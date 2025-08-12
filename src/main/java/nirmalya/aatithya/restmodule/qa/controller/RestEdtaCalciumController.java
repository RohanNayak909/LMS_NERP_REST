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
import nirmalya.aatithya.restmodule.qa.dao.RestEdtaCalciumDao;
import nirmalya.aatithya.restmodule.qa.dao.RestSulphuricAcidDao;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestEdtaSolutionModel;
import nirmalya.aatithya.restmodule.qa.model.SulphuricAcidModel;
@RestController
@RequestMapping(value = { "qa/" })
public class RestEdtaCalciumController {

	Logger logger = LoggerFactory.getLogger(RestEdtaCalciumController.class);

	@Autowired
	RestEdtaCalciumDao restEdtaCalciumDao;
	
	@PostMapping(value = "rest-addCalcium")
	public ResponseEntity<JsonResponse<List<RestEdtaSolutionModel>>> addSulphuric(

			@RequestBody List<RestEdtaSolutionModel> RestEdtaSolutionModel) {
		logger.info("Method : addCalcium starts");
		logger.info("Method : addCalcium ends");
		return restEdtaCalciumDao.addCalcium(RestEdtaSolutionModel);
	}
	
	@RequestMapping(value = "rest-viewCalcium", method = { RequestMethod.GET })
	public JsonResponse<Object> viewCalcium(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewCalcium start");

		logger.info("Method :viewCalcium endss");
		return restEdtaCalciumDao.viewCalcium(orgName, orgDivision);
	}
	
	
	@RequestMapping(value = "rest-editCalcium", method = { RequestMethod.GET })
	public JsonResponse<Object> editCalcium(@RequestParam String edtacalciumId, String orgName, String orgDivision) {
		logger.info("Method :editCalcium start");

		logger.info("Method :editCalcium endss");
		return restEdtaCalciumDao.editCalcium(edtacalciumId, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-deleteCalcium", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCalcium(@RequestParam String id, String org, String orgDivision) {
		logger.info("Method : deleteCalcium starts");

		logger.info("Method : deleteCalcium ends");
		return restEdtaCalciumDao.deleteCalcium(id, org, orgDivision);

	}
	
	@RequestMapping(value = "rest-approveCalcium", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveCalcium(@RequestParam String id, String org, String orgDiv,String userId) {
		logger.info("Method : approveCalcium starts");
		
		logger.info("Method : approveCalcium endsssssssssssss"+userId);
		return restEdtaCalciumDao.approveCalcium(id, org, orgDiv, userId);

	}
	//PDF
		@RequestMapping(value = "rest-edtaCalPdf", method = { RequestMethod.GET })
		public JsonResponse<Object> edtaCalPdf(@RequestParam String id,String orgName, String orgDivision) {
			logger.info("Method :edtaCalPdf start");

			logger.info("Method :edtaCalPdf endss");
			return restEdtaCalciumDao.edtaCalPdf(id,orgName,orgDivision);

		}
}
