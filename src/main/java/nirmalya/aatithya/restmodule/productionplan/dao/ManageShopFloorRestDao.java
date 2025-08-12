package nirmalya.aatithya.restmodule.productionplan.dao;

import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.productionplan.GenerateShopFloorParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateLaminateParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.productionplan.model.RestManageShopFloorModel;
import nirmalya.aatithya.restmodule.qa.model.RestEvaluationOfLaminatesModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ManageShopFloorRestDao {

	Logger logger = LoggerFactory.getLogger(ManageShopFloorRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager entityManager;

	/*
	 * @SuppressWarnings("unchecked") public JsonResponse<Object>
	 * getManageShopFloor(String date, String shift, String orgName, String orgDiv,
	 * String uType, String userId) {
	 * logger.info("Method : getManageShopFloor starts"); JsonResponse<Object> resp
	 * = new JsonResponse<Object>(); try { String value = "SET @p_date='" + date +
	 * "',@p_shift='"+shift+"',@p_orgName='" + orgName + "',@orgDiv='" + orgDiv +
	 * "',@uType='" + uType + "',@userId='" + userId + "';";
	 * System.out.println("value for search------------" + value); List<Object[]> x
	 * = em.createNamedStoredProcedureQuery(
	 * "production_plan_manage_shopFloor_routines") .setParameter("actionType",
	 * "getManageShopFloor").setParameter("actionValue", value).getResultList();
	 * 
	 * System.out.println("==>"+x.get(0));
	 * 
	 * 
	 * resp.setBody(x.get(0)); resp.setCode("success");
	 * resp.setMessage("Data fetched successfully"); } catch (Exception e) {
	 * e.printStackTrace(); resp.setCode("failed"); resp.setMessage(e.getMessage());
	 * e.printStackTrace(); } System.out.println("==>>"+resp);
	 * logger.info("Method : getManageShopFloor ends" + resp); return resp; }
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getShiftWiseMcDetls(String date, String shift, String orgName, String orgDiv) {
		logger.info("Method : getShiftWiseMcDetls starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String Date = DateFormatter.getStringDate(date);
		// String Date = "2023-09-25";
		try {
			String value = "SET @p_date='" + Date + "',@p_shift='" + shift + "',@p_orgName='" + orgName + "',@orgDiv='"
					+ orgDiv + "';";
			System.out.println("value for search------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_manage_shopFloor_routines")
					.setParameter("actionType", "getShiftWiseMcDetls").setParameter("actionValue", value)
					.getResultList();

			System.out.println("==>" + x.get(0));

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("==>>" + resp);
		logger.info("Method : getShiftWiseMcDetls ends" + resp);
		return resp;
	}

	// add.

	public ResponseEntity<JsonResponse<RestManageShopFloorModel>> addShopFloor(RestManageShopFloorModel qc) {
		logger.info("Method : addLaminates dao starts");
		System.out.println(qc);
		JsonResponse<RestManageShopFloorModel> resp = new JsonResponse<RestManageShopFloorModel>();

		try {
			String value = GenerateShopFloorParam.getShopFloorDtls(qc);
			System.out.println("value===" + value);
			System.out.println("Modify qc===" + qc.getFloorId());
			if (qc.getFloorId() != null && qc.getFloorId() != "") {

				em.createNamedStoredProcedureQuery("production_plan_manage_shopFloor_routines")
						.setParameter("actionType", "modifyFloor").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("production_plan_manage_shopFloor_routines")
						.setParameter("actionType", "addFloor").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<RestManageShopFloorModel>> response = new ResponseEntity<JsonResponse<RestManageShopFloorModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addLaminates dao ends");
		return response;

	}

	// View.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getShoopFloorView(String orgName, String orgDivision) {
		logger.info("Method : getShoopFloorView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_manage_shopFloor_routines")
					.setParameter("actionType", "getShoopFloorView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : getShoopFloorView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// Edit

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editFloorData(String id, String orgName, String orgDivision) {
		logger.info("Method : editFloorData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_floorId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_manage_shopFloor_routines")
					.setParameter("actionType", "editFloorData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : editFloorData Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}

	// add BreakDown.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addBreakDown(RestManageShopFloorModel qc) {
		logger.info("Method : addBreakDown Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = GenerateShopFloorParam.getBreakDownDtls(qc);
			System.out.println("values***" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_manage_shopFloor_routines")
					.setParameter("actionType", "addBreakDownDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));

			resp.setCode("success");
			resp.setMessage("Data Saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Save Failed");
		}
		logger.info("Method : addBreakDown Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}
	
	// Approve
	
	

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveShopFloor(String id, String orgName, String orgDivision, String approvedBy) {
		logger.info("Method : approveShopFloor Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_floorId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_approvedBy='" + approvedBy + "';";
			System.out.println("values***" + value);
			em.createNamedStoredProcedureQuery("production_plan_manage_shopFloor_routines")
			.setParameter("actionType", "approveFloor").setParameter("actionValue", value).execute();
			
			resp.setCode("success");
			resp.setMessage("Data Approved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Process Failed");
		}
		logger.info("Method : approveShopFloor Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}
	
	

	// Delete
	
	

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteShopFloor(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteShopFloor Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_floorId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			em.createNamedStoredProcedureQuery("production_plan_manage_shopFloor_routines")
			.setParameter("actionType", "deleteFloor").setParameter("actionValue", value).execute();
			
			resp.setCode("success");
			resp.setMessage("Data Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Process Failed");
		}
		logger.info("Method : deleteShopFloor Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> breakDownPdf(String id, String mcNo, String sku, String orgName, String orgDivision) {
		logger.info("Method : breakDownPdf Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_floorId='" + id + "',@p_mc_id='" + mcNo + "',@p_sku='" + sku + 
					"',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_manage_shopFloor_routines")
					.setParameter("actionType", "breakDownPdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : breakDownPdf Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}

}
