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
import nirmalya.aatithya.restmodule.tenant.dao.RestTenantPayOSduesDao;
import nirmalya.aatithya.restmodule.tenant.model.RestTenantPayOSduesModel;


@RestController
@RequestMapping(value = { "property" })

public class RestTenantPayOSduesController {
	Logger logger = LoggerFactory.getLogger(RestTenantPayOSduesController.class);

	@Autowired
	RestTenantPayOSduesDao payOSdao;
	
	@RequestMapping(value = "pay-osdue-details-view", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestTenantPayOSduesModel>>> viewpayosdues(@RequestParam String userid,@RequestParam String fromDate, @RequestParam String toDate){

		logger.info("Method : viewpayosdues starts");

		logger.info("Method : viewpayosdues ends"+userid+fromDate+toDate);
		return payOSdao.viewpayosdues(userid, fromDate, toDate);
	}

}
