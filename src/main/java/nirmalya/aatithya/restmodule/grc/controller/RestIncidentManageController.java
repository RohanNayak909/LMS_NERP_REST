package nirmalya.aatithya.restmodule.grc.controller;

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
import nirmalya.aatithya.restmodule.grc.dao.RestIncidentManageDao;
import nirmalya.aatithya.restmodule.grc.model.RestIncidentManageModel;

@RestController
@RequestMapping(value = "grc/")
public class RestIncidentManageController {

	Logger logger = LoggerFactory.getLogger(RestIncidentManageController.class);

	@Autowired
	RestIncidentManageDao restIncidentManageDao;
	
	/* add */
	
	@RequestMapping(value = "incident-manage-rest-add", method = {RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addManage(@RequestBody RestIncidentManageModel restData){
		logger.info("Method : addManage starts"/* +restData */); 
			
		logger.info("Method : addManag ends");
		return restIncidentManageDao.addManageDao(restData);
	}
	
	/* Auto SearchList */
	
	@GetMapping(value = "rest-getAssignToAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssignToAutoSearchList(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getVendorAutoSearchList starts");

		logger.info("Method :getVendorAutoSearchList endss");
		return restIncidentManageDao.getAssignToAutoSearchList(id);
	}

	/* view */

	@GetMapping(value = "incident-manage-rest-view")
	public JsonResponse<List<RestIncidentManageModel>> viewManage(@RequestParam String id, String uId, 
			String orgName,String orgDivision) {
		logger.info("Method : viewManage starts");

		logger.info("Method : viewManage ends");
		return restIncidentManageDao.viewManageDao(id,uId,orgName,orgDivision);
	}

	/* edit */

	@RequestMapping(value = "incident-manage-rest-edit", method = { RequestMethod.GET })
	public JsonResponse<RestIncidentManageModel> editManageMaster(@RequestParam String id, String uId, String orgName,
			String orgDivision) {
			
		logger.info("Method : editManage rest starts");

		logger.info("Method :editManage rest ends");
		return restIncidentManageDao.editManageDao(id, uId, orgName, orgDivision);
	}

	/* delete */

	@RequestMapping(value = "incident-manage-rest-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteManage(@RequestParam String id, String uId, String orgName,
			String orgDivision) {
		logger.info("Method : deleteManage starts");

		logger.info("Method : deleteManage ends");
		return restIncidentManageDao.deleteManageDao(id, uId, orgName, orgDivision);
	}
}
