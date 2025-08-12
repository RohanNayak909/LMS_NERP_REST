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
import nirmalya.aatithya.restmodule.serviceprovider.dao.RestServiceProviderBillDao;
import nirmalya.aatithya.restmodule.serviceprovider.model.RestServiceProviderBillModel;

@RestController
@RequestMapping(value = { "property" })

public class RestServiceBillController {
	Logger logger = LoggerFactory.getLogger(RestServiceBillController.class);

	@Autowired
	RestServiceProviderBillDao Billdao;
	
	@RequestMapping(value = "bill-details-view", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestServiceProviderBillModel>>> viewBill(@RequestParam String userid,@RequestParam String fromDate, @RequestParam String toDate){

		logger.info("Method : viewBill starts");

		logger.info("Method : viewBill ends"+userid+fromDate+toDate);
		return Billdao.viewbilldues(userid, fromDate, toDate);
	}

}
