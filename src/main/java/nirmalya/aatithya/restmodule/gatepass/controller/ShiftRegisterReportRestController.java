package nirmalya.aatithya.restmodule.gatepass.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gatepass.dao.ShiftRegisterReportDao;
import nirmalya.aatithya.restmodule.gatepass.model.ShiftRegisterReportModel;

@RestController
@RequestMapping("gatepass/")
public class ShiftRegisterReportRestController {

	Logger logger = LoggerFactory.getLogger(ShiftRegisterReportRestController.class);

	@Autowired
	ShiftRegisterReportDao shiftRegisterReportDao;

	// category list
	@RequestMapping(value = "rest-gatePass-report_category_list", method = { RequestMethod.GET })
	public JsonResponse<Object> getCategoryList(@RequestParam String orgName, String orgDivision, String shift, String date) {
		logger.info("Method :getCategoryList start");

		logger.info("Method :getCategoryList endss");
		return shiftRegisterReportDao.getCategoryList(orgName, orgDivision, shift, date);
	}
	
	// Shift List
	
	@RequestMapping(value = "getShiftLists", method = { RequestMethod.GET })
	public List<DropDownModel> getShiftLists(@RequestParam String org, String orgDiv,
			String userId) {
		logger.info("Method : getShiftLists starts");

		logger.info("Method : getShiftLists ends");
		return shiftRegisterReportDao.getShiftLists(org, orgDiv, userId);
	}
	

	// saveAllocation
	@PostMapping(value = "saveGateReportData")
	public ResponseEntity<JsonResponse<List<ShiftRegisterReportModel>>> saveAllocation(
			@RequestBody List<ShiftRegisterReportModel> restGatePassReportModel) {
		logger.info("Method :saveGateReportData starts");

		logger.info("Method :saveGateReportData endss");
		return shiftRegisterReportDao.saveGateReportData(restGatePassReportModel);
	}

	@RequestMapping(value = "viewReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewReportData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewReportData start");

		logger.info("Method :viewReportData endss");
		return shiftRegisterReportDao.viewReportData(orgName, orgDivision);

	}

	

	// Emp List.

	@RequestMapping(value = "rest-empListData", method = { RequestMethod.GET })
	public JsonResponse<Object> empListData(@RequestParam String orgName, String orgDivision, String empCategory) {
		logger.info("Method :empListData start");

		logger.info("Method :empListData endss");
		return shiftRegisterReportDao.empListData(orgName, orgDivision,empCategory);

	}

	@RequestMapping(value = "editReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> editReportData(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editReportData start");

		logger.info("Method :editReportData endss");
		return shiftRegisterReportDao.editReportData(id, orgName, orgDivision);
	}

	@RequestMapping(value = "rest-deleteReport", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteReport(@RequestParam String registerId, String org, String orgDiv) {
		logger.info("Method :deleteReport start");

		logger.info("Method :deleteReport endss");
		return shiftRegisterReportDao.deleteReport(registerId, org, orgDiv);
	}

	@RequestMapping(value = "rest-approveReportdata", method = { RequestMethod.GET })
	public JsonResponse<Object> approveReportdata(@RequestParam String registerId, String org, String orgDiv) {
		logger.info("Method :approveReportdata start");

		logger.info("Method :approveReportdata endss");
		return shiftRegisterReportDao.approveReportdata(registerId, org, orgDiv);
	}

	@RequestMapping(value = "rest-report-pdf", method = { RequestMethod.GET })
	public JsonResponse<Object> getReportPdfDetails(@RequestParam String registerId, String orgName,
			String orgDivision) {
		logger.info("Method :getReportPdfDetails start");

		logger.info("Method :getReportPdfDetails endss");
		return shiftRegisterReportDao.getReportPdfDetails(registerId, orgName, orgDivision);
	}

	@RequestMapping(value = "getCategoryAutoSearchListForItem", method = { RequestMethod.GET })
	public JsonResponse<Object> getCategoryAutoSearchListForItem(@RequestParam String id) {
		logger.info("Method :getCategoryAutoSearchListForItem start");

		logger.info("Method :getCategoryAutoSearchListForItem endss");
		return shiftRegisterReportDao.getCategoryAutoSearchListForItem(id);
	}

	@RequestMapping(value = "getManPowerAutoSearchListForItem", method = { RequestMethod.GET })
	public JsonResponse<Object> getManPowerAutoSearchListForItem(@RequestParam String id) {
		logger.info("Method :getManPowerAutoSearchListForItem start");

		logger.info("Method :getManPowerAutoSearchListForItem endss");
		return shiftRegisterReportDao.getManPowerAutoSearchListForItem(id);
	}
	
	@RequestMapping(value = "rest-categoriesdata", method = { RequestMethod.GET })
	public JsonResponse<Object> addNewCategories(@RequestParam String categories,String type, String shift, String org, String orgDiv) {
		logger.info("Method :addNewCategories start");

		logger.info("Method :addNewCategories endss");
		return shiftRegisterReportDao.addCategories(categories,type,shift,org, orgDiv);
	}
	
	// Delete Catagory.
	
	@RequestMapping(value = "rest-gatePass-report_category_delete", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteCategory(@RequestParam String orgName, String orgDivision, String id) {
		logger.info("Method :deleteCategory start");

		logger.info("Method :deleteCategory endss");
		return shiftRegisterReportDao.deleteCategory(orgName, orgDivision, id);
	}


}
