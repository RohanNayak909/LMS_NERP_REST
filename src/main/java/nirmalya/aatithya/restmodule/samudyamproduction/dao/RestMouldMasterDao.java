package nirmalya.aatithya.restmodule.samudyamproduction.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateMoldmasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestCheckingDetailsModel;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestMouldMasterModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestMouldMasterDao {

	Logger logger = LoggerFactory.getLogger(RestMouldMasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager entityManager;
	
	//getPatternTypeList
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPatternTypeList(String org,String orgDiv) {
		logger.info("Method : getPatternTypeList starts");
		List<DropDownModel> patternTypeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("nerp_production_moldRoutines")
					.setParameter("actionType", "getPatternTypeList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				patternTypeList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("patternTypeList==="+patternTypeList);
		logger.info("Method : getPatternTypeList ends");
		return patternTypeList;
	}
	//getMoldTypeList
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getMoldTypeList(String org,String orgDiv) {
		logger.info("Method : getMoldTypeList starts");
		List<DropDownModel> moldTypeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("nerp_production_moldRoutines")
					.setParameter("actionType", "getMoldTypeList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				moldTypeList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getMoldTypeList ends");
		return moldTypeList;
	}
	// ViewMoldMasterView
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCheckingDetailsModel>>> viewCheckingDetailsType(String org,
			String orgDiv) {
		logger.info("Method : viewCheckingDetailsType starts");
		List<RestCheckingDetailsModel> respList = new ArrayList<RestCheckingDetailsModel>();
		JsonResponse<List<RestCheckingDetailsModel>> resp = new JsonResponse<List<RestCheckingDetailsModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("nerp_production_moldRoutines")
					.setParameter("actionType", "viewcheckingtype").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestCheckingDetailsModel travelModel = new RestCheckingDetailsModel(m[0], m[1], m[2], m[3], m[4]);
				respList.add(travelModel);
				if (respList.size() > 0) {
					resp.setBody(respList);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} else {
					resp.setBody(respList);
					resp.setCode("success");
					resp.setMessage("Data not found");
				}
			}
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("viewReimbursement: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(respList);
			resp.setCode("success");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCheckingDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestCheckingDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : RestCheckingDetailsModel ends");
		return response;
	}
	// restAddMoldMaster

	public ResponseEntity<JsonResponse<List<RestMouldMasterModel>>> restAddMoldMaster(RestMouldMasterModel moldModel) {
		logger.info("Method : restAddMoldMaster dao starts");
		JsonResponse<List<RestMouldMasterModel>> resp = new JsonResponse<List<RestMouldMasterModel>>();

		String value = GenerateMoldmasterParameter.getMoldMasterParam(moldModel);
		logger.info("value===" + value);
		try {
			if (moldModel.getMoldid() != null && moldModel.getMoldid() != "") {
				entityManager.createNamedStoredProcedureQuery("nerp_production_moldRoutines")
						.setParameter("actionType", "modifymold").setParameter("actionValue", value).execute();

			} else {

				entityManager.createNamedStoredProcedureQuery("nerp_production_moldRoutines")
						.setParameter("actionType", "addmold").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<RestMouldMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestMouldMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response===" + response);
		logger.info("Method : restAddMoldMaster dao ends");
		return response;
	}

//ViewMoldMasterView
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMouldMasterModel>>> ViewMoldMasterView(String org, String orgDiv) {
		logger.info("Method : ViewMoldMasterView starts");
		List<RestMouldMasterModel> respList = new ArrayList<RestMouldMasterModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("nerp_production_moldRoutines")
					.setParameter("actionType", "viewmoldmasterdata").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object DATE = null;
				if (m[3] != null) {
					DATE = DateFormatter.returnStringDate(m[3]);
				}
				Object FDATE = null;
				if (m[6] != null) {
					FDATE = DateFormatter.returnStringDate(m[6]);
				}
				Object TDATE = null;
				if (m[7] != null) {
					TDATE = DateFormatter.returnStringDate(m[7]);
				}
				RestMouldMasterModel mdata = new RestMouldMasterModel(m[0], m[1], m[2], DATE, m[4], m[5], FDATE, TDATE,m[8],m[9],m[10],m[11]);
				respList.add(mdata);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestMouldMasterModel>> resp = new JsonResponse<List<RestMouldMasterModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestMouldMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestMouldMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : ViewMoldMasterView ends");
		return response;
	}

//editMoldMaster
	@SuppressWarnings("unchecked")
	public RestMouldMasterModel editMoldMaster(String bomid) {
		logger.info("Method : editMoldMaster Dao starts");

		logger.info("======>>>>" + bomid);
		RestMouldMasterModel moldData = new RestMouldMasterModel();
		List<RestCheckingDetailsModel> itemList = new ArrayList<RestCheckingDetailsModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		JsonResponse<RestMouldMasterModel> resp = new JsonResponse<RestMouldMasterModel>();

		String value = "SET @p_moldId='" + bomid + "';";

		logger.info("ssssssssssssssss" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("nerp_production_moldRoutines")
					.setParameter("actionType", "editmasterdata").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object DATE = null;
				if (m[3] != null) {
					DATE = DateFormatter.returnStringDate(m[3]);
				}
				Object FDATE = null;
				if (m[6] != null) {
					FDATE = DateFormatter.returnStringDate(m[6]);
				}
				Object TDATE = null;
				if (m[7] != null) {
					TDATE = DateFormatter.returnStringDate(m[7]);
				}
				moldData = new RestMouldMasterModel(m[0],m[1],m[2],DATE,m[4],m[5],FDATE,TDATE,m[8],m[9],m[10],m[11]);
			}
			try {
				List<Object[]> y = em.createNamedStoredProcedureQuery("nerp_production_moldRoutines")
						.setParameter("actionType", "editchilddata").setParameter("actionValue", value).getResultList();

				for (Object[] m : y) {
					RestCheckingDetailsModel item = new RestCheckingDetailsModel(m[0], m[1], m[2], m[3], m[4]);
					itemList.add(item);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			moldData.setActivity(itemList);
			try {
				List<Object[]> y = em.createNamedStoredProcedureQuery("nerp_production_moldRoutines")
						.setParameter("actionType", "editchilddocuments").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : y) {
					InventoryVendorDocumentModel items = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
					docList.add(items);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			moldData.setDocumentList(docList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(moldData);
		if (resp.getBody() == null) {
			// resp.setSuccess(false);
			// resp.setCode(ResponseStatus.UNSUCCESS.getCode());
			// resp.setMessage(ResponseStatus.UNSUCCESS.getMessage());

		} else {
			// resp.setSuccess(true);
			// resp.setCode(ResponseStatus.SUCCESS.getCode());
			// resp.setMessage("Data fetched successfully");
		}
		logger.info("=====>>>resp" + resp);
		logger.info("Method : editMoldMaster Dao ends");
		return moldData;
	}
	// deleteMoldMaster

	public JsonResponse<Object> deleteMoldMaster(String mlid, String org, String orgDiv) {
		logger.info("Method : deleteMoldMaster starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_moldid='" + mlid + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("nerp_production_moldRoutines").setParameter("actionType", "deleteMoldMaster")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Mold Delete successfully");
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			} catch (Exception e1) {
				resp.setCode("failed");
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			logger.error("deleteMoldMaster: " + e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : deleteMoldMaster ends");
		return resp;
	}
}
