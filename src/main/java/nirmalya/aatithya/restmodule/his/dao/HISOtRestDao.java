package nirmalya.aatithya.restmodule.his.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class HISOtRestDao {
	Logger logger = LoggerFactory.getLogger(HISOtRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPatient(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewPatient Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			
			logger.info(value);			
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_details_routines")
					.setParameter("actionType", "viewPatient").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPatient Dao ends" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editOt(String Id, String organization, String orgDivision) {
		logger.info("Method : editOt Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_patientId='" + Id + "';";
			
			logger.info("vvvv"+value);	
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_details_routines")
					.setParameter("actionType", "editOt").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : editOt Dao ends" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewSurgen(String Id,String orgName, String orgDivision, String userId) {
		logger.info("Method : viewSurgen Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "',@p_procedureName='" + Id + "';";
			
			logger.info(value);			
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_details_routines")
					.setParameter("actionType", "viewSurgen").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewSurgen Dao ends" + resp);
		return resp;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewDoctorMaster(String orgName, String orgDivision) {
		logger.info("Method : viewDoctorMaster Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision +"';";
			
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_ot_details_routines")
					.setParameter("actionType", "viewDoctorMaster").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewDoctorMaster Dao ends"+resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEquipment(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewEquipment Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			
			logger.info(value);			
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_details_routines")
					.setParameter("actionType", "viewEquipment").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEquipment Dao ends" + resp);
		return resp;
	}

}
