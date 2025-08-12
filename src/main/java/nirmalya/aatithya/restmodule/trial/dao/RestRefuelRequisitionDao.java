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
import nirmalya.aatithya.restmodule.common.utils.trial.GenerateRefuelrequisitionParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.trial.model.RestRefuelRequisitionModel;
@Repository

public class RestRefuelRequisitionDao {
	Logger logger = LoggerFactory.getLogger(RestRefuelRequisitionDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	// dropdown start
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVehicleRegList() {
		logger.info("Method : getStateList Dao starts");

		List<DropDownModel> getFuelStationList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_refuelrequisition")
					.setParameter("actionType", "getRegVehicle").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				logger.info(dropDownModel.toString());
				getFuelStationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStateList Dao ends");
		System.out.println("getStateList" + getFuelStationList);
		return getFuelStationList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFuelStationList() {
		logger.info("Method : getStateList Dao starts");

		List<DropDownModel> getFuelStationList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_refuelrequisition")
					.setParameter("actionType", "getFuelStation").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				logger.info(dropDownModel.toString());
				getFuelStationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStateList Dao ends");
		System.out.println("getStateList" + getFuelStationList);
		return getFuelStationList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFuelTypeList() {
		logger.info("Method : getStateList Dao starts");

		List<DropDownModel> getFuelTypeList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_refuelrequisition")
					.setParameter("actionType", "getFuelType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				logger.info(dropDownModel.toString());
				getFuelTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStateList Dao ends");
		System.out.println("getStateList" + getFuelTypeList);
		return getFuelTypeList;
	} // dropdown end
	
	// add
	public ResponseEntity<JsonResponse<Object>> addRefuelRequisitio(RestRefuelRequisitionModel refuelreq) {
		logger.info("Method : Rest saveDemoCategory  Dao starts");
		// Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("refuelreq.getStationId() ====" + refuelreq.getRefuelReqId());

		// if (validity)
		try {

			String values = GenerateRefuelrequisitionParam.getAddrefuelParam(refuelreq);
			if (refuelreq.getRefuelReqId() == null || refuelreq.getRefuelReqId() == "") {

				em.createNamedStoredProcedureQuery("vm_refuelrequisition").setParameter("actionType", "addrefuelreq")
						.setParameter("actionValue", values).execute();

			} else {

				logger.info("modify block");
				em.createNamedStoredProcedureQuery("vm_refuelrequisition").setParameter("actionType", "modifyrefuelreq")
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
	public ResponseEntity<JsonResponse<List<RestRefuelRequisitionModel>>> viewRefuelreq() {
		// TODO Auto-generated method stub
		logger.info("Method : viewEducationDetails Dao starts");

		List<RestRefuelRequisitionModel> workList = new ArrayList<RestRefuelRequisitionModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_refuelrequisition")
					.setParameter("actionType", "viewrefueldetails").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				
				RestRefuelRequisitionModel dropDownModel = new RestRefuelRequisitionModel(m[0],
						m[1], m[2], m[3], m[4], m[5],m[6], null);
				workList.add(dropDownModel);
				System.out.println(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestRefuelRequisitionModel>> resp = new JsonResponse<List<RestRefuelRequisitionModel>>();
		resp.setBody(workList);
		ResponseEntity<JsonResponse<List<RestRefuelRequisitionModel>>> response = new ResponseEntity<JsonResponse<List<RestRefuelRequisitionModel>>>(
				resp, HttpStatus.CREATED);

		System.out.println("RRRRRRRRRRRR===" + response);

		logger.info("Method : vieweducationDetails Dao ends");

		return response;

	}
	

	// edit
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<RestRefuelRequisitionModel>> editRefuel(String refuelReqId) {
			logger.info("Method : editInsurance starts");

			RestRefuelRequisitionModel req = new RestRefuelRequisitionModel();
			JsonResponse<RestRefuelRequisitionModel> resp = new JsonResponse<RestRefuelRequisitionModel>();

			try {

				String value = "SET @refuelreqid='" + refuelReqId + "';";
				System.out.println(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("vm_refuelrequisition")
						.setParameter("actionType", "editRefuel").setParameter("actionValue", value).getResultList();
				System.out.println("############FFFFF" + value);
				for (Object[] m : x) {

					

					RestRefuelRequisitionModel reqemp = new RestRefuelRequisitionModel(m[0],
							m[1], m[2], m[3], m[4], m[5], m[6], m[7]);

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

			ResponseEntity<JsonResponse<RestRefuelRequisitionModel>> response = new ResponseEntity<JsonResponse<RestRefuelRequisitionModel>>(
					resp, responseHeaders, HttpStatus.CREATED);

			logger.info("Method : editInsurance ends");
			System.out.println(response);
			return response;
		}
		
		// delete

				public JsonResponse<RestRefuelRequisitionModel> deleteRefuel(String refuelReqId) {
					logger.info("Method : deleteDistrict starts");
					logger.info(refuelReqId);

					RestRefuelRequisitionModel req = new RestRefuelRequisitionModel();
					JsonResponse<RestRefuelRequisitionModel> resp = new JsonResponse<RestRefuelRequisitionModel>();

					try {
						String value = "SET  @refuelreqid='" + refuelReqId + "';";
						System.out.println("DELETE " + value);

						em.createNamedStoredProcedureQuery("vm_refuelrequisition").setParameter("actionType", "deleteRefuel")
								.setParameter("actionValue", value).execute();

						resp.setBody(req);

					} catch (Exception e) {
						e.printStackTrace();

					}

					logger.info("Method : deleteDistrict ends");
					logger.info("+++delete+++++" + resp);
					return resp;

				}

	



}
