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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.EmailConfigDao;
import nirmalya.aatithya.restmodule.master.model.EmailConfigModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class EmailConfigRestController {

	Logger logger = LoggerFactory.getLogger(EmailConfigRestController.class);

	@Autowired
	EmailConfigDao emailConfigDao;
	
	@RequestMapping(value = "saveEmailConfiguration", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<EmailConfigModel>> saveEmailConfiguration(@RequestBody EmailConfigModel emailDtls) {
		logger.info("Method : saveEmailConfiguration starts");
		
		logger.info("Method : saveEmailConfiguration ends");
		return emailConfigDao.saveEmailConfiguration(emailDtls);
	}
	
	@RequestMapping(value = "getTotalMailConenction", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<EmailConfigModel>>> getTotalMailConenction() {
		logger.info("Method : getTotalMailConenction starts");
		
		logger.info("Method : getTotalMailConenction ends");
		return emailConfigDao.getTotalMailConenction();
	}
	
	@RequestMapping(value = "editEmailConfig", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<EmailConfigModel>> editEmailConfig(@RequestParam String id) {
		logger.info("Method : editEmailConfig starts");
		
		logger.info("Method : editEmailConfig ends");
		return emailConfigDao.editEmailConfig(id);
	}
	
	@RequestMapping(value = "deleteEmailConfig", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteEmailConfig(@RequestParam String id) {
		logger.info("Method : deleteEmailConfig starts");
		
		logger.info("Method : deleteEmailConfig ends");
		return emailConfigDao.deleteEmailConfig(id);
	}
}
