package nirmalya.aatithya.restmodule.purchase.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.ShortageSurplusGoodsDao;

@RestController
@RequestMapping(value = "purchase/")
public class RestShortageSurplusGoodsController {
	
	Logger logger = LoggerFactory.getLogger(RestShortageSurplusGoodsController.class);

	@Autowired
	ShortageSurplusGoodsDao shortageSurplusGoodsDao;
	
	// View
	
	@RequestMapping(value = "rest-shortageSurplusGoodsDataView", method = { RequestMethod.GET })
	public JsonResponse<Object> shortageSurplusGoodsDataView(@RequestParam String orgName, @RequestParam String orgDivision, String pageno) {
		logger.info("Method :shortageSurplusGoodsDataView start");

		logger.info("Method :shortageSurplusGoodsDataView endss");
		return shortageSurplusGoodsDao.shortageSurplusGoodsDataView(orgName, orgDivision, pageno);

	}
	
	// Add debit Note.
	
	@RequestMapping(value = "rest-shortageSurplusGoodsDataAddDebitNote", method = { RequestMethod.GET })
	public JsonResponse<Object> shortageSurplusGoodsDataAddDebitNote(@RequestParam String orgName, @RequestParam String orgDivision, String id, String userId) {
		logger.info("Method :shortageSurplusGoodsDataAddDebitNote start");

		logger.info("Method :shortageSurplusGoodsDataAddDebitNote endss");
		return shortageSurplusGoodsDao.shortageSurplusGoodsDataAddDebitNote(orgName, orgDivision, id, userId);

	}

}
