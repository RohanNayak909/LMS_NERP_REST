package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.RestIncomeTaxMasterDao;
import nirmalya.aatithya.restmodule.master.model.RestIncomeTaxMasterModel;

@RestController
@RequestMapping(value = { "master" })
public class RestIncomeTaxMasterController {
	Logger logger = LoggerFactory.getLogger(RestIncomeTaxMasterController.class);

	@Autowired
	RestIncomeTaxMasterDao restIncomeTaxMasterDao;

	/*
	 * 
	 * post mapping for add TAX CATAGORY
	 * 
	 * 
	 */

	@RequestMapping(value = "/getFinancialYrForIncometax", method = { RequestMethod.GET })
	public List<DropDownModel> getFinancialYrForIncometax() {
		logger.info("Method : getFinancialYrForIncometax starts");

		logger.info("Method : getFinancialYrForIncometax end");
		return restIncomeTaxMasterDao.getFinancialYrForIncometax();
	}

	@RequestMapping(value = "/getcatagoryName", method = { RequestMethod.GET })
	public List<DropDownModel> getcatagoryName() {
		logger.info("Method : getcatagoryName starts");

		logger.info("Method : getcatagoryName end");
		return restIncomeTaxMasterDao.getcatagoryName();
	}

	// add
	@RequestMapping(value = "rest-addnew-slabmaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addslabMaster(@RequestBody RestIncomeTaxMasterModel restPayroll) {
		logger.info("Method : addslabMaster starts");

		logger.info("Method : addslabMaster ends");
		return restIncomeTaxMasterDao.addslabMaster(restPayroll);
	}
	// view

	@RequestMapping(value = "viewSlabMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestIncomeTaxMasterModel>>> viewSlabMaster(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewSlabMaster starts");

		logger.info("Method : viewSlabMaster ends");
		return restIncomeTaxMasterDao.viewSlabMaster(org, orgDiv);
	}

	// add
	@RequestMapping(value = "rest-addnew-incomemaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addIncomeMaster(@RequestBody RestIncomeTaxMasterModel restPayroll) {
		logger.info("Method : addIncomeMaster starts");

		logger.info("Method : addIncomeMaster ends");
		return restIncomeTaxMasterDao.addIncomeMaster(restPayroll);
	}

	// view

	@RequestMapping(value = "viewIncomeMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestIncomeTaxMasterModel>>> viewIncomeMaster(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewIncomeMaster starts");

		logger.info("Method : viewIncomeMaster ends");
		return restIncomeTaxMasterDao.viewIncomeMaster(org, orgDiv);
	}

	// add
	@RequestMapping(value = "rest-addnew-professional", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addProfessionalMaster(
			@RequestBody RestIncomeTaxMasterModel restPayroll) {
		logger.info("Method : addProfessionalMaster starts");

		logger.info("Method : addProfessionalMaster ends");
		return restIncomeTaxMasterDao.addProfessionalMaster(restPayroll);
	}
	// view

	@RequestMapping(value = "viewProfessionalMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestIncomeTaxMasterModel>>> viewProfessionalMaster(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewProfessionalMaster starts");

		logger.info("Method : viewProfessionalMaster ends");
		return restIncomeTaxMasterDao.viewProfessionalMaster(org, orgDiv);
	}

	// delete slab master
	@RequestMapping(value = "rest-deleteDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteslabmaster(@RequestParam String id) {
		logger.info("Method : deleteslabmaster starts");

		logger.info("Method : deleteslabmaster ends");
		return restIncomeTaxMasterDao.deleteslabmaster(id);
	}

	// delete professional slab master
	@RequestMapping(value = "rest-deleteProfessionalslabmasterDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteProfessionalslabmaster(@RequestParam String id) {
		logger.info("Method : deleteProfessionalslabmaster starts");

		logger.info("Method : deleteProfessionalslabmaster ends");
		return restIncomeTaxMasterDao.deleteProfessionalslabmaster(id);
	}

	// deleteIncometaxmaster 
	@RequestMapping(value = "rest-deleteIncometaxmasterDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteIncometaxmaster(@RequestParam String id) {
		logger.info("Method : deleteIncometaxmaster starts");

		logger.info("Method : deleteIncometaxmaster ends");
		return restIncomeTaxMasterDao.deleteIncometaxmaster(id);
	}
}
