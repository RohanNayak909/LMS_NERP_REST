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
import nirmalya.aatithya.restmodule.common.utils.GenerateWareHouseMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.store.GenerateStoreDetailsMasterParameter;
import nirmalya.aatithya.restmodule.store.model.StoreModel;
import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;
import nirmalya.aatithya.restmodule.store.model.StoreZoneMasterModel;
import nirmalya.aatithya.restmodule.store.model.StoreZoneRackModel;
import nirmalya.aatithya.restmodule.warehouse.model.WareHouseModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;
import nirmalya.aatithya.restmodule.warehouse.model.ZoneMasterModel;
import nirmalya.aatithya.restmodule.warehouse.model.ZoneRackModel;

@Repository
public class ManageStoreDao {
	Logger logger = LoggerFactory.getLogger(ManageStoreDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<StoreModel>>> getStocklocationDeatils(String id) {

		logger.info("Method : getStocklocationDeatils starts");
		List<StoreModel> locationList = new ArrayList<StoreModel>();
		JsonResponse<List<StoreModel>> resp = new JsonResponse<List<StoreModel>>();

		String value = "SET @p_locationId='" + id + "';";
		
		try {
			
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "getStocklocationDeatils").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				StoreModel stockModel = new StoreModel(m[0], m[1],m[2],m[3]);
				locationList.add(stockModel);
			}

			resp.setBody(locationList);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<StoreModel>>> response = new ResponseEntity<JsonResponse<List<StoreModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getStocklocationDeatils ends");
		System.out.println("response"+response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStockItemCategoryList(String org,String orgDiv) {
		logger.info("Method : getStockItemCategoryList starts");
		
		List<DropDownModel> locationList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "getStockItemCategoryList").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getStockItemCategoryList ends");
		return locationList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStockLocationList(String org,String orgDiv) {
		logger.info("Method : getStockLocationList starts");

		List<DropDownModel> locationList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "getStockLocationList").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getStockLocationList ends");
		return locationList;
	}

	/*
	 * Function for get item name
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getstockItemName(String category,String org,String orgDiv) {

		logger.info("Method in Dao: getstockItemName starts");

		List<DropDownModel> typeModelList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_categoryId='" + category + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "getstockItemName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel typeModel = new DropDownModel(m[0], m[1]);
				typeModelList.add(typeModel);
			}
			resp.setBody(typeModelList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method in Dao: getstockItemName ends");

		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<StoreZoneMasterModel>> saveStockZoneMaster(StoreZoneMasterModel stockZoneMasterModel) {
		logger.info("Method : saveStockZoneMaster starts");
			
		Boolean validity = true;
		JsonResponse<StoreZoneMasterModel> resp = new JsonResponse<StoreZoneMasterModel>();
		resp.setMessage("");
		resp.setCode("");
		
		List<StoreZoneMasterModel> zoneData = new ArrayList<StoreZoneMasterModel>();

		if (stockZoneMasterModel.getZoneCode() == null || stockZoneMasterModel.getZoneCode() == "") {
			resp.setMessage("Zone Code Required");
			validity = false;
		} else if (stockZoneMasterModel.getZoneName() == null || stockZoneMasterModel.getZoneName() == "") {
			resp.setMessage("Zone Name Required");
			validity = false;
		
		}
		if (validity)
			try {
				String values = GenerateStoreDetailsMasterParameter.saveStockZoneMaster(stockZoneMasterModel);
				if (stockZoneMasterModel.getZoneId() != null && stockZoneMasterModel.getZoneId() != "") {
			
					List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
							.setParameter("actionType", "modifyZone").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						StoreZoneMasterModel zoneMasterModelList = new StoreZoneMasterModel(m[0], m[1], m[2],m[3],m[4],null,null,m[5]);
						zoneData.add(zoneMasterModelList);
					}
				} else {
				
					List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
							.setParameter("actionType", "addZone").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						StoreZoneMasterModel zoneMasterModelList = new StoreZoneMasterModel(m[0], m[1], m[2],m[3],m[4],null,null,m[5]);
						zoneData.add(zoneMasterModelList);
					}
					System.out.println("values"+values);

				}

				resp.setBody(zoneData.get(0));
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<StoreZoneMasterModel>> response = new ResponseEntity<JsonResponse<StoreZoneMasterModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("rest"+response);
		logger.info("Method : saveStockZoneMaster ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ZoneMasterModel>>> getZoneDetailss(String id) {

		logger.info("Method : getZoneDetailss starts");
		List<ZoneMasterModel> locationList = new ArrayList<ZoneMasterModel>();
		JsonResponse<List<ZoneMasterModel>> resp = new JsonResponse<List<ZoneMasterModel>>();

		String value = "SET @p_zoneId='" + id + "';";
		System.out.println("value@@@@@@@@@@@@"+value);
		try {
			System.out.println("x"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "getStockZoneList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				ZoneMasterModel zoneMasterModel = new ZoneMasterModel(m[0], m[1],m[2],m[3],m[4],null,m[5],m[6]);
				locationList.add(zoneMasterModel);
			}
			System.out.println("zoneMasterModel"+value);
			resp.setBody(locationList);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<ZoneMasterModel>>> response = new ResponseEntity<JsonResponse<List<ZoneMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getZoneDetailss ends");
		System.out.println("response@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<StoreZoneMasterModel>> editStockZoneMaster(String id) {
		logger.info("Method : editStockZoneMaster starts");

		JsonResponse<StoreZoneMasterModel> resp = new JsonResponse<StoreZoneMasterModel>();
		List<StoreZoneMasterModel> newZone = new ArrayList<StoreZoneMasterModel>();

		try {

			String value = "SET @P_Zone='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "editStockZone").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				StoreZoneMasterModel stockZoneMasterModel = new StoreZoneMasterModel(m[0], m[1], m[2], m[3],m[4],null,null,m[5]);
				newZone.add(stockZoneMasterModel);
			}
			
			resp.setBody(newZone.get(0));
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<StoreZoneMasterModel>> response = new ResponseEntity<JsonResponse<StoreZoneMasterModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : editStockZoneMaster ends");
		return response;
	}
	public ResponseEntity<JsonResponse<Object>> deleteStockZoneMaster(String id, String createdBy) {
		logger.info("Method : deleteStockZoneMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @P_ModifiedBy='" + createdBy + "', @p_zone='" + id + "';";
				System.out.println("delete data"+value);
				em.createNamedStoredProcedureQuery("storeRoutine").setParameter("actionType", "deleteStockZone")
						.setParameter("actionValue", value).execute();

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteStockZoneMaster ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<StoreZoneRackModel> viewRackListByZonee(String id) {
		logger.info("Method : viewRackListByZonee starts");
		
		List<StoreZoneRackModel> sectionList = new ArrayList<StoreZoneRackModel>();
		
		String value = "SET @p_Zone='" + id + "';";
		
		try {
			System.out.println("xxxx@"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "getStockRackList").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				StoreZoneRackModel dropDownModel = new StoreZoneRackModel(m[0], m[1], m[2], m[3], m[4], m[5],m[6],m[7],m[8],m[9]);
				sectionList.add(dropDownModel);
			}
			System.out.println("viewwwww@"+value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("viewrack"+sectionList);
		logger.info("Method : viewRackListByZonee ends");
		return sectionList;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<StoreZoneRackModel>> saveStockRackMaster(StoreZoneRackModel stockZoneRackModel) {
		logger.info("Method : saveStockRackMaster starts");

		Boolean validity = true;
		JsonResponse<StoreZoneRackModel> resp = new JsonResponse<StoreZoneRackModel>();
		resp.setMessage("");
		resp.setCode("");
		
		List<StoreZoneRackModel> rackData = new ArrayList<StoreZoneRackModel>();

		if (stockZoneRackModel.getRackName() == null || stockZoneRackModel.getRackName() == "") {
			resp.setMessage("Rack Name Required");
			validity = false;
		} else if (stockZoneRackModel.getRackCode()== null || stockZoneRackModel.getRackCode() == "") {
			resp.setMessage("Rack Code Required");
			validity = false;
		
		}
		if (validity)
			try {
				String values = GenerateStoreDetailsMasterParameter.saveRackMasterr(stockZoneRackModel);
				System.out.println(stockZoneRackModel);
				if (stockZoneRackModel.getRackId() != null && stockZoneRackModel.getRackId() != "") {
			
					List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
							.setParameter("actionType", "modifyStockRack").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						StoreZoneRackModel zoneRackModelList = new StoreZoneRackModel(m[0],m[1], m[2],m[3],m[4],m[5],m[6],m[7],m[8],null);
						rackData.add(zoneRackModelList);
					}
				} else {
				System.out.println("xy"+values);
					List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
							.setParameter("actionType", "addRack").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
							
						StoreZoneRackModel zoneRackModelList = new StoreZoneRackModel(m[0], m[1], m[2],m[3],m[4],m[5],m[6],m[7],m[8],null);
						rackData.add(zoneRackModelList);
					}
						System.out.println("rackData"+values);
				}

				resp.setBody(rackData.get(0));
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<StoreZoneRackModel>> response = new ResponseEntity<JsonResponse<StoreZoneRackModel>>(
				resp, HttpStatus.CREATED);
			System.out.println(response);
		logger.info("Method : saveStockRackMaster ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<StoreZoneRackModel>> editStockRackMaster(String id) {
		logger.info("Method : editStockRackMaster starts");

		JsonResponse<StoreZoneRackModel> resp = new JsonResponse<StoreZoneRackModel>();
		List<StoreZoneRackModel> newZone = new ArrayList<StoreZoneRackModel>();

		try {

			String value = "SET @P_Rack='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "editStockRack").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				StoreZoneRackModel StockZoneRackModel = new StoreZoneRackModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],m[8],null);
				newZone.add(StockZoneRackModel);
			}
			
			resp.setBody(newZone.get(0));
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<StoreZoneRackModel>> response = new ResponseEntity<JsonResponse<StoreZoneRackModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : editStockRackMaster ends");
		return response;
	}
	public ResponseEntity<JsonResponse<Object>> deleteStockRackMaster(String id, String createdBy) {
		logger.info("Method : deleteStockRackMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @P_ModifiedBy='" + createdBy + "', @p_rack='" + id + "';";
				System.out.println("delete data"+value);
				em.createNamedStoredProcedureQuery("storeRoutine").setParameter("actionType", "deleteStockRack")
						.setParameter("actionValue", value).execute();

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteStockRackMaster ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<StoreRomeModel>>> getStockRoomDetails(List<String> id) {
		logger.info("Method : getStockRoomDetails starts");
		
		List<StoreRomeModel> locationList = new ArrayList<StoreRomeModel>();
		JsonResponse<List<StoreRomeModel>> resp = new JsonResponse<List<StoreRomeModel>>();
		
		String value = GenerateStoreDetailsMasterParameter.getStockRackIdList(id);
		
		if(id.size() > 0) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
						.setParameter("actionType", "getstoreRoomDetails").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					
					StoreRomeModel dropDownModel = new StoreRomeModel(m[0], m[1], m[2], null, m[3], m[4], null, m[5], m[6], null,
							m[7], m[8], null, null,null);
					locationList.add(dropDownModel);
				}
				resp.setBody(locationList);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		ResponseEntity<JsonResponse<List<StoreRomeModel>>> response = new ResponseEntity<JsonResponse<List<StoreRomeModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("getwarehouseRoomDetails$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+response);
		logger.info("Method : getStockRoomDetails ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> countStockZoneWiseRoom(List<String> id) {
		logger.info("Method : countStockZoneWiseRoom starts");
		
		List<DropDownModel> locationList = new ArrayList<DropDownModel>();
		
		String value = GenerateStoreDetailsMasterParameter.getStockRackIdList(id);
		
		if(id.size() > 0) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
						.setParameter("actionType", "countZoneWiseStockRoom").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1].toString());
					locationList.add(dropDownModel);


				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		logger.info("Method : countStockZoneWiseRoom ends");
		return locationList;
	}
	
	@SuppressWarnings("unchecked")
	public List<StoreRomeModel> viewStockRoomListByRack(String id) {
		logger.info("Method : viewStockRoomListByRack starts");

		List<StoreRomeModel> roomList = new ArrayList<StoreRomeModel>();

		String value = "SET @P_Rack='" + id + "';";
		

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "getStockBinList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				StoreRomeModel dropDownModel = new StoreRomeModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
				roomList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : viewStockRoomListByRack ends");
		return roomList;
	}
	 
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<StoreRomeModel>> saveStockBinMaster(StoreRomeModel location) {
		logger.info("Method : saveStockBinMaster starts");
		System.out.println("B"+location);
		Boolean validity = true;
		JsonResponse<StoreRomeModel> resp = new JsonResponse<StoreRomeModel>();
		resp.setMessage("");
		resp.setCode("");
		
		List<StoreRomeModel> newLoc = new ArrayList<StoreRomeModel>();
		
		if (location.getRoomCode() == null || location.getRoomCode() == "") {
			resp.setMessage("Room Code Required");
			validity = false;
		} else if (location.getRoomName() == null || location.getRoomName() == "") {
			resp.setMessage("Room Name Required");
			validity = false;
		} else if (location.getRackId() == null || location.getRackId() == "") {
			resp.setMessage("Section Id Required");
			validity = false;
		}
		
		if (validity)
			try {
				System.out.println("aB"+location);
				String values = GenerateStoreDetailsMasterParameter.saveStockBin(location);
				System.out.println("Bin"+values);
				if (location.getRoomId() != null && location.getRoomId() != "") {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
							.setParameter("actionType", "modifyBinStock").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						

						StoreRomeModel item = new StoreRomeModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9],
								m[10], m[11], m[12], m[13], m[14]);
						newLoc.add(item);
					}
				} else {
					System.out.println("Bin$"+values);
					List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
							.setParameter("actionType", "addBinStock").setParameter("actionValue", values).getResultList();
					for (Object[] m : x) {
						

						
						StoreRomeModel item = new StoreRomeModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9],
								m[10], m[11], m[12], m[13], m[14]);
						newLoc.add(item);
					}
					
				}
				System.out.println("Bin@"+values);
				resp.setBody(newLoc.get(0));
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		
		ResponseEntity<JsonResponse<StoreRomeModel>> response = new ResponseEntity<JsonResponse<StoreRomeModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("BinR"+response);
		logger.info("Method : saveStockBinMaster ends");
		return response;
	}

	/*
	 * public ResponseEntity<JsonResponse<Object>> deleteBinMaster(String id, String
	 * createdBy) { logger.info("Method : deleteBinMaster starts");
	 * 
	 * Boolean validity = true; JsonResponse<Object> resp = new
	 * JsonResponse<Object>(); resp.setMessage(""); resp.setCode("");
	 * 
	 * if (validity) try {
	 * 
	 * String value = "SET @P_ModifiedBy='" + createdBy + "', @P_Room='" + id +
	 * "';"; em.createNamedStoredProcedureQuery("warehouseRoutine").setParameter(
	 * "actionType", "deleteBin") .setParameter("actionValue", value).execute();
	 * 
	 * } catch (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
	 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
	 * e1.printStackTrace(); } e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : deleteBinMaster ends"); return response; }
	 */
	public ResponseEntity<JsonResponse<StoreRomeModel>> saveStockBinConfiguration(StoreRomeModel config) {
		logger.info("Method : saveStockBinConfiguration starts");
		System.out.println("B"+config);
		Boolean validity = true;
		JsonResponse<StoreRomeModel> resp = new JsonResponse<StoreRomeModel>();
		resp.setMessage("");
		resp.setCode("");
		List<StoreRomeModel> newLoc = new ArrayList<StoreRomeModel>();
		if (config.getCategory() == null || config.getCategory() == "") {
			resp.setMessage("Category Required");
			validity = false;
		} else if (config.getItemName() == null || config.getItemName() == "") {
			resp.setMessage("Item Name Required");
			validity = false;
		} else if (config.getBinlist() == null || config.getBinlist() == "") {
			resp.setMessage("Bin Required");
			validity = false;
		}
		if (validity)
			try {
				String values = GenerateStoreDetailsMasterParameter.saveStockBinConfig(config);
				System.out.println("BinConfig="+values);
				
				  em.createNamedStoredProcedureQuery("storeRoutine")
				    .setParameter("actionType","saveStockBinConfiguration").setParameter(
				  "actionValue", values).execute();
				 
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		
		ResponseEntity<JsonResponse<StoreRomeModel>> response = new ResponseEntity<JsonResponse<StoreRomeModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("BinR"+response);
		logger.info("Method : saveStockBinConfiguration ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<StoreRomeModel>> viewStockBindata(String rmId,String orgName, String orgDiv) {
		logger.info("Method : viewStockBindata starts");

		JsonResponse<StoreRomeModel> resp = new JsonResponse<StoreRomeModel>();
		List<StoreRomeModel> newZone = new ArrayList<StoreRomeModel>();

		try {

			String value = "SET @P_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("@@@@@@@@@@@@@@@@@@@@@"+value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "viewStockBindata").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				StoreRomeModel StockRomeModel = new StoreRomeModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6]);
				newZone.add(StockRomeModel);
			}
			
			resp.setBody(newZone.get(0));
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<StoreRomeModel>> response = new ResponseEntity<JsonResponse<StoreRomeModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : viewStockBindata ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<StoreRomeModel>> deleteStockBin(String binlist,String orgName, String orgDiv) {
		logger.info("Method : deleteStockBin starts");
		
		JsonResponse<StoreRomeModel> resp = new JsonResponse<StoreRomeModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @P_binlist='" + binlist + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value@@@@@@@@@@@@@@@@@@"+value);
			em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "deleteStockRoomBin").setParameter("actionValue", value).execute();
			//System.out.println("print block" + deleteBim);
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<StoreRomeModel>> response = new ResponseEntity<JsonResponse<StoreRomeModel>>(resp,
				HttpStatus.CREATED);
		
		logger.info("Method : deleteStockBin ends");
		return response;
	}
	public ResponseEntity<JsonResponse<StoreRomeModel>> deleteStockRoom(String binlist,String orgName, String orgDiv) {
		logger.info("Method : deleteStockRoom starts");
		
		JsonResponse<StoreRomeModel> resp = new JsonResponse<StoreRomeModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @P_binlist='" + binlist + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value@@@@@@@@@@@@@@@@@@"+value);
			em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "deleteStockRoom").setParameter("actionValue", value).execute();
			//System.out.println("print block" + deleteBim);
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<StoreRomeModel>> response = new ResponseEntity<JsonResponse<StoreRomeModel>>(resp,
				HttpStatus.CREATED);
		
		logger.info("Method : deleteStockRoom ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewBinItemList(String bindatas,String orgName, String orgDivision) {
		logger.info("Method : viewBinItemList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_bindatas='" + bindatas + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "viewBinItemList").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewBinItemList Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteConfigItemdata(String id,String orgName, String orgDiv) {
		logger.info("Method : deleteConfigItemdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_binid='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			 em.createNamedStoredProcedureQuery("storeRoutine")
					.setParameter("actionType", "deleteConfigItemdata").setParameter("actionValue", value)
					.execute();
			 resp.setCode("success");
			 resp.setMessage("Deleted Successfully");
			//resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : deleteConfigItemdata Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

}
