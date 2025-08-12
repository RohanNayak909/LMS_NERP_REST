package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateGlobalMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.DateFormatModel;
import nirmalya.aatithya.restmodule.master.model.FiscalYearModel;
import nirmalya.aatithya.restmodule.master.model.GlobalMasterRestModel;
import nirmalya.aatithya.restmodule.master.model.YearMasterModel;

@Repository
public class GlobalRestDao {
	Logger logger = LoggerFactory.getLogger(GlobalRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	public ResponseEntity<JsonResponse<Object>> addGlobalMaster(GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addGlobalMaster Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateGlobalMasterParameter.Country(globalMasterRestModel);

			if (globalMasterRestModel.getGlobalId() != null && globalMasterRestModel.getGlobalId() != "") {
				em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "modifyGlobal")
						.setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "addGlobal")
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

		logger.info("Method :addGlobalMaster Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewGlobalMaster() {
		logger.info("Method : viewGlobalMaster starts");

		List<GlobalMasterRestModel> countryList = new ArrayList<GlobalMasterRestModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "viewCountry").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[4].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				GlobalMasterRestModel dropDownModel = new GlobalMasterRestModel(m[0], m[1], m[2], m[3], null, null,
						null, null, null, null, null, null, null, status, null, null, null, null, null);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<GlobalMasterRestModel>> resp = new JsonResponse<List<GlobalMasterRestModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewGlobalMaster ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteGlobalMaster(String id) {
		logger.info("Method : deleteGlobalMaster Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_globalId='" + id + "';";

			em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "deleteCountry")
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

		logger.info("Method : deleteGlobalMaster Dao starts");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteFiscalyear(String id) {
		logger.info("Method : deleteFiscalyear Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_fiscalYearId='" + id + "';";

			em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "deleteFiscalyear")
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

		logger.info("Method : deleteFiscalyear Dao starts");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DateFormatModel>> changeDateFormat(String id, String userId) {
		logger.info("Method : changeDateFormat Dao starts");

		JsonResponse<DateFormatModel> resp = new JsonResponse<DateFormatModel>();
		List<DateFormatModel> dataList = new ArrayList<DateFormatModel>();

		try {
			String value = "SET @P_Id='" + id + "', @P_CreatedBy='" + userId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "changeDateFormat").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DateFormatModel dd = new DateFormatModel(m[0], m[1], m[2]);
				dataList.add(dd);
			}
			resp.setBody(dataList.get(0));
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

		ResponseEntity<JsonResponse<DateFormatModel>> response = new ResponseEntity<JsonResponse<DateFormatModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : changeDateFormat Dao starts");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addFiscalyear(FiscalYearModel id) {
		logger.info("Method : addFiscalyear Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			if (id.getYearId() == "" || id.getYearId() == null) {
				String value = "SET @P_Year='" + id.getYear() + "', @P_StartMonth='" + id.getMonthDtls()
						+ "', @P_EndMonth='" + id.getEndMnth() + "', @P_CreatedBy='" + id.getCreatedBy() + "';";
				em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "addFiscalyear")
						.setParameter("actionValue", value).execute();
			} else {
				String value = "SET @P_Year='" + id.getYear() + "', @P_StartMonth='" + id.getMonthDtls()
						+ "', @P_EndMonth='" + id.getEndMnth() + "', @P_CreatedBy='" + id.getCreatedBy()
						+ "', @P_YearId='" + id.getYearId() + "';";
				em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
						.setParameter("actionType", "modifyFiscalyear").setParameter("actionValue", value).execute();
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

		logger.info("Method : addFiscalyear Dao starts");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addCalenedarYear(YearMasterModel id) {
		logger.info("Method : addCalenedarYear Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			if (id.getYearId() == null) {
				String value = "SET @P_Year='" + id.getYear() + "', @P_YrStatus='" + id.getYearStatus()
						+ "', @P_CreatedBy='" + id.getCreatedBy() + "';";
				em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
						.setParameter("actionType", "addCalenedarYear").setParameter("actionValue", value).execute();
			} else {
				String value = "SET @P_Year='" + id.getYear() + "', @P_YrStatus='" + id.getYearStatus()
						+ "', @P_CreatedBy='" + id.getCreatedBy() + "', @P_YearId=" + id.getYearId() + ";";
				em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
						.setParameter("actionType", "modifyCalenedarYear").setParameter("actionValue", value).execute();
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
		logger.info("Method : addCalenedarYear Dao starts");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<FiscalYearModel>>> getFiscalYearList() {
		logger.info("Method : getFiscalYearList Dao starts");

		JsonResponse<List<FiscalYearModel>> resp = new JsonResponse<List<FiscalYearModel>>();
		List<FiscalYearModel> year = new ArrayList<FiscalYearModel>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "getFiscalYearList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				FiscalYearModel dd = new FiscalYearModel(m[0], m[1], m[2], m[3]);
				year.add(dd);
			}
			resp.setBody(year);
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

		ResponseEntity<JsonResponse<List<FiscalYearModel>>> response = new ResponseEntity<JsonResponse<List<FiscalYearModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getFiscalYearList Dao starts");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewOnclickState(String id) {
		logger.info("Method : viewOnclickState starts");

		List<GlobalMasterRestModel> countryList = new ArrayList<GlobalMasterRestModel>();

		String values = "SET @p_globalId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "viewOnclickState").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[4].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				GlobalMasterRestModel dropDownModel = new GlobalMasterRestModel(null, null, null, null, m[0], m[1],
						m[2], m[3], null, null, null, null, null, null, status, null, null, null, null);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<GlobalMasterRestModel>> resp = new JsonResponse<List<GlobalMasterRestModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewOnclickState ends");
		return response;
	}

	/* STATE STARTS */
	public ResponseEntity<JsonResponse<Object>> addStateMaster(GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addStateMaster Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateGlobalMasterParameter.State(globalMasterRestModel);

			if (globalMasterRestModel.getStateId() != null && globalMasterRestModel.getStateId() != "") {
				em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "modifyState")
						.setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "addState")
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

		logger.info("Method :addStateMaster Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewStateMaster() {
		logger.info("Method : viewStateMaster starts");

		List<GlobalMasterRestModel> stateList = new ArrayList<GlobalMasterRestModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "viewState").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[4].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				GlobalMasterRestModel dropDownModel = new GlobalMasterRestModel(null, null, null, null, m[0], m[1],
						m[2], m[3], null, null, null, null, null, null, status, null, null, null, null);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<GlobalMasterRestModel>> resp = new JsonResponse<List<GlobalMasterRestModel>>();
		resp.setBody(stateList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewStateMaster ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteStateMaster(String id) {

		logger.info("Method : deleteStateMaster Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_stateId='" + id + "';";

			em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "deleteState")
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

		logger.info("Method : deleteStateMaster Dao starts");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewOnclickDistrict(String id) {
		logger.info("Method : viewOnclickDistrict starts");

		List<GlobalMasterRestModel> countryList = new ArrayList<GlobalMasterRestModel>();

		String values = "SET @p_stateId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "viewOnclickDistrict").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[4].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				GlobalMasterRestModel dropDownModel = new GlobalMasterRestModel(m[0], m[1], m[2], m[3], status, null);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<GlobalMasterRestModel>> resp = new JsonResponse<List<GlobalMasterRestModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewOnclickDistrict ends");
		return response;
	}

	/* DISTRICT MASTER */
	public ResponseEntity<JsonResponse<Object>> addDistrictMaster(GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addDistrictMaster Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateGlobalMasterParameter.District(globalMasterRestModel);

			if (globalMasterRestModel.getDistrictId() != null && globalMasterRestModel.getDistrictId() != "") {
				em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "modifyDistrict")
						.setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "addDistrict")
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

		logger.info("Method :addDistrictMaster Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewDistrictMaster() {
		logger.info("Method : viewDistrictMaster starts");

		List<GlobalMasterRestModel> stateList = new ArrayList<GlobalMasterRestModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "viewDistrict").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[4].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				GlobalMasterRestModel dropDownModel = new GlobalMasterRestModel(m[0], m[1], m[2], m[3], status, null);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<GlobalMasterRestModel>> resp = new JsonResponse<List<GlobalMasterRestModel>>();
		resp.setBody(stateList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewDistrictMaster ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteDistrictMaster(String id) {

		logger.info("Method : deleteDistrictMaster Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_districtId='" + id + "';";

			em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "deleteDistrict")
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

		logger.info("Method : deleteDistrictMaster Dao starts");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewOnclickCity(String id) {
		logger.info("Method : viewOnclickCity starts");

		List<GlobalMasterRestModel> countryList = new ArrayList<GlobalMasterRestModel>();

		String values = "SET @p_districtId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "viewOnclickCity").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[4].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				GlobalMasterRestModel dropDownModel = new GlobalMasterRestModel(null, null, null, null, null, null,
						null, null, m[0], m[1], m[2], m[3], null, null, null, status, null, null, null);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<GlobalMasterRestModel>> resp = new JsonResponse<List<GlobalMasterRestModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewOnclickCity ends");
		return response;
	}

	/* CITY MASTER */
	public ResponseEntity<JsonResponse<Object>> addCityMaster(GlobalMasterRestModel globalMasterRestModel) {
		logger.info("Method : addCityMaster Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateGlobalMasterParameter.City(globalMasterRestModel);

				if (globalMasterRestModel.getCityId() != null && globalMasterRestModel.getCityId() != "") {
					em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "modifyCity")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "addCity")
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

		logger.info("Method :addCityMaster Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewCityMaster() {
		logger.info("Method : viewCityMaster starts");

		List<GlobalMasterRestModel> cityList = new ArrayList<GlobalMasterRestModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "viewCity").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[4].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				GlobalMasterRestModel dropDownModel = new GlobalMasterRestModel(null, null, null, null, null, null,
						null, null, m[0], m[1], m[2], m[3], null, null, null, status, null, null, null);
				cityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<GlobalMasterRestModel>> resp = new JsonResponse<List<GlobalMasterRestModel>>();
		resp.setBody(cityList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewCityMaster ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteCityMaster(String id) {

		logger.info("Method : deleteCityMaster Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_cityId='" + id + "';";

			em.createNamedStoredProcedureQuery("GlobalMasterRoutines").setParameter("actionType", "deleteCity")
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

		logger.info("Method : deleteCityMaster Dao starts");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDateFormatTypeList() {
		logger.info("Method : getDateFormatTypeList Dao starts");

		List<DropDownModel> dateFormatTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "dateFormatList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dd = new DropDownModel(m[0], m[1]);
				dateFormatTypeList.add(dd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDateFormatTypeList Dao ends");
		return dateFormatTypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<YearMasterModel>>> viewYearListMaster() {
		logger.info("Method : viewYearListMaster starts");

		List<YearMasterModel> countryList = new ArrayList<YearMasterModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "viewYearList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[2].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				YearMasterModel dropDownModel = new YearMasterModel(m[0], m[1], status);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<YearMasterModel>> resp = new JsonResponse<List<YearMasterModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<YearMasterModel>>> response = new ResponseEntity<JsonResponse<List<YearMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewYearListMaster ends");
		return response;
	}

	/**
	 * for add list of city
	 * @param globalMasterRestModel
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addCityMasterList(List<GlobalMasterRestModel> globalMasterRestModel) {
		logger.info("Method : addCityMaster Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateGlobalMasterParameter.getCityList(globalMasterRestModel);

			em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "addCityMasterList").setParameter("actionValue", values).execute();

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

		logger.info("Method :addCityMaster Dao ends");
		return response;
	}

	/**
	 * for add list of country
	 * @param globalMasterRestModel
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addCountryMasterList(
			List<GlobalMasterRestModel> globalMasterRestModel) {
		logger.info("Method : addCountryMasterList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateGlobalMasterParameter.getCountryList(globalMasterRestModel);
 
			 em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "addCountryMasterList").setParameter("actionValue", values).execute();
		 
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

		logger.info("Method :addCountryMasterList Dao ends");
		return response;
	}
	
	/**
	 * for add list of state
	 * @param globalMasterRestModel
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addStateMasterList(
			List<GlobalMasterRestModel> globalMasterRestModel) {
		logger.info("Method : addStateMasterList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateGlobalMasterParameter.getStateList(globalMasterRestModel);
 
			 em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "addStateMasterList").setParameter("actionValue", values).execute();
		 
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

		logger.info("Method :addStateMasterList Dao ends");
		return response;
	}
	
	/**
	 * for add list of state
	 * @param globalMasterRestModel
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addDistMasterList(
			List<GlobalMasterRestModel> globalMasterRestModel) {
		logger.info("Method : addDistMasterList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateGlobalMasterParameter.getDistList(globalMasterRestModel);
			
			em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
			.setParameter("actionType", "addDistMasterList").setParameter("actionValue", values).execute();
			
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
		
		logger.info("Method :addDistMasterList Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> viewTotalGlobal() {
		logger.info("Method : viewTotalGlobal starts");

		List<GlobalMasterRestModel> countryList = new ArrayList<GlobalMasterRestModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("GlobalMasterRoutines")
					.setParameter("actionType", "viewTotalGlobal").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {  
				GlobalMasterRestModel dropDownModel = new GlobalMasterRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18] ,m[19]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<GlobalMasterRestModel>> resp = new JsonResponse<List<GlobalMasterRestModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<GlobalMasterRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewTotalGlobal ends");
		return response;
	}

}
