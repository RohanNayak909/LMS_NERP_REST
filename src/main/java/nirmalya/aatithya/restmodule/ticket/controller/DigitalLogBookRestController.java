package nirmalya.aatithya.restmodule.ticket.controller;

import java.util.List;

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

import nirmalya.aatithya.restmodule.asset.dao.AssetPolicyDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.ticket.dao.DigitalLogBookDao;
import nirmalya.aatithya.restmodule.ticket.model.DigitalLogBookRestModel;

@RestController
@RequestMapping(value = { "ticket/" })
public class DigitalLogBookRestController {

	Logger logger = LoggerFactory.getLogger(DigitalLogBookRestController.class);

	@Autowired
	DigitalLogBookDao logBookDao;

	// add
	@PostMapping(value = "rest-logbook-add")
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addLogBook(

			@RequestBody List<AssetPoilcyRestModel> assetPolicyModel) {
		logger.info("Method : addLogBook starts");
		logger.info("Method : addLogBook ends");
		return logBookDao.addLogBook(assetPolicyModel);
	}

	// view
	@RequestMapping(value = "rest-logbook-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewLogBook(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewLogBook start");

		logger.info("Method :viewLogBook endss");
		return logBookDao.viewLogBook(orgName, orgDivision);
	}

	// edit
	@RequestMapping(value = "rest-logbook-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editLogbook(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editLogbook start");

		logger.info("Method :editLogbook endss");
		return logBookDao.editLogbook(id, orgName, orgDivision);
	}

	// delete
	@RequestMapping(value = "rest-logbook-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteLogbook(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteLogbook starts");

		logger.info("Method : deleteLogbook ends");
		return logBookDao.deleteLogbook(id, org, orgDiv);

	}

	// approve
	@RequestMapping(value = "rest-logbook-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveLogbook(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveLogbook starts");

		logger.info("Method : approveLogbook ends");
		return logBookDao.approveLogbook(id, org, orgDiv);

	}

//ELCB LOGBOOK //
	// dropDown
	
	@RequestMapping(value = "rest-elcbTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> elcbTypeList(@RequestParam String org,String orgDiv ) {
		logger.info("Method : elcbTypeList starts");

		logger.info("Method : elcbTypeList ends");
		return logBookDao.elcbTypeList(org,orgDiv);
	}
	
	
	// add
	@PostMapping(value = "rest-elcblogBook-add")
	public ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>> addelcblogBook(
			@RequestBody List<DigitalLogBookRestModel> assetPolicyModel) {
		logger.info("Method : addelcblogBook starts");
		logger.info("Method : addelcblogBook ends");
		return logBookDao.addelcblogBook(assetPolicyModel);
	}

	// view
	@RequestMapping(value = "rest-elcb-logbook-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewelcblogBook(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewelcblogBook start");

		logger.info("Method :viewelcblogBook endss");
		return logBookDao.viewelcblogBook(orgName, orgDivision);
	}

	// edit
	@RequestMapping(value = "rest-elcblogbook-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editelcblogBook(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editelcblogBook start");

		logger.info("Method :editelcblogBook endss");
		return logBookDao.editelcblogBook(id, orgName, orgDivision);
	}

	//
	@RequestMapping(value = "rest-elcb-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteElcb(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteElcb starts");

		logger.info("Method : deleteElcb ends");
		return logBookDao.deleteElcb(id, org, orgDiv);

	}

	// approve
	@RequestMapping(value = "rest-elcb-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveElcb(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveElcb starts");

		logger.info("Method : approveElcb ends");
		return logBookDao.approveElcb(id, org, orgDiv);

	}

// WASTE OIL TRACKING RECORD //
	// add
	@PostMapping(value = "rest-oilTracking-add")
	public ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>> addOilTrack(
			@RequestBody List<DigitalLogBookRestModel> assetPolicyModel) {
		logger.info("Method : addOilTrack starts");
		logger.info("Method : addOilTrack ends");
		return logBookDao.addOilTrack(assetPolicyModel);
	}

	// view
	@RequestMapping(value = "rest-oilTracking-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewOilTrack(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewOilTrack start");

		logger.info("Method :viewOilTrack endss");
		return logBookDao.viewOilTrack(orgName, orgDivision);
	}

	// edit
	@RequestMapping(value = "rest-oilTracking-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editOilTrack(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editOilTrack start");

		logger.info("Method :editOilTrack endss");
		return logBookDao.editOilTrack(id, orgName, orgDivision);
	}

	//
	@RequestMapping(value = "rest-oilTracking-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteOilTracking(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteOilTracking starts");

		logger.info("Method : deleteOilTracking ends");
		return logBookDao.deleteOilTracking(id, org, orgDiv);

	}

	// approve
	@RequestMapping(value = "rest-oilTracking-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveOilTracking(@RequestParam String id, String org, String orgDiv,
			String userId) {
		logger.info("Method : approveOilTracking starts");

		logger.info("Method : approveOilTracking ends");
		return logBookDao.approveOilTracking(id, org, orgDiv, userId);

	}
//INITIATION/COMPLETION OF NON-ROUTINE ACTIVITY

	// view
	@RequestMapping(value = "rest-viewActivity1", method = { RequestMethod.GET })
	public JsonResponse<Object> viewActivity1(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewActivity1 start");

		logger.info("Method :viewActivity1 endss");
		return logBookDao.viewActivity1(orgName, orgDivision);
	}

	// view
	@RequestMapping(value = "rest-viewActivity2", method = { RequestMethod.GET })
	public JsonResponse<Object> viewActivity2(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewActivity2 start");

		logger.info("Method :viewActivity2 endss");
		return logBookDao.viewActivity2(orgName, orgDivision);
	}

	//
	// view
	@RequestMapping(value = "rest-viewcomplitionRoutine", method = { RequestMethod.GET })
	public JsonResponse<Object> viewcomplitionRoutine(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewcomplitionRoutine start");

		logger.info("Method :viewcomplitionRoutine endss");
		return logBookDao.viewcomplitionRoutine(orgName, orgDivision);
	}

	//
	// add
	@PostMapping(value = "rest-activityAdd")
	public ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>> activityAdd(
			@RequestBody List<DigitalLogBookRestModel> assetPolicyModel) {
		logger.info("Method : activityAdd starts");
		logger.info("Method : activityAdd ends");
		return logBookDao.activityAdd(assetPolicyModel);
	}

	// edit
	@RequestMapping(value = "rest-activity-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editActivity(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editActivity start");

		logger.info("Method :editActivity endss");
		return logBookDao.editActivity(id, orgName, orgDivision);
	}

	//
	@RequestMapping(value = "rest-activity-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteActivity(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteActivity starts");

		logger.info("Method : deleteActivity ends");
		return logBookDao.deleteActivity(id, org, orgDiv);

	}

	// approve
	@RequestMapping(value = "rest-activity-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveActivity(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveActivity starts");

		logger.info("Method : approveActivity ends");
		return logBookDao.approveActivity(id, org, orgDiv);

	}

///////////////////RW and BR LOGBOOK////////////////////////////////////

	// RWandBR add
	@PostMapping(value = "rest-RWandBR-details-add")
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addRWandBRLogBook(

			@RequestBody List<AssetPoilcyRestModel> assetPolicyModel) {
		logger.info("Method : addRWandBRLogBook starts");
		logger.info("Method : addRWandBRLogBook ends");
		return logBookDao.addRWandBRLogBook(assetPolicyModel);
	}

	// RWandBR view
	@RequestMapping(value = "rest-RWandBR-details-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRWandBRLogBook(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewRWandBRLogBook start");

		logger.info("Method :viewRWandBRLogBook endss");
		return logBookDao.viewRWandBRLogBook(orgName, orgDivision);
	}

	// RWandBR delete
	@RequestMapping(value = "rest-RWandBR-details-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRWandBRLogbook(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : deleteRWandBRLogbook starts");

		logger.info("Method : deleteRWandBRLogbook ends");
		return logBookDao.deleteRWandBRLogbook(id, org, orgDiv);

	}

	// RWandBR approve
	@RequestMapping(value = "rest-RWandBR-details-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveRWandBRLogbook(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : approveRWandBRLogbook starts");

		logger.info("Method : approveRWandBRLogbook ends");
		return logBookDao.approveRWandBRLogbook(id, org, orgDiv);

	}

///////////////////RW and BR LOGBOOK////////////////////////////////////

//WRR add
	@PostMapping(value = "rest-WRR-details-add")
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addWRRLogBook(

			@RequestBody List<AssetPoilcyRestModel> assetPolicyModel) {
		logger.info("Method : addWRRLogBook starts");
		logger.info("Method : addWRRLogBook ends");
		return logBookDao.addWRRLogBook(assetPolicyModel);
	}

//RWandBR view
	@RequestMapping(value = "rest-WRR-details-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewWRRLogBook(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewWRRLogBook start");

		logger.info("Method :viewWRRLogBook endss");
		return logBookDao.viewWRRLogBook(orgName, orgDivision);
	}

//RWandBR delete
	@RequestMapping(value = "rest-WRR-details-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteWRRLogbook(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : deleteWRRLogbook starts");

		logger.info("Method : deleteWRRLogbook ends");
		return logBookDao.deleteWRRLogbook(id, org, orgDiv);

	}

//RWandBR approve
	@RequestMapping(value = "rest-WRR-details-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveWRRLogbook(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveWRRLogbook starts");

		logger.info("Method : approveWRRLogbook ends");
		return logBookDao.approveWRRLogbook(id, org, orgDiv);

	}

///////////////////EB LOGBOOK////////////////////////////////////

//WRR add
	@PostMapping(value = "rest-EBReading-details-add")
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addEBReadingLogBook(

			@RequestBody List<AssetPoilcyRestModel> assetPolicyModel) {
		logger.info("Method : addEBReadingLogBook starts");
		logger.info("Method : addEBReadingLogBook ends");
		return logBookDao.addEBReadingLogBook(assetPolicyModel);
	}

//RWandBR view
	@RequestMapping(value = "rest-EBReading-details-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEBReadingLogBook(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewEBReadingLogBook start");

		logger.info("Method :viewEBReadingLogBook endss");
		return logBookDao.viewEBReadingLogBook(orgName, orgDivision);
	}

//RWandBR delete
	@RequestMapping(value = "rest-EBReading-details-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteEBReadingLogbook(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : deleteEBReadingLogbook starts");

		logger.info("Method : deleteEBReadingLogbook ends");
		return logBookDao.deleteEBReadingLogbook(id, org, orgDiv);

	}

//RWandBR approve
	@RequestMapping(value = "rest-EBReading-details-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveEBReadingLogbook(@RequestParam String id, String org,
			String orgDiv) {
		logger.info("Method : approveEBReadingLogbook starts");

		logger.info("Method : approveEBReadingLogbook ends");
		return logBookDao.approveEBReadingLogbook(id, org, orgDiv);

	}
	// view
		@RequestMapping(value = "rest-viewIlluminationData", method = { RequestMethod.GET })
		public JsonResponse<Object> viewIlluminationData(@RequestParam String orgName, String orgDivision) {
			logger.info("Method :viewIlluminationData start");

			logger.info("Method :viewIlluminationData endss");
			return logBookDao.viewIlluminationData(orgName, orgDivision);
		}
		// add 
		@PostMapping(value = "rest-illuminationAdd")
		public ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>> illuminationAdd(
				@RequestBody List<DigitalLogBookRestModel> assetPolicyModel) {
			logger.info("Method : illuminationAdd starts");
			logger.info("Method : illuminationAdd ends");
			return logBookDao.illuminationAdd(assetPolicyModel);
		}
		// view
		@RequestMapping(value = "rest-viewIllumination", method = { RequestMethod.GET })
		public JsonResponse<Object> viewIllumination(@RequestParam String orgName, String orgDivision) {
			logger.info("Method :viewIllumination start");

			logger.info("Method :viewIllumination endss");
			return logBookDao.viewIllumination(orgName, orgDivision);
		}
		
		// edit
		@RequestMapping(value = "rest-editIllumination", method = { RequestMethod.GET })
		public JsonResponse<Object> editIllumination(@RequestParam String id, String orgName, String orgDivision) {
			logger.info("Method :editIllumination start");

			logger.info("Method :editIllumination endss");
			return logBookDao.editIllumination(id, orgName, orgDivision);
		}
		
		@RequestMapping(value = "rest-deleteIllumination", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteIllumination(@RequestParam String id, String org, String orgDiv) {
			logger.info("Method : deleteIllumination starts");

			logger.info("Method : deleteIllumination ends");
			return logBookDao.deleteIllumination(id, org, orgDiv);

		}

		// approve
		@RequestMapping(value = "rest-approveIllumination", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> approveIllumination(@RequestParam String id, String org, String orgDiv) {
			logger.info("Method : approveIllumination starts");

			logger.info("Method : approveIllumination ends");
			return logBookDao.approveIllumination(id, org, orgDiv);

		}
}