package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestOrganizationDao;
import nirmalya.aatithya.restmodule.master.model.RestOrganizationMasterModel;

@RestController
@RequestMapping(value = "master/")
public class RestOrganizationRestController {

	Logger logger = LoggerFactory.getLogger(RestOrganizationRestController.class);

	@Autowired
	RestOrganizationDao restOrganizationDao;
//Get Organization Name
	@RequestMapping(value = "getOrganizationName", method = { RequestMethod.GET })
	public  DropDownModel  getOrganizationName() {
		logger.info("Method : getOrganizationName starts");
		
		logger.info("Method : getOrganizationName ends");
		return restOrganizationDao.getOrganizationName();
	}
	
	/*
	 * for employee list
	 */
	
	@RequestMapping(value = "getEmployeeLists", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeLists() {
		logger.info("Method : getEmployeeLists starts");

		logger.info("Method : getEmployeeLists ends");
		return restOrganizationDao.getEmployeeLists();
	}
	@RequestMapping(value = "saveOrganizationCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<RestOrganizationMasterModel>> saveOrganizationCategory(
			@RequestBody RestOrganizationMasterModel organization) {
		logger.info("Method : saveOrganizationCategory starts");

		logger.info("Method : saveOrganizationCategory ends"+organization.getOrgName());
		return restOrganizationDao.saveOrganizationCategory(organization);
	}

	@RequestMapping(value = "saveOrganizationSubCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<RestOrganizationMasterModel>> saveOrganizationSubCategory(
			@RequestBody RestOrganizationMasterModel organization) {
		logger.info("Method : saveOrganizationSubCategory starts");

		logger.info("Method : saveOrganizationSubCategory ends"+organization.getOrgName());
		return restOrganizationDao.saveOrganizationSubCategory(organization);
	}

	@RequestMapping(value = "getAllOrganizationCategoryList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestOrganizationMasterModel>>> getAllOrganizationCategoryList(@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method : getAllOrganizationCategoryList starts");

		logger.info("Method : getAllOrganizationCategoryList ends");
		return restOrganizationDao.getAllOrganizationCategoryList(orgName,orgDivision);
	}

	@RequestMapping(value = "getOrganizationCategoryListById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestOrganizationMasterModel>>> getOrganizationCategoryListById(
			@RequestParam String id) {
		logger.info("Method : getOrganizationCategoryListById starts");

		logger.info("Method : getOrganizationCategoryListById ends");
		return restOrganizationDao.getOrganizationCategoryListById(id);
	}

	@RequestMapping(value = "getOrganizationCategoryById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestOrganizationMasterModel>> getOrganizationCategoryById(@RequestParam String id) {
		logger.info("Method : getOrganizationCategoryById starts");

		logger.info("Method : getOrganizationCategoryById ends");
		return restOrganizationDao.getOrganizationCategoryById(id);
	}

	@RequestMapping(value = "deleteOrganization", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteOrganization(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteOrganization starts");

		logger.info("Method : deleteOrganization ends");
		return restOrganizationDao.deleteOrganization(id, createdBy);
	}
}
