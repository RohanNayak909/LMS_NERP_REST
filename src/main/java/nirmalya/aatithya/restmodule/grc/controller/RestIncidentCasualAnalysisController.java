package nirmalya.aatithya.restmodule.grc.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.RestIncidentCasualAnalysisDao;
import nirmalya.aatithya.restmodule.grc.model.RestIncidentCasualAnalysisModel;

@RestController
@RequestMapping(value = "grc/")
public class RestIncidentCasualAnalysisController {

	Logger logger = LoggerFactory.getLogger(RestIncidentCasualAnalysisController.class);

	@Autowired
	RestIncidentCasualAnalysisDao restIncidentCasualAnalysisDao;
	
	
	/* view */

	@GetMapping(value = "rest-view-casual-analysis")
	public JsonResponse<List<RestIncidentCasualAnalysisModel>> viewCasualAnalysis(@RequestParam String uId, 
			String orgName,String orgDivision) {
		logger.info("Method : viewCasualAnalysis starts");

		logger.info("Method : viewCasualAnalysis ends");
		return restIncidentCasualAnalysisDao.viewCasualAnalysisDao(uId,orgName,orgDivision);
	}
	
	/* edit */

	@RequestMapping(value = "rest-edit-casual-analysis", method = { RequestMethod.GET })
	public JsonResponse<RestIncidentCasualAnalysisModel> editCasualAnalysis(@RequestParam String id, String uId, String orgName,
			String orgDivision) {
			
		logger.info("Method : editCasualAnalysis rest starts");

		logger.info("Method :editCasualAnalysis rest ends");
		return restIncidentCasualAnalysisDao.editCasualAnalysisDao(id, uId, orgName, orgDivision);
	}
	
	/* add */

	@RequestMapping(value = "rest-add-casual-analysis", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addCasualAnalysis(@RequestBody RestIncidentCasualAnalysisModel restData) {
		logger.info("Method : addManage starts"/* +restData */);

		logger.info("Method : addManag ends");
		return restIncidentCasualAnalysisDao.addCasualAnalysisDao(restData);
	}
}
