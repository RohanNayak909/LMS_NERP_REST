package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ReimbrusementPaymentModel;
import nirmalya.aatithya.restmodule.master.dao.RestAccountantSectionDao;
import nirmalya.aatithya.restmodule.master.model.AccountantSectionRestModel;

@RestController
@RequestMapping(value = "master/")
public class RestAccountantSectionController {
	Logger logger = LoggerFactory.getLogger(RestAccountantSectionController.class);

	@Autowired
	RestAccountantSectionDao restAccountantSectionDao;

	@Autowired
	EnvironmentVaribles env;
	
	
	/*
	 * Add payment rest
	 * 
	 */

	@PostMapping(value = "add-accountantSection-payment")
	public JsonResponse<Object> addAccountantSection(@RequestBody ReimbrusementPaymentModel reimbursementModel) {
		logger.info("Method : addAccountantSectionPaymnet rest starts");

		logger.info("Method : addAccountantSectionPaymnet rest ends");
		return restAccountantSectionDao.addAccountantSectionPaymnet(reimbursementModel);
	}
	
	@GetMapping(value = "rest-viewAccountantSection")
	public JsonResponse<List<AccountantSectionRestModel>> viewAccountantSectionDetails(@RequestParam String userid) {
		logger.info("Method : viewAccountantSectionDetails");

		logger.info("Method : viewAccountantSectionDetails ends");
		return restAccountantSectionDao.viewAccountantSectionDetails(userid);
	}
}
