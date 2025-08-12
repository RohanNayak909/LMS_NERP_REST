package nirmalya.aatithya.restmodule.asset.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AssetSparepartAllocationDao {
	Logger logger = LoggerFactory.getLogger(AssetSparepartAllocationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// viewAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewSpareAssign(String id,String orgName, String orgDivision,String userId) {
		logger.info("Method : viewSpareAssign Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_id='" + id + "',@p_userId='" + userId+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_assign_routines")
					.setParameter("actionType", "viewSpareAssign").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewSpareAssign Dao ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> dissociateSpare(String assignid, String assetid, String orgName,
			String orgDivision, String dreason, String spareQty) {
		logger.info("Method : dissociateSpare starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assignId='" + assignid + "',@p_assetId='" + assetid + "',@p_org='" + orgName
						+ "',@p_orgDiv='" + orgDivision + "',@p_dreason='" + dreason+ "',@p_spareQty='" + spareQty + "';";
				System.out.println("VALUE::::::::::"+value);
				em.createNamedStoredProcedureQuery("asset_assign_routines")
						.setParameter("actionType", "dissociateSpare").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Dissociated successfully");
			} catch (Exception e) {
				resp.setCode("unsuccess");
				resp.setMessage("Data Dissociated Failed");
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

		logger.info("Method : dissociateSpare ends");
		return response;
	}

}
