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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateSalaryRevisionPromotionParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestSalaryRevisionModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class SalaryRevisionDao {
	Logger logger = LoggerFactory.getLogger(SalaryRevisionDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFinancialYrForSalaryRevision(String organization, String orgDivision) {
		// TODO Auto-generated method stub
		logger.info("Method : getFinancialYrForSalaryRevision starts");
		List<DropDownModel> financialYr = new ArrayList<DropDownModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "getFinancialYrType").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				financialYr.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFinancialYrForSalaryRevision end");
		return financialYr;

	}

	// employeeID list
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getEmployeeList(String orgName, String orgDivision) {

		logger.info("Method : getEmployeeList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_organization='" + orgName + "',@P_orgDivision='" + orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}

			resp.setBody(nameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEmployeeList ends");

		return resp;
	}

	/*
	 * date list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDateList(String id) {

		logger.info("Method : getDateList starts");
		List<DropDownModel> jobList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_fy='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "getDateList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobList.add(dropDownModel);
			}

			resp.setBody(jobList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDateList ends");
		return resp;
	}

	// designation list

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDesignationDropDown(String organization, String orgDivision) {
		logger.info("Method : getDesignationDropDown starts");

		List<DropDownModel> getDesgList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "getDesignationDropDownList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDown = new DropDownModel(m[0], m[1]);
				getDesgList.add(dropDown);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDesignationDropDown ends");

		return getDesgList;
	}

	/**
	 * DAO Function to Add
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addsalaryrevision(RestSalaryRevisionModel salaryModel) {
		logger.info("Method : Rest addsalaryrevision  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String values = GenerateSalaryRevisionPromotionParameter.addSalaryRevisionParamNew(salaryModel);

				if (salaryModel.getEditId() == null || salaryModel.getEditId() == "") {
					em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
							.setParameter("actionType", "addsalaryrevision").setParameter("actionValue", values)
							.execute();
					resp.setCode("Success");
					resp.setMessage("Salary Added Successfully");
				} else {
					em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
							.setParameter("actionType", "modifysalaryrevision").setParameter("actionValue", values)
							.execute();
					resp.setCode("Success");
					resp.setMessage("Salary Modified Successfully");
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

		logger.info("Method : Rest addsalaryrevision  Dao ends");
		return response;
	}

	// view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>> viewSalaryMaster(String userid,
			String organization, String orgDivision,String id) {
		logger.info("Method : viewSalaryMaster starts");
		List<RestSalaryRevisionModel> respList = new ArrayList<RestSalaryRevisionModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='"
					+ orgDivision + "',@P_id='" + id + "';";
			logger.info("value==$$" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "viewSalaryMaster").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				for (Object obj : m) {
			      //  System.out.println(obj);  // Print each object followed by a space
			    }
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
						m[26].toString(), m[27].toString()/* , m[28], m[29].toString() */
						, date1 ,m[29] ,m[30].toString());
				respList.add(restPayroll);
			}

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

	// edit apply

//	@SuppressWarnings("unchecked")
//	public JsonResponse<RestSalaryRevisionModel> editSalaryRevision(String id) {
//		logger.info("Method : editSalaryRevision dao starts");
//		logger.info("Edit" + id);
//		RestSalaryRevisionModel req = new RestSalaryRevisionModel();
//		JsonResponse<RestSalaryRevisionModel> resp = new JsonResponse<RestSalaryRevisionModel>();
//		try {
//			String value = "SET @p_editId='" + id + "';";
//			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
//					.setParameter("actionType", "editSalaryRevision").setParameter("actionValue", value)
//					.getResultList();
//			for (Object[] m : x) {
//				Object date = null;
//				if (m[4] != null) {
//					date = DateFormatter.returnStringDate(m[4]);
//					date = date.toString();
//					logger.info("DATEEE" + date);
//				}
//
//				RestSalaryRevisionModel restPayroll = new RestSalaryRevisionModel(m[0], m[1], m[2], m[3], date, m[5],
//						m[6].toString(), m[7].toString(), m[8].toString(), m[9].toString(), m[10].toString(),
//						m[11].toString(), m[12].toString(), m[13].toString(),m[14].toString(), m[15].toString(), m[16].toString(), null, null, 
//						m[17].toString(),m[18].toString(),m[19].toString(),null);
//				req = restPayroll;
//
//			}
//			resp.setBody(req);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		logger.info("RestSalaryRevisionModel" + resp);
//		logger.info("Method : editSalaryRevision dao ends");
//		return resp;
//	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editSalaryRevision(String id) {
		logger.info("Method : editSalaryRevision Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			// String value = "SET @p_searchValue='" + id + "';";
			String value = "SET @p_editId='" + id + "';";
			System.out.println("Value========="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "editSalaryRevision").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editSalaryRevision Dao ends" + resp);
		return resp;
	}

	/*
	 * name And DesignationList list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getnameAndDesignationList(String id, String organization,
			String orgDivision) {

		logger.info("Method : getnameAndDesignationList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_empId='" + id + "',@P_organization='" + organization + "',@P_orgDivision='" + orgDivision
				+ "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "getnameAndDesignationList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				nameList.add(dropDownModel);
			}

			resp.setBody(nameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getnameAndDesignationList ends");

		return resp;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteSalaryRevision(String id, String organization,
			String orgDivision) {
		logger.info("Method : deleteSalaryRevision starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_editId='" + id + "',@P_organization='" + organization + "',@P_orgDivision='"
						+ orgDivision + "';";
				em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
						.setParameter("actionType", "deleteSalaryRevision").setParameter("actionValue", value)
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

		logger.info("Method : deleteSalaryRevision ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeptAndSubDept(String empid, String orgName,
			String orgDivision) {

		logger.info("Method : getDeptAndSubDept starts");

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> model = new ArrayList<DropDownModel>();

		String value = "SET @p_empid='" + empid + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision
				+ "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeassetassign")
					.setParameter("actionType", "getDeptAndSubDept").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getDeptAndSubDept ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> restBandCalculation(String band, String orgName, String orgDivision,String empid) {
		logger.info("Method : daoBandCalculation Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_band='" + band + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_empid='" + empid + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "bandCalculation").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : daoBandCalculation Dao ends");
		return resp;
	}

	public JsonResponse<Object> approveSalaryStatus(String id, String sts, String org, String orgDiv) {
		logger.info("Method : approveSalaryStatus Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			//String value = "SET @p_editId='" + id + "',@p_sts='" + sts + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv
			//		+ "';";
			String value = "SET @p_editId='(" + id + ")', @p_sts='" + sts + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			System.out.println("value======"+value);
			em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "approveSalaryStatus").setParameter("actionValue", value).execute();
			resp.setCode("success");
			if (sts.equals("1")) {
				resp.setMessage("Approved successfully");
			} else {
				resp.setMessage("Rejected successfully");
			}
		} catch (Exception e) {
			resp.setCode("unsuccess");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : approveSalaryStatus Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>> viewSalaryMasterByYear(String startDate,
			String endDate, String organization, String orgDivision, String id) {
		logger.info("Method : viewSalaryMasterByYear starts");
		List<RestSalaryRevisionModel> respList = new ArrayList<RestSalaryRevisionModel>();

		try {
			String value = "SET @P_startDate='" + startDate + "',@P_endDate='" + endDate + "',@P_organization='"
					+ organization + "',@P_orgDivision='" + orgDivision + "',@P_id='" + id + "';";
			System.out.println("value--"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "viewSalaryMasterbyYear").setParameter("actionValue", value)
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
						m[26].toString(), m[27].toString()/* , m[28], m[29].toString() */
						, date1 ,m[29] ,m[30].toString());
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestSalaryRevisionModel>> resp = new JsonResponse<List<RestSalaryRevisionModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>> response = new ResponseEntity<JsonResponse<List<RestSalaryRevisionModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewSalaryMasterByYear ends");
		return response;
	}

	/*
	 * Get all report data
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getReportAllData(String empId, String effectiveFromDate, String effectiveToDate, String organization,
			String orgDivision) {
		
		logger.info("Method : getReportAllData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "SET @p_empId='" + empId + "', @p_effectiveFromDate='" + DateFormatter.getStringDate(effectiveFromDate) + "', @p_effectiveToDate='" + DateFormatter.getStringDate(effectiveToDate)
				+ "', @p_orgDiv='" + orgDivision + "', @p_org='" + organization + "';";
System.out.println("value>>"+value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("SalaryRevisionPromotion")
					.setParameter("actionType", "getSarayRevisionPDF").setParameter("actionValue", value)
					.getResultList();

			Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
		}

		logger.info("Method : getReportAllData Dao ends");

		return resp;

	}

}
