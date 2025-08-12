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
public class PerforationBladeRecordDao {
Logger logger = LoggerFactory.getLogger(PerforationBladeRecordDao.class);
	
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addPerforationBladeRecord(Map<String, Object> perforationJsonData) {
	    logger.info("Method : addPerforationBladeRecord starts");

	    JsonResponse<Object> resp = new JsonResponse<>();


	    if (perforationJsonData == null || perforationJsonData.isEmpty()) {
	        resp.setCode("failed");
	        resp.setMessage("Perforation data cannot be empty.");
	        return resp;
	    }

	    String orgName = (String) perforationJsonData.get("orgName");
	    String orgDiv = (String) perforationJsonData.get("orgDiv");
	    String recordYear = (String) perforationJsonData.get("recordYear");
	    String recordMonth = (String) perforationJsonData.get("recordMonth");
	    String recordId = (String) perforationJsonData.get("recordId");
	    String createdById = (String) perforationJsonData.get("createdById");

	    List<Map<String, Object>> rows = (List<Map<String, Object>>) perforationJsonData.get("rows");
	    
	    String rowsJson = "";
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	        rowsJson = objectMapper.writeValueAsString(rows);
	    } catch (Exception e) {
	        resp.setCode("failed");
	        resp.setMessage("Failed to process perforation rows.");
	        return resp;
	    }

 
	    String value = "SET @p_orgName='" + orgName + "', " +
	                   "@p_orgDiv='" + orgDiv + "', " +
	                   "@p_recordYear='" + recordYear + "', " +
	                   "@p_recordMonth='" + recordMonth + "', " +
	                   "@p_recordId='" + recordId + "', " +
	                   "@p_createdById='" + createdById + "', " +
	                   "@p_rows='" + rowsJson + "';";

         System.out.println("Values For Perforation Reocrd=======>>>>"+value);
	    if (StringUtil.isNull(recordId)) {
	    	
	        em.createNamedStoredProcedureQuery("perforation_record_routines")
	                .setParameter("actionType", "addRecord")
	                .setParameter("actionValue", value)
	                .execute();
	        resp.setCode("success");
	        resp.setMessage("Perforation Record added successfully.");
	    } else {
	        
	            logger.info("Modifying an existing perforation record...");
	             em.createNamedStoredProcedureQuery("perforation_record_routines")
	                    .setParameter("actionType", "modifyRecord")
	                    .setParameter("actionValue", value)
	                    .execute();
	            resp.setCode("success");
	            resp.setMessage("Perforation Record updated successfully.");
	        } 
	    

	    logger.info("Method : addPerforationBladeRecord ends");
	    return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPerforationRecord(String orgName, String orgDiv) {
		logger.info("Method : viewPerforationRecord Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			System.out.println("viewPerforationRecord========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("perforation_record_routines")
					.setParameter("actionType", "viewPerforationData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewPerforationRecord Dao ends"+resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editPerforationRecordData(String orgName, String orgDiv,String recordId) {
		logger.info("Method : editPerforationRecordData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_recordId='"+recordId+"';";
			System.out.println("editPerforationData========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("perforation_record_routines")
					.setParameter("actionType", "editPerforationData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : editPerforationRecordData Dao ends"+resp);
		return resp;

	}
	
	 @SuppressWarnings("unchecked")
	    public JsonResponse<Object> deletPerforationRecord(String recordId,String orgName, String orgDiv) {
	        logger.info("Method : deletPerforationRecord Dao starts");

	        JsonResponse<Object> resp = new JsonResponse<Object>();

	        try {
	             
	            String value = "SET @p_recordId='" + recordId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv + "';";
	            System.out.println("deleteChecklist========>" + value);

	            Object x = em.createNamedStoredProcedureQuery("perforation_record_routines")
	                    .setParameter("actionType", "deletePerforationRecord").setParameter("actionValue", value)
	                    .getSingleResult();
	            System.out.println("value of x ------->>>>> "+x.toString());
	            if(Integer.parseInt(x.toString()) > 0) {
					resp.setCode("success");
		  			resp.setMessage("Perforation Record Deleted successfully");
	  			}

	        } catch (Exception e) {
	            resp.setCode("failed");
	            resp.setMessage(e.getMessage());
	            e.printStackTrace();
	        }

	        logger.info("Method : deletPerforationRecord Dao ends" + resp);
	        return resp;
	    }
	 
	 @SuppressWarnings("unchecked")
		public JsonResponse<Object> generatePdfForPerforationRecord(String orgName, String orgDiv,String recordId) {
			logger.info("Method : generatePdfForPerforationRecord Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_recordId='"+recordId+"';";
				System.out.println("generatePdfForPerforationRecord========>" + value);
				logger.info("Alert Data Value" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("perforation_record_routines")
						.setParameter("actionType", "pdfForPorforationRecord").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : generatePdfForPerforationRecord Dao ends"+resp);
			return resp;

		}
	 
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> approvePerforationRecord(String recordId, String orgName, String orgDiv) {
			logger.info("Method : approvePerforationRecord Dao starts");

		 	JsonResponse<Object> resp = new JsonResponse<Object>();

			try {

				String value = "SET @p_recordId='" + recordId + "',@p_orgName='" + orgName + "',@p_orgDivision='"
						+ orgDiv + "';";
				System.out.println("approvePerforationRecord========>" + value);

				Object x = em.createNamedStoredProcedureQuery("perforation_record_routines")
						.setParameter("actionType", "approvePerforation").setParameter("actionValue", value)
						.getSingleResult();
				System.out.println("value of x ------->>>>> " + x.toString());
				if (Integer.parseInt(x.toString()) > 0) {
					resp.setCode("success");
					resp.setMessage("Perforation Record Approved successfully");
				}

			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : approvePerforationRecord Dao ends" + resp);
			return resp;
		}
}
