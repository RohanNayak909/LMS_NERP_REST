package nirmalya.aatithya.restmodule.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.RestHrmsDashboardRecruitmentDao;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsDashboardModel;

@RestController
@RequestMapping("employee/")
public class RestHrmsDashboardRecruitmentController {
	Logger logger = LoggerFactory.getLogger(RestHrmsDashboardRecruitmentController.class);

	@Autowired
	RestHrmsDashboardRecruitmentDao restHrmsDashboardRecruitmentDao;
	
	
	//////////////////////////////////Recruitment Start///////////////////////////////
	//hrmsRecruitmentHeadCount
	@RequestMapping(value = "hrmsRecruitmentHeadCount", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentHeadCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentHeadCount start");
		logger.info("Method :hrmsRecruitmentHeadCount endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentHeadCount(fromDate, toDate, location, org, orgDiv);
	}
	
	//hrmsRecruitmentConversionRateByHr
	@RequestMapping(value = "hrmsRecruitmentConversionRateByHr", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentConversionRateByHr(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentConversionRateByHr start");
		logger.info("Method :hrmsRecruitmentConversionRateByHr endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentConversionRateByHr(fromDate, toDate, location, org, orgDiv);
	}
	
	//hrmsRecruitmentAvgCostHiringBySeniorityLevel
	@RequestMapping(value = "hrmsRecruitmentAvgCostHiringBySeniorityLevel", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentAvgCostHiringBySeniorityLevel(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentAvgCostHiringBySeniorityLevel start");
		logger.info("Method :hrmsRecruitmentAvgCostHiringBySeniorityLevel endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentAvgCostHiringBySeniorityLevel(fromDate, toDate, location, org, orgDiv);
	}
	
	
	
	
	//hrmsRecruitmentFunnel
	@RequestMapping(value = "hrmsRecruitmentFunnel", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentFunnel(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentFunnel start");
		logger.info("Method :hrmsRecruitmentFunnel endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentFunnel(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//hrmsRecruitmentAvgDeptByFullfillInDays
	@RequestMapping(value = "hrmsRecruitmentAvgDeptByFullfillInDays", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentAvgDeptByFullfillInDays(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentAvgDeptByFullfillInDays start");
		logger.info("Method :hrmsRecruitmentAvgDeptByFullfillInDays endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentAvgDeptByFullfillInDays(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//hrmsRecruitmentHiredBySource
	@RequestMapping(value = "hrmsRecruitmentHiredBySource", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentHiredBySource(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentHiredBySource start");
		logger.info("Method :hrmsRecruitmentHiredBySource endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentHiredBySource(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//hrmsRecruitmentProgressDistribution
	@RequestMapping(value = "hrmsRecruitmentProgressDistribution", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentProgressDistribution(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentProgressDistribution start");
		logger.info("Method :hrmsRecruitmentProgressDistribution endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentProgressDistribution(fromDate, toDate, location, org, orgDiv);
	}
	
	//hrmsRecruitmentAcceptanceRejectionDistribution
	@RequestMapping(value = "hrmsRecruitmentAcceptanceRejectionDistribution", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentAcceptanceRejectionDistribution(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentAcceptanceRejectionDistribution start");
		logger.info("Method :hrmsRecruitmentAcceptanceRejectionDistribution endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentAcceptanceRejectionDistribution(fromDate, toDate, location, org, orgDiv);
	}
	
	//hrmsRecruitmentOfferDeclineReason
	@RequestMapping(value = "hrmsRecruitmentOfferDeclineReason", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentOfferDeclineReason(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentOfferDeclineReason start");
		logger.info("Method :hrmsRecruitmentOfferDeclineReason endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentOfferDeclineReason(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//hrmsRecruitmentHiringVacancyTrend
	@RequestMapping(value = "hrmsRecruitmentHiringVacancyTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentHiringVacancyTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentHiringVacancyTrend start");
		logger.info("Method :hrmsRecruitmentHiringVacancyTrend endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentHiringVacancyTrend(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//hrmsRecruitmentHiredByJobsRole
	@RequestMapping(value = "hrmsRecruitmentHiredByJobsRole", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentHiredByJobsRole(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentHiredByJobsRole start");
		logger.info("Method :hrmsRecruitmentHiredByJobsRole endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentHiredByJobsRole(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//hrmsRecruitmentHiredByProject
	@RequestMapping(value = "hrmsRecruitmentHiredByDepartment", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentHiredByDepartment(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentHiredByDepartment start");
		logger.info("Method :hrmsRecruitmentHiredByDepartment endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentHiredByDepartment(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//hrmsRecruitmentSalaryDistByExpHiresEmp
	@RequestMapping(value = "hrmsRecruitmentSalaryDistByExpHiresEmp", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentSalaryDistByExpHiresEmp(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentSalaryDistByExpHiresEmp start");
		logger.info("Method :hrmsRecruitmentSalaryDistByExpHiresEmp endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentSalaryDistByExpHiresEmp(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//hrmsRecruitmentHiredByAgeBrackets

	@RequestMapping(value = "hrmsRecruitmentHiredByAgeBrackets", method = { RequestMethod.GET })
	public JsonResponse<Object> hrmsRecruitmentHiredByAgeBrackets(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :hrmsRecruitmentHiredByAgeBrackets start");
		logger.info("Method :hrmsRecruitmentHiredByAgeBrackets endss");
		return restHrmsDashboardRecruitmentDao.hrmsRecruitmentHiredByAgeBrackets(fromDate, toDate, location, org, orgDiv);
	}
		
		
		
		//////////////////////////////////Recruitment End/////////////////////////////////
		
		
	
	
	
}
