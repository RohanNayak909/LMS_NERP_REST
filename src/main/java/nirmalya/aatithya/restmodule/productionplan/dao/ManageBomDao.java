package nirmalya.aatithya.restmodule.productionplan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.productionplan.GenerateBomDetailsParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.productionplan.model.ManageBomRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ManageBomDao {

	Logger logger = LoggerFactory.getLogger(ManageBomDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemlist(String org, String orgDiv) {
		logger.info("Method : getItemlist Dao starts");

		List<DropDownModel> getItemlist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_bom_routines")
					.setParameter("actionType", "getitemlist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getItemlist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getItemlist Dao ends");

		return getItemlist;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemSublist(String org, String orgDiv) {
		logger.info("Method : getItemSublist Dao starts");

		List<DropDownModel> getItemsublist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_bom_routines")
					.setParameter("actionType", "getItemsublist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getItemsublist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getItemSublist Dao ends");

		return getItemsublist;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getunitlist(String org, String orgDiv) {
		logger.info("Method : getunitlist Dao starts");

		List<DropDownModel> getunitlist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_bom_routines")
					.setParameter("actionType", "getunitlist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getunitlist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getunitlist Dao ends");

		return getunitlist;
	}

	// add Student
	public ResponseEntity<JsonResponse<List<ManageBomRestModel>>> addBomDetails(List<ManageBomRestModel> bomDetails) {
		logger.info("Method : addBomDetails dao starts");
		System.out.println(bomDetails);
		JsonResponse<List<ManageBomRestModel>> resp = new JsonResponse<List<ManageBomRestModel>>();

		String value = GenerateBomDetailsParam.getBomDetailsParam(bomDetails);
		System.out.println("value===" + value);
		System.out.println("Modify bom===" + bomDetails.get(0).getBomid());
		try {

			if (bomDetails.get(0).getBomid() != null && bomDetails.get(0).getBomid() != "") {

				em.createNamedStoredProcedureQuery("production_plan_bom_routines")
						.setParameter("actionType", "modifyDomDetails").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("production_plan_bom_routines")
						.setParameter("actionType", "addBomDetails").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<ManageBomRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageBomRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addBomDetails dao ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewBomData(String orgName, String orgDivision) {
		logger.info("Method : viewBomData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_bom_routines")
					.setParameter("actionType", "viewBomDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewBomData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editBomData(String id, String orgName, String orgDivision) {
		logger.info("Method : editBomData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_bomId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_bom_routines")
					.setParameter("actionType", "getBomEdit").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editBomData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// deleteBom
	public ResponseEntity<JsonResponse<Object>> deleteBom(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteBom dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_bomId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("value==" + value);
			em.createNamedStoredProcedureQuery("production_plan_bom_routines").setParameter("actionType", "deleteBom")
					.setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteBom dao ends");
		return response;
	}

	// change Status.
	public ResponseEntity<JsonResponse<Object>> changeStatus(String status, String id, String orgName, String orgDivision) {
		logger.info("Method : changeStatus dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_status='" + status + "',@p_bomId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			em.createNamedStoredProcedureQuery("production_plan_bom_routines").setParameter("actionType", "changeStatus")
					.setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : changeStatus dao ends");
		return response;
	}
}
