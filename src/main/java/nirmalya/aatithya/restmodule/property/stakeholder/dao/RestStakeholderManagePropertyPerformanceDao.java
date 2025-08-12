package nirmalya.aatithya.restmodule.property.stakeholder.dao;

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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateManagePropertyPerformanceParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestManagePropertyPerformanceModel;

@Repository
public class RestStakeholderManagePropertyPerformanceDao {

	Logger logger = LoggerFactory.getLogger(RestStakeholderManagePropertyPerformanceDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

////add
	public ResponseEntity<JsonResponse<Object>> savePropertyPerformance(
			RestManagePropertyPerformanceModel restPayroll) {

		logger.info("Method : Rest savePropertyPerformance  Dao starts");
		logger.info("restPayroll" + restPayroll);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		logger.info("restPayroll.getId() ====" + restPayroll.getPerformanceId());

		try {

			String values = GenerateManagePropertyPerformanceParam.addPropertyPerformanceParam(restPayroll);

			if (restPayroll.getPerformanceId() == null || restPayroll.getPerformanceId() == "") {

				logger.info("values IN ADD" + values);
				em.createNamedStoredProcedureQuery("viewPropertyPerformance").setParameter("actionType", "adddetails")
						.setParameter("actionValue", values).execute();

			} else {

				logger.info("values in modify");
				em.createNamedStoredProcedureQuery("viewPropertyPerformance")
						.setParameter("actionType", "modifystddetails").setParameter("actionValue", values).execute();

			}

		}

		catch (Exception e) {
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

		logger.info("Method : Rest savePropertyPerformance Dao ends");

		return response;
	}

////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManagePropertyPerformanceModel>>> ViewPropertyPerformance(
			@RequestParam String userid, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewPropertyPerformance starts");
		List<RestManagePropertyPerformanceModel> respList = new ArrayList<RestManagePropertyPerformanceModel>();

		String value = "SET @p_userid='" + userid + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
		logger.info(value);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewPropertyPerformance")
					.setParameter("actionType", "viewView").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestManagePropertyPerformanceModel restPayroll = new RestManagePropertyPerformanceModel(m[0], m[1],
						m[2], m[3], m[4], m[5], m[6], m[7].toString(), m[8], m[9], m[10], m[11]);
				respList.add(restPayroll);

			}

			//logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestManagePropertyPerformanceModel>> resp = new JsonResponse<List<RestManagePropertyPerformanceModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestManagePropertyPerformanceModel>>> response = new ResponseEntity<JsonResponse<List<RestManagePropertyPerformanceModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : ViewPropertyPerformance ends");

		//logger.info("VIEWWWWWWWW" + respList);
		return response;

	}

////edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManagePropertyPerformanceModel>>> editPropertyPerformance(String id) {
		logger.info("Method : editPropertyPerformance starts");

		JsonResponse<List<RestManagePropertyPerformanceModel>> resp = new JsonResponse<List<RestManagePropertyPerformanceModel>>();
		List<RestManagePropertyPerformanceModel> rs = new ArrayList<RestManagePropertyPerformanceModel>();

		try {

			String value = "SET @p_PerformanceId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewPropertyPerformance")
					.setParameter("actionType", "viewEdit").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestManagePropertyPerformanceModel reqemp = new RestManagePropertyPerformanceModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11]);
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestManagePropertyPerformanceModel>>> response = new ResponseEntity<JsonResponse<List<RestManagePropertyPerformanceModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : editPropertyPerformance ends");
		return response;
	}

	// delete
	public ResponseEntity<JsonResponse<Object>> deletePropertyPerformance(String id) {
		logger.info("Method : deletePropertyPerformance starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		logger.info("ID...." + id);
		if (validity)
			try {

				String value = "SET @p_PerformanceId='" + id + "';";
				logger.info(value);

				em.createNamedStoredProcedureQuery("viewPropertyPerformance").setParameter("actionType", "viewDelete")
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

		logger.info("Method :  deletePropertyPerformance ends");
		logger.info("DELETEE" + response);
		return response;
	}

	// todate fromdate
	// edit Property Details
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManagePropertyPerformanceModel>>> viewPropertyPerformance(String userid,
			String fromDate, String toDate) {
		logger.info("Method : editperformancedetails starts" + userid + fromDate + toDate);

		List<RestManagePropertyPerformanceModel> req = new ArrayList<RestManagePropertyPerformanceModel>();
		JsonResponse<List<RestManagePropertyPerformanceModel>> resp = new JsonResponse<List<RestManagePropertyPerformanceModel>>();

		try {

			String value = "SET @p_userid='" + userid + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewPropertyPerformance")
					.setParameter("actionType", "getPropertyPerformance").setParameter("actionValue", value)
					.getResultList();
			logger.info("############FFFFF" + value);
			for (Object[] m : x) {

				RestManagePropertyPerformanceModel reqemp = new RestManagePropertyPerformanceModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11]);

				req.add(reqemp);

			}

			logger.info("hhhhhuuu====" + req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		logger.info("hhhhhuuu====" + req);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestManagePropertyPerformanceModel>>> response = new ResponseEntity<JsonResponse<List<RestManagePropertyPerformanceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editperformancedetails ends");
		return response;
	}
		
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyAutocomplete(String id) {
		logger.info("Method : getPropertyAutocomplete starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
logger.info("ssssssssssssss"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewPropertyPerformance")
					.setParameter("actionType", "getpropertype").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPropertyAutocomplete ends"+response);
		return response;
	}

}
