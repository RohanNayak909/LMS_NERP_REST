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
import nirmalya.aatithya.restmodule.productionplan.dao.LmrLogDao;
import nirmalya.aatithya.restmodule.productionplan.model.LmrLogRestModel;


@RestController
@RequestMapping(value = { "production/" })
public class RestLmrLogController {
	
	Logger logger = LoggerFactory.getLogger(RestLmrLogController.class);
	
	@Autowired
	LmrLogDao lmrLogDao;
	
	// MAchine List.
	

	@RequestMapping(value = "rest-lmrLog-machineList", method = { RequestMethod.GET })
	public JsonResponse<Object> lmrMachineList(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :lmrMachineList start");

		logger.info("Method :lmrMachineList endss");
		return lmrLogDao.lmrMachineList(id, orgName, orgDivision);
	}
	
	// Add
	
	
	@PostMapping(value = "addLmrLog")
	public JsonResponse<Object> addPackingLogbook(
			@RequestBody LmrLogRestModel offDay) {
		logger.info("Method :addLmrLog starts");

		logger.info("Method :addLmrLog endss");
		return lmrLogDao.addLmrLog(offDay);
	}
	
	// view
	
	@RequestMapping(value = "viewLmrLog", method = { RequestMethod.GET })
	public JsonResponse<Object> viewLmrLog(@RequestParam String org, String orgDiv, String pageno) {
		logger.info("Method :viewLmrLog start");

		logger.info("Method :viewLmrLog endss");
		return lmrLogDao.viewLmrLog( org, orgDiv, pageno);
	}
	
	// View Edit
	
	@RequestMapping(value = "rest-editLmrLogView", method = { RequestMethod.GET })
	public JsonResponse<Object> editLmrLogView(@RequestParam String id , String itemFlag , String org, String orgDiv) {
		logger.info("Method :editLmrLogView start");

		
		logger.info("Method :editLmrLogView endss");
		return lmrLogDao.editLmrLogView( id, itemFlag , org, orgDiv);
	}
	
	
	// Add part b
	
	@PostMapping(value = "rest-addPartBIngd")
	public ResponseEntity<JsonResponse<LmrLogRestModel>> addPartBIngd(
			@RequestBody LmrLogRestModel offDay) {
		logger.info("Method :addPartBIngd starts");

		logger.info("Method :addPartBIngd endss");
		return lmrLogDao.addPartBIngd(offDay);
	}
	
	
	// View part b
	
	@RequestMapping(value = "rest-partBIngredientView", method = { RequestMethod.GET })
	public JsonResponse<Object> partBIngredientView(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :partBIngredientView start");

		logger.info("Method :partBIngredientView endss");
		return lmrLogDao.partBIngredientView( id, org, orgDiv);
	}
	
	
	// Add femto blending
	
	@PostMapping(value = "rest-addFemtoBlending")
	public ResponseEntity<JsonResponse<LmrLogRestModel>> addFemtoBlending(
			@RequestBody LmrLogRestModel offDay) {
		logger.info("Method :addFemtoBlending starts");

		logger.info("Method :addFemtoBlending endss");
		return lmrLogDao.addFemtoBlending(offDay);
	}
	
	
	// Add weighing scale
	
	@PostMapping(value = "rest-addWeighingScale")
	public ResponseEntity<JsonResponse<LmrLogRestModel>> addWeighingScale(
			@RequestBody LmrLogRestModel offDay) {
		logger.info("Method :addWeighingScale starts");

		logger.info("Method :addWeighingScale endss");
		return lmrLogDao.addWeighingScale(offDay);
	}
	
	

	// Add area line clearance
	
	@PostMapping(value = "rest-addAreaLineClearance")
	public ResponseEntity<JsonResponse<LmrLogRestModel>> addAreaLineClearance(
			@RequestBody LmrLogRestModel offDay) {
		logger.info("Method :addAreaLineClearance starts");

		logger.info("Method :addAreaLineClearance endss");
		return lmrLogDao.addAreaLineClearance(offDay);
	}
	
	
	// Delete
	
		@RequestMapping(value = "rest-deleteLmrLog", method = { RequestMethod.GET })
		public JsonResponse<Object> deleteLmrLog(@RequestParam String id, String org, String orgDiv) {
			logger.info("Method :deleteLmrLog start");

			logger.info("Method :deleteLmrLog endss");
			return lmrLogDao.deleteLmrLog( id, org, orgDiv);
		}
		
		/*
		 * 
		 * //getLineLists-LMR
		 * 
		 * @RequestMapping(value = "getLineLists-Lmr", method = { RequestMethod.GET })
		 * public List<DropDownModel> getLineListsLmr(@RequestParam String org,String
		 * orgDiv) { logger.info("Method : getLineListsLmr starts");
		 * 
		 * logger.info("Method : getLineListsLmr ends"); return
		 * lmrLogDao.getLineListsLmr(org,orgDiv); }
		 */
		
	//getLineListsApi
		@RequestMapping(value = "getLineLists-Lmr-api", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getLineListsLmrApi(@RequestParam String org,String orgDiv) {
			logger.info("Method : getLineListsLmrApi starts");
			
			logger.info("Method : getLineListsLmrApi ends");
			return lmrLogDao.getLineListsLmrApi(org,orgDiv);
		}
		
		
		// Pdf.
		
		@RequestMapping(value = "rest-lmr-pdf-dtls", method = { RequestMethod.GET })
		public JsonResponse<Object> downloadLmrPdf(@RequestParam String id, String type, String orgName, String orgDivision) {
			logger.info("Method :downloadLmrPdf start");

			logger.info("Method :downloadLmrPdf endss");
			return lmrLogDao.downloadLmrPdf(id,type, orgName, orgDivision);
		}
		
		
		// Search
		
		@RequestMapping(value = "rest-lmrLogDataViewSearch", method = { RequestMethod.GET })
		public JsonResponse<Object> lmrLogDataViewSearch(@RequestParam String orgName, @RequestParam String orgDivision, String searchValue) {
			logger.info("Method :lmrLogDataViewSearch start");

			logger.info("Method :lmrLogDataViewSearch endss");
			return lmrLogDao.lmrLogDataViewSearch(orgName, orgDivision, searchValue);

		}

}
