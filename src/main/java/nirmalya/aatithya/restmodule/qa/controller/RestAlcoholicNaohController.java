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
import nirmalya.aatithya.restmodule.qa.dao.RestAlcoholicNaohDao;
import nirmalya.aatithya.restmodule.qa.dao.RestSulphuricAcidDao;
import nirmalya.aatithya.restmodule.qa.model.AlcoholicNaohModel;
import nirmalya.aatithya.restmodule.qa.model.SulphuricAcidModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestAlcoholicNaohController {
	Logger logger = LoggerFactory.getLogger(RestAlcoholicNaohController.class);
	@Autowired
	RestAlcoholicNaohDao restAlcoholicNaohDao;

	@PostMapping(value = "rest-addAlcoholicNaoh")
	public ResponseEntity<JsonResponse<List<AlcoholicNaohModel>>> addAlcoholicNaoh(

			@RequestBody List<AlcoholicNaohModel> alcoholicNaohModel) {
		logger.info("Method : addAlcoholicNaoh starts");
		logger.info("Method : addAlcoholicNaoh ends");
		return restAlcoholicNaohDao.addAlcoholicNaoh(alcoholicNaohModel);
	}
	
	@RequestMapping(value = "rest-getAlcoholicNaohView", method = { RequestMethod.GET })
	public JsonResponse<Object> getAlcoholicNaohView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getAlcoholicNaohView start");

		logger.info("Method :getAlcoholicNaohView endss");
		return restAlcoholicNaohDao.getAlcoholicNaohView(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-editAlcoholicNaoh", method = { RequestMethod.GET })
	public JsonResponse<Object> editAlcoholicNaoh(@RequestParam String alcoholicNaohId, String orgName, String orgDivision) {
		logger.info("Method :editAlcoholicNaoh start");

		logger.info("Method :editAlcoholicNaoh endss");
		return restAlcoholicNaohDao.editAlcoholicNaoh(alcoholicNaohId, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-deleteAlcoholicNaoh", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAlcoholicNaoh(@RequestParam String id, String org, String orgDivision) {
		logger.info("Method : deleteAlcoholicNaoh starts");

		logger.info("Method : deleteAlcoholicNaoh ends");
		return restAlcoholicNaohDao.deleteAlcoholicNaoh(id, org, orgDivision);

	}
	@RequestMapping(value = "rest-approveAlcoholicNaoh", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveAlcoholicNaoh(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveAlcoholicNaoh starts");
		System.out.println("ORGANISATION DIVISION"+orgDiv);
		logger.info("Method : approveAlcoholicNaoh ends");
		return restAlcoholicNaohDao.approveAlcoholicNaoh(id, org, orgDiv);

	}
	//PDF
	@RequestMapping(value = "rest-alcohlicNaohPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> alcohlicNaohPdf(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :alcohlicNaohPdf start");

		logger.info("Method :alcohlicNaohPdf endss");
		return restAlcoholicNaohDao.alcohlicNaohPdf(id,orgName,orgDivision);

	}
}
