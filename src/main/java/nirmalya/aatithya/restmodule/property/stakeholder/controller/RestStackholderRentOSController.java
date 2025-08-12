package nirmalya.aatithya.restmodule.property.stakeholder.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.dao.RestStackholderRentOSDao;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStackholderRentOSModel;

@RestController
@RequestMapping("property/")
public class RestStackholderRentOSController {
	Logger logger = LoggerFactory.getLogger(RestStackholderRentOSController.class);
	@Autowired
	RestStackholderRentOSDao rentosdao;

	
////view
	@RequestMapping(value = "rent-os-viewRentLedger", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStackholderRentOSModel>>> ViewRentLedger(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewRentLedger starts");

		logger.info("Method : ViewRentLedger ends");
		return rentosdao.ViewRentLedger(userid, fromDate, toDate);
	}
}
