package nirmalya.aatithya.restmodule.api.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.model.CustomerProfileApiModel;
import nirmalya.aatithya.restmodule.api.model.RegistrationRestCrmModel;
import nirmalya.aatithya.restmodule.api.model.RestCrmDealFinalApiModel;
import nirmalya.aatithya.restmodule.api.model.RestDirecterManagerCrmModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateClientDetailsCrmApiParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeRestModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.pipeline.model.CrmVisitHistoryReportRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RegistrationCrmRestDao {

	Logger logger = LoggerFactory.getLogger(RegistrationCrmRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCustomerLists(String organization, String orgDivision, String userId) {
		// TODO Auto-generated method stub
		logger.info("Method : getCustomerLists starts");
		List<DropDownModel> customer = new ArrayList<DropDownModel>();

		String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_TaskApi_Details")
					.setParameter("actionType", "getLeadList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString(), m[2]);
				customer.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCustomerLists end");
		return customer;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSalesTeamLists(String organization, String orgDivision, String userId) {
		// TODO Auto-generated method stub
		logger.info("Method : getSalesTeamLists starts");
		List<DropDownModel> staff = new ArrayList<DropDownModel>();

		String value = "SET @p_createdBy='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
				+ "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
					.setParameter("actionType", "getSalesManagerList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				staff.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSalesTeamLists end");
		return staff;
	}

	/*
	 * add
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RegistrationRestCrmModel>>> addClientDetails(
			List<RegistrationRestCrmModel> registrationRestCrmModel) {

		logger.info("Method : addClientDetails starts");

		logger.info("RegistrationRestCrmModel" + registrationRestCrmModel);
		JsonResponse<List<RegistrationRestCrmModel>> resp = new JsonResponse<List<RegistrationRestCrmModel>>();
		List<RegistrationRestCrmModel> listData = new ArrayList<RegistrationRestCrmModel>();

		try {
			String values = GenerateClientDetailsCrmApiParam.getAddClientParam(registrationRestCrmModel);
			logger.info("Valuee----#" + values);

			if (registrationRestCrmModel.get(0).getClientId() == null
					|| registrationRestCrmModel.get(0).getClientId() == "") {
				logger.info("ADD#" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
						.setParameter("actionType", "addClientDetails").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {
						RegistrationRestCrmModel dropDownModel = new RegistrationRestCrmModel(m[0].toString(),
								m[1].toString());
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				logger.info("Modifyyy" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
						.setParameter("actionType", "modifyClientDetails").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {

						RegistrationRestCrmModel dropDownModel = new RegistrationRestCrmModel(m[0].toString(),
								m[1].toString());
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			resp.setCode("Success");
			resp.setMessage("Data Saved Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getLocalizedMessage());

		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RegistrationRestCrmModel>>> response = new ResponseEntity<JsonResponse<List<RegistrationRestCrmModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addClientDetails ends");
		return response;
	}

	/*
	 * modify Decision Maker
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestDirecterManagerCrmModel>> modifyDecisionMaker(
			RestDirecterManagerCrmModel restDirecterManagerCrmModel) {

		logger.info("Method : modifyDecisionMaker starts");

		logger.info("restDirecterManagerCrmModel" + restDirecterManagerCrmModel);
		JsonResponse<RestDirecterManagerCrmModel> resp = new JsonResponse<RestDirecterManagerCrmModel>();
		RestDirecterManagerCrmModel listData = new RestDirecterManagerCrmModel();

		try {
			String values = GenerateClientDetailsCrmApiParam.getModifyDecisionMakerParam(restDirecterManagerCrmModel);
			logger.info("Valuee----#" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "modifyDecisionMaker").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					RestDirecterManagerCrmModel dropDownModel = new RestDirecterManagerCrmModel(m[0].toString(), m[1],
							m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9]);
					listData = dropDownModel;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.setCode("Success");
			resp.setMessage("Data Modified Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getLocalizedMessage());

		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<RestDirecterManagerCrmModel>> response = new ResponseEntity<JsonResponse<RestDirecterManagerCrmModel>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : modifyDecisionMaker ends");
		return response;
	}

// view customer
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RegistrationRestCrmModel>> getClientDetails(String createdby, String organization,
			String orgDivision) {

		logger.info("Method in Dao: getClientDetails Dao starts");

		List<RegistrationRestCrmModel> viewMaster = new ArrayList<RegistrationRestCrmModel>();
		JsonResponse<List<RegistrationRestCrmModel>> resp = new JsonResponse<List<RegistrationRestCrmModel>>();
		String values = "SET @p_createdBy='" + createdby + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
				+ "';";
		try {
			logger.info("values===" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "getClientDetails").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				// logger.info("x===" + Arrays.toString(m));

				RegistrationRestCrmModel cusDetails = new RegistrationRestCrmModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], null);
				viewMaster.add(cusDetails);
				if (cusDetails.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method in Dao: getClientDetails Dao ends");
		return resp;
	}
	// edit
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RegistrationRestCrmModel>> getClientDetailsEdit(String id, String organization,
			String orgDivision) {
		logger.info("Method in Dao: getClientDetailsEdit Dao starts");

		List<RegistrationRestCrmModel> registrationRestCrmModel = new ArrayList<RegistrationRestCrmModel>();
		JsonResponse<List<RegistrationRestCrmModel>> resp = new JsonResponse<List<RegistrationRestCrmModel>>();
		String values = "SET @p_editId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
		try {
			logger.info("values===" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "getClientEditForParent").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				String profileImg = null;
				if (m[21] != null && m[21] != "" && m[21] != " " && !m[21].toString().equals(" ")
						&& !m[21].toString().equals(null) && !m[21].toString().equals("")) {
					profileImg = env.getMobileView() + "document/crm/" + m[21].toString();
				} else {
					profileImg = "";
				}

				RegistrationRestCrmModel invDetails = new RegistrationRestCrmModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], profileImg);
				registrationRestCrmModel.add(invDetails);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("registrationRestCrmModel====" + registrationRestCrmModel);
		if (!Util.isNull(registrationRestCrmModel) && !registrationRestCrmModel.isEmpty()) {
			for (RegistrationRestCrmModel a : registrationRestCrmModel) {
				List<RestDirecterManagerCrmModel> crmModelDetails = new ArrayList<RestDirecterManagerCrmModel>();
				try {
					String value = "set @p_editId ='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
					logger.info("value===" + value);
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("crm_Client_Routines")
							.setParameter("actionType", "getClientEditForchild").setParameter("actionValue", value)
							.getResultList();
					for (Object[] m : x1) {
						RestDirecterManagerCrmModel dropDownModel = new RestDirecterManagerCrmModel(m[0].toString(),
								m[1], m[2], m[3], m[4], m[5], m[6], m[7], null, m[8]);
						crmModelDetails.add(dropDownModel);
						if (dropDownModel.equals("")) {
							resp.setCode("failed");
							resp.setMessage("Data not found");
						} else {
							resp.setCode("success");
							resp.setMessage("Data fetched successfully");
						}
					}
					a.setDmList(crmModelDetails);
				} catch (Exception e) {
					e.printStackTrace();
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
			}
			resp.setBody(registrationRestCrmModel);
		} else {
			resp.setCode("failed");
			resp.setMessage("Data not found");
		}
		logger.info("resp=====" + resp);
		logger.info("Method in Dao: getClientDetails Dao ends");
		return resp;
	}
	
	// View

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RegistrationRestCrmModel>> getVisistorDetails(String createdBy) {
		logger.info("Method : getVisistorDetails Dao starts");

		List<RegistrationRestCrmModel> viewMaster = new ArrayList<RegistrationRestCrmModel>();
		JsonResponse<List<RegistrationRestCrmModel>> resp = new JsonResponse<List<RegistrationRestCrmModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "getVisistorDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RegistrationRestCrmModel restStudentModel = new RegistrationRestCrmModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11]);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("failed");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(viewMaster);
		logger.info("Method : getVisistorDetails Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}
	// AutoSearch customer

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCustomerAutoSearchList(String id, String organization,
			String orgDivision) {
		logger.info("Method : getCustomerAutoSearchList starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "getCustomerAutoSearchList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCustomerAutoSearchList ends");
		logger.info("AUTODATAAA" + response);
		return response;
	}

	// view search customer
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RegistrationRestCrmModel>> getClientDetailsSearch(String createdBy, String organization,
			String orgDivision, String customer) {
		logger.info("Method in Dao: getClientDetailsSearch Dao starts");

		List<RegistrationRestCrmModel> registrationRestCrmModel = new ArrayList<RegistrationRestCrmModel>();
		JsonResponse<List<RegistrationRestCrmModel>> resp = new JsonResponse<List<RegistrationRestCrmModel>>();
		String values = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
				+ "',@p_customer='" + customer + "';";
		try {
			logger.info("values a ===" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "getClientDetailsSearch").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				logger.info("x===" + Arrays.toString(m));

				RegistrationRestCrmModel invDetails = new RegistrationRestCrmModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], null);
				registrationRestCrmModel.add(invDetails);
			}
			if (registrationRestCrmModel.equals("") || registrationRestCrmModel.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			} else {
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("registrationRestCrmModel====" + registrationRestCrmModel);
		/*
		 * if (!Util.isNull(registrationRestCrmModel) &&
		 * !registrationRestCrmModel.isEmpty()) { for (RegistrationRestCrmModel a :
		 * registrationRestCrmModel) { List<RestDirecterManagerCrmModel> crmModelDetails
		 * = new ArrayList<RestDirecterManagerCrmModel>(); try { String value =
		 * "set @p_clientId ='" + a.getClientId() + "';"; logger.info("value==="
		 * + value); List<Object[]> x1 =
		 * em.createNamedStoredProcedureQuery("crm_Client_Routines")
		 * .setParameter("actionType",
		 * "getClientDetailsforDm").setParameter("actionValue", value) .getResultList();
		 * 
		 * for (Object[] m : x1) {
		 * 
		 * RestDirecterManagerCrmModel dropDownModel = new
		 * RestDirecterManagerCrmModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5],
		 * m[6], m[7], null, m[8]); crmModelDetails.add(dropDownModel); if
		 * (dropDownModel.equals("")) { resp.setCode("failed");
		 * resp.setMessage("Data not found"); } else { resp.setCode("success");
		 * resp.setMessage("Data fetched successfully"); } }
		 * a.setDmList(crmModelDetails); } catch (Exception e) { e.printStackTrace();
		 * resp.setCode("failed"); resp.setMessage(e.getMessage()); } }
		 * resp.setBody(registrationRestCrmModel); } else {
		 * resp.setBody(registrationRestCrmModel); resp.setCode("failed");
		 * resp.setMessage("Data not found"); }
		 */
		resp.setBody(registrationRestCrmModel);
		logger.info("Method in Dao: getClientDetailsSearch Dao ends");
		return resp;
	}

	// view search customer by executive
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RegistrationRestCrmModel>> getClientDetailsSearchByExecutive(String createdBy,
			String organization, String orgDivision, String executive) {
		logger.info("Method in Dao: getClientDetailsSearchByExecutive Dao starts");

		List<RegistrationRestCrmModel> registrationRestCrmModel = new ArrayList<RegistrationRestCrmModel>();
		JsonResponse<List<RegistrationRestCrmModel>> resp = new JsonResponse<List<RegistrationRestCrmModel>>();
		String values = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
				+ "',@p_executive='" + executive + "';";
		try {
			logger.info("values===" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "getClientDetailsSearchByExecutive").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				RegistrationRestCrmModel invDetails = new RegistrationRestCrmModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], null);
				registrationRestCrmModel.add(invDetails);
			}
			if (registrationRestCrmModel.equals("")) {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			} else {
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("registrationRestCrmModel====" + registrationRestCrmModel);

		resp.setBody(registrationRestCrmModel);
		logger.info("Method in Dao: getClientDetailsSearchByExecutive Dao ends");
		return resp;
	}

	// View customer web report search
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealStatusReportSearch(String createdBy,
			String organization, String orgDivision, String fromDate, String toDate, String customer, String saleTeam) {
		logger.info("Method : viewDealStatusReportSearch Dao starts");

		List<RestCrmDealFinalApiModel> viewMaster = new ArrayList<RestCrmDealFinalApiModel>();
		JsonResponse<List<RestCrmDealFinalApiModel>> resp = new JsonResponse<List<RestCrmDealFinalApiModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "',@p_customer='" + customer + "',@p_saleTeam='" + saleTeam
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details")
					.setParameter("actionType", "viewDealStatusReportSearch").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[6] != null) {
					date = DateFormatter.returnStringDate(m[6]);
				}
				Object pcddate = null;
				if (m[12] != null) {
					pcddate = DateFormatter.returnStringDate(m[12]);
				}
				RestCrmDealFinalApiModel restStudentModel = new RestCrmDealFinalApiModel(m[0], m[1], m[2], m[3], m[4],
						m[5], date, m[7], m[8], m[9], m[10], m[11], pcddate, m[13], m[14], m[15], m[16], m[17], m[18]);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewDealStatusReportSearch Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// view customer web Report
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RegistrationRestCrmModel>> getClientDetailsReport(String createdby, String organization,
			String orgDivision) {

		logger.info("Method in Dao: getClientDetailsReport Dao starts");

		List<RegistrationRestCrmModel> registrationRestCrmModel = new ArrayList<RegistrationRestCrmModel>();
		JsonResponse<List<RegistrationRestCrmModel>> resp = new JsonResponse<List<RegistrationRestCrmModel>>();
		String values = "SET @p_createdBy='" + createdby + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
				+ "';";
		try {
			logger.info("values===" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "getClientDetails").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				// logger.info("x===" + Arrays.toString(m));

				RegistrationRestCrmModel invDetails = new RegistrationRestCrmModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], null);
				registrationRestCrmModel.add(invDetails);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(registrationRestCrmModel);
		logger.info("Method in Dao: getClientDetailsReport Dao ends");
		return resp;
	}

	// view customer web Report search
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RegistrationRestCrmModel>> viewCustomerReportSearch(String createdBy, String organization,
			String orgDivision, String fromDate, String toDate, String customer, String saleTeam) {
		logger.info("Method : viewDealStatusReportSearch Dao starts");

		List<RegistrationRestCrmModel> viewMaster = new ArrayList<RegistrationRestCrmModel>();
		JsonResponse<List<RegistrationRestCrmModel>> resp = new JsonResponse<List<RegistrationRestCrmModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "',@p_customer='" + customer + "',@p_saleTeam='" + saleTeam
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "viewCustomerReportSearch").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RegistrationRestCrmModel cusDetails = new RegistrationRestCrmModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], null);
				viewMaster.add(cusDetails);

				if (cusDetails.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewDealStatusReportSearch Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// view Decision Maker Deatils web
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestDirecterManagerCrmModel>> viewDecisionMakerDeatils(String createdBy,
			String organization, String orgDivision) {
		logger.info("Method : viewDecisionMakerDeatils Dao starts");

		List<RestDirecterManagerCrmModel> viewMaster = new ArrayList<RestDirecterManagerCrmModel>();
		JsonResponse<List<RestDirecterManagerCrmModel>> resp = new JsonResponse<List<RestDirecterManagerCrmModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "viewDecisionMakerDeatils").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RestDirecterManagerCrmModel dropDownModel = new RestDirecterManagerCrmModel(m[0].toString(), m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], null, m[9], m[10], m[11]);
				viewMaster.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("VIEWWWWW" + resp);
		logger.info("Method : viewDecisionMakerDeatils Dao ends");

		return resp;
	}

	// view Decision Maker Deatils web
	@SuppressWarnings("unchecked")
	public JsonResponse<List<ManageEmployeeRestModel>> viewExecutiveDeatils(String createdBy, String organization,
			String orgDivision) {
		logger.info("Method : viewExecutiveDeatils Dao starts");

		List<ManageEmployeeRestModel> viewMaster = new ArrayList<ManageEmployeeRestModel>();
		JsonResponse<List<ManageEmployeeRestModel>> resp = new JsonResponse<List<ManageEmployeeRestModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "viewExecutiveDeatils").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object date = null;
				if (m[3] != null) {
					date = DateFormatter.returnStringDate(m[3]);
				}
				ManageEmployeeRestModel dropDownModel = new ManageEmployeeRestModel(m[0].toString(), m[1], m[2], date,
						m[4], m[5]);
				viewMaster.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("VIEWWWWW" + resp);
		logger.info("Method : viewExecutiveDeatils Dao ends");

		return resp;
	}
	// View decision maker report search

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestDirecterManagerCrmModel>> viewDecisionMakerDeatilsSearch(String userId,
			String organization, String orgDivision, String fromDate, String toDate, String customer, String saleTeam) {
		logger.info("Method : viewDecisionMakerDeatilsSearch Dao starts");

		List<RestDirecterManagerCrmModel> viewMaster = new ArrayList<RestDirecterManagerCrmModel>();
		JsonResponse<List<RestDirecterManagerCrmModel>> resp = new JsonResponse<List<RestDirecterManagerCrmModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='"
					+ DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate)
					+ "'," + "@p_user='" + userId + "',@p_customer='" + customer + "',@p_saleTeam='" + saleTeam + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "viewDecisionMakerDeatilsSearch").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				RestDirecterManagerCrmModel dropDownModel = new RestDirecterManagerCrmModel(m[0].toString(), m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], null, m[9], m[10], m[11]);
				viewMaster.add(dropDownModel);

				if (viewMaster.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewDecisionMakerDeatilsSearch Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	public ResponseEntity<JsonResponse<CustomerProfileApiModel>> customerProfileDataUpload(
			CustomerProfileApiModel customer) {
		logger.info("Method : customerProfileDataUpload starts");
		JsonResponse<CustomerProfileApiModel> resp = new JsonResponse<CustomerProfileApiModel>();
		try {
			String values = GenerateClientDetailsCrmApiParam.generateClientProfileUploadParam(customer);
			logger.info("values===" + values);

			em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "customerProfileUpload").setParameter("actionValue", values).execute();
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.error("Error " + err[1]);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			logger.error("saveEmpMaster: " + e.getMessage());
		}
		ResponseEntity<JsonResponse<CustomerProfileApiModel>> response = new ResponseEntity<JsonResponse<CustomerProfileApiModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : customerProfileDataUpload ends");
		return response;
	}

	// View check in history Report
	@SuppressWarnings("unchecked")
	public JsonResponse<List<CrmVisitHistoryReportRestModel>> viewCrmVisitHistoryReport(String userId,
			String organization, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : viewCrmVisitHistoryReport Dao starts");

		List<CrmVisitHistoryReportRestModel> viewMaster = new ArrayList<CrmVisitHistoryReportRestModel>();
		JsonResponse<List<CrmVisitHistoryReportRestModel>> resp = new JsonResponse<List<CrmVisitHistoryReportRestModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='"
					+ DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate)
					+ "',@p_user='" + userId + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "viewCrmVisitHistoryReport").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object date = null;
				if (m[11] != null) {
					date = DateFormatter.returnStringDate(m[11]);
				}
				String visitImg = null;
				if (m[20] != null && m[20] != "" && m[20] != " ") {
					visitImg =m[20].toString();
				} else {
					visitImg = "";
				}
				CrmVisitHistoryReportRestModel restVisitModel = new CrmVisitHistoryReportRestModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], date, m[12], m[13], m[14], m[15], m[16], m[17],
						m[18], m[19],visitImg);
				viewMaster.add(restVisitModel);

				if (restVisitModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmVisitHistoryReport Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// View visit in history Report search
	@SuppressWarnings("unchecked")
	public JsonResponse<List<CrmVisitHistoryReportRestModel>> viewCrmvisitHistoryReportSearch(String userId,
			String organization, String orgDivision, String fromDate, String toDate, String customer, String saleTeam) {
		logger.info("Method : viewCrmvisitHistoryReportSearch Dao starts");

		List<CrmVisitHistoryReportRestModel> viewMaster = new ArrayList<CrmVisitHistoryReportRestModel>();
		JsonResponse<List<CrmVisitHistoryReportRestModel>> resp = new JsonResponse<List<CrmVisitHistoryReportRestModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='"
					+ DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate)
					+ "'," + "@p_user='" + userId + "',@p_customer='" + customer + "',@p_saleTeam='" + saleTeam + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "viewCrmvisitHistoryReportSearch").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object date = null;
				if (m[11] != null) {
					date = DateFormatter.returnStringDate(m[11]);
				}
				String visitImg = null;
				if (m[20] != null || m[20] != "" || m[20] != " ") {
					visitImg =m[20].toString();
				} else {
					visitImg = "";
				}
				CrmVisitHistoryReportRestModel restVisitModel = new CrmVisitHistoryReportRestModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], date, m[12], m[13], m[14], m[15], m[16], m[17],
						m[18], m[19],visitImg);
				viewMaster.add(restVisitModel);

				if (restVisitModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmvisitHistoryReportSearch Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// View visit in history Report search ByType
	@SuppressWarnings({ "unchecked", "unused" })
	public JsonResponse<List<CrmVisitHistoryReportRestModel>> viewCrmvisitHistoryReportSearchByType(String userId,
			String organization, String orgDivision, String fromDate, String toDate, String customer, String saleTeam,
			String type) {
		logger.info("Method : viewCrmvisitHistoryReportSearchByType Dao starts");

		List<CrmVisitHistoryReportRestModel> viewMaster = new ArrayList<CrmVisitHistoryReportRestModel>();
		JsonResponse<List<CrmVisitHistoryReportRestModel>> resp = new JsonResponse<List<CrmVisitHistoryReportRestModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='"
					+ DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate)
					+ "'," + "@p_user='" + userId + "',@p_customer='" + customer + "',@p_saleTeam='" + saleTeam
					+ "',@p_type='" + type + "';";

			if (customer == "" && saleTeam == "") {
				logger.info("value===" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
						.setParameter("actionType", "viewCrmvisitHistoryReportSearchByTypeData")
						.setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					Object date = null;
					if (m[11] != null) {
						date = DateFormatter.returnStringDate(m[11]);
					}
					String visitImg = null;
					if (m[20] != null && m[20] != "" && m[20] != " ") {
						visitImg =m[20].toString();
					} else {
						visitImg = "";
					}
					CrmVisitHistoryReportRestModel restVisitModel = new CrmVisitHistoryReportRestModel(m[0], m[1], m[2],
							m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], date, m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19],visitImg);
					viewMaster.add(restVisitModel);

					if (restVisitModel.equals("")) {
						resp.setCode("success");
						resp.setMessage("Data not found");
					} else {
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
					}
				}
			} else {
				logger.info("value1===" + value);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("crm_Client_Routines")
						.setParameter("actionType", "viewCrmvisitHistoryReportSearchByType")
						.setParameter("actionValue", value).getResultList();
				for (Object[] m : x1) {
					Object date = null;
					if (m[11] != null) {
						date = DateFormatter.returnStringDate(m[11]);
					}
					String visitImg = null;
					if (m[20] != null || m[20] != "" || m[20] != " ") {
						visitImg = env.getMobileView() + "document/crm/" + m[20];
					} else {
						visitImg = "";
					}
					CrmVisitHistoryReportRestModel restVisitModel = new CrmVisitHistoryReportRestModel(m[0], m[1], m[2],
							m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], date, m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19],visitImg);
					viewMaster.add(restVisitModel);
					if (restVisitModel.equals("")) {
						resp.setCode("success");
						resp.setMessage("Data not found");
					} else {
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
					}
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmvisitHistoryReportSearchByType Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// View check in plan Report
	@SuppressWarnings("unchecked")
	public JsonResponse<List<CrmVisitHistoryReportRestModel>> viewCrmVisitPlanReport(String userId, String organization,
			String orgDivision, String fromDate, String toDate) {
		logger.info("Method : viewCrmVisitPlanReport Dao starts");

		List<CrmVisitHistoryReportRestModel> viewMaster = new ArrayList<CrmVisitHistoryReportRestModel>();
		JsonResponse<List<CrmVisitHistoryReportRestModel>> resp = new JsonResponse<List<CrmVisitHistoryReportRestModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "',@p_user='" + userId + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "viewCrmVisitPlanReport").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object date = null;
				if (m[11] != null) {
					date = DateFormatter.returnStringDate(m[11]);
				}
				String visitImg = null;
				if (m[20] != null || m[20] != "" || m[20] != " ") {
					visitImg =m[20].toString();
				} else {
					visitImg = "";
				}
				CrmVisitHistoryReportRestModel restVisitModel = new CrmVisitHistoryReportRestModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], date, m[12], m[13], m[14], m[15], m[16], m[17],
						m[18], m[19],visitImg);
				viewMaster.add(restVisitModel);

				if (restVisitModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmVisitPlanReport Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// View visit in plan Report search
	@SuppressWarnings("unchecked")
	public JsonResponse<List<CrmVisitHistoryReportRestModel>> viewCrmvisitPlanReportSearch(String userId,
			String organization, String orgDivision, String fromDate, String toDate, String customer, String saleTeam) {
		logger.info("Method : viewCrmvisitPlanReportSearch Dao starts");

		List<CrmVisitHistoryReportRestModel> viewMaster = new ArrayList<CrmVisitHistoryReportRestModel>();
		JsonResponse<List<CrmVisitHistoryReportRestModel>> resp = new JsonResponse<List<CrmVisitHistoryReportRestModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "'," + "@p_user='" + userId + "',@p_customer='" + customer
					+ "',@p_saleTeam='" + saleTeam + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "viewCrmvisitPlanReportSearch").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object date = null;
				if (m[11] != null) {
					date = DateFormatter.returnStringDate(m[11]);
				}
				String visitImg = null;
				if (m[20] != null || m[20] != "" || m[20] != " ") {
					visitImg =m[20].toString();
				} else {
					visitImg = "";
				}
				CrmVisitHistoryReportRestModel restVisitModel = new CrmVisitHistoryReportRestModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], date, m[12], m[13], m[14], m[15], m[16], m[17],
						m[18], m[19],visitImg);
				viewMaster.add(restVisitModel);

				if (restVisitModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmvisitPlanReportSearch Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// View visit in plan Report search ByType
	@SuppressWarnings({ "unchecked", "unused" })
	public JsonResponse<List<CrmVisitHistoryReportRestModel>> viewCrmvisitPlanReportSearchByType(String userId,
			String organization, String orgDivision, String fromDate, String toDate, String customer, String saleTeam,
			String type) {
		logger.info("Method : viewCrmvisitPlanReportSearchByType Dao starts");

		List<CrmVisitHistoryReportRestModel> viewMaster = new ArrayList<CrmVisitHistoryReportRestModel>();
		JsonResponse<List<CrmVisitHistoryReportRestModel>> resp = new JsonResponse<List<CrmVisitHistoryReportRestModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "'," + "@p_user='" + userId + "',@p_customer='" + customer
					+ "',@p_saleTeam='" + saleTeam + "',@p_type='" + type + "';";

			if (customer == "" && saleTeam == "") {
				logger.info("value===" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
						.setParameter("actionType", "viewCrmvisitPlanReportSearchByTypeData")
						.setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					Object date = null;
					if (m[11] != null) {
						date = DateFormatter.returnStringDate(m[11]);
					}
					String visitImg = null;
					if (m[20] != null || m[20] != "" || m[20] != " ") {
						visitImg =m[20].toString();
					} else {
						visitImg = "";
					}
					CrmVisitHistoryReportRestModel restVisitModel = new CrmVisitHistoryReportRestModel(m[0], m[1], m[2],
							m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], date, m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19],visitImg);
					viewMaster.add(restVisitModel);

					if (restVisitModel.equals("")) {
						resp.setCode("success");
						resp.setMessage("Data not found");
					} else {
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
					}
				}
			} else {
				logger.info("value1===" + value);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("crm_Client_Routines")
						.setParameter("actionType", "viewCrmvisitPlanReportSearchByType")
						.setParameter("actionValue", value).getResultList();
				for (Object[] m : x1) {
					Object date = null;
					if (m[11] != null) {
						date = DateFormatter.returnStringDate(m[11]);
					}
					String visitImg = null;
					if (m[20] != null || m[20] != "" || m[20] != " ") {
						visitImg =m[20].toString();
					} else {
						visitImg = "";
					}
					CrmVisitHistoryReportRestModel restVisitModel = new CrmVisitHistoryReportRestModel(m[0], m[1], m[2],
							m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], date, m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19],visitImg);
					viewMaster.add(restVisitModel);
					if (restVisitModel.equals("")) {
						resp.setCode("success");
						resp.setMessage("Data not found");
					} else {
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
					}
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmvisitPlanReportSearchByType Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// switchCustomerApply
	public ResponseEntity<JsonResponse<Object>> switchCustomerApply(String customer, String executive, String org,String orgDiv) {
		logger.info("Method : switchCustomerApply starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String value = "SET @p_customer='(" + customer + ")',@p_executive='" + executive + "',@p_org='" + org+ "',@p_orgDiv='" + orgDiv + "';";
				logger.info("value=====" + value);
				em.createNamedStoredProcedureQuery("crm_Client_Routines")
						.setParameter("actionType", "switchCustomerApply").setParameter("actionValue", value).execute();
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
		logger.info("Method : switchCustomerApply ends");
		return response;
	}

	// edit customer switch

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RegistrationRestCrmModel>>> customerSwitchEdit(String id,
			String organization, String orgDivision) {
		logger.info("Method : customerSwitchEdit starts");
		List<RegistrationRestCrmModel> respList = new ArrayList<RegistrationRestCrmModel>();

		try {
			String value = "SET @p_editId='" + id + "';";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "getCustomerSwitchEdit").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RegistrationRestCrmModel invDetails = new RegistrationRestCrmModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20].toString(), m[21], m[22], m[23], m[24], m[25].toString(), m[26]);
				respList.add(invDetails);
			}
			logger.info("respList" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RegistrationRestCrmModel>> resp = new JsonResponse<List<RegistrationRestCrmModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RegistrationRestCrmModel>>> response = new ResponseEntity<JsonResponse<List<RegistrationRestCrmModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("EDITT" + response);
		logger.info("Method : customerSwitchEdit ends");
		return response;

	}
	
	/*
	 * add Customer Details
	 */
	public ResponseEntity<JsonResponse<RegistrationRestCrmModel>> addCustomerDetails(
			RegistrationRestCrmModel registrationRestCrmModel) {
		
		logger.info("Method : addCustomerDetails starts");
		
		logger.info("registrationRestCrmModel" + registrationRestCrmModel);
		JsonResponse<RegistrationRestCrmModel> resp = new JsonResponse<RegistrationRestCrmModel>();
		RegistrationRestCrmModel listData = new RegistrationRestCrmModel();
		
		try {
			String values = GenerateClientDetailsCrmApiParam.generateClientDetailsByAdmin(registrationRestCrmModel);
			logger.info("Valuee----#" + values);
			if(registrationRestCrmModel.getClientId()=="" || registrationRestCrmModel.getClientId()==null) {
				em.createNamedStoredProcedureQuery("crm_Client_Routines")
				.setParameter("actionType", "addCustomerDetailsByAdmin").setParameter("actionValue", values)
				.execute();
				resp.setCode("Success");
				resp.setMessage("Data saved Successfully");
			}else {
				logger.info("elseseseseses");
				em.createNamedStoredProcedureQuery("crm_Client_Routines")
				.setParameter("actionType", "ModifiedCustomerDetailsByAdmin").setParameter("actionValue", values)
				.execute();
				resp.setCode("Success");
				resp.setMessage("Data Modified Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getLocalizedMessage());
			
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<RegistrationRestCrmModel>> response = new ResponseEntity<JsonResponse<RegistrationRestCrmModel>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addCustomerDetails ends");
		return response;
	}
	/*
	 * delete Customer
	 */
	public JsonResponse<RegistrationRestCrmModel> deleteCustomer(String deleteId,String org, String orgDiv) {
		logger.info("Method : deleteCustomer starts");

		RegistrationRestCrmModel req = new RegistrationRestCrmModel();
		JsonResponse<RegistrationRestCrmModel> resp = new JsonResponse<RegistrationRestCrmModel>();

		try {
			String value = "SET @p_clientId='(" + deleteId + ")',@p_org='" + org+ "',@p_orgDiv='" + orgDiv + "';";
			logger.info("DELETE " + value);

			em.createNamedStoredProcedureQuery("crm_Client_Routines").setParameter("actionType", "deleteCustomer")
					.setParameter("actionValue", value).execute();
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : deleteCustomer ends");
		logger.info("+++delete+++++" + resp);
		return resp;
	}
	
	/*******************    Decision Maker   ****************************/
	// edit dm

	@SuppressWarnings("unchecked")
	public JsonResponse<RestDirecterManagerCrmModel> editDecisionMaker(String id, String org,String orgDiv) {
		logger.info("Method : editDecisionMaker dao starts");
		logger.info("Edit" + id);
		RestDirecterManagerCrmModel req = new RestDirecterManagerCrmModel();
		JsonResponse<RestDirecterManagerCrmModel> resp = new JsonResponse<RestDirecterManagerCrmModel>();
		try {
			String value = "SET @p_dmId='" + id + "',@p_org='" + org+ "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
					.setParameter("actionType", "editDecisionMaker").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RestDirecterManagerCrmModel dropDownModel = new RestDirecterManagerCrmModel(m[0].toString(),
						m[1], m[2], m[3], m[4], m[5], m[6], m[7], null, m[8]);
						req=dropDownModel;
				if (dropDownModel.equals("")) {
					resp.setCode("failed");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("editDecisionMaker" + resp);
		logger.info("Method : editEmployeeWorkLocation dao ends");
		return resp;
	}
	/*
	 * add Decision Maker
	 */
	public ResponseEntity<JsonResponse<RestDirecterManagerCrmModel>> addDecisionMaker(
			RestDirecterManagerCrmModel restDirecterManagerCrmModel) {

		logger.info("Method : addDecisionMaker starts");

		logger.info("restDirecterManagerCrmModel" + restDirecterManagerCrmModel);
		JsonResponse<RestDirecterManagerCrmModel> resp = new JsonResponse<RestDirecterManagerCrmModel>();
		RestDirecterManagerCrmModel listData = new RestDirecterManagerCrmModel();

		try {
			String values = GenerateClientDetailsCrmApiParam.getModifyDecisionMakerParam(restDirecterManagerCrmModel);
			logger.info("Valuee----#" + values);
			if(restDirecterManagerCrmModel.getDmId()=="" || restDirecterManagerCrmModel.getDmId()==null) {
				em.createNamedStoredProcedureQuery("crm_Client_Routines")
				.setParameter("actionType", "addDecisionMaker").setParameter("actionValue", values)
				.execute();
				resp.setCode("Success");
				resp.setMessage("Data saved Successfully");
			}else {
				em.createNamedStoredProcedureQuery("crm_Client_Routines")
				.setParameter("actionType", "modifyDecisionMakerDetails").setParameter("actionValue", values)
				.execute();
				resp.setCode("Success");
				resp.setMessage("Data Modified Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getLocalizedMessage());

		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<RestDirecterManagerCrmModel>> response = new ResponseEntity<JsonResponse<RestDirecterManagerCrmModel>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : modifyDecisionMaker ends");
		return response;
	}

	/*
	 * delete Decision Maker
	 */
	public JsonResponse<RestDirecterManagerCrmModel> deleteDecisionMaker(String deleteId,String org, String orgDiv) {
		logger.info("Method : deleteDecisionMaker starts");

		RestDirecterManagerCrmModel req = new RestDirecterManagerCrmModel();
		JsonResponse<RestDirecterManagerCrmModel> resp = new JsonResponse<RestDirecterManagerCrmModel>();

		try {
			String value = "SET @p_dmId='(" + deleteId + ")',@p_org='" + org+ "',@p_orgDiv='" + orgDiv + "';";
			logger.info("DELETE " + value);

			em.createNamedStoredProcedureQuery("crm_Client_Routines").setParameter("actionType", "deleteDecisionMaker")
					.setParameter("actionValue", value).execute();
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : deleteDecisionMaker ends");
		logger.info("+++delete+++++" + resp);
		return resp;
	}
	// view customer by Pagination
		@SuppressWarnings("unchecked")
		public JsonResponse<List<RegistrationRestCrmModel>> getClientDetailsPagination(String createdby, String organization,
				String orgDivision,String pageNo) {

			logger.info("Method in Dao: getClientDetailsPagination Dao starts");

			List<RegistrationRestCrmModel> viewMaster = new ArrayList<RegistrationRestCrmModel>();
			JsonResponse<List<RegistrationRestCrmModel>> resp = new JsonResponse<List<RegistrationRestCrmModel>>();
			String values = "SET @p_createdBy='" + createdby + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision+ "',@p_pageNo='" + pageNo+ "';";
			try {
				logger.info("values===" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
						.setParameter("actionType", "getClientDetailsByPagination").setParameter("actionValue", values).getResultList();
				for (Object[] m : x) {
					// logger.info("x===" + Arrays.toString(m));

					RegistrationRestCrmModel cusDetails = new RegistrationRestCrmModel(m[0], m[1], m[2], m[3], m[4], m[5],
							m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
							m[20], null);
					viewMaster.add(cusDetails);
					if (cusDetails.equals("")) {
						resp.setCode("success");
						resp.setMessage("Data not found");
					} else {
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
					}
				}
				if (viewMaster.isEmpty()) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				}
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
			resp.setBody(viewMaster);
			logger.info("Method in Dao: getClientDetailsPagination Dao ends");
			return resp;
		}
//getClientDetailsEditWeb		
		@SuppressWarnings("unchecked")
		public JsonResponse<RegistrationRestCrmModel> getClientDetailsEditWeb(String id, String organization,
				String orgDivision) {

			logger.info("Method in Dao: getClientDetailsEditWeb Dao starts");

			RegistrationRestCrmModel registrationRestCrmModel = new RegistrationRestCrmModel();
			List<RestDirecterManagerCrmModel> itemList = new ArrayList<RestDirecterManagerCrmModel>();
			JsonResponse<RegistrationRestCrmModel> resp = new JsonResponse<RegistrationRestCrmModel>();
			
			String values = "SET @p_editId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			try {
				logger.info("values===" + values);
				
				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines")
						.setParameter("actionType", "getClientEditForParent").setParameter("actionValue", values)
						.getResultList();
				for (Object[] m : x) {
logger.info(Arrays.toString(m));
					String profileImg = null;
					if (m[21] != null || m[21] != "" || m[21] != " ") {
						logger.info("prooooooooofile imge" + m[21]);
						profileImg = env.getMobileView() + "document/crm/" + m[21];
					} else {
						logger.info("noprofile" + resp);
						profileImg = "";
					}

					registrationRestCrmModel = new RegistrationRestCrmModel(m[0], m[1], m[2], m[3], m[4], m[5],
							m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
							m[20], profileImg);
				}
				
				try {
					String value = "set @p_editId ='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
					logger.info("value===" + value);
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("crm_Client_Routines")
							.setParameter("actionType", "getClientEditForchild").setParameter("actionValue", value)
							.getResultList();

					for (Object[] m : x1) {
						RestDirecterManagerCrmModel item = new RestDirecterManagerCrmModel(m[0].toString(),
								m[1], m[2], m[3], m[4], m[5], m[6], m[7], null, m[8]);
						itemList.add(item);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				registrationRestCrmModel.setDmList(itemList);
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
			resp.setBody(registrationRestCrmModel);
			logger.info("=====>>>resp" + resp);
			logger.info("resp=====" + resp);
			logger.info("Method in Dao: getClientDetailsEditWeb Dao ends");
			return resp;
		}
}
