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
import nirmalya.aatithya.restmodule.common.utils.GenerateWarehouseAllocationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@Repository
public class WarehouseAllocationDao {

	Logger logger = LoggerFactory.getLogger(WarehouseAllocationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/****************************************
	 * Dropdown Section Start
	 ****************************************************/
	// getwarehouseListApi
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getwarehouseListApi(String org, String orgDiv) {
		logger.info("Method : getwarehouseListApi starts");
		List<DropDownModel> whList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		System.out.println("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getWhLocationList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				whList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			resp.setBody(whList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getwarehouseListApi ends");
		System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}

	// getzoneList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getzoneList(String warehouseId, String orgName,
			String orgDiv) {

		logger.info("Method : getzoneList starts");
		List<DropDownModel> zoneList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_warehouseId='" + warehouseId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		System.out.println("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getzoneList").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getzoneList ends");
		System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}

	// rackList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> rackLists(String zoneId, String orgName, String orgDiv) {

		logger.info("Method : rackLists starts");
		List<DropDownModel> rackList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_zoneId='" + zoneId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		// System.out.println("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "rackList").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : rackLists ends");
		// System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}

//getManufacturePlaceLists
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getManufacturePlaceLists(String org, String orgDiv) {
		logger.info("Method : getManufacturePlaceLists starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getManufacturePlaceLists").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getManufacturePlaceLists ends");
		return getCollectionList;
	}

//getManufacturePlaceListsApi
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getManufacturePlaceListsApi(String org, String orgDiv) {

		logger.info("Method : getManufacturePlaceListsApi starts");
		List<DropDownModel> mgfPlaceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getManufacturePlaceLists").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				mgfPlaceList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			resp.setBody(mgfPlaceList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getManufacturePlaceListsApi ends");
		System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}

//getBatchGenerateType
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBatchNoLists(String org, String orgDiv) {
		logger.info("Method : getBatchNoLists starts");

		List<DropDownModel> getBatchList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getBatchNoLists").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getBatchList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBatchNoLists ends");
		return getBatchList;
	}

//getBatchGenerateTypeApi
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBatchGenerateTypeApi(String org, String orgDiv) {

		logger.info("Method : getBatchGenerateTypeApi starts");
		List<DropDownModel> batchList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getBatchNoLists").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				batchList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			resp.setBody(batchList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getBatchGenerateTypeApi ends");
		System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}

//getShiftListsAllocation	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getShiftListsAllocation(String org, String orgDiv, String userId) {
		logger.info("Method : getShiftListsAllocation starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getShiftListsAllocation").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getShiftListsAllocation ends");
		return getCollectionList;
	}

	// getShiftListsAllocationApi
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getShiftListsAllocationApi(String org, String orgDiv,
			String userId) {

		logger.info("Method : getShiftListsAllocationApi starts");
		List<DropDownModel> batchList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		System.out.println("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getShiftListsAllocation").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				batchList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			resp.setBody(batchList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getShiftListsAllocationApi ends");
		System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}

//getLineLists			
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLineLists(String org, String orgDiv) {
		logger.info("Method : getLineLists starts");

		List<DropDownModel> getLineList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getLineLists").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getLineList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLineLists ends");
		return getLineList;
	}

	// getLineListsApi
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLineListsApi(String org, String orgDiv) {

		logger.info("Method : getLineListsApi starts");
		List<DropDownModel> lineList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getLineLists").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				lineList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			resp.setBody(lineList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getLineListsApi ends");
		System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}

//getPackingSiteLists
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPackingSiteLists(String org, String orgDiv) {
		logger.info("Method : getPackingSiteLists starts");

		List<DropDownModel> getLineList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getPackingSiteLists").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getLineList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPackingSiteLists ends");
		return getLineList;
	}

	// getPackingSiteListsApi
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPackingSiteListsApi(String org, String orgDiv) {

		logger.info("Method : getPackingSiteListsApi starts");
		List<DropDownModel> packList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getPackingSiteLists").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				packList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			resp.setBody(packList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPackingSiteListsApi ends");
		System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}

	// getUomListsApi
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUomListsApi() {

		logger.info("Method : getUomListsApi starts");
		List<DropDownModel> uomList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getUOM").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				uomList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			resp.setBody(uomList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getUomListsApi ends");
		System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}

	/****************************************
	 * Main Section Start
	 ****************************************************/

	// getCategoryListApi
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCategoryListApi(String org, String orgDiv) {
		logger.info("Method : getCategoryListApi starts");
		List<DropDownModel> whList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseRoutine")
					.setParameter("actionType", "getWarehouseItemCategoryList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				whList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			resp.setBody(whList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCategoryListApi ends");
		System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}

//getitemList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getitemList(String categoryId, String orgName,
			String orgDiv) {

		logger.info("Method : getitemList starts");
		List<DropDownModel> zoneList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_categoryId='" + categoryId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		System.out.println("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getitemList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2], m[3]);
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
		logger.info("Method : getitemList ends");
		System.out.println("++++++++++++++++++++++++++" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getWarehouseData(String warehouseId, String orgName, String orgDiv) {
		logger.info("Method : getWarehouseData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_warehouseId='" + warehouseId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			System.out.println("values****************************" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getWarehouseData").setParameter("actionValue", values).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : getWarehouseData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// warehouseGetSearchData
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> warehouseGetSearchData(String warehouseId, String zoneId, String rackId,
			String categoryId, String itemName, String orgName, String orgDiv) {
		logger.info("Method : warehouseGetSearchData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_warehouseId='" + warehouseId + "',@p_zoneId='" + zoneId + "',@p_rackId='" + rackId
					+ "',@p_categoryId='" + categoryId + "',@p_itemName='" + itemName + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "warehouseGetSearchData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : warehouseGetSearchData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}

	// saveAllocation
	public ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> saveAllocation(
			List<WirehouseRomeModel> wirehouseRomeModel) {
		logger.info("Method : saveAllocation starts");
		JsonResponse<List<WirehouseRomeModel>> resp = new JsonResponse<List<WirehouseRomeModel>>();
		List<WirehouseRomeModel> listData = new ArrayList<WirehouseRomeModel>();

		System.out.println("=====>>>>>" + wirehouseRomeModel);

		try {
			String values = GenerateWarehouseAllocationParameter.saveAllocationParam(wirehouseRomeModel);
			em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
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
		System.out.println("response data is" + response);
		logger.info("Method : saveAllocation ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getAvlBinLocBySKU(DropDownModel data) {
		logger.info("Method : getAvlBinLocBySKU starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(data);
			System.out.println(values);
			
			List<Object[]> x = null;
			if(data.getId() != null && data.getId().equals("BLOCK")) {
				x = em.createNamedStoredProcedureQuery("warehouseGoodsBlockRoutine")
						.setParameter("actionType", "getAvlBin").setParameter("actionValue", values).getResultList();
			} else {
				x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
						.setParameter("actionType", "getAvlBin").setParameter("actionValue", values).getResultList();
			}
			
			
			if(x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getAvlBinLocBySKU ends");
		return response;
	}

	// rest-viewAllocationData
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAllocationData(String orgName, String orgDivision, String pageno,String type) {
		logger.info("Method : viewAllocationData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pageno='" + pageno + "', @p_type='" + type + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "viewAllocationData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAllocationData Dao ends");
		return resp;

	}

	// Clear bin data
	public ResponseEntity<JsonResponse<WirehouseRomeModel>> clearBinData(String aiddatas, String bdata, String orgName,
			String orgDiv) {
		logger.info("Method : clearBinData starts");
		JsonResponse<WirehouseRomeModel> resp = new JsonResponse<WirehouseRomeModel>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_aiddatas='(" + aiddatas + ")',@p_bdata='(" + bdata + ")',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value@@@@@@@@@@@@@@@@@@" + value);
			em.createNamedStoredProcedureQuery("warehouseAllocationRoutine").setParameter("actionType", "clearBinData")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Data Clear Successfully");
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
		ResponseEntity<JsonResponse<WirehouseRomeModel>> response = new ResponseEntity<JsonResponse<WirehouseRomeModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : clearBinData ends");
		return response;
	}

//deleteAllocationdata
	public JsonResponse<Object> deleteAllocationdata(String allocId, String orgName, String orgDiv) {
		logger.info("Method : deleteAllocationdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_allocId='" + allocId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "deleteAllocationdata").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Deleted Successfully");
			// resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : deleteAllocationdata Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// approveAllocationdata
	public JsonResponse<Object> approveAllocationdata(String allocId, String orgName, String orgDiv) {
		logger.info("Method : approveAllocationdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_allocId='" + allocId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "approveAllocationdata").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Request To Stacking Successfully");
			// resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approveAllocationdata Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

//View allocation data
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewBinAllocationdata(String rmId, String orgName, String orgDiv) {
		logger.info("Method : viewBinAllocationdata Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "viewBinAllocationdata").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewBinAllocationdata Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// View bin data
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewbinconfigdata(String rmId, String orgName, String orgDiv) {
		logger.info("Method : viewbinconfigdata Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "viewbinconfigdata").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewbinconfigdata Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// Get Batch data
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getBatchData(String orgName, String orgDiv) {
		logger.info("Method : getBatchData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "getBatchData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : getBatchData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// holdAllocationdata
	public JsonResponse<Object> holdAllocationdata(String rmId, String orgName, String orgDiv) {
		logger.info("Method : approveAllocationdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "holdAllocationdata").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Bin Hold Successfully");
			// resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : holdAllocationdata Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// releaseAllocationdata
	public JsonResponse<Object> releaseAllocationdata(String rmId, String orgName, String orgDiv) {
		logger.info("Method : releaseAllocationdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("warehouseAllocationRoutine")
					.setParameter("actionType", "releaseAllocationdata").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Bin Release Successfully");
			// resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : releaseAllocationdata Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
}
