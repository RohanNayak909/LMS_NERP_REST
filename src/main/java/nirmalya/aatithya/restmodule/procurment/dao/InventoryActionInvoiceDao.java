package nirmalya.aatithya.restmodule.procurment.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateActionInvoicePAram;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.model.InventoryActionInvoiceModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryActionInvoiceDao {

	Logger logger = LoggerFactory.getLogger(InventoryActionInvoiceDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	/**
	 * @return vendor list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVendorList() {
		logger.info("Method : getVendorList starts");
		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "getVendorList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getVendorList ends");
		return vendorList;
	}

	/**
	 * @return payment status list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPaymentStatus() {
		logger.info("Method : getPaymentStatus starts");
		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "getPaymentStatus").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPaymentStatus ends");
		return vendorList;
	}

	/*
	 * Drop down for state Change list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorLocChange(String vendorId) {

		logger.info("Method : getVendorLocChange starts");

		List<DropDownModel> locationList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_vendorId='" + vendorId + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "getVendorLocationList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationList.add(dropDownModel);
			}

			resp.setBody(locationList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getVendorLocChange ends");
		return response;
	}

	/*
	 * Drop down for state Change list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorContactChange(String vendorId) {

		logger.info("Method : getVendorContactChange starts");

		List<DropDownModel> contactList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_vendorId='" + vendorId + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "getVendorContactList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				contactList.add(dropDownModel);
			}

			resp.setBody(contactList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getVendorContactChange ends");
		return response;
	}

	/*
	 * Drop down for state Change list
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCostCenterChange(String costCenterId) {

		logger.info("Method : getCostCenterChange starts");

		List<DropDownModel> contactList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_costCenterId='" + costCenterId + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "getCostCenterChange").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				contactList.add(dropDownModel);
			}

			resp.setBody(contactList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getCostCenterChange ends");
		return response;
	}

	/**
	 * DAO Function to Add po
	 *
	 */
	@SuppressWarnings({ "unchecked" })
	public ResponseEntity<JsonResponse<InventoryActionInvoiceModel>> restAddInvoice(
			InventoryActionInvoiceModel inventoryActionInvoiceModel) {
		logger.info("Method : restAddInvoice starts");
		logger.info("add=="+inventoryActionInvoiceModel);
		boolean validation = true;
		JsonResponse<InventoryActionInvoiceModel> resp = new JsonResponse<InventoryActionInvoiceModel>();
		List<InventoryActionInvoiceModel> listData = new ArrayList<InventoryActionInvoiceModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		resp.setMessage("");
		resp.setCode("");
		String errorCode = "Field Validation Error";

		if (inventoryActionInvoiceModel.getInvNo() == null || inventoryActionInvoiceModel.getInvNo() == "") {
			validation = false;
			resp.setCode(errorCode);
			resp.setMessage("Please Enter Invoice No.");
		} else if (inventoryActionInvoiceModel.getInvDate() == null || inventoryActionInvoiceModel.getInvDate() == "") {
			validation = false;
			resp.setCode(errorCode);
			resp.setMessage("PleaseEnter Invoice Date.");
		} else if (inventoryActionInvoiceModel.getVendorId() == null || inventoryActionInvoiceModel.getVendorId() == "") {
			validation = false;
			resp.setCode(errorCode);
			resp.setMessage("please Select Vendor.");
		}
		for (InventoryProductModel l : inventoryActionInvoiceModel.getProductList()) {
			if (l.getSku() == null || l.getSku() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please SKU .");
				break;
			} else if (l.getLocationId() == null || l.getLocationId() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please Enter Location.");
				break;
			} else if (l.getItemId() == null || l.getItemId() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please Select Product.");
				break;
			} else if (l.getUomId() == null || l.getUomId() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("please select UOM.");

			} else if (l.getQuantity() == null) {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("please Enter Quantity.");
				break;
			}
		}
		if (validation) {

			try {
				String value = GenerateActionInvoicePAram.getPoParam(inventoryActionInvoiceModel);
				logger.info("value=="+value);
				List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();

				if (inventoryActionInvoiceModel.getInvId() != null && inventoryActionInvoiceModel.getInvId() != "") {

					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
							.setParameter("actionType", "modifyInv").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {
						Object oa = null;
						if (m[5] != null) {
							oa = m[5].toString();
						}
						Object startDate = null;
						if (m[8] != null) {
							startDate = m[8].toString();
						}

						Object invDate = null;
						if (m[1] != null) {
							invDate = m[1].toString();
						}
						Object activeDate = null;
						if (m[17] != null) {
							activeDate = m[17].toString();
						}
						Object completeDate = null;
						if (m[18] != null) {
							completeDate = m[18].toString();
						}
						Object onHoldDate = null;
						if (m[19] != null) {
							onHoldDate = m[19].toString();
						}

						InventoryActionInvoiceModel dropDownModel = new InventoryActionInvoiceModel(m[0], invDate, m[2],
								m[3], null, null, m[4], oa, m[6], m[7], startDate, m[9], m[10], m[11], m[12], m[13],
								m[14], m[15], m[16], activeDate, completeDate, onHoldDate, m[20],m[21],m[22],m[23]);
						listData.add(dropDownModel);
					}

					try {

						List<Object[]> y = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
								.setParameter("actionType", "getInvItemList")
								.setParameter("actionValue", "SET @p_invId='" + listData.get(0).getInvId() + "';")
								.getResultList();

						for (Object[] m : y) {
							Object createdDate = null;
							if (m[10] != null) {
								createdDate = m[10].toString();
							}
							InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4],
									m[5], m[6], m[7], m[8], m[9], createdDate, m[11], m[12], m[13], m[14], m[15], m[16],
									m[17], m[18], m[19], m[20], m[21],null,null);
							productList.add(productModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
					if (listData != null) {
						String values = "SET @p_invId='" + listData.get(0).getInvId() + "';";
						List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
								.setParameter("actionType", "getVendorDocs").setParameter("actionValue", values)
								.getResultList();
						for (Object[] m1 : x1) {

							InventoryVendorDocumentModel dropDownModel1 = new InventoryVendorDocumentModel(m1[0], m1[1],
									m1[2]);
							docList.add(dropDownModel1);
						}
						listData.get(0).setDocumentList(docList);
					}
					if (listData != null) {
						listData.get(0).setProductList(productList);
					}

				} else {
					logger.info("ssssssssssssssss"+value);
					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
							.setParameter("actionType", "addNewInv").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {
						Object oa = null;
						if (m[5] != null) {
							oa = m[5].toString();
						}
						Object startDate = null;
						if (m[8] != null) {
							startDate = m[8].toString();
						}

						Object invDate = null;
						if (m[1] != null) {
							invDate = m[1].toString();
						}
						Object activeDate = null;
						if (m[17] != null) {
							activeDate = m[17].toString();
						}
						Object completeDate = null;
						if (m[18] != null) {
							completeDate = m[18].toString();
						}
						Object onHoldDate = null;
						if (m[19] != null) {
							onHoldDate = m[19].toString();
						}

						InventoryActionInvoiceModel dropDownModel = new InventoryActionInvoiceModel(m[0], invDate, m[2],
								m[3], null, null, m[4], oa, m[6], m[7], startDate, m[9], m[10], m[11], m[12], m[13],
								m[14], m[15], m[16], activeDate, completeDate, onHoldDate, m[20] ,m[21],m[22],m[23]);
						listData.add(dropDownModel);
						logger.info("iiiiiiiiiii"+dropDownModel);
					}

					try {

						List<Object[]> y = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
								.setParameter("actionType", "getInvItemList")
								.setParameter("actionValue", "SET @p_invId='" + listData.get(0).getInvId() + "';")
								.getResultList();

						for (Object[] m : y) {
							Object createdDate = null;
							if (m[10] != null) {
								createdDate = m[10].toString();
							}
							InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4],
									m[5], m[6], m[7], m[8], m[9], createdDate, m[11], m[12], m[13], m[14], m[15], m[16],
									m[17], m[18], m[19], m[20], m[21],null,null);
							productList.add(productModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
					if (listData != null) {
						String values = "SET @p_invId='" + listData.get(0).getInvId() + "';";
						List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
								.setParameter("actionType", "getVendorDocs").setParameter("actionValue", values)
								.getResultList();
						for (Object[] m1 : x1) {

							InventoryVendorDocumentModel dropDownModel1 = new InventoryVendorDocumentModel(m1[0], m1[1],
									m1[2]);
							docList.add(dropDownModel1);
						}
						listData.get(0).setDocumentList(docList);
					}
					if (listData != null) {
						listData.get(0).setProductList(productList);
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
			resp.setBody(listData.get(0));

		}
		ResponseEntity<JsonResponse<InventoryActionInvoiceModel>> response = new ResponseEntity<JsonResponse<InventoryActionInvoiceModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : restAddInvoice ends"+response);
		return response;
	}

	/**
	 * for view po list
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryActionInvoiceModel> getInvoiceViewList(String orgName, String orgDiv) {
		logger.info("Method : getInvoiceViewList starts");
		List<InventoryActionInvoiceModel> inventoryPoModelList = new ArrayList<InventoryActionInvoiceModel>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesddddddddddd"+values);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "getInvoiceViewList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[1] != null) {
					oa = m[1].toString();
				}
				Object startDate = null;
				if (m[7] != null) {
					startDate = m[7].toString();
				}
				Object expireDate = null;
				if (m[10] != null) {
					expireDate = m[10].toString();
				}
				Object activeDate = null;
				if (m[19] != null) {
					activeDate = m[19].toString();
				}
				Object completeDate = null;
				if (m[20] != null) {
					completeDate = m[20].toString();
				}
				Object onHoldDate = null;
				if (m[21] != null) {
					onHoldDate = m[21].toString();
				}

				InventoryActionInvoiceModel inventoryPoModel = new InventoryActionInvoiceModel(m[0], oa, m[2], m[3],
						m[4], m[5], m[6], startDate, m[8], m[9], expireDate, m[11], m[12], m[13], m[14], m[15], m[16],
						m[17], m[18], activeDate, completeDate, onHoldDate, m[22],m[23],null,null);

				if (inventoryPoModel.getApproveStatus() != null) {
					if (inventoryPoModel.getApproveStatus().contentEquals("1")) {
						inventoryPoModel.setApproveStatus("Approve");
					} else if (inventoryPoModel.getApproveStatus().contentEquals("0")) {
						inventoryPoModel.setApproveStatus("Active");
					} else if (inventoryPoModel.getApproveStatus().contentEquals("2")) {
						inventoryPoModel.setApproveStatus("Pending");
					} else if (inventoryPoModel.getApproveStatus().contentEquals("3")) {
						inventoryPoModel.setApproveStatus("Rejected ");
					}
				}

				inventoryPoModelList.add(inventoryPoModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInvoiceViewList ends");
		return inventoryPoModelList;
	}

	/**
	 * DAO Function to for po edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public InventoryActionInvoiceModel geInvoiceEdit(String id,String orgName, String orgDiv) {
		logger.info("Method : geInvoiceEdit starts");
		InventoryActionInvoiceModel poList = new InventoryActionInvoiceModel();
		List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		String value = "SET @p_invId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("value==="+value);
		
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "getInvEdit").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object oa = null;
				if (m[5] != null) {
					oa = DateFormatter.returnStringDate(m[5]);
				}
				Object startDate = null;
				if (m[8] != null) {
					startDate = DateFormatter.returnStringDate(m[8]);
				}

				Object invDate = null;
				if (m[1] != null) {
					invDate = DateFormatter.returnStringDate(m[1]);
				}
				Object activeDate = null;
				if (m[17] != null) {
					activeDate = DateFormatter.returnStringDate(m[17]);
				}
				Object completeDate = null;
				if (m[18] != null) {
					completeDate = DateFormatter.returnStringDate(m[18]);
				}
				Object onHoldDate = null;
				if (m[19] != null) {
					onHoldDate = DateFormatter.returnStringDate(m[19]);
				}
				InventoryActionInvoiceModel dropDownModel = new InventoryActionInvoiceModel(m[0], invDate, m[2], m[3],
						null, null, m[4], oa, m[6], m[7], startDate, m[9], m[10], m[11], m[12], m[13], m[14], m[15],
						m[16], activeDate, completeDate, onHoldDate, m[20],m[21],m[22],m[23],m[24],m[25],m[26],m[27],m[28]);
				poList = dropDownModel;
			}
			try {

				List<Object[]> y = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
						.setParameter("actionType", "getInvItemList")
						.setParameter("actionValue", "SET @p_invId='" + poList.getInvId() + "';").getResultList();

				for (Object[] m : y) {
					Object createdDate = null;
					if (m[10] != null) {
						createdDate =DateFormatter.returnStringDate(m[10]);
					}
					InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4], m[5],
							m[6], m[7], m[8], m[9], createdDate, m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18],
							m[19], m[20], m[21],m[22],m[23]);
					productList.add(productModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (poList != null) {
				String values = "SET @p_invId='" + poList.getInvId() + "';";
				List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", values)
						.getResultList();
				for (Object[] m1 : x1) {

					InventoryVendorDocumentModel dropDownModel1 = new InventoryVendorDocumentModel(m1[0], m1[1], m1[2]);
					docList.add(dropDownModel1);
				}
				poList.setDocumentList(docList);
			}
			if (poList != null) {
				poList.setProductList(productList);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("Method : geInvoiceEdit ends"+poList);
		return poList;

	}

	/**
	 * DAO Function to delete
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restDeleteAction(InventoryActionInvoiceModel inventoryRfqModel) {
		logger.info("Method : restDeleteAction starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateActionInvoicePAram.getRfqDeleteParam(inventoryRfqModel);

			entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "restDeleteAction").setParameter("actionValue", value).execute();

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
		logger.info("Method : restDeleteAction ends");
		return response;
	}

	/**
	 * DAO Function to approve
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restApproveInvoice(InventoryActionInvoiceModel inventoryRfqModel) {
		logger.info("Method : restApproveInvoice starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = GenerateActionInvoicePAram.getRfqApproveParam(inventoryRfqModel);
			entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "restApproveInvoice").setParameter("actionValue", value).execute();

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
		logger.info("Method : restApproveInvoice ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<List<InventoryActionInvoiceModel>> getInvoicePdfDetails(String id,String organization,  String orgDivision) {
		logger.info("Method : getInvoicePdfDetails starts");
		List<InventoryActionInvoiceModel> patienttestdetails = new ArrayList<InventoryActionInvoiceModel>();

		JsonResponse<List<InventoryActionInvoiceModel>> resp = new JsonResponse<List<InventoryActionInvoiceModel>>();
		List<InventoryActionInvoiceModel> rs = new ArrayList<InventoryActionInvoiceModel>();
		InventoryActionInvoiceModel poList = new InventoryActionInvoiceModel();

		//List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();
		//List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();

		
		//List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();
		
		try {

			String value = "SET @p_invId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
					.setParameter("actionType", "getInvPDF").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[5] != null) {
					oa = DateFormatter.returnStringDate(m[5]);
				}
				Object startDate = null;
				if (m[8] != null) {
					startDate = DateFormatter.returnStringDate(m[8]);
				}

				Object invDate = null;
				if (m[1] != null) {
					invDate = DateFormatter.returnStringDate(m[1]);
				}
				Object activeDate = null;
				if (m[17] != null) {
					activeDate = DateFormatter.returnStringDate(m[17]);
				}
				Object completeDate = null;
				if (m[18] != null) {
					completeDate = DateFormatter.returnStringDate(m[18]);
				}
				Object onHoldDate = null;
				if (m[19] != null) {
					onHoldDate = DateFormatter.returnStringDate(m[19]);
				}
				InventoryActionInvoiceModel dropDownModel = new InventoryActionInvoiceModel(m[0], invDate, m[2], m[3],
						null, null, m[4], oa, m[6], m[7], startDate, m[9], m[10], m[11], m[12], m[13], m[14], m[15],
						m[16], activeDate, completeDate, onHoldDate, m[20],m[21],m[22],m[23],m[24],m[25],m[26],m[27],m[28]);
				logger.info("dropDownModel" + dropDownModel);
				patienttestdetails.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (patienttestdetails.isEmpty() == false) {
			List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();
		 String iD = patienttestdetails.get(0).getInvId();
			logger.info("IDDDD"+iD);
			try {

				List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("action_invoice_Routines")
						.setParameter("actionType", "getInvItemListpdf")
						.setParameter("actionValue", "SET @p_invId='" +  patienttestdetails.get(0).getInvId() + "';").getResultList();
				for (Object[] m : x1) {

					Object createdDate = null;
					if (m[10] != null) {
						createdDate = m[10].toString();
					}
				
					
					InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4], m[5],
							m[6], m[7], m[8], m[9], createdDate, m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18],
							m[19], m[20], m[21],m[22],m[23]);
					logger.info("productList" + productModel);
					productList.add(productModel);
				}
				logger.info("productList" + productList);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			patienttestdetails.get(0).setProductList(productList);
		}
	
		resp.setBody(patienttestdetails);
		logger.info("DaOOOOO================" + resp);
		logger.info("Method : getInvoicePdfDetails ends");

		return resp;
	}

}
