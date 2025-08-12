package nirmalya.aatithya.restmodule.productionplan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.productionplan.dao.LmrLogDao;
import nirmalya.aatithya.restmodule.productionplan.dao.SackConfigurationDao;
import nirmalya.aatithya.restmodule.productionplan.model.LmrLogRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.SackConfigurationRestModel;

@RestController
@RequestMapping(value = { "production/" })
public class RestSackConfigurationController {
	
Logger logger = LoggerFactory.getLogger(RestSackConfigurationController.class);
	
	@Autowired
	SackConfigurationDao sackConfigurationDao;
	
	
	// view
	
		@RequestMapping(value = "rest-viewSackConfiguration", method = { RequestMethod.GET })
		public JsonResponse<Object> viewSackConfiguration(@RequestParam String org, String orgDiv) {
			logger.info("Method :viewSackConfiguration start");

			logger.info("Method :viewSackConfiguration endss");
			return sackConfigurationDao.viewSackConfiguration( org, orgDiv);
		}
		
		
		// Add
		
		
		@PostMapping(value = "rest-addSackConfiguration")
		public JsonResponse<Object> addSackConfiguration(
				@RequestBody SackConfigurationRestModel offDay) {
			logger.info("Method :addLmrLog starts");

			logger.info("Method :addLmrLog endss");
			return sackConfigurationDao.addSackConfiguration(offDay);
		}
		
		// Delete
		
			@RequestMapping(value = "rest-deleteSackConfig", method = { RequestMethod.GET })
			public JsonResponse<Object> deleteSackConfig(@RequestParam String id, String org, String orgDiv) {
				logger.info("Method :deleteSackConfig start");

				logger.info("Method :deleteSackConfig endss");
				return sackConfigurationDao.deleteSackConfig( id, org, orgDiv);
			}

}
