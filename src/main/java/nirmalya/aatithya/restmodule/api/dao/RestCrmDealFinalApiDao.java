package nirmalya.aatithya.restmodule.api.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Base64;

import nirmalya.aatithya.restmodule.api.model.RestCrmDealFinalApiModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.MailService;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCRMDealFinalParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.PushNotification;

@Repository
public class RestCrmDealFinalApiDao {
	Logger logger = LoggerFactory.getLogger(RestCrmDealFinalApiDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	@Autowired
	MailService mailService;
	PushNotification pushNotification = new PushNotification();

	public ResponseEntity<JsonResponse<Object>> postDealFinalApi(RestCrmDealFinalApiModel data) {
		logger.info("Method : postDealFinalApi Dao starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();
		if (data.getAmount() == null || data.getAmount() == "" || data.getAmount().equals("")
				|| data.getAmount().equals(null)) {
			data.setAmount(null);
		}
		if (data.getPcdAmount() == null || data.getPcdAmount() == "" || data.getPcdAmount().equals("")
				|| data.getPcdAmount().equals(null)) {
			data.setPcdAmount(null);
		}
		if (data.getChqdate() == null || data.getChqdate() == "" || data.getChqdate() == "null"
				|| data.getChqdate().equals("") || data.getChqdate().equals(null) || data.getChqdate().equals("null")) {
			data.setChqdate(null);
		}
		if (data.getPcdDate() != "" && data.getPcdDate() != null && !data.getPcdDate().equals("")) {
			data.setPcdDate(DateFormatter.getStringDate(data.getPcdDate()));
		}
		try {
			String values = GenerateCRMDealFinalParam.getdealParam(data);
			logger.info(values);

			if (data.getDealId() == null || data.getDealId() == "" || data.getDealId().equals("")
					|| data.getDealId().equals(null)) {
				em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
						.setParameter("actionType", "addDealFinalDlts").setParameter("actionValue", values).execute();
				jsonResponse.setCode("success");
				jsonResponse.setMessage("Data added successfully");

			} else {
				em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
						.setParameter("actionType", "modifyDealFinalDlts").setParameter("actionValue", values)
						.execute();
				jsonResponse.setCode("success");
				jsonResponse.setMessage("Data modified successfully");

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info("err====" + err);
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Something went wrong");

			} catch (Exception e1) {
				e1.printStackTrace();
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Something went wrong");
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
				HttpStatus.OK);
		logger.info("Method : postDealFinalApi Dao ends");
		return response;
	}

	// view Deal Details
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealDetails(String createdBy, String organization,
			String orgDivision) {
		logger.info("Method : viewDealDetails Dao starts");

		List<RestCrmDealFinalApiModel> viewMaster = new ArrayList<RestCrmDealFinalApiModel>();
		JsonResponse<List<RestCrmDealFinalApiModel>> resp = new JsonResponse<List<RestCrmDealFinalApiModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
					.setParameter("actionType", "viewDealDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object date = null;
				if (m[6] != null) {
					date = DateFormatter.returnStringDate(m[6]);
				}
				Object pcddate = null;
				if (m[12] != null) {
					pcddate = DateFormatter.returnStringDate(m[12]);
				}
				Object chdate = null;
				if (m[18] != null) {
					chdate = DateFormatter.returnStringDate(m[18]);
				}
				RestCrmDealFinalApiModel restStudentModel = new RestCrmDealFinalApiModel(m[0], m[1], m[2], m[3], m[4],
						m[5], date, m[7], m[8], m[9], m[10], m[11], pcddate, m[13], m[14], m[15], m[16], m[17], chdate,
						m[19]);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewDealDetails Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// View status
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealStatus(String createdBy, String organization,
			String orgDivision) {
		logger.info("Method : viewDealStatus Dao starts");

		List<RestCrmDealFinalApiModel> viewMaster = new ArrayList<RestCrmDealFinalApiModel>();
		JsonResponse<List<RestCrmDealFinalApiModel>> resp = new JsonResponse<List<RestCrmDealFinalApiModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
					.setParameter("actionType", "viewDealStatus").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[6] != null) {
					date = DateFormatter.returnStringDate(m[6]);
				}
				Object pcddate = null;
				if (m[12] != null) {
					pcddate = DateFormatter.returnStringDate(m[12]);
				}
				RestCrmDealFinalApiModel restStudentModel = new RestCrmDealFinalApiModel(m[0], m[1], m[2], m[3], m[4],
						m[5], date, m[7], m[8], m[9], m[10], m[11], pcddate, m[13], m[14], m[15], m[16], m[17], m[18]);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewDealStatus Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSalesManagerList(String createdBy, String organization, String orgDivision) {
		logger.info("Method : getSalesManagerList starts");
		List<DropDownModel> list = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
				+ "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
					.setParameter("actionType", "getSalesManagerList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				list.add(dropDownModel);

				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSalesManagerList end");
		return list;
	}

	// view Deal Details search
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealDetailsSearch(String createdBy, String organization,
			String orgDivision, String customer) {
		logger.info("Method : viewDealDetailsSearch Dao starts");

		List<RestCrmDealFinalApiModel> viewMaster = new ArrayList<RestCrmDealFinalApiModel>();
		JsonResponse<List<RestCrmDealFinalApiModel>> resp = new JsonResponse<List<RestCrmDealFinalApiModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "',@p_customer='" + customer + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
					.setParameter("actionType", "viewDealDetailsSearch").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[6] != null) {
					date = DateFormatter.returnStringDate(m[6]);
				}
				Object pcddate = null;
				if (m[12] != null) {
					pcddate = DateFormatter.returnStringDate(m[12]);
				}
				Object chdate = null;
				if (m[17] != null) {
					chdate = DateFormatter.returnStringDate(m[17]);
				}
				RestCrmDealFinalApiModel restStudentModel = new RestCrmDealFinalApiModel(m[0], m[1], m[2], m[3], m[4],
						m[5], date, m[7], m[8], m[9], m[10], m[11], pcddate, m[13], m[14], m[15], m[16], chdate, m[18]);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewDealDetailsSearch Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// View status search
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealStatusSearch(String createdBy, String organization,
			String orgDivision, String customer) {
		logger.info("Method : viewDealStatusSearch Dao starts");

		List<RestCrmDealFinalApiModel> viewMaster = new ArrayList<RestCrmDealFinalApiModel>();
		JsonResponse<List<RestCrmDealFinalApiModel>> resp = new JsonResponse<List<RestCrmDealFinalApiModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "',@p_customer='" + customer + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
					.setParameter("actionType", "viewDealStatusSearch").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[6] != null) {
					date = DateFormatter.returnStringDate(m[6]);
				}
				Object pcddate = null;
				if (m[12] != null) {
					pcddate = DateFormatter.returnStringDate(m[12]);
				}
				RestCrmDealFinalApiModel restStudentModel = new RestCrmDealFinalApiModel(m[0], m[1], m[2], m[3], m[4],
						m[5], date, m[7], m[8], m[9], m[10], m[11], pcddate, m[13], m[14], m[15], m[16], m[17], m[18]);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewDealStatusSearch Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// View status web report
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealStatusReport(String createdBy, String organization,
			String orgDivision, String fromDate, String toDate) {
		logger.info("Method : viewDealStatusReport Dao starts");

		List<RestCrmDealFinalApiModel> viewMaster = new ArrayList<RestCrmDealFinalApiModel>();
		JsonResponse<List<RestCrmDealFinalApiModel>> resp = new JsonResponse<List<RestCrmDealFinalApiModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
					.setParameter("actionType", "viewDealStatus").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[6] != null) {
					date = DateFormatter.returnStringDate(m[6]);
				}
				Object pcddate = null;
				if (m[12] != null) {
					pcddate = DateFormatter.returnStringDate(m[12]);
				}
				Object chdate = null;
				if (m[24] != null) {
					chdate = DateFormatter.returnStringDate(m[24]);
				}
				RestCrmDealFinalApiModel restStudentModel = new RestCrmDealFinalApiModel(m[0], m[1], m[2], m[3], m[4],
						m[5], date, m[7], m[8], m[9], m[10], m[11], pcddate, m[13], m[14], m[15], m[16], m[17], m[18],
						m[19], m[20], m[21], m[22], m[23], chdate, m[25]);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewDealStatusReport Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// View status web report search
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealStatusReportSearch(String createdBy,
			String organization, String orgDivision, String fromDate, String toDate, String customer, String saleTeam) {
		logger.info("Method : viewDealStatusReportSearch Dao starts");

		List<RestCrmDealFinalApiModel> viewMaster = new ArrayList<RestCrmDealFinalApiModel>();
		JsonResponse<List<RestCrmDealFinalApiModel>> resp = new JsonResponse<List<RestCrmDealFinalApiModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "',@p_customer='" + customer + "',@p_saleTeam='" + saleTeam
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
					.setParameter("actionType", "viewDealStatusReportSearch").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[6] != null) {
					date = DateFormatter.returnStringDate(m[6]);
				}
				Object pcddate = null;
				if (m[12] != null) {
					pcddate = DateFormatter.returnStringDate(m[12]);
				}
				Object chdate = null;
				if (m[24] != null) {
					chdate = DateFormatter.returnStringDate(m[24]);
				}
				RestCrmDealFinalApiModel restStudentModel = new RestCrmDealFinalApiModel(m[0], m[1], m[2], m[3], m[4],
						m[5], date, m[7], m[8], m[9], m[10], m[11], pcddate, m[13], m[14], m[15], m[16], m[17], m[18],
						m[19], m[20], m[21], m[22], m[23], chdate, m[25]);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewDealStatusReportSearch Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPaymentModeList() {
		logger.info("Method : getPaymentModeList starts");

		List<DropDownModel> user = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
					.setParameter("actionType", "getpaymentmode").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				user.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (user.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
			resp.setBody(user);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPaymentModeList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBankNameList() {
		logger.info("Method : getBankNameList starts");

		List<DropDownModel> user = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
					.setParameter("actionType", "getbanknamelist").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				user.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (user.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
			resp.setBody(user);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getBankNameList ends");
		return response;
	}

	// chequeDateReminder
	@SuppressWarnings("unchecked")
	public JsonResponse<DropDownModel> chequeDateReminder(String date) {
		logger.info("Method : chequeDateReminder starts");
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_date='" + DateFormatter.getStringDate(date) + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
					.setParameter("actionType", "chequeDateReminder").setParameter("actionValue", value)
					.getResultList();
			if (x.size() > 0) {
				logger.info("x===" + x.get(0)[0].toString());
				if (x.get(0)[0].toString() == null || x.get(0)[0].toString() == ""
						|| x.get(0)[0].toString().equals(null) || x.get(0)[0].toString().equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					String userid = x.get(0)[0].toString();
					String username = x.get(0)[1].toString();
					String to = x.get(0)[2].toString();
					String clientName = x.get(0)[3].toString();
					String sub = "Reminder email for cheque Date";
					String msg = "Hi " + username + "," + System.lineSeparator() + System.lineSeparator() + "" + date
							+ " : Today last cheque date of " + clientName + " ;";
					String msgId = pushNotification.pushFCMNotificationForChequeDate(userid, msg);
					logger.info("msgId====" + msgId);
					logger.info("TOOOOO" + to);
					logger.info("sub" + sub);
					logger.info("msg" + msg);
					mailService.sendEmail(to, sub, msg);
					resp.setCode("success");
					resp.setMessage("Reminder sent successfully");
				}
			} else {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
				logger.error("chequeDateReminder: " + err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				logger.error("chequeDateReminder: " + e.getMessage());
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			e.printStackTrace();
		}
		logger.info("resp===" + resp);
		logger.info("Method : chequeDateReminder ends");
		return resp;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> savemanageRemarks(String managerRemarksData, String userId, String org,
			String orgDiv) {
		logger.info("method: savemanageRemarks Dao Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @p_allData='" + managerRemarksData + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";

			System.out.println("value is coming like this==============> " + value);

			String reviewId = "";
			Gson gson = new Gson();
			JsonObject jsonObject = null;

			try {
				jsonObject = gson.fromJson(managerRemarksData, JsonObject.class);
				if (jsonObject.has("reviewId")) {
					reviewId = jsonObject.get("reviewId").getAsString();
				}
			} catch (Exception parseException) {
				logger.error("Error parsing managerRemarksData with Gson: ", parseException);
			}

			System.out.println("reviewId is coming like this==============> " + reviewId);

			if (reviewId == null || reviewId.trim().isEmpty()) {
				List<String> feedbackIdList = em.createNamedStoredProcedureQuery("appraisal_review_routines")
						.setParameter("actionType", "saveManagerRemarks").setParameter("actionValue", value)
						.getResultList();

				String newFeedbackId = feedbackIdList.get(0).toString();

				resp.setMessage("Feedback Forwarded successfully!");
				resp.setCode("Success");

				System.out.println("feedback id is coming================>" + newFeedbackId);

				// Send Email Notification
				if (jsonObject != null && jsonObject.has("managerEmail")) {
					JsonArray emails = jsonObject.getAsJsonArray("managerEmail");

					String encodedFeedbackId = Base64.getEncoder().encodeToString(newFeedbackId.getBytes());

					for (JsonElement emailElement : emails) {
						String email = emailElement.getAsString();
						System.out.println("email==============================>" + email);

						String subject = "📝 Feedback Request for Employee Review";
						String feedbackLink = "https://yourdomain.com/feedback-form?id=" + encodedFeedbackId;

						String message = "Dear Manager,\n\n"
								+ "You are kindly requested to provide your feedback for an employee appraisal.\n"
								+ "Please use the link below to access the feedback form:\n\n" + feedbackLink + "\n\n"
								+ "Your input is valuable and helps in performance evaluations.\n\n"
								+ "Best regards,\nHR Team";

						try {
							mailService.sendEmail(email, subject, message);
						} catch (Exception ex) {
							logger.error("Error sending email to " + email + ": ", ex);
						}
					}
				}

			} else {
				List<String> feedbackId = em.createNamedStoredProcedureQuery("appraisal_review_routines")
						.setParameter("actionType", "modifyManagerRemarks").setParameter("actionValue", value)
						.getResultList();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");

				System.out.println(feedbackId);
			}

		} catch (Exception e) {
			logger.error("Error in savemanageRemarks: ", e);
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception nestedException) {
				logger.error("Error while handling exception: ", nestedException);
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
		logger.info("method: savemanageRemarks Dao Ends");
		return response;
	}

}
