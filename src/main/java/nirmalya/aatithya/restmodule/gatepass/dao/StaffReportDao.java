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
public class StaffReportDao {
	Logger logger = LoggerFactory.getLogger(StaffReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// viewAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewStaffReport(String fromdate,String todate,String orgName, String orgDivision) {
		logger.info("Method : viewStaffReport Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String FromDate = DateFormatter.getStringDate(fromdate);
		String ToDate = DateFormatter.getStringDate(todate);
		try {
			String value = "SET @p_org='" + orgName + "',@p_fromdate='" + FromDate + "',@p_todate='" + ToDate + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("staff_report_routines")
					.setParameter("actionType", "viewStaffReport").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewStaffReport Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> showTotal(String id,String fromdate,String todate, String orgName, String orgDivision) {
		logger.info("Method : showTotal Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("values****************************" + fromdate);
		String FromDate = DateFormatter.getStringDate(fromdate);
		String ToDate = DateFormatter.getStringDate(todate);
		try {
			String value = "SET @p_empId='" + id + "',@p_fromdate='" + FromDate + "',@p_todate='" + ToDate + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("staff_report_routines")
					.setParameter("actionType", "showTotal").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : showTotal Dao ends");
		return resp;
	}

}
