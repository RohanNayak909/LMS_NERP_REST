package nirmalya.aatithya.restmodule.samudyamproduction.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

@Repository
public class OrderSchedulingDao {
	Logger logger = LoggerFactory.getLogger(OrderSchedulingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager entityManager;

	/*
	 * view
	 */
	/*
	 * @SuppressWarnings("unchecked") public
	 * JsonResponse<List<RestSaleOrderNewModel>> getOrderScheduling(String
	 * userId,String organization, String orgDivision ) {
	 * logger.info("Method : getOrderScheduling Dao starts");
	 * 
	 * List<RestSaleOrderNewModel> getAllemployee = new
	 * ArrayList<RestSaleOrderNewModel>(); JsonResponse<List<RestSaleOrderNewModel>>
	 * resp = new JsonResponse<List<RestSaleOrderNewModel>>();
	 * 
	 * try { String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" +
	 * organization + "\", @p_orgDiv=\"" + orgDivision + "\";";
	 * logger.info("value===="+value); List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("salesOrderNew")
	 * .setParameter("actionType", "viewsalesorder").setParameter("actionValue",
	 * "").getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * Object createdOn = null; if (m[6] != null) { createdOn = m[6].toString(); }
	 * 
	 * 
	 * Object DATER = null; if (m[9] != null) { DATER = m[9].toString(); }
	 * 
	 * Object DATET = null; if (m[9] != null) { DATET = m[9].toString(); } Object
	 * EDATE = null; if (m[10] != null) { EDATE = m[10].toString(); } Object InvDATE
	 * = null; if (m[15] != null) { InvDATE = DateFormatter.returnStringDate(m[15]);
	 * } RestSaleOrderNewModel viewdemo = new RestSaleOrderNewModel(m[0], null,
	 * m[1], m[2], null, null, m[3], m[4], m[5], createdOn, null, null, null, null,
	 * null, null, null, null, null, null, null, m[7], null, null, null, null, m[8],
	 * null, null, DATET, null, null, null,
	 * null,EDATE,m[11],m[12],m[13],null,null,null,
	 * null,null,null,null,null,null,null,m[14],InvDATE,m[16],null,null,null,null,
	 * null,null,null,null,null); getAllemployee.add(viewdemo); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * resp.setBody(getAllemployee);
	 * logger.info("Method : getOrderScheduling Dao ends");
	 * logger.info("DDDDDDDDDDDDDDDDdd"+resp); return resp;
	 * 
	 * }
	 */
}
