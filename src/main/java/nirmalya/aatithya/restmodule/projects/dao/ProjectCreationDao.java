package nirmalya.aatithya.restmodule.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.model.ShiftScheduleApiModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectCreationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectFileuploadModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectShippingModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository

public class ProjectCreationDao {

	Logger logger = LoggerFactory.getLogger(ProjectCreationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// FOR PROJECT CREATION DAO ADD STARTS

	public ResponseEntity<JsonResponse<Object>> restaddPrjCreationDao(List<ProjectCreationRestModel> prjCreation) {

		logger.info("Method in Dao: restaddPrjCreationDao starts"+prjCreation);

		// Print the received MonitoringControl object
		System.out.println("Received PrjCreation ADDD: ");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {

			String values = GenerateProjectCreationParameter.getPrjCreateParam(prjCreation);
			System.out.println(values);
			if (prjCreation.get(0).getProjectId() != "" && prjCreation.get(0).getProjectId() != null) {

				em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
						.setParameter("actionType", "modifyProjectCreation").setParameter("actionValue", values)
						.execute();

			} else {

				em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
						.setParameter("actionType", "addProjectCreation").setParameter("actionValue", values).execute();

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

		logger.info("Method in Dao: restaddPrjCreationDao ends");

		return response;
	}

	// FOR PROJECT CREATION DAO ADD ENDS

	// FOR PROJECT CREATION DAO VIEW STARTS
	@SuppressWarnings("unchecked")

	public JsonResponse<Object> viewProject(String userid, String org, String div) {

		logger.info("Method : viewProject Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "viewProjectCreation").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewProject Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	// FOR PROJECT CREATION DAO VIEW ENDS

	// FOR PROJECT CREATION EDIT
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ProjectCreationRestModel>> editProject(String id) {
		logger.info("Method : viewProjectEdit starts");
		System.out.println("RestDeliveryChallanModel" + id);
		JsonResponse<ProjectCreationRestModel> resp = new JsonResponse<ProjectCreationRestModel>();
		List<ProjectCreationRestModel> getRequisitionTypeList = new ArrayList<ProjectCreationRestModel>();
		List<RestProjectFileuploadModel> docList = new ArrayList<RestProjectFileuploadModel>();
		List<RestProjectShippingModel> shippingList = new ArrayList<RestProjectShippingModel>();
		List<RestProjectShippingModel> productList = new ArrayList<RestProjectShippingModel>();

		try {
			String values = "SET @p_projectId='" + id + "';";
			System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "getProductDataById").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				ProjectCreationRestModel dropDownModel = new ProjectCreationRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18],
						m[19], m[20], m[21], m[22],m[23]);

				System.out.println("print edit" + getRequisitionTypeList);
				getRequisitionTypeList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (getRequisitionTypeList.size() > 0) {
			try {
				String subValues = "SET @p_projectId='" + id + "';";
				// System.out.println(subValues);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
						.setParameter("actionType", "getProjectdocs").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					RestProjectFileuploadModel dropDownModel = new RestProjectFileuploadModel(m[0], m[1], m[2]);
					docList.add(dropDownModel);
					System.out.println(docList);
				}
				getRequisitionTypeList.get(0).setDocumentList(docList);

			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				String subValues = "SET @p_projectId='" + id + "';";
				System.out.println(subValues);
				List<Object[]> x2 = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
						.setParameter("actionType", "getShippingDetails").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x2) {

					RestProjectShippingModel dropDownModel = new RestProjectShippingModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
					// docList.add(dropDownModel);

					shippingList.add(dropDownModel);
				}
				getRequisitionTypeList.get(0).setShippingList(shippingList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			try {
				String subValues = "SET @p_projectId='" + id + "';";
				System.out.println(subValues);
				List<Object[]> x2 = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
						.setParameter("actionType", "editProjectProduct").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x2) {

					RestProjectShippingModel dropDownModel = new RestProjectShippingModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7]);

					productList.add(dropDownModel);
				}
				getRequisitionTypeList.get(0).setProductList(productList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		resp.setBody(getRequisitionTypeList.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<ProjectCreationRestModel>> response = new ResponseEntity<JsonResponse<ProjectCreationRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editProductInfo ends");
		System.out.println("response in edit product-------------" + response);
		return response;
	}

	// FOR PROJECT CREATION DELETE

	public ResponseEntity<JsonResponse<Object>> deleteProjectCreation(String id) {
		logger.info("Method : deleteProjectCreation starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_projectId='" + id + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
						.setParameter("actionType", "deleteProCre").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteProjectCreation ends");
		return response;
	}

	/* billing country drop down */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryListForBillingDao() {
		logger.info("Method : getCountryListForBillingDao starts");

		List<DropDownModel> locationTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "getBillingCountryList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForBillingDao ends");
		return locationTypeList;
	}

	/* billing state drop down */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateNameForBillingDao(String id) {
		logger.info("Method : getStateNameForBillingDao starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country='" + id + "';";

		System.out.println("########" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "getBillingStateList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}
			resp.setBody(stateList);
			if (stateList.size() > 0) {
				Util.setJsonResponse(resp, stateList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, stateList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getStateNameForBiddingDao ends");
		return response;
	}

	/* shipping country drop down */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryListForShippingDao() {
		logger.info("Method : getCountryListForShippingDao starts");

		List<DropDownModel> locationTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "getShippingCountryList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForShippingDao ends");
		return locationTypeList;
	}

	/* shipping state drop down */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateNameForShippingDao(String id) {
		logger.info("Method : getStateNameForShippingDao starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country1='" + id + "';";

		System.out.println("########" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "getShippingStateList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}
			resp.setBody(stateList);
			if (stateList.size() > 0) {
				Util.setJsonResponse(resp, stateList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, stateList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getStateNameForShippingDao ends");
		return response;
	}

	// For project country drop down

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryListForProjectDao() {
		logger.info("Method : getCountryListForProjectDao starts");

		List<DropDownModel> locationTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "getprojectCountryList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForProjectDao ends");
		return locationTypeList;
	}

	// For project state drop down

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateNameForProjectDao(String id) {
		logger.info("Method : getStateNameForProjectDao starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country2='" + id + "';";

		System.out.println("########" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "getprojectStateList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}
			resp.setBody(stateList);
			if (stateList.size() > 0) {
				Util.setJsonResponse(resp, stateList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, stateList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getStateNameForProjectDao ends");
		return response;
	}

	// project sate list on edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getProjectStateListDao(String id) {

		logger.info("Method : getProjectStateListDao starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "getProjectStateLists").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getProjectStateListDao ends");
		return response;
	}

	// billing state list on edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBillingStateListDao(String id) {

		logger.info("Method : getBillingStateListDao starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "getBillingStateLists").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getBillingStateListDao ends");
		return response;
	}

	// shipping state list on edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getShippingStateListDao(String id) {

		logger.info("Method : getShippingStateListDao starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "getShippingStateLists").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getShippingStateListDao ends");
		return response;
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
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

	// For PO View

	@SuppressWarnings("unchecked")

	public JsonResponse<Object> viewProjectPo(String userid, String org, String div, String id) {

		logger.info("Method : viewProjectPo Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_id='" + id
					+ "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
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

	// For MaterialIssue View

	@SuppressWarnings("unchecked")

	public JsonResponse<Object> viewProjectMaterialIssue(String userid, String org, String div, String id) {

		logger.info("Method : viewProjectMaterialIssue Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_id='" + id
					+ "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "viewProjectMaterialIssue").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewProjectMaterialIssue Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	// for product sku listing

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductMasterModel>>> getProjectProductSKUListing(String type,
			String orgName, String orgDiv) {
		logger.info("Method : getProjectProductSKUListing starts");

		List<ProductMasterModel> locationList = new ArrayList<ProductMasterModel>();
		JsonResponse<List<ProductMasterModel>> resp = new JsonResponse<List<ProductMasterModel>>();
		String value = "SET @P_type='" + type + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "viewProductSkuList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object CREATEDON = null;
				if (m[9] != null) {
					CREATEDON = DateFormatter.returnStringDate(m[9]);
				}
				ProductMasterModel dropDownModel = new ProductMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], CREATEDON, null,null);
				locationList.add(dropDownModel);
			}
			resp.setBody(locationList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ProductMasterModel>>> response = new ResponseEntity<JsonResponse<List<ProductMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProjectProductSKUListing ends" + response);
		return response;
	}
	
	
	@SuppressWarnings("unchecked")

	public JsonResponse<Object> editProjectProduct(String id,String userid,
			String orgName, String div) {

		logger.info("Method : editProjectProduct Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_id = '" + id + "',@p_userId='" + userid + "',@p_org='" + orgName + "',@p_orgDiv='" + div + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "editProjectProduct").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		
		logger.info("Method : editProjectProduct Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	public ResponseEntity<JsonResponse<Object>> saveproductskuDao(ProjectCreationRestModel prjCreation) {

		logger.info("Method in Dao: saveproductsku Dao starts");

		// Print the received MonitoringControl object
		System.out.println("Received PrjCreation ADDD: " + prjCreation);

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {

			System.out.println("VALUE------------------------------" + prjCreation);
			String values = GenerateProjectCreationParameter.getproductSkuParam(prjCreation);
			System.out.println(values);
			System.out.println("getProductSkuId=----------" + prjCreation.getProductSkuId());
			if (prjCreation.getProductSkuId() != "" && prjCreation.getProductSkuId() != null) {

				em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
						.setParameter("actionType", "modifyProductSku").setParameter("actionValue", values)
						.execute();

			} else {

				System.out.println("ADD=================" + prjCreation.getProductSkuId());
				em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
						.setParameter("actionType", "addProductSku").setParameter("actionValue", values).execute();

			}
		} catch (Exception e) {
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

		logger.info("Method in Dao: saveproductsku Dao ends"+response);

		return response;
	}
	
	@SuppressWarnings("unchecked")

	public JsonResponse<Object> viewProductSku(String userid, String org, String div) {

		logger.info("Method : viewProductSku Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "viewProductSku").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		
		logger.info("Method : viewProductSku Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProjectTypeList(String type) {
		logger.info("Method : getProjectTypeList starts");

		List<DropDownModel> locationTypeList = new ArrayList<DropDownModel>();
		
		String value = "SET @p_type='" + type + "'";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectsprjcreationroutines")
					.setParameter("actionType", "getProjectTypeList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getProjectTypeList ends");
		return locationTypeList;
	}

}
