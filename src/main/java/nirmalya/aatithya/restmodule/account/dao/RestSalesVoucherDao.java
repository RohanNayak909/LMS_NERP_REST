package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.AccountPurchaseOrderRestModel;
import nirmalya.aatithya.restmodule.account.model.AccountPurchaseProductRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestSalesVoucherDao {

	Logger logger = LoggerFactory.getLogger(RestAccountDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewSalesVoucher(String orgName, String orgDivision) {
		logger.info("Method : viewSalesVoucher Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("restViewVendorDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
					.setParameter("actionType", "getSalesList").setParameter("actionValue", values).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewSalesVoucher Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> salesUpdateItemLedgerDao(String orgName, String orgDiv, String userId, String data) {
		logger.info("Method : salesUpdateItemLedgerDao Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "', @p_userId='" + userId
					+ "', @p_data='" + data + "';";

			System.out.println(values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
					.setParameter("actionType", "updateItemLedger").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(null);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			}

		} catch (Exception e) {
			resp.setBody(null);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : salesUpdateItemLedgerDao Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> updateNarrationSalesDao(String orgName, String orgDiv, String userId, String data) {
		logger.info("Method : updateNarrationSalesDao Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "', @p_userId='" + userId + "', @p_data='" + data + "';";
			
			System.out.println(values);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
					.setParameter("actionType", "updateNarration").setParameter("actionValue", values).getResultList();
			
			if(x.size() > 0) {
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(null);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			}
			
			
		} catch (Exception e) {
			resp.setBody(null);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("Method : updateNarrationSalesDao Dao ends");
		return resp;
		
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveVoucherSalesDao(String orgName, String orgDiv, String userId, String data) {
		logger.info("Method : approveVoucherSalesDao Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "', @p_userId='" + userId + "', @p_data='" + data + "';";
			
			System.out.println(values);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
					.setParameter("actionType", "approveSVoucher").setParameter("actionValue", values).getResultList();
			
			if(x.size() > 0) {
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(null);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			}
			
			
		} catch (Exception e) {
			resp.setBody(null);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("Method : approveVoucherSalesDao Dao ends");
		return resp;
		
	}

	// editAccountInfo
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>> viewEditSalesVoucher(String id,
			String orgName, String orgDiv) {
		logger.info("Method : viewEditSalesVoucher starts");
		JsonResponse<List<AccountPurchaseOrderRestModel>> resp = new JsonResponse<List<AccountPurchaseOrderRestModel>>();
		List<AccountPurchaseOrderRestModel> rs = new ArrayList<AccountPurchaseOrderRestModel>();
		List<AccountPurchaseProductRestModel> prdoct = new ArrayList<AccountPurchaseProductRestModel>();

		try {
			String value = "SET @p_salesId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
					.setParameter("actionType", "editSalesView").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				if (m[7] == null) {
					m[7] = "N/A";
				}

				AccountPurchaseOrderRestModel restPayroll = new AccountPurchaseOrderRestModel(m[0], m[1].toString(),
						m[2].toString(), m[3], m[4], m[5], m[6], m[7].toString(), m[8].toString(), m[9].toString(),
						m[10].toString(), m[11].toString(), m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], m[21], m[22], m[23], m[24], m[25], m[26]);
				rs.add(restPayroll);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("rs.size()-------------" + rs.size());
		if (rs.size() > 0) {
			try {
				String subValues = "SET @p_salesId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv
						+ "';";
				System.out.println(subValues);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesAccountRoutines")
						.setParameter("actionType", "getProductDetails").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					System.out.println("discount value-----------------------------" + m[6]);

					if (m[6].equals("null")) {
						m[6] = "No Discount";
					}

					if (m[11] == null) {
						m[11] = 0.0;
					}

					AccountPurchaseProductRestModel dropDownModel = new AccountPurchaseProductRestModel(m[0], m[1],
							m[2], m[3].toString(), m[4], m[5].toString(), m[6].toString(), m[7].toString(),
							m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(),
							m[13], m[14], m[15]);

					if (m[16] != null) {
						dropDownModel.setLedgerId(m[16].toString());
					}
					if (m[17] != null) {
						dropDownModel.setLedgerName(m[17].toString());
					}
					if (m[18] != null) {
						dropDownModel.setInvItemId(m[18].toString());
					}
					if (m[19] != null) {
						dropDownModel.setVoucherId(m[19].toString());
					}

					prdoct.add(dropDownModel);
				}
				rs.get(0).setProductList(prdoct);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		resp.setBody(rs);
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountPurchaseOrderRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewEditSalesVoucher ends");
		System.out.println(response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewSalesFilteredData(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : viewSalesFilteredData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
					+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',@p_orgDiv='" + orgDivision + "';";

			logger.info("values----->" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
					.setParameter("actionType", "viewSalesFilter").setParameter("actionValue", values).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewSalesFilteredData Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> CustmerTdsAmount(String orgName, String orgDivision, String voucherid,
			String invoiceid) {
		logger.info("Method : vendorTdsAmount Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_voucherid='" + voucherid
					+ "',@p_invoiceid='" + invoiceid + "';";
			logger.info("value-->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
					.setParameter("actionType", "custmerTdsAmount").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		
		System.out.println(resp);
		
		logger.info("Method : vendorTdsAmount Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTdsLedgerListCustmer(String orgName, String orgDivision) {
		logger.info("Method : getTdsLedgerListCustmer starts");
		List<DropDownModel> getTdsLedgerListCustmer = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
					.setParameter("actionType", "getTdsLedger").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getTdsLedgerListCustmer.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTdsLedgerList ends" + getTdsLedgerListCustmer);
		return getTdsLedgerListCustmer;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> tdsAmountAdit(String orgName, String orgDivision, String tdsAmount, String vendorid,
			String tdsRate, String invoiceId, String voucherId, String userId, String finalPayableAmt,
			String tdsLedgerId, String tdsTransactionDate, String tdsNarration, String roundOffAmount) {
		logger.info("Method : tdsAmountAdit Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_invoiceId='" + invoiceId
					+ "',@p_voucherId='" + voucherId + "',@p_userId='" + userId + "',@p_tdsRate='" + tdsRate
					+ "',@p_finalPayableAmt='" + finalPayableAmt + "',@p_tdsTransactionDate='" + tdsTransactionDate
					+ "',@p_tdsNarration='" + tdsNarration + "',@p_tdsAmount='" + tdsAmount + "',@p_tdsLedgerId='"
					+ tdsLedgerId + "',@p_vendorid='" + vendorid + "', @p_roundOffAmount=" + roundOffAmount + ";";
			logger.info("value=====" + value);
			em.createNamedStoredProcedureQuery("salesAccountRoutines").setParameter("actionType", "addTdsAmount")
					.setParameter("actionValue", value).execute();
			// resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Amount Modified successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : tdsAmountAdit Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCurrentVoucherTypeListForSale(String orgName, String orgDivision) {
		logger.info("Method : getCurrentVoucherTypeListForSale starts");
		List<DropDownModel> vList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
					.setParameter("actionType", "getCurrentVoucherTypeListForSale").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCurrentVoucherTypeListForSale ends" + vList);
		return vList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getcurrentvoucherForSale(String id, String orgName,
			String orgDivision) {
		logger.info("Method : getcurrentvoucher starts");

		List<DropDownModel> itemList = new ArrayList<>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> results = em.createNamedStoredProcedureQuery("salesAccountRoutines")
					.setParameter("actionType", "getcurrentvoucherForSale").setParameter("actionValue", value)
					.getResultList();

			for (Object[] row : results) {
				String buyerName = row[0] != null ? row[0].toString() : null;
				Object buyerLedger = row[1];

				DropDownModel dropDownModel = new DropDownModel(buyerLedger, buyerName);
				itemList.add(dropDownModel);
			}
			resp.setBody(itemList);
		} catch (Exception e) {
			logger.error("Error in getcurrentvoucher: ", e);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("Method : getcurrentvoucherForSale ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveVoucherDetailsforSale(String orgName, String orgDivision, String voucherTypeId,
			String voucherClassId, String ledgerName, String ledgerId, String pVoucherId, String invoiceId) {
		logger.info("Method : saveVoucherDetailsforSale Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_voucherTypeId='"
					+ voucherTypeId + "',@p_voucherClassId='" + voucherClassId + "',@p_ledgerName='" + ledgerName
					+ "',@p_ledgerId='" + ledgerId + "',@p_pVoucherId='" + pVoucherId + "',@p_invoiceId='" + invoiceId
					+ "';";
			logger.info("value=====" + value);
			em.createNamedStoredProcedureQuery("salesAccountRoutines").setParameter("actionType", "saveVoucherDetails")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Data saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : saveVoucherDetailsforSale Dao ends" + resp);
		return resp;
	}
}
