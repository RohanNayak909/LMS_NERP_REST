package nirmalya.aatithya.restmodule.account.controller;

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

import nirmalya.aatithya.restmodule.account.dao.RestAccountCreditorsLedgerDao;
import nirmalya.aatithya.restmodule.account.model.RestAccountCreditorLedgerModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestAccountCreditorsLedgerController {

	Logger logger = LoggerFactory.getLogger(RestAccountCreditorsLedgerController.class);
	@Autowired
	RestAccountCreditorsLedgerDao restAccountCreditorsLedgerDao;

	@RequestMapping(value = "viewCreditorsLedger", method = { RequestMethod.GET })
	public JsonResponse<Object> defectRate(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :defectRate start");

		logger.info("Method :defectRate endss");
		return restAccountCreditorsLedgerDao.viewCreditLedger(orgName, orgDivision);
	}

	// creditorsLedgerFilter

	@RequestMapping(value = "creditorsLedgerFilter", method = { RequestMethod.GET })
	public JsonResponse<Object> defectRate(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String financialYear, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :creditorsLedgerFilter start");

		logger.info("Method :creditorsLedgerFilter endss");
		return restAccountCreditorsLedgerDao.creditorsLedgerFilter(orgName, orgDivision, financialYear, fromDate,
				toDate);
	}

	// getVendorNameAutoList

	@GetMapping(value = "getVendorNameAutoList")
	public ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> getVendorNameAutoList(
			@RequestParam String id) {
		logger.info("Method : getVendorNameAutoList starts");

		logger.info("Method :getVendorNameAutoList endss");
		return restAccountCreditorsLedgerDao.getVendorAutoList(id);
	}

	// vendorCreditorLedgerPdf

	@GetMapping(value = "vendorCreditorsLedgerPdf")
	public ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> vendorCreditorLedgerPdf(
			@RequestParam String fromDate, String toDate,String id) {
		logger.info("Method :vendorCreditorLedgerPdf starts");

		logger.info("Method :vendorCreditorLedgerPdf ends" + id);
		return restAccountCreditorsLedgerDao.vendorCreditorLedgerPdf(id,fromDate,toDate);
	}
}
