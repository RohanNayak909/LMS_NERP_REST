package nirmalya.aatithya.restmodule.edms.controller;

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
import nirmalya.aatithya.restmodule.edms.dao.RestWorkFlowApproveDao;
import nirmalya.aatithya.restmodule.edms.model.RestDocumentControlModel;

@RestController
@RequestMapping(value = "edms/")
public class RestWorkFlowApproveController {

	Logger logger = LoggerFactory.getLogger(RestWorkFlowApproveController.class);

	@Autowired
	RestWorkFlowApproveDao restWorkFlowApproveDao;

	@RequestMapping(value = "rest-workFlowApproveView", method = { RequestMethod.GET })
	public JsonResponse<Object> workFlowApproveView(@RequestParam String userId, @RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :workFlowApproveView start");

		logger.info("Method :workFlowApproveView endss ");
		return restWorkFlowApproveDao.workFlowApproveView(userId, orgName, orgDivision);

	}

	@PostMapping(value = "rest-approveWorkFlow")
	public ResponseEntity<JsonResponse<RestDocumentControlModel>> approveWorkFlow(@RequestBody RestDocumentControlModel restDocumentControlModel) {
		logger.info("Method : approveWorkFlow starts");
		logger.info("Method : approveWorkFlow ends");
		return restWorkFlowApproveDao.approveWorkFlow(restDocumentControlModel);
	}
}
