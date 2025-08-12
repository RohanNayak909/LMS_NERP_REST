package nirmalya.aatithya.restmodule.productionplan.controller;

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
import nirmalya.aatithya.restmodule.productionplan.dao.ManageBomDao;
import nirmalya.aatithya.restmodule.productionplan.model.ManageBomRestModel;

@RestController
@RequestMapping(value = "production/")
public class ManageBomRestController {

	Logger logger = LoggerFactory.getLogger(ManageBomRestController.class);

	@Autowired
	ManageBomDao productionPlanRestDao;

	@GetMapping(value = "get-Item-list")
	public List<DropDownModel> getitemlist(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : Getitemlist starts");

		logger.info("Method : getitemlist ends");
		return productionPlanRestDao.getItemlist(org, orgDiv);
	}

	@GetMapping(value = "get-Item-unitlist")
	public List<DropDownModel> getunitlist(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getunitlist starts");

		logger.info("Method : getunitlist ends");
		return productionPlanRestDao.getunitlist(org, orgDiv);
	}

	@GetMapping(value = "get-Item-sublist")
	public List<DropDownModel> getitemsublist(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getitemsublist starts");

		logger.info("Method : getitemsublist ends");
		return productionPlanRestDao.getItemSublist(org, orgDiv);
	}

	// add Bom-Details.

	@PostMapping(value = "rest-add-bomDetails")
	public ResponseEntity<JsonResponse<List<ManageBomRestModel>>> restAddBomDetails(

			@RequestBody List<ManageBomRestModel> bomDetailsModel) {
		logger.info("Method : restAddBomDetails starts");
		logger.info("Method : restAddBomDetails ends");
		return productionPlanRestDao.addBomDetails(bomDetailsModel);
	}

	@RequestMapping(value = "rest-viewBomData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewBomData(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewBomData start");

		logger.info("Method :viewBomData endss");
		return productionPlanRestDao.viewBomData(orgName, orgDivision);

	}

	@RequestMapping(value = "rest-editBomData", method = { RequestMethod.GET })
	public JsonResponse<Object> editBomData(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editBomData start");

		logger.info("Method :editBomData endss");
		return productionPlanRestDao.editBomData(id, orgName, orgDivision);

	}

	

	// deleteBom
	@GetMapping(value = "rest-delete-bom")
	public ResponseEntity<JsonResponse<Object>> deleteBom(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method : deleteBom starts");
		logger.info("Method : deleteBom ends");
		return productionPlanRestDao.deleteBom(id, orgName, orgDivision);
	}

	// change Status.
	@GetMapping(value = "rest-change-bom-status")
	public ResponseEntity<JsonResponse<Object>> changeStatus(@RequestParam String status,String id, String orgName, String orgDivision) {
		logger.info("Method : changeStatus starts");
		logger.info("Method : changeStatus ends");
		return productionPlanRestDao.changeStatus(status, id, orgName, orgDivision);
	}

}
