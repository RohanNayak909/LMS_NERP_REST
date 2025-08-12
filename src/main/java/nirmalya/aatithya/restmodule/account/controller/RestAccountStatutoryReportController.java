package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.RestAccountStatutoryReportDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountStatutoryReportController {
	Logger logger = LoggerFactory.getLogger(RestAccountStatutoryReportController.class);
	@Autowired
	RestAccountStatutoryReportDao restAccountStatutoryReportDao;
	
	@RequestMapping(value = "rest-viewTdsFilteredData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewTdsFilteredData(@RequestParam String orgName, String orgDivision, String fromDate, String toDate, String tdsLedgerId,String activeStatus) {
		logger.info("Method :viewTdsFilteredData start");

		logger.info("Method :viewTdsFilteredData endss");
		return restAccountStatutoryReportDao.viewTdsFilteredData(orgName, orgDivision, fromDate, toDate, tdsLedgerId,activeStatus);

	}
	
	@RequestMapping(value = "rest-getTdsReceivableLedgerList", method = { RequestMethod.GET })
	public List<DropDownModel> getTdsReceivableLedgerList(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getTdsReceivableLedgerList starts");

		logger.info("Method : getTdsReceivableLedgerList ends");
		return restAccountStatutoryReportDao.getTdsReceivableLedgerList(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-getTdsPayableLedgerList", method = { RequestMethod.GET })
	public List<DropDownModel> getTdsPayableLedgerList(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : getTdsPayableLedgerList starts");
		
		logger.info("Method : getTdsPayableLedgerList ends");
		return restAccountStatutoryReportDao.getTdsPayableLedgerList(orgName, orgDivision);
	}

}
