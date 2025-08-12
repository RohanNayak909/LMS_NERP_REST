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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateGoodsReceiveNoteParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.model.InventoryGRNModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryGoodsReturnModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryGrnDao {

	Logger logger = LoggerFactory.getLogger(InventoryGrnDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	/* get delivery method dropdown */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDeliveryMethodList() {
		logger.info("Method : getDeliveryMethodList starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("execute_grn_Routines")
					.setParameter("actionType", "getDeliveryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDeliveryMethodList ends");
		return getRequisitionTypeList;
	}

	/**
	 * for view po list
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryGRNModel> getGrnViewList(String orgName, String orgDiv) {
		logger.info("Method : getGrnViewList starts");
		List<InventoryGRNModel> inventoryGRNModelList = new ArrayList<InventoryGRNModel>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("execute_grn_Routines")
					.setParameter("actionType", "getGrnViewList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object invDate = null;
				if (m[1] != null) {
					invDate = m[1].toString();
				}
				Object poDate = null;
				if (m[4] != null) {
					poDate = m[4].toString();
				}
				Object dispatchDate = null;
				if (m[5] != null) {
					dispatchDate = m[5].toString();
				}
				Object createdon = null;
				if (m[13] != null) {
					createdon = m[13].toString();
				}
				Object approveDate = null;
				if (m[14] != null) {
					approveDate = m[14].toString();
				}
				Object onHoldDate = null;
				if (m[15] != null) {
					onHoldDate = m[15].toString();
				}
				Object completeDate = null;
				if (m[16] != null) {
					completeDate = m[16].toString();
				}
				Object estDeliveryDate = null;
				if (m[9] != null) {
					estDeliveryDate = m[9].toString();
				}
				InventoryGRNModel inventoryGRNModel = new InventoryGRNModel(m[0], invDate, m[2], m[3], poDate,
						dispatchDate, m[6], m[7], m[8], estDeliveryDate, m[10], m[11], m[12], createdon, approveDate,
						onHoldDate, completeDate, m[17], m[18], m[19], m[20],null,null);

				if (inventoryGRNModel.getStatus().contentEquals("1")) {
					inventoryGRNModel.setStatus("Approve");
				} else if (inventoryGRNModel.getStatus().contentEquals("0")) {
					inventoryGRNModel.setStatus("Created");
				} else if (inventoryGRNModel.getStatus().contentEquals("2")) {
					inventoryGRNModel.setStatus("OnHold");
				} else if (inventoryGRNModel.getStatus().contentEquals("3")) {
					inventoryGRNModel.setStatus("Completed ");
				}
				inventoryGRNModel
						.setTotalOutStandingQty(inventoryGRNModel.getTotalInvQty() - inventoryGRNModel.getTotalDnQty());
				inventoryGRNModel.setTotalNotReceiveQty(
						inventoryGRNModel.getTotalDnQty() - inventoryGRNModel.getTotalReceiveQty());
				inventoryGRNModelList.add(inventoryGRNModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getGrnViewList ends");
		return inventoryGRNModelList;
	}

	/**
	 * DAO Function to for po edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public InventoryGRNModel geGrnEdit(String id,String orgName, String orgDiv) {
		logger.info("Method : geGrnEdit starts");
		InventoryGRNModel poList = new InventoryGRNModel();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();
		String value = "SET @p_grnId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("aaaaaaaaaaaaaaaaaaaaaaa"+value);

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("execute_grn_Routines")
					.setParameter("actionType", "getGrnEdit").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object invDate = null;
				if (m[1] != null) {
					invDate = m[1].toString();
				}
				Object poDate = null;
				if (m[4] != null) {
					poDate = m[4].toString();
				}
				Object dispatchDate = null;
				if (m[5] != null) {
					dispatchDate = m[5].toString();
				}
				Object createdon = null;
				if (m[13] != null) {
					createdon = m[13].toString();
				}
				Object approveDate = null;
				if (m[14] != null) {
					approveDate = m[14].toString();
				}
				Object onHoldDate = null;
				if (m[15] != null) {
					onHoldDate = m[15].toString();
				}
				Object completeDate = null;
				if (m[16] != null) {
					completeDate = m[16].toString();
				}
				Object estDeliveryDate = null;
				if (m[9] != null) {
					estDeliveryDate = m[9].toString();
				}
				InventoryGRNModel inventoryGRNModel = new InventoryGRNModel(m[0], invDate, m[2], m[3], poDate,
						dispatchDate, m[6], m[7], m[8], estDeliveryDate, m[10], m[11], m[12], createdon, approveDate,
						onHoldDate, completeDate, m[17], m[18], m[19], m[20],null,null);
				inventoryGRNModel
						.setTotalOutStandingQty(inventoryGRNModel.getTotalInvQty() - inventoryGRNModel.getTotalDnQty());
				inventoryGRNModel.setTotalNotReceiveQty(
						inventoryGRNModel.getTotalDnQty() - inventoryGRNModel.getTotalReceiveQty());
				poList = inventoryGRNModel;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		try {
			String val = "SET @p_grnId='" + poList.getNoteId() + "';";
			List<Object[]> y = entityManager.createNamedStoredProcedureQuery("execute_grn_Routines")
					.setParameter("actionType", "getGrnItemList").setParameter("actionValue", val).getResultList();

			for (Object[] m : y) {
				Object createdDate = null;
				if (m[9] != null) {
					createdDate = m[9].toString();
				}
				InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], createdDate, m[10], m[11], m[12], m[13], m[14]);
				productModel.setOutstandQty(productModel.getInvoiceQty() - productModel.getQtyDelivered());
				productList.add(productModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (poList != null) {
			poList.setProductList(productList);
		}
		try {
			if (poList != null) {
				String values = "SET @p_grnId='" + poList.getNoteId() + "';";
				List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("execute_grn_Routines")
						.setParameter("actionType", "getdocsList").setParameter("actionValue", values).getResultList();
				for (Object[] m1 : x1) {

					InventoryVendorDocumentModel dropDownModel1 = new InventoryVendorDocumentModel(m1[0], m1[1], null);
					docList.add(dropDownModel1);
				}
				poList.setDocumentList(docList);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.info("Method : geGrnEdit ends");
		return poList;

	}

	/**
	 * DAO Function to Add po
	 *
	 */
	@SuppressWarnings({ "unchecked" })
	public ResponseEntity<JsonResponse<InventoryGRNModel>> restAddGrn(InventoryGRNModel inventoryGRNModel) {
		logger.info("Method : restAddGrn starts");
		boolean validation = true;
		JsonResponse<InventoryGRNModel> resp = new JsonResponse<InventoryGRNModel>();
		List<InventoryGRNModel> listData = new ArrayList<InventoryGRNModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		resp.setMessage("");
		resp.setCode("");
		String errorCode = "Field Validation Error";

		for (InventoryProductModel l : inventoryGRNModel.getProductList()) {
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

			} else if (l.getReceiveQty() == null) {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("please Enter Receive Quantity.");
				break;
			}
		}
		if (validation) {

			try {
				String value = GenerateGoodsReceiveNoteParam.getGrnParam(inventoryGRNModel);

				List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();

				if (inventoryGRNModel.getNoteId() != null && inventoryGRNModel.getNoteId() != "") {

					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("execute_grn_Routines")
							.setParameter("actionType", "modifyGrn").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {
						Object invDate = null;
						if (m[1] != null) {
							invDate = m[1].toString();
						}
						Object poDate = null;
						if (m[4] != null) {
							poDate = m[4].toString();
						}
						Object dispatchDate = null;
						if (m[5] != null) {
							dispatchDate = m[5].toString();
						}
						Object createdon = null;
						if (m[13] != null) {
							createdon = m[13].toString();
						}
						Object approveDate = null;
						if (m[14] != null) {
							approveDate = m[14].toString();
						}
						Object onHoldDate = null;
						if (m[15] != null) {
							onHoldDate = m[15].toString();
						}
						Object completeDate = null;
						if (m[16] != null) {
							completeDate = m[16].toString();
						}
						Object estDeliveryDate = null;
						if (m[9] != null) {
							estDeliveryDate = m[9].toString();
						}
						InventoryGRNModel inventoryGRNModel1 = new InventoryGRNModel(m[0], invDate, m[2], m[3], poDate,
								dispatchDate, m[6], m[7], m[8], estDeliveryDate, m[10], m[11], m[12], createdon,
								approveDate, onHoldDate, completeDate, m[17], m[18], m[19], m[20],m[21],m[22]);
						inventoryGRNModel1.setTotalOutStandingQty(
								inventoryGRNModel1.getTotalInvQty() - inventoryGRNModel1.getTotalDnQty());
						inventoryGRNModel1.setTotalNotReceiveQty(
								inventoryGRNModel1.getTotalDnQty() - inventoryGRNModel1.getTotalReceiveQty());
						listData.add(inventoryGRNModel1);
					}

					try {

						List<Object[]> y = entityManager.createNamedStoredProcedureQuery("execute_grn_Routines")
								.setParameter("actionType", "getGrnItemList")
								.setParameter("actionValue", "SET @p_grnId='" + listData.get(0).getNoteId() + "';")
								.getResultList();

						for (Object[] m : y) {
							Object createdDate = null;
							if (m[9] != null) {
								createdDate = m[9].toString();
							}
							InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4],
									m[5], m[6], m[7], m[8], createdDate, m[10], m[11], m[12], m[13], m[14]);
							productList.add(productModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					if (listData != null) {
						String values = "SET @p_grnId='" + listData.get(0).getNoteId() + "';";
						List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("execute_grn_Routines")
								.setParameter("actionType", "getdocsList").setParameter("actionValue", values)
								.getResultList();
						for (Object[] m1 : x1) {

							InventoryVendorDocumentModel dropDownModel1 = new InventoryVendorDocumentModel(m1[0], m1[1],
									null);
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
		ResponseEntity<JsonResponse<InventoryGRNModel>> response = new ResponseEntity<JsonResponse<InventoryGRNModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : restAddGrn ends"+response);
		return response;
	}

	/**
	 * DAO Function to approve
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> completeGrn(InventoryGRNModel inventoryRfqModel) {
		logger.info("Method : completeGrn starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = GenerateGoodsReceiveNoteParam.getGrnCompleteParam(inventoryRfqModel);
			entityManager.createNamedStoredProcedureQuery("execute_grn_Routines")
					.setParameter("actionType", "completeGrn").setParameter("actionValue", value).execute();

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
		logger.info("Method : completeGrn ends");
		return response;
	}

	/**
	 * DAO Function to Add po
	 *
	 */
	public ResponseEntity<JsonResponse<InventoryGoodsReturnModel>> restAddGrnReturn(
			InventoryGoodsReturnModel inventoryGoodsReturnModel) {
		logger.info("Method : restAddGrnReturn starts");
		boolean validation = true;
		JsonResponse<InventoryGoodsReturnModel> resp = new JsonResponse<InventoryGoodsReturnModel>();
		resp.setMessage("");
		resp.setCode("");
		String errorCode = "Field Validation Error";

		for (InventoryProductModel l : inventoryGoodsReturnModel.getProductList()) {
			if (l.getSku() == null || l.getSku() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please SKU .");
				break;
			} else if (l.getItemId() == null || l.getItemId() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please Select Product.");
				break;
			} else if (l.getReturnQty() == null) {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("please Enter Return Quantity.");
				break;
			}
		}
		if (validation) {

			String value = "";
			try {
				value = GenerateGoodsReceiveNoteParam.getGrnReturnParam(inventoryGoodsReturnModel);
			} catch (Exception e) {
				value = "";
				logger.error(e.getMessage());
			}
			try {
				if (value != null && value != "")
					entityManager.createNamedStoredProcedureQuery("execute_grn_Routines")
							.setParameter("actionType", "addGrnReturn").setParameter("actionValue", value).execute();

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

		}
		ResponseEntity<JsonResponse<InventoryGoodsReturnModel>> response = new ResponseEntity<JsonResponse<InventoryGoodsReturnModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : restAddGrnReturn ends");
		return response;
	}
}
