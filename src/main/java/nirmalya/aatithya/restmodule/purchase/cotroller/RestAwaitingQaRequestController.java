package nirmalya.aatithya.restmodule.purchase.cotroller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.RestAwaitingQaRequestDao;
import nirmalya.aatithya.restmodule.purchase.model.RestQaRequestModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping(value = "purchase/")
public class RestAwaitingQaRequestController {
	
	Logger logger = LoggerFactory.getLogger(RestAwaitingQaRequestController.class);

	@Autowired
	RestAwaitingQaRequestDao restAwaitingQaRequestDao;

	@RequestMapping(value = "rest-awaitingQaRequestData", method = { RequestMethod.GET })
	public JsonResponse<Object> awaitingQaRequestData(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :awaitingQaRequestData start");

		logger.info("Method :awaitingQaRequestData endss");
		return restAwaitingQaRequestDao.awaitingQaRequestData(orgName, orgDivision);

	}
	
	// add
	
	@PostMapping(value = "rest-qaRequestSave")
	public ResponseEntity<JsonResponse<List<RestQaRequestModel>>> saveQaRequest(
			@RequestBody List<RestQaRequestModel> data) {
		logger.info("Method :saveQaRequest starts");
		
		logger.info("Method :saveQaRequest endss");
		return restAwaitingQaRequestDao.saveQaRequest(data);
	}
}
