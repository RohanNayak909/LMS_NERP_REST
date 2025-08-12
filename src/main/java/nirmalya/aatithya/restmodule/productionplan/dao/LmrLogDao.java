package nirmalya.aatithya.restmodule.productionplan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.productionplan.GenerateLmrLogParams;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.productionplan.model.LmrLogRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingLogBookRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class LmrLogDao {

	Logger logger = LoggerFactory.getLogger(LmrLogDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> lmrMachineList(String id, String orgName, String orgDivision) {
		logger.info("Method : lmrMachineList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
					.setParameter("actionType", "getLineListsLmr").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data fetched failed!");
		}
		logger.info("Method : lmrMachineList Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}

	// Add

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addLmrLog(LmrLogRestModel offDay) {

		logger.info("Method : addLmrLog starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String values = GenerateLmrLogParams.getLmrLogParam(offDay);

		logger.info("valuess to add ----" + values);
		try {

			System.out.println("values add >>>>>>>" + values);
			if (offDay.getPackId() == "" || offDay.getPackId() == null) {
				List<Object[]> result = em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
						.setParameter("actionType", "addLmrLog").setParameter("actionValue", values).getResultList();
				/*
				 * PackingLogBookRestModel restPayroll = new PackingLogBookRestModel(result);
				 * System.out.println("restPayroll---" + restPayroll);
				 */
				resp.setBody(result.get(0));
				/*
				 * resp.setCode("success"); resp.setMessage("Data fetched successfully");
				 */
				Util.setJsonResponse(resp, result, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		/*
		 * ResponseEntity<JsonResponse<LmrLogRestModel>> response = new
		 * ResponseEntity<JsonResponse<LmrLogRestModel>>(resp, HttpStatus.CREATED);
		 */

		logger.info("Method : addLmrLog ends" + resp);
		return resp;
	}

	// view

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewLmrLog(String org, String orgDiv, String pageno) {
		logger.info("Method : viewLmrLog Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_pageNo='" + pageno + "';";
			logger.info("valuesss------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
					.setParameter("actionType", "viewLmrLog").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewLmrLog Dao ends" + resp);
		return resp;
	}

	// view edit

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editLmrLogView(String id, String itemFlag, String org, String orgDiv) {
		logger.info("Method : editLmrLogView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id + "',@p_itemFlag='" + itemFlag + "',@p_org='" + org + "',@p_orgDiv='"
					+ orgDiv + "';";
			logger.info("valuesss------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
					.setParameter("actionType", "editLmrLogView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editLmrLogView Dao ends" + resp);
		return resp;
	}

	// Add part b

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<LmrLogRestModel>> addPartBIngd(LmrLogRestModel offDay) {

		logger.info("Method : addPartBIngd starts");
		JsonResponse<LmrLogRestModel> resp = new JsonResponse<LmrLogRestModel>();
		// LmrLogRestModel listData = new LmrLogRestModel();
		String values = GenerateLmrLogParams.getPartBIngredientParam(offDay);

		logger.info("valuess to add ----" + values);
		try {

			System.out.println("values add >>>>>>>" + values);

			em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
					.setParameter("actionType", "addPartBIngd").setParameter("actionValue", values).execute();

			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		ResponseEntity<JsonResponse<LmrLogRestModel>> response = new ResponseEntity<JsonResponse<LmrLogRestModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addLmrLog ends" + response);
		return response;
	}

	// view edit

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> partBIngredientView(String id, String org, String orgDiv) {
		logger.info("Method : partBIngredientView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
					.setParameter("actionType", "partBIngredientView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : partBIngredientView Dao ends" + resp);
		return resp;
	}

	// Add femto blending

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<LmrLogRestModel>> addFemtoBlending(LmrLogRestModel offDay) {

		logger.info("Method : addFemtoBlending starts");
		JsonResponse<LmrLogRestModel> resp = new JsonResponse<LmrLogRestModel>();
		// LmrLogRestModel listData = new LmrLogRestModel();
		String values = GenerateLmrLogParams.getFemtoBlendingParam(offDay);

		logger.info("valuess to add ----" + values);

		try {

			System.out.println("values add >>>>>>>" + values);

			em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
					.setParameter("actionType", "addFemtoBlending").setParameter("actionValue", values).execute();

			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}

		ResponseEntity<JsonResponse<LmrLogRestModel>> response = new ResponseEntity<JsonResponse<LmrLogRestModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addFemtoBlending ends" + response);
		return response;
	}

	// Add weighing scale

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<LmrLogRestModel>> addWeighingScale(LmrLogRestModel offDay) {

		logger.info("Method : addWeighingScale starts");
		JsonResponse<LmrLogRestModel> resp = new JsonResponse<LmrLogRestModel>();
		// LmrLogRestModel listData = new LmrLogRestModel();
		String values = GenerateLmrLogParams.getWeaghingScaleParam(offDay);

		logger.info("valuess to add ----" + values);

		try {

			System.out.println("values add >>>>>>>" + values);

			em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
					.setParameter("actionType", "addWeighingScale").setParameter("actionValue", values).execute();

			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}

		ResponseEntity<JsonResponse<LmrLogRestModel>> response = new ResponseEntity<JsonResponse<LmrLogRestModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addWeighingScale ends" + response);
		return response;
	}

	// Add area line clearance

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<LmrLogRestModel>> addAreaLineClearance(LmrLogRestModel offDay) {

		logger.info("Method : addAreaLineClearance starts");
		JsonResponse<LmrLogRestModel> resp = new JsonResponse<LmrLogRestModel>();
		// LmrLogRestModel listData = new LmrLogRestModel();
		String values = GenerateLmrLogParams.getAreaLineClearanceParam(offDay);

		try {

			System.out.println("values add >>>>>>>" + values);

			em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
					.setParameter("actionType", "addAreaLineClearance").setParameter("actionValue", values).execute();

			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}

		ResponseEntity<JsonResponse<LmrLogRestModel>> response = new ResponseEntity<JsonResponse<LmrLogRestModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addAreaLineClearance ends" + response);
		return response;
	}

	// delete

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteLmrLog(String id, String org, String orgDiv) {
		logger.info("Method : deleteLmrLog Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------" + value);
			em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
					.setParameter("actionType", "deleteLmrLog").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Data Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UNsuccess");
			resp.setMessage("Data Deleted failed");
		}
		logger.info("Method : deleteLmrLog Dao ends" + resp);
		return resp;
	}

	/*
	 * 
	 * //getLineLists
	 * 
	 * @SuppressWarnings("unchecked") public List<DropDownModel>
	 * getLineListsLmr(String org, String orgDiv) {
	 * logger.info("Method : getLineListsLmr starts");
	 * 
	 * List<DropDownModel> getLineList = new ArrayList<DropDownModel>(); String
	 * value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';"; try {
	 * List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
	 * .setParameter("actionType", "getLineListsLmr").setParameter("actionValue",
	 * value).getResultList(); for (Object[] m : x) { DropDownModel dropDownModel =
	 * new DropDownModel(m[0], m[1]); getLineList.add(dropDownModel); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * logger.info("Method : getLineListsLmr ends"); return getLineList; }
	 */

	// Pdf.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> downloadLmrPdf(String id, String type, String orgName, String orgDivision) {
		logger.info("Method : downloadLmrPdf Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		System.out.println("values****************************" + value);
		List<Object[]> x = null;
		try {
			if (type.equals("partB")) {
				x = em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
						.setParameter("actionType", "dloadPartB").setParameter("actionValue", value).getResultList();
			} else if (type.equals("wScale")) {
				x = em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
						.setParameter("actionType", "wScaleDload").setParameter("actionValue", value).getResultList();
			} else if (type.equals("blending")) {
				x = em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
						.setParameter("actionType", "blendingDload").setParameter("actionValue", value).getResultList();
			} else if (type.equals("alc")) {
				x = em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
						.setParameter("actionType", "alcDload").setParameter("actionValue", value).getResultList();
			}

			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : downloadLmrPdf Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}

//getLineListsApi
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLineListsLmrApi(String org, String orgDiv) {

		logger.info("Method : getLineListsLmrApi starts");
		List<DropDownModel> lineList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
					.setParameter("actionType", "getLineListsLmr").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				lineList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			resp.setBody(lineList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getLineListsLmrApi ends");
		System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}

	// Search

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> lmrLogDataViewSearch(String orgName, String orgDivision, String searchValue) {
		logger.info("Method : lmrLogDataViewSearch Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_searchValue='" + searchValue
					+ "';";
			System.out.println("value>>>-----" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_lmrLog_routines")
					.setParameter("actionType", "lmrLogDataViewSearch").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : lmrLogDataViewSearch Dao ends");
		return resp;

	}

}
