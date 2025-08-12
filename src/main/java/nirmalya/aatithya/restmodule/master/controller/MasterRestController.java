package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.MasterDao;
import nirmalya.aatithya.restmodule.master.model.MasterModel;
import nirmalya.aatithya.restmodule.master.model.MasterWarehouseModel;

@RestController
@RequestMapping(value = { "master" })
public class MasterRestController {
	
	Logger logger = LoggerFactory.getLogger(MasterRestController.class);

	@Autowired
	MasterDao masterDao;
	
	@RequestMapping(value = "getcategorylist", method = { RequestMethod.GET })
	public List<DropDownModel> getCategoryListRest(@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : getCategoryListRest starts");

		logger.info("Method : getCategoryListRest ends");
		return masterDao.getCategoryListDao(organization, orgDivision);
	}
	
	@RequestMapping(value = "getprojectcategorylist", method = { RequestMethod.GET })
	public List<DropDownModel> getprojectcategorylist(@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : getprojectcategorylist starts");
		
		logger.info("Method : getprojectcategorylist ends");
		return masterDao.getprojectcategorylistDao(organization, orgDivision);
	}
	
	@RequestMapping(value = "rest-addmasterdata", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddMasterData(@RequestBody MasterModel masterModel) {
		logger.info("Method : restAddMasterData starts");
		
		logger.info("Method : restAddMasterData ends");
		return masterDao.addMasterDataDao(masterModel);
	}
	
	@RequestMapping(value = "rest-viewmasterdata", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<MasterModel>>> restViewMasterData(@RequestParam String org,
			@RequestParam String orgDiv, @RequestParam String type) {
		logger.info("Method :rest restViewMasterData starts");

		logger.info("Method :rest restViewMasterData ends");
		return masterDao.viewMasterDataDao(org, orgDiv, type);
	}
	
	@RequestMapping(value = "rest-deletemasterdata", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteMasterData(@RequestParam String id, @RequestParam String type,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest deleteMasterData starts");

		logger.info("Method : rest deleteMasterData ends");
		return masterDao.deleteMasterDataDao(id, type, userId, org, orgDiv);
	}
	
	@RequestMapping(value = "rest-getSubCatData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getSubCatDataRest(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest getSubCatDataRest starts");
		
		logger.info("Method : rest getSubCatDataRest ends");
		return masterDao.getSubCatDataDao(id, org, orgDiv);
	}
	
	@RequestMapping(value = "rest-getProjectSubCatData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getProjectSubCatDataRest(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest getProjectSubCatDataRest starts");
		
		logger.info("Method : rest getProjectSubCatDataRest ends");
		return masterDao.getProjectSubCatDataDao(id, org, orgDiv);
	}
	
	@RequestMapping(value = "rest-getConfigData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getConfigDataRest(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest getConfigDataRest starts");
		
		logger.info("Method : rest getConfigDataRest ends");
		return masterDao.getConfigDataDao(org, orgDiv);
	}
	
	@RequestMapping(value = "rest-getWarehouseList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getWarehouseListRest(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest getWarehouseListRest starts");
		
		logger.info("Method : rest getWarehouseListRest ends");
		return masterDao.getWarehouseListDao(org, orgDiv);
	} 
	
	@RequestMapping(value = "rest-getTestListTypeWise", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getTestListTypeWise(@RequestParam String type, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest getTestListTypeWiseRest starts");
		
		logger.info("Method : rest getTestListTypeWiseRest ends");
		return masterDao.getTestListTypeWiseDao(type, org, orgDiv);
	}
	
	@RequestMapping(value = "rest-changePassword", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restChangePassword(@RequestBody DropDownModel data) {
		logger.info("Method : restChangePassword starts");
		
		logger.info("Method : restChangePassword ends");
		return masterDao.restChangePassword(data);
	}
	
	@RequestMapping(value = "rest-getShiftDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getShiftDetails(@RequestParam String dt1, String dt2, String org, String orgDiv, String userId) {
		logger.info("Method : rest getShiftDetails starts");
		
		logger.info("Method : rest getShiftDetails ends");
		return masterDao.getShiftDetails(dt1, dt2, org, orgDiv, userId);
	}
	
	@RequestMapping(value = "rest-getTransactionDocumentNumberingData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getTransactionDocumentNumberingData(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest getTransactionDocumentNumberingData starts");
		
		logger.info("Method : rest getTransactionDocumentNumberingData ends");
		return masterDao.getTransactionDocumentNumberingData(org, orgDiv);
	}
	//modifyTransactionDocumentNumberingData
	@PostMapping(value = "rest-modifyTransactionDocumentNumberingData")
	public ResponseEntity<JsonResponse<Object>> modifyTransactionDocumentNumberingData(@RequestBody String prefixData,
			@RequestParam String userId,String org,String orgDiv) {
		logger.info("Method :modifyTransactionDocumentNumberingData starts");
		logger.info("Method :modifyTransactionDocumentNumberingData endss");
		return masterDao.modifyTransactionDocumentNumberingData(prefixData, userId, org, orgDiv);
	}
//
	@GetMapping(value = "employee-autosearch")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> EmployeeAutoSearchForAttendance(
			@RequestParam String id,String org,String orgDiv) {
		logger.info("Method : EmployeeAutoSearchForAttendance starts");

		logger.info("Method :EmployeeAutoSearchForAttendance endss");
		return masterDao.EmployeeAutoSearch(id,org,orgDiv);
	}
	
	@RequestMapping(value = "rest-viewMasterOffdaysData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> viewMasterOffdaysData(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest viewMasterOffdaysData starts");
		
		logger.info("Method : rest viewMasterOffdaysData ends");
		return masterDao.viewMasterOffdaysData(org, orgDiv);
	}
	 
	@RequestMapping(value = "saveOffDaysMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveOffDaysMaster(@RequestBody MasterWarehouseModel data) {
		logger.info("Method : saveOffDaysMaster starts");
		
		logger.info("Method : saveOffDaysMaster ends");
		return masterDao.saveOffDaysMaster(data);
	}
	
	@RequestMapping(value = "rest-deleteMasterOffDaysData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteMasterOffDaysData(@RequestParam String id,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest deleteMasterOffDaysData starts");

		logger.info("Method : rest deleteMasterOffDaysData ends");
		return masterDao.deleteMasterOffDaysData(id, userId, org, orgDiv);
	}
	
	@RequestMapping(value = "rest-viewHolidayList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> viewHolidayList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest viewHolidayList starts");
		
		logger.info("Method : rest viewHolidayList ends");
		return masterDao.viewHolidayList(org, orgDiv);
	}
	@RequestMapping(value = "rest-viewPModeList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> viewPModeList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest viewPModeList starts");
		
		logger.info("Method : rest viewPModeList ends");
		return masterDao.viewPModeList(org, orgDiv);
	}
	@RequestMapping(value = "rest-viewSac", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> viewSac(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest viewSac starts");
		
		logger.info("Method : rest viewSac ends");
		return masterDao.viewSac(org, orgDiv);
	}
}
