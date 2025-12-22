package nirmalya.aatithya.restmodule.sales.controller;

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
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;
import nirmalya.aatithya.restmodule.sales.dao.RestSalesPackagesDao;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesPackagesModel;

@RestController
@RequestMapping("sales/")
public class RestSalesPackagesController {
	Logger logger = LoggerFactory.getLogger(RestSalesPackagesController.class);

	@Autowired

	RestSalesPackagesDao restSalesPackagesDao;

	@GetMapping(value = "getPackagingtypeList")
	public List<DropDownModel> getPackagingtypeList() {
		logger.info("Method : getPackagingtypeList starts");

		logger.info("Method : getPackagingtypeList ends");
		return restSalesPackagesDao.getPackagingtypeList();
	}

	@RequestMapping(value = "getSalesOrderList1", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderList(@RequestParam String id, String type) {
		logger.info("Method : getSalesOrderList starts");
		logger.info("Method : getSalesOrderList ends");
		return restSalesPackagesDao.getSalesOrderList(id, type);
	}

	@PostMapping(value = "addpackagesnew")
	public ResponseEntity<JsonResponse<List<RestSalesPackagesModel>>> addpackagesnew(
			@RequestBody List<RestSalesPackagesModel> restSalesPackagesModel) {
		logger.info("Method :addpackagesnew starts");
		
		logger.info("Method :addpackagesnew endss");
		return restSalesPackagesDao.addpackagesnew(restSalesPackagesModel);
	}

	@RequestMapping(value = "rest-viewsalesPackages", method = { RequestMethod.GET })
	public JsonResponse<Object> viewsalesPackages(@RequestParam String orgName, @RequestParam String orgDivision,String pageno) {
		logger.info("Method :viewsalesPackages start");

		logger.info("Method :viewsalesPackages endss");
		return restSalesPackagesDao.viewsalesPackages(orgName, orgDivision, pageno);

	}

/*	@GetMapping(value = "viewPackageEdit")
	public List<RestSalesPackagesModel> viewPackageEdit(@RequestParam String id) {
		logger.info("Method : viewPackageEdit starts");
	 
		logger.info("Method : viewPackageEdit endss");
		return restSalesPackagesDao.viewPackageEdit(id);
	}*/

	@RequestMapping(value = "/deletPackage", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletPackage(@RequestParam String id) {
		logger.info("Method : deletPackage starts");

		logger.info("Method : deletPackage ends");
		return restSalesPackagesDao.deletPackage(id);
	}

	@GetMapping(value = "getInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInsertedId() {
		logger.info("Method : getInsertedId starts");

		logger.info("Method : getInsertedId endss");
		return restSalesPackagesDao.getInsertedId();
	}

	// add Advance apply
	@PostMapping(value = "savepackedQutdetails")
	public ResponseEntity<JsonResponse<Object>> savepackedQutdetails(
			@RequestBody RestSalesPackagesModel packagesModel) {
		logger.info("Method : savepackedQutdetails starts");

		logger.info("Method : savepackedQutdetails ends");
		return restSalesPackagesDao.savepackedQutdetails(packagesModel);
	}
	
	@GetMapping(value = "viewsalesOrderItemDetails")
	public List<RestSaleOrderNewModel> viewsalesOrderItemDetails(@RequestParam String id) {
		logger.info("Method : viewsalesOrderItemDetails starts");
	 
		logger.info("Method : viewsalesOrderItemDetails endss");
		return restSalesPackagesDao.viewsalesOrderItemDetails(id);
	}
	
	@GetMapping(value = "getDeliveryChallanDataOnPackageId")
	public List<RestSalesPackagesModel> getDeliveryChallanDataOnPackageId(@RequestParam String id) {
		logger.info("Method : getDeliveryChallanDataOnPackageId starts");
	 
		logger.info("Method : getDeliveryChallanDataOnPackageId endss");
		return restSalesPackagesDao.getDeliveryChallanDataOnPackageId(id);
	}
	@RequestMapping(value = "rest-get-sales-order", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllsalesOrder(@RequestParam String orgName, @RequestParam String orgDivision,String pageno) {
		logger.info("Method :getAllsalesOrder start");

		logger.info("Method :getAllsalesOrder endss");
		return restSalesPackagesDao.getAllsalesOrder(orgName, orgDivision, pageno);

	}
	@RequestMapping(value = "viewsalesForPacking", method = { RequestMethod.GET })
	public JsonResponse<Object> viewsalesForPacking(@RequestParam String id,String poidd, String orgName, String orgDivision) {
		logger.info("Method :viewsalesForPacking start");

		logger.info("Method :viewsalesForPacking endss");
		return restSalesPackagesDao.viewsalesForPacking(id,poidd, orgName, orgDivision);
	}
//
	@RequestMapping(value = "viewPackageEdit", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPackageEdit(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :viewPackageEdit start");

		logger.info("Method :viewPackageEdit endss");
		return restSalesPackagesDao.viewPackageEdit(id,orgName, orgDivision);
	}
}
