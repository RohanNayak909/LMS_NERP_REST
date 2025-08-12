package nirmalya.aatithya.restmodule.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.api.dao.ShiftScheduleApiDao;
import nirmalya.aatithya.restmodule.api.model.ShiftScheduleApiModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.DocumentUpload;

@RestController
@RequestMapping(value = "api")
public class ShiftScheduleApiController {

	@Autowired
	ShiftScheduleApiDao shiftScheduleApiDao;

	@Autowired
	EnvironmentVaribles env;
	
	@Autowired
	DocumentUpload documentUpload;

	Logger logger = LoggerFactory.getLogger(ShiftScheduleApiController.class);
	
	@GetMapping(value = "/get-shift-month-list-api")
	public ResponseEntity<JsonResponse<List<ShiftScheduleApiModel>>> getShiftMonthList(@RequestParam String empId,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : getShiftMonthList starts");

		logger.info("Method : getShiftMonthList ends");
		return shiftScheduleApiDao.getShiftMonthList(empId,organization,orgDivision);
	}
	@GetMapping(value = "/get-empshift-details-api")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpShiftDetails(@RequestParam String empId,@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : getEmpShiftDetails starts");

		logger.info("Method : getEmpShiftDetails ends");
		return shiftScheduleApiDao.getEmpShiftDetails(empId,fromDate,toDate,organization,orgDivision);
	}

}
