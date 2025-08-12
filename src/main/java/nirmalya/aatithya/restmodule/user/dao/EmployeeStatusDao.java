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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeStatus;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.model.RestUserRoleAssignModel;

@Repository
public class EmployeeStatusDao {

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(EmployeeStatusDao.class);
	

	// view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestUserRoleAssignModel>>> viewEmployeeMasterView(String org, String orgDiv) {
		logger.info("Method : viewEmployeeMaster starts");
		List<RestUserRoleAssignModel> respList = new ArrayList<RestUserRoleAssignModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeestatus")
					.setParameter("actionType", "viewEmployeeMaster").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestUserRoleAssignModel restPayroll = new RestUserRoleAssignModel(m[0].toString(),m[1],m[2],m[3],m[4],m[5],null);
				respList.add(restPayroll);

			}

			logger.info("ROLEASSIGN" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestUserRoleAssignModel>> resp = new JsonResponse<List<RestUserRoleAssignModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestUserRoleAssignModel>>> response = new ResponseEntity<JsonResponse<List<RestUserRoleAssignModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewEmployeeMaster ends");
		logger.info("VIEWWWW"+response);
		return response;

	}

	
	// add
	public ResponseEntity<JsonResponse<Object>> addEmployeeMasteradd(RestUserRoleAssignModel id) {
		logger.info("Method : addEmployeeMaster starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			logger.info("ADDDDRESULT"+id.getEmpId());
			String values = GenerateEmployeeStatus.saveEmployeeMaster(id);
			if(id.getEmpId() != null && id.getEmpId() != "") {
				logger.info("ADDVALUE"+values);
				em.createNamedStoredProcedureQuery("employeestatus").setParameter("actionType", "modifyEmployeeMaster")
				.setParameter("actionValue", values).execute();
			} 

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

		logger.info("Method : addEmployeeMaster ends");
		return response;
	}
	// clear Password
	public ResponseEntity<JsonResponse<Object>> clearPassword(String id,String org, String orgDiv) {
		logger.info("Method : clearPassword starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String value = "SET @p_empId='(" + id + ")',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
				logger.info("value====="+value);
				em.createNamedStoredProcedureQuery("employeestatus").setParameter("actionType", "clearPassword")
						.setParameter("actionValue", value).execute();
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
		logger.info("Method : clearPassword ends");
		return response;
	}
	// clear IMEI
	public ResponseEntity<JsonResponse<Object>> clearIMEI(String id,String org, String orgDiv) {
		logger.info("Method : clearIMEI starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String value = "SET @p_empId='(" + id + ")',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
				logger.info("value====="+value);
				em.createNamedStoredProcedureQuery("employeestatus").setParameter("actionType", "clearIMEI")
				.setParameter("actionValue", value).execute();
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
		logger.info("Method : clearIMEI ends");
		return response;
	}
}
