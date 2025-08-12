package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class BankReconciliationDao {
	Logger logger = LoggerFactory.getLogger(BankReconciliationDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> bankLedgerList(String orgName,String orgDivision) {
		logger.info("Method :bankLedgerList starts");
		List<DropDownModel> bankLedgerList = new ArrayList<DropDownModel>();
		String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bank_reconciliation_routines")
					.setParameter("actionType", "getBankLedgerList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bankLedgerList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : bankLedgerList ends");
		return bankLedgerList;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> bankReconciliationView(String orgName, String orgDivision, String fromDate, String toDate,String bank,String type) {
		logger.info("Method : bankReconciliationView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String fromDt = DateFormatter.getStringDate(fromDate);
			String toDt = DateFormatter.getStringDate(toDate);
			String value = "SET @p_orgName ='" + orgName + "',@p_orgDiv ='" + orgDivision + "',@p_fromDate ='" + fromDt+ "',@p_toDate ='" + toDt + "',@p_bank='" + bank+ "',@p_type ='" + type + "';";
			logger.info("Values are: {}", value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bank_reconciliation_routines")
					.setParameter("actionType", "bankReconciliationView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : bankReconciliationView Dao ends");
		return resp;
	}
	//clearanceSave
	public JsonResponse<Object> clearanceSave(String orgName, String orgDivision, String vid,String chqClrDate,String remarks,String userId) {
		logger.info("Method : clearanceSave Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String chqClrDate1 = DateFormatter.getStringDate(chqClrDate);
			String value = "SET @p_orgName ='" + orgName + "',@p_orgDiv ='" + orgDivision + "',@p_createdBy ='" + userId + "',@p_vid ='" + vid+ "',@p_chqClrDate ='" + chqClrDate1 + "',@p_remarks='" + remarks+ "';";
			logger.info("Values are: {}", value);
			
			em.createNamedStoredProcedureQuery("account_bank_reconciliation_routines")
					.setParameter("actionType", "clearanceSave").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Data saved successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("Method : clearanceSave Dao ends");
		return resp;
	}
}