package nirmalya.aatithya.restmodule.purchase.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateVendorNewParameter;
import nirmalya.aatithya.restmodule.purchase.model.RestVendorNewModel;

/*
 * @author NirmalyaLabs
 *
 */
@Repository
public class RestPurchaseDashboardDao {

	Logger logger = LoggerFactory.getLogger(RestPurchaseDashboardDao.class);

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	
	// getAllHeadCount

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getAllHeadCount(String orgName, String orgDivision, String fromDate, String toDate,
				String loc) {
			logger.info("Method : getAllHeadCount Dao starts");

			String div = orgDivision.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
						.setParameter("actionType", "getAllHeadCount").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getAllHeadCount Dao ends" + resp);
			return resp;

		}
		
		
		//getAllPOCityList
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllPOCityList(String id) {

			logger.info("Method : getAllPOCityList starts");
			List<DropDownModel> stateList = new ArrayList<DropDownModel>();

			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			String value = "SET @p_division='" + id + "';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
						.setParameter("actionType", "getAllCityList").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					stateList.add(dropDownModel);
				}

				resp.setBody(stateList);

			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : getAllPOCityList ends");
			return response;
		}
		
		
		// getAllRecordOperational

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getAllRecordOperational(String orgName, String orgDivision, String fromDate,
				String toDate, String id, String loc) {
			logger.info("Method : getAllRecordOperational Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
						+ "',@p_toDate='" + toDate + "',@p_id='" + id + "',@p_loc='" + loc + "';";
				logger.info("getAllOperational------------" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
						.setParameter("actionType", "getAllOperational").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getAllRecordOperational Dao ends" + resp);
			return resp;

		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> SupllierClasification(String orgName, String orgDivision, String fromDate,
				String toDate, String loc) {
			logger.info("Method : SupllierClasification Dao starts");

			String div = orgDivision.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
				logger.info("SupllierClasification3333" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
						.setParameter("actionType", "SupllierClasification").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : SupllierClasification Dao ends" + resp);
			return resp;

		}
		
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> procuremrntDashboard(String orgName, String orgDivision) {
			logger.info("Method : procuremrntDashboard Dao starts");

			String org = orgName.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
						.setParameter("actionType", "procSupplier").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : procuremrntDashboard Dao ends" + resp);
			return resp;

		}
	
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> contractedAllCount(String orgName, String orgDivision) {
			logger.info("Method : contractedAllCount Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
						.setParameter("actionType", "procContracted").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("Method : contractedAllCount Dao ends" + resp);
			return resp;

		}
		
		
		// serviceAllCount

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> serviceAllCount(String orgName, String orgDivision) {
			logger.info("Method : serviceAllCount Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
						.setParameter("actionType", "procService").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("Method : serviceAllCount Dao ends" + resp);
			return resp;

		}
		
		// fiveYearTrend
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> fiveYearTrend(String orgName, String orgDivision, String fromDate, String toDate,
				String loc) {
			logger.info("Method : fiveYearTrend Dao starts");

			String div = orgDivision.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";

				logger.info("fiveYearTrend1212" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
						.setParameter("actionType", "totalAmmount").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : fiveYearTrend Dao ends" + resp);
			return resp;

		}

		// fiveYearTrend1
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> fiveYearTrend1(String orgName, String orgDivision, String fromDate, String toDate,
				String loc) {
			logger.info("Method : fiveYearTrend1 Dao starts");

			String div = orgDivision.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";

				logger.info("fiveYearTrend1212" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
						.setParameter("actionType", "savingAmount").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : fiveYearTrend1 Dao ends" + resp);
			return resp;

		}

		// fiveYearTrend2
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> fiveYearTrend2(String orgName, String orgDivision, String fromDate, String toDate,
				String loc) {
			logger.info("Method : fiveYearTrend2 Dao starts");

			String div = orgDivision.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";

				logger.info("fiveYearTrend1212" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
						.setParameter("actionType", "taxableAmnt").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : fiveYearTrend2 Dao ends" + resp);
			return resp;
		}
		
		
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getOrganization(String orgName) {
			logger.info("Method : getOrganization starts");

			List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

			try {
				String value = "SET @p_orgName='" + orgName + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
						.setParameter("actionType", "getOrganization").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					getCollectionList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getOrganization ends");
			return getCollectionList;
		}

		//

		@SuppressWarnings("unchecked")
		public List<DropDownModel> getDivision(String orgName) {
			logger.info("Method : getDivision starts");

			List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

			try {
				String value = "SET @p_orgName='" + orgName + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseDashboard")
						.setParameter("actionType", "orgDivision").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					getCollectionList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : orgDivision ends");
			return getCollectionList;
		}

	
}
