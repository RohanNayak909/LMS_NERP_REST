package nirmalya.aatithya.restmodule.account.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestAccountStatutoryReportDao {
	Logger logger = LoggerFactory.getLogger(RestAccountStatutoryReportDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewTdsFilteredData(String orgName, String orgDivision, String fromDate, String toDate, String tdsLedgerId,String activeStatus) {
		logger.info("Method : viewTdsFilteredData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_orgName='" + orgName + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_tdsLedgerId='" + tdsLedgerId + 
					"',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',@p_orgDiv='" + orgDivision + "',@p_activeStatus='" + activeStatus + "';";
			
			logger.info("values----->"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_statutoryReport")
					.setParameter("actionType", "getTdsFilterdata").setParameter("actionValue", values)
					.getResultList();
			
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Response TDS View==>"+resp);
		logger.info("Method : viewTdsFilteredData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTdsReceivableLedgerList(String orgName, String orgDiv) {
		logger.info("Method : getTdsReceivableLedgerList starts");
		List<DropDownModel> voucherList = new ArrayList<DropDownModel>();

		try {
			String values = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("values----->"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_statutoryReport")
					.setParameter("actionType", "getTdsReceivableLedgerList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				voucherList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("reponse--" + voucherList);
		logger.info("Method : getTdsReceivableLedgerList ends");
		return voucherList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTdsPayableLedgerList(String orgName, String orgDiv) {
		logger.info("Method : getTdsPayableLedgerList starts");
		List<DropDownModel> voucherList = new ArrayList<DropDownModel>();

		try {
			String values = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("values----->"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_statutoryReport")
					.setParameter("actionType", "getTdsPayableLedgerList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				voucherList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("reponse--" + voucherList);
		logger.info("Method : getTdsPayableLedgerList ends");
		return voucherList;
	}
	
}
