package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;

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

import nirmalya.aatithya.restmodule.asset.dao.PropertyGroupingRestDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@RestController
@RequestMapping(value = { "asset/" })
public class PropertyGroupingRestController {
	Logger logger = LoggerFactory.getLogger(PropertyGroupingRestController.class);

	@Autowired
	PropertyGroupingRestDao propertyGroupingRestDao;
	// viewAssetPolicy
		@RequestMapping(value = "rest-property-grouping-room-list", method = { RequestMethod.GET })
		public JsonResponse<Object> viewPropertyInGrouping(@RequestParam String orgName, String orgDivision, String pid , String fid) {
			logger.info("Method :viewPropertyInGrouping start");

			logger.info("Method :viewPropertyInGrouping endss");
			return propertyGroupingRestDao.viewPropertyInGrouping(orgName, orgDivision,pid,fid);
		}
		
		@PostMapping(value = "rest-property-grouping-add")
		public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addPropertyGroup(

				@RequestBody List<AssetPoilcyRestModel> assetPolicyModel) {
			logger.info("Method : addPropertyGroup starts");
			logger.info("Method : addPropertyGroup ends");
			return propertyGroupingRestDao.addPropertyGroup(assetPolicyModel);
		}
		
		@RequestMapping(value = "rest-property-grouping-view", method = { RequestMethod.GET })
		public JsonResponse<Object> viewPropertyGroup(@RequestParam String orgName, String orgDivision, String userId) {
			logger.info("Method :viewPropertyGroup start");

			logger.info("Method :viewPropertyGroup endss");
			return propertyGroupingRestDao.viewPropertyGroup(orgName, orgDivision,userId);
		}
		@RequestMapping(value = "rest-edit-Property-grouping", method = { RequestMethod.GET })
		public JsonResponse<Object> editGrouping(@RequestParam String id, String orgName, String orgDivision) {
			logger.info("Method :editGrouping start");

			logger.info("Method :editGrouping endss");
			return propertyGroupingRestDao.editGrouping(id, orgName, orgDivision);
		}
		@RequestMapping(value = "rest-Property-group-approve", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> approvePropertyGroup(@RequestParam String id, String org, String orgDiv) {
			logger.info("Method : approvePropertyGroup starts");

			logger.info("Method : approvePropertyGroup ends");
			return propertyGroupingRestDao.approvePropertyGroup(id, org, orgDiv);

		}
		@RequestMapping(value = "rest-Property-group-delete", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deletePropertyGroup(@RequestParam String id, String org, String div) {
			logger.info("Method : deletePropertyGroup starts");

			logger.info("Method : deletePropertyGroup ends");
			return propertyGroupingRestDao.deletePropertyGroup(id, org, div);

		}
	//
		@RequestMapping(value = "getPropertyList", method = { RequestMethod.GET })
		public List<DropDownModel> getPropertyList(@RequestParam String org, String orgDiv, String userId) {
			logger.info("Method : getPropertyList starts");

			logger.info("Method : getPropertyList ends");
			return propertyGroupingRestDao.getPropertyList(org, orgDiv, userId);
		}
//
		// getSubCategory
		@RequestMapping(value = "rest-property-floor", method = { RequestMethod.GET })
		public JsonResponse<Object> getFloor(@RequestParam String id, String orgName, String orgDivision) {
			logger.info("Method :getFloor start");

			logger.info("Method :getFloor endss");
			return propertyGroupingRestDao.getFloor(id, orgName, orgDivision);
		}
}
