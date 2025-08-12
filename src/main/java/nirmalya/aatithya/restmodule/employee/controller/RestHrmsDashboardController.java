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
import nirmalya.aatithya.restmodule.employee.dao.RestHrmsDashboardDao;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsDashboardModel;

@RestController
@RequestMapping("employee/")
public class RestHrmsDashboardController {
	Logger logger = LoggerFactory.getLogger(RestHrmsDashboardController.class);

	@Autowired
	RestHrmsDashboardDao restHrmsDashboardDao;
	
	// organisation
	/*	@RequestMapping(value = "getOrganization", method = { RequestMethod.GET })
		public List<DropDownModel> getOrganizationDivision(@RequestParam String orgName) {
			logger.info("Method : getOrganizationDivision starts");

			logger.info("Method : getOrganizationDivision ends");
			return restHrmsDashboardDao.getOrganization(orgName);
		}

		// organisationDivision
		@RequestMapping(value = "getDivision", method = { RequestMethod.GET })
		public List<DropDownModel> getDivision(@RequestParam String orgName) {
			logger.info("Method : getDivision starts");

			logger.info("Method : getDivision ends");
			return restHrmsDashboardDao.getDivision(orgName);
		}*/
		
		
		@RequestMapping(value = "dashboard-hrms-getAllData-oprtnl", method = { RequestMethod.GET })
		public JsonResponse<Object> getAllDataOprtnls(@RequestParam String id,
				@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String location
				, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :getAllDataOprtnls start");
			logger.info("Method :getAllDataOprtnls endss");
			return restHrmsDashboardDao.getHRMSAllDataOprtnls(id, fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsDashboardCount1
		@RequestMapping(value = "hrmsDashboardCount1", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsDashboardCount1(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsDashboardCount1 start");
			logger.info("Method :hrmsDashboardCount1 endss");
			return restHrmsDashboardDao.hrmsDashboardCount1(fromDate, toDate, location, org, orgDiv);
		}

		//hrmsDashboardCount2
		@RequestMapping(value = "hrmsDashboardCount2", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsDashboardCount2(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsDashboardCount2 start");
			logger.info("Method :hrmsDashboardCount2 endss");
			return restHrmsDashboardDao.hrmsDashboardCount2(fromDate, toDate, location, org, orgDiv);
		}

		
		//hrmsDashboardAttritionHeadCount
		@RequestMapping(value = "hrmsDashboardAttritionHeadCount", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsDashboardAttritionHeadCount(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsDashboardAttritionHeadCount start");
			logger.info("Method :hrmsDashboardAttritionHeadCount endss");
			return restHrmsDashboardDao.hrmsDashboardAttritionHeadCount(fromDate, toDate, location, org, orgDiv);
		}
		
		//getAllHRMSCityList
		@RequestMapping(value = "getAllHRMSCityList", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllHRMSCityList(@RequestParam String id) {
			logger.info("Method : getAllHRMSCityList starts");
			logger.info("Method : getAllHRMSCityList ends");
			return restHrmsDashboardDao.getAllHRMSCityList(id);
		}
		
		//hrmsDashboardAttnInvoluntaryVoluntary
		@RequestMapping(value = "hrmsDashboardAttnInvoluntaryVoluntary", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsDashboardAttnInvoluntaryVoluntary(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsDashboardAttnInvoluntaryVoluntary start");
			logger.info("Method :hrmsDashboardAttnInvoluntaryVoluntary endss");
			return restHrmsDashboardDao.hrmsDashboardAttnInvoluntaryVoluntary(fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsDashboardAttnEmpTenure
		@RequestMapping(value = "hrmsDashboardAttnEmpTenure", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsDashboardAttnEmpTenure(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsDashboardAttnEmpTenure start");
			logger.info("Method :hrmsDashboardAttnEmpTenure endss");
			return restHrmsDashboardDao.hrmsDashboardAttnEmpTenure(fromDate, toDate, location, org, orgDiv);
		}
		
		//dashhrmsAttRatio   
		@RequestMapping(value = "dashhrmsAttRatio", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsAttRatio(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsAttRatio start");
			logger.info("Method :dashhrmsAttRatio endss");
			return restHrmsDashboardDao.dashhrmsAttRatio(fromDate, toDate, location, org, orgDiv);
		}
	
		
		//dashhrmsAttDeptWise
		@RequestMapping(value = "dashhrmsAttDeptWise", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsAttDeptWise(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsAttDeptWise start");
			logger.info("Method :dashhrmsAttDeptWise endss");
			return restHrmsDashboardDao.dashhrmsAttDeptWise(fromDate, toDate, location, org, orgDiv);
		}
		
		
		//dashhrmsAttVoluntaryWise
		@RequestMapping(value = "dashhrmsAttVoluntaryWise", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsAttVoluntaryWise(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsAttVoluntaryWise start");
			logger.info("Method :dashhrmsAttVoluntaryWise endss");
			return restHrmsDashboardDao.dashhrmsAttVoluntaryWise(fromDate, toDate, location, org, orgDiv);
		}
		
		//dashhrmsAttReasonDistribution
		@RequestMapping(value = "dashhrmsAttReasonDistribution", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsAttReasonDistribution(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsAttReasonDistribution start");
			logger.info("Method :dashhrmsAttReasonDistribution endss");
			return restHrmsDashboardDao.dashhrmsAttReasonDistribution(fromDate, toDate, location, org, orgDiv);
		}
		
		//dashhrmsAttritionByTenureSalary
		@RequestMapping(value = "dashhrmsAttritionByTenureSalary", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsAttritionByTenureSalary(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsAttritionByTenureSalary start");
			logger.info("Method :dashhrmsAttritionByTenureSalary endss");
			return restHrmsDashboardDao.dashhrmsAttritionByTenureSalary(fromDate, toDate, location, org, orgDiv);
		}
		
		
		//dashhrmsAttritionByJobRole
		@RequestMapping(value = "dashhrmsAttritionByJobRole", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsAttritionByJobRole(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsAttritionByJobRole start");
			logger.info("Method :dashhrmsAttritionByJobRole endss");
			return restHrmsDashboardDao.dashhrmsAttritionByJobRole(fromDate, toDate, location, org, orgDiv);
		}
		
		//dashhrmsAttritionByTenure
		@RequestMapping(value = "dashhrmsAttritionByTenure", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsAttritionByTenure(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsAttritionByTenure start");
			logger.info("Method :dashhrmsAttritionByTenure endss");
			return restHrmsDashboardDao.dashhrmsAttritionByTenure(fromDate, toDate, location, org, orgDiv);
		}
		
		
		


		//hrmsDashboardCompensationHeadCount
		@RequestMapping(value = "hrmsDashboardCompensationHeadCount", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsDashboardCompensationHeadCount(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsDashboardCompensationHeadCount start");
			logger.info("Method :hrmsDashboardCompensationHeadCount endss");
			return restHrmsDashboardDao.hrmsDashboardCompensationHeadCount(fromDate, toDate, location, org, orgDiv);
		}
		//hrmsDashboardCompensationSalaryDistributionDept
		@RequestMapping(value = "hrmsDashboardCompensationSalaryDistributionDept", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsDashboardCompensationSalaryDistributionDept(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsDashboardCompensationSalaryDistributionDept start");
			logger.info("Method :hrmsDashboardCompensationSalaryDistributionDept endss");
			return restHrmsDashboardDao.hrmsDashboardCompensationSalaryDistributionDept(fromDate, toDate, location, org, orgDiv);
		}
		//hrmsDashboardCompensationSalaryRange
		@RequestMapping(value = "hrmsDashboardCompensationEmpCountSalaryRange", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsDashboardCompensationEmpCountSalaryRange(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsDashboardCompensationEmpCountSalaryRange start");
			logger.info("Method :hrmsDashboardCompensationEmpCountSalaryRange endss");
			return restHrmsDashboardDao.hrmsDashboardCompensationEmpCountSalaryRange(fromDate, toDate, location, org, orgDiv);
		}
		//dashhrmsCompensationJoiningLeavingTrend
		@RequestMapping(value = "dashhrmsCompensationJoiningLeavingTrend", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsCompensationJoiningLeavingTrend(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsCompensationJoiningLeavingTrend start");
			logger.info("Method :dashhrmsCompensationJoiningLeavingTrend endss");
			return restHrmsDashboardDao.dashhrmsCompensationJoiningLeavingTrend(fromDate, toDate, location, org, orgDiv);
		}
		//dashhrmsCompensationSalaryByPerformance
		@RequestMapping(value = "dashhrmsCompensationSalaryByPerformance", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsCompensationSalaryByPerformance(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsCompensationSalaryByPerformance start");
			logger.info("Method :dashhrmsCompensationSalaryByPerformance endss");
			return restHrmsDashboardDao.dashhrmsCompensationSalaryByPerformance(fromDate, toDate, location, org, orgDiv);
		}
		//dashhrmsAttritionCompensationAvgSalryYearRangeBy
		@RequestMapping(value = "dashhrmsAttritionCompensationAvgSalryYearRangeBy", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsAttritionCompensationAvgSalryYearRangeBy(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsAttritionCompensationAvgSalryYearRangeBy start");
			logger.info("Method :dashhrmsAttritionCompensationAvgSalryYearRangeBy endss");
			return restHrmsDashboardDao.dashhrmsAttritionCompensationAvgSalryYearRangeBy(fromDate, toDate, location, org, orgDiv);
		}
		
		/////////////////////Performance Start/////////////////////////////////////////////////
		
		//dashhrmsPerformHeadCount
		@RequestMapping(value = "dashhrmsPerformHeadCount", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsPerformHeadCount(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsPerformHeadCount start");
			logger.info("Method :dashhrmsPerformHeadCount endss");
			return restHrmsDashboardDao.dashhrmsPerformHeadCount(fromDate, toDate, location, org, orgDiv);
		}
		
		//dashhrmsPerformanceEmpRatingDistriByDept
		@RequestMapping(value = "dashhrmsPerformanceEmpRatingDistriByDept", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsPerformanceEmpRatingDistriByDept(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsPerformanceEmpRatingDistriByDept start");
			logger.info("Method :dashhrmsPerformanceEmpRatingDistriByDept endss");
			return restHrmsDashboardDao.dashhrmsPerformanceEmpRatingDistriByDept(fromDate, toDate, location, org, orgDiv);
		}
		
		//dashhrmsPerformanceEmpTenureWithLastYear
		@RequestMapping(value = "dashhrmsPerformanceEmpTenureWithLastYear", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsPerformanceEmpTenureWithLastYear(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsPerformanceEmpTenureWithLastYear start");
			logger.info("Method :dashhrmsPerformanceEmpTenureWithLastYear endss");
			return restHrmsDashboardDao.dashhrmsPerformanceEmpTenureWithLastYear(fromDate, toDate, location, org, orgDiv);
		}
		
		//dashhrmsPerformanceOvertimebyAgeGroup
		@RequestMapping(value = "dashhrmsPerformanceOvertimebyAgeGroup", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsPerformanceOvertimebyAgeGroup(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsPerformanceOvertimebyAgeGroup start");
			logger.info("Method :dashhrmsPerformanceOvertimebyAgeGroup endss");
			return restHrmsDashboardDao.dashhrmsPerformanceOvertimebyAgeGroup(fromDate, toDate, location, org, orgDiv);
		}
		
		//dashhrmsPerformanceAbsenteeismRate
		@RequestMapping(value = "dashhrmsPerformanceAbsenteeismRate", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsPerformanceAbsenteeismRate(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsPerformanceAbsenteeismRate start");
			logger.info("Method :dashhrmsPerformanceAbsenteeismRate endss");
			return restHrmsDashboardDao.dashhrmsPerformanceAbsenteeismRate(fromDate, toDate, location, org, orgDiv);
		}
		
		//dashhrmsPerformanceEmpCountByRating
		@RequestMapping(value = "dashhrmsPerformanceEmpCountByRating", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsPerformanceEmpCountByRating(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsPerformanceEmpCountByRating start");
			logger.info("Method :dashhrmsPerformanceEmpCountByRating endss");
			return restHrmsDashboardDao.dashhrmsPerformanceEmpCountByRating(fromDate, toDate, location, org, orgDiv);
		}
		
		//dashhrmsPerformanceAvgSalaryYearRangeBy
		@RequestMapping(value = "dashhrmsPerformanceAvgSalaryYearRangeBy", method = { RequestMethod.GET })
		public JsonResponse<Object> dashhrmsPerformanceAvgSalaryYearRangeBy(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :dashhrmsPerformanceAvgSalaryYearRangeBy start");
			logger.info("Method :dashhrmsPerformanceAvgSalaryYearRangeBy endss");
			return restHrmsDashboardDao.dashhrmsPerformanceAvgSalaryYearRangeBy(fromDate, toDate, location, org, orgDiv);
		}
		
		//////////////////////////////////Management Start////////////////////////////////////
		//hrmsManagementHeadCount
		@RequestMapping(value = "hrmsManagementHeadCount", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsManagementHeadCount(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsManagementHeadCount start");
			logger.info("Method :hrmsManagementHeadCount endss");
			return restHrmsDashboardDao.hrmsManagementHeadCount(fromDate, toDate, location, org, orgDiv);
		}
		//hrmsManagementEmpCntByDept
		@RequestMapping(value = "hrmsManagementEmpCntByDept", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsManagementEmpCntByDept(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsManagementEmpCntByDept start");
			logger.info("Method :hrmsManagementEmpCntByDept endss");
			return restHrmsDashboardDao.hrmsManagementEmpCntByDept(fromDate, toDate, location, org, orgDiv);
		}
		//hrmsManagementEmpCntByAge
		@RequestMapping(value = "hrmsManagementEmpCntByAge", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsManagementEmpCntByAge(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsManagementEmpCntByAge start");
			logger.info("Method :hrmsManagementEmpCntByAge endss");
			return restHrmsDashboardDao.hrmsManagementEmpCntByAge(fromDate, toDate, location, org, orgDiv);
		}
		//hrmsManagementEmpCntByDeptExp
		@RequestMapping(value = "hrmsManagementEmpCntByDeptExp", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsManagementEmpCntByDeptExp(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsManagementEmpCntByDeptExp start");
			logger.info("Method :hrmsManagementEmpCntByDeptExp endss");
			return restHrmsDashboardDao.hrmsManagementEmpCntByDeptExp(fromDate, toDate, location, org, orgDiv);
		}
		//hrmsManagementHeadCountDevlpmnt
		@RequestMapping(value = "hrmsManagementHeadCountDevlpmnt", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsManagementHeadCountDevlpmnt(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsManagementHeadCountDevlpmnt start");
			logger.info("Method :hrmsManagementHeadCountDevlpmnt endss");
			return restHrmsDashboardDao.hrmsManagementHeadCountDevlpmnt(fromDate, toDate, location, org, orgDiv);
		}
		//hrmsManagementEmpPayByDept
		@RequestMapping(value = "hrmsManagementEmpPayByDept", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsManagementEmpPayByDept(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsManagementEmpPayByDept start");
			logger.info("Method :hrmsManagementEmpPayByDept endss");
			return restHrmsDashboardDao.hrmsManagementEmpPayByDept(fromDate, toDate, location, org, orgDiv);
		}
		//hrmsManagementHireByEmpType
		@RequestMapping(value = "hrmsManagementHireByEmpType", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsManagementHireByEmpType(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsManagementHireByEmpType start");
			logger.info("Method :hrmsManagementHireByEmpType endss");
			return restHrmsDashboardDao.hrmsManagementHireByEmpType(fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsManagementEmpByGender
		@RequestMapping(value = "hrmsManagementEmpByGender", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsManagementEmpByGender(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsManagementEmpByGender start");
			logger.info("Method :hrmsManagementEmpByGender endss");
			return restHrmsDashboardDao.hrmsManagementEmpByGender(fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsManagementSalaryByAgeGroup
		@RequestMapping(value = "hrmsManagementSalaryByAgeGroup", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsManagementSalaryByAgeGroup(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsManagementSalaryByAgeGroup start");
			logger.info("Method :hrmsManagementSalaryByAgeGroup endss");
			return restHrmsDashboardDao.hrmsManagementSalaryByAgeGroup(fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsManagementEmpCountByCity
		@RequestMapping(value = "hrmsManagementEmpCountByCity", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsManagementEmpCountByCity(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsManagementEmpCountByCity start");
			logger.info("Method :hrmsManagementEmpCountByCity endss");
			return restHrmsDashboardDao.hrmsManagementEmpCountByCity(fromDate, toDate, location, org, orgDiv);
		}
		//hrmsManagementEmpByExperience
		@RequestMapping(value = "hrmsManagementEmpByExperience", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsManagementEmpByExperience(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsManagementEmpByExperience start");
			logger.info("Method :hrmsManagementEmpByExperience endss");
			return restHrmsDashboardDao.hrmsManagementEmpByExperience(fromDate, toDate, location, org, orgDiv);
		}
		//hrmsManagementCostPerEmp
		@RequestMapping(value = "hrmsManagementCostPerEmp", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsManagementCostPerEmp(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsManagementCostPerEmp start");
			logger.info("Method :hrmsManagementCostPerEmp endss");
			return restHrmsDashboardDao.hrmsManagementCostPerEmp(fromDate, toDate, location, org, orgDiv);
		}
		//////////////////////////////////Management End//////////////////////////////////////
		
		//////////////////////////////////Talent Start////////////////////////////////////////
		//hrmsTalentHeadCount
		@RequestMapping(value = "hrmsTalentHeadCount", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsTalentHeadCount(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsTalentHeadCount start");
			logger.info("Method :hrmsTalentHeadCount endss");
			return restHrmsDashboardDao.hrmsTalentHeadCount(fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsTalentTurnoverRate
		@RequestMapping(value = "hrmsTalentTurnoverRate", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsTalentTurnoverRate(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsTalentTurnoverRate start");
			logger.info("Method :hrmsTalentTurnoverRate endss");
			return restHrmsDashboardDao.hrmsTalentTurnoverRate(fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsTalentFiredByEmploymentByPeriod
		@RequestMapping(value = "hrmsTalentFiredByEmploymentByPeriod", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsTalentFiredByEmploymentByPeriod(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsTalentFiredByEmploymentByPeriod start");
			logger.info("Method :hrmsTalentFiredByEmploymentByPeriod endss");
			return restHrmsDashboardDao.hrmsTalentFiredByEmploymentByPeriod(fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsTalentSatisfactionMonthWise
		@RequestMapping(value = "hrmsTalentSatisfactionMonthWise", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsTalentSatisfactionMonthWise(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsTalentSatisfactionMonthWise start");
			logger.info("Method :hrmsTalentSatisfactionMonthWise endss");
			return restHrmsDashboardDao.hrmsTalentSatisfactionMonthWise(fromDate, toDate, location, org, orgDiv);
		}
		

		//hrmsTalentTrendWiseYearCount
		@RequestMapping(value = "hrmsTalentTrendWiseYearCount", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsTalentTrendWiseYearCount(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsTalentTrendWiseYearCount start");
			logger.info("Method :hrmsTalentTrendWiseYearCount endss");
			return restHrmsDashboardDao.hrmsTalentTrendWiseYearCount(fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsTalentRatingMonthWise
		@RequestMapping(value = "hrmsTalentRatingMonthWise", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsTalentRatingMonthWise(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsTalentRatingMonthWise start");
			logger.info("Method :hrmsTalentRatingMonthWise endss");
			return restHrmsDashboardDao.hrmsTalentRatingMonthWise(fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsTalentByRatingByPercent
		@RequestMapping(value = "hrmsTalentByRatingByPercent", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsTalentByRatingByPercent(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsTalentByRatingByPercent start");
			logger.info("Method :hrmsTalentByRatingByPercent endss");
			return restHrmsDashboardDao.hrmsTalentByRatingByPercent(fromDate, toDate, location, org, orgDiv);
		}
		

		//hrmsTalentLastSixMonthCategoriesWise
		@RequestMapping(value = "hrmsTalentLastSixMonthCategoriesWise", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsTalentLastSixMonthCategoriesWise(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsTalentLastSixMonthCategoriesWise start");
			logger.info("Method :hrmsTalentLastSixMonthCategoriesWise endss");
			return restHrmsDashboardDao.hrmsTalentLastSixMonthCategoriesWise(fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsTalentLastOneYearCategoriesWise
		@RequestMapping(value = "hrmsTalentLastOneYearCategoriesWise", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsTalentLastOneYearCategoriesWise(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsTalentLastOneYearCategoriesWise start");
			logger.info("Method :hrmsTalentLastOneYearCategoriesWise endss");
			return restHrmsDashboardDao.hrmsTalentLastOneYearCategoriesWise(fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsTalentLastTwoYearCategoriesWise
		@RequestMapping(value = "hrmsTalentLastTwoYearCategoriesWise", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsTalentLastTwoYearCategoriesWise(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsTalentLastTwoYearCategoriesWise start");
			logger.info("Method :hrmsTalentLastTwoYearCategoriesWise endss");
			return restHrmsDashboardDao.hrmsTalentLastTwoYearCategoriesWise(fromDate, toDate, location, org, orgDiv);
		}
		
		//hrmsTalentLastThreeYearCategoriesWise
		@RequestMapping(value = "hrmsTalentLastThreeYearCategoriesWise", method = { RequestMethod.GET })
		public JsonResponse<Object> hrmsTalentLastThreeYearCategoriesWise(@RequestParam String fromDate, @RequestParam String toDate,
				@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :hrmsTalentLastThreeYearCategoriesWise start");
			logger.info("Method :hrmsTalentLastThreeYearCategoriesWise endss");
			return restHrmsDashboardDao.hrmsTalentLastThreeYearCategoriesWise(fromDate, toDate, location, org, orgDiv);
		}
		
		//////////////////////////////////Talent End//////////////////////////////////////////
		
		
	/*

	// Total Monthly Attendance
	@GetMapping(value = "rest-getTotalMonthlyAttendance")
	public JsonResponse<List<DropDownModel>> getTotalMonthlyAttendance(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getTotalMonthlyAttendance starts");

		logger.info("Method :getTotalMonthlyAttendance ends");
		return restHrmsDashboardDao.getTotalMonthlyAttendance(userId, orgName, orgDiv, currentYear);
	}

	// totalMonthlyAttendance Aggrid
	@GetMapping(value = "rest-getTotalMonthlyAttendanceAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalMonthlyAttendanceAggrid(
			@RequestParam("userId") String userId, @RequestParam("value1") String value1,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear, @RequestParam("month") String month) {

		logger.info("Method : getTotalMonthlyAttendanceAggrid starts");

		logger.info("Method :getTotalMonthlyAttendanceAggrid ends");
		return restHrmsDashboardDao.getTotalMonthlyAttendanceAggrid(userId, value1, orgName, orgDiv, currentYear,
				month);
	}

	// Total Monthly Reimbursement
	@GetMapping(value = "rest-getTotalMonthlyReimbursement")
	public JsonResponse<List<DropDownModel>> getTotalMonthlyReimbursement(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getTotalMonthlyReimbursement starts");

		logger.info("Method :getTotalMonthlyReimbursement ends");
		return restHrmsDashboardDao.getTotalMonthlyReimbursement(userId, orgName, orgDiv, currentYear);
	}

	// Total Monthly Reimbursement Aggrid
	@GetMapping(value = "rest-getTotalMonthlyReimbursementAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalMonthlyReimbursementAggrid(
			@RequestParam("userId") String userId, @RequestParam("value1") String value1,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear, @RequestParam("month") String month) {

		logger.info("Method : getTotalMonthlyReimbursementAggrid starts");

		logger.info("Method :getTotalMonthlyReimbursementAggrid ends");
		return restHrmsDashboardDao.getTotalMonthlyReimbursementAggrid(userId, value1, orgName, orgDiv, currentYear,
				month);
	}

	// Total Leave

	@GetMapping(value = "rest-getTotalLeave")
	public JsonResponse<List<DropDownModel>> getTotalLeave(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getTotalLeave starts");

		logger.info("Method :getTotalLeave ends");
		return restHrmsDashboardDao.getTotalLeave(userId, orgName, orgDiv, currentYear);
	}

	// Leave Aggrid
	@GetMapping(value = "rest-getTotalLeaveAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalLeaveAggrid(@RequestParam("userId") String userId,
			@RequestParam("value1") String value1, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam("currentYear") String currentYear) {

		logger.info("Method : getTotalLeaveAggrid starts");

		logger.info("Method :getTotalLeaveAggrid ends");
		return restHrmsDashboardDao.getTotalLeaveAggrid(userId, value1, orgName, orgDiv, currentYear);
	}
	// Total Monthly Event

	@GetMapping(value = "rest-getTotalMonthlyEvent")
	public JsonResponse<List<DropDownModel>> getTotalMonthlyEvent(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getTotalMonthlyEvent starts");

		logger.info("Method :getTotalMonthlyEvent ends");
		return restHrmsDashboardDao.getTotalMonthlyEvent(userId, orgName, orgDiv, currentYear);
	}

	// Total Monthly Event Aggrid
	@GetMapping(value = "rest-getTotalMonthlyEventAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalMonthlyEventAggrid(@RequestParam("userId") String userId,
			@RequestParam("value1") String value1, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam("currentYear") String currentYear,
			@RequestParam("month") String month) {

		logger.info("Method : getTotalMonthlyEventAggrid starts");

		logger.info("Method :getTotalMonthlyEventAggrid ends");
		return restHrmsDashboardDao.getTotalMonthlyEventAggrid(userId, value1, orgName, orgDiv, currentYear, month);
	}

	// Total Count Details
	@GetMapping(value = "rest-getCountDetails")
	public JsonResponse<List<RestHrmsDashboardModel>> getCountDetails(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getCountDetails starts");

		logger.info("Method :getCountDetails ends");
		return restHrmsDashboardDao.getCountDetails(userId, orgName, orgDiv, currentYear);
	}

	// Total Manager Count Details
	@GetMapping(value = "rest-getManagerCountDetails")
	public JsonResponse<List<RestHrmsDashboardModel>> getManagerCountDetails(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getManagerCountDetails starts");

		logger.info("Method :getManagerCountDetails ends");
		return restHrmsDashboardDao.getManagerCountDetails(userId, orgName, orgDiv, currentYear);
	}

	/// Leave Approve
	@GetMapping(value = "rest-getLeaveApprove")
	public JsonResponse<List<DropDownModel>> getLeaveApprove(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method : getLeaveApprove starts");

		logger.info("Method :getLeaveApprove ends");
		return restHrmsDashboardDao.getLeaveApprove(userId, orgName, orgDiv, fromdate, todate);
	}

	// Leave Approve Aggrid
	@GetMapping(value = "rest-getLeaveApprovedAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getLeaveApprovedAggrid(@RequestParam("userId") String userId,
			@RequestParam("value1") String value1, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam String fromdate, @RequestParam String todate) {

		logger.info("Method : getLeaveApprovedAggrid starts");

		logger.info("Method :getLeaveApprovedAggrid ends");
		return restHrmsDashboardDao.getLeaveApprovedAggrid(userId, value1, orgName, orgDiv, fromdate, todate);
	}

	// Total Reimbursement Approved
	@GetMapping(value = "rest-getReimbursementApproved")
	public JsonResponse<List<DropDownModel>> getReimbursementApproved(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method : getReimbursementApproved starts");

		logger.info("Method :getReimbursementApproved ends");
		return restHrmsDashboardDao.getReimbursementApproved(userId, orgName, orgDiv, fromdate, todate);
	}

	// Total Reimbursement Approved Aggrid
	@GetMapping(value = "rest-getReimbursementApprovedAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getReimbursementApprovedAggrid(
			@RequestParam("userId") String userId, @RequestParam("value1") String value1,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("month") String month,@RequestParam String fromdate, @RequestParam String todate) {

		logger.info("Method : getReimbursementApprovedAggrid starts");

		logger.info("Method :getReimbursementApprovedAggrid ends");
		return restHrmsDashboardDao.getReimbursementApprovedAggrid(userId, value1, orgName, orgDiv, month,fromdate, todate);
	}

	// PayRoll Process
	@GetMapping(value = "rest-getPayrollProcess")
	public JsonResponse<List<RestHrmsDashboardModel>> getPayrollProcess(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method : getPayrollProcess starts");

		logger.info("Method :getPayrollProcess ends");
		return restHrmsDashboardDao.getPayrollProcess(userId, orgName, orgDiv, fromdate, todate);
	}

	// PayRoll Process Aggrid

	@GetMapping(value = "rest-getPayrollProcessAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getPayrollProcessAggrid(@RequestParam("userId") String userId,
			@RequestParam("value") String value, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam String fromdate, @RequestParam String todate) {

		logger.info("Method : getPayrollProcessAggrid starts");

		logger.info("Method :getPayrollProcessAggrid ends");
		return restHrmsDashboardDao.getPayrollProcessAggrid(userId, value, orgName, orgDiv, fromdate, todate);
	}
	// RatingWise Appresal

	@GetMapping(value = "rest-getRatingWise")
	public JsonResponse<List<DropDownModel>> getRatingWise(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getRatingWise starts");

		logger.info("Method :getRatingWise ends");
		return restHrmsDashboardDao.getRatingWise(userId, orgName, orgDiv, currentYear);
	}

	// RatingWise Appresal aggrid
	@GetMapping(value = "rest-getRatingWiseAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getRatingWiseAggrid(@RequestParam("userId") String userId,
			@RequestParam("value1") String value1, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam("currentYear") String currentYear) {

		logger.info("Method : getRatingWiseAggrid starts");

		logger.info("Method :getRatingWiseAggrid ends");
		return restHrmsDashboardDao.getRatingWiseAggrid(userId, value1, orgName, orgDiv, currentYear);
	}

	// Total HR Count Details
	@GetMapping(value = "rest-getHrCountDetails")
	public JsonResponse<List<RestHrmsDashboardModel>> getHrCountDetails(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getHrCountDetails starts");

		logger.info("Method :getHrCountDetails ends");
		return restHrmsDashboardDao.getHrCountDetails(userId, orgName, orgDiv, currentYear);
	}

	// Designation By Requisition
	@GetMapping(value = "rest-getDesignationByRequisition")
	public JsonResponse<List<RestHrmsDashboardModel>> getDesignationByRequisition(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getDesignationByRequisition starts");

		logger.info("Method :getDesignationByRequisition ends");
		return restHrmsDashboardDao.getDesignationByRequisition(userId, orgName, orgDiv, currentYear);
	}

	// Designation By Requisition Aggrid
	@GetMapping(value = "rest-getDesignationByRequisitionAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getDesignationByRequisitionAggrid(
			@RequestParam("userId") String userId, @RequestParam("value1") String value1,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear, @RequestParam("value") String value) {

		logger.info("Method : getDesignationByRequisitionAggrid starts");

		logger.info("Method :getDesignationByRequisitionAggrid ends");
		return restHrmsDashboardDao.getDesignationByRequisitionAggrid(userId, value1, orgName, orgDiv, currentYear,
				value);
	}

	// Requisition status
	@GetMapping(value = "rest-getRequisitionStatus")
	public JsonResponse<List<RestHrmsDashboardModel>> getRequisitionStatus(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getRequisitionStatus starts");

		logger.info("Method :getRequisitionStatus ends");
		return restHrmsDashboardDao.getRequisitionStatus(userId, orgName, orgDiv, currentYear);
	}

	// Requisition Status Aggrid
	@GetMapping(value = "rest-getRequisitionStatusAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getRequisitionStatusAggrid(@RequestParam("userId") String userId,
			@RequestParam("value") String value, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam("currentYear") String currentYear) {

		logger.info("Method : getRequisitionStatusAggrid starts");

		logger.info("Method :getRequisitionStatusAggrid ends");
		return restHrmsDashboardDao.getRequisitionStatusAggrid(userId, value, orgName, orgDiv, currentYear);
	}

	//// Gender Wise Candidate/Employee
	@GetMapping(value = "rest-getGendereWiseCandidate")
	public JsonResponse<List<DropDownModel>> getGendereWiseCandidate(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getGendereWiseCandidate starts");

		logger.info("Method :getGendereWiseCandidate ends");
		return restHrmsDashboardDao.getGendereWiseCandidate(userId, orgName, orgDiv, currentYear);
	}

	// Gender Wise Candidate/Employee Aggrid
	@GetMapping(value = "rest-getGendereWiseCandidateAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getGendereWiseCandidateAggrid(
			@RequestParam("userId") String userId, @RequestParam("value1") String value1,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {

		logger.info("Method : getGendereWiseCandidateAggrid starts");

		logger.info("Method :getGendereWiseCandidateAggrid ends");
		return restHrmsDashboardDao.getGendereWiseCandidateAggrid(userId, value1, orgName, orgDiv, currentYear);
	}

	// Yearly Event
	@GetMapping(value = "rest-getYearlyEvent")
	public JsonResponse<List<DropDownModel>> getYearlyEvent(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam("currentYear") String currentYear) {
		logger.info("Method : getYearlyEvent starts");

		logger.info("Method :getYearlyEvent ends");
		return restHrmsDashboardDao.getYearlyEvent(userId, orgName, orgDiv, currentYear);
	}

	// Yearly Event Aggrid
	@GetMapping(value = "rest-getYearlyEventAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getYearlyEventAggrid(@RequestParam("userId") String userId,
			@RequestParam("value1") String value1, @RequestParam("orgName") String orgName,
			@RequestParam("orgDiv") String orgDiv, @RequestParam("currentYear") String currentYear,
			@RequestParam("month") String month) {

		logger.info("Method : getYearlyEventAggrid starts");

		logger.info("Method :getYearlyEventAggrid ends");
		return restHrmsDashboardDao.getYearlyEventAggrid(userId, value1, orgName, orgDiv, currentYear, month);
	}

	@RequestMapping(value = "dashboard-yearlyselection", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrmsDashboardModel>>> viewYearSelectionData(
			@RequestParam String currentYear, @RequestParam String orgname, @RequestParam String orgdiv) {
		logger.info("Method : viewYearSelectionData starts" + currentYear);

		logger.info("Method : viewYearSelectionData ends");
		return restHrmsDashboardDao.viewYearSelectionData(currentYear, orgname, orgdiv);
	}

	/// getAttendanceReports
	@GetMapping(value = "rest-getAttendanceReports")
	public JsonResponse<List<DropDownModel>> getAttendanceReports(@RequestParam("userId") String userId,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method : getAttendanceReports starts" + fromdate);
		logger.info("Method : getAttendanceReports starts" + todate);

		logger.info("Method :getAttendanceReports ends");
		return restHrmsDashboardDao.getAttendanceReports(userId, orgName, orgDiv, fromdate, todate);
	}

	@GetMapping(value = "rest-getTotalemployeeAttendanceAggrid")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalEmployeeAttendanceAggrid(
			@RequestParam("userId") String userId, @RequestParam("value1") String value1,
			@RequestParam("orgName") String orgName, @RequestParam("orgDiv") String orgDiv,
			@RequestParam String fromdate, @RequestParam String todate, @RequestParam String shift) {

		logger.info("Method : getTotalEmployeeAttendanceAggrid starts");

		logger.info("Method :getTotalEmployeeAttendanceAggrid ends");
		return restHrmsDashboardDao.getTotalEmployeeAttendanceAggrid(userId, value1, orgName, orgDiv, fromdate, todate,
				shift);
	}*/
	
	
	
}
