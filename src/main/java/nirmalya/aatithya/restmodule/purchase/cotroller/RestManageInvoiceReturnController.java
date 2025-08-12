package nirmalya.aatithya.restmodule.purchase.cotroller;

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
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModelNew;
import nirmalya.aatithya.restmodule.purchase.dao.RestManageInvoiceDao;
import nirmalya.aatithya.restmodule.purchase.dao.RestManageInvoiceReturnDao;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceReturnModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPhysicalVarificationModel;

@RestController
@RequestMapping("purchase/")
public class RestManageInvoiceReturnController {
	Logger logger = LoggerFactory.getLogger(RestManageInvoiceReturnController.class);

	@Autowired

	RestManageInvoiceReturnDao restManageInvoiceReturnDao;

	@GetMapping(value = "geInvoiceReturnId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> geInvoiceReturnId() {
		logger.info("Method : geInvoiceReturnId starts");

		logger.info("Method : geInvoiceReturnId endss");
		return restManageInvoiceReturnDao.geInvoiceReturnId();
	}

	/*
	 * add
	 */
	@PostMapping(value = "addInvoiceReturn")
	public ResponseEntity<JsonResponse<List<RestManageInvoiceReturnModel>>> addInvoiceReturn(
			@RequestBody List<RestManageInvoiceReturnModel> restManageInvoiceReturnModel) {
		logger.info("Method :addInvoiceReturn starts");

		logger.info("Method :addInvoiceReturn endss");
		return restManageInvoiceReturnDao.addInvoiceReturn(restManageInvoiceReturnModel);
	}

// view

	@RequestMapping(value = "rest-viewInvoiceReturn", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManageInvoiceReturnModel>>> viewInvoiceReturn(@RequestParam String org,
			@RequestParam String orgDiv) {

		logger.info("Method :viewInvoiceReturn startssssssssssssssssss");

		logger.info("Method :viewInvoiceReturn endss");
		return restManageInvoiceReturnDao.viewInvoiceReturn(org, orgDiv);

	}

	/*
	 * edit
	 */ @GetMapping(value = "viewInvoiceReturnEdit")
	public List<RestManageInvoiceReturnModel> viewInvoiceReturnEdit(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewInvoiceReturnEdit starts");

		logger.info("Method : viewInvoiceReturnEdit endss");
		return restManageInvoiceReturnDao.viewInvoiceReturnEdit(id, org, orgDiv);
	}

	/*
	 * approveInvoiceReturn
	 */

	@PostMapping(value = "approveInvoiceReturn")
	public ResponseEntity<JsonResponse<Object>> approveInvoiceReturn(@RequestBody RestManageInvoiceReturnModel restManageInvoiceReturnModel) {
		logger.info("Method : approveInvoiceReturn starts");

		logger.info("Method : approveInvoiceReturn ends");
		return restManageInvoiceReturnDao.approveInvoiceReturn(restManageInvoiceReturnModel);
	}
	
	
	@GetMapping(value = "rest-getReturnId")
	public ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>> getRFQList(@RequestParam String id, String type,
			String org, String orgDiv) {
		logger.info("Method : getGrnId starts");

		logger.info("Method :getGrnId endss");
		return restManageInvoiceReturnDao.getGrnId(id, type, org, orgDiv);
	}
	
	
	@GetMapping(value = "viewReturnEdit")
	public List<RestManageInvoiceModel> viewReturnEdit(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewReturnEdit starts");
		// logger.info(id);
		logger.info("Method : viewReturnEdit endss");
		return restManageInvoiceReturnDao.viewInvoiteEdit(id, org, orgDiv);
	}
}
