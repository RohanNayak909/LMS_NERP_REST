package nirmalya.aatithya.restmodule.pharmacy.dao;

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
import nirmalya.aatithya.restmodule.util.StringUtil;

@Repository
public class IPOPharmacyDao {
    Logger logger = LoggerFactory.getLogger(IPOPharmacyDao.class);
    @Autowired
    EntityManager em;
    
    @Autowired
    ServerDao serverDao;
    
    @SuppressWarnings("unchecked")
	public List<DropDownModel> getPatientList(String org, String orgDiv) {
		logger.info("Method : getPatientList starts");
		List<DropDownModel> patientList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("Value is coming For dropDown============> " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ipo_pharamcy_routine")
					.setParameter("actionType", "getPatientList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				patientList.add(dropDownModel);
			}

			System.out.println(patientList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPatientList ends");
		System.out.println("Patient List =====>" + patientList);
		return patientList;
	}
    
    @SuppressWarnings("unchecked")
    public ResponseEntity<JsonResponse<Object>> savePharmacy(String pharmacy) {
        logger.info("Method : savePharmacy starts");
        JsonResponse<Object> resp = new JsonResponse<Object>();
        JSONObject data = new JSONObject(pharmacy);
        String id=data.getString("pharmacyId");
        System.out.println("profileModel+++++++++++++++++++++++"+pharmacy);
        System.out.println("id+++++++++++++++++++++++"+id);
        try {
            String value = "SET @pharmacy='" + pharmacy + "';";
            System.out.println(data.isNull(id) +"++++++++++++++");
            if (StringUtil.isNull(id)) {
                System.out.println("add");
                Object x = em.createNamedStoredProcedureQuery("ipo_pharamcy_routine")
                        .setParameter("actionType", "addPharmacy").setParameter("actionValue", value)
                        .getResultList();
                resp.setBody(x.toString())	;
                resp.setCode("Success");
                resp.setMessage("Pharmacy added Successfully");
            } else {
                System.out.println("modyfy");
                Object x = em.createNamedStoredProcedureQuery("ipo_pharamcy_routine")
                        .setParameter("actionType", "modifyPharmacy").setParameter("actionValue", value)
                        .getResultList();
                resp.setBody(x.toString())	;
                resp.setCode("Success");
                resp.setMessage("Pharmacy updated Successfully");
            }

        } catch (Exception e) {
            resp.setCode("Failed");
            resp.setMessage("Error During pharmacy add");
            e.printStackTrace();
            logger.error("savePharmacy: " + e.getMessage());
        }
        ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
                resp, HttpStatus.CREATED);

        logger.info("Method : savePharmacy ends");
        return response;
    }
    //
	/*
	 * @SuppressWarnings("unchecked") public JsonResponse<Object>
	 * pharmacyView(String org,String orgDiv) {
	 * logger.info("Method : pharmacyView Dao starts"); JsonResponse<Object> resp =
	 * new JsonResponse<Object>(); try { String value = "SET @p_org='" + org +
	 * "',@p_orgDivision='" + orgDiv + "';"; System.out.println("values=>" + value);
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("ipo_pharamcy_routine")
	 * .setParameter("actionType", "pharmacyView").setParameter("actionValue",
	 * value) .getResultList(); resp.setBody(x); resp.setCode("Success");
	 * resp.setMessage("Data Fetched Successfully."); } catch (Exception e) {
	 * e.printStackTrace(); try { String[] err = serverDao.errorProcedureCall(e);
	 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
	 * e1.printStackTrace(); } } logger.info("Method : pharmacyView Dao ends" +
	 * resp); return resp; }
	 */
    
    @SuppressWarnings("unchecked")
	public JsonResponse<Object> pharmacyView(String org,String orgDiv) {
		logger.info("Method : pharmacyView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDivision='" + orgDiv + "';";
            System.out.println("values=>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ipo_pharamcy_routine")
					.setParameter("actionType", "pharmacyView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : pharmacyView Dao ends");
		return resp;

	}
  //pdf
  	@SuppressWarnings("unchecked")
  	public JsonResponse<Object> pharmacyPdf(String id,String orgName, String orgDivision) {
  		logger.info("Method : pharmacyPdf Dao startsssss" + id );

  		JsonResponse<Object> resp = new JsonResponse<Object>();

  		try {
  			String value = "SET @p_pId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
  			logger.info("values******" + value);
  			List<Object[]> x = em.createNamedStoredProcedureQuery("ipo_pharamcy_routine")
  					.setParameter("actionType", "pharmacyPdf").setParameter("actionValue", value).getResultList();
  			resp.setBody(x.get(0));
  			resp.setCode("success");
  			resp.setMessage("Data fetched successfully");
  		} catch (Exception e) {
  			resp.setCode("failed");
  			resp.setMessage(e.getMessage());
  			e.printStackTrace();
  		}
  		logger.info("resp******" + resp);
  		logger.info("Method : pharmacyPdf Dao ends");
  		return resp;

  	}
}
