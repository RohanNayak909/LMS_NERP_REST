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
import nirmalya.aatithya.restmodule.common.utils.purchase.GeneratePhysicalVarificationParam;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPhysicalVarificationModel;

@Repository
public class RestPhysicalVarificationDao {
	Logger logger = LoggerFactory.getLogger(RestPhysicalVarificationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getvarificationId() {
		logger.info("Method : getvarificationId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("Physical_Varification_Routines")
					.setParameter("actionType", "getvarificationId").setParameter("actionValue", "").getResultList();

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
		logger.info("Method : getvarificationId ends");
		return response;
	}

	/*
	 * add
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>> addVerification(
			List<RestPhysicalVarificationModel> RestPhysicalVarificationModel) {

		logger.info("Method : addVerification starts");

		// logger.info("RestManageInvoiceModel" + restManageInvoiceModel);
		JsonResponse<List<RestPhysicalVarificationModel>> resp = new JsonResponse<List<RestPhysicalVarificationModel>>();
		List<RestPhysicalVarificationModel> listData = new ArrayList<RestPhysicalVarificationModel>();

		try {
			String values = GeneratePhysicalVarificationParam.getAddVarificationDetils(RestPhysicalVarificationModel);

			logger.info("ADDDDD" + values);

			if (RestPhysicalVarificationModel.get(0).getVarificationId() == null
					|| RestPhysicalVarificationModel.get(0).getVarificationId() == "") {

				em.createNamedStoredProcedureQuery("Physical_Varification_Routines")
						.setParameter("actionType", "addVerification").setParameter("actionValue", values).execute();
				
				resp.setCode("Physical Verification Added Successfully.");

			} else {
				logger.info("@modifyyyyyyyyyyyyyy" + values);

				em.createNamedStoredProcedureQuery("Physical_Varification_Routines")
						.setParameter("actionType", "modifyVerification").setParameter("actionValue", values).execute();

				// logger.info("modify printttttttttttttttttt" + listData);
				
				resp.setCode("Physical Verification Modified  Successfully.");

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
		ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>> response = new ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data issssssssssssssssssssss" + response);
		logger.info("Method : addVerification ends");
		return response;
	}

	/*
	 * view
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>> viewVerification(String orgName,
			String orgDiv) {
		logger.info("Method : viewVerification Dao startssssssssssssssssssssss");

		List<RestPhysicalVarificationModel> getAllemployee = new ArrayList<RestPhysicalVarificationModel>();
		JsonResponse<List<RestPhysicalVarificationModel>> resp = new JsonResponse<List<RestPhysicalVarificationModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("viewVerification -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("Physical_Varification_Routines")
					.setParameter("actionType", "viewVerification").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object createdOn = null;
				if (m[4] != null) {
					createdOn = m[4].toString();
				}

				double aprvqty = 0;
				if (m[11] != null) {
					aprvqty = Double.parseDouble(m[11].toString());
				}
				/*
				 * Object dueDate = null; if (m[7] != null) { dueDate = m[7].toString(); }
				 */

				RestPhysicalVarificationModel viewdemo = new RestPhysicalVarificationModel(m[0], m[1], m[2], m[3],
						createdOn, m[5], m[6], m[7], m[8], m[9], m[10], aprvqty, m[12], m[13].toString(),
						m[14].toString());
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>> response = new ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewVerification Dao ends");
		logger.info("aaaaaaaaaaaaaaaaaaaaaa" + response);
		return response;

	}

	// approve

	public JsonResponse<DropDownModel> approvePhysicalVarification(String approveStatus, String varificationId,
			String invoiceId, String orgName, String orgDivision) {
		logger.info("Method : approvePhysicalVarification starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_approveStatus='" + approveStatus + "',@p_varificationId='" + varificationId
					+ "',@p_invoiceId='" + invoiceId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("Physical_Varification_Routines")
					.setParameter("actionType", "approvePhysicalVarification").setParameter("actionValue", value)
					.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("resp===" + resp);
		logger.info("Method : approvePhysicalVarification ends");
		return resp;
	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestPhysicalVarificationModel> viewPhysicalVarifyEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : viewPhysicalVarifyEdit starts");
		logger.info("RestPhysicalVarificationModel" + id);
		List<RestPhysicalVarificationModel> getRequisitionTypeList = new ArrayList<RestPhysicalVarificationModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_varificationId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("Physical_Varification_Routines")
					.setParameter("actionType", "viewPhysicalVarifyEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					logger.info(Arrays.toString(m));
//						Object createdOn1 = null;
//						if (m[4] != null) {
//							createdOn1 = m[4].toString();
//						}
					Object createdOn2 = null;
					if (m[29] != null) {
						createdOn2 = m[29].toString();
					}

					RestPhysicalVarificationModel dropDownModel = new RestPhysicalVarificationModel(m[0], m[1], m[2],
							m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28],
							createdOn2, m[30], m[31], m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39]);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_varificationId='" + getRequisitionTypeList.get(0).getVarificationId() + "';";
				logger.info("DOCUMRNt" + subValues);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("Physical_Varification_Routines")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
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
		getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewPhysicalVarifyEdit ends");
		return getRequisitionTypeList;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteVarificationDetails(String id) {
		logger.info("Method : deleteVarificationDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_varificationId='" + id + "';";
				logger.info("IDD" + value);
				em.createNamedStoredProcedureQuery("Physical_Varification_Routines")
						.setParameter("actionType", "deleteVarificationDetails").setParameter("actionValue", value)
						.execute();

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

		logger.info("Method : deleteVarificationDetails ends");
		logger.info("DELETEE" + response);
		return response;
	}

	/*
	 * edit for grn data
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestPhysicalVarificationModel> viewPhysicalVarifyEditForgrnReturn(String id, String hsnCode,
			String orgName, String orgDiv) {
		logger.info("Method : viewPhysicalVarifyEditForgrnReturn starts");
		logger.info("RestPhysicalVarificationModel" + id);
		List<RestPhysicalVarificationModel> getRequisitionTypeList = new ArrayList<RestPhysicalVarificationModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_varificationId='" + id + "',@p_sku='(" + hsnCode + ")',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("Physical_Varification_Routines")
					.setParameter("actionType", "viewPhysicalVarifyEditForgrnReturn")
					.setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {
					logger.info(Arrays.toString(m));
//						Object createdOn1 = null;
//						if (m[4] != null) {
//							createdOn1 = m[4].toString();
//						}
					Object createdOn2 = null;
					if (m[29] != null) {
						createdOn2 = m[29].toString();
					}

					RestPhysicalVarificationModel dropDownModel = new RestPhysicalVarificationModel(m[0], m[1], m[2],
							m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28],
							createdOn2, m[30], m[31], m[32], m[33], m[34], m[35], m[36], m[37], null, null);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_varificationId='" + getRequisitionTypeList.get(0).getVarificationId() + "';";
				logger.info("DOCUMRNt" + subValues);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("Physical_Varification_Routines")
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
		logger.info("viewPhysicalVarifyEditForgrnReturn==edit" + getRequisitionTypeList);
		logger.info("Method :  ends");
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>> getRFQList(String id, String type,
			String org, String orgDiv) {
		logger.info("Method : getRFQList starts");
		List<RestPhysicalVarificationModel> itemNameList = new ArrayList<RestPhysicalVarificationModel>();
		JsonResponse<List<RestPhysicalVarificationModel>> resp = new JsonResponse<List<RestPhysicalVarificationModel>>();
		String value = "SET @p_searchValue='" + id + "', @p_type='" + type + "',@p_org='" + org + "',@p_orgDiv='"
				+ orgDiv + "';";
		System.err.println("value====" + value);
		try {
		    // Execute the stored procedure
		    List<Object[]> results = em.createNamedStoredProcedureQuery("Physical_Varification_Routines")
		            .setParameter("actionType", "getGRNId")
		            .setParameter("actionValue", value)
		            .getResultList();

		    // Iterate over the results
		    for (Object[] row : results) {
		        // Ensure the row has the expected number of columns
		        if (row.length >= 3) {
		            RestPhysicalVarificationModel dropDownModel = new RestPhysicalVarificationModel(
		                row[0] != null ? row[0].toString() : null,
		                row[1] != null ? row[1].toString() : null,
		                row[2] != null ? row[2].toString() : null
		            );
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

}
