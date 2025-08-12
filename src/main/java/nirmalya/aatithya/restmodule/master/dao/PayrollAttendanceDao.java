//package nirmalya.aatithya.restmodule.master.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import nirmalya.aatithya.restmodule.common.ServerDao;
//import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
//
//
//@Repository
//public class PayrollAttendanceDao {
//	Logger logger = LoggerFactory.getLogger(PayrollAttendanceDao.class);
//
//	@Autowired
//	ServerDao serverDao;
//
//	@Autowired
//	EntityManager em;
//
//	// view
//	@SuppressWarnings("unchecked")
//	public JsonResponse<Object> getEmployeeList(String orgName, String orgDivision, String userId) {
//		logger.info("Method : getEmployeeList Dao starts");
//		
//		JsonResponse<Object> resp = new JsonResponse<Object>();
//
//		try {
//			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
//			List<Object[]> x = em.createNamedStoredProcedureQuery("payroll_attedance_new_routines")
//					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value).getResultList();
//			resp.setBody(x.get(0));
//			resp.setCode("success");
//			resp.setMessage("Data Fetched successfully");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		logger.info("Method : getEmployeeList Dao ends" + resp );
//		return resp;
//	}
//}
