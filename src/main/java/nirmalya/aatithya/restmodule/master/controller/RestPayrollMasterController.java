package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.RestPayrollMasterDao;
import nirmalya.aatithya.restmodule.master.model.RestPayrollMasterModel;

@RestController
@RequestMapping(value = { "master" })
public class RestPayrollMasterController {
	Logger logger = LoggerFactory.getLogger(RestPayrollMasterController.class);

	@Autowired
	RestPayrollMasterDao restPayrollMasterDao;
	
	@RequestMapping(value = "getBandTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getBandTypeList() {
		logger.info("Method : getBandTypeList starts");
		
		logger.info("Method : getBandTypeList ends");
		return restPayrollMasterDao.getBandTypeList();
	}
	
	@RequestMapping(value = "getComponentTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getComponentTypeList() {
		logger.info("Method : getComponentTypeList starts");
		
		logger.info("Method : getComponentTypeList ends");
		return restPayrollMasterDao.getComponentTypeList();
	}
	
	
	@RequestMapping(value = "rest-addnew-payroll", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addCalculationType(@RequestBody RestPayrollMasterModel restPayrollMasterModel) {
		logger.info("Method : restAddJobType starts");

		
		logger.info("Method : restAddJobType ends");
		return restPayrollMasterDao.addCalculationType(restPayrollMasterModel);
	}
	

@RequestMapping(value = "viewSalType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPayrollMasterModel>>> viewSalType(@RequestParam String id,@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewSalType starts");
		logger.info("Method : viewSalType ends");
		return restPayrollMasterDao.viewSalType(id, org, orgDiv);
	}

}