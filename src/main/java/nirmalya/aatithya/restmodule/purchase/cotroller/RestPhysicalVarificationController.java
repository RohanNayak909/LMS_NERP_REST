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
import nirmalya.aatithya.restmodule.master.model.LeaveApplyRestModel;
import nirmalya.aatithya.restmodule.purchase.dao.RestManageInvoiceDao;
import nirmalya.aatithya.restmodule.purchase.dao.RestManageInvoiceReturnDao;
import nirmalya.aatithya.restmodule.purchase.dao.RestPhysicalVarificationDao;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceReturnModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPhysicalVarificationModel;

@RestController
@RequestMapping("purchase/")
public class RestPhysicalVarificationController {
	Logger logger = LoggerFactory.getLogger(RestPhysicalVarificationController.class);

	@Autowired

	RestPhysicalVarificationDao restPhysicalVarificationDao;

	@GetMapping(value = "getvarificationId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getvarificationId() {
		logger.info("Method : getvarificationId starts");

		logger.info("Method : getvarificationId endss");
		return restPhysicalVarificationDao.getvarificationId();
	}

	/*
	 * add
	 */
	@PostMapping(value = "addVerification")
	public ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>> addVerification(
			@RequestBody List<RestPhysicalVarificationModel> restPhysicalVarificationModel) {
		logger.info("Method :addVerification starts");

		logger.info("Method :addVerification endss");
		return restPhysicalVarificationDao.addVerification(restPhysicalVarificationModel);
	}

// view

	@RequestMapping(value = "rest-viewVerification", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>> viewVerification(@RequestParam String org,
			@RequestParam String orgDiv) {

		logger.info("Method :viewVerification startssssssssssssssssss");

		logger.info("Method :viewVerification endss");
		return restPhysicalVarificationDao.viewVerification(org, orgDiv);

	}

	/*
	 * edit
	 * 
	 */
	@GetMapping(value = "viewPhysicalVarifyEdit")
	public List<RestPhysicalVarificationModel> viewPhysicalVarifyEdit(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewPhysicalVarifyEdit starts");

		logger.info("Method : viewPhysicalVarifyEdit endss");
		return restPhysicalVarificationDao.viewPhysicalVarifyEdit(id, org, orgDiv);
	}

	// approve

	@GetMapping(value = "approveVarification")
	public JsonResponse<DropDownModel> approvePhysicalVarification(@RequestParam String approveStatus,
			String varificationId, String invoiceId, String orgName, String orgDivision) {
		logger.info("Method : approvePhysicalVarification starts");

		logger.info("Method : approvePhysicalVarification ends");
		return restPhysicalVarificationDao.approvePhysicalVarification(approveStatus, varificationId, invoiceId,
				orgName, orgDivision);
	}

	/*
	 * delete
	 * 
	 */
	@RequestMapping(value = "deleteVarificationDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteVarificationDetails(@RequestParam String id) {
		logger.info("Method : deleteVarificationDetails starts");

		logger.info("Method : deleteVarificationDetails ends");
		return restPhysicalVarificationDao.deleteVarificationDetails(id);
	}

	/*
	 * edit for grn data
	 * 
	 */
	@GetMapping(value = "viewPhysicalVarifyEditForgrnReturn")
	public List<RestPhysicalVarificationModel> viewPhysicalVarifyEditForgrnReturn(@RequestParam String id,
			String hsnCode, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewPhysicalVarifyEditForgrnReturn starts");

		logger.info("Method : viewPhysicalVarifyEditForgrnReturn endss");
		return restPhysicalVarificationDao.viewPhysicalVarifyEditForgrnReturn(id, hsnCode, org, orgDiv);
	}

	@GetMapping(value = "rest-getGrnId")
	public ResponseEntity<JsonResponse<List<RestPhysicalVarificationModel>>> getRFQList(@RequestParam String id, String type,
			String org, String orgDiv) {
		logger.info("Method : getGrnId starts");

		logger.info("Method :getGrnId endss");
		return restPhysicalVarificationDao.getRFQList(id, type, org, orgDiv);
	}
}