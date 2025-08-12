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
import nirmalya.aatithya.restmodule.his.dao.HISWardDao;
import nirmalya.aatithya.restmodule.his.model.RestHISWardModel;

@RestController
@RequestMapping(value = "his/")
public class RestManageHISWardController {

	Logger logger = LoggerFactory.getLogger(RestManageHISWardController.class);

	@Autowired
	HISWardDao hisDao;

	@RequestMapping(value = "floorList", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryList() {

		logger.info("Method : getFloorList starts");
		logger.info("Method : getFloorList ends");

		return hisDao.getFloorList();
	}

	// restAddWard
	@RequestMapping(value = "/rstAddWard", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddWard(@RequestBody RestHISWardModel restHISWardModel) {
		logger.info("Method : restAddWard starts");

		logger.info("Method : restAddWard ends");
		return hisDao.addWard(restHISWardModel);
	}

	// rest-viewWard

	@RequestMapping(value = "rest-viewWard", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISWardModel>>> viewWard(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : Rest viewWard starts");

		logger.info("Method :  Rest viewWard ends");
		return hisDao.viewWard(org, orgDiv);
	}
	
	//deleteWard
	
	@RequestMapping(value = "deleteWard", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteWard(@RequestParam String id) {
		logger.info("Method : deleteWard starts");

		logger.info("Method : deleteWard ends");
		return hisDao.deleteWard(id);
	}

}
