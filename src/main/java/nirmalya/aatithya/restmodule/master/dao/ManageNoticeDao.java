package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateNoticePolicyParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.ManageNoticeRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
	public class ManageNoticeDao {

		Logger logger = LoggerFactory.getLogger(ManageLetterDao.class);
		@Autowired
		ServerDao serverDao;

		@Autowired
		private EntityManager em;

		@Autowired
		private EnvironmentVaribles env;
		
		// Add Notice
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<Object>> publishNotice(ManageNoticeRestModel data) {
			logger.info("Method : publishNotice starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();

			List<ManageNoticeRestModel> description = new ArrayList<ManageNoticeRestModel>();

			resp.setMessage("");
			resp.setCode("");

			String values = GenerateNoticePolicyParameter.publishsNoticeDetails(data);
			if (validity)
				try {
					if (data.getNoticeId() != null && data.getNoticeId() != "") {
						List<Object[]> x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
								.setParameter("actionType", "modifyPublishNotice").setParameter("actionValue", values)
								.getResultList();

						if(x.get(0) != null) {
						Util.setJsonResponse(resp, null, ResponseStatus.success, "Notice Modified Successfully");
						}
					} else {
						List<Object[]> x1 = em.createNamedStoredProcedureQuery("hrmManagePolicy")
								.setParameter("actionType", "publishNotice").setParameter("actionValue", values)
								.getResultList();

						if(x1.get(0) != null) {
						Util.setJsonResponse(resp, null, ResponseStatus.success, "Notice Drafted Successfully");
						}
					}

				} catch (Exception e) {

					try {
						String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
						resp.setMessage(err[1]);
						
						System.err.println(err[0]);
						System.err.println(err[1]);
						Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();

				}
			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : publishNotice ends");
			return response;
		}

		
		// All Employee List

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getAllNotice(String orgName, String orgDivision, String userId) {
			logger.info("Method : getAllNotice Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {

				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";

				System.out.println("value>>getAllNotice>>>>" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
						.setParameter("actionType", "getAllNoticeDet").setParameter("actionValue", value).getResultList();
				resp.setBody(x);

				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getAllNotice Dao ends");

			return resp;

		}

		// get all notice content
		public JsonResponse<Object> getPublishNoticeEdit(String organization, String orgDivision, String id) {
			logger.info("Method : getNoticeEdit Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {

				String value = "SET @p_organization='" + organization + "',@p_orgDivision='" + orgDivision
						+ "',@p_noticeId='" + id + "';";
				
				Object x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
						.setParameter("actionType", "noticeEditByID").setParameter("actionValue", value).getResultList();

				if (x != null) {
					Util.setJsonResponse(resp, x, ResponseStatus.success,  ApiResponseMessage.DATA_FETCH_SUCCESS);
				} else {
					Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
				}

			} catch (Exception e) {
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getNoticeEdit Dao ends");

			return resp;
		}

		//Delete Notice 
		public JsonResponse<Object> deleteNotice(String org, String orgDiv, String userId, String id) {
			logger.info("Method : deleteNotice starts");
			
			JsonResponse<Object> resp = new JsonResponse<>();
			
			try {
				
				String value = "SET @p_noticeId='" + id + "',@p_organization='" + org + "',@p_orgDivision='" + orgDiv
						+ "',@p_userId='" + userId + "';";
				
				em.createNamedStoredProcedureQuery("hrmManagePolicy").setParameter("actionType", "deleteNotice")
				.setParameter("actionValue", value).execute();
				
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
				
			} catch (Exception e) {
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				e.printStackTrace();
			}
			
			logger.info("Method : deleteNotice ends");
			return resp;
		}
		
		
		// Fetch pdf Details

		@SuppressWarnings("unused")
		public JsonResponse<Object> fetchPdfDetails(String id, String organization, String orgDivision, String userId) {
			logger.info("Method : fetchPdfDetails starts");
			ManageNoticeRestModel noticeDetails = new ManageNoticeRestModel();

			JsonResponse<Object> resp = new JsonResponse<>();
			try {

				String value = "SET @p_noticeId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
						+ "',@p_userId='" + userId + "';";

				System.out.println("value pdf>>>"+value);
				Object x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
						.setParameter("actionType", "getPDFDetails").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			logger.info("Method : fetchPdfDetails ends");

			return resp;
		}

}
