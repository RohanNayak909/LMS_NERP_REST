package nirmalya.aatithya.restmodule.warehouse.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.dao.WarehouseBatchCreationDao;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping(value = "master")
public class RestWarehouseBatchCreationController {
	Logger logger = LoggerFactory.getLogger(RestWarehouseBatchCreationController.class);

	@Autowired
	WarehouseBatchCreationDao warehouseBatchCreationDao;
	
	//saveBatch
		@PostMapping(value = "saveBatchData")
		public ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> saveBatchData(
				@RequestBody List<WirehouseRomeModel> wirehouseRomeModel) {
			logger.info("Method :saveBatchData starts");
			
			logger.info("Method :saveBatchData endss");
			return warehouseBatchCreationDao.saveBatchData(wirehouseRomeModel);
		}
		//View Batch
		@RequestMapping(value = "viewBatchData", method = { RequestMethod.GET })
		public JsonResponse<Object> viewBatchData(@RequestParam String orgName, String orgDivision) {
			logger.info("Method :viewBatchData start");

			logger.info("Method :viewBatchData endss");
			return warehouseBatchCreationDao.viewBatchData(orgName, orgDivision);

		}
		
		//Edit Batch Data
		//View Bin Data
		@RequestMapping(value = "rest-editBatchData", method = { RequestMethod.GET })
		public JsonResponse editBatchData(@RequestParam String batchId, String org,
				 String orgDiv) {
			logger.info("Method :editBatchData start");

			logger.info("Method :editBatchData endss");
			return warehouseBatchCreationDao.editBatchData(batchId,org, orgDiv);

		}
		
		//delete Batch Data
		  @GetMapping(value = "deleteBatchdata")
			public JsonResponse<Object> deleteBatchdata(@RequestParam String batchId,String orgName,String orgDivision) {
				logger.info("Method : deleteBatchdata starts");
				logger.info("Method : deleteBatchdata ends");
				return warehouseBatchCreationDao.deleteBatchdata(batchId,orgName, orgDivision);
			}
		//Approve Batch
		  @GetMapping(value="approveBatch")
		 	public JsonResponse<WirehouseRomeModel> approveBatch(@RequestParam String approveStatus,
		 			String batchId,String orgName,String orgDivision){
		 		logger.info("Method : approveBatch starts");
		 		
		 		logger.info("Method : approveBatch ends");
		 	return warehouseBatchCreationDao.approveBatch(approveStatus, batchId,orgName, orgDivision);
		 	}
}
