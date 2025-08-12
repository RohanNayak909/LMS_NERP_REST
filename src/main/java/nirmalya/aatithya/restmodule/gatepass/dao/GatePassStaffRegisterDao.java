package nirmalya.aatithya.restmodule.gatepass.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.gatePass.GenerateGatePassStaffRegistrationParam;
import nirmalya.aatithya.restmodule.gatepass.model.GatePassStaffRegisterModel;

@Repository
public class GatePassStaffRegisterDao {

	Logger logger = LoggerFactory.getLogger(GatePassStaffRegisterDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	@Autowired
	EnvironmentVaribles env;
	
	//getStaffDeatils
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getStaffDeatils(String organization, String orgDivision, String employeeId,String date,String time) {
		logger.info("Method : getStaffDeatils starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		String value = "SET @p_org='" + organization+ "',@p_orgDiv='" + orgDivision + "',@p_empId='" +employeeId+ "',@p_date='" +DateFormatter.getStringDate(date)+ "',@p_time='" +time+"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatepassStaffregRoutines")
					.setParameter("actionType", "getEmployeeDetails").setParameter("actionValue", value).getResultList();
			if (x.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
				resp.setBody("");
			} else {
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
				resp.setBody(x.get(0));
				JSONObject jsonObj = new JSONObject(resp.getBody().toString());
				String img=jsonObj.getString("empImage");
				String prfileImg = null;
				if (img != null && img != "" && img != " " && !img.toString().equals(" ")
						&& !img.toString().equals(null) && !img.toString().equals("")) {
					prfileImg = env.getMobileView() + "document/employee/" + img.toString();
				} else {
					prfileImg = "";
				}
				jsonObj.put("empImage",prfileImg);
				resp.setBody(jsonObj.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : getStaffDetails ends");
		return resp;
	}
	
	//postStaffPunchInOutDetails
	public JsonResponse<Object> postStaffPunchInOutDetails(GatePassStaffRegisterModel regModel) {
		logger.info("Method : postStaffPunchInOutDetails starts");
		logger.info(regModel.toString());
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (regModel.getEmpId() == null || regModel.getEmpId() == "") {
			resp.setMessage("Employee Id Required");
			validity = false;
		}
		if (validity){
			String values = GenerateGatePassStaffRegistrationParam.getAddPunchInOutParam(regModel);
			logger.info(values);
			try {
				if(regModel.getPunchType().contentEquals("punchin") || regModel.getPunchType()=="punchin") {
					em.createNamedStoredProcedureQuery("gatepassStaffregRoutines").setParameter("actionType", "staffPunchIn")
					.setParameter("actionValue", values).execute();
					resp.setCode("success");
					resp.setMessage("PunchIn successfully");
				}else {
					em.createNamedStoredProcedureQuery("gatepassStaffregRoutines").setParameter("actionType", "staffPunchOut")
					.setParameter("actionValue", values).execute();
					resp.setCode("success");
					resp.setMessage("PunchOut successfully");
				}
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		}
		logger.info("Method : postStaffPunchInOutDetails ends");
		return resp;
	
	}		
}