package nirmalya.aatithya.restmodule.trial.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.trial.GenerateStationwiseRefuellingParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.trial.model.RestStationwiseRefuellingModel;

@Repository
public class StationwiseRefuellingDao {

	Logger logger = LoggerFactory.getLogger(StationwiseRefuellingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	// vehicle reg dropdown

	@SuppressWarnings("unchecked")
	public List<DropDownModel> vehicleRegDropdown() {
		logger.info("Method : getVehicleRegList starts");

		List<DropDownModel> vrglist = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_Stationwise_refuel")
					.setParameter("actionType", "getVehicleRegList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vrglist.add(dropDownModel);
				System.out.println("###############" + dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVehicleRegList ends");

		return vrglist;
	}
	
	// fuel type dropdown

	@SuppressWarnings("unchecked")
	public List<DropDownModel> fuelListdropdown() {
		logger.info("Method : getFuelTypeList starts");

		List<DropDownModel> ftypelist = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_Stationwise_refuel")
					.setParameter("actionType", "getFuelTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ftypelist.add(dropDownModel);
				System.out.println("###############" + dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getFuelTypeList ends");

		return ftypelist;
	}
	
	// fuel station list dropdown

	@SuppressWarnings("unchecked")
	public List<DropDownModel> fuelStationdropdown() {
		logger.info("Method : getFuelStationList starts");

		List<DropDownModel> fstationlist = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_Stationwise_refuel")
					.setParameter("actionType", "getFuelStationList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				fstationlist.add(dropDownModel);
				System.out.println("###############" + dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getFuelStationList ends");

		return fstationlist;
	}

	// add student data
	public ResponseEntity<JsonResponse<Object>> addStationFuelData(
			RestStationwiseRefuellingModel restStationwiseRefuellingModel) {

		logger.info("aaaaaaaaaaaaaaaaaaaaaa");
		logger.info("Method : addlegaldoc starts");
		System.out.println("RestManageLegalDocumentModel" + restStationwiseRefuellingModel);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateStationwiseRefuellingParameter
					.getStationwiseRefuelParam(restStationwiseRefuellingModel);
			System.out.println(values);

			if (restStationwiseRefuellingModel.getSlId() == null || restStationwiseRefuellingModel.getSlId() == "") {
				System.out.println("Hii New");
				em.createNamedStoredProcedureQuery("vm_Stationwise_refuel")
						.setParameter("actionType", "addStationFuelData").setParameter("actionValue", values).execute();
				System.out.println("print in addlegaldoc block");

			}

			
			
			  else { System.out.println("print in modify block");
			  em.createNamedStoredProcedureQuery("vm_Stationwise_refuel").setParameter(
			  "actionType", "modifyStationRefuelDoc") .setParameter("actionValue",
			  values).execute();
			  
			  System.out.println("print end in modify block");
			  
			  }
			 

		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : adddist ends");
		return response;

	}
	
	
	
	
	
	// view
	
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestStationwiseRefuellingModel>>> viewStationRefuelDoc() {
			logger.info("Method : viewStationRefuelDoc starts dao");
			List<RestStationwiseRefuellingModel> respList = new ArrayList<RestStationwiseRefuellingModel>();
			
			try {
				
				List<Object[]> x = em.createNamedStoredProcedureQuery("vm_Stationwise_refuel")
						.setParameter("actionType", "viewStationRefuelDoc").setParameter("actionValue", "").getResultList();
				
				for (Object[] m : x) {

					RestStationwiseRefuellingModel restView = new RestStationwiseRefuellingModel(m[0], m[1], m[2], m[3],
							null, m[4],m[5],null,null);
					respList.add(restView);
					logger.info("restView" + restView);
				}

				logger.info("VIEWWWW" + respList);

			} catch (Exception e) {

				e.printStackTrace();

			}

			JsonResponse<List<RestStationwiseRefuellingModel>> resp = new JsonResponse<List<RestStationwiseRefuellingModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestStationwiseRefuellingModel>>> response = new ResponseEntity<JsonResponse<List<RestStationwiseRefuellingModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			logger.info("Method : viewStationRefuelDoc ends");
			System.out.println("View in Dao= " + response);
			return response;

		}
		
		
		
		
		// delete

		public ResponseEntity<JsonResponse<Object>> deleteStationwiseRefuelDoc(String id) {
			logger.info("Method : deleteStationwiseRefuelDoc Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			System.out.println("id" + id);

			try {
				String values = "SET @p_slId='" + id + "';";

				em.createNamedStoredProcedureQuery("vm_Stationwise_refuel").setParameter("actionType", "deleteStationwiseRefuelDoc")
						.setParameter("actionValue", values).execute();

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

			logger.info("Method : deleteStationwiseRefuelDoc Dao ends");
			return response;
		}
		
		
		
		
		// edit
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<RestStationwiseRefuellingModel>> legalStationRefuelEdit(String id) {
			logger.info("Method : legalStationRefuelEdit starts");

			RestStationwiseRefuellingModel req = new RestStationwiseRefuellingModel();
			JsonResponse<RestStationwiseRefuellingModel> resp = new JsonResponse<RestStationwiseRefuellingModel>();
			logger.info(id);

			try {

				String value = "SET @p_slId	='" + id + "';";

				List<Object[]> x = em.createNamedStoredProcedureQuery("vm_Stationwise_refuel")
						.setParameter("actionType", "editStationRefuelDoc").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					
					Object DATE = null;
					if (m[7] != null) {
						DATE = m[7].toString();
					}
					
					RestStationwiseRefuellingModel reqemp = new RestStationwiseRefuellingModel(m[0], m[1], m[2], m[3],
							 m[4],m[5],m[6],DATE,m[8]);
					req = reqemp;

				}

				resp.setBody(req);
			} catch (Exception e) {
				e.printStackTrace();
			}

			ResponseEntity<JsonResponse<RestStationwiseRefuellingModel>> response = new ResponseEntity<JsonResponse<RestStationwiseRefuellingModel>>(
					resp, HttpStatus.CREATED);

			logger.info("Method : legalStationRefuelEdit ends");
			System.out.println(response);
			return response;

		}


}
