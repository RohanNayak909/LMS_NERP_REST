package nirmalya.aatithya.restmodule.productionplan.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.productionplan.dao.ManageShopFloorRestDao;
import nirmalya.aatithya.restmodule.productionplan.model.RestManageShopFloorModel;

@RestController
@RequestMapping("production")
public class ManageShopFloorRestController {
	Logger logger = LoggerFactory.getLogger(ManageShopFloorRestController.class);
	@Autowired
	ManageShopFloorRestDao floorDao;
	
	
	/*
	 * @GetMapping(value = "getManageShopFloor") public JsonResponse<Object>
	 * getManageShopFloor(@RequestParam String date,String shift, String
	 * orgName,String orgDiv,String uType,String userId) {
	 * logger.info("Method : getManageShopFloor starts");
	 * logger.info("Method :getManageShopFloor endss"); return
	 * floorDao.getManageShopFloor(date,shift, orgName, orgDiv,uType,userId); }
	 */
	
	@GetMapping(value = "rest-getShiftWiseMcDetls")
	public JsonResponse<Object> getShiftWiseMcDetls(@RequestParam String date,String shift, String orgName,String orgDiv) {
		logger.info("Method : getShiftWiseMcDetls starts");
		logger.info("Method :getShiftWiseMcDetls endss");
		return floorDao.getShiftWiseMcDetls(date,shift, orgName, orgDiv);
	}
	
	// add.
	
	@PostMapping(value = "rest-addShopFloor")
	public ResponseEntity<JsonResponse<RestManageShopFloorModel>> addLaminates(

			@RequestBody RestManageShopFloorModel restManageShopFloorModel) {
		logger.info("Method : addShopFloor starts");
		logger.info("Method : addShopFloor ends");
		return floorDao.addShopFloor(restManageShopFloorModel);
	}
	
	// View
		@RequestMapping(value = "rest-getShoopFloorView", method = { RequestMethod.GET })
		public JsonResponse<Object> getShoopFloorView(@RequestParam String orgName, String orgDivision) {
			logger.info("Method :getShoopFloorView start");

			logger.info("Method :getShoopFloorView endss");
			return floorDao.getShoopFloorView(orgName, orgDivision);
		}
		
		
		
		//Edit.
		
		@RequestMapping(value = "rest-editFloorData", method = { RequestMethod.GET })
		public JsonResponse<Object> editFloorData(@RequestParam String id, String orgName, String orgDivision) {
			logger.info("Method :editFloorData start");

			logger.info("Method :editFloorData endss");
			return floorDao.editFloorData(id, orgName, orgDivision);
		}
		
		
		// add Break Down.
		@RequestMapping(value = "rest-addBreakDown", method = { RequestMethod.POST })
		public JsonResponse<Object> addBreakDown(

				@RequestBody RestManageShopFloorModel restManageShopFloorModel) {
			logger.info("Method : addBreakDown starts");
			logger.info("Method : addBreakDown ends");
			return floorDao.addBreakDown(restManageShopFloorModel);
		}
		
		

		// Approve.
		
		@RequestMapping(value = "rest-approveShopFloor", method = { RequestMethod.GET })
		public JsonResponse<Object> approveShopFloor(@RequestParam String id, String orgName, String orgDivision, String approvedBy) {
			logger.info("Method :approveShopFloor start");

			logger.info("Method :approveShopFloor endss");
			return floorDao.approveShopFloor(id, orgName, orgDivision, approvedBy);
		}
		

		// Delete.
		
		@RequestMapping(value = "rest-deleteShopFloor", method = { RequestMethod.GET })
		public JsonResponse<Object> deleteShopFloor(@RequestParam String id, String orgName, String orgDivision) {
			logger.info("Method :deleteShopFloor start");

			logger.info("Method :deleteShopFloor endss");
			return floorDao.deleteShopFloor(id, orgName, orgDivision);
		}
	
		// BreakDown PDF
		@RequestMapping(value = "rest-breakDownPdf", method = { RequestMethod.GET })
		public JsonResponse<Object> breakDownPdf(@RequestParam String id, String mcNo, String sku, String orgName, String orgDivision) {
			logger.info("Method :breakDownPdf start");

			logger.info("Method :breakDownPdf endss");
			return floorDao.breakDownPdf(id, mcNo, sku, orgName, orgDivision);
		}
}

