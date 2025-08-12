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
import nirmalya.aatithya.restmodule.his.dao.RestHISIcuDao;
import nirmalya.aatithya.restmodule.his.model.RestHISIcuModel;

@RestController
@RequestMapping(value = "/his")
public class RestHISIcuController {
	
	Logger logger = (Logger) LoggerFactory.getLogger(RestHISConfigurationController.class);

	@Autowired
	RestHISIcuDao restHISIcuDao;
	
	/* get getFloorType list */
	
	@RequestMapping(value = "getFloorType1", method = { RequestMethod.GET })
	public List<DropDownModel> getFloorType() {
		logger.info("Method : getFloorType starts");

		logger.info("Method : getFloorType ends");
		return restHISIcuDao.getFloorTypeDao();
	} 
	
	
	// Add
	
	@RequestMapping(value = "rest-addIcu", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addIcu(
			@RequestBody RestHISIcuModel ICU) {
		logger.info("Method : addIcu starts");

		logger.info("Method : addIcu ends");

		return restHISIcuDao.addIcu(ICU);
	}
	
	
	// View 

	@RequestMapping(value = "rest-view-Icu", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISIcuModel>>> viewIcu() {
		logger.info("Method : viewIcu starts");

		logger.info("Method : viewIcu ends");
		return restHISIcuDao.viewIcu();
	}
	
	// edit

	@RequestMapping(value = "rest-edit-Icu", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISIcuModel>>> editIcu(@RequestParam String id) {
		logger.info("Method : editIcu starts");

		logger.info("Method : editIcu ends");
		return restHISIcuDao.editIcu(id);
	}

	//delete
	
	@RequestMapping(value = "rest-icu-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteIcu(@RequestParam String id) {
		logger.info("Method : deleteIcu starts");

		logger.info("Method : deleteIcu ends");
		return restHISIcuDao.deleteIcu(id);
	}

}
