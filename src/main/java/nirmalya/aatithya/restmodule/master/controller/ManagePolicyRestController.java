package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.ManagePolicyDao;
import nirmalya.aatithya.restmodule.master.model.ManagePolicyRestModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class ManagePolicyRestController {
	
	Logger logger = LoggerFactory.getLogger(ManagePolicyRestController.class);

	@Autowired
	ManagePolicyDao managePolicyDao;
	
	@GetMapping(value = "get-all-departmentList")
	public List<DropDownModel> dropDownshift(@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : dropDownshift starts");

		logger.info("Method : dropDownshift ends");
		return managePolicyDao.getDeptList(organization,orgDivision);
	}
	
	//add notice policy
	
	@PostMapping(value = "save-notice-policy")
	public ResponseEntity<JsonResponse<ManagePolicyRestModel>> addNoticePolicy(
			@RequestBody ManagePolicyRestModel notice) {
		logger.info("Method : addNoticePolicy starts");
		
		
		logger.info("Method : addNoticePolicy ends");
		return managePolicyDao.addNoticePolicy(notice);
	}
	
	
}
