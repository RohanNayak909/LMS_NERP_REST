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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateAuditMasterParam;
import nirmalya.aatithya.restmodule.grc.model.AuditScheduleRestModel;

@Repository

public class AuditScheduleRestDao {
	Logger logger = LoggerFactory.getLogger(AuditScheduleRestDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditPlanList(String organization, String orgDivision) {
		logger.info("Method : getAuditPlanList starts");
		List<DropDownModel> getAuditPlanList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getAuditPlanList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAuditPlanList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAuditPlanList end");
		return getAuditPlanList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList(String organization, String orgDivision) {
		logger.info("Method : getDepartmentList starts");
		List<DropDownModel> getDepartmentList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getDepartmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDepartmentList end");
		return getDepartmentList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditeeList(String organization, String orgDivision) {
		logger.info("Method : getAuditeeList starts");
		List<DropDownModel> getAuditeeList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getAuditeeList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAuditeeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAuditeeList end");
		return getAuditeeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSheduledAuditorList(String organization, String orgDivision) {
		logger.info("Method : getSheduledAuditorList starts");
		List<DropDownModel> getSheduledAuditorList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getSheduledAuditorList").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getSheduledAuditorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSheduledAuditorList end");
		return getSheduledAuditorList;
	}
 
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getauditTypeWiseAuditorList(String id) {
		logger.info("Method : get getauditTypeWiseAuditorList starts");
		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_auditor_type='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getauditTypeWiseAuditorList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				categoryList.add(dropDownModel);
			}

			resp.setBody(categoryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : get getauditTypeWiseAuditorList ends");
		return response;
	}

	 
	
	public ResponseEntity<JsonResponse<Object>> auditPlanSchedule(AuditScheduleRestModel model) {
		logger.info("Method : auditPlanSchedule starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateAuditMasterParam.getAddAuditScheduleParam(model);
			logger.info("values-->  " + values);
			logger.info("schedule id-->  " + model.getAuditScheduleId());
			if (model.getAuditScheduleId() == "" || model.getAuditScheduleId() == null) {
				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "addAuditScheduleDetails").setParameter("actionValue", values)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data saved successfully");
			} else {
				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "modifyAuditScheduleDetails").setParameter("actionValue", values)
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		 

		logger.info("Method in Dao: addAuditScheduleSavedata ends" );

		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> unScheduledAuditPlan(String id, String orgName, String orgDivision) {
		logger.info("Method : unScheduledAuditPlan starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "unScheduleAuditPlan").setParameter("actionValue", value).execute();
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
		logger.info("Method : approveAssetPolicy ends");
		return response;
	}

}
