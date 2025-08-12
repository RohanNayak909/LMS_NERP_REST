package nirmalya.aatithya.restmodule.grc.controller;

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
import nirmalya.aatithya.restmodule.grc.dao.SBOHIRestDao;
import nirmalya.aatithya.restmodule.grc.model.GRCReportRestModel;
import nirmalya.aatithya.restmodule.maintenance.model.AllotedMaintenanceRestModel;
import nirmalya.aatithya.restmodule.ticket.controller.DepartmentViewRestController;
import nirmalya.aatithya.restmodule.ticket.dao.DepartmentViewDao;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;

@RestController
@RequestMapping("grc/")
public class SBOHIRestController {

	Logger logger = LoggerFactory.getLogger(DepartmentViewRestController.class);

	@Autowired
	SBOHIRestDao sBOHIRestDao;


	@RequestMapping(value = "rest-sbo-hi-report-monthly-emplist", method = { RequestMethod.GET })
	public JsonResponse<Object> getMonthlyEmpList(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getMonthlyEmpList start");

		logger.info("Method :getMonthlyEmpList endss");
		return sBOHIRestDao.getMonthlyEmpList(orgName, orgDivision);
	}
	
	@PostMapping(value = "rest-sbo-hi-report-monthly-add")
	public ResponseEntity<JsonResponse<List<GRCReportRestModel>>> addMonthlyEmpDetails(

			@RequestBody List<GRCReportRestModel> allotedModel) {
		logger.info("Method : addMonthlyEmpDetails starts");
		logger.info("Method : addMonthlyEmpDetails ends");
		return sBOHIRestDao.addMonthlyEmpDetails(allotedModel);
	}
	
	@RequestMapping(value = "rest-sbo-hi-report-monthly-view", method = { RequestMethod.GET })
	public JsonResponse<Object> getMonthlyView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getMonthlyView start");

		logger.info("Method :getMonthlyView endss");
		return sBOHIRestDao.getMonthlyView(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-sbo-hi-report-monthly-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> getMonthlyEdit(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :getMonthlyEdit start");

		logger.info("Method :getMonthlyEdit endss");
		return sBOHIRestDao.getMonthlyEdit(id,orgName, orgDivision);
	}
	
	@RequestMapping(value = "sbo-hi-report-yearly-view", method = { RequestMethod.GET })
	public JsonResponse<Object> getYearlyView(@RequestParam String orgName, String orgDivision,String financialYr) {
		logger.info("Method :getYearlyView start");

		logger.info("Method :getYearlyView endss");
		return sBOHIRestDao.getYearlyView(orgName, orgDivision,financialYr);
	}
	
	@RequestMapping(value = "rest-master-checklist-monthly-emplist", method = { RequestMethod.GET })
	public JsonResponse<Object> getMonthlyMaster(@RequestParam String orgName, String orgDivision,String month,String year) {
		logger.info("Method :getMonthlyMaster start");

		logger.info("Method :getMonthlyMaster endss");
		return sBOHIRestDao.getMonthlyMaster(orgName, orgDivision,month,year);
	}
	
	@PostMapping(value = "rest-master-checklist-monthly-add")
	public ResponseEntity<JsonResponse<List<GRCReportRestModel>>> addMasterChecklistDetails(@RequestBody List<GRCReportRestModel> allotedModel) {
		logger.info("Method : addMasterChecklistDetails starts");
		logger.info("Method : addMasterChecklistDetails ends");
		return sBOHIRestDao.addMasterChecklistDetails(allotedModel);
	}
	
	@RequestMapping(value = "rest-master-checklist-view", method = { RequestMethod.GET })
	public JsonResponse<Object> getMasterChecklistView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getMasterChecklistView start");

		logger.info("Method :getMasterChecklistView endss");
		return sBOHIRestDao.getMasterChecklistView(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-master-checklist-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> getMasterChecklistEdit(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :getMasterChecklistEdit start");

		logger.info("Method :getMasterChecklistEdit endss");
		return sBOHIRestDao.getMasterChecklistEdit(id,orgName, orgDivision);
	}
	@RequestMapping(value = "rest-master-checklist-report", method = { RequestMethod.GET })
	public JsonResponse<Object> getReportView(@RequestParam String orgName, String orgDivision,String financialYr) {
		logger.info("Method :getReportView start");

		logger.info("Method :getReportView endss");
		return sBOHIRestDao.getReportView(orgName, orgDivision,financialYr);
	}
}
