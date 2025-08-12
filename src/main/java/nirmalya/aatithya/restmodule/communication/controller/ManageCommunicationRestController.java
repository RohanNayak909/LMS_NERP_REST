package nirmalya.aatithya.restmodule.communication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.communication.dao.ManageCommunicationRestDao;
import nirmalya.aatithya.restmodule.communication.model.ManageCommunicationRestModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "communication/")
public class ManageCommunicationRestController {

	Logger logger = LoggerFactory.getLogger(ManageCommunicationRestController.class);

	@Autowired
	ManageCommunicationRestDao commRestDao;

	@GetMapping(value = "getCountryList")
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");

		logger.info("Method : getCountryList ends");
		return commRestDao.getCountryList();
	}

	@GetMapping(value = "getDepartmentList")
	public List<DropDownModel> getDeptList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getDeptList starts");

		logger.info("Method : getDeptList ends");
		return commRestDao.getDeptList(org, orgDiv);
	}

	@GetMapping(value = "getStateList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateList(@RequestParam String id) {
		logger.info("Method : getStateList starts");

		logger.info("Method : getStateList ends");
		return commRestDao.getStateList(id);
	}

	@GetMapping(value = "getCityList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCityList(@RequestParam String id) {
		logger.info("Method : getCityList starts");

		logger.info("Method : getCityList ends");
		return commRestDao.getCityList(id);
	}

	@PostMapping(value = "add-dispatch-details")
	public JsonResponse<Object> addDispatchDetails(

			@RequestBody ManageCommunicationRestModel assetMasterModel) {
		logger.info("Method : addDispatchDetails starts");

		logger.info("Method : addDispatchDetails ends");
		return commRestDao.addDispatchDetailsDao(assetMasterModel);
	}

	@PostMapping(value = "add-receive-details")
	public JsonResponse<Object> addReceiveDetails(

			@RequestBody ManageCommunicationRestModel assetMasterModel) {
		logger.info("Method : addReceiveDetails starts");

		logger.info("Method : addReceiveDetails ends");
		return commRestDao.addReceiveDetailsDao(assetMasterModel);
	}


	@GetMapping(value = "rest-get-all-data")
	public JsonResponse<Object> getAllData(@RequestParam String orgName, String orgDivision, String pageno , String type) {
		logger.info("Method :getAllData start");

		logger.info("Method :getAllData endss");
		return commRestDao.getAllData(orgName, orgDivision, pageno, type);

	}
	
	
	@GetMapping(value = "rest-get-edit-data")
	public JsonResponse<Object> getDataForEdit(@RequestParam String orgName, String orgDivision, String regNo) {
		logger.info("Method :getDataForEdit start");
		
		logger.info("Method :getDataForEdit endss");
		return commRestDao.getDataForEdit(orgName, orgDivision, regNo);
		
	}
	
	@GetMapping(value = "rest-get-edit-dispatch")
	public JsonResponse<Object> getDataForDispatch(@RequestParam String orgName, String orgDivision, String regNo) {
		logger.info("Method :getDataForDispatch start");
		
		logger.info("Method :getDataForDispatch endss");
		return commRestDao.getDataForDispatch(orgName, orgDivision, regNo);
		
	}
	
	@GetMapping(value = "delete-communication-data")
	public ResponseEntity<JsonResponse<Object>> deleteCommunicationData(@RequestParam String id, String org,
			String orgDivision, String userId) {
		logger.info("Method : deleteCommunicationData starts");

		logger.info("Method : deleteCommunicationData ends");
		return commRestDao.deleteCommunicationData(id, org, orgDivision, userId);
	}

	// Attachemnt View

		@GetMapping(value = "rest-view-attachment")
		public JsonResponse<Object> attachemntView(@RequestParam String id, @RequestParam String orgName,
				@RequestParam String orgDivision) {
			logger.info("Method :attachemntView start");

			logger.info("Method :attachemntView endss");
			return commRestDao	.attachemntDaoView(id, orgName, orgDivision);
		}
}
