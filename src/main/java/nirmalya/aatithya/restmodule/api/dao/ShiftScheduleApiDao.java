package nirmalya.aatithya.restmodule.api.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.model.ShiftScheduleApiModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
 
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class ShiftScheduleApiDao {

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	Logger logger = LoggerFactory.getLogger(ShiftScheduleApiDao.class);
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ShiftScheduleApiModel>>> getShiftMonthList(String empId,String organization,String orgDivision) {
		logger.info("Method : getShiftMonthList Dao starts");

		List<ShiftScheduleApiModel> monthlist = new ArrayList<ShiftScheduleApiModel>();
		JsonResponse<List<ShiftScheduleApiModel>> jsonResponse = new JsonResponse<List<ShiftScheduleApiModel>>();
		try {
			String value = "SET @p_userName='" + empId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("shiftScheduleApiRoutine")
					.setParameter("actionType", "getShiftMonthList").setParameter("actionValue",value).getResultList();
				if (x.size() > 0) {
					for (Object[] m : x) {
						Object fromDate = null;
						if (m[1] != null) {
							fromDate  = m[1].toString();
						}
						Object toDate = null;
						if (m[2] != null) {
							toDate  =m[2].toString();
						}
						ShiftScheduleApiModel shift = new ShiftScheduleApiModel(m[0], fromDate,toDate,m[3],m[4].toString());
						monthlist.add(shift);
					}
					jsonResponse.setBody(monthlist);
					jsonResponse.setCode("success");
					jsonResponse.setMessage("Data Fetched Successfully");
				}else {
					jsonResponse.setBody(monthlist);
					jsonResponse.setCode("success");
					jsonResponse.setMessage("No Data Found");
				}
			
			
		} catch (Exception e) {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<List<ShiftScheduleApiModel>>> response = new ResponseEntity<JsonResponse<List<ShiftScheduleApiModel>>>(
				jsonResponse, HttpStatus.OK);
		logger.info("Method : getShiftMonthList Dao ends");
logger.info("getShiftMonthList response=="+response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>>getEmpShiftDetails(String empId,String fromDate,String toDate,String organization,String orgDivision ) {
		logger.info("Method : getEmpShiftDetails Dao starts");

		List<DropDownModel> shiftlist = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> jsonResponse = new JsonResponse<List<DropDownModel>>();
		
		
		try {
			String value = "SET @p_userName='" + empId + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate+ "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("shiftScheduleApiRoutine")
					.setParameter("actionType", "getEmpShiftDetails").setParameter("actionValue",value).getResultList();
			if (x.size() > 0) {
				for (Object[] m : x) {
					Object shiftDate = null;
					if (m[0] != null) {
						shiftDate  =DateFormatter.returnStringDate(m[0]);
					}
					DropDownModel shift = new DropDownModel(shiftDate, m[1],m[2]);
					shiftlist.add(shift);
				}
				jsonResponse.setBody(shiftlist);
				jsonResponse.setCode("success");
				jsonResponse.setMessage("Data Fetched Successfully");
			}else {
				jsonResponse.setBody(shiftlist);
				jsonResponse.setCode("success");
				jsonResponse.setMessage("No Data Found");
			}
		} catch (Exception e) {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				jsonResponse, HttpStatus.OK);
		logger.info("Method : getEmpShiftDetails Dao ends");

		return response;
	}
}
