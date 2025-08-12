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
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.AccountPurchaseOrderRestModel;
import nirmalya.aatithya.restmodule.account.model.AccountPurchaseProductRestModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountCreditorLedgerModel;
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestPurchaseVoucherDao {

	Logger logger = LoggerFactory.getLogger(RestAccountDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	// JSON purchase view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPurchaseVoucher(String orgName, String orgDiv) {
		logger.info("Method : viewPurchaseVoucher Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("restViewVendorDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "getPurchaseList").setParameter("actionValue", values).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewPurchaseVoucher Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProductListDD(String orgName, String orgDiv, String type) {
		logger.info("Method : getProductListDD Dao starts");
		
		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "', @p_type='" + type + "';";
			System.out.println("restViewVendorDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "getItemList").setParameter("actionValue", values).getResultList();
			
			for(Object[] m : x) {
				DropDownModel dd = new DropDownModel(m[0],m[1],m[2],m[3],m[4],m[5]);
				
				if(m[6] != null) {
					dd.setOrgName(m[6].toString());
				}
				
				itemList.add(dd);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getProductListDD Dao ends");
		return itemList;
		
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> updateItemLedgerDao(String orgName, String orgDiv, String userId, String data) {
		logger.info("Method : updateItemLedgerDao Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "', @p_userId='" + userId
					+ "', @p_data='" + data + "';";

			System.out.println(values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
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

		logger.info("Method : updateItemLedgerDao Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addItemLedgerDao(String orgName, String orgDiv, String userId, String data) {
		logger.info("Method : addItemLedgerDao Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "', @p_userId='" + userId
					+ "', @p_data='" + data + "';";
			
			System.out.println(values);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "addItemLedger").setParameter("actionValue", values).getResultList();
			
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
		
		logger.info("Method : addItemLedgerDao Dao ends");
		return resp;
		
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> updateNarrationDao(String orgName, String orgDiv, String userId, String data) {
		logger.info("Method : updateNarrationDao Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "', @p_userId='" + userId
					+ "', @p_data='" + data + "';";

			System.out.println(values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "updateNarration").setParameter("actionValue", values).getResultList();

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

		logger.info("Method : updateNarrationDao Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> updateInvoice(String orgName, String orgDiv, String userId, String data) {
		logger.info("Method : updateInvoice Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "', @p_userId='" + userId
					+ "', @p_data='" + data + "';";
			
			System.out.println(values);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "updateInvoice").setParameter("actionValue", values).getResultList();
			
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
		
		logger.info("Method : updateInvoice Dao ends");
		return resp;
		
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveVoucherDao(String orgName, String orgDiv, String userId, String data) {
		logger.info("Method : approveVoucherDao Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "', @p_userId='" + userId
					+ "', @p_data='" + data + "';";

			System.out.println(values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "approvePVoucher").setParameter("actionValue", values).getResultList();

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

		logger.info("Method : approveVoucherDao Dao ends");
		return resp;

	}

	// editAccountInfo
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPurchaseVoucher(String id, String orgName, String orgDiv, String vtype) {
		logger.info("Method : viewPurchaseVoucher starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_purchaseId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "', @p_vtype='" + vtype + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "editPurchase").setParameter("actionValue", value).getResultList();
			logger.info("values-->" + value);

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewPurchaseVoucher ends");

		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPurchaseFilteredData(String orgName, String orgDivision, String fromDate,
			String toDate, String vtype) {
		logger.info("Method : viewPurchaseFilteredData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_orgName='" + orgName + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
					+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',@p_orgDiv='" + orgDivision
					+ "', @p_vtype='" + vtype + "';";

			logger.info("values----->" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "getPurchaseFilter").setParameter("actionValue", values)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewPurchaseFilteredData Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> accountRegisterPdf(String voucherType,
			String fromDate, String toDate, String orgName, String orgDivision) {
		logger.info("Method : accountRegisterPdf starts" + voucherType);
		JsonResponse<List<RestAccountCreditorLedgerModel>> resp = new JsonResponse<List<RestAccountCreditorLedgerModel>>();
		List<RestAccountCreditorLedgerModel> rs = new ArrayList<RestAccountCreditorLedgerModel>();

		String value = "SET @p_voucherType='" + voucherType + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision
				+ "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
				+ DateFormatter.getStringDate(toDate) + "';";
		logger.info("accountRegisterPdf values ========" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "accountRegisterPdf").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestAccountCreditorLedgerModel restPayroll = new RestAccountCreditorLedgerModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5].toString(), m[6], m[7]);

				rs.add(restPayroll);
			}

			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : accountRegisterPdf ends==" + response);
		return response;
	}

	// Excel

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>>
	 * purchaseRegisterExcel(String voucherType, String fromDate, String toDate,
	 * String orgDivision) { logger.info("Method : purchaseRegisterExcel starts" +
	 * voucherType); JsonResponse<List<RestAccountCreditorLedgerModel>> resp = new
	 * JsonResponse<List<RestAccountCreditorLedgerModel>>();
	 * List<RestAccountCreditorLedgerModel> rs = new
	 * ArrayList<RestAccountCreditorLedgerModel>();
	 * 
	 * String value = "SET @p_voucherType='" + voucherType + "',@p_orgDiv='" +
	 * orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) +
	 * "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "';";
	 * logger.info("accountRegisterPdf values ========" + value); try {
	 * 
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
	 * .setParameter("actionType", "accountRegisterPdf").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * RestAccountCreditorLedgerModel restPayroll = new
	 * RestAccountCreditorLedgerModel(m[0], m[1], m[2], m[3], m[4].toString(),
	 * m[5].toString(), m[6], m[7]);
	 * 
	 * rs.add(restPayroll); }
	 * 
	 * resp.setCode("Success"); resp.setMessage("Data Fetched Successfully"); }
	 * catch (Exception e) { e.printStackTrace(); resp.setCode("Failed");
	 * resp.setMessage(e.getMessage()); } resp.setBody(rs); HttpHeaders
	 * responseHeaders = new HttpHeaders(); responseHeaders.set("MyResponseHeader",
	 * "MyValue");
	 * 
	 * ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> response =
	 * new ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>>( resp,
	 * responseHeaders, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : purchaseRegisterExcel ends=="+response); return
	 * response; }
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> purchaseRegisterExcel(String voucherType, String fromDate, String toDate,
			String orgName, String orgDivision) {
		logger.info("Method : purchaseRegisterExcel Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_voucherType='" + voucherType + "',@p_orgName='" + orgName + "',@p_orgDiv='"
					+ orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "purchaseRegisterExcel").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : purchaseRegisterExcel Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> vendorTdsAmount(String orgName, String orgDivision, String voucherid, String invoiceid,
			String vtype) {
		logger.info("Method : vendorTdsAmount Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_voucherid='" + voucherid
					+ "',@p_invoiceid='" + invoiceid + "', @p_vtype='" + vtype + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "vendorTdsAmount").setParameter("actionValue", value).getResultList();
			logger.info("value-->" + value);
			System.out.println(x.get(0));
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : vendorTdsAmount Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> tdsAmountAdit(String orgName, String orgDivision, String tdsAmount, String vendorid,
			String tdsRate, String invoiceId, String voucherId, String userId, String finalPayableAmt,
			String tdsLedgerId, String tdsTransactionDate, String tdsNarration, String roundOffAmount,
			String tdsSection, String tdsInvList) {
		logger.info("Method : tdsAmountAdit Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_invoiceId='" + invoiceId
					+ "',@p_voucherId='" + voucherId + "',@p_userId='" + userId + "',@p_tdsRate='" + tdsRate
					+ "',@p_finalPayableAmt='" + finalPayableAmt + "',@p_tdsTransactionDate='" + tdsTransactionDate
					+ "',@p_tdsNarration='" + tdsNarration + "',@p_tdsAmount='" + tdsAmount + "',@p_tdsLedgerId='"
					+ tdsLedgerId + "',@p_vendorid='" + vendorid + "', @p_roundOffAmount=" + roundOffAmount
					+ ", @p_tdsSection='" + tdsSection + "',@p_tdsInvList='" + tdsInvList + "';";
			logger.info("value=====" + value);
			em.createNamedStoredProcedureQuery("purchaseRoutines").setParameter("actionType", "addTdsAmount")
					.setParameter("actionValue", value).execute();

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
	public List<DropDownModel> getTdsLedgerList(String orgName, String orgDivision) {
		logger.info("Method : getTdsLedgerList starts");
		List<DropDownModel> tdsLedgerList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "getTdsLedger").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				tdsLedgerList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTdsLedgerList ends" + tdsLedgerList);
		return tdsLedgerList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCurrentVoucherTypeList(String orgName, String orgDivision) {
		logger.info("Method : getVoucherTypeList starts");
		List<DropDownModel> vList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "getVoucherTypeList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCurrentVoucherTypeList ends" + vList);
		return vList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getcurrentvoucher(String id, String orgName,
			String orgDivision) {
		logger.info("Method : getcurrentvoucher starts");

		List<DropDownModel> itemList = new ArrayList<>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> results = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "getcurrentvoucher").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getcurrentvoucher ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getvoucherClassList(String id, String orgName,
			String orgDivision) {

		logger.info("Method : getvoucherClassList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "getvoucherClassList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getvoucherClassList ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLedgervoucher(String id, String orgName,
			String orgDivision) {
		logger.info("Method : getLedgervoucher starts");

		List<DropDownModel> itemList = new ArrayList<>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.error("value: " + value);
			List<Object[]> results = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "getLedgervoucher").setParameter("actionValue", value).getResultList();

			for (Object[] row : results) {
				String ledgerName = row[0] != null ? row[0].toString() : null;
				Object buyerLedger = row[1];

				DropDownModel dropDownModel = new DropDownModel(buyerLedger, ledgerName);
				itemList.add(dropDownModel);
			}
			resp.setBody(itemList);
		} catch (Exception e) {
			logger.error("Error in getLedgervoucher: ", e);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("Method : getLedgervoucher ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getTdsSection(String id, String orgName, String orgDivision,
			String type) {
		logger.info("Method : getTdsSection starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "', @p_type='" + type + "',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDivision + "';";
			logger.error("value: " + value);
			List<Object[]> results = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "getTdsSection").setParameter("actionValue", value).getResultList();

			if (results.size() > 0) {
				resp.setBody(results.get(0));
				resp.setCode("success");
				resp.setMessage("Data found");
			} else {
				resp.setCode("failed");
				resp.setMessage("No data found");
			}

		} catch (Exception e) {
			logger.error("Error in getLedgervoucher: ", e);
			resp.setCode("failed");
			resp.setMessage("No data found");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("Method : getLedgervoucher ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveVoucherDetails(String orgName, String orgDivision, String voucherTypeId,
			String voucherClassId, String ledgerName, String ledgerId, String pVoucherId, String invoiceId) {
		logger.info("Method : saveVoucherDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_voucherTypeId='"
					+ voucherTypeId + "',@p_voucherClassId='" + voucherClassId + "',@p_ledgerName='" + ledgerName
					+ "',@p_ledgerId='" + ledgerId + "',@p_pVoucherId='" + pVoucherId + "',@p_invoiceId='" + invoiceId
					+ "';";
			logger.info("value=====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "saveVoucherDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : saveVoucherDetails Dao ends" + resp);
		return resp;
	}

}
