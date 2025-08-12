package nirmalya.aatithya.restmodule.his.controller;

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
import nirmalya.aatithya.restmodule.his.dao.HISBedMasterDao;
import nirmalya.aatithya.restmodule.his.model.HISBedMasterRestModel;

@RestController
@RequestMapping(value = { "his" })
public class HISBedMasterRestController {

	Logger logger = LoggerFactory.getLogger(HISBedMasterRestController.class);

	@Autowired
	HISBedMasterDao bedMasterDao;

	/* get bedcategory list */

	@RequestMapping(value = "getbedCategoryType", method = { RequestMethod.GET })
	public List<DropDownModel> getbedCategory() {
		logger.info("Method : getbedCategory starts");

		logger.info("Method : getbedCategory ends");
		return bedMasterDao.getBedCategoryTypeDao();

	}

	/* get getFloorType list */

	@RequestMapping(value = "getFloorType", method = { RequestMethod.GET })
	public List<DropDownModel> getFloorType() {
		logger.info("Method : getFloorType starts");

		logger.info("Method : getFloorType ends");
		return bedMasterDao.getFloorTypeDao();
	}
	
	@RequestMapping(value = "getDepartmentList", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList() {
		logger.info("Method : getDepartmentList starts");

		logger.info("Method : getDepartmentList ends");
		return bedMasterDao.getDepartmentList();
	}

	/* get wardList */

	@RequestMapping(value = "rest-ward-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getwardList(@RequestParam String id) {
		logger.info("Method : getwardList method starts" + id);
		logger.info("Method : getwardList method ends");
		return bedMasterDao.getWardListDao(id);
	}

	/* add */

	@RequestMapping(value = "rest-bed-mstr-add", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addMaster(@RequestBody HISBedMasterRestModel restData) {
		logger.info("Method : addMaster starts"/* +restData */);

		logger.info("Method : addMaster ends");
		return bedMasterDao.addBedMasterDao(restData);
	}

	/* view */

	@GetMapping(value = "rest-bed-mstr-view")
	public JsonResponse<List<HISBedMasterRestModel>> viewMaster() {
		logger.info("Method : viewMaster starts");

		logger.info("Method : viewMaster ends");
		return bedMasterDao.viewBedMasterDao();
	}

	/* edit */

	@RequestMapping(value = "rest-bed-mstr-edit", method = { RequestMethod.GET })
	public JsonResponse<HISBedMasterRestModel> editMaster(@RequestParam String id, String orgName, String orgDivision,
			String uId) {
		logger.info("Method : editMaster rest starts");

		logger.info("Method :editMaster rest ends");
		return bedMasterDao.editBedMasterDao(id, orgName, orgDivision, uId);
	}

	/* delete */

	@RequestMapping(value = "deleteBed", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteBed(@RequestParam String id) {
		logger.info("Method : deleteBed  starts");

		logger.info("Method : deleteBed  ends");
		return bedMasterDao.deleteBed(id);
	}

}
