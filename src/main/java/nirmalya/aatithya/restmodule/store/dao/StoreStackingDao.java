package nirmalya.aatithya.restmodule.store.dao;

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
import nirmalya.aatithya.restmodule.common.utils.store.GenerateStoreStackingParameter;
import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@Repository
public class StoreStackingDao {
	Logger logger = LoggerFactory.getLogger(StoreStackingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	//viewRequestedStackingGoods
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewStoreRequestedStacking(String orgName, String orgDivision) {
		logger.info("Method : viewStoreRequestedStacking Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeStackingRoutine")
					.setParameter("actionType", "viewStoreRequestedStacking").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewStoreRequestedStacking Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}
	
	//getStackingData
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getStoreAllocationDataforStacking(String warehouse,String allocate,String orgName, String orgDiv) {
		logger.info("Method : getStoreAllocationDataforStacking Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_warehouseId='" + warehouse + "',@p_allocate='" + allocate + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeStackingRoutine")
					.setParameter("actionType", "getStoreAllocationDataforStacking").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : getStoreAllocationDataforStacking Dao ends");
		return resp;

	}
	
	//Save
	public JsonResponse<StoreRomeModel> modifyStoreStackingData(String warehouseId, String allocateId,String bdata, String orgName,String orgDivision) {
		logger.info("Method : modifyStoreStackingData starts");

		JsonResponse<StoreRomeModel> resp = new JsonResponse<StoreRomeModel>();
		try {
			
			String value = "SET @p_warehouseId='" + warehouseId + "',@p_allocateId='" + allocateId + "',@p_bdata='(" + bdata + ")',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision +"';";
			System.out.println("value==="+value);
			em.createNamedStoredProcedureQuery("storeStackingRoutine").setParameter("actionType", "modifyStoreStackingData")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Stacking successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		System.out.println("resp==="+resp);
		logger.info("Method : modifyStoreStackingData ends");
		return resp;
	}
	
	//rackList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> binStoreLists(String rackId,String binId,String orgName, String orgDiv) {

		logger.info("Method : binStoreLists starts");
		List<DropDownModel> rackList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_rackId='" + rackId + "',@p_binId='" + binId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		System.out.println("racklistttttttttttttttttttttttt" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeStackingRoutine")
					.setParameter("actionType", "binStoreLists").setParameter("actionValue", value)
					.getResultList();
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
		logger.info("Method : binStoreLists ends");
		System.out.println("cccccccccccc ++++" + response);
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse editStoreData(String rmId,String orgName, String orgDiv) {
		logger.info("Method : editStoreData Dao startssssssssssssssssssssss");

		JsonResponse resp = new JsonResponse();

		try {
			String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeStackingRoutine")
					.setParameter("actionType", "editStoreData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : editStoreData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	public ResponseEntity<JsonResponse<List<StoreRomeModel>>> saveStoreStackdata(
			List<StoreRomeModel> storeRomeModel) {
		logger.info("Method : saveStoreStackdata starts");
		JsonResponse<List<StoreRomeModel>> resp = new JsonResponse<List<StoreRomeModel>>();
		List<StoreRomeModel> listData = new ArrayList<StoreRomeModel>();

		System.out.println("=====>>>>>" + storeRomeModel);

		try {
			String values = GenerateStoreStackingParameter.saveStoreStackdataParam(storeRomeModel);
			System.out.println("values==="+values);
			 em.createNamedStoredProcedureQuery("storeStackingRoutine")
						.setParameter("actionType", "saveStoreStackdata").setParameter("actionValue", values)
						.execute();
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
		ResponseEntity<JsonResponse<List<StoreRomeModel>>> response = new ResponseEntity<JsonResponse<List<StoreRomeModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response data is" + response);
		logger.info("Method : saveStoreStackdata ends");
		return response;
	}
	
	
	//View allocation data
	@SuppressWarnings("unchecked")
	public JsonResponse viewStackBinAllocationdata(String rmId,String allocateId,String orgName, String orgDiv) {
		logger.info("Method : viewStackBinAllocationdata Dao startssssssssssssssssssssss");

		JsonResponse resp = new JsonResponse();

		try {
			String value = "SET @p_rmId='" + rmId + "',@p_allocateId='" + allocateId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeStackingRoutine")
					.setParameter("actionType", "viewStackBinAllocationdata").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : viewStackBinAllocationdata Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
}
