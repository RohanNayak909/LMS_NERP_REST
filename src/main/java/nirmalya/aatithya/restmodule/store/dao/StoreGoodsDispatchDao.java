package nirmalya.aatithya.restmodule.store.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;
import nirmalya.aatithya.restmodule.warehouse.dao.RestWarehouseGoodsDispatchDao;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;
@Repository
public class StoreGoodsDispatchDao {
	Logger logger = LoggerFactory.getLogger(StoreGoodsDispatchDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	//viewRequestedDispatchGoods
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewStoreRequestedDispatchGoods(String orgName, String orgDivision) {
		logger.info("Method : viewStoreRequestedDispatchGoods Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeGoodsDispatchRoutine")
					.setParameter("actionType", "viewStoreRequestedDispatchGoods").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewStoreRequestedDispatchGoods Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}
	
	//getBlockingDataforDispatch
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getStoreBlockingDataforDispatch(String warehouse,String block,String orgName, String orgDiv) {
		logger.info("Method : getStoreBlockingDataforDispatch Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_warehouseId='" + warehouse + "',@p_blockId='" + block + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeGoodsDispatchRoutine")
					.setParameter("actionType", "getStoreBlockingDataforDispatch").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : getStoreBlockingDataforDispatch Dao ends");
		return resp;

	}
	
	//Save
	public JsonResponse<StoreRomeModel> modifyStoreDispatchData(String warehouseId, String blockId,String bdata, String orgName,String orgDivision) {
		logger.info("Method : modifyStoreDispatchData starts");

		JsonResponse<StoreRomeModel> resp = new JsonResponse<StoreRomeModel>();
		try {
			
			String value = "SET @p_warehouseId='" + warehouseId + "',@p_blockId='" + blockId + "',@p_bdata='(" + bdata + ")',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision +"';";
			System.out.println("value==="+value);
			em.createNamedStoredProcedureQuery("storeGoodsDispatchRoutine").setParameter("actionType", "modifyStoreDispatchData")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Goods Dispatched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		System.out.println("resp==="+resp);
		logger.info("Method : modifyStoreDispatchData ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse viewStoreblockDispatch(String rmId,String blockId,String orgName, String orgDiv) {
		logger.info("Method : viewStoreblock Dao startssssssssssssssssssssss");

		JsonResponse resp = new JsonResponse();

		try {
			String value = "SET @p_rmId='" + rmId + "',@p_blockId='" + blockId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeGoodsDispatchRoutine")
					.setParameter("actionType", "viewStoreblockDispatch").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : viewStoreblockDispatch Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

}
