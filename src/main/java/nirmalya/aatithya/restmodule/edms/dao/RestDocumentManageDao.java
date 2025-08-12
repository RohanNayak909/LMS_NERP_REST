package nirmalya.aatithya.restmodule.edms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import nirmalya.aatithya.restmodule.edms.model.RestDocumentManageAccessModel;
import nirmalya.aatithya.restmodule.edms.model.RestDocumentManageModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.edms.GenerateWorkSpaceParam;

@Repository
public class RestDocumentManageDao {

	Logger logger = LoggerFactory.getLogger(RestDocumentManageDao.class);
	@Autowired
	private EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JsonResponse getEmployeeListDao(String organization, String orgDivision, String userId) {
		logger.info("Method : getEmployeeListDao starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
		logger.info("values-->" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "viewUserEmpList").setParameter("actionValue", value).getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("viewHrmsEmpPersonalDetails: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getEmployeeListDao ends" + resp);
		logger.info("Method : getEmployeeListDao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDMSEmpList(String orgName, String orgDivision, String userId) {
		logger.info("Method : getDMSEmpList starts");

		List<DropDownModel> emplist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "getEmployeeLists").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				emplist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDMSEmpList ends" + emplist);
		return emplist;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse<Object> adduserGroup(RestDocumentManageModel managemodel) {
		logger.info("Method : adduserGroup starts");
		JsonResponse resp = new JsonResponse();

		String values = GenerateWorkSpaceParam.getManageUserGroupParam(managemodel);

		try {
			System.out.println("groupid:" + managemodel.getGroupId());
			if (managemodel.getGroupId() == "" || managemodel.getGroupId() == null) {
				System.out.println("@@@@@@@@@@@@@@@@@valueee" + values);

				em.createNamedStoredProcedureQuery("documentManageRoutines").setParameter("actionType", "addUserGroup")
						.setParameter("actionValue", values).execute();
				resp.setCode("200");
				resp.setMessage("Data Added Successfully");

			} else {
				System.out.println("@@@@@@@@@@@@@@@@@" + values);
				em.createNamedStoredProcedureQuery("documentManageRoutines")
						.setParameter("actionType", "modifyUserGroup").setParameter("actionValue", values).execute();
				resp.setCode("200");
				resp.setMessage("Data Modified Successfully");
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

		logger.info("Method : adduserGroup starts");
		return resp;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getUserGroupListDao(String organization, String orgDivision) {
		logger.info("Method : getUserGroupListDao starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("documentManageRoutines")
					.setParameter("actionType", "getUserGroup").setParameter("actionValue", value).getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("viewHrmsEmpPersonalDetails: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getUserGroupListDao ends");
		return resp;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JsonResponse editUserGroupDao(String id, String organization, String orgDivision) {
		logger.info("Method : editUserGroupDao starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_id='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("documentManageRoutines")
					.setParameter("actionType", "editUserGroup").setParameter("actionValue", value).getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("editUserGroupDao: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : editUserGroupDao ends");
		return resp;
	}

	/*************** get Access Document listing *********/

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getAccessDocumentListingDao(String id, String organization, String orgDivision) {
		logger.info("Method : getAccessDocumentListingDao starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_id='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("documentManageRoutines")
					.setParameter("actionType", "viewAccessDocumentList").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getAccessDocumentListingDao: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getAccessDocumentListingDao ends");
		return resp;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getAccessDocumentListingByType(String doctype, String date, String organization,
			String orgDivision) {
		logger.info("Method : getAccessDocumentListingByType starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_doctype = '" + doctype + "',@p_date='" + date + "', @p_org='" + organization
				+ "',@p_orgDiv='" + orgDivision + "';";

		System.out.println("@@@@@@@@@@@@@" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("documentManageRoutines")
					.setParameter("actionType", "viewAccessDocumentListByDocType").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getAccessDocumentListingByType: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getAccessDocumentListingByType ends");
		return resp;
	}

	public JsonResponse<Object> saveUserAccessDao(List<RestDocumentManageAccessModel> restAccessModel) {
		logger.info("Method : saveUserAccessDao starts" + restAccessModel);

		JsonResponse resp = new JsonResponse();

		String values = "";
		Gson gson = new Gson();
		String jsonString = gson.toJson(restAccessModel.get(0));
		System.out.println("jsonString===" + jsonString);
		try {
			values = GenerateWorkSpaceParam.getManageUserAccess(restAccessModel);
			if (restAccessModel.get(0).getAccessId() == "" || restAccessModel.get(0).getAccessId() == null) {

				if (restAccessModel.get(0).getGroupId() == "" || restAccessModel.get(0).getGroupId() == null) {
					System.out.println("USER");
					em.createNamedStoredProcedureQuery("documentManageRoutines")
							.setParameter("actionType", "addUserAccess").setParameter("actionValue", values).execute();
				} else {
					System.out.println("valueforgroup@@@@@@@@@@@@@@@@@" + jsonString);
					em.createNamedStoredProcedureQuery("documentManageRoutines")
							.setParameter("actionType", "addUserGroupAccess").setParameter("actionValue", jsonString)
							.execute();
				}
			} else {
				System.out.println("Modify USER ACCESS");
				// String modifyValues =
				// GenerateWorkSpaceParam.modifyManageUserAccess(restAccessModel);
				em.createNamedStoredProcedureQuery("documentManageRoutines")
						.setParameter("actionType", "modifyUserAccess").setParameter("actionValue", values).execute();
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

		logger.info("Method : saveUserAccessDao ends");
		return resp;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getAccessListDao(String organization, String orgDivision) {
		logger.info("Method : getAccessListDao starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("documentManageRoutines")
					.setParameter("actionType", "viewAccessList").setParameter("actionValue", value).getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getAccessDocumentListingDao: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getAccessListDao ends");
		return resp;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getDocumentAccessedListingDao(String id, String accessid, String organization,
			String orgDivision) {
		logger.info("Method : getDocumentAccessedListingDao starts");
		JsonResponse resp = new JsonResponse();
		System.out.println("@@@@@@@@@@@@" + id);
		String value = "SET @p_id='" + id + "',@p_accessid='" + accessid + "',@p_org='" + organization + "',@p_orgDiv='"
				+ orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("documentManageRoutines")
					.setParameter("actionType", "viewAccessListByUser").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getDocumentAccessedListingDao: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getDocumentAccessedListingDao ends");
		return resp;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse viewUserDocumentListDao(String userid, String organization, String orgDivision) {
		logger.info("Method : viewUserDocumentListDao starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_id='" + userid + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("documentManageRoutines")
					.setParameter("actionType", "viewUserDocumentList").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("viewUserDocumentListDao: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewUserDocumentListDao ends");
		return resp;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse viewAuditLogListDao(String organization, String orgDivision) {
		logger.info("Method : viewAuditLogListDao starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("documentManageRoutines")
					.setParameter("actionType", "viewAuditList").setParameter("actionValue", value).getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("viewAuditLogListDao: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewAuditLogListDao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveUserAccessManage(List<RestDocumentManageAccessModel> restAccessModel) {
		logger.info("Method : saveUserAccessDao starts" + restAccessModel);

		JsonResponse resp = new JsonResponse();

		String values = "";
		Gson gson = new Gson();
		String jsonString = gson.toJson(restAccessModel);
		System.out.println("jsonString===" + jsonString);
		try {
			if (restAccessModel.get(0).getAccessId() == "" || restAccessModel.get(0).getAccessId() == null) {

				if (restAccessModel.get(0).getGroupId() == "" || restAccessModel.get(0).getGroupId() == null) {
					System.out.println("USER");
					em.createNamedStoredProcedureQuery("documentManageRoutines")
							.setParameter("actionType", "userManageAccess").setParameter("actionValue", jsonString)
							.execute();
				} else {
					System.out.println("valueforgroup@@@@@@@@@@@@@@@@@" + jsonString);
					em.createNamedStoredProcedureQuery("documentManageRoutines")
							.setParameter("actionType", "userManageAccess").setParameter("actionValue", jsonString)
							.execute();
				}
			} else {
				System.out.println("Modify USER ACCESS");
				String modifyValues = GenerateWorkSpaceParam.modifyManageUserAccess(restAccessModel);
				em.createNamedStoredProcedureQuery("documentManageRoutines")
						.setParameter("actionType", "modifyUserAccess").setParameter("actionValue", modifyValues)
						.execute();
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

		logger.info("Method : saveUserAccessManage ends");
		return resp;
	}

	/*************** get Access Document Workflow *********/

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse accessWorkflow(String id, String organization, String orgDivision) {
		logger.info("Method : getAccessDocumentListingDao starts" + id);
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_id='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
		System.out.println("value####################" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("documentManageRoutines")
					.setParameter("actionType", "viewWorkflowDocument").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getAccessDocumentListingDao: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : accessWorkflow ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> documentworkFlowView(String userId, String organization, String orgDivision,
			String docId) {
		logger.info("Method : documentworkFlowView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @userId='" + userId + "',@organization='" + organization + "',@orgDivision='"
					+ orgDivision + "',@p_docId='" + docId + "';";
			System.out.println("values=>" + value);
			Object x = em.createNamedStoredProcedureQuery("documentManageRoutines")
					.setParameter("actionType", "getViewworkFlow").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully.");
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
		logger.info("Method : documentworkFlowView Dao ends" + resp);
		return resp;
	}
}
