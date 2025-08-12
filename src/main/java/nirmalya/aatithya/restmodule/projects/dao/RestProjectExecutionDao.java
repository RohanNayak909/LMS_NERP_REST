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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectExecutionParameter;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.ProductCategoryDao;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectMessageModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectExecutionModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.StringUtil;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestProjectExecutionDao {

	Logger logger = LoggerFactory.getLogger(RestProjectExecutionDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	// tree structure

	@SuppressWarnings({ "unchecked", "unused" })
	public ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> getAllProjectCategoryList(String id) {
		logger.info("Method : getAllProjectCategoryList starts");

		JsonResponse<List<RestProjectCategoryModel>> resp = new JsonResponse<List<RestProjectCategoryModel>>();
		List<RestProjectCategoryModel> newLoc = new ArrayList<RestProjectCategoryModel>();

		try {
			String value = "SET @p_projectId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "getProjectCategoryList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestProjectCategoryModel item = new RestProjectCategoryModel(m[0], m[1], null, null, m[2], null, m[3],
						m[4], m[5], m[6], m[7], null);
				newLoc.add(item);
			}

			resp.setBody(newLoc);
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

		ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> response = new ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllProjectCategoryList ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> saveProductCategory(
			List<RestProjectExecutionModel> category) {

		logger.info("Method : saveProductCategory starts");

		JsonResponse<List<RestProjectExecutionModel>> resp = new JsonResponse<List<RestProjectExecutionModel>>();
		List<RestProjectExecutionModel> listData = new ArrayList<RestProjectExecutionModel>();
		try {

			try {
				String values = GenerateProjectExecutionParameter.saveProjectsCategory(category);

				if (category.get(0).getExecutionId() != null && category.get(0).getExecutionId() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
							.setParameter("actionType", "modifyCategory").setParameter("actionValue", values)
							.getResultList();
					try {
						for (Object[] m : x) {

							RestProjectExecutionModel dropDownModel = new RestProjectExecutionModel(m[0], m[1]);
							listData.add(dropDownModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
							.setParameter("actionType", "addCategory").setParameter("actionValue", values)
							.getResultList();
					try {
						for (Object[] m : x) {

							RestProjectExecutionModel dropDownModel = new RestProjectExecutionModel(m[0], m[1]);
							listData.add(dropDownModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
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

		} catch (Exception e) {
			logger.info("addSchemeToVle: " + e);
			try {
				String[] err = serverDao.errorProcedureCall(e);

				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> response = new ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveProductCategory ends" + resp);

		return response;
	}

	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> getAllProjectExecutionDetails(String id, String userid, String org, String div) {

		logger.info("Method : getAllProjectExecutionDetails Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_projectIds='" + id + "',@p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='"
					+ div + "';";
logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "getAllProjectExecutionDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllProjectExecutionDetails Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>>
	 * getAllProjectExecutionDetails(String id, String userid, String org, String
	 * div) { logger.info("Method : getAllProjectCategoryList starts" + id);
	 * 
	 * JsonResponse<List<RestProjectExecutionModel>> resp = new
	 * JsonResponse<List<RestProjectExecutionModel>>();
	 * List<RestProjectExecutionModel> newLoc = new
	 * ArrayList<RestProjectExecutionModel>();
	 * 
	 * try { String value = "SET @p_projectId='" + id + "',@p_userId='" + userid +
	 * "',@p_org='" + org + "',@p_orgDiv='" + div + "';";
	 * 
	 * List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("projectExceutionRoutines")
	 * .setParameter("actionType",
	 * "getAllProjectExecutionDetails").setParameter("actionValue", value)
	 * .getResultList(); if (x.size() > 0) { for (Object[] m : x) {
	 * 
	 * RestProjectExecutionModel item = new RestProjectExecutionModel(m[0], m[1],
	 * null, null, m[2], null, m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10],
	 * m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20],
	 * m[21],m[22]); newLoc.add(item); }
	 * 
	 * resp.setBody(newLoc); resp.setCode("success");
	 * resp.setMessage("Data Fetched Successfully"); } else { resp.setBody(newLoc);
	 * resp.setCode("success"); resp.setMessage("No Data Found"); }
	 * 
	 * } catch (Exception e) { resp.setCode("failed");
	 * resp.setMessage(e.getMessage()); }
	 * 
	 * ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> response = new
	 * ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>>( resp,
	 * HttpStatus.CREATED);
	 * 
	 * logger.info("Method : getAllProjectCategoryList ends" + response.getBody());
	 * return response; }
	 */

	// Add exxecution

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> saveProjectExecutionsDao(
			List<RestProjectExecutionModel> execution) {
		logger.info("Method : saveProjectExecutions Dao starts" + execution);

		JsonResponse<List<RestProjectExecutionModel>> resp = new JsonResponse<List<RestProjectExecutionModel>>();
		List<RestProjectExecutionModel> listData = new ArrayList<RestProjectExecutionModel>();

		try {
			String values = GenerateProjectExecutionParameter.savePrrojectExecutionTasks(execution);
			logger.info("values===========================" + values);
			if (execution.get(0).getExecutionId() != null && execution.get(0).getExecutionId() != "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
						.setParameter("actionType", "modifySubexecution").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {

						RestProjectExecutionModel dropDownModel = new RestProjectExecutionModel(m[0], m[1]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				logger.info("values===========================addd" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
						.setParameter("actionType", "addSubexecution").setParameter("actionValue", values)
						.getResultList();

				try {
					for (Object[] m : x) {

						RestProjectExecutionModel dropDownModel = new RestProjectExecutionModel(m[0], m[1]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getLocalizedMessage());

		}
		resp.setBody(listData);
		resp.setCode("Success");
		resp.setMessage("Data Saved Successfully");

		ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> response = new ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveProjectExecutions Dao ends" + response);
		return response;
	}

	// Add main tasks
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> saveParentCategoryDao(
			List<RestProjectExecutionModel> execution) {
		logger.info("Method : saveProjectExecutionsParent Dao starts" + execution);

		Boolean validity = true;
		JsonResponse<List<RestProjectExecutionModel>> resp = new JsonResponse<List<RestProjectExecutionModel>>();
		List<RestProjectExecutionModel> listData = new ArrayList<RestProjectExecutionModel>();
		resp.setMessage("");
		resp.setCode("");
		try {
			try {
				String values = GenerateProjectExecutionParameter.saveParentTasks(execution);
				logger.info("valuess===========" + values);
				if (execution.get(0).getExecutionId() != null && execution.get(0).getExecutionId() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
							.setParameter("actionType", "modifyParentexecution").setParameter("actionValue", values)
							.getResultList();
					try {
						for (Object[] m : x) {

							RestProjectExecutionModel dropDownModel = new RestProjectExecutionModel(m[0], m[1]);
							listData.add(dropDownModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
							.setParameter("actionType", "addParentexecution").setParameter("actionValue", values)
							.getResultList();
					try {
						for (Object[] m : x) {

							RestProjectExecutionModel dropDownModel = new RestProjectExecutionModel(m[0], m[1]);
							listData.add(dropDownModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
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

		} catch (

		Exception e) {
			logger.info("addSchemeToVle: " + e);
			try {
				String[] err = serverDao.errorProcedureCall(e);

				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> response = new ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveProjectExecutionsParent Dao ends");
		return response;
	}

	// edit Parent

	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> getProjectParentEditDao(String id, String exeId, String userid, String org,
			String div) {

		logger.info("Method : getProjectParentEdit Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_catId='" + id + "',@p_excId='" + exeId + "',@p_userId='" + userid + "',@p_org='"
					+ org + "',@p_orgDiv='" + div + "';";

			logger.info("values****************************PrentEdit" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "getParentEdit").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getProjectParentEdit Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	// edit Child

	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> getProjectChildEditDao(String id, String exeId, String userid, String org, String div) {

		logger.info("Method : getProjectChildEditDao Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_catId='" + id + "',@p_excId='" + exeId + "',@p_userId='" + userid + "',@p_org='"
					+ org + "',@p_orgDiv='" + div + "';";

			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "getChildEdit").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getProjectChildEditDao Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<RestProjectExecutionModel>>
	 * getProjectChildEditDao(String id, String pid, String userId, String orgName,
	 * String orgDiv) { logger.info("Method : getProjectChildEditDao Dao starts");
	 * RestProjectExecutionModel resp = new RestProjectExecutionModel();
	 * JsonResponse<RestProjectExecutionModel> jsonResponse = new
	 * JsonResponse<RestProjectExecutionModel>(); try { String value =
	 * "SET @P_PCategory='" + id + "', @p_id='" + pid + "', @p_userId='" + userId +
	 * "', @p_orgName='" + orgName + "', @p_orgDiv='" + orgDiv + "' ;";
	 * logger.info("baluew" + value); List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("projectExceutionRoutines")
	 * .setParameter("actionType", "getChildEdit").setParameter("actionValue",
	 * value).getResultList(); for (Object[] m : x) { RestProjectExecutionModel item
	 * = new RestProjectExecutionModel(m[0], m[1], null, null, m[2], null, m[3],
	 * m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],
	 * m[16], m[17], m[18], m[19], m[20], m[22]); resp = item;
	 * System.out.println("X ::" + item); } System.out.println("X ::" + x); if
	 * (x.size() > 0) { jsonResponse.setBody(resp); jsonResponse.setCode("success");
	 * jsonResponse.setMessage(ApiResponseMessage.DATA_FETCH_SUCCESS); } else {
	 * jsonResponse.setCode("failed");
	 * jsonResponse.setMessage(ApiResponseMessage.NO_DATA_FOUND); } } catch
	 * (Exception e) { e.printStackTrace(); Util.setJsonResponse(jsonResponse, null,
	 * ResponseStatus.failed, e.getMessage()); logger.error(e.getMessage()); }
	 * ResponseEntity<JsonResponse<RestProjectExecutionModel>> response = new
	 * ResponseEntity<JsonResponse<RestProjectExecutionModel>>( jsonResponse,
	 * HttpStatus.OK); logger.info("Method : getProjectChildEditDao Dao ends" +
	 * response); return response; }
	 */

	// add task detail

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveTaskDetails(List<RestProjectExecutionModel> execution) {
		logger.info("Method in Dao: saveTaskDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		// resp.setMessage("");
		// resp.setCode("");
		try {
			String values = GenerateProjectExecutionParameter.AddTaskDetail(execution);
			logger.info("values===" + values);
			if (execution.get(0).getSlNo() == "" || execution.get(0).getSlNo() == null) {

				em.createNamedStoredProcedureQuery("projectExceutionRoutines")
						.setParameter("actionType", "saveTaskDetails").setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("projectExceutionRoutines")
						.setParameter("actionType", "modifyTaskDetails").setParameter("actionValue", values).execute();
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
		if (resp.getMessage() == null) {
			resp.setMessage("Saved successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: saveTaskDetails ends");

		return response;
	}
	// view task detail

	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> getProjectTaskDetailsDao(String id, String userid, String org, String div) {

		logger.info("Method : getProjectTaskDetails Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_catId='" + id + "',@p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div
					+ "';";

			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "viewTaskDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getProjectTaskDetails Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	// edit editTaskDetails

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<RestProjectExecutionModel>>
	 * editTaskDetails(String id) {
	 * logger.info("Method : editTaskDetails Dao starts" + id);
	 * 
	 * JsonResponse<RestProjectExecutionModel> resp = new
	 * JsonResponse<RestProjectExecutionModel>(); List<RestProjectExecutionModel>
	 * newLoc = new ArrayList<RestProjectExecutionModel>();
	 * 
	 * try { String value = "SET @p_slNo='" + id + "';"; logger.info("baluew" +
	 * value); List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("projectExceutionRoutines")
	 * .setParameter("actionType", "editTaskDetails").setParameter("actionValue",
	 * value).getResultList(); for (Object[] m : x) {
	 * 
	 * RestProjectExecutionModel item = new
	 * RestProjectExecutionModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5],
	 * m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],
	 * m[16],m[17],null); newLoc.add(item); }
	 * 
	 * resp.setBody(newLoc.get(0)); } catch (Exception e) { try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); }
	 * e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<RestProjectExecutionModel>> response = new
	 * ResponseEntity<JsonResponse<RestProjectExecutionModel>>( resp,
	 * HttpStatus.CREATED); logger.info("Method : editTaskDetails Dao ends"); return
	 * response; }
	 */

	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> editTaskDetails(String id, String id2, String userid, String org, String div) {

		logger.info("Method : editTaskDetails Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_catId='" + id + "',@p_excId='" + id2 + "',@p_userId='" + userid + "',@p_org='" + org
					+ "',@p_orgDiv='" + div + "';";

			logger.info("values****************************PrentEdit" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "editTaskDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : editTaskDetails Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	// delete task

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> deleteTaskDetails(String id) {
		logger.info("Method : deleteTaskDetails dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {

				String value = "SET @p_slNo='" + id + "';";

				em.createNamedStoredProcedureQuery("projectExceutionRoutines")
						.setParameter("actionType", "deleteTaskDetails").setParameter("actionValue", value).execute();

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

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  deleteTaskDetails dao ends");
		return response;
	}

	// auto search

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPrecedAutoSearchList(String id, String projectId) {
		logger.info("Method : getPrecedAutoSearchList dao starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_projectId='" + projectId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "getPreced").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getPrecedAutoSearchList dao ends");
		return response;
	}
	// auto search

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssignedToAutoSearchList(String id) {
		logger.info("Method : getAssignedToAutoSearchList dao starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "getAssignedTo").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (itemNameList.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
			resp.setBody(itemNameList);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAssignedToAutoSearchList dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPrecedDates(String id) {
		logger.info("Method : getPrecedDates dao starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_nodeSlNo='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "getDates").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getPrecedDates dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestProjectExecutionModel>> gettaskdetail(String id, String pid) {
		logger.info("Method : gettaskdetail Dao starts" + id);

		JsonResponse<RestProjectExecutionModel> resp = new JsonResponse<RestProjectExecutionModel>();
		List<RestProjectExecutionModel> newLoc = new ArrayList<RestProjectExecutionModel>();

		try {
			String value = "SET @p_categoryId='" + id + "', @p_executionId='" + pid + "';";
			logger.info("baluew" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "gettaskdetail").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestProjectExecutionModel item = new RestProjectExecutionModel(null, m[0], m[1], m[2], m[3], m[4], null,
						null, m[5], m[6], m[7], null, m[8], null, null, null, null, null, m[9]);
				newLoc.add(item);
			}

			resp.setBody(newLoc.get(0));
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

		ResponseEntity<JsonResponse<RestProjectExecutionModel>> response = new ResponseEntity<JsonResponse<RestProjectExecutionModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : gettaskdetail Dao ends");
		return response;
	}

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>>
	 * getFromPlanning(String id) { logger.info("Method : getFromPlanning starts" +
	 * id);
	 * 
	 * JsonResponse<List<RestProjectExecutionModel>> resp = new
	 * JsonResponse<List<RestProjectExecutionModel>>();
	 * List<RestProjectExecutionModel> newLoc = new
	 * ArrayList<RestProjectExecutionModel>();
	 * 
	 * try { String value = "SET @p_projectId='" + id + "';";
	 * System.out.println("vauess" + value); List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("projectExceutionRoutines")
	 * .setParameter("actionType", "getFromPlanning").setParameter("actionValue",
	 * value) .getResultList(); for (Object[] m : x) {
	 * 
	 * RestProjectExecutionModel item = new RestProjectExecutionModel(m[0], m[1],
	 * null, null, m[2], null, null, null, null, null, null, null, null, null, null,
	 * null, null, null, null, null, null, null, null, null, null);
	 * newLoc.add(item); }
	 * 
	 * resp.setBody(newLoc); } catch (Exception e) { try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); }
	 * e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> response = new
	 * ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>>( resp,
	 * HttpStatus.CREATED);
	 * 
	 * logger.info("Method : getFromPlanning ends" + response.getBody()); return
	 * response; }
	 */

	public ResponseEntity<JsonResponse<Object>> getFromPlanning(String id, String userId, String org, String div) {
		logger.info("Method : getFromPlanning starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String value = "SET @p_projectId='" + id + "',@p_userId='" + userId + "',@p_org='" + org
						+ "',@p_orgDiv='" + div + "';";

				em.createNamedStoredProcedureQuery("projectExceutionRoutines")
						.setParameter("actionType", "getFromPlanning").setParameter("actionValue", value).execute();

				// Util.setJsonResponse(resp, x.get(0), ResponseStatus.success,
				// ApiResponseMessage.DATA_FETCH_SUCCESS);
			} catch

			(Exception e) {
				String[] err = serverDao.errorProcedureCall(e);
				logger.error("Error " + err[1]);
				e.printStackTrace();
				// Util.setJsonResponse(resp, null, ResponseStatus.failed,
				// ApiResponseMessage.NO_DATA_FOUND);
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :  getFromPlanning ends");
		return response;
	}

////////////////////////////////////API////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestProjectExecutionModel>> getexectuionParentchildData(String id, String userId,
			String org, String div) {
		logger.info("Method : getexectuionParentchildData starts");
		JsonResponse<List<RestProjectExecutionModel>> resp = new JsonResponse<List<RestProjectExecutionModel>>();
		List<RestProjectExecutionModel> getparentData = new ArrayList<RestProjectExecutionModel>();
		List<RestProjectCategoryModel> subCategoryList = new ArrayList<RestProjectCategoryModel>();
		try {
			String value = "SET @p_projectId='" + id + "',@p_userId='" + userId + "',@p_org='" + org + "',@p_orgDiv='"
					+ div + "';";
			logger.info("bbbbbvvvvaaaa" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "getparentdataApi").setParameter("actionValue", value).getResultList();
			try {
				for (Object[] m : x) {

					RestProjectExecutionModel item = new RestProjectExecutionModel(m[0], m[1], null, null, m[2], null,
							m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19], m[20], m[21], null);
					getparentData.add(item);
					logger.info("print edit" + getparentData);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_projectId='" + id + "',@p_userId='" + userId + "',@p_org='" + org
						+ "',@p_orgDiv='" + div + "',@p_parentId='" + getparentData.get(0).getParentId() + "';";

				// String subValues = "SET @p_parentId='" + getparentData.get(0).getParentId() +
				// "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
						.setParameter("actionType", "getChildDataApi").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					RestProjectCategoryModel itemChild = new RestProjectCategoryModel(m[0], m[1], null, null, m[2],
							null, m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],
							m[16], m[17], m[18], m[19], m[20], m[21]);
					subCategoryList.add(itemChild);
				}
			} catch (Exception e) {

			}

			getparentData.get(0).setCategoryNameList(subCategoryList);
			resp.setBody(getparentData);
			if (resp.getBody().size() > 0) {
				resp.setCode("Success");
				resp.setMessage("Data Fetched Successfully");
			} else {
				resp.setCode("Failed");
				resp.setMessage("Data Not Found");
			}

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}

		logger.info("@@@@@@@@edit" + resp);
		logger.info("Method : getexectuionParentchildData ends");
		return resp;
	}

	// Add exxecution

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveexecutionApi(RestProjectExecutionModel execution) {
		logger.info("Method : saveexecutionApi Dao starts" + execution);

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<RestProjectExecutionModel> listData = new ArrayList<RestProjectExecutionModel>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String values = GenerateProjectExecutionParameter.savePrrojectExecutionTasksApi(execution);
			logger.info("values=====" + execution);
			if (!StringUtil.isNull(execution.getExecutionId())) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
						.setParameter("actionType", "modifySubexecution").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {

						RestProjectExecutionModel dropDownModel = new RestProjectExecutionModel(m[0], m[1]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				logger.info("values=====ADDD==============================" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
						.setParameter("actionType", "addSubexecution").setParameter("actionValue", values)
						.getResultList();

				try {
					for (Object[] m : x) {

						RestProjectExecutionModel dropDownModel = new RestProjectExecutionModel(m[0], m[1]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			resp.setCode("Success");
			resp.setMessage("Data Saved Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getLocalizedMessage());

		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveexecutionApi Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> requisitionData(String id, String orgName, String orgDiv) {

		logger.info("Method : requisitionData starts");
		List<DropDownModel> referenceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		// String value = "SET @p_vendorId='" + id + "';";
		String value = "SET @p_projectId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "getReqData").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				referenceList.add(dropDownModel);
			}
			resp.setBody(referenceList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : requisitionData ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProjectDetails(String projectIdReq, String orgName, String orgDiv) {
		logger.info("Method : getProjectDetails starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();

		try {
			String values = "SET @p_projectIdReq='" + projectIdReq + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			logger.info("values" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "getProjectDetails").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : getProjectDetails ends");
		return getRequisitionTypeList;
	}
	/*
	 * @SuppressWarnings("unchecked") public List<RestPurchaseOrderModel>
	 * requisitionDataProject(String id) {
	 * logger.info("Method : requisitionDataProject starts");
	 * List<RestPurchaseOrderModel> referenceList = new
	 * ArrayList<RestPurchaseOrderModel>();
	 * JsonResponse<List<RestPurchaseOrderModel>> resp = new
	 * JsonResponse<List<RestPurchaseOrderModel>>();
	 * 
	 * // String value = "SET @p_vendorId='" + id + "';"; String value =
	 * "SET @p_projectId='" + id +"';"; logger.info("++++++++++++++++++++++++++" +
	 * value); try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("projectExceutionRoutines")
	 * .setParameter("actionType",
	 * "requisitionDataProject").setParameter("actionValue", value).getResultList();
	 * for (Object[] m : x) { RestPurchaseOrderModel dropDownModel = new
	 * RestPurchaseOrderModel(m[0], m[1]); referenceList.add(dropDownModel); }
	 * resp.setBody(referenceList); } catch (Exception e) { e.printStackTrace(); }
	 * logger.info("Method : requisitionDataProject ends"); return referenceList; }
	 */

	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> getplanningList(String id, String userid, String org, String div) {

		logger.info("Method : getplanningList Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_projectIds='" + id + "',@p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='"
					+ div + "';";

			logger.info("valuesExecution" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "getplanningList").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getplanningList Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	// FOR PROJECT Monitoring DAO VIEW STARTS
	@SuppressWarnings("unchecked")

	public JsonResponse<Object> monitoringViewDao(String userid, String org, String div, String id) {

		logger.info("Method : monitoringViewDao Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_id='" + id
					+ "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "viewMonitoringDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : monitoringViewDao Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	// For Req View

	@SuppressWarnings("unchecked")

	public JsonResponse<Object> viewProjectRequision(String userid, String org, String div, String id) {

		logger.info("Method : viewProjectRequision Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_id='" + id
					+ "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "viewProjectRequision").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewProjectRequision Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	// For Po View

	@SuppressWarnings("unchecked")

	public JsonResponse<Object> viewProjectPoDao(String userid, String org, String div, String id) {

		logger.info("Method : viewProjectPo Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_id='" + id
					+ "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "viewProjectPo").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewProjectPo Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	// For Po View

	@SuppressWarnings("unchecked")

	public JsonResponse<Object> viewProjectGrnDao(String userid, String org, String div, String id) {

		logger.info("Method : viewProjectGrn Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_id='" + id
					+ "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "viewProjectGrn").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewProjectGrn Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> ganttChartList(String id, String userid, String org, String orgDivision) {

		logger.info("Method : ganttChartList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_projectIds='" + id + "',@p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='"
					+ orgDivision + "';";

			logger.info("valuesExecution" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "getGanttChartDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : ganttChartList Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	
	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> saveTaskComments(ProjectMessageModel data) {
		logger.info("Method : saveTaskComments Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			
			String value = "SET @p_task_id='" + data.getTaskid() + "',@p_user_id='" + data.getUserid() 
			+ "',@p_msg='" + data.getMessage() + "',@p_date='" + data.getDate() + "',@p_time='" + data.getTime() 
			+ "',@p_org='" + data.getOrg() + "',@p_org_div='" + data.getOrgdiv() + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "saveTaskComments").setParameter("actionValue", value)
					.getResultList();
			
			if(x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("Method : saveTaskComments Dao ends");
		return resp;
		
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getProjectBillPdfView(String id, String userid, String orgName, String div) {
		logger.info("Method : getProjectBillPdfView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_projectId='" +id + "',@p_userId='" + userid +"',@p_orgName='" + orgName +  "',@p_orgDiv= '" +div+"';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectExceutionRoutines")
					.setParameter("actionType", "viewProjectBill").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getProjectBillPdfView Dao ends");
		logger.info("resp**********" + resp);
		return resp;

	}
}
