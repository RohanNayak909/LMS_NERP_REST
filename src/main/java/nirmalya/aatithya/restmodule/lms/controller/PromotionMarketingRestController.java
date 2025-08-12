package nirmalya.aatithya.restmodule.lms.controller;

import java.util.Map;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.lms.dao.PromotionMarketingRestDao;

	@RestController
	@RequestMapping(value = { "master" })
	public class PromotionMarketingRestController {

		Logger logger = LoggerFactory.getLogger(PromotionMarketingRestController.class);

		@Autowired
		PromotionMarketingRestDao promotionMarketingRestDao;
	
	
	
// View
	@RequestMapping(value = "rest-viewCoupon", method = { RequestMethod.GET })
	public JsonResponse<Object> viewCoupon(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewCoupon start");

		logger.info("Method :viewCoupon endss");
		return promotionMarketingRestDao.viewCoupon(orgName, orgDivision);
	}
	
// add
	@PostMapping("rest-addCoupon")
	public JsonResponse<Object> addCoupon(@RequestBody Map<String, Object> couponJsonData) {
	    logger.info("Method : addCoupon starts");

	    logger.info("Method : addCoupon ends");
	    return promotionMarketingRestDao.addCoupon(couponJsonData);
	}
// EDIT
	@GetMapping("rest-editCoupon")
	public JsonResponse<Object> editCoupon( @RequestParam String orgName,
			@RequestParam String orgDiv,@RequestParam String couponId) {
		logger.info("Method :editCoupon start");

		logger.info("Method :editCoupon ends");
		return promotionMarketingRestDao.editCoupon(orgName,orgDiv,couponId);
	}
// DELETE
	@GetMapping("rest-deletCoupon")
	public JsonResponse<Object> deletCoupon(@RequestParam String couponId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :deletCoupon start");

		logger.info("Method :deletCoupon ends");
		return promotionMarketingRestDao.deletCoupon(couponId, orgName, orgDiv);
	}
// Course List
	
		@RequestMapping(value = "rest-viewCourseList", method = { RequestMethod.GET })
		public JsonResponse<Object> viewCourseList(@RequestParam String orgName, String orgDivision) {
			logger.info("Method :viewCourseList start");

			logger.info("Method :viewCourseList endss");
			return promotionMarketingRestDao.viewCourseList(orgName, orgDivision);
		}
		
		@GetMapping(value = "rest-get-all-product-details")
		public JsonResponse<Object> getAllProductDetails() {
			logger.info("Method :getAllProductDetails start");

			logger.info("Method :getAllProductDetails ends");
			return promotionMarketingRestDao.getAllProductDetails();

		}
}
