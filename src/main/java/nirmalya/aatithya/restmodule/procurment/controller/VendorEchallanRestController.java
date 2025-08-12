package nirmalya.aatithya.restmodule.procurment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.dao.InventoryVendorInvoiceDao;
import nirmalya.aatithya.restmodule.procurment.dao.VendorEchallanDao;
import nirmalya.aatithya.restmodule.procurment.model.InventoryActionInvoiceModel;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestManagePropertyModel;

@RestController
@RequestMapping(value = { "inventory/" })
public class VendorEchallanRestController {
	Logger logger = LoggerFactory.getLogger(VendorEchallanRestController.class);

	@Autowired
	VendorEchallanDao vendorEchallanDao;
	
	@GetMapping(value = "get-vendor-challan-view-list")
	public List<InventoryActionInvoiceModel> getchallanViewList(@RequestParam String vendorId,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getchallanViewList starts");
		logger.info("Method : getchallanViewListendss");
		return vendorEchallanDao.getchallanViewList(vendorId,org,orgDiv);
	}
	
	/*
	 * @GetMapping(value = "get-challan-edit") public InventoryActionInvoiceModel
	 * get-challan-edit(@RequestParam String id,@RequestParam String org,
	 * 
	 * @RequestParam String orgDiv) { logger.info("Method : geInvoiceEdit starts");
	 * logger.info("Method : geInvoiceEdit endss"); return
	 * vendorEchallanDao.geChallanEdit(id,org,orgDiv); }
	 */
	
	@GetMapping(value = "get-challan-edit")
	public InventoryActionInvoiceModel geChallanEdit(@RequestParam String id) {
		logger.info("Method : geChallanEdit starts");

		logger.info("Method :geChallanEdit ends"+id);
		return vendorEchallanDao.geChallanEdit(id);

		}
	
	@GetMapping(value="get-challan-pdfDetails")
	public JsonResponse<List<InventoryActionInvoiceModel>> getChallanPdfDetails(@RequestParam String id ,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : getChallanPdfDetails starts");
		
		logger.info("Method : getChallanPdfDetails ends");
		return vendorEchallanDao.getChallanPdfDetails(id,organization,orgDivision);
	}
}
