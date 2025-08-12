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

import nirmalya.aatithya.restmodule.api.model.RestCrmClassifiedBillingModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateCRMClassifiedBillingParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
@Repository
public class RestCrmClassifiedBillingDao {
	Logger logger = LoggerFactory.getLogger(RestCrmClassifiedBillingDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

 
    public ResponseEntity<JsonResponse<Object>> addClassifiedBillApi(RestCrmClassifiedBillingModel billModel) {
        logger.info("Method : addClassifiedBillApi Dao starts");
logger.info("data===="+billModel);
        JsonResponse<Object> jsonResponse = new JsonResponse<Object>();
	 
        try {
            String values = GenerateCRMClassifiedBillingParam.getBillingParam(billModel);
            logger.info(values);

            if (billModel.getBillId() == null || billModel.getBillId() == ""
                    || billModel.getBillId().equals("") || billModel.getBillId().equals(null)) {
                em.createNamedStoredProcedureQuery("crm_classified_Billing")
                        .setParameter("actionType", "addClassifiedBill").setParameter("actionValue", values)
                        .execute();
                jsonResponse.setCode("success");
                jsonResponse.setMessage("Data saved successfully");

            } else {
                em.createNamedStoredProcedureQuery("crm_classified_Billing")
                        .setParameter("actionType", "modifyClassifiedBill").setParameter("actionValue", values)
                        .execute();
                jsonResponse.setCode("success");
                jsonResponse.setMessage("Data modified successfully");

            }
        } catch

        (Exception e) {
            try {
                String[] err = serverDao.errorProcedureCall(e);
                jsonResponse.setCode("failed");
                jsonResponse.setMessage("Something went wrong");

            } catch (Exception e1) {
                e1.printStackTrace();
                jsonResponse.setCode("failed");
                jsonResponse.setMessage("Something went wrong");
            }
        }
        ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
                HttpStatus.OK);
        logger.info("Method : addClassifiedBillApi Dao ends");
        return response;
    }
	// view bill Details
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmClassifiedBillingModel>> viewClassifiedBillApi(String createdBy,String organization, String orgDivision,String fromDate,String toDate) {
		logger.info("Method : viewClassifiedBillApi Dao starts");

		List<RestCrmClassifiedBillingModel> viewMaster = new ArrayList<RestCrmClassifiedBillingModel>();
		JsonResponse<List<RestCrmClassifiedBillingModel>> resp = new JsonResponse<List<RestCrmClassifiedBillingModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) +"',@p_toDate='" + DateFormatter.getStringDate(toDate) +"';";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_classified_Billing")
					.setParameter("actionType", "viewClassifiedBill").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[2] != null) {
					date  =DateFormatter.returnStringDate(m[2]);
				}
 
				RestCrmClassifiedBillingModel restStudentModel = new RestCrmClassifiedBillingModel(m[0], m[1],date, m[3], m[4], m[5], null);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if(viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewClassifiedBillApi Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}
	// view bill Search Details
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmClassifiedBillingModel>> viewClassifiedBillSearchApi(String createdBy,String organization, String orgDivision,String fromDate,String toDate,String salesTeam) {
		logger.info("Method : viewClassifiedBillSearchApi Dao starts");
		
		List<RestCrmClassifiedBillingModel> viewMaster = new ArrayList<RestCrmClassifiedBillingModel>();
		JsonResponse<List<RestCrmClassifiedBillingModel>> resp = new JsonResponse<List<RestCrmClassifiedBillingModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) +"',@p_toDate='" + DateFormatter.getStringDate(toDate) +"',@p_salesTeam='" + salesTeam + "';";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_classified_Billing")
					.setParameter("actionType", "viewClassifiedBillSearch").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				Object date = null;
				if (m[2] != null) {
					date  =DateFormatter.returnStringDate(m[2]);
				}
				
				RestCrmClassifiedBillingModel restStudentModel = new RestCrmClassifiedBillingModel(m[0], m[1],date, m[3], m[4], m[5], null);
				viewMaster.add(restStudentModel);
				
				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if(viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewClassifiedBillSearchApi Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}
}
