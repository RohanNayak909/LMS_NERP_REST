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
import nirmalya.aatithya.restmodule.common.utils.GenerateDeputizationAdd;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestDeputizationModel;

@Repository
public class DeputizationRestDao {
	
	Logger logger = LoggerFactory.getLogger(DeputizationRestDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFinancialYrForDeputization() {
		// TODO Auto-generated method stub
		logger.info("Method : getFinancialYrForDeputization starts");
		List<DropDownModel> financialYr = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("DeputizationRoutine")
					.setParameter("actionType", "getFinancialYearType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				logger.info("dropDownModel@@@@@@@@@@@@@@@@" + dropDownModel);
				financialYr.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFinancialYrForDeputization end");
		return financialYr;

	}

	// employeeID list

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDeputizationEmployeeList() {
		logger.info("Method : getDeputizationEmployeeList starts");

		List<DropDownModel> getRequisitionList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("DeputizationRoutine")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				logger.info("dropDownModel@@@@@@@@@@@@@@@@" + dropDownModel);
				getRequisitionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDeputizationEmployeeList ends");

		return getRequisitionList;
	}

	/*
	 * date list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDateListDeputization(String id) {

		logger.info("Method : getDateListDeputization"
				+ " starts");
		List<DropDownModel> jobList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_fy='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeputizationRoutine")
					.setParameter("actionType", "getDateListDeputization").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobList.add(dropDownModel);
			}
			
			resp.setBody(jobList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDateListDeputization ends");
		logger.info("LISTTTT" + resp);
		return resp;
	}

	
	
	
	/**
	 * DAO Function to Add
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> adddeputization(RestDeputizationModel restPayroll) {
		logger.info("Method : Rest adddeputization  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
logger.info( "ADDDDDDID"+ restPayroll.getEditId() );
		if (validity)
			try {

				String values = GenerateDeputizationAdd.addDeputizationParam(restPayroll);

				if (restPayroll.getEditId() == null || restPayroll.getEditId() == "") {

					em.createNamedStoredProcedureQuery("DeputizationRoutine")
							.setParameter("actionType", "adddeputization").setParameter("actionValue", values)
							.execute();

				} else {
             logger.info("MODIFYYYYYYY"+restPayroll.getEditId());
             logger.info("VALUEEEEE"+values);
					em.createNamedStoredProcedureQuery("DeputizationRoutine")
							.setParameter("actionType", "modifydeputization").setParameter("actionValue", values)
							.execute();
				}
				logger.info("VALUEEEEE"+values);
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

		logger.info("Method : Rest adddeputization  Dao ends");

		logger.info("ADDDDDDDDDDD" + response);

		return response;
	}

	/*
	 * // view
	 * 
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<RestDeputizationModel>>> viewdeputization()
	 * { logger.info("Method : viewdeputization starts");
	 * List<RestDeputizationModel> respList = new
	 * ArrayList<RestDeputizationModel>();
	 * 
	 * try { //String value = "SET @P_userId='" + userid + "';";
	 * //logger.info("value=="+value); List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("DeputizationRoutine")
	 * .setParameter("actionType", "viewdeputization").setParameter("actionValue",
	 * "").getResultList();
	 * 
	 * for (Object[] m : x) { Object date = null; if (m[4] != null) { date =
	 * m[4].toString(); } RestDeputizationModel restPayroll = new
	 * RestDeputizationModel(m[0], m[1], m[2], m[3], date, m[5], m[6].toString(),
	 * m[7].toString(), m[8].toString(), m[9].toString(), m[10].toString());
	 * respList.add(restPayroll);
	 * 
	 * }
	 * 
	 * logger.info("respList" + respList);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * JsonResponse<List<RestDeputizationModel>> resp = new
	 * JsonResponse<List<RestDeputizationModel>>(); resp.setBody(respList);
	 * ResponseEntity<JsonResponse<List<RestDeputizationModel>>> response = new
	 * ResponseEntity<JsonResponse<List<RestDeputizationModel>>>( resp,
	 * HttpStatus.CREATED); logger.info("response" + response);
	 * logger.info("Method : viewdeputization ends"); return response;
	 * 
	 * }
	 */

	
	// view

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestDeputizationModel>>> viewdeputization() {
			logger.info("Method : viewdeputization starts");
			List<RestDeputizationModel> respList = new ArrayList<RestDeputizationModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("DeputizationRoutine")
						.setParameter("actionType", "viewdeputization").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					Object date = null;
					Object date1=null;
					if (m[2] != null) {
						date = m[2].toString();					
					}
					if (m[3] !=null  ) {
						date1 = m[3].toString();	
					}
					
					
					RestDeputizationModel restPayroll = new RestDeputizationModel(m[0], m[1], date, date1,m[4], m[5],
							m[6], m[7], m[8], m[9], m[10]);
					respList.add(restPayroll);

				}

				logger.info("respList" + respList);

			} catch (Exception e) {

				e.printStackTrace();

			}

			JsonResponse<List<RestDeputizationModel>> resp = new JsonResponse<List<RestDeputizationModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestDeputizationModel>>> response = new ResponseEntity<JsonResponse<List<RestDeputizationModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("response" + response);
			logger.info("Method : viewdeputization ends");
			return response;

		}
	
	
	// edit apply
	
	@SuppressWarnings("unchecked")
	public JsonResponse<RestDeputizationModel> editDeputization(String id) {
		logger.info("Method : editDeputization dao starts");
logger.info("Edit"+id);
RestDeputizationModel req = new RestDeputizationModel();
		JsonResponse<RestDeputizationModel> resp = new JsonResponse<RestDeputizationModel>();
		try {
			String value = "SET @p_editId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeputizationRoutine")
					.setParameter("actionType", "editDeputization").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				/*
				 * Object date = null; Object date1=null; if (m[2] != null) { date =
				 * DateFormatter.returnStringDate(m[2]); date = date.toString();
				 * 
				 * } if (m[3] != null) { date1 = DateFormatter.returnStringDate(m[3]); date1 =
				 * date1.toString();
				 * 
				 * }
				 */
				
				RestDeputizationModel restPayroll = new RestDeputizationModel(m[0], m[1],m[2].toString(),m[3].toString(),m[4], m[5],
						m[6], m[7], m[8], m[9], m[10]);
				req=restPayroll;
				
			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("editDeputization" + resp);
		logger.info("Method : editDeputization dao ends");
		return resp;
	}
	

/*
	 * name And DesignationList list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getnameAndDesignationListDeputization(String id) {

		logger.info("Method : getnameAndDesignationList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_empId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeputizationRoutine")
					.setParameter("actionType", "getnameAndDesignationList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}

			resp.setBody(nameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getnameAndDesignationListDeputization ends");
		
		logger.info("LISTTTT" + resp);
		return resp;
	}



	// delete

	public ResponseEntity<JsonResponse<Object>> deleteDeputization(String id) {
		logger.info("Method : deleteSalaryRevision starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_editId='" + id + "';";

				em.createNamedStoredProcedureQuery("DeputizationRoutine")
						.setParameter("actionType", "deleteDeputization").setParameter("actionValue", value)
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

		logger.info("Method : deleteDeputization ends");
		logger.info("DELETEE" + response);
		return response;
	}

}
