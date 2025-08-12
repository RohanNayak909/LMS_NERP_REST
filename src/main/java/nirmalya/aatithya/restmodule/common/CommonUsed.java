package nirmalya.aatithya.restmodule.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

public class CommonUsed {
	static Logger logger = LoggerFactory.getLogger(CommonUsed.class);

	/** 1. GENERATE QR CODE **/

	@SuppressWarnings("deprecation")
	public static void generateQRCode(String qrcode, String uniqueid, String mobile, String name,
			String fileUploadProfile) {
		try {
			String qrCodeData = "UniqueId : " + uniqueid + "\nMobile : " + mobile + "\nName : " + name;
			String filePath = fileUploadProfile + qrcode;
			String charset = "UTF-8";// "ISO-8859-1";

			Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();

			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
					BarcodeFormat.QR_CODE, 200, 200, hintMap);
			MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1),
					new File(filePath));
			logger.info("QR Code image created successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 2. SMS GATEWAY
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 **/

	public static void sendSMS(String mobile, String message) throws ClientProtocolException, IOException {

		String ServerDomainApiEndPoint = "https://www.smsgateway.center/SMSApi/rest/send";

		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(ServerDomainApiEndPoint);

		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<>(2);
		params.add(new BasicNameValuePair("userId", "ncord"));
		params.add(new BasicNameValuePair("password", "Ayoqpey1"));
		params.add(new BasicNameValuePair("msg", message));
		params.add(new BasicNameValuePair("msgType", "text"));
		params.add(new BasicNameValuePair("sendMethod", "simpleMsg"));
		params.add(new BasicNameValuePair("senderId", "EHSAPP"));
		params.add(new BasicNameValuePair("dltEntityId", "1601100000000002843"));
		params.add(new BasicNameValuePair("duplicateCheck", "true"));
		params.add(new BasicNameValuePair("format", "json"));
		params.add(new BasicNameValuePair("mobile", mobile));
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		// Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();

		logger.info("StatusCode: {}", response.getStatusLine().getStatusCode());

		if (entity != null) {
			try (InputStream instream = entity.getContent()) {
				logger.info(EntityUtils.toString(entity, "utf-8"));
			}
		}
	}

	public static int sendSMSReturnResponse(String mobile, String message) throws ClientProtocolException, IOException {

		String ServerDomainApiEndPoint = "https://www.smsgateway.center/SMSApi/rest/send";

		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(ServerDomainApiEndPoint);

		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<>(2);
		params.add(new BasicNameValuePair("userId", "ncord"));
		params.add(new BasicNameValuePair("password", "Ayoqpey1"));
		params.add(new BasicNameValuePair("msg", message));
		params.add(new BasicNameValuePair("msgType", "text"));
		params.add(new BasicNameValuePair("sendMethod", "simpleMsg"));
		params.add(new BasicNameValuePair("senderId", "EHSAPP"));
		params.add(new BasicNameValuePair("dltEntityId", "1601100000000002843"));
		params.add(new BasicNameValuePair("duplicateCheck", "true"));
		params.add(new BasicNameValuePair("format", "json"));
		params.add(new BasicNameValuePair("mobile", mobile));
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		// Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();

		logger.info("StatusCode: {}", response.getStatusLine().getStatusCode());

		if (entity != null) {
			try (InputStream instream = entity.getContent()) {
				logger.info(EntityUtils.toString(entity, "utf-8"));
			}
		}

		return response.getStatusLine().getStatusCode();
	}

	/**
	 * @param procedureName name of the procedure
	 * @param actionType    action type of the procedure
	 * @param actionValue   action value of the procedure
	 * @param em            is the entity manager, executes persistent logics
	 * @return List of object array fetched from db
	 */
	@SuppressWarnings("unchecked")
	public static List<Object[]> getResultList(String procedureName, String actionType, String actionValue,
			EntityManager em) {
		logger.info("Procedure name : {}, actionType :{}, actionValue :{}", procedureName, actionType, actionValue);
		return em.createNamedStoredProcedureQuery(procedureName)
				.setParameter(ProcedureNameConstants.ACTION_TYPE, actionType)
				.setParameter(ProcedureNameConstants.ACTION_VALUE, actionValue).getResultList();
	}

	/**
	 * @param procedureName name of the procedure
	 * @param actionType    action type of the procedure
	 * @param actionValue   action value of the procedure
	 * @param em            is the entity manager, executes persistent logics
	 */
	public static void executeQuery(String procedureName, String actionType, String actionValue, EntityManager em) {
		logger.info("Procedure name : {}, actionType :{}, actionValue :{}", procedureName, actionType, actionValue);
		em.createNamedStoredProcedureQuery(procedureName).setParameter(ProcedureNameConstants.ACTION_TYPE, actionType)
				.setParameter(ProcedureNameConstants.ACTION_VALUE, actionValue).execute();
	}
	
	
	/**
	 * @param resp where response code and response message will be saved.
	 * @param e exception thrown by database
	 */
	public static void getErrorDetails(JsonResponse<Object> resp, Exception e, ServerDao serverDao) {
		try {
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Object> getResultListSimpleObject(String procedureName, String actionType, String actionValue,
			EntityManager em) throws Exception {
		logger.info("Procedure name : {}, actionType :{}, actionValue :{}", procedureName, actionType, actionValue);
		return em.createNamedStoredProcedureQuery(procedureName).setParameter(CommonConstants.ACTION_TYPE, actionType)
				.setParameter(CommonConstants.ACTION_VALUE, actionValue).getResultList();
	}
}
