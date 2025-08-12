package nirmalya.aatithya.restmodule.his.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISOperationThearterDAo;
import nirmalya.aatithya.restmodule.his.model.RestHISOperationThearterModel;

@RestController
@RequestMapping(value = "his/")
public class HISOperationTheaterRestController {

	Logger logger = LoggerFactory.getLogger(HISOperationTheaterRestController.class);

	@Autowired
	HISOperationThearterDAo operationThearterDAo;

	// restAddOperationTheater
	@RequestMapping(value = "/restAddOperationTheater", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddOperationTheater(
			@RequestBody RestHISOperationThearterModel operationThearterModel) {
		logger.info("Method : restAddOperationTheater starts");

		logger.info("Method : restAddOperationTheater ends");
		return operationThearterDAo.addOperationTheater(operationThearterModel);
	}

	// rest-viewOTDetails

	@RequestMapping(value = "rest-viewOTDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISOperationThearterModel>>> viewOTDetails(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : Rest viewOTDetails starts");

		logger.info("Method :  Rest viewOTDetails ends");
		return operationThearterDAo.viewOTDetails(org, orgDiv);
	}

	// deleteOTDetails

	@RequestMapping(value = "deleteOTDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteOTDetails(@RequestParam String id) {
		logger.info("Method : deleteOTDetails starts");

		logger.info("Method : deleteOTDetails ends");
		return operationThearterDAo.deleteOTDetails(id);
	}

}
