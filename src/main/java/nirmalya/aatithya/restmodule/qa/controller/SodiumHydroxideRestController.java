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
import nirmalya.aatithya.restmodule.qa.dao.SodiumHydrixideDao;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestEdtaSolutionModel;
import nirmalya.aatithya.restmodule.qa.model.SodiumHydroxideRestModel;
import nirmalya.aatithya.restmodule.qa.model.SulphuricAcidModel;
@RestController
@RequestMapping(value = { "qa/" })
public class SodiumHydroxideRestController {
	
	Logger logger = LoggerFactory.getLogger(SodiumHydroxideRestController.class);

	@Autowired
	SodiumHydrixideDao sodiumHydrixideDao;
	
	@PostMapping(value = "rest-addSodium")
	public ResponseEntity<JsonResponse<List<SodiumHydroxideRestModel>>> addSulphuric(

			@RequestBody List<SodiumHydroxideRestModel> SodiumHydroxideRestModel) {
		logger.info("Method : addSodium starts");
		logger.info("Method : addSodium ends");
		return sodiumHydrixideDao.addSodium(SodiumHydroxideRestModel);
	}

	@RequestMapping(value = "rest-viewSodium", method = { RequestMethod.GET })
	public JsonResponse<Object> viewSodium(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewSodium start");

		logger.info("Method :viewSodium endss");
		return sodiumHydrixideDao.viewSodium(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-editSodium", method = { RequestMethod.GET })
	public JsonResponse<Object> editSodium(@RequestParam String sodiumId, String orgName, String orgDivision) {
		logger.info("Method :editSodium start");

		logger.info("Method :editSodium endss");
		return sodiumHydrixideDao.editSodium(sodiumId, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-deleteSodium", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSodium(@RequestParam String id, String org, String orgDivision) {
		logger.info("Method : deleteSodium starts");

		logger.info("Method : deleteSodium ends");
		return sodiumHydrixideDao.deleteSodium(id, org, orgDivision);

	}
	
	@RequestMapping(value = "rest-approveSodium", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveSodium(@RequestParam String id, String org, String orgDiv,String userId) {
		logger.info("Method : approveSodium starts");
		
		logger.info("Method : approveSodium endsssssssssssss"+userId);
		return sodiumHydrixideDao.approveSodium(id, org, orgDiv, userId);

	}
	//PDF
	@RequestMapping(value = "rest-sodiumHydroxidePdf", method = { RequestMethod.GET })
	public JsonResponse<Object> sodiumHydroxidePdf(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :sodiumHydroxidePdf start");

		logger.info("Method :sodiumHydroxidePdf endss");
		return sodiumHydrixideDao.sodiumHydroxidePdf(id,orgName,orgDivision);

	}
}
