package nirmalya.aatithya.restmodule.ticket.dao;

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

@Repository
public class SieveReplacementStatusDao {
Logger logger = LoggerFactory.getLogger(SieveReplacementStatusDao.class);
	
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;
	
 

	public JsonResponse<Object> addSieveStatusData(Map<String, Object> sieveStatusJsonData) {
	    logger.info("Method : addSieveStatusData starts");

	    JsonResponse<Object> resp = new JsonResponse<>();
	    ObjectMapper objectMapper = new ObjectMapper();

	    try {
	        // Convert Map to JSON string
	        String jsonData = objectMapper.writeValueAsString(sieveStatusJsonData);
	        String serialNo = (String) sieveStatusJsonData.get("serialNo");
	        String actionType = (serialNo == null || serialNo.isEmpty()) ? "addSieveStatus" : "modifySieveStatus";

	        // Prepare the SQL variable for stored procedure
	        String value = "SET @sieveStatusData='" + jsonData + "';";
            System.out.println("Value==============>"+value);
	        // Execute the stored procedure
	        Object result = em.createNamedStoredProcedureQuery("sieve_status_routines")
	                .setParameter("actionType", actionType)
	                .setParameter("actionValue", value)
	                .execute();

	        resp.setBody(result.toString());
	        resp.setCode("success");
	        resp.setMessage(actionType.equals("addSieveStatus") ? "Sieve Status added successfully." : "Sieve Status updated successfully.");
	        logger.info(actionType.equals("addSieveStatus") ? "Adding new sieve status." : "Updating sieve status for serialNo: " + serialNo);

	    } catch (Exception e) {
	        resp.setCode("Failed");
	        resp.setMessage("Error during Sieve Status operation.");
	        logger.error("Error in addSieveStatusData: ", e);
	    }

	    logger.info("Method : addSieveStatusData ends");
	    return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sieveStatusView(String orgName, String orgDiv) {
		logger.info("Method : sieveStatusView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			System.out.println("sieveStatusView========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("sieve_status_routines")
					.setParameter("actionType", "sieveStatusView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : sieveStatusView Dao ends"+resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editSieveStatus(String orgName, String orgDiv,String slNo) {
		logger.info("Method : editSieveStatus Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_slNo='"+slNo+"';";
			System.out.println("editSieveStatus========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("sieve_status_routines")
					.setParameter("actionType", "editSieveStatus").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : editSieveStatus Dao ends"+resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
    public JsonResponse<Object> deleteSieveStatus(String serialNo,String orgName, String orgDiv) {
        logger.info("Method : deleteSieveStatus Dao starts");

        JsonResponse<Object> resp = new JsonResponse<Object>();

        try {
             
            String value = "SET @p_serialNo='" + serialNo + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv + "';";
            System.out.println("deleteSieveStatus========>" + value);

            Object x = em.createNamedStoredProcedureQuery("sieve_status_routines")
                    .setParameter("actionType", "deletSieveStatus").setParameter("actionValue", value)
                    .getSingleResult();
            System.out.println("value of x ------->>>>> "+x.toString());
            if(Integer.parseInt(x.toString()) > 0) {
				resp.setCode("success");
	  			resp.setMessage("Sieve Status Deleted successfully");
  			}

        } catch (Exception e) {
            resp.setCode("failed");
            resp.setMessage(e.getMessage());
            e.printStackTrace();
        }

        logger.info("Method : deleteSieveStatus Dao ends" + resp);
        return resp;
    }
	
	@SuppressWarnings("unchecked")
    public JsonResponse<Object> approveSieveStatus(String serialNo,String orgName, String orgDiv) {
        logger.info("Method : approveSieveStatus Dao starts");

        JsonResponse<Object> resp = new JsonResponse<Object>();

        try {
             
            String value = "SET @p_serialNo='" + serialNo + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv + "';";
            System.out.println("approveSieveStatus========>" + value);

            Object x = em.createNamedStoredProcedureQuery("sieve_status_routines")
                    .setParameter("actionType", "approveSieveStatus").setParameter("actionValue", value)
                    .getSingleResult();
            System.out.println("value of x ------->>>>> "+x.toString());
            if(Integer.parseInt(x.toString()) > 0) {
				resp.setCode("success");
	  			resp.setMessage("Sieve Status Approved successfully");
  			}

        } catch (Exception e) {
            resp.setCode("failed");
            resp.setMessage(e.getMessage());
            e.printStackTrace();
        }

        logger.info("Method : approveSieveStatus Dao ends" + resp);
        return resp;
    }

}
