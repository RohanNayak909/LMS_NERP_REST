package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestEntityMasterDao;
import nirmalya.aatithya.restmodule.master.dao.RestHrMasterDao;
import nirmalya.aatithya.restmodule.master.model.RestEntityMasterModel;
import nirmalya.aatithya.restmodule.master.model.RestHrMasterModel;

@RestController
@RequestMapping(value = { "master" })
public class RestEntityMasterController {

	Logger logger = LoggerFactory.getLogger(RestEntityMasterController.class);

	@Autowired
	RestEntityMasterDao restEntityMasterDao;

	@RequestMapping(value = "addCostNature", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddJobType(
			@RequestBody RestEntityMasterModel restEntityMasterModel) {
		logger.info("Method : addCostNature starts");

		logger.info("Method : addCostNature ends");
		return restEntityMasterDao.addCostNature(restEntityMasterModel);
	}

	@RequestMapping(value = "viewCostNature", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> viewCostNature(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewCostNature starts");

		logger.info("Method : viewCostNature ends");
		return restEntityMasterDao.viewCostNature(org, orgDiv);
	}

	@RequestMapping(value = "deleteCostNatureType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCostNatureType(@RequestParam String id) {
		logger.info("Method : deleteCostNatureType starts");

		logger.info("Method : deleteCostNatureType ends");
		return restEntityMasterDao.deleteCostNatureType(id);
	}

	@RequestMapping(value = "addCostLabour", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addCostLabour(
			@RequestBody RestEntityMasterModel restEntityMasterModel) {
		logger.info("Method : rest addCostLabour starts");

		logger.info("Method : rest addCostLabour ends");
		return restEntityMasterDao.addCostLabour(restEntityMasterModel);
	}

	@RequestMapping(value = "viewCostLabour", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> viewCostLabour(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest viewCostLabour starts");

		logger.info("Method : rest viewCostLabour ends");
		return restEntityMasterDao.viewCostLabour(org, orgDiv);
	}

	@RequestMapping(value = "deleteCostLabour", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCostLabour(@RequestParam String id) {
		logger.info("Method : deleteCostLabour starts");

		logger.info("Method : deleteCostLabour ends");
		return restEntityMasterDao.deleteCostLabour(id);
	}

	// Vendor Type Master

	@RequestMapping(value = "addVendorCatagory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addVendorCatagory(
			@RequestBody RestEntityMasterModel restEntityMasterModel) {
		logger.info("Method : rest addVendorCatagory starts");

		logger.info("Method : rest addVendorCatagory ends");
		return restEntityMasterDao.addVendorCatagory(restEntityMasterModel);
	}

	@RequestMapping(value = "viewVendorCatagory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> viewVendorCatagory(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest viewVendorCatagory starts");

		logger.info("Method : rest viewVendorCatagory ends");
		return restEntityMasterDao.viewVendorCatagory(org, orgDiv);
	}

	@RequestMapping(value = "deleteVendorCatagory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteVendorCatagory(@RequestParam String id) {
		logger.info("Method : deleteVendorCatagory starts");

		logger.info("Method : deleteVendorCatagory ends");
		return restEntityMasterDao.deleteVendorCatagory(id);
	}

	// Location Type Master

	@RequestMapping(value = "addLocationType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addLocationType(
			@RequestBody RestEntityMasterModel restEntityMasterModel) {
		logger.info("Method : rest addLocationType starts");

		logger.info("Method : rest addLocationType ends");
		return restEntityMasterDao.addLocationType(restEntityMasterModel);
	}

	@RequestMapping(value = "viewLocationType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> viewLocationType(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest viewLocationType starts");

		logger.info("Method : rest viewLocationType ends");
		return restEntityMasterDao.viewLocationType(org, orgDiv);
	}

	@RequestMapping(value = "deleteLocationType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteLocationType(@RequestParam String id) {
		logger.info("Method : deleteLocationType starts");

		logger.info("Method : deleteLocationType ends");
		return restEntityMasterDao.deleteLocationType(id);
	}

	// Room Type Master

	@RequestMapping(value = "addRoomType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addRoomType(@RequestBody RestEntityMasterModel restEntityMasterModel) {
		logger.info("Method : addRoomType starts");

		logger.info("Method : addRoomType ends");
		return restEntityMasterDao.addRoomType(restEntityMasterModel);
	}

	@RequestMapping(value = "viewRoomType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> viewRoomType(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest viewRoomType starts");

		logger.info("Method : rest viewRoomType ends");
		return restEntityMasterDao.viewRoomType(org, orgDiv);
	}

	@RequestMapping(value = "deleteRoomType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRoomType(@RequestParam String id) {
		logger.info("Method : deleteRoomType starts");

		logger.info("Method : deleteRoomType ends");
		return restEntityMasterDao.deleteRoomType(id);
	}

	// Vendor Type Master

	@RequestMapping(value = "getVendorCategoryList", method = { RequestMethod.GET })
	public List<DropDownModel> getVendorCategoryList() {
		logger.info("Method : getVendorCategoryList starts");

		logger.info("Method : getVendorCategoryList ends");
		return restEntityMasterDao.getVendorCategoryList();

	}

	@RequestMapping(value = "addVendorType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddVendorTypeMaster(
			@RequestBody RestEntityMasterModel restEntityMasterModel) {
		logger.info("Method : rest AddVendorTypeMaster starts");

		logger.info("Method : rest AddVendorTypeMaster ends");
		return restEntityMasterDao.addVendorTypeMaster(restEntityMasterModel);
	}

	@RequestMapping(value = "viewVendorType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> viewVendorTypeMaster(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest viewVendorTypeMaster starts");

		logger.info("Method : rest viewVendorTypeMaster ends");
		return restEntityMasterDao.viewVendorTypeMaster(org, orgDiv);
	}

	@RequestMapping(value = "deleteVendorType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteVendorTypeMaster(@RequestParam String id) {
		logger.info("Method : deleteVendorTypeMaster starts");

		logger.info("Method : deleteVendorTypeMaster ends");
		return restEntityMasterDao.deleteVendorTypeMaster(id);
	}

}
