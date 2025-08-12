package nirmalya.aatithya.restmodule.procurment.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GeneratePoParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.model.InventoryPoModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryProductModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryPoDao {
	Logger logger = LoggerFactory.getLogger(InventoryPoDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	/* get legal Term dropdown */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLegalTerm() {
		logger.info("Method : getLegalTerm starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getLegalTerm").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getLegalTerm ends");
		return getRequisitionTypeList;
	}

	/* get payment term Dropdown list */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPaymentTerm() {
		logger.info("Method : getPaymentTerm starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getPaymentTerm").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPaymentTerm ends");
		return getRequisitionTypeList;
	}

	/* get vendor dropdown */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVendorList() {
		logger.info("Method : getVendorList starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getVendorList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getVendorList ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to Add po
	 *
	 */
	@SuppressWarnings({ "unchecked" })
	public ResponseEntity<JsonResponse<InventoryPoModel>> restAddPo(InventoryPoModel inventoryPoModel) {
		logger.info("Method : restAddPo starts");
		boolean validation = true;
		JsonResponse<InventoryPoModel> resp = new JsonResponse<InventoryPoModel>();
		List<InventoryPoModel> listData = new ArrayList<InventoryPoModel>();
		resp.setMessage("");
		resp.setCode("");
		String errorCode = "Field Validation Error";

		if (inventoryPoModel.getReqPrior() == null || inventoryPoModel.getReqPrior() == "") {
			validation = false;
			resp.setCode(errorCode);
			resp.setMessage("Please Enter Date.");
		} else if (inventoryPoModel.getReqType() == null || inventoryPoModel.getReqType() == "") {
			validation = false;
			resp.setCode(errorCode);
			resp.setMessage("Please Select Requisition Type.");
		} else if (inventoryPoModel.getVendorId() == null || inventoryPoModel.getVendorId() == "") {
			validation = false;
			resp.setCode(errorCode);
			resp.setMessage("please Select Vendor.");
		}
		for (InventoryProductModel l : inventoryPoModel.getProductList()) {
			if (l.getSku() == null || l.getSku() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please SKU .");
				break;
			} else if (l.getCostCenterId() == null || l.getCostCenterId() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please Select Cost Center.");
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
				String value = GeneratePoParam.getPoParam(inventoryPoModel);
				logger.info("valuecccccccccc"+value);
				List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();
			

				if (inventoryPoModel.getPoId() != null && inventoryPoModel.getPoId() != "") {

					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("poRoutines")
							.setParameter("actionType", "modifyPo").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {
						Object oa = null;
						if (m[7] != null) {
							oa = m[7].toString();
						}
						Object startDate = null;
						if (m[8] != null) {
							startDate = m[8].toString();
						}
						Object expireDate = null;
						if (m[9] != null) {
							expireDate = m[9].toString();
						}
						Object createdon = null;
						if (m[14] != null) {
							createdon = m[14].toString();
						}
						Object approveDate = null;
						if (m[15] != null) {
							approveDate = m[15].toString();
						}
						Object onHoldDate = null;
						if (m[16] != null) {
							onHoldDate = m[16].toString();
						}
						Object completeDate = null;
						if (m[17] != null) {
							completeDate = m[17].toString();
						}

						InventoryPoModel dropDownModel = new InventoryPoModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
								oa, startDate, expireDate, m[10], m[11], m[12], m[13], createdon, approveDate,
								onHoldDate, completeDate, m[18], m[19], m[20]);
						listData.add(dropDownModel);
					}

					try {

						List<Object[]> y = entityManager.createNamedStoredProcedureQuery("poRoutines")
								.setParameter("actionType", "getPoItemList")
								.setParameter("actionValue", "SET @p_PoId='" + listData.get(0).getPoId() + "';")
								.getResultList();

						for (Object[] m : y) {
							Object createdDate = null;
							if (m[12] != null) {
								createdDate = m[12].toString();
							}
							InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4],
									m[5], m[6], m[7], m[8], m[9], m[10], m[11], createdDate, m[13], m[14], m[15], m[16],
									m[17], m[18], m[19], m[20], m[21], m[22]);
							productList.add(productModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
					if (listData != null) {
						listData.get(0).setProductList(productList);
					}

				} else {
					//logger.info("ssssssssssssssss"+value);
					List<Object[]> x = entityManager.createNamedStoredProcedureQuery("poRoutines")
							.setParameter("actionType", "addPo").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {
						Object oa = null;
						if (m[7] != null) {
							oa = m[7].toString();
						}
						Object startDate = null;
						if (m[8] != null) {
							startDate = m[8].toString();
						}
						Object expireDate = null;
						if (m[9] != null) {
							expireDate = m[9].toString();
						}
						Object createdon = null;
						if (m[14] != null) {
							createdon = m[14].toString();
						}
						Object approveDate = null;
						if (m[15] != null) {
							approveDate = m[15].toString();
						}
						Object onHoldDate = null;
						if (m[16] != null) {
							onHoldDate = m[16].toString();
						}
						Object completeDate = null;
						if (m[17] != null) {
							completeDate = m[17].toString();
						}

						InventoryPoModel dropDownModel = new InventoryPoModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
								oa, startDate, expireDate, m[10], m[11], m[12], m[13], createdon, approveDate,
								onHoldDate, completeDate, m[18], m[19], m[20]);
						listData.add(dropDownModel);
						logger.info("iiiiiiiiiii"+dropDownModel);
					}
				
					try {

						List<Object[]> y = entityManager.createNamedStoredProcedureQuery("poRoutines")
								.setParameter("actionType", "getPoItemList")
								.setParameter("actionValue", "SET @p_PoId='" + listData.get(0).getPoId() + "';")
								.getResultList();

						for (Object[] m : y) {
							Object createdDate = null;
							if (m[12] != null) {
								createdDate = m[12].toString();
							}
							InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4],
									m[5], m[6], m[7], m[8], m[9], m[10], m[11], createdDate, m[13], m[14], m[15], m[16],
									m[17], m[18], m[19], m[20], m[21], m[22]);
							productList.add(productModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
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

		ResponseEntity<JsonResponse<InventoryPoModel>> response = new ResponseEntity<JsonResponse<InventoryPoModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : restAddPo ends"+response);
		return response;
	}

	/**
	 * for view po list
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryPoModel> getPoViewList(String orgName, String orgDiv) {
		logger.info("Method : getPoViewList starts");
		List<InventoryPoModel> inventoryPoModelList = new ArrayList<InventoryPoModel>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesfffffffffff"+values);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getPoViewList").setParameter("actionValue", values).getResultList();

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
						createdon, approveDate, completeDate, onHoldDate, m[24], m[25], m[26],null,null);

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
		logger.info("Method : getPoViewList ends");
		return inventoryPoModelList;
	}

	/**
	 * DAO Function to approve
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restApprovePo(InventoryPoModel InventoryPoModel) {
		logger.info("Method : restApprovePo starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = GeneratePoParam.getPoApproveParam(InventoryPoModel);
			logger.info("value==="+value);
			entityManager.createNamedStoredProcedureQuery("poRoutines").setParameter("actionType", "approvePo")
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
		logger.info("Method : restApprovePo ends");
		return response;
	}

	/**
	 * DAO Function to for po edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public InventoryPoModel gePoEdit(String id,String orgName, String orgDiv) {
		logger.info("Method : gePoEdit starts");
		InventoryPoModel poList = new InventoryPoModel();
		List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();
		String values = "SET @p_PoId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getPoEdit").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object oa = null;
				if (m[7] != null) {
					oa = DateFormatter.returnStringDate(m[7]);
				}
				Object startDate = null;
				if (m[8] != null) {
					startDate =DateFormatter.returnStringDate(m[8]);
				}
				Object expireDate = null;
				if (m[9] != null) {
					expireDate = DateFormatter.returnStringDate(m[9]);
				}
				Object createdon = null;
				if (m[14] != null) {
					createdon = DateFormatter.returnStringDate(m[14]);
				}
				Object approveDate = null;
				if (m[15] != null) {
					approveDate = DateFormatter.returnStringDate(m[15]);
				}
				Object onHoldDate = null;
				if (m[16] != null) {
					onHoldDate =DateFormatter.returnStringDate(m[16]);
				}
				Object completeDate = null;
				if (m[17] != null) {
					completeDate = DateFormatter.returnStringDate(m[16]);
				}

				InventoryPoModel dropDownModel = new InventoryPoModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], oa,
						startDate, expireDate, m[10], m[11], m[12], m[13], createdon, approveDate, onHoldDate,
						completeDate, m[18], m[19], m[20]);
				poList = dropDownModel;
			}

			List<Object[]> y = entityManager.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getPoItemList")
					.setParameter("actionValue", "SET @p_PoId='" + poList.getPoId() + "';").getResultList();

			for (Object[] m : y) {
				Object createdDate = null;
				if (m[12] != null) {
					createdDate =   DateFormatter.returnStringDate(m[12]);
				}
				InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], createdDate, m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], m[21], m[22]);
				productList.add(productModel);
			}

			if (poList != null) {
				poList.setProductList(productList);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
		logger.info("Method : gePoEdit ends"+poList);
		return poList;

	}

	/**
	 * DAO Function to approve
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restDeletePo(InventoryPoModel InventoryPoModel) {
		logger.info("Method : restDeletePo starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = GeneratePoParam.getPoDeleteParam(InventoryPoModel);
			entityManager.createNamedStoredProcedureQuery("poRoutines").setParameter("actionType", "restDeletePo")
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
		logger.info("Method : restDeletePo ends");
		return response;
	}
}
