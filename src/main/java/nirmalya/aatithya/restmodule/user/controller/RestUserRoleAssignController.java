package nirmalya.aatithya.restmodule.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestOrganisationTypeModel;
import nirmalya.aatithya.restmodule.user.dao.RolesAccessDao;
import nirmalya.aatithya.restmodule.user.dao.UserRoleAssignDao;
import nirmalya.aatithya.restmodule.user.model.RestUserRoleAssignModel;
import nirmalya.aatithya.restmodule.user.model.RolesAccessModel;
import nirmalya.aatithya.restmodule.user.model.UserAccessModel;

@RestController
@RequestMapping(value = "user/")
public class RestUserRoleAssignController {
	
	@Autowired
	UserRoleAssignDao userRoleAssignDao;

	Logger logger = LoggerFactory.getLogger(RestUserRoleAssignController.class);
	
	// view

		@RequestMapping(value = "viewUserMaster", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<RestUserRoleAssignModel>>> viewUserMaster(@RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method : viewUserMaster starts"+org+orgDiv);

			logger.info("Method : viewUserMaster ends");
			return userRoleAssignDao.viewUserMaster(org, orgDiv);
		}
		
		@RequestMapping(value = "editUserAssignMaster", method = { RequestMethod.GET }) 
		public ResponseEntity<JsonResponse<RestUserRoleAssignModel>> editUserAssignMaster(@RequestParam String id) {
			logger.info("Method : editUserAssignMaster starts");
			
			logger.info("Method : editUserAssignMaster ends");
			return userRoleAssignDao.editUserAssignMaster(id);
		}
		
		@RequestMapping(value = "addRoleassignMaster", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> addRoleassignMaster(@RequestBody RestUserRoleAssignModel id) {
			logger.info("Method : addRoleassignMaster starts"+id);
			
			logger.info("Method : addRoleassignMaster ends");
			return userRoleAssignDao.addRoleassignMaster(id);
		}
}
