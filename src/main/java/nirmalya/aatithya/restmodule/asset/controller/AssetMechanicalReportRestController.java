package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetMechanicalReportDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetMechanicalReportRestController {

	Logger logger = LoggerFactory.getLogger(AssetMechanicalReportRestController.class);

	@Autowired
	AssetMechanicalReportDao assetMechanicalReportDao;
//	
//	//Dropdown For Asset Name
//	@RequestMapping(value = "rest-getAssetLists", method = { RequestMethod.GET })
//	    public List<DropDownModel> getAssetList(@RequestParam String userId,
//	    		@RequestParam String orgName,@RequestParam String orgDivision,@RequestParam String policyId) {
//	        logger.info("Method : getAssetList starts");
//
//	        logger.info("Method : getAssetList ends");
//	        return assetMechanicalReportDao.getAssetList(userId,orgName,orgDivision,policyId);
//	    }

	// view Metal Detector
	@RequestMapping(value = "rest-viewMetalDetector", method = { RequestMethod.GET })
	public JsonResponse<Object> viewMetalDetector(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String assetName,
			@RequestParam String policyId) {
		logger.info("Method :viewMetalDetector start");

		logger.info("Method :viewMetalDetector endss");
		return assetMechanicalReportDao.viewMetalDetector(orgName, orgDivision, userId, fromDate, toDate, assetName,
				policyId);
	}

	// view Double Track
	@RequestMapping(value = "rest-viewDoubleTrack", method = { RequestMethod.GET })
	public JsonResponse<Object> viewDoubleTrack(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String assetName,
			@RequestParam String policyId) {
		logger.info("Method :viewDoubleTrack start");

		logger.info("Method :viewDoubleTrack endss");
		return assetMechanicalReportDao.viewDoubleTrack(orgName, orgDivision, userId, fromDate, toDate, assetName,
				policyId);
	}

	// view Gear oil
	@RequestMapping(value = "rest-viewGearOil", method = { RequestMethod.GET })
	public JsonResponse<Object> viewGearOil(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String policyId) {
		logger.info("Method :viewGearOil start");

		logger.info("Method :viewGearOil endss");
		return assetMechanicalReportDao.viewGearOil(orgName, orgDivision, userId, fromDate, toDate, policyId);
	}

	// view Checklist
	@RequestMapping(value = "rest-viewgetChecklist", method = { RequestMethod.GET })
	public JsonResponse<Object> viewgetChecklist(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String assetName,
			@RequestParam String policyId) {
		logger.info("Method :viewgetChecklist start");

		logger.info("Method :viewgetChecklist endss");
		return assetMechanicalReportDao.viewgetChecklist(orgName, orgDivision, userId, fromDate, toDate, assetName,
				policyId);
	}

	// view Bag Filter Checklist
	@RequestMapping(value = "rest-viewBagFiletrCheckList", method = { RequestMethod.GET })
	public JsonResponse<Object> viewBagFiletrCheckList(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String assetName,
			@RequestParam String policyId) {
		logger.info("Method :viewBagFiletrCheckList start");

		logger.info("Method :viewBagFiletrCheckList endss");
		return assetMechanicalReportDao.viewBagFiletrCheckList(orgName, orgDivision, userId, fromDate, toDate,
				assetName, policyId);
	}

	// BIB MACHINE/////////////////////////////////

	// view Bib Machine
	@RequestMapping(value = "rest-viewBibMachine", method = { RequestMethod.GET })
	public JsonResponse<Object> viewBibMachine(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String assetName,
			@RequestParam String policyId) {
		logger.info("Method :viewBibMachine start");

		logger.info("Method :viewBibMachine endss");
		return assetMechanicalReportDao.viewBibMachine(orgName, orgDivision, userId, fromDate, toDate, assetName,
				policyId);
	}

	// SHREDDING MACHINE ///////////////////////////////

	// view Shredding machine
	@RequestMapping(value = "rest-viewgetshredding", method = { RequestMethod.GET })
	public JsonResponse<Object> viewgetshredding(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String assetName,
			@RequestParam String policyId) {
		logger.info("Method :viewgetshredding start");

		logger.info("Method :viewgetshredding endss");
		return assetMechanicalReportDao.viewgetshredding(orgName, orgDivision, userId, fromDate, toDate, assetName,
				policyId);
	}

	/////// STARPAC PERFORATION////////////////

	// view Strapac Blade
	@RequestMapping(value = "rest-viewStrpacBlade", method = { RequestMethod.GET })
	public JsonResponse<Object> viewStrpacBlade(@RequestParam String orgName, String orgDivision, String mon,
			@RequestParam String policyId) {
		logger.info("Method :viewStrpacBlade start");

		logger.info("Method :viewStrpacBlade endss");
		return assetMechanicalReportDao.viewStrpacBlade(orgName, orgDivision, mon, policyId);
	}

	// view Multi Track
	@RequestMapping(value = "rest-viewMultiTrack", method = { RequestMethod.GET })
	public JsonResponse<Object> viewMultiTrack(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String assetName,
			@RequestParam String policyId) {
		logger.info("Method :viewMultiTrack start");

		logger.info("Method :viewMultiTrack endss");
		return assetMechanicalReportDao.viewMultiTrack(orgName, orgDivision, userId, fromDate, toDate, assetName,
				policyId);

	}

	// view Nut Boult
	@RequestMapping(value = "rest-viewNutBults", method = { RequestMethod.GET })
	public JsonResponse<Object> viewNutBults(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String assetName,
			@RequestParam String policyId) {
		logger.info("Method :viewNutBults start");

		logger.info("Method :viewNutBults endss");
		return assetMechanicalReportDao.viewNutBults(orgName, orgDivision, userId, fromDate, toDate, assetName,
				policyId);
	}

	// view paintworkCheckList
	@RequestMapping(value = "rest-paintworkCheckList", method = { RequestMethod.GET })
	public JsonResponse<Object> paintworkCheckList(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String assetName,
			@RequestParam String policyId) {
		logger.info("Method :paintworkCheckList start");

		logger.info("Method :paintworkCheckList endss");
		return assetMechanicalReportDao.paintworkCheckList(orgName, orgDivision, userId, fromDate, toDate, assetName,
				policyId);
	}

	// view Epoxy Work CheckList
	@RequestMapping(value = "rest-epoxyWorkCheckListView", method = { RequestMethod.GET })
	public JsonResponse<Object> epoxyWorkCheckListView(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String policyId) {
		logger.info("Method :epoxyWorkCheckListView start");

		logger.info("Method :epoxyWorkCheckListView endss");
		return assetMechanicalReportDao.epoxyWorkCheckListView(orgName, orgDivision, userId, fromDate, toDate,
				policyId);
	}

	// View Starpac Center Cutter Change Record
	@RequestMapping(value = "rest-viewStrpacCutterRecord", method = { RequestMethod.GET })
	public JsonResponse<Object> viewStrpacCutterRecord(@RequestParam String orgName, String orgDivision, String mon,
			@RequestParam String policyId) {
		logger.info("Method :viewStrpacCutterRecord start");

		logger.info("Method :viewStrpacCutterRecord endss");
		return assetMechanicalReportDao.viewStrpacCutterRecord(orgName, orgDivision, mon, policyId);
	}

	// View Wet Cleaning Check List
	@RequestMapping(value = "rest-viewWetCleaningCheckList", method = { RequestMethod.GET })
	public JsonResponse<Object> viewWetCleaningCheckList(@RequestParam String orgName, String orgDivision, String userId,String date) {
		logger.info("Method :viewWetCleaningCheckList start");

		logger.info("Method :viewWetCleaningCheckList endss");
		return assetMechanicalReportDao.viewWetCleaningCheckList(orgName, orgDivision, userId,date);
	}

}
