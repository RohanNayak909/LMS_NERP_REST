package nirmalya.aatithya.restmodule.samudyamproduction.controller;

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
import nirmalya.aatithya.restmodule.samudyamproduction.dao.RestMouldMasterDao;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestCheckingDetailsModel;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestMouldMasterModel;


@RestController
@RequestMapping("production/")
public class RestMouldMasterController {
	
	Logger logger = LoggerFactory.getLogger(RestMouldMasterController.class);
	@Autowired
	RestMouldMasterDao RestMouldMasterDao;
	//getPatternTypeList
	@GetMapping(value = "get-pattern-type-list")
	public List<DropDownModel> getPatternTypeList(@RequestParam String org,String orgDiv) {
		logger.info("Method : getPatternTypeList starts");

		logger.info("Method : getPatternTypeList ends");
		return RestMouldMasterDao.getPatternTypeList(org,orgDiv);
	}
	//getMoldTypeList
	@GetMapping(value = "get-mold-type-list")
	public List<DropDownModel> getMoldTypeList(@RequestParam String org,String orgDiv) {
		logger.info("Method : getMoldTypeList starts");

		logger.info("Method : getMoldTypeList ends");
		return RestMouldMasterDao.getMoldTypeList(org,orgDiv);
	}
	//viewCheckingDetailsType
	@RequestMapping(value = "checking-detailstype-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestCheckingDetailsModel>>> viewCheckingDetailsType(@RequestParam String org,String orgDiv) {
		logger.info("Method : viewCheckingDetailsType starts");

		logger.info("Method : viewCheckingDetailsType ends");
		return RestMouldMasterDao.viewCheckingDetailsType(org,orgDiv);
	}
	//restAddMoldMaster
	@PostMapping(value = "rest-add-molddetails")
	public ResponseEntity<JsonResponse<List<RestMouldMasterModel>>> restAddMoldMaster(
			@RequestBody RestMouldMasterModel moldModel) {
		logger.info("Method : restAddMoldMaster starts");
		logger.info("Method : restAddMoldMaster ends");
		return RestMouldMasterDao.restAddMoldMaster(moldModel);
	}
//ViewMoldMasterView	
	@RequestMapping(value = "mold-master-data-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestMouldMasterModel>>> ViewMoldMasterView(@RequestParam String org,String orgDiv) {
		logger.info("Method : ViewMoldMasterView starts");

		logger.info("Method : ViewMoldMasterView ends");
		return RestMouldMasterDao.ViewMoldMasterView(org,orgDiv);
	}
//editMoldMaster
	@GetMapping(value = "rest-edit-moldmaster")
	public RestMouldMasterModel editMoldMaster(@RequestParam String id) {
		logger.info("Method : editMoldMaster starts");

		logger.info("Method : editMoldMaster ends");
		return RestMouldMasterDao.editMoldMaster(id);
	}
	// delete Mold Master
	@GetMapping(value = "delete-moldMaster")
	public JsonResponse<Object> deleteMoldMaster(@RequestParam String mlid, String org,String orgDiv) {
		logger.info("Method : deleteMoldMaster starts");

		logger.info("Method : deleteMoldMaster ends");
		return RestMouldMasterDao.deleteMoldMaster(mlid,org,orgDiv);
	}
 
}
