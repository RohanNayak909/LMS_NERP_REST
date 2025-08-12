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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestMasterOrganisationDao;
import nirmalya.aatithya.restmodule.master.model.RestMasterOrganisationModel;
import nirmalya.aatithya.restmodule.sales.model.RestCustoomerNewModel;

@RestController
@RequestMapping(value = "master/")
public class RestMasterOrganisationController {
	Logger logger = LoggerFactory.getLogger(RestMasterOrganisationController.class);

	@Autowired
	RestMasterOrganisationDao restMasterOrganisationDao;

	// org type
	@RequestMapping(value = "getOrganisationTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getOrganisationTypeList() {
		logger.info("Method : getOrganisationTypeList starts");

		logger.info("Method : getOrganisationTypeList ends");
		return restMasterOrganisationDao.getOrganisationTypeList();
	}

	// location
	@RequestMapping(value = "getLocationsLists", method = { RequestMethod.GET })
	public List<DropDownModel> getLocationsLists() {
		logger.info("Method : getLocationsLists starts");

		logger.info("Method : getLocationsLists ends");
		return restMasterOrganisationDao.getLocationsListsDao();
	}
	// location
	@RequestMapping(value = "getFinancialYearLists", method = { RequestMethod.GET })
	public List<DropDownModel> getFinancialYearLists() {
		logger.info("Method : getFinancialYearLists starts");
		
		logger.info("Method : getFinancialYearLists ends");
		return restMasterOrganisationDao.getFinancialYearListsDao();
	}

	// method to save data for organization details
	@RequestMapping(value = "/rest-add-organiserdetails")
	public @ResponseBody JsonResponse<Object> addOrganisation(
			@RequestBody RestMasterOrganisationModel restMasterOrganisationModel) {
		logger.info("Method : addOrganiser starts");

		logger.info("Method : addOrganiser ends");
		return restMasterOrganisationDao.addOrgDao(restMasterOrganisationModel);
	}

	// rest controller

	@RequestMapping(value = "rest-view-organiserdetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>> vieworg(@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : vieworg starts");

		logger.info("Method : vieworg ends");
		return restMasterOrganisationDao.vieworg(organization,orgDivision);
	}

	
	// edit responsible
	@RequestMapping(value = "editOrganizerMasterDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>> editOrganizerMaster(
			@RequestParam String id) {
		logger.info("Method : editOrganizerMaster starts");

		logger.info("Method : editOrganizerMaster ends");
		return restMasterOrganisationDao.editOrganizerMaster(id);
	}

	// delete resp
	@RequestMapping(value = "deleteOrganzierDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteOrganzierDetails(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteOrganzier starts");

		logger.info("Method : deleteOrganzier ends");
		return restMasterOrganisationDao.restOrganizerMasterDetails(id, createdBy);
	}
	/*
	 * auto search 
	 */

	@GetMapping(value = "getOrgNameAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getOrgNameAutoSearchList(@RequestParam String id) {
		logger.info("Method : getOrgNameAutoSearchList starts");

		logger.info("Method :getOrgNameAutoSearchList endss");
		return restMasterOrganisationDao.getOrgNameAutoSearchList(id);
	}
 //save working Day
	@RequestMapping(value = "/rest-addOrgWorkingDay")
	public @ResponseBody JsonResponse<Object> addOrgWorkingDay(
			@RequestBody RestMasterOrganisationModel restMasterOrganisationModel) {
		logger.info("Method : addOrgWorkingDayDao starts");

		logger.info("Method : addOrgWorkingDayDao ends");
		return restMasterOrganisationDao.addOrgWorkingDayDao(restMasterOrganisationModel);
	}
	// rest controller

	@RequestMapping(value = "rest-viewworkingDay", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>> viewworkingDay(@RequestParam String orgName,String orgDiv) {
		logger.info("Method : viewworkingDay starts");

		logger.info("Method : viewworkingDay ends");
		return restMasterOrganisationDao.viewworkingDay(orgName,orgDiv);
	}
	//save working Day
	@RequestMapping(value = "/rest-addTaxDeclarationModifyDeclare")
	public @ResponseBody JsonResponse<Object> addTaxDeclarationModifyDeclare(
			@RequestBody RestMasterOrganisationModel restMasterOrganisationModel) {
		logger.info("Method : addTaxDeclarationModifyDeclare starts");
		
		logger.info("Method : addTaxDeclarationModifyDeclare ends");
		return restMasterOrganisationDao.addTaxDeclarationModifyDeclareDao(restMasterOrganisationModel);
	}
	// rest controller
	
	@RequestMapping(value = "rest-viewTaxDeclarationModifyDeclare", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestMasterOrganisationModel>>> viewTaxDeclarationModifyDeclare(@RequestParam String orgName,String orgDiv) {
		logger.info("Method : viewTaxDeclarationModifyDeclare starts");
		
		logger.info("Method : viewTaxDeclarationModifyDeclare ends");
		return restMasterOrganisationDao.viewTaxDeclarationModifyDeclareDao(orgName,orgDiv);
	}
	
	@RequestMapping(value = "saveOrgAddressDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<RestMasterOrganisationModel>> saveOrgAddressDetails(@RequestBody RestMasterOrganisationModel restMasterOrganisationModel) {
		logger.info("Method : saveOrgAddressDetails starts");
		
		logger.info("Method : saveOrgAddressDetails ends");
		return restMasterOrganisationDao.saveOrgAddressDetails(restMasterOrganisationModel);
	}
	
	@RequestMapping(value = "rest-viewShippingAddressDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> viewShippingAddressDetails(@RequestParam String organisationalIdd, String orgName, String orgDivision) {
		logger.info("Method :viewShippingAddressDetails start");

		logger.info("Method :viewShippingAddressDetails endss");
		return restMasterOrganisationDao.viewShippingAddressDetails(organisationalIdd,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-editShippingAddressDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> editShippingAddressDetails(@RequestParam String addressId,String orgName, String orgDivision) {
		logger.info("Method :editShippingAddressDetails start");

		logger.info("Method :editShippingAddressDetails endss");
		return restMasterOrganisationDao.editShippingAddressDetails(addressId,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-deleteShippingaddressdata", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteShippingaddressdata(@RequestParam String deleteId, String org,String orgDiv) {
		logger.info("Method :deleteShippingaddressdata start");

		logger.info("Method :deleteShippingaddressdata endss");
		return restMasterOrganisationDao.deleteShippingaddressdata(deleteId,org, orgDiv);
	}
	
	
}