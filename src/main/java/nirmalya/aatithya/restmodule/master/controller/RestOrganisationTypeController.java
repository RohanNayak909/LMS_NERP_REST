package nirmalya.aatithya.restmodule.master.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.master.dao.RestOrganisationTypeDao;
import nirmalya.aatithya.restmodule.master.model.RestOrganisationTypeModel;


@RestController
@RequestMapping(value = "master/")
public class RestOrganisationTypeController  {
	Logger logger = LoggerFactory.getLogger(RestOrganisationTypeController .class);

	@Autowired
	RestOrganisationTypeDao restOrganisationTypeDao;
 
	@RequestMapping(value = "rest-addOrganisationTypeMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addOrgType(
			@RequestBody RestOrganisationTypeModel restOrganisationTypeModel) {
		logger.info("Method : rest addOrgType starts");

		logger.info("Method : rest addOrgType ends");
		return restOrganisationTypeDao.addOrgType(restOrganisationTypeModel);
	}

	
	//rest controller

	
	  @RequestMapping(value = "rest-view-organisertypedetails", method = { RequestMethod.GET
	  }) public ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> vieworgType() {
	  logger.info("Method : vieworgType starts");
	  
	  logger.info("Method : vieworgType ends"); 
	  return restOrganisationTypeDao.vieworgType();
	  }
	  
	  //edit responsible
		@RequestMapping(value = "rest-editOrganizerMasterDetails", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> editOrganizerType(@RequestParam String id) {
			logger.info("Method : editOrganizerType starts");
			
			logger.info("Method : editOrganizerType ends");
			return restOrganisationTypeDao.editOrganizerType(id);
		}
		
		/*
		 * //delete resp
		 * 
		 * @RequestMapping(value = "rest-deleteOrganzierTypeDetails", method = {
		 * RequestMethod.GET }) public ResponseEntity<JsonResponse<Object>>
		 * deleteOrganzierType(@RequestBody String id) {
		 * logger.info("Method : deleteOrganzierType starts");
		 * 
		 * logger.info("Method : deleteOrganzierType ends"); return
		 * restOrganisationTypeDao.deleteOrganzierType(id); }
		 */
		
		@RequestMapping(value = "rest-deleteOrganzierTypeDetails", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteOrganzierType(@RequestParam String id) {
			logger.info("Method : deleteOrganzierType starts");

			logger.info("Method : deleteOrganzierType ends");
			return restOrganisationTypeDao.deleteOrganzierType(id);
		}
		///holiday add
		
		@RequestMapping(value = "rest-addOrganisationTypeHolidayMaster", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> addOrgTypeHoliday(
				@RequestBody RestOrganisationTypeModel restOrganisationTypeModel) {
			logger.info("Method : rest addOrgTypeHoliday starts");

			logger.info("Method : rest addOrgTypeHoliday ends");
			return restOrganisationTypeDao.addOrgTypeHoliday(restOrganisationTypeModel);
		}

		//rest controller holiday view

		
		  @RequestMapping(value = "organisation-type-holiday-master-view", method = { RequestMethod.GET
		  }) public ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> vieworgTypeHoliday() {
		  logger.info("Method : vieworgTypeHoliday starts");
		  
		  logger.info("Method : vieworgTypeHoliday ends"); 
		  return restOrganisationTypeDao.vieworgTypeHoliday();
		  }
          
		  //holiday delete
		  @RequestMapping(value = "rest-deleteOrganzierTypeholidayDetails", method = { RequestMethod.GET })
			public ResponseEntity<JsonResponse<Object>> deleteOrganzierTypeHoliday(@RequestParam String id) {
				logger.info("Method : deleteOrganzierTypeHoliday starts");

				logger.info("Method : deleteOrganzierTypeHoliday ends");
				return restOrganisationTypeDao.deleteOrganzierTypeHoliday(id);
			}
		  
  //bank add
		  
		  @RequestMapping(value = "rest-addbankMaster", method = { RequestMethod.POST })
			public ResponseEntity<JsonResponse<Object>> addBank(
					@RequestBody RestOrganisationTypeModel restOrganisationTypeModel) {
				logger.info("Method : rest addBank starts");

				logger.info("Method : rest addBank ends");
				return restOrganisationTypeDao.addBank(restOrganisationTypeModel);
			}
		  
		//rest bank controller

			
		  @RequestMapping(value = "rest-view-viewBankDetails", method = { RequestMethod.GET}) 
		  public ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> viewBank() {
		  logger.info("Method : viewBank starts");
		  
		  logger.info("Method : viewBank ends"); 
		  return restOrganisationTypeDao.viewBank();
		  }
		  
		
			
			@RequestMapping(value = "rest-deleteBankTypeDetails", method = { RequestMethod.GET })
			public ResponseEntity<JsonResponse<Object>> deleteBankType(@RequestParam String id) {
				logger.info("Method : deleteBankType starts");

				logger.info("Method : deleteBankType ends");
				return restOrganisationTypeDao.deleteBankTypeDetails(id);
			}
			
			// add Announcement details
			
		@RequestMapping(value = "rest-addannouncementMaster", method = { RequestMethod.POST })
			public ResponseEntity<JsonResponse<Object>> addannouncement(
					@RequestBody RestOrganisationTypeModel restOrganisationTypeModel) {
				logger.info("Method : rest addannouncement starts");

				logger.info("Method : rest addannouncement ends");
				return restOrganisationTypeDao.addannouncement(restOrganisationTypeModel);
			}
      //View Announcement
		  @RequestMapping(value = "rest-view-announcementmaster", method = { RequestMethod.GET
		  }) public ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> viewannouncement() {
		  logger.info("Method : viewannouncement starts");
		  
		  logger.info("Method : viewannouncement ends"); 
		  return restOrganisationTypeDao.viewannouncement();
		  }
			//Delete Announcement
		  
		  @RequestMapping(value = "rest-delete-announcementmaster", method = { RequestMethod.GET })
			public ResponseEntity<JsonResponse<Object>> deleteannouncement(@RequestParam String id) {
				logger.info("Method : deleteannouncement starts");

				logger.info("Method : deleteannouncement ends");
				return restOrganisationTypeDao.deleteannouncement(id);
			}
		  
		// add Leave Policy
			
			@RequestMapping(value = "rest-addleavepolicyMaster", method = { RequestMethod.POST })
				public ResponseEntity<JsonResponse<Object>> addleavepolicy(
						@RequestBody RestOrganisationTypeModel restOrganisationTypeModel) {
					logger.info("Method : rest addleavepolicy starts"+restOrganisationTypeModel);

					logger.info("Method : rest addleavepolicy ends");
					return restOrganisationTypeDao.addleavepolicy(restOrganisationTypeModel);
				}
			
			 //View Leave Policy
			  @RequestMapping(value = "rest-view-leavepolicymaster", method = { RequestMethod.GET
			  }) public ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> viewleavepolicy() {
			  logger.info("Method : viewleavepolicy starts");
			  
			  logger.info("Method : viewleavepolicy ends"); 
			  return restOrganisationTypeDao.viewleavepolicy();
			  }
		  
			  //Edit Leave Policy
			  @GetMapping(value = "editleavepolicy")
				public ResponseEntity<JsonResponse<RestOrganisationTypeModel>> editleavepolicy(@RequestParam String id) {
					logger.info("Method : editleavepolicy starts");

					logger.info("Method :editleavepolicy ends");
					return restOrganisationTypeDao.editleavepolicy(id);
				}
		  
			  
			//Delete Leave Policy
			  
			  @RequestMapping(value = "rest-delete-leavepolicymaster", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<Object>> deleteleavepolicy(@RequestParam String id) {
					logger.info("Method : deleteleavepolicy starts"+id);

					logger.info("Method : deleteleavepolicy ends");
					return restOrganisationTypeDao.deleteleavepolicy(id);
				}
		  
}

