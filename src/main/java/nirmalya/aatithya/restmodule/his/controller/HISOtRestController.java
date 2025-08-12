package nirmalya.aatithya.restmodule.his.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISOtRestDao;
import nirmalya.aatithya.restmodule.his.dao.HISPharmacyRestDao;
import nirmalya.aatithya.restmodule.user.model.RestUserRoleAssignModel;

@RestController
@RequestMapping(value = "his/")
public class HISOtRestController {
	Logger logger = LoggerFactory.getLogger(HISOtRestController.class);

	@Autowired
	HISOtRestDao hISOtRestDao;
	
	@RequestMapping(value = "rest-viewOtList", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPatient(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewPatient start");

		logger.info("Method :viewPatient endss");
		return hISOtRestDao.viewPatient(orgName, orgDivision, userId);
	}
	
	@RequestMapping(value = "rest-ot-editOt", method = { RequestMethod.GET })
	public JsonResponse<Object> editOt(@RequestParam String Id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :editOt start");
		logger.info("Method :editOt endss");
		return hISOtRestDao.editOt(Id, organization, orgDivision);
	}
	
	@RequestMapping(value = "rest-viewSurgen", method = { RequestMethod.GET })
	public JsonResponse<Object> viewSurgen(@RequestParam String Id,String orgName, String orgDivision, String userId) {
		logger.info("Method :viewSurgen start");

		logger.info("Method :viewSurgen endss");
		return hISOtRestDao.viewSurgen(Id,orgName, orgDivision, userId);
	}
	
	@RequestMapping(value = "rest-ot-details-users-employee", method = { RequestMethod.GET })
	public JsonResponse<Object> viewDoctorMaster(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewDoctorMaster start");
		logger.info("Method :viewDoctorMaster endss");
		return hISOtRestDao.viewDoctorMaster(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-viewEquipments", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEquipment(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewEquipment start");

		logger.info("Method :viewEquipment endss");
		return hISOtRestDao.viewEquipment(orgName, orgDivision, userId);
	}
	
}
