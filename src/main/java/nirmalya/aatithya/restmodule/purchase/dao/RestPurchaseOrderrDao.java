package nirmalya.aatithya.restmodule.purchase.dao;

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

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.purchase.*;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.RestVendorNewModel;

@Repository
public class RestPurchaseOrderrDao {

	Logger logger = LoggerFactory.getLogger(RestPurchaseOrderrDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EnvironmentVaribles env;
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> getVendorAutoSearchListStore(String id,String type, String orgName,
			String orgDiv) {
		logger.info("Method : getVendorAutoSearchListStore starts");

		List<RestPurchaseOrderModel> itemNameList = new ArrayList<RestPurchaseOrderModel>();
		JsonResponse<List<RestPurchaseOrderModel>> resp = new JsonResponse<List<RestPurchaseOrderModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_type='" + type + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
System.out.println("hhhhhhhhhhhhhhhhh"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getVendorAutoSearchListStore").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				
				Boolean boolean1 = false;
				if (m[3].toString() != null) {
					String data = m[3].toString();
					if (data.contentEquals("Same State")) {
						boolean1 = true;
					} else {
						boolean1 = false;
					}
				}
				RestPurchaseOrderModel dropDownModel = new RestPurchaseOrderModel(m[0], m[1], m[2], boolean1, m[4]);

				itemNameList.add(dropDownModel);
			}
			
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getVendorAutoSearchListStore ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPoInsertedId() {
		logger.info("Method : getPoInsertedId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getPoInsertedId").setParameter("actionValue", "").getResultList();

			Object jobId = x.get(0);
			

			DropDownModel dropDownModel = new DropDownModel(jobId, null);

			itemList.add(dropDownModel);
			resp.setBody(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getPoInsertedId ends");
		return response;
	}

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorStateData(String
	 * id,String type) { logger.info("Method : getVendorStateData starts");
	 * 
	 * List<DropDownModel> itemList = new ArrayList<DropDownModel>();
	 * JsonResponse<List<DropDownModel>> resp = new
	 * JsonResponse<List<DropDownModel>>(); String value = "SET @p_vendorId='" + id
	 * + "',@p_type='" + type + "';";
	 * logger.info("ddddddddddddddddddddd"+value); try {
	 * 
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
	 * .setParameter("actionType", "getVendorStateData").setParameter("actionValue",
	 * value) .getResultList(); for (Object[] m : x) { DropDownModel dropDownModel =
	 * new DropDownModel(m[0], m[1]); itemList.add(dropDownModel);
	 * //logger.info("ddddddddddddddddddddd"+itemList); }
	 * 
	 * resp.setBody(itemList);
	 * 
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<List<DropDownModel>>> response = new
	 * ResponseEntity<JsonResponse<List<DropDownModel>>>( resp, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : getVendorStateData ends#######################"
	 * +response); return response; }
	 */

	/*
	 * add
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> addPurchase(
			List<RestPurchaseOrderModel> restPurchaseOrderModel) {

		logger.info("Method : addPurchase starts");

		// logger.info("RestPurchaseOrderModel" + restPurchaseOrderModel);
		JsonResponse<List<RestPurchaseOrderModel>> resp = new JsonResponse<List<RestPurchaseOrderModel>>();
		List<RestPurchaseOrderModel> listData = new ArrayList<RestPurchaseOrderModel>();

		try {
			String values = GeneratePurchaseOrderParameter.getAddPo(restPurchaseOrderModel);

			if (restPurchaseOrderModel.get(0).getPoId() == null || restPurchaseOrderModel.get(0).getPoId() == "") {
				// logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);

				System.out.println("Adddddddd--->>>"+values);
				em.createNamedStoredProcedureQuery("poRoutines").setParameter("actionType", "addPurchase")
						.setParameter("actionValue", values).execute();
				
				resp.setCode("Purchase Order Added Successfully.");

			} else {
				// logger.info("@modifyyyyyyyyyyyyyy" + values);
				System.out.println("modifyyyyyyyyyyyyyy--->>>"+values);
				em.createNamedStoredProcedureQuery("poRoutines").setParameter("actionType", "modifyPurchase")
						.setParameter("actionValue", values).execute();
				
				resp.setCode("Purchase Order Modified Successfully.");
				//logger.info("modify printttttttttttttttttt" + listData);

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
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : addPurchase ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> viewPurchaseOrder(String orgName, String orgDiv) {
		logger.info("Method : viewPurchaseOrder Dao startssssssssssssssssssssss");

		List<RestPurchaseOrderModel> getAllemployee = new ArrayList<RestPurchaseOrderModel>();
		JsonResponse<List<RestPurchaseOrderModel>> resp = new JsonResponse<List<RestPurchaseOrderModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "viewPurchaseOrder").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				//logger.info(Arrays.toString(m));
				Object createdOn = null;
				if (m[6] != null) {
					createdOn = m[6].toString();
				}

				RestPurchaseOrderModel viewdemo = new RestPurchaseOrderModel(m[0], m[1], m[2], m[3].toString(), m[4],
						m[5], null, createdOn, m[7], m[8], m[9], m[10].toString(), null, null, m[11], m[12],m[13],m[14]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewPurchaseOrder Dao ends");

		return response;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestPurchaseOrderModel> viewPoEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : viewPoEdit starts");
		// logger.info("RestDeliveryChallanModel" + id);
		List<RestPurchaseOrderModel> getRequisitionTypeList = new ArrayList<RestPurchaseOrderModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_poId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines").setParameter("actionType", "viewPoEdit")
					.setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {
					Object createdOn = null;
					if (m[31] != null) {
						createdOn = m[31].toString();
					}
					Object createdOn1 = null;
					if (m[3] != null) {
						createdOn1 = m[3].toString();
					}

					RestPurchaseOrderModel dropDownModel = new RestPurchaseOrderModel(m[0], m[1], m[2], createdOn1,
							m[4], m[5], m[6], m[7], m[8], null, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], null, m[25], m[26], m[27], m[28],
							m[29], null, m[30], createdOn, null, null, m[32], m[33], m[34], m[35], m[36], m[37], null,
							m[38], null, m[39], m[40], null, null, m[41], m[42], null, null, m[43],m[44], m[45], m[46]
									, m[47], m[48],m[49],null);
					getRequisitionTypeList.add(dropDownModel);
					// logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_poId='" + getRequisitionTypeList.get(0).getPoId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("poRoutines")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {
					//logger.info("DATA12" + Arrays.toString(m));
					InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2], m[3]);
					docList.add(dropDownModel);
				}
			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		getRequisitionTypeList.get(0).setDocumentList(docList);
		//logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewPoEdit ends");
		return getRequisitionTypeList;
	}

	/*
	 * delete
	 * 
	 */
	public ResponseEntity<JsonResponse<Object>> deletePo(RestPurchaseOrderModel deletePo) {
		logger.info("Method : deletePo starts");
		// logger.info("restDeliveryChallanModel" + deletesalesDeliveryChallan);
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GeneratePurchaseOrderParameter.getDeletePo(deletePo);
			// logger.info(value);
			em.createNamedStoredProcedureQuery("poRoutines").setParameter("actionType", "deletePo")
					.setParameter("actionValue", value).execute();
			// logger.info("print block" + deletesalesInvoice);
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
		// logger.info("@@@@@@@@@@@@@@@@" + deletesalesInvoice);
		logger.info("Method : deletePo ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCarrierList() {
		logger.info("Method : getCarrierList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getCarrierList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCarrierList ends");
		return getCollectionList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPaymentterm() {
		logger.info("Method : getPaymentterm starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getPaymentterm").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPaymentterm ends");
		return getCollectionList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<RestVendorNewModel> getVendorAddressAddressById(String id) {
		logger.info("Method : getVendorAddressAddressById dao starts");

		RestVendorNewModel req = new RestVendorNewModel();
		JsonResponse<RestVendorNewModel> resp = new JsonResponse<RestVendorNewModel>();

		try {

			String value = "SET @P_vendorId='" + id + "';";
			System.out.println("valueeeeeee>>>>>>0____________0---------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getVendorAddressAddressById").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestVendorNewModel reqEdit = new RestVendorNewModel(m[0], null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				req = reqEdit;

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVendorAddressAddressById dao ends");
		//logger.info("EDIT@@@@" + resp);
		return resp;
	}

	public JsonResponse<Object> addVendorBillingaddres(RestVendorNewModel restVendorNewModel) {

		logger.info("Method : addVendorBillingaddres starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GeneratePurchaseOrderParameter.getBillingaddressadd(restVendorNewModel);
			// logger.info("ADDDVALUE"+values);
			//logger.info("ID======" + restVendorNewModel.getVendorId());
			//logger.info("ADDddddddd" + values);
			if (restVendorNewModel.getVendorId() == null || restVendorNewModel.getVendorId() == "") {
				//logger.info("ADDddddddd" + values);
				em.createNamedStoredProcedureQuery("poRoutines").setParameter("actionType", "addVendorBillingaddres")
						.setParameter("actionValue", values).execute();

			}

			else {
				//logger.info("ADDddddddd" + values);
				em.createNamedStoredProcedureQuery("poRoutines").setParameter("actionType", "modifyVendorBillingaddres")
						.setParameter("actionValue", values).execute();

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

		//logger.info("ADDDDDDD" + resp);
		logger.info("Method : addVendorBillingaddres ends");
		return resp;
	}

	public JsonResponse<Object> addvendorShippingaddress(RestVendorNewModel restVendorNewModel) {

		logger.info("Method : addvendorShippingaddress starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GeneratePurchaseOrderParameter.getShippingaddressadd(restVendorNewModel);
			// logger.info("ADDDVALUE"+values);
			// logger.info("ID======"+restCustoomerNewModel.getSalespersonId());
			if (restVendorNewModel.getVendorId() == null || restVendorNewModel.getVendorId() == "") {
				//logger.info("ADD" + values);
				em.createNamedStoredProcedureQuery("poRoutines").setParameter("actionType", "addvendorShippingaddress")
						.setParameter("actionValue", values).execute();

			} else {
				//logger.info("ADDddddddd" + values);
				em.createNamedStoredProcedureQuery("poRoutines")
						.setParameter("actionType", "modifyvendorShippingaddress").setParameter("actionValue", values)
						.execute();

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

		//logger.info("ADDDDDDD" + resp);
		logger.info("Method : addvendorShippingaddress ends");
		return resp;
	}
	
	// view annexure
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewAnnexure(String id, String orgName, String orgDivision) {
			logger.info("Method : viewAnnexure Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String values = "SET @p_anxId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				//String value = "SET @p_OrganizationName='" + orgName + "',@p_OrganizationDivision='" + orgDivision + "';";
				System.out.println("values****************************" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
						.setParameter("actionType", "viewannexuredata").setParameter("actionValue", values).getResultList();
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewAnnexure Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}

	/************************ Invoice PDF View **********************/

	@SuppressWarnings("unchecked")
	public List<RestPurchaseOrderModel> viewPoViewPdf(String id, String orgName, String orgDiv) {
		logger.info("Method : viewPoViewPdf starts");
		List<RestPurchaseOrderModel> getRequisitionTypeList = new ArrayList<RestPurchaseOrderModel>();
		try {
			String values = "SET @p_poId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			//logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "viewPoViewPdf").setParameter("actionValue", values).getResultList();

			try {
				for (Object[] m : x) {
					
					
					Object createdOn = null;
					if (m[31] != null) {
						createdOn = m[31].toString();
					}
					Object createdOn1 = null;
					if (m[3] != null) {
						createdOn1 = m[3].toString();
					}
					String orgImg = null;
					if (m[47] != null && m[47] != "" && m[47] != " " && !m[47].toString().equals(" ")
							&& !m[47].toString().equals(null) && !m[47].toString().equals("")) {
						orgImg = env.getMobileView() + "document/document/" + m[47].toString();
					} else {
						orgImg = "";
					}
					//logger.info("TOTAL"+m[41]);
					/*
					 * RestPurchaseOrderModel dropDownModel = new RestPurchaseOrderModel(m[0], m[1],
					 * m[2], createdOn1, m[4], m[5], m[6], m[7], m[8], null, m[9], m[10], m[11],
					 * m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
					 * m[23], m[24], null, m[25], m[26], m[27], m[28], m[29], null, m[30],
					 * createdOn, null, null, m[32], m[33], m[34], m[35], m[36], m[37], null, m[38],
					 * null, m[39], m[40], m[41], m[42], null, null, null, null, null,null, m[43],
					 * m[44] , m[45]);
					 */
					RestPurchaseOrderModel dropDownModel = new RestPurchaseOrderModel(m[0], m[1], m[2], createdOn1,
							m[4], m[5], m[6], m[7], m[8], null, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], null, m[25], m[26], m[27], m[28],
							m[29], null, m[30], createdOn, m[32], null, m[33], m[34], m[35], m[36], m[37], m[38], null,
							m[39], null, m[40], m[41], m[42], m[43], null, null, null, null, null,null,null,m[44],m[45],m[46],orgImg);
					getRequisitionTypeList.add(dropDownModel);
					// logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//logger.info("=======aaaaaaaaaaaa=================" + getRequisitionTypeList);
		logger.info("Method : viewPoViewPdf ends");
		return getRequisitionTypeList;
	}

	/* report */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> viewPOReport(String orgName, String orgDiv) {
		logger.info("Method : viewPOReport Dao startssssssssssssssssssssss");

		List<RestPurchaseOrderModel> getAllemployee = new ArrayList<RestPurchaseOrderModel>();
		JsonResponse<List<RestPurchaseOrderModel>> resp = new JsonResponse<List<RestPurchaseOrderModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			//logger.info("restViewVendorDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "viewPOReport").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				//logger.info(Arrays.toString(m));
				Object createdOn = null;
				if (m[6] != null) {
					createdOn = m[6].toString();
				}
				RestPurchaseOrderModel viewdemo = new RestPurchaseOrderModel(m[0], m[1], m[2], m[3], m[4], m[5],
						createdOn);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewPOReport Dao ends");

		return response;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getGRNdata(String sku, String gatePass, String orgName,
			String orgDiv, String challanNo, String challanDt) {
		logger.info("Method : getGRNdata starts");
		JsonResponse resp = new JsonResponse();
		String Date = DateFormatter.getStringDate(challanDt);

		try {
			

			String values = "SET @p_sku='" + sku + "',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDiv + "',@p_gatePass='" + gatePass + "',@p_challanNo='" + challanNo + "',@p_challanDt='" + Date + "';";
			System.out.println("values>>>>----" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getGRNdataForGateReceived").setParameter("actionValue", values)
					.getResultList();
	
			resp.setBody(x.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		logger.info("Method : getGRNdata ends");
		return resp;
	}
	
	// Ori-Food
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getGRNdataOf(String sku, String gatePass, String orgName,
			String orgDiv, String challanNo, String challanDt, String vendorId) {
		logger.info("Method : getGRNdataOf starts");
		JsonResponse resp = new JsonResponse();
		String Date = DateFormatter.getStringDate(challanDt);
		
		try {
			

			String values = "SET @p_sku='(" + sku + ")',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDiv + "',@p_gatePass='" + gatePass + "',@p_challanNo='" + challanNo + "',@p_challanDt='" + Date + "',@p_vendorId='" + vendorId + "';";
			System.out.println("values>>>>----" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getGRNdataForGateReceivedOf").setParameter("actionValue", values)
					.getResultList();
	
			resp.setBody(x.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		logger.info("Method : getGRNdataOf ends");
		return resp;
	}

	// approve

	public JsonResponse<DropDownModel> approvePorder(String approveStatus, String poId, String orgName,
			String orgDivision) {
		logger.info("Method : approvePorder starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			// String value = "SET @p_approveStatus='" + approveStatus + "',@p_poId='" +
			// poId + "', @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

			String value = "SET @p_approveStatus='" + approveStatus + "',@p_poId='" + poId + "', @p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "';";

			
			em.createNamedStoredProcedureQuery("poRoutines").setParameter("actionType", "approvePorder")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : approvePorder ends");
		return resp;
	}

	// For add Uloaded po Data

	public ResponseEntity<JsonResponse<Object>> addPOUploadData(List<RestPurchaseOrderModel> pOrder) {
		logger.info("Method : addPOUploadData dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GeneratePurchaseOrderParameter.addPOUploadDataParam(pOrder);

		
			if (values != null || values != "") {
				em.createNamedStoredProcedureQuery("poRoutines").setParameter("actionType", "addPOUploadData")
						.setParameter("actionValue", values).execute();

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				logger.error("addPOUploadData: " + e.getMessage());
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addPOUploadData Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getItemQuotationAutoSearchNewListForPO(
			String id,String type,
			String org, String orgDiv) {
		logger.info("Method : getItemQuotationAutoSearchNewListForPO starts");
		List<InventorySkuProductModel> itemNameList = new ArrayList<InventorySkuProductModel>();
		JsonResponse<List<InventorySkuProductModel>> resp = new JsonResponse<List<InventorySkuProductModel>>();
		String value = "SET @p_searchValue='" + id + "', @p_type='" + type + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
	System.out.println("value>>><<<<" + value);
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getitemquotationList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				double gst = 0;
				if (m[9] != null) {
					gst = Double.parseDouble(m[9].toString());
				}
				String brandName = "";
				if (m[4] != null && m[4] != "null") {
					brandName = (String) m[4];
				}
				InventorySkuProductModel dropDownModel = new InventorySkuProductModel(m[0], m[1], m[2], m[3], brandName,
						m[5], m[6], m[7], m[8], gst,m[10],null,null,m[11]);
				itemNameList.add(dropDownModel);
			}
		System.out.println("itemNameList>>>>" + itemNameList);
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> response = new ResponseEntity<JsonResponse<List<InventorySkuProductModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response>>>>" + response);
		logger.info("Method : getItemQuotationAutoSearchNewListForPO ends");
		return response;
	}

	// get Product Category List Modal
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryDataListModal() {
		logger.info("Method : getProductCategoryListForPO starts");

		JsonResponse<List<ProductCategoryModel>> resp = new JsonResponse<List<ProductCategoryModel>>();
		List<ProductCategoryModel> yearList = new ArrayList<ProductCategoryModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getProductCategoryList").setParameter("actionValue", "")
					.getResultList();
			for (Object[] m : x) {

				ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				yearList.add(item);

			
			}
			resp.setBody(yearList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ProductCategoryModel>>> response = new ResponseEntity<JsonResponse<List<ProductCategoryModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getProductCategoryDataListModal ends");
	
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getModeListForPurchaseProduct() {
		logger.info("Method : getModeListForPurchaseProduct starts");
		
		List<DropDownModel> modeList = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getModeListForPurchaseProduct").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				modeList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getModeListForPurchaseProduct ends");
		return modeList;
	}
	
	// Annexure Details

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewAnnexurePdf(String id) {
			logger.info("Method : viewAnnexurePdf Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String values = "SET @p_anxId='" + id + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
						.setParameter("actionType", "viewannexurePdfData").setParameter("actionValue", values)
						.getResultList();
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewAnnexurePdf Dao ends" + resp);
			return resp;
		}
		
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getReferenceListPO(String id, String poId, String orgName,
				String orgDiv) {

			logger.info("Method : getReferenceListPO starts");
			List<DropDownModel> referenceList = new ArrayList<DropDownModel>();

			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			// String value = "SET @p_vendorId='" + id + "';";
			String value = "SET @p_vendorId='" + id + "',@p_poId='" + poId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value>>>>" + value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
						.setParameter("actionType", "getReferenceListPO").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					referenceList.add(dropDownModel);
				}
				resp.setBody(referenceList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : getReferenceListPO ends");
			return response;
		}
		
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getReferenceItemDetailsPO(String orgName, String orgDivision, String id) {
			logger.info("Method : getReferenceItemDetailsPO Dao startssssssssssssssssssssss");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_rqstType='" + id
						 + "';";
				System.out.println("value>>>-----" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
						.setParameter("actionType", "getReferenceItemDetailsPO").setParameter("actionValue", value)
						.getResultList();
				System.out.println("x.get(0)--->>>>>>-----" + x.get(0));
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getReferenceItemDetailsPO Dao ends");
			return resp;

		}
}
