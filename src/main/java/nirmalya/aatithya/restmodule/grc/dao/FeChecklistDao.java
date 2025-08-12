package nirmalya.aatithya.restmodule.grc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.StringUtil;

@Repository
public class FeChecklistDao {
	Logger logger = LoggerFactory.getLogger(FeChecklistDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllMasterData(String orgName, String orgDiv) {
		logger.info("Method : getAllMasterData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			System.out.println("getAllMasterData========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("fe_checklist_routines")
					.setParameter("actionType", "getMasterData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllMasterData Dao ends"+resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addChecklistData(Map<String, Object> checklistJsonData) {
	    logger.info("Method : addChecklistData starts");

	    JsonResponse<Object> resp = new JsonResponse<>();


	    if (checklistJsonData == null || checklistJsonData.isEmpty()) {
	        resp.setCode("failed");
	        resp.setMessage("Checklist data cannot be empty.");
	        return resp;
	    }

	    String orgName = (String) checklistJsonData.get("orgName");
	    String orgDiv = (String) checklistJsonData.get("orgDiv");
	    String refillingDate = (String) checklistJsonData.get("refillingDate");
	    String nextDueDate = (String) checklistJsonData.get("nextDueDate");
	    String inspectionDate = (String) checklistJsonData.get("inspectionDate");
	    String checklistId = (String) checklistJsonData.get("checklistId");
	    String createdById = (String) checklistJsonData.get("createdById");

	    List<Map<String, Object>> rows = (List<Map<String, Object>>) checklistJsonData.get("rows");
	    
	    String rowsJson = "";
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	        rowsJson = objectMapper.writeValueAsString(rows);
	    } catch (Exception e) {
	        resp.setCode("failed");
	        resp.setMessage("Failed to process checklist rows.");
	        return resp;
	    }

 
	    String value = "SET @p_orgName='" + orgName + "', " +
	                   "@p_orgDiv='" + orgDiv + "', " +
	                   "@p_refillingDate='" + refillingDate + "', " +
	                   "@p_nextDueDate='" + nextDueDate + "', " +
	                   "@p_inspectionDate='" + inspectionDate + "', " +
	                   "@p_checklistId='" + checklistId + "', " +
	                   "@p_createdById='" + createdById + "', " +
	                   "@p_rows='" + rowsJson + "';";


	    if (StringUtil.isNull(checklistId)) {
	    	
	        em.createNamedStoredProcedureQuery("fe_checklist_routines")
	                .setParameter("actionType", "addChecklist")
	                .setParameter("actionValue", value)
	                .execute();
	        resp.setCode("success");
	        resp.setMessage("Checklist added successfully.");
	    } else {
	        
	            logger.info("Modifying an existing checklist...");
	             em.createNamedStoredProcedureQuery("fe_checklist_routines")
	                    .setParameter("actionType", "modifyChecklist")
	                    .setParameter("actionValue", value)
	                    .execute();
	            resp.setCode("success");
	            resp.setMessage("Checklist updated successfully.");
	        } 
	    

	    logger.info("Method : addChecklistData ends");
	    return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewChecklistData(String orgName, String orgDiv) {
		logger.info("Method : viewChecklistData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			System.out.println("viewChecklistData========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("fe_checklist_routines")
					.setParameter("actionType", "viewChecklistData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewChecklistData Dao ends"+resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editChecklistData(String orgName, String orgDiv,String checklistId) {
		logger.info("Method : editChecklistData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_checklistId='"+checklistId+"';";
			System.out.println("editChecklistData========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("fe_checklist_routines")
					.setParameter("actionType", "editChecklistData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : editChecklistData Dao ends"+resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> generatePdfForChecklist(String orgName, String orgDiv,String checklistId) {
		logger.info("Method : generatePdfForChecklist Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_checklistId='"+checklistId+"';";
			System.out.println("generatePdfForChecklist========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("fe_checklist_routines")
					.setParameter("actionType", "pdfForChecklist").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : generatePdfForChecklist Dao ends"+resp);
		return resp;

	}
	
	 @SuppressWarnings("unchecked")
	    public JsonResponse<Object> deleteChecklist(String checklistId,String orgName, String orgDiv) {
	        logger.info("Method : deleteChecklist Dao starts");

	        JsonResponse<Object> resp = new JsonResponse<Object>();

	        try {
	             
	            String value = "SET @p_checklistId='" + checklistId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv + "';";
	            System.out.println("deleteChecklist========>" + value);

	            Object x = em.createNamedStoredProcedureQuery("fe_checklist_routines")
	                    .setParameter("actionType", "deleteChecklist").setParameter("actionValue", value)
	                    .getSingleResult();
	            System.out.println("value of x ------->>>>> "+x.toString());
	            if(Integer.parseInt(x.toString()) > 0) {
					resp.setCode("success");
		  			resp.setMessage("Selected Checklist Deleted successfully");
	  			}

	        } catch (Exception e) {
	            resp.setCode("failed");
	            resp.setMessage(e.getMessage());
	            e.printStackTrace();
	        }

	        logger.info("Method : deleteChecklist Dao ends" + resp);
	        return resp;
	    }
	 
	 @SuppressWarnings("unchecked")
	    public JsonResponse<Object> approveChecklist(String checklistId,String orgName, String orgDiv) {
	        logger.info("Method : approveChecklist Dao starts");

	        JsonResponse<Object> resp = new JsonResponse<Object>();

	        try {
	             
	            String value = "SET @p_checklistId='" + checklistId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv + "';";
	            System.out.println("approveChecklist========>" + value);

	            Object x = em.createNamedStoredProcedureQuery("fe_checklist_routines")
	                    .setParameter("actionType", "approveChecklist").setParameter("actionValue", value)
	                    .getSingleResult();
	            System.out.println("value of x ------->>>>> "+x.toString());
	            if(Integer.parseInt(x.toString()) > 0) {
					resp.setCode("success");
		  			resp.setMessage("Selected Checklist Approved successfully");
	  			}

	        } catch (Exception e) {
	            resp.setCode("failed");
	            resp.setMessage(e.getMessage());
	            e.printStackTrace();
	        }

	        logger.info("Method : approveChecklist Dao ends" + resp);
	        return resp;
	    }
  
}
