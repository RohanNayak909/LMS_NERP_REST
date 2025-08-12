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
import nirmalya.aatithya.restmodule.common.utils.GenerateWarehouseAllocationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.store.GenerateStoreAllocationParameter;
import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@Repository
public class StoreAllocationDao {
	Logger logger = LoggerFactory.getLogger(StoreAllocationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	//getManufacturePlaceLists
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getStoreManufacturePlaceLists(String org,String orgDiv) {
			logger.info("Method : getStoreManufacturePlaceLists starts");

			List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
						.setParameter("actionType", "getStoreManufacturePlaceLists").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					getCollectionList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getStoreManufacturePlaceLists ends");
			return getCollectionList;
		}
		
		//getBatchGenerateType
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getStoreBatchNoLists(String org,String orgDiv) {
			logger.info("Method : getStoreBatchNoLists starts");

			List<DropDownModel> getBatchList = new ArrayList<DropDownModel>();
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
						.setParameter("actionType", "getStoreBatchNoLists").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					getBatchList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getStoreBatchNoLists ends");
			return getBatchList;
		}
		
		//getShiftListsAllocation	
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getStoreShiftListsAllocation(String org,String orgDiv,String userId) {
			logger.info("Method : getStoreShiftListsAllocation starts");

			List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
						.setParameter("actionType", "getStoreShiftListsAllocation").setParameter("actionValue",value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					getCollectionList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getStoreShiftListsAllocation ends");
			return getCollectionList;
		}
		
		//getLineLists			
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getStoreLineLists(String org,String orgDiv) {
			logger.info("Method : getStoreLineLists starts");

			List<DropDownModel> getLineList = new ArrayList<DropDownModel>();
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
						.setParameter("actionType", "getStoreLineLists").setParameter("actionValue",value).getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					getLineList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getStoreLineLists ends");
			return getLineList;
		}
		
		//getPackingSiteLists
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getStorePackingSiteLists(String org,String orgDiv) {
			logger.info("Method : getStorePackingSiteLists starts");

			List<DropDownModel> getLineList = new ArrayList<DropDownModel>();
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
						.setParameter("actionType", "getStorePackingSiteLists").setParameter("actionValue",value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					getLineList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getStorePackingSiteLists ends");
			return getLineList;
		}	
		
		//getzoneList
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getStorezoneList(String warehouseId,String orgName, String orgDiv) {

			logger.info("Method : getStorezoneList starts");
			List<DropDownModel> zoneList = new ArrayList<DropDownModel>();

			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			String value = "SET @p_warehouseId='" + warehouseId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("++++++++++++++++++++++++++" + value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
						.setParameter("actionType", "getStorezoneList").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					zoneList.add(dropDownModel);
					if (dropDownModel.equals("")) {
						resp.setCode("success");
						resp.setMessage("Data not found");
					} else {
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
					}
				}
				resp.setBody(zoneList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : getStorezoneList ends");
			System.out.println("++++++++++++++++++++++++++" + response);
			return response;
		}
		
		//rackList
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> rackStoreLists(String zoneId,String orgName, String orgDiv) {

			logger.info("Method : rackStoreLists starts");
			List<DropDownModel> rackList = new ArrayList<DropDownModel>();

			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			String value = "SET @p_zoneId='" + zoneId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			//System.out.println("++++++++++++++++++++++++++" + value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
						.setParameter("actionType", "rackStoreLists").setParameter("actionValue", value)
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
			logger.info("Method : rackStoreLists ends");
			//System.out.println("++++++++++++++++++++++++++" + response);
			return response;
		}
		
		//getitemList
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getstoreitemList(String categoryId,String orgName, String orgDiv) {

			logger.info("Method : getstoreitemList starts");
			List<DropDownModel> zoneList = new ArrayList<DropDownModel>();

			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			String value = "SET @p_categoryId='" + categoryId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("++++++++++++++++++++++++++" + value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
						.setParameter("actionType", "getstoreitemList").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					zoneList.add(dropDownModel);
					if (dropDownModel.equals("")) {
						resp.setCode("success");
						resp.setMessage("Data not found");
					} else {
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
					}
				}
				resp.setBody(zoneList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : getstoreitemList ends");
			System.out.println("++++++++++++++++++++++++++" + response);
			return response;
		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getStoreData(String warehouseId,String orgName, String orgDiv) {
			logger.info("Method : getStoreData Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String values = "SET @p_warehouseId='" + warehouseId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("values****************************" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
						.setParameter("actionType", "getStoreData").setParameter("actionValue", values)
						.getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
			logger.info("Method : getStoreData Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		//warehouseGetSearchData
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> storeGetAllData(String warehouseId,String zoneId,String rackId,String categoryId,
				String itemName,String orgName, String orgDiv) {
			logger.info("Method : storeGetAllData Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_warehouseId='" + warehouseId + "',@p_zoneId='" + zoneId + "',@p_rackId='" + rackId + "',@p_categoryId='" + categoryId + "',@p_itemName='" + itemName + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
						.setParameter("actionType", "storeGetAllData").setParameter("actionValue", value)
						.getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : storeGetAllData Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;
		}
		
		//saveAllocation
		public ResponseEntity<JsonResponse<List<StoreRomeModel>>> saveStoreAllocation(
				List<StoreRomeModel> storeRomeModel) {
			logger.info("Method : saveStoreAllocation starts");
			JsonResponse<List<StoreRomeModel>> resp = new JsonResponse<List<StoreRomeModel>>();
			List<StoreRomeModel> listData = new ArrayList<StoreRomeModel>();

			System.out.println("=====>>>>>" + storeRomeModel);

			try {
				String values = GenerateStoreAllocationParameter.saveStoreAllocationParam(storeRomeModel);
				 em.createNamedStoredProcedureQuery("storeAllocationRoutine")
							.setParameter("actionType", "saveStoreAllocation").setParameter("actionValue", values)
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
			logger.info("Method : saveStoreAllocation ends");
			return response;
		}
		
		 //rest-viewAllocationData
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewStoreAllocationData(String orgName, String orgDivision) {
			logger.info("Method : viewStoreAllocationData Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
						.setParameter("actionType", "viewStoreAllocationData").setParameter("actionValue", value)
						.getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewStoreAllocationData Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		//View allocation data
				@SuppressWarnings("unchecked")
				public JsonResponse viewStoreBinAllocationdata(String rmId,String orgName, String orgDiv) {
					logger.info("Method : viewStoreBinAllocationdata Dao startssssssssssssssssssssss");

					JsonResponse resp = new JsonResponse();

					try {
						String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
						System.out.println("values****************************" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
								.setParameter("actionType", "viewStoreBinAllocationdata").setParameter("actionValue", value)
								.getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
						} catch (Exception e) {
							resp.setCode("failed");
							resp.setMessage(e.getMessage());
						}
					logger.info("Method : viewStoreBinAllocationdata Dao ends");
					System.out.println("resp****************************" + resp);
					return resp;

				}
				
				//View bin data
				@SuppressWarnings("unchecked")
				public JsonResponse viewStorebinconfigdata(String rmId,String orgName, String orgDiv) {
					logger.info("Method : viewStorebinconfigdata Dao startssssssssssssssssssssss");

					JsonResponse resp = new JsonResponse();

					try {
						String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
						System.out.println("values****************************" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("storeAllocationRoutine")
								.setParameter("actionType", "viewStorebinconfigdata").setParameter("actionValue", value)
								.getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
						} catch (Exception e) {
							resp.setCode("failed");
							resp.setMessage(e.getMessage());
						}
					logger.info("Method : viewStorebinconfigdata Dao ends");
					System.out.println("resp****************************" + resp);
					return resp;

				}
				
				//deleteAllocationdata
				@SuppressWarnings("unchecked")
				public JsonResponse<Object> deleteStoreAllocationdata(String allocId,String orgName, String orgDiv) {
					logger.info("Method : deleteStoreAllocationdata Dao starts");
					JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_allocId='" + allocId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
						System.out.println("values****************************" + value);
						 em.createNamedStoredProcedureQuery("storeAllocationRoutine")
								.setParameter("actionType", "deleteStoreAllocationdata").setParameter("actionValue", value)
								.execute();
						 resp.setCode("success");
						 resp.setMessage("Deleted Successfully");
						//resp.setBody(x);
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : deleteStoreAllocationdata Dao ends");
					System.out.println("resp****************************" + resp);
					return resp;

				}
				
				//approveAllocationdata
				@SuppressWarnings("unchecked")
				public JsonResponse<Object> approveStoreAllocationdata(String allocId,String orgName, String orgDiv) {
					logger.info("Method : approveStoreAllocationdata Dao starts");
					JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_allocId='" + allocId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
						System.out.println("values****************************" + value);
						 em.createNamedStoredProcedureQuery("storeAllocationRoutine")
								.setParameter("actionType", "approveStoreAllocationdata").setParameter("actionValue", value)
								.execute();
						 resp.setCode("success");
						 resp.setMessage("Approved Successfully");
						//resp.setBody(x);
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : approveStoreAllocationdata Dao ends");
					System.out.println("resp****************************" + resp);
					return resp;

				}
				
				//holdAllocationdata
				@SuppressWarnings("unchecked")
				public JsonResponse<Object> holdStoreAllocationdata(String rmId,String orgName, String orgDiv) {
					logger.info("Method : holdStoreAllocationdata Dao starts");
					JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
						System.out.println("values****************************" + value);
						 em.createNamedStoredProcedureQuery("storeAllocationRoutine")
								.setParameter("actionType", "holdStoreAllocationdata").setParameter("actionValue", value)
								.execute();
						 resp.setCode("success");
						 resp.setMessage("Bin Hold Successfully");
						//resp.setBody(x);
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : holdStoreAllocationdata Dao ends");
					System.out.println("resp****************************" + resp);
					return resp;

				}
				//releaseAllocationdata
				@SuppressWarnings("unchecked")
				public JsonResponse<Object> releaseStoreAllocationdata(String rmId,String orgName, String orgDiv) {
					logger.info("Method : releaseStoreAllocationdata Dao starts");
					JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
						System.out.println("values****************************" + value);
						 em.createNamedStoredProcedureQuery("storeAllocationRoutine")
								.setParameter("actionType", "releaseStoreAllocationdata").setParameter("actionValue", value)
								.execute();
						 resp.setCode("success");
						 resp.setMessage("Bin Release Successfully");
						//resp.setBody(x);
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : releaseStoreAllocationdata Dao ends");
					System.out.println("resp****************************" + resp);
					return resp;

				}
}
