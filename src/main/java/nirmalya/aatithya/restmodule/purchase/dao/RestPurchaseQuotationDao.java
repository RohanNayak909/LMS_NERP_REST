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

import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GeneratePurchaseQuotationParameter;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.inventory.model.InventoryRfqVendorModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;
import nirmalya.aatithya.restmodule.purchase.model.RestVendorNewModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestPurchaseQuotationDao {
	Logger logger = LoggerFactory.getLogger(RestPurchaseQuotationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<RestVendorNewModel> getPurchaseVendorList(String id, String orgName, String orgDiv) {
		logger.info("Method : getPurchaseVendorList starts");
		List<RestVendorNewModel> getRequisitionTypeList = new ArrayList<RestVendorNewModel>();
		try {
			String values = "SET @p_rfq='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getPurchaseVendorList").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				Object oa = null;
				if (m[2] != null) {
					oa = m[2].toString();
				}
				RestVendorNewModel dropDownModel = new RestVendorNewModel(m[0], m[1], oa, m[3], null, null, null);

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
		logger.info("Method : getPurchaseVendorList ends");
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRequisitionList(String id, String org, String orgDiv) {
		logger.info("Method : getRequisitionList starts");

		List<DropDownModel> modeList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_id='" + id + "';";
		System.out.println("modeList---value>>>" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getRequisitionList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				modeList.add(dropDownModel);
			}

			resp.setBody(modeList);
			if (modeList.size() > 0) {
				Util.setJsonResponse(resp, modeList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, modeList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getRequisitionList ends");
		return response;
	}

	/*
	 * add
	 */
	public ResponseEntity<JsonResponse<List<RestPurchaseQuotationModel>>> addPurchaseQuotation(
			List<RestPurchaseQuotationModel> restPurchaseQuotationModel) {

		logger.info("Method : addPurchaseQuotation starts");

		JsonResponse<List<RestPurchaseQuotationModel>> resp = new JsonResponse<List<RestPurchaseQuotationModel>>();
		List<RestPurchaseQuotationModel> listData = new ArrayList<RestPurchaseQuotationModel>();
		System.out.println("restPurchaseQuotationModel>>" + restPurchaseQuotationModel);
		;
		try {
			String values = GeneratePurchaseQuotationParameter.getAddQuotParam(restPurchaseQuotationModel);
			logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);

			if (restPurchaseQuotationModel.get(0).getRfqId() == null
					|| restPurchaseQuotationModel.get(0).getRfqId() == "") {
				em.createNamedStoredProcedureQuery("RfqRoutines").setParameter("actionType", "addPurchaseQuotation")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("RfqRoutines").setParameter("actionType", "modifyPurchaseQuotation")
						.setParameter("actionValue", values).execute();

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
		ResponseEntity<JsonResponse<List<RestPurchaseQuotationModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseQuotationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addPurchaseQuotation ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseQuotationModel>>> viewQuotation(String orgName, String orgDiv) {
		logger.info("Method : viewQuotation Dao startssssssssssssssssssssss");

		List<RestPurchaseQuotationModel> getAllemployee = new ArrayList<RestPurchaseQuotationModel>();
		JsonResponse<List<RestPurchaseQuotationModel>> resp = new JsonResponse<List<RestPurchaseQuotationModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "viewQuotation").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object createdOn = null;
				if (m[6] != null) {
					createdOn = m[6].toString();
					// createdOn = DateFormatter.returnStringDate(m[6]);
				}
				Object receiveDate = null;
				if (m[4] != null) {
					receiveDate = m[4].toString();
				}

				RestPurchaseQuotationModel viewdemo = new RestPurchaseQuotationModel(m[0], m[1], m[2], m[3],
						receiveDate, m[5], createdOn, m[7], m[8]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestPurchaseQuotationModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseQuotationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewQuotation Dao ends");
		return response;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestPurchaseQuotationModel> viewInquiryEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : viewInquiryEdit starts");
		List<RestPurchaseQuotationModel> getRequisitionTypeList = new ArrayList<RestPurchaseQuotationModel>();
		List<InventoryRfqVendorModel> vendorList = new ArrayList<InventoryRfqVendorModel>();
		try {
			String values = "SET @p_rfqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "viewInquiryEdit").setParameter("actionValue", values).getResultList();
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
							recvDate, m[5], m[6], m[7], m[8], m[9], m[10], m[11].toString(), m[12], createdOn, m[14],
							m[15], null, null, m[16], m[17], null, null, null, null, null, null, null, null, null,
							m[18]);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {

				List<Object[]> x1 = em.createNamedStoredProcedureQuery("RfqRoutines")
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

		logger.info("Method : viewInquiryEdit ends");
		return getRequisitionTypeList;
	}

	/*
	 * delete
	 * 
	 */
	public ResponseEntity<JsonResponse<Object>> deleteInquiry(RestPurchaseQuotationModel deleteInquiry) {
		logger.info("Method : deleteInquiry starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GeneratePurchaseQuotationParameter.getDeleteInquiry(deleteInquiry);
			em.createNamedStoredProcedureQuery("RfqRoutines").setParameter("actionType", "deleteInquiry")
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
		logger.info("Method : deleteInquiry ends");
		return response;
	}

	/************************ Invoice PDF View **********************/

	@SuppressWarnings("unchecked")
	public List<RestPurchaseQuotationModel> getItemPdfDetails(String id, String orgName, String orgDiv) {
		logger.info("Method : getItemPdfDetails starts");
		List<RestPurchaseQuotationModel> getRequisitionTypeList = new ArrayList<RestPurchaseQuotationModel>();
		try {
			String values = "SET @p_itemDetailsId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("PDF values>>>" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getItemPdfDetails").setParameter("actionValue", values)
					.getResultList();

			try {
				for (Object[] m : x) {
					Object recvDate = null;
					if (m[4] != null) {
						recvDate = m[4].toString();
					}
					Object updateDate = null;
					if (m[13] != null) {
						updateDate = m[13].toString();
					}
					Object createdOn = null;
					if (m[12] != null) {
						createdOn = m[12].toString();
					}
					Object quantStr = null;
					if (m[8] != null) {
						quantStr = m[8];
					}
					Object unitPriceStr = null;
					if (m[9] != null) {
						unitPriceStr = m[9];
					}
					Object lineTotalStr = null;
					if (m[10] != null) {
						lineTotalStr = m[10];
					}

					RestPurchaseQuotationModel dropDownModel = new RestPurchaseQuotationModel(m[0], m[1], m[2], m[3],
							recvDate, m[5], m[6], m[7], null, null, null, null, m[11], createdOn, updateDate, m[14], null,
							null, null, null, m[15], m[16], m[17], m[18], m[19], m[20], quantStr, unitPriceStr, lineTotalStr,
							null);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Pdf Data >>> " + getRequisitionTypeList);
		logger.info("Method : getItemPdfDetails ends");
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public List<RestVendorNewModel> getVendordata(String sku, String orgName, String orgDivision, String rowCount) {
		logger.info("Method : getVendordata starts");
		logger.info("RestVendorNewModel" + sku);
		List<RestVendorNewModel> getRequisitionTypeList = new ArrayList<RestVendorNewModel>();

		try {
			String values = "SET @p_sku='(" + sku + ")',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "',@p_rowCount='" + rowCount + "';";
			logger.info("VALUESSSSSSS" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getVendordata1").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {
					Object oa = null;
					if (m[2] != null) {
						oa = m[2].toString();
					}
					RestVendorNewModel dropDownModel = new RestVendorNewModel(m[0], m[1], oa, m[3], null, null, null);

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

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : getVendordata ends");
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getReqNoAutoSearchList(String id, String org, String orgDiv) {
		logger.info("Method : getReqNoAutoSearchList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_searchValue='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getReqNoAutoSearchList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getReqNoAutoSearchList Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getReqNoAutoSearchListDtls(String id, String org, String orgDiv) {
		logger.info("Method : getReqNoAutoSearchListDtls Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_rqstType='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getReqNoAutoSearchListDtls").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getReqNoAutoSearchListDtls Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllVendorListDtls(String type, String org, String orgDiv) {
		logger.info("Method : getAllVendorListDtls Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Type='" + type + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("getAllVendorListDtls--value>>>>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getAllVendorListDtls").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("getAllVendorListDtls>>>>" + resp);
		logger.info("Method : getAllVendorListDtls Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEmailData(String id, String mailStatus, String orgName, String orgDivision) {
		logger.info("Method : getEmailData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_rfqId='" + id + "',@p_mailStatus='" + mailStatus + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getEmailData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : getEmailData Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}

	// Email

	public ResponseEntity<JsonResponse<List<RestPurchaseQuotationModel>>> sendEmailRfq(String rfqId, String vendorNames,
			String vendorMails, String vendorCc, String vendorBcc, String vendorMsg, String url) {
		logger.info("Method : sendEmailRfq starts" + vendorCc);

		JsonResponse<List<RestPurchaseQuotationModel>> resp = new JsonResponse<List<RestPurchaseQuotationModel>>();
		List<RestPurchaseQuotationModel> rs = new ArrayList<RestPurchaseQuotationModel>();
		List<InventoryVendorDocumentModel> docListt = new ArrayList<InventoryVendorDocumentModel>();

		try {

			String value = "SET @p_rfqId='" + rfqId + "',@p_vendorNames='" + vendorNames + "'," + "@p_vendorMails='"
					+ vendorMails + "'," + "@p_vendorCc='" + vendorCc + "',@p_vendorBcc='" + vendorBcc + "',"
					+ "@p_vendorMsg='" + vendorMsg + "',@p_url='" + url + "';";

			logger.info("value===========" + value);
			try {
				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("RfqRoutines")
						.setParameter("actionType", "sendEmailRfq").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					RestPurchaseQuotationModel dropDownModel = new RestPurchaseQuotationModel(m[0], m[1], m[2], m[3],
							m[4]);
					rs.add(dropDownModel);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			/*
			 * if (rs.size() > 0) {
			 * 
			 * try { String values1 = "SET @p_itemDetailsId='" + rfqId + "';";
			 * 
			 * @SuppressWarnings("unchecked") List<Object[]> x1 =
			 * em.createNamedStoredProcedureQuery("RfqRoutines") .setParameter("actionType",
			 * "getVendorDocForPdfData").setParameter("actionValue", values1)
			 * .getResultList(); for (Object[] m : x1) {
			 * 
			 * InventoryVendorDocumentModel productModel = new
			 * InventoryVendorDocumentModel(m[0], m[1], m[2]);
			 * System.out.println("productModel" + productModel);
			 * docListt.add(productModel); } } catch (Exception e) { e.printStackTrace(); }
			 * 
			 * rs.get(0).setDocumentList(docListt); }
			 */

			resp.setBody(rs);
			resp.setCode("success");
			resp.setMessage("send email successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestPurchaseQuotationModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseQuotationModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("resp===" + resp);
		logger.info("Method : sendEmailRfq ends");
		return response;
	}
}
