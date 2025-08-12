package nirmalya.aatithya.restmodule.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.EmployeeTaxDeclarationDao;
import nirmalya.aatithya.restmodule.employee.model.EmployeeTaxDeclarationRestModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeTaxDeclarationRestController {
	Logger logger = LoggerFactory.getLogger(EmployeeTaxDeclarationRestController.class);

	@Autowired
	EmployeeTaxDeclarationDao employeeTaxDao;
 
	// view Monthly Income
	@GetMapping(value = "viewtaxdeclaration")
	public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewMonthlyIncome(@RequestParam String userid,
			@RequestParam String startYr, @RequestParam String endYr) {
		logger.info("Method : viewMonthlyIncome starts");

		logger.info("Method : viewMonthlyIncome ends");
		return employeeTaxDao.viewMonthlyIncomeDao(userid, startYr, endYr);
	}

	// view Adhoc Income
	@GetMapping(value = "viewadhocincome")
	public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewAdhocIncome(@RequestParam String userid,
			@RequestParam String startYr, @RequestParam String endYr) {
		logger.info("Method : viewAdhocIncome starts");

		logger.info("Method : viewAdhocIncome ends");
		return employeeTaxDao.viewAdhocIncomeDao(userid, startYr, endYr);
	}

	// view Other Items Details
	@GetMapping(value = "viewOtherItemDetails")
	public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewOtherItemDetails(@RequestParam String userid,
			@RequestParam String startYr, @RequestParam String endYr) {
		logger.info("Method : viewOtherItemDetails starts");

		logger.info("Method : viewOtherItemDetails ends");
		return employeeTaxDao.viewOtherItemDetailsDao(userid, startYr, endYr);
	}

	// view Other Items Details
	@GetMapping(value = "viewPerquisiteDetails")
	public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewPerquisiteDetails(@RequestParam String userid,
			@RequestParam String startYr, @RequestParam String endYr) {
		logger.info("Method : viewPerquisiteDetails starts");

		logger.info("Method : viewPerquisiteDetails ends");
		return employeeTaxDao.viewPerquisiteDetailsDao(userid, startYr, endYr);
	}

	// view Other Items Details
	@GetMapping(value = "view-tax-exluded")
	public JsonResponse<List<EmployeeTaxDeclarationRestModel>> incomeExcludeFromTax(@RequestParam String userid,
			@RequestParam String startYr, @RequestParam String endYr) {
		logger.info("Method : incomeExcludeFromTax starts");

		logger.info("Method : incomeExcludeFromTax ends");
		return employeeTaxDao.incomeExcludeFromTaxDao(userid, startYr, endYr);
	}
	
	// view Previous employer tax declration details
	
	@GetMapping(value = "view-prevemployer-tax-details")
	public JsonResponse<List<EmployeeTaxDeclarationRestModel>> prevEmployerTaxDeclartion(@RequestParam String userid,
			@RequestParam String startYr, @RequestParam String endYr) {
		logger.info("Method : prevEmployerTaxDeclartion starts");

		logger.info("Method : prevEmployerTaxDeclartion ends");
		return employeeTaxDao.prevEmployerTaxDeclartionDao(userid, startYr, endYr);
	}
	
	// view LESS EXEMPTION UNDER SECTION 10 details
	
		@GetMapping(value = "tax-less-exemption-details")
		public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewLessExemptionUnderSection10(@RequestParam String userid,
				@RequestParam String startYr, @RequestParam String endYr) {
			logger.info("Method : viewLessExemptionUnderSection10 starts");

			logger.info("Method : viewLessExemptionUnderSection10 ends");
			return employeeTaxDao.viewLessExemptionUnderSec10Dao(userid, startYr, endYr);
		}
		
		// view less deduction under section 10
		
		@GetMapping(value = "rest-viewLessDeductionSection")
		public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewLessDeductionSection(@RequestParam String userid,
				@RequestParam String startYr, @RequestParam String endYr) {
			logger.info("Method : viewLessDeductionSection starts");

			logger.info("Method : viewLessDeductionSection ends");
			return employeeTaxDao.viewLessDeductionSection(userid, startYr, endYr);
		}
		
		
		// view any other income by employee
		
		@GetMapping(value = "rest-viewAnyOtherIncomeByEmp")
		public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewAnyOtherIncomeByEmp(@RequestParam String userid,
				@RequestParam String startYr, @RequestParam String endYr) {
			logger.info("Method : viewAnyOtherIncomeByEmp starts");

			logger.info("Method : viewAnyOtherIncomeByEmp ends");
			return employeeTaxDao.viewAnyOtherIncomeByEmp(userid, startYr, endYr);
		}
		
		// view DEDUCTION UNDER CHAPTER  VI A
		@GetMapping(value = "rest-viewDeductionViA")
		public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewDeductionViA(@RequestParam String userid,
				@RequestParam String startYr, @RequestParam String endYr) {
			logger.info("Method : viewDeductionViA starts");

			logger.info("Method : viewDeductionViA ends");
			return employeeTaxDao.viewDeductionViA(userid, startYr, endYr);
		}
		
		// view SURCHAGE ON TAX
				@GetMapping(value = "rest-viewSurchageTax")
				public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewSurchageTax(@RequestParam String userid,
						@RequestParam String startYr, @RequestParam String endYr) {
					logger.info("Method : viewSurchageTax starts");

					logger.info("Method : viewSurchageTax ends");
					return employeeTaxDao.viewSurchageTax(userid, startYr, endYr);
				}
				

				// view TAX PAID TILL
				@GetMapping(value = "rest-viewTaxPaidTill")
				public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewTaxPaidTill(@RequestParam String userid,
						@RequestParam String startYr, @RequestParam String endYr) {
					logger.info("Method : viewTaxPaidTill starts");

					logger.info("Method : viewTaxPaidTill ends");
					return employeeTaxDao.viewTaxPaidTill(userid, startYr, endYr);
				}
}
