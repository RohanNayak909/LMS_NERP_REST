package nirmalya.aatithya.restmodule.qa.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.qa.dao.QaSpotDao;
import nirmalya.aatithya.restmodule.qa.dao.QcPcroDao;
import nirmalya.aatithya.restmodule.qa.model.QaPcroRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaSpotRestModel;

@RestController
@RequestMapping(value = { "production/" })
public class QaSpotRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	QaSpotDao qaSpotDao;
	
	// editPCRO
	@RequestMapping(value = "rest-spot-check-show-aggrid", method = { RequestMethod.GET })
	public JsonResponse<Object> spotAggridView(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :spotAggridView start");

		logger.info("Method :spotAggridView endss");
		return qaSpotDao.spotAggridView(id, orgName, orgDivision);
	}
	// addPCRO
	@PostMapping(value = "rest-spot-check-details-add")
	public ResponseEntity<JsonResponse<List<QaSpotRestModel>>> addQc(

			@RequestBody List<QaSpotRestModel> qaSpotRestModel) {
		logger.info("Method : restaddQc starts");
		logger.info("Method : restaddQc ends");
		return qaSpotDao.addSpot(qaSpotRestModel);
	}
	
	// viewMain
	@RequestMapping(value = "rest-spot-check--details-view", method = { RequestMethod.GET })
	public JsonResponse<Object> getTotalSpotView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getTotalView start");

		logger.info("Method :getTotalView endss");
		return qaSpotDao.getTotalSpotView(orgName, orgDivision);
	}

	// editSpotView
	@RequestMapping(value = "rest-spot-check-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editSpot(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editSpot start");

		logger.info("Method :editSpot endss");
		return qaSpotDao.editSpotView(id, orgName, orgDivision);
	}
	// deleteSpot
	@RequestMapping(value = "rest-spot-check-detls-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSpot(@RequestParam String id, String org, String div) {
		logger.info("Method : deleteSpot starts");

		logger.info("Method : deleteSpot ends");
		return qaSpotDao.deleteSpot(id, org, div);

	}


	// approvePcro
	@RequestMapping(value = "rest-spot-check-detls-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> restapproveSpot(@RequestParam String id, String org, String div) {
		logger.info("Method : restapproveSpot starts");

		logger.info("Method : restapproveSpot ends");
		return qaSpotDao.approveSpot(id, org, div);

	}
	
	// downloadPdfSpotView
	@RequestMapping(value = "rest-spot-check-download", method = { RequestMethod.GET })
	public JsonResponse<Object> downloadSpot(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :downloadSpot start");

		logger.info("Method :downloadSpot endss");
		return qaSpotDao.downlaodSpotPdf(id, orgName, orgDivision);
	}
	
	//addchild
	
	@RequestMapping(value = "rest-spot-check-detailsname-add", method = { RequestMethod.GET })
	public JsonResponse<Object> addNameAddition(@RequestParam String add,String skg , String product,String org, String orgDiv) {
		logger.info("Method :addNameAddition start");

		logger.info("Method :addNameAddition endss");
		return qaSpotDao.addNameAddition(add,skg,product,org, orgDiv);
	}


}