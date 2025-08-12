package nirmalya.aatithya.restmodule.his.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class HISPharmacyRestDao {

	Logger logger = LoggerFactory.getLogger(HISPharmacyRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemList(String org, String orgDiv) {
		logger.info("Method :getItemList starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();

		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_pharmacy_routines")
					.setParameter("actionType", "getItemList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object gstRate = "0.00";

				if (m[5] != null) {
					gstRate = m[5].toString();
				}

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2], m[3], m[4], gstRate);
				itemList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getItemList ends");
		return itemList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPayModeList(String org, String orgDiv) {
		logger.info("Method :getPayModeList starts");

		List<DropDownModel> payModeList = new ArrayList<DropDownModel>();

		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_pharmacy_routines")
					.setParameter("actionType", "getPayModeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				payModeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPayModeList ends");
		return payModeList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPatientListByAutoSearch(String id, String orgName, String orgDiv) {
		logger.info("Method : getPatientListByAutoSearch starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<String> emptyArray = new ArrayList<String>();

		if (id != null && id != "" && !id.equals(null) && !id.equals("null")) {
			id = "%" + id + "%";
		}

		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_pharmacy_routines")
					.setParameter("actionType", "getPatientListAutoSearch").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {

				List<DropDownModel> dataList = new ArrayList<DropDownModel>();
				for (Object[] m : x) {
					DropDownModel dd = new DropDownModel(m[0], m[1]);
					dataList.add(dd);
				}

				if (dataList.size() > 0) {
					resp.setBody(dataList);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} else {
					resp.setBody(emptyArray);
					resp.setCode("failed");
					resp.setMessage("Data not found");
				}

			} else {
				resp.setBody(emptyArray);
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setBody(emptyArray);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}

		logger.info("Method : getPatientListByAutoSearch ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPharmacy(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewPharmacy Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";

			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_pharmacy_routines")
					.setParameter("actionType", "viewPharmacy").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPharmacy Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getBatchDetails(String orgName, String orgDivision, String userId, String id) {
		logger.info("Method : viewPharmacy Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "', @p_sku='" + id + "';";

			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_pharmacy_routines")
					.setParameter("actionType", "getBatchDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPharmacy Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dispatchMedicine(String orgName, String orgDivision, String userId, String data) {
		logger.info("Method : dispatchMedicine Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_createdBy='" + userId
					+ "', @p_data='" + data + "';";

			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_pharmacy_routines")
					.setParameter("actionType", "dispatchMedicine").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Medicine Added Successfully");

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage("Something went wrong");
			e.printStackTrace();
		}
		logger.info("Method : dispatchMedicine Dao ends");
		return resp;
	}

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewmedicine(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewmedicine Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "', @p_userId='" + userId + "';";
			System.out.println("value for employee view=================> " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_pharmacy_dasboard")
					.setParameter("actionType", "viewmedicine").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : viewmedicine Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPayment(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewPayment Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "', @p_userId='" + userId + "';";
			System.out.println("value for payment view=================> " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_pharmacy_dasboard")
					.setParameter("actionType", "viewPayment").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : viewPayment Dao ends" + resp);
		return resp;

	}
}
