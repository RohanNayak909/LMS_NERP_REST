package nirmalya.aatithya.restmodule.warehouse.dao;

import java.util.ArrayList;
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

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
import nirmalya.aatithya.restmodule.common.utils.GenerateStockTransferParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateWarehouseAllocationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateDispCartonsParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;
import nirmalya.aatithya.restmodule.warehouse.model.RestStockTransferModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@Repository
public class StockTransferDao {

	Logger logger = LoggerFactory.getLogger(StockTransferDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getStockTransferStackData(String warehouseId, String orgName, String orgDiv) {
		logger.info("Method : getStockTransferStackData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		// System.out.println("STOCK TRANSFER DAO CALLED<<<<<>>>>>");
		try {
			String values = "SET @p_warehouseId='" + warehouseId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			System.out.println("values****************************" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouse_stock_transfer_routines")
					.setParameter("actionType", "getStockTransferStackData").setParameter("actionValue", values)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : getStockTransferStackData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// add.

	public ResponseEntity<JsonResponse<RestStockTransferModel>> addStockTransfer(RestStockTransferModel av) {
		logger.info("Method : addStockTransfer dao starts");
		System.out.println(av);
		JsonResponse<RestStockTransferModel> resp = new JsonResponse<RestStockTransferModel>();

		try {
			String value = GenerateStockTransferParameter.getStockTrasfer(av);
			System.out.println("value===" + value);

			em.createNamedStoredProcedureQuery("warehouse_stock_transfer_routines")
					.setParameter("actionType", "addStockTransfer").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Goods Transfered Successfully");
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

		ResponseEntity<JsonResponse<RestStockTransferModel>> response = new ResponseEntity<JsonResponse<RestStockTransferModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addStockTransfer dao ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getStockTransferStackDataFilter(DropDownModel data) {
		logger.info("Method : getStockTransferStackDataFilter Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(data);
			System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouse_stock_transfer_routines")
					.setParameter("actionType", "getAvlBin").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}

		logger.info("Method : getStockTransferStackDataFilter Dao ends");
		return resp;

	}

	public ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> saveAllocation(
			List<WirehouseRomeModel> wirehouseRomeModel) {
		logger.info("Method : saveAllocation starts");
		
		JsonResponse<List<WirehouseRomeModel>> resp = new JsonResponse<List<WirehouseRomeModel>>();
		List<WirehouseRomeModel> listData = new ArrayList<WirehouseRomeModel>();

		try {
			String values = GenerateWarehouseAllocationParameter.saveAllocationParam(wirehouseRomeModel);
			
			System.out.println(values);
			
			em.createNamedStoredProcedureQuery("warehouse_stock_transfer_routines")
					.setParameter("actionType", "saveAllocation").setParameter("actionValue", values).execute();
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
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> response = new ResponseEntity<JsonResponse<List<WirehouseRomeModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveAllocation ends");
		return response;
	}

}
