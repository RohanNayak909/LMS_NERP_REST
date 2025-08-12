package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.account.model.AccountCreditNoteRestModel;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.ItemShoukeenModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.account.CreditNoteGenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateAccountJournalVoucherParameter;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateCreditNoteVoucherParameter;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmLeadsDao;

@Repository
public class RestAccountCreditNoteDao {
	Logger logger = LoggerFactory.getLogger(RestAccountCreditNoteDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getorderList(String id, String orgName,
			String orgDivision) {

		logger.info("Method : getorderList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_salesId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "getorderList").setParameter("actionValue", value).getResultList();
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
		System.out.println(response);
		logger.info("Method : getorderList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getProductList(String id, String orgName,
			String orgDivision) {

		logger.info("Method : getProductList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_orderId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "getProductList").setParameter("actionValue", value).getResultList();
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
		System.out.println(response);
		logger.info("Method : getProductList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ItemShoukeenModel>>> getProductDetails(String id, String pid,
			String orgName, String orgDivision) {
		logger.info("Method : getProductDetails starts");

		List<ItemShoukeenModel> getAllemployee = new ArrayList<ItemShoukeenModel>();
		JsonResponse<List<ItemShoukeenModel>> resp = new JsonResponse<List<ItemShoukeenModel>>();

		String value = "SET @p_orderId='" + id + "',@p_prdcId='" + pid + "',@p_org='" + orgName + "',@p_orgDiv='"
				+ orgDivision + "';";
		System.out.println("======>>>" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "getOrderItem").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				String extraDis = "";
				if (m[14] == null) {
					extraDis = "0";
				} else {
					extraDis = m[14].toString();
				}

				ItemShoukeenModel viewdemo = new ItemShoukeenModel(m[0], m[1], m[2].toString(), m[3].toString(),
						m[4].toString(), m[5].toString(), m[6].toString(), m[7], m[8], m[9], m[10], m[11], null, m[12],
						extraDis, null, null);

				/*
				 * this.categoryId = (String) categoryId; this.categoryName = (String)
				 * categoryName; this.quantity = (String) quantity; this.itemUnitPrice =
				 * (String) itemUnitPrice; this.discount = (String) discount; this.gstRate =
				 * (String) gstRate; this.lineTotal = (String) lineTotal; this.productDimension
				 * = (String) productDimension; this.productId = (String) productId;
				 * this.productName = (String) productName; this.itemCgst = (Double) itemCgst;
				 * this.itemSgst = (Double) itemSgst; this.replaceBtnStatus = (boolean)
				 * replaceBtnStatus; this.dealerCode = (String) dealerCode; this.extraDiscount =
				 * (String) extraDiscount; this.toggleRegularCustom = (String)
				 * toggleRegularCustom; this.qIGST = (Double) qIGST;
				 */
				System.out.println("response-------------------------------" + viewdemo);
				getAllemployee.add(viewdemo);
			}
			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}

		resp.setBody(getAllemployee);
		ResponseEntity<JsonResponse<List<ItemShoukeenModel>>> response = new ResponseEntity<JsonResponse<List<ItemShoukeenModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductDetails ends");
		System.out.println("response data is" + response);
		return response;
	}

	/*
	 * add
	 */

	@SuppressWarnings({ "unchecked", "unused" })
	public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> addCreditNote(
			List<AccountCreditNoteRestModel> addCreditNote) {
		logger.info("Method : addCreditNote starts");
		JsonResponse<List<AccountCreditNoteRestModel>> resp = new JsonResponse<List<AccountCreditNoteRestModel>>();
		List<AccountCreditNoteRestModel> listData = new ArrayList<AccountCreditNoteRestModel>();

		String orderId;
		String address;

		try {
			String values = CreditNoteGenerateParameter.addCreditNote(addCreditNote);
			System.out.println("====>>>" + values);
			if (addCreditNote.get(0).getCreditNoteId() == null || addCreditNote.get(0).getCreditNoteId() == "") {
				System.out.println("addCreditNote values---------------------------" + values);

				em.createNamedStoredProcedureQuery("credit_notes_routines").setParameter("actionType", "addCreditNote")
						.setParameter("actionValue", values).execute();

			}
			resp.setCode("Success");
			resp.setMessage("Order placed successfully");
		} catch (Exception e) {
			resp.setCode("Failed");
			resp.setMessage(e.getLocalizedMessage());

		}
		ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addCreditNote dao ends");
		return response;
	}

	// restViewJournalVoucher

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> creditNoteView(String orgName, String orgDivision) {
		logger.info("Method : creditNoteView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "creditNoteView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : creditNoteView Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>>
	 * creditNoteView(String userId,String orgName, String orgDivision) {
	 * logger.info("Method : creditNoteView starts");
	 * List<AccountCreditNoteRestModel> respList = new
	 * ArrayList<AccountCreditNoteRestModel>();
	 * 
	 * String value = "SET @p_userId='" + userId + "',@p_org='" + orgName +
	 * "',@p_orgDiv='" + orgDivision + "';"; System.out.println("====>>>"+value);
	 * try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("credit_notes_routines")
	 * .setParameter("actionType", "creditNoteView").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * if(m[5]=="" || m[5]==null) { m[5]=""; } AccountCreditNoteRestModel
	 * restPayroll = new AccountCreditNoteRestModel(m[0], m[1], m[2], m[3], m[4],
	 * m[5], m[6], m[7], m[8], m[9].toString(), m[10].toString(), m[11].toString(),
	 * m[12].toString(), m[13], m[14], m[15],null,null); respList.add(restPayroll);
	 * 
	 * }
	 * 
	 * System.out.println("VIEW" + respList);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * JsonResponse<List<AccountCreditNoteRestModel>> resp = new
	 * JsonResponse<List<AccountCreditNoteRestModel>>(); resp.setBody(respList);
	 * ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> response = new
	 * ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>>( resp,
	 * HttpStatus.CREATED); System.out.println("response" + response);
	 * 
	 * 
	 * if (resp.getMessage() == null) { resp.setMessage("View successfully"); }
	 * 
	 * if (resp.getCode() == null) { resp.setCode("Success"); }
	 * 
	 * System.out.println("VIEWWWWWWWW" + respList);
	 * logger.info("Method : creditNoteView ends"); return response;
	 * 
	 * }
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> getCreditLedgerList(String id, String orgName,
			String orgDivision) {
		logger.info("Method : getCreditLedgerList starts");

		List<AccountCreditNoteRestModel> itemNameList = new ArrayList<AccountCreditNoteRestModel>();
		JsonResponse<List<AccountCreditNoteRestModel>> resp = new JsonResponse<List<AccountCreditNoteRestModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "getCreditLedgerList").setParameter("actionValue", value)
					.getResultList();

			System.out.println(value);
			for (Object[] m : x) {

				if (m[2] == "" || m[2] == null) {
					m[2] = "";
				}

				AccountCreditNoteRestModel dropDownModel = new AccountCreditNoteRestModel(m[0], m[1], m[2].toString(),
						m[3]);
				itemNameList.add(dropDownModel);
			}
			// System.out.println("getAllcustomer" +itemNameList);
			if (itemNameList.size() > 0) {
				resp.setBody(itemNameList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(itemNameList);
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountCreditNoteRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCreditLedgerList ends" + response);

		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewCreditNote(String id, String orgName, String orgDivision) {
		logger.info("Method : viewCreditNote Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET  @p_creditId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "viewCreditNotes").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewCreditNote Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editVoucher(String id, String orgName,
			String orgDivision) {
		logger.info("Method : editVoucher starts");
		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		List<AccountJournalVoucherModel> rs = new ArrayList<AccountJournalVoucherModel>();
		try {

			String value = "SET @p_journalVoucher='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "editVoucher").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf" + x);

			for (Object[] m : x) {

				if (m[11] == null || m[11] == "") {
					m[11] = "";
				}

				AccountJournalVoucherModel restPayroll = new AccountJournalVoucherModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11].toString(), m[12].toString(),m[13]);
				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> response = new ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editPaymentInfo ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println(response);
		return response;
	}

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<AccountCreditNoteRestModel>>
	 * viewCreditNote(String id,String orgName, String orgDivision) {
	 * logger.info("Method : viewCreditNote starts");
	 * 
	 * JsonResponse<AccountCreditNoteRestModel> resp = new
	 * JsonResponse<AccountCreditNoteRestModel>(); List<AccountCreditNoteRestModel>
	 * getShoukeenProduct = new ArrayList<AccountCreditNoteRestModel>();
	 * List<ItemShoukeenModel> docList = new ArrayList<ItemShoukeenModel>();
	 * 
	 * try {
	 * 
	 * String value = "SET @p_creditId='" + id + "',@p_org='" + orgName +
	 * "',@p_orgDiv='" + orgDivision + "';";
	 * System.out.println("for edit purpose===>>>" + value); List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("credit_notes_routines")
	 * .setParameter("actionType", "viewCreditNotes").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * 
	 * if(m[5]=="" || m[5]==null) { m[5]=""; }
	 * 
	 * if(m[16]=="" || m[16]==null) { m[16]=""; }
	 * 
	 * if(m[17]=="" || m[17]==null) { m[17]=""; }
	 * 
	 * AccountCreditNoteRestModel orderdeatils = new
	 * AccountCreditNoteRestModel(m[0], m[1], m[2], m[3], m[4], m[5].toString(),
	 * m[6], m[7], m[8], m[9].toString(), m[10].toString(), m[11].toString(),
	 * m[12].toString(), m[13], m[14], m[15],m[16],m[17].toString());
	 * getShoukeenProduct.add(orderdeatils);
	 * 
	 * System.out.println("orderdeatils1111111111111---------------"+orderdeatils);
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } if (getShoukeenProduct.size()
	 * > 0) { try { String subValues = "SET @p_vocherId='" + id + "',@p_org='" +
	 * orgName + "',@p_orgDiv='" + orgDivision + "';";
	 * System.out.println(subValues); List<Object[]> x1 =
	 * em.createNamedStoredProcedureQuery("credit_notes_routines")
	 * .setParameter("actionType", "getProductDetails").setParameter("actionValue",
	 * subValues) .getResultList(); for (Object[] m : x1) {
	 * 
	 * ItemShoukeenModel viewdemo = new ItemShoukeenModel(m[0], m[1], m[2],
	 * m[3].toString(), m[4], m[5], m[6].toString(),
	 * m[7],null,m[8],m[9],m[10],m[11],m[12],null,null,null,null,null,null);
	 * docList.add(viewdemo); } getShoukeenProduct.get(0).setItemattribute(docList);
	 * }catch (Exception e) { e.printStackTrace(); } }
	 * resp.setBody(getShoukeenProduct.get(0)); HttpHeaders responseHeaders = new
	 * HttpHeaders(); responseHeaders.set("MyResponseHeader", "MyValue");
	 * 
	 * if (resp.getBody().getCreditNoteId() != null) { resp.setCode("Success");
	 * resp.setMessage("Data fetched  succesfully"); } else {
	 * resp.setCode("Failed"); resp.setMessage("Data Not Found"); }
	 * 
	 * ResponseEntity<JsonResponse<AccountCreditNoteRestModel>> response = new
	 * ResponseEntity<JsonResponse<AccountCreditNoteRestModel>>( resp,
	 * responseHeaders, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : viewCreditNote ends");
	 * System.out.println("response in edit product-------------" + response);
	 * return response;
	 * 
	 * }
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherNumber(String orgName, String orgDivision) {
		logger.info("Method : voucherNumber starts");
		List<DropDownModel> respList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "getvoucherNumber").setParameter("actionValue", value).getResultList();
			Object jobId = x.get(0);

			DropDownModel dropDownModel = new DropDownModel(jobId, null);
			respList.add(dropDownModel);
			resp.setBody(respList);
			resp.setMessage("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Unsuccess");
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : voucherNumber ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewCreditNoteFilter(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : viewCreditNoteFilter Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
					+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values====" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "viewCreditNoteFilter").setParameter("actionValue", values)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewCreditNoteFilter Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unused")
	public ResponseEntity<JsonResponse<Object>> addCreditNoteVoucher(
			List<AccountJournalVoucherModel> journalVoucherModel) {
		logger.info("Method : addCreditNoteVoucher starts");
		System.out.println("sdfddsfdf=====>>>>" + journalVoucherModel);

		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (AccountJournalVoucherModel l : journalVoucherModel) {
			if (l.getCostCenter() == null || l.getCostCenter() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Cost Center.");
				break;
			} else if (l.getDescription() == null || l.getDescription() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Description.");
				break;
			}
		}

		if (validation) {

			if (journalVoucherModel.get(0).getJournalVoucher() == null
					|| journalVoucherModel.get(0).getJournalVoucher() == "") {
				try {
					String value = GenerateCreditNoteVoucherParameter.saveJournalVoucherParam(journalVoucherModel);
					System.out.println("Add=====>>>>vchr--->" + value);

					em.createNamedStoredProcedureQuery("credit_notes_routines")
							.setParameter("actionType", "creditNoteVchr").setParameter("actionValue", value).execute();
					// }
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
			} else {
				try {
					String value = GenerateCreditNoteVoucherParameter.saveJournalVoucherParam(journalVoucherModel);
					System.out.println("modify=====>>>>" + value);
					em.createNamedStoredProcedureQuery("credit_notes_routines")
							.setParameter("actionType", "modifyCreditVoucher").setParameter("actionValue", value)
							.execute();
					// }
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

		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addCreditNoteVoucher ends");
		return response;
	}
	
	
	public ResponseEntity<JsonResponse<Object>> deleteCreditNote(String id,String orgName, String orgDivision) {
		logger.info("Method : deleteCreditNote starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		if (validity)
			try {
				String value = "SET @p_debitNoteId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("ID...." + value);
				em.createNamedStoredProcedureQuery("credit_notes_routines")
						.setParameter("actionType", "deleteCreditNote")
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

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  deleteCreditNote ends");
		System.out.println("DELETE" + response);
		return response;
	}
}
