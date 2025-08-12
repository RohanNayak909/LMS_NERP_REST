package nirmalya.aatithya.restmodule.gatepass.dao;

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
import nirmalya.aatithya.restmodule.common.utils.gatePass.GenerateGatePassSecurityAssignParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gatepass.model.RestSecurityAssignModel;

@Repository
public class SecurityAssignDao {

	Logger logger = LoggerFactory.getLogger(SecurityAssignDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getpostGateLists(String org, String orgDiv) {
		logger.info("Method : getpostGateLists starts");
		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println(" List value>>----" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePass_SecurityAssign_Routines")
					.setParameter("actionType", "getpostGateLists").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1], null);
				categoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getpostGateLists ends");
		System.out.println(" List value>>----" + categoryList);
		return categoryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSecurityName(String org, String orgDiv) {
		logger.info("Method : getSecurityName starts");
		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println(" List value>>----" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePass_SecurityAssign_Routines")
					.setParameter("actionType", "getSecurityName").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				categoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSecurityName ends");
		return categoryList;
	}

	/**
	 * DAO Function to Add
	 *
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public ResponseEntity<JsonResponse<List<RestSecurityAssignModel>>> saveSecurityAssign(
			List<RestSecurityAssignModel> restSecurityAssignModel) {
		logger.info("Method : saveSecurityAssign starts");
		boolean validation = true;
		JsonResponse<List<RestSecurityAssignModel>> resp = new JsonResponse<List<RestSecurityAssignModel>>();
		List<RestSecurityAssignModel> listData = new ArrayList<RestSecurityAssignModel>();

		try {
			String values = GenerateGatePassSecurityAssignParam.getAssignParam(restSecurityAssignModel);
			System.out.println("ADDDDDDDDDDDDDDDDDDS#" + values);
			System.out.println("IDDDDD#" + restSecurityAssignModel.get(0).getSecurityAssignId());

			if (restSecurityAssignModel.get(0).getSecurityAssignId() == null
					|| restSecurityAssignModel.get(0).getSecurityAssignId() == "") {

				em.createNamedStoredProcedureQuery("gatePass_SecurityAssign_Routines")
						.setParameter("actionType", "saveSecurityAssign").setParameter("actionValue", values).execute();
				
				resp.setCode("Security Assign Successfully.");

			} else {
				System.out.println("@modifyyyyyyyyyyyyyy" + values);

				em.createNamedStoredProcedureQuery("gatePass_SecurityAssign_Routines")
						.setParameter("actionType", "modifySecurityAssign").setParameter("actionValue", values)
						.execute();
				
				resp.setCode("Security Assign Modified Successfully.");

				System.out.println("modify printttttttttttttttttt" + listData);

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

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestSecurityAssignModel>>> response = new ResponseEntity<JsonResponse<List<RestSecurityAssignModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveSecurityAssign ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewSecurityAssign(String orgName, String orgDivision) {
		logger.info("Method : viewSecurityAssign Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePass_SecurityAssign_Routines")
					.setParameter("actionType", "viewSecurityAssign").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewSecurityAssign Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// View allocation data
	@SuppressWarnings("unchecked")
	public JsonResponse editSecurityAssign(String assignId, String orgName, String orgDiv) {
		logger.info("Method : editSecurityAssign Dao starts");

		JsonResponse resp = new JsonResponse();

		try {
			String value = "SET @p_assignId='" + assignId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePass_SecurityAssign_Routines")
					.setParameter("actionType", "editSecurityAssign").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : editSecurityAssign Dao ends");
		System.out.println("resp" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAssignPdfDetails(String id, String orgName, String orgDivision) {
		logger.info("Method : getAssignPdfDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assignId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

			System.out.println("values***" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePass_SecurityAssign_Routines")
					.setParameter("actionType", "getAssignPdfDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAssignPdfDetails Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}

	// approve

	public JsonResponse<DropDownModel> approveAssign(String approveStatus, String securityAssignId, String orgName,
			String orgDivision) {
		logger.info("Method : approveAssign starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			// String value = "SET @p_approveStatus='" + approveStatus +
			// "',@p_quotationId='" + quotationId + "', @p_org='" + orgName +
			// "',@p_orgDiv='" + orgDivision + "';";

			String value = "SET @p_approveStatus='" + approveStatus + "',@p_securityAssignId='" + securityAssignId + "',@p_org='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "';";

			System.out.println("value===" + value);
			em.createNamedStoredProcedureQuery("gatePass_SecurityAssign_Routines").setParameter("actionType", "approveAssign")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : approveAssign ends");
		return resp;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteAssignDetails(String id) {
		logger.info("Method : deleteAssignDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_securityAssignId='" + id + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("gatePass_SecurityAssign_Routines")
						.setParameter("actionType", "deleteAssignDetails").setParameter("actionValue", value)
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

		logger.info("Method : deleteAssignDetails ends");
		System.out.println("DELETEE" + response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSecurityNameList(String id, String orgName, String orgDivision) {

		logger.info("Method : getSecurityNameList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_type='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		
		System.out.println("#############################"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatePass_SecurityAssign_Routines")
					.setParameter("actionType", "getSecurityNameListt").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("stateeeeeeeeeee"+response);
		logger.info("Method : getSecurityNameList ends");
		return response;
	}

}
