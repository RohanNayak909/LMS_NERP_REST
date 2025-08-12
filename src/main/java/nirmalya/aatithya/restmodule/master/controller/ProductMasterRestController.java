package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.ProductMasterDao;
import nirmalya.aatithya.restmodule.master.model.ProductDetailsModel;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class ProductMasterRestController {

	Logger logger = LoggerFactory.getLogger(ProductMasterRestController.class);

	@Autowired
	ProductMasterDao productMasterDao;

	@RequestMapping(value = "getBrandListForProduct", method = { RequestMethod.GET })
	public List<DropDownModel> getBrandListForProduct(@RequestParam String org, String orgDiv) {
		logger.info("Method : getBrandListForProduct starts");

		logger.info("Method : getBrandListForProduct ends");
		return productMasterDao.getBrandListForProduct(org, orgDiv);
	}

	@RequestMapping(value = "getModeListForProduct", method = { RequestMethod.GET })
	public List<DropDownModel> getModeListForProduct(@RequestParam String org, String orgDiv, String type) {
		logger.info("Method : getModeListForProduct starts");

		logger.info("Method : getModeListForProduct ends");
		return productMasterDao.getModeListForProduct(org, orgDiv, type);
	}

	@RequestMapping(value = "getHSNCodeListForProduct", method = { RequestMethod.GET })
	public List<DropDownModel> getHSNCodeListForProduct() {
		logger.info("Method : getHSNCodeListForProduct starts");

		logger.info("Method : getHSNCodeListForProduct ends");
		return productMasterDao.getHSNCodeListForProduct();
	}

	@RequestMapping(value = "getVariationTypeListtForProduct", method = { RequestMethod.GET })
	public List<DropDownModel> getVariationTypeListtForProduct() {
		logger.info("Method : getVariationTypeListtForProduct starts");

		logger.info("Method : getVariationTypeListtForProduct ends");
		return productMasterDao.getVariationTypeListtForProduct();
	}

	@RequestMapping(value = "getUOMListForProduct", method = { RequestMethod.GET })
	public List<DropDownModel> getUOMListForProduct() {
		logger.info("Method : getUOMListForProduct starts");

		logger.info("Method : getUOMListForProduct ends");
		return productMasterDao.getUOMListForProduct();
	}
	@RequestMapping(value = "getAllItemList", method = { RequestMethod.GET })
	public List<DropDownModel> getAllItemList(@RequestParam String org, String orgDiv,String type) {
		logger.info("Method : getAllItemList starts");
		
		logger.info("Method : getAllItemList ends");
		return productMasterDao.getAllItemList(org,orgDiv,type);
	}

	@RequestMapping(value = "getVendorListForProduct", method = { RequestMethod.GET })
	public List<DropDownModel> getVendorListForProduct() {
		logger.info("Method : getVendorListForProduct starts");

		logger.info("Method : getVendorListForProduct ends");
		return productMasterDao.getVendorListForProduct();
	}

	@RequestMapping(value = "getVendorListForProductWise", method = { RequestMethod.GET })
	public List<DropDownModel> getVendorListForProductWise(@RequestParam String org, String orgDiv, String type) {
		logger.info("Method : getVendorListForProductWise starts");

		logger.info("Method : getVendorListForProductWise ends");
		return productMasterDao.getVendorListForProductWise(org, orgDiv, type);
	}

	@RequestMapping(value = "saveProductMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ProductMasterModel>> saveProductMaster(@RequestBody ProductMasterModel product) {
		logger.info("Method : saveProductMaster starts");

		logger.info("Method : saveProductMaster ends");
		return productMasterDao.saveProductMaster(product);
	}
	
	@RequestMapping(value = "saveBomMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveBomMaster(@RequestBody DropDownModel data) {
		logger.info("Method : saveBomMaster starts");
		
		logger.info("Method : saveBomMaster ends");
		return productMasterDao.saveBomMaster(data);
	}

	@RequestMapping(value = "saveProductDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ProductDetailsModel>> saveProductDetails(
			@RequestBody ProductDetailsModel product) {
		logger.info("Method : saveProductDetails starts");

		logger.info("Method : saveProductDetails ends");
		return productMasterDao.saveProductDetails(product);
	}

	@RequestMapping(value = "saveProductPurchaseDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ProductDetailsModel>> saveProductPurchaseDetails(
			@RequestBody ProductDetailsModel product) {
		logger.info("Method : saveProductPurchaseDetails starts");

		logger.info("Method : saveProductPurchaseDetails ends");
		return productMasterDao.saveProductPurchaseDetails(product);
	}

	@RequestMapping(value = "getProductSKUListing", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductMasterModel>>> getProductSKUListing(@RequestParam String type,
			String orgName, String orgDiv, String from) {
		logger.info("Method : getProductSKUListing starts");

		logger.info("Method : getProductSKUListing ends");
		return productMasterDao.getProductSKUListing(type, orgName, orgDiv, from);
	}

	@RequestMapping(value = "getSKUListingById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductDetailsModel>>> getSKUListingById(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method : getSKUListingById starts");

		logger.info("Method : getSKUListingById ends");
		return productMasterDao.getSKUListingById(id, orgName, orgDiv);
	}

	@RequestMapping(value = "getSKUPurchaseListingById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductDetailsModel>>> getSKUPurchaseListingById(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method : getSKUPurchaseListingById starts");

		logger.info("Method : getSKUPurchaseListingById ends");
		return productMasterDao.getSKUPurchaseListingById(id, orgName, orgDiv);
	}

	@RequestMapping(value = "getProductDetailsById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ProductMasterModel>> getProductDetailsById(@RequestParam String id,String orgName,String orgDiv) {
		logger.info("Method : getProductDetailsById starts");

		logger.info("Method : getProductDetailsById ends");
		return productMasterDao.getProductDetailsById(id, orgName, orgDiv);
	}

	@RequestMapping(value = "getSKUDetailsById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ProductDetailsModel>> getSKUDetailsById(@RequestParam String id,
			@RequestParam String skuid) {
		logger.info("Method : getSKUDetailsById starts");

		logger.info("Method : getSKUDetailsById ends");
		return productMasterDao.getSKUDetailsById(id, skuid);
	}

	@RequestMapping(value = "getSKUPurchaseDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ProductDetailsModel>> getSKUPurchaseDetails(@RequestParam String id,
			@RequestParam String skuid, @RequestParam String vendorId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method : getSKUPurchaseDetails starts");

		logger.info("Method : getSKUPurchaseDetails ends");
		return productMasterDao.getSKUPurchaseDetails(id, skuid, vendorId, orgName, orgDiv);
	}

	@RequestMapping(value = "getVariantDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<DropDownModel>> getVariantDetails(@RequestParam String id,
			@RequestParam String skuid) {
		logger.info("Method : getVariantDetails starts");

		logger.info("Method : getVariantDetails ends");
		return productMasterDao.getVariantDetails(id, skuid);
	}

	@GetMapping(value = "deletesku")
	public ResponseEntity<JsonResponse<Object>> deletesku(@RequestParam String id,String org, String orgDiv) {
		logger.info("Method : deletesku starts");

		logger.info("Method : deletesku ends");
		return productMasterDao.deletesku(id, org, orgDiv);
	}
	
	@GetMapping(value = "deletebom")
	public ResponseEntity<JsonResponse<Object>> deletebom(@RequestParam String id, String bomsku, String org, String orgDiv) {
		logger.info("Method : deletebom starts");

		logger.info("Method : deletebom ends");
		return productMasterDao.deletebom(id, bomsku, org, orgDiv);
	}
	
//deleteAssignedVendor
	@GetMapping(value = "deleteAssignedVendor")
	public ResponseEntity<JsonResponse<Object>> deleteAssignedVendor(@RequestParam String id, String sku,String userId,String org, String orgDiv) {
		logger.info("Method : deleteAssignedVendor starts");

		logger.info("Method : deleteAssignedVendor ends");
		return productMasterDao.deleteAssignedVendor(id, sku,userId,org, orgDiv);
	}

	@RequestMapping(value = "deleteProductMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteProductMaster(@RequestParam String id, String createdBy,String org,String orgDiv) {
		logger.info("Method : deleteProductMaster starts");

		logger.info("Method : deleteProductMaster ends");
		return productMasterDao.deleteProductMaster(id, createdBy, org, orgDiv);
	}

	@RequestMapping(value = "parentCategoryList", method = RequestMethod.GET)
	public ResponseEntity<JsonResponse<List<DropDownModel>>> parentCategoryList(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : parentCategoryList starts");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = productMasterDao.parentCategoryList(org, orgDiv);
		logger.info("Method : parentCategoryList ends");
		return response;
	}

	@RequestMapping(value = "subcategory", method = RequestMethod.GET)
	public ResponseEntity<JsonResponse<List<DropDownModel>>> subcategory(@RequestParam String org,
			@RequestParam String orgDiv, @RequestParam String id) {
		logger.info("Method : subcategory starts");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = productMasterDao.subcategory(org, orgDiv, id);
		logger.info("Method : subcategory ends");
		return response;
	}
	
	@RequestMapping(value = "getProduct", method = RequestMethod.GET)
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getProduct(@RequestParam String org,
			@RequestParam String orgDiv, @RequestParam String id) {
		logger.info("Method : getProduct starts");
		logger.info("Method : getProduct ends");
		return productMasterDao.getProduct(org, orgDiv, id);
	}

	@RequestMapping(value = "getIntailBrandList", method = RequestMethod.GET)
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIntailBrandList(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getIntailBrandList starts");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = productMasterDao.getIntailBrandList(org, orgDiv);
		logger.info("Method : getIntailBrandList ends");
		return response;
	}

	/** For New Version Product Category & Sub-Category **/

	@GetMapping(value = "getProductCategoryList")
	public List<DropDownModel> getProductCategoryList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getProductCategoryList starts");

		logger.info("Method : getProductCategoryList ends");
		return productMasterDao.getProductCategoryList(org,orgDiv);
	}
	//get-variation-list
	@RequestMapping(value = "get-variation-list", method = RequestMethod.GET)
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVariationList(@RequestParam String org,
			@RequestParam String orgDiv, @RequestParam String id) {
		logger.info("Method : subcategory starts");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = productMasterDao.getVariationList(org, orgDiv, id);
		logger.info("Method : subcategory ends");
		return response;
	}
	
	@RequestMapping(value = "get-item-list", method = RequestMethod.GET)
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemList(@RequestParam String org,
			@RequestParam String orgDiv, @RequestParam String id) {
		logger.info("Method : getItemList starts");

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = productMasterDao.getItemList(org, orgDiv, id);

		logger.info("Method : getItemList ends");
		return response;
	}
	
//getItemdDtailsBySku
	@RequestMapping(value = "getItemdDtailsBySku", method = { RequestMethod.GET })
	public JsonResponse<Object> getItemdDtailsBySku(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :getItemdDtailsBySku start");

		logger.info("Method :getItemdDtailsBySku endss");
		return productMasterDao.getItemdDtailsBySku(id, org, orgDiv);
	}	
}
