package nirmalya.aatithya.restmodule.sales.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.RestDebitNoteDao;

@RestController
@RequestMapping("sales/")
public class RestDebitNoteController {
	
	Logger logger = LoggerFactory.getLogger(RestDebitNoteController.class);

	@Autowired

	RestDebitNoteDao restDebitNoteDao;
	
	// view  Data

		@RequestMapping(value = "viewdebitNoteData", method = { RequestMethod.GET })
		public JsonResponse<Object> viewdebitNoteData(@RequestParam String orgName, String orgDivision) {
			logger.info("Method :viewdebitNoteData start");

			logger.info("Method :viewdebitNoteData endss");
			return restDebitNoteDao.viewdebitNoteData(orgName, orgDivision);

		}
	

}
