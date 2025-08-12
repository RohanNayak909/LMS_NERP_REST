package nirmalya.aatithya.restmodule.purchase.dao;

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

import nirmalya.aatithya.restmodule.common.ServerDao;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateVendorNewParameter;
import nirmalya.aatithya.restmodule.purchase.model.RestVendorNewModel;

/*
 * @author NirmalyaLabs
 *
 */
@Repository
public class RestPurchaseVendorDao {

	Logger logger = LoggerFactory.getLogger(RestPurchaseVendorDao.class);

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	// getStateLists

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateLists(String id) {

		logger.info("Method : getStateLists starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendormaster")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("stateeeeeeeeeee" + response);
		logger.info("Method : getStateLists ends");
		return response;
	}

//addVendor

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addVendor(RestVendorNewModel restVendorNewModel) {

		logger.info("Method in Dao: addVendor starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		// resp.setMessage("");
		// resp.setCode("");
		try {
			String values = GenerateVendorNewParameter.getAddVendorParam(restVendorNewModel);
			System.out.println("values####" + values);
			System.out.println("values####" + restVendorNewModel.getVendorIdHead());
			List<Object[]> x = null;
			if (restVendorNewModel.getVendorIdHead() == "" || restVendorNewModel.getVendorIdHead() == null) {

				x = em.createNamedStoredProcedureQuery("vendormaster").setParameter("actionType", "addVendor")
						.setParameter("actionValue", values).getResultList();
				
				resp.setMessage("Vendor Added successfully.");

			} else {

				x = em.createNamedStoredProcedureQuery("vendormaster").setParameter("actionType", "modifyVendor")
						.setParameter("actionValue", values).getResultList();
				
				resp.setMessage("Vendor Modified successfully.");

			}

			resp.setBody(x.get(0));

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
		if (resp.getMessage() == null) {
			resp.setMessage("Saved successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: addVendor ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> deleteChildDataOfVendor(DropDownModel dropDownModel) {
		logger.info("Method in Dao: deleteChildDataOfVendor starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(dropDownModel);
			System.out.println(values);
			List<Object[]> x = null;
			System.out.println("values>>>>>><<<<<-----" + values);

			if (dropDownModel.getKey() != "" && dropDownModel.getKey() != null) {

				x = em.createNamedStoredProcedureQuery("vendormaster").setParameter("actionType", "deleteChildData")
						.setParameter("actionValue", values).getResultList();
				System.out.println(x.get(0));
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data deleted successfully");
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
			resp.setBody(null);
			resp.setCode("failed");
			resp.setMessage("Something went wrong");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: deleteChildDataOfVendor ends");
		return response;
	}

//restViewVendorDtls

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestVendorNewModel>>> restViewVendorDtls(String orgName, String orgDiv,
			String from) {
		logger.info("Method : restViewVendorDtls starts");
		List<RestVendorNewModel> respList = new ArrayList<RestVendorNewModel>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_from='" + from + "';";
			System.out.println("VALUES:::::::::::::::" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendormaster")
					.setParameter("actionType", "getVendorDetails").setParameter("actionValue", values).getResultList();
			// logger.info("restViewVendorDtls -----------view12");
			for (Object[] m : x) {
				// logger.info(Arrays.toString(m));
				String createdDate = null;
				if (m[45] != null) {
					createdDate = m[45].toString();
				}

				RestVendorNewModel restPayroll = new RestVendorNewModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32], m[33], m[34],
						m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42], m[43], m[44], createdDate,
						m[46].toString(), m[47], m[48], null, m[49], null, null, null, null, null, null, null, null);
				respList.add(restPayroll);

			}

			// logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestVendorNewModel>> resp = new JsonResponse<List<RestVendorNewModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestVendorNewModel>>> response = new ResponseEntity<JsonResponse<List<RestVendorNewModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("response" + response);
		logger.info("Method : restViewVendorDtls ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		// logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
//editVendorInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestVendorNewModel>>> editVendorPurchaseInfo(String id, String orgName,
			String orgDiv) {
		logger.info("Method : editVendorPurchaseInfo starts");

		JsonResponse<List<RestVendorNewModel>> resp = new JsonResponse<List<RestVendorNewModel>>();
		List<RestVendorNewModel> rs = new ArrayList<RestVendorNewModel>();

		try {

			String value = "SET @p_vendorId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			// logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("vendormaster")
					.setParameter("actionType", "editVendorInfo").setParameter("actionValue", value).getResultList();
			// logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				String createdDate = null;
				if (m[45] != null) {
					createdDate = m[45].toString();
				}

				RestVendorNewModel restPayroll = new RestVendorNewModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32], m[33], m[34],
						m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42], m[43], m[44], createdDate,
						m[46].toString(), m[47], m[48], m[49], m[50], null, null, m[51], m[52], m[53], m[54], m[55],
						m[56]);
				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestVendorNewModel>>> response = new ResponseEntity<JsonResponse<List<RestVendorNewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editVendorPurchaseInfo ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		return response;
	}

	// deleteVendorDetails

	public ResponseEntity<JsonResponse<Object>> deleteVendorDetails(String id, String orgName, String orgDiv) {
		logger.info("Method : deleteVendorDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		// logger.info("ID...." + id);
		if (validity)
			try {

				String value = "SET  @p_vendorId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println(value);
				// logger.info("value------------------" + value);

				em.createNamedStoredProcedureQuery("vendormaster").setParameter("actionType", "deleteVendor")
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

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  deleteVendorDetails ends");
		// logger.info("DELETE" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVendorCategory() {
		logger.info("Method : getVendorCategory starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendormaster")
					.setParameter("actionType", "getVendorCategory").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVendorCategory ends");
		return getCollectionList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSalutationLists() {
		logger.info("Method : getSalutationLists starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendormaster")
					.setParameter("actionType", "getSalutationLists").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSalutationLists ends");
		return getCollectionList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPaymentTermsLists() {
		logger.info("Method : getPaymentTermsLists starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendormaster")
					.setParameter("actionType", "getPaymentTermsLists").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPaymentTermsLists ends");
		return getCollectionList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getbankAutoSearchList(String id, String org, String orgDiv) {
		logger.info("Method : getbankAutoSearchList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_searchValue='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendormaster")
					.setParameter("actionType", "getbankAutoSearchList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getbankAutoSearchList Dao ends");
		System.out.println("resp**" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestVendorNewModel>>> restViewVendorProfileDtls(String orgName,
			String orgDiv, String userId) {
		logger.info("Method : restViewVendorProfileDtls starts");
		List<RestVendorNewModel> respList = new ArrayList<RestVendorNewModel>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "' ;";

			logger.info("restViewVendorProfileDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendormaster")
					.setParameter("actionType", "getVendorProfileDetails").setParameter("actionValue", values)
					.getResultList();
			logger.info("restViewVendorProfileDtls -----------view12");
			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				String createdDate = null;
				if (m[45] != null) {
					createdDate = m[45].toString();
				}

				RestVendorNewModel restPayroll = new RestVendorNewModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32], m[33], m[34],
						m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42], m[43], m[44], createdDate,
						m[46].toString(), m[47], m[48], null, m[49], null, null, null, null, null, null, null, null);
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestVendorNewModel>> resp = new JsonResponse<List<RestVendorNewModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestVendorNewModel>>> response = new ResponseEntity<JsonResponse<List<RestVendorNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : restViewVendorProfileDtls ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("restViewVendorProfileDtls" + respList);
		return response;

	}
	
	

		
	

	
}
