package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateWagePlusParams;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.EmpMonthlyWagePlusRestModel;

@Repository
public class EmpMonthlyWagePlusDao {
	Logger logger = LoggerFactory.getLogger(EmpMonthlyWagePlusDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;


//addWagePlus
	public ResponseEntity<JsonResponse<Object>> addWagePlus(EmpMonthlyWagePlusRestModel empMonthlyWagePlusRestModel) {
	    logger.info("Method : addWagePlus starts--"+empMonthlyWagePlusRestModel);

	    JsonResponse<Object> resp = new JsonResponse<>();

	    try {
	        String values = GenerateWagePlusParams.getWagePlusMasterParam(empMonthlyWagePlusRestModel);
	        logger.info(values);

	        if (empMonthlyWagePlusRestModel.getWagePlusId() == null || empMonthlyWagePlusRestModel.getWagePlusId().isEmpty()) {
	            em.createNamedStoredProcedureQuery("monthlyWagePlusRoutiness")
	                    .setParameter("actionType", "addWagePlus")
	                    .setParameter("actionValue", values)
	                    .execute();
	        } else {
	            em.createNamedStoredProcedureQuery("monthlyWagePlusRoutiness")
	                    .setParameter("actionType", "modifyWagePlus")
	                    .setParameter("actionValue", values)
	                    .execute();
	        }

	    } catch (DataIntegrityViolationException e) {
	        // Handle the specific exception for duplicate key violation
	        resp.setMessage("Error:This TDS record already exists.");
	        return new ResponseEntity<>(resp, HttpStatus.CONFLICT);
	    } catch (Exception e) {
	        // Handle other exceptions
	        resp.setMessage("Error: An unexpected error occurred.");
	        return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    resp.setMessage("Data Saved successfully.");
	    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

	    logger.info("Method : addWagePlus ends" + response);
	    return response;
	}

	//viewWageYearWise
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewWageYearWise(String month,String year, String orgName, String orgDivision) {
		logger.info("Method : viewWageYearWise Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "',@p_year='" + year+ "',@p_month='" + month + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("monthlyWagePlusRoutiness")
					.setParameter("actionType", "viewWageYearWise").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewWageYearWise Dao ends");
		return resp;
	}

//approveWagePlusApply
	public JsonResponse<Object> approveWagePlusApply(String approveId,String orgName, String orgDivision,String userId) {
		logger.info("Method : approveWagePlusApply starts");

		String litem="";
		String[] userIds = approveId.split(",");
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
 
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_wageplusId='" + litem + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "',@p_userId='" + userId+ "';";
			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("monthlyWagePlusRoutiness").setParameter("actionType", "approveWagePlusApply")
					.setParameter("actionValue", value).execute();
 
			resp.setCode("success");
			resp.setMessage("Data added successfully");
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
				// resp.setMessage(err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				logger.error("approveRequisitionapply: " + e.getMessage());
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			e.printStackTrace();
		}
		logger.info("resp===" + resp);
		logger.info("Method : approveWagePlusApply ends");
		return resp;
	}
//deleteWagePlus
	public JsonResponse<Object> deleteWagePlus(String dltId,String orgName, String orgDivision,String userId) {
		logger.info("Method : deleteWagePlus starts");

		String litem="";
		String[] userIds = dltId.split(",");
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_wageplusId='" + litem + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "',@p_userId='" + userId+ "';";
			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("monthlyWagePlusRoutiness").setParameter("actionType", "deleteWagePlus")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Data added successfully");
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
				// resp.setMessage(err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				logger.error("approveRequisitionapply: " + e.getMessage());
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			e.printStackTrace();
		}
		logger.info("Method : deleteWagePlus ends");
		return resp;
	}
	//viewWagePlus
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewWagePlus(String orgName, String orgDivision) {
		logger.info("Method : viewWagePlus Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("monthlyWagePlusRoutiness")
					.setParameter("actionType", "viewWagePlus").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewWagePlus Dao ends"+resp);
		return resp;

	}
	
	/* Function for getStartDayForAttendance */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getComponentForWage(String organization,String orgDivision) {
		logger.info("Method : getComponentForWage starts");

		List<DropDownModel> bandlist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("monthlyWagePlusRoutiness")
					.setParameter("actionType", "getComponentForWage").setParameter("actionValue",value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bandlist.add(dropDownModel);
			}

		} catch (Exception e) {

			logger.error("getStartDayForAttendance: " + e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getComponentForWage ends");
		return bandlist;
	}

}
