package nirmalya.aatithya.restmodule.recruitment.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.dao.RecuitmentDashboardDao;
import nirmalya.aatithya.restmodule.recruitment.model.JobTitleRestModel;

@RestController
@RequestMapping("recruitment")
public class RecuitmentDashboardRestController {
	Logger logger = LoggerFactory.getLogger(RecuitmentDashboardRestController.class);

	@Autowired
	RecuitmentDashboardDao recuitmentDashboardDao;
	
	
		//recruitmentDashHeadCount
		@RequestMapping(value = "recruitmentDashHeadCount", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashHeadCount(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashHeadCount start");
			logger.info("Method :recruitmentDashHeadCount endss");
			return recuitmentDashboardDao.recruitmentDashHeadCount(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		
		//recruitmentDashAvgCostHiringBySeniorityLevel
		@RequestMapping(value = "recruitmentDashAvgCostHiringBySeniorityLevel", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashAvgCostHiringBySeniorityLevel(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashAvgCostHiringBySeniorityLevel start");
			logger.info("Method :recruitmentDashAvgCostHiringBySeniorityLevel endss");
			return recuitmentDashboardDao.recruitmentDashAvgCostHiringBySeniorityLevel(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//getAllRctmntCityList
		@RequestMapping(value = "getAllRctmntCityList", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllRctmntCityList(@RequestParam String id) {
			logger.info("Method : getAllRctmntCityList starts");
			logger.info("Method : getAllRctmntCityList ends");
			return recuitmentDashboardDao.getAllRctmntCityList(id);
		}
		
		//recruitmentDashFunnelCount
		@RequestMapping(value = "recruitmentDashFunnelCount", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashFunnelCount(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashFunnelCount start");
			logger.info("Method :recruitrecruitmentDashFunnelCountmentDashHeadCount endss");
			return recuitmentDashboardDao.recruitmentDashFunnelCount(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//recruitmentDashTurnOverRateByAge
		@RequestMapping(value = "recruitmentDashTurnOverRateByAge", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashTurnOverRateByAge(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashTurnOverRateByAge start");
			logger.info("Method :recruitmentDashTurnOverRateByAge endss");
			return recuitmentDashboardDao.recruitmentDashTurnOverRateByAge(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//recruitmentDashHiredBySource
		@RequestMapping(value = "recruitmentDashHiredBySource", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashHiredBySource(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashHiredBySource start");
			logger.info("Method :recruitmentDashHiredBySource endss");
			return recuitmentDashboardDao.recruitmentDashHiredBySource(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//recruitmentDashHiringVacancyTrend
		@RequestMapping(value = "recruitmentDashHiringVacancyTrend", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashHiringVacancyTrend(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashHiringVacancyTrend start");
			logger.info("Method :recruitmentDashHiringVacancyTrend endss");
			return recuitmentDashboardDao.recruitmentDashHiringVacancyTrend(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//recruitmentDashHiringByJobsRole
		@RequestMapping(value = "recruitmentDashHiringByJobsRole", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashHiringByJobsRole(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashHiringByJobsRole start");
			logger.info("Method :recruitmentDashHiringByJobsRole endss");
			return recuitmentDashboardDao.recruitmentDashHiringByJobsRole(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//recruitmentDashAvgDeptByfullfillInDay
		@RequestMapping(value = "recruitmentDashAvgDeptByfullfillInDay", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashAvgDeptByfullfillInDay(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashAvgDeptByfullfillInDay start");
			logger.info("Method :recruitmentDashAvgDeptByfullfillInDay endss");
			return recuitmentDashboardDao.recruitmentDashAvgDeptByfullfillInDay(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//recruitmentDashHiredByDepartment
		@RequestMapping(value = "recruitmentDashHiredByDepartment", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashHiredByDepartment(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashHiredByDepartment start");
			logger.info("Method :recruitmentDashHiredByDepartment endss");
			return recuitmentDashboardDao.recruitmentDashHiredByDepartment(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//recruitmentDashSalaryDistByExpHiredEmp
		@RequestMapping(value = "recruitmentDashSalaryDistByExpHiredEmp", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashSalaryDistByExpHiredEmp(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashSalaryDistByExpHiredEmp start");
			logger.info("Method :recruitmentDashSalaryDistByExpHiredEmp endss");
			return recuitmentDashboardDao.recruitmentDashSalaryDistByExpHiredEmp(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//recruitmentDashHiredByAgeBrackets
		@RequestMapping(value = "recruitmentDashHiredByAgeBrackets", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashHiredByAgeBrackets(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashHiredByAgeBrackets start");
			logger.info("Method :recruitmentDashHiredByAgeBrackets endss");
			return recuitmentDashboardDao.recruitmentDashHiredByAgeBrackets(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//recruitmentDashOfferDeclineReason
		@RequestMapping(value = "recruitmentDashOfferDeclineReason", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashOfferDeclineReason(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashOfferDeclineReason start");
			logger.info("Method :recruitmentDashOfferDeclineReason endss");
			return recuitmentDashboardDao.recruitmentDashOfferDeclineReason(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//recruitmentDashProgressDistribution
		@RequestMapping(value = "recruitmentDashProgressDistribution", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashProgressDistribution(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashProgressDistribution start");
			logger.info("Method :recruitmentDashProgressDistribution endss");
			return recuitmentDashboardDao.recruitmentDashProgressDistribution(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//recruitmentDashAcceptRejectionDistribution
		@RequestMapping(value = "recruitmentDashAcceptRejectionDistribution", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashAcceptRejectionDistribution(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashAcceptRejectionDistribution start");
			logger.info("Method :recruitmentDashAcceptRejectionDistribution endss");
			return recuitmentDashboardDao.recruitmentDashAcceptRejectionDistribution(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		
		//recruitmentDashConversionRateByHr
		@RequestMapping(value = "recruitmentDashConversionRateByHr", method = { RequestMethod.GET })
		public JsonResponse<Object> recruitmentDashConversionRateByHr(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String department, @RequestParam String jobRole,
				@RequestParam String recuiter, @RequestParam String type) {
			logger.info("Method :recruitmentDashConversionRateByHr start");
			logger.info("Method :recruitmentDashConversionRateByHr endss");
			return recuitmentDashboardDao.recruitmentDashConversionRateByHr(fromDate, toDate, location, org, orgDiv, department, jobRole, recuiter, type);
		}
		

	
}
