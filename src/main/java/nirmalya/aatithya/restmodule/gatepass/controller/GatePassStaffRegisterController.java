package nirmalya.aatithya.restmodule.gatepass.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gatepass.dao.GatePassStaffRegisterDao;
import nirmalya.aatithya.restmodule.gatepass.model.GatePassStaffRegisterModel;

@RestController
@RequestMapping("gatepass/")
public class GatePassStaffRegisterController {
	Logger logger = LoggerFactory.getLogger(GatePassStaffRegisterController.class);

	@Autowired
	GatePassStaffRegisterDao gatePassStaffRegisterDao;
	//get-staff-details
	@RequestMapping(value = "get-staff-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getStaffDeatils(@RequestParam String organization,@RequestParam String orgDivision,@RequestParam String employeeId,@RequestParam String date,@RequestParam String time) {
		logger.info("Method : getStaffDeatils starts");

		logger.info("Method : getStaffDeatils end");
		return gatePassStaffRegisterDao.getStaffDeatils(organization,orgDivision,employeeId,date,time);
	}
	//postStaffPunchInOutDetails
	@RequestMapping(value = "post-staff-punchInOut-details", method = { RequestMethod.POST })
	public JsonResponse<Object> postStaffPunchInOutDetails(@RequestBody GatePassStaffRegisterModel regModel) {
		logger.info("Method : postStaffPunchInOutDetails starts"); 
		
		logger.info("Method : postStaffPunchInOutDetails ends");
		return gatePassStaffRegisterDao.postStaffPunchInOutDetails(regModel);
	}	
}
