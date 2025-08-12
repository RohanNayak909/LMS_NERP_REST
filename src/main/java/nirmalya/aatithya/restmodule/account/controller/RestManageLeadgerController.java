package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

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

import nirmalya.aatithya.restmodule.account.dao.RestManageLeadgerDao;
import nirmalya.aatithya.restmodule.account.model.RestManageLeadgerModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class RestManageLeadgerController {

	Logger logger = LoggerFactory.getLogger(RestManageLeadgerController.class);
	@Autowired
	RestManageLeadgerDao restManageLeadgerDao;

	@RequestMapping(value = "getCountryList", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");
		logger.info("Method : getCountryList ends");
		return restManageLeadgerDao.getCountryList();
	}

	@RequestMapping(value = "getLedgerTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getLedgerTypeList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getLedgerTypeList starts");
		logger.info("Method : getLedgerTypeList ends");
		return restManageLeadgerDao.getLedgerTypeList(org, orgDiv);
	}

	@RequestMapping(value = "getStateList", method = { RequestMethod.GET })
	public List<DropDownModel> getStateList() {

		logger.info("Method : getStateList starts");
		logger.info("Method : getStateList ends");

		return restManageLeadgerDao.getStateLists();
	}

	// add
	@RequestMapping(value = "resaddledger", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addLedger(@RequestBody RestManageLeadgerModel LedgerDetails) {
		logger.info("Method : addrestLedger starts");

		logger.info("Method : addrestLedger  ends");
		return restManageLeadgerDao.addLedgerDetails(LedgerDetails);
	}

	/// view
	@RequestMapping(value = "restViewleadger", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> restViewLeadgerDetails(
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method: restViewLeadger View Start");

		logger.info("Method: restViewLeadger ends");
		return restManageLeadgerDao.viewLeadger(orgName, orgDivision);
	}

//edit
	@GetMapping(value = "editmanageledger")
	public ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> editmanageleadgerInfo(

			@RequestParam String id, @RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :ResteditLeadger starts");

		logger.info("Method :ResteditLeadger ends" + id);
		return restManageLeadgerDao.editLeadger(id, orgName, orgDivision);

	}

	@RequestMapping(value = "deletemanageLedger", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletemanageleadgerDetails(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : deletemanageleadgerDetails starts" + id);

		logger.info("Method :deletemanageleadgerDetails ends");
		return restManageLeadgerDao.deletemanageleadgerDetails(id, orgName, orgDivision);
	}

	// search
	@GetMapping(value = "getundergrouplist")
	public ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> getProductSearchList(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method : getgroupNameSearchList starts");

		logger.info("Method :getgroupNameSearchList ends");
		return restManageLeadgerDao.getGroupList(id, orgName, orgDiv);
	}

	@RequestMapping(value = "ledgerGetStateLists", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> ledgerGetStateLists(@RequestParam String id) {

		logger.info("Method : ledgerGetStateLists starts");
		logger.info("Method : ledgerGetStateLists ends");

		return restManageLeadgerDao.ledgerGetStateLists(id);
	}

}
