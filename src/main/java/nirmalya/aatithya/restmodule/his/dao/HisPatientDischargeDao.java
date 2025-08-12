package nirmalya.aatithya.restmodule.his.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class HisPatientDischargeDao {
	Logger logger = LoggerFactory.getLogger(HisPatientDischargeDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDischargeTypeList(String org, String orgDiv) {
		logger.info("Method : getDischargeTypeList starts");

		List<DropDownModel> dischargeTypeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv +"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_discharge_routines")
					.setParameter("actionType", "getDischargeTypeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dischargeTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDischargeTypeList ends");
		return dischargeTypeList;
	}

	// GET THE PATIENT DETAILS FOR DISCHARGE
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPatientDetails(String orgName, String orgDiv, String userId, String bookingId) {
		logger.info("Method : getPatientDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId
					+ "',@p_bookingId='" + bookingId + "';";
			System.out.println("getPatientDetails========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_discharge_routines")
					.setParameter("actionType", "getPatientDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getPatientDetails Dao ends" + resp);
		return resp;

	}

	// ADD DISCHARGE DATA
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addPatientDischargeData(Map<String, Object> dischargeJsonData) {
		logger.info("Method : addPatientDischargeData starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			String allDischargeData = objectMapper.writeValueAsString(dischargeJsonData);
			System.out.println("All Discharge Data---------->" + dischargeJsonData);
			String dischargeId = (String) dischargeJsonData.get("dischargeId");
			System.out.println("Discharge IId---------->" + dischargeId);

			String actionType;
			String value;

			actionType = (dischargeId == null || dischargeId.isEmpty()) ? "addDischargeData" : "modifyDischargeData";

			value = "SET @dischargeJsonData='" + allDischargeData + "';";

			logger.info("value" + value);

			Object result = em.createNamedStoredProcedureQuery("his_discharge_routines")
					.setParameter("actionType", actionType).setParameter("actionValue", value).execute();

			resp.setBody(result.toString());
			resp.setCode("success");
			resp.setMessage(
					actionType.equals("addDischargeData") ? "Discharge Data added successfully." : "Discharge Data updated successfully.");
			logger.info(actionType.equals("addDischargeData") ? "Adding new Discharge Data."
					: "Updating Discharge for Discharge Id: " + dischargeId);

		} catch (Exception e) {
			resp.setCode("Failed");
			resp.setMessage("Error during Add Discharge Data operation.");
			logger.error("Error in addPatientDischargeData: ", e);
		}

		logger.info("Method : addPatientDischargeData ends");
		return resp;
	}
	
	// GET THE PATIENT DETAILS FOR DISCHARGE PDF
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getPatientDetailsForPdf(String orgName, String orgDiv, String userId, String bookingId) {
			logger.info("Method : getPatientDetailsForPdf Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId
						+ "',@p_bookingId='" + bookingId + "';";
				System.out.println("getPatientDetailsForPdf========>" + value);
				logger.info("Alert Data Value" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("his_discharge_routines")
						.setParameter("actionType", "getPatientDetailsForPdf").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getPatientDetailsForPdf Dao ends" + resp);
			return resp;

		}
		// DELETE DISCHARGE DATA
		public JsonResponse<Object> deleteDischargeData(String bookingId, String orgName, String orgDiv) {
			logger.info("Method : deleteDischargeData Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {

				String value = "SET @p_bookingId='" + bookingId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv
						+ "';";
				System.out.println("deleteMeetingCalendar========>" + value);

				Object x = em.createNamedStoredProcedureQuery("his_discharge_routines")
						.setParameter("actionType", "delete-discharge-data").setParameter("actionValue", value)
						.getSingleResult();
				System.out.println("value of x ------->>>>> " + x.toString());
				if (Integer.parseInt(x.toString()) > 0) {
					resp.setCode("success");
					resp.setMessage("Discharge Data Deleted successfully");
				}

			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : deleteDischargeData Dao ends" + resp);
			return resp;
		}
}
