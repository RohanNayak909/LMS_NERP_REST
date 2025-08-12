package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.model.RestManageLeadgerModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateManageLeadgerParam;

@RestController
@RequestMapping(value = { "account" })
public class RestManageLeadgerDao {

	Logger logger = LoggerFactory.getLogger(RestManageLeadgerDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryList() {

		logger.info("Method :getCountryList starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageledger")
					.setParameter("actionType", "getCountryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryList ends" + countryList);

		return countryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLedgerTypeList(String org, String orgDiv) {
		logger.info("Method :getLedgerTypeList starts");

		List<DropDownModel> ledgerTypeList = new ArrayList<DropDownModel>();

		try {

			String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageledger")
					.setParameter("actionType", "getLedgerTypeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ledgerTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLedgerTypeList ends");
		return ledgerTypeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStateLists() {

		logger.info("Method :getStateLists starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageledger")
					.setParameter("actionType", "getStateLists").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				stateList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getStateLists ends");

		return stateList;
	}

	// Add
	public ResponseEntity<JsonResponse<Object>> addLedgerDetails(RestManageLeadgerModel manageleadger) {

		logger.info("Method in Dao: addLedgerDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateManageLeadgerParam.addManageLeadgerParam(manageleadger);
			System.out.println(values);
			if (manageleadger.getLeadgerId() == "" || manageleadger.getLeadgerId() == null) {

				em.createNamedStoredProcedureQuery("account_manageledger").setParameter("actionType", "addLedger")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("account_manageledger").setParameter("actionType", "modifyLedger")
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
		logger.info("Method in Dao: addLedgerDetails ends" + response);

		return response;
	}

////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> viewLeadger(String orgName, String orgDivision) {
		logger.info("Method : viewLeadgerDao starts");

		List<RestManageLeadgerModel> respList = new ArrayList<RestManageLeadgerModel>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values==>" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageledger")
					.setParameter("actionType", "viewleadger").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				RestManageLeadgerModel data = new RestManageLeadgerModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], null);
				
//				if(m[10] != null) {
//					data.setLedgerType(m[10].toString());
//				}
//				if(m[11] != null) {
//					data.setLedgerTypeName(m[11].toString());
//				}
				
				respList.add(data);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		JsonResponse<List<RestManageLeadgerModel>> resp = new JsonResponse<List<RestManageLeadgerModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> response = new ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewLeadgerDao ends");
		return response;

	}

	// Edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> editLeadger(String id, String orgName,
			String orgDivision) {
		logger.info("Method : editmanageLeadgerInfo starts");

		JsonResponse<List<RestManageLeadgerModel>> resp = new JsonResponse<List<RestManageLeadgerModel>>();
		List<RestManageLeadgerModel> rs = new ArrayList<RestManageLeadgerModel>();

		try {

			String value = "SET @p_leaderId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageledger")
					.setParameter("actionType", "editledger").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestManageLeadgerModel restPayroll = new RestManageLeadgerModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
				rs.add(restPayroll);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> response = new ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editmanageLeadgerInfo ends");
		System.out.println("hello" + response);
		return response;
	}

	// delete
	public ResponseEntity<JsonResponse<Object>> deletemanageleadgerDetails(String id, String orgName,
			String orgDivision) {
		logger.info("Method : deletemanageleadgerDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String value = "SET @p_leaderId='(" + id + ")',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
						+ "';";
				logger.info("value--->" + value);
				em.createNamedStoredProcedureQuery("account_manageledger").setParameter("actionType", "deleteleadger")
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

		logger.info("response==>" + response);
		logger.info("Method :  deletemanageleadgerDetails ends");
		return response;
	}

	// search
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> getGroupList(String id, String orgName,
			String orgDiv) {
		logger.info("Method : getGroupList starts");

		List<RestManageLeadgerModel> itemNameList = new ArrayList<RestManageLeadgerModel>();
		JsonResponse<List<RestManageLeadgerModel>> resp = new JsonResponse<List<RestManageLeadgerModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("value" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageledger")
					.setParameter("actionType", "getgroupli").setParameter("actionValue", value).getResultList();

			System.out.println(value);
			for (Object[] m : x) {
				RestManageLeadgerModel dropDownModel = new RestManageLeadgerModel(m[0], m[1]);

				itemNameList.add(dropDownModel);
			}
			if (itemNameList.size() > 0) {
				resp.setBody(itemNameList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(itemNameList);
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> response = new ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response===>" + response);
		logger.info("Method : getGroupList ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> ledgerGetStateLists(String id) {

		logger.info("Method :ledgerGetStateLists starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_countryId='" + id + "';";

		logger.info("Method :ledgerGetStateLists --> " + id);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageledger")
					.setParameter("actionType", "ledgerGetStateLists").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				stateList.add(dropDownModel);
			}
			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : ledgerGetStateLists ends" + resp);

		return response;
	}

}