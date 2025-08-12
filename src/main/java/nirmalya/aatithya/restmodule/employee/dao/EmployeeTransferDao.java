package nirmalya.aatithya.restmodule.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class EmployeeTransferDao {

	Logger logger = LoggerFactory.getLogger(EmployeeTransferDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveTransferEmployeeData(String data, String userId, String org,
			String orgDiv) {
		logger.info("method: saveTransferEmployeeData Starts");

		JsonResponse<Object> response = new JsonResponse<>();

		String values = "SET @emp_json='" + data + "',@userId='" + userId + "',@org='" + org + "',@orgDiv='" + orgDiv
				+ "';";

		try {

			em.createNamedStoredProcedureQuery("employee_transfer_routines")
					.setParameter("actionType", "save-transfer-employee-data").setParameter("actionValue", values)
					.execute();

			response.setMessage("Transfer request generated successfully.");
			response.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("method: saveTransferEmployeeData ends");

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllEmpTransferData(String org, String orgDiv, String userId) {
		logger.info("Method : getAllEmpTransferData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @org='" + org + "', @org_div='" + orgDiv + "',@userId='" + userId + "';";
		System.out.println(value);
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("employee_transfer_routines")
					.setParameter("actionType", "get-emp-transfer-data").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0 && x.get(0) != null) {
				resp.setBody(x.get(0));
				resp.setMessage("Data fetched successfully.");
				resp.setCode("Success");
			} else {
				resp.setMessage("No data found.");
				resp.setCode("Failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : getAllEmpTransferData Dao ends");
		return resp;
	}

}
