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
public class AssetUtilityReportDao {

	Logger logger = LoggerFactory.getLogger(AssetUtilityReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// view Hvac Monitoring
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewHvacMonitoring(String orgName, String orgDivision, String userId, String fromDate,
			String toDate, String policyId) {
		logger.info("Method : viewHvacMonitoring Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "',@p_policyId='" + policyId
					+ "';";
			System.out.println("aaaaaaaaaaaaaaaaa"+value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("mechanical_report_routines")
					.setParameter("actionType", "paintworkCheckList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewHvacMonitoring Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAirCompreessor(String month, String assetId, String orgName, String orgDiv) {
		logger.info("Method : getAirCompreessor Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_month='" + month + "',@p_assetId='" + assetId + "',@p_orgName='" + orgName
					+ "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("getAirCompreessor========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("utility_report_routines")
					.setParameter("actionType", "getAirCompreessor").setParameter("actionValue", value).getResultList();
			System.out.println(x.toString());
			resp.setBody(x.toString());
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAirCompreessor Dao ends" + resp);
		return resp;

	}

	// getAnnextureFilterData
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAnnextureFilterData(String yearName, String fromDate,String toDate, String orgName,
			String orgDiv) {
		logger.info("Method : getAnnextureFilterData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_yearName='" + yearName
					+ "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
			System.out.println("DATA----------------"+value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("utility_report_routines")
					.setParameter("actionType", "annextureFilter").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAnnextureFilterData Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getfilterCleaningView(String month, String assetId, String orgName, String orgDiv,
			String policyId) {
		logger.info("Method : getfilterCleaningView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_month='" + month + "',@p_assetId='" + assetId + "',@p_orgName='" + orgName
					+ "',@p_orgDiv='" + orgDiv + "',@p_policyId='" + policyId + "';";
			System.out.println("getAirCompreessor========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("utility_report_routines")
					.setParameter("actionType", "getfilterCleaningView").setParameter("actionValue", value)
					.getResultList();
			System.out.println(x.toString());
			resp.setBody(x.toString());
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getfilterCleaningView Dao ends" + resp);
		return resp;

	}

	// view Ahu Dut Cleaning
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAhuDutCleaning(String orgName, String orgDivision, String userId, String month,
			String currentYear) {
		logger.info("Method : viewAhuDutCleaning Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_month='" + month + "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("utility_report_routines")
					.setParameter("actionType", "ahuDutCleaning").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAhuDutCleaning Dao ends");
		return resp;

	}

	// view Chiller1
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewChiller1(String orgName, String orgDivision, String userId, String date) {
		logger.info("Method : viewChiller1 Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_date='" + DateFormatter.getStringDate(date) + "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("utility_report_routines")
					.setParameter("actionType", "viewChiller1").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewChiller1 Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAirCompDryTpyeList(String userId, String orgName, String orgDivision,
			String policyId) {
		logger.info("Method : getAirCompDryTpyeList starts");
		List<DropDownModel> userList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_userId='" + userId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision
					+ "'" + ",@p_policyId='" + policyId + "';";
			System.out.println("getAssetList========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("utility_report_routines")
					.setParameter("actionType", "getAirCompDryTpyeList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				userList.add(dropDownModel);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAirCompDryTpyeList ends");
		System.out.println("Air Comp Type List =====>" + userList);
		return userList;
	}

	// vewAirCompDryData
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> vewAirCompDryData(String orgName, String orgDivision, String userId, String date,
			String type, String policyId) {
		logger.info("Method : vewAirCompDryData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_date='" + date + "',@p_type='" + type + "',@p_policyId='" + policyId + "';";
			System.out.println("value is coming for airCompressor=====================> " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("utility_report_routines")
					.setParameter("actionType", "getAirCompressorData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong 1");
		}
		logger.info("Method : vewAirCompDryData Dao ends" + resp);
		return resp;

	}
	
	//viewRhTempData
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRhTempData(String orgName, String orgDivision, String userId, String date,
			String type, String policyId) {
		logger.info("Method : viewRhTempData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_date='" + date + "',@p_type='" + type + "',@p_policyId='" + policyId + "';";
			System.out.println("value is coming for viewRhTempData=====================> " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("utility_report_routines")
					.setParameter("actionType", "viewRhTempData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong 1");
		}
		logger.info("Method : viewRhTempData Dao ends" + resp);
		return resp;

	}

}
