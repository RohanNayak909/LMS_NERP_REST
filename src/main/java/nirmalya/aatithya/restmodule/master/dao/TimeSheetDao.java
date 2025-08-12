package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateTimeSheetParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.TimeSheetAllProjectDetailsModel;
import nirmalya.aatithya.restmodule.master.model.TimeSheetModel;
import nirmalya.aatithya.restmodule.master.model.TimeSheetProjectDetailsModel;
/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class TimeSheetDao {
	Logger logger = LoggerFactory.getLogger(TimeSheetDao.class);
	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getWeekDays(List<String> id) {
		logger.info("Method : getWeekDays starts");

		List<DropDownModel> weekList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_MONTH='" + id.get(0).split("\\[")[1] + "', @P_year='" + id.get(1).split("\\]")[0] + "';";
		logger.info(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("masterTimeSheetRoutines")
					.setParameter("actionType", "getWeekList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				weekList.add(dropDownModel);
			}
			resp.setBody(weekList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getWeekDays ends");
	logger.info("weeklist"+response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<TimeSheetProjectDetailsModel>>> getProjectDetails(List<String> id) {
		logger.info("Method : getProjectDetails starts");

		List<TimeSheetProjectDetailsModel> weekList = new ArrayList<TimeSheetProjectDetailsModel>();
		JsonResponse<List<TimeSheetProjectDetailsModel>> resp = new JsonResponse<List<TimeSheetProjectDetailsModel>>();

		//String value = "SET @P_Emp='" + id.get(0) + "';";
		String value = "SET @P_Emp='" + id.get(0).split("\\[")[1] + "', @P_year='" + id.get(1)+ "', @P_month='" + id.get(2) + "', @P_week='" + id.get(3).split("\\]")[0]+ "';";
		logger.info(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("masterTimeSheetRoutines")
					.setParameter("actionType", "getProjectList").setParameter("actionValue",value).getResultList();
			for (Object[] m : x) {
				TimeSheetProjectDetailsModel timeSheetProjectDetailsModel = new TimeSheetProjectDetailsModel(m[0],m[1],m[2],m[3].toString(),m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14].toString());
				weekList.add(timeSheetProjectDetailsModel);
			}
			resp.setBody(weekList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<TimeSheetProjectDetailsModel>>> response = new ResponseEntity<JsonResponse<List<TimeSheetProjectDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProjectDetails ends");
		logger.info("response"+response);
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> saveTimeSheet(List<TimeSheetModel> timeSheetModel) {
		logger.info("Method : saveTimeSheet starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (TimeSheetModel l : timeSheetModel) {

			/*if (l.getEntryDate() == null || l.getEntryDate() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Entry Date Required");
				break;
			} else if (l.getEntryTime() == null || l.getEntryTime() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Entry Time Required");
				break;
			} else if (l.getStore() == null || l.getStore() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Store Name Required");
				break;
			} else if (l.getItemCode() == null || l.getItemCode() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Item Name Required");
				break;
			} else if (l.getClientNetQty() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Client Net Quantity Required");
				break;
			} else if (l.getActualNetQty() == null) {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Actual Net Quantity Required");
				break;
			}*/
		}
		if (Boolean.TRUE.equals(validity)) {
			try {
				String values = GenerateTimeSheetParameter.timesheetParam(timeSheetModel);

				if (timeSheetModel.get(0).getTimesheetId() != "0" && timeSheetModel.get(0).getTimesheetId() != "" && timeSheetModel.get(0).getTimesheetId() != null) {
					em.createNamedStoredProcedureQuery("masterTimeSheetRoutines")
							.setParameter("actionType", "modifyTimeSheet").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("masterTimeSheetRoutines")
							.setParameter("actionType", "addTimeSheet").setParameter("actionValue", values)
							.execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveTimeSheet ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<TimeSheetAllProjectDetailsModel>>> getProjectTotalHourDetails(String id,String Year) {
		logger.info("Method : getProjectDetails starts");

		List<TimeSheetAllProjectDetailsModel> weekList = new ArrayList<TimeSheetAllProjectDetailsModel>();
		JsonResponse<List<TimeSheetAllProjectDetailsModel>> resp = new JsonResponse<List<TimeSheetAllProjectDetailsModel>>();

		String value = "SET @P_Emp='" + id + "', @P_year='" + Year + "';";
		logger.info(value);
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("masterTimeSheetRoutines")
					.setParameter("actionType", "getProjectTotList").setParameter("actionValue",value).getResultList();
			Object jan = "0";
			Object feb = "0";
			Object mar = "0";
			Object apr = "0";
			Object may = "0";
			Object jun = "0";
			Object jul = "0";
			Object aug = "0";
			Object sep = "0";
			Object oct = "0";
			Object nov = "0";
			Object dec = "0";
			Object tot = "0";
			for (Object[] m : x) {
				if (m[0] != null) {
				
					jan = m[0].toString().split("\\.")[0];
				}
				if (m[1] != null) {
					
					feb = m[1].toString().split("\\.")[0];
				}
				if (m[2] != null) {
					
					mar = m[2].toString().split("\\.")[0];
				}
				if (m[3] != null) {
					
					apr = m[3].toString().split("\\.")[0];
				}
				if (m[4] != null) {
					
					may = m[4].toString().split("\\.")[0];
				}
				if (m[5] != null) {
					
					jun = m[5].toString().split("\\.")[0];
				}
				if (m[6] != null) {
					
					jul = m[6].toString().split("\\.")[0];
				}
				if (m[7] != null) {
					
					aug = m[7].toString().split("\\.")[0];
				}
				if (m[8] != null) {
					
					sep = m[8].toString().split("\\.")[0];
				}
				if (m[9] != null) {
					
					oct = m[9].toString().split("\\.")[0];
				}
				if (m[10] != null) {
					
					nov = m[10].toString().split("\\.")[0];
				}
				if (m[11] != null) {
					
					dec = m[11].toString().split("\\.")[0];
				}
				if (m[12] != null) {
					
					tot = m[12].toString().split("\\.")[0];
				}
				TimeSheetAllProjectDetailsModel timeSheetAllProjectDetailsModel = new TimeSheetAllProjectDetailsModel(jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec,tot,null,null,null);
				weekList.add(timeSheetAllProjectDetailsModel);
			}
			resp.setBody(weekList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<TimeSheetAllProjectDetailsModel>>> response = new ResponseEntity<JsonResponse<List<TimeSheetAllProjectDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProjectDetails ends");
		
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<TimeSheetAllProjectDetailsModel>>> getEmpDetails() {
		logger.info("Method : getEmpDetails starts");

		List<TimeSheetAllProjectDetailsModel> dataList = new ArrayList<TimeSheetAllProjectDetailsModel>();
		JsonResponse<List<TimeSheetAllProjectDetailsModel>> resp = new JsonResponse<List<TimeSheetAllProjectDetailsModel>>();

	
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("masterTimeSheetRoutines")
					.setParameter("actionType", "getEmpList").setParameter("actionValue","").getResultList();
			for (Object[] m : x) {
	
				TimeSheetAllProjectDetailsModel timeSheetAllProjectDetailsModel = new TimeSheetAllProjectDetailsModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],null,m[12],m[13],m[14]);
				dataList.add(timeSheetAllProjectDetailsModel);
			}
			resp.setBody(dataList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<TimeSheetAllProjectDetailsModel>>> response = new ResponseEntity<JsonResponse<List<TimeSheetAllProjectDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getEmpDetails ends");
		
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteTimeSheetEmp(String id,
			String createdBy) {
		logger.info("Method : deleteTimeSheet starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @P_ModifiedBy='" + createdBy + "',@P_Id='" + id + "';";

				em.createNamedStoredProcedureQuery("masterTimeSheetRoutines").setParameter("actionType", "deleteTimeSheet")
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

		logger.info("Method : deleteTimeSheet ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteTimeSheetProDetails(String empId,String year,String monthdata,String week,
			String createdBy) {
		logger.info("Method : deleteTimeSheetProDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @P_ModifiedBy='" + createdBy + "',@P_Id='" + empId + "',@P_year='" + year + "',@P_monthdata='" + monthdata + "',@P_week='" + week + "';";

				em.createNamedStoredProcedureQuery("masterTimeSheetRoutines").setParameter("actionType", "deleteTimeSheetProDetails")
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

		logger.info("Method : deleteTimeSheetProDetails ends");
		return response;
	}
}
