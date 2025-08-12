package nirmalya.aatithya.restmodule.productionplan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.productionplan.GenerateParamPlanningProduction;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateCrqsParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionParentModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionRawmaterialModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionVariantModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestProductionPlanningProductList;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class DailyRosterDao {
	Logger logger = LoggerFactory.getLogger(DailyRosterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// viewAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewDailyRosters(String orgName, String orgDivision) {
		logger.info("Method : viewDailyRosters Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "viewDailyRosters").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewDailyRosters Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPlanningProductionParentModel>>> viewDailyPlanning(String planid) {
		logger.info("Method : viewBom starts");
		List<RestPlanningProductionParentModel> respList = new ArrayList<RestPlanningProductionParentModel>();

		try {

			String value = "SET @p_planId='" + planid + "';";
			System.out.println("dddddddddddddddddddddddd" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "viewdailyplanningdetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object Sdate = null;
				if (m[3] != null && m[3] != "") {
					Sdate = DateFormatter.returnStringDate(m[3]);
				}
				logger.info("formate date" + Sdate);

				Object Edate = null;
				if (m[4] != null && m[4] != "") {
					Edate = DateFormatter.returnStringDate(m[4]);
				}

				logger.info("formate date" + Edate);

				RestPlanningProductionParentModel restPayroll = new RestPlanningProductionParentModel(m[0], m[1], m[2],
						Sdate, Edate, m[5], m[6], m[7], m[8], m[9].toString());
				respList.add(restPayroll);

			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestPlanningProductionParentModel>> resp = new JsonResponse<List<RestPlanningProductionParentModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestPlanningProductionParentModel>>> response = new ResponseEntity<JsonResponse<List<RestPlanningProductionParentModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : ViewSuplier ends");

		System.out.println("viewBom" + respList);
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dailyrosterView(String orgName, String orgDivision) {
		logger.info("Method : dailyrosterView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "viewDailyRosters").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : dailyrosterView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<RestPlanningProductionParentModel>>>
	 * viewplanning(String userid) { logger.info("Method : viewBom starts");
	 * List<RestPlanningProductionParentModel> respList = new
	 * ArrayList<RestPlanningProductionParentModel>();
	 * 
	 * try {
	 * 
	 * String value = "SET @p_userId='" + userid + "';";
	 * 
	 * 
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
	 * .setParameter("actionType",
	 * "viewplanningdetailssp").setParameter("actionValue", value).getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * Object Sdate = null; if (m[3] != null && m[3] != "") { Sdate =
	 * DateFormatter.returnStringDate(m[3]); } logger.info("formate date" + Sdate);
	 * 
	 * Object Edate = null; if (m[4] != null && m[4] != "") { Edate =
	 * DateFormatter.returnStringDate(m[4]); }
	 * 
	 * logger.info("formate date" + Edate);
	 * 
	 * RestPlanningProductionParentModel restPayroll = new
	 * RestPlanningProductionParentModel(m[0], m[1], m[2], Sdate, Edate, m[5],
	 * m[6],m[7],m[8], m[9].toString()); respList.add(restPayroll);
	 * 
	 * }
	 * 
	 * System.out.println("VIEW" + respList);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * JsonResponse<List<RestPlanningProductionParentModel>> resp = new
	 * JsonResponse<List<RestPlanningProductionParentModel>>();
	 * resp.setBody(respList);
	 * ResponseEntity<JsonResponse<List<RestPlanningProductionParentModel>>>
	 * response = new
	 * ResponseEntity<JsonResponse<List<RestPlanningProductionParentModel>>>( resp,
	 * HttpStatus.CREATED); System.out.println("response" + response);
	 * logger.info("Method : ViewSuplier ends");
	 * 
	 * System.out.println("viewBom" + respList); return response;
	 * 
	 * }
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dailyrosterShiftView(String orgName, String orgDivision, String date, String id) {
		logger.info("Method : dailyrosterView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String Date = DateFormatter.getStringDate(date);
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_date='" + Date
					+ "',@p_pId='" + id + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "dailyrosterShiftView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : dailyrosterView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// Add Daily Roster.

	public ResponseEntity<JsonResponse<List<RestProductionPlanningProductList>>> addDailyRoster(
			List<RestProductionPlanningProductList> datas) {
		logger.info("Method : addDailyRoster dao starts");
		System.out.println(datas);
		JsonResponse<List<RestProductionPlanningProductList>> resp = new JsonResponse<List<RestProductionPlanningProductList>>();

		String value = GenerateParamPlanningProduction.dailyRosterData(datas);
		System.out.println("value===" + value);

		try {

			em.createNamedStoredProcedureQuery("planningproduction").setParameter("actionType", "addDailyRoster")
					.setParameter("actionValue", value).execute();

			/*
			 * resp.setCode("success"); resp.setMessage(" ");
			 */

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestProductionPlanningProductList>>> response = new ResponseEntity<JsonResponse<List<RestProductionPlanningProductList>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addDailyRoster dao ends");
		return response;

	}

}
