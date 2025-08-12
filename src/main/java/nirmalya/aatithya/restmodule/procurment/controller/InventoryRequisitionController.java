package nirmalya.aatithya.restmodule.procurment.controller;

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

import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.procurment.dao.InventoryRequisitionDao;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRequisitionModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory/" })
public class InventoryRequisitionController {
	Logger logger = LoggerFactory.getLogger(InventoryRequisitionController.class);

	@Autowired
	InventoryRequisitionDao inventoryRequisitionDao;

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-requisition-type")
	public List<DropDownModel> getRequisitionType() {
		logger.info("Method : getRequisitionType starts");
		logger.info("Method : getRequisitionType endss");
		return inventoryRequisitionDao.getRequisitionType();
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-requisition-priority")
	public List<DropDownModel> getRequisitionPriority() {
		logger.info("Method : getRequisitionPriority starts");
		logger.info("Method : getRequisitionPriority endss");
		return inventoryRequisitionDao.getRequisitionPriority();
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-uom")
	public List<DropDownModel> getUom() {
		logger.info("Method : getUom starts");
		logger.info("Method : getUom endss");
		return inventoryRequisitionDao.getUom();
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-requisition-item-list")
	public List<InventoryRequisitionModel> getRequisitionItemList() {
		logger.info("Method : getRequisitionItemList starts");
		logger.info("Method : getRequisitionItemList endss");
		return inventoryRequisitionDao.getRequisitionItemList();
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-requisition-edit")
	public List<InventoryRequisitionModel> getRequisitionEdit(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getRequisitionEdit starts");
		logger.info("Method : getRequisitionEdit endss");
		return inventoryRequisitionDao.getRequisitionEdit(id,org,orgDiv);
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-activity-log")
	public List<ActivitylogModel> getActivityLog(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getActivityLog starts");
		logger.info("Method : getActivityLog endss");
		return inventoryRequisitionDao.getActivityLog(id,org,orgDiv);
	}

	/*
	 * 
	 * PostMapping for add rest ItemRequisition
	 * 
	 * 
	 */
	@PostMapping(value = "rest-add-requisition")
	public ResponseEntity<JsonResponse<List<InventoryRequisitionModel>>> restAddRequisition(
			@RequestBody List<InventoryRequisitionModel> restItemRequisitonModel) {
		logger.info("Method : restAddRequisition starts");
		logger.info("Method : restAddRequisition ends");
		return inventoryRequisitionDao.restAddRequisition(restItemRequisitonModel);
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-req-cost-center")
	public List<DropDownModel> getCostCenter() {
		logger.info("Method : getCostCenter starts");
		logger.info("Method : getCostCenter endss");
		return inventoryRequisitionDao.getCostCenter();
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-location")
	public List<DropDownModel> getLocation() {
		logger.info("Method : getLocation starts");
		logger.info("Method : getLocation endss");
		return inventoryRequisitionDao.getLocation();
	}

	/*
	 * Get mapping for get Item Name
	 */

	@GetMapping(value = "getProductListByAutoSearch")
	public ResponseEntity<JsonResponse<List<InventoryRequisitionModel>>> getProductListByAutoSearch(
			@RequestParam String id) {
		logger.info("Method : getProductListByAutoSearch starts");

		logger.info("Method : getProductListByAutoSearch endss");
		return inventoryRequisitionDao.getProductListByAutoSearch(id);
	}

	/*
	 * get all requisition for view
	 */
	@GetMapping(value = "get-requisition-view-list")
	public List<InventoryRequisitionModel> getRequisitionViewList(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getRequisitionViewList starts");
		logger.info("Method : getRequisitionViewList endss");
		return inventoryRequisitionDao.getRequisitionViewList(id,org,orgDiv);
	}

	/*
	 * PostMapping for delete ItemRequisition
	 */
	@PostMapping(value = "rest-delete-requisition")
	public ResponseEntity<JsonResponse<Object>> restDeleteRequisition(
			@RequestBody InventoryRequisitionModel restItemRequisitonModel) {
		logger.info("Method : restDeleteRequisition starts");
		logger.info("Method : restDeleteRequisition ends");
		return inventoryRequisitionDao.restDeleteRequisition(restItemRequisitonModel);
	}

	/*
	 * PostMapping for delete ItemRequisition
	 */
	@PostMapping(value = "rest-approve-requisition")
	public ResponseEntity<JsonResponse<Object>> restApproveRequisition(
			@RequestBody InventoryRequisitionModel restItemRequisitonModel) {
		logger.info("Method : restApproveRequisition starts");
		logger.info("Method : restApproveRequisition ends");
		return inventoryRequisitionDao.restApproveRequisition(restItemRequisitonModel);
	}

	/*
	 * Get mapping for get product list
	 */

	@GetMapping(value = "getProductByReqList")
	public ResponseEntity<JsonResponse<InventoryRequisitionModel>> getProductByReqList(@RequestParam String id,
			@RequestParam String prodId) {
		logger.info("Method : getProductByReqList starts");

		logger.info("Method : getProductByReqList endss");
		return inventoryRequisitionDao.getProductByReqList(id, prodId);
	}
	/*
	 * for drop down of job type
	 */
	@GetMapping(value = "/getProductByCat")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getProductByCat(@RequestParam String id,String orgName,String orgDiv) {
		logger.info("Method in rest: getProductByCat starts");

		logger.info("Method in rest: getProductByCat ends");
		return inventoryRequisitionDao.getProductByCat(id,orgName,orgDiv);
	}
	
	@RequestMapping(value = "getProductCategoryDataListModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryDataListModal() {
		logger.info("Method : getProductCategoryDataListModal starts");
		
		logger.info("Method : getProductCategoryDataListModal ends");
		return inventoryRequisitionDao.getProductCategoryDataListModal();
	}
	
	@PostMapping(value = "saveOneProductMaster")
	public ResponseEntity<JsonResponse<DropDownModel>> saveOneProductMaster(@RequestBody ProductMasterModel product) {
		logger.info("Method : saveOneProductMaster starts");
		 
		logger.info("Method : saveOneProductMaster ends");
		return inventoryRequisitionDao.saveOneProductMaster(product);
	}
	
	@GetMapping(value = "getRFQdata")
	public List<InventoryRequisitionModel> getRFQdata(@RequestParam String id, String sku, String org,String orgDiv) {
		logger.info("Method : getRFQdata starts");
		logger.info("Method : getRFQdata endss");
		return inventoryRequisitionDao.getRFQdata(id, sku, org, orgDiv);
	}
	
	@PostMapping(value = "adddepartmentDetails")
	public JsonResponse<Object> adddepartmentDetails(@RequestBody ProductMasterModel productMasterModel) {
		logger.info("Method :adddepartmentDetails starts");

		logger.info("Method : adddepartmentDetails ends");
		return inventoryRequisitionDao.adddepartmentDetails(productMasterModel);
	}

	@RequestMapping(value = "getDeptList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeptList(@RequestParam String id,@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method : getDeptList starts");

		logger.info("Method : getDeptList ends");
		return inventoryRequisitionDao.getDeptList(id,orgName, orgDivision);
	}
}
