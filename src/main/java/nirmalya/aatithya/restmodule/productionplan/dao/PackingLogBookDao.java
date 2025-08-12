package nirmalya.aatithya.restmodule.productionplan.dao;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParamPackingLogBook;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.productionplan.model.PackingLotManufacturRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.Packing2AFSSMachineRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingALCRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingInitialCheckRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingLogBookRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingFCWLRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class PackingLogBookDao {

	Logger logger = LoggerFactory.getLogger(PackingLogBookDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	public ResponseEntity<JsonResponse<PackingLogBookRestModel>> addPackingLogbook(PackingLogBookRestModel offDay) {

		logger.info("Method : addPackingLogbook starts");
		JsonResponse<PackingLogBookRestModel> resp = new JsonResponse<PackingLogBookRestModel>();
		PackingLogBookRestModel listData = new PackingLogBookRestModel();
		String values = GenerateParamPackingLogBook.getPackingLogBookParam(offDay);
		logger.info("valuess to add ----"+values);
		try {

			System.out.println("values add >>>>>>>" + values);
			if (offDay.getPackId() == "" || offDay.getPackId() == null) {
				Object result = em.createNamedStoredProcedureQuery("packing_logBook_routines")
		                  .setParameter("actionType", "addPackingLogbook")
		                  .setParameter("actionValue", values)
		                  .getSingleResult();
				PackingLogBookRestModel restPayroll = new PackingLogBookRestModel(result);
				System.out.println("restPayroll---"+restPayroll);
				resp.setBody( listData);
				Util.setJsonResponse(resp, restPayroll, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}
			else {
				System.out.println("values edit >>>>>>>" + values);
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "modifyPackingLogbook").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
				
			}

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		ResponseEntity<JsonResponse<PackingLogBookRestModel>> response = new ResponseEntity<JsonResponse<PackingLogBookRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addEarnedaddPackingLogbookLeave ends"+response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPackingLogbook(String org, String orgDiv, String pageno) {
		logger.info("Method : viewPackingLogbook Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_pageno='" + pageno + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "viewPackingLogbook").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPackingLogbook Dao ends"+resp);
		return resp;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEditPackingLogbook(String id, String org, String orgDiv) {
		logger.info("Method : viewEditPackingLogbook Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "viewEditPackingLogbook").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEditPackingLogbook Dao ends"+resp);
		return resp;
	}
	public JsonResponse<Object> deletePackingLogbook(String id, String org, String orgDiv) {
		logger.info("Method : deletePackingLogbook Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_id='" +id  + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values>>>>>>>" + value);
			em.createNamedStoredProcedureQuery("packing_logBook_routines")
			.setParameter("actionType", "deletePackingLogbook").setParameter("actionValue", value).execute();
			//resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Deleted successfully");
			} catch (Exception e) {
				resp.setCode("unsuccess");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : deletePackingLogbook Dao ends"+resp);
		return resp;
	}
	// Lot Manufacturingggg
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEditlotmanagement(String id, String org, String orgDiv) {
		logger.info("Method : viewEditlotmanagement Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "viewEditlotmanagement").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEditlotmanagement Dao ends"+resp);
		return resp;
	}
	public ResponseEntity<JsonResponse<PackingLotManufacturRestModel>> addLotManufacture(
			PackingLotManufacturRestModel offDay) {
		logger.info("Method : addLotManufacture starts");
		JsonResponse<PackingLotManufacturRestModel> resp = new JsonResponse<PackingLotManufacturRestModel>();
		PackingLotManufacturRestModel listData = new PackingLotManufacturRestModel();
		String values = GenerateParamPackingLogBook.getLotManufactureParam(offDay);
		logger.info("valuess to add ----"+values);
		try {

			System.out.println("values add >>>>>>>" + values);
			if (offDay.getManufactureId() == "" || offDay.getManufactureId() == null) {
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "addLotManufacture").setParameter("actionValue", values).execute();
				resp.setBody( listData);
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}
			else {
				System.out.println("values edit >>>>>>>" + values);
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "modifyLotManufacture").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
				
			}

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		ResponseEntity<JsonResponse<PackingLotManufacturRestModel>> response = new ResponseEntity<JsonResponse<PackingLotManufacturRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addLotManufacture ends"+response);
		return response;
	}
// 2A. FSS Machine Setting
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> add2AFSSMachine(
			Packing2AFSSMachineRestModel offDay) {
		logger.info("Method : addLotManufacture starts");
		JsonResponse<Packing2AFSSMachineRestModel> resp = new JsonResponse<Packing2AFSSMachineRestModel>();
		Packing2AFSSMachineRestModel listData = new Packing2AFSSMachineRestModel();
		String values = GenerateParamPackingLogBook.get2AFSSMachineParam(offDay);
		logger.info("valuess to add ----"+values);
		try {
			System.out.println("values add >>>>>>>" + values);
			if (offDay.getId() == "" || offDay.getId() == null) {
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "add2AFSSMachine").setParameter("actionValue", values).execute();
				resp.setBody( listData);
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}
			else {
				System.out.println("values edit >>>>>>>" + values);
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "modify2AFSSMachine").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> response = new ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>>(resp, HttpStatus.CREATED);
		logger.info("Method : addLotManufacture ends"+response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> view2AFSSMachine(String id, String org, String orgDiv) {
		logger.info("Method : view2AFSSMachine Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("view2AFSSMachine valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "view2AFSSMachine").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : view2AFSSMachine Dao ends"+resp);
		return resp;
	}
	
// 2B. FSS Machine Setting
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> save2BFSSMachine(
			Packing2AFSSMachineRestModel offDay) {
		logger.info("Method : save2BFSSMachine starts");
		JsonResponse<Packing2AFSSMachineRestModel> resp = new JsonResponse<Packing2AFSSMachineRestModel>();
		Packing2AFSSMachineRestModel listData = new Packing2AFSSMachineRestModel();
		String values = GenerateParamPackingLogBook.get2BFSSMachineParam(offDay);
		logger.info("valuess to add ----"+values);
		try {
			System.out.println("values add >>>>>>>" + values);
			if (offDay.getId() == "" || offDay.getId() == null) {
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "add2BFSSMachine").setParameter("actionValue", values).execute();
				resp.setBody( listData);
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}
			else {
				System.out.println("values edit >>>>>>>" + values);
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "modify2BFSSMachine").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> response = new ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>>(resp, HttpStatus.CREATED);
		logger.info("Method : save2BFSSMachine ends"+response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> view2BFSSMachine(String id, String org, String orgDiv) {
		logger.info("Method : view2BFSSMachine Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("view2BFSSMachine valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "view2BFSSMachine").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : view2BFSSMachine Dao ends"+resp);
		return resp;
	}
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> save5INBBPBCR(
			Packing2AFSSMachineRestModel offDay) {
		logger.info("Method : save5INBBPBCR starts");
		JsonResponse<Packing2AFSSMachineRestModel> resp = new JsonResponse<Packing2AFSSMachineRestModel>();
		Packing2AFSSMachineRestModel listData = new Packing2AFSSMachineRestModel();
		String values = GenerateParamPackingLogBook.get2BFSSMachineParam(offDay);
		logger.info("valuess to add ----"+values);
		try {
			System.out.println("values add >>>>>>>" + values);
			if (offDay.getId() == "" || offDay.getId() == null) {
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "add5INBBPBCR").setParameter("actionValue", values).execute();
				resp.setBody( listData);
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}
			else {
				System.out.println("values edit >>>>>>>" + values);
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "modify5INBBPBCR").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> response = new ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>>(resp, HttpStatus.CREATED);
		logger.info("Method : save5INBBPBCR ends"+response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> view5INBBPBCR(String id, String org, String orgDiv) {
		logger.info("Method : view5INBBPBCR starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("view2BFSSMachine valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "view5INBBPBCR").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : view5INBBPBCR Dao ends"+resp);
		return resp;
	}
//6. RH/TEMP CHECKS-SACHET / POUCH LINE
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> saveRHTemp(
			Packing2AFSSMachineRestModel offDay) {
		logger.info("Method : saveRHTemp starts");
		JsonResponse<Packing2AFSSMachineRestModel> resp = new JsonResponse<Packing2AFSSMachineRestModel>();
		Packing2AFSSMachineRestModel listData = new Packing2AFSSMachineRestModel();
		String values = GenerateParamPackingLogBook.get2BFSSMachineParam(offDay);
		logger.info("valuess to add ----"+values);
		try {
			System.out.println("values add >>>>>>>" + values);
			if (offDay.getId() == "" || offDay.getId() == null) {
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "addRHTemp").setParameter("actionValue", values).execute();
				resp.setBody( listData);
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}
			else {
				System.out.println("values edit >>>>>>>" + values);
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "modifyRHTemp").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> response = new ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>>(resp, HttpStatus.CREATED);
		logger.info("Method : saveRHTemp ends"+response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRHTemp(String id, String org, String orgDiv) {
		logger.info("Method : view5INBBPBCR starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("viewRHTemp valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "viewRHTemp").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewRHTemp Dao ends"+resp);
		return resp;
	}
//9. Challenge Test - Sachet / Pouch Line	
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> saveChalTest(
			Packing2AFSSMachineRestModel offDay) {
		logger.info("Method : saveChalTest starts");
		JsonResponse<Packing2AFSSMachineRestModel> resp = new JsonResponse<Packing2AFSSMachineRestModel>();
		Packing2AFSSMachineRestModel listData = new Packing2AFSSMachineRestModel();
		String values = GenerateParamPackingLogBook.get2BFSSMachineParam(offDay);
		logger.info("valuess to add ----"+values);
		try {
			System.out.println("ChalTest add >>>>>>>" + values);
			if (offDay.getId() == "" || offDay.getId() == null) {
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "addChalTest").setParameter("actionValue", values).execute();
				resp.setBody( listData);
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}
			else {
				System.out.println("values edit >>>>>>>" + values);
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "modifyChalTest").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> response = new ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>>(resp, HttpStatus.CREATED);
		logger.info("Method : saveChalTest ends"+response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getChalTest(String id, String org, String orgDiv) {
		logger.info("Method : getChalTest starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("viewRHTemp valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "viewChalTest").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getChalTest Dao ends"+resp);
		return resp;
	}
//14. GTP	
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> saveGTP(
			Packing2AFSSMachineRestModel offDay) {
		logger.info("Method : saveGTP starts");
		JsonResponse<Packing2AFSSMachineRestModel> resp = new JsonResponse<Packing2AFSSMachineRestModel>();
		Packing2AFSSMachineRestModel listData = new Packing2AFSSMachineRestModel();
		String values = GenerateParamPackingLogBook.get2BFSSMachineParam(offDay);
		logger.info("valuess to add ----"+values);
		try {
			System.out.println("GTP add >>>>>>>" + values);
			if (offDay.getId() == "" || offDay.getId() == null) {
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "addGTP").setParameter("actionValue", values).execute();
				resp.setBody( listData);
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}
			else {
				System.out.println("values edit >>>>>>>" + values);
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "modifyGTP").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> response = new ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>>(resp, HttpStatus.CREATED);
		logger.info("Method : saveGTP ends"+response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getGTP(String id, String org, String orgDiv) {
		logger.info("Method : getGTP starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("viewRHTemp valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "viewGTP").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getGTP Dao ends"+resp);
		return resp;
	}
	//14. CTQ	
	public ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> saveCTQ(
			Packing2AFSSMachineRestModel offDay) {
		logger.info("Method : saveCTQ starts");
		JsonResponse<Packing2AFSSMachineRestModel> resp = new JsonResponse<Packing2AFSSMachineRestModel>();
		Packing2AFSSMachineRestModel listData = new Packing2AFSSMachineRestModel();
		String values = GenerateParamPackingLogBook.getCTQParam(offDay);
		logger.info("valuess to add ----"+values);
		try {
			System.out.println("CTQ add >>>>>>>" + values);
			if (offDay.getId() == "" || offDay.getId() == null) {
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "addCTQ").setParameter("actionValue", values).execute();
				resp.setBody( listData);
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}
			else {
				System.out.println("values edit >>>>>>>" + values);
				em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "modifyCTQ").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>> response = new ResponseEntity<JsonResponse<Packing2AFSSMachineRestModel>>(resp, HttpStatus.CREATED);
		logger.info("Method : saveCTQ ends"+response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCTQ(String id, String org, String orgDiv) {
		logger.info("Method : getCTQ starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("viewRHTemp valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "viewCTQ").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCTQ Dao ends"+resp);
		return resp;
	}
//	initial check
	public ResponseEntity<JsonResponse<PackingInitialCheckRestModel>> saveInitialCheck(
			PackingInitialCheckRestModel offDay) {
			logger.info("Method : saveInitialCheck starts");
			JsonResponse<PackingInitialCheckRestModel> resp = new JsonResponse<PackingInitialCheckRestModel>();
			String values = GenerateParamPackingLogBook.getInitialCheckParam(offDay);
			logger.info("valuess to add ----"+values);
			try {
				System.out.println("InitialCheck add >>>>>>>" + values);
				if (offDay.getId() == "" || offDay.getId() == null) {
					em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "addInitialCheck").setParameter("actionValue", values).execute();
					//resp.setBody( listData);
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
				}
				else {
					System.out.println("values edit >>>>>>>" + values);
					em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "modifyInitialCheck").setParameter("actionValue", values).execute();
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
				}
			} catch (Exception e) {
				String[] err = serverDao.errorProcedureCall(e);
				logger.error("Error " + err[1]);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			ResponseEntity<JsonResponse<PackingInitialCheckRestModel>> response = new ResponseEntity<JsonResponse<PackingInitialCheckRestModel>>(resp, HttpStatus.CREATED);
			logger.info("Method : saveInitialCheck ends"+response);
			return response;
	}	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getInitialCheck(String id, String org, String orgDiv) {
		logger.info("Method : getInitialCheck starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("viewRHTemp valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "viewInitialCheck").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInitialCheck Dao ends"+resp);
		return resp;
	}
//	ALC
	public ResponseEntity<JsonResponse<PackingALCRestModel>> saveALC(
			PackingALCRestModel offDay) {
			logger.info("Method : saveALC starts");
			JsonResponse<PackingALCRestModel> resp = new JsonResponse<PackingALCRestModel>();
			PackingALCRestModel listData = new PackingALCRestModel();
			String values = GenerateParamPackingLogBook.getALCParam(offDay);
			logger.info("valuess to add ----"+values);
			try {
				System.out.println("ALC add >>>>>>>" + values);
				if (offDay.getId() == "" || offDay.getId() == null) {
					em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "addALC").setParameter("actionValue", values).execute();
					resp.setBody( listData);
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
				}
				else {
					System.out.println("values edit >>>>>>>" + values);
					em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "modifyALC").setParameter("actionValue", values).execute();
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
				}
			} catch (Exception e) {
				String[] err = serverDao.errorProcedureCall(e);
				logger.error("Error " + err[1]);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			ResponseEntity<JsonResponse<PackingALCRestModel>> response = new ResponseEntity<JsonResponse<PackingALCRestModel>>(resp, HttpStatus.CREATED);
			logger.info("Method : saveALC ends"+response);
			return response;
	}	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getALC(String id, String org, String orgDiv) {
		logger.info("Method : getALC starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("viewRHTemp valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "viewALC").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getALC Dao ends"+resp);
		return resp;
	}
// FCWL
	public ResponseEntity<JsonResponse<PackingFCWLRestModel>> saveFCWL(
			PackingFCWLRestModel offDay) {
			logger.info("Method : saveFCWL starts");
			JsonResponse<PackingFCWLRestModel> resp = new JsonResponse<PackingFCWLRestModel>();
			PackingFCWLRestModel listData = new PackingFCWLRestModel();
			String values = GenerateParamPackingLogBook.getFCWLParam(offDay);
			logger.info("valuess to add ----"+values);
			try {
				System.out.println("FCWL add >>>>>>>" + values);
				if (offDay.getId() == "" || offDay.getId() == null) {
					em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "addFCWL").setParameter("actionValue", values).execute();
					resp.setBody( listData);
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
				}
				else {
					System.out.println("values edit >>>>>>>" + values);
					em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "modifyFCWL").setParameter("actionValue", values).execute();
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
				}
			} catch (Exception e) {
				String[] err = serverDao.errorProcedureCall(e);
				logger.error("Error " + err[1]);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			ResponseEntity<JsonResponse<PackingFCWLRestModel>> response = new ResponseEntity<JsonResponse<PackingFCWLRestModel>>(resp, HttpStatus.CREATED);
			logger.info("Method : saveFCWL ends"+response);
			return response;
	}	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getFCWL(String id, String org, String orgDiv) {
		logger.info("Method : getFCWL starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("viewRHTemp valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
				.setParameter("actionType", "viewFCWL").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFCWL Dao ends"+resp);
		return resp;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> logManufacturePdf(String id, String org, String orgDiv) {
		logger.info("Method : logManufacturePdf Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_id='" + id +"',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "logManufacturePdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : logManufacturePdf Dao ends"+resp);
		return resp;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPackingLogbookSearch(String org, String orgDiv, String searchValue) {
		logger.info("Method : viewPackingLogbookSearch Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_searchValue='" + searchValue + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "viewPackingLogbookSearch").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPackingLogbookSearch Dao ends"+resp);
		return resp;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getLineLists(String id, String org, String orgDiv) {
		logger.info("Method : viewPackingLogbookSearch Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_id='" + id + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("packing_logBook_routines")
					.setParameter("actionType", "getLineListsLmr").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPackingLogbookSearch Dao ends"+resp);
		return resp;
	}
}
