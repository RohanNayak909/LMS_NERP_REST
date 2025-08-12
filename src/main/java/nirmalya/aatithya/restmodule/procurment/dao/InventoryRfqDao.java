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
import nirmalya.aatithya.restmodule.common.utils.GenerateRfqParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRfqModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRfqVendorModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryRfqDao {
	Logger logger = LoggerFactory.getLogger(InventoryRfqDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<InventoryRfqVendorModel> getVendorList(String orgName, String orgDiv) {
		logger.info("Method : getVendorList starts");
		List<InventoryRfqVendorModel> getRequisitionTypeList = new ArrayList<InventoryRfqVendorModel>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getVendorList").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				Object oa = null;
				if (m[6] != null) {
					oa = m[6].toString();
				}
				InventoryRfqVendorModel dropDownModel = new InventoryRfqVendorModel(m[0], m[1], m[2], m[3], m[4], m[5],
						null, null, null, oa, m[7]);

				if (dropDownModel.getCandidates() == null) {
					dropDownModel.setCandidates(new Double(0));
				}
				if (dropDownModel.getClosed() == null) {
					dropDownModel.setClosed(new Double(0));
				}
				if (dropDownModel.getReqSent() == null) {
					dropDownModel.setReqSent(new Double(0));
				}
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getVendorList ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to Add rfq
	 *
	 */

	@SuppressWarnings({ "unused", "unchecked" })
	public ResponseEntity<JsonResponse<List<InventoryRfqModel>>> restAddRfq(List<InventoryRfqModel> inventoryRfqModel) {
		logger.info("Method : restAddRequisition starts");
		boolean validation = true;
		JsonResponse<List<InventoryRfqModel>> resp = new JsonResponse<List<InventoryRfqModel>>();
		List<InventoryRfqModel> listData = new ArrayList<InventoryRfqModel>();
		resp.setMessage("");
		resp.setCode("");
		String errorCode = "Field Validation Error";
		for (InventoryRfqModel l : inventoryRfqModel) {

			if (l.getCostCenter() == null || l.getCostCenter() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please Select Cost Center.");
				break;
			} else if (l.getLocation() == null || l.getLocation() == "") {
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
				String value = GenerateRfqParam.getRfqParam(inventoryRfqModel);

				List<InventoryRfqVendorModel> vendorList = new ArrayList<InventoryRfqVendorModel>();

				if (inventoryRfqModel.get(0).getRfqId() != null && inventoryRfqModel.get(0).getRfqId() != "") {

					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("RfqRoutines")
							.setParameter("actionType", "modifyRfq").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {
						Object oa = null;
						if (m[18] != null) {
							oa = m[18].toString();
						}
						Object receiveDate = null;
						if (m[22] != null) {
							receiveDate = m[22].toString();
						}
						Object activeDate = null;
						if (m[24] != null) {
							activeDate = m[24].toString();
						}
						Object onHoldDate = null;
						if (m[25] != null) {
							onHoldDate = m[25].toString();
						}
						Object completeDate = null;
						if (m[26] != null) {
							completeDate = m[26].toString();
						}

						InventoryRfqModel dropDownModel = new InventoryRfqModel(m[28], m[0], m[1], m[2], m[3], m[4],
								m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
								oa, m[19], m[20], m[21], receiveDate, m[23], activeDate, onHoldDate, completeDate,
								m[27], null);
						listData.add(dropDownModel);
					}

					try {

						List<Object[]> y = entityManager.createNamedStoredProcedureQuery("RfqRoutines")
								.setParameter("actionType", "getVendorEdit")
								.setParameter("actionValue", "SET @P_req='" + listData.get(0).getRfqId() + "';")
								.getResultList();

						for (Object[] m : y) {
							Object oa = null;
							if (m[8] != null) {
								oa = m[8].toString();
							}
							InventoryRfqVendorModel dropDownModel = new InventoryRfqVendorModel(m[0], m[1], m[2], m[3],
									m[4], null, m[5], m[6], m[7], oa, m[9]);
							vendorList.add(dropDownModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
					if (listData != null) {
						listData.get(0).setVendorList(vendorList);
					}

				} else {
					logger.info("######"+value);
					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("RfqRoutines")
							.setParameter("actionType", "addNewRfq").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {
						Object oa = null;
						if (m[18] != null) {
							oa = m[18].toString();
						}
						Object receiveDate = null;
						if (m[22] != null) {
							receiveDate = m[22].toString();
						}
						Object activeDate = null;
						if (m[24] != null) {
							activeDate = m[24].toString();
						}
						Object onHoldDate = null;
						if (m[25] != null) {
							onHoldDate = m[25].toString();
						}
						Object completeDate = null;
						if (m[26] != null) {
							completeDate = m[26].toString();
						}

						InventoryRfqModel dropDownModel = new InventoryRfqModel(m[28], m[0], m[1], m[2], m[3], m[4],
								m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
								oa, m[19], m[20], m[21], receiveDate, m[23], activeDate, onHoldDate, completeDate,
								m[27], null);
						listData.add(dropDownModel);
					}
					try {
						List<Object[]> y = entityManager.createNamedStoredProcedureQuery("RfqRoutines")
								.setParameter("actionType", "getVendorEdit")
								.setParameter("actionValue", "SET @P_req='" + listData.get(0).getRfqId() + "';")
								.getResultList();

						for (Object[] m : y) {
							Object oa = null;
							if (m[8] != null) {
								oa = m[8].toString();
							}
							InventoryRfqVendorModel dropDownModel = new InventoryRfqVendorModel(m[0], m[1], m[2], m[3],
									m[4], null, m[5], m[6], m[7], oa, m[9]);
							vendorList.add(dropDownModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
					if (listData != null) {
						listData.get(0).setVendorList(vendorList);
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
		ResponseEntity<JsonResponse<List<InventoryRfqModel>>> response = new ResponseEntity<JsonResponse<List<InventoryRfqModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : add item Requisition ends");
	return response;
	}

	/*
	 * for view rfq list
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryRfqModel> getRfqViewList(String orgName, String orgDiv) {
		logger.info("Method : getRfqViewList starts");
		List<InventoryRfqModel> getRequisitionTypeList = new ArrayList<InventoryRfqModel>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getRfqViewList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[4] != null) {
					oa = m[4].toString();
				}
				Object createdon = null;
				if (m[7] != null) {
					createdon = m[7].toString();
				}
				Object activeDate = null;
				if (m[9] != null) {
					activeDate = m[9].toString();
				}
				Object onHoldDate = null;
				if (m[10] != null) {
					onHoldDate = m[10].toString();
				}
				Object completeDate = null;
				if (m[11] != null) {
					completeDate = m[11].toString();
				}
				InventoryRfqModel dropDownModel = new InventoryRfqModel(m[12], m[0], m[1], m[2], m[3], oa, m[5], m[6],
						createdon, m[8], activeDate, onHoldDate, completeDate,null,null);

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
		logger.info("Method : getRfqViewList ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to delete
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restDeleteRfq(InventoryRfqModel inventoryRfqModel) {
		logger.info("Method : restDeleteRfq starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateRfqParam.getRfqDeleteParam(inventoryRfqModel);

			entityManager.createNamedStoredProcedureQuery("RfqRoutines").setParameter("actionType", "deleteRfq")
					.setParameter("actionValue", value).execute();

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
		logger.info("Method : restDeleteRfq ends");
		return response;
	}

	/**
	 * DAO Function to approve
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restApproveRfq(InventoryRfqModel inventoryRfqModel) {
		logger.info("Method : restApproveRfq starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = GenerateRfqParam.getRfqApproveParam(inventoryRfqModel);
			entityManager.createNamedStoredProcedureQuery("RfqRoutines").setParameter("actionType", "approveRfq")
					.setParameter("actionValue", value).execute();

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
		logger.info("Method : restApproveRfq ends");
		return response;
	}

	/**
	 * DAO Function to for rfq edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryRfqModel> getRfqEdit(String id,String orgName, String orgDiv) {
		logger.info("Method : getRfqEdit starts");
		List<InventoryRfqModel> getRequisitionTypeList = new ArrayList<InventoryRfqModel>();
		List<InventoryRfqVendorModel> vendorList = new ArrayList<InventoryRfqVendorModel>();
		//String values = "SET @P_req='" + id + "';";
		String values = "SET @P_req='" + id + "', @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		
		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getRfqEdit").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[18] != null) {
					oa = m[18].toString();
				}
				Object receiveDate = null;
				if (m[22] != null) {
					receiveDate = m[22].toString();
				}
				Object activeDate = null;
				if (m[24] != null) {
					activeDate = m[24].toString();
				}
				Object onHoldDate = null;
				if (m[25] != null) {
					onHoldDate = m[15].toString();
				}
				Object completeDate = null;
				if (m[26] != null) {
					completeDate = m[26].toString();
				}

				InventoryRfqModel dropDownModel = new InventoryRfqModel(m[28], m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], oa, m[19], m[20],
						m[21], receiveDate, m[23], activeDate, onHoldDate, completeDate, m[27], null);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getVendorEdit").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[8] != null) {
					oa = m[8].toString();
				}
				InventoryRfqVendorModel dropDownModel = new InventoryRfqVendorModel(m[0], m[1], m[2], m[3], m[4], null,
						m[5], m[6], m[7], oa, m[9]);
				vendorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (getRequisitionTypeList != null) {
			getRequisitionTypeList.get(0).setVendorList(vendorList);
		}
		logger.info("Method : getRfqEdit ends");
		return getRequisitionTypeList;
	}
}
