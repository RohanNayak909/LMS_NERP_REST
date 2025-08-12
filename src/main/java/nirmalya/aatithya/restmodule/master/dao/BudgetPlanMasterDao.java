package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateBudgetPlanParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.BudgetPlanMasterModel;
import nirmalya.aatithya.restmodule.master.model.CCAccountMapModel;
import nirmalya.aatithya.restmodule.master.model.FiscalYearModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class BudgetPlanMasterDao {

	Logger logger = LoggerFactory.getLogger(BudgetPlanMasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getYearList() {
		logger.info("Method : getYearList starts");

		List<DropDownModel> yearList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("budgetPlanRoutines")
					.setParameter("actionType", "getYearList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				DropDownModel item = new DropDownModel(m[0], m[1]);
				yearList.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getYearList ends");
		return yearList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<FiscalYearModel>> saveBudgetPlanYear(FiscalYearModel yearDtls) {
		logger.info("Method : saveBudgetPlanYear starts");

		Boolean validity = true;
		JsonResponse<FiscalYearModel> resp = new JsonResponse<FiscalYearModel>();
		List<FiscalYearModel> yearList = new ArrayList<FiscalYearModel>();
		resp.setMessage("");
		resp.setCode("");
		
		if (yearDtls.getYear() == null || yearDtls.getYear() == "") {
			resp.setMessage("Year Required");
			validity = false;
		}
		
		if (validity)
			try {
				
				if(yearDtls.getYearId() == "" || yearDtls.getYearId() == null) {
					String value = "SET @P_Year='" + yearDtls.getYear() + "', @P_CreatedBy='" + yearDtls.getCreatedBy() + "';";
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("budgetPlanRoutines")
							.setParameter("actionType", "addYear").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {

						FiscalYearModel item = new FiscalYearModel(m[0], m[1], m[2], null);
						yearList.add(item);
					}
					resp.setBody(yearList.get(0));
				} else {
					String value = "SET @P_Year='" + yearDtls.getYear() + "', @P_YearId = '" + yearDtls.getYearId() + "', @P_CreatedBy='" + yearDtls.getCreatedBy() + "';";
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("budgetPlanRoutines")
							.setParameter("actionType", "modifyYear").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {

						FiscalYearModel item = new FiscalYearModel(m[0], m[1], m[2], null);
						yearList.add(item);
					}
					resp.setBody(yearList.get(0));
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<FiscalYearModel>> response = new ResponseEntity<JsonResponse<FiscalYearModel>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveBudgetPlanYear ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<FiscalYearModel>>> getYearDataList() {
		logger.info("Method : getYearDataList ends");
		
		JsonResponse<List<FiscalYearModel>> resp = new JsonResponse<List<FiscalYearModel>>();
		List<FiscalYearModel> yearList = new ArrayList<FiscalYearModel>();
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("budgetPlanRoutines")
					.setParameter("actionType", "getYearDataList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				FiscalYearModel item = new FiscalYearModel(m[0], m[1], m[2], null);
				yearList.add(item);
			}
			resp.setBody(yearList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<FiscalYearModel>>> response = new ResponseEntity<JsonResponse<List<FiscalYearModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getYearDataList ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CCAccountMapModel>>> getCCAccountDataList(String id, String mnth) {
		logger.info("Method : getCCAccountDataList ends");
		
		JsonResponse<List<CCAccountMapModel>> resp = new JsonResponse<List<CCAccountMapModel>>();
		List<CCAccountMapModel> yearList = new ArrayList<CCAccountMapModel>();
		
		try {
			String value = GenerateBudgetPlanParameter.getCCByYear(id,mnth);
			List<Object[]> x = em.createNamedStoredProcedureQuery("budgetPlanRoutines")
					.setParameter("actionType", "getCCAccountDataList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				
				CCAccountMapModel item = new CCAccountMapModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10],
						m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18]);
				yearList.add(item);
			}
			resp.setBody(yearList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<CCAccountMapModel>>> response = new ResponseEntity<JsonResponse<List<CCAccountMapModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getCCAccountDataList ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<CCAccountMapModel> getChartAccountDetails(String id, String year, String mnth) {
		logger.info("Method : getChartAccountDetails ends");
		
		List<CCAccountMapModel> yearList = new ArrayList<CCAccountMapModel>();
		
		try {
			String value = GenerateBudgetPlanParameter.getCAccntByCC(id,year,mnth);
			List<Object[]> x = em.createNamedStoredProcedureQuery("budgetPlanRoutines")
					.setParameter("actionType", "getChartAccountDetails").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				
				CCAccountMapModel item = new CCAccountMapModel(m[0], m[1], m[2], m[3], m[4], null, m[5], m[6], m[7], m[8], m[9], m[10],
						m[11], m[12], m[13], m[14], m[15], m[16], m[17]);
				yearList.add(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getChartAccountDetails ends");
		return yearList;
	}
	
	public ResponseEntity<JsonResponse<Object>> saveBudgetPlanDtls(List<BudgetPlanMasterModel> budgetPlanDtls) {
		logger.info("Method : saveBudgetPlanDtls starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = GenerateBudgetPlanParameter.saveBudgetPlan(budgetPlanDtls);

				em.createNamedStoredProcedureQuery("budgetPlanRoutines").setParameter("actionType", "addBudgetPlan")
						.setParameter("actionValue", value).execute();

			} catch (Exception e) {
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveBudgetPlanDtls ends");
		return response;
	}
}
