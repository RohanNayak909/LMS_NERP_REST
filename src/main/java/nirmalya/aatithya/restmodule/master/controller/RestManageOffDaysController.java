package nirmalya.aatithya.restmodule.master.controller;

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

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.ManageOffDaysDao;
import nirmalya.aatithya.restmodule.master.model.RestOFFManageModel;

@RestController
@RequestMapping("master/")
public class RestManageOffDaysController {

	Logger logger = LoggerFactory.getLogger(RestManageOffDaysController.class);

	@Autowired
	ManageOffDaysDao offDayDao;
	
	@Autowired
	EnvironmentVaribles env;
	
	@PostMapping(value = "addOffDays")
	public ResponseEntity<JsonResponse<RestOFFManageModel>> addOffDays(
			@RequestBody RestOFFManageModel offDay) {
		logger.info("Method :addOffDays starts");

		logger.info("Method :addOffDays endss");
		return offDayDao.addOffDays(offDay);
	}
	@RequestMapping(value = "viewOffDays", method = { RequestMethod.GET })
	public JsonResponse<Object> viewOffDays(@RequestParam String org, String orgDiv) {
		logger.info("Method :viewOffDays start");

		logger.info("Method :viewOffDays endss");
		return offDayDao.viewOffDays( org, orgDiv);
	}
	@RequestMapping(value = "editOffDays", method = { RequestMethod.GET })
	public JsonResponse<Object> editOffDays(@RequestParam String id,String org, String orgDiv) {
		logger.info("Method :editOffDays start");

		logger.info("Method :editOffDays endss");
		return offDayDao.editOffDays(id, org, orgDiv);
	}
	@RequestMapping(value = "approveOffDays", method = { RequestMethod.GET })
	public JsonResponse<Object> approveOffDays(@RequestParam String id, String org,String orgDiv, String userId) {
		logger.info("Method :approveOffDays start");

		logger.info("Method :approveOffDays endss");
		return offDayDao.approveOffDays(id, org, orgDiv,userId);
	}
	@RequestMapping(value = "deleteOffDays", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteOffDays(@RequestParam String id, String org,String orgDiv) {
		logger.info("Method :deleteOffDays start");

		logger.info("Method :deleteOffDays endss");
		return offDayDao.deleteOffDays(id, org, orgDiv);
	}
}
