package nirmalya.aatithya.restmodule.employee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateTravelClaimOtherParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateTravelManagementParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.TravelClaimRestModel;
import nirmalya.aatithya.restmodule.employee.model.TravelRequisitionRestModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class TravelClaimRestDao {
	Logger logger = LoggerFactory.getLogger(TravelRequsitionRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager entityManager;

	@Autowired
	EnvironmentVaribles env;

	/*
	 * view travel claim employee list data
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<TravelClaimRestModel>> viewTravelClaim(String userId, String userRole, String organization,
			String orgDivision) {
		logger.info("Method : viewTravelClaim starts");
		JsonResponse<List<TravelClaimRestModel>> resp = new JsonResponse<List<TravelClaimRestModel>>();
		List<TravelClaimRestModel> viewTravelClaim = new ArrayList<TravelClaimRestModel>();

		try {
			String value = "SET @p_empId=\"" + userId + "\",@p_userRole='(" + userRole + ")',@p_org=\"" + organization
					+ "\",@p_orgDiv=\"" + orgDivision + "\";";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("travelClaimRoutines")
					.setParameter("actionType", "viewTravelClaim").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object sDate = null;
				if (m[7] != null) {
					sDate = DateFormatter.returnStringDate(m[7]);
				}
				Object Date = null;
				if (m[8] != null) {
					Date = DateFormatter.returnStringDate(m[8]);
				}
				TravelClaimRestModel travelModel = new TravelClaimRestModel(m[0], m[1], m[2], m[3], m[4].toString(),
						m[5].toString(), m[6].toString(), sDate, Date, m[9], m[10], m[11], m[12]);
				viewTravelClaim.add(travelModel);
			}
			Util.setJsonResponse(resp, viewTravelClaim, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			Util.setJsonResponse(resp, viewTravelClaim, ResponseStatus.success, ApiResponseMessage.DATA_FECTH_FAILED);
			e.printStackTrace();
			logger.error("viewTravelClaim: " + e.getMessage());
		}
		resp.setBody(viewTravelClaim);
		logger.info("Method : viewTravelClaim ends" + resp);
		return resp;
	}

	/*
	 * view travel claim edit
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<TravelClaimRestModel>> getTravelClaimEdit(String id) {
		logger.info("Method : getTravelEdit starts");
		List<TravelClaimRestModel> viewTravelClaim = new ArrayList<TravelClaimRestModel>();
		JsonResponse<List<TravelClaimRestModel>> resp = new JsonResponse<List<TravelClaimRestModel>>();
		try {
			String values = "SET @P_ser='" + id + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("travelClaimRoutines")
					.setParameter("actionType", "getTravelClaimEdit").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object fromDate = null;
				if (m[5] != null) {
					fromDate = DateFormatter.returnStringDate(m[5]);
					fromDate = fromDate.toString();
				}
				Object toDate = null;
				if (m[6] != null) {
					toDate = DateFormatter.returnStringDate(m[6]);
					toDate = toDate.toString();
				}

				TravelClaimRestModel travelModel = new TravelClaimRestModel(m[0], m[1], m[2], m[3].toString(), m[4],
						fromDate, toDate, null, m[7], m[8], m[9], m[10], m[11], m[12]);
				viewTravelClaim.add(travelModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getTravelClaimEdit: " + e.getMessage());
		}
		resp.setBody(viewTravelClaim);
		logger.info("Method : getTravelEdit ends" + resp);

		return resp;
	}

	/*
	 * add travel claim
	 */
	public ResponseEntity<JsonResponse<Object>> addTravelClaimOther(TravelClaimRestModel travelClaimRestModel) {
		logger.info("Method : Rest addTravelClaimOther Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateTravelClaimOtherParameter.getTavelClaimData(travelClaimRestModel);

				if (travelClaimRestModel.getItemId() != null && travelClaimRestModel.getItemId() != "") {
					em.createNamedStoredProcedureQuery("travelClaimRoutines")
							.setParameter("actionType", "modifyClaimOtherData").setParameter("actionValue", values)
							.execute();
					resp.setCode("Claim Modified Succesfuly");

				} else {
					em.createNamedStoredProcedureQuery("travelClaimRoutines")
							.setParameter("actionType", "addClaimOtherData").setParameter("actionValue", values)
							.execute();
					resp.setCode("Claim Added Succesfuly");
				}

			} catch (Exception e) {
				logger.error("addTravelClaimOther: " + e.getMessage());
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
		logger.info("Method : Rest addTravelClaimOther Dao ends");

		return response;
	}
//
	//
	/*
	 * view travel employee other
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<TravelClaimRestModel>> viewTravelClaimOther(String id) {
		logger.info("Method : viewTravelClaimOther starts");
		List<TravelClaimRestModel> viewTravelClaim = new ArrayList<TravelClaimRestModel>();
		JsonResponse<List<TravelClaimRestModel>> resp = new JsonResponse<List<TravelClaimRestModel>>();
		try {
			String values = "SET @P_ser='" + id + "';";
			logger.info("values@@@@==" + values);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("travelClaimRoutines")
					.setParameter("actionType", "getClaimOtherData").setParameter("actionValue", values)
					.getResultList();
			if (x.size() > 0) {
				for (Object[] m : x) {

					Object date = null;
					if (m[3] != null) {
						date = DateFormatter.returnStringDate(m[3]);
						date = date.toString();
					}
					String bill = null;
					if (m[5] != null && m[5] != "" && m[5] != " " && !m[5].toString().equals(" ")
							&& !m[5].toString().equals(null) && !m[5].toString().equals("")) {
						bill = env.getMobileView() + "document/document/" + m[5].toString();
					} else {
						bill = "";
					}
					TravelClaimRestModel travelModel = new TravelClaimRestModel(m[0].toString(), m[1], m[2], date, m[4],
							bill, m[5], m[6], m[8]);
					viewTravelClaim.add(travelModel);
					Util.setJsonResponse(resp, viewTravelClaim, ResponseStatus.success,
							ApiResponseMessage.DATA_FETCH_SUCCESS);

				}
			} else {
				Util.setJsonResponse(resp, viewTravelClaim, ResponseStatus.failed, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("viewTravelClaimOther: " + e.getMessage());
		}
		resp.setBody(viewTravelClaim);
		logger.info("Method : viewTravelClaimOther ends");
		logger.info("viewTravelClaimOther resp===================" + resp);
		return resp;
	}

	/*
	 * add travel claim Api
	 */

	public ResponseEntity<JsonResponse<Object>> addTravelClaimOtherApiDao(TravelClaimRestModel travelClaimRestModel) {
		logger.info("Method : Rest addTravelClaimOtherApiDao Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (travelClaimRestModel.getDate() != "" && travelClaimRestModel.getDate() != null) {
			travelClaimRestModel.setDate(DateFormatter.getStringDate(travelClaimRestModel.getDate()));
		}

		if (validity) {
			try {
				String values = GenerateTravelClaimOtherParameter.getTavelClaimData(travelClaimRestModel);

				System.out.println("values>>>>>>>>>>" + values);

				if (travelClaimRestModel.getItemId() != null && travelClaimRestModel.getItemId() != "") {
					em.createNamedStoredProcedureQuery("travelClaimRoutines")
							.setParameter("actionType", "modifyClaimOtherData").setParameter("actionValue", values)
							.execute();
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.MODIFIED_SUCCESSFULLY);

				} else {
					em.createNamedStoredProcedureQuery("travelClaimRoutines")
							.setParameter("actionType", "addClaimOtherData").setParameter("actionValue", values)
							.execute();
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPLOADED_SUCCESSFULLY);

				}

			} catch (Exception e) {
				logger.error("addTravelClaimOther: " + e.getMessage());
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
		logger.info("Method : Rest addTravelClaimOtherApiDao Dao ends");

		return response;
	}

	/*
	 * view travel claim edit
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<TravelClaimRestModel>> travelClaimOtherEdit(String id) {
		logger.info("Method : getTravelEdit starts");
		List<TravelClaimRestModel> viewTravelClaim = new ArrayList<TravelClaimRestModel>();
		JsonResponse<List<TravelClaimRestModel>> resp = new JsonResponse<List<TravelClaimRestModel>>();
		try {
			String values = "SET @P_itemId='" + id + "';";
			System.out.println("values=====" + values);

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("travelClaimRoutines")
					.setParameter("actionType", "getClaimOtherEdit").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object date = null;
				if (m[3] != null) {
					date = DateFormatter.returnStringDate(m[3]);
					date = date.toString();
				}

				TravelClaimRestModel travelModel = new TravelClaimRestModel(m[0].toString(), m[1], m[2], date, m[4],
						m[5], m[6], null, m[7]);
				viewTravelClaim.add(travelModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("travelClaimOtherEdit: " + e.getMessage());
		}
		resp.setBody(viewTravelClaim);
		logger.info("Method : getTravelEdit ends");

		return resp;
	}

	/*
	 * Delete Travel Claim
	 */
	public JsonResponse<TravelClaimRestModel> deleteTravelClaimOther(String id) {
		logger.info("Method : deleteTravelClaimOther dao starts");
		TravelClaimRestModel req = new TravelClaimRestModel();
		JsonResponse<TravelClaimRestModel> resp = new JsonResponse<TravelClaimRestModel>();

		try {

			String value = "SET @p_itemId='(" + id + ")';";
			em.createNamedStoredProcedureQuery("travelClaimRoutines").setParameter("actionType", "deleteClaimOtherData")
					.setParameter("actionValue", value).execute();

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("deleteTravelClaimOther: " + e.getMessage());
		}
		logger.info("Method : deleteTravelClaimOther dao ends" + resp);
		return resp;
	}

	/*
	 * add travel claim status
	 */
	public ResponseEntity<JsonResponse<Object>> addTravelClaimStatus(TravelClaimRestModel travelClaimRestModel) {
		logger.info("Method : Rest addTravelClaimOther Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateTravelClaimOtherParameter.getTavelClaimStatus(travelClaimRestModel);
			
				if (travelClaimRestModel.getTravelingReqId() != null
						&& travelClaimRestModel.getTravelingReqId() != "") {
					em.createNamedStoredProcedureQuery("travelClaimRoutines")
							.setParameter("actionType", "modifyClaimStatus").setParameter("actionValue", values)
							.execute();
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.STATUS_CHANGED);
				}

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UNKNOWN_EXCEPTION);
				} catch (Exception e1) {
					e1.printStackTrace();
					logger.error("addTravelClaimStatus: " + e.getMessage());
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UNKNOWN_EXCEPTION);
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest addTravelClaimOther Dao ends" + response);

		return response;
	}

	/*
	 * view travel claim employee list api
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<TravelClaimRestModel>> viewTravelClaimApi(String userId, String organization,
			String orgDivision) {
		logger.info("Method : viewTravelClaimApi starts");
		JsonResponse<List<TravelClaimRestModel>> resp = new JsonResponse<List<TravelClaimRestModel>>();
		List<TravelClaimRestModel> viewTravelClaim = new ArrayList<TravelClaimRestModel>();

		try {
			String value = "SET @p_empId=\"" + userId + "\",@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision
					+ "\";";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("travelClaimRoutines")
					.setParameter("actionType", "viewTravelClaimApi").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object sDate = null;
				if (m[7] != null) {
					sDate = DateFormatter.returnStringDate(m[7]);
				}
				Object Date = null;
				if (m[8] != null) {
					Date = DateFormatter.returnStringDate(m[8]);
				}
				TravelClaimRestModel travelModel = new TravelClaimRestModel(m[0], m[1], m[2], m[3], m[4].toString(),
						m[5].toString(), m[6].toString(), sDate, Date, m[9], m[10], m[11], m[12]);
				viewTravelClaim.add(travelModel);
			}
			Util.setJsonResponse(resp, viewTravelClaim, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			Util.setJsonResponse(resp, viewTravelClaim, ResponseStatus.success, ApiResponseMessage.DATA_FECTH_FAILED);
			e.printStackTrace();
			logger.error("viewTravelClaimApi: " + e.getMessage());
		}
		resp.setBody(viewTravelClaim);
		logger.info("Method : viewTravelClaimApi ends" + resp);
		return resp;
	}

//edit other service Api
	@SuppressWarnings("unchecked")
	public JsonResponse<List<TravelClaimRestModel>> editOtherServiceApi(String id) {
		logger.info("Method : editOtherServiceApi starts");

		List<TravelClaimRestModel> viewTravelClaim = new ArrayList<TravelClaimRestModel>();
		JsonResponse<List<TravelClaimRestModel>> resp = new JsonResponse<List<TravelClaimRestModel>>();

		try {
			String value = "SET @P_Id='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("travelClaimRoutines")
					.setParameter("actionType", "editOtherServiceApi").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object date = null;
				if (m[3] != null) {
					date = DateFormatter.returnStringDate(m[3]);
					date = date.toString();
				}

				TravelClaimRestModel travelModel = new TravelClaimRestModel(m[0].toString(), m[1], m[2], date, m[4],
						m[5], m[6], m[7], m[8]);
				viewTravelClaim.add(travelModel);
			}
			if (viewTravelClaim.size() > 0) {
				Util.setJsonResponse(resp, viewTravelClaim, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
				System.out.println("respresp====" + resp);
			} else {
				Util.setJsonResponse(resp, viewTravelClaim, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		resp.setBody(viewTravelClaim);
		logger.info("Method : editOtherServiceApi Dao ends");
		logger.info("VIEWRESP====" + resp);
		return resp;
	}

//editTravelClaim Api
	@SuppressWarnings("unchecked")
	public JsonResponse<List<TravelClaimRestModel>> editTravelClaimApi(String id) {
		logger.info("Method : editTravelClaimApi starts");

		List<TravelClaimRestModel> viewTravelClaim = new ArrayList<TravelClaimRestModel>();
		JsonResponse<List<TravelClaimRestModel>> resp = new JsonResponse<List<TravelClaimRestModel>>();

		try {
			String value = "SET @P_Id='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("travelClaimRoutines")
					.setParameter("actionType", "editTravelClaimApi").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object fromDate = null;
				if (m[5] != null) {
					fromDate = DateFormatter.returnStringDate(m[5]);
					fromDate = fromDate.toString();
				}
				Object toDate = null;
				if (m[6] != null) {
					toDate = DateFormatter.returnStringDate(m[6]);
					toDate = toDate.toString();
				}

				TravelClaimRestModel travelModel = new TravelClaimRestModel(m[0], m[1], m[2], m[3].toString(), m[4],
						fromDate, toDate, null, m[7], m[8], m[9], m[10], m[11], m[12]);
				viewTravelClaim.add(travelModel);

			}
			if (viewTravelClaim.size() > 0) {
				Util.setJsonResponse(resp, viewTravelClaim, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
				System.out.println("respresp====" + resp);
			} else {
				Util.setJsonResponse(resp, viewTravelClaim, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		resp.setBody(viewTravelClaim);
		logger.info("Method : editTravelClaimApi Dao ends");
		logger.info("VIEWRESP====" + resp);
		return resp;
	}
//

}
