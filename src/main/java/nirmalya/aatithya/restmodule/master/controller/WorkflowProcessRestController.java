package nirmalya.aatithya.restmodule.master.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.WarehouseItemConfigurationDao;
import nirmalya.aatithya.restmodule.master.dao.WorkflowProcessDao;
import nirmalya.aatithya.restmodule.master.model.UserStateModel;
import nirmalya.aatithya.restmodule.master.model.WorkflowProcessRestModal;

@RestController
@RequestMapping(value = { "master" })
public class WorkflowProcessRestController {
	Logger logger = LoggerFactory.getLogger(WorkflowProcessRestController.class);
	
	@Autowired
	WorkflowProcessDao workflowProcessDao;
	
	@RequestMapping(value = "saveWorkflowData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restSaveWorkflowData(@RequestBody WorkflowProcessRestModal workflowProcessRestModal) {
		logger.info("Method : restSaveWorkflowData starts");

		logger.info("Method : restSaveWorkflowData ends");
		return workflowProcessDao.saveWorkflowProcessData(workflowProcessRestModal);
	}

}
