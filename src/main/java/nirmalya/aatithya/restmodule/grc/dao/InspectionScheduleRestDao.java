package nirmalya.aatithya.restmodule.grc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateAuditMasterParam;
import nirmalya.aatithya.restmodule.grc.model.AuditScheduleRestModel;

@Repository
public class InspectionScheduleRestDao {

	Logger logger = LoggerFactory.getLogger(InspectionScheduleRestDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewInspectionSchedule(@RequestParam String orgName, String orgDivision) {
		logger.info("Method : viewInspectionSchedule Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "', @p_orgDiv='" + orgDivision + "';";

			System.out.println("VALUE PARAM:::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "viewInspectionSchedule").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewInspectionSchedule Dao ends");
		return resp;

	}
	
	
	public ResponseEntity<JsonResponse<Object>> inspectionPlanSchedule(AuditScheduleRestModel model) {
		logger.info("Method : inspectionPlanSchedule starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateAuditMasterParam.getAddAuditScheduleParam(model);
			System.out.println("SCHEDULE VALUE PARAM:::::"+values);
			if (model.getAuditScheduleId() == "" || model.getAuditScheduleId() == null) {
				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "addInspectionSchedule").setParameter("actionValue", values)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data saved successfully");
			} else {
				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "modifyInspectionSchedule").setParameter("actionValue", values)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data Modified successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,HttpStatus.CREATED);
		logger.info("Method in Dao: inspectionPlanSchedule ends" );
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> unScheduledInspectionPlan(String id, String orgName, String orgDivision) {
		logger.info("Method : unScheduledInspectionPlan starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "unSchedulePlan").setParameter("actionValue", value).execute();
				resp.setMessage("Data Approved Successfully");
				resp.setCode("success");
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
		logger.info("Method : unScheduledInspectionPlan ends");
		return response;
	}

}
