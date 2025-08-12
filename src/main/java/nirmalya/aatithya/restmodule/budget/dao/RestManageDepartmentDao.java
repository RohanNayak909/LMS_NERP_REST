package nirmalya.aatithya.restmodule.budget.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.budget.model.RestManageDepartmentModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.budget.GenerateDepartmentBudgetParam;


	@RestController
	@RequestMapping(value = { "budget" })
	public class RestManageDepartmentDao {
		Logger logger = LoggerFactory.getLogger(RestManageDepartmentDao.class);
		@Autowired
		EntityManager em;
		@Autowired
		ServerDao serverDao;

		// =============================================================

		// Add
		public ResponseEntity<JsonResponse<Object>> addDepartmentInfo(RestManageDepartmentModel restManageDepartmentModel) {

			logger.info("Method in Dao: addDepartmentInfo starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			resp.setMessage("");
			resp.setCode("");
			try {
				// String values ="";//
				String values = GenerateDepartmentBudgetParam.addDepartmentInfo(restManageDepartmentModel);
				// System.out.println("values---------------------------------"+values);
				if (restManageDepartmentModel.getDepartmentId() == ""
						|| restManageDepartmentModel.getDepartmentId() == null) {
					System.out.println("values for if block---------------------------------" + values);
					em.createNamedStoredProcedureQuery("assign_dept_budget").setParameter("actionType", "addDepartment")
							.setParameter("actionValue", values).execute();

				} else {
					System.out.println("values for else---------------------------------" + values);
					em.createNamedStoredProcedureQuery("assign_dept_budget").setParameter("actionType", "modifyDepartment")
							.setParameter("actionValue", values).execute();
				}
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

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);

			logger.info("Method in Dao: addDepartmentInfo ends" + response);

			return response;
		}

		// viewDepartment
				@SuppressWarnings("unchecked")
				public JsonResponse<Object> viewDepatment(String orgName, String orgDivision) {
					logger.info("Method : viewDepartment Dao starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
						
						System.out.println("values****************************" + value);
						
						List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
								.setParameter("actionType", "viewDepartment").setParameter("actionValue", value).getResultList();
						resp.setBody(x);
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : viewDepartment Dao ends");
					System.out.println("resp****************************" + resp);
					return resp;

				}
				
		
	
		// Edit

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestManageDepartmentModel>>> editDepartmentInfo(String departmentId) {
			logger.info("Method : editDepartmentInfo starts");

			JsonResponse<List<RestManageDepartmentModel>> resp = new JsonResponse<List<RestManageDepartmentModel>>();
			List<RestManageDepartmentModel> rs = new ArrayList<RestManageDepartmentModel>();

			try {

				String value = "SET @p_dept_id='" + departmentId + "';";
				System.out.println(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
						.setParameter("actionType", "editDepartment").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					RestManageDepartmentModel restPayroll = new RestManageDepartmentModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);

					rs.add(restPayroll);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.setBody(rs);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<RestManageDepartmentModel>>> response = new ResponseEntity<JsonResponse<List<RestManageDepartmentModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);

			logger.info("Method : editDepartmentInfo ends");
			System.out.println(response);
			return response;
		}
		
		//Delete
		
		
		public ResponseEntity<JsonResponse<Object>> deleteDepartmentInfo(String departmentId) {
			logger.info("Method : deleteDepartmentInfo starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			System.out.println("ID...."+departmentId);
			if (validity)
				try {

					
					String value = "SET  @p_dept_id='(" + departmentId + ")';";
					
					System.out.println("value------------------"+value);
					

					em.createNamedStoredProcedureQuery("assign_dept_budget")
							.setParameter("actionType", "deleteDepartment").setParameter("actionValue", value).execute();

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

			logger.info("Method :  deleteDepartmentInfo ends");
			System.out.println("DELETE" + response);
			return response;
		}
		
		
		
		
	}



