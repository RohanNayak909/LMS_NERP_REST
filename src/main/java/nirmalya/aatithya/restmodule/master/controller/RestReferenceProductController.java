package nirmalya.aatithya.restmodule.master.controller;

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
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestReferenceProductDao; 
import nirmalya.aatithya.restmodule.master.model.RestReferenceProductModel;

@RestController
@RequestMapping(value = { "master" })
public class RestReferenceProductController {
	Logger logger = LoggerFactory.getLogger(RestReferenceProductController.class);

	@Autowired
	RestReferenceProductDao restReferenceProductDao;

	@RequestMapping(value = "addBrandType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restaddBrandType(
			@RequestBody RestReferenceProductModel restProcurementMasterModel) {
		logger.info("Method : restaddBrandType starts");

		logger.info("Method : restaddBrandType ends");
		return restReferenceProductDao.addBrandType(restProcurementMasterModel);
	}

	@RequestMapping(value = "viewBrandType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> viewBrandType(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewBrandType starts");

		logger.info("Method : viewBrandType ends");
		return restReferenceProductDao.viewBrandType(org,orgDiv);
	}

	@RequestMapping(value = "deletebrandType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletebrandType(@RequestParam String id,@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : deletebrandType starts");

		logger.info("Method : deletebrandType ends");
		return restReferenceProductDao.deletebrandType(id,org,orgDiv);
	}

	// product Type

	@RequestMapping(value = "addProductType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restaddProductType(
			@RequestBody RestReferenceProductModel restProcurementMasterModel) {
		logger.info("Method : rest addProductType starts");

		logger.info("Method : rest addProductType ends");
		return restReferenceProductDao.addProductType(restProcurementMasterModel);
	}

	@RequestMapping(value = "viewProductType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> viewProductType(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :rest viewProductType starts");

		logger.info("Method :rest viewProductType ends");
		return restReferenceProductDao.viewProductType(org,orgDiv);
	}

	@RequestMapping(value = "deleteProductType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteProductType(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : deleteProductType starts");

		logger.info("Method : deleteProductType ends");
		return restReferenceProductDao.deleteProductType(id,org,orgDiv);
	}
	
	// insurance Type

		@RequestMapping(value = "addInsuranceType", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> restaddInsuranceType(
				@RequestBody RestReferenceProductModel restProcurementMasterModel) {
			logger.info("Method : rest addInsuranceType starts");

			logger.info("Method : rest addInsuranceType ends");
			return restReferenceProductDao.addInsuranceType(restProcurementMasterModel);
		}
		
		@RequestMapping(value = "viewInsuranceType", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> viewInsuranceType(@RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :rest viewInsuranceType starts");

			logger.info("Method :rest viewInsuranceType ends");
			return restReferenceProductDao.viewInsuranceType(org,orgDiv);
		}
		
		@RequestMapping(value = "deleteInsuranceType", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteInsuranceType(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method : deleteInsuranceType starts");

			logger.info("Method : deleteInsuranceType ends");
			return restReferenceProductDao.deleteInsuranceType(id,org,orgDiv);
		}
		
		// insurance Proider Type
		
		@GetMapping(value = "getinsuranceList")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getinsuranceList(@RequestParam String org,
				@RequestParam String orgDiv) {
			logger.info("Method : getinsuranceList starts");

			logger.info("Method : getinsuranceList ends");
			return restReferenceProductDao.getinsuranceList(org, orgDiv);
		}

		@RequestMapping(value = "addInsuranceProvdrType", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> restaddInsuranceProvdrType(
				@RequestBody RestReferenceProductModel restProcurementMasterModel) {
			logger.info("Method : rest addInsuranceProvdrType starts");

			logger.info("Method : rest addInsuranceProvdrType ends");
			return restReferenceProductDao.addInsuranceProvdrType(restProcurementMasterModel);
		}
		
		@RequestMapping(value = "viewInsuranceProviderType", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> viewInsuranceProviderType(@RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :rest viewInsuranceProviderType starts");

			logger.info("Method :rest viewInsuranceProviderType ends");
			return restReferenceProductDao.viewInsuranceProviderType(org,orgDiv);
		}
		
		@RequestMapping(value = "deleteInsuranceProviderType", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteInsuranceProviderType(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method : deleteInsuranceProviderType starts");

			logger.info("Method : deleteInsuranceProviderType ends");
			return restReferenceProductDao.deleteInsuranceProviderType(id,org,orgDiv);
		}

	// Variation Type

	@RequestMapping(value = "addVariationType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restaddVariationType(
			@RequestBody RestReferenceProductModel restProcurementMasterModel) {
		logger.info("Method : rest addVariationType starts");

		logger.info("Method : rest addVariationType ends");
		return restReferenceProductDao.addVariationType(restProcurementMasterModel);
	}

	@RequestMapping(value = "viewVariationType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> viewVariationType(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :rest viewVariationType starts");

		logger.info("Method :rest viewVariationType ends");
		return restReferenceProductDao.viewVariationType(org,orgDiv);
	}

	@RequestMapping(value = "deleteVariationType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteVariationType(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : deleteVariationType starts");

		logger.info("Method : deleteVariationType ends");
		return restReferenceProductDao.deleteVariationType(id,org,orgDiv);
	}
	
	// Mode Of Transport Type
	@RequestMapping(value = "addTransportType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restaddTransportType(
			@RequestBody RestReferenceProductModel restProcurementMasterModel) {
		logger.info("Method : rest addTransportType starts");

		logger.info("Method : rest addTransportType ends");
		return restReferenceProductDao.addTransportType(restProcurementMasterModel);
	}
	
	@RequestMapping(value = "viewtransportType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> viewtransportType(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :rest viewtransportType starts");

		logger.info("Method :rest viewtransportType ends");
		return restReferenceProductDao.viewtransportType(org,orgDiv);
	}
	
	@RequestMapping(value = "deleteTransportType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteTransportType(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : deleteTransportType starts");

		logger.info("Method : deleteTransportType ends");
		return restReferenceProductDao.deleteTransportType(id,org,orgDiv);
	}

	/**
	 * add brand type from csv 
	 * @param reqtypeList
	 * @return
	 */
	@PostMapping(value = "addBrandTypeCsv")
	public ResponseEntity<JsonResponse<Object>> addBrandTypeCsv(
			@RequestBody List<RestReferenceProductModel> reqtypeList) {
		logger.info("Method : addBrandTypeCsv starts");
		logger.info("Method : addBrandTypeCsv ends");
		return restReferenceProductDao.addBrandTypeCsv(reqtypeList);
	}

	/**
	 * add product type from csv
	 * @param reqtypeList
	 * @return
	 */
	@PostMapping(value = "addProductTypeCsv")
	public ResponseEntity<JsonResponse<Object>> addProductTypeCsv(
			@RequestBody List<RestReferenceProductModel> reqtypeList) {
		logger.info("Method : addProductTypeCsv starts");
		logger.info("Method : addProductTypeCsv ends");
		return restReferenceProductDao.addProductTypeCsv(reqtypeList);
	}

	/**
	 * add variation type from csv
	 * 
	 * @param reqtypeList
	 * @return
	 */
	@PostMapping(value = "addVariationTypeCsv")
	public ResponseEntity<JsonResponse<Object>> addVariationTypeCsv(
			@RequestBody List<RestReferenceProductModel> reqtypeList) {
		logger.info("Method : addBrandTypeCsv starts");
		logger.info("Method : addBrandTypeCsv ends");
		return restReferenceProductDao.addVariationTypeCsv(reqtypeList);
	}
}
