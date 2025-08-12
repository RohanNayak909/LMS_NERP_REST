package nirmalya.aatithya.restmodule.inventory.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateShoukeenDealerDetails;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.RestShoukeenDealerModel;

@Repository
public class RestShoukeenDealerDao {

	Logger logger = LoggerFactory.getLogger(RestShoukeenDealerDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	// getCountryList

	/**
	 * DAO Function for drop down models of states
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getShoukeenCountryList() {
		logger.info("Method : getShoukeenCountryList starts");
		List<DropDownModel> countryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("shoukeen_dealer")
					.setParameter("actionType", "getCountry").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getShoukeenCountryList end");
		return countryList;
	}

//getShoukeenState

	/**
	 * DAO Function for drop down models of states
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getShoukeenState() {
		logger.info("Method : getShoukeenState starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("shoukeen_dealer")
					.setParameter("actionType", "getState").setParameter("actionValue", "").getResultList();

			logger.info("rest dao for shoukeen State-------------2222222222222222222");

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Response for state-----" + stateList);
		logger.info("Method : getShoukeenState end");
		return stateList;
	}

	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> addDealer(RestShoukeenDealerModel restShoukeenDealerModel) {

		logger.info("Method in Dao: addDealer starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateShoukeenDealerDetails.generateDealerParam(restShoukeenDealerModel);
			logger.info("save for dealer-----------------------------------" + values);
			if (restShoukeenDealerModel.getDealerId() == "" || restShoukeenDealerModel.getDealerId() == null) {

				em.createNamedStoredProcedureQuery("shoukeen_dealer").setParameter("actionType", "addDealer")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("shoukeen_dealer").setParameter("actionType", "modifyDealer")
						.setParameter("actionValue", values).execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addDealer ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestShoukeenDealerModel>>> restViewDealerDetails() {
		logger.info("Method : restViewDealerDetails starts");
		List<RestShoukeenDealerModel> respList = new ArrayList<RestShoukeenDealerModel>();
		logger.info("RestShoukeenDealerModel   dao");
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("shoukeen_dealer")
					.setParameter("actionType", "getDealerDetails").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestShoukeenDealerModel restPayroll = new RestShoukeenDealerModel(m[0], m[1], m[2], m[3], m[4],
						m[5].toString(), m[6]);
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestShoukeenDealerModel>> resp = new JsonResponse<List<RestShoukeenDealerModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestShoukeenDealerModel>>> response = new ResponseEntity<JsonResponse<List<RestShoukeenDealerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : restViewDealerDetails ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}

	/// editDealerInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestShoukeenDealerModel>>> editDealerInfo(String id) {
		logger.info("Method : editDealerInfo starts");

		JsonResponse<List<RestShoukeenDealerModel>> resp = new JsonResponse<List<RestShoukeenDealerModel>>();
		List<RestShoukeenDealerModel> rs = new ArrayList<RestShoukeenDealerModel>();

		try {

			String value = "SET @p_dealerId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("shoukeen_dealer")
					.setParameter("actionType", "editDealerInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				String decodedString = null;
				/*
				 * if (m[4] != null) { String inputString = (String) m[4]; byte[] byteArrray =
				 * inputString.getBytes();
				 * 
				 * byte[] decodedBytes = Base64.getDecoder().decode(byteArrray); decodedString =
				 * new String(decodedBytes); }
				 */

				RestShoukeenDealerModel restPayroll = new RestShoukeenDealerModel(m[0], m[1], m[2], m[3], decodedString,
						null, m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
						m[18], m[19], m[20], m[21], m[22], m[23], m[24], null);

				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestShoukeenDealerModel>>> response = new ResponseEntity<JsonResponse<List<RestShoukeenDealerModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editDealerInfo ends");
		return response;
	}

	// deleteDealerDetails

	/*
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deleteDealerDetails(String id) {
		logger.info("Method : deleteDealerDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		logger.info("ID....--------------------------------" + id);
		if (validity)
			try {

				// String result=id.replaceAll("^|$", "'").replaceAll(",", "','");
				// String value = "SET @p_vendorId='(" + result + ")';";
				// String value = "SET @p_vendorId=('TVM00001','TVM00002');";
				// logger.info(value);

				String value = "SET  @p_dealerId='(" + id + ")';";

				logger.info("value----------------------------------------" + value);

				em.createNamedStoredProcedureQuery("shoukeen_dealer455678").setParameter("actionType", "deleteDealer")
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

		logger.info("Method :  deleteDealerDetails ends");
		logger.info("DELETE" + response);
		return response;
	}

	// getVendorNameAutoSearch

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<DropDownModel>>>
	 * getVendorNameAutoSearch(String id) {
	 * logger.info("Method : getVendorNameAutoSearch starts"); List<DropDownModel>
	 * itemNameList = new ArrayList<DropDownModel>();
	 * JsonResponse<List<DropDownModel>> resp = new
	 * JsonResponse<List<DropDownModel>>(); String value = "SET @p_searchValue='" +
	 * id + "';";
	 * 
	 * try { logger.info("VALUE"+value); List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("crmVendors_routines")
	 * .setParameter("actionType",
	 * "getVendorNameAutoSearch").setParameter("actionValue", value)
	 * .getResultList(); for (Object[] m : x) { DropDownModel dropDownModel = new
	 * DropDownModel(m[0], m[1]); itemNameList.add(dropDownModel); }
	 * resp.setBody(itemNameList); } catch (Exception e) { e.printStackTrace(); }
	 * ResponseEntity<JsonResponse<List<DropDownModel>>> response = new
	 * ResponseEntity<JsonResponse<List<DropDownModel>>>( resp, HttpStatus.CREATED);
	 * logger.info("Method : getVendorNameAutoSearch ends");
	 * logger.info("AUTODATAAA" + response); return response; }
	 */

}
