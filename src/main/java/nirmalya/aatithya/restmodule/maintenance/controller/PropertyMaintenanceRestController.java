package nirmalya.aatithya.restmodule.maintenance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.maintenance.dao.AssetMaintenanceDao;
import nirmalya.aatithya.restmodule.maintenance.dao.PropertyMaintenanceDao;

@RestController
@RequestMapping(value = { "maintenance/" })
public class PropertyMaintenanceRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	PropertyMaintenanceDao propertyMaintenanceDao;

 
	@RequestMapping(value = "rest-property-maintenance-policy-list", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPropertyMaintenancePolicy(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method :viewPropertyMaintenancePolicy start");

		logger.info("Method :viewPropertyMaintenancePolicy endss");
		return propertyMaintenanceDao.viewPropertyMaintenancePolicy(orgName, orgDivision,userId);
	}
	
	@RequestMapping(value = "rest-property-maintenance-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPropertyMaintenance(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewPropertyMaintenance start");

		logger.info("Method :viewPropertyMaintenance endss");
		return propertyMaintenanceDao.viewPropertyMaintenance(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-property-maintenance-deallocate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePolicyAlloc(@RequestParam String id, String org, String div) {
		logger.info("Method : deletePolicyAlloc starts");

		logger.info("Method : deletePolicyAlloc ends");
		return propertyMaintenanceDao.deletePolicyAlloc(id, org, div);

	}
	
	@RequestMapping(value = "getGroupListforProperty", method = { RequestMethod.GET }) 
	public List<DropDownModel>getGroupListforProperty(@RequestParam String org,String orgDiv,String userId){ 
		logger.info("Method : getGroupListforProperty starts");
			  
		logger.info("Method : getGroupListforProperty ends"); 
		return propertyMaintenanceDao.getGroupListforProperty(org,orgDiv,userId); 
		}
	
	@RequestMapping(value = "rest-property-maintenance-allocate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> allocatePropertyPolicy(@RequestParam String policyId,String assetList,
			String assetemp,String assigndate,String assetcat,String assetGrp, String org, String orgDiv, String userid, String type) {
		logger.info("Method : allocatePropertyPolicy starts");

		logger.info("Method : allocatePropertyPolicy ends");
		return propertyMaintenanceDao.allocatePropertyPolicy(policyId,assetList,assetemp,assigndate,assetcat,assetGrp, org, orgDiv,userid,type);

	}
	
	@RequestMapping(value = "getGroupListforPropertyAPI", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGroupListforPropertyAPI(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getGroupListforPropertyAPI starts");

		logger.info("Method : getGroupListforPropertyAPI ends");
		return propertyMaintenanceDao.getGroupListforPropertyAPI(org,orgDiv,userId);
	}
}
