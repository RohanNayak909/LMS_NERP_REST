package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
 
@Repository
public class WarehouseItemConfigurationDao {
	Logger logger = LoggerFactory.getLogger(WarehouseItemConfigurationDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
	
	//getItemListForWarehouseConfig
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemListForWarehouseAllocationConfig(String org,String orgDiv,String type) {
		logger.info("Method : getItemListForWarehouseAllocationConfig starts");
		
		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "', @p_type='" + type + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouse_item_configuration_routines")
					.setParameter("actionType", "getItemListForWarehouseAllocationConfig").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getItemListForWarehouseAllocationConfig ends");
		return itemList;
	}
	
	//viewWarehouseDetails
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewWarehouseDetails(String orgName, String orgDivision, String userId, String type) {
		logger.info("Method : viewWarehouseDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "', @p_type='" + type + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouse_item_configuration_routines")
					.setParameter("actionType", "viewWarehouseDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewWarehouseDetails Dao ends");
		return resp;
	}	
//viewAllocateitems
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAllocateItems(String orgName, String orgDivision, String whid,String type) {
		logger.info("Method : viewAllocateItems Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_whid='" + whid + "', @p_type='" + type + "';";
					
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouse_item_configuration_routines")
					.setParameter("actionType", "viewAllocateItems").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAllocateItems Dao ends");
		return resp;
	}	
//saveAllocateItems
	public JsonResponse<Object> saveAllocateItems(String orgName, String orgDivision,String userId,String sku,String whid,String minQty,String edit) {
		logger.info("Method : saveAllocateItems Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId +"',@p_sku='" + sku + "',@p_whid='" + whid + "',@p_minQty='" + minQty +"';";
			
			logger.info(value);	
			if(edit.equals("Yes")){
				em.createNamedStoredProcedureQuery("warehouse_item_configuration_routines")
				.setParameter("actionType", "modifyAllocateItems").setParameter("actionValue", value).execute();
			resp.setBody(null);
			resp.setCode("success");
			resp.setMessage("Allocated item modified successfully.");
			}else {
				em.createNamedStoredProcedureQuery("warehouse_item_configuration_routines")
				.setParameter("actionType", "saveAllocateItems").setParameter("actionValue", value).execute();
			resp.setBody(null);
			resp.setCode("success");
			resp.setMessage("Item Allocate successfully");
			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				if (err[0].equals("1062")) {
				    resp.setCode("failed");
				    resp.setMessage("This item has already been allocated. Please choose a different one.");
				} else {
				    resp.setCode("error");
				    resp.setMessage("An unexpected error occurred. Please try again later.");
				}
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
			}
			e.printStackTrace();
		}
		logger.info("Method : saveAllocateItems Dao ends");
		return resp;
	}	
//deleteAllocateItems
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteAllocateItems(String orgName, String orgDivision,String userId,String sku,String whid) {
		logger.info("Method : deleteAllocateItems Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId +"',@p_sku='" + sku + "',@p_whid='" + whid + "';";
			
			logger.info(value);	
			em.createNamedStoredProcedureQuery("warehouse_item_configuration_routines")
			.setParameter("actionType", "deleteAllocateItems").setParameter("actionValue", value).execute();
 
			resp.setCode("success");
			resp.setMessage("Allocated item deleted successfully.");
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("error");
				resp.setMessage("An unexpected error occurred. Please try again later.");
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
			}
			e.printStackTrace();
		}
 
		logger.info("Method : deleteAllocateItems Dao ends");
		return resp;
	}	
}
