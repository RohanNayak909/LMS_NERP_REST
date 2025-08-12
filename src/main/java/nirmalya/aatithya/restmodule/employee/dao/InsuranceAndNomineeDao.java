package nirmalya.aatithya.restmodule.employee.dao;

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

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.InsuranceAndNomineeParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.InsuranceAndNomineeRestModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.PushNotification;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class InsuranceAndNomineeDao {
	Logger logger = LoggerFactory.getLogger(InsuranceAndNomineeDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	PushNotification pushNotification = new PushNotification();

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InsuranceAndNomineeRestModel>>> viewInsuranceAndNominee(String userId,
			String organization, String orgDivision) {
		logger.info("Method : viewInsuranceAndNominee starts");
		List<InsuranceAndNomineeRestModel> respList = new ArrayList<InsuranceAndNomineeRestModel>();

		try {
			String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\""
					+ orgDivision + "\";";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
					.setParameter("actionType", "viewInsuranceAndNominee").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date1 = null;
				if (m[4] != null) {
					date1 = m[4].toString();
				}

				InsuranceAndNomineeRestModel restPayroll = new InsuranceAndNomineeRestModel(m[0].toString(),
						m[1].toString(), m[2], m[3].toString(), date1, m[5], m[6], m[7], m[8]);
				respList.add(restPayroll);

			}

			logger.info("respList" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<InsuranceAndNomineeRestModel>> resp = new JsonResponse<List<InsuranceAndNomineeRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<InsuranceAndNomineeRestModel>>> response = new ResponseEntity<JsonResponse<List<InsuranceAndNomineeRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewInsuranceAndNominee ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<InsuranceAndNomineeRestModel>> viewEmpDetails(String userid) {
		logger.info("Method : viewEmpDetails  Dao starts");

		List<InsuranceAndNomineeRestModel> viewempDetails = new ArrayList<InsuranceAndNomineeRestModel>();

		JsonResponse<List<InsuranceAndNomineeRestModel>> resp = new JsonResponse<List<InsuranceAndNomineeRestModel>>();
		try {
			String value = "SET @p_empid=\"" + userid + "\";";
			logger.info("VIEWW" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
					.setParameter("actionType", "viewEmpDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object date1 = null;
				if (m[2] != null) {
					date1 = DateFormatter.returnStringDate(m[2]);
				}
				InsuranceAndNomineeRestModel insurance = new InsuranceAndNomineeRestModel(m[0].toString(), m[1], date1,
						m[3], m[4], m[5]);

				viewempDetails.add(insurance);
			}
			if (viewempDetails.size() > 0) {
				resp.setBody(viewempDetails);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(viewempDetails);
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("viewLeaveApply: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(viewempDetails);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());

		}

		resp.setBody(viewempDetails);
		logger.info("REEESSSPPP===" + resp);
		logger.info("Method : viewEmpDetails  Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InsuranceAndNomineeRestModel>> saveEmployeeDtls(
			InsuranceAndNomineeRestModel employee) {
		logger.info("Method : saveEmployeeDtls starts");
		JsonResponse<InsuranceAndNomineeRestModel> resp = new JsonResponse<InsuranceAndNomineeRestModel>();
		logger.info("employee=======" + employee);
		try {
			String values = InsuranceAndNomineeParam.getAddInsuranceParam(employee);
			logger.info("values=======" + values);
			if (employee.getDclrId() == null || employee.getDclrId() == "" || employee.getDclrId() == "null") {
				logger.info("ADDDDD" + employee.getDclrId());
				List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
						.setParameter("actionType", "saveInsuranceDeclaration").setParameter("actionValue", values)
						.getResultList();
				for (Object[] m : x) {
					logger.info("x===" + Arrays.toString(m));
					InsuranceAndNomineeRestModel Model = new InsuranceAndNomineeRestModel(m[0], m[1]);
					logger.info("InsuranceAndNomineeRestModel===" + Model);
					resp.setBody(Model);
					Util.setJsonResponse(resp, null, ResponseStatus.success, "Information saved scuccessfully.");
				}

			}

			else {
				logger.info("Modifyy" + employee.getDclrId());
				List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
						.setParameter("actionType", "modifyInsuranceDeclaration").setParameter("actionValue", values)
						.getResultList();
				for (Object[] m : x) {
					logger.info("x===" + Arrays.toString(m));
					InsuranceAndNomineeRestModel Model = new InsuranceAndNomineeRestModel(m[0], m[1]);
					logger.info("InsuranceAndNomineeRestModel===" + Model);
					resp.setBody(Model);
					Util.setJsonResponse(resp, null, ResponseStatus.success, "Information saved scuccessfully.");

				}
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
		ResponseEntity<JsonResponse<InsuranceAndNomineeRestModel>> response = new ResponseEntity<JsonResponse<InsuranceAndNomineeRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveEmployeeDtls ends");
		logger.info("ADDDDD===" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InsuranceAndNomineeRestModel>>> viewInsuranceDeclaration(String userId,
			String organization, String orgDivision) {
		logger.info("Method : viewInsuranceDeclaration starts");
		List<InsuranceAndNomineeRestModel> respList = new ArrayList<InsuranceAndNomineeRestModel>();

		try {
			String value = "SET @p_empId='" + userId + "';";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
					.setParameter("actionType", "viewInsuranceDeclaration").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date1 = null;
				if (m[3] != null) {
					date1 = DateFormatter.returnStringDate(m[3]);
				}

				InsuranceAndNomineeRestModel restPayroll = new InsuranceAndNomineeRestModel(m[0], m[1], m[2], date1,
						m[4]);
				respList.add(restPayroll);

			}

			logger.info("respList" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<InsuranceAndNomineeRestModel>> resp = new JsonResponse<List<InsuranceAndNomineeRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<InsuranceAndNomineeRestModel>>> response = new ResponseEntity<JsonResponse<List<InsuranceAndNomineeRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewInsuranceDeclaration ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> nameList(String userId) {
		logger.info("Method : nameList starts");

		List<DropDownModel> nameList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_empId='" + userId + "';";
			logger.info("EMPIDDDDD" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
					.setParameter("actionType", "nameList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("NAMEEELIST" + nameList);
		logger.info("Method : nameList ends");
		return nameList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> viewDobRelation(String id) {

		logger.info("Method : viewDobRelation starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_empId='" + id + "';";
		logger.info("value==" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
					.setParameter("actionType", "viewDobRelation").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object date = null;
				if (m[0] != null) {
					date = DateFormatter.returnStringDate(m[0]);
					date = date.toString();
				}
				DropDownModel dropDownModel = new DropDownModel(date, m[1]);
				nameList.add(dropDownModel);
			}

			resp.setBody(nameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewDobRelation ends");

		logger.info("LISTTTT" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InsuranceAndNomineeRestModel>> saveNomineeDetails(
			InsuranceAndNomineeRestModel employee) {
		logger.info("Method : saveNomineeDetails starts");
		JsonResponse<InsuranceAndNomineeRestModel> resp = new JsonResponse<InsuranceAndNomineeRestModel>();
		logger.info("employee=======" + employee);
		try {
			String values = InsuranceAndNomineeParam.getAddInsuranceNomineeParam(employee);
			logger.info("values=======" + values);
			if (employee.getNomId() == null || employee.getNomId() == "" || employee.getNomId() == "null") {
				List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
						.setParameter("actionType", "saveNomineeDetail").setParameter("actionValue", values)
						.getResultList();
				for (Object[] m : x) {
					logger.info("x===" + Arrays.toString(m));
					InsuranceAndNomineeRestModel Model = new InsuranceAndNomineeRestModel(m[0], m[1]);
					logger.info("InsuranceAndNomineeRestModel===" + Model);
					resp.setBody(Model);
					Util.setJsonResponse(resp, null, ResponseStatus.success, "Information saved scuccessfully.");
				}

			} else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
						.setParameter("actionType", "modifyNomineeDetail").setParameter("actionValue", values)
						.getResultList();
				for (Object[] m : x) {
					logger.info("x===" + Arrays.toString(m));
					InsuranceAndNomineeRestModel Model = new InsuranceAndNomineeRestModel(m[0], m[1]);
					logger.info("InsuranceAndNomineeRestModel===" + Model);
					resp.setBody(Model);
					Util.setJsonResponse(resp, null, ResponseStatus.success, "Information saved scuccessfully.");
				}
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
		ResponseEntity<JsonResponse<InsuranceAndNomineeRestModel>> response = new ResponseEntity<JsonResponse<InsuranceAndNomineeRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveNomineeDetails ends");
		logger.info("ADDDDD===" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InsuranceAndNomineeRestModel>>> viewInsuranceNomineeDetails(String userId,
			String organization, String orgDivision) {
		logger.info("Method : viewInsuranceNomineeDetails starts");
		List<InsuranceAndNomineeRestModel> respList = new ArrayList<InsuranceAndNomineeRestModel>();

		try {
			String value = "SET @p_insuId='" + userId + "';";

			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
					.setParameter("actionType", "viewInsuranceNomineeDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date1 = null;
				if (m[2] != null) {
					date1 = DateFormatter.returnStringDate(m[2]);
				}

				InsuranceAndNomineeRestModel restPayroll = new InsuranceAndNomineeRestModel(m[0], m[1], date1, m[3],
						m[4].toString(), null, null, m[5].toString());
				respList.add(restPayroll);

			}

			logger.info("respList" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<InsuranceAndNomineeRestModel>> resp = new JsonResponse<List<InsuranceAndNomineeRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<InsuranceAndNomineeRestModel>>> response = new ResponseEntity<JsonResponse<List<InsuranceAndNomineeRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewInsuranceNomineeDetails ends");
		return response;

	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteDeclaration(String id) {
		logger.info("Method : deleteDeclaration starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_dclrId='" + id + "';";
				em.createNamedStoredProcedureQuery("insuranceAndNominee")
						.setParameter("actionType", "deleteDeclaration").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteDeclaration ends");
		logger.info("DELETEE" + response);
		return response;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteNominee(String id) {
		logger.info("Method : deleteNominee starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_nomId='" + id + "';";
				em.createNamedStoredProcedureQuery("insuranceAndNominee").setParameter("actionType", "deleteNominee")
						.setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteNominee ends");
		logger.info("DELETEE" + response);
		return response;
	}

	// Work InsuranceAndNomineeRestModel Edit

	@SuppressWarnings("unchecked")
	public JsonResponse<InsuranceAndNomineeRestModel> editDeclaration(String id, String organization,
			String orgDivision) {
		logger.info("Method : editWorkDetails dao starts");
		InsuranceAndNomineeRestModel req = new InsuranceAndNomineeRestModel();
		JsonResponse<InsuranceAndNomineeRestModel> resp = new JsonResponse<InsuranceAndNomineeRestModel>();
		try {

			String value = "SET @p_dclrId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
					.setParameter("actionType", "editDeclaration").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object date1 = null;
				if (m[2] != null) {
					date1 = DateFormatter.returnStringDate(m[2]);
					date1 = date1.toString();
				}

				InsuranceAndNomineeRestModel restWorkDetails = new InsuranceAndNomineeRestModel(m[0], null, m[1], date1,
						m[3]);
				req = restWorkDetails;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("editDeclaration" + resp);
		logger.info("Method : editDeclaration dao ends");
		return resp;
	}

	// Work InsuranceAndNomineeRestModel Edit
	@SuppressWarnings("unchecked")
	public JsonResponse<InsuranceAndNomineeRestModel> editNominee(String id, String organization, String orgDivision) {
		logger.info("Method : editNominee dao starts");
		InsuranceAndNomineeRestModel req = new InsuranceAndNomineeRestModel();
		JsonResponse<InsuranceAndNomineeRestModel> resp = new JsonResponse<InsuranceAndNomineeRestModel>();
		try {

			String value = "SET @p_nomId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
					.setParameter("actionType", "editNominee").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object date1 = null;
				if (m[2] != null) {
					date1 = DateFormatter.returnStringDate(m[2]);
					date1 = date1.toString();
				}
				InsuranceAndNomineeRestModel restWorkDetails = new InsuranceAndNomineeRestModel(m[0], m[1], date1, m[3],
						m[4].toString(), null, null, null);
				req = restWorkDetails;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("editNominee" + resp);
		logger.info("Method : editNominee dao ends");
		return resp;
	}

	// check new Available

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>> checkNewAvailable(String userId, String financialYear,
			String organization, String orgDivision) {
		logger.info("Method : checkNewAvailable starts");

		DropDownModel pf = new DropDownModel();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		String value = "SET @p_empId='" + userId + "';";
		logger.info("VALUEEEEEEEE----" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
					.setParameter("actionType", "checkNewAvailable").setParameter("actionValue", value).getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.failed, ApiResponseMessage.NO_DATA_FOUND);
			}

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString(), null);
				pf = dropDownModel;

				if (dropDownModel.equals("")) {
					resp.setBody(dropDownModel);
					resp.setCode("failed");
					resp.setMessage("Data not found");
				} else {
					resp.setBody(dropDownModel);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}

			}
			resp.setBody(pf);
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("checkEditAvailable: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(pf);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				responseHeaders, HttpStatus.CREATED);
		logger.info("Method : checkNewAvailable ends");
		logger.info("VIEWCHECKKKK" + response);
		return response;
	}

	/*
	 * getDeclareName
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDeclareName(String insuId, String orgName,String orgDivision) {
		logger.info("Method : getDeclareName starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_insuId='" + insuId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("insuranceAndNominee")
					.setParameter("actionType", "getDeclareName").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}
			resp.setBody(nameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDeclareName ends");
		logger.info("LISTTTT" + resp);
		return resp;
	}
}
