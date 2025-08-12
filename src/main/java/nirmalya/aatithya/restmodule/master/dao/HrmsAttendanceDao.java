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

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateHrmsAttendanceParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateTravelClaimOtherParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.HrmInsuranceDao;
import nirmalya.aatithya.restmodule.master.model.RestHrmsAttendanceModel;

@Repository
public class HrmsAttendanceDao {
	Logger logger = LoggerFactory.getLogger(HrmsAttendanceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAttendance(String orgName, String orgDivision, String fromDate, String toDate,
			String empid, String shift) {
		logger.info("Method : viewAttendance Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "'," + "@p_fromDate='"
					+ DateFormatter.getStringDate(fromDate) + "'" + "," + "@p_toDate='"
					+ DateFormatter.getStringDate(toDate) + "',@p_empId='" + empid + "',@p_shift='" + shift + "';";
			System.out.println("value for attendance view=================> " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_attendance_routines")
					.setParameter("actionType", "viewAttendance").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}

		logger.info("Method : viewAttendance Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> emplist() {

		logger.info("Method :emplist starts");

		List<DropDownModel> emplist = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_attendance_routines")
					.setParameter("actionType", "emplist").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				emplist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : emplist ends" + emplist);

		return emplist;
	}

	// add

	public ResponseEntity<JsonResponse<Object>> addAttendance(RestHrmsAttendanceModel data) {
		logger.info("Method : Rest addAttendance Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String dateTime = DateFormatter.getStringDate(data.getDate()) + " " + data.getTime();
				String values = "SET @p_empId = '" + data.getEmpId() + "', @p_dateTime='" + dateTime
						+ "', @p_createdBy='" + data.getCreatedBy() + "', @p_org='" + data.getOrganization()
						+ "', @p_orgDiv='" + data.getOrgDivision() + "';";

				if (data.getType().equals("PI")) {
					em.createNamedStoredProcedureQuery("hrms_attendance_routines").setParameter("actionType", "punchIn")
							.setParameter("actionValue", values).execute();

					resp.setCode("success");
					resp.setMessage("Punched-in Successfully");
				} else {
					em.createNamedStoredProcedureQuery("hrms_attendance_routines")
							.setParameter("actionType", "punchOut").setParameter("actionValue", values).execute();

					resp.setCode("success");
					resp.setMessage("Punched-out Successfully");
				}

			} catch (Exception e) {
				logger.error("addAttendance: " + e.getMessage());
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

		logger.info("Method : Rest addAttendance Dao ends");
		return response;
	}

}
