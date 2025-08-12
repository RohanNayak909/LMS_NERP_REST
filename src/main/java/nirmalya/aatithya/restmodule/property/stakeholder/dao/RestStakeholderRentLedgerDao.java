package nirmalya.aatithya.restmodule.property.stakeholder.dao;
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
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateManageRentLedgerParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderRentLedgerModel;

@Repository
public class RestStakeholderRentLedgerDao {
	Logger logger = LoggerFactory.getLogger(RestStakeholderRentLedgerDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

////add
	public ResponseEntity<JsonResponse<Object>> saveRentLedger(
			RestStakeholderRentLedgerModel restPayroll) {

		logger.info("Method : Rest saveRentLedger  Dao starts");
		logger.info("restPayroll" + restPayroll);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		logger.info("restPayroll.getId() ====" + restPayroll.getRentId());

		try {

			String values = GenerateManageRentLedgerParameter.addRentLedgerParam(restPayroll);

			if (restPayroll.getRentId() == null || restPayroll.getRentId() == "") {

				logger.info("values IN ADD" + values);
				em.createNamedStoredProcedureQuery("viewRentLedger").setParameter("actionType", "adddetails")
						.setParameter("actionValue", values).execute();

			} else {

				logger.info("values in modifyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"+values);
				em.createNamedStoredProcedureQuery("viewRentLedger").setParameter("actionType", "modifystddetails")
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

		logger.info("Method : Rest saveRentLedger Dao ends");

		return response;
	}
////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> ViewRentLedger(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewRentLedger starts");
		List<RestStakeholderRentLedgerModel> respList = new ArrayList<RestStakeholderRentLedgerModel>();
		
		String value=	 "SET @p_userid='" + userid + "',@p_fromDate='" + fromDate +"',@p_toDate='" + toDate + "';";
		logger.info(value);
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewRentLedger").setParameter("actionType", "viewView")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestStakeholderRentLedgerModel restPayroll = new RestStakeholderRentLedgerModel(m[0], m[1], m[2], m[3], m[4], m[5],m[6],null,null,null,null,null,null,null,m[7],m[8]);
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestStakeholderRentLedgerModel>> resp = new JsonResponse<List<RestStakeholderRentLedgerModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : ViewProperty ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
////edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>>editRentLedger(String id) {
		logger.info("Method : editRentLedger starts");

		JsonResponse<List<RestStakeholderRentLedgerModel>> resp = new JsonResponse<List<RestStakeholderRentLedgerModel>>();
		List<RestStakeholderRentLedgerModel> rs = new ArrayList<RestStakeholderRentLedgerModel>();

		try {

			String value = "SET @p_RentId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewRentLedger").setParameter("actionType", "viewEdit")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestStakeholderRentLedgerModel reqemp = new RestStakeholderRentLedgerModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],null,null,null,null,null,null,null,m[7],m[8]);
				rs.add(reqemp);
			}

			resp.setBody(rs);
			logger.info("ssssssssssssssssssssssssssssssssssss"+resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : editRentLedger ends");
		return response;
	}
	
////edit2
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>>editRentLedgers(String id) {
		logger.info("Method : editRentLedger starts");

		JsonResponse<List<RestStakeholderRentLedgerModel>> resp = new JsonResponse<List<RestStakeholderRentLedgerModel>>();
		List<RestStakeholderRentLedgerModel> rs = new ArrayList<RestStakeholderRentLedgerModel>();

		try {

			String value = "SET @p_RentId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewRentLedger").setParameter("actionType", "viewEditRent")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestStakeholderRentLedgerModel reqemp = new RestStakeholderRentLedgerModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14],m[15]);
				rs.add(reqemp);
			}

			resp.setBody(rs);
			logger.info("ssssssssssssssssssssssssssssssssssss"+resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : editRentLedger ends");
		return response;
	}

	//delete
	public ResponseEntity<JsonResponse<Object>> deleteRentLedger(String id) {
		logger.info("Method : deleteRentLedger starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		logger.info("ID...."+id);
		if (validity)
			try {

				String value = "SET @p_RentId='" + id + "';";
				logger.info(value);

				em.createNamedStoredProcedureQuery("viewRentLedger")
						.setParameter("actionType", "viewDelete").setParameter("actionValue", value).execute();

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

		logger.info("Method :  deleteRentLedger ends");
		logger.info("DELETEE" + response);
		return response;
	}
	//todate fromdate
		// edit Property Details
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> viewRentledger(String userid, String fromDate, String toDate) {
			logger.info("Method : editperformancedetails starts"+userid+fromDate+toDate);

			List<RestStakeholderRentLedgerModel> req = new ArrayList<RestStakeholderRentLedgerModel>();
			JsonResponse<List<RestStakeholderRentLedgerModel>> resp = new JsonResponse<List<RestStakeholderRentLedgerModel>>();

			try {

			
				String value=	 "SET @p_userid='" + userid + "',@p_fromDate='" + fromDate +"',@p_toDate='" + toDate + "';";
				logger.info(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("viewRentLedger")
						.setParameter("actionType", "getRentLedger").setParameter("actionValue", value)
						.getResultList();
				logger.info("############FFFFF" + value);
				for (Object[] m : x) {

					RestStakeholderRentLedgerModel reqemp = new RestStakeholderRentLedgerModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],null,null,null,null,null,null,null,m[7],m[8]);

					/*
					 * Object insuranceid, Object companyName, Object vehicleNo, Object policyNo,
					 * Object stDate, Object endDate, Object recurringPeriod, Object checkbox2,
					 * Object checkbox1, Object recurringDate, Object remarks, Object charge
					 */
					req.add(reqemp);

				}

				logger.info("hhhhhuuu===="+req);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.setBody(req);
			logger.info("hhhhhuuu===="+req);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<	RestStakeholderRentLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);

			logger.info("Method : editRentLedger ends");
			return response;
		}
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>>rentLedgerPrimeData(String id) {
			logger.info("Method : editRentLedger starts");

			JsonResponse<List<RestStakeholderRentLedgerModel>> resp = new JsonResponse<List<RestStakeholderRentLedgerModel>>();
			List<RestStakeholderRentLedgerModel> rs = new ArrayList<RestStakeholderRentLedgerModel>();

			try {

				String value = "SET @p_searchValue='" + id + "';";
				logger.info(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("viewRentLedger").setParameter("actionType", "getprimedata")
						.setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					
					RestStakeholderRentLedgerModel reqemp = new RestStakeholderRentLedgerModel(null, m[1], m[2], m[3],m[4],m[5],m[6],null,null,null,null,null,null,null,m[7],m[8]);
					rs.add(reqemp);
				}

				resp.setBody(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}

		
			ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>>(resp,HttpStatus.CREATED);

			logger.info("Method : editRentLedger ends");
			return response;
		}
		
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getmonthList() {
			logger.info("Method : getCountryListemployee starts");

			List<DropDownModel> CountryList = new ArrayList<DropDownModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("viewRentLedger")
						.setParameter("actionType", "getmonthlist").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					CountryList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getCountryListForemployee ends");
			return CountryList;
		}
		
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getyearList() {
			logger.info("Method : getCountryListemployee starts");

			List<DropDownModel> CountryList = new ArrayList<DropDownModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("viewRentLedger")
						.setParameter("actionType", "getyearlist").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					CountryList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getCountryListForemployee ends");
			return CountryList;
		}


}
