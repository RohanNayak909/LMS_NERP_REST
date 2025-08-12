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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeWorkLocation;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeWorkLocationModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestEmployeeWorkLocationDao {

	Logger logger = LoggerFactory.getLogger(RestAdvanceManagementDaoNew.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// employeeID list

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getemployeeList() {
		logger.info("Method : getemployeeList starts");

		List<DropDownModel> getemployeeList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeWorkLocation")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getemployeeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeList ends");

		return getemployeeList;
	}

	/*
	 * name list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getnameList(String id) {

		logger.info("Method : getnameList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_empId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeWorkLocation")
					.setParameter("actionType", "getnameList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}

			resp.setBody(nameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getnameList ends");

		logger.info("LISTTTT" + resp);
		return resp;
	}
	/*
	 * get employee list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getEmployeeList(String type,String orgName,String orgDivision) {

		logger.info("Method : getEmployeeList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_type='" + type + "',@p_org='"+orgName+"',@p_orgDiv='"+orgDivision+"';";
		logger.info(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeWorkLocation")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value).getResultList();
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

		logger.info("Method : getEmployeeList ends");
		
		logger.info("LISTTTT" + resp);
		return resp;
	}
	/**
	 * DAO Function to Add
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addworkLocation(RestEmployeeWorkLocationModel restPayroll) {
		logger.info("Method : Rest addworkLocation  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {

				String values = GenerateEmployeeWorkLocation.addEmployeeWorkLocationParam(restPayroll);
				logger.info("values-=====" + values);
				if (restPayroll.getLocId() == null || restPayroll.getLocId() == "") {

					em.createNamedStoredProcedureQuery("EmployeeWorkLocation")
							.setParameter("actionType", "addworkLocation").setParameter("actionValue", values)
							.execute();

				} else {
					logger.info("Modifyyy" + values);

					em.createNamedStoredProcedureQuery("EmployeeWorkLocation")
							.setParameter("actionType", "modifyworkLocation").setParameter("actionValue", values)
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

		logger.info("Method : Rest addworkLocation  Dao ends");

		logger.info("ADDDDDDDDDDD" + response);

		return response;
	}

	// view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestEmployeeWorkLocationModel>>> EmployeeWorkLocation(String org, String orgDiv) {
		logger.info("Method : viewEmployeeWorkLocation starts");
		List<RestEmployeeWorkLocationModel> respList = new ArrayList<RestEmployeeWorkLocationModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='"+orgDiv +"';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeWorkLocation")
					.setParameter("actionType", "viewEmployeeWorkLocation").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestEmployeeWorkLocationModel restPayroll = new RestEmployeeWorkLocationModel(m[0].toString(),
						m[1].toString(), m[2].toString(), m[3].toString(), m[4], m[5], m[6], m[7]);
				respList.add(restPayroll);

			}

			logger.info("respList" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestEmployeeWorkLocationModel>> resp = new JsonResponse<List<RestEmployeeWorkLocationModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestEmployeeWorkLocationModel>>> response = new ResponseEntity<JsonResponse<List<RestEmployeeWorkLocationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("VIEWWWWWW" + response);
		logger.info("Method : viewEmployeeWorkLocation ends");
		return response;

	}

	// edit apply

	@SuppressWarnings("unchecked")
	public JsonResponse<RestEmployeeWorkLocationModel> editEmployeeWorkLocation(String id) {
		logger.info("Method : editEmployeeWorkLocation dao starts");
		logger.info("Edit" + id);
		RestEmployeeWorkLocationModel req = new RestEmployeeWorkLocationModel();
		JsonResponse<RestEmployeeWorkLocationModel> resp = new JsonResponse<RestEmployeeWorkLocationModel>();
		try {
			String value = "SET @p_locId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeWorkLocation")
					.setParameter("actionType", "editEmployeeWorkLocation").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestEmployeeWorkLocationModel restPayroll = new RestEmployeeWorkLocationModel(m[0].toString(),
						m[1].toString(), m[2].toString(), m[3].toString(), m[4], m[5], m[6], m[7]);
				req = restPayroll;
			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("RestEmployeeWorkLocationModel" + resp);
		logger.info("Method : editEmployeeWorkLocation dao ends");
		return resp;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteEmployeeWorkLocation(String id) {
		logger.info("Method : deleteEmployeeWorkLocation starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_locId='" + id + "';";

				em.createNamedStoredProcedureQuery("EmployeeWorkLocation")
						.setParameter("actionType", "deleteEmployeeWorkLocation").setParameter("actionValue", value)
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

		logger.info("Method : deleteEmployeeWorkLocation ends");
		logger.info("DELETEE" + response);
		return response;
	}

}
