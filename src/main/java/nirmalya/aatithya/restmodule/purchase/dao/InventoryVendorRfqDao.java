package nirmalya.aatithya.restmodule.purchase.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateVendorRfqPAram;
import nirmalya.aatithya.restmodule.inventory.model.InventoryRfqVendorModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryActionRfqModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorRfqModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryVendorRfqDao {

	Logger logger = LoggerFactory.getLogger(InventoryVendorRfqDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	/*
	 * for action rfq view list
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryActionRfqModel> getVendorRfqViewList(String userId, String orgName, String orgDiv) {
		logger.info("Method : getVendorRfqViewList starts");
		List<InventoryActionRfqModel> getRequisitionTypeList = new ArrayList<InventoryActionRfqModel>();
		try {
			String value = "SET @p_vendorId='" + userId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("VendorRfqRoutines")
					.setParameter("actionType", "getVendorRfqViewList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[16] != null) {
					oa = m[16].toString();
				}
				Object createdon = null;
				if (m[19] != null) {
					createdon = m[19].toString();
				}
				Object activeDate = null;
				if (m[21] != null) {
					activeDate = m[21].toString();
				}
				Object onHoldDate = null;
				if (m[22] != null) {
					onHoldDate = m[22].toString();
				}
				Object completeDate = null;
				if (m[23] != null) {
					completeDate = m[23].toString();
				}
				InventoryActionRfqModel dropDownModel = new InventoryActionRfqModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], oa, m[17], m[18], createdon,
						m[20], activeDate, onHoldDate, completeDate, null);

				if (dropDownModel.getApproveStatus().contentEquals("1")) {
					dropDownModel.setApproveStatus("Approve");
				} else if (dropDownModel.getApproveStatus().contentEquals("0")) {
					dropDownModel.setApproveStatus("Active");
				} else if (dropDownModel.getApproveStatus().contentEquals("2")) {
					dropDownModel.setApproveStatus("Pending");
				} else if (dropDownModel.getApproveStatus().contentEquals("3")) {
					dropDownModel.setApproveStatus("Rejected ");
				}
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getVendorRfqViewList ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to Add rfq
	 *
	 */

	@SuppressWarnings({ "unchecked" })
	public ResponseEntity<JsonResponse<List<InventoryVendorRfqModel>>> restAddRfq(
			List<InventoryVendorRfqModel> inventoryRfqModel) {
		logger.info("Method : restAddRequisition starts");
		boolean validation = true;
		JsonResponse<List<InventoryVendorRfqModel>> resp = new JsonResponse<List<InventoryVendorRfqModel>>();
		List<InventoryVendorRfqModel> listData = new ArrayList<InventoryVendorRfqModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		resp.setMessage("");
		resp.setCode("");
		String errorCode = "Field Validation Error";
		for (InventoryVendorRfqModel l : inventoryRfqModel) {

			if (l.getLocation() == null || l.getLocation() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please Enter Location.");
				break;
			} else if (l.getDesc() == null || l.getDesc() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please Enter Description.");
				break;
			} else if (l.getReqPrior() == null || l.getReqPrior() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please Enter Date.");
				break;
			} else if (l.getReqType() == null || l.getReqType() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please Select Requisition Type.");
				break;
			} else if (l.getItemId() == null || l.getItemId() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please Select Product.");
				break;
			} else if (l.getSku() == null || l.getSku() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please SKU .");
				break;
			} else if (l.getUom() == null || l.getUom() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("please select UOM.");
				break;
			} else if (l.getQty() == null) {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("please Enter Quantity.");
				break;
			}
		}

		if (validation) {

			try {
				String value = GenerateVendorRfqPAram.getVendorRfqParam(inventoryRfqModel);
				if (inventoryRfqModel.get(0).getVendorRfqId() != null
						&& inventoryRfqModel.get(0).getVendorRfqId() != "") {

					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("VendorRfqRoutines")
							.setParameter("actionType", "modifyVendorRfq").setParameter("actionValue", value)
							.getResultList();

					for (Object[] m : x) {
						Object oa = null;
						if (m[16] != null) {
							oa = m[16].toString();
						}
						Object createdOn = null;
						if (m[20] != null) {
							createdOn = m[20].toString();
						}
						Object openDate = null;
						if (m[22] != null) {
							openDate = m[22].toString();
						}
						Object submittedDate = null;
						if (m[23] != null) {
							submittedDate = m[23].toString();
						}
						Object closedDate = null;
						if (m[24] != null) {
							closedDate = m[24].toString();
						}
						InventoryVendorRfqModel dropDownModel = new InventoryVendorRfqModel(m[0], m[1], m[2], m[3],
								m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], oa, m[17],
								m[18], m[19], createdOn, m[21], openDate, submittedDate, closedDate, m[25], m[26],
								m[27], m[28]);
						listData.add(dropDownModel);
					}

					if (listData != null) {
						String values = "SET @p_vend_rfq_id='" + listData.get(0).getVendorRfqId() + "';";

						List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("VendorRfqRoutines")
								.setParameter("actionType", "getVendorDocs").setParameter("actionValue", values)
								.getResultList();
						for (Object[] m1 : x1) {

							InventoryVendorDocumentModel dropDownModel1 = new InventoryVendorDocumentModel(m1[0], m1[1],
									m1[2]);
							docList.add(dropDownModel1);
						}
						listData.get(0).setDocumentList(docList);
					}

				} else {
					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("VendorRfqRoutines")
							.setParameter("actionType", "addNewVendorRfq").setParameter("actionValue", value)
							.getResultList();
					for (Object[] m : x) {
						Object oa = null;
						if (m[16] != null) {
							oa = m[16].toString();
						}
						Object createdOn = null;
						if (m[20] != null) {
							createdOn = m[20].toString();
						}
						Object openDate = null;
						if (m[22] != null) {
							openDate = m[22].toString();
						}
						Object submittedDate = null;
						if (m[23] != null) {
							submittedDate = m[23].toString();
						}
						Object closedDate = null;
						if (m[24] != null) {
							closedDate = m[24].toString();
						}
						InventoryVendorRfqModel dropDownModel = new InventoryVendorRfqModel(m[0], m[1], m[2], m[3],
								m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], oa, m[17],
								m[18], m[19], createdOn, m[21], openDate, submittedDate, closedDate, m[25], m[26],
								m[27], m[28]);
						listData.add(dropDownModel);
					}
					if (listData != null) {
						String values = "SET @p_vend_rfq_id='" + listData.get(0).getVendorRfqId() + "';";
						List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("VendorRfqRoutines")
								.setParameter("actionType", "getVendorDocs").setParameter("actionValue", values)
								.getResultList();
						for (Object[] m1 : x1) {

							InventoryVendorDocumentModel dropDownModel1 = new InventoryVendorDocumentModel(m1[0], m1[1],
									m1[2]);
							docList.add(dropDownModel1);
						}
						listData.get(0).setDocumentList(docList);
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
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<InventoryVendorRfqModel>>> response = new ResponseEntity<JsonResponse<List<InventoryVendorRfqModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : add item Requisition ends");
		return response;
	}

	/**
	 * DAO Function to for rfq edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryVendorRfqModel> getVendorRfqEdit(String id, String userId, String orgName, String orgDiv) {
		logger.info("Method : getVendorRfqEdit starts");
		List<InventoryVendorRfqModel> getRequisitionTypeList = new ArrayList<InventoryVendorRfqModel>();
		String values = "SET @P_req='" + id + "',@p_vendor='" + userId + "',@p_org='" + orgName + "',@p_orgDiv='"
				+ orgDiv + "';";
		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("VendorRfqRoutines")
					.setParameter("actionType", "getRfqEdit").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[15] != null) {
					oa = m[15].toString();
				}
				Object createdOn = null;
				if (m[19] != null) {
					createdOn = m[19].toString();
				}

				InventoryVendorRfqModel dropDownModel = new InventoryVendorRfqModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], oa, m[16], m[17], m[18], createdOn,
						m[20], m[21]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (getRequisitionTypeList != null) {
			if (getRequisitionTypeList.get(0).getModelName() != null) {
				List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
				getRequisitionTypeList = new ArrayList<InventoryVendorRfqModel>();
				try {

					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("VendorRfqRoutines")
							.setParameter("actionType", "getVendorRfqDetails").setParameter("actionValue", values)
							.getResultList();

					for (Object[] m : x) {
						Object oa = null;
						if (m[16] != null) {
							oa = m[16].toString();
						}
						Object createdOn = null;
						if (m[20] != null) {
							createdOn = m[20].toString();
						}
						Object openDate = null;
						if (m[22] != null) {
							openDate = m[22].toString();
						}
						Object submittedDate = null;
						if (m[23] != null) {
							submittedDate = m[23].toString();
						}
						Object closedDate = null;
						if (m[24] != null) {
							closedDate = m[24].toString();
						}
						InventoryVendorRfqModel dropDownModel = new InventoryVendorRfqModel(m[0], m[1], m[2], m[3],
								m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], oa, m[17],
								m[18], m[19], createdOn, m[21], openDate, submittedDate, closedDate, m[25], m[26], null,
								null);
						getRequisitionTypeList.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					String subValues = "SET @p_vend_rfq_id='" + getRequisitionTypeList.get(0).getVendorRfqId() + "';";
					List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("VendorRfqRoutines")
							.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
							.getResultList();
					for (Object[] m : x1) {

						InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
						docList.add(dropDownModel);
					}
				} catch (Exception e) {

				}
				getRequisitionTypeList.get(0).setDocumentList(docList);
			}

		}

		logger.info("Method : getVendorRfqEdit ends" + getRequisitionTypeList);
		return getRequisitionTypeList;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewVendorRFQData(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewVendorRFQData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("VendorRfqRoutines")
					.setParameter("actionType", "viewVendorRFQData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewVendorRFQData Dao ends");
		return resp;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestPurchaseQuotationModel> viewRFQVendorEdit(String id, String orgName, String orgDivision,
			String userId) {
		logger.info("Method : viewRFQVendorEdit starts");
		List<RestPurchaseQuotationModel> getRequisitionTypeList = new ArrayList<RestPurchaseQuotationModel>();
		List<InventoryRfqVendorModel> vendorList = new ArrayList<InventoryRfqVendorModel>();
		try {
			String values = "SET @p_rfqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "' ,@p_userId='" + userId + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("VendorRfqRoutines")
					.setParameter("actionType", "viewRFQVendorEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					Object recvDate = null;
					if (m[4] != null) {
						recvDate = m[4].toString();
					}
					Object createdOn = null;
					if (m[13] != null) {
						createdOn = m[13].toString();
					}
					RestPurchaseQuotationModel dropDownModel = new RestPurchaseQuotationModel(m[0], m[1], m[2], m[3],
							recvDate, m[5], m[6], m[7], m[8],m[9], m[10], m[11].toString(), m[12], createdOn, m[14],
							m[15], m[16], m[17], m[18], m[19], null, null, null, null, m[20], m[21], null, null, null,null);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {

				List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("RfqRoutines")
						.setParameter("actionType", "getVendorEdit1").setParameter("actionValue", values)
						.getResultList();

				for (Object[] m : x1) {
					Object oa = null;
					if (m[8] != null) {
						oa = m[8].toString();
					}
					InventoryRfqVendorModel dropDownModel = new InventoryRfqVendorModel(m[0], m[1], m[2], m[3], m[4],
							null, m[5], m[6], m[7], oa, m[9]);
					vendorList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (getRequisitionTypeList != null) {
				getRequisitionTypeList.get(0).setVendorList(vendorList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : viewRFQVendorEdit ends");
		return getRequisitionTypeList;
	}
	// approve

	public JsonResponse<DropDownModel> approvePorderForVendor(String approveStatus, String poId, String orgName,
			String orgDivision, String userId) {
		logger.info("Method : approvePorderForVendor starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_approveStatus='" + approveStatus + "',@p_poId='" + poId + "', @p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "' ;";

			entityManager.createNamedStoredProcedureQuery("VendorRfqRoutines")
					.setParameter("actionType", "approvePorder").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approvePorderForVendor ends");
		return resp;
	}

}
