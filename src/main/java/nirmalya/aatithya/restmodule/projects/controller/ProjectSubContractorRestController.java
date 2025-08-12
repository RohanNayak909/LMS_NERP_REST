package nirmalya.aatithya.restmodule.projects.controller;

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
import nirmalya.aatithya.restmodule.projects.dao.ProjectSubContractorDao;
import nirmalya.aatithya.restmodule.projects.model.ProjectSubContractorRestModel;

@RestController
@RequestMapping(value = "projects")

public class ProjectSubContractorRestController {

	Logger logger = LoggerFactory.getLogger(ProjectSubContractorRestController.class);

	@Autowired
	ProjectSubContractorDao projectSubContractorDao;

	// add rest sub contractor
	@PostMapping(value = "rest-SubContractor-add")
	public ResponseEntity<JsonResponse<Object>> restaddSubContractor(

			@RequestBody ProjectSubContractorRestModel subContractor) {
		logger.info("Method : restaddSubContractor starts");
		logger.info("Method : restaddSubContractor ends");
		return projectSubContractorDao.restaddSubContractor(subContractor);
	}

	// view rest sub contractor
	@RequestMapping(value = "rest-SubContractor-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewSubContractor(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewSubContractor start");

		logger.info("Method :viewSubContractor endss");
		return projectSubContractorDao.viewSubContractor(orgName, orgDivision);
	}

	// edit rest sub contractor
	@RequestMapping(value = "rest-SubContractor-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editSubContractor(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editSubContractor start");

		logger.info("Method :editSubContractor endss");
		return projectSubContractorDao.editSubContractor(id, orgName, orgDivision);
	}

	// delete rest sub contractor
	@RequestMapping(value = "rest-SubContractor-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSubContractor(@RequestParam String id, String org, String div) {
		logger.info("Method : deleteSubContractor starts");

		logger.info("Method : deleteSubContractor ends");
		return projectSubContractorDao.deleteSubContractor(id, org, div);

	}

	// rest auto search

	@GetMapping(value = "get-rest-ProjectAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getProjectAutoSearchList(@RequestParam String id) {
		logger.info("Method : getProjectAutoSearchList starts");

		logger.info("Method :getProjectAutoSearchList endss");
		return projectSubContractorDao.getProjectAutoSearchList(id);
	}

	// add rest sub contractor work

	@RequestMapping(value = "rest-SubContractor-add-work", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addSubContractorWork(
			@RequestBody ProjectSubContractorRestModel subContractorWork) {
		logger.info("Method : restaddSubContractor starts");

		logger.info("Method : restaddSubContractor ends");
		return projectSubContractorDao.addSubContractorWork(subContractorWork);
	}

	// view rest sub contractor work

	@RequestMapping(value = "rest-SubContractor-view-work", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProjectSubContractorRestModel>>> viewSubContractorWork() {
		logger.info("Method: viewSubContractorWork View Start");

		logger.info("Method: viewSubContractorWork View ends");
		return projectSubContractorDao.viewSubContractorWork();
	}

	// edit rest sub contractor work

	@RequestMapping(value = "rest-SubContractor-work-edit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProjectSubContractorRestModel>>> subcontractorWorkEdit(
			@RequestParam String id) {
		logger.info("Method : subcontractorWorkEdit starts");
		System.out.println("IDDDDDD" + id);
		logger.info("Method : subcontractorWorkEdit ends");
		return projectSubContractorDao.subcontractorWorkEdit(id);

	}

	// delete rest sub contractor work
	@RequestMapping(value = "rest-SubContractor-work-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> subcontractorWorkDelete(@RequestParam String id) {
		logger.info("Method : subcontractorWorkDelete starts");

		logger.info("Method : subcontractorWorkDelete ends");
		return projectSubContractorDao.subcontractorWorkDelete(id);
	}

}
