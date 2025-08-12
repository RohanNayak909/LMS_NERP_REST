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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.RestHISPathoLabDao;
import nirmalya.aatithya.restmodule.his.model.RestHISPathoLabModel;

@RestController
@RequestMapping(value = "/his")
public class RestHISPathoLabController {
	
	Logger logger = (Logger) LoggerFactory.getLogger(RestHISPathoLabController.class);

	@Autowired
	RestHISPathoLabDao restHISPathoLabDao;
	
/* get getFloorType list */
	
	@RequestMapping(value = "getFloorTypelab", method = { RequestMethod.GET })
	public List<DropDownModel> getFloorTypelab() {
		logger.info("Method : getFloorTypelab starts");

		logger.info("Method : getFloorTypelab ends");
		return restHISPathoLabDao.getFloorTypeDao();
	}
	
	// Add
	
	@RequestMapping(value = "rest-addPathoLab", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPathoLab(
			@RequestBody RestHISPathoLabModel pathoLab) {
		logger.info("Method : addPathoLab starts");

		logger.info("Method : addPathoLab ends");

		return restHISPathoLabDao.addPathoLab(pathoLab);
	}
	

	// View 

	@RequestMapping(value = "rest-viewPathoLab", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISPathoLabModel>>> viewPathoLab() {
		logger.info("Method : viewPathoLab starts");

		logger.info("Method : viewPathoLab ends");
		return restHISPathoLabDao.viewPathoLab();
	}
	
	// edit

		@RequestMapping(value = "rest-editPathoLab", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<RestHISPathoLabModel>>> editPathoLab(@RequestParam String id) {
			logger.info("Method : editPathoLab starts");

			logger.info("Method : editPathoLab ends");
			return restHISPathoLabDao.editPathoLab(id);
		}
		
		//delete
		
		@RequestMapping(value = "rest-deletePathoLab", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deletePathoLab(@RequestParam String id) {
			logger.info("Method : deletePathoLab starts");

			logger.info("Method : deletePathoLab ends");
			return restHISPathoLabDao.deletePathoLab(id);
		}

}
