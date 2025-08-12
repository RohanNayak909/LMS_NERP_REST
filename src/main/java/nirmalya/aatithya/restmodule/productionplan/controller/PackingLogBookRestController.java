package nirmalya.aatithya.restmodule.productionplan.controller;

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
import nirmalya.aatithya.restmodule.productionplan.model.PackingLogBookRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingLotManufacturRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.Packing2AFSSMachineRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingInitialCheckRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingALCRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingFCWLRestModel;

import nirmalya.aatithya.restmodule.productionplan.dao.PackingLogBookDao;

@RestController
@RequestMapping(value = { "production/" })
public class PackingLogBookRestController {
	Logger logger = LoggerFactory.getLogger(PackingLogBookRestController.class);

	@Autowired
	PackingLogBookDao packingLogbook;
	
	@PostMapping(value = "addPackingLogbook")
	public ResponseEntity<JsonResponse<PackingLogBookRestModel>> addPackingLogbook(
			@RequestBody PackingLogBookRestModel offDay) {
		logger.info("Method :addPackingLogbook starts");

		logger.info("Method :addPackingLogbook endss");
		return packingLogbook.addPackingLogbook(offDay);
	}
	@RequestMapping(value = "viewPackingLogbook", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPackingLogbook(@RequestParam String org, String orgDiv, String pageno) {
		logger.info("Method :viewPackingLogbook start");

		logger.info("Method :viewPackingLogbook endss");
		return packingLogbook.viewPackingLogbook( org, orgDiv, pageno);
	}
	@RequestMapping(value = "viewEditPackingLogbook", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEditPackingLogbook(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :viewEditPackingLogbook start");

		logger.info("Method :viewEditPackingLogbook endss");
		return packingLogbook.viewEditPackingLogbook( id, org, orgDiv);
	}
	@RequestMapping(value = "deletePackingLogbook", method = { RequestMethod.GET })
	public JsonResponse<Object> deletePackingLogbook(@RequestParam String id, String org,String orgDiv) {
		logger.info("Method :deletePackingLogbook start");

		logger.info("Method :deletePackingLogbook endss");
		return packingLogbook.deletePackingLogbook(id, org, orgDiv);
	}
//	Lot  Management
	@RequestMapping(value = "viewlotmanagement", method = { RequestMethod.GET })
	public JsonResponse<Object> viewlotmanagement(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :viewlotmanagement start");

		logger.info("Method :viewlotmanagement endss");
		return packingLogbook.viewEditlotmanagement( id, org, orgDiv);
	}
	@PostMapping(value = "addLotManufacture")
	public ResponseEntity<JsonResponse<PackingLotManufacturRestModel>> addLotManufacture(
			@RequestBody PackingLotManufacturRestModel offDay) {
		logger.info("Method :addLotManufacture starts");

		logger.info("Method :addLotManufacture endss");
		return packingLogbook.addLotManufacture(offDay);
	}
	
//	2A FSS Machine
	@PostMapping(value = "add2AFSSMachine")
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> add2AFSSMachine(
			@RequestBody Packing2AFSSMachineRestModel offDay) {
		logger.info("Method :add2AFSSMachine starts");

		logger.info("Method :add2AFSSMachine endss");
		return packingLogbook.add2AFSSMachine(offDay);
	}
	@RequestMapping(value = "view2AFSSMachine", method = { RequestMethod.GET })
	public JsonResponse<Object> view2AFSSMachine(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :view2AFSSMachine start");

		logger.info("Method :view2AFSSMachine endss");
		return packingLogbook.view2AFSSMachine( id, org, orgDiv);
	}
//	2B FSS Machine
	@PostMapping(value = "save2BFSSMachine")
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> save2BFSSMachine(
			@RequestBody Packing2AFSSMachineRestModel offDay) {
		logger.info("Method :save2BFSSMachine starts");

		logger.info("Method :save2BFSSMachine endss");
		return packingLogbook.save2BFSSMachine(offDay);
	}
	@RequestMapping(value = "view2BFSSMachine", method = { RequestMethod.GET })
	public JsonResponse<Object> view2BFSSMachine(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :view2BFSSMachine start");

		logger.info("Method :view2BFSSMachine endss");
		return packingLogbook.view2BFSSMachine( id, org, orgDiv);
	}
//5.Inspection Of Non-Blending Bulk Powder & Batch Coding Record
	@PostMapping(value = "save5INBBPBCR")
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> save5INBBPBCR(
			@RequestBody Packing2AFSSMachineRestModel offDay) {
		logger.info("Method :save5INBBPBCR starts");
		
		logger.info("Method :save5INBBPBCR endss");
		return packingLogbook.save5INBBPBCR(offDay);
	}
	@RequestMapping(value = "view5INBBPBCR", method = { RequestMethod.GET })
	public JsonResponse<Object> view5INBBPBCR(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :view5INBBPBCR start");

		logger.info("Method :view5INBBPBCR endss");
		return packingLogbook.view5INBBPBCR( id, org, orgDiv);
	}
//6. RH/TEMP CHECKS-SACHET / POUCH LINE
	@PostMapping(value = "saveRHTemp")
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> saveRHTemp(
			@RequestBody Packing2AFSSMachineRestModel offDay) {
		logger.info("Method :saveRHTemp starts");
		
		logger.info("Method :saveRHTemp endss");
		return packingLogbook.saveRHTemp(offDay);
	}
	@RequestMapping(value = "viewRHTemp", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRHTemp(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :view5INBBPBCR start");

		logger.info("Method :viewRHTemp endss");
		return packingLogbook.viewRHTemp( id, org, orgDiv);
	}
// 9. Challenge Test - Sachet / Pouch Line		
	@PostMapping(value = "saveChalTest")
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> saveChalTest(
			@RequestBody Packing2AFSSMachineRestModel offDay) {
		logger.info("Method :saveChalTest starts");
		
		logger.info("Method :saveChalTest endss");
		return packingLogbook.saveChalTest(offDay);
	}
	@RequestMapping(value = "getChalTest", method = { RequestMethod.GET })
	public JsonResponse<Object> getChalTest(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :getChalTest start");

		logger.info("Method :getChalTest endss");
		return packingLogbook.getChalTest( id, org, orgDiv);
	}	

//  GTP	
	@PostMapping(value = "saveGTP")
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> saveGTP(
			@RequestBody Packing2AFSSMachineRestModel offDay) {
		logger.info("Method :saveGTP starts");
		
		logger.info("Method :saveGTP endss");
		return packingLogbook.saveGTP(offDay);
	}
	@RequestMapping(value = "getGTP", method = { RequestMethod.GET })
	public JsonResponse<Object> getGTP(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :getGTP start");

		logger.info("Method :getGTP endss");
		return packingLogbook.getGTP( id, org, orgDiv);
	}	
//  CTQ	
	@PostMapping(value = "saveCTQ")
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> saveCTQ(
			@RequestBody Packing2AFSSMachineRestModel offDay) {
		logger.info("Method :saveCTQ starts");
		
		logger.info("Method :saveCTQ endss");
		return packingLogbook.saveCTQ(offDay);
	}
	@RequestMapping(value = "getCTQ", method = { RequestMethod.GET })
	public JsonResponse<Object> getCTQ(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :getCTQ start");

		logger.info("Method :getCTQ endss");
		return packingLogbook.getCTQ( id, org, orgDiv);
	}		
//  InitialCheck	
	@PostMapping(value = "saveInitialCheck")
	public ResponseEntity<JsonResponse<PackingInitialCheckRestModel>> saveInitialCheck(
			@RequestBody PackingInitialCheckRestModel offDay) {
		logger.info("Method :saveInitialCheck starts");
		
		logger.info("Method :saveInitialCheck endss");
		return packingLogbook.saveInitialCheck(offDay);
	}
	@RequestMapping(value = "getInitialCheck", method = { RequestMethod.GET })
	public JsonResponse<Object> getInitialCheck(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :getInitialCheck start");

		logger.info("Method :getInitialCheck endss");
		return packingLogbook.getInitialCheck( id, org, orgDiv);
	}	
//  ALC	
	@PostMapping(value = "saveALC")
	public ResponseEntity<JsonResponse<PackingALCRestModel>> saveALC(
			@RequestBody PackingALCRestModel offDay) {
		logger.info("Method :saveALC starts");
		
		logger.info("Method :saveALC endss");
		return packingLogbook.saveALC(offDay);
	}
	@RequestMapping(value = "getALC", method = { RequestMethod.GET })
	public JsonResponse<Object> getALC(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :getALC start");

		logger.info("Method :getALC endss");
		return packingLogbook.getALC( id, org, orgDiv);
	}	
//  FCWL	
	@PostMapping(value = "saveFCWL")
	public ResponseEntity<JsonResponse<PackingFCWLRestModel>> saveFCWL(
			@RequestBody PackingFCWLRestModel offDay) {
		logger.info("Method :saveFCWL starts");
		
		logger.info("Method :saveFCWL endss");
		return packingLogbook.saveFCWL(offDay);
	}
	@RequestMapping(value = "getFCWL", method = { RequestMethod.GET })
	public JsonResponse<Object> getFCWL(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :getFCWL start");

		logger.info("Method :getFCWL endss");
		return packingLogbook.getFCWL( id, org, orgDiv);
	}
	
	
	@RequestMapping(value = "logManufacturePdf", method = { RequestMethod.GET })
	public JsonResponse<Object> logManufacturePdf(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :logManufacturePdf start");

		logger.info("Method :logManufacturePdf endss");
		return packingLogbook.logManufacturePdf( id, org, orgDiv);
	}

	@RequestMapping(value = "viewPackingLogbookSearch", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPackingLogbookSearch(@RequestParam String org, String orgDiv, String searchValue) {
		logger.info("Method :viewPackingLogbookSearch start");

		logger.info("Method :viewPackingLogbookSearch endss");
		return packingLogbook.viewPackingLogbookSearch( org, orgDiv, searchValue);
	}
	@RequestMapping(value = "getLineLists-api", method = { RequestMethod.GET })
	public JsonResponse<Object> getLineLists(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : getLineLists starts");
		
		logger.info("Method : getLineLists ends");
		return packingLogbook.getLineLists(id,org,orgDiv);
	}
}
