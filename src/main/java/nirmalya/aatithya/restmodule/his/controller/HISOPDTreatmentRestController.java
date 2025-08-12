package nirmalya.aatithya.restmodule.his.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISOPDTreatmentDao;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;
import nirmalya.aatithya.restmodule.his.model.HISTreatmentRestModel;

@RestController
@RequestMapping(value = "his/")
public class HISOPDTreatmentRestController {

	Logger logger = LoggerFactory.getLogger(HISOPDTreatmentRestController.class);

	@Autowired
	HISOPDTreatmentDao treatmentDao;
	
	@GetMapping(value = "getMedicineAutoList")
	public ResponseEntity<JsonResponse<List<HISTreatmentRestModel>>> getMedicineAutoList(
			@RequestParam String id) {
		logger.info("Method : getMedicineAutoList starts");

		logger.info("Method :getMedicineAutoList endss");
		return treatmentDao.getMedicineAutoList(id);
	}
	
	/* add */

	@RequestMapping(value = "rest-opd-treatment", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addOpdTreatment(@RequestBody HISTreatmentRestModel restData) {
		logger.info("Method : addOpdTreatment starts"/* +restData */);

		logger.info("Method : addOpdTreatment ends");
		return treatmentDao.addOpdTreatment(restData);
	}
	
	@GetMapping(value = "getTestAutoList")
	public ResponseEntity<JsonResponse<List<HISTreatmentRestModel>>> getTestAutoList(
			@RequestParam String id) {
		logger.info("Method : getTestAutoList starts");

		logger.info("Method :getTestAutoList endss");
		return treatmentDao.getTestAutoList(id);
	}
	
	@RequestMapping(value = "rest-viewOpdTreatmentLists", method = { RequestMethod.GET })
	public JsonResponse<Object> viewOpdTreatmentLists(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :viewOpdTreatmentLists start...");
		logger.info("Method :viewOpdTreatmentLists ends...");
		return treatmentDao.viewOpdTreatmentLists(orgName, orgDivision, userId, fromDate, toDate);
	}
	
	@RequestMapping(value = "rest-opd-test", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addOpdTest(@RequestBody HISTreatmentRestModel restData) {
		logger.info("Method : addOpdTest starts"/* +restData */);

		logger.info("Method : addOpdTest ends");
		return treatmentDao.addOpdTest(restData);
	}

	@RequestMapping(value = "rest-viewOpdTestLists", method = { RequestMethod.GET })
	public JsonResponse<Object> viewOpdTestLists(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :viewOpdTestLists start...");
		logger.info("Method :viewOpdTestLists ends...");
		return treatmentDao.viewOpdTestLists(orgName, orgDivision, userId, fromDate, toDate);
	}
	
	@RequestMapping(value = "getTypeList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getTypeList(@RequestParam String id) {
		logger.info("Method : getTypeList starts");
		logger.info("Method : getTypeList ends");
		return treatmentDao.getTypeList(id);
	}
	
	@RequestMapping(value = "typeList", method = { RequestMethod.GET })
	public List<DropDownModel> typeList() {

		logger.info("Method : typeList starts");
		logger.info("Method : typeList ends");

		return treatmentDao.typeList();
	}
}
