package nirmalya.aatithya.restmodule.edms.dao;

import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.util.Util;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.edms.GenerateWorkSpaceParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.StringUtil;
import nirmalya.aatithya.restmodule.edms.model.RestWorkSpaceModel;
import nirmalya.aatithya.restmodule.common.ServerDao;

@Repository
public class RestWorkspaceDao {
	Logger logger = LoggerFactory.getLogger(RestWorkspaceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;  

	@SuppressWarnings("unchecked")
	public List<DropDownModel> fileAccessType() {
		logger.info("Method : fileAccessType Dao starts");

		List<DropDownModel> CatogaryList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "fileAccessType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				logger.info(dropDownModel.toString());
				CatogaryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : fileAccessType Dao ends");
		return CatogaryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> fileOperationType() {
		logger.info("Method : fileOperationType Dao starts");

		List<DropDownModel> CatogaryList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "fileOperationType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				logger.info(dropDownModel.toString());
				CatogaryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : fileOperationType Dao ends");
		return CatogaryList;
	}

	public ResponseEntity<JsonResponse<Object>> saveWorkspaceModel(RestWorkSpaceModel empDetaails) {
		logger.info("Method : saveWorkspaceModel dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateWorkSpaceParam.getWorkspaceParam(empDetaails);
			if (empDetaails.getWorkspaceId() == null || empDetaails.getWorkspaceId() == "") {
				em.createNamedStoredProcedureQuery("workspaceRoutines").setParameter("actionType", "addWorkSpace")
						.setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("workspaceRoutines").setParameter("actionType", "modifyDetails")
						.setParameter("actionValue", values).execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveWorkspaceModel dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewWorkSpace(String userId, String orgName, String orgDiv) {
		logger.info("Method : viewWorkSpace Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "viewWorkspace").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewWorkSpace Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editWorkSpace(String workSpaceId, String userId, String orgName, String orgDiv) {
		logger.info("Method : editWorkSpace Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_workId='" + workSpaceId + "' ,@p_userId='" + userId + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "editWorkSpace").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editWorkSpace Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> deleteWorksapce(String workSpaceId, String userId, String orgName, String orgDivision) {
		logger.info("Method : deleteWorksapce Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String value = "SET @p_workSpaceId='" + workSpaceId + "',@p_userId='"+userId+"',@p_orgName='"+orgName+"',@p_orgDivision='"+orgDivision+"';";
		System.out.println(value);
		try {

			em.createNamedStoredProcedureQuery("workspaceRoutines").setParameter("actionType", "deleteworkspace")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteWorksapce Dao ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> parentFolder() {
		logger.info("Method : parentFolder Dao starts");

		List<DropDownModel> parentFolder = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "parentFolder").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1],m[2]);
				logger.info(dropDownModel.toString());
				parentFolder.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : parentFolder Dao ends" + parentFolder);
		return parentFolder;
	}

	// Workspace Add

	public ResponseEntity<JsonResponse<Object>> getWorkspaceAdd(String itm, String workSpaceId) {
		logger.info("Method : getWorkspaceAdd dao starts" + itm);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			if (!StringUtil.isNull(workSpaceId)) {
				String value = "SET @workSpaceId='" + workSpaceId + "',@itm='" + itm + "';";
				System.out.println("Updated Seert ID: " + workSpaceId);
				em.createNamedStoredProcedureQuery("workspaceRoutines").setParameter("actionType", "modifyWorkspace")
						.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Updated successfully");

			} else {
				String value = "SET @workSpaceId='" + workSpaceId + "',@itm='" + itm + "';";
				System.out.println("VALUE"+value);
				em.createNamedStoredProcedureQuery("workspaceRoutines").setParameter("actionType", "addWorkspace")
						.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Added successfully");
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : getWorkspaceAdd dao ends");
		return response;

	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> chooseFolderType() {
		logger.info("Method : chooseFolderType Dao starts");

		List<DropDownModel> chooseFolderType = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "chooseFolderType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString(),m[2].toString());
				logger.info(dropDownModel.toString());
				chooseFolderType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : chooseFolderType Dao ends" + chooseFolderType);
		return chooseFolderType;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getUserAutoSearch(String id,String type) {
		logger.info("Method : getUserAutoSearch dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_searchValue='" + id + "',@p_type='"+type+"';";
		System.out.println("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "getUserNameAutoSearch").setParameter("actionValue", value).getResultList();
		
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getUserAutoSearch dao ends");
		System.out.println("AUTODATAAA" + response);
		return response;
	}
	
	// employee list cc
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getEmployeeList(String orgName, String orgDivision, String userId) {
			logger.info("Method : getEmployeeList starts");

			List<DropDownModel> emplist = new ArrayList<DropDownModel>();

			try {
				String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\",@p_userId=\"" + userId + "\";";
				List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
						.setParameter("actionType", "getEmployeeLists").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					emplist.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getEmployeeList ends" + emplist);
			return emplist;
		}
		
		// AutoSearch

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getAutosearchUser(String id,String userId,String orgName,String orgDiv) {
			logger.info("Method : getAutosearchUser starts");
			List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
			String value = "SET @p_searchValue='" + id + "',@p_userId='" + userId + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			try {
				logger.info("VALUE" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
						.setParameter("actionType", "autosearchUser").setParameter("actionValue", value)
						.getResultList();
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

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}

			logger.info("Method : getAutosearchUser ends");
			logger.info("AUTODATAAA" + response);
			return response;
		}
		
		// AutoSearch Group

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<List<DropDownModel>>> getAutosearchGroup(String id,String userId) {
					logger.info("Method : getAutosearchGroup starts");
					List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
					JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
					String value = "SET @p_searchValue='" + id + "',@p_userId='" + userId + "';";

					try {
						logger.info("VALUE" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
								.setParameter("actionType", "autosearchGroup").setParameter("actionValue", value)
								.getResultList();
						for (Object[] m : x) {
							DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
							itemNameList.add(dropDownModel);
						}
						resp.setBody(itemNameList);
					} catch (Exception e) {
						e.printStackTrace();
					}
					ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
							resp, HttpStatus.CREATED);

					if (resp.getMessage() == null) {
						resp.setMessage("View successfully");
					}

					if (resp.getCode() == null) {
						resp.setCode("Success");
					}

					logger.info("Method : getAutosearchGroup ends"+response);
					return response;
				}
}
