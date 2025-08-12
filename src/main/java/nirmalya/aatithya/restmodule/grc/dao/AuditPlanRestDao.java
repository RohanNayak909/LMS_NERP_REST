package nirmalya.aatithya.restmodule.grc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateAuditMasterParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.grc.model.AuditPlanRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository

public class AuditPlanRestDao {
	Logger logger = LoggerFactory.getLogger(AuditPlanRestDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditProjectList(String organization, String orgDivision) {
		logger.info("Method : getAuditProjectList starts");
		List<DropDownModel> getAuditProjectList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getAuditProjectList").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAuditProjectList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAuditProjectList end");
		return getAuditProjectList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPriorityList(String organization, String orgDivision) {
		logger.info("Method : getPriorityList starts");
		List<DropDownModel> getPriorityList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getPriorityList").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getPriorityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPriorityList end");
		return getPriorityList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUOMListforAsset(String organization, String orgDivision) {
		logger.info("Method : getUOMListforAsset starts");
		List<DropDownModel> getUOMListforAsset = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getUOMListforAsset").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getUOMListforAsset.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getUOMListforAsset end");
		return getUOMListforAsset;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditTypeWiseAuditCategory(String organization, String orgDivision) {
		logger.info("Method : getAuditTypeWiseAuditCategory starts");
		List<DropDownModel> getAuditTypeWiseAuditCategory = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getAuditTypeWiseAuditCategory").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAuditTypeWiseAuditCategory.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAuditTypeWiseAuditCategory end");
		return getAuditTypeWiseAuditCategory;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getInternalAuditorList(String organization, String orgDivision) {
		logger.info("Method : getInternalAuditorList starts");
		List<DropDownModel> getInternalAuditorList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getInternalAuditorList").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getInternalAuditorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInternalAuditorList end");
		return getInternalAuditorList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getExternalAuditorList(String organization, String orgDivision) {
		logger.info("Method : getExternalAuditorList starts");
		List<DropDownModel> getExternalAuditorList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getExternalAuditorList").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getExternalAuditorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getExternalAuditorList end");
		return getExternalAuditorList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAuditCategoryLists(String id) {

		logger.info("Method : get AuditCategoryLists starts");
		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_auditor_type='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getAuditCategoryList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				categoryList.add(dropDownModel);
			}

			resp.setBody(categoryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : get AuditCategoryLists ends");
		return response;
	}

	// addAuditPlanSavedata
	public ResponseEntity<JsonResponse<List<AuditPlanRestModel>>> addAuditPlan(List<AuditPlanRestModel> ap) {
		logger.info("Method : addAuditPlan dao starts");
		JsonResponse<List<AuditPlanRestModel>> resp = new JsonResponse<List<AuditPlanRestModel>>();

		String value = GenerateAuditMasterParam.getAddAuditPlanParam(ap);
	 
		try {

			if (ap.get(0).getPlanId() != null && ap.get(0).getPlanId() != "") {

				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "modifyAuditPlan").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("auditmaster_routines").setParameter("actionType", "addAuditPlan")
						.setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<AuditPlanRestModel>>> response = new ResponseEntity<JsonResponse<List<AuditPlanRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addAuditPlan dao ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAuditPlan(@RequestParam String type,String orgName, String orgDivision) {
		logger.info("Method : viewAuditPlan Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "', @p_orgDiv='" + orgDivision + "', @p_type='" + type + "';";

			System.out.println("VALUE PARAM:::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "viewAuditPlan").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAuditPlan Dao ends");
		return resp;

	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object>auditPlanEdit(String id, String orgName, String orgDivision) {
		logger.info("Method : auditPlanEdit Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		 
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "auditPlanEdit").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : auditPlanEdit Dao Ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteAuditPlan(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteAuditPlan starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "deleteAuditPlan").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
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

		logger.info("Method : deleteAuditPlan ends");
		return response;
	}
	
	
	public ResponseEntity<JsonResponse<Object>> approveAuditPlan(String id, String orgName, String orgDivision) {
		logger.info("Method : approveAuditPlan starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "approveAuditPlan").setParameter("actionValue", value).execute();
				resp.setMessage("Data Approved Successfully");
				resp.setCode("success");
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
		logger.info("Method : approveAssetPolicy ends");
		return response;
	}

}
