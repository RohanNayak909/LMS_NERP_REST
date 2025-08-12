package nirmalya.aatithya.restmodule.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.RestInvestmentDeclarationDao;
import nirmalya.aatithya.restmodule.employee.model.InvestDeclareSubModel;
import nirmalya.aatithya.restmodule.employee.model.RestInvestmentDeclarationModel;

@RestController
@RequestMapping(value = { "employee/" })
public class RestInvestmentDeclarationController {
	Logger logger = LoggerFactory.getLogger(RestInvestmentDeclarationController.class);

	@Autowired
	RestInvestmentDeclarationDao restInvestmentDeclarationDao;
	
	/* view investment declare details */

	@GetMapping(value = "rest-investmentdeclare-details")
	public JsonResponse<List<RestInvestmentDeclarationModel>> investmentDeclareDetails(String id,String organization,String orgDivision) {
		logger.info("Method : investmentDeclareDetails starts");

		logger.info("Method : investmentDeclareDetails ends");

		return restInvestmentDeclarationDao.investmentDeclareDetails(id,organization,orgDivision);
	}
	
	@PostMapping(value = "rest-addInvestment")
	public ResponseEntity<JsonResponse<List<RestInvestmentDeclarationModel>>>addInvestment(@RequestBody List<RestInvestmentDeclarationModel> restInvestmentDeclarationModel) {
		logger.info("Method :addInvestment starts");
		logger.info("Method :addInvestment endss");
		return restInvestmentDeclarationDao.addInvestment(restInvestmentDeclarationModel);
	}
	
	@PostMapping(value = "/rest-addInvestment-api")
	public ResponseEntity<JsonResponse<List<RestInvestmentDeclarationModel>>> addInvestmentApi(

			@RequestBody List<RestInvestmentDeclarationModel> restInvestmentDeclarationModel) {
		logger.info("Method : addInvestmentApi starts");

		logger.info("Method : addInvestmentApi ends");
		return restInvestmentDeclarationDao.addInvestmentApi(restInvestmentDeclarationModel);
	}
	
	@GetMapping(value = "rest-investmentdeclare-subheader-details")
	public JsonResponse<List<RestInvestmentDeclarationModel>> investmentDeclareSubheaderDetails(String id,String userId,String organization,String orgDivision) {
		logger.info("Method : investmentDeclareSubheaderDetails starts");

		logger.info("Method : investmentDeclareSubheaderDetails ends");

		return restInvestmentDeclarationDao.investmentDeclareSubheaderDetailsDao(id,userId,organization,orgDivision);
	}
	
	
	@GetMapping(value = "rest-declarationview")
	public JsonResponse<List<RestInvestmentDeclarationModel>> getAllquotation(String empId,String organization,String orgDivision) {
		logger.info("Method :declarationview starts");
		
		
		logger.info("Method :declarationview endss");
		return restInvestmentDeclarationDao.declarationviewDao(empId,organization,orgDivision);
		
	}
	
	@GetMapping(value = "rest-declarationviewapi")
	public JsonResponse<List<RestInvestmentDeclarationModel>> restdeclarationviewApi(String empId,String organisation,String orgDiv) {
		logger.info("Method : investmentDeclareSubheaderDetails starts");

		logger.info("Method : investmentDeclareSubheaderDetails ends"+empId);

		return restInvestmentDeclarationDao.restdeclarationviewApi(empId,organisation,orgDiv);
	}
	
	@GetMapping(value = "rest-investmentdeclare-details-api")
	public JsonResponse<List<RestInvestmentDeclarationModel>> investmentDeclareDetailsApi(String organization,String orgDivision) {
		logger.info("Method : investmentDeclareDetailsApi starts");

		logger.info("Method : investmentDeclareDetailsApi ends");

		return restInvestmentDeclarationDao.investmentDeclareDetailsApi(organization,orgDivision);
	}
	
	
	@GetMapping(value = "rest-investmentdeclare-headers-details-api")
	public JsonResponse<List<InvestDeclareSubModel>> investmentDeclareHeadersDetailsApi(String headerId,String organization,String orgDivision) {
		logger.info("Method : investmentDeclareHeadersDetailsApi starts");

		logger.info("Method : investmentDeclareHeadersDetailsApi ends"+headerId);

		return restInvestmentDeclarationDao.investmentDeclareHeadersDetailsApi(headerId,organization,orgDivision);
	}
	//check Edit Available
	@GetMapping(value = "/rest-checkEditAvailable")
	public ResponseEntity<JsonResponse<DropDownModel>> checkEditAvailable(@RequestParam String userId,String financialYear, String organization, String orgDivision){
		logger.info("Method : checkEditAvailable starts");

		logger.info("Method : checkEditAvailable ends");
		return restInvestmentDeclarationDao.checkEditAvailable(userId,financialYear,organization,orgDivision);
	}
}
