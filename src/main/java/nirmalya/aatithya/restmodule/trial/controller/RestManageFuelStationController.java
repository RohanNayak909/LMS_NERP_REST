package nirmalya.aatithya.restmodule.trial.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.trial.dao.RestManagefuelStationDao;
import nirmalya.aatithya.restmodule.trial.model.RestManageFuelStationModel;

@RestController
@RequestMapping(value = "trial/")

public class RestManageFuelStationController {
	Logger logger = LoggerFactory.getLogger(RestManageFuelStationController.class);

	@Autowired

	RestManagefuelStationDao rsd;

	@RequestMapping(value = "fetch-vendor-list-dropdown", method = { RequestMethod.GET })
	public List<DropDownModel> displayvendorlist() {

		logger.info("Method : displayvendorlist starts");

		logger.info("Method : displayvendorlist ends");
		return rsd.displayvendorlist();
	}

	@PostMapping(value = "managefuelstation-add-master")
	public ResponseEntity<JsonResponse<Object>> addFuel(@RequestBody RestManageFuelStationModel fuelstation) {
		logger.info("Method :restAdd starts");
		System.out.println("rrrrrrrrrrrcccccccccc" + fuelstation);
		logger.info("Method :restAdd endss");
		return rsd.addFuelStation(fuelstation);

	}

	@RequestMapping(value = "managefuelstation-view-master", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManageFuelStationModel>>> viewFuel() {
		logger.info("Method : viewEducation starts");

		logger.info("Method : viewEducation ends");
		return rsd.viewFuel();
	}

	@RequestMapping(value = "managefuelstation-edit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestManageFuelStationModel>> editFuel(@RequestParam String stationId) {
		logger.info("Method : editFuel starts");

		logger.info("Method :editFuel ends");
		return rsd.editFuel(stationId);
	}

	@RequestMapping(value = "managefuelstation-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> fuelDelete(@RequestParam String stationId) {
		logger.info("Method : deleteIssue starts");
		logger.info("Method : deleteIssue ends");
			
		return rsd.fuelDelete(stationId);
							
		}

}
