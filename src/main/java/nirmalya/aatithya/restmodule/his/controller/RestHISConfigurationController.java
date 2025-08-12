package nirmalya.aatithya.restmodule.his.controller;

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
import nirmalya.aatithya.restmodule.his.dao.RestHISConfigurationDao;
import nirmalya.aatithya.restmodule.his.model.RestHISConfigurationModel;

@RestController
@RequestMapping(value = "/his")
public class RestHISConfigurationController {
	Logger logger = (Logger) LoggerFactory.getLogger(RestHISConfigurationController.class);

	@Autowired
	RestHISConfigurationDao resthisconfigurationdao;

	// group id

	@RequestMapping(value = "getGroupId", method = { RequestMethod.GET })
	public List<DropDownModel> getGroupId() {
		logger.info("Method : getGroupId starts");

		logger.info("Method : getGroupId ends");
		return resthisconfigurationdao.getGroupId();
	}

	// Add Bed Category

	@RequestMapping(value = "rest-addBedCategoryMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addBedCategoryMaster(
			@RequestBody RestHISConfigurationModel beddetails) {
		logger.info("Method : addBedCategoryMaster starts");

		logger.info("Method : addBedCategoryMaster ends");

		return resthisconfigurationdao.addBedCategoryMaster(beddetails);
	}

	// View Bed Category

	@RequestMapping(value = "rest-view-BedCategoryMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewBedcat() {
		logger.info("Method : viewBedcat starts");

		logger.info("Method : viewBedcat ends");
		return resthisconfigurationdao.viewBedcat();
	}

	// edit Bed Category

	@RequestMapping(value = "rest-editOrganizerMasterDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editBedCat(@RequestParam String id) {
		logger.info("Method : editBedCat starts");

		logger.info("Method : editBedCat ends");
		return resthisconfigurationdao.editBedCat(id);
	}

	// delete Bed Category

	@RequestMapping(value = "rest-deleteBedCategoryMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteBedCategory(@RequestParam String id) {
		logger.info("Method : deleteBedCategory starts");

		logger.info("Method : deleteBedCategory ends");
		return resthisconfigurationdao.deleteBedCategory(id);
	}

	// discharge add

	@RequestMapping(value = "rest-addDischargeMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> adddischarge(
			@RequestBody RestHISConfigurationModel restHISConfigurationModel) {
		logger.info("Method : rest adddischargetype starts");

		logger.info("Method : rest adddischargetypemaster ends");
		return resthisconfigurationdao.adddischarge(restHISConfigurationModel);
	}

	// discharge view

	@RequestMapping(value = "rest-view-DisTypeMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewDisType() {
		logger.info("Method : viewDisType starts");

		logger.info("Method : viewDisType ends");
		return resthisconfigurationdao.viewDisType();
	}

	// discharge edit

	@RequestMapping(value = "rest-edit-DisTypeMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editDisType(@RequestParam String distype) {
		logger.info("Method : editDisType starts");

		logger.info("Method : editDisType ends");
		return resthisconfigurationdao.editDisType(distype);
	}

	// discharge delete

	@RequestMapping(value = "rest-deleteDischargeType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDischargeType(@RequestParam String id) {
		logger.info("Method : deleteDischargeType starts");

		logger.info("Method : deleteDischargeType ends");
		return resthisconfigurationdao.deleteDischargeType(id);
	}

	// Destination add

	@RequestMapping(value = "rest-addDestinationMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> adddestination(
			@RequestBody RestHISConfigurationModel restHISConfigurationModel) {
		logger.info("Method : rest addDestinationMaster starts");

		logger.info("Method : rest addDestinationMaster ends");
		return resthisconfigurationdao.adddestination(restHISConfigurationModel);
	}

	// Destination View

	@RequestMapping(value = "rest-view-DestinMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewDestination() {
		logger.info("Method : viewDestination starts");

		logger.info("Method : viewDestination ends");
		return resthisconfigurationdao.viewDestination();
	}

	// Destination edit

	@RequestMapping(value = "rest-edit-DestinMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editDestination(@RequestParam String id) {
		logger.info("Method : editDestination starts");

		logger.info("Method : editDestination ends");
		return resthisconfigurationdao.editDestination(id);
	}

	// Destination delete

	@RequestMapping(value = "rest-deleteDestination", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDestination(@RequestParam String id) {
		logger.info("Method : deleteDestination starts");

		logger.info("Method : deleteDestination ends");
		return resthisconfigurationdao.deleteDestination(id);
	}

	// Add Concession

	@RequestMapping(value = "rest-addConcessionMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addconcession(
			@RequestBody RestHISConfigurationModel restHISConfigurationModel) {
		logger.info("Method : rest addConcessionMaster starts");

		logger.info("Method : rest addConcessionMaster ends");
		return resthisconfigurationdao.addconcession(restHISConfigurationModel);
	}

	// View Concession

	@RequestMapping(value = "rest-view-ConcessionMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewConcession() {
		logger.info("Method : viewConcession starts");

		logger.info("Method : viewConcession ends");
		return resthisconfigurationdao.viewConcession();
	}

	// edit Concession

	@RequestMapping(value = "rest-edit-ConcessionMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editConcession(@RequestParam String id) {
		logger.info("Method : editConcession starts");

		logger.info("Method : editConcession ends");
		return resthisconfigurationdao.editConcession(id);
	}

	// delete Concession

	@RequestMapping(value = "rest-deleteConcession", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteConcession(@RequestParam String id) {
		logger.info("Method : deleteConcession starts");

		logger.info("Method : deleteConcession ends");
		return resthisconfigurationdao.deleteConcession(id);
	}

	// Add Pathology

	@RequestMapping(value = "rest-addpathology", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addpathology(
			@RequestBody RestHISConfigurationModel restHISConfigurationModel) {
		logger.info("Method : rest addpathology starts");

		logger.info("Method : rest addpathology ends");
		return resthisconfigurationdao.addpathology(restHISConfigurationModel);
	}

	// View Pathology

	@RequestMapping(value = "rest-view-PathologyMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewPathology() {
		logger.info("Method : viewPathology starts");

		logger.info("Method : viewPathology ends");
		return resthisconfigurationdao.viewPathology();
	}

	// edit Pathology

	@RequestMapping(value = "rest-edit-PathologyMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editPathology(@RequestParam String id) {
		logger.info("Method : editPathology starts");

		logger.info("Method : editPathology ends");
		return resthisconfigurationdao.editPathology(id);
	}

	// delete Pathology

	@RequestMapping(value = "rest-deletePathology", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePathology(@RequestParam String id) {
		logger.info("Method : deletePathology starts");

		logger.info("Method : deletePathology ends");
		return resthisconfigurationdao.deletePathology(id);
	}

	// Add Group

	@RequestMapping(value = "rest-addgroup", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addgroup(
			@RequestBody RestHISConfigurationModel restHISConfigurationModel) {
		logger.info("Method : rest addgroup starts");

		logger.info("Method : rest addgroup ends");
		return resthisconfigurationdao.addgroup(restHISConfigurationModel);
	}

	// View Group

	@RequestMapping(value = "rest-view-GroupMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewGroup() {
		logger.info("Method : viewGroup starts");

		logger.info("Method : viewGroup ends");
		return resthisconfigurationdao.viewGroup();
	}

	// edit Group

	@RequestMapping(value = "rest-edit-GroupMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editGroup(@RequestParam String id) {
		logger.info("Method : editGroup starts");

		logger.info("Method : editGroup ends");
		return resthisconfigurationdao.editGroup(id);
	}

	// delete Group

	@RequestMapping(value = "rest-deleteGroup", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteGroup(@RequestParam String id) {
		logger.info("Method : deleteGroup starts");

		logger.info("Method : deleteGroup ends");
		return resthisconfigurationdao.deleteGroup(id);
	}

	// Add Sub Group

	@RequestMapping(value = "rest-addsubgroup", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addsubgroup(
			@RequestBody RestHISConfigurationModel restHISConfigurationModel) {
		logger.info("Method : rest addsubgroup starts");

		logger.info("Method : rest addsubgroup ends");
		return resthisconfigurationdao.addsubgroup(restHISConfigurationModel);
	}

	// View Sub Group

	@RequestMapping(value = "rest-view-SubGroupMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewSubGroup() {
		logger.info("Method : viewSubGroup starts");

		logger.info("Method : viewSubGroup ends");
		return resthisconfigurationdao.viewSubGroup();
	}

	// edit Sub Group

	@RequestMapping(value = "rest-edit-SubGroupMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editSubGroup(@RequestParam String id) {
		logger.info("Method : editSubGroup starts");

		logger.info("Method : editSubGroup ends");
		return resthisconfigurationdao.editSubGroup(id);
	}

	// delete Sub Group

	@RequestMapping(value = "rest-deleteSubGroup", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSubGroup(@RequestParam String id) {
		logger.info("Method : deleteSubGroup starts");

		logger.info("Method : deleteSubGroup ends");
		return resthisconfigurationdao.deleteSubGroup(id);
	}

	// Add Surgery

	@RequestMapping(value = "rest-addSurgery", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addSurgery(
			@RequestBody RestHISConfigurationModel restHISConfigurationModel) {
		logger.info("Method : rest addSurgery starts");

		logger.info("Method : rest addSurgery ends");
		return resthisconfigurationdao.addSurgery(restHISConfigurationModel);
	}

	// View Surgery

	@RequestMapping(value = "rest-view-SurgeryMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewSurgery() {
		logger.info("Method : viewSurgery starts");

		logger.info("Method : viewSurgery ends");
		return resthisconfigurationdao.viewSurgery();
	}

	// edit Surgery

	@RequestMapping(value = "rest-edit-surgeryMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editSurgery(@RequestParam String id) {
		logger.info("Method : editSurgery starts");

		logger.info("Method : editSurgery ends");
		return resthisconfigurationdao.editSurgery(id);
	}

	// delete Surgery

	@RequestMapping(value = "rest-deleteSurgery", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSurgery(@RequestParam String id) {
		logger.info("Method : deleteSurgery starts");

		logger.info("Method : deleteSurgery ends");
		return resthisconfigurationdao.deleteSurgery(id);
	}
		
		// viewOnclickSubGroup		
				@RequestMapping(value = "rest-viewOnclickSubGroup", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewOnclickSubGroup(@RequestParam String id) {
					logger.info("Method : viewOnclickSubGroup starts");

					logger.info("Method : viewOnclickSubGroup ends");
					return resthisconfigurationdao.viewOnclickSubGroup(id);
				}
}