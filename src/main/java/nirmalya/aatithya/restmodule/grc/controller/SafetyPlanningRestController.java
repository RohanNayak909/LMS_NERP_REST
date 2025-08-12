package nirmalya.aatithya.restmodule.grc.controller;


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
import nirmalya.aatithya.restmodule.grc.dao.SafetyPlanningRestDao;
import nirmalya.aatithya.restmodule.grc.model.SafetyPlanningRestModel;

@RestController
@RequestMapping(value = { "grc/" })

public class SafetyPlanningRestController {
	
Logger logger = LoggerFactory.getLogger(SafetyPlanningRestController.class);
	
	
	  @Autowired 
	  SafetyPlanningRestDao daoManager;
	 
	
	//viewSafetyAssess

	@RequestMapping(value = "rest-getSafetyPlanning", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SafetyPlanningRestModel>>> getSafetyPlanning(@RequestParam String id ,@RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getSafetyPlanning starts"+id);
		
		logger.info("Method : getSafetyPlanning ends");
		return daoManager.getSafetyPlanning(id, userId, org, orgDiv);
	}
	//addSafetyIdentification
	@PostMapping(value = "rest-addSafetyPlanning")
	public ResponseEntity<JsonResponse<Object>> addSafetyPlanning(
			@RequestBody SafetyPlanningRestModel model) {
		logger.info("Method :addSafetyPlanning starts");
		logger.info("Method :addSafetyPlanning endss");
		return daoManager.addSafetyPlanning(model);
	}
	@RequestMapping(value = "rest-viewSafetyPlanning", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SafetyPlanningRestModel>>> viewSafetyPlanning(@RequestParam String id ,@RequestParam String pid ,@RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewSafetyPlanning starts"+id + " @@@@ "+pid + " @@@@ "+userId + " @@@@ "+org + " @@@@ "+orgDiv);
		
		logger.info("Method : viewSafetyPlanning ends");
		return daoManager.viewSafetyPlanning(id, pid, userId, org, orgDiv);
	}
	//edit
	@RequestMapping(value = "rest-editSafetyPlanning", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SafetyPlanningRestModel>>> editSafetyPlanning(@RequestParam String id ,@RequestParam String sid ,@RequestParam String pid ,@RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : editSafetyPlanning starts"+id + " @@@@ "+sid + " @@@@ "+pid + " @@@@ "+userId + " @@@@ "+org + " @@@@ "+orgDiv);
		
		logger.info("Method : editSafetyPlanning ends");
		return daoManager.editSafetyPlanning(id, sid, pid, userId, org, orgDiv);
	}
	@RequestMapping(value = "rest-deleteSafetyPlanning", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSafetyPlanning(@RequestParam String id,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : deleteSafetyPlanning starts");

		logger.info("Method : deleteSafetyPlanning ends");
		return daoManager.deleteSafetyPlanning(id, userId, org, orgDiv);
	}
	// rest auto search
	@GetMapping(value = "rest-getOwnerAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getOwnerAutoSearchList(@RequestParam String id) {
		logger.info("Method : getOwnerAutoSearchList starts"+id);

		logger.info("Method :getOwnerAutoSearchList endss");
		return daoManager.getOwnerAutoSearchList(id);
	}
}
