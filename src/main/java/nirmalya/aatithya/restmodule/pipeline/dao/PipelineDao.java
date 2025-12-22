package nirmalya.aatithya.restmodule.pipeline.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GeneratePipelineParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineActivityModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineLogModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineSmsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestStagesDetailModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class PipelineDao {
	Logger logger = LoggerFactory.getLogger(PipelineDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function for drop down models of customer
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCustomer() {
		logger.info("Method : getCustomer starts");
		List<DropDownModel> customerList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "getCustomer")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				customerList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDefaultUser end");
		return customerList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLostReasonList() {
		logger.info("Method : getLostReasonList starts");
		List<DropDownModel> lostReasonList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline")
					.setParameter("actionType", "getLostReason").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				lostReasonList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDefaultUser end");
		return lostReasonList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStatusList() {
		logger.info("Method : getStatusList starts");
		List<DropDownModel> statusList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline")
					.setParameter("actionType", "getStatusList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				statusList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStatusList end");
		return statusList;
	}

	/**
	 * DAO Function for drop down models of sales person
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSalesPerson() {
		logger.info("Method : getSalesPerson starts");
		List<DropDownModel> salesPersonList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline")
					.setParameter("actionType", "getSalesPerson").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesPersonList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSalesPerson end");
		return salesPersonList;
	}

	/**
	 * DAO Function for drop down models of SalesTeam
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSalesTeam() {
		logger.info("Method : getSalesTeam starts");
		List<DropDownModel> salesTeamList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "getSalesTeam")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesTeamList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSalesTeam end");
		return salesTeamList;
	}

	/**
	 * DAO Function for drop down models of tags
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTags() {
		logger.info("Method : getTags starts");
		List<DropDownModel> tagList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "getTags")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				tagList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCrmTags end");
		return tagList;
	}

	/**
	 * DAO Function for drop down models of company
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCompanyList() {
		logger.info("Method : getCompanyList starts");
		List<DropDownModel> companyList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline")
					.setParameter("actionType", "getCompanyList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				companyList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCompanyList end");
		return companyList;
	}

	/**
	 * DAO Function for drop down models of states
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStatesList() {
		logger.info("Method : getStatesList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "getState")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStatesList end");
		return stateList;
	}

	/**
	 * DAO Function for drop down models of states
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");
		List<DropDownModel> countryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "getCountry")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCountryList end");
		return countryList;
	}

	/**
	 * DAO Function for drop down models of states
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTittleList() {
		logger.info("Method : getTittleList starts");
		List<DropDownModel> tittleList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "getTittle")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				tittleList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTittleList end");
		return tittleList;
	}

	/**
	 * DAO Function for drop down models of states
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCampaignList() {
		logger.info("Method : getCampaignList starts");
		List<DropDownModel> campaignList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "getCampaign")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				campaignList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : campaignList end");
		return campaignList;
	}

	/**
	 * DAO Function for drop down models of medium
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getMediumList() {
		logger.info("Method : getMediumList starts");
		List<DropDownModel> mediumList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "getMedium")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				mediumList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getMediumList end");
		return mediumList;
	}

	/**
	 * DAO Function for drop down models of source
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSourceList() {
		logger.info("Method : getSourceList starts");
		List<DropDownModel> sourceList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "getSource")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				sourceList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSourceList end");
		return sourceList;
	}

	/**
	 * DAO Function for drop down models of language
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLanguageList() {
		logger.info("Method : getLanguageList starts");
		List<DropDownModel> languageList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "getLanguage")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				languageList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getLanguageList end");
		return languageList;
	}

	/**
	 * DAO Function for drop down models for activity type
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getActivityTypeList() {
		logger.info("Method : getActivityTypeList starts");
		List<DropDownModel> activityTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmPipeline")
					.setParameter("actionType", "getActivityType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				activityTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getActivityTypeList end");
		return activityTypeList;
	}

	/**
	 * DAO Function for drop down models for assign to
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAssignTo() {
		logger.info("Method : getAssignTo starts");
		List<DropDownModel> assignToList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmPipeline")
					.setParameter("actionType", "getAssignTo").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				assignToList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAssignTo end");
		return assignToList;
	}

	/**
	 * DAO Function for drop down models of stages
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStageList(String id) {
		logger.info("Method : getStageList starts");
		List<DropDownModel> stageList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_pipelineId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmPipeline").setParameter("actionType", "getStages")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stageList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStageList end");

		return stageList;
	}

	/**
	 * DAO Function for drop down models of stages
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDateList(String id) {
		logger.info("Method : getDateList starts");
		List<DropDownModel> dateList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_pipelineId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmPipeline").setParameter("actionType", "getDates")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object createdDate = null;
				if (m[0] != null) {
					createdDate = DateFormatter.returnStringDate(m[0]);
				}
				DropDownModel dropDownModel = new DropDownModel(createdDate, m[1]);
				dateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDateList end");

		return dateList;
	}

	/**
	 * DAO Function for drop down models of meeting reminder
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getMeetingReminderList() {
		logger.info("Method : getMeetingReminderList starts");
		List<DropDownModel> meetingReminderList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmPipeline")
					.setParameter("actionType", "getMeetingReminder").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				meetingReminderList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getMeetingReminderList end");
		return meetingReminderList;
	}

	/**
	 * DAO Function for drop down models of meeting reminder
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getMeetingRepetationUnitList() {
		logger.info("Method : getMeetingRepetationUnitList starts");
		List<DropDownModel> meetingRepetationUnitList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmPipeline")
					.setParameter("actionType", "getRepetationUnit").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				meetingRepetationUnitList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getMeetingReminderList end");
		return meetingRepetationUnitList;
	}

	/**
	 * DAO Function for drop down models of meeting reminder
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getMeetingRepetationUntilList() {
		logger.info("Method : getMeetingRepetationUntilList starts");
		List<DropDownModel> meetingRepetationUntillList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmPipeline")
					.setParameter("actionType", "getRepetationUntill").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				meetingRepetationUntillList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getMeetingRepetationUntilList end");
		return meetingRepetationUntillList;
	}

	/**
	 * DAO Function for drop down models of meeting privacy
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPrivacyList() {
		logger.info("Method : getPrivacyList starts");
		List<DropDownModel> privacyList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmPipeline")
					.setParameter("actionType", "getPrivacyList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				privacyList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getMeetingRepetationUntilList end");
		return privacyList;
	}

	/**
	 * DAO Function for drop down models of meeting privacy
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getShowAsTimeList() {
		logger.info("Method : getShowAsTimeList starts");
		List<DropDownModel> showAsTimeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmPipeline")
					.setParameter("actionType", "getShowAsTime").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				showAsTimeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getShowAsTimeList end");
		return showAsTimeList;
	}

	/**
	 * DAO Function to add pipeline
	 *
	 */

	public JsonResponse<Object> addPipeline(RestPipelineModel pipeline) {

		logger.info("###### add " + pipeline);
		logger.info("Method : addPipeline starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (pipeline.getPhone() == null || pipeline.getPhone() == "") {
			resp.setMessage("phone no required");

			validity = false;

		}
		if (validity)
			try {
				String values = GeneratePipelineParameter.getAddPipelineParam(pipeline);

				if (pipeline.getPipelineId() == null || pipeline.getPipelineId() == "") {
					logger.info("add=============");

					em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "addPipeline")
							.setParameter("actionValue", values).execute();

				} else {

					em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "modifyPipeline")
							.setParameter("actionValue", values).execute();

				}
			} catch

			(Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		logger.info("@@@@@" + resp);

		logger.info("Method : addEmployee ends");
		return resp;
	}

	/**
	 * DAO Function for auto fill of contact name
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPipelineModel>>> getContactNameAutoComplete(String id) {
		logger.info("Method : getContactNameAutoComplete starts");

		List<RestPipelineModel> form = new ArrayList<RestPipelineModel>();
		JsonResponse<List<RestPipelineModel>> resp = new JsonResponse<List<RestPipelineModel>>();
		try {
			String value = "SET @p_contact='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline")
					.setParameter("actionType", "getContactAuto").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestPipelineModel pipelineModel = new RestPipelineModel(null, m[0], null, null, m[1], m[2], m[3], null,
						null, null, null, null, null, null, m[4], m[5], null, m[6], m[7], m[8], m[9], null, null, m[10],
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, m, m, m, m,
						m, m, m, m, m, m);

				form.add(pipelineModel);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.setBody(form);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestPipelineModel>>> response = new ResponseEntity<JsonResponse<List<RestPipelineModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getContactNameAutoComplete Dao ends");
		return response;
	}

	/*
	 * View Pipeline
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestPipelineModel>> viewAllPipelineDao() {

		logger.info("Method in Dao: viewAllPipelineDao starts");

		List<RestPipelineModel> pipeline = new ArrayList<RestPipelineModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline")
					.setParameter("actionType", "viewAllPipeline").setParameter("actionValue", "").getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					Object createdDate = null;
					if (m[32] != null) {
						createdDate = DateFormatter.returnStringDate(m[32]);
					}
					RestPipelineModel crmPipelineModel = new RestPipelineModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
							m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], null,
							null, createdDate, m[33], m[34], m[35], null, null, null, null, null, null, null, null,
							null, null);

					pipeline.add(crmPipelineModel);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestPipelineModel>> resp = new JsonResponse<List<RestPipelineModel>>();
		resp.setBody(pipeline);

		logger.info("Method in Dao: viewAllPipelinesDao ends");
		// logger.info("fgfghjhfh "+resp);
		return resp;
	}

	/*
	 * Edit Pipeline
	 *
	 *
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<RestPipelineModel> editPipeline(String id) {
		logger.info("Method : editPipeline starts");

		RestPipelineModel req = new RestPipelineModel();
		JsonResponse<RestPipelineModel> resp = new JsonResponse<RestPipelineModel>();

		try {

			String value = "SET @p_pipeline='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "editPipeline")
					.setParameter("actionValue", value).getResultList();
			logger.info(id);

			for (Object[] m : x) {
				Object createdDate = null;
				if (m[32] != null) {
					createdDate = m[32].toString();
				}
				RestPipelineModel reqEdit = new RestPipelineModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22],
						m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], null, null, m[31], createdDate, m[33],
						m[34], m[35], null, null, null, null, null, null, null, null, null, null);
				req = reqEdit;

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editPipeline ends");
		logger.info("rest controller=======" + resp);
		return resp;
	}
	// delete

	@SuppressWarnings("unchecked")
	public JsonResponse<RestPipelineModel> deletePipeline(String id) {
		logger.info("Method : deleteipeline starts");

		logger.info(id + "Hiiiii Amar");

		RestPipelineModel req = new RestPipelineModel();
		JsonResponse<RestPipelineModel> resp = new JsonResponse<RestPipelineModel>();

		try {
			// String value = "SET @p_pipeline='" + id + "';";
			String value = "SET @p_pipeline='(" + id + ")';";
			logger.info("@@@@@" + value);

			em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "deletePipeline")
					.setParameter("actionValue", value).execute();

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : deletePipeline ends");

		return resp;
	}

	/* for notifications */
	@SuppressWarnings("unchecked")
	public List<RestStagesDetailModel> getStagesById(String id, String action) {
		logger.info("Method : getCrmStagesById starts");

		List<RestStagesDetailModel> form = new ArrayList<RestStagesDetailModel>();

		try {
			String value = "SET @p_pipeline='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", action)
					.setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object createdDate = null;
				Object createOnDate = null;
				if (m[2] != null) {
					createdDate = DateFormatter.returnStringDate(m[2]);
				}
				if (m[5] != null) {
					createOnDate = DateFormatter.returnStringDateTime(m[5]);
				}
				RestStagesDetailModel stagesDetailModel = new RestStagesDetailModel(m[0], m[1], createdDate, m[3], m[4],
						createOnDate, m[6], m[7]);
				form.add(stagesDetailModel);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		logger.info("Method : getCrmStagesById end");

		return form;

	}

	/* for notifications */
	@SuppressWarnings("unchecked")
	public List<RestPipelineActivityModel> getPlannedActivityList(String id, String action) {
		logger.info("Method : getCrmPlannedActivityList starts");

		List<RestPipelineActivityModel> form = new ArrayList<RestPipelineActivityModel>();

		try {
			String value = "SET @p_pipeline='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", action)
					.setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object createdDate = null;
				if (m[2] != null) {
					createdDate = DateFormatter.returnStringDate(m[2]);
				}
				Object cretedOnDate = null;
				if (m[9] != null) {
					cretedOnDate = DateFormatter.returnStringDate(m[9]);
				}
				/*
				 * if (m[5] != null) { createOnDate = DateFormatter.returnStringDateTime(m[5]);
				 * }
				 */
				RestPipelineActivityModel pipelineActivityTypeModel = new RestPipelineActivityModel(m[0], m[1],
						createdDate, m[3], m[4], m[5], m[6], m[7], m[8], cretedOnDate);
				form.add(pipelineActivityTypeModel);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		logger.info("Method : getCrmStagesById end");

		return form;

	}

	/**
	 * DAO Function add stages
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addStagesDao(String id, String stage, String previousStage,
			String createdBy) {
		logger.info("Method : DAO addStages starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_pipelineId='" + id + "',@p_stages='" + stage + "',@p_previousStage='" + previousStage
					+ "',@p_createdBy='" + createdBy + "';";

			em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "addStages")
					.setParameter("actionValue", value).execute();
		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : DAO addStages ends");
		return response;
	}

	/**
	 * DAO Function add lost reason
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addLostReason(String id, String lostReason, String createdBy) {//
		logger.info("Method : DAO addLostReason starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			// + "',@p_lostReason='" + lostReason
			String value = "SET @p_pipelineId='" + id + "',@p_lostReason='" + lostReason + "',@p_createdBy='"
					+ createdBy + "';";

			logger.info("HEyaaaaaaaa" + value);

			em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "addLostReason")
					.setParameter("actionValue", value).execute();
		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : DAO addLostReason ends");
		return response;
	}

	// meetinggg

	public JsonResponse<Object> scheduleMeeting(RestPipelineModel pipeline) {

		logger.info("###### addmeeting " + pipeline);
		logger.info("Method : scheduleMeeting starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		/*
		 * if (pipeline.getFromDate() == null || pipeline.getFromDate() == "") {
		 * resp.setMessage("Date required");
		 * 
		 * validity = false;
		 * 
		 * } if (validity)
		 */
			try {
				String values = GeneratePipelineParameter.getMeetingParameters(pipeline);
				logger.info("value---------------"+values);

				if (pipeline.getMeetingId() == null || pipeline.getMeetingId() == "") {
					logger.info("add=============");

					em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "ScheduleMeeting")
							.setParameter("actionValue", values).execute();

				} else {

					em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "modifyPipeline")
							.setParameter("actionValue", values).execute();

				}
			} catch

			(Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		logger.info("@@@@@" + resp);

		logger.info("Method : shcedule Meeting ends");
		return resp;
	}

	// activity type

	public ResponseEntity<JsonResponse<Object>> addpipelineActivityType(
			List<RestPipelineActivityModel> pipelineActivityTypeModel) {
		logger.info("Method : addpipelineActivityType starts");
		// List<DropDownModel> dropModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestPipelineActivityModel l : pipelineActivityTypeModel) {
			if (l.getActivityType() == null || l.getActivityType() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Activity Type");
				break;

			}

		}

		if (validation) {
			try {
				String value = GeneratePipelineParameter.getPipelineAddActivity(pipelineActivityTypeModel);
				if (pipelineActivityTypeModel.get(0).getActivityTypeId() != null
						&& pipelineActivityTypeModel.get(0).getActivityTypeId() != "") {
					em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "modifyActSchedule")
							.setParameter("actionValue", value).execute();

				} else {

					em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "addPipelineActivity")
							.setParameter("actionValue", value).execute();
				}

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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addpipelineActivityType ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addPipelineMessage(List<RestPipelineSmsModel> pipelineSmsModel) {
		logger.info("Method : addPipelineMessage starts");
		// List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestPipelineSmsModel l : pipelineSmsModel) {
			if (l.getPipelineSmsBody() == null || l.getPipelineSmsBody() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please type any message");
				break;

			}

		}

		if (validation) {
			try {
				String value = GeneratePipelineParameter.getPipelineAddMessages(pipelineSmsModel);
				if (pipelineSmsModel.get(0).getPipelineSmsId() != null
						&& pipelineSmsModel.get(0).getPipelineSmsId() != "") {
					em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "addSms")
							.setParameter("actionValue", value).execute();

				} else {

					em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "addSms")
							.setParameter("actionValue", value).execute();
				}

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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addPipelineMessage ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addCrmPipelineLog(List<RestPipelineLogModel> pipelineLogModel) {
		logger.info("Method : addCrmPipelineLog starts");
		// List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (RestPipelineLogModel l : pipelineLogModel) {
			if (l.getPipelineLogBody() == null || l.getPipelineLogBody() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please type any log note");
				break;

			}

		}

		if (validation) {
			try {
				String value = GeneratePipelineParameter.getPipelineAddLog(pipelineLogModel);
				if (pipelineLogModel.get(0).getPipelineLogId() != null
						&& pipelineLogModel.get(0).getPipelineLogId() != "") {
					em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "addLog")
							.setParameter("actionValue", value).execute();

				} else {

					em.createNamedStoredProcedureQuery("crmPipeline").setParameter("actionType", "addLog")
							.setParameter("actionValue", value).execute();
				}

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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addCrmPipelineLog ends");
		return response;
	}

	/**
	 * DAO Function to delete pipeline
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deletePipelineMeetingById(String id, String createdBy) {
		logger.info("Method : deleteCrmPipelineMeetingById dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_meetingScheduleId='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "deleteMeeting")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String[] err = serverDao.errorProcedureCall(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteCrmPipelineMeetingById dao end");
		return response;
	}

	/**
	 * DAO Function for drop down models of customer
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTagList() {
		logger.info("Method : getTagList starts");
		List<DropDownModel> tagList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "getTagList")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				tagList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTagList end");
		return tagList;
	}

	/**
	 * DAO Function to delete pipeline
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> changeMarkDoneStatus(String id) {
		logger.info("Method : changeMarkDoneStatus dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_activityId='" + id + "';";
			em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "changeMarkDone")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String[] err = serverDao.errorProcedureCall(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : changeMarkDoneStatus dao end");
		return response;
	}
	/*
	 * for edit activity type schedule
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestPipelineActivityModel>> getEditActivityTypeSchedule(String id) {

		logger.info("Method : getEditActivityTypeSchedule starts");

		List<RestPipelineActivityModel> activityTypeScheduleDetails = new ArrayList<RestPipelineActivityModel>();
		JsonResponse<RestPipelineActivityModel> resp = new JsonResponse<RestPipelineActivityModel>();

		try {

			String value = "SET @p_activityscheduleId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline")
					.setParameter("actionType", "editActivitySchedule").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object dueDate = null;
				if (m[2] != null) {
					dueDate = DateFormatter.returnStringDate(m[2]);
				}
				Object createdOn = null;
				if (m[9] != null) {
					createdOn = DateFormatter.returnStringDate(m[9]);
				}
				RestPipelineActivityModel activityTypeSchedule = new RestPipelineActivityModel(m[0], m[1], dueDate,
						m[3], m[4], m[5], m[6], m[7], m[8], createdOn);

				activityTypeScheduleDetails.add(activityTypeSchedule);
			}

			resp.setBody(activityTypeScheduleDetails.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestPipelineActivityModel>> response = new ResponseEntity<JsonResponse<RestPipelineActivityModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getEditActivityTypeSchedule ends");

		return response;
	}

	/**
	 * DAO Function to delete activity type schedule
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deleteActivityTypeDetails(String id, String createdBy) {
		logger.info("Method : deleteActivityTypeDetails dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_activityTypeId='" + id + "',@p_createdBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "deleteActSchedule")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String[] err = serverDao.errorProcedureCall(e);

			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteActivityTypeDetails dao end");
		return response;
	}

	// Activity Log Pipeline
	@SuppressWarnings("unchecked")
	public List<ActivitylogModel> getActivityLogPipeline(String id) {
		logger.info("Method : getActivityLog starts");
		List<ActivitylogModel> activitylogModelList = new ArrayList<ActivitylogModel>();
		try {
			String value = "SET @p_pipeline='" + id + "'";

			logger.info("actvity pipeline" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("Pipeline").setParameter("actionType", "ActivityLog")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[6] != null) {
					oa = m[6].toString();
				}
				ActivitylogModel activitylogModel = new ActivitylogModel(m[0], m[1], m[2], m[3], m[4], m[5], oa);
				activitylogModelList.add(activitylogModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(activitylogModelList + "aaaaaaaaaaaaaaa");
		logger.info("Method : getActivityLog ends");
		return activitylogModelList;
	}

}
