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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GeneratePurchaseIndentParam;
import nirmalya.aatithya.restmodule.common.utils.purchase.GeneratePurchaseOrderParameter;
import nirmalya.aatithya.restmodule.common.utils.purchase.GeneratePurchaseQuotationDetails;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRequisitionModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseIndentModel;

@Repository
public class PurchaseIndentDao {

	Logger logger = LoggerFactory.getLogger(PurchaseIndentDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * add
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> addIndentDetails(
			List<RestPurchaseIndentModel> RestPurchaseIndentModel) {

		logger.info("Method : addIndentDetails starts");

		JsonResponse<List<RestPurchaseIndentModel>> resp = new JsonResponse<List<RestPurchaseIndentModel>>();
		List<RestPurchaseIndentModel> listData = new ArrayList<RestPurchaseIndentModel>();

		try {
			String values = GeneratePurchaseIndentParam.getAddPurchaseIndent(RestPurchaseIndentModel);

			logger.info("IDd" + RestPurchaseIndentModel.get(0).getIndentId());
			if (RestPurchaseIndentModel.get(0).getIndentId() == null
					|| RestPurchaseIndentModel.get(0).getIndentId() == "") {
				logger.info("ADS#" + values);

				em.createNamedStoredProcedureQuery("purchase_indent_Routines")
						.setParameter("actionType", "addIndentDetails").setParameter("actionValue", values).execute();

			} else {


				em.createNamedStoredProcedureQuery("purchase_indent_Routines")
						.setParameter("actionType", "modifyIndentDetails").setParameter("actionValue", values)
						.execute();

				logger.info("modify print" + listData);

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
		ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addIndentDetails ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> viewIndentDetails(String orgName,
			String orgDiv) {
		logger.info("Method : viewPurchaseOrder Dao starts");
		List<RestPurchaseIndentModel> getAllemployee = new ArrayList<RestPurchaseIndentModel>();
		JsonResponse<List<RestPurchaseIndentModel>> resp = new JsonResponse<List<RestPurchaseIndentModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("restViewVendorDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_indent_Routines")
					.setParameter("actionType", "viewIndentDetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object createdOn = null;
				if (m[7] != null) {
					createdOn = m[7].toString();
				}

				RestPurchaseIndentModel viewdemo = new RestPurchaseIndentModel(m[0], m[1], m[2], m[3].toString(), m[4],
						m[5], m[6], createdOn, m[8], m[9],m[10],null);
				getAllemployee.add(viewdemo);

			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewIndentDetails Dao ends");

		return response;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestPurchaseIndentModel> viewPurchaseIndentEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : viewPurchaseIndentEdit starts");
		// logger.info("RestDeliveryChallanModel" + id);
		List<RestPurchaseIndentModel> getRequisitionTypeList = new ArrayList<RestPurchaseIndentModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_indentId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_indent_Routines")
					.setParameter("actionType", "viewPurchaseIndentEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					RestPurchaseIndentModel dropDownModel = new RestPurchaseIndentModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14],m[15],m[16]);
					getRequisitionTypeList.add(dropDownModel);

					// logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_indentId='" + getRequisitionTypeList.get(0).getIndentId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("purchase_indent_Routines")
						.setParameter("actionType", "getIndentDocs").setParameter("actionValue", subValues)
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
		logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewPurchaseIndentEdit ends");
		return getRequisitionTypeList;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteIndentDetails(String id) {
		logger.info("Method : deleteIndentDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_indentId='" + id + "';";
				logger.info("IDD" + value);
				em.createNamedStoredProcedureQuery("purchase_indent_Routines")
						.setParameter("actionType", "deleteIndentDetails").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteIndentDetails ends");
		logger.info("DELETEE" + response);
		return response;
	}

	// approve

	public JsonResponse<DropDownModel> approveIndentDetails(String approveStatus, String indentId, String orgName,
			String orgDivision) {
		logger.info("Method : approveIndentDetails starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			// String value = "SET @p_approveStatus='" + approveStatus +
			// "',@p_quotationId='" + quotationId + "', @p_org='" + orgName +
			// "',@p_orgDiv='" + orgDivision + "';";

			String value = "SET @p_approveStatus='" + approveStatus + "',@p_indentId='" + indentId + "',@p_org='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "';";

			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("purchase_indent_Routines")
					.setParameter("actionType", "approveQuotation").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : approveIndentDetails ends");
		return resp;
	}

	public JsonResponse<Object> addFeedBackDetails(RestPurchaseIndentModel restPurchaseIndentModel) {
		logger.info("Method : addFeedBackDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GeneratePurchaseIndentParam.getReplyAdd(restPurchaseIndentModel);
			if (restPurchaseIndentModel.getIndentId() != null || restPurchaseIndentModel.getIndentId() != "") {
				System.out.println("ADD" + values);
				em.createNamedStoredProcedureQuery("purchase_indent_Routines")
						.setParameter("actionType", "addFeedBackDetails").setParameter("actionValue", values).execute();
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		logger.info("ADDDDDDD" + resp);
		logger.info("Method : addFeedBackDetails ends");
		return resp;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> viewIndentDetailsForPurchase(String orgName,
			String orgDiv) {
		logger.info("Method : viewIndentDetailsForPurchase Dao starts");
		List<RestPurchaseIndentModel> getAllemployee = new ArrayList<RestPurchaseIndentModel>();
		JsonResponse<List<RestPurchaseIndentModel>> resp = new JsonResponse<List<RestPurchaseIndentModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("restViewVendorDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_indent_Routines")
					.setParameter("actionType", "viewIndentDetailsForPurchase").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				RestPurchaseIndentModel viewdemo = new RestPurchaseIndentModel(m[0], m[1], m[2], m[3].toString(), m[4],
						m[5], m[6], m[7], m[8], m[9],m[10]);
				getAllemployee.add(viewdemo);

			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewIndentDetailsForPurchase Dao ends");

		return response;

	}

	@SuppressWarnings("unchecked")
	public List<RestPurchaseIndentModel> getIndentdataForRFQ(String sku, String id, String orgName, String orgDiv) {
		logger.info("Method : getIndentdataForRFQ starts");
		List<RestPurchaseIndentModel> getRequisitionTypeList = new ArrayList<RestPurchaseIndentModel>();
		String y = id.trim();
		//String z = sku.trim();
		try {

			String values = "SET @p_sku='(" + sku + ")',@p_indentid='(" + y + ")',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_indent_Routines")
					.setParameter("actionType", "getIndentdataForRFQ").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					System.out.println("DATA"+Arrays.toString(m));
					/*
					 * double qty = 0; if (m[5] != null) { qty =
					 * Double.parseDouble(m[5].toString()); }
					 */
					//double qty=	Double.toString(m[5])
					RestPurchaseIndentModel dropDownModel = new RestPurchaseIndentModel(m[0], m[1], m[2], m[3], m[4],
							m[5],m[6], m[7],null,m[8],null,null,null);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : getIndentdataForRFQ ends");
		return getRequisitionTypeList;
	}

}
