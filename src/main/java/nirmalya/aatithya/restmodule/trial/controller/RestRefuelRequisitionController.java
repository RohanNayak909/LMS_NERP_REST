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
import nirmalya.aatithya.restmodule.trial.dao.RestRefuelRequisitionDao;
import nirmalya.aatithya.restmodule.trial.model.RestRefuelRequisitionModel;

@RestController
@RequestMapping(value = "trial/")
public class RestRefuelRequisitionController {
	Logger logger = LoggerFactory.getLogger(RestRefuelRequisitionController.class);

	@Autowired

	RestRefuelRequisitionDao rsd;
	
	@RequestMapping(value = "getVehiclenoLists-rest", method = { RequestMethod.GET })
	public List<DropDownModel> getVehicleRegList() {
		logger.info("Method : getStateList starts");

		logger.info("Method : getStateList ends");
		return rsd.getVehicleRegList();
	}

	@RequestMapping(value = "getFuelStationLists-list", method = { RequestMethod.GET })
	public List<DropDownModel> getFuelStationList() {
		logger.info("Method : getStateList starts");

		logger.info("Method : getStateList ends");
		return rsd.getFuelStationList();
	}
	
	@RequestMapping(value = "getFuelTypeLists-list", method = { RequestMethod.GET })
	public List<DropDownModel> getFuelTypeList() {
		logger.info("Method : getStateList starts");

		logger.info("Method : getStateList ends");
		return rsd.getFuelTypeList();
	}
	
	@PostMapping(value = "refuelrequition-add-master")
	public ResponseEntity<JsonResponse<Object>> addRefuel(@RequestBody RestRefuelRequisitionModel refuelreq) {
		logger.info("Method :restAdd starts");
		System.out.println("rrrrrrrrrrrcccccccccc" + refuelreq);
		logger.info("Method :restAdd endss");
		return rsd.addRefuelRequisitio(refuelreq);

	}
	

	@RequestMapping(value = "refuelrequition-view-master", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestRefuelRequisitionModel>>> viewFuel() {
		logger.info("Method : viewEducation starts");

		logger.info("Method : viewEducation ends");
		return rsd.viewRefuelreq();
	}
	
	@RequestMapping(value = "refuelrequition-edit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestRefuelRequisitionModel>> editRefuel(@RequestParam String refuelReqId) {
		logger.info("Method : editFuel starts");

		logger.info("Method :editFuel ends");
		return rsd.editRefuel(refuelReqId);
	}
	
	
	  @RequestMapping(value = "refuelrequition-delete", method = {
	  RequestMethod.GET }) public JsonResponse<RestRefuelRequisitionModel> deleteRefuel(@RequestParam String refuelReqId) {
	  logger.info("Method : deleteFuel starts");
	  
	  logger.info("Method : deleteFuel ends");
	  return rsd.deleteRefuel(refuelReqId); 
	  }
	 
}
