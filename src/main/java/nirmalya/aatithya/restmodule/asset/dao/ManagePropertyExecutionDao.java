package nirmalya.aatithya.restmodule.asset.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@Repository
public class ManagePropertyExecutionDao {

	Logger logger = LoggerFactory.getLogger(ManagePropertyExecutionDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	private EnvironmentVaribles env;


	@SuppressWarnings("unchecked")
	public JsonResponse<Object> showTotalAsset(String type,String cat,String scat, String orgName, String orgDivision) {
		logger.info("Method : showTotalAsset Dao starts");
		String scatList="";
		String[] userIds = scat.split(",");

		for (String a : userIds) {
			scatList = scatList + "\"" + a + "\",";
				}
		scatList = scatList.substring(0, scatList.length() - 1);
		scatList = "(" + scatList + ")";
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assetType='" + type + "',@p_cat='" + cat+ "',@p_scat='" + scatList+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("VALUES::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "showAssetExecution").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetching Interupted");
		}
		logger.info("Method : showTotalAsset Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPropertyApproved(String orgName, String orgDivision,String property,String floor,String space) {
		logger.info("Method : viewPropertyApproved Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_property='" + property + "',@p_floor='" + floor + "',@p_space='" + space + "';";
			System.out.println("VALUES::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "viewPropertyExecution").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPropertyApproved Dao ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> assignAssetForExecution(String id, String locid, String loctype,String date,String planId, String orgName, String orgDivision, String userId) {
		logger.info("Method : assignAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String value = "";
		String values = "";
		String litem = "";
		String ticket = "";
		String[] parts = id.split(",");
        for (String part : parts) {
            value = value + "(FN_GET_ASSIGNID(),\"" + part + "\",\""+ loctype + "\",\"" + locid + "\",\""+ date +"\",\""+orgName+"\",\""+orgDivision+"\"),";
            ticket= ticket + "(FN_GET_TICKETID(),\"" + userId + "\",@userName,\"" + DateFormatter.getStringDate(date) + "\",@deptId,\"TTYPE004\",\"TCAT007\",\"TSCAT006\",\"1\",\"Following Asset Should Be Assigned To Mentioned Location\",\"Property\",\"\",\"\",\""+ locid + "\",\""+ userId +"\",now(),\""+orgName+"\",\""+orgDivision+"\",1,\"COMPLETED\",\""+part+"\",\"SYSTEM\",\"NOT ASSIGNED\",\"Installation\"),";
        }
        for (String a : parts) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		
        value = value.substring(0, value.length() - 1);
        ticket = ticket.substring(0, ticket.length() - 1);
        values = values + "SET @p_itemSubQuery='" + value + "',"+ "@p_assetId='" + litem+ "',"+ "@p_ticket='" + ticket+ "',"+ "@p_orgName='" + orgName+ "',"+ "@p_orgDivision='" + orgDivision+ "',"+ "@p_userId='" + userId + "';";
        
        System.out.println(values);
		if (validity)
			
		try {
			em.createNamedStoredProcedureQuery("assetPropertyRoutines").setParameter("actionType", "assignAssetExe")
					.setParameter("actionValue", values).execute();
			resp.setMessage("Data Assigned Successfully");
			resp.setCode("success");
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

		logger.info("Method : assignAsset ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editPropertyPlan(String id, String orgName, String orgDivision) {
		logger.info("Method : editPropertyPlan Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "editPlanEx").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editPropertyPlan Dao ends");
		return resp;
	}
}
