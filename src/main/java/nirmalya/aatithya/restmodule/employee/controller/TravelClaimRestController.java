package nirmalya.aatithya.restmodule.employee.controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.TravelClaimRestDao;
import nirmalya.aatithya.restmodule.employee.model.TravelClaimRestModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.util.DocumentUpload;


@RestController
@RequestMapping(value = { "employee/" })
public class TravelClaimRestController {
	Logger logger = LoggerFactory.getLogger(TravelClaimRestController.class);
	
	@Autowired
	TravelClaimRestDao travelClaimRestDao;

	@Autowired
	DocumentUpload documentUpload;
	
	/*
	 * view travel claim employee list data
	 */
	@PostMapping(value = "travel-claim-employee")
	public JsonResponse<List<TravelClaimRestModel>> viewTravelClaim(@RequestBody EmpRoleModel empModel) {
		logger.info("Method : viewTravelClaim starts");

		String userId = empModel.getUserId();
		String organization = empModel.getOrganization();
		String orgDivision = empModel.getOrgDivision();
		List<String> roleList = empModel.getUserRole();

		String userRole = "";
		if (roleList.size() > 0) {
			for (String m : roleList) {
				if (empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole + "\"" + m + "\",";
				}
			}
		}
		if (userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}
		
		logger.info("Method : viewTravelClaim ends");
		return travelClaimRestDao.viewTravelClaim(userId, userRole,organization,orgDivision);
	}
	
	
	/*
	 * view travel claim edit
	 */
	@GetMapping(value = "get-travel-claim-edit")
	public JsonResponse<List<TravelClaimRestModel>> travelClaimEdit(@RequestParam String id) {
		logger.info("Method : travelClaimEdit starts");
		logger.info("Method : travelClaimEdit endss");
		return travelClaimRestDao.getTravelClaimEdit(id);
	}
	/*
	 * add travel claim 
	 */
	@PostMapping(value = "add-travelclaim-others")
	public ResponseEntity<JsonResponse<Object>> addTravelClaimOther(@RequestBody  TravelClaimRestModel travelClaimRestModel) {
		logger.info("Method : addTravelClaimOther starts");

		logger.info("Method : addTravelClaimOther ends");
		return travelClaimRestDao.addTravelClaimOther(travelClaimRestModel);
	}
	/*
	 * view travel employee other 
	 */
	@RequestMapping(value = "get-claim-other", method = { RequestMethod.GET })
	JsonResponse<List<TravelClaimRestModel>> viewTravelClaimOther(@RequestParam String id) {
		logger.info("Method : viewTravelClaimOther start");

		logger.info("Method : viewTravelClaimOther ends");
		return travelClaimRestDao.viewTravelClaimOther(id);
	}
	
	/*
	 * add travel claim api
	 */
	@PostMapping(value = "add-travelclaim-others-api", headers = "content-type=multipart/*", consumes = {
			"application/*" })
	public ResponseEntity<JsonResponse<Object>> addTravelClaimOtherApi(TravelClaimRestModel travelClaimRestModel) {
		logger.info("Method : addTravelClaimOtherApi starts");

		MultipartFile x = travelClaimRestModel.getMulFile();
		logger.info("travelClaimRestModel==="+travelClaimRestModel);
		String fileName = null;
		if (x != null) {
			byte[] bytes = null;
			try {
				bytes = x.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileName = documentUpload.saveAllTypeDocument(bytes, travelClaimRestModel.getExtension(),
					travelClaimRestModel.getCreatedBy(), "TRAVELCLAIM");
			logger.info("fileName==="+fileName);
		}
		travelClaimRestModel.setDocName(fileName);

		logger.info("Method : addTravelClaimOtherApi ends");
		return travelClaimRestDao.addTravelClaimOtherApiDao(travelClaimRestModel);
	}
	
	
	/*
	 * view travel claim edit
	 */
	@GetMapping(value = "get-claim-other-edit")
	public JsonResponse<List<TravelClaimRestModel>> travelClaimOtherEdit(@RequestParam String id) {
		logger.info("Method : travelClaimOtherEdit starts");
		logger.info("Method : travelClaimOtherEdit endss");
		return travelClaimRestDao.travelClaimOtherEdit(id);
	}
	/*
	 * Delete Travel Claim
	 */
	@GetMapping(value = "delete-travelclaim-Other")
	public JsonResponse<TravelClaimRestModel> deleteTravelClaimOther(@RequestParam String id) {
		logger.info("Method : deleteTravelClaimOther starts");

		logger.info("Method : deleteTravelClaimOther ends");
		return travelClaimRestDao.deleteTravelClaimOther(id);
	}
	/*
	 * add travel claim status
	 */
	@PostMapping(value = "add-travelclaim-status")
	public ResponseEntity<JsonResponse<Object>> addTravelClaimStatus(@RequestBody TravelClaimRestModel travelClaimRestModel) {
		logger.info("Method : addTravelClaimStatus starts");

		logger.info("Method : addTravelClaimStatus ends");
		return travelClaimRestDao.addTravelClaimStatus(travelClaimRestModel);
	}
	/*
	 * view travel claim employee list api
	 */
	@GetMapping(value = "travel-claim-employee-api")
	public JsonResponse<List<TravelClaimRestModel>> viewTravelClaimApi(@RequestParam String userId,String organization,String orgDivision) {
		logger.info("Method : viewTravelClaimApi starts");
 
		logger.info("Method : viewTravelClaimApi ends");
		return travelClaimRestDao.viewTravelClaimApi(userId,organization,orgDivision);
	}
}
