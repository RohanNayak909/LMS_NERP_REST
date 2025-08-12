package nirmalya.aatithya.restmodule.ticket.dao;



	import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
	import nirmalya.aatithya.restmodule.common.ServerDao;
	import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
	import nirmalya.aatithya.restmodule.util.StringUtil;
	import org.json.JSONObject;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Repository;

	import javax.persistence.EntityManager;
	import java.util.List;

	@Repository
	public class WorkPermitRestDao {
	    Logger logger = LoggerFactory.getLogger(WorkPermitRestDao.class);
	    @Autowired
	    EntityManager em;

	    @Autowired
	    ServerDao serverDao;

	    @Autowired
	    EnvironmentVaribles env;
	    // save New Employee data
	    @SuppressWarnings("unchecked")
	    public ResponseEntity<JsonResponse<Object>> saveWorkPermit(String workpermit) {
	        logger.info("Method : workpermit starts");
	        JsonResponse<Object> resp = new JsonResponse<Object>();
	        JSONObject data = new JSONObject(workpermit);
	        String id=data.getString("workPermitId");
	        System.out.println("profileModel+++++++++++++++++++++++"+workpermit);
	        System.out.println("id+++++++++++++++++++++++"+id);
	        try {
	            String value = "SET @workpermit='" + workpermit + "';";
	            System.out.println(data.isNull(id) +"++++++++++++++");
	            if (StringUtil.isNull(id)) {
	                System.out.println("add");
	                Object x = em.createNamedStoredProcedureQuery("workPermitRoutines")
	                        .setParameter("actionType", "addWorkpermit").setParameter("actionValue", value)
	                        .getResultList();
	                resp.setBody(x.toString())	;
	                resp.setCode("Success");
	                resp.setMessage("workpermit added Successfully");
	            } else {
	                System.out.println("modyfy");
	                Object x = em.createNamedStoredProcedureQuery("workPermitRoutines")
	                        .setParameter("actionType", "modifyWorkPermit").setParameter("actionValue", value)
	                        .getResultList();
	                resp.setBody(x.toString())	;
	                resp.setCode("Success");
	                resp.setMessage("workpermit updated Successfully");
	            }

	        } catch (Exception e) {
	            resp.setCode("Failed");
	            resp.setMessage("Error During workpermit add");
	            e.printStackTrace();
	            logger.error("saveworkpermit: " + e.getMessage());
	        }
	        ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
	                resp, HttpStatus.CREATED);

	        logger.info("Method : saveworkpermit ends");
	        return response;
	    }
	    @SuppressWarnings("unchecked")
	    public JsonResponse<Object> fetchWorkPermitData(String org,String orgDiv) {
	        logger.info("Method : fetchWorkPermitData Dao starts");
	        JsonResponse<Object> resp = new JsonResponse<Object>();
	        try {
	            String value = "SET @p_org='" + org + "',@p_orgDivision='" + orgDiv + "';";
	            System.out.println("values=>" + value);
	            List<Object[]> x = em.createNamedStoredProcedureQuery("workPermitRoutines")
	                    .setParameter("actionType", "fetchWorkPermitData").setParameter("actionValue", value)
	                    .getResultList();
	            resp.setBody(x);
	            resp.setCode("Success");
	            resp.setMessage("Data Fetched Successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	            try {
	                String[] err = serverDao.errorProcedureCall(e);
	                resp.setCode(err[0]);
	                resp.setMessage(err[1]);
	            } catch (Exception e1) {
	                e1.printStackTrace();
	            }
	        }
	        logger.info("Method : fetchWorkPermitData Dao ends" + resp);
	        return resp;
	    }
	    @SuppressWarnings("unchecked")
	    public JsonResponse<Object> editWorkPermit(String org,String orgDiv,String id) {
	        logger.info("Method : editWorkPermit Dao starts");
	        JsonResponse<Object> resp = new JsonResponse<Object>();
	        try {
	            String value = "SET @p_org='" + org + "',@p_orgDivision='" + orgDiv  + "',@p_workPermitId='" + id + "';";
	            System.out.println("values=>" + value);
	            List<Object[]> x = em.createNamedStoredProcedureQuery("workPermitRoutines")
	                    .setParameter("actionType", "editWorkPermit").setParameter("actionValue", value)
	                    .getResultList();
	            resp.setBody(x.get(0));
	            resp.setCode("Success");
	            resp.setMessage("Data Fetched Successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	            try {
	                String[] err = serverDao.errorProcedureCall(e);
	                resp.setCode(err[0]);
	                resp.setMessage(err[1]);
	            } catch (Exception e1) {
	                e1.printStackTrace();
	            }
	        }
	        logger.info("Method : editWorkPermit Dao ends" + resp);
	        return resp;
	    }
	    // delete work permit
	    @SuppressWarnings("unchecked")
	    public ResponseEntity<JsonResponse<Object>> deleteWorkpermit(String id, String orgName, String orgDivision) {
	        logger.info("Method : deleteWorkpermit starts");

	        Boolean validity = true;
	        JsonResponse<Object> resp = new JsonResponse<Object>();
	        resp.setMessage("");
	        resp.setCode("");

	        if (validity)
	            try {

	                String value = "SET @p_workpermitId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
	                System.out.println("value data"+value);
	                em.createNamedStoredProcedureQuery("workPermitRoutines")
	                        .setParameter("actionType", "deleteWorkpermit").setParameter("actionValue", value).execute();
	                resp.setCode("success");
	                resp.setMessage("Data Deleted successfully");
	            } catch (Exception e) {
	                try {
	                    String[] err = serverDao.errorProcedureCall(e);
	                    resp.setCode(err[0]);
	                    resp.setMessage(err[1]);
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	                e.printStackTrace();
	            }

	        ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
	                HttpStatus.CREATED);

	        logger.info("Method : deleteWorkpermit ends");
	        return response;
	    }
// Approve
	    @SuppressWarnings("unchecked")
	    public ResponseEntity<JsonResponse<Object>> approveWorkpermit(String id, String orgName, String orgDivision, String userId) {
	        logger.info("Method : approveWorkpermit starts");

	        Boolean validity = true;
	        JsonResponse<Object> resp = new JsonResponse<Object>();
	        resp.setMessage("");
	        resp.setCode("");

	        if (validity)
	            try {

	                String value = "SET @p_workpermitId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_approvedBy='" + userId + "';";
	                System.out.println("value data"+value);
	                em.createNamedStoredProcedureQuery("workPermitRoutines")
	                        .setParameter("actionType", "approveWorkpermit").setParameter("actionValue", value).execute();
	                resp.setCode("success");
	                resp.setMessage("Data Approved successfully");
	            } catch (Exception e) {
	                try {
	                    String[] err = serverDao.errorProcedureCall(e);
	                    resp.setCode(err[0]);
	                    resp.setMessage(err[1]);
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	                e.printStackTrace();
	            }

	        ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
	                HttpStatus.CREATED);

	        logger.info("Method : approveWorkpermit ends");
	        return response;
	    }
}
