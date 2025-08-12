package nirmalya.aatithya.restmodule.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateInsuranceParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateNomineParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateIpdTreatmentParameter;
import nirmalya.aatithya.restmodule.employee.model.RestEmployeeNomineModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.his.dao.HISPatientDao;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class HrmInsuranceDao {

	Logger logger = LoggerFactory.getLogger(HrmInsuranceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;
	
	//view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEmployee(String orgName, String orgDivision, String type, String userId) {
		logger.info("Method : viewEmployee Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "', @p_type='" + type + "', @p_userId='" + userId + "';";
			System.out.println("value for employee view=================> " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_insurance_routines")
					.setParameter("actionType", "viewEmployee").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : viewEmployee Dao ends" + resp);
		return resp;

	}
	
	//edit
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editInsurance(String Id, String organization, String orgDivision) {
		logger.info("Method : editInsurance Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_employeeId='" + Id + "';";
			
			logger.info("vvvv"+value);	
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_insurance_routines")
					.setParameter("actionType", "editInsurance").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : editInsurance Dao ends" + resp);
		return resp;

	}
	
	
	//save nomine 
	
			public ResponseEntity<JsonResponse<Object>> saveNomine(RestEmployeeNomineModel restEmployeeNomineModel) {
				logger.info("Method : Rest Add saveNomine Dao starts");

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String values = GenerateNomineParam.addNomineParam(restEmployeeNomineModel);

					if (restEmployeeNomineModel.getNomineId() != null && restEmployeeNomineModel.getNomineId() != "") {

						em.createNamedStoredProcedureQuery("hrms_insurance_routines").setParameter("actionType", "modifyNomine")
								.setParameter("actionValue", values).execute();
						resp.setMessage("Nominee  Modified Successfully");
						resp.setCode("Success");
					} else {
						em.createNamedStoredProcedureQuery("hrms_insurance_routines").setParameter("actionType", "saveNomine")
								.setParameter("actionValue", values).execute();
						resp.setMessage("Nominee saved SuccessFully");
						resp.setCode("Success");
					}

				} catch (Exception e) {
					try {
						String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}

				ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
						HttpStatus.CREATED);

				logger.info("Method :  Rest Add saveNomine Dao ends");

				return response;
			}
			
			
			//view nomine
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> viewNomine(String organization, String orgDivision, String userId,String employeeId) {
				logger.info("Method : viewNomine Dao starts" + userId);

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "',@p_employeeId='" + employeeId +"'";
					
					logger.info("valuesssss"+value);			
					List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_insurance_routines")
							.setParameter("actionType", "viewNomine").setParameter("actionValue", value)
							.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data Fetched successfully");
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : viewNomine Dao ends" + resp);
				return resp;
			}
			
			
			//edit nomine
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> editNomine(String id, String organization, String orgDivision) {
				logger.info("Method : editNomine Dao starts");

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_nomineId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "'";
					
	System.out.println(value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_insurance_routines")
							.setParameter("actionType", "editNomine").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data Fetched successfully");
				} catch (Exception e) {
					e.printStackTrace();
					resp.setMessage("Something Went Wrong !");
				}
				logger.info("Method : editNomine Dao ends" + resp);
				return resp;

			}
			
			//view insurance
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> viewInsurance(String organization, String orgDivision, String userId,String id) {
				logger.info("Method : viewInsurance Dao starts" + userId);

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "',@p_id='" + id +"'";
					
					logger.info("valuesssss"+value);			
					List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_insurance_routines")
							.setParameter("actionType", "viewInsurance").setParameter("actionValue", value)
							.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data Fetched successfully");
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : viewInsurance Dao ends" + resp);
				return resp;
			}
			
			  //add
			  
				public ResponseEntity<JsonResponse<Object>> addInsurance(
						RestEmployeeNomineModel restEmployeeNomineModel) {
					logger.info("Method : Rest Add addInsurance Dao starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						String values = GenerateInsuranceParam.addInsuranceParam(restEmployeeNomineModel);

						if (restEmployeeNomineModel.getInsuranceId() != null
								&& restEmployeeNomineModel.getInsuranceId() != "") {

							em.createNamedStoredProcedureQuery("hrms_insurance_routines")
									.setParameter("actionType", "modifyInsurance").setParameter("actionValue", values)
									.execute();
							resp.setMessage("Data Modify SuccessFully");
							resp.setCode("Success");
						} else {
							em.createNamedStoredProcedureQuery("hrms_insurance_routines")
									.setParameter("actionType", "addInsurance").setParameter("actionValue", values)
									.execute();
							resp.setMessage("Data saved SuccessFully");
							resp.setCode("Success");
						}

					} catch (Exception e) {
						try {
							String[] err = serverDao.errorProcedureCall(e);
							resp.setCode(err[0]);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						e.printStackTrace();
					}

					ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
							HttpStatus.CREATED);

					logger.info("Method :  Rest Add addInsurance Dao ends");

					return response;
				} 
				
				
				//Delete Nomine 
				public JsonResponse<Object> deleteNomine(String org, String orgDiv, String userId, String id) {
					logger.info("Method : deleteNomine starts");
					
					JsonResponse<Object> resp = new JsonResponse<>();
					
					try {
						
						String value = "SET @p_nomineId='" + id + "',@p_orgDiv='" + org + "',@p_orgDiv='" + orgDiv
								+ "',@p_userId='" + userId + "';";
						
						em.createNamedStoredProcedureQuery("hrms_insurance_routines").setParameter("actionType", "deleteNomine")
						.setParameter("actionValue", value).execute();
						
						Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
						
					} catch (Exception e) {
						Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
						e.printStackTrace();
					}
					
					logger.info("Method : deleteNomine ends");
					return resp;
				}
}
