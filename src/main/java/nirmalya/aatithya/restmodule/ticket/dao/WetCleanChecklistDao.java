package nirmalya.aatithya.restmodule.ticket.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.StringUtil;

@Repository
public class WetCleanChecklistDao {
Logger logger = LoggerFactory.getLogger(WetCleanChecklistDao.class);
	
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getWetCleanChecklistMasterData(String orgName, String orgDiv,String selectedPhase) {
		logger.info("Method : getWetCleanChecklistMasterData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_selectedPhase='"+selectedPhase+"';";
			System.out.println("getWetCleanChecklistMasterData========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("wet_clean_checklist_routine")
					.setParameter("actionType", "getWetCleanMaster").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getWetCleanChecklistMasterData Dao ends"+resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addWetCleanChecklistData(Map<String, Object> checklistJsonData) {
	    logger.info("Method : addWetChecklist starts");

	    JsonResponse<Object> resp = new JsonResponse<>();


	    if (checklistJsonData == null || checklistJsonData.isEmpty()) {
	        resp.setCode("failed");
	        resp.setMessage("Checklist data cannot be empty.");
	        return resp;
	    }

	    String orgName = (String) checklistJsonData.get("orgName");
	    String orgDiv = (String) checklistJsonData.get("orgDiv");
	    String issueDate = (String) checklistJsonData.get("issueDate");
	    String selectedPhase = (String) checklistJsonData.get("selectedPhase");
	    String checklistId = (String) checklistJsonData.get("checklistId");
	    String createdById = (String) checklistJsonData.get("createdById");

	    List<Map<String, Object>> allRowData = (List<Map<String, Object>>) checklistJsonData.get("allRowData");
	    List<Map<String, Object>> allRowData2 = (List<Map<String, Object>>) checklistJsonData.get("allRowData2");
	    List<Map<String, Object>> allRowData3 = (List<Map<String, Object>>) checklistJsonData.get("allRowData3");
	    
	    String rowsJson1 = "";
	    String rowsJson2 = "";
	    String rowsJson3 = "";
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	        rowsJson1 = objectMapper.writeValueAsString(allRowData);
	        rowsJson2 = objectMapper.writeValueAsString(allRowData2);
	        rowsJson3 = objectMapper.writeValueAsString(allRowData3);
	    } catch (Exception e) {
	        resp.setCode("failed");
	        resp.setMessage("Failed to process checklist rows.");
	        return resp;
	    }

	    String value = "SET @p_orgName='" + orgName + "', " +
	               "@p_orgDiv='" + orgDiv + "', " +
	               "@p_issueDate='" + issueDate + "', " +
	               "@p_selectedPhase='" + selectedPhase + "', " +
	               "@p_allRow1='" + rowsJson1 + "', " +
	               "@p_checklistId='" + checklistId + "', " +
	               "@p_createdById='" + createdById + "', " +
	               "@p_allRow2='" + rowsJson2 + "', " +
	               "@p_allRow3='" + rowsJson3 + "';";
	    System.out.println("Value=========>"+value);

	    if (StringUtil.isNull(checklistId)) {
	    	
	        em.createNamedStoredProcedureQuery("wet_clean_checklist_routine")
	                .setParameter("actionType", "addChecklist")
	                .setParameter("actionValue", value)
	                .execute();
	        resp.setCode("success");
	        resp.setMessage("Wet Clean Checklist added successfully.");
	    } else {
	            logger.info("Modifying an existing checklist...");
	             em.createNamedStoredProcedureQuery("wet_clean_checklist_routine")
	                    .setParameter("actionType", "modifyChecklist")
	                    .setParameter("actionValue", value)
	                    .execute();
	            resp.setCode("success");
	            resp.setMessage("Wet Clean Checklist updated successfully.");
	        } 
	    
	    logger.info("Method : addWetChecklist ends");
	    return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewWetCleanChecklist(String orgName, String orgDiv) {
		logger.info("Method : viewWetCleanChecklist Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			System.out.println("viewWetCleanChecklist========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("wet_clean_checklist_routine")
					.setParameter("actionType", "viewChecklistData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewWetCleanChecklist Dao ends"+resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> wetCleanChecklistEdit(String orgName, String orgDiv,String phaseStatus,String checklistId) {
		logger.info("Method : wetCleanChecklistEdit Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_phaseStatus='"+phaseStatus+"',@p_checklistId='"+checklistId+"';";
			System.out.println("getWetCleanChecklistMasterData========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("wet_clean_checklist_routine")
					.setParameter("actionType", "editWetCleanChecklistData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : wetCleanChecklistEdit Dao ends"+resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
    public JsonResponse<Object> deleteWetCleanChecklist(String checklistId,String orgName, String orgDiv) {
        logger.info("Method : deleteWetCleanChecklist Dao starts");

        JsonResponse<Object> resp = new JsonResponse<Object>();

        try {
             
            String value = "SET @p_checklistId='" + checklistId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv + "';";
            System.out.println("deleteWetCleanChecklist========>" + value);

            Object x = em.createNamedStoredProcedureQuery("wet_clean_checklist_routine")
                    .setParameter("actionType", "deleteWetCleanChecklist").setParameter("actionValue", value)
                    .getSingleResult();
            System.out.println("value of x ------->>>>> "+x.toString());
            if(Integer.parseInt(x.toString()) > 0) {
				resp.setCode("success");
	  			resp.setMessage("Wet Clean Checklist Deleted successfully");
  			}

        } catch (Exception e) {
            resp.setCode("failed");
            resp.setMessage(e.getMessage());
            e.printStackTrace();
        }

        logger.info("Method : deleteWetCleanChecklist Dao ends" + resp);
        return resp;
    }
	
	@SuppressWarnings("unchecked")
    public JsonResponse<Object> approveWetCleanChecklist(String checklistId,String orgName, String orgDiv) {
        logger.info("Method : approveWetCleanChecklist Dao starts");

        JsonResponse<Object> resp = new JsonResponse<Object>();

        try {
             
            String value = "SET @p_checklistId='" + checklistId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv + "';";
            System.out.println("approveWetCleanChecklist========>" + value);

            Object x = em.createNamedStoredProcedureQuery("wet_clean_checklist_routine")
                    .setParameter("actionType", "approveWetCleanChecklist").setParameter("actionValue", value)
                    .getSingleResult();
            System.out.println("value of x ------->>>>> "+x.toString());
            if(Integer.parseInt(x.toString()) > 0) {
				resp.setCode("success");
	  			resp.setMessage("Wet Clean Checklist Approved successfully");
  			}

        } catch (Exception e) {
            resp.setCode("failed");
            resp.setMessage(e.getMessage());
            e.printStackTrace();
        }

        logger.info("Method : approveWetCleanChecklist Dao ends" + resp);
        return resp;
    }
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEmployeeListforJob(String org, String orgDiv, String userId) {
		logger.info("Method : getEmployeeListforJob Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("wet_clean_checklist_routine")
					.setParameter("actionType", "get-EmpListJob").setParameter("actionValue", value).getResultList();
			System.out.println(x);
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeListforJob Dao ends"+resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> generatePdfForWetChecklisr(String orgName, String orgDiv,String checklistId,String phaseStatus) {
		logger.info("Method : generatePdfForWetChecklisr Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_checklistId='"+checklistId+"',@p_phaseStatus='"+phaseStatus+"';";
			System.out.println("generatePdfForWetChecklisr========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("wet_clean_checklist_routine")
					.setParameter("actionType", "pdfForChecklist").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : generatePdfForWetChecklisr Dao ends"+resp);
		return resp;

	}
}
