package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.GlobalRestDao;
import nirmalya.aatithya.restmodule.master.model.DateFormatModel;
import nirmalya.aatithya.restmodule.master.model.FiscalYearModel;
import nirmalya.aatithya.restmodule.master.model.GlobalMasterRestModel;
import nirmalya.aatithya.restmodule.master.model.YearMasterModel;

@RestController
@RequestMapping(value = "master")
public class GlobalMasterRestController {

	Logger logger = LoggerFactory.getLogger(GlobalMasterRestController.class);

	@Autowired
	GlobalRestDao globalrestdao;
	@Autowired
	EntityManager em;

	@RequestMapping(value = "viewGlobalMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewGlobalMaster() {
		logger.info("Method : viewGlobalMaster starts");

		logger.info("Method : viewGlobalMaster ends");
		return globalrestdao.viewGlobalMaster();
	}

	@RequestMapping(value = "addGlobalMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addGlobalMaster(
			@RequestBody GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addGlobalMaster starts");

		logger.info("Method : addGlobalMaster ends");
		return globalrestdao.addGlobalMaster(globalMasterRestModel);
	}

	@RequestMapping(value = "deleteGlobalMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteGlobalMaster(@RequestParam String id) {
		logger.info("Method : deleteGlobalMaster starts");

		logger.info("Method : deleteGlobalMaster ends");
		return globalrestdao.deleteGlobalMaster(id);
	}

	@RequestMapping(value = "deleteFiscalyear", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteFiscalyear(@RequestParam String id) {
		logger.info("Method : deleteFiscalyear starts");

		logger.info("Method : deleteFiscalyear ends");
		return globalrestdao.deleteFiscalyear(id);
	}

	@RequestMapping(value = "changeDateFormat", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<DateFormatModel>> changeDateFormat(@RequestParam String id,
			@RequestParam String userId) {
		logger.info("Method : changeDateFormat starts");

		logger.info("Method : changeDateFormat ends");
		return globalrestdao.changeDateFormat(id, userId);
	}

	@RequestMapping(value = "addFiscalyear", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addFiscalyear(@RequestBody FiscalYearModel id) {
		logger.info("Method : addFiscalyear starts");

		logger.info("Method : addFiscalyear ends");
		return globalrestdao.addFiscalyear(id);
	}

	@RequestMapping(value = "addCalenedarYear", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addCalenedarYear(@RequestBody YearMasterModel id) {
		logger.info("Method : addCalenedarYear starts");

		logger.info("Method : addCalenedarYear ends");
		return globalrestdao.addCalenedarYear(id);
	}

	@RequestMapping(value = "getFiscalYearList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<FiscalYearModel>>> getFiscalYearList() {
		logger.info("Method : getFiscalYearList starts");

		logger.info("Method : getFiscalYearList ends");
		return globalrestdao.getFiscalYearList();
	}

	@RequestMapping(value = "viewOnclickState", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewOnclickState(@RequestParam String id) {
		logger.info("Method : viewOnclickState starts");

		logger.info("Method : viewOnclickState ends");
		return globalrestdao.viewOnclickState(id);
	}

	@RequestMapping(value = "addStateMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addStateMaster(
			@RequestBody GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addStateMaster starts");

		logger.info("Method : addStateMaster ends");
		return globalrestdao.addStateMaster(globalMasterRestModel);
	}

	@RequestMapping(value = "viewStateMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewStateMaster() {
		logger.info("Method : viewStateMaster starts");

		logger.info("Method : viewStateMaster ends");
		return globalrestdao.viewStateMaster();
	}

	@RequestMapping(value = "deleteStateMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteStateMaster(@RequestParam String id) {
		logger.info("Method : deleteStateMaster starts");

		logger.info("Method : deleteStateMaster ends");
		return globalrestdao.deleteStateMaster(id);
	}

	@RequestMapping(value = "viewOnclickDistrict", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewOnclickDistrict(@RequestParam String id) {
		logger.info("Method : viewOnclickDistrict starts");

		logger.info("Method : viewOnclickDistrict ends");
		return globalrestdao.viewOnclickDistrict(id);
	}

	@RequestMapping(value = "addDistrictMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDistrictMaster(
			@RequestBody GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addDistrictMaster starts");

		logger.info("Method : addDistrictMaster ends");
		return globalrestdao.addDistrictMaster(globalMasterRestModel);
	}

	@RequestMapping(value = "viewDistrictMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewDistrictMaster() {
		logger.info("Method : viewDistrictMaster starts");

		logger.info("Method : viewDistrictMaster ends");
		return globalrestdao.viewDistrictMaster();
	}

	@RequestMapping(value = "deleteDistrictMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDistrictMaster(@RequestParam String id) {
		logger.info("Method : deleteDistrictMaster starts");

		logger.info("Method : deleteDistrictMaster ends");
		return globalrestdao.deleteDistrictMaster(id);
	}

	@RequestMapping(value = "viewOnclickCity", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewOnclickCity(@RequestParam String id) {
		logger.info("Method : viewOnclickCity starts");

		logger.info("Method : viewOnclickCity ends");
		return globalrestdao.viewOnclickCity(id);
	}

	@RequestMapping(value = "addCityMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addCityMaster(
			@RequestBody GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addCityMaster starts");
		logger.info("Method : addCityMaster ends");
		return globalrestdao.addCityMaster(globalMasterRestModel);
	}

	@RequestMapping(value = "viewCityMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewCityMaster() {
		logger.info("Method : viewCityMaster starts");

		logger.info("Method : viewCityMaster ends");
		return globalrestdao.viewCityMaster();
	}

	@RequestMapping(value = "deleteCityMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCityMaster(@RequestParam String id) {
		logger.info("Method : deleteCityMaster starts");

		logger.info("Method : deleteCityMaster ends");
		return globalrestdao.deleteCityMaster(id);
	}

	@RequestMapping(value = "getDateFormatTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getDateFormatTypeList() {
		logger.info("Method : getDateFormatTypeList starts");

		logger.info("Method : getDateFormatTypeList ends");
		return globalrestdao.getDateFormatTypeList();
	}

	@RequestMapping(value = "viewYearListMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<YearMasterModel>>> viewYearListMaster() {
		logger.info("Method : viewYearListMaster starts");

		logger.info("Method : viewYearListMaster ends");
		return globalrestdao.viewYearListMaster();
	}

	@PostMapping(value = "addCityMasterList")
	public ResponseEntity<JsonResponse<Object>> addCityMasterList(
			@RequestBody List<GlobalMasterRestModel> globalMasterRestModelList) {
		logger.info("Method : addCityMasterList starts");
		logger.info("Method : addCityMasterList ends");
		return globalrestdao.addCityMasterList(globalMasterRestModelList);
	}

	@PostMapping(value = "addCountryMasterList")
	public ResponseEntity<JsonResponse<Object>> addCountryMasterList(
			@RequestBody List<GlobalMasterRestModel> globalMasterRestModelList) {
		logger.info("Method : addCountryMasterList starts");
		logger.info("Method : addCountryMasterList ends");
		return globalrestdao.addCountryMasterList(globalMasterRestModelList);
	}

	@PostMapping(value = "addStateMasterList")
	public ResponseEntity<JsonResponse<Object>> addStateMasterList(
			@RequestBody List<GlobalMasterRestModel> globalMasterRestModelList) {
		logger.info("Method : addStateMasterList starts");
		logger.info("Method : addStateMasterList ends");
		return globalrestdao.addStateMasterList(globalMasterRestModelList);
	}

	@PostMapping(value = "addDistMasterList")
	public ResponseEntity<JsonResponse<Object>> addDistMasterList(
			@RequestBody List<GlobalMasterRestModel> globalMasterRestModelList) {
		logger.info("Method : addStateMasterList starts");
		logger.info("Method : addStateMasterList ends");
		return globalrestdao.addStateMasterList(globalMasterRestModelList);
	}
	
	@RequestMapping(value = "viewTotalGlobal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewTotalGlobal() {
		logger.info("Method : viewTotalGlobal starts");

		logger.info("Method : viewTotalGlobal ends");
		return globalrestdao.viewTotalGlobal();
	}
	
}
