package nirmalya.aatithya.restmodule.asset.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.asset.dao.helper.AssetDashboardDaoHelper;
import nirmalya.aatithya.restmodule.asset.model.DashboardData;
import nirmalya.aatithya.restmodule.common.CommonConstants;
import nirmalya.aatithya.restmodule.common.CommonUsed;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AssetDashboardDao {
	private static final String DATA_FETCHED_SUCCESSFULLY = "Data fetched successfully";
	private static final String END_OF_INSURANCE = "End of insurance";
	private static final String END_OF_LIFE = "End of life";
	Logger logger = LoggerFactory.getLogger(AssetDashboardDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager em;

	@Autowired
	private AssetDashboardDaoHelper assetDashboardDaoHelper;

	public static boolean isDateBeforeToday(String dateStr) {
		// Parse the date string
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dateStr, formatter);
		LocalDate today = LocalDate.now();
		return date.isBefore(today);
	}

	/*
	 * public JsonResponse<Object> getAllData(String orgName, String orgDivision,
	 * String id, String month, String year) {
	 * logger.info("Method : getAllData Dao start."); JsonResponse<Object> resp =
	 * new JsonResponse<>(); try { String value = "SET @p_org='" + orgName +
	 * "',@p_orgDiv='" + orgDivision + "', @p_id='" + id + "', @p_month='" + month +
	 * "', @p_year='" + year + "';"; logger.info("values: {}", value);
	 * List<Object[]> x = CommonUsed.getResultList("asset_dashboard_Routines",
	 * "getAllData", value, em); String message = DATA_FETCHED_SUCCESSFULLY;
	 * Util.setJsonResponse(resp, x, CommonConstants.HTTP_STATUS_OK, message); }
	 * catch (Exception e) { CommonUsed.getErrorDetails(resp, e, serverDao);
	 * e.printStackTrace(); } logger.info("Method : getAllData Dao ends {}", resp);
	 * return resp;
	 * 
	 * }
	 */

	// @Autowired
	// private EnvironmentVaribles env;

	/*
	 * public JsonResponse<Object> oprationalHeadData(String orgName, String
	 * orgDivision, String month, String year) {
	 * logger.info("Method : oprationalHeadData Dao start."); JsonResponse<Object>
	 * resp = new JsonResponse<Object>(); try { String value = "SET @p_org='" +
	 * orgName + "',@p_orgDiv='" + orgDivision + "', @p_month='" + month +
	 * "', @p_year='" + year + "';"; logger.info("values {}", value); List<Object> x
	 * = CommonUsed.getResultListSimpleObject("asset_dashboard_Routines",
	 * "viewDashboardHeadData", value, em); String message =
	 * DATA_FETCHED_SUCCESSFULLY; Util.setJsonResponse(resp, x,
	 * CommonConstants.HTTP_STATUS_OK, message); } catch (Exception e) {
	 * CommonUsed.getErrorDetails(resp, e, serverDao); e.printStackTrace(); }
	 * logger.info("Method : oprationalHeadData Dao ends {}", resp); return resp; }
	 * 
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> salesstateperformance(String orgName, String orgDivision) {
		logger.info("Method : accumulatedrevenue Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_Routines")
					.setParameter("actionType", "assetCountByCategory").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage(DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : salesstateperformance Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetEndOfLife(String orgName, String orgDivision) {
		logger.info("Method : assetEndOfLife start");

		JsonResponse<Object> resp = new JsonResponse<>();
		List<Object> resultList;
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("assetEndLife values {}", value);
			try {
				resultList = em.createNamedStoredProcedureQuery("asset_dashboard_Routines")
						.setParameter("actionType", "assetEndLife").setParameter("actionValue", value).getResultList();
			} catch (Exception e) {
				assetDashboardDaoHelper.handleException(resp, e);
				return resp;
			}
			// Map to store data grouped by month and category
			Map<String, List<Integer>> dataMap = new HashMap<>();
			String[] categoryArray = null;
			// Iterate over the result list
			for (Object obj : resultList) {
				if (obj instanceof String) {
					JSONObject jsonObject = new JSONObject((String) obj);
					String categoryNames = jsonObject.optString("categoryNames");
					categoryArray = categoryNames.split(",");

					JSONArray endOFLifeArray = jsonObject.getJSONArray("endOFLife");
//					JSONArray endOfInsuranceArray = jsonObject.getJSONArray("endOfInsurance");

					dataMap.putIfAbsent(END_OF_LIFE, new ArrayList<>());

					dataMap.putIfAbsent(END_OF_INSURANCE, new ArrayList<>());
					for (String categoryNameToCheck : categoryArray) {
						int count = 0;
						boolean isCategoryPresent = false;

						assetDashboardDaoHelper.assetEndOfLifeFilterCategory(count, isCategoryPresent, endOFLifeArray,
								categoryNameToCheck, dataMap, END_OF_LIFE);

						isCategoryPresent = false;
//						assetDashboardDaoHelper.assetEndOfLifeFilterCategory(count, isCategoryPresent,
//								endOfInsuranceArray, categoryNameToCheck, dataMap, END_OF_INSURANCE);
					}
				}
			}
			Map<String, Object> responseMap = new HashMap<>();
			assetDashboardDaoHelper.setDataForGraph(dataMap, categoryArray, responseMap);
			Util.setJsonResponse(resp, responseMap, CommonConstants.HTTP_STATUS_OK, DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {
			CommonUsed.getErrorDetails(resp, e, serverDao);
			e.printStackTrace();
		}

		logger.info("Method : assetEndOfLife stand , response{}", resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetVerificationStatus(String orgName, String orgDivision) {
		logger.info("Method : assetVerificationStatus Dao start.");

		JsonResponse<Object> resp = new JsonResponse<>();
		List<Object> resultList;
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("assetEndLife values {}", value);
			try {
				resultList = em.createNamedStoredProcedureQuery("asset_dashboard_Routines")
						.setParameter("actionType", "assetVerificationStatus").setParameter("actionValue", value)
						.getResultList();
			} catch (Exception e) {
				assetDashboardDaoHelper.handleException(resp, e);
				return resp;
			}
			Map<String, List<Integer>> dataMap = new HashMap<>();
			String[] categoryArray = null;

			for (Object obj : resultList) {
				if (obj instanceof String) {
					JSONObject jsonObject = new JSONObject((String) obj);
					String categoryNames = jsonObject.optString("categoryNames");

					categoryArray = categoryNames.split(",");
					Set<String> categorySet = new HashSet<>(Arrays.asList(categoryNames.split(",")));

					List<DashboardData> dashboardDataList = assetDashboardDaoHelper
							.extractDashboardData(jsonObject.getJSONArray("dashboardData"));
					for (DashboardData data : dashboardDataList) {
						dataMap.computeIfAbsent("", k -> new ArrayList<>()).add(data.getValue());
					}
				}
			}

			Map<String, Object> responseMap = new HashMap<>();
			assetDashboardDaoHelper.setDataForGraph(dataMap, categoryArray, responseMap);
			Util.setJsonResponse(resp, responseMap, CommonConstants.HTTP_STATUS_OK, DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {
			CommonUsed.getErrorDetails(resp, e, serverDao);
			e.printStackTrace();
		}

		logger.info("Method : assetVerificationStatus Dao ends {}", resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetTotalSpend(String orgName, String orgDivision) {
		logger.info("Method : assetTotalSpend Dao start.");

		JsonResponse<Object> resp = new JsonResponse<>();
		List<Object> resultList = null;
		try {
			String actionValue = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values {}", actionValue);
			try {
				resultList = em.createNamedStoredProcedureQuery("asset_dashboard_Routines")
						.setParameter("actionType", "assetTotalSpend").setParameter("actionValue", actionValue)
						.getResultList();
			} catch (Exception e) {
				assetDashboardDaoHelper.handleException(resp, e);
			}
			Map<String, List<Double>> dataMap = new HashMap<>();
			String[] monthArray = null;

			for (Object obj : resultList) {
				if (obj instanceof String) {
					JSONObject jsonObject = new JSONObject((String) obj);
					String categoryNames = jsonObject.optString("categoryNames");
					String monthNames = jsonObject.optString("monthNames");

					monthArray = monthNames.split(",");
					Set<String> categorySet = new HashSet<>(Arrays.asList(categoryNames.split(",")));

					List<DashboardData> dashboardDataList = assetDashboardDaoHelper
							.extractDashboardData(jsonObject.getJSONArray("dashboardData"));

					assetDashboardDaoHelper.processDashboardData(dashboardDataList, monthArray, categorySet, dataMap);
				}
			}

			Map<String, Object> responseMap = assetDashboardDaoHelper.buildResponseMap(monthArray, dataMap);

			Util.setJsonResponse(resp, responseMap, CommonConstants.HTTP_STATUS_OK, DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {
			CommonUsed.getErrorDetails(resp, e, serverDao);
		}

		logger.info("Method : assetTotalSpend Dao ends {}", resp);
		return resp;
	}

	public JsonResponse<Object> assetBreakupHardwareAssets(String orgName, String orgDivision) {
		logger.info("Method : assetBreakupHardwareAssets Dao start.");
		JsonResponse<Object> resp = new JsonResponse<>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("BreakupHardwareAssets values {}", value);
		List<Object> resultList = null;
		try {
			try {
				resultList = CommonUsed.getResultListSimpleObject("asset_dashboard_Routines",
						"assetBreakupHardwareAssets", value, em);
			} catch (Exception e) {
				assetDashboardDaoHelper.handleException(resp, e);
			}
			Map<String, List<Integer>> dataMap = new HashMap<>();
			String[] hardWareAssetArray = null; // Declare as final

			// Move initialization outside lambda expression

			for (Object result : resultList) {
				if (result instanceof String) {
					JSONObject jsonObject = new JSONObject((String) result);
					String subCategory = jsonObject.optString("subCategory");

					hardWareAssetArray = subCategory.split(",");
					// Extract the nested JSON string
					String dashboardDataString = jsonObject.getString("dashboardData");

					// Parse the nested JSON string into a JSONArray
					JSONArray dashboardDataArray = new JSONArray(dashboardDataString);
					List<DashboardData> dashboardDataList = assetDashboardDaoHelper
							.extractDashboardData(dashboardDataArray);
					// Use stream and filter to extract unique keys
					Set<String> uniqueKeys = dashboardDataList.stream().map(DashboardData::getKey)
							.collect(Collectors.toSet());
					for (String category : hardWareAssetArray) {
						for (String set : uniqueKeys) {
							List<Integer> values = dataMap.computeIfAbsent(set, k -> new ArrayList<>());
							Integer sumOfPrice = dashboardDataList.stream()
									.filter(data -> StringUtils.equals(category.trim(), data.getSubCategory())
											&& StringUtils.equals(set.trim(), data.getKey()))
									.mapToInt(DashboardData::getValue).findFirst().orElse(0);
							values.add(sumOfPrice);
						}
					}
				}
			}
			Map<String, Object> responseMap = new HashMap<>();
			assetDashboardDaoHelper.setDataForGraph(dataMap, hardWareAssetArray, responseMap);
			Util.setJsonResponse(resp, responseMap, CommonConstants.HTTP_STATUS_OK, DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {
			CommonUsed.getErrorDetails(resp, e, serverDao);
			e.printStackTrace();
		}
		logger.info("Method : assetBreakupHardwareAssets Dao ends {}", resp);
		return resp;

	}

//assetAssetCountByLocation
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetAssetCountByLocation(String orgName, String orgDivision) {
		logger.info("Method : assetAssetCountByLocation Dao startssssssssssssssssssssss");
		System.out.print("assetAssetCountByLocation");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("assetCountByLocation values {}", value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_Routines")
					.setParameter("actionType", "assetLocation").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage(DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {

			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : assetCountByLocation Dao ends {}", resp);
		return resp;
	}

	// assetAssetCountByLifeState
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetAssetCountByLifeState(String orgName, String orgDivision) {
		logger.info("Method : assetAssetCountByLifeState Dao startssssssssssssssssssssss");
		System.out.print("assetAssetCountByLifeState");
		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_Routines")
					.setParameter("actionType", "assetLifeState").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage(DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : assetAssetCountByLifeState Dao ends" + resp);
		return resp;

	}

//		assetAssetCountByLifeState
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetAssetValueByCategory(String orgName, String orgDivision) {
		logger.info("Method : assetAssetValueByCategory Dao startssssssssssssssssssssss");
		System.out.print("assetAssetValueByCategory");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_Routines")
					.setParameter("actionType", "assetValueByCategory").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage(DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : assetAssetValueByCategory Dao ends" + resp);
		return resp;

	}

	public JsonResponse<Object> assetAssetsPulledFromPool(String orgName, String orgDivision) {
		logger.info("Method : assetAssetsPulledFromPool Dao start.");
		JsonResponse<Object> resp = new JsonResponse<>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("assetAssetsPulledFromPool values {}", value);
		List<Object> resultList = null;
		try {
			try {
				resultList = CommonUsed.getResultListSimpleObject("asset_dashboard_Routines",
						"assetAssetsPulledFromPool", value, em);
			} catch (Exception e) {
				assetDashboardDaoHelper.handleException(resp, e);
			}
			Map<String, List<Integer>> dataMap = new HashMap<>();
			String[] assetStateArray = null;

			// Move initialization outside lambda expression

			for (Object result : resultList) {
				if (result instanceof String) {
					JSONObject jsonObject = new JSONObject((String) result);
					String subCategory = jsonObject.optString("categoryName");

					assetStateArray = subCategory.split(",");
					// Extract the nested JSON string
					String dashboardDataString = jsonObject.getString("dashboardData");

					// Parse the nested JSON string into a JSONArray
					JSONArray dashboardDataArray = new JSONArray(dashboardDataString);
					List<DashboardData> dashboardDataList = assetDashboardDaoHelper
							.extractDashboardData(dashboardDataArray);
					// Use stream and filter to extract unique keys
					Set<String> uniqueKeys = dashboardDataList.stream().map(DashboardData::getAssetState)
							.collect(Collectors.toSet());
					for (String category : assetStateArray) {
						for (String set : uniqueKeys) {
							List<Integer> values = dataMap.computeIfAbsent(set, k -> new ArrayList<>());
							Integer sumOfPrice = dashboardDataList.stream()
									.filter(data -> StringUtils.equals(category.trim(), data.getKey())
											&& StringUtils.equals(set.trim(), data.getAssetState()))
									.mapToInt(DashboardData::getValue).findFirst().orElse(0);
							values.add(sumOfPrice);
						}
					}
				}
			}
			Map<String, Object> responseMap = new HashMap<>();
			assetDashboardDaoHelper.setDataForGraph(dataMap, assetStateArray, responseMap);
			Util.setJsonResponse(resp, responseMap, CommonConstants.HTTP_STATUS_OK, DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {
			CommonUsed.getErrorDetails(resp, e, serverDao);
			e.printStackTrace();
		}
		logger.info("Method : assetAssetsPulledFromPool Dao ends {}", resp);
		return resp;
	}

	public JsonResponse<Object> assetAssetFulfillmentTime(String orgName, String orgDivision) {
		logger.info("Method : assetAssetFulfillmentTime Dao start.");
		JsonResponse<Object> resp = new JsonResponse<>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("assetAssetFulfillmentTime values {}", value);
		List<Object> resultList = null;
		try {
			try {
				resultList = CommonUsed.getResultListSimpleObject("asset_dashboard_Routines",
						"assetAssetFulfillmentTime", value, em);
			} catch (Exception e) {
				assetDashboardDaoHelper.handleException(resp, e);
			}
			Map<String, List<Integer>> dataMap = new HashMap<>();
			String[] timeRangeArray = null;

			// Move initialization outside lambda expression

			for (Object result : resultList) {
				if (result instanceof String) {
					JSONObject jsonObject = new JSONObject((String) result);
					String timeRange = jsonObject.optString("categoryName");

					timeRangeArray = timeRange.split(",");
					// Extract the nested JSON string
					String dashboardDataString = jsonObject.getString("dashboardData");

					// Parse the nested JSON string into a JSONArray
					JSONArray dashboardDataArray = new JSONArray(dashboardDataString);
					List<DashboardData> dashboardDataList = assetDashboardDaoHelper
							.extractDashboardData(dashboardDataArray);
					// Use stream and filter to extract unique keys
					Set<String> uniqueKeys = dashboardDataList.stream().map(DashboardData::getKey)
							.collect(Collectors.toSet());
					for (String category : timeRangeArray) {
						for (String set : uniqueKeys) {
							List<Integer> values = dataMap.computeIfAbsent(set, k -> new ArrayList<>());
							Integer sumOfPrice = dashboardDataList.stream()
									.filter(data -> StringUtils.equals(category.trim(), data.getTimeRange())
											&& StringUtils.equals(set.trim(), data.getKey()))
									.mapToInt(DashboardData::getValue).findFirst().orElse(0);
							values.add(sumOfPrice);
						}
					}
				}
			}
			Map<String, Object> responseMap = new HashMap<>();
			assetDashboardDaoHelper.setDataForGraph(dataMap, timeRangeArray, responseMap);
			Util.setJsonResponse(resp, responseMap, CommonConstants.HTTP_STATUS_OK, DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {
			CommonUsed.getErrorDetails(resp, e, serverDao);
			e.printStackTrace();
		}
		logger.info("Method : assetAssetFulfillmentTime Dao ends {}", resp);
		return resp;
	}

	public JsonResponse<Object> assetValuation(String orgName, String orgDivision) {
		logger.info("Method : assetValuation Dao start.");
		JsonResponse<Object> resp = new JsonResponse<>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("assetValuation values {}", value);
		List<Object> resultList = null;
		try {
			try {
				resultList = CommonUsed.getResultListSimpleObject("asset_dashboard_Routines", "assetValuation", value,
						em);
				Util.setJsonResponse(resp, resultList, CommonConstants.HTTP_STATUS_OK, DATA_FETCHED_SUCCESSFULLY);
			} catch (Exception e) {
				assetDashboardDaoHelper.handleException(resp, e);
			}
		} catch (Exception e) {
			CommonUsed.getErrorDetails(resp, e, serverDao);
			e.printStackTrace();
		}
		logger.info("Method : assetValuation Dao ends {}", resp);
		return resp;
	}

	public JsonResponse<Object> scrapedValuation(String orgName, String orgDivision) {
		logger.info("Method : scrapedValuation Dao start.");
		JsonResponse<Object> resp = new JsonResponse<>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("scrapedValuation values {}", value);
		List<Object> resultList = null;
		try {
			try {
				resultList = CommonUsed.getResultListSimpleObject("asset_dashboard_Routines", "scrapedValuation", value,
						em);
			} catch (Exception e) {
				assetDashboardDaoHelper.handleException(resp, e);
			}
			Map<String, List<Integer>> dataMap = new HashMap<>();
			String[] monthArray = null;
			for (Object result : resultList) {
				if (result instanceof String) {
					JSONObject jsonObject = new JSONObject((String) result);
					String timeRange = jsonObject.optString("monthArray");

					monthArray = timeRange.split(",");
					// Extract the nested JSON string
					String dashboardDataString = jsonObject.getString("dashboardData");
					// Parse the nested JSON string into a JSONArray
					JSONArray dashboardDataArray = new JSONArray(dashboardDataString);
					List<DashboardData> dashboardDataList = assetDashboardDaoHelper
							.extractDashboardData(dashboardDataArray);

					Set<String> category = dashboardDataList.stream().map(DashboardData::getCategory)
							.collect(Collectors.toSet());
					for (String month : monthArray) {
						for (String cat : category) {
							List<Integer> values = dataMap.computeIfAbsent(cat, k -> new ArrayList<>());
							Integer getCount = dashboardDataList.stream()
									.filter(data -> StringUtils.equals(cat, data.getCategory())
											&& StringUtils.equals(data.getMonth(), month.trim()))
									.mapToInt(DashboardData::getValue).findFirst().orElse(0);
							values.add(getCount);
						}
					}
				}
			}
			Map<String, Object> responseMap = new HashMap<>();
			assetDashboardDaoHelper.setDataForGraph(dataMap, monthArray, responseMap);
			Util.setJsonResponse(resp, responseMap, CommonConstants.HTTP_STATUS_OK, DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {
			CommonUsed.getErrorDetails(resp, e, serverDao);
			e.printStackTrace();
		}
		logger.info("Method : scrapedValuation Dao ends {}", resp);
		return resp;
	}

	public JsonResponse<Object> netAssetValuation(String orgName, String orgDivision) {
		logger.info("Method : netAssetValuation Dao start.");
		JsonResponse<Object> resp = new JsonResponse<>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("netAssetValuation values {}", value);
		List<Object> resultList = null;
		try {
			try {
				resultList = CommonUsed.getResultListSimpleObject("asset_dashboard_Routines", "netAssetValuation",
						value, em);
			} catch (Exception e) {
				e.printStackTrace();
				assetDashboardDaoHelper.handleException(resp, e);
			}
			Map<String, List<Integer>> dataMap = new HashMap<>();
			String[] monthArray = null;
			for (Object result : resultList) {
				if (result instanceof String) {
					JSONObject jsonObject = new JSONObject((String) result);
					String timeRange = jsonObject.optString("monthArray");

					monthArray = timeRange.split(",");
					// Extract the nested JSON string
					String dashboardDataString = jsonObject.getString("dashboardData");
					// Parse the nested JSON string into a JSONArray
					JSONArray dashboardDataArray = new JSONArray(dashboardDataString);
					List<DashboardData> dashboardDataList = assetDashboardDaoHelper
							.extractDashboardData(dashboardDataArray);

					Set<String> category = dashboardDataList.stream().map(DashboardData::getCategory)
							.collect(Collectors.toSet());
					for (String month : monthArray) {
						for (String cat : category) {
							List<Integer> values = dataMap.computeIfAbsent(cat, k -> new ArrayList<>());
							Integer getCount = dashboardDataList.stream()
									.filter(data -> StringUtils.equals(cat, data.getCategory())
											&& StringUtils.equals(data.getMonth(), month.trim()))
									.mapToInt(data -> data.getValue() - data.getScrapValue()).findFirst().orElse(0);
							values.add(getCount);
						}
					}
				}
			}
			Map<String, Object> responseMap = new HashMap<>();
			assetDashboardDaoHelper.setDataForGraph(dataMap, monthArray, responseMap);
			Util.setJsonResponse(resp, responseMap, CommonConstants.HTTP_STATUS_OK, DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {
			CommonUsed.getErrorDetails(resp, e, serverDao);
			e.printStackTrace();
		}
		logger.info("Method : netAssetValuation Dao ends {}", resp);
		return resp;
	}

	public JsonResponse<Object> maenTimeToRepair(String orgName, String orgDivision) {
		logger.info("Method : maenTimeToRepair Dao start.");
		JsonResponse<Object> resp = new JsonResponse<>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("maenTimeToRepair values {}", value);
		List<Object> resultList = null;
		try {
			try {
				resultList = CommonUsed.getResultListSimpleObject("asset_dashboard_Routines", "maenTimeToRepair", value,
						em);
			} catch (Exception e) {
				e.printStackTrace();
				assetDashboardDaoHelper.handleException(resp, e);
			}
			Map<String, List<Integer>> dataMap = new HashMap<>();
			String[] categoryArray = null;
			for (Object result : resultList) {
				if (result instanceof String) {
					JSONObject jsonObject = new JSONObject((String) result);
					String subCategory = jsonObject.optString("categoryName");

					categoryArray = subCategory.split(",");
					// Extract the nested JSON string
					String dashboardDataString = jsonObject.getString("dashboardData");

					// Parse the nested JSON string into a JSONArray
					JSONArray dashboardDataArray = new JSONArray(dashboardDataString);
					List<DashboardData> dashboardDataList = assetDashboardDaoHelper
							.extractDashboardData(dashboardDataArray);

					for (String categoryName : categoryArray) {
						List<Integer> values = dataMap.computeIfAbsent(categoryName, k -> new ArrayList<>());
						Integer getCount = dashboardDataList.stream()
								.filter(data -> StringUtils.equals(data.getCategory(), categoryName.trim()))
								.mapToInt(data -> data.getAverageDay()).findFirst().orElse(0);
						values.add(getCount);
					}
				}
			}
			Map<String, Object> responseMap = new HashMap<>();
			assetDashboardDaoHelper.setDataForGraph(dataMap, categoryArray, responseMap);
			Util.setJsonResponse(resp, responseMap, CommonConstants.HTTP_STATUS_OK, DATA_FETCHED_SUCCESSFULLY);
		} catch (Exception e) {
			CommonUsed.getErrorDetails(resp, e, serverDao);
			e.printStackTrace();
		}
		logger.info("Method : maenTimeToRepair Dao ends {}", resp);
		return resp;
	}

/////////////////////////////////////////////////////  Start  maintainance

//maintainancemonthlybackloganalysis
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> monthlybackloganalysis(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : maintainancemonthlybackloganalysis");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "monloganalysis").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : maintainancemonthlybackloganalysis Dao ends" + resp);
		return resp;

	}

//maintainancescheduledassigned
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> maintainancescheduledassigned(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : maintainancescheduledassigned");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "maintainancescheduledassigned").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : maintainancescheduledassigned Dao ends" + resp);
		return resp;

	}

//maintainancepreventivemaintainance
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> maintainancepreventivemaintainance(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : maintainancepreventivemaintainance");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "maintainancepreventivemaintainance").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : maintainancepreventivemaintainance Dao ends" + resp);
		return resp;

	}

//maintainancepreventivemaintainance
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> maintainanceplannedmaintainancepercentage(String orgName, String orgDivision,
			String fromDate, String toDate) {
		logger.info("Method : maintainanceplannedmaintainancepercentage");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values for maintainanceplannedmaintainancepercentage****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "plannedmaintainancepercentage").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : maintainanceplannedmaintainancepercentage Dao ends" + resp);
		return resp;

	}

//maintainanceassetgroupassets
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> maintainanceassetgroupassets(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : maintainanceassetgroupassets");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "maintainanceassetgroupassets").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : maintainanceassetgroupassets Dao ends" + resp);
		return resp;

	}

//maintainanceassetgroupassets
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> departmentsassetscriticality(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : departmentsassetscriticality");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "departmentsassetscriticality").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : departmentsassetscriticality Dao ends" + resp);
		return resp;

	}

//workorderoverview
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> workorderoverview(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : workorderoverview");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values workorderoverview****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "workorderoverview").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : workorderoverview Dao ends" + resp);
		return resp;

	}

//workorderoverview
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> workorderstype(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : workorderstype");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "workorderstype").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : workorderstype Dao ends" + resp);
		return resp;

	}

//unplannedlaborhours
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> unplannedlaborhours(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : unplannedlaborhours");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "unplannedlaborhours").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : unplannedlaborhours Dao ends" + resp);
		return resp;

	}

//workordersstatus
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> workordersstatus(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : workordersstatus");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "workordersstatus").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : workordersstatus Dao ends" + resp);
		return resp;

	}

//workordersstatus
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> workOrderactualestimatedcosts(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : workOrderactualestimatedcosts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "workOrderactualestimatedcosts").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : workOrderactualestimatedcosts Dao ends" + resp);
		return resp;

	}

//workordersstatus
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> countpercentageunsolvedtickets(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : countpercentageunsolvedtickets");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		System.out.print("bulet");
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values countpercentageunsolvedtickets****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "countpercentageunsolvedtickets").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : countpercentageunsolvedtickets Dao ends" + resp);
		return resp;

	}

//meantimerepair
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> meantimerepair(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : meantimerepair");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String div = orgDivision.trim();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "meantimerepair").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : meantimerepair Dao ends" + resp);
		return resp;

	}

//meantimedetect
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> meantimedetect(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : meantimedetect");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "meantimedetect").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : meantimedetect Dao ends" + resp);
		return resp;
	}

//meantimedetect
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> reopenedtickets(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : reopenedtickets");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "reopenedtickets").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : reopenedtickets Dao ends" + resp);
		return resp;

	}

//meantimedetect
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> totalratiopercentage(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : totalratiopercentage");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "totalratiopercentage").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : totalratiopercentage Dao ends" + resp);
		return resp;

	}

//totatratioperyear
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> totatratioperyear(String orgName, String orgDivision, String userid, String fromDate,
			String toDate) {
		logger.info("Method : totatratioperyear");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_userid='" + userid
					+ "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
			System.out.println("value for totatratioperyear----------------------" + value);
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "totatratioperyear").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : totatratioperyear Dao ends" + resp);
		return resp;

	}

//////////////////////////////////////////////////////// End maintainance

	//////////////////////////////////////////////////////// Start Asset

	// assetcountbycategory
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetcountbycategory(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : assetcountbycategory");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values assetcountbycategory****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_asset_Routines")
					.setParameter("actionType", "assetcountbycategory").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : assetcountbycategory Dao ends" + resp);
		return resp;

	}

	// countbyLifestate
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> countbyLifestate(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : countbyLifestate");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values countbyLifestate****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_asset_Routines")
					.setParameter("actionType", "countbyLifestate").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : countbyLifestate Dao ends" + resp);
		return resp;

	}

	// valuebycategory
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> valuebycategory(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : valuebycategory");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values valuebycategory ****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_asset_Routines")
					.setParameter("actionType", "valuebycategory").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : valuebycategory Dao ends" + resp);
		return resp;

	}

	// countbylocation
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> countbylocation(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : countbylocation");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_asset_Routines")
					.setParameter("actionType", "countbylocation").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : countbylocation Dao ends" + resp);
		return resp;

	}

	// assetfulfillmenttime
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetfulfillmenttime(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : assetfulfillmenttime");
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values assetfulfillmenttime****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_asset_Routines")
					.setParameter("actionType", "assetfulfillmenttime").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : assetfulfillmenttime Dao ends" + resp);
		return resp;

	}

	// totalspend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> totalspend(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : totalspend");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values  totalspend****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_asset_Routines")
					.setParameter("actionType", "totalspend").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : totalspend Dao ends" + resp);
		return resp;

	}

	// assetstatus
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetstatus(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : assetstatus");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_asset_Routines")
					.setParameter("actionType", "assetstatus").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : assetstatus Dao ends" + resp);
		return resp;

	}

	// assetstatus
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> endlifenextdays(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : endlifenextdays");
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_asset_Routines")
					.setParameter("actionType", "endlifenextdays").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : endlifenextdays Dao ends" + resp);
		return resp;

	}

	// assetspulledfrompoolnetnewpurchase
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetspulledfrompoolnetnewpurchase(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : assetspulledfrompoolnetnewpurchase");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_asset_Routines")
					.setParameter("actionType", "assetspulledfrompoolpurchase").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : assetspulledfrompoolnetnewpurchase Dao ends" + resp);
		return resp;

	}

	// verificationstatus
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> verificationstatus(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : verificationstatus");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_asset_Routines")
					.setParameter("actionType", "verificationstatus").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : verificationstatus Dao ends" + resp);
		return resp;

	}

//////////////////////////////////////////////////////// Start Performance	

////////////////////////////////////////////////////////Start Performance	

	// topmeantimerepairapril
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> topmeantimerepairapril(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : topmeantimerepairapril");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_performance_Routines")
					.setParameter("actionType", "topmeantimerepairapril").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : topmeantimerepairapril Dao ends" + resp);
		return resp;

	}

//maintexpensessinceapril
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> maintexpensessinceapril(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : maintexpensessinceapril");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_performance_Routines")
					.setParameter("actionType", "maintexpensessinceapril").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : maintexpensessinceapril Dao ends" + resp);
		return resp;

	}

//maintexpensessinceapril
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> incidentresolutionresponsetime(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : incidentresolutionresponsetime");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_performance_Routines")
					.setParameter("actionType", "incidentresolutionresponsetime").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : incidentresolutionresponsetime Dao ends" + resp);
		return resp;

	}

//assetutilizationsinceapril
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetutilizationsinceapril(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : assetutilizationsinceapril");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_performance_Routines")
					.setParameter("actionType", "assetutilizationsinceapril").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : assetutilizationsinceapril Dao ends" + resp);
		return resp;

	}

//topmeantimefailuresinceapril
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> topmeantimefailuresinceapril(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : topmeantimefailuresinceapril");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_performance_Routines")
					.setParameter("actionType", "topmeantimefailuresinceapril").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : topmeantimefailuresinceapril Dao ends" + resp);
		return resp;

	}

//topassetlaborsinceapril
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> topassetlaborsinceapril(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : topassetlaborsinceapril");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_performance_Routines")
					.setParameter("actionType", "topassetlaborsinceapril").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : topassetlaborsinceapril Dao ends" + resp);
		return resp;

	}

//topassetdowntimesinceapril
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> topassetdowntimesinceapril(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : topassetdowntimesinceapril");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_performance_Routines")
					.setParameter("actionType", "topassetdowntimesinceapril").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : topassetdowntimesinceapril Dao ends" + resp);
		return resp;

	}

//////////////////////////////////////////////////////// End Performance

////////////////////////////////////////////////////////Start valueassets						
//valueassets
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> valueassets(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : valueassets");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values valueassets****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_valuation_Routines")
					.setParameter("actionType", "valueassets").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : valueassets Dao ends" + resp);
		return resp;

	}

//netassetvalue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> netassetvalue(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : netassetvalue");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_valuation_Routines")
					.setParameter("actionType", "netassetvalue").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : netassetvalue Dao ends" + resp);
		return resp;

	}

//netassetvalue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> netpurchasevalue(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : netpurchasevalue");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_valuation_Routines")
					.setParameter("actionType", "netpurchasevalue").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : netpurchasevalue Dao ends" + resp);
		return resp;

	}

//netscrapvalue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> netscrapvalue(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : netscrapvalue");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_valuation_Routines")
					.setParameter("actionType", "netscrapvalue").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : netscrapvalue Dao ends" + resp);
		return resp;

	}

//netscrapvalue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetdepriciationvalue(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : assetdepriciationvalue");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_valuation_Routines")
					.setParameter("actionType", "assetdepriciationvalue").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : assetdepriciationvalue Dao ends" + resp);
		return resp;

	}

//netscrapvalue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> scrapvalueMonthWise(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : scrapvalueMonthWise");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_valuation_Routines")
					.setParameter("actionType", "scrapvalueMonthWise").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : scrapvalueMonthWise Dao ends" + resp);
		return resp;

	}

//netscrapvalue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> netassetvaluesMonthtWise(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : netassetvaluesMonthtWise");

		
		 String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values  netassetvaluesMonthtWise****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_valuation_Routines")
					.setParameter("actionType", "netassetvaluesMonthwise").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : netassetvaluesMonthtWise Dao ends" + resp);
		return resp;

	}

//////////////////////////////////////////////////////// End valueassets

////////////////////////////////////////////////////////Start analytics_reports								
//netscrapvalue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> incompleteassets(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : incompleteassets");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "incompleteassets").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : incompleteassets Dao ends" + resp);
		return resp;

	}

//tableincompleteassets
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> tableincompleteassets(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : tableincompleteassets");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "tableincompleteassets").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : tableincompleteassets Dao ends" + resp);
		return resp;

	}

//eligibleforrefreshassets
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> eligibleforrefreshassets(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : eligibleforrefreshassets");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "eligibleforrefreshassets").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : eligibleforrefreshassets Dao ends" + resp);
		return resp;

	}

//eligibleforrefreshassets
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> tableeligibleforrefreshassets(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : tableeligibleforrefreshassets");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "tableeligibleforrefreshassets").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : tableeligibleforrefreshassets Dao ends" + resp);
		return resp;

	}

//activeassetsnotdiscovered
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> activeassetsnotdiscovered(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : activeassetsnotdiscovered");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "activeassetsnotdiscovered").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : activeassetsnotdiscovered Dao ends" + resp);
		return resp;

	}

//tableactiveassetsnotdiscovered
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> tableactiveassetsnotdiscovered(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : tableactiveassetsnotdiscovered");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "tableactiveassetsnotdiscovered").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : tableactiveassetsnotdiscovered Dao ends" + resp);
		return resp;

	}

//assetincidentfrequency
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetincidentfrequency(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : assetincidentfrequency");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "assetincidentfrequency").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : assetincidentfrequency Dao ends" + resp);
		return resp;

	}

//tableassetincidentfrequency
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> tableassetincidentfrequency(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : tableassetincidentfrequency");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "tableassetincidentfrequency").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : tableassetincidentfrequency Dao ends" + resp);
		return resp;

	}

//lifecycleoverview
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> lifecycleoverview(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : lifecycleoverview");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "lifecycleoverview").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : lifecycleoverview Dao ends" + resp);
		return resp;

	}

//lifecycleoverview
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> tablelifecycleoverview(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : tablelifecycleoverview");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "tablelifecycleoverview").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : tablelifecycleoverview Dao ends" + resp);
		return resp;

	}

//tableassetdisposalstatus
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> tableassetdisposalstatus(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : tablelifecycleoverview");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values tableassetdisposalstatus****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "tableassetdisposalstatus").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : tableassetdisposalstatus Dao ends" + resp);
		return resp;

	}

//tableendlifemethod
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> tableendlifemethod(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : tableendlifemethod");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "tableendlifemethod").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : tableendlifemethod Dao ends" + resp);
		return resp;

	}

//tableendlifemethod
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> tableeligiblerefreshassets(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : tableeligiblerefreshassets");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_analytics_reports_Routines")
					.setParameter("actionType", "tableeligiblerefreshassets").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : tableeligiblerefreshassets Dao ends" + resp);
		return resp;

	}

//////////////////////////////////////////////////////// End analytics_reports

	// tableendlifemethod
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> oprationalAssetCount(String orgName, String orgDivision, String fromDate, String toDate,
			String activity) {
		logger.info("Method : oprationalHeadData11");

		
		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_activity='" + activity + "',@p_toDate='" + toDate + "';";
			logger.info("values oprationalAssetCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "assetOprationCnt").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : oprationalHeadData11 Dao ends" + resp);
		return resp;

	}

	// oprationalAssetCount2
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> oprationalAssetCount2(String orgName, String orgDivision, String fromDate,
			String toDate, String activity) {
		logger.info("Method : oprationalAssetCount2");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDivision.trim();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_activity='" + activity + "',@p_toDate='" + toDate + "';";
			logger.info("values oprationalAssetCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "assetOprationCnt2").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : oprationalAssetCount2 Dao ends" + resp);
		return resp;

	}

	// tableendlifemethod
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllData(String orgName, String orgDivision, String id, String fromDate,
			String toDate) {
		logger.info("Method : getAllData11");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDivision.trim();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "', @p_id='" + id + "',@p_fromDate='"
					+ fromDate + "',@p_toDate='" + toDate + "';";
			logger.info("values*********************getAllData==========================*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "getAllRecordById").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllData11 Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrganization(String orgName) {
		logger.info("Method : getOrganization starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "getOrganization").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOrganization ends");
		return getCollectionList;
	}

	//

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDivision(String orgName) {
		logger.info("Method : getDivision starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "orgDivision").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : orgDivision ends");
		return getCollectionList;
	}

}
