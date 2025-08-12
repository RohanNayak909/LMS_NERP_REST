package nirmalya.aatithya.restmodule.projects.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.dao.ProjectMonitoringRestDao;
import nirmalya.aatithya.restmodule.projects.model.ProjectMonitoringRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectExecutionModel;

@RestController
@RequestMapping(value = "projects")
public class ProjectMonitoringRestController {

	Logger logger = LoggerFactory.getLogger(ProjectMonitoringRestController.class);

	@Autowired
	ProjectMonitoringRestDao monitoringDao;
	
	//***************************************************PROJECT HEALTH CRUD STARTS***************************************//

	// rest add monitoring control

	@RequestMapping(value = "rest-monitoring-control-add", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addMonitoringControl(
			@RequestBody ProjectMonitoringRestModel MonitoringControl) {
		logger.info("Method : restaddMonitoringControl starts");

		// Log the data in MonitoringControl object
		logger.info("Received MonitoringControl: {}", MonitoringControl);

		logger.info("Method : restaddMonitoringControl ends");
		return monitoringDao.addMonitoringControlDao(MonitoringControl);
	}

	// rest view monitoring control
	@GetMapping(value = "rest-monitoring-control-view")
	public JsonResponse<List<ProjectMonitoringRestModel>> viewMonitoringControl(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewMonitoringControl starts");

		logger.info("Method : viewMonitoringControl ends");
		return monitoringDao.viewMonitoringControlDao(org, orgDiv);
	}

	// rest edit monitoring control
	@GetMapping(value = "rest-monitoring-control-edit")
	public ResponseEntity<JsonResponse<ProjectMonitoringRestModel>> editMonitoringControl(@RequestParam String id) {
		logger.info("Method : editRestMonitoringControl starts");

		logger.info("Method :editRestMonitoringControl ends");
		return monitoringDao.editMonitoringControlDao(id);
	}

	// rest delete monitoring control
	@RequestMapping(value = "rest-monitoring-control-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteMonitoringControl(@RequestParam String id) {
		logger.info("Method : deleteMonitoringControl starts");

		logger.info("Method : deleteMonitoringControl ends");
		return monitoringDao.deleteMonitoringControlDao(id);
	}
	
	//***********************************PROJECT HEALTH CRUD ENDS************************************//
	
	//***********************************RUNNING PROJECT VIEW STARTS********************************//

	// rest project table view
	@GetMapping(value = "rest-monitoring-control-project-view")
	public ResponseEntity<JsonResponse<List<ProjectMonitoringRestModel>>> viewProjectTbl(@RequestParam String userid) {
		logger.info("Method : rest viewProjectTbl starts");

		logger.info("Method : rest viewProjectTbl ends");
		return monitoringDao.viewProjectTblDao(userid);
	}
	
	//***********************************RUNNING PROJECT VIEW ENDS********************************//
	
	//***********************************FORECASTING CRUD STARTS**********************************//
	
	// rest add monitoring control forecasting

		@RequestMapping(value = "monitoring-control-forecasting-add", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> addMonitoringControlForecasting(
				@RequestBody ProjectMonitoringRestModel MonitoringControlForecasting) {
			logger.info("Method : rest addMonitoringControlForecasting starts");

			// Log the data in MonitoringControl object
			logger.info("Received MonitoringControlForecasting: {}", MonitoringControlForecasting);

			logger.info("Method : rest addMonitoringControlForecasting ends");
			return monitoringDao.addMonitoringControlForecastingDao(MonitoringControlForecasting);
		}
		
		// rest view monitoring control forecasting
		@GetMapping(value = "rest-monitoring-control-forecasting-view")
		public JsonResponse<List<ProjectMonitoringRestModel>> viewMonitoringControlForecasting(@RequestParam String org,
				@RequestParam String orgDiv) {
			logger.info("Method : rest viewMonitoringControlForecasting starts");

			logger.info("Method : rest viewMonitoringControlForecasting ends");
			return monitoringDao.viewMonitoringControlForecastingDao(org, orgDiv);
		}
		
		// rest edit monitoring control forecasting
		@GetMapping(value = "rest-monitoring-control-forecasting-edit")
		public ResponseEntity<JsonResponse<ProjectMonitoringRestModel>> editMonitoringControlForecasting(@RequestParam String id) {
			logger.info("Method : rest editMonitoringControlForecasting starts");

			logger.info("Method :rest editMonitoringControlForecasting ends");
			return monitoringDao.editMonitoringControlForecastingDao(id);
		}
		
		// rest delete monitoring control forecasting
		@RequestMapping(value = "rest-monitoring-control-forecasting-delete", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteMonitoringControlForecasting(@RequestParam String id) {
			logger.info("Method : rest deleteMonitoringControlForecasting starts");
			
			 // Print the 'id' parameter value to the console
		    System.out.println("Received ID for deletion: " + id);

			logger.info("Method : rest deleteMonitoringControlForecasting ends");
			return monitoringDao.deleteMonitoringControlForecastingDao(id);
		}
		
		//***********************************FORECASTING CRUD ENDS**********************************//
		
		//***********************************CATCH UP PLAN STARTS**********************************//

		// rest add monitoring control catch up
		
		@PostMapping(value = "rest-add-catchup")
		public @ResponseBody JsonResponse<Object> restaddCatchUp(@RequestBody ProjectMonitoringRestModel catchupModel){
			logger.info("Method : restaddCatchUp starts");
			
			// Print data to console using System.out.println()
		    System.out.println("Received catchupModel: " + catchupModel);
			
			logger.info("Method : restaddCatchUp ends");
			return monitoringDao.restaddCatchUpDao(catchupModel);
		}
		
		// rest view monitoring control catch up
				@GetMapping(value = "rest-view-catchup")
				public JsonResponse<List<ProjectMonitoringRestModel>> restviewCatchUp(@RequestParam String org,
						@RequestParam String orgDiv) {
					logger.info("Method : rest restviewCatchUp starts");

					logger.info("Method : rest restviewCatchUp ends");
					return monitoringDao.restviewCatchUpDao(org, orgDiv);
				}
				
				// rest edit monitoring control catch up
				@GetMapping(value = "rest-edit-catchup")
				public ResponseEntity<JsonResponse<ProjectMonitoringRestModel>> resteditCatchUp(@RequestParam String id) {
					logger.info("Method : rest resteditCatchUp starts>>>>>>>>>");
					
					 // Print the received 'id' parameter
				    System.out.println("Received edit ID: " + id);


					logger.info("Method :rest resteditCatchUp ends>>>>>>>>>>>>>");
					return monitoringDao.resteditCatchUpDao(id); 
				}
				
				// rest delete monitoring control catch up
				@RequestMapping(value = "rest-delete-catchup", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<Object>> restdeleteCatchUp(@RequestParam String id) {
				    logger.info("Method : restdeleteCatchUp starts");
				    
				    // Print the received 'id' parameter
				    System.out.println("Received ID: " + id);

				    logger.info("Method : restdeleteCatchUp ends");
				    return monitoringDao.restdeleteCatchUpDao(id);
				}
				
				//***********************************CATCH UP PLAN ENDS**********************************//
				
				//***********************************PROJECT HEALTH NOTES CRUD STARTS**********************************//
				
				// rest add monitoring control project health notes starts
				
				// rest add notes

				@RequestMapping(value = "rest-notes-add", method = { RequestMethod.POST })
				public ResponseEntity<JsonResponse<Object>> restaddNotes(@RequestBody ProjectMonitoringRestModel notes) {
					logger.info("Method : rest restaddNotes starts");

					// Log the data in MonitoringControl object
					logger.info("Received restaddNotes: {}", notes);

					logger.info("Method : rest restaddNotes ends");
					return monitoringDao.restaddNotesDao(notes);
				}
				
				// rest view notes
				@GetMapping(value = "rest-notes-view")
				public JsonResponse<List<ProjectMonitoringRestModel>> restviewNotes(@RequestParam String org,@RequestParam String orgDiv) {
					logger.info("Method : rest viewNotes starts");

					logger.info("Method : rest viewNotes ends");
					return monitoringDao.restviewNotesDao(org, orgDiv);
				}
				
				// rest edit notes
				@GetMapping(value = "rest-notes-edit")
				public ResponseEntity<JsonResponse<ProjectMonitoringRestModel>> resteditNotes(@RequestParam String id) {
					logger.info("Method : rest editNotes starts");
					
					 // Print the received 'id' parameter
				    System.out.println("Received edit ID: " + id);
				    
					logger.info("Method :rest editNotes ends");
					return monitoringDao.resteditNotesDao(id);
				}
				
				// rest delete notes
				
				@RequestMapping(value = "rest-notes-delete", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<Object>> restdeleteNotes(@RequestParam String id) {
				    logger.info("Method : restdeleteCatchUp starts");
				    
				    // Print the received 'id' parameter
				    System.out.println("Received deleted ID: " + id);

				    logger.info("Method : restdeleteCatchUp ends");
				    return monitoringDao.restdeleteNotesDao(id);
				}
				
				//***********************************PROJECT HEALTH NOTES CRUD ENDS**********************************//
				//
				@RequestMapping(value = "rest-getAllProjectMonitoringDetails", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> getAllProjectMoniteringDetails(
						@RequestParam String id,@RequestParam String userid,
						@RequestParam String org,@RequestParam String div) {
					logger.info("Method : getAllProjectMoniteringDetails starts");

					logger.info("Method : getAllProjectMoniteringDetails ends");
					return monitoringDao.getAllProjectMoniteringDetails(id,userid,org,div);
				}
				
				// edit PaRENT

				@RequestMapping(value = "rest-getMonitorParentEdit", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<RestProjectExecutionModel>> getMonitorParentEdit(@RequestParam String id,
						@RequestParam String pid) {
					logger.info("Method : getMonitorParentEdit starts");
					logger.info("Method : getMonitorParentEdit ends");
					return monitoringDao.getMonitorParentEdit(id, pid);
				}
				// edit child

				@RequestMapping(value = "rest-getMonitorChildEdit", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<RestProjectExecutionModel>> getMonitorChildEdit(@RequestParam String id,
						@RequestParam String pid,@RequestParam String userId,
						@RequestParam String orgName,@RequestParam String orgDiv) {
					logger.info("Method : getMonitorChildEdit starts");

					logger.info("Method : getMonitorChildEdit ends");
					return monitoringDao.getMonitorChildEdit(id, pid,userId,orgName,orgDiv);
				}
}
