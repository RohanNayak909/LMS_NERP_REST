package nirmalya.aatithya.restmodule.his.dao;

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
import nirmalya.aatithya.restmodule.common.utils.his.GenerateOTReserveParameters;
import nirmalya.aatithya.restmodule.common.utils.GenerateUserMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.model.HISBedMasterRestModel;
import nirmalya.aatithya.restmodule.his.model.HISOTReservationRestModel;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;
import nirmalya.aatithya.restmodule.user.model.RolesAccessModel;
import nirmalya.aatithya.restmodule.user.model.UserAccessModel;


@Repository
public class RestHISOTReservationDao {

	Logger logger = LoggerFactory.getLogger(RestHISOTReservationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HISPatientRestModel>>> getOTPatientList(String id) {
		logger.info("Method : getOTPatientList Dao starts");

		List<HISPatientRestModel> itemNameList = new ArrayList<HISPatientRestModel>();
		JsonResponse<List<HISPatientRestModel>> resp = new JsonResponse<List<HISPatientRestModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		System.out.println("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
					.setParameter("actionType", "getOTPatientList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				HISPatientRestModel viewDemo = new HISPatientRestModel(m[0], m[1]);

				itemNameList.add(viewDemo);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<HISPatientRestModel>>> response = new ResponseEntity<JsonResponse<List<HISPatientRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getOTPatientList Dao ends" + resp);
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> groupList() {

		logger.info("Method : groupList starts");

		List<DropDownModel> departType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
					.setParameter("actionType", "groupList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : groupList ends" + departType);
		return departType;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> subGroupList() {

		logger.info("Method : subGroupList starts");

		List<DropDownModel> departType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
					.setParameter("actionType", "subGroupList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : subGroupList ends" + departType);
		return departType;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> empList() {

		logger.info("Method : empList starts");

		List<DropDownModel> departType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
					.setParameter("actionType", "empList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : empList ends" + departType);
		return departType;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> surgeryList() {

		logger.info("Method : surgeryList starts");

		List<DropDownModel> departType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
					.setParameter("actionType", "surgeryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : surgeryList ends" + departType);
		return departType;
	}

	public ResponseEntity<JsonResponse<Object>> addOtReserve(HISOTReservationRestModel restData) {
		logger.info("Method : Rest addOtReserve   starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ADDDDDDID" + restData);

		if (validity)
			try {
				String values = GenerateOTReserveParameters.getOtReserveParam(restData);

				if (restData.getOtReserveId() == null || restData.getOtReserveId() == "") {
					System.out.println("addddd in daooooooooooo" + restData);
					em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
							.setParameter("actionType", "addOtReserve").setParameter("actionValue", values).execute();

				}

				else {
					System.out.println("MODIFYYYYYYY  in daooooooooo " + restData);
					System.out.println("VALUEEEEE" + values);
					em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
							.setParameter("actionType", "modifyOtReserve").setParameter("actionValue", values)
							.execute();
				}
				System.out.println("VALLLLUUUUUUEEEEE" + values);
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

		logger.info("Method : Rest addOtReserve Dao ends" + response);
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<HISOTReservationRestModel>> viewReservation() {
		logger.info("Method : viewReservation starts");

		List<HISOTReservationRestModel> viewMasterData = new ArrayList<HISOTReservationRestModel>();
		JsonResponse<List<HISOTReservationRestModel>> resp = new JsonResponse<List<HISOTReservationRestModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
					.setParameter("actionType", "viewReservation").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				System.out.println("x====" + x);
				HISOTReservationRestModel restMasterData = new HISOTReservationRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], null);
				viewMasterData.add(restMasterData);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(viewMasterData);
		logger.info("Method : viewReservation ends");
		System.out.println("VIEWWWWW" + resp);

		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<HISOTReservationRestModel> editReservation(String id, String orgName, String orgDivision,
			String uId) {
		logger.info("Method : editReservation Dao starts");
		System.out.println("Edit" + id);
		HISOTReservationRestModel req = new HISOTReservationRestModel();
		JsonResponse<HISOTReservationRestModel> resp = new JsonResponse<HISOTReservationRestModel>();
		try {
			String value = "SET @p_reserveId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
					.setParameter("actionType", "editReservation").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				HISOTReservationRestModel restMasterData = new HISOTReservationRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], null);
				req = restMasterData;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editReservation Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> subGroupListData(String id) {

		logger.info("Method : subGroupListData starts");
		List<DropDownModel> doctorList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_group='" + id + "';";

		logger.info(value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
					.setParameter("actionType", "subGroupListData").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				doctorList.add(dropDownModel);

			}

			resp.setBody(doctorList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : subGroupListData ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RolesAccessModel>>> getResEmployeeList(String org, String orgDiv) {
		logger.info("Method : getResEmployeeList starts");

		JsonResponse<List<RolesAccessModel>> resp = new JsonResponse<List<RolesAccessModel>>();
		resp.setMessage("");
		resp.setCode("");
		List<RolesAccessModel> roleList = new ArrayList<RolesAccessModel>();
		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
					.setParameter("actionType", "getResEmployeeList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object createdDate = null;

				if (m[5] != null) {
					createdDate = DateFormatter.returnStringDateMonth(m[5]);
				}

				RolesAccessModel dropDownModel = new RolesAccessModel(m[0], m[1], m[2], m[3], m[4], createdDate);
				roleList.add(dropDownModel);
			}
			resp.setBody(roleList);
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

		ResponseEntity<JsonResponse<List<RolesAccessModel>>> response = new ResponseEntity<JsonResponse<List<RolesAccessModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response====" + response);
		logger.info("Method : getResEmployeeList ends");

		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveOtReserve(HISOTReservationRestModel id) {
		logger.info("Method : saveOtReserve starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String values = GenerateOTReserveParameters.saveOtReserve(id);
			logger.info("values=====" + values);
			if (id.getOtReserveId() != null && id.getOtReserveId() != "") {
				em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
						.setParameter("actionType", "modifyOtReserve").setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("his_ot_reserve_routines").setParameter("actionType", "addOtReserve")
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

		logger.info("Method : saveOtReserve ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HISOTReservationRestModel>>> getReserveList() {
		logger.info("Method : getReserveList starts");

		JsonResponse<List<HISOTReservationRestModel>> resp = new JsonResponse<List<HISOTReservationRestModel>>();
		resp.setMessage("");
		resp.setCode("");
		List<HISOTReservationRestModel> roleList = new ArrayList<HISOTReservationRestModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
					.setParameter("actionType", "getReserveList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				Object createdDate = null;

				if (m[3] != null) {
					createdDate = m[3].toString();
				}

				HISOTReservationRestModel dropDownModel = new HISOTReservationRestModel(m[0], m[1], m[2], createdDate,
						m[4], m[5], m[6], null, m[7], m[8], m[9], null, m[10], m[11]);
				roleList.add(dropDownModel);
			}
			resp.setBody(roleList);
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

		ResponseEntity<JsonResponse<List<HISOTReservationRestModel>>> response = new ResponseEntity<JsonResponse<List<HISOTReservationRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getReserveList ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<HISOTReservationRestModel>> editReserveList(String id) {
		logger.info("Method : editReserveList starts");

		JsonResponse<HISOTReservationRestModel> resp = new JsonResponse<HISOTReservationRestModel>();
		resp.setMessage("");
		resp.setCode("");
		List<HISOTReservationRestModel> roleList = new ArrayList<HISOTReservationRestModel>();
		try {
			String value = "SET @P_UserId='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_reserve_routines")
					.setParameter("actionType", "editReserveList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object createdDate = null;

				if (m[3] != null) {
					createdDate = m[3].toString();
				}

				HISOTReservationRestModel dropDownModel = new HISOTReservationRestModel(m[0], m[1], m[2], createdDate,
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13]);
				roleList.add(dropDownModel);
			}
			resp.setBody(roleList.get(0));
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

		ResponseEntity<JsonResponse<HISOTReservationRestModel>> response = new ResponseEntity<JsonResponse<HISOTReservationRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : editReserveList ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteReserved(List<DropDownModel> id) {
		logger.info("Method : deleteReserved starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		if (validity)
			try {
				
				String value = GenerateOTReserveParameters.geOTIdList(id);
				em.createNamedStoredProcedureQuery("his_ot_reserve_routines").setParameter("actionType", "deleteReserved")
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
		
		logger.info("Method : deleteReserved ends");
		return response;
	}
}
