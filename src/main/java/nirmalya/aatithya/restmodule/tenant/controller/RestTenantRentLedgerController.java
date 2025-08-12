package nirmalya.aatithya.restmodule.tenant.controller;

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
import nirmalya.aatithya.restmodule.tenant.dao.RestTenantRentLedgerDao;
import nirmalya.aatithya.restmodule.tenant.model.RestTenantRentLedgerModel;


@RestController
@RequestMapping(value = { "property" })

public class RestTenantRentLedgerController {
	Logger logger = LoggerFactory.getLogger(RestTenantRentLedgerController.class);

	@Autowired
	RestTenantRentLedgerDao rentledgerdao;
	
	@RequestMapping(value = "rentledger-details-view", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestTenantRentLedgerModel>>> viewrentledger(@RequestParam String userid,@RequestParam String fromDate, @RequestParam String toDate){

		logger.info("Method : viewrentledger starts");

		logger.info("Method : viewrentledger ends"+userid+fromDate+toDate);
		return rentledgerdao.viewrentledgerdetails(userid, fromDate, toDate);
	}

}
