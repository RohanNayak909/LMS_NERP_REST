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
import nirmalya.aatithya.restmodule.qa.dao.RestLaminateDao;
import nirmalya.aatithya.restmodule.qa.dao.RestVbarDao;
import nirmalya.aatithya.restmodule.qa.model.LaminateModel;
import nirmalya.aatithya.restmodule.qa.model.QaPcroRestModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestLaminateController {
	Logger logger = LoggerFactory.getLogger(RestLaminateController.class);

	@Autowired
	RestLaminateDao restLaminateDao;
	
	@PostMapping(value = "rest-laminate-add")
	public ResponseEntity<JsonResponse<List<LaminateModel>>> addLaminate(

			@RequestBody List<LaminateModel> laminateModel) {
		logger.info("Method : addLaminate starts");
		logger.info("Method : addLaminate ends");
		return restLaminateDao.addLaminate(laminateModel);
	}
	
	@RequestMapping(value = "rest-laminate-view", method = { RequestMethod.GET })
	public JsonResponse<Object> getLaminateView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getLaminateView start");

		logger.info("Method :getLaminateView endss");
		return restLaminateDao.getLaminateView(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-editLaminate", method = { RequestMethod.GET })
	public JsonResponse<Object> editLaminate(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editLaminate start");

		logger.info("Method :editLaminate endss");
		return restLaminateDao.editLaminate(id, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-deleteLaminate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePcro(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method : deleteLaminate starts");

		logger.info("Method : deleteLaminate ends");
		return restLaminateDao.deleteLaminate(id, orgName, orgDivision);

	}
	@RequestMapping(value = "rest-laminate-detls-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveLaminate(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method : approveLaminate starts");

		logger.info("Method : approveLaminate ends");
		return restLaminateDao.approveLaminate(id, orgName, orgDivision);

	}
}
