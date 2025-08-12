package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.RestAccountVoucherTypesDao;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@RestController
@RequestMapping(value = "account")
public class RestAccountVoucherTypesController {
	Logger logger = LoggerFactory.getLogger(RestAccountVoucherTypesController.class);
	@Autowired
	RestAccountVoucherTypesDao restAccountVoucherTypesDao;
	
	//Auto search ledger 
	@GetMapping(value = "rest-getLedgerListSearch")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getLedgerListSearch(
			@RequestParam String id,@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method : getLedgerListSearch starts");

		logger.info("Method :getLedgerListSearch endss");
		return restAccountVoucherTypesDao.getLedgerListSearch(id,orgName,orgDivision);
	}
	
	@RequestMapping(value = "rest-voucherTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> voucherTypeList(@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method : voucherTypeList starts");

		logger.info("Method : voucherTypeList ends");
		return restAccountVoucherTypesDao.voucherTypeList(orgName,orgDivision);
	}
	
	@RequestMapping(value = "voucherTypesAdd", method = { RequestMethod.POST })
	public JsonResponse<Object> voucherTypesAdd(@RequestBody String obj,@RequestParam String orgName,@RequestParam String orgDivision,@RequestParam String userId,@RequestParam String voucherId) {
		logger.info("Method :voucherTypesAdd----" + obj);

		logger.info("Method :voucherTypesAdd ends");
		return restAccountVoucherTypesDao.voucherTypesAdd(obj,orgName,orgDivision,userId,voucherId);
	}
	
	// view ag grid voucher types
	@RequestMapping(value = "restViewVoucherTypes", method = { RequestMethod.GET })
	public JsonResponse<Object> restViewVoucherTypes(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :restViewVoucherTypes start");

		logger.info("Method :restViewVoucherTypes endss");
		return restAccountVoucherTypesDao.restViewVoucherTypes(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-editVoucherType", method = { RequestMethod.GET })
	public JsonResponse<Object> editVoucherTypeFilteredData(@RequestParam String orgName, String orgDivision, String id) {
		logger.info("Method :editVoucherTypeFilteredData start");

		logger.info("Method :editVoucherTypeFilteredData endss");
		return restAccountVoucherTypesDao.editVoucherTypeFilteredData(orgName, orgDivision, id);

	}
	
	
	@RequestMapping(value = "restDeleteVoucherId", method = { RequestMethod.GET })
	public JsonResponse<Object> restDeleteVoucherId(@RequestParam String orgName, String orgDivision, String id) {
		logger.info("Method :restDeleteVoucherId start");

		logger.info("Method :restDeleteVoucherId endss");
		return restAccountVoucherTypesDao.deleteVoucherType(orgName, orgDivision, id);

	}
}
