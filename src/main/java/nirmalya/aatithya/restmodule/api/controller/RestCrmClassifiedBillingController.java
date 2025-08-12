package nirmalya.aatithya.restmodule.api.controller;

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
import nirmalya.aatithya.restmodule.api.dao.RestCrmClassifiedBillingDao;
import nirmalya.aatithya.restmodule.api.model.RestCrmClassifiedBillingModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "api")
public class RestCrmClassifiedBillingController {

	@Autowired
	RestCrmClassifiedBillingDao restCrmClassifiedBillingDao;

	@Autowired
	EnvironmentVaribles env;

	Logger logger = LoggerFactory.getLogger(RestCrmClassifiedBillingController.class);
	
	//Add Bill
	@RequestMapping(value = "addClassifiedBillApi", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addClassifiedBillApi(@RequestBody RestCrmClassifiedBillingModel bill) {
		logger.info("Method : addClassifiedBillApi starts");
		logger.info("Method : addClassifiedBillApi ends");
		return restCrmClassifiedBillingDao.addClassifiedBillApi(bill);
	}
		// view bill
		@GetMapping(value = "viewClassifiedBillApi")
		public JsonResponse<List<RestCrmClassifiedBillingModel>> viewClassifiedBillApi(@RequestParam String createdBy,String organization, String orgDivision,
															String fromDate,String toDate) {
			logger.info("Method : viewClassifiedBillApi");

			
			logger.info("Method : viewClassifiedBillApi ends");
			return restCrmClassifiedBillingDao.viewClassifiedBillApi(createdBy,organization,orgDivision,fromDate,toDate);
		}
		// view bill search
		@GetMapping(value = "viewClassifiedBillSearchApi")
		public JsonResponse<List<RestCrmClassifiedBillingModel>> viewClassifiedBillSearchApi(@RequestParam String createdBy,String organization, String orgDivision,
				String fromDate,String toDate,String salesTeam) {
			logger.info("Method : viewClassifiedBillSearchApi");
			
			
			logger.info("Method : viewClassifiedBillSearchApi ends");
			return restCrmClassifiedBillingDao.viewClassifiedBillSearchApi(createdBy,organization,orgDivision,fromDate,toDate,salesTeam);
		}
}
