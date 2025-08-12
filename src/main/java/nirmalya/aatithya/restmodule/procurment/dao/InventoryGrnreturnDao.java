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
import nirmalya.aatithya.restmodule.common.utils.GenerateGoodsReceiveNoteParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 
import nirmalya.aatithya.restmodule.procurment.model.InventoryGoodsReturnModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryGrnreturnDao {
	Logger logger = LoggerFactory.getLogger(InventoryGrnreturnDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	/**
	 * for view po list
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryGoodsReturnModel> getGrnViewList(String orgName, String orgDiv) {
		logger.info("Method : getGrnViewList starts");
		List<InventoryGoodsReturnModel> InventoryGoodsReturnModelList = new ArrayList<InventoryGoodsReturnModel>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("execute_grn_return_Routines")
					.setParameter("actionType", "getGrnReturnViewList").setParameter("actionValue", values).getResultList();

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
				InventoryGoodsReturnModel inventoryGoodsReturnModel = new InventoryGoodsReturnModel(m[0], invDate, m[2],
						m[3], poDate, dispatchDate, m[6], m[7], m[8], estDeliveryDate, m[10], m[11], m[12], createdon,
						approveDate, onHoldDate, completeDate, m[17], m[18], m[19], m[20], m[21], m[22]);

				if (inventoryGoodsReturnModel.getStatus().contentEquals("1")) {
					inventoryGoodsReturnModel.setStatus("Approve");
				} else if (inventoryGoodsReturnModel.getStatus().contentEquals("0")) {
					inventoryGoodsReturnModel.setStatus("Created");
				} else if (inventoryGoodsReturnModel.getStatus().contentEquals("2")) {
					inventoryGoodsReturnModel.setStatus("OnHold");
				} else if (inventoryGoodsReturnModel.getStatus().contentEquals("3")) {
					inventoryGoodsReturnModel.setStatus("Completed ");
				}
				inventoryGoodsReturnModel.setTotalOutStandingQty(
						inventoryGoodsReturnModel.getTotalInvQty() - inventoryGoodsReturnModel.getTotalDnQty());
				inventoryGoodsReturnModel.setTotalNotReceiveQty(
						inventoryGoodsReturnModel.getTotalDnQty() - inventoryGoodsReturnModel.getTotalReceiveQty());
				InventoryGoodsReturnModelList.add(inventoryGoodsReturnModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getGrnViewList ends");
		return InventoryGoodsReturnModelList;
	}

	/**
	 * DAO Function to for po edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public InventoryGoodsReturnModel getGrnReturnEdit(String id,String orgName, String orgDiv) {
		logger.info("Method : getGrnReturnEdit starts");
		InventoryGoodsReturnModel poList = new InventoryGoodsReturnModel();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();
		String value = "SET @p_grnRetId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
	
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("execute_grn_return_Routines")
					.setParameter("actionType", "getGrnReturnEdit").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				Object createdon = null;
				if (m[4] != null) {
					createdon = m[4].toString();
				}
				Object approveDate = null;
				if (m[5] != null) {
					approveDate = m[5].toString();
				}
				Object onHoldDate = null;
				if (m[6] != null) {
					onHoldDate = m[6].toString();
				}
				Object completeDate = null;
				if (m[7] != null) {
					completeDate = m[7].toString();
				}
				InventoryGoodsReturnModel inventoryGRNModel = new InventoryGoodsReturnModel(m[0], m[1], m[2], m[3],
						createdon, approveDate, onHoldDate, completeDate,null,null);
				poList = inventoryGRNModel;

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		try {
			String val = "SET @p_grnRetId='" + id + "';";
			List<Object[]> y = entityManager.createNamedStoredProcedureQuery("execute_grn_return_Routines")
					.setParameter("actionType", "getGrnRetItemList").setParameter("actionValue", val).getResultList();

			for (Object[] m : y) {
				Object createdDate = null;
				if (m[5] != null) {
					createdDate = m[5].toString();
				}
				InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4],
						createdDate);
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
				String values = "SET @p_grnRetId='" + id + "';";
				List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("execute_grn_return_Routines")
						.setParameter("actionType", "getdocsList").setParameter("actionValue", values).getResultList();
				for (Object[] m1 : x1) {

					InventoryVendorDocumentModel dropDownModel1 = new InventoryVendorDocumentModel(m1[0], m1[1], m1[2]);
					docList.add(dropDownModel1);
				}
				poList.setDocumentList(docList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		logger.info("Method : getGrnReturnEdit ends");
		return poList;

	}

	/**
	 * DAO Function to Add po
	 *
	 */
	@SuppressWarnings({ "unchecked" })
	public ResponseEntity<JsonResponse<InventoryGoodsReturnModel>> restModifyGrn(
			InventoryGoodsReturnModel inventoryGRNModel) {
		logger.info("Method : restAddGrn starts");
		boolean validation = true;
		JsonResponse<InventoryGoodsReturnModel> resp = new JsonResponse<InventoryGoodsReturnModel>();
		List<InventoryGoodsReturnModel> listData = new ArrayList<InventoryGoodsReturnModel>();
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

			try {
				String value = GenerateGoodsReceiveNoteParam.getGrnReturnParam(inventoryGRNModel);

				List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();

				if (inventoryGRNModel.getNoteId() != null && inventoryGRNModel.getNoteId() != "") {

					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("execute_grn_return_Routines")
							.setParameter("actionType", "modifyGrnReturn").setParameter("actionValue", value)
							.getResultList();
					for (Object[] m : x) {

						Object createdon = null;
						if (m[4] != null) {
							createdon = m[4].toString();
						}
						Object approveDate = null;
						if (m[5] != null) {
							approveDate = m[5].toString();
						}
						Object onHoldDate = null;
						if (m[6] != null) {
							onHoldDate = m[6].toString();
						}
						Object completeDate = null;
						if (m[7] != null) {
							completeDate = m[7].toString();
						}
						InventoryGoodsReturnModel inventoryGRNModels = new InventoryGoodsReturnModel(m[0], m[1], m[2],
								m[3], createdon, approveDate, onHoldDate, completeDate,m[8],m[9]);
						listData.add(inventoryGRNModels);

					}
					if (listData != null) {
						try {
							String val = "SET @p_grnRetId='" + listData.get(0).getReturnNoteId() + "';";

							List<Object[]> y = entityManager
									.createNamedStoredProcedureQuery("execute_grn_return_Routines")
									.setParameter("actionType", "getGrnRetItemList").setParameter("actionValue", val)
									.getResultList();

							for (Object[] m : y) {
								Object createdDate = null;
								if (m[5] != null) {
									createdDate = m[5].toString();
								}
								InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3],
										m[4], createdDate);
								productList.add(productModel);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
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

			try {
				if (listData != null) {
					String values = "SET @p_grnId='" + listData.get(0).getReturnNoteId() + "';";

					List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("execute_grn_return_Routines")
							.setParameter("actionType", "getdocsList").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m1 : x1) {

						InventoryVendorDocumentModel dropDownModel1 = new InventoryVendorDocumentModel(m1[0], m1[1],
								null);
						docList.add(dropDownModel1);
					}
					listData.get(0).setDocumentList(docList);
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}

			resp.setBody(listData.get(0));

		}
		ResponseEntity<JsonResponse<InventoryGoodsReturnModel>> response = new ResponseEntity<JsonResponse<InventoryGoodsReturnModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : restAddGrn ends"+response);
		return response;
	}

	/**
	 * DAO Function to approve
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> completeGrn(InventoryGoodsReturnModel inventoryRfqModel) {
		logger.info("Method : completeGrn starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = GenerateGoodsReceiveNoteParam.getGrnReturnCompleteParam(inventoryRfqModel);
			entityManager.createNamedStoredProcedureQuery("execute_grn_return_Routines")
					.setParameter("actionType", "completeGrnReturn").setParameter("actionValue", value).execute();

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
}
