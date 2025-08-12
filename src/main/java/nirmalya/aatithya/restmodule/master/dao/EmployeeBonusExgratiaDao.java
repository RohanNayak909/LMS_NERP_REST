package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameterEmployeeBonusExgratia;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.controller.RestEmployeeBonusModel;

@Repository
public class EmployeeBonusExgratiaDao {
	Logger logger = LoggerFactory.getLogger(EmployeeBonusExgratiaDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	 EntityManager entityManager;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;


	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEmployeeBonusExgratia(String fromDate, String toDate, String org, String orgDiv, String id) {
		logger.info("Method : viewEmployeeBonusExgratia Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			
			String value = "SET  @p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='" +
					DateFormatter.getStringDate(toDate) + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_id='" + id + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrms_emp_bonusExgratia_routines")
					.setParameter("actionType", "viewEBE").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEmployeeBonusExgratia Dao ends"+resp);
		return resp;
	}


	public ResponseEntity<JsonResponse<Object>> addUloadedEmployeeBonusExgratia(List<RestEmployeeBonusModel> model) {
		logger.info("Method : addUloadedEmployeeBonusExgratia dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateParameterEmployeeBonusExgratia.addUloadedEmployeeBonusExgratia(model);
			logger.info("values===" + values);
			if (values != null || values != "") {
				Object x=entityManager.createNamedStoredProcedureQuery("hrms_emp_bonusExgratia_routines")
						.setParameter("actionType", "addBonusExgratia").setParameter("actionValue", values)
						.execute();
				//System.err.println("dataaaa==="+x);

			}
		} catch
		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				logger.error("addEmployeeAttendances: " + e.getMessage());
				e1.printStackTrace();
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,HttpStatus.CREATED);
		logger.info("Method : addUloadedEmployeeBonusExgratia Dao ends");
		return response;
	}

}
