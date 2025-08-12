package nirmalya.aatithya.restmodule.master.controller;

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

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.EmployeeBonusExgratiaDao;
import nirmalya.aatithya.restmodule.master.model.RestAttendanceModel;

@RestController
@RequestMapping("master/")
public class RestEmployeeBonusController {
	Logger logger = LoggerFactory.getLogger(RestELManageController.class);

	@Autowired
	EmployeeBonusExgratiaDao dao;
	
	@Autowired
	EnvironmentVaribles env;
	
	@RequestMapping(value = "viewEmployeeBonusExgratia", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEmployeeBonusExgratia(@RequestParam String fromDate, String toDate, String org, String orgDiv,String id) {
		logger.info("Method :viewEmployeeBonusExgratia start");

		logger.info("Method :viewEmployeeBonusExgratia endss");
		return dao.viewEmployeeBonusExgratia(fromDate, toDate, org, orgDiv, id);
	}
	
	@PostMapping(value = "addUloadedEmployeeBonusExgratia")
	public ResponseEntity<JsonResponse<Object>> addUloadedEmployeeBonusExgratia(@RequestBody List<RestEmployeeBonusModel> model) {
		logger.info("Method : addUloadedEmployeeBonusExgratia starts");

		logger.info("Method : addUloadedEmployeeBonusExgratia ends");
		return dao.addUloadedEmployeeBonusExgratia(model);
	}
}
