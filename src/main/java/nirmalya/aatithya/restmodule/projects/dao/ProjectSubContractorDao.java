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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectSubContractorParameter;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.projects.model.ProjectSubContractorRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository

public class ProjectSubContractorDao {

	Logger logger = LoggerFactory.getLogger(ProjectSubContractorDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// add sub contractor

	public ResponseEntity<JsonResponse<Object>> restaddSubContractor(
	        ProjectSubContractorRestModel subContractor) {
	    logger.info("Method: restaddSubContractor starts");
	    System.out.println(subContractor);
	    JsonResponse<Object> resp = new JsonResponse<>();

	    String value = GenerateProjectSubContractorParameter.getProjectSubContractorParam(subContractor);
	    System.out.println("value===" + value);
	    System.out.println("Modify subContractor===" + subContractor.getContractorId());
	    try {
	        if (subContractor.getContractorId() != null && !subContractor.getContractorId().isEmpty()) {
	            em.createNamedStoredProcedureQuery("project_sub_contractor_routines")
	                    .setParameter("actionType", "modifySubContractor")
	                    .setParameter("actionValue", value)
	                    .execute();

	            resp.setCode("success");
	            resp.setMessage("Data Modified successfully");
	        } else {
	            em.createNamedStoredProcedureQuery("project_sub_contractor_routines")
	                    .setParameter("actionType", "addSubContractor")
	                    .setParameter("actionValue", value)
	                    .execute();

	            resp.setCode("success");
	            resp.setMessage("Data saved successfully");
	        }
	    } catch (Exception e) {
	        try {
	            String[] err = serverDao.errorProcedureCall(e);
	            e.printStackTrace();
	            Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
	        } catch (Exception e1) {
	            e1.printStackTrace();
	            e.printStackTrace();
	            Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
	        }
	        e.printStackTrace();
	    }

	    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
	    System.out.println("response===" + response);
	    logger.info("Method: restaddSubContractor ends");
	    return response;
	}


	// view sub contractor
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewSubContractor(String orgName, String orgDivision) {
		logger.info("Method : viewSubContractor Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_OrganizationName='" + orgName + "',@p_OrganizationDivision='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("project_sub_contractor_routines")
					.setParameter("actionType", "viewSubContractor").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewSubContractor Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// edit sub contractor
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editSubContractor(String id, String orgName, String orgDivision) {
		logger.info("Method : editSubContractor Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_ContractorId='" + id + "',@p_OrganizationName='" + orgName
					+ "',@p_OrganizationDivision='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("project_sub_contractor_routines")
					.setParameter("actionType", "editSubContractor").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editSubContractor Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}

	// delete sub contractor
	public ResponseEntity<JsonResponse<Object>> deleteSubContractor(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteSubContractor dao starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_ContractorId='" + id + "',@p_OrganizationName='" + orgName
						+ "',@p_OrganizationDivision='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("project_sub_contractor_routines")
						.setParameter("actionType", "deleteSubContractor").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteSubContractor dao ends");
		System.out.println("DELETEE" + response);
		return response;
	}

	// auto search

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getProjectAutoSearchList(String id) {
		logger.info("Method : getProjectAutoSearchList dao starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		System.out.println("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("project_sub_contractor_routines")
					.setParameter("actionType", "getProjectName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProjectAutoSearchList dao ends");
		System.out.println("AUTODATAAA" + response);
		return response;
	}

	// add sub contractor work

	public ResponseEntity<JsonResponse<Object>> addSubContractorWork(ProjectSubContractorRestModel subContractorWork) {
		logger.info("Method : restaddsubContractorWork starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateProjectSubContractorParameter.getProjectSubContractorParamm(subContractorWork);

			System.out.println("valuessss" + values);

			if (subContractorWork.getSubContractorId() == null || subContractorWork.getSubContractorId() == "") {

				em.createNamedStoredProcedureQuery("project_sub_contractor_routines")
						.setParameter("actionType", "addSubContractorWork").setParameter("actionValue", values)
						.execute();
				System.out.println("if");
			} else {

				em.createNamedStoredProcedureQuery("project_sub_contractor_routines")
						.setParameter("actionType", "modifySubContractorWork").setParameter("actionValue", values)
						.execute();
				System.out.println("else");
			}

		} catch

		(Exception e) {
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

		logger.info("Method : restaddsubContractorWork ends");
		return response;
	}

	// view sub contractor work

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProjectSubContractorRestModel>>> viewSubContractorWork() {
		logger.info("Method : viewSubContractorWork dao starts");
		List<ProjectSubContractorRestModel> respList = new ArrayList<ProjectSubContractorRestModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("project_sub_contractor_routines")
					.setParameter("actionType", "viewSubContractorWork").setParameter("actionValue", "")
					.getResultList();
			for (Object[] m : x) {
				ProjectSubContractorRestModel cusData = new ProjectSubContractorRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
				respList.add(cusData);
			}
			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<ProjectSubContractorRestModel>> resp = new JsonResponse<List<ProjectSubContractorRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<ProjectSubContractorRestModel>>> response = new ResponseEntity<JsonResponse<List<ProjectSubContractorRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : viewSubContractorWork dao ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

	// edit sub contractor work

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProjectSubContractorRestModel>>> subcontractorWorkEdit(String id) {
		logger.info("Method : edit starts");

		JsonResponse<List<ProjectSubContractorRestModel>> resp = new JsonResponse<List<ProjectSubContractorRestModel>>();
		List<ProjectSubContractorRestModel> newResp = new ArrayList<ProjectSubContractorRestModel>();

		try {
			String value = "SET @p_SubContractorId='" + id + "';";
			System.out.println("@@@@@@@@@@@@@@@@@@@" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("project_sub_contractor_routines")
					.setParameter("actionType", "EditSubContractorWork").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				ProjectSubContractorRestModel restSubcontractorWorkEdit = new ProjectSubContractorRestModel(m[0], m[1],
						m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
				newResp.add(restSubcontractorWorkEdit);
				System.out.println("restSubcontractorWorkEditDao" + restSubcontractorWorkEdit);
			}

			resp.setBody(newResp);
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

		ResponseEntity<JsonResponse<List<ProjectSubContractorRestModel>>> response = new ResponseEntity<JsonResponse<List<ProjectSubContractorRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : edit ends");
		return response;
	}

	// delete sub contractor work
	public ResponseEntity<JsonResponse<Object>> subcontractorWorkDelete(String id) {
		logger.info("Method : subcontractorWorkDelete dao starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_SubContractorId='" + id + "';";

				em.createNamedStoredProcedureQuery("project_sub_contractor_routines")
						.setParameter("actionType", "DeleteSubContractorWork").setParameter("actionValue", value)
						.execute();

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

		logger.info("Method : subcontractorWorkDelete dao ends");
		System.out.println("DELETEE" + response);
		return response;
	}

}
