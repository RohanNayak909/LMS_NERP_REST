package nirmalya.aatithya.restmodule.property.stakeholder.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.dao.RestStakeholderRentLedgerDao;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderRentLedgerModel;

@RestController
@RequestMapping("property/")
public class RestStakeholderRentLedgerController {

	Logger logger = LoggerFactory.getLogger(RestStakeholderRentLedgerController.class);
	@Autowired
	RestStakeholderRentLedgerDao restManageRentLedgerDao;

////add
	@RequestMapping(value = "rent-ledger-add-RentLedger", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveRentLedger(
			@RequestBody RestStakeholderRentLedgerModel performance) {
		logger.info("$$$$" + performance);
		logger.info("Method : saveRentLedger starts");
		logger.info("restPayroll");
		logger.info("Method : saveRentLedger ends");
		return restManageRentLedgerDao.saveRentLedger(performance);
	}

////view
	@RequestMapping(value = "rent-ledger-viewRentLedger", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> ViewRentLedger(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewRentLedger starts");

		logger.info("Method : ViewRentLedger ends");
		return restManageRentLedgerDao.ViewRentLedger(userid, fromDate, toDate);
	}

	/// edit
	@GetMapping(value = "editRentLedger")
	public ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> editRentLedger(@RequestParam String id) {
		logger.info("Method : editRentLedger starts");

		logger.info("Method :editRentLedger ends" + id);
		return restManageRentLedgerDao.editRentLedger(id);

	}

////delete
	@RequestMapping(value = "rent-ledger-delete-Rent-Ledger", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRentLedger(@RequestParam String id) {
		logger.info("Method :  deleteRentLedger starts" + id);

		logger.info("Method :  deleteRentLedger ends");
		return restManageRentLedgerDao.deleteRentLedger(id);
	}

	@RequestMapping(value = "Rest-manage-rent-ledger", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> viewPropertyPerformance(

			@RequestParam String userid, @RequestParam String fromDate, @RequestParam String toDate) {

		logger.info("Method : viewRentledger starts");

		logger.info("Method : viewRentledger ends" + userid + fromDate + toDate);
		return restManageRentLedgerDao.viewRentledger(userid, fromDate, toDate);
	}
	
	//prime data fro rent ledger with property no
	
	@GetMapping(value = "rentledger-prime-data")
	public ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> rentLedgerPrimeData(@RequestParam String id) {
		logger.info("Method : rentLedgerPrimeData starts"+ id);

		logger.info("Method :rentLedgerPrimeData ends" );
		return restManageRentLedgerDao.rentLedgerPrimeData(id);

	}
	
	@RequestMapping(value = "getmonth-List", method = { RequestMethod.GET })
	public List<DropDownModel> getmonthList() {
		logger.info("Method : getmonthList starts");

		logger.info("Method : getmonthList ends");
		return restManageRentLedgerDao.getmonthList();

	}
	
	@RequestMapping(value = "getyear-List", method = { RequestMethod.GET })
	public List<DropDownModel> getyearList() {
		logger.info("Method : getyearList starts");

		logger.info("Method : getyearList ends");
		return restManageRentLedgerDao.getyearList();

	}
	
	/// edit2
		@GetMapping(value = "editRentLedgers")
		public ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> editRentLedgers(@RequestParam String id) {
			logger.info("Method : editRentLedgers starts");

			logger.info("Method :editRentLedgers ends" + id);
			return restManageRentLedgerDao.editRentLedgers(id);

		}

}
