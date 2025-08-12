package nirmalya.aatithya.restmodule.user.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateAddRoleAssignparam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.model.RestUserRoleAssignModel;

@Repository
public class UserRoleAssignDao {

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(UserRoleAssignDao.class);
	

	// view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestUserRoleAssignModel>>> viewUserMaster(String organization, String orgDivision) {
		logger.info("Method : viewUserMaster starts");
		List<RestUserRoleAssignModel> respList = new ArrayList<RestUserRoleAssignModel>();

		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='"+orgDivision +"';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userRoleAssign")
					.setParameter("actionType", "viewUserMaster").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestUserRoleAssignModel restPayroll = new RestUserRoleAssignModel(m[0].toString(),m[1],m[2],m[3],m[4]);
				respList.add(restPayroll);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		JsonResponse<List<RestUserRoleAssignModel>> resp = new JsonResponse<List<RestUserRoleAssignModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestUserRoleAssignModel>>> response = new ResponseEntity<JsonResponse<List<RestUserRoleAssignModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewUserMaster ends");
		return response;

	}
	
//edit
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestUserRoleAssignModel>> editUserAssignMaster(String id) {
		logger.info("Method : editUserAssignMaster starts");
		
		JsonResponse<RestUserRoleAssignModel> resp = new JsonResponse<RestUserRoleAssignModel>();
		resp.setMessage("");
		resp.setCode("");
		List<RestUserRoleAssignModel> roleList = new ArrayList<RestUserRoleAssignModel>();
		try {
			String value = "SET @P_empId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("userRoleAssign")
					.setParameter("actionType", "editUserAssignMaster").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				
				RestUserRoleAssignModel dropDownModel = new RestUserRoleAssignModel(m[0].toString(),m[1],null,null,m[2].toString(),m[3].toString());
				roleList.add(dropDownModel);
			}
			resp.setBody(roleList.get(0));
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
		
		ResponseEntity<JsonResponse<RestUserRoleAssignModel>> response = new ResponseEntity<JsonResponse<RestUserRoleAssignModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : editUserAssignMaster ends");
		return response;
	}

	
	
	// add
	public ResponseEntity<JsonResponse<Object>> addRoleassignMaster(RestUserRoleAssignModel id) {
		logger.info("Method : saveUserMaster starts"+id);

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			logger.info("ADDDDRESULT"+id.getEmpId());
			String values = GenerateAddRoleAssignparam.saveUserRoleAssignMaster(id);
			if(id.getEmpId() != null && id.getEmpId() != "") {
				logger.info("role assign"+values);
				em.createNamedStoredProcedureQuery("userRoleAssign").setParameter("actionType", "modifyRoleassignMaster")
				.setParameter("actionValue", values).execute();
			} /*
				 * else { em.createNamedStoredProcedureQuery("userManageRoutines").setParameter(
				 * "actionType", "addRoleassignMaster") .setParameter("actionValue",
				 * values).execute(); }
				 */

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addRoleassignMaster ends"+response);
		return response;
	}
}
