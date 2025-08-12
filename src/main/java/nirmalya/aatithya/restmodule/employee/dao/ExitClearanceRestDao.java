package nirmalya.aatithya.restmodule.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateExitFinanceParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ExitFinancialSettelmentRestModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ExitClearanceRestDao {
	Logger logger = LoggerFactory.getLogger(ExitClearanceRestDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewExitClearance(String userId, String organization, String orgDivision) {

		logger.info("Method in Dao: viewExitClearanceDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		String value = "SET @P_userId='" + userId + "',@P_organization='" + organization
				+ "',@P_orgDivision='" + orgDivision + "';";

		System.out.println("value>>"+value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "viewExitClearance").setParameter("actionValue", value)
					.getResultList();

			System.out.println("resp>>>>"+x);
			
			if (x != null) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, "success");
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
			System.out.println("resp>>>>"+resp);

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			System.err.println(err[0]);
			System.err.println(err[1]);
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setMessage(e.getMessage());

		}

		logger.info("Method in Dao: viewExitClearanceDetails ends");

		return resp;
	}

	/*
	 * Add Exit Clearance Details
	 * 
	 */

	public JsonResponse<Object> updateExitClearances(ExitFinancialSettelmentRestModel exit) {

		logger.info("Method : updateExitClearances starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateExitFinanceParameter.updateClearanceStatus(exit);
			
			System.out.println("values>>>>updateClearanceStatus>>>>>"+values);
		
				em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "updateClearanceDetails")
						.setParameter("actionValue", values).execute();
			
				Util.setJsonResponse(resp, null, ResponseStatus.success, "Clearance Updated Successfully");
				
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed,err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		logger.info("Method : updateExitClearances ends");
		return resp;
	}
}
