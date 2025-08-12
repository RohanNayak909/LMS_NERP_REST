package nirmalya.aatithya.restmodule.gatepass.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class GatePassFinalReportDao {

	Logger logger = LoggerFactory.getLogger(GatePassFinalReportDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewGatePassFinalReportData(String orgName, String orgDivision, String sec,
			String fromdate, String todate, String type) {
		logger.info("Method : viewGatePassFinalReportData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String FormDate = DateFormatter.getStringDate(fromdate);
		String ToDate = DateFormatter.getStringDate(todate);
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_sec='" + sec
					+ "',@p_fromdate='" + FormDate + "',@p_todate='" + ToDate + "',@p_type='" + type + "';";
			System.out.println("values****************************" + value);
			if (sec.contentEquals("gateIn")) {
				System.out.println("GAteIn");

				List<Object[]> x = em.createNamedStoredProcedureQuery("gatepass_final_report_routines")
						.setParameter("actionType", "viewGateInData").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x);

			} else {

				List<Object[]> x = em.createNamedStoredProcedureQuery("gatepass_final_report_routines")
						.setParameter("actionType", "viewGateOutData").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x);
			}
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewGatePassFinalReportData Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewGatePassFinalReportDataDload(String orgName, String orgDivision, String sec,
			String fromdate, String todate, String type) {
		logger.info("Method : viewGatePassFinalReportDataDload Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String FormDate = DateFormatter.getStringDate(fromdate);
		String ToDate = DateFormatter.getStringDate(todate);
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_sec='" + sec
					+ "',@p_fromdate='" + FormDate + "',@p_todate='" + ToDate + "',@p_type='" + type + "';";
			System.out.println("values****************************" + value);
			if (sec.contentEquals("gateIn")) {
				System.out.println("GAteIn");

				List<Object[]> x = em.createNamedStoredProcedureQuery("gatepass_final_report_routines")
						.setParameter("actionType", "viewGateInDataDload").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x);

			} else {

				List<Object[]> x = em.createNamedStoredProcedureQuery("gatepass_final_report_routines")
						.setParameter("actionType", "viewGateOutDataDload").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x);

			}

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewGatePassFinalReportDataDload Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewGatePassFinalReportEntryDtls(String orgName, String orgDivision, String id) {
		logger.info("Method : viewGatePassFinalReportEntryDtls Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_Entryid='" + id + "';";
			System.out.println("values****************************" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("gatepass_final_report_routines")
					.setParameter("actionType", "viewGateEntryDetls").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewGatePassFinalReportEntryDtls Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewGatePassFinalReportOutDtls(String orgName, String orgDivision, String id) {
		logger.info("Method : viewGatePassFinalReportOutDtls Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_Exitid='" + id + "';";
			System.out.println("values****************************" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("gatepass_final_report_routines")
					.setParameter("actionType", "viewGateOutDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewGatePassFinalReportOutDtls Dao ends");
		return resp;

	}

}
