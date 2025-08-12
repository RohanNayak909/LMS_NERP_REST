package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.TemplatesMasterDao;
import nirmalya.aatithya.restmodule.master.model.TemplatesMasterModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class TemplatesMasterRestController {

	Logger logger = LoggerFactory.getLogger(TemplatesMasterRestController.class);

	@Autowired
	TemplatesMasterDao templatesMasterDao;
	
	@RequestMapping(value = "/getTemplatesList", method = { RequestMethod.GET })
	public List<TemplatesMasterModel> getTemplatesList() {
		logger.info("Method : getTemplatesList starts");

		logger.info("Method : getTemplatesList end");
		return templatesMasterDao.getTemplatesList();
	}
	
	@RequestMapping(value = "saveReportDocument", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<TemplatesMasterModel>> saveReportDocument(@RequestBody TemplatesMasterModel docDtls) {
		logger.info("Method : saveReportDocument starts");
		
		logger.info("Method : saveReportDocument ends");
		return templatesMasterDao.saveReportDocument(docDtls);
	}
}
