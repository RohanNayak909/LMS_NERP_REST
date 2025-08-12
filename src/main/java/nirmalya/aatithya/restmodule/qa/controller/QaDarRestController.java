package nirmalya.aatithya.restmodule.qa.controller;

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
import nirmalya.aatithya.restmodule.qa.dao.QaDarDao;
import nirmalya.aatithya.restmodule.qa.model.QaDarRestModel;



@RestController
@RequestMapping(value = { "production/" })
public class QaDarRestController {
	
	Logger logger = LoggerFactory.getLogger(QaDarRestController.class);

	@Autowired
	QaDarDao qaDarDao;
	
	
	@GetMapping(value = "brandList")
	public List<DropDownModel> brandList(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : brandList starts");

		logger.info("Method : brandList ends");
		return qaDarDao.brandList(org, orgDiv);
	}
	

	
	@RequestMapping(value = "rest-dar-machineList", method = { RequestMethod.GET })
	public JsonResponse<Object> machineList(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :machineList start");

		logger.info("Method :machineList endss");
		return qaDarDao.machineList(id, orgName, orgDivision);
	}
	
	@PostMapping(value = "rest-dar-details-add")
	public ResponseEntity<JsonResponse<List<QaDarRestModel>>> addDar(

			@RequestBody List<QaDarRestModel> qaDarRestModel) {
		logger.info("Method : addDar starts");
		logger.info("Method : addDar ends");
		return qaDarDao.addDar(qaDarRestModel);
	}
	
	// view
	
	@RequestMapping(value = "rest-dar-details-view", method = { RequestMethod.GET })
	public JsonResponse<Object> darView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :darView start");

		logger.info("Method :darView endss");
		return qaDarDao.darView(orgName, orgDivision);
	}
	
	//edit
	
	
	@RequestMapping(value = "rest-dar-reqst-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editDar(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editDar start");

		logger.info("Method :editDar endss");
		return qaDarDao.editDar(id, orgName, orgDivision);
	}
	
	// approve
	
	@GetMapping(value = "rest-dar-approve-data")
	public ResponseEntity<JsonResponse<Object>> approveDar(@RequestParam String id, String userId , String org, String orgDiv) {
		logger.info("Method : approveDar starts");

		logger.info("Method : approveDar ends");
		return qaDarDao.approveDar(id, userId, org, orgDiv);

	}
	
	// delete 
	
	@GetMapping(value = "rest-dar-detls-delete")
	public ResponseEntity<JsonResponse<Object>> deleteDar(@RequestParam String id, String userId , String org, String orgDiv) {
		logger.info("Method : deleteDar starts");

		logger.info("Method : deleteDar ends");
		return qaDarDao.deleteDar(id, userId, org, orgDiv);

	}
	
	// downloadDar
	
	@RequestMapping(value = "rest-dar-reqst-download", method = { RequestMethod.GET })
	public JsonResponse<Object> downloadDar(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :downloadDar start");

		logger.info("Method :downloadDar endss");
		return qaDarDao.downloadDar(id, orgName, orgDivision);
}

}
