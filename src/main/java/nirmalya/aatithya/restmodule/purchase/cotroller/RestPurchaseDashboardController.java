package nirmalya.aatithya.restmodule.purchase.cotroller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseDashboardDao;
import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseVendorDao;
import nirmalya.aatithya.restmodule.purchase.model.RestVendorNewModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "purchase" })
public class RestPurchaseDashboardController {

	Logger logger = LoggerFactory.getLogger(RestPurchaseDashboardController.class);
	@Autowired
	RestPurchaseDashboardDao restPurchaseDashboardDao;

	// getAllHeadCount
		@RequestMapping(value = "getAllHeadCount", method = { RequestMethod.GET })
		public JsonResponse<Object> getAllHeadCount(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
			logger.info("Method :getAllHeadCount start");

			logger.info("Method :getAllHeadCount endss");
			return restPurchaseDashboardDao.getAllHeadCount(orgName,orgDivision,fromDate,toDate,loc);

		}
		
		//getAllPOCityList
		
				@RequestMapping(value = "getAllPOCityList", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllPOCityList(@RequestParam String id) {
					logger.info("Method : getAllPOCityList starts");
					logger.info("Method : getAllPOCityList ends");
					return restPurchaseDashboardDao.getAllPOCityList(id);
				}

		// getAllRecordOperational
		@RequestMapping(value = "getAllRecordOperational", method = { RequestMethod.GET })
		public JsonResponse<Object> getAllRecordOperational(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String id,@RequestParam String loc) {
			logger.info("Method :getAllRecordOperational start");

			logger.info("Method :getAllRecordOperational endss");
			return restPurchaseDashboardDao.getAllRecordOperational(orgName,orgDivision,fromDate,toDate,id,loc);

		}
		
		
		@RequestMapping(value = "SupllierClasification", method = { RequestMethod.GET })
		public JsonResponse<Object> SupllierClasification(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
			logger.info("Method :SupllierClasification start");

			logger.info("Method :SupllierClasification endss");
			return restPurchaseDashboardDao.SupllierClasification(orgName,orgDivision,fromDate,toDate,loc);
		}
		
		
		@RequestMapping(value = "dashboardSuppliers", method = { RequestMethod.GET })
		public JsonResponse<Object> procuremrntDashboard(@RequestParam String orgName, @RequestParam String div) {
			logger.info("Method :procuremrntDashboard start");

			logger.info("Method :procuremrntDashboard endss");
			return restPurchaseDashboardDao.procuremrntDashboard(orgName, div);

		}
		
		
		
		// dashboardContracted

		@RequestMapping(value = "dashboardContracted", method = { RequestMethod.GET })
		public JsonResponse<Object> contracted(@RequestParam String orgName, @RequestParam String div) {
			logger.info("Method :contractedAllCount start");

			logger.info("Method :contractedAllCount endss");
			return restPurchaseDashboardDao.contractedAllCount(orgName, div);

		}
		
		
		
		// dashboardServices

		@RequestMapping(value = "dashboardServices", method = { RequestMethod.GET })
		public JsonResponse<Object> dashboardServices(@RequestParam String orgName, @RequestParam String div) {
			logger.info("Method :serviceAllCount start");

			logger.info("Method :serviceAllCount endss");
			return restPurchaseDashboardDao.serviceAllCount(orgName, div);

		}
		
		// fiveYearTrend

		@RequestMapping(value = "fiveYearTrend", method = { RequestMethod.GET })
		public JsonResponse<Object> fiveYearTrend(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
			logger.info("Method :fiveYearTrend start");

			logger.info("Method :fiveYearTrend endss");
			return restPurchaseDashboardDao.fiveYearTrend(orgName,orgDivision,fromDate,toDate,loc);
		}
		
		
		// fiveYearTrend1
		@RequestMapping(value = "fiveYearTrend1", method = { RequestMethod.GET })
		public JsonResponse<Object> fiveYearTrend1(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
			logger.info("Method :fiveYearTrend1 start");

			logger.info("Method :fiveYearTrend1 endss");
			return restPurchaseDashboardDao.fiveYearTrend1(orgName,orgDivision,fromDate,toDate,loc);
		}
		
		// fiveYearTrend2
		@RequestMapping(value = "fiveYearTrend2", method = { RequestMethod.GET })
		public JsonResponse<Object> fiveYearTrend2(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
			logger.info("Method :fiveYearTrend2 start");

			logger.info("Method :fiveYearTrend2 endss");
			return restPurchaseDashboardDao.fiveYearTrend2(orgName,orgDivision,fromDate,toDate,loc);
		}
		
		// organisation
		@RequestMapping(value = "getOrganization", method = { RequestMethod.GET })
		public List<DropDownModel> getOrganizationDivision(@RequestParam String orgName) {
			logger.info("Method : getOrganizationDivision starts");

			logger.info("Method : getOrganizationDivision ends");
			return restPurchaseDashboardDao.getOrganization(orgName);
		}

		// organisationDivision
		@RequestMapping(value = "getDivision", method = { RequestMethod.GET })
		public List<DropDownModel> getDivision(@RequestParam String orgName) {
			logger.info("Method : getDivision starts");

			logger.info("Method : getDivision ends");
			return restPurchaseDashboardDao.getDivision(orgName);
		}
	
}
