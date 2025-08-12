package nirmalya.aatithya.restmodule.grc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAllotedPolicyProgress;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateReportParams;
import nirmalya.aatithya.restmodule.common.utils.ticket.GenerateTicketAddManagementParm;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.grc.model.GRCReportRestModel;
import nirmalya.aatithya.restmodule.maintenance.model.AllotedMaintenanceRestModel;
import nirmalya.aatithya.restmodule.ticket.dao.DepartmentViewDao;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class SBOHIRestDao {

	Logger logger = LoggerFactory.getLogger(DepartmentViewDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getMonthlyEmpList(String orgName, String orgDivision) {
		logger.info("Method : getMonthlyEmpList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='"+ orgDivision + "';";
			System.out.println("VALUE::::" + value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_sbo_hi_routines")
					.setParameter("actionType", "getMonthlyEmpList").setParameter("actionValue", value).getResultList();
			Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getMonthlyEmpList Dao ends" + resp);
		return resp;
	}
	
	public ResponseEntity<JsonResponse<List<GRCReportRestModel>>> addMonthlyEmpDetails(
			List<GRCReportRestModel> av) {
		logger.info("Method : addMonthlyEmpDetails dao starts");
		JsonResponse<List<GRCReportRestModel>> resp = new JsonResponse<List<GRCReportRestModel>>();

		String value = GenerateReportParams.getMonthlyEmpList(av);
		try {

			if (av.get(0).getReportId() != null && av.get(0).getReportId() != "") {

				em.createNamedStoredProcedureQuery("grc_sbo_hi_routines")
						.setParameter("actionType", "modifyMonthlyEmp").setParameter("actionValue", value)
						.execute();

				resp.setCode("success");
				resp.setMessage("Data Modified Successfully");

			}else {
				em.createNamedStoredProcedureQuery("grc_sbo_hi_routines")
				.setParameter("actionType", "addMonthlyEmp").setParameter("actionValue", value)
				.execute();

					resp.setCode("success");
					resp.setMessage("Data Uploaded Successfully");
			}
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

		ResponseEntity<JsonResponse<List<GRCReportRestModel>>> response = new ResponseEntity<JsonResponse<List<GRCReportRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addMonthlyEmpDetails dao ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getMonthlyView(String orgName, String orgDivision) {
		logger.info("Method : getMonthlyView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='"+ orgDivision + "';";
			System.out.println("VALUE::::" + value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_sbo_hi_routines")
					.setParameter("actionType", "getMonthlyView").setParameter("actionValue", value).getResultList();
			Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getMonthlyView Dao ends" + resp);
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getMonthlyEdit(String id,String orgName, String orgDivision) {
		logger.info("Method : getMonthlyEdit Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='"+ orgDivision+ "',@p_requestId='"+ id + "';";
			System.out.println("VALUE::::" + value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_sbo_hi_routines")
					.setParameter("actionType", "getMonthlyEdit").setParameter("actionValue", value).getResultList();
			Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getMonthlyEdit Dao ends" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getYearlyView(String orgName, String orgDivision,String financialYr) {
		logger.info("Method : getYearlyView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='"+ orgDivision+ "',@p_financialYr='"+ financialYr + "';";
			System.out.println("VALUE::::" + value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_sbo_hi_routines")
					.setParameter("actionType", "getYearlyView").setParameter("actionValue", value).getResultList();
			Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getYearlyView Dao ends" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getMonthlyMaster(String orgName, String orgDivision,String month,String year) {
		logger.info("Method : getMonthlyMaster Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='"+ orgDivision+ "',@p_month='"+ month+ "',@p_year='"+ year + "';";
			System.out.println("VALUE::::" + value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_sbo_hi_routines")
					.setParameter("actionType", "getMonthlyMaster").setParameter("actionValue", value).getResultList();
			Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getMonthlyMaster Dao ends" + resp);
		return resp;
	}
	
	public ResponseEntity<JsonResponse<List<GRCReportRestModel>>> addMasterChecklistDetails(
			List<GRCReportRestModel> av) {
		logger.info("Method : addMasterChecklistDetails dao starts");
		JsonResponse<List<GRCReportRestModel>> resp = new JsonResponse<List<GRCReportRestModel>>();

		String value = GenerateReportParams.getMasterChecklistParam(av);
		try {

			if (av.get(0).getReportId() != null && av.get(0).getReportId() != "") {

				em.createNamedStoredProcedureQuery("grc_sbo_hi_routines").setParameter("actionType", "modifyMasterCheck").setParameter("actionValue", value)
						.execute();

				resp.setCode("success");
				resp.setMessage("Data Modified Successfully");

			}else {
				em.createNamedStoredProcedureQuery("grc_sbo_hi_routines").setParameter("actionType", "addMasterCheck").setParameter("actionValue", value)
				.execute();

					resp.setCode("success");
					resp.setMessage("Data Uploaded Successfully");
			}
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

		ResponseEntity<JsonResponse<List<GRCReportRestModel>>> response = new ResponseEntity<JsonResponse<List<GRCReportRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addMasterChecklistDetails dao ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getMasterChecklistView(String orgName, String orgDivision) {
		logger.info("Method : getMasterChecklistView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='"+ orgDivision + "';";
			System.out.println("VALUE::::" + value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_sbo_hi_routines")
					.setParameter("actionType", "masterChecklistView").setParameter("actionValue", value).getResultList();
			Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getMasterChecklistView Dao ends" + resp);
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getMasterChecklistEdit(String id,String orgName, String orgDivision) {
		logger.info("Method : getMasterChecklistEdit Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='"+ orgDivision+ "',@p_requestId='"+ id + "';";
			System.out.println("VALUE::::" + value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_sbo_hi_routines")
					.setParameter("actionType", "masterChecklistEdit").setParameter("actionValue", value).getResultList();
			Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getMasterChecklistEdit Dao ends" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getReportView(String orgName, String orgDivision,String financialYr) {
		logger.info("Method : getReportView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='"+ orgDivision+ "',@p_financialYr='"+ financialYr + "';";
			System.out.println("VALUE::::" + value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_sbo_hi_routines")
					.setParameter("actionType", "getReportView").setParameter("actionValue", value).getResultList();
			Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getReportView Dao ends" + resp);
		return resp;
	}
}
