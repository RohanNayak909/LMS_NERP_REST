package nirmalya.aatithya.restmodule.trial.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.trial.dao.StationwiseRefuellingDao;
import nirmalya.aatithya.restmodule.trial.model.RestStationwiseRefuellingModel;

@RestController
@RequestMapping("trial/")
public class RestStationwiseRefuellingController {
	
	Logger logger = LoggerFactory.getLogger(RestStationwiseRefuellingController.class);
	@Autowired
	StationwiseRefuellingDao stationwiseRefuellingDao;
	
	@GetMapping(value = "fetch-vehiclereg-list")
	public List<DropDownModel> vehicleRegDropdown() {
		logger.info("Method : getDocumentList starts");

		logger.info("Method : getDocumentList ends");
		return stationwiseRefuellingDao.vehicleRegDropdown();
	}

	@GetMapping(value = "fetch-fueltype-list")
	public List<DropDownModel> fuelListdropdown() {
		logger.info("Method : getFuelTypeList starts");

		logger.info("Method : getFuelTypeList ends");
		return stationwiseRefuellingDao.fuelListdropdown();
	}
	
	@GetMapping(value = "fetch-fuelstation-list")
	public List<DropDownModel> fuelStationdropdown() {
		logger.info("Method : getFuelStationList starts");

		logger.info("Method : getFuelStationList ends");
		return stationwiseRefuellingDao.fuelStationdropdown();
	}

	
	//add
		@RequestMapping(value = "rest-addStationFuelData", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> addStationFuelData(
				@RequestBody RestStationwiseRefuellingModel restStationwiseRefuellingModel) {
			logger.info("Method :addStationFuelData starts");
			System.out.println(restStationwiseRefuellingModel);
			logger.info("Method :addStationFuelData ends");
			return stationwiseRefuellingDao.addStationFuelData(restStationwiseRefuellingModel);
		}
		
		
		
		// view

		@RequestMapping(value = "view-StationRefuelDoc", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<RestStationwiseRefuellingModel>>> viewStationRefuelDoc() {
			logger.info("Method : viewStationRefuelDoc starts");

			logger.info("Method : viewStationRefuelDoc ends");
			return stationwiseRefuellingDao.viewStationRefuelDoc();
		}
		
		
		
		//delete
		@RequestMapping(value = "deleteStationwiseRefuelDoc", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteStationwiseRefuelDoc(@RequestParam String id) {
			logger.info("Method : deleteStationwiseRefuelDoc starts");

			logger.info("Method : deleteStationwiseRefuelDoc ends");
			return stationwiseRefuellingDao.deleteStationwiseRefuelDoc(id);
		}
		
		
		
		//edit
		@GetMapping(value = "legalStationRefuelEdit")
		public ResponseEntity<JsonResponse<RestStationwiseRefuellingModel>> legalStationRefuelEdit(@RequestParam String id) {
			logger.info("Method : legalStationRefuelEdit starts");

			logger.info("Method :legalStationRefuelEdit ends");
			return stationwiseRefuellingDao.legalStationRefuelEdit(id);

		}
}
