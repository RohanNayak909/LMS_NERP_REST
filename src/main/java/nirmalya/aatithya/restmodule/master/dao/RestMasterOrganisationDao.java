package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterOrganiserModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateCustomerNewParameter;
import nirmalya.aatithya.restmodule.master.model.RestMasterOrganisationModel;
import nirmalya.aatithya.restmodule.sales.model.RestCustoomerNewModel;

@Repository
public class RestMasterOrganisationDao {
	Logger logger = LoggerFactory.getLogger(RestMasterOrganisationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrganisationTypeList() {
		logger.info("Method : getOrganisationTypeList starts");
		List<DropDownModel> orgType = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
					.setParameter("actionType", "getOrganisationTypeList").setParameter("actionValue", "")
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				orgType.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getOrganisationTypeList ends");

		return orgType;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLocationsListsDao() {
		logger.info("Method : getLocationsListsDao starts");
		List<DropDownModel> loc = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
					.setParameter("actionType", "getLocationList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				loc.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getLocationsListsDao ends");

		return loc;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFinancialYearListsDao() {
		logger.info("Method : getFinancialYearListsDao starts");
		List<DropDownModel> loc = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
					.setParameter("actionType", "getFinancialYearLists").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				loc.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFinancialYearListsDao ends");
		return loc;
	}

	public JsonResponse<Object> addOrgDao(RestMasterOrganisationModel restMasterOrganisationModel) {
		// TODO Auto-generated method stub
		// Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		// if (validity)
		try {
			String values = GenerateMasterOrganiserModel.addOrg(restMasterOrganisationModel);
			logger.info("Method : addOrganiser Dao ends" + values);
			logger.info("organization id: " + restMasterOrganisationModel.getOrganisationId());
			if (restMasterOrganisationModel.getOrganisationId() != null
					&& restMasterOrganisationModel.getOrganisationId() == "") {
				logger.info("if part: " + values);
				em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
						.setParameter("actionType", "addOrgDetails").setParameter("actionValue", values).execute();
			} else {
				logger.info("else part: " + values);
				em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
						.setParameter("actionType", "modifyOrgDetails").setParameter("actionValue", values).execute();
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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("resp" + response);
		logger.info("Method : addOrganiser Dao ends");
		return resp;
	}

	/// rest view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>> vieworg(String organization, String orgDivision) {
		logger.info("Method : vieworg starts");
		List<RestMasterOrganisationModel> respList = new ArrayList<RestMasterOrganisationModel>();

		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("VALUEE"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
					.setParameter("actionType", "vieworgDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestMasterOrganisationModel restMasterOrganisationModel = new RestMasterOrganisationModel(m[0], m[1],
						m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9],null, null, null, null,m[10],m[11],null,null,null,null);
				respList.add(restMasterOrganisationModel);
				logger.info("RestMasterOrganisationModel" + restMasterOrganisationModel);
			}
			logger.info("respList" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestMasterOrganisationModel>> resp = new JsonResponse<List<RestMasterOrganisationModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>> response = new ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : vieworg ends");
		return response;
	}

	// edit Dao

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>> editOrganizerMaster(String id) {
		logger.info("Method : editOrganizerMaster starts");

		JsonResponse<List<RestMasterOrganisationModel>> resp = new JsonResponse<List<RestMasterOrganisationModel>>();
		List<RestMasterOrganisationModel> newResp = new ArrayList<RestMasterOrganisationModel>();

		try {
			String value = "SET @p_OrganisationId='" + id + "';";
			logger.info("@@@@@@@@@@@@@@@@@@@" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
					.setParameter("actionType", "editOrganiserDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestMasterOrganisationModel restMasterOrganisationModel = new RestMasterOrganisationModel(m[0], m[1],
						m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19]);
				newResp.add(restMasterOrganisationModel);
				logger.info("RestMasterOrganisationModel" + restMasterOrganisationModel);
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

		ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>> response = new ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : editOrganizerMaster ends");
		return response;
	}

	// delete resp

	public ResponseEntity<JsonResponse<Object>> restOrganizerMasterDetails(String id, String createdBy) {
		logger.info("Method : deleteOrganzier starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @P_ModifiedBy='" + createdBy + "',@p_OrganisationId='" + id + "';";

				em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
						.setParameter("actionType", "deleteOrgDetails").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteOrganzier ends");
		return response;
	}
	// AutoSearch

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getOrgNameAutoSearchList(String id) {
		logger.info("Method : getOrgNameAutoSearchList starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		logger.info("value==="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
					.setParameter("actionType", "getOrgName").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getOrgNameAutoSearchList ends");
		logger.info("AUTODATAAA" + response);
		return response;
	}
	public JsonResponse<Object> addOrgWorkingDayDao(RestMasterOrganisationModel restMasterOrganisationModel) {
		logger.info("Method : addOrgWorkingDay Dao start");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateMasterOrganiserModel.addOrgWorkingDay(restMasterOrganisationModel);
			
			logger.info("organization id: " + restMasterOrganisationModel.getOrganisationId());
			if (restMasterOrganisationModel.getWorkingDaySlNo() != null
					&& restMasterOrganisationModel.getWorkingDaySlNo() == "") {
				logger.info("if part: " + values);
				em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
						.setParameter("actionType", "addOrgWorkingDay").setParameter("actionValue", values).execute();
			} else {
				logger.info("else part: " + values);
				em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
						.setParameter("actionType", "modifyOrgWorkingDay").setParameter("actionValue", values).execute();
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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("resp" + response);
		logger.info("Method : addOrgWorkingDay Dao ends");
		return resp;
	}
	/// rest view work details

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>> viewworkingDay(String orgName,String orgDiv) {
		logger.info("Method : vieworg starts");
		List<RestMasterOrganisationModel> respList = new ArrayList<RestMasterOrganisationModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
					.setParameter("actionType", "viewworkingDay").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {

				RestMasterOrganisationModel restMasterOrganisationModel = new RestMasterOrganisationModel(m[0].toString(), m[1],
						m[2], m[3], m[4]);
				respList.add(restMasterOrganisationModel);
			}
			logger.info("respList" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestMasterOrganisationModel>> resp = new JsonResponse<List<RestMasterOrganisationModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>> response = new ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : vieworg ends");
		return response;
	}
	public JsonResponse<Object> addTaxDeclarationModifyDeclareDao(RestMasterOrganisationModel restMasterOrganisationModel) {
		logger.info("Method : addTaxDeclarationModifyDeclareDao start");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateMasterOrganiserModel.taxDeclarationModifyDeclareParam(restMasterOrganisationModel);
			
			if (restMasterOrganisationModel.getDeclareSlNo() != null
					&& restMasterOrganisationModel.getDeclareSlNo() == "") {
				logger.info("if part: " + values);
				em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
				.setParameter("actionType", "addTaxDeclarationModifyDeclare").setParameter("actionValue", values).execute();
			} else {
				logger.info("else part: " + values);
				em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
				.setParameter("actionType", "modifyTaxDeclarationModifyDeclare").setParameter("actionValue", values).execute();
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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("resp" + response);
		logger.info("Method : addTaxDeclarationModifyDeclareDao ends");
		return resp;
	}
	/// rest view tax details
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>> viewTaxDeclarationModifyDeclareDao(String orgName,String orgDiv) {
		logger.info("Method : viewTaxDeclarationModifyDeclareDao starts");
		List<RestMasterOrganisationModel> respList = new ArrayList<RestMasterOrganisationModel>();
		
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
					.setParameter("actionType", "viewTaxDeclarationModifyDeclare").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				Object FROMDATE = null;
				if (m[2] != null) {
					FROMDATE =DateFormatter.returnStringDate(m[2]);
				}
				Object TODATE = null;
				if (m[3] != null) {
					TODATE = DateFormatter.returnStringDate(m[3]);
				}
				RestMasterOrganisationModel restMasterOrganisationModel = new RestMasterOrganisationModel(m[0].toString(), m[1],
						FROMDATE, TODATE, m[4],null,null);
				respList.add(restMasterOrganisationModel);
			}
			logger.info("respList" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<RestMasterOrganisationModel>> resp = new JsonResponse<List<RestMasterOrganisationModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>> response = new ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewTaxDeclarationModifyDeclareDao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestMasterOrganisationModel>> saveOrgAddressDetails(RestMasterOrganisationModel product) {
		logger.info("Method : saveOrgAddressDetails starts");
		JsonResponse<RestMasterOrganisationModel> resp = new JsonResponse<RestMasterOrganisationModel>();
		
		List<RestMasterOrganisationModel> newProduct = new ArrayList<RestMasterOrganisationModel>();
		try {
				String values = GenerateMasterOrganiserModel.saveAddressDetails(product);
				System.out.println("value==="+values);
				if (product.getShippingId() != null && product.getShippingId() != "") {
					System.out.println("valuemodifyy");
					List<Object[]> x = em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
							.setParameter("actionType", "modifyOrgAddressDetails").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						
						RestMasterOrganisationModel item = new RestMasterOrganisationModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10],m[11],m[12]);
						newProduct.add(item);
					}
				} else {
				
					List<Object[]> x = em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
							.setParameter("actionType", "saveOrgAddressDetails").setParameter("actionValue", values)
							.getResultList();
					logger.info("ddddddddddddd"+x.toString());
					for (Object[] m : x) {
						logger.info("ddddddddddddd"+Arrays.toString(m));
						RestMasterOrganisationModel item = new RestMasterOrganisationModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10],m[11],m[12]);
						newProduct.add(item);
						logger.info("@@@@@@@@@@@@"+newProduct);
					}
					
				}
				
				resp.setBody(newProduct.get(0));
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
		
		ResponseEntity<JsonResponse<RestMasterOrganisationModel>> response = new ResponseEntity<JsonResponse<RestMasterOrganisationModel>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveOrgAddressDetails ends"+response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewShippingAddressDetails(String organisationalIdd,String orgName, String orgDivision) {
		logger.info("Method : viewShippingAddressDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_organisationalId='" + organisationalIdd + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
					.setParameter("actionType", "viewShippingAddressDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewShippingAddressDetails Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editShippingAddressDetails(String addressId,String orgName, String orgDivision) {
		logger.info("Method : editShippingAddressDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_addressId='" + addressId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
					.setParameter("actionType", "editShippingAddressDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : editShippingAddressDetails Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteShippingaddressdata(String deleteId,String orgName, String orgDiv) {
		logger.info("Method : deleteShippingaddressdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_deleteId='" + deleteId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			 em.createNamedStoredProcedureQuery("organiserMasterRoutinesModel")
					.setParameter("actionType", "deleteShippingaddressdata").setParameter("actionValue", value)
					.execute();
			 resp.setCode("success");
			 resp.setMessage("Deleted Successfully");
			//resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : deleteShippingaddressdata Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
}