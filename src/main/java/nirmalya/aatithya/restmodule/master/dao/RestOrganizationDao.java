package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateOrganizationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestOrganizationMasterModel;

@Repository
public class RestOrganizationDao {

	Logger logger = LoggerFactory.getLogger(ProductCategoryDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

/* Function for getOrganizationName */
	@SuppressWarnings("unchecked")
	public  DropDownModel  getOrganizationName() {
		logger.info("Method : getOrganizationName starts");
		
			DropDownModel  orgName = new  DropDownModel();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationCategoryRoutines")
					.setParameter("actionType", "getOrganizationName").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				orgName=dropDownModel;
			}
			
		} catch (Exception e) {

			logger.error("getOrganizationName: "+e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getOrganizationName ends");
		return orgName;
	}
	
	
	// employee list
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeLists() {
		logger.info("Method : getEmployeeLists starts");

		List<DropDownModel> emplist = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationCategoryRoutines")
					.setParameter("actionType", "getEmployeeLists").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				emplist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeLists ends");
		return emplist;
	}
	
	/* Function for save OrganizationCategory */	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestOrganizationMasterModel>> saveOrganizationCategory(
			RestOrganizationMasterModel organization) {
		logger.info("Method : saveOrganizationCategory starts");

		Boolean validity = true;
		JsonResponse<RestOrganizationMasterModel> resp = new JsonResponse<RestOrganizationMasterModel>();
		resp.setMessage("");
		resp.setCode("");
		List<RestOrganizationMasterModel> newLoc = new ArrayList<RestOrganizationMasterModel>();

		if (organization.getOrganizationalName() == null || organization.getOrganizationalName() == "") {
			resp.setMessage("Name Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateOrganizationParameter.saveOrganizationCategory(organization);
				if (organization.getOrganizationalId() != null && organization.getOrganizationalId() != "") {

					List<Object[]> x = em.createNamedStoredProcedureQuery("organizationCategoryRoutines")
							.setParameter("actionType", "modifyOrganization").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						RestOrganizationMasterModel item = new RestOrganizationMasterModel(m[0], m[1], m[2], m[3], m[4],
								m[5], m[6], m[7],null);
						newLoc.add(item);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("organizationCategoryRoutines")
							.setParameter("actionType", "addOrganization").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						RestOrganizationMasterModel item = new RestOrganizationMasterModel(m[0], m[1], m[2], m[3], m[4],
								m[5], m[6], m[7],null);
						newLoc.add(item);
					}

				}

				resp.setBody(newLoc.get(0));
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

		ResponseEntity<JsonResponse<RestOrganizationMasterModel>> response = new ResponseEntity<JsonResponse<RestOrganizationMasterModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveOrganizationCategory ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestOrganizationMasterModel>> saveOrganizationSubCategory(
			RestOrganizationMasterModel organization) {
		logger.info("Method : saveOrganizationSubCategory starts");

		Boolean validity = true;
		JsonResponse<RestOrganizationMasterModel> resp = new JsonResponse<RestOrganizationMasterModel>();
		resp.setMessage("");
		resp.setCode("");

		List<RestOrganizationMasterModel> newLoc = new ArrayList<RestOrganizationMasterModel>();

		if (organization.getOrganizationalName() == null || organization.getOrganizationalName() == "") {
			resp.setMessage("Name Required");
			validity = false;
		} /*
			 * else if (organization.getAssignEmployee() == null ||
			 * organization.getAssignEmployee() == "") {
			 * resp.setMessage("Organization Description Required"); validity = false; }
			 */

		if (validity)
			try {
				String values = GenerateOrganizationParameter.saveOrganizationCategory(organization);

				if (organization.getOrganizationalId() != null && organization.getOrganizationalId() != "") {

					List<Object[]> x = em.createNamedStoredProcedureQuery("organizationCategoryRoutines")
							.setParameter("actionType", "modifyOrganization").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						RestOrganizationMasterModel item = new RestOrganizationMasterModel(m[0], m[1], m[2], m[3], m[4],
								m[5], m[6], null, null);
						newLoc.add(item);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("organizationCategoryRoutines")
							.setParameter("actionType", "addSubOrganization").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						RestOrganizationMasterModel item = new RestOrganizationMasterModel(m[0], m[1], m[2], m[3], m[4],
								m[5], m[6], null, null);
						newLoc.add(item);
					}

				}

				resp.setBody(newLoc.get(0));
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

		ResponseEntity<JsonResponse<RestOrganizationMasterModel>> response = new ResponseEntity<JsonResponse<RestOrganizationMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveOrganizationSubCategory ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestOrganizationMasterModel>>> getAllOrganizationCategoryList(String orgName,String orgDivision) {
		logger.info("Method : getAllOrganizationCategoryList starts");

		JsonResponse<List<RestOrganizationMasterModel>> resp = new JsonResponse<List<RestOrganizationMasterModel>>();
		List<RestOrganizationMasterModel> newLoc = new ArrayList<RestOrganizationMasterModel>();

		try {
			String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\";";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationCategoryRoutines")
					.setParameter("actionType", "getOrgCategoryList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestOrganizationMasterModel item = new RestOrganizationMasterModel(m[0], m[1], null, null, m[2], null,
						m[3], m[4], m[5]);
				newLoc.add(item);
			}

			resp.setBody(newLoc);
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

		ResponseEntity<JsonResponse<List<RestOrganizationMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestOrganizationMasterModel>>>(
				resp, HttpStatus.CREATED);

		
		logger.info("Method : getAllOrganizationCategoryList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestOrganizationMasterModel>>> getOrganizationCategoryListById(String id) {
		logger.info("Method : getOrganizationCategoryListById starts");

		JsonResponse<List<RestOrganizationMasterModel>> resp = new JsonResponse<List<RestOrganizationMasterModel>>();
		List<RestOrganizationMasterModel> newLoc = new ArrayList<RestOrganizationMasterModel>();

		try {
			String value = "SET @P_ParentID='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationCategoryRoutines")
					.setParameter("actionType", "getOrgCategoryListById").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestOrganizationMasterModel item = new RestOrganizationMasterModel(m[0], m[1], null, null, m[2], null,
						m[3], m[4], m[5]);
				newLoc.add(item);
			}

			resp.setBody(newLoc);
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

		ResponseEntity<JsonResponse<List<RestOrganizationMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestOrganizationMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getOrganizationCategoryListById ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestOrganizationMasterModel>> getOrganizationCategoryById(String id) {
		logger.info("Method : getOrganizationCategoryById starts");

		JsonResponse<RestOrganizationMasterModel> resp = new JsonResponse<RestOrganizationMasterModel>();
		List<RestOrganizationMasterModel> newLoc = new ArrayList<RestOrganizationMasterModel>();

		try {
			String value = "SET @p_organizationId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("organizationCategoryRoutines")
					.setParameter("actionType", "getOrgCategoryById").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestOrganizationMasterModel item = new RestOrganizationMasterModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], null);
				newLoc.add(item);
			}

			resp.setBody(newLoc.get(0));
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

		ResponseEntity<JsonResponse<RestOrganizationMasterModel>> response = new ResponseEntity<JsonResponse<RestOrganizationMasterModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getOrganizationCategoryById ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteOrganization(String id, String createdBy) {
		logger.info("Method : deleteOrganization starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_PCat='" + id + "', @P_ModifiedBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("organizationCategoryRoutines")
					.setParameter("actionType", "deleteOrganization").setParameter("actionValue", value).execute();
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
		logger.info("Method : deleteOrganization ends");
		return response;
	}
}
