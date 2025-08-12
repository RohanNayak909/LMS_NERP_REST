package nirmalya.aatithya.restmodule.maintenance.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class VerificationAllocationDao {
	Logger logger = LoggerFactory.getLogger(VerificationAllocationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;



	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewVerificationAsset(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewVerificationAsset Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "';";
			System.out.println("HELLO WORLD:::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "verificationAsset").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewVerificationAsset Dao ends");
		return resp;

	}
	
	public ResponseEntity<JsonResponse<Object>> allocateVerification(String assetid,String assetemp,String assigndate,String frequency, String orgName, String orgDivision, String userId) {
		logger.info("Method : allocateVerification starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        String formattedTime = sdf.format(currentTime);
		if (validity)
			try {

				String value = "SET @p_assetId='" + assetid+ "',@p_assetemp='" + assetemp+ "',@p_assigndate='" + assigndate+ "',@p_frequency='" + frequency+ "',@p_org='" + orgName + "',@p_time='" + formattedTime + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "';";
				System.out.println("HELLO WORLD ADD:::"+value);
				em.createNamedStoredProcedureQuery("asset_maintenance_routines")
						.setParameter("actionType", "allocateVerify").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Verification Allocated successfully");
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

		logger.info("Method : allocateVerification ends");

		return response;
	}
	
	
	public ResponseEntity<JsonResponse<Object>> deleteVerifyAlloc(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteVerifyAlloc starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {

				String value = "SET @p_assetId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("asset_maintenance_routines")
						.setParameter("actionType", "deleteVerifyAlloc").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Deallocated Successfully");
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

		logger.info("Method : deleteVerifyAlloc ends");
		return response;
	}
}
