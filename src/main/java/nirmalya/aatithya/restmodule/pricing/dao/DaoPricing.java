package nirmalya.aatithya.restmodule.pricing.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONObject;
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
public class DaoPricing {
	Logger logger = LoggerFactory.getLogger(DaoPricing.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// get Category
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getActivityList(String org, String orgDiv) {
		logger.info("Method : getActivityList starts");

		List<DropDownModel> modeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
					.setParameter("actionType", "getActivityList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				modeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getActivityList ends");
		return modeList;
	}

	// Package Configuration Dao Start Here --->>>>
	// Save Package Configuration Data ------------>
	public ResponseEntity<JsonResponse<Object>> savePackageConfig(String packageData, String org, String orgDiv) {
		logger.info("method: savePackageConfig Starts");

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			JSONObject jsonObj = new JSONObject(packageData);

			String packageId = jsonObj.optString("packageId");
			String packageName = jsonObj.optString("packageName");
			String service = jsonObj.optString("service");
			String function = jsonObj.optString("function");
			String startDate = jsonObj.optString("startDate");
			String endDate = jsonObj.optString("endDate");
			String desc = jsonObj.optString("desc");

			String value = "SET " + "@packageId='" + packageId + "', " + "@packageName='" + packageName + "', "
					+ "@service='" + service + "', " + "@function='" + function + "', " + "@startDate='" + startDate
					+ "', " + "@endDate='" + endDate + "'," + "@org='" + org + "'," + "@orgDiv='" + orgDiv + "', "
					+ "@desc='" + desc + "';";

			System.out.println("value:::::::::::::" + value);

			if (packageId != null && !packageId.isEmpty()) {
				System.out.println("calling modifyApplication");
				em.createNamedStoredProcedureQuery("hotel_org_packageConfiguration_routine")
						.setParameter("actionType", "modifyPackageConfigData").setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			} else {
				System.out.println("calling saveApplicationDetails");
				em.createNamedStoredProcedureQuery("hotel_org_packageConfiguration_routine")
						.setParameter("actionType", "savePackageConfigData").setParameter("actionValue", value)
						.execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in savePackageConfig: ", e);
			resp.setMessage("Error savePackageConfig!");
			resp.setCode("Error");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: savePackageConfig Ends");
		return response;
	}

	// View PackageData
	// --------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPackageData(String orgName, String orgDivision) {
		logger.info("Method : viewPackageData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

			logger.info("values for Application view====================" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_org_packageConfiguration_routine")
					.setParameter("actionType", "viewPackageData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPackageData Dao ends" + resp);
		return resp;
	}
	
	//Delete Packageing Data --------------------------->>>>>>>>>
	// Delete Application-->>>>>
		public ResponseEntity<JsonResponse<Object>> deletePackageData(String id) {
			logger.info("Method : deletePackageData starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {

				String value = "SET @packageId='" + id + "';";

				System.out.println("value:::::" + value);

				em.createNamedStoredProcedureQuery("hotel_org_packageConfiguration_routine")
						.setParameter("actionType", "deletePackageData").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Deleted Successfully");
			} catch (Exception e) {

				e.printStackTrace();
			}

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);

			logger.info("Method : deletePackageData ends");
			return response;
		}
}
