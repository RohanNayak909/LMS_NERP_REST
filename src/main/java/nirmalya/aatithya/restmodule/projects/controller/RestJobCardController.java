package nirmalya.aatithya.restmodule.projects.controller;

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
import nirmalya.aatithya.restmodule.projects.dao.RestJobCardDao;
import nirmalya.aatithya.restmodule.projects.model.BudgetEstimationRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestExtraExpenseModel;

@RestController
@RequestMapping("projects/")
public class RestJobCardController {


	Logger logger = LoggerFactory.getLogger(RestJobCardController.class);

	@Autowired
	RestJobCardDao restJobCardDao;
	
	
	//
	//budget add
	@PostMapping(value = "rest-jobcard-add")
	public ResponseEntity<JsonResponse<Object>> jobcardAdd(@RequestBody BudgetEstimationRestModel budget) {
		logger.info("Method : jobcardAdd starts");

		logger.info("Method : jobcardAdd ends");
		return restJobCardDao.jobcardAddDao(budget);
	}
	
	//budget view
	@RequestMapping(value = "rest-jobcard-view", method = { RequestMethod.GET })

	public JsonResponse<Object> jobcardView(@RequestParam String userid,@RequestParam String org,
			@RequestParam String div,@RequestParam String id) {
		logger.info("Method :jobcardView start");

		logger.info("Method :jobcardView endss");
		return restJobCardDao.jobcardViewDao(userid,org,div,id);
	}
	
	//edit budget
	@RequestMapping(value = "rest-jobcard-edit", method = { RequestMethod.GET })

	public JsonResponse<Object> jobcardEdit(@RequestParam String userid,@RequestParam String org,
			@RequestParam String div,@RequestParam String id) {
		logger.info("Method :jobcardEdit start");

		logger.info("Method :jobcardEdit endss");
		return restJobCardDao.jobcardEditDao(userid,org,div,id);
	}
	
	//delete budget
		@RequestMapping(value = "rest-jobcard-delete", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> jobcardDelete(@RequestParam String id) {
			logger.info("Method :  jobcardDelete starts"+id);

			logger.info("Method :  jobcardDelete ends");
			return restJobCardDao.jobcardDeleteDao(id);
		}
		
		@RequestMapping(value = "rest-estimateSink", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> estimateSink(@RequestParam String id) {
			logger.info("Method : estimateSink starts"+id);

			logger.info("Method : estimateSink ends");
			return restJobCardDao.estimateSink(id);
		}
	
}

