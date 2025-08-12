package nirmalya.aatithya.restmodule.his.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateAccountJournalVoucherParameter;
import nirmalya.aatithya.restmodule.his.model.ItemBillModel;

@Repository
public class HisOpdBillingDao {
	Logger logger = LoggerFactory.getLogger(HisOpdBillingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> categoryList(String org, String orgDiv) {
		logger.info("Method :categoryList starts");

		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();

		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_billing_routines")
					.setParameter("actionType", "categoryListData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				categoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : categoryList ends");
		return categoryList;
	}

	@SuppressWarnings("unchecked")
	public List<ItemBillModel> getSkuListCatWise(String org, String orgDiv, String cat_id) {
		logger.info("Method :getSkuListCatWise starts");

		List<ItemBillModel> itemList = new ArrayList<ItemBillModel>();

		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "', @p_cat_id='" + cat_id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_billing_routines")
					.setParameter("actionType", "skuListData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object gstRate = "0.00";
				Object price = "0.00";

				if (m[5] != null) {
					gstRate = m[5].toString();
				}
				if (m[6] != null) {
					price = m[6].toString();
				}

				ItemBillModel dropDownModel = new ItemBillModel(m[0], m[1], m[2], m[3], m[4], gstRate, price);
				itemList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSkuListCatWise ends");
		return itemList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewOpdDetails(String orgName, String orgDivision, String fromdate, String todate) {
		logger.info("Method : viewOpdDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromdate='" + fromdate
					+ "',@p_todate='" + todate + "' ;";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_billing_routines")
					.setParameter("actionType", "viewOpdData").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewOpdDetails Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editOpd(String Id, String organization, String orgDivision) {
		logger.info("Method : editOpd Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_patientId='" + Id + "';";

			logger.info("vvvv" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_billing_routines")
					.setParameter("actionType", "editOpdDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : editOpd Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getBalanceSheet(String id, String organization, String orgDivision) {
		logger.info("Method : getBalanceSheet Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_booking_id='" + id + "', @p_org='" + organization + "', @p_orgDiv='" + orgDivision
					+ "';";

			logger.info("vvvv" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_billing_routines")
					.setParameter("actionType", "custBalanceSheet").setParameter("actionValue", value).getResultList();

			if (x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data Fetched Successfully");
			} else {
				resp.setBody(null);
				resp.setCode("failed");
				resp.setMessage("Data Not Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}

		logger.info("Method : getBalanceSheet Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getOrderListDao(String id, String organization, String orgDivision) {
		logger.info("Method : getOrderListDao Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_bookId='" + id + "', @p_org='" + organization + "', @p_orgDiv='" + orgDivision
					+ "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_billing_routines")
					.setParameter("actionType", "order_list").setParameter("actionValue", value).getResultList();
			
			if (x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data Fetched Successfully");
			} else {
				resp.setBody(null);
				resp.setCode("failed");
				resp.setMessage("Data Not Found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : getOrderListDao Dao ends");
		return resp;
		
	}
	
	/*
	 * @SuppressWarnings("unchecked") public JsonResponse<Object>
	 * getOrderFullDetailstDao(String id, String bookId, String organization, String
	 * orgDivision) { logger.info("Method : getOrderFullDetailstDao Dao starts");
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<Object>();
	 * 
	 * try { String value = "SET @p_orderId='" + id + "', @p_bookId='" + bookId +
	 * "', @p_org='" + organization + "', @p_orgDiv='" + orgDivision + "';";
	 * 
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("his_billing_routines")
	 * .setParameter("actionType", "order_dtls").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * if (x.size() > 0) { resp.setBody(x); resp.setCode("success");
	 * resp.setMessage("Data Fetched Successfully"); } else { resp.setBody(null);
	 * resp.setCode("failed"); resp.setMessage("Data Not Found"); }
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * resp.setMessage("Something Went Wrong !"); }
	 * logger.info("Method : getOrderFullDetailstDao Dao ends"); return resp;
	 * 
	 * }
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveBill(String orgName, String orgDivision, String userId, String data) {
		logger.info("Method : saveBill Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_createdBy='" + userId
					+ "', @p_data='" + data + "';";

			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_billing_routines")
					.setParameter("actionType", "addBillInvoice").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Bill Added Successfully");

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage("Something went wrong");
			e.printStackTrace();
		}
		logger.info("Method : saveBill Dao ends");
		return resp;
	}
	
	/*
	 * @SuppressWarnings("unchecked") public JsonResponse<Object>
	 * modifyBillInvoice(String orgName, String orgDivision, String userId, String
	 * data) { logger.info("Method : modifyBillInvoice Dao starts" + userId);
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<Object>();
	 * 
	 * try { String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision
	 * + "',@p_createdBy='" + userId + "', @p_data='" + data + "';";
	 * 
	 * logger.info(value); List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("his_billing_routines")
	 * .setParameter("actionType", "modifyBillInvoice").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * resp.setBody(x.get(0)); resp.setCode("success");
	 * resp.setMessage("Bill Modified Successfully");
	 * 
	 * } catch (Exception e) { resp.setCode("failed");
	 * resp.setMessage("Something went wrong"); e.printStackTrace(); }
	 * logger.info("Method : modifyBillInvoice Dao ends"); return resp; }
	 */

	public ResponseEntity<JsonResponse<Object>> ipdBillingPay(String userId, String orgName, String orgDivision, String data) {
		logger.info("Method : ipdBillingPay starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validation) {

			try {

				String value = "SET @p_userId='" + userId + "', @p_org='" + orgName + "', @p_orgDiv='" + orgDivision + "', @p_data='" + data + "';";
				
				System.out.println(value);
				
				em.createNamedStoredProcedureQuery("his_billing_routines")
						.setParameter("actionType", "ipd_bill_pay").setParameter("actionValue", value).execute();

				resp.setCode("201");
				resp.setMessage("Receipt voucher created successfully.");
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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : ipdBillingPay ends");
		return response;
	}
	
	/*
	 * @SuppressWarnings("unchecked") public JsonResponse<Object>
	 * getOrderListDao(String id, String organization, String orgDivision) {
	 * logger.info("Method : getOrderListDao Dao starts");
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<Object>();
	 * 
	 * try { String value = "SET @p_bookId='" + id + "', @p_org='" + organization +
	 * "', @p_orgDiv='" + orgDivision + "';";
	 * 
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("his_billing_routines")
	 * .setParameter("actionType", "order_list").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * if (x.size() > 0) { resp.setBody(x); resp.setCode("success");
	 * resp.setMessage("Data Fetched Successfully"); } else { resp.setBody(null);
	 * resp.setCode("failed"); resp.setMessage("Data Not Found"); }
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * resp.setMessage("Something Went Wrong !"); }
	 * logger.info("Method : getOrderListDao Dao ends"); return resp;
	 * 
	 * }
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getOrderFullDetailstDao(String id, String bookId, String organization, String orgDivision) {
		logger.info("Method : getOrderFullDetailstDao Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_orderId='" + id + "', @p_bookId='" + bookId + "', @p_org='" + organization + "', @p_orgDiv='" + orgDivision
					+ "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_billing_routines")
					.setParameter("actionType", "order_dtls").setParameter("actionValue", value).getResultList();
			
			if (x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data Fetched Successfully");
			} else {
				resp.setBody(null);
				resp.setCode("failed");
				resp.setMessage("Data Not Found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : getOrderFullDetailstDao Dao ends");
		return resp;
		
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> modifyBillInvoice(String orgName, String orgDivision, String userId, String data) {
		logger.info("Method : modifyBillInvoice Dao starts" + userId);
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_createdBy='" + userId
					+ "', @p_data='" + data + "';";
			
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_billing_routines")
					.setParameter("actionType", "modifyBillInvoice").setParameter("actionValue", value).getResultList();
			
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Bill Modified Successfully");
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage("Something went wrong");
			e.printStackTrace();
		}
		logger.info("Method : modifyBillInvoice Dao ends");
		return resp;
	}


}
