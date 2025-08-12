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
public class InspectionPlanRestDao {

	Logger logger = LoggerFactory.getLogger(InspectionPlanRestDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	

	/*
	 * @SuppressWarnings("unchecked") public JsonResponse<List<AuditPlanRestModel>>
	 * getInspectionPlanData(String organization, String orgDivision) {
	 * logger.info("Method : getInspectionPlanData Dao starts");
	 * 
	 * Integer total = 0; List<AuditPlanRestModel> req = new
	 * ArrayList<AuditPlanRestModel>(); JsonResponse<List<AuditPlanRestModel>> resp
	 * = new JsonResponse<List<AuditPlanRestModel>>();
	 * 
	 * try { String value = "SET @P_organization='" + organization +
	 * "',@P_orgDivision='" + orgDivision + "';"; List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("inspection_plan_routines")
	 * .setParameter("actionType",
	 * "getInspectionPlanData").setParameter("actionValue", value) .getResultList();
	 * 
	 * for (Object[] m : x) { AuditPlanRestModel reqEdit = new
	 * AuditPlanRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8]);
	 * 
	 * req.add(reqEdit); total = total + 1; } } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * resp.setBody(req); resp.setTotal(total);
	 * logger.info("Method : getInspectionPlanData Dao ends"); return resp; }
	 */
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInspectCategoryLists(String id) {

		logger.info("Method : get InspectCategoryLists starts");
		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_inspect_type='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_plan_routines")
					.setParameter("actionType", "getInspectCategoryLists").setParameter("actionValue", value)
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

		logger.info("Method : get InspectCategoryLists ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getInternalInspectionList(String organization, String orgDivision) {
		logger.info("Method : getInternalInspectionList starts");
		List<DropDownModel> getInternalInspectionList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_plan_routines")
					.setParameter("actionType", "getInternalInspectionList").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getInternalInspectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInternalInspectionList end");
		return getInternalInspectionList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getExternalInspectionList(String organization, String orgDivision) {
		logger.info("Method : getExternalInspectionList starts");
		List<DropDownModel> getExternalInspectionList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_plan_routines")
					.setParameter("actionType", "getExternalInspectionList").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getExternalInspectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getExternalInspectionList end"+getExternalInspectionList);
		return getExternalInspectionList;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteInspectionPlan(String id) {
		logger.info("Method : deleteInspectionPlan starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_inspection_plan_id='" + id + "';";

				em.createNamedStoredProcedureQuery("inspection_plan_routines")
						.setParameter("actionType", "deleteInspectionPlan").setParameter("actionValue", value)
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

		logger.info("Method : deleteInspectionPlan ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getInspectionTypeWiseAuditCategory(String organization, String orgDivision) {
		logger.info("Method : getInspectionTypeWiseAuditCategory starts");
		List<DropDownModel> getInspectionTypeWiseAuditCategory = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_plan_routines")
					.setParameter("actionType", "getInspectionTypeCategory").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getInspectionTypeWiseAuditCategory.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInspectionTypeWiseAuditCategory end");
		return getInspectionTypeWiseAuditCategory;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewInspection(@RequestParam String orgName, String orgDivision) {
		logger.info("Method : viewInspection Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "', @p_orgDiv='" + orgDivision + "';";

			System.out.println("VALUE PARAM:::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "viewInspection").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewInspection Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getInspectionType(String organization, String orgDivision) {
		logger.info("Method : getInspectionType starts");
		List<DropDownModel> getInspectionType = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "getInspectionTypeList").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getInspectionType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInspectionTypeWiseAuditCategory end");
		return getInspectionType;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getInspectionCategory(String organization, String orgDivision) {
		logger.info("Method : getInspectionCategory starts");
		List<DropDownModel> getInspectionCategory = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "getInspectionCategory").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getInspectionCategory.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInspectionCategory end");
		return getInspectionCategory;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getInspectionCategoryEx(String organization, String orgDivision) {
		logger.info("Method : getInspectionCategoryEx starts");
		List<DropDownModel> getInspectionCategory = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values-->" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "getCategoryEx").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getInspectionCategory.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInspectionCategoryEx end" + getInspectionCategory);
		return getInspectionCategory;
	}
	
	public ResponseEntity<JsonResponse<List<AuditPlanRestModel>>> addInspectionPlan(List<AuditPlanRestModel> ap) {
		logger.info("Method : addInspectionPlan dao starts");
		JsonResponse<List<AuditPlanRestModel>> resp = new JsonResponse<List<AuditPlanRestModel>>();

		String value = GenerateAuditMasterParam.getAddAuditPlanParam(ap);
		System.out.println("PARAM ::::::::"+value);
		try {

			if (ap.get(0).getPlanId() != null && ap.get(0).getPlanId() != "") {

				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "modifyInspectionPlan").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("inspection_master_routines").setParameter("actionType", "addInspectionPlan")
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
		logger.info("Method : addInspectionPlan dao ends");
		return response;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object>inspectionPlanEdit(String id, String orgName, String orgDivision) {
		logger.info("Method : inspectionPlanEdit Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		 
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "inspectionPlanEdit").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : inspectionPlanEdit Dao Ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteInspectionPlan(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteInspectionPlan starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "deleteInspectionPlan").setParameter("actionValue", value).execute();
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

		logger.info("Method : deleteInspectionPlan ends");
		return response;
	}
	
	
	public ResponseEntity<JsonResponse<Object>> approveInspectionPlan(String id, String orgName, String orgDivision) {
		logger.info("Method : approveInspectionPlan starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "approveInspectionPlan").setParameter("actionValue", value).execute();
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
		logger.info("Method : approveInspectionPlan ends");
		return response;
	}
	
	public JsonResponse<Object> addNewCategory(String name,String type,String userId,String orgName,String orgDivision) {
		logger.info("Method : addNewCategory dao starts");
		JsonResponse<Object> resp = new JsonResponse<>();
		String values = "SET @p_newCatName=\"" + name + "\",@P_newcattype=\"" + type + "\",@P_userId=\"" + userId + "\",@P_orgName=\"" + orgName + "\",@P_orgDiv=\"" + orgDivision + "\";";
		
		logger.info("values" + values);
		try {
			em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "addNewCategroy").setParameter("actionValue", values).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : addNewCategory dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCategory(String orgName,String orgDiv,String type) {
		logger.info("Method : getCategory starts");
		List<DropDownModel> respList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		
		String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv +  "',@p_type='" + type +"';";
		
		logger.info("values-->" + value);	
		try {
			List<Object[]> category = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "getcategoryList").setParameter("actionValue", value).getResultList();
			
			
			  for (Object[] result : category) {
		            String categoryId = (String) result[0]; 
		            String categoryname = (String) result[1]; 

		            DropDownModel dropDownModel = new DropDownModel(categoryId, categoryname);
		            respList.add(dropDownModel);
		        }
			resp.setBody(respList);
			resp.setMessage("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Unsuccess");
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : getCategory ends");
		return response;

	}
}
