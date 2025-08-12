package nirmalya.aatithya.restmodule.asset.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AssetMechanicalReportDao {

	Logger logger = LoggerFactory.getLogger(AssetMechanicalReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// Dropdown For Asset Name
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAssetList(String userId, String orgName, String orgDivision, String policyId) {
		logger.info("Method : getAssetList starts");
		List<DropDownModel> userList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_userId='" + userId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision
					+ "'" + ",@p_policyId='" + policyId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "getAssetList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				userList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAssetList ends");
		return userList;
	}

	// view Metal Detector
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewMetalDetector(String orgName, String orgDivision, String userId, String fromDate,
			String toDate, String assetName, String policyId) {
		logger.info("Method : viewMetalDetector Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "'" + ",@p_assetId='" + assetName + "',@p_policyId='"
					+ policyId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "viewMetalDetector").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewMetalDetector Dao ends");
		return resp;

	}

	// view Double Track
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewDoubleTrack(String orgName, String orgDivision, String userId, String fromDate,
			String toDate, String assetName, String policyId) {
		logger.info("Method : viewDoubleTrack Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "'" + ",@p_assetId='" + assetName + "',@p_policyId='"
					+ policyId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "viewMetalDetector").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewDoubleTrack Dao ends");
		return resp;

	}

	// view Gear oil
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewGearOil(String orgName, String orgDivision, String userId, String fromDate,
			String toDate, String policyId) {
		logger.info("Method : viewGearOil Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "'" + ",@p_policyId='" + policyId + "';";
			logger.info("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "viewGearOil").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewGearOil Dao ends"+resp);
		return resp;

	}

	// view Checklist
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewgetChecklist(String orgName, String orgDivision, String userId, String fromDate,
			String toDate, String assetName, String policyId) {
		logger.info("Method : viewgetChecklist Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "'" + ",@p_assetId='" + assetName + "',@p_policyId='"
					+ policyId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "viewMetalDetector").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewgetChecklist Dao ends");
		return resp;

	}

	// view Bag Filter Check List
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewBagFiletrCheckList(String orgName, String orgDivision, String userId,
			String fromDate, String toDate, String assetName, String policyId) {
		logger.info("Method : viewBagFiletrCheckList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "'," + "@p_assetId='" + assetName + "',@p_policyId='"
					+ policyId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "bagFilterCheckList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewBagFiletrCheckList Dao ends");
		return resp;

	}

	// BIB MACHINE/////////////////////////////////

	// view Bib Machine
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewBibMachine(String orgName, String orgDivision, String userId, String fromDate,
			String toDate, String assetName, String policyId) {
		logger.info("Method : viewBibMachine Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "'" + ",@p_assetId='" + assetName + "',@p_policyId='"
					+ policyId + "';";

			logger.info("value"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "viewBibMachine").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewBibMachine Dao ends"+resp);
		return resp;

	}

	// SHREDDING MACHINE ///////////////////////////////

	// view Shredding machine

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewgetshredding(String orgName, String orgDivision, String userId, String fromDate,
			String toDate, String assetName, String policyId) {
		logger.info("Method : viewgetshredding Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "'" + ",@p_assetId='" + assetName + "',@p_policyId='"
					+ policyId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "viewgetshredding").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewgetshredding Dao ends");
		return resp;

	}

	/////// STARPAC PERFORATION////////////////

	// view strapac Blade
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewStrpacBlade(String orgName, String orgDivision, String mon, String policyId) {
		logger.info("Method : viewStrpacBlade Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_mon='" + mon
					+ "',@p_policyId='" + policyId + "';;";

			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "viewStrpacBlade").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewStrpacBlade Dao ends");
		return resp;

	}

	// view Multi Track
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewMultiTrack(String orgName, String orgDivision, String userId, String fromDate,
			String toDate, String assetName, String policyId) {
		logger.info("Method : viewMultiTrack Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "',@p_assetId='" + assetName + "',@p_policyId='" + policyId
					+ "';";
			
			logger.info("value"+value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "viewMlutiTrack").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewMultiTrack Dao ends" + resp);
		return resp;

	}

	// view Nut Boult
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewNutBults(String orgName, String orgDivision, String userId, String fromDate,
			String toDate, String assetName, String policyId) {
		logger.info("Method : viewNutBults Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "',@p_assetId='" + assetName + "',@p_policyId='" + policyId
					+ "';";
			logger.info("value"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "viewNutBults").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewNutBults Dao ends" + resp);
		return resp;

	}

	// view paintworkCheckList
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> paintworkCheckList(String orgName, String orgDivision, String userId, String fromDate,
			String toDate, String assetName, String policyId) {
		logger.info("Method : paintworkCheckList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "',@p_assetId='" + assetName + "',@p_policyId='" + policyId
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "paintworkCheckList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : paintworkCheckList Dao ends" + resp);
		return resp;

	}

	// view paintworkCheckList
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> epoxyWorkCheckListView(String orgName, String orgDivision, String userId,
			String fromDate, String toDate, String policyId) {
		logger.info("Method : epoxyWorkCheckListView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "',@p_policyId='" + policyId + "';";
			System.out.println("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "epoxyWorkCheckList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : epoxyWorkCheckListView Dao ends" + resp);
		return resp;

	}

	// view strapac Blade
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewStrpacCutterRecord(String orgName, String orgDivision, String mon,
			String policyId) {
		logger.info("Method : viewStrpacCutterRecord Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_mon='" + mon
					+ "',@p_policyId='" + policyId + "';;";
			System.out.println("value" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "viewStrpacCutter").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewStrpacCutterRecord Dao ends" + resp);
		return resp;

	}

	//View Wet Cleaning Check List
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewWetCleaningCheckList(String orgName, String orgDivision, String userId,String date) {
		logger.info("Method : viewWetCleaningCheckList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_date='"+DateFormatter.getStringDate(date)+"';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "viewWetClean").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewWetCleaningCheckList Dao ends");
		return resp;

	}
}
