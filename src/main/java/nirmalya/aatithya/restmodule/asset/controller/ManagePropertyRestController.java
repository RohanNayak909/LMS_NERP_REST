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

import nirmalya.aatithya.restmodule.asset.dao.ManagePropertyDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.LocationMasterDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPropertyRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetProprtyOwnerRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.master.model.LocationRoomModel;

@RestController
@RequestMapping(value = "asset/")
public class ManagePropertyRestController {
	
	Logger logger = LoggerFactory.getLogger(ManagePropertyRestController.class);

	@Autowired
	ManagePropertyDao managePropertyDao;

	
	@RequestMapping(value = "rest-manage-property-save", method = { RequestMethod.POST })
	public JsonResponse<Object> saveLocationMaster(@RequestBody AssetPropertyRestModel location) {
		logger.info("Method : saveLocationMaster starts");
		
		logger.info("Method : saveLocationMaster ends");
		return managePropertyDao.saveLocationMaster(location);
	}
	

	@RequestMapping(value = "rest-manage-property-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetProperty(@RequestParam String orgName, String orgDivision, String type) {
		logger.info("Method :viewAssetProperty start");

		logger.info("Method :viewAssetProperty endss");
		return managePropertyDao.viewAssetProperty(orgName, orgDivision,type);
	}
	
	@RequestMapping(value = "rest-manage-property-get-details", method = { RequestMethod.GET })
	public JsonResponse<Object> editAssetProperty(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editAssetProperty start");

		logger.info("Method :editAssetProperty endss");
		return managePropertyDao.editAssetProperty(id, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-manage-property-save-floor", method = { RequestMethod.POST })
	public JsonResponse<Object> savePropertyFloor(@RequestBody AssetPropertyRestModel location) {
		logger.info("Method : savePropertyFloor starts");
		
		logger.info("Method : savePropertyFloor ends");
		return managePropertyDao.savePropertyFloor(location);
	}
	
	@RequestMapping(value = "rest-property-get-loc-room-details", method = { RequestMethod.POST })
	public JsonResponse<Object> getPropertyRoomDetails(@RequestBody List<String> id) {
		logger.info("Method : getPropertyRoomDetails starts");
		
		logger.info("Method : getPropertyRoomDetails ends");
		return managePropertyDao.getPropertyRoomDetails(id);
	}

	@RequestMapping(value = "rest-manage-property-save-room", method = { RequestMethod.POST })
	public JsonResponse<Object> saveRoomForAssetProperty(@RequestBody LocationRoomModel location) {
		logger.info("Method : saveRoomForAssetProperty starts");
		
		logger.info("Method : saveRoomForAssetProperty ends");
		return managePropertyDao.saveRoomForAssetProperty(location);
	}

	@RequestMapping(value = "rest-manage-property-get-loc-floor-details", method = { RequestMethod.GET })
	public JsonResponse<Object>  getLocationFloorDetails(@RequestParam String id) {
		logger.info("Method : getLocationFloorDetails starts");
		
		logger.info("Method : getLocationFloorDetails ends");
		return managePropertyDao.getLocationFloorDetails(id);
	}
	
	@RequestMapping(value = "rest-manage-property-floor-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteFloorForAsset(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteFloorForAsset starts");
		
		logger.info("Method : deleteFloorForAsset ends");
		return managePropertyDao.deleteFloorForAsset(id,createdBy);
	}
	
	@RequestMapping(value = "rest-manage-property-room-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRoomForAsset(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteRoomForAsset starts");
		
		logger.info("Method : deleteRoomForAsset ends");
		return managePropertyDao.deleteRoomForAsset(id,createdBy);
	}
	
	@RequestMapping(value = "rest-manage-property-location-delete", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> deleteLocationForAsset(@RequestBody List<DropDownModel> locationList) {
		logger.info("Method : deleteLocationForAsset starts");
		
		logger.info("Method : deleteLocationForAsset ends");
		return managePropertyDao.deleteLocationForAsset(locationList);
	}
	
	@RequestMapping(value = "rest-manage-property-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteLocatioinForAsset(@RequestParam String id,String userId, String org, String orgDiv) {
		logger.info("Method :  deleteLocatioinForAsset starts"+id);

		logger.info("Method :  deleteLocatioinForAsset ends");
		return managePropertyDao.deleteLocatioinForAsset(id, org, orgDiv,userId);
	}
	@RequestMapping(value = "rest-manage-property-file-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteLocationFile(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteLocationFile starts");
		
		logger.info("Method : deleteLocationFile ends");
		return managePropertyDao.deleteLocationFile(id,createdBy);
	}
	@RequestMapping(value = "rest-manage-property-asset-list", method = { RequestMethod.GET })
	public JsonResponse<Object> showTotalAsset(@RequestParam String type,String cat,String scat, String orgName, String orgDivision,String userId) {
		logger.info("Method :showTotalAsset start");

		logger.info("Method :showTotalAsset endss");
		return managePropertyDao.showTotalAsset(type,cat,scat,orgName, orgDivision,userId);
	}
	
	@RequestMapping(value = "rest-manage-property-asset-assign", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> assignAsset(@RequestParam String id,String locid,String loctype,String date, String org, String orgDiv, String userId) {
		logger.info("Method : assignAsset starts");

		logger.info("Method : assignAsset ends");
		return managePropertyDao.assignAsset(id,locid,loctype, date, org, orgDiv,userId);

	}
	
	// Report List
	@RequestMapping(value = "rest-manage-property-report-list", method = { RequestMethod.GET })
	public JsonResponse<Object> showReportTotal(@RequestParam String type,String id, String orgName, String orgDivision) {
		logger.info("Method :showReportTotal start");

		logger.info("Method :showReportTotal endss");
		return managePropertyDao.showReportTotal(type,id,orgName,orgDivision);
	}
	
	// Report List
	@RequestMapping(value = "rest-manage-property-report-list-assign", method = { RequestMethod.GET })
	public JsonResponse<Object> showReportTotalAssign(@RequestParam String type,String id, String orgName, String orgDivision) {
		logger.info("Method :showReportTotal start");

		logger.info("Method :showReportTotal endss");
		return managePropertyDao.showReportTotalAssign(type,id,orgName,orgDivision);
	}
	
	@PostMapping(value = "rest-manage-property-add-owner")
	public ResponseEntity<JsonResponse<List<AssetProprtyOwnerRestModel>>> addPropertyOwner(@RequestBody List<AssetProprtyOwnerRestModel> assetProprtyOwnerRestModel) {
		logger.info("Method : addPropertyOwner starts");
		logger.info("Method : addPropertyOwner ends");
		return managePropertyDao.addPropertyOwner(assetProprtyOwnerRestModel);
	}
	@PostMapping(value = "rest-manage-property-add-documents")
	public ResponseEntity<JsonResponse<List<AssetProprtyOwnerRestModel>>> addDocsOfProperty(@RequestBody List<AssetProprtyOwnerRestModel> addDocsOfProperty) {
		logger.info("Method : addDocsOfProperty starts   "+addDocsOfProperty);
		logger.info("Method : addDocsOfProperty ends");
		return managePropertyDao.addDocsOfProperty(addDocsOfProperty);
	}
	
	// deleteOwner
	@RequestMapping(value = "rest-manage-property-delete-owner", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePropertyOwner(@RequestParam String id, String org, String div) {
		logger.info("Method : deletePropertyOwner starts");

		logger.info("Method : deletePropertyOwner ends");
		return managePropertyDao.deletePropertyOwner(id, org, div);

	}
	
	@RequestMapping(value = "rest-manage-property-owner-document", method = { RequestMethod.GET })
	public JsonResponse<Object> getAttachmentOwner(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getAttachmentOwner start");

		logger.info("Method :getAttachmentOwner endss");
		return managePropertyDao.getAttachmentOwner(id, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-getDocsOfProperty", method = { RequestMethod.GET })
	public JsonResponse<Object> getDocsOfProperty(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getDocsOfProperty start");

		logger.info("Method :getDocsOfProperty endss");
		return managePropertyDao.getDocsOfProperty(id, orgName, orgDivision);
	}

	@RequestMapping(value = "rest-manage-property-deleteDocuments", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDocuments(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :  deleteDocuments starts"+id);

		logger.info("Method :  deleteDocuments ends");
		return managePropertyDao.deleteDocuments(id, org, orgDiv);
	}	
	
	@RequestMapping(value = "rest-manage-property-deleteFloors", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteFloors(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :  deleteFloors starts"+id);

		logger.info("Method :  deleteFloors ends");
		return managePropertyDao.deleteFloors(id, org, orgDiv);
	}
	
	@RequestMapping(value = "rest-viewBuildingFloor", method = { RequestMethod.GET })
	public JsonResponse<Object> viewBuildingFloor(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewBuildingFloor start");

		logger.info("Method :viewBuildingFloor endss");
		return managePropertyDao.viewBuildingFloor(orgName, orgDivision);
	}
	@RequestMapping(value = "rest-viewFloorRooms", method = { RequestMethod.GET })
	public JsonResponse<Object> viewFloorRooms(@RequestParam String floorId, String orgName, String orgDivision) {
		logger.info("Method :viewFloorRooms start");

		logger.info("Method :viewFloorRooms endss");
		return managePropertyDao.viewFloorRooms(floorId,orgName, orgDivision);
	}
	@RequestMapping(value = "rest-delete-room", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRoom(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :  deleteRoom starts"+id);

		logger.info("Method :  deleteRoom ends");
		return managePropertyDao.deleteRoom(id, org, orgDiv);
	}	

	@RequestMapping(value = "rest-save-floor-details", method = { RequestMethod.POST })
	public JsonResponse<Object> saveFloorDetails(@RequestBody LocationRoomModel location) {
		logger.info("Method : saveFloorDetails starts");
		
		logger.info("Method : saveFloorDetails ends");
		return managePropertyDao.saveFloorDetails(location);
	}
	@RequestMapping(value = "rest-viewFloorDets", method = { RequestMethod.GET })
	public JsonResponse<Object> viewFloorDets(@RequestParam String floorId, String orgName, String orgDivision) {
		logger.info("Method :viewFloorDets start");

		logger.info("Method :viewFloorDets endss");
		return managePropertyDao.viewFloorDets(floorId,orgName, orgDivision);
	}
	@RequestMapping(value = "rest-deleteFloorDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteFloorDetails(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :  deleteFloorDetails starts"+id);

		logger.info("Method :  deleteFloorDetails ends");
		return managePropertyDao.deleteFloorDetails(id, org, orgDiv);
	}	
	
}
