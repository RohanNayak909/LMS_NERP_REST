package nirmalya.aatithya.restmodule.trial.dao;
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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.trial.GenerateFuelStationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.trial.model.RestManageFuelStationModel;

@Repository

public class RestManagefuelStationDao {
	Logger logger = LoggerFactory.getLogger(RestManagefuelStationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@SuppressWarnings("unchecked")
	public List<DropDownModel> displayvendorlist() {
		logger.info("Method : displayvendorlist Dao starts");

		List<DropDownModel> tempvendorlist = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_managefuelstation")
					.setParameter("actionType", "getVendor").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				logger.info(dropDownModel.toString());
				tempvendorlist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : displayvendorlist Dao ends");
		System.out.println("getVendorList" + tempvendorlist);
		return tempvendorlist;
	}
	
	public ResponseEntity<JsonResponse<Object>> addFuelStation(RestManageFuelStationModel fuelstationmodel) {
		logger.info("Method : Rest saveDemoCategory  Dao starts");
		// Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("insuranceNewModel.getInsuranceid() ====" + fuelstationmodel.getStationId());

		// if (validity)
		try {

			String values = GenerateFuelStationParameter.getAddfuelParam(fuelstationmodel);
			if (fuelstationmodel.getStationId() == null || fuelstationmodel.getStationId() == "") {

				em.createNamedStoredProcedureQuery("vm_managefuelstation").setParameter("actionType", "addfueldetails")
						.setParameter("actionValue", values).execute();

			} else {

				logger.info("modify block");
				em.createNamedStoredProcedureQuery("vm_managefuelstation").setParameter("actionType", "modifyfuel")
						.setParameter("actionValue", values).execute();

			}

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

		logger.info("Method : Rest saveDemoCategory  Dao ends");

		return response;

	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageFuelStationModel>>> viewFuel() {
		// TODO Auto-generated method stub
		logger.info("Method : viewEducationDetails Dao starts");

		List<RestManageFuelStationModel> workList = new ArrayList<RestManageFuelStationModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_managefuelstation")
					.setParameter("actionType", "viewfueldetails").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				
				RestManageFuelStationModel dropDownModel = new RestManageFuelStationModel(m[0],
						m[1], m[2], m[3], m[4], m[5], null);
				workList.add(dropDownModel);
				System.out.println(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestManageFuelStationModel>> resp = new JsonResponse<List<RestManageFuelStationModel>>();
		resp.setBody(workList);
		ResponseEntity<JsonResponse<List<RestManageFuelStationModel>>> response = new ResponseEntity<JsonResponse<List<RestManageFuelStationModel>>>(
				resp, HttpStatus.CREATED);

		System.out.println("RRRRRRRRRRRR===" + response);

		logger.info("Method : vieweducationDetails Dao ends");

		return response;

	}
	
	// edit
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<RestManageFuelStationModel>> editFuel(String stationId) {
			logger.info("Method : editInsurance starts");

			RestManageFuelStationModel req = new RestManageFuelStationModel();
			JsonResponse<RestManageFuelStationModel> resp = new JsonResponse<RestManageFuelStationModel>();

			try {

				String value = "SET @stationId='" + stationId + "';";
				System.out.println(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("vm_managefuelstation")
						.setParameter("actionType", "editFuel").setParameter("actionValue", value).getResultList();
				System.out.println("############FFFFF" + value);
				for (Object[] m : x) {

					

					RestManageFuelStationModel reqemp = new RestManageFuelStationModel(m[0],
							m[1], m[2], m[3], m[4], m[5], m[6]);

					/*
					 * Object insuranceid, Object companyName, Object vehicleNo, Object policyNo,
					 * Object stDate, Object endDate, Object recurringPeriod, Object checkbox2,
					 * Object checkbox1, Object recurringDate, Object remarks, Object charge
					 */
					req = reqemp;

				}

				resp.setBody(req);
			} catch (Exception e) {
				e.printStackTrace();
			}

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<RestManageFuelStationModel>> response = new ResponseEntity<JsonResponse<RestManageFuelStationModel>>(
					resp, responseHeaders, HttpStatus.CREATED);

			logger.info("Method : editInsurance ends");
			System.out.println(response);
			return response;
		}

		
		// delete
		public ResponseEntity<JsonResponse<Object>> fuelDelete(String stationId) {
			
			logger.info("Method : fuelDelete starts");
			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			logger.info(stationId);
			
			if (validity)
				try {

					String value = "SET @stationId=='" + stationId + "';";

					em.createNamedStoredProcedureQuery("vm_managefuelstation")
							.setParameter("actionType", "deleteFuel").setParameter("actionValue", value)
							.execute();

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

			logger.info("Method : fuelDelete ends");
			System.out.println("DELETE2" + response);
			return response;

		}



}
