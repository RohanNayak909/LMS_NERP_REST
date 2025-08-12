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
import nirmalya.aatithya.restmodule.qa.dao.RestSulphuricAcidDao;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.SulphuricAcidModel;
@RestController
@RequestMapping(value = { "qa/" })
public class RestSulphuricAcidController {
	Logger logger = LoggerFactory.getLogger(RestSulphuricAcidController.class);

	@Autowired
	RestSulphuricAcidDao restSulphuricAcidDao;
	
	@PostMapping(value = "rest-addSulphuric")
	public ResponseEntity<JsonResponse<List<SulphuricAcidModel>>> addSulphuric(

			@RequestBody List<SulphuricAcidModel> sulphuricAcidModel) {
		logger.info("Method : addSulphuric starts");
		logger.info("Method : addSulphuric ends");
		return restSulphuricAcidDao.addSulphuric(sulphuricAcidModel);
	}
	
	@RequestMapping(value = "rest-getSulphuricAcidView", method = { RequestMethod.GET })
	public JsonResponse<Object> getSulphuricAcidView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getSulphuricAcidView start");

		logger.info("Method :getSulphuricAcidView endss");
		return restSulphuricAcidDao.getSulphuricAcidView(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-editSulphuricAcid", method = { RequestMethod.GET })
	public JsonResponse<Object> editSulphuricAcid(@RequestParam String sulphuricAcidId, String orgName, String orgDivision) {
		logger.info("Method :editSulphuricAcid start");

		logger.info("Method :editSulphuricAcid endss");
		return restSulphuricAcidDao.editSulphuricAcid(sulphuricAcidId, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-deleteSulphuricAcid", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSulphuricAcid(@RequestParam String id, String org, String orgDivision) {
		logger.info("Method : deleteSulphuricAcid starts");

		logger.info("Method : deleteSulphuricAcid ends");
		return restSulphuricAcidDao.deleteSulphuricAcid(id, org, orgDivision);

	}
	
	@RequestMapping(value = "rest-approveSa", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveSa(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveSa starts");
		System.out.println("ORGANISATION DIVISION"+orgDiv);
		logger.info("Method : approveSa ends");
		return restSulphuricAcidDao.approveSa(id, org, orgDiv);

	}
//
	@RequestMapping(value = "rest-sulAcidPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> sulAcidPdf(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :sulAcidPdf start");

		logger.info("Method :sulAcidPdf endss");
		return restSulphuricAcidDao.sulAcidPdf(id,orgName,orgDivision);

	}
}
