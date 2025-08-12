package nirmalya.aatithya.restmodule.asset.dao;

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
import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetPolicyParams;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AssetPolicyDao {
	Logger logger = LoggerFactory.getLogger(AssetPolicyDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// getShiftListsAllocation
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCategoryListforAsset(String org, String orgDiv, String userId) {
		logger.info("Method : getEmployeeListforAsset starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		System.out.println("PARAM VALUE::::"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getCatList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeListforAsset ends");
		return getCollectionList;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCategoryListforSparePart(String org, String orgDiv, String userId) {
		logger.info("Method : getCategoryListforSparePart starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getCatListSpare").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCategoryListforSparePart ends");
		return getCollectionList;
	}

	// getShiftListsAllocation
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPriorityList(String org, String orgDiv, String userId) {
		logger.info("Method : getPriorityList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getPriorityList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPriorityList ends");
		return getCollectionList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSourceList(String org, String orgDiv, String userId) {
		logger.info("Method : getSourceList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getSourceList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSourceList ends");
		return getCollectionList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUOMList(String org, String orgDiv, String userId) {
		logger.info("Method : getUOMList starts");

		List<DropDownModel> getUOMList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getUOMList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getUOMList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getUOMList ends");
		return getUOMList;
	}

	// getSubCategory
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSubCategory(String id, String orgName, String orgDivision) {
		logger.info("Method : getSubCategory Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_catId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getSubCategory").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSubCategory Dao ends");
		return resp;
	}

	// getSubCategoryForSpare
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSubCategoryForSpare(String id, String orgName, String orgDivision) {
		logger.info("Method : getSubCategoryForSpare Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_catId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("CATEGORYID------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getSubCatSpare").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSubCategoryForSpare Dao ends");
		return resp;
	}
	
	// addAssetPolicy 
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addAssetPolicy(List<AssetPoilcyRestModel> av) {
		logger.info("Method : addAssetPolicy dao starts");
		JsonResponse<List<AssetPoilcyRestModel>> resp = new JsonResponse<List<AssetPoilcyRestModel>>();

		String value = GenerateAssetPolicyParams.getAddAssetPolicy(av);
		try {

			if (av.get(0).getPolicyid() != null && av.get(0).getPolicyid() != "") {

				em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "modifyPolicy").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("asset_mstr_policy_routines").setParameter("actionType", "addPolicy")
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

		ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> response = new ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addAssetPolicy dao ends");
		return response;

	}

	// viewAssetPolicy
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAssetPolicy(String orgName, String orgDivision,String userId) {
		logger.info("Method : viewAssetPolicy Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "viewAssetPolicy").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAssetPolicy Dao ends");
		return resp;

	}

	// editPolicy
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editAssetPolicy(String id, String orgName, String orgDivision) {
		logger.info("Method : editAssetPolicy Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_policyId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "editAssetPolicy").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAssetPolicy Dao ends");
		return resp;
	}

	// deleteAssetPolicy
	public ResponseEntity<JsonResponse<Object>> deleteAssetPolicy(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteAssetPolicy starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_policyId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "deleteAssetPolicy").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Policy Deleted Successfully");
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

		logger.info("Method : deleteAssetPolicy ends");
		return response;
	}

	// approveAssetPolicy
	public ResponseEntity<JsonResponse<Object>> approveAssetPolicy(String id, String orgName, String orgDivision) {
		logger.info("Method : approveAssetPolicy starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_policyId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "approveAssetPolicy").setParameter("actionValue", value).execute();
				resp.setMessage("Policy Approved Successfully");
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

	// getShiftListsAllocation
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCategoryListforAssetApi(String org, String orgDiv,
			String userId) {
		logger.info("Method : getEmployeeListforAsset starts");

		List<DropDownModel> getCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getCatList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCategoryList.add(dropDownModel);
			}
			if (getCategoryList.size() > 0) {
				Util.setJsonResponse(resp, getCategoryList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getCategoryList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getEmployeeListforAsset ends");
		return response;
	}

	// getShiftListsAllocation
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPriorityListApi(String org, String orgDiv,
			String userId) {
		logger.info("Method : getPriorityList starts");

		List<DropDownModel> getPriorityList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getPriorityList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getPriorityList.add(dropDownModel);
			}
			if (getPriorityList.size() > 0) {
				Util.setJsonResponse(resp, getPriorityList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getPriorityList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPriorityList ends");
		return response;
	}

	// getSubCategoryListforAssetApi
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubCategoryListforAssetApi(String catid, String org,
			String orgDiv, String userId) {
		logger.info("Method : getSubCategoryListforAssetApi starts");

		List<DropDownModel> getCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_catid='" + catid + "',@p_orgDiv='" + orgDiv + "',@p_userId='"
				+ userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getSubCatList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCategoryList.add(dropDownModel);
			}
			if (getCategoryList.size() > 0) {
				Util.setJsonResponse(resp, getCategoryList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getCategoryList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSubCategoryListforAssetApi ends");
		return response;
	}

	// Search
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetPolicyViewSearch(String orgName, String orgDivision, String searchValue) {
		logger.info("Method : assetPolicyViewSearch Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_Svalue='" + searchValue
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "assetPolicySearch").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : assetPolicyViewSearch Dao ends");
		return resp;

	}
	// viewPropertyPolicy
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewPropertyPolicy(String orgName, String orgDivision,String userId) {
			logger.info("Method : viewPropertyPolicy Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
				System.out.println("VALUE@@@@@-----------"+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "viewPropertyPolicy").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewPropertyPolicy Dao ends"+resp);
			return resp;

		}
//
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubCategoryListApi(String id, String orgName,
				String orgDivision) {
			logger.info("Method : getSubCategoryListApi starts");

			List<DropDownModel> getCategoryList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
			String value = "SET @p_org='" + orgName + "',@p_catid='" + id + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("@@@@__________________________--"+value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "getSubCategoryApi").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2].toString());
					getCategoryList.add(dropDownModel);
				}
				if (getCategoryList.size() > 0) {
					Util.setJsonResponse(resp, getCategoryList, ResponseStatus.success,
							ApiResponseMessage.DATA_FETCH_SUCCESS);
				} else {
					Util.setJsonResponse(resp, getCategoryList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : getSubCategoryListApi ends"+response);
			return response;
		}

		@SuppressWarnings("unchecked")
		public List<DropDownModel> getEmployeeListforAssentAssign(String org, String orgDiv, String userId) {
			logger.info("Method : getEmployeeListforJobview starts");

			List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
			System.err.println("value===="+value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value).getResultList();

		//		System.err.println("dropDownModel===="+x.get(0));
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
					getCollectionList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getEmployeeListforJobview ends");
			System.err.println("getCollectionList===="+getCollectionList);
			return getCollectionList;
		}

		public ResponseEntity<JsonResponse<AssetPoilcyRestModel>> addAssetPolicyData(AssetPoilcyRestModel av) {
			logger.info("Method : addAssetPolicy dao starts");
			JsonResponse<AssetPoilcyRestModel> resp = new JsonResponse<AssetPoilcyRestModel>();
			String value = GenerateAssetPolicyParams.addAssetPolicyData(av);
			try {
				if (av.getPolicyid() != null && av.getPolicyid() != "") {
					em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
							.setParameter("actionType", "modifyPolicyMain").setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Policy Modified Successfully");
				} else {
					em.createNamedStoredProcedureQuery("asset_mstr_policy_routines").setParameter("actionType", "addPolicyMain")
							.setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Policy saved Successfully");
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
			ResponseEntity<JsonResponse<AssetPoilcyRestModel>> response = new ResponseEntity<JsonResponse<AssetPoilcyRestModel>>(resp, HttpStatus.CREATED);
			logger.info("Method : addAssetPolicy dao ends");
			return response;
		}

		public ResponseEntity<JsonResponse<AssetPoilcyRestModel>> addPolicyCheckList(AssetPoilcyRestModel av) {
			logger.info("Method : addPolicyCheckList dao starts");
			JsonResponse<AssetPoilcyRestModel> resp = new JsonResponse<AssetPoilcyRestModel>();
			String value = GenerateAssetPolicyParams.addPolicyCheckListData(av);
			System.err.println("value======"+value);
			try {
				if (av.getTaskId() != null && av.getTaskId() != "") {
					em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
							.setParameter("actionType", "modifyCheckList").setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Policy Checklist Modified Successfully");
				} else {
					em.createNamedStoredProcedureQuery("asset_mstr_policy_routines").setParameter("actionType", "addCheckList")
							.setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Policy Checklist Saved Successfully");
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
			ResponseEntity<JsonResponse<AssetPoilcyRestModel>> response = new ResponseEntity<JsonResponse<AssetPoilcyRestModel>>(resp, HttpStatus.CREATED);
			logger.info("Method : addPolicyCheckList dao ends");
			return response;
		}
		// deletePolicyCheckList
		public ResponseEntity<JsonResponse<Object>> deletePolicyCheckList(String id, String orgName, String orgDivision) {
			logger.info("Method : deletePolicyCheckList starts");
			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			if (validity)
				try {
					String value = "SET @p_taskid='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
							.setParameter("actionType", "deleteCheckList").setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Policy CheckList Deleted Successfully");
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
			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,HttpStatus.CREATED);
			logger.info("Method : deletePolicyCheckList ends");
			return response;
		}
}
