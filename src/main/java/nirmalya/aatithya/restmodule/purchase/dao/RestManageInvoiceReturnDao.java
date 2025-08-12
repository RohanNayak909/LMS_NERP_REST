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
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateManageInvoiceReturnParam;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceReturnModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPhysicalVarificationModel;

@Repository
public class RestManageInvoiceReturnDao {
	Logger logger = LoggerFactory.getLogger(RestManageInvoiceReturnDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> geInvoiceReturnId() {
		logger.info("Method : geInvoiceReturnId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("Inventory_action_invoice_Return_Routines")
					.setParameter("actionType", "getInvoiceReturnId").setParameter("actionValue", "").getResultList();

			Object jobId = x.get(0);
			logger.info("job id--------" + jobId);

			DropDownModel dropDownModel = new DropDownModel(jobId, null);

			itemList.add(dropDownModel);
			resp.setBody(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("response for getting job card id -------" + response);
		logger.info("Method : geInvoiceReturnId ends");
		return response;
	}

	/*
	 * add
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageInvoiceReturnModel>>> addInvoiceReturn(
			List<RestManageInvoiceReturnModel> restManageInvoiceReturnModel) {

		logger.info("Method : addInvoiceReturn starts");

		// logger.info("RestManageInvoiceModel" + restManageInvoiceModel);
		JsonResponse<List<RestManageInvoiceReturnModel>> resp = new JsonResponse<List<RestManageInvoiceReturnModel>>();
		List<RestManageInvoiceReturnModel> listData = new ArrayList<RestManageInvoiceReturnModel>();

		try {
			String values = GenerateManageInvoiceReturnParam.getAddInvoiceReturn(restManageInvoiceReturnModel);

			logger.info("ADDDDD" + values);

			if (restManageInvoiceReturnModel.get(0).getInvoiceReturnId() == null
					|| restManageInvoiceReturnModel.get(0).getInvoiceReturnId() == "") {

				em.createNamedStoredProcedureQuery("Inventory_action_invoice_Return_Routines")
						.setParameter("actionType", "addInvoiceReturn").setParameter("actionValue", values).execute();

				resp.setCode("GRN Return Saved Successfully.");

			} else {
				logger.info("@modifyyyyyyyyyyyyyy" + values);

				em.createNamedStoredProcedureQuery("Inventory_action_invoice_Return_Routines")
						.setParameter("actionType", "modifyInvoiceReturn").setParameter("actionValue", values)
						.execute();

				resp.setCode("GRN Return Modified Successfully");

				// logger.info("modify printttttttttttttttttt" + listData);

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
		ResponseEntity<JsonResponse<List<RestManageInvoiceReturnModel>>> response = new ResponseEntity<JsonResponse<List<RestManageInvoiceReturnModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data issssssssssssssssssssss" + response);
		logger.info("Method : addInvoiceReturn ends");
		return response;
	}

	/*
	 * view
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageInvoiceReturnModel>>> viewInvoiceReturn(String orgName,
			String orgDiv) {
		logger.info("Method : viewInvoiceReturn Dao startssssssssssssssssssssss");

		List<RestManageInvoiceReturnModel> getAllemployee = new ArrayList<RestManageInvoiceReturnModel>();
		JsonResponse<List<RestManageInvoiceReturnModel>> resp = new JsonResponse<List<RestManageInvoiceReturnModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("restViewVendorDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("Inventory_action_invoice_Return_Routines")
					.setParameter("actionType", "viewInvoiceReturn").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object createdOn = null;
				if (m[5] != null) {
					createdOn = m[5].toString();
				}
				double crdAmt = 0;
				if (m[11] != null) {
					crdAmt = Double.parseDouble(m[11].toString());
				}
				/*
				 * Object dueDate = null; if (m[7] != null) { dueDate = m[7].toString(); }
				 */

				RestManageInvoiceReturnModel viewdemo = new RestManageInvoiceReturnModel(m[0], m[1], m[2], m[3], m[4],
						createdOn, m[6], m[7], m[8], m[9], m[10], crdAmt, m[12], m[13], m[14].toString());
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestManageInvoiceReturnModel>>> response = new ResponseEntity<JsonResponse<List<RestManageInvoiceReturnModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewInvoiceReturn Dao ends");
		logger.info("aaaaaaaaaaaaaaaaaaaaaa" + response);
		return response;

	}

	/*
	 * edit grn return
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestManageInvoiceReturnModel> viewInvoiceReturnEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : viewInvoiceReturnEdit starts");
		logger.info("RestManageInvoiceReturnModel" + id);
		List<RestManageInvoiceReturnModel> getRequisitionTypeList = new ArrayList<RestManageInvoiceReturnModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_invoiceReturnId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("Inventory_action_invoice_Return_Routines")
					.setParameter("actionType", "viewInvoiceReturnEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					logger.info(Arrays.toString(m));
//					Object createdOn1 = null;
//					if (m[4] != null) {
//						createdOn1 = m[4].toString();
//					}
					Object createdOn2 = null;
					if (m[29] != null) {
						createdOn2 = m[29].toString();
					}

					RestManageInvoiceReturnModel dropDownModel = new RestManageInvoiceReturnModel(m[0], m[1], m[2],
							m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28],
							createdOn2, m[30], m[31], m[32], m[33], m[34], m[35], m[36], m[37], m[38]);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_invoiceReturnId='" + getRequisitionTypeList.get(0).getInvoiceId() + "';";
				logger.info("DOCUMRNt" + subValues);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("Inventory_action_invoice_Return_Routines")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2],
							m[3]);
					docList.add(dropDownModel);
				}
			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewInvoiceReturnEdit ends");
		return getRequisitionTypeList;
	}

	/*
	 * approveInvoiceReturn
	 */

	public ResponseEntity<JsonResponse<Object>> approveInvoiceReturn(RestManageInvoiceReturnModel req) {
		logger.info("Method : approveInvoiceReturn starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("ADDDDDDDDDDDDD" + req.getApproveStatus());
		try {
			String values = GenerateManageInvoiceReturnParam.getApproveGRNReturnParam(req);
			logger.info("ADDDDDDDDDDDDD" + values);
			if (req.getApproveStatus() != null || req.getApproveStatus() != "") {

				em.createNamedStoredProcedureQuery("Inventory_action_invoice_Return_Routines")
						.setParameter("actionType", "approveInvoiceReturn").setParameter("actionValue", values)
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
		logger.info("approveInvoiceReturn1" + resp);

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("approveInvoiceReturn" + response);

		logger.info("Method : approveInvoiceReturn ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>> getGrnId(String id, String type,
			String org, String orgDiv) {
		logger.info("Method : getRFQList starts");
		List<RestPhysicalVarificationModel> itemNameList = new ArrayList<RestPhysicalVarificationModel>();
		JsonResponse<List<RestPhysicalVarificationModel>> resp = new JsonResponse<List<RestPhysicalVarificationModel>>();
		String value = "SET @p_searchValue='" + id + "', @p_type='" + type + "',@p_org='" + org + "',@p_orgDiv='"
				+ orgDiv + "';";
		System.err.println("value====" + value);
		try {
			// Execute the stored procedure
			List<Object[]> results = em.createNamedStoredProcedureQuery("Inventory_action_invoice_Return_Routines")
					.setParameter("actionType", "getGRNId").setParameter("actionValue", value).getResultList();

			// Iterate over the results
			for (Object[] row : results) {
				// Ensure the row has the expected number of columns
				if (row.length >= 3) {
					RestPhysicalVarificationModel dropDownModel = new RestPhysicalVarificationModel(
							row[0] != null ? row[0].toString() : null, row[1] != null ? row[1].toString() : null,
							row[2] != null ? row[2].toString() : null);
					itemNameList.add(dropDownModel);
				} else {
					System.err.println("Unexpected row format: " + Arrays.toString(row));
				}
			}

			// Set the response body
			resp.setBody(itemNameList);
		} catch (Exception e) {
			// Log and rethrow or handle appropriately
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>> response = new ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getRFQList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<RestManageInvoiceModel> viewInvoiteEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : viewReturnEdit starts");
		// logger.info("RestManageInvoiceModel" + id);
		List<RestManageInvoiceModel> getRequisitionTypeList = new ArrayList<RestManageInvoiceModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_invoiceId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("Inventory_action_invoice_Return_Routines")
					.setParameter("actionType", "viewInvoiteEdit").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {
					// logger.info(Arrays.toString(m));

					RestManageInvoiceModel dropDownModel = new RestManageInvoiceModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18],
							m[19], m[20], m[21], m[22], m[23].toString(), m[24], m[25], m[26].toString());

					getRequisitionTypeList.add(dropDownModel);

				}
				System.out.println("getRequisitionTypeList===" + getRequisitionTypeList);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_invoiceId='" + id + "';"; //
				logger.info("DOCUMRNt" + subValues);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("Inventory_action_invoice_Return_Routines")
						.setParameter("actionType", "getVendorDocsPhVrification").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2], m[3]);
					docList.add(dropDownModel);
				}
			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("docList>>>>>" + docList);
		if (!docList.isEmpty()) {
			getRequisitionTypeList.get(0).setDocumentList(docList);
		}
		// logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewReturnEdit ends");
		return getRequisitionTypeList;
	}
}
