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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestManagerAppraisalDao;
import nirmalya.aatithya.restmodule.master.model.AppraisalKeyFactorRestModel;
@RestController
@RequestMapping(value = "master/")
public class RestManagerAppraisal {
Logger logger = LoggerFactory.getLogger(RestManagerAppraisal.class);
	
	@Autowired
	RestManagerAppraisalDao RestManagerAppraisalDao;

	
	
	@RequestMapping(value = "rest-viewMAnagerAppraisalData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewManagerAppraisal(@RequestParam String orgName, String orgDivision,@RequestParam String userid) {
		logger.info("Method :viewManagerAppraisal start");

		logger.info("Method :viewManagerAppraisal endss");
		return RestManagerAppraisalDao.viewManagerAppraisal(orgName, orgDivision,userid);
	}
	
	@RequestMapping(value = "rest-editManagerAppraisalData", method = { RequestMethod.GET })
	public JsonResponse<Object> editManagerAppraisalData(@RequestParam String orgName, String orgDivision,String id,String assignid) {
		logger.info("Method :editManagerAppraisalData start");

		logger.info("Method :editManagerAppraisalData endss");
		return RestManagerAppraisalDao.editManagerAppraisalData(orgName, orgDivision,id,assignid);
	}
	
	@PostMapping(value = "rest-managerAppraisalAdd")
	public ResponseEntity<JsonResponse<List<AppraisalKeyFactorRestModel>>> appraisalKeyfactorAdd(
			@RequestBody List<AppraisalKeyFactorRestModel> assetPolicyModel) {
		logger.info("Method : managerAppraisalAdd starts");
		logger.info("Method : managerAppraisalAdd ends");
		return RestManagerAppraisalDao.managerAppraisalAdd(assetPolicyModel);
	}
}
