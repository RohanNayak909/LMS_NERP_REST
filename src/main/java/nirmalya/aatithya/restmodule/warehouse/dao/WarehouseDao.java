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
import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
import nirmalya.aatithya.restmodule.common.utils.GenerateWareHouseMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;
import nirmalya.aatithya.restmodule.warehouse.model.ZoneMasterModel;
import nirmalya.aatithya.restmodule.warehouse.model.ZoneRackModel;

@Repository
public class WarehouseDao {

	Logger logger = LoggerFactory.getLogger(WarehouseDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getLocationDetails(String id, String type, String org, String orgDiv) {
		logger.info("Method : getLocationDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "SET @p_locationId='" + id + "', @p_type='" + type + "', @p_org='" + org + "', @p_orgDiv='"
				+ orgDiv + "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getWarehouseList").setParameter("actionValue", value).getResultList();

			if (x.size() > 0) {
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
				resp.setBody(x);
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Something went wrong");
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getLocationDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getlocationDetailAgainstId(String id, String org, String orgDiv) {
		logger.info("Method : getlocationDetailAgainstId starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "SET @p_binId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getConfigItemOfBin").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
				resp.setBody(x);
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Something went wrong");
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getlocationDetailAgainstId ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getBinDetails(String id, String org, String orgDiv) {
		logger.info("Method : getBinDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "SET @p_rackId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getBinListDtls").setParameter("actionValue", value).getResultList();

			if (x.size() > 0) {
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
				resp.setBody(x);
			} else {
				resp.setBody(null);
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Something went wrong");
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getBinDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getWarehouseLocationList(String org, String orgDiv, String type) {
		logger.info("Method : getWarehouseLocationList starts");

		List<DropDownModel> locationList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_type='" + type + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getWhLocationList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getWarehouseLocationList ends");
		return locationList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getWarehouseItemCategoryList(String org, String orgDiv) {
		logger.info("Method : getWarehouseItemCategoryList starts");

		List<DropDownModel> locationList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getWarehouseItemCategoryList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getWarehouseItemCategoryList ends");
		return locationList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getWarehouseTypeWiseItemCategoryList(String org, String orgDiv, String type) {
		logger.info("Method : getWarehouseTypeWiseItemCategoryList starts");

		List<DropDownModel> locationList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_type='" + type + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getWarehouseTypeWiseItemCategoryList")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getWarehouseTypeWiseItemCategoryList ends");
		return locationList;
	}

	/*
	 * Function for get item name
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getWhItemName(String category, String org, String orgDiv) {

		logger.info("Method in Dao: getWhItemName starts");

		List<DropDownModel> typeModelList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_categoryId='" + category + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getWhItemName").setParameter("actionValue", value).getResultList();
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
		logger.info("Method in Dao: getWhItemName ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ZoneMasterModel>> saveZoneMaster(ZoneMasterModel zoneMasterModel) {
		logger.info("Method : saveZoneMaster starts");
		System.out.println(zoneMasterModel);
		Boolean validity = true;
		JsonResponse<ZoneMasterModel> resp = new JsonResponse<ZoneMasterModel>();
		resp.setMessage("");
		resp.setCode("");

		List<ZoneMasterModel> zoneData = new ArrayList<ZoneMasterModel>();

		if (zoneMasterModel.getZoneCode() == null || zoneMasterModel.getZoneCode() == "") {
			resp.setMessage("Zone Code Required");
			validity = false;
		} else if (zoneMasterModel.getZoneName() == null || zoneMasterModel.getZoneName() == "") {
			resp.setMessage("Zone Name Required");
			validity = false;

		}
		if (validity)
			try {
				String values = GenerateWareHouseMasterParameter.saveZoneMaster(zoneMasterModel);
				if (zoneMasterModel.getZoneId() != null && zoneMasterModel.getZoneId() != "") {

					List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
							.setParameter("actionType", "modifyZone").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ZoneMasterModel zoneMasterModelList = new ZoneMasterModel(m[0], m[1], m[2], m[3], m[4], null,
								null, m[5]);
						zoneData.add(zoneMasterModelList);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
							.setParameter("actionType", "addZone").setParameter("actionValue", values).getResultList();
					for (Object[] m : x) {

						ZoneMasterModel zoneMasterModelList = new ZoneMasterModel(m[0], m[1], m[2], m[3], m[4], null,
								null, m[5]);
						zoneData.add(zoneMasterModelList);
					}
					System.out.println("values" + values);

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

		ResponseEntity<JsonResponse<ZoneMasterModel>> response = new ResponseEntity<JsonResponse<ZoneMasterModel>>(resp,
				HttpStatus.CREATED);
		System.out.println("rest" + response);
		logger.info("Method : saveZoneMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ZoneMasterModel>>> getZoneDetails(String id) {

		logger.info("Method : getZoneDetails starts");
		List<ZoneMasterModel> locationList = new ArrayList<ZoneMasterModel>();
		JsonResponse<List<ZoneMasterModel>> resp = new JsonResponse<List<ZoneMasterModel>>();

		String value = "SET @p_zoneId='" + id + "';";
		System.out.println("value@@@@@@@@@@@@" + value);
		try {
			System.out.println("x" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getZoneList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				ZoneMasterModel zoneMasterModel = new ZoneMasterModel(m[0], m[1], m[2], m[3], m[4], null, m[5], m[6]);
				locationList.add(zoneMasterModel);
			}
			System.out.println("zoneMasterModel" + value);
			resp.setBody(locationList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<ZoneMasterModel>>> response = new ResponseEntity<JsonResponse<List<ZoneMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getZoneDetails ends");
		System.out.println("response@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ZoneMasterModel>> editZoneMaster(String id) {
		logger.info("Method : editZoneMaster starts");

		JsonResponse<ZoneMasterModel> resp = new JsonResponse<ZoneMasterModel>();
		List<ZoneMasterModel> newZone = new ArrayList<ZoneMasterModel>();

		try {

			String value = "SET @P_Zone='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "editZone").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ZoneMasterModel zoneMasterModel = new ZoneMasterModel(m[0], m[1], m[2], m[3], m[4], null, null, m[5]);
				newZone.add(zoneMasterModel);
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

		ResponseEntity<JsonResponse<ZoneMasterModel>> response = new ResponseEntity<JsonResponse<ZoneMasterModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : editZoneMaster ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteZoneMaster(String id, String createdBy, String org,
			String orgDiv) {
		logger.info("Method : deleteZoneMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_user_id='" + createdBy + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv
						+ "', @p_zone='" + id + "';";
				em.createNamedStoredProcedureQuery("warehouseRoutine").setParameter("actionType", "deleteZone")
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

		logger.info("Method : deleteFloorMaster ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteItemConfig(String id, String createdBy, String org, String orgDiv,
			String skuid) {
		logger.info("Method : deleteItemConfig starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_user_id='" + createdBy + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv
						+ "', @p_binid='" + id + "', @p_skuid='" + skuid + "';";
				em.createNamedStoredProcedureQuery("warehouseRoutine").setParameter("actionType", "deleteItemConfig")
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

		logger.info("Method : deleteItemConfig ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<ZoneRackModel> viewRackListByZone(String id) {
		logger.info("Method : viewRackListByZone starts");

		List<ZoneRackModel> sectionList = new ArrayList<ZoneRackModel>();

		String value = "SET @p_Zone='" + id + "';";

		try {
			System.out.println("xxxx@" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getRackList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				ZoneRackModel dropDownModel = new ZoneRackModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],
						m[9]);
				sectionList.add(dropDownModel);
			}
			System.out.println("viewwwww@" + value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("viewrack" + sectionList);
		logger.info("Method : viewRackListByZone ends");
		return sectionList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ZoneRackModel>> saveRackMaster(ZoneRackModel zoneRackModel) {
		logger.info("Method : saveRackMaster starts");

		Boolean validity = true;
		JsonResponse<ZoneRackModel> resp = new JsonResponse<ZoneRackModel>();
		resp.setMessage("");
		resp.setCode("");

		List<ZoneRackModel> rackData = new ArrayList<ZoneRackModel>();

		if (zoneRackModel.getRackName() == null || zoneRackModel.getRackName() == "") {
			resp.setMessage("Rack Name Required");
			validity = false;
		} else if (zoneRackModel.getRackCode() == null || zoneRackModel.getRackCode() == "") {
			resp.setMessage("Rack Code Required");
			validity = false;

		}
		if (validity)
			try {
				String values = GenerateWareHouseMasterParameter.saveRackMaster(zoneRackModel);
				System.out.println(zoneRackModel);
				if (zoneRackModel.getRackId() != null && zoneRackModel.getRackId() != "") {

					List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
							.setParameter("actionType", "modifyRack").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ZoneRackModel zoneRackModelList = new ZoneRackModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
								m[7], m[8], null);
						rackData.add(zoneRackModelList);
					}
				} else {
					System.out.println("xy" + values);
					List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
							.setParameter("actionType", "addRack").setParameter("actionValue", values).getResultList();
					for (Object[] m : x) {

						ZoneRackModel zoneRackModelList = new ZoneRackModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
								m[7], m[8], null);
						rackData.add(zoneRackModelList);
					}
					System.out.println("rackData" + values);
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

		ResponseEntity<JsonResponse<ZoneRackModel>> response = new ResponseEntity<JsonResponse<ZoneRackModel>>(resp,
				HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : saveRackMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ZoneRackModel>> editRackMaster(String id) {
		logger.info("Method : editRackMaster starts");

		JsonResponse<ZoneRackModel> resp = new JsonResponse<ZoneRackModel>();
		List<ZoneRackModel> newZone = new ArrayList<ZoneRackModel>();

		try {

			String value = "SET @P_Rack='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "editRack").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ZoneRackModel ZoneRackModel = new ZoneRackModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],
						null);
				newZone.add(ZoneRackModel);
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

		ResponseEntity<JsonResponse<ZoneRackModel>> response = new ResponseEntity<JsonResponse<ZoneRackModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : editRackMaster ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteRackMaster(String id, String createdBy, String org,
			String orgDiv) {
		logger.info("Method : deleteRackMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_user_id='" + createdBy + "', @p_org= '" + org + "', @p_orgDiv='" + orgDiv
						+ "', @p_rack='" + id + "';";
				em.createNamedStoredProcedureQuery("warehouseRoutine").setParameter("actionType", "deleteRack")
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

		logger.info("Method : deleteRackMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> getwarehouseRoomDetails(List<String> id) {
		logger.info("Method : getwarehouseRoomDetails starts");

		List<WirehouseRomeModel> locationList = new ArrayList<WirehouseRomeModel>();
		JsonResponse<List<WirehouseRomeModel>> resp = new JsonResponse<List<WirehouseRomeModel>>();

		String value = GenerateWareHouseMasterParameter.getRackIdList(id);

		if (id.size() > 0) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
						.setParameter("actionType", "getwarehouseRoomDetails").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {

					WirehouseRomeModel dropDownModel = new WirehouseRomeModel(m[0], m[1], m[2], null, m[3], m[4], null,
							m[5], m[6], null, m[7], m[8], null, null, null);
					locationList.add(dropDownModel);
				}
				resp.setBody(locationList);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> response = new ResponseEntity<JsonResponse<List<WirehouseRomeModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("getwarehouseRoomDetails$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + response);
		logger.info("Method : getwarehouseRoomDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> countZoneWiseRoom(List<String> id) {
		logger.info("Method : countZoneWiseRoom starts");

		List<DropDownModel> locationList = new ArrayList<DropDownModel>();

		String value = GenerateWareHouseMasterParameter.getRackIdList(id);

		if (id.size() > 0) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
						.setParameter("actionType", "countZoneWiseRoom").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {

					DropDownModel dropDownModel = new DropDownModel(m[0], m[1].toString());
					locationList.add(dropDownModel);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		logger.info("Method : countZoneWiseRoom ends");
		return locationList;
	}

	@SuppressWarnings("unchecked")
	public List<WirehouseRomeModel> viewRoomListByRack(String id) {
		logger.info("Method : viewRoomListByRack starts");

		List<WirehouseRomeModel> roomList = new ArrayList<WirehouseRomeModel>();

		String value = "SET @P_Rack='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getBinList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				WirehouseRomeModel dropDownModel = new WirehouseRomeModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
				roomList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : viewRoomListByRack ends");
		return roomList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<WirehouseRomeModel>> saveBinMaster(WirehouseRomeModel location) {
		logger.info("Method : saveBinMaster starts");
		System.out.println("B" + location);
		Boolean validity = true;
		JsonResponse<WirehouseRomeModel> resp = new JsonResponse<WirehouseRomeModel>();
		resp.setMessage("");
		resp.setCode("");

		List<WirehouseRomeModel> newLoc = new ArrayList<WirehouseRomeModel>();

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
				System.out.println("aB" + location);
				String values = GenerateWareHouseMasterParameter.saveBin(location);
				System.out.println("Bin" + values);
				if (location.getRoomId() != null && location.getRoomId() != "") {

					List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
							.setParameter("actionType", "modifyBin").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						WirehouseRomeModel item = new WirehouseRomeModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
								m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
						newLoc.add(item);
					}
				} else {
					System.out.println("Bin$" + values);
					List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
							.setParameter("actionType", "addBin").setParameter("actionValue", values).getResultList();
					for (Object[] m : x) {

						WirehouseRomeModel item = new WirehouseRomeModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
								m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
						newLoc.add(item);
					}

				}
				System.out.println("Bin@" + values);
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

		ResponseEntity<JsonResponse<WirehouseRomeModel>> response = new ResponseEntity<JsonResponse<WirehouseRomeModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveBinMaster ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveItemConfig(DropDownModel data) {
		logger.info("Method : saveItemConfig starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(data);
			em.createNamedStoredProcedureQuery("warehouseRoutine").setParameter("actionType", "saveItemConfig")
					.setParameter("actionValue", values).execute();

			resp.setCode("success");

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveItemConfig ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteBinMaster(String id, String createdBy) {
		logger.info("Method : deleteBinMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @P_ModifiedBy='" + createdBy + "', @P_Room='" + id + "';";
				em.createNamedStoredProcedureQuery("warehouseRoutine").setParameter("actionType", "deleteBin")
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

		logger.info("Method : deleteBinMaster ends");
		return response;
	}

	@SuppressWarnings("unused")
	public ResponseEntity<JsonResponse<WirehouseRomeModel>> saveBinConfiguration(WirehouseRomeModel config) {
		logger.info("Method : saveBinConfiguration starts");
		
		Boolean validity = true;
		JsonResponse<WirehouseRomeModel> resp = new JsonResponse<WirehouseRomeModel>();
		resp.setMessage("");
		resp.setCode("");
		List<WirehouseRomeModel> newLoc = new ArrayList<WirehouseRomeModel>();
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
				String values = GenerateWareHouseMasterParameter.saveBinConfig(config);
				em.createNamedStoredProcedureQuery("warehouseRoutine")
						.setParameter("actionType", "saveBinConfiguration").setParameter("actionValue", values)
						.execute();
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

		ResponseEntity<JsonResponse<WirehouseRomeModel>> response = new ResponseEntity<JsonResponse<WirehouseRomeModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("BinR" + response);
		logger.info("Method : saveBinConfiguration ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<WirehouseRomeModel>> viewBindata(String rmId, String orgName, String orgDiv) {
		logger.info("Method : viewBindata starts");

		JsonResponse<WirehouseRomeModel> resp = new JsonResponse<WirehouseRomeModel>();
		List<WirehouseRomeModel> newZone = new ArrayList<WirehouseRomeModel>();

		try {

			String value = "SET @P_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("@@@@@@@@@@@@@@@@@@@@@" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "viewBindata").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				WirehouseRomeModel WirehouseRomeModel = new WirehouseRomeModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6]);
				newZone.add(WirehouseRomeModel);
			}
			if (newZone.size() > 0) {
				resp.setBody(newZone.get(0));
			} else {
				resp.setMessage("No data found");
			}

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

		ResponseEntity<JsonResponse<WirehouseRomeModel>> response = new ResponseEntity<JsonResponse<WirehouseRomeModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewBindata ends");
		return response;
	}

	public ResponseEntity<JsonResponse<WirehouseRomeModel>> deleteBin(String binlist, String orgName, String orgDiv) {
		logger.info("Method : deleteBin starts");

		JsonResponse<WirehouseRomeModel> resp = new JsonResponse<WirehouseRomeModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @p_binId='" + binlist + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			em.createNamedStoredProcedureQuery("warehouseRoutine").setParameter("actionType", "deleteRoomBin")
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

		ResponseEntity<JsonResponse<WirehouseRomeModel>> response = new ResponseEntity<JsonResponse<WirehouseRomeModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : deleteBin ends");
		return response;
	}

	public ResponseEntity<JsonResponse<WirehouseRomeModel>> deleteRoom(String binlist, String orgName, String orgDiv) {
		logger.info("Method : deleteRoom starts");

		JsonResponse<WirehouseRomeModel> resp = new JsonResponse<WirehouseRomeModel>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET @P_binlist='" + binlist + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value@@@@@@@@@@@@@@@@@@" + value);
			em.createNamedStoredProcedureQuery("warehouseRoutine").setParameter("actionType", "deleteRoom")
					.setParameter("actionValue", value).execute();
			// System.out.println("print block" + deleteBim);
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

		ResponseEntity<JsonResponse<WirehouseRomeModel>> response = new ResponseEntity<JsonResponse<WirehouseRomeModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : deleteRoom ends");
		return response;
	}

}
