package nirmalya.aatithya.restmodule.ticket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.ticket.dao.RsetManageDashboardDao;

@RestController
@RequestMapping("ticket/")
public class RsetManageDashboardController {

	@Autowired
	RsetManageDashboardDao dashboardDao;

	Logger logger = LoggerFactory.getLogger(RsetManageDashboardController.class);

	@RequestMapping(value = "rest-operational-tab-data", method = { RequestMethod.GET })
	public JsonResponse<Object> productionHeadData(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String location, @RequestParam String organization,
			@RequestParam String division) {
		logger.info("Method :productionHeadData start");

		logger.info("Method :productionHeadData endss");
		return dashboardDao.ticketHeadData(fromDate,toDate,location,organization,division);

	}

	// ticketListData

	@RequestMapping(value = "rest-operational-aggrid-data", method = { RequestMethod.GET })
	public JsonResponse<Object> operationalAgGridData(@RequestParam String organization, @RequestParam String division,
			@RequestParam String id,@RequestParam String fromDate,@RequestParam String location,@RequestParam String toDate) {
		logger.info("Method :operationalAgGridData start");

		logger.info("Method :operationalAgGridData endss");
		return dashboardDao.operationalAgGridData(organization, division, id,fromDate,location,toDate);

	}

	// ticketByType
	@RequestMapping(value = "ticketByType", method = { RequestMethod.GET })
	public JsonResponse<Object> ticketByType(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :ticketByType start");

		logger.info("Method :ticketByType endss");
		return dashboardDao.ticketByType(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-operational-head-count-data", method = { RequestMethod.GET })
	public JsonResponse<Object> operationalHeadData(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String location,@RequestParam String organization,
			@RequestParam String division) {
		logger.info("Method :operationalHeadData start");

		logger.info("Method :operationalHeadData ends");
		return dashboardDao.operationalHeadData(fromDate,toDate,location,organization,division);
	}

	@RequestMapping(value = "ticketByCategory", method = { RequestMethod.GET })
	public JsonResponse<Object> ticketByCategory(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :ticketByCategory start");

		logger.info("Method :ticketByCategory endss");
		return dashboardDao.ticketByCategory(orgName, orgDivision);

	}

	// organisation
	@RequestMapping(value = "getOrganization", method = { RequestMethod.GET })
	public List<DropDownModel> getOrganizationDivision(@RequestParam String orgName) {
		logger.info("Method : getOrganizationDivision starts");

		logger.info("Method : getOrganizationDivision ends");
		return dashboardDao.getOrganization(orgName);
	}

	// organisationDivision
	@RequestMapping(value = "getDivision", method = { RequestMethod.GET })
	public List<DropDownModel> getDivision(@RequestParam String orgName) {
		logger.info("Method : getDivision starts");

		logger.info("Method : getDivision ends");
		return dashboardDao.getDivision(orgName);
	}
}
