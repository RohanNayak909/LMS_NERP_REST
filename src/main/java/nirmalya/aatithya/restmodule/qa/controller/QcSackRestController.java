package nirmalya.aatithya.restmodule.qa.controller;
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
 
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.employee.dao.TravelRequsitionRestDao;
import nirmalya.aatithya.restmodule.employee.model.TravelRequisitionRestModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.qa.dao.QcMasterDao;
import nirmalya.aatithya.restmodule.qa.dao.QcPcroDao;
import nirmalya.aatithya.restmodule.qa.dao.QcSackRestDao;
import nirmalya.aatithya.restmodule.qa.model.QaPcroRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaSackRestModel;
import nirmalya.aatithya.restmodule.qa.model.QcMasterRestModel;

@RestController
@RequestMapping(value = { "production/" })
public class QcSackRestController {
	
	Logger logger = LoggerFactory.getLogger(QcSackRestController.class);
	
	@Autowired
	QcSackRestDao qcSackRestDao;
	
	
	@RequestMapping(value = "rest-sack-shift-slno", method = { RequestMethod.GET })
	public JsonResponse<Object> getShiftSlno(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getShiftSlno start");

		logger.info("Method :getShiftSlno endss");
		return qcSackRestDao.getShiftSlno(orgName, orgDivision);
	}
	
	
	// add
	
	@PostMapping(value = "rest-sack-details-add")
	public ResponseEntity<JsonResponse<List<QaSackRestModel>>> addSack(

			@RequestBody List<QaSackRestModel> qaSackRestModel) {
		logger.info("Method : addSack starts");
		logger.info("Method : addSack ends");
		return qcSackRestDao.addSack(qaSackRestModel);
	}
	
	// viewMain
	@RequestMapping(value = "rest-sack -view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewSack(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewSack start");

		logger.info("Method :viewSack endss");
		return qcSackRestDao.viewSack(orgName, orgDivision);
	}
		
		// edit
				@RequestMapping(value = "rest-sack-reqst-editview", method = { RequestMethod.GET })
				public JsonResponse<Object> editSack(@RequestParam String id, String orgName, String orgDivision) {
					logger.info("Method :editSack start");

					logger.info("Method :editSack endss");
					return qcSackRestDao.editSack(id, orgName, orgDivision);
				}
				
				
				// delete
				@RequestMapping(value = "rest-sack-detls-delete", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<Object>> deleteSack(@RequestParam String id, String org, String div) {
					logger.info("Method : deleteSack starts");

					logger.info("Method : deleteSack ends");
					return qcSackRestDao.deleteSack(id, org, div);

				}
				
				
				// approve
				@RequestMapping(value = "rest-sack-detls-approve", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<Object>> approveSack(@RequestParam String id, String org, String div) {
					logger.info("Method : approveSack starts");

					logger.info("Method : approveSack ends");
					return qcSackRestDao.approveSack(id, org, div);

				}

}
