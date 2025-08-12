package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterReferenceHr;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestHrMasterModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestHrMasterDao {
	Logger logger = LoggerFactory.getLogger(RestHrMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to Add jobTypes
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addJobType(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : Rest Add Job Type Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addJobTypeParam(restHrMasterModel);

				if (restHrMasterModel.getJobTypeId() != null && restHrMasterModel.getJobTypeId() != "") {
					em.createNamedStoredProcedureQuery("HrReference").setParameter("actionType", "modifyJobType")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrReference").setParameter("actionType", "addJobType")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest Add Job Type Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewJobType(String org, String orgDiv) {
		logger.info("Method : viewJobType starts");

		List<RestHrMasterModel> jobList = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("HrReference")
					.setParameter("actionType", "viewJobType").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestHrMasterModel dropDownModel = new RestHrMasterModel(m[0], m[1], m[2], status, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,null,null);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(jobList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewJobType ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteJobType(String id) {

		logger.info("Method : deleteJobType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_jobTypeId='" + id + "';";

			em.createNamedStoredProcedureQuery("HrReference").setParameter("actionType", "deleteJob")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteJobType Dao starts");
		return response;
	}

	/*
	 * 
	 * ------------------------ADD WORK HOURS
	 * DAO--------------------------------------------------------------------------
	 * ----------------
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addWorkHour(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : Rest Add WorkHour Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addWorkHoursParam(restHrMasterModel);
				logger.info("Method : Rest Add WorkHour Dao starts" + values);

				if (restHrMasterModel.getWorkhourId() != null && restHrMasterModel.getWorkhourId() != "") {
					em.createNamedStoredProcedureQuery("HrWorkHours").setParameter("actionType", "modifyWorkHours")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrWorkHours").setParameter("actionType", "addWorkHours")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest Add WorkHour Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewAllWorkHours(String org, String orgDiv) {
		logger.info("Method : viewAllWorkHours Dao starts");

		List<RestHrMasterModel> workList = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("HrWorkHours")
					.setParameter("actionType", "viewAllWorkHours").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[2].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						m[0], m[1], null, status, null, null, m[3], m[4], m[5], m[6], null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,null,null);
				workList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(workList);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewAllWorkHours Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteWorkHour(String id) {

		logger.info("Method : deleteWorkHour Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_WorkhourId='" + id + "';";

			em.createNamedStoredProcedureQuery("HrWorkHours").setParameter("actionType", "deleteWorkHour")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteWorkHour Dao ends");
		return response;
	}

	/*
	 * 
	 * ------------------------ADD Education
	 * DAO--------------------------------------------------------------------------
	 * ----------------
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addEducation(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : Education Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addEducationParam(restHrMasterModel);

				if (restHrMasterModel.getEducationId() != null && restHrMasterModel.getEducationId() != "") {
					em.createNamedStoredProcedureQuery("HrEducation").setParameter("actionType", "modifyEdu")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrEducation").setParameter("actionType", "addEdu")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Education Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewEducation(String org, String orgDiv) {
		logger.info("Method : viewEducation Dao starts");

		List<RestHrMasterModel> eduList = new ArrayList<RestHrMasterModel>();

		try {

			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("HrEducation").setParameter("actionType", "viewEdu")
					.setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2], status, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,null,null);
				eduList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(eduList);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewEducation Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteEducation(String id) {

		logger.info("Method : deleteEducation Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_eduId='" + id + "';";

			em.createNamedStoredProcedureQuery("HrEducation").setParameter("actionType", "deleteEdu")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteEducation Dao ends");
		return response;
	}

	/*
	 * 
	 * ------------------------ADD Job Band
	 * DAO--------------------------------------------------------------------------
	 * ----------------
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addJobBand(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : Job Band Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addJobBandParam(restHrMasterModel);

				if (restHrMasterModel.getJobBandId() != null && restHrMasterModel.getJobBandId() != "") {
					em.createNamedStoredProcedureQuery("HrJobBand").setParameter("actionType", "modifyJobBand")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrJobBand").setParameter("actionType", "addJobBand")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Job Band Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewJobBand(String org, String orgDiv) {
		logger.info("Method : viewJobBand Dao starts");

		List<RestHrMasterModel> jobbandList = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("HrJobBand").setParameter("actionType", "viewJobBand")
					.setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						m[0], m[1], m[2], status, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,null,null);
				jobbandList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(jobbandList);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewJobBand Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteJobBand(String id) {

		logger.info("Method : deleteJobBand Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_jobBandId='" + id + "';";

			em.createNamedStoredProcedureQuery("HrJobBand").setParameter("actionType", "deleteJobBand")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteJobBand Dao ends");
		return response;
	}

	/*
	 * 
	 * ------------------------ADD Benefits
	 * DAO--------------------------------------------------------------------------
	 * ----------------
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addBenefits(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : Benefits Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addBenefitsParam(restHrMasterModel);

				if (restHrMasterModel.getBenifitId() != null && restHrMasterModel.getBenifitId() != "") {
					em.createNamedStoredProcedureQuery("HrBenefit").setParameter("actionType", "modifyBenefit")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrBenefit").setParameter("actionType", "addBenefit")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Benefits Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewBenefits(String org, String orgDiv) {
		logger.info("Method : viewBenefits Dao starts");

		List<RestHrMasterModel> BenefitList = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("HrBenefit")
					.setParameter("actionType", "viewBenefits").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, m[0], m[1], m[2], status, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,null,null);
				BenefitList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(BenefitList);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewBenefits Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteBenefits(String id) {

		logger.info("Method : deleteBenefits Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_benefitId='" + id + "';";

			em.createNamedStoredProcedureQuery("HrBenefit").setParameter("actionType", "deleteBenefits")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteBenefits Dao ends");
		return response;
	}

	/*
	 * 
	 * ------------------------ADD AddressType
	 * DAO--------------------------------------------------------------------------
	 * ----------------
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addAddress(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : Address Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addAddressParam(restHrMasterModel);

				if (restHrMasterModel.getAddressId() != null && restHrMasterModel.getAddressId() != "") {
					em.createNamedStoredProcedureQuery("HrAddress").setParameter("actionType", "modifyAddress")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrAddress").setParameter("actionType", "addAddress")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Address Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewAddress(String org, String orgDiv) {
		logger.info("Method : viewAddress Dao starts");

		List<RestHrMasterModel> AddressList = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("HrAddress").setParameter("actionType", "viewAddress")
					.setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2],
						status, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null,null,null);
				AddressList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(AddressList);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewAddress Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteAddress(String id) {

		logger.info("Method : deleteAddress Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_addressId='" + id + "';";

			em.createNamedStoredProcedureQuery("HrAddress").setParameter("actionType", "deleteAddress")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteAddress Dao ends");
		return response;
	}

	/*
	 * 
	 * ------------------------ADD Blood Group
	 * DAO--------------------------------------------------------------------------
	 * ----------------
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addBloodgroup(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addBloodgroup Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addBloodGroupParam(restHrMasterModel);

				if (restHrMasterModel.getBloodGroupId() != null && restHrMasterModel.getBloodGroupId() != "") {
					em.createNamedStoredProcedureQuery("HrBloodGroup").setParameter("actionType", "modifyBloodGroup")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrBloodGroup").setParameter("actionType", "addBloodgroup")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addBloodgroup Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewBloodGroup(String org, String orgDiv) {
		logger.info("Method : viewBloodGroup Dao starts");

		List<RestHrMasterModel> AddressList = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("HrBloodGroup")
					.setParameter("actionType", "viewBloodGroup").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, m[0], m[1], m[2], status, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,null,null);
				AddressList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(AddressList);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewBloodGroup Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteBloodGroup(String id) {

		logger.info("Method : deleteBloodGroup Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_bloodGroupId='" + id + "';";

			em.createNamedStoredProcedureQuery("HrBloodGroup").setParameter("actionType", "deleteBloodGroup")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteBloodGroup Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentTypeForShiftType(String organization, @RequestParam String orgDivision) {
		// TODO Auto-generated method stub
		logger.info("Method : getDepartmentTypeForShiftType starts");
		List<DropDownModel> financialYr = new ArrayList<DropDownModel>();

		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("HrShift")
					.setParameter("actionType", "getDepartmentTypeForShiftType").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				logger.info("dropDownModel@@@@@@@@@@@@@@@@" + dropDownModel);
				financialYr.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDepartmentTypeForShiftType end");
		return financialYr;

	}
	/*
	 * 
	 * ------------------------ADD Shift
	 * DAO--------------------------------------------------------------------------
	 * ----------------
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addShift(RestHrMasterModel restShift) {
		logger.info("Method : Rest addShift starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addShiftParam(restShift);

				if (restShift.getShiftId() != null && restShift.getShiftId() != "") {
					em.createNamedStoredProcedureQuery("HrShift").setParameter("actionType", "modifyShift")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrShift").setParameter("actionType", "addShift")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : Rest addShift ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewShift(String org, String orgDiv) {
		logger.info("Method : viewShift Dao starts");

		List<RestHrMasterModel> AddressList = new ArrayList<RestHrMasterModel>();

		try {

			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("Method : viewShift Dao starts" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("HrShift").setParameter("actionType", "viewShift")
					.setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object status = "";
				if (m[2].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], null,
						status, m[3], m[4], null, null, null, null, null, null, null, null);
				AddressList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(AddressList);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);
		 logger.info("shift==="+response);

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteShift(String id, String org, String orgDiv) {

		logger.info("Method : deleteShift Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_shiftId='" + id + "', @p_org = '" + org + "', @p_orgDiv = '" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("HrShift").setParameter("actionType", "deleteShift")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteShift Dao ends");
		return response;
	}

	/*
	 * 
	 * ------------------------ADD Marital
	 * DAO--------------------------------------------------------------------------
	 * ----------------
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addMarital(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addMarital Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addMaritalParam(restHrMasterModel);

				if (restHrMasterModel.getMaritalId() != null && restHrMasterModel.getMaritalId() != "") {
					em.createNamedStoredProcedureQuery("HrMarital").setParameter("actionType", "modifyMarital")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrMarital").setParameter("actionType", "addMarital")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addMarital Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewMarital(String org, String orgDiv) {
		logger.info("Method : viewMarital Dao starts");

		List<RestHrMasterModel> MaritalList = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("HrMarital").setParameter("actionType", "viewMarital")
					.setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2],
						status, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null,null,null);
				MaritalList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(MaritalList);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewMarital Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteMarital(String id) {

		logger.info("Method : deleteMarital Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_maritalId='" + id + "';";

			em.createNamedStoredProcedureQuery("HrMarital").setParameter("actionType", "deleteMarital")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteMarital Dao ends");
		return response;
	}

	/*
	 * 
	 * ------------------------ADD Document Type
	 * DAO--------------------------------------------------------------------------
	 * ----------------
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addDocument(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addDocument Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addDocumentParam(restHrMasterModel);

				if (restHrMasterModel.getDocumentId() != null && restHrMasterModel.getDocumentId() != "") {
					em.createNamedStoredProcedureQuery("HrDocument").setParameter("actionType", "modifyDocument")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrDocument").setParameter("actionType", "addDocument")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addDocument Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewDocument(String org, String orgDiv) {
		logger.info("Method : viewDocument Dao starts");

		List<RestHrMasterModel> docList = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("HrDocument")
					.setParameter("actionType", "viewDocument").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, m[0], m[1], m[2], status, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,null,null);
				docList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(docList);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewDocument Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteDocument(String id,String org,String orgDiv) {

		logger.info("Method : deleteDocument Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_documentId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("HrDocument").setParameter("actionType", "deleteDocument")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteDocument Dao ends");
		return response;
	}

	/*
	 * 
	 * ------------------------ADD TimeSheet Type
	 * DAO--------------------------------------------------------------------------
	 * ----------------
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addTimeSheet(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addTimeSheet Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addTimeSheetParam(restHrMasterModel);

				if (restHrMasterModel.getTimeSheetId() != null && restHrMasterModel.getTimeSheetId() != "") {
					em.createNamedStoredProcedureQuery("HrmTimeSheet").setParameter("actionType", "modifyTimeSheet")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrmTimeSheet").setParameter("actionType", "addTimeSheet")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addTimeSheet Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewTimeSheet(String org, String orgDiv) {
		logger.info("Method : viewTimeSheet Dao starts");

		List<RestHrMasterModel> timesheet = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("HrmTimeSheet")
					.setParameter("actionType", "viewTimeSheet").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2],
						status, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null,null,null);
				timesheet.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(timesheet);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewTimeSheet Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteTimeSheet(String id) {

		logger.info("Method : deleteTimeSheet Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_timeSheetId='" + id + "';";

			em.createNamedStoredProcedureQuery("HrmTimeSheet").setParameter("actionType", "deleteTimeSheet")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteTimeSheet Dao ends");
		return response;
	}

	/*
	 * 
	 * ------------------------ADD Employee Status Type
	 * DAO--------------------------------------------------------------------------
	 * ----------------
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addEmpStatus(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addEmpStatus Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addEmpStatusParam(restHrMasterModel);

				if (restHrMasterModel.getEmploymentstatusId() != null
						&& restHrMasterModel.getEmploymentstatusId() != "") {
					em.createNamedStoredProcedureQuery("HrmEmpStatus").setParameter("actionType", "modifyEmpStatus")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrmEmpStatus").setParameter("actionType", "addEmpStatus")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addEmpStatus Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewEmpStatus(String org, String orgDiv) {
		logger.info("Method : viewEmpStatus Dao starts");

		List<RestHrMasterModel> EmpStatus = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("HrmEmpStatus")
					.setParameter("actionType", "viewEmpStatus").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, m[0], m[1], m[2], status, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,null,null);
				EmpStatus.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(EmpStatus);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : HrmEmpStatus Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteEmpStatus(String id) {

		logger.info("Method : deleteEmpStatus Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_empstatusId='" + id + "';";

			em.createNamedStoredProcedureQuery("HrmEmpStatus").setParameter("actionType", "deleteEmpStatus")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteEmpStatus Dao ends");
		return response;
	}

	/*
	 * 
	 * ------------------------ADD Project Type
	 * DAO--------------------------------------------------------------------------
	 * ----------------
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addprojectType(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addprojectType Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addProjectTypeParam(restHrMasterModel);

				if (restHrMasterModel.getProjectTypeId() != null && restHrMasterModel.getProjectTypeId() != "") {
					em.createNamedStoredProcedureQuery("HrmProjectType").setParameter("actionType", "modifyprojectType")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("HrmProjectType").setParameter("actionType", "addprojectType")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addprojectType Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewprojectType(String org, String orgDiv) {
		logger.info("Method : viewprojectType Dao starts");

		List<RestHrMasterModel> EmpStatus = new ArrayList<RestHrMasterModel>();

		try {

			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("HrmProjectType")
					.setParameter("actionType", "viewprojectType").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2],
						status, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null,null,null);
				EmpStatus.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(EmpStatus);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewprojectType Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteprojectType(String id) {

		logger.info("Method : deleteprojectType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_projectTypeId='" + id + "';";

			em.createNamedStoredProcedureQuery("HrmProjectType").setParameter("actionType", "deleteprojectType")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteprojectType Dao ends");
		return response;
	}

	/*
	 *
	 * ------------------------ priority Type
	 * -----------------------------------------------
	 *
	 *
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addPriority(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addPriority Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.priorityTypeParam(restHrMasterModel);

				if (restHrMasterModel.getPriorityId() != null && restHrMasterModel.getPriorityId() != "") {
					em.createNamedStoredProcedureQuery("priorityMasterpriorityMaster")
							.setParameter("actionType", "modifyPriority").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("priorityMasterpriorityMaster")
							.setParameter("actionType", "addPriority").setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addPriority Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewPriority(String org, String orgDiv) {
		logger.info("Method : viewPriority Dao starts");

		List<RestHrMasterModel> priority = new ArrayList<RestHrMasterModel>();

		try {

			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("priorityMasterpriorityMaster")
					.setParameter("actionType", "viewPriorityMaster").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, m[0], m[1], m[2], status, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,null,null);
				priority.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(priority);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewPriority Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deletePriority(String id) {

		logger.info("Method : deletePriority Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_priorityId='" + id + "';";

			em.createNamedStoredProcedureQuery("priorityMasterpriorityMaster")
					.setParameter("actionType", "deletePriorityMaster").setParameter("actionValue", values).execute();

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

		logger.info("Method : deletePriority Dao ends");
		return response;
	}

	/*
	 *
	 * ------------------------ Gender Type
	 * -----------------------------------------------
	 *
	 *
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addGender(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addGender Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.genderTypeParam(restHrMasterModel);

				if (restHrMasterModel.getGenderId() != null && restHrMasterModel.getGenderId() != "") {
					em.createNamedStoredProcedureQuery("GenderMaster").setParameter("actionType", "modifyGender")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("GenderMaster").setParameter("actionType", "addGender")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addGender Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewGender(String org, String orgDiv) {
		logger.info("Method : viewGender Dao starts");

		List<RestHrMasterModel> gender = new ArrayList<RestHrMasterModel>();

		try {

			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("GenderMaster")
					.setParameter("actionType", "viewGender").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2],
						status, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null,null,null);
				gender.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(gender);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewGender Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteGender(String id) {

		logger.info("Method : deleteGender Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_genderId='" + id + "';";

			em.createNamedStoredProcedureQuery("GenderMaster").setParameter("actionType", "deleteGender")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteGender Dao ends");
		return response;
	}

	/*
	 *
	 * ------------------------ Gender Type
	 * -----------------------------------------------
	 *
	 *
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addDepRelationship(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addDepRelationship Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.empDepRelationTypeParam(restHrMasterModel);

				if (restHrMasterModel.getDepRelationId() != null && restHrMasterModel.getDepRelationId() != "") {
					em.createNamedStoredProcedureQuery("DepRelationshipMaster")
							.setParameter("actionType", "modifyDepRelationship").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("DepRelationshipMaster")
							.setParameter("actionType", "addDepRelationship").setParameter("actionValue", values)
							.execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addGender Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewDepRelationship(String org, String orgDiv) {
		logger.info("Method : viewDepRelationship Dao starts");

		List<RestHrMasterModel> DepRelationship = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("DepRelationshipMaster")
					.setParameter("actionType", "viewDepRelationship").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, m[0], m[1], m[2], status, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,null,null);
				DepRelationship.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(DepRelationship);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewDepRelationship Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteDepRelationship(String id) {

		logger.info("Method : deleteDepRelationship Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_depRelationId='" + id + "';";

			em.createNamedStoredProcedureQuery("DepRelationshipMaster")
					.setParameter("actionType", "deleteDepRelationship").setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteDepRelationship Dao ends");
		return response;
	}

	/*
	 *
	 * ------------------------ Employee Dependent type
	 * -----------------------------------------------
	 *
	 *
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addDependentType(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addDependentType Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.dependentTypeParam(restHrMasterModel);

				if (restHrMasterModel.getDependentId() != null && restHrMasterModel.getDependentId() != "") {
					em.createNamedStoredProcedureQuery("dependentMaster")
							.setParameter("actionType", "modifyDependentType").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("dependentMaster").setParameter("actionType", "addDependentType")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addDependentType Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewDependentType(String org, String orgDiv) {
		logger.info("Method : viewDependentType Dao starts");

		List<RestHrMasterModel> dependent = new ArrayList<RestHrMasterModel>();

		try {

			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("dependentMaster")
					.setParameter("actionType", "viewDependentType").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2],
						status, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null,null,null);
				dependent.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(dependent);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewDependentType Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteDependentType(String id) {

		logger.info("Method : deleteDependentType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_dependentId='" + id + "';";

			em.createNamedStoredProcedureQuery("dependentMaster").setParameter("actionType", "deleteDependentType")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteDependentType Dao ends");
		return response;
	}

	/*
	 *
	 * ------------------------ Employee Insurance Company
	 * -----------------------------------------------
	 *
	 *
	 *
	 */

	public ResponseEntity<JsonResponse<Object>> addInsuranceCompany(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addInsuranceCompany Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.insuranceCompanyParam(restHrMasterModel);

				if (restHrMasterModel.getInsuranceId() != null && restHrMasterModel.getInsuranceId() != "") {
					em.createNamedStoredProcedureQuery("insuranceMaster")
							.setParameter("actionType", "modifyInsuranceCompany").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("insuranceMaster")
							.setParameter("actionType", "addInsuranceCompany").setParameter("actionValue", values)
							.execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addInsuranceCompany Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewInsuranceCompany(String org, String orgDiv) {
		logger.info("Method : viewInsuranceCompany Dao starts");

		List<RestHrMasterModel> dependent = new ArrayList<RestHrMasterModel>();

		try {

			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			logger.info("Method : viewInsuranceCompany Dao starts" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceMaster")
					.setParameter("actionType", "viewInsuranceCompany").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel dropDownModel = new RestHrMasterModel(null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, m[0], m[1], m[2], status, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null,null,null);
				dependent.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(dependent);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewInsuranceCompany Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteInsuranceCompany(String id) {

		logger.info("Method : deleteInsuranceCompany Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_insuranceId='" + id + "';";

			em.createNamedStoredProcedureQuery("insuranceMaster").setParameter("actionType", "deleteInsuranceCompany")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteInsuranceCompany Dao ends");
		return response;
	}

	/*
	 * ------------------------ Designation Company
	 * -----------------------------------------------
	 */

	public ResponseEntity<JsonResponse<Object>> addDesignationMasterDao(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addDesignationMaster Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addDesignationParam(restHrMasterModel);

				if (restHrMasterModel.getDesignationId() != null && restHrMasterModel.getDesignationId() != "") {
					logger.info("if part: " + values);
					em.createNamedStoredProcedureQuery("designationMaster")
							.setParameter("actionType", "modifyDesignation").setParameter("actionValue", values)
							.execute();
				} else {
					logger.info("Else part");
					em.createNamedStoredProcedureQuery("designationMaster").setParameter("actionType", "addDesignation")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addDesignationMaster Dao ends");

		return response;
	}

	// dao designation view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewDesignationDao(String org, String orgDiv) {
		logger.info("Method : viewDesignationDao starts");

		List<RestHrMasterModel> dependent = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("designationMaster")
					.setParameter("actionType", "viewdesignationMaster").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel restHrMasterModel = new RestHrMasterModel(m[0], m[1], m[2], status, null, null);
				dependent.add(restHrMasterModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(dependent);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewDesignationDao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteDesignationDao(String id, String orgName, String orgDiv) {

		logger.info("Method : deleteDesignationDao  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_designationId='" + id + "', @p_org='" + orgName + "', @p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("designationMaster")
					.setParameter("actionType", "deleteDesignationMaster").setParameter("actionValue", values)
					.execute();

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
		logger.info("##################" + response);
		logger.info("Method : deleteDesignationDao ends");
		return response;
	}

	// ******************************Department*********************
	public ResponseEntity<JsonResponse<Object>> addDepartmentMasterDao(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addDepartmentMasterDao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addDepartmentParam(restHrMasterModel);

				if (restHrMasterModel.getDepartmentId() != null && restHrMasterModel.getDepartmentId() != "") {
					logger.info("if part: " + values);
					em.createNamedStoredProcedureQuery("hrdepartmentMaster")
							.setParameter("actionType", "modifyDepartment").setParameter("actionValue", values)
							.execute();
				} else {
					logger.info("Else part");
					em.createNamedStoredProcedureQuery("hrdepartmentMaster").setParameter("actionType", "addDepartment")
							.setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :addDepartmentMasterDao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewDepartmentDetails(String orgName, String orgDiv) {
		logger.info("Method : viewDepartmentDetails starts");

		List<RestHrMasterModel> dependent = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrdepartmentMaster")
					.setParameter("actionType", "viewdepartment").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel restHrMasterModel = new RestHrMasterModel(null, null, m[0], m[1], m[2], status, null,
						null, null, null, null, null, null, null, null);

				dependent.add(restHrMasterModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(dependent);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewDepartmentDetails ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteDepartment(String id,String orgName, String orgDiv) {
		logger.info("Method : deleteDepartment  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_departmentId='" + id + "', @p_orgName = '" + orgName + "', @p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("hrdepartmentMaster").setParameter("actionType", "deleteDepartment")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteDepartment ends");
		return response;
	}

	// Sub Department
	public ResponseEntity<JsonResponse<Object>> addSubDepartmentMaster(RestHrMasterModel restHrMasterModel) {
		logger.info("Method : addSubDepartmentMaster starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterReferenceHr.addSubDepartmentParam(restHrMasterModel);

				if (restHrMasterModel.getSubDepartmentId() != null && restHrMasterModel.getSubDepartmentId() != "") {
					logger.info("if part: " + values);
					em.createNamedStoredProcedureQuery("hrdepartmentMaster")
							.setParameter("actionType", "modifySubDepartment").setParameter("actionValue", values)
							.execute();
				} else {
					logger.info("Else part");
					em.createNamedStoredProcedureQuery("hrdepartmentMaster")
							.setParameter("actionType", "addSubDepartment").setParameter("actionValue", values)
							.execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :addSubDepartmentMaster ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrMasterModel>>> viewSubDepartmentDetails(String orgName,
			String orgDiv) {
		logger.info("Method : viewSubDepartmentDetails starts");

		List<RestHrMasterModel> dependent = new ArrayList<RestHrMasterModel>();

		try {
			String values = "SET @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrdepartmentMaster")
					.setParameter("actionType", "viewsubdepartment").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[4].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestHrMasterModel restHrMasterModel = new RestHrMasterModel(null, null, null, null, null, null, null,
						null, null, m[0], m[1], m[2], m[3], status, null);

				dependent.add(restHrMasterModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHrMasterModel>> resp = new JsonResponse<List<RestHrMasterModel>>();
		resp.setBody(dependent);
		ResponseEntity<JsonResponse<List<RestHrMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestHrMasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewSubDepartmentDetails ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteSubDepartment(String id, String org, String orgDiv) {

		logger.info("Method : deleteSubDepartment  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_subdepartmentId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("hrdepartmentMaster").setParameter("actionType", "deleteSubDepartment")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteSubDepartment ends");
		return response;
	}
	/*
	 * get shiftSubDepartment
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getshiftSubDepartment(String shiftDeptId,String orgName,String orgDivision) {

		logger.info("Method : getshiftSubDepartment starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_deptId='" + shiftDeptId + "',@p_org='"+orgName+"',@p_orgDiv='"+orgDivision+"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("HrShift")
					.setParameter("actionType", "getshiftSubDepartment").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}

			resp.setBody(nameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getshiftSubDepartment ends");
		
		logger.info("LISTTTT" + resp);
		return resp;
	}
	
	/*
	 *  getSubDeptTypeList
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getSubDeptTypeList( String orgName,@RequestParam String orgDivision) {

		logger.info("Method : getSubDeptTypeList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_org='"+orgName+"',@p_orgDiv='"+orgDivision+"';";
		logger.info(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrdepartmentMaster")
					.setParameter("actionType", "getSubDeptTypeList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}
			resp.setBody(nameList);
			if (nameList.size() > 0) {
				Util.setJsonResponse(resp, nameList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, nameList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getSubDeptTypeList ends");
		
		logger.info("LISTTTT" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSubDepartmentTypeForShiftType(String organization, @RequestParam String orgDivision) {
		// TODO Auto-generated method stub
		logger.info("Method : getSubDepartmentTypeForShiftType starts");
		List<DropDownModel> financialYr = new ArrayList<DropDownModel>();

		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("HrShift")
					.setParameter("actionType", "getSubDepartmentTypeForShiftType").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				financialYr.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSubDepartmentTypeForShiftType end");
		return financialYr;

	}
}