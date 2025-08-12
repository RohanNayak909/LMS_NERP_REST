package nirmalya.aatithya.restmodule.serviceprovider.controller;

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
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderRentLedgerModel;
import nirmalya.aatithya.restmodule.serviceprovider.dao.RestServiceProviderLedgerDao;

@RestController
@RequestMapping("property/")
public class RestServiceProviderLedgerController {
	
	Logger logger = LoggerFactory.getLogger(RestServiceProviderLedgerController.class);
	@Autowired
	RestServiceProviderLedgerDao restRentLedgerDao;
	
////view
	@RequestMapping(value = "ledger-viewRentLedger", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> ViewRentLedger(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewRentLedger starts");

		logger.info("Method : ViewRentLedger ends");
		return restRentLedgerDao.ViewRentLedger(userid, fromDate, toDate);
	}

}
