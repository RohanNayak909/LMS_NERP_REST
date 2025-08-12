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
import nirmalya.aatithya.restmodule.common.utils.GenerateManageTenantParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderTenantModel;

@Repository
public class RestStakeholderTenantDao {

	Logger logger = LoggerFactory.getLogger(RestStakeholderTenantDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

////add
	public ResponseEntity<JsonResponse<Object>> saveTenant(RestStakeholderTenantModel restPayroll) {

		logger.info("Method : Rest saveTenant Dao starts");
		logger.info("restPayroll" + restPayroll);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		logger.info("restPayroll.getId() ====" + restPayroll.getPropId());

		try {

			String values = GenerateManageTenantParam.addTenantParam(restPayroll);

			if (restPayroll.getTenantId() == null || restPayroll.getTenantId() == "") {

				logger.info("values IN ADD" + values);
				em.createNamedStoredProcedureQuery("viewTenant").setParameter("actionType", "adddetails")
						.setParameter("actionValue", values).execute();

			} else {

				logger.info("values in modify");
				em.createNamedStoredProcedureQuery("viewTenant").setParameter("actionType", "modifystddetails")
						.setParameter("actionValue", values).execute();

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

		logger.info("Method : Rest saveTenant Dao ends");

		return response;
	}

////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderTenantModel>>> ViewTenant(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewTenant starts");
		List<RestStakeholderTenantModel> respList = new ArrayList<RestStakeholderTenantModel>();

		String value = "SET @p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
		logger.info(value);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewTenant").setParameter("actionType", "viewView")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestStakeholderTenantModel restPayroll = new RestStakeholderTenantModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestStakeholderTenantModel>> resp = new JsonResponse<List<RestStakeholderTenantModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestStakeholderTenantModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderTenantModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : ViewProperty ends");

		//logger.info("VIEWWWWWWWW" + respList);
		return response;

	}

////edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderTenantModel>>> editTenant(String id) {
		logger.info("Method : editTenant starts");

		JsonResponse<List<RestStakeholderTenantModel>> resp = new JsonResponse<List<RestStakeholderTenantModel>>();
		List<RestStakeholderTenantModel> rs = new ArrayList<RestStakeholderTenantModel>();

		try {

			String value = "SET @p_tenantId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewTenant").setParameter("actionType", "viewEdit")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestStakeholderTenantModel reqemp = new RestStakeholderTenantModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestStakeholderTenantModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderTenantModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : editTenant ends");
		return response;
	}

	// delete
	public ResponseEntity<JsonResponse<Object>> deleteTenant(String id) {
		logger.info("Method : deleteTenant starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		logger.info("ID...." + id);
		if (validity)
			try {

				String value = "SET @p_tenantId='" + id + "';";
				logger.info(value);

				em.createNamedStoredProcedureQuery("viewTenant").setParameter("actionType", "viewDelete")
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

		logger.info("Method :  deleteTenant ends");
		logger.info("DELETEE" + response);
		return response;
	}

	// todate fromdate
	// edit Property Details
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderTenantModel>>> viewtenantdetails(String userid,
			String fromDate, String toDate) {
		logger.info("Method : edittenantDetails starts" + userid + fromDate + toDate);

		List<RestStakeholderTenantModel> req = new ArrayList<RestStakeholderTenantModel>();
		JsonResponse<List<RestStakeholderTenantModel>> resp = new JsonResponse<List<RestStakeholderTenantModel>>();

		try {

			String value = "SET @p_userid='" + userid + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewTenant").setParameter("actionType", "gettenant")
					.setParameter("actionValue", value).getResultList();
			logger.info("############FFFFF" + value);
			for (Object[] m : x) {

				RestStakeholderTenantModel reqemp = new RestStakeholderTenantModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);

				/*
				 * Object insuranceid, Object companyName, Object vehicleNo, Object policyNo,
				 * Object stDate, Object endDate, Object recurringPeriod, Object checkbox2,
				 * Object checkbox1, Object recurringDate, Object remarks, Object charge
				 */
				req.add(reqemp);

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestStakeholderTenantModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderTenantModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : edittenantDetails ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyByAutoSearch(String id) {
		logger.info("Method : getNoticeListByAutoSearch starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
logger.info("ssssssssssssss"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewTenant")
					.setParameter("actionType", "getPropertyList").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getNoticeListByAutoSearch ends"+response);
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewTenant")
					.setParameter("actionType", "getTenantnamemail").setParameter("actionValue", value).getResultList();
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
