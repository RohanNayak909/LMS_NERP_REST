package nirmalya.aatithya.restmodule.warehouse.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateWarehouseStackingParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@Repository
public class WarehouseStackingDao {
	Logger logger = LoggerFactory.getLogger(WarehouseStackingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// viewRequestedStackingGoods

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRequestedStackingGoods(String orgName, String orgDivision, String pageno,
			String type) {
		logger.info("Method : viewRequestedStackingGoods Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pageno='" + pageno
					+ "', @p_type='" + type + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseStackingRoutine")
					.setParameter("actionType", "viewRequestedStackingGoods").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewRequestedStackingGoods Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}

	// getStackingData
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllocationDataforStacking(String warehouse, String allocate, String orgName,
			String orgDiv) {
		logger.info("Method : getBlockingDataforDispatch Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_warehouseId='" + warehouse + "',@p_allocate='" + allocate + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseStackingRoutine")
					.setParameter("actionType", "getAllocationDataforStacking").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : getAllocationDataforStacking Dao ends");
		return resp;

	}

	// Save
	public JsonResponse<Object> modifyStackingData(List<DropDownModel> data) {
		logger.info("Method : modifyStackingData starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		String bdata = "";
		if(data.size() > 0) {
			for(DropDownModel m : data) {
				bdata = bdata + "\"" + m.getCode() + "\"," ;
			}
			if(bdata != "" && bdata != null) {
				bdata = bdata.substring(0, bdata.length() - 1);
			}
		}
		
		try {
			String value = "SET @p_warehouseId='" + data.get(0).getKey() + "',@p_allocateId='" + data.get(0).getName() + "',@p_bdata='("
					+ bdata + ")',@p_org='" + data.get(0).getOrgName() + "',@p_orgDiv='" + data.get(0).getOrgDivision() + "',@p_stackBy='" + data.get(0).getCreatedBy()
					+ "';";
			System.out.println("value===" + value);
			em.createNamedStoredProcedureQuery("warehouseStackingRoutine")
					.setParameter("actionType", "modifyStackingData").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Stacked successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}

		logger.info("Method : modifyStackingData ends");
		return resp;
	}

	// rackList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> binLists(String rackId, String binId, String orgName,
			String orgDiv) {

		logger.info("Method : binLists starts");
		List<DropDownModel> rackList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_rackId='" + rackId + "',@p_binId='" + binId + "',@p_org='" + orgName + "',@p_orgDiv='"
				+ orgDiv + "';";
		System.out.println("racklistttttttttttttttttttttttt" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseStackingRoutine")
					.setParameter("actionType", "binLists").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				rackList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			resp.setBody(rackList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : binLists ends");
		System.out.println("cccccccccccc ++++" + response);
		return response;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse editData(String rmId, String orgName, String orgDiv) {
		logger.info("Method : editData Dao startssssssssssssssssssssss");

		JsonResponse resp = new JsonResponse();

		try {
			String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseStackingRoutine")
					.setParameter("actionType", "editData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : editData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	public ResponseEntity<JsonResponse<Object>> saveStackdata(WirehouseRomeModel wirehouseRomeModel) {
		logger.info("Method : saveStackdata starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		System.out.println("=====>>>>>" + wirehouseRomeModel);

		try {
			String values = GenerateWarehouseStackingParameter.saveStackdataParam(wirehouseRomeModel);
			System.out.println("values>>>>>>>>>>===" + values);

			em.createNamedStoredProcedureQuery("warehouseStackingRoutine").setParameter("actionType", "saveStackdata")
					.setParameter("actionValue", values).execute();

			resp.setCode("success");
			resp.setMessage("Data Saved Successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveStackdata ends");
		return response;
	}
}
