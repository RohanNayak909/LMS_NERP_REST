package nirmalya.aatithya.restmodule.employee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.EmployeeTaxDeclarationRestModel;

@Repository
public class EmployeeTaxDeclarationDao {

	Logger logger = LoggerFactory.getLogger(EmployeeTaxDeclarationDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	// view Monthly Income Details
	@SuppressWarnings("unchecked")
	public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewMonthlyIncomeDao(String userId, String startYr,
			String endYr) {

		logger.info("Method : viewMonthlyIncomeDao Dao starts");
		List<EmployeeTaxDeclarationRestModel> viewTaxDeclaration = new ArrayList<EmployeeTaxDeclarationRestModel>();
		JsonResponse<List<EmployeeTaxDeclarationRestModel>> resp = new JsonResponse<List<EmployeeTaxDeclarationRestModel>>();
		try {

			String value = "SET @p_empId=\"" + userId + "\",@p_startYr=\"" + startYr + "\",@p_endYr=\"" + endYr + "\";";

			List<Object[]> x = em.createNamedStoredProcedureQuery("taxDeclaration")
					.setParameter("actionType", "viewTaxDeclaration").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				EmployeeTaxDeclarationRestModel viewTax = new EmployeeTaxDeclarationRestModel(m[0], m[1].toString(),
						m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13]);
				viewTaxDeclaration.add(viewTax);
				resp.setBody(viewTaxDeclaration);

			}
		} catch (Exception e) {
			logger.error("Monthly Income: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewMonthlyIncomeDao Dao ends");
		return resp;

	}

	// view Adhoc Income Details
	@SuppressWarnings("unchecked")
	public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewAdhocIncomeDao(String userId, String startYr,
			String endYr) {

		logger.info("Method : viewAdhocIncomeDao Dao starts");
		List<EmployeeTaxDeclarationRestModel> viewMonthlyAdhoc = new ArrayList<EmployeeTaxDeclarationRestModel>();
		JsonResponse<List<EmployeeTaxDeclarationRestModel>> resp = new JsonResponse<List<EmployeeTaxDeclarationRestModel>>();
		try {

			String value = "SET @p_empId=\"" + userId + "\",@p_startYr=\"" + startYr + "\",@p_endYr=\"" + endYr + "\";";

			List<Object[]> x = em.createNamedStoredProcedureQuery("taxDeclaration")
					.setParameter("actionType", "viewMothlyAdhoc").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				EmployeeTaxDeclarationRestModel viewTax = new EmployeeTaxDeclarationRestModel(null, m[0],
						m[1].toString(),m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13]);
				viewMonthlyAdhoc.add(viewTax);
				resp.setBody(viewMonthlyAdhoc);

			}
		} catch (Exception e) {
			logger.error("Adhoc Income: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewAdhocIncomeDao Dao ends");
		return resp;

	}

	
	// view Other Item Details
		@SuppressWarnings("unchecked")
		public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewOtherItemDetailsDao(String userId, String startYr,
				String endYr) {

			logger.info("Method : viewOtherItemDetailsDao Dao starts");
			List<EmployeeTaxDeclarationRestModel> viewMonthlyOtherItems = new ArrayList<EmployeeTaxDeclarationRestModel>();
			JsonResponse<List<EmployeeTaxDeclarationRestModel>> resp = new JsonResponse<List<EmployeeTaxDeclarationRestModel>>();
			try {

				String value = "SET @p_empId=\"" + userId + "\",@p_startYr=\"" + startYr + "\",@p_endYr=\"" + endYr + "\";";

				List<Object[]> x = em.createNamedStoredProcedureQuery("taxDeclaration")
						.setParameter("actionType", "viewOtherIncome").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					EmployeeTaxDeclarationRestModel viewTax = new EmployeeTaxDeclarationRestModel(m[0],
							m[1].toString(),m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13],null,null);
					viewMonthlyOtherItems.add(viewTax);
					resp.setBody(viewMonthlyOtherItems);

				}
			} catch (Exception e) {
				logger.error("view Other Item Details : " + e.getMessage());
				e.printStackTrace();
			}
			logger.info("Method : viewOtherItemDetailsDao Dao ends");
			return resp;

		}
		
		
		// view PERQUISITES Details
				@SuppressWarnings("unchecked")
				public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewPerquisiteDetailsDao(String userId, String startYr,
						String endYr) {
					logger.info("Method : viewPerquisiteDetailsDao Dao starts");
					List<EmployeeTaxDeclarationRestModel> viewPERQUISITES = new ArrayList<EmployeeTaxDeclarationRestModel>();
					JsonResponse<List<EmployeeTaxDeclarationRestModel>> resp = new JsonResponse<List<EmployeeTaxDeclarationRestModel>>();
					try {

						String value = "SET @p_empId=\"" + userId + "\",@p_startYr=\"" + startYr + "\",@p_endYr=\"" + endYr + "\";";
						logger.info("viewPerquisiteDetails value======"+value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("taxDeclaration")
								.setParameter("actionType", "viewPerquisiteDetails").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {
							EmployeeTaxDeclarationRestModel viewTax = new EmployeeTaxDeclarationRestModel(m[0],
									m[1].toString());
							viewPERQUISITES.add(viewTax);
							resp.setBody(viewPERQUISITES);

						}
					} catch (Exception e) {
						logger.error("view PERQUISITES Details : " + e.getMessage());
						e.printStackTrace();
					}
					logger.info("viewPerquisiteDetails======"+resp);
					logger.info("Method : viewPerquisiteDetailsDao Dao ends");
					return resp;

				}
				
				// view PERQUISITES Details
				@SuppressWarnings("unchecked")
				public JsonResponse<List<EmployeeTaxDeclarationRestModel>> incomeExcludeFromTaxDao(String userId, String startYr,
						String endYr) {

					logger.info("Method : incomeExcludeFromTaxDao Dao starts");
					List<EmployeeTaxDeclarationRestModel> viewPERQUISITES = new ArrayList<EmployeeTaxDeclarationRestModel>();
					JsonResponse<List<EmployeeTaxDeclarationRestModel>> resp = new JsonResponse<List<EmployeeTaxDeclarationRestModel>>();
					try {

						String value = "SET @p_empId=\"" + userId + "\",@p_startYr=\"" + startYr + "\",@p_endYr=\"" + endYr + "\";";

						List<Object[]> x = em.createNamedStoredProcedureQuery("taxDeclaration")
								.setParameter("actionType", "incomeExcludedTax").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {
							EmployeeTaxDeclarationRestModel viewTax = new EmployeeTaxDeclarationRestModel(m[0],
									m[1].toString(),null);
							viewPERQUISITES.add(viewTax);
							resp.setBody(viewPERQUISITES);

						}
					} catch (Exception e) {
						logger.error("view PERQUISITES Details : " + e.getMessage());
						e.printStackTrace();
					}
					logger.info("Method : incomeExcludeFromTaxDao Dao ends");
					return resp;

				}
				
				// view prev Employer tax Details
				@SuppressWarnings("unchecked")
				public JsonResponse<List<EmployeeTaxDeclarationRestModel>> prevEmployerTaxDeclartionDao(String userId, String startYr,
						String endYr) {

					logger.info("Method : prevEmployerTaxDeclartionDao Dao starts");
					List<EmployeeTaxDeclarationRestModel> viewPrevEmployerTaxDetails = new ArrayList<EmployeeTaxDeclarationRestModel>();
					JsonResponse<List<EmployeeTaxDeclarationRestModel>> resp = new JsonResponse<List<EmployeeTaxDeclarationRestModel>>();
					try {

						String value = "SET @p_empId=\"" + userId + "\",@p_startYr=\"" + startYr + "\",@p_endYr=\"" + endYr + "\";";

						List<Object[]> x = em.createNamedStoredProcedureQuery("taxDeclaration")
								.setParameter("actionType", "prevEmployerTaxDetails").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {
							EmployeeTaxDeclarationRestModel viewTax = new EmployeeTaxDeclarationRestModel(m[0],
									m[1].toString(),null);
							viewPrevEmployerTaxDetails.add(viewTax);
							resp.setBody(viewPrevEmployerTaxDetails);
							logger.info("viewPrevEmployerTaxDetails"+viewPrevEmployerTaxDetails);
						}
					} catch (Exception e) {
						logger.error("view prev Employer TaxDeclartionDao Details : " + e.getMessage());
						e.printStackTrace();
					}
					logger.info("Method : prevEmployerTaxDeclartionDao Dao ends");
					return resp;

				}
				
				
				// view prev Employer tax details Details
				@SuppressWarnings("unchecked")
				public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewLessExemptionUnderSec10Dao(String userId, String startYr,
						String endYr) {

					logger.info("Method : viewLessExemptionUnderSec10Dao Dao starts");
					List<EmployeeTaxDeclarationRestModel> viewPrevEmployerTaxDetails = new ArrayList<EmployeeTaxDeclarationRestModel>();
					JsonResponse<List<EmployeeTaxDeclarationRestModel>> resp = new JsonResponse<List<EmployeeTaxDeclarationRestModel>>();
					try {

						String value = "SET @p_empId=\"" + userId + "\",@p_startYr=\"" + startYr + "\",@p_endYr=\"" + endYr + "\";";

						List<Object[]> x = em.createNamedStoredProcedureQuery("taxDeclaration")
								.setParameter("actionType", "lessExemptionUnderSec10Details").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {
							EmployeeTaxDeclarationRestModel viewTax = new EmployeeTaxDeclarationRestModel(m[0].toString(),
									m[1].toString(),null);
							viewPrevEmployerTaxDetails.add(viewTax);
							resp.setBody(viewPrevEmployerTaxDetails);

						}
					} catch (Exception e) {
						logger.error("view Less ExemptionUnderSec 10 Dao Details : " + e.getMessage());
						e.printStackTrace();
					}
					logger.info("Method : viewLessExemptionUnderSec 10 Dao ends");
					return resp;

				}
				
				// view prev Employer tax Details
				@SuppressWarnings("unchecked")
				public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewLessDeductionSection(String userId, String startYr,
						String endYr) {

					logger.info("Method : viewLessDeductionSection Dao starts");
					List<EmployeeTaxDeclarationRestModel> viewPrevEmployerTaxDetails = new ArrayList<EmployeeTaxDeclarationRestModel>();
					JsonResponse<List<EmployeeTaxDeclarationRestModel>> resp = new JsonResponse<List<EmployeeTaxDeclarationRestModel>>();
					try {

						String value = "SET @p_empId=\"" + userId + "\",@p_startYr=\"" + startYr + "\",@p_endYr=\"" + endYr + "\";";

						List<Object[]> x = em.createNamedStoredProcedureQuery("taxDeclaration")
								.setParameter("actionType", "lessDeductionUnderSection16s").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {
							EmployeeTaxDeclarationRestModel viewTax = new EmployeeTaxDeclarationRestModel(m[0],
									m[1].toString(),null);
							viewPrevEmployerTaxDetails.add(viewTax);
							resp.setBody(viewPrevEmployerTaxDetails);
							logger.info("viewPrevEmployerTaxDetails"+viewPrevEmployerTaxDetails);
						}
					} catch (Exception e) {
						logger.error("viewLessDeductionSection : " + e.getMessage());
						e.printStackTrace();
					}
					logger.info("Method : viewLessDeductionSection Dao ends"+resp);
					return resp;
				}
				
				// view any other income by employee
				@SuppressWarnings("unchecked")
				public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewAnyOtherIncomeByEmp(String userId, String startYr,
						String endYr) {

					logger.info("Method : viewAnyOtherIncomeByEmp Dao starts"+userId);
					List<EmployeeTaxDeclarationRestModel> viewPrevEmployerTaxDetails = new ArrayList<EmployeeTaxDeclarationRestModel>();
					JsonResponse<List<EmployeeTaxDeclarationRestModel>> resp = new JsonResponse<List<EmployeeTaxDeclarationRestModel>>();
					try {

						String value = "SET @p_empId=\"" + userId + "\",@p_startYr=\"" + startYr + "\",@p_endYr=\"" + endYr + "\";";

						List<Object[]> x = em.createNamedStoredProcedureQuery("taxDeclaration")
								.setParameter("actionType", "viewanyOtherIncomeByEmp").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {
							EmployeeTaxDeclarationRestModel viewTax = new EmployeeTaxDeclarationRestModel(m[0],
									m[1].toString(),null);
							viewPrevEmployerTaxDetails.add(viewTax);
							resp.setBody(viewPrevEmployerTaxDetails);
							logger.info("viewPrevEmployerTaxDetails"+viewPrevEmployerTaxDetails);
						}
					} catch (Exception e) {
						logger.error("viewAnyOtherIncomeByEmp : " + e.getMessage());
						e.printStackTrace();
					}
					logger.info("Method : viewAnyOtherIncomeByEmp Dao ends"+resp);
					return resp;
				}
				
				// view Deduction Under Chapter vi-A
				@SuppressWarnings("unchecked")
				public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewDeductionViA(String userId, String startYr,
						String endYr) {

					logger.info("Method : viewDeductionViA Dao starts");
					List<EmployeeTaxDeclarationRestModel> viewMonthlyOtherItems = new ArrayList<EmployeeTaxDeclarationRestModel>();
					JsonResponse<List<EmployeeTaxDeclarationRestModel>> resp = new JsonResponse<List<EmployeeTaxDeclarationRestModel>>();
					try {

						String value = "SET @p_empId=\"" + userId + "\",@p_startYr=\"" + startYr + "\",@p_endYr=\"" + endYr + "\";";

						List<Object[]> x = em.createNamedStoredProcedureQuery("taxDeclaration")
								.setParameter("actionType", "viewDeductionChapter").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {
							EmployeeTaxDeclarationRestModel viewTax = new EmployeeTaxDeclarationRestModel(m[0],
									null,m[1].toString(),m[2].toString(),null);
							viewMonthlyOtherItems.add(viewTax);
							resp.setBody(viewMonthlyOtherItems);

						}
					} catch (Exception e) {
						logger.error("viewDeductionViA : " + e.getMessage());
						e.printStackTrace();
					}
					logger.info("Method : viewDeductionViA Dao ends"+resp);
					return resp;

				}
				
				// view Surchage On Tax
				@SuppressWarnings("unchecked")
				public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewSurchageTax(String userId, String startYr,
						String endYr) {

					logger.info("Method : viewSurchageTax Dao starts"+userId);
					logger.info("startYr"+startYr);
					logger.info("endYr"+endYr);
					List<EmployeeTaxDeclarationRestModel> viewMonthlyOtherItems = new ArrayList<EmployeeTaxDeclarationRestModel>();
					JsonResponse<List<EmployeeTaxDeclarationRestModel>> resp = new JsonResponse<List<EmployeeTaxDeclarationRestModel>>();
					try {

						String value = "SET @p_empId=\"" + userId + "\",@p_startYr=\"" + startYr + "\",@p_endYr=\"" + endYr + "\";";

						List<Object[]> x = em.createNamedStoredProcedureQuery("taxDeclaration")
								.setParameter("actionType", "viewSurchageTax").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {
							EmployeeTaxDeclarationRestModel viewTax = new EmployeeTaxDeclarationRestModel(m[0],
									m[1].toString(),null);
							viewMonthlyOtherItems.add(viewTax);
							resp.setBody(viewMonthlyOtherItems);

						}
					} catch (Exception e) {
						logger.error("viewSurchageTax : " + e.getMessage());
						e.printStackTrace();
					}
					logger.info("Method : viewSurchageTax Dao ends"+resp);
					return resp;

				}
				
				// view Tax Paid Till
				@SuppressWarnings("unchecked")
				public JsonResponse<List<EmployeeTaxDeclarationRestModel>> viewTaxPaidTill(String userId, String startYr,
						String endYr) {

					logger.info("Method : viewTaxPaidTill Dao starts");
					List<EmployeeTaxDeclarationRestModel> viewMonthlyOtherItems = new ArrayList<EmployeeTaxDeclarationRestModel>();
					JsonResponse<List<EmployeeTaxDeclarationRestModel>> resp = new JsonResponse<List<EmployeeTaxDeclarationRestModel>>();
					try {

						String value = "SET @p_empId=\"" + userId + "\",@p_startYr=\"" + startYr + "\",@p_endYr=\"" + endYr + "\";";

						List<Object[]> x = em.createNamedStoredProcedureQuery("taxDeclaration")
								.setParameter("actionType", "viewTaxPaidTill").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {
							EmployeeTaxDeclarationRestModel viewTax = new EmployeeTaxDeclarationRestModel(m[0],
									null,m[1].toString(),m[2].toString(),null);
							viewMonthlyOtherItems.add(viewTax);
							resp.setBody(viewMonthlyOtherItems);

						}
					} catch (Exception e) {
						logger.error("viewTaxPaidTill : " + e.getMessage());
						e.printStackTrace();
					}
					logger.info("Method : viewTaxPaidTill Dao ends"+resp);
					return resp;

				}
}
