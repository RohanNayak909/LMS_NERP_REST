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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.model.InventoryPoModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryVendorPoDao {
	Logger logger = LoggerFactory.getLogger(InventoryVendorPoDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	/**
	 * for view po list
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryPoModel> getVendorPoViewList(String userId, String orgName, String orgDiv) {
		logger.info("Method : getVendorPoViewList starts");
		List<InventoryPoModel> inventoryPoModelList = new ArrayList<InventoryPoModel>();
		String value = "SET @p_VendorId='" + userId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("vendorPoRoutines")
					.setParameter("actionType", "getVendorPoViewList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[13] != null) {
					oa = m[13].toString();
				}
				Object startDate = null;
				if (m[14] != null) {
					startDate = m[14].toString();
				}
				Object expireDate = null;
				if (m[15] != null) {
					expireDate = m[15].toString();
				}
				Object createdon = null;
				if (m[20] != null) {
					createdon = m[20].toString();
				}
				Object approveDate = null;
				if (m[21] != null) {
					approveDate = m[21].toString();
				}
				Object onHoldDate = null;
				if (m[22] != null) {
					onHoldDate = m[22].toString();
				}
				Object completeDate = null;
				if (m[23] != null) {
					completeDate = m[23].toString();
				}
				InventoryPoModel inventoryPoModel = new InventoryPoModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], oa, startDate, expireDate, m[16], m[17], m[18], m[19],
						createdon, approveDate, completeDate, onHoldDate, m[24], m[25], m[26], null, null);

				if (inventoryPoModel.getApproveStatus().contentEquals("1")) {
					inventoryPoModel.setApproveStatus("Approve");
				} else if (inventoryPoModel.getApproveStatus().contentEquals("0")) {
					inventoryPoModel.setApproveStatus("Active");
				} else if (inventoryPoModel.getApproveStatus().contentEquals("2")) {
					inventoryPoModel.setApproveStatus("Pending");
				} else if (inventoryPoModel.getApproveStatus().contentEquals("3")) {
					inventoryPoModel.setApproveStatus("Rejected ");
				}
				inventoryPoModelList.add(inventoryPoModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getVendorPoViewList ends");
		return inventoryPoModelList;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> viewPurchaseOrderForVendor(String orgName,
			String orgDivision, String userId) {
		logger.info("Method : viewPurchaseOrderForVendor Dao startss");

		List<RestPurchaseOrderModel> getAllemployee = new ArrayList<RestPurchaseOrderModel>();
		JsonResponse<List<RestPurchaseOrderModel>> resp = new JsonResponse<List<RestPurchaseOrderModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "' ;";

			logger.info("Dataaa" + values);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("vendorPoRoutines")
					.setParameter("actionType", "viewPurchaseOrder").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestPurchaseOrderModel viewdemo = new RestPurchaseOrderModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewPurchaseOrderForVendor Dao ends"+response);

		return response;

	}

	// approve

	public JsonResponse<DropDownModel> approvePorderForVendor(String approveStatus, String poId, String orgName,
			String orgDivision, String userId) {
		logger.info("Method : approvePorderForVendor starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_approveStatus='" + approveStatus + "',@p_poId='" + poId + "', @p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "' ;";

			entityManager.createNamedStoredProcedureQuery("vendorPoRoutines")
					.setParameter("actionType", "approvePorderForVendor").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approvePorderForVendor ends");
		return resp;
	}

	// reject

	public JsonResponse<DropDownModel> rejectPorderForVendor(String rejectStatus, String poId, String orgName,
			String orgDivision, String userId) {
		logger.info("Method : rejectPorderForVendor starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_rejectStatus='" + rejectStatus + "',@p_poId='" + poId + "', @p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "' ;";

			entityManager.createNamedStoredProcedureQuery("vendorPoRoutines")
					.setParameter("actionType", "rejectPorderForVendor").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : rejectPorderForVendor ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<RestPurchaseOrderModel> getdeliverychallandata(String id, String sku, String gatePass, String orgName,
			String orgDiv) {
		logger.info("Method : getdeliverychallandata starts");
		logger.info("getdeliverychallandata" + gatePass);
		List<RestPurchaseOrderModel> getRequisitionTypeList = new ArrayList<RestPurchaseOrderModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();

			try {
				String values = "SET @p_poId='" + id + "',@p_sku='(" + sku + ")',@p_org='" + orgName + "',@p_orgDiv='"
						+ orgDiv + "';";
				List<Object[]> x = entityManager.createNamedStoredProcedureQuery("vendorPoRoutines")
						.setParameter("actionType", "getdeliverychallandata").setParameter("actionValue", values).getResultList();
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
						Object tdsmat = null;
						if (m[48] != null) {
							tdsmat = m[48].toString();
						}else {
							tdsmat="0.00";
						}
						RestPurchaseOrderModel dropDownModel = new RestPurchaseOrderModel(m[0], m[1], m[2], createdOn1,
								m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
								m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28],
								m[29], m[30], createdOn, m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39], m[40],
								m[41], m[42], m[43], m[44], m[45],m[46],m[47],tdsmat);
						getRequisitionTypeList.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					String subValues = "SET @p_poId='" + getRequisitionTypeList.get(0).getPoId() + "';";
					List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("vendorPoRoutines")
							.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
							.getResultList();
					for (Object[] m : x1) {

						InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
						docList.add(dropDownModel);
					}
				} catch (Exception e) {

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("Method : getdeliverychallandata ends");
		return getRequisitionTypeList;
	}
	
	
	/*
	 *  viewPoEditForVendor
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestPurchaseOrderModel> viewPoEditForVendor(String id, String orgName, String orgDiv) {
		logger.info("Method : viewPoEditForVendor starts");
		List<RestPurchaseOrderModel> getRequisitionTypeList = new ArrayList<RestPurchaseOrderModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_poId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("vendorPoRoutines").setParameter("actionType", "viewPoEditForVendor")
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
					Object tdsmat = null;
					if (m[50] != null) {
						tdsmat = m[50].toString();
					}else {
						tdsmat="0.00";
					}
					RestPurchaseOrderModel dropDownModel = new RestPurchaseOrderModel(m[0], m[1], m[2], createdOn1,
							m[4], m[5], m[6], m[7], m[8], null, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], null, m[25], m[26], m[27], m[28],
							m[29], null, m[30], createdOn, null, null, m[32], m[33], m[34], m[35], m[36], m[37], null,
							m[38], null, m[39], m[40], null, null, m[41], m[42], null, null, m[43],m[44], m[45], m[46]
									, m[47],m[48],m[49],tdsmat,m[51],m[52]);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_poId='" + getRequisitionTypeList.get(0).getPoId() + "';";
				List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("vendorPoRoutines")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {
					InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
					docList.add(dropDownModel);
				}
			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("Method : viewPoEditForVendor ends"+getRequisitionTypeList);
		return getRequisitionTypeList;
	}
	
	

}
