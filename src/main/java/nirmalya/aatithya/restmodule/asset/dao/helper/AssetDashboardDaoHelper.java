package nirmalya.aatithya.restmodule.asset.dao.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.asset.dao.AssetDashboardDao;
import nirmalya.aatithya.restmodule.asset.model.DashboardData;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Component
public class AssetDashboardDaoHelper {
	Logger logger = LoggerFactory.getLogger(AssetDashboardDao.class);

	/**
	 * @param dataMap
	 * @param categoryArray
	 * @param responseMap
	 */
	public void setDataForGraph(Map<String, List<Integer>> dataMap, String[] categoryArray,
			Map<String, Object> responseMap) {
		responseMap.put("categories", categoryArray);
		List<Map<String, Object>> seriesList = new ArrayList<>();
		for (Map.Entry<String, List<Integer>> entry : dataMap.entrySet()) {
			Map<String, Object> series = new HashMap<>();
			series.put("name", entry.getKey());
			series.put("data", entry.getValue());
			seriesList.add(series);
		}
		responseMap.put("series", seriesList);
		logger.info("responseMap map : {}", responseMap);
	}

	public void assetEndOfLifeFilterCategory(int count, boolean isCategoryPresent, JSONArray jsonArray,
			String categoryNameToCheck, Map<String, List<Integer>> dataMap, String categoryJsonField) {
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject item = jsonArray.getJSONObject(i);
			String categoryName = item.getString("categoryName");
			if (categoryName.equals(categoryNameToCheck)) {
				isCategoryPresent = true;
				count = Integer.parseInt(item.getString("count"));
				break;
			}
		}
		if (isCategoryPresent) {
			dataMap.get(categoryJsonField).add(count);
		} else {
			dataMap.get(categoryJsonField).add(0);
		}
	}

	public List<DashboardData> extractDashboardData(JSONArray dashboardDataArray) throws JSONException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<DashboardData> dashboardDataList = new ArrayList<>();
		for (int i = 0; i < dashboardDataArray.length(); i++) {
			JSONObject dashboardDataJson = dashboardDataArray.getJSONObject(i);
			DashboardData dashboardData = objectMapper.readValue(dashboardDataJson.toString(), DashboardData.class);
			dashboardDataList.add(dashboardData);
		}
		return dashboardDataList;
	}

	public void processDashboardData(List<DashboardData> dashboardDataList, String[] monthArray,
			Set<String> categorySet, Map<String, List<Double>> dataMap) {
		for (String set : monthArray) {
			for (String category : categorySet) {
				List<Double> values = dataMap.computeIfAbsent(category, k -> new ArrayList<>());
				double sumOfPrice = dashboardDataList.stream()
						.filter(data -> StringUtils.equals(set.trim(), data.getMonth())
								&& StringUtils.equals(category, data.getCategory()))
						.mapToDouble(DashboardData::getSumOfPrice).findFirst().orElse(0.0);
				values.add(sumOfPrice);
			}
		}
	}

	public Map<String, Object> buildResponseMap(String[] monthArray, Map<String, List<Double>> dataMap) {
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("categories", monthArray);
		List<Map<String, Object>> seriesList = new ArrayList<>();
		for (Map.Entry<String, List<Double>> entry : dataMap.entrySet()) {
			Map<String, Object> series = new HashMap<>();
			series.put("name", entry.getKey());
			series.put("data", entry.getValue());
			seriesList.add(series);
		}
		responseMap.put("series", seriesList);
		logger.info("responseMap map : {}", responseMap);
		return responseMap;
	}

	public void handleException(JsonResponse<Object> resp, Exception e) {
		e.printStackTrace();
		resp.setCode("failed");
		resp.setMessage(e.getMessage());
	}
}
