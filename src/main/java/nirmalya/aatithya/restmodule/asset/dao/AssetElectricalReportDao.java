package nirmalya.aatithya.restmodule.asset.dao;

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
public class AssetElectricalReportDao {

	Logger logger = LoggerFactory.getLogger(AssetElectricalReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEmergencyLightData(String selectedMonth,String orgName, String orgDiv) {
		logger.info("Method : getEmergencyLightData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_month='" + selectedMonth +"';";
			System.out.println("getEmergencyLightData========>"+value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("electricalReportRoutines")
					.setParameter("actionType", "emergencyLightData").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getEmergencyLightData Dao ends");
		return resp;
	}

	// getEarthingChecklistData
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEarthingChecklistData(String selectedMonth,String orgName, String orgDiv) {
		logger.info("Method : getEarthingChecklistData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_month='" + selectedMonth + "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("electricalReportRoutines")
					.setParameter("actionType", "earthingChecklistData").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getEarthingChecklistData Dao ends" + resp);
		return resp;
	}
	
	// getControlAreaData
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getControlAreaData(String fromDate,String toDate, String orgName, String orgDiv) {
			logger.info("Method : getControlAreaData Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
				System.out.println(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("electricalReportRoutines")
						.setParameter("actionType", "controlAreaData").setParameter("actionValue", value)
						.getResultList();

				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getControlAreaData Dao ends" + resp);
			return resp;
		}
		
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getPolicyList(String userId, String org, String orgDiv, String policyId) {
			logger.info("Method : getPolicyList starts");
			List<DropDownModel> userList = new ArrayList<DropDownModel>();
			try {
				String value = "SET @p_userId='" + userId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv
						+ "',@p_pilicyId='" + policyId + "';";
				logger.info("Value is coming For dropDown============> " + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("electricalReportRoutines")
						.setParameter("actionType", "getPolicyList").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					userList.add(dropDownModel);
				}

				System.out.println(userList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getPolicyList ends");
			System.out.println("Policy List =====>" + userList);
			return userList;
		}

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> transforerReport(String orgName, String orgDivision, String mon, String assetId) {
			logger.info("Method : transforerReport Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_month='" + mon
						+ "', @p_assetId='" + assetId + "';";
				logger.info(": ===========transforerReport=========>" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("electricalReportRoutines")
						.setParameter("actionType", "transforermerReport").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : transforerReport Dao ends" + resp);
			return resp;
		}

	//diselGenerator
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> diselGenerator(String orgName, String orgDivision, String mon, String assetId) {
			logger.info("Method : diselGenerator Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_month='" + mon
						+ "', @p_assetId='" + assetId + "';";
				logger.info(": ===========diselGenerator=========>" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("electricalReportRoutines")
						.setParameter("actionType", "diselGenerator").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : diselGenerator Dao ends" + resp);
			return resp;
		}

		// viewApfcReports
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewApfcReports(String orgName, String orgDivision, String mon, String assetId) {
			logger.info("Method : diselGenerator Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_month='" + mon + "', @p_assetId='" + assetId + "';";
				logger.info(": ===========viewApfcReports=========>" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("electricalReportRoutines")
						.setParameter("actionType", "apfcReports").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : viewApfcReports Dao ends" + resp);
			return resp;
		}
		
		@SuppressWarnings("unchecked")
	    public List<DropDownModel> getAssetList(String userId,String orgName,String orgDivision,String policyId) {
	        logger.info("Method : getAssetList starts");
	        List<DropDownModel> userList = new ArrayList<DropDownModel>();
	        try {
	        	String value = "SET @p_userId='" + userId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "'"
						+ ",@p_policyId='" + policyId + "';";
	        	System.out.println("getAssetList========>"+value);
	            List<Object[]> x = em.createNamedStoredProcedureQuery("electricalReportRoutines")
	                    .setParameter("actionType", "getAssetList").setParameter("actionValue", value).getResultList();
	            for (Object[] m : x) {
	                DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
	                userList.add(dropDownModel);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        logger.info("Method : getAssetList ends");
	        System.out.println("Asset List =====>"+userList);     
	        return userList;
	    }
	   
	   @SuppressWarnings("unchecked")
		public JsonResponse<Object> getPolicyFilterData(String month, String orgName, String orgDiv) {
			logger.info("Method : getPolicyFilterData Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_month='" + month +"',@p_orgName='"+orgName+"',@p_orgDiv='"+orgDiv+"';";
	            System.out.println("getPolicyFilterData========>"+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("electricalReportRoutines")
						.setParameter("actionType", "getPolicyFilterData").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.toString());
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getPolicyFilterData Dao ends"+resp);
			return resp;

		}
	   
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getPortalToolReport(String month,String orgName,
				String orgDiv) {
			logger.info("Method : getPortalToolReport Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_month='" + month + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("getPortalToolReport========>" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("electricalReportRoutines")
						.setParameter("actionType", "getPortalToolReport").setParameter("actionValue", value)
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

			logger.info("Method : getPortalToolReport Dao ends" + resp);
			return resp;

		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getPanelCheckRecord(String selectedMonth, String orgName,
				String orgDiv) {
			logger.info("Method : getPanelCheckRecord Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_month='" + selectedMonth + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("getPanelCheckRecord========>" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("electricalReportRoutines")
						.setParameter("actionType", "getPanelCheckRecord").setParameter("actionValue", value)
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

			logger.info("Method : getPanelCheckRecord Dao ends" + resp);
			return resp;

		}

}
