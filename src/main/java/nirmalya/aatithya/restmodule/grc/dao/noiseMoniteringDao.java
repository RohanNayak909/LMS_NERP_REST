package nirmalya.aatithya.restmodule.grc.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateDcaMonitorReportParam;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateNoiseMonitorReportParam;
import nirmalya.aatithya.restmodule.common.utils.ticket.GenerateTicketDigitalLogBookParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.grc.model.dcaMonitoringRestModel;
import nirmalya.aatithya.restmodule.grc.model.noiseMonitorReportModel;
import nirmalya.aatithya.restmodule.ticket.model.DigitalLogBookRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;


@Repository
public class noiseMoniteringDao {
	
	Logger logger = LoggerFactory.getLogger(noiseMoniteringDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getNoiseMonitorData(String orgName, String orgDivision) {
		logger.info("Method : getNoiseMonitorData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_noise_monitoring_report_routines")
					.setParameter("actionType", "getMonitorData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getNoiseMonitorData Dao ends" + resp);
		return resp;

	}
	
	public ResponseEntity<JsonResponse<List<noiseMonitorReportModel>>> activityAdd(List<noiseMonitorReportModel> av) {
		logger.info("Method : activityAdd dao starts");
		JsonResponse<List<noiseMonitorReportModel>> resp = new JsonResponse<List<noiseMonitorReportModel>>();

		String value = GenerateNoiseMonitorReportParam.getAddCompilationActivity(av);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + value);
		try {

			if (av.get(0).getMonitorId() != null && av.get(0).getMonitorId() != "") {

				em.createNamedStoredProcedureQuery("grc_noise_monitoring_report_routines")
						.setParameter("actionType", "modifyActivity").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("grc_noise_monitoring_report_routines")
						.setParameter("actionType", "activityAdd").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

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

		ResponseEntity<JsonResponse<List<noiseMonitorReportModel>>> response = new ResponseEntity<JsonResponse<List<noiseMonitorReportModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : activityAdd dao ends");
		return response;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewNoiseMonitor(String orgName, String orgDivision) {
		logger.info("Method : viewNoiseMonitor Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_noise_monitoring_report_routines")
					.setParameter("actionType", "viewMonitorData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewNoiseMonitor Dao ends" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editNoiseMonitor(String id, String orgName, String orgDivision) {
		logger.info("Method : editNoiseMonitor Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_MonitorId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("edit----------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_noise_monitoring_report_routines")
					.setParameter("actionType", "editActivity").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editNoiseMonitor Dao ends");
		return resp;
	}
	
	
	
	public ResponseEntity<JsonResponse<Object>> deleteNoiseMonitor(String id, String orgName, String orgDiv) {
		logger.info("Method : deleteNoiseMonitor starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_MonitorId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("DELETE---------------------" + value);
				em.createNamedStoredProcedureQuery("grc_noise_monitoring_report_routines")
						.setParameter("actionType", "deleteActivity").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteNoiseMonitor ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> monitorReportPdf(String id,String orgName,String orgDivision) {
		logger.info("Method : monitorReportPdf Dao startsssss" + id );

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_MonitorId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_noise_monitoring_report_routines")
					.setParameter("actionType", "editActivity").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp******" + resp);
		logger.info("Method : monitorReportPdf Dao ends");
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getDcaMonitorData(String orgName, String orgDivision) {
		logger.info("Method : getDcaMonitorData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_dca_monitoring_report_routines")
					.setParameter("actionType", "getDcaMonitorData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDcaMonitorData Dao ends" + resp);
		return resp;

	}
	
	
	
	public ResponseEntity<JsonResponse<List<dcaMonitoringRestModel>>> dcaMonitorAdd(List<dcaMonitoringRestModel> av) {
		logger.info("Method : dcaMonitorAdd dao starts");
		JsonResponse<List<dcaMonitoringRestModel>> resp = new JsonResponse<List<dcaMonitoringRestModel>>();

		String value = GenerateDcaMonitorReportParam.getAddDcaActivity(av);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + value);
		try {

			if (av.get(0).getMonitorId() != null && av.get(0).getMonitorId() != "") {

				em.createNamedStoredProcedureQuery("grc_dca_monitoring_report_routines")
						.setParameter("actionType", "modifyActivity").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("grc_dca_monitoring_report_routines")
						.setParameter("actionType", "activityAdd").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

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

		ResponseEntity<JsonResponse<List<dcaMonitoringRestModel>>> response = new ResponseEntity<JsonResponse<List<dcaMonitoringRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : dcaMonitorAdd dao ends");
		return response;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewDcaMonitor(String orgName, String orgDivision) {
		logger.info("Method : viewDcaMonitor Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_dca_monitoring_report_routines")
					.setParameter("actionType", "viewDcaMonitorData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewDcaMonitor Dao ends" + resp);
		return resp;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editDcaMonitor(String id, String orgName, String orgDivision) {
		logger.info("Method : editDcaMonitor Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_MonitorId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("edit----------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_dca_monitoring_report_routines")
					.setParameter("actionType", "editActivity").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editDcaMonitor Dao ends");
		return resp;
	}
	
	
	
	public ResponseEntity<JsonResponse<Object>> deleteDcaMonitor(String id, String orgName, String orgDiv) {
		logger.info("Method : deleteDcaMonitor starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_MonitorId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("DELETE---------------------" + value);
				em.createNamedStoredProcedureQuery("grc_dca_monitoring_report_routines")
						.setParameter("actionType", "deleteActivity").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteDcaMonitor ends");
		return response;
	}

	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> DcamonitorReportPdf(String id,String orgName,String orgDivision) {
		logger.info("Method : DcamonitorReportPdf Dao startsssss" + id );

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_MonitorId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("grc_dca_monitoring_report_routines")
					.setParameter("actionType", "editActivity").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp******" + resp);
		logger.info("Method : DcamonitorReportPdf Dao ends");
		return resp;

	}
	
	 @SuppressWarnings("unchecked")
	    public JsonResponse<Object> approveNoiseReport(String noiseId,String orgName, String orgDiv) {
	        logger.info("Method : approveNoiseReport Dao starts");

	        JsonResponse<Object> resp = new JsonResponse<Object>();

	        try {
	             
	            String value = "SET @p_noiseId='" + noiseId + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
	            System.out.println("approveNoiseReport========>" + value);

	            Object x = em.createNamedStoredProcedureQuery("grc_noise_monitoring_report_routines")
	                    .setParameter("actionType", "approveReport").setParameter("actionValue", value)
	                    .getSingleResult();
	            System.out.println("value of x ------->>>>> "+x.toString());
	            if(Integer.parseInt(x.toString()) > 0) {
					resp.setCode("success");
		  			resp.setMessage("Selected Report Approved successfully");
	  			}

	        } catch (Exception e) {
	            resp.setCode("failed");
	            resp.setMessage(e.getMessage());
	            e.printStackTrace();
	        }

	        logger.info("Method : approveNoiseReport Dao ends" + resp);
	        return resp;
	    }

}
