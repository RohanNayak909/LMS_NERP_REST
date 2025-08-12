package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.EmpMonthlyWagePlusDao;
import nirmalya.aatithya.restmodule.master.model.EmpMonthlyWagePlusRestModel;

@RestController
@RequestMapping(value = "master/")
public class EmpMonthlyWagePlusRestController {
	Logger logger = LoggerFactory.getLogger(EmpMonthlyWagePlusRestController.class);

	@Autowired
	EmpMonthlyWagePlusDao empMonthlyWagePlusDao;

	//addWagePlus
	@PostMapping(value = "rest-wagePlusAdd")
	public ResponseEntity<JsonResponse<Object>> addWagePlus(@RequestBody EmpMonthlyWagePlusRestModel model) {
		logger.info("Method : addWagePlus starts");

		logger.info("Method : addWagePlus ends");
		return empMonthlyWagePlusDao.addWagePlus(model);
	}
//approveWagePlusApply
	@GetMapping(value = "approveWagePlusApply")
	public JsonResponse<Object> approveWagePlusApply(@RequestParam String approveId,String orgName, String orgDivision,String userId) {
		logger.info("Method : approveWagePlusApply starts");

		logger.info("Method : approveWagePlusApply ends");
		return empMonthlyWagePlusDao.approveWagePlusApply(approveId,orgName,orgDivision,userId);
	}
//deleteWagePlus
	@GetMapping(value = "deleteWagePlus")
	public JsonResponse<Object> deleteWagePlus(@RequestParam String dltId,String orgName, String orgDivision,String userId) {
		logger.info("Method : deleteWagePlus starts");

		logger.info("Method : deleteWagePlus ends");
		return empMonthlyWagePlusDao.deleteWagePlus(dltId,orgName,orgDivision,userId);
	}
	//viewWagePlus
	@RequestMapping(value = "rest-employee-monthly-wageplus-view-data", method = { RequestMethod.GET })
	public JsonResponse<Object> viewWagePlus(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewWagePlus start");

		logger.info("Method :viewWagePlus endss");
		return empMonthlyWagePlusDao.viewWagePlus(orgName, orgDivision);
	}
	//wageyearWise
	@RequestMapping(value = "rest-wageplus-view-data-yearWise", method = { RequestMethod.GET })
	public JsonResponse<Object> wageyearWise(@RequestParam String year,String month, String orgName, String orgDivision) {
		logger.info("Method :wageyearWise start");

		logger.info("Method :wageyearWise endss");
		return empMonthlyWagePlusDao.viewWageYearWise(month,year, orgName, orgDivision);
	}
	//getComponentForWage
	@RequestMapping(value = "getComponentForWage", method = { RequestMethod.GET })
	public List<DropDownModel> getComponentForWage(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getComponentForWage starts");
		
		logger.info("Method : getComponentForWage ends");
		return empMonthlyWagePlusDao.getComponentForWage(organization,orgDivision);
	}
}
