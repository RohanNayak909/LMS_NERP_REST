package nirmalya.aatithya.restmodule.gatepass.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gatepass.dao.GatePassFinalReportDao;

@RestController
@RequestMapping("gatepass/")
public class GatePassFinalReportRestController {
	
	Logger logger = LoggerFactory.getLogger(GatePassFinalReportRestController.class);

	@Autowired
	GatePassFinalReportDao gatePassFinalReportDao;
	
	@RequestMapping(value = "rest-viewGatePassFinalReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewGatePassFinalReportData(@RequestParam String orgName, @RequestParam String orgDivision, String sec , String fromdate, String todate , String type) {
		logger.info("Method :viewGatePassFinalReportData start");

		logger.info("Method :viewGatePassFinalReportData endss");
		return gatePassFinalReportDao.viewGatePassFinalReportData(orgName, orgDivision , sec , fromdate , todate, type);

	}
	
	@RequestMapping(value = "rest-viewGatePassFinalReportDataDload", method = { RequestMethod.GET })
	public JsonResponse<Object> viewGatePassFinalReportDataDload(@RequestParam String orgName, @RequestParam String orgDivision, String sec , String fromdate, String todate , String type) {
		logger.info("Method :viewGatePassFinalReportDataDload start");

		logger.info("Method :viewGatePassFinalReportDataDload endss");
		return gatePassFinalReportDao.viewGatePassFinalReportDataDload(orgName, orgDivision , sec , fromdate , todate, type);

	}
	
	@RequestMapping(value = "rest-viewGatePassFinalReportEntryDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> viewGatePassFinalReportEntryDtls(@RequestParam String orgName, @RequestParam String orgDivision, String id) {
		logger.info("Method :viewGatePassFinalReportEntryDtls start");

		logger.info("Method :viewGatePassFinalReportEntryDtls endss");
		return gatePassFinalReportDao.viewGatePassFinalReportEntryDtls(orgName, orgDivision , id );

	}
	
	@RequestMapping(value = "rest-gateOutDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> viewGatePassFinalReportOutDtls(@RequestParam String orgName, @RequestParam String orgDivision, String id) {
		logger.info("Method :viewGatePassFinalReportOutDtls start");

		logger.info("Method :viewGatePassFinalReportOutDtls endss");
		return gatePassFinalReportDao.viewGatePassFinalReportOutDtls(orgName, orgDivision , id );

	}

}
