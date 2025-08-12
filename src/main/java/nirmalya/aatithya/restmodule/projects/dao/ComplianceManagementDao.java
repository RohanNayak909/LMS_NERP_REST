package nirmalya.aatithya.restmodule.projects.dao;

import java.util.ArrayList;
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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateComplianceParam;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectExecutionParameter;
import nirmalya.aatithya.restmodule.projects.model.RestComplianceManagementModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectExecutionModel;

@Repository
public class ComplianceManagementDao {
	Logger logger = LoggerFactory.getLogger(ComplianceManagementDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> complianceNameListDao() {
		logger.info("Method : complianceNameList Dao starts");

		List<DropDownModel> getComplianceNameList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("compliance_management_routinnes")
					.setParameter("actionType", "getComplianceNameList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getComplianceNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : complianceNameList Dao ends"+getComplianceNameList);

		return getComplianceNameList;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestComplianceManagementModel>>> saveComplianceManagementDao(
			List<RestComplianceManagementModel> compliance) {
		logger.info("Method : saveComplianceManagement Dao starts"+compliance);

		JsonResponse<List<RestComplianceManagementModel>> resp = new JsonResponse<List<RestComplianceManagementModel>>();
		List<RestComplianceManagementModel> listData = new ArrayList<RestComplianceManagementModel>();
		
			try {
				String values = GenerateComplianceParam.saveCompliance(compliance);
                logger.info("values==========================="+values);
				if (compliance.get(0).getComplianceId() != null && compliance.get(0).getComplianceId() != "") {

					em.createNamedStoredProcedureQuery("compliance_management_routinnes")
							.setParameter("actionType", "modifyComplianceManagement").setParameter("actionValue", values)
							.execute();
					/*
					 * try { for (Object[] m : x) {
					 * 
					 * RestComplianceManagementModel dropDownModel = new
					 * RestComplianceManagementModel(m[0], m[1]); listData.add(dropDownModel); }
					 * 
					 * } catch (Exception e) { e.printStackTrace(); }
					 */
				} else {
					logger.info("values===========================addd"+values);
					em.createNamedStoredProcedureQuery("compliance_management_routinnes")
							.setParameter("actionType", "addComplianceManagement").setParameter("actionValue", values)
							.execute();

					
					/*
					 * try { for (Object[] m : x) {
					 * 
					 * RestComplianceManagementModel dropDownModel = new
					 * RestComplianceManagementModel(m[0], m[1]); listData.add(dropDownModel); }
					 * 
					 * } catch (Exception e) { e.printStackTrace(); }
					 */
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("Failed");
				resp.setMessage(e.getLocalizedMessage());

			}
			resp.setBody(listData);
			resp.setCode("Success");
			resp.setMessage("Data Saved Successfully");

		ResponseEntity<JsonResponse<List<RestComplianceManagementModel>>> response = new ResponseEntity<JsonResponse<List<RestComplianceManagementModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveComplianceManagement Dao ends"+response);
		return response;
	}
	
	
	@SuppressWarnings("unchecked")

	public JsonResponse<Object> viewCompliance(String userid, String org,
			String div,String id) {

		logger.info("Method : viewCompliance Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_id='" + id + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("compliance_management_routinnes")
					.setParameter("actionType", "viewCompliance").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewCompliance Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")

	public JsonResponse<Object> editCompliance(String userid, String org,
			String div,String id) {

		logger.info("Method : editCompliance Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_id='" + id + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("compliance_management_routinnes")
					.setParameter("actionType", "editCompliance").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : editCompliance Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	public ResponseEntity<JsonResponse<Object>> deleteCompliance(String id) {
		logger.info("Method : deleteCompliance Dao starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_comId='" + id + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("compliance_management_routinnes")
						.setParameter("actionType", "deleteCompliance").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteCompliance Dao ends");
		return response;
	}
}
