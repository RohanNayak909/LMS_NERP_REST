package nirmalya.aatithya.restmodule.vms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class RestAuditTrailDao {

	Logger logger = LoggerFactory.getLogger(RestAuditTrailDao.class);
	@Autowired
	ServerDao serverDao;

	@PersistenceContext
	private EntityManager em;
	
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditTypeList(String org, String orgDiv) {
		logger.info("Method : getAuditTypeList starts");
		List<DropDownModel> auditList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("Value is coming For dropDown============> " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vms_contract_routines")
					.setParameter("actionType", "getAuditList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				auditList.add(dropDownModel);
			}

			System.out.println(auditList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAuditTypeList ends");
		System.out.println("Policy List =====>" + auditList);
		return auditList;
	}

	

	// getContractDetails
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAuditLogData(String fromDate, String toDate, String type) {
		logger.info("Method : getAuditLogData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "',@p_type='" + type + "';";
		logger.info("Value is coming For getAuditLogData============> " + value);
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("vms_contract_routines")
					.setParameter("actionType", "getAuditLogData").setParameter("actionValue", value).getResultList();

			if (x.size() > 0 && x.get(0) != null) {
				resp.setBody(x.get(0));
				resp.setMessage("Audit Log fetched successfully.");
				resp.setCode("Success");
			} else {
				resp.setMessage("No data found.");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : getAuditLogData Dao ends");
		return resp;
	}

}
