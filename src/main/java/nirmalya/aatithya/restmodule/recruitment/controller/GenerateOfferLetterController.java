package nirmalya.aatithya.restmodule.recruitment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.dao.GenerateOfferLetterDao;
import nirmalya.aatithya.restmodule.recruitment.model.RestGenerateOfferLetterModel;

@RestController
@RequestMapping("recruitment/")
public class GenerateOfferLetterController {

	Logger logger = LoggerFactory.getLogger(GenerateOfferLetterController.class);

	@Autowired
	GenerateOfferLetterDao generateOfferLetterDao;

	@GetMapping(value = "viewpdf")
	public JsonResponse<Object> viewpdf(@RequestParam String candId,String bandid,String offerLetterId,String org,String orgDiv) {
		logger.info("Method : editpatientnew starts");

		logger.info("Method :editpatientnew ends");
		return generateOfferLetterDao.createOfferLetter(candId,bandid,offerLetterId,org,orgDiv);
	}

}
