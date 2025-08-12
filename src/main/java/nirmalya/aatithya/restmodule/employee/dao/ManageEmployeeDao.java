package nirmalya.aatithya.restmodule.employee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateProfileUploadParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateemployeemasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ManageEmployeeEducationRestModel;
import nirmalya.aatithya.restmodule.employee.model.EmployeeProfileFileUploadModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeAddressRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeBankDetailsRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeBenifitrestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeDependentRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeDocumentRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeInsuranceDetailsrestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeWorkdetailsRestModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestSalaryRevisionModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class ManageEmployeeDao {

	Logger logger = LoggerFactory.getLogger(ManageEmployeeDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@Autowired
	PasswordEncoder passEncoder;

	@Autowired
	EnvironmentVaribles env;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");

		List<DropDownModel> CountryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getCountryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				CountryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryList ends");
		return CountryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getstateList1() {
		logger.info("Method : getstateList1 starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getstateList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getstateList1 ends");
		return stateList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getcityList1() {
		logger.info("Method : getcityList1 starts");

		List<DropDownModel> cityList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getcityList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				cityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getcityList1 ends");
		return cityList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getgenderList1() {
		logger.info("Method : genderTypeList starts");

		List<DropDownModel> genderTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getgenderList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				genderTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return genderTypeList;
	}
	
	//getOrganization
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrganization(String orgName) {
		logger.info("Method : getOrganization starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			System.out.println("organisation===============?"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines")
					.setParameter("actionType", "getOrganization").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOrganization ends");
		return getCollectionList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDivision(String orgName) {
		logger.info("Method : getDivision starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			System.out.println("orgDivision===============?"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines")
					.setParameter("actionType", "orgDivision").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : orgDivision ends");
		return getCollectionList;
	}

	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentListDash(String orgName, String orgDivision) {
		logger.info("Method : getDepartmentListDash starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			//String value = "SET @p_orgName='" + orgName + "';";
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("getDepartmentListDash===============?"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines")
					.setParameter("actionType", "deptDashList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentListDash ends");
		return getCollectionList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getJobRoleList(String orgName, String orgDivision) {
		logger.info("Method : getJobRoleList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("getJobRoleList===============?"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines")
					.setParameter("actionType", "jobRoleDashList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getJobRoleList ends");
		return getCollectionList;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRecuiterList(String orgName, String orgDivision) {
		logger.info("Method : getRecuiterList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("getRecuiterList===============?"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines")
					.setParameter("actionType", "recuitDashList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRecuiterList ends");
		return getCollectionList;
	}
	


	@SuppressWarnings("unchecked")
	public List<DropDownModel> getnationalityList1() {
		logger.info("Method : getnationalityList1 starts");

		List<DropDownModel> nationalityList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "nationalityList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nationalityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForemployee ends");
		return nationalityList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getaddressList1() {
		logger.info("Method : getaddressList1 starts");

		List<DropDownModel> getaddressList1 = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getaddressList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getaddressList1.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getaddressList1 ends");
		return getaddressList1;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getemploymentType1(String organization, String orgDivision) {
		logger.info("Method : getemploymentType1 starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "employmentList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getemploymentType1 ends");
		return employmentList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getbloodgroupList1() {
		logger.info("Method : getbloodgroupList1 starts");

		List<DropDownModel> bloodgroupList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getbloodgroupList1").setParameter("actionValue", "").getResultList();
			System.out.println("Blodd Group In daooo=====>" + x);
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bloodgroupList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getbloodgroupList1 ends");
		return bloodgroupList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBandList() {
		logger.info("Method : getBandList starts");

		List<DropDownModel> getBandList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getBandList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getBandList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBandList ends");
		return getBandList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getmaritalstatusList1() {
		logger.info("Method : getmaritalstatusList1 starts");

		List<DropDownModel> maritalstatusList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "maritalstatusList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				maritalstatusList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getmaritalstatusList1 ends");
		return maritalstatusList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getdocumenttypeList1() {
		logger.info("Method : getdocumenttypeList1 starts");

		List<DropDownModel> documenttypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "documentTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				documenttypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : get document type List1 ends" + documenttypeList);
		return documenttypeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDesignations(String organization, String orgDivision) {
		logger.info("Method : getDesignations starts");

		List<DropDownModel> documenttypeList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getDesignations").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				documenttypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDesignations ends");
		return documenttypeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getJobType1(String organization, String orgDivision) {
		logger.info("Method : getJobType1 starts");

		List<DropDownModel> jobtypeList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "jobtypeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobtypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getJobType1 ends");
		return jobtypeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList1(String organization, String orgDivision) {
		logger.info("Method : getDepartmentList1 starts");

		List<DropDownModel> DepartmentList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "DepartmentList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				DepartmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentList1 ends");
		return DepartmentList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTimesheetType1(String organization, String orgDivision) {
		logger.info("Method : getTimesheetType1 starts");

		List<DropDownModel> TimesheetList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "TimesheetList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				TimesheetList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTimesheetType1 ends");
		return TimesheetList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getemploymentstatusList1() {
		logger.info("Method : getemploymentstatusList1 starts");

		List<DropDownModel> employmentstatusList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getemploymentstatusList1").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentstatusList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getemploymentstatusList1 ends");
		return employmentstatusList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getJobType2() {
		logger.info("Method : getJobType2 starts");

		List<DropDownModel> jobtypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "jobtypeList2").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobtypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : jobtypeList2 ends");
		return jobtypeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBenefits(String organization, String orgDivision) {
		logger.info("Method : getBenefits starts");

		List<DropDownModel> benefitsList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "benefitsList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				benefitsList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBenefits ends");
		return benefitsList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBenefitsApi(String organization, String orgDivision) {
		logger.info("Method : getBenefitsApi starts");

		List<DropDownModel> benefitsList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "benefitsList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				benefitsList.add(dropDownModel);
			}
			if (benefitsList.size() > 0) {
				Util.setJsonResponse(resp, benefitsList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, benefitsList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getBenefitsApi ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBankNameList() {
		logger.info("Method : getBankNameList starts");

		List<DropDownModel> getBankNameList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getBankNameList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getBankNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : benefitsList ends");
		return getBankNameList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> dependentTypeList() {
		logger.info("Method : dependentTypeList starts");

		List<DropDownModel> getDependentTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "dependentTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getDependentTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : dependentTypeList ends");
		return getDependentTypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> dependentTypeListApi() {
		logger.info("Method : dependentTypeListApi starts");

		List<DropDownModel> dependentList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "dependentTypeList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dependentList.add(dropDownModel);
			}
			if (dependentList.size() > 0) {
				Util.setJsonResponse(resp, dependentList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, dependentList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : dependentTypeListApi ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> relationshipList() {
		logger.info("Method : relationshipList starts");

		List<DropDownModel> getRelationshipList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "relationshipList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRelationshipList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : relationshipList ends");
		return getRelationshipList;
	}

	public ResponseEntity<JsonResponse<ManageEmployeeDependentRestModel>> saveemployeedependent(
			ManageEmployeeDependentRestModel manageEmployeeDependentRestModel) {
		logger.info("Method : saveemployeedependent starts");
		JsonResponse<ManageEmployeeDependentRestModel> resp = new JsonResponse<ManageEmployeeDependentRestModel>();

		try {
			String values = GenerateemployeemasterParameter.saveemployeedependent(manageEmployeeDependentRestModel);
			if (manageEmployeeDependentRestModel.getDependentId() != null
					&& manageEmployeeDependentRestModel.getDependentId() != "") {

				em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "modifydeptnt")
						.setParameter("actionValue", values).execute();
				resp.setCode("success");
				resp.setMessage("Data modified successfully");

			} else {

				em.createNamedStoredProcedureQuery("employeeMasterRoutines")
						.setParameter("actionType", "saveemployeedependent").setParameter("actionValue", values)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data added successfully");

			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
				logger.info("err" + err);

			} catch (Exception e1) {
				e1.printStackTrace();
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<ManageEmployeeDependentRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeDependentRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveemployeedependent ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> EmployeeList(String organization, String orgDivision) {
		logger.info("Method : EmployeeList starts");
		List<DropDownModel> getBankNameList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "EmployeeList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getBankNameList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : EmployeeList ends");
		return getBankNameList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> OfferletterList() {
		logger.info("Method : OfferletterList starts");
		List<DropDownModel> OfferletterList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "OfferletterLists").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				OfferletterList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : OfferletterList ends");
		return OfferletterList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> insuranceCompanyList(String organization, String orgDivision) {
		logger.info("Method : insuranceCompanyList starts");

		List<DropDownModel> insuranceCompanyList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "insuranceCompanyList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				insuranceCompanyList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : insuranceCompanyList ends");
		return insuranceCompanyList;
	}

	// API INSURANCE COMPANY LIST
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> insuranceCompanyListApiDao() {
		logger.info("Method : insuranceCompanyListApiDao starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "insuranceCompanyList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}
			if (countryList.size() > 0) {
				Util.setJsonResponse(resp, countryList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, countryList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : insuranceCompanyListApiDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getManager(String id, String organization,
			String orgDivision) {

		logger.info("Method : getManager starts");

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> model = new ArrayList<DropDownModel>();

		String values = "SET @p_empId='" + id + "',@P_organization='" + organization + "',@P_orgDivision='"
				+ orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getManager").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {

				DropDownModel item = new DropDownModel(m[0], m[1]);
				model.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(model);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getManager ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubdepartmentList(String id, String organization,
			String orgDivision) {

		logger.info("Method : getSubdepartmentList starts");

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> model = new ArrayList<DropDownModel>();

		String values = "SET @p_departmentId='" + id + "',@p_organization='" + organization + "',@p_orgDivision='"
				+ orgDivision + "';";
		logger.info("values===" + values);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getSubdepartmentList").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel item = new DropDownModel(m[0], m[1]);
				model.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(model);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response===" + response);
		logger.info("Method : getSubdepartmentList ends");
		return response;
	}

	// save Employee
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageEmployeeRestModel>> saveemployeeMaster(ManageEmployeeRestModel employee) {
		logger.info("Method : saveemployeeMaster starts");
		JsonResponse<ManageEmployeeRestModel> resp = new JsonResponse<ManageEmployeeRestModel>();
		try {
			String values = GenerateemployeemasterParameter.getAddempParam(employee);

			if (employee.getEmployeeId() != null && employee.getEmployeeId() != "") {
				List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
						.setParameter("actionType", "modifyemp").setParameter("actionValue", values).getResultList();

				System.err.println("valuesss ====" + values);

				for (Object[] m : x) {
					String profileImg = null;
					if (m[1] != null && m[1] != "" && m[1] != " " && !m[1].toString().equals(" ")
							&& !m[1].toString().equals(null) && !m[1].toString().equals("")) {
						profileImg = env.getMobileView() + "document/employee/" + m[1].toString();
					} else {
						profileImg = "";
					}
					/*
					 * Object dob = null; if (m[5] != null) { dob =
					 * DateFormatter.returnStringDate(m[5]); }
					 */
					ManageEmployeeRestModel empdata = new ManageEmployeeRestModel(m[0], profileImg, m[2], m[3], m[4],
							m[5], m[6], m[7], null);
					Util.setJsonResponse(resp, empdata, ResponseStatus.success, "Information updated successfully.");
					logger.info("modify return" + empdata);
				}
			} else {

				List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
						.setParameter("actionType", "addemp").setParameter("actionValue", values).getResultList();
				for (Object[] m : x) {

					Object profileImg = null;
					if (m[1] != null && m[1] != "" && m[1] != " " && !m[1].toString().equals(" ")
							&& !m[1].toString().equals(null) && !m[1].toString().equals("")) {
						profileImg = env.getMobileView() + "document/employee/" + m[1].toString();
					} else {
						profileImg = "";
					}
					Object dob = null;
					if (m[5] != null) {
						dob = DateFormatter.returnStringDate(m[5]);
					}
					ManageEmployeeRestModel empdata = new ManageEmployeeRestModel(m[0], profileImg, m[2], m[3], m[4],
							dob, m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], null, null, null, null,
							null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
							null, null, null,null);
					Util.setJsonResponse(resp, empdata, ResponseStatus.success, "Information saved successfully.");
				}
			}

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
		ResponseEntity<JsonResponse<ManageEmployeeRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveEmpMaster ends");
		return response;
	}

	// save New Employee
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageEmployeeRestModel>> saveNewEmployeeMaster(
			ManageEmployeeRestModel employee) {
		logger.info("Method : saveNewEmployeeMaster starts");
		JsonResponse<ManageEmployeeRestModel> resp = new JsonResponse<ManageEmployeeRestModel>();

		try {
			String values = GenerateemployeemasterParameter.getAddempParam(employee);
			System.out.println("values====" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "saveNewEmployeeMaster").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object profileImg = null;
				if (m[1] != null && m[1] != "" && m[1] != " " && !m[1].toString().equals(" ")
						&& !m[1].toString().equals(null) && !m[1].toString().equals("")) {
					profileImg = env.getMobileView() + "document/employee/" + m[1].toString();
				} else {
					profileImg = "";
				}

				ManageEmployeeRestModel empdata = new ManageEmployeeRestModel(m[0], profileImg, m[2], m[3], m[4], m[5],
						m[6], null, null);

				Util.setJsonResponse(resp, empdata, ResponseStatus.success, "Information saved scuccessfully.");
			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.error("Error " + err[1]);
				if (err[0].equals("1062")) {
					resp.setMessage("Duplicate Employee Id Entry");
				} else {
					resp.setMessage(e.getLocalizedMessage());
				}
				resp.setCode("Failed");
				logger.error("saveNewEmployeeMaster: " + e.getMessage());
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			logger.error("saveNewEmployeeMaster: " + e.getMessage());
		}
		ResponseEntity<JsonResponse<ManageEmployeeRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveNewEmployeeMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeRestModel>>> viewemppersonal() {
		logger.info("Method : viewemppersonal starts");

		List<ManageEmployeeRestModel> viewemppersonal = new ArrayList<ManageEmployeeRestModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "viewemppersonal").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				ManageEmployeeRestModel vendorLocation = new ManageEmployeeRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,null);
				viewemppersonal.add(vendorLocation);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ManageEmployeeRestModel>> resp = new JsonResponse<List<ManageEmployeeRestModel>>();
		resp.setBody(viewemppersonal);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewemppersonal ends");
		return response;
	}

	public ResponseEntity<JsonResponse<ManageEmployeeAddressRestModel>> saveemployeeaddress(
			ManageEmployeeAddressRestModel manageEmployeeAddressRestModel) {
		logger.info("Method : saveemployeeaddress starts");

		JsonResponse<ManageEmployeeAddressRestModel> resp = new JsonResponse<ManageEmployeeAddressRestModel>();
		try {
			String values = GenerateemployeemasterParameter.saveempadd(manageEmployeeAddressRestModel);
			logger.info("values" + values);
			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "addempaddress")
					.setParameter("actionValue", values).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
			resp.setCode("Success");
			resp.setMessage("Address Details Saved Successfully");

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		ResponseEntity<JsonResponse<ManageEmployeeAddressRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeAddressRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveVendorLocationMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeAddressRestModel>>> viewEmployeeadd(String id,
			String organization, String orgDivision) {
		logger.info("Method : viewEmployeeadd starts");

		List<ManageEmployeeAddressRestModel> viewEmployeeadd = new ArrayList<ManageEmployeeAddressRestModel>();
		JsonResponse<List<ManageEmployeeAddressRestModel>> resp = new JsonResponse<List<ManageEmployeeAddressRestModel>>();
		try {

			String value = "SET @p_empId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "viewEmployeeadd").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ManageEmployeeAddressRestModel empLocation = new ManageEmployeeAddressRestModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], null, null);
				viewEmployeeadd.add(empLocation);
			}
			if (viewEmployeeadd.size() > 0) {
				Util.setJsonResponse(resp, viewEmployeeadd, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, viewEmployeeadd, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		resp.setBody(viewEmployeeadd);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeAddressRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeAddressRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewEmployeeadd ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteAddress(String id, String organization, String orgDivision) {
		logger.info("Method : deleteAddress starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='(" + id + ")',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "deleteAddress")
					.setParameter("actionValue", values).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
		} catch

		(Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteAddress ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageEmployeeWorkdetailsRestModel>> saveemployeeworkdetails(
			ManageEmployeeWorkdetailsRestModel manageEmployeeWorkdetailsRestModel) {
		logger.info("Method : saveemployeeworkdetails modify master data starts");
		JsonResponse<ManageEmployeeWorkdetailsRestModel> resp = new JsonResponse<ManageEmployeeWorkdetailsRestModel>();

		try {
			String values = GenerateemployeemasterParameter.saveempworkdetails(manageEmployeeWorkdetailsRestModel);
			logger.info("manageEmployeeWorkdetailsRestModel.getEmployeeworkId()"
					+ manageEmployeeWorkdetailsRestModel.getEmployeeworkId());
			if (manageEmployeeWorkdetailsRestModel.getEmployeeworkId() != null
					&& manageEmployeeWorkdetailsRestModel.getEmployeeworkId() != "") {
				List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
						.setParameter("actionType", "modifyempworkdetails").setParameter("actionValue", values)
						.getResultList();
				resp.setCode("Success");
				resp.setMessage("Workdetails Modified Successfully");
				for (Object[] m : x) {
					ManageEmployeeWorkdetailsRestModel empdata = new ManageEmployeeWorkdetailsRestModel(m[0], m[1],
							m[2], m[3], m[4], null);
					logger.info("empdata" + empdata);
					/*
					 * Util.setJsonResponse(resp, empdata, ResponseStatus.success,
					 * ApiResponseMessage.UPDATED_SUCCESSFULLY);
					 */
					resp.setBody(empdata);
					resp.setCode("Success");
					resp.setMessage("Work details updated successfully");
				}

			} else {

				List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
						.setParameter("actionType", "addempworkdetails").setParameter("actionValue", values)
						.getResultList();
				resp.setCode("Success");
				resp.setMessage("Workdetails Added Successfully");
				for (Object[] m : x) {
					ManageEmployeeWorkdetailsRestModel empdata = new ManageEmployeeWorkdetailsRestModel(m[0], m[1],
							m[2], m[3], m[4], null);
					logger.info("empdata" + empdata);
					/*
					 * Util.setJsonResponse(resp, empdata, ResponseStatus.success,
					 * ApiResponseMessage.SAVED_SUCCESSFULLY);
					 */
					resp.setBody(empdata);
					resp.setCode("Success");
					resp.setMessage("Work details saved successfully");
				}

			}

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<ManageEmployeeWorkdetailsRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeWorkdetailsRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveemployeeworkdetails modify master data ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeWorkdetailsRestModel>>> viewEmployeework(String id,
			String organization, String orgDivision) {
		logger.info("Method : viewEmployeework starts");

		List<ManageEmployeeWorkdetailsRestModel> viewEmployeework = new ArrayList<ManageEmployeeWorkdetailsRestModel>();
		JsonResponse<List<ManageEmployeeWorkdetailsRestModel>> resp = new JsonResponse<List<ManageEmployeeWorkdetailsRestModel>>();
		try {

			String value = "SET @p_empId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "viewEmployework").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ManageEmployeeWorkdetailsRestModel viewEmployee = new ManageEmployeeWorkdetailsRestModel(m[0], m[1],
						m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
						m[17], m[18], m[23], m[19], m[20], m[21], m[22], m[24]);
				viewEmployeework.add(viewEmployee);
			}
			if (viewEmployeework.size() > 0) {
				Util.setJsonResponse(resp, viewEmployeework, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, viewEmployeework, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		resp.setBody(viewEmployeework);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeWorkdetailsRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeWorkdetailsRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : get viewEmployeework ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeDependentRestModel>>> viewempdepent(String id,
			String organization, String orgDivision) {
		logger.info("Method : viewempdepent starts");

		List<ManageEmployeeDependentRestModel> viewempdepent = new ArrayList<ManageEmployeeDependentRestModel>();
		JsonResponse<List<ManageEmployeeDependentRestModel>> resp = new JsonResponse<List<ManageEmployeeDependentRestModel>>();

		try {

			String value = "SET @p_empId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "viewempdepent").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object ddob = null;
				if (m[6] != null) {
					ddob = DateFormatter.returnStringDate(m[6]);
				}
				ManageEmployeeDependentRestModel viewEmployeesss = new ManageEmployeeDependentRestModel(m[0], m[1],
						m[2], m[3], m[4], m[5], ddob, m[7], m[8], m[9], m[10], null);
				viewempdepent.add(viewEmployeesss);
			}

			if (viewempdepent.size() > 0) {
				Util.setJsonResponse(resp, viewempdepent, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, viewempdepent, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		resp.setBody(viewempdepent);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeDependentRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeDependentRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getworkkkk ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deletedependent(String id, String organization, String orgDivision) {
		logger.info("Method : deletedependent starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "deletedependent")
					.setParameter("actionValue", values).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
		} catch

		(Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deletedependent ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deletebank(String id) {
		logger.info("Method : deletebank starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='(" + id + ")'";
			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "deletebank")
					.setParameter("actionValue", values).execute();

		} catch

		(Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deletebank ends");
		return response;
	}

	public ResponseEntity<JsonResponse<ManageEmployeeBankDetailsRestModel>> saveemployeebank(
			ManageEmployeeBankDetailsRestModel manageEmployeeBankDetailsRestModel) {
		logger.info("Method : saveemployeebank starts");

		JsonResponse<ManageEmployeeBankDetailsRestModel> resp = new JsonResponse<ManageEmployeeBankDetailsRestModel>();

		try {
			String values = GenerateemployeemasterParameter.saveemployeebankdetails(manageEmployeeBankDetailsRestModel);
			if (manageEmployeeBankDetailsRestModel.getEbankId() != null
					&& manageEmployeeBankDetailsRestModel.getEbankId() != "") {

				em.createNamedStoredProcedureQuery("employeeMasterRoutines")
						.setParameter("actionType", "modifybankdetails").setParameter("actionValue", values).execute();
				resp.setCode("Success");
				resp.setMessage("Bank Details Updated Successfully");
			} else {
				em.createNamedStoredProcedureQuery("employeeMasterRoutines")
						.setParameter("actionType", "saveemployeebankdetails").setParameter("actionValue", values)
						.execute();
				resp.setCode("Success");
				resp.setMessage("Bank Details Saved Successfully");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<ManageEmployeeBankDetailsRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeBankDetailsRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveemployeebank ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeBankDetailsRestModel>>> viewebank(String id,
			String organization, String orgDivision) {
		logger.info("Method : viewempdepent starts");

		List<ManageEmployeeBankDetailsRestModel> viewempdepent = new ArrayList<ManageEmployeeBankDetailsRestModel>();
		JsonResponse<List<ManageEmployeeBankDetailsRestModel>> resp = new JsonResponse<List<ManageEmployeeBankDetailsRestModel>>();

		try {

			String value = "SET @p_empId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "viewebank").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ManageEmployeeBankDetailsRestModel viewEmployeesss = new ManageEmployeeBankDetailsRestModel(m[0], m[1],
						m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], null, null, null, null,
						m[13]);
				viewempdepent.add(viewEmployeesss);
			}

			if (viewempdepent.size() > 0) {
				Util.setJsonResponse(resp, viewempdepent, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, viewempdepent, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		resp.setBody(viewempdepent);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeBankDetailsRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeBankDetailsRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getworkkkk ends" + response);
		return response;
	}

	public ResponseEntity<JsonResponse<ManageEmployeeInsuranceDetailsrestModel>> saveempinsurance(
			ManageEmployeeInsuranceDetailsrestModel manageEmployeeInsuranceDetailsrestModel) {
		logger.info("Method : saveempinsurance starts");

		JsonResponse<ManageEmployeeInsuranceDetailsrestModel> resp = new JsonResponse<ManageEmployeeInsuranceDetailsrestModel>();
		try {
			String values = GenerateemployeemasterParameter.insurancedetails(manageEmployeeInsuranceDetailsrestModel);
			if (manageEmployeeInsuranceDetailsrestModel.getEinsuraneId() != null
					&& manageEmployeeInsuranceDetailsrestModel.getEinsuraneId() != "") {

				em.createNamedStoredProcedureQuery("employeeMasterRoutines")
						.setParameter("actionType", "modifyinsurence").setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("employeeMasterRoutines")
						.setParameter("actionType", "insurancedetailsssss").setParameter("actionValue", values)
						.execute();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<ManageEmployeeInsuranceDetailsrestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeInsuranceDetailsrestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveempinsurance ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeInsuranceDetailsrestModel>>> vieweinsurance(String id,
			String organization, String orgDivision) {
		logger.info("Method : vieweinsurance starts");

		List<ManageEmployeeInsuranceDetailsrestModel> viewempdepent = new ArrayList<ManageEmployeeInsuranceDetailsrestModel>();
		JsonResponse<List<ManageEmployeeInsuranceDetailsrestModel>> resp = new JsonResponse<List<ManageEmployeeInsuranceDetailsrestModel>>();

		try {

			String value = "SET @p_empId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "vieweinsurance").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object fDATE = null;
				if (m[7] != null) {
					fDATE = DateFormatter.returnStringDate(m[7]);
				}
				Object tDATE = null;
				if (m[8] != null) {
					tDATE = DateFormatter.returnStringDate(m[8]);
				}
				ManageEmployeeInsuranceDetailsrestModel viewEmployeesss = new ManageEmployeeInsuranceDetailsrestModel(
						m[0], m[1], m[2], m[3], m[4], m[5], m[6], fDATE, tDATE, null);
				viewempdepent.add(viewEmployeesss);
			}
			if (viewempdepent.size() > 0) {
				Util.setJsonResponse(resp, viewempdepent, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, viewempdepent, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		resp.setBody(viewempdepent);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeInsuranceDetailsrestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeInsuranceDetailsrestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : vieweinsurance ends");
		return response;
	}

	/************************* View Employee *********************************/
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeRestModel>>> viewmanageemployeemaste(String userId,
			String organization, String orgDivision,String type) {
		logger.info("Method : viewHrmsEmpPersonalDetails starts");
		JsonResponse<List<ManageEmployeeRestModel>> resp = new JsonResponse<List<ManageEmployeeRestModel>>();
		List<ManageEmployeeRestModel> employeeDetails = new ArrayList<ManageEmployeeRestModel>();
		String value = "SET @P_userId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_type='" + type + "';";
		System.out.println("value@@@@" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "viewemppersonal").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object dob = null;
				if (m[5] != null) {
					dob = DateFormatter.returnStringDate(m[5]);
				}
				ManageEmployeeRestModel empDetails = new ManageEmployeeRestModel(m[0], m[1], m[2], m[3], m[4], dob,
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], null, null, null, null, null, null, null,
						null, null, m[14], m[15], m[16], null, null, null, m[17], m[18], m[19], m[20], m[21], m[22],
						m[23], m[24],null);

				employeeDetails.add(empDetails);
			}
			if (employeeDetails.size() > 0) {
				Util.setJsonResponse(resp, employeeDetails, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, employeeDetails, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.error("Error " + err[1]);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.error("viewHrmsEmpPersonalDetails: " + e.getMessage());
			e.printStackTrace();
		}

		resp.setBody(employeeDetails);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewHrmsEmpPersonalDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked") 
	public ResponseEntity<JsonResponse<ManageEmployeeRestModel>> editmanageEmployeemasterById(String id,
			String organization, String orgDivision) {
		logger.info("Method : editmanageEmployeemasterById starts");

		JsonResponse<ManageEmployeeRestModel> resp = new JsonResponse<ManageEmployeeRestModel>();
		List<ManageEmployeeRestModel> editemp = new ArrayList<ManageEmployeeRestModel>();

		try {

			String value = "SET @P_employeeId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "editemp").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				String imgUrl = null;

				if (m[1] != null && m[1] != "" && !m[1].toString().contentEquals("null")
						&& !m[1].toString().equals("")) {
					imgUrl = env.getMobileView() + "document/employee/" + m[1].toString();
				}
				Object dob = null;
				if (m[5] != null) {
					dob = DateFormatter.returnStringDate(m[5]);
				}
				Object jDate = null;
				if (m[22] != null) {
					jDate = DateFormatter.returnStringDate(m[22]);
				}
				Object mDate = null;
				if (m[23] != null) {
					mDate = DateFormatter.returnStringDate(m[23]);
				}
				ManageEmployeeRestModel manageEmployeeRestModel = new ManageEmployeeRestModel(m[0], imgUrl, m[2], m[3],
						m[4], dob, m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], null, null, m[14], m[15], m[16],
						m[17], m[18], m[19], m[20], null, null, null, m[21], jDate, mDate, null, null, null, null, null,
						null, m[24], null,m[25]);
				editemp.add(manageEmployeeRestModel);
			}
			if (editemp.size() > 0) {
				Util.setJsonResponse(resp, editemp, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, editemp, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
			resp.setBody(editemp.get(0));
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
		}

		ResponseEntity<JsonResponse<ManageEmployeeRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : editmanageEmployeemasterById ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteinsurance(String id) {
		logger.info("Method : deleteinsurance starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='(" + id + ")'";
			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "deleteinsurance")
					.setParameter("actionValue", values).execute();

		} catch

		(Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteinsurance ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deletework(String id) {
		logger.info("Method : deletework starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			// String values = "SET @p_id='(" + id + ")'";
			String values = "SET @p_id='(\"" + id + "\")'";
			System.out.println("values=================" + values);
			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "deletework")
					.setParameter("actionValue", values).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
		} catch

		(Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deletework ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> savebenifit(ManageEmployeeBenifitrestModel req) {
		logger.info("Method : savebenifit starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateemployeemasterParameter.getAddbenParam(req);

			if (req.getEbenifitId() == null || req.getEbenifitId() == "") {
				em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "addbenifit")
						.setParameter("actionValue", values).execute();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : save benifit ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeBenifitrestModel>>> viewBenefits(String empid,
			String organization, String orgDivision) {

		logger.info("Method : viewBenefits starts");

		JsonResponse<List<ManageEmployeeBenifitrestModel>> resp = new JsonResponse<List<ManageEmployeeBenifitrestModel>>();
		List<ManageEmployeeBenifitrestModel> editemp = new ArrayList<ManageEmployeeBenifitrestModel>();
		try {
			String values = "SET @p_empId='" + empid + "',@P_organization='" + organization + "',@P_orgDivision='"
					+ orgDivision + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "viewBenefits").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				ManageEmployeeBenifitrestModel benefits = new ManageEmployeeBenifitrestModel(m[0], m[1], null, null);
				editemp.add(benefits);
			}

			if (editemp.size() > 0) {
				Util.setJsonResponse(resp, editemp, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, editemp, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
			resp.setBody(editemp);
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<ManageEmployeeBenifitrestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeBenifitrestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewBenefits ends");

		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getTeam(String id, String organization,
			String orgDivision) {

		logger.info("Method : getManager starts");

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> model = new ArrayList<DropDownModel>();

		String values = "SET @p_empId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getTeam").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {

				DropDownModel item = new DropDownModel(m[0], m[1]);
				model.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(model);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getManager ends");
		return response;
	}

	/*
	 * public ResponseEntity<JsonResponse<Object>> addDoc(EmployeeDocumentModel
	 * employeeDocumentModel) { logger.info("Method : addDoc starts");
	 * JsonResponse<Object> resp = new JsonResponse<Object>();
	 * 
	 * try { String value =
	 * GenerateemployeemasterParameter.getEmployeeDoc(employeeDocumentModel); if
	 * (employeeDocumentModel.getEmployeeId() != null &&
	 * employeeDocumentModel.getEmployeeId() != "") {
	 * 
	 * em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter(
	 * "actionType", "modifyEmpDoc") .setParameter("actionValue", value).execute();
	 * } } catch (Exception e) { try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); }
	 * e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * logger.info("Method : add item addDoc ends"); return response; }
	 */

	@SuppressWarnings("unchecked")
	public List<InventoryVendorDocumentModel> viewEmpDocEdit(String id) {
		logger.info("Method : viewEmpDocEdit starts");

		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		List<InventoryVendorDocumentModel> docList1 = new ArrayList<InventoryVendorDocumentModel>();
		String values = "SET @p_empId='" + id + "';";

		try {
			List<Object[]> x1 = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getEmpDocs").setParameter("actionValue", values).getResultList();
			for (Object[] m : x1) {

				InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], null);
				docList.add(dropDownModel);
			}

			List<DropDownModel> documenttypeList = new ArrayList<DropDownModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
						.setParameter("actionType", "documentTypeList").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);

					documenttypeList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (docList.size() > 0) {
				docList.get(0).setDrop(documenttypeList);
			} else {
				InventoryVendorDocumentModel abc = new InventoryVendorDocumentModel();
				abc.setDrop(documenttypeList);
				docList1.add(abc);
				return docList1;
			}

		} catch (Exception e) {

		}

		logger.info("Method : viewEmpDocEdit ends");
		return docList;
	}

	// drop down for country list

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCountryListApiDao() {
		logger.info("Method : getgenderListAPiDao starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getCountryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}
			if (countryList.size() > 0) {
				Util.setJsonResponse(resp, countryList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, countryList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getgenderListAPiDao ends");
		return response;
	}
	// drop down for country list

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getNationalityListApiDao() {
		logger.info("Method : getNationalityListApiDao starts");

		List<DropDownModel> nationalityList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "nationalityList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nationalityList.add(dropDownModel);
			}
			if (nationalityList.size() > 0) {
				Util.setJsonResponse(resp, nationalityList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, nationalityList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getNationalityListApiDao ends");
		return response;
	}

	// drop down for gender list

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getgenderListAPiDao() {
		logger.info("Method : getgenderListAPiDao starts");

		List<DropDownModel> genderTypeList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getgenderList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				genderTypeList.add(dropDownModel);
			}
			if (genderTypeList.size() > 0) {
				Util.setJsonResponse(resp, genderTypeList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, genderTypeList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getgenderListAPiDao ends");
		return response;
	}

	// drop down for blood group list

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getbloodgroupListApiDao() {
		logger.info("Method : getbloodgroupListApiDao starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getbloodgroupList1").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}
			if (countryList.size() > 0) {
				Util.setJsonResponse(resp, countryList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, countryList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getbloodgroupListApiDao ends");
		return response;
	}

	// drop down for blood group list

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getmaritalstatusListApiDao() {
		logger.info("Method : getmaritalstatusListApiDao starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "maritalstatusList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}
			if (countryList.size() > 0) {
				Util.setJsonResponse(resp, countryList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, countryList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getmaritalstatusListApiDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> documentTypeListApiDao() {
		logger.info("Method : documentTypeListApiDao starts");

		List<DropDownModel> documenttypeList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "documentTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				documenttypeList.add(dropDownModel);
			}
			if (documenttypeList.size() > 0) {
				Util.setJsonResponse(resp, documenttypeList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, documenttypeList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : documentTypeListApiDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> relationshipListapi() {
		logger.info("Method : relationshipListapi starts");

		List<DropDownModel> relationList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "relationshipList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				relationList.add(dropDownModel);
			}
			if (relationList.size() > 0) {
				Util.setJsonResponse(resp, relationList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, relationList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : relationshipListapi ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<EmployeeProfileFileUploadModel>> profileDataUpload(
			EmployeeProfileFileUploadModel employee) {
		logger.info("Method : saveemployeeMaster starts");
		JsonResponse<EmployeeProfileFileUploadModel> resp = new JsonResponse<EmployeeProfileFileUploadModel>();

		try {
			String values = GenerateProfileUploadParam.generateProfileUploadParam(employee);
			logger.info("values===" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "profileUpload").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				String profileImg = null;
				if (m[1] != null && m[1] != "" && m[1] != " " && !m[1].toString().equals(" ")
						&& !m[1].toString().equals(null) && !m[1].toString().equals("")) {
					profileImg = env.getMobileView() + "document/employee/" + m[1].toString();
				} else {
					profileImg = "";
				}
				EmployeeProfileFileUploadModel empdata = new EmployeeProfileFileUploadModel(m[0], profileImg);
				resp.setBody(empdata);
				Util.setJsonResponse(resp, empdata, ResponseStatus.success, "Information updated scuccessfully.");
			}

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
		ResponseEntity<JsonResponse<EmployeeProfileFileUploadModel>> response = new ResponseEntity<JsonResponse<EmployeeProfileFileUploadModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveEmpMaster ends");
		return response;
	}

	/*
	 * public ResponseEntity<JsonResponse<Object>> resetPasswordDao(DropDownModel
	 * data) { logger.info("Method : resetPasswordDao Dao starts");
	 * 
	 * JsonResponse<Object> jsonResponse = new JsonResponse<Object>();
	 * 
	 * Boolean validity = true; if (data.getKey() == null || data.getKey() == "") {
	 * jsonResponse.setCode("failed");
	 * jsonResponse.setMessage("Employee number required"); validity = false; }
	 * 
	 * if (!StringUtil.isNull(data.getName()) && !StringUtil.isNull(data.getCode()))
	 * { if (data.getName().equals(data.getCode())) {
	 * Util.setJsonResponse(jsonResponse, null, ResponseStatus.failed,
	 * "New password can't be same as old password"); validity = false; } }
	 * 
	 * if (validity) { try { if (data.getKey() != null && data.getKey() != "") {
	 * 
	 * String password = null;
	 * 
	 * logger.info(data.getKey()); logger.info(data.getCode());
	 * 
	 * if (data.getCode() != null && data.getCode() != "") { password =
	 * passEncoder.encode(data.getCode()); }
	 * 
	 * if (data.getName() != null && data.getName() != "" && data.getCode() != null
	 * && data.getCode() != "") {
	 * 
	 * String encodePassword = checkDuplicateDao.getUserPassword(data.getKey());
	 * Boolean status = passEncoder.matches(data.getName(), encodePassword); if
	 * (status) { password = passEncoder.encode(data.getCode()); String value =
	 * "SET @p_userid='" + data.getKey() + "',@p_password='" + password + "';";
	 * logger.info(value); boolean x =
	 * em.createNamedStoredProcedureQuery("check_userid_exist")
	 * .setParameter("actionType", "change_password").setParameter("actionValue",
	 * value) .execute();
	 * 
	 * jsonResponse.setCode("success");
	 * jsonResponse.setMessage("Password changed successfully");
	 * 
	 * } else { jsonResponse.setCode("failed");
	 * jsonResponse.setMessage("Old password does not match"); }
	 * 
	 * } else { jsonResponse.setCode("failed");
	 * jsonResponse.setMessage("Current password does not match"); }
	 * 
	 * } else { jsonResponse.setCode("failed");
	 * jsonResponse.setMessage("Employee number required"); } } catch (Exception e)
	 * { e.printStackTrace(); jsonResponse.setCode("failed");
	 * jsonResponse.setMessage("Password not changed"); } }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(jsonResponse, HttpStatus.OK);
	 * 
	 * logger.info("Method : resetPasswordDao Dao ends"); return response; }
	 */
	public ResponseEntity<JsonResponse<Object>> resetPasswordDao(DropDownModel data) {
		logger.info("Method : resetPasswordDao Dao starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		Boolean validity = true;
		if (data.getKey() == null || data.getKey() == "") {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Mobile No. required");
			validity = false;
		}

		if (validity) {

			try {
				if (data.getKey() != null && data.getKey() != "") {

					String password = null;
					if (data.getCode() != null && data.getCode() != "") {
						password = passEncoder.encode(data.getCode());
					}

					String value = "SET @p_userid='" + data.getKey() + "',@p_password='" + password + "';";

					logger.info(data.getKey());
					logger.info(password);

					em.createNamedStoredProcedureQuery("check_userid_exist")
							.setParameter("actionType", "change_password").setParameter("actionValue", value).execute();

					jsonResponse.setCode("success");
					jsonResponse.setMessage("Password updated successfully");

				} else {
					jsonResponse.setCode("failed");
					jsonResponse.setMessage("Employee No. required");
				}
			} catch (Exception e) {
				e.printStackTrace();
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Password not updated");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
				HttpStatus.OK);

		logger.info("Method : resetPasswordDao Dao ends");
		return response;
	}

	// Address Edit
	@SuppressWarnings("unchecked")
	public JsonResponse<ManageEmployeeAddressRestModel> editAddressDetails(String addressId, String addressType,
			String organization, String orgDivision) {
		logger.info("Method : editAddressDetails dao starts");
		ManageEmployeeAddressRestModel req = new ManageEmployeeAddressRestModel();
		JsonResponse<ManageEmployeeAddressRestModel> resp = new JsonResponse<ManageEmployeeAddressRestModel>();
		try {
			String value = "SET @p_addressId='" + addressId + "',@p_addressType='" + addressType + "',@p_org='"
					+ organization + "',@p_orgDiv='" + orgDivision + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "editAddressDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				ManageEmployeeAddressRestModel restaddress = new ManageEmployeeAddressRestModel(m[0], m[1], null, m[2],
						m[3], null, m[4], null, m[5], null, m[6], m[7], m[8], null, m[9]);
				req = restaddress;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAddressDetails dao ends");
		return resp;
	}

	// Insurance Edit
	@SuppressWarnings("unchecked")
	public JsonResponse<ManageEmployeeInsuranceDetailsrestModel> editInsurance(String id, String organization,
			String orgDivision) {
		logger.info("Method : editInsurance dao starts");
		ManageEmployeeInsuranceDetailsrestModel req = new ManageEmployeeInsuranceDetailsrestModel();
		JsonResponse<ManageEmployeeInsuranceDetailsrestModel> resp = new JsonResponse<ManageEmployeeInsuranceDetailsrestModel>();
		try {

			String value = "SET @p_insuranceId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "editInsurance").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object fdate = null;
				if (m[3] != null) {
					fdate = DateFormatter.returnStringDate(m[3]);
				}
				Object tdate = null;
				if (m[4] != null) {
					tdate = DateFormatter.returnStringDate(m[4]);
				}

				ManageEmployeeInsuranceDetailsrestModel restInsurance = new ManageEmployeeInsuranceDetailsrestModel(
						null, null, m[0], null, m[1], null, m[2], fdate, tdate, null);
				req = restInsurance;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editInsurance dao ends");
		return resp;
	}

	// Work Details Edit
	@SuppressWarnings("unchecked")
	public JsonResponse<ManageEmployeeWorkdetailsRestModel> editWorkDetails(String id, String organization,
			String orgDivision) {
		logger.info("Method : editWorkDetails dao starts");
		ManageEmployeeWorkdetailsRestModel req = new ManageEmployeeWorkdetailsRestModel();
		JsonResponse<ManageEmployeeWorkdetailsRestModel> resp = new JsonResponse<ManageEmployeeWorkdetailsRestModel>();
		try {

			String value = "SET @p_workId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "editWorkDetails").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ManageEmployeeWorkdetailsRestModel restWorkDetails = new ManageEmployeeWorkdetailsRestModel(null, null,
						m[0], m[1], m[2], m[3], null, m[4], null, m[5], null, m[6], null, m[7], m[8], null, m[9], m[10],
						null, null, null, null, m[11], m[12], null);
				req = restWorkDetails;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("editWorkDetails" + resp);
		logger.info("Method : editWorkDetails dao ends");
		return resp;
	}

	// Eidt Dependent
	@SuppressWarnings("unchecked")
	public JsonResponse<ManageEmployeeDependentRestModel> editDependentDetails(String id, String organization,
			String orgDivision) {
		logger.info("Method : editDependentDetails dao starts");

		ManageEmployeeDependentRestModel req = new ManageEmployeeDependentRestModel();
		JsonResponse<ManageEmployeeDependentRestModel> resp = new JsonResponse<ManageEmployeeDependentRestModel>();
		try {

			String value = "SET @p_dependentId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "editDependentDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				Object ddob = null;
				if (m[3] != null) {
					ddob = DateFormatter.returnStringDate(m[3]);
				}

				ManageEmployeeDependentRestModel restDependentDetails = new ManageEmployeeDependentRestModel(m[0], null,
						null, null, m[1], m[2], ddob, m[4], null, m[5], null, null);
				req = restDependentDetails;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editDependentDetails dao ends");
		return resp;
	}

	// Edit Bank
	@SuppressWarnings("unchecked")
	public JsonResponse<ManageEmployeeBankDetailsRestModel> editBankDetails(String id, String organization,
			String orgDivision) {
		logger.info("Method : editDependentDetails dao starts");

		ManageEmployeeBankDetailsRestModel req = new ManageEmployeeBankDetailsRestModel();
		JsonResponse<ManageEmployeeBankDetailsRestModel> resp = new JsonResponse<ManageEmployeeBankDetailsRestModel>();
		try {

			String value = "SET @p_bankId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "editBankDetails").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ManageEmployeeBankDetailsRestModel viewbank = new ManageEmployeeBankDetailsRestModel(m[0], m[1], null,
						m[2], m[3], null, m[4], null, m[5], null, m[6], m[7], m[8], null, null, null, null, m[9]);
				req = viewbank;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editBankDetails dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeDocumentRestModel>>> viewedocument(String id,
			String organization, String orgDivision) {
		logger.info("Method : viewedocument starts");

		List<ManageEmployeeDocumentRestModel> viewempdoc = new ArrayList<ManageEmployeeDocumentRestModel>();
		JsonResponse<List<ManageEmployeeDocumentRestModel>> resp = new JsonResponse<List<ManageEmployeeDocumentRestModel>>();

		try {

			String value = "SET @p_empId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "viewempdocument").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				ManageEmployeeDocumentRestModel viewEmployeesss = new ManageEmployeeDocumentRestModel(m[0], m[1], m[2],
						m[3], m[4]);
				viewempdoc.add(viewEmployeesss);
			}
			if (viewempdoc.size() > 0) {
				Util.setJsonResponse(resp, viewempdoc, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, viewempdoc, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		resp.setBody(viewempdoc);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeDocumentRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeDocumentRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewedocument ends");
		return response;
	}

	public ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>> addEmpDocument(
			ManageEmployeeDocumentRestModel manageEmployeeDocumentRestModel) {
		logger.info("Method : addEmpDocument starts");

		JsonResponse<ManageEmployeeDocumentRestModel> resp = new JsonResponse<ManageEmployeeDocumentRestModel>();
		try {
			String value = GenerateemployeemasterParameter.getEmployeeOtherDoc(manageEmployeeDocumentRestModel);

			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "addEmpDoc")
					.setParameter("actionValue", value).execute();
			resp.setCode("Success");
			resp.setMessage("Document Updated Successfully");
		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addEmpDocument ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteEmpDoc(String docType, String empid, String organization,
			String orgDivision) {
		logger.info("Method : deleteEmpDoc starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_empId='" + empid + "',@p_docType='" + docType + "',@p_org='" + organization
					+ "',@p_orgDiv='" + orgDivision + "';";
			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "deleteEmpDoc")
					.setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
		} catch

		(Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteEmpDoc ends");
		return response;
	}

	// Eidt Dependent
	@SuppressWarnings("unchecked")
	public JsonResponse<ManageEmployeeDocumentRestModel> editDocumentDetails(String docType, String empid,
			String organization, String orgDivision) {
		logger.info("Method : editDocumentDetails dao starts");

		ManageEmployeeDocumentRestModel req = new ManageEmployeeDocumentRestModel();
		JsonResponse<ManageEmployeeDocumentRestModel> resp = new JsonResponse<ManageEmployeeDocumentRestModel>();
		try {
			String value = "SET @p_empId='" + empid + "',@p_docType='" + docType + "',@p_org='" + organization
					+ "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value====" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "editDocumentDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				ManageEmployeeDocumentRestModel viewEmployeesss = new ManageEmployeeDocumentRestModel(m[0], m[1], m[2],
						m[3], m[4]);
				req = viewEmployeesss;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("editDocumentDetails" + resp);
		logger.info("Method : editDocumentDetails dao ends");
		return resp;
	}

	/*
	 * get document type list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDocumentTypeList(String empid, String orgName, String orgDivision) {

		logger.info("Method : getDocumentTypeList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_empid='" + empid + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getDocumentTypeList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}
			resp.setBody(nameList);
			if (nameList.size() > 0) {
				Util.setJsonResponse(resp, nameList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, nameList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getDocumentTypeList ends" + resp);

		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<ManageEmployeeRestModel> getIdCardDetails(String id, String organization, String orgDivision) {
		logger.info("Method : getIdCardDetails starts");

		List<ManageEmployeeRestModel> resp = new ArrayList<ManageEmployeeRestModel>();

		try {

			String value = "SET @P_employeeId='(" + id + ")',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";
			System.out.println("hhhuuuullllliiii" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getIDCardDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				String imgUrl = null;
				String qrUrl = null;
				if (m[1] != null && m[1] != "" && !m[1].toString().contentEquals("null")
						&& !m[1].toString().equals("")) {
					imgUrl = env.getMobileView() + "document/employee/" + m[1].toString();
				}
				if (m[4] != null && m[4] != "" && !m[4].toString().contentEquals("null")
						&& !m[4].toString().equals("")) {
					qrUrl = env.getMobileView() + "document/staffQrCode/" + m[4].toString();
				}
				String logo = null;
				if (m[15] != null && m[15] != "" && !m[15].toString().contentEquals("null")
						&& !m[15].toString().equals("")) {
					logo = env.getMobileView() + "document/document/" + m[15].toString();
				}
				String sign = null;
				if (m[16] != null && m[16] != "" && !m[16].toString().contentEquals("null")
						&& !m[16].toString().equals("")) {
					sign = env.getMobileView() + "document/document/" + m[16].toString();
				}

				ManageEmployeeRestModel manageEmployeeRestModel = new ManageEmployeeRestModel(m[0], imgUrl, m[2], m[3],
						qrUrl, m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], logo, sign);
				resp.add(manageEmployeeRestModel);
			}
			// resp.setCode("success");
			// System.out.println("hhhuuuu"+resp);
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.error("Error " + err[1]);
				e.printStackTrace();
				// resp.setCode("failed");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		logger.info("Method : getIdCardDetails ends");
		return resp;
	}

	public ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>> viewSalaryMaster(String userid,
			String organization, String orgDivision) {
		logger.info("Method : viewSalaryMaster starts");
		List<RestSalaryRevisionModel> respList = new ArrayList<RestSalaryRevisionModel>();

		try {
			/*
			 * String value = "SET @P_userId='" + userid + "',@P_organization='" +
			 * organization + "',@P_orgDivision='" + orgDivision + "';";
			 * logger.info("value==" + value); List<Object[]> x =
			 * em.createNamedStoredProcedureQuery("employeeMasterRoutines")
			 * .setParameter("actionType", "viewSalaryMaster").setParameter("actionValue",
			 * value).getResultList();
			 * 
			 * for (Object[] m : x) { Object date = null; if (m[4] != null) { date =
			 * m[4].toString(); } RestSalaryRevisionModel restPayroll = new
			 * RestSalaryRevisionModel(m[0], m[1], m[2], m[3], date, m[5], m[6].toString(),
			 * m[7].toString(), m[8].toString(), m[9].toString(), m[10].toString(),
			 * m[11].toString(), m[12].toString(), m[13].toString(), m[14].toString(),
			 * m[15].toString(), m[16].toString(), m[17], m[18],
			 * m[19].toString(),m[20].toString(),m[21].toString(),m[22]);
			 * respList.add(restPayroll);
			 */

//			}

			// logger.info("respList" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestSalaryRevisionModel>> resp = new JsonResponse<List<RestSalaryRevisionModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>> response = new ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("response" + response);
		logger.info("Method : viewSalaryMaster ends");
		return response;

	}

	public ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>> saveeDocumentType(
			ManageEmployeeDocumentRestModel manageEmployeeDocumentRestModel) {
		logger.info("Method : saveeDocumentType starts");

		JsonResponse<ManageEmployeeDocumentRestModel> resp = new JsonResponse<ManageEmployeeDocumentRestModel>();
		try {
			String value = GenerateemployeemasterParameter.addDocTypeParam(manageEmployeeDocumentRestModel);
			System.out.println("values---------" + value);
			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "addDocType")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			// resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveeDocumentType ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getQualifyEduList(String orgName, String orgDivision) {

		logger.info("Method : getQualifyEduList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getQualifyEduList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}
			resp.setBody(nameList);
			if (nameList.size() > 0) {
				Util.setJsonResponse(resp, nameList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, nameList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getQualifyEduList ends" + resp);

		return resp;
	}

	public ResponseEntity<JsonResponse<ManageEmployeeEducationRestModel>> saveemployeeEducation(
			ManageEmployeeEducationRestModel education) {
		logger.info("Method : saveemployeeaddress starts" + education.getEduId());

		JsonResponse<ManageEmployeeEducationRestModel> resp = new JsonResponse<ManageEmployeeEducationRestModel>();
		try {
			String values = GenerateemployeemasterParameter.saveempeducation(education);
			if (education.getEduId() != null && education.getEduId() != "") {

				logger.info(" update values saveempeducation" + values);
				em.createNamedStoredProcedureQuery("employeeMasterRoutines")
						.setParameter("actionType", "modifyEducation").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
				resp.setCode("Success");
				resp.setMessage("Education Details Updated Successfully");

			} else {

				logger.info("add values saveempeducation" + values);
				em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "addEducation")
						.setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
				resp.setCode("Success");
				resp.setMessage("Education Details Added Successfully");
			}

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		ResponseEntity<JsonResponse<ManageEmployeeEducationRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeEducationRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveVendorLocationMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeEducationRestModel>>> empQualificationView(String id,
			String organization, String orgDivision) {
		logger.info("Method : viewEmployeeadd starts");

		List<ManageEmployeeEducationRestModel> viewEmployeeadd = new ArrayList<ManageEmployeeEducationRestModel>();
		JsonResponse<List<ManageEmployeeEducationRestModel>> resp = new JsonResponse<List<ManageEmployeeEducationRestModel>>();
		try {

			String value = "SET @p_empId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "viewEducation").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ManageEmployeeEducationRestModel empLocation = new ManageEmployeeEducationRestModel(m[0], m[1], m[2],
						m[3], m[4]);
				viewEmployeeadd.add(empLocation);
			}
			if (viewEmployeeadd.size() > 0) {
				Util.setJsonResponse(resp, viewEmployeeadd, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, viewEmployeeadd, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		resp.setBody(viewEmployeeadd);
		resp.setMessage("Data Fetched Successfully");
		resp.setCode("Success");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeEducationRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeEducationRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewEmployeeadd ends" + response);

		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<ManageEmployeeEducationRestModel> empQualificationEdit(String eduid, String empid,
			String organization, String orgDivision) {
		logger.info("Method : editDocumentDetails dao starts");

		ManageEmployeeEducationRestModel req = new ManageEmployeeEducationRestModel();
		JsonResponse<ManageEmployeeEducationRestModel> resp = new JsonResponse<ManageEmployeeEducationRestModel>();
		try {
			String value = "SET @p_empId='" + empid + "',@p_eduId='" + eduid + "',@p_org='" + organization
					+ "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value====" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "editEducation").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				ManageEmployeeEducationRestModel viewEmployeesss = new ManageEmployeeEducationRestModel(m[0], m[1],
						m[2], m[3], m[4]);
				req = viewEmployeesss;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("editDocumentDetails" + resp);
		logger.info("Method : editDocumentDetails dao ends");
		return resp;
	}

	public ResponseEntity<JsonResponse<ManageEmployeeEducationRestModel>> saveQualifyType(
			ManageEmployeeEducationRestModel docModel) {
		logger.info("Method : saveQualifyType starts");

		JsonResponse<ManageEmployeeEducationRestModel> resp = new JsonResponse<ManageEmployeeEducationRestModel>();
		try {
			String value = GenerateemployeemasterParameter.saveempeducation(docModel);
			System.out.println("values---------" + value);
			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "addEduQualify")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			// resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<ManageEmployeeEducationRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeEducationRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveQualifyType ends" + response);
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteEducation(String id) {
		logger.info("Method : deleteEducation starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='" + id + "';";
			System.out.println("values---------" + values);
			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "deleteEducation")
					.setParameter("actionValue", values).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
		} catch

		(Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteEducation ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getemployedByList(String organization, String orgDivision) {
		logger.info("Method : getemployedByList starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getemployedByList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}
			if (countryList.size() > 0) {
				Util.setJsonResponse(resp, countryList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, countryList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getemployedByList ends");
		return countryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getQualifyEduListdropdown(String orgName, String orgDivision) {
		logger.info("Method : getQualifyEduListdropdown starts");

		List<DropDownModel> genderTypeList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getQualifyEduList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				genderTypeList.add(dropDownModel);
			}
			if (genderTypeList.size() > 0) {
				Util.setJsonResponse(resp, genderTypeList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, genderTypeList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getQualifyEduListdropdown ends");
		return genderTypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>> viewSalaryMasterSingle(String id,
			String organization, String orgDivision) {
		logger.info("Method : viewSalaryMaster starts");
		List<RestSalaryRevisionModel> respList = new ArrayList<RestSalaryRevisionModel>();

		try {
			String value = "SET @P_userId='" + id + "',@P_organization='" + organization + "',@P_orgDivision='"
					+ orgDivision + "';";
			logger.info("value==" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "viewSalaryMasterSingle").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object date = null;

				if (m[4] != null) {
					date = m[4].toString();
				}
				Object date1 = null;
				if (m[28] != null) {
					date1 = m[28].toString();
				}

				RestSalaryRevisionModel restPayroll = new RestSalaryRevisionModel(m[0], m[1], m[2], m[3], date, m[5],
						m[6].toString(), m[7].toString(), m[8].toString(), m[9].toString(), m[10].toString(),
						m[11].toString(), m[12].toString(), m[13].toString(), m[14].toString(), m[15].toString(),
						m[16].toString(), m[17].toString(), m[18].toString(), m[19].toString(), m[20].toString(),
						m[21].toString(), m[22].toString(), m[23].toString(), m[24].toString(), m[25].toString(),
						m[26].toString(), m[27].toString(), date1, null, null);
				respList.add(restPayroll);
			}
			logger.info("respList" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestSalaryRevisionModel>> resp = new JsonResponse<List<RestSalaryRevisionModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>> response = new ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewSalaryMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>> saveeCCRType(
			ManageEmployeeDocumentRestModel docModel) {
		logger.info("Method : saveeCCRType starts");

		JsonResponse<ManageEmployeeDocumentRestModel> resp = new JsonResponse<ManageEmployeeDocumentRestModel>();
		try {
			String value = GenerateemployeemasterParameter.addDocTypeParam(docModel);
			System.err.println("values---------" + value);
			em.createNamedStoredProcedureQuery("hrms_ccr_routines").setParameter("actionType", "saveeCCRType")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			// resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveeCCRType ends");
		return response;
	}

}
