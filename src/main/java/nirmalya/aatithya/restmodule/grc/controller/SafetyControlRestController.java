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
import nirmalya.aatithya.restmodule.grc.dao.SafetyControlRestDao;
import nirmalya.aatithya.restmodule.grc.model.SafetyControlRestModel;
import nirmalya.aatithya.restmodule.grc.model.SafetyPlanningRestModel;

@RestController
@RequestMapping(value = { "grc/" })
public class SafetyControlRestController {

	Logger logger = LoggerFactory.getLogger(SafetyControlRestController.class);
	@Autowired
	SafetyControlRestDao daoManager;

	@RequestMapping(value = "rest-viewSafetyControl", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SafetyControlRestModel>>> viewSafetyControl(@RequestParam String id,
			@RequestParam String pid, @RequestParam String userId, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewSafetyControl starts" + id + " @@@@ " + pid + " @@@@ " + userId + " @@@@ " + org
				+ " @@@@ " + orgDiv);

		logger.info("Method : viewSafetyControl ends");
		return daoManager.viewSafetyControl(id, pid, userId, org, orgDiv);
	}

	// edit
	@RequestMapping(value = "rest-editSafetyControl", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<SafetyControlRestModel>>> editSafetyControl(@RequestParam String id,
			@RequestParam String sid, @RequestParam String pid, @RequestParam String userId, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : editSafetyControl starts" + id + " @@@@ " + sid + " @@@@ " + pid + " @@@@ " + userId
				+ " @@@@ " + org + " @@@@ " + orgDiv);

		logger.info("Method : editSafetyControl ends");
		return daoManager.editSafetyControl(id, sid, pid, userId, org, orgDiv);
	}

	// add
	@PostMapping(value = "rest-addSafetyControl")
	public ResponseEntity<JsonResponse<Object>> addSafetyPlanning(@RequestBody SafetyControlRestModel model) {
		logger.info("Method :addSafetyControl starts" + model);
		logger.info("Method :addSafetyControl endss");
		return daoManager.addSafetyControl(model);
	}
	// rest auto search

	@GetMapping(value = "rest-getIndentNoAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIndentNoAutoSearchList(@RequestParam String id) {
		logger.info("Method : getIndentNoAutoSearchList starts" + id);

		logger.info("Method :getIndentNoAutoSearchList endss");
		return daoManager.getIndentNoAutoSearchList(id);
	}

}
