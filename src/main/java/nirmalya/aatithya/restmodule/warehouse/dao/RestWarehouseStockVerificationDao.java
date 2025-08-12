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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestWarehouseStockVerificationDao {
	Logger logger = LoggerFactory.getLogger(RestWarehouseStockVerificationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> zoneListData(String id,String orgName, String orgDiv) {

		logger.info("Method : zoneListData starts");
		List<DropDownModel> zoneList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_warehouseId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		//System.out.println("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseStockVerificationRoutine")
					.setParameter("actionType", "zoneListData").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				zoneList.add(dropDownModel);
			}
			resp.setBody(zoneList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : zoneListData ends");
		//System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getWarehouseOpenListData(String warehouseId,String orgName, String orgDiv) {
		logger.info("Method : getWarehouseOpenListData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_warehouseId='" + warehouseId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		//	System.out.println("values****************************" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseStockVerificationRoutine")
					.setParameter("actionType", "getWarehouseOpenListData").setParameter("actionValue", values)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getWarehouseOpenListData Dao ends");
		//System.out.println("resp****************************" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> rackListData(String id,String orgName, String orgDiv) {

		logger.info("Method : rackListData starts");
		List<DropDownModel> rackList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_rackId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		//System.out.println("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseStockVerificationRoutine")
					.setParameter("actionType", "rackListData").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				rackList.add(dropDownModel);
			}
			resp.setBody(rackList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : rackListData ends");
		//System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}	

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> binListData(String id,String orgName, String orgDiv) {

		logger.info("Method : binListData starts");
		List<DropDownModel> binList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_rackId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		//System.out.println("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseStockVerificationRoutine")
					.setParameter("actionType", "binListData").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				binList.add(dropDownModel);
			}
			resp.setBody(binList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : binListData ends");
		//System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}	
	

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getStockVerificationData(String warehouseId,String zoneId,String categoryId,
			String itemName,String rackId,String binId,String orgName, String orgDiv) {
		logger.info("Method : getStockVerificationData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_warehouseId='" + warehouseId + "',@p_zoneId='" + zoneId + "',@p_categoryId='" + categoryId + "',@p_itemName='" + itemName + "',@p_rackId='" + rackId + "',@p_binId='" + binId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			//System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseStockVerificationRoutine")
					.setParameter("actionType", "getStockVerificationData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getStockVerificationData Dao ends");
		//System.out.println("resp****************************" + resp);
		return resp;

	}
	

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewstockdetails(String rmId,String allocateid,String orgName, String orgDivision) {
		logger.info("Method : viewstockdetails Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_rmId='" + rmId + "',@p_allocateid='" + allocateid + "', @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseStockVerificationRoutine")
					.setParameter("actionType", "viewstockdetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewstockdetails Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	
}
