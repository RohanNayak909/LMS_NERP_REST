package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.RestOtherBenifitsControllerDao;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;
import nirmalya.aatithya.restmodule.master.model.RestOtherBenifitsModel;

@RestController
@RequestMapping("master/")
public class RestOtherBenifitsController {
	Logger logger = LoggerFactory.getLogger(RestOtherBenifitsController.class);

	@Autowired

	RestOtherBenifitsControllerDao restOtherBenifitsControllerDao;
	
	@RequestMapping(value = "getOtherBenifit", method = { RequestMethod.GET })
	public List<DropDownModel> getOtherBenifit(@RequestParam String org, String orgDiv) {
		logger.info("Method : getOtherBenifit starts");

		logger.info("Method : getOtherBenifit ends");
		return restOtherBenifitsControllerDao.getOtherBenifit(org,orgDiv);
	}
	@PostMapping(value="saveOtherBanifits")
	public ResponseEntity<JsonResponse<Object>> saveAdvanceDetailsApply(@RequestBody RestOtherBenifitsModel restOtherBenifitsModel){
		logger.info("Method : saveOtherBanifits starts");
		
		logger.info("Method : saveOtherBanifits ends");
		return restOtherBenifitsControllerDao.saveOtherBanifits(restOtherBenifitsModel);
	}
	
	@RequestMapping(value = "viewBenifitsData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewBenifitsData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewBenifitsData start");

		logger.info("Method :viewBenifitsData endss");
		return restOtherBenifitsControllerDao.viewBenifitsData(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-deleteBenifit", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteBenifit(@RequestParam String id, String org,String orgDiv) {
		logger.info("Method :deleteBenifit start");

		logger.info("Method :deleteBenifit endss");
		return restOtherBenifitsControllerDao.deleteBenifit(id,org, orgDiv);
	}
	@RequestMapping(value = "rest-approveBenifitdata", method = { RequestMethod.GET })
	public JsonResponse<Object> approveBenifitdata(@RequestParam String id, String org,String orgDiv) {
		logger.info("Method :approveBenifitdata start");

		logger.info("Method :approveBenifitdata endss");
		return restOtherBenifitsControllerDao.approveBenifitdata(id,org, orgDiv);
	}
	@RequestMapping(value = "editBenifitData", method = { RequestMethod.GET })
	public JsonResponse<Object> editBenifitData(@RequestParam String benifitId,String orgName, String orgDivision) {
		logger.info("Method :editBenifitData start");

		logger.info("Method :editBenifitData endss");
		return restOtherBenifitsControllerDao.editBenifitData(benifitId,orgName, orgDivision);
	}
	@RequestMapping(value = "rest-view-other-benifits-get-frequency", method = { RequestMethod.GET })
	public JsonResponse<Object> getFrequency(@RequestParam String category, String orgName, String orgDivision) {
		logger.info("Method :getFrequency start");

		logger.info("Method :getFrequency endss");
		return restOtherBenifitsControllerDao.getFrequency(category, orgName, orgDivision);
	}
}
