package nirmalya.aatithya.restmodule.account.controller;

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

import nirmalya.aatithya.restmodule.account.dao.RestManageCurrencyDao;
import nirmalya.aatithya.restmodule.account.model.RestManageCurrencyModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account/")
public class RestManageCurrencyController {

	
	Logger logger = LoggerFactory.getLogger(RestManageCurrencyController.class);
	@Autowired
	RestManageCurrencyDao restManageCurrencyDao;

	@RequestMapping(value = "restaddcurrency", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addIncentive(@RequestBody RestManageCurrencyModel curencyDetails) {
		logger.info("Method : addrestCurrency starts");

		logger.info("Method : addrestCurrency  ends");

		return restManageCurrencyDao.addManageCurrency(curencyDetails);
	}
	
	@RequestMapping(value = "restViewCurrency", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManageCurrencyModel>>> restViewcurencyDetails() {
		logger.info("Method: restViewCurrency View Start");

		logger.info("Method: restViewCurrency ends");
		return restManageCurrencyDao.viewCurrency();
	}
	
	
	@GetMapping(value = "edit-Currency-Info")
	public ResponseEntity<JsonResponse<List<RestManageCurrencyModel>>> editrestViewcurencyDetailsInfo(

			
	@RequestParam String id) {
		logger.info("Method :editCurrencyMemberInfo starts");

		logger.info("Method :editCurrencyMemberInfo ends" + id);
		return restManageCurrencyDao.editCurrency(id);

	}
	@RequestMapping(value = "delete-currency-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleterestViewcurencyDetails(@RequestParam String id) {
		logger.info("Method : deleteclubmemberDetails starts" + id);

		logger.info("Method :  deleteclubmemberDetails ends");
		return restManageCurrencyDao.deletecurrencyMemberDetails(id);
	}
}
