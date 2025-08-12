package nirmalya.aatithya.restmodule.employee.controller;

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
//import nirmalya.aatithya.restmodule.employee.model.ReimbrusementOtherModel;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
//import nirmalya.aatithya.restmodule.employee.model.ReimbrusementOtherModel;
import nirmalya.aatithya.restmodule.employee.model.ReimbrusementRestOtherModel;
import nirmalya.aatithya.restmodule.employee.model.ReimbursementModel;
import nirmalya.aatithya.restmodule.employee.dao.ReimbrusementRestOtherDao;
import nirmalya.aatithya.restmodule.employee.dao.ReimbursementRestDao;
@RestController
@RequestMapping(value = { "employee/" })
public class ReimbrusementOtherRestController {
	Logger logger = LoggerFactory.getLogger(ReimbrusementOtherRestController.class);

	@Autowired
	ReimbrusementRestOtherDao reimbursementRestDao;
	//Gender drop down
			@RequestMapping(value = "getTypeLists", method = { RequestMethod.GET })
			public List<DropDownModel> getReimbTypeLists() {
				logger.info("Method : getReimbTypeLists starts");

				logger.info("Method : getReimbTypeLists ends");
				return reimbursementRestDao.getReimbTypeLists();
			}
			
			@PostMapping(value = "add-reimbursement-others")
			public ResponseEntity<JsonResponse<Object>> addReimbursementOther(@RequestBody  ReimbrusementRestOtherModel reimbursementModel) {
				logger.info("Method : addReimbursementOther starts");

				logger.info("Method : addReimbursementOther ends");
				return reimbursementRestDao.addReimbursementOther(reimbursementModel);
			}
			// Post mapping foe view Reimbuseiment

			@GetMapping(value = "viewReimbursementOther")
			public JsonResponse<List<ReimbrusementRestOtherModel>> viewReimbursementOther() {
				logger.info("Method : viewReimbursementOther");

				logger.info("Method : viewReimbursementOther ends");
				return reimbursementRestDao.viewReimbursementOther();
			}
			/*
			 *
			 * Edit Reimbursement rest
			 *
			 */
			@RequestMapping(value = "edit-rest-reimbursement-other", method = { RequestMethod.GET })
			public JsonResponse<ReimbrusementRestOtherModel> editReimbursementOther(@RequestParam String id) {
				logger.info("Method : editReimbursementOther rest starts");

				logger.info("Method :editReimbursementOther rest ends");
				return reimbursementRestDao.editReimbursementOther(id);
			}
			
			/*
			 *
			 * Delete Reimbursement rest
			 *
			 */
			@GetMapping(value = "deleteReimbursementOthers")
			public JsonResponse<ReimbrusementRestOtherModel> deleteReimbursementOther(@RequestParam String id) {
				logger.info("Method : Delete deleteReimbursementOther rest starts");

				logger.info("Method :Delete deleteReimbursementOther rest ends");
				return reimbursementRestDao.deleteReimbursementOther(id);
			}
			
			// approve advance details

			@GetMapping(value = "approvereimbursementOtherApply")
			public JsonResponse<ReimbrusementRestOtherModel> approvereimbursementOtherApply(@RequestParam String id, String name,
					String comment, String roleid) {
				logger.info("Method : approvereimbursementOtherApply starts");

				logger.info("Method : approvereimbursementOtherApply ends");

				return reimbursementRestDao.approvereimbursementOtherApply(id, name, comment, roleid);
			}

			// reject advance

			@GetMapping(value = "rejectreimbursementOtherApply")
			public JsonResponse<ReimbrusementRestOtherModel> rejectreimbursementOtherApply(@RequestParam String id, String name, String comment) {
				logger.info("Method : rejectreimbursementOtherApply starts");

				logger.info("Method : rejectreimbursementOtherApply ends");
				return reimbursementRestDao.rejectreimbursementOtherApply(id, name, comment);
			}
}
