package nirmalya.aatithya.restmodule.productionplan.controller;



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


import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.productionplan.dao.PackingDetailsDao;
import nirmalya.aatithya.restmodule.productionplan.model.PackingDetailsRestModel;


@RestController
@RequestMapping(value = "production/")

public class PackingDetailsRestController {
	
	Logger logger = LoggerFactory.getLogger(PackingDetailsRestController.class);

	@Autowired
	PackingDetailsDao packingDetailsDao;
	
	@RequestMapping(value = "rest-viewPackingDetailsData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewMfgProcessingData(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewPackingDetailsData start");

		logger.info("Method :viewPackingDetailsData endss");
		return packingDetailsDao.viewPackingDetailsData(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-machineDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> machineDtls(@RequestParam String id,String bId,String pId ,String orgName, String orgDivision,String shift, String date) {
		logger.info("Method :machineDtls start");

		logger.info("Method :machineDtls endss");
		return packingDetailsDao.machineDtls(id , bId , pId , orgName, orgDivision,shift,date);
	}
	
	
	
	@PostMapping(value = "rest-addPackingDetails")
	public ResponseEntity<JsonResponse<Object>> addPackingDetails(@RequestBody PackingDetailsRestModel addPackingDetails) {
		logger.info("Method : addPackingDetails starts");

		logger.info("Method : addPackingDetails ends");
		return packingDetailsDao.addPackingDetails(addPackingDetails);
	}
	
	@RequestMapping(value = "rest-processMfgDetailsPdfView", method = { RequestMethod.GET })
	public JsonResponse<Object> processMfgDetailsPdfView(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :processMfgDetailsPdfView start");

		logger.info("Method :processMfgDetailsPdfView endss");
		return packingDetailsDao.processMfgDetailsPdfView(id, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-packingDetailsPdfView", method = { RequestMethod.GET })
	public JsonResponse<Object> packingDetailsPdfView(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :packingDetailsPdfView start");

		logger.info("Method :packingDetailsPdfView endss");
		return packingDetailsDao.packingDetailsPdfView(id, orgName, orgDivision);
	}
	
	//Approve
	
	@GetMapping(value = "rest-packingDataApprove")
	public ResponseEntity<JsonResponse<Object>> packingDataApprove(@RequestParam String id, String userId ,String orgName, String orgDivision) {
		logger.info("Method : packingDataApprove starts");
		logger.info("Method : packingDataApprove ends");
		return packingDetailsDao.packingDataApprove(id, userId ,orgName, orgDivision);
	}
	
	// item-data
	
	@GetMapping(value = "rest-itemDetailsView")
	public ResponseEntity<JsonResponse<Object>> itemDetailsView(@RequestParam String id,String amt,String planId,String orgName, String orgDivision) {
		logger.info("Method : itemDetailsView starts");
		logger.info("Method : itemDetailsView ends");
		return packingDetailsDao.itemDetailsView(id, amt, planId, orgName, orgDivision);
	}

}
