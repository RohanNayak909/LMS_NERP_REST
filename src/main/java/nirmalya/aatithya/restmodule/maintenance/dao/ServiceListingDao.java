package nirmalya.aatithya.restmodule.maintenance.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateVendorRegistrationParams;
import nirmalya.aatithya.restmodule.maintenance.model.VendorRegistrationRestModal;


@Repository
public class ServiceListingDao {

	Logger logger = LoggerFactory.getLogger(ServiceListingDao.class);

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewServiceList(String orgName, String orgDivision, String userRole, String userName, String userId) {
		logger.info("Method : viewServiceList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userRole='" + userRole + "',@p_userName='" + userName + "',@p_userId='" + userId + "';";
			System.out.println("USER ROLE::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "viewServiceView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewServiceList Dao ends");
		return resp;

	}
	
	public ResponseEntity<JsonResponse<Object>> addService(VendorRegistrationRestModal vendorRegistrationRestModal) {

		logger.info("Method in Dao: addService starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		try {
			String values = GenerateVendorRegistrationParams.getServiceListParam(vendorRegistrationRestModal);
			System.out.println("VALUES::::::::  " + values);
				em.createNamedStoredProcedureQuery("asset_maintenance_routines").setParameter("actionType", "addService")
						.setParameter("actionValue", values).execute();

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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,HttpStatus.CREATED);
		if (resp.getMessage() == null) {
			resp.setMessage("Data Saved successfully");
		}
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method in Dao: addService ends");

		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editServiceDetails(String id, String orgName, String orgDivision) {
		logger.info("Method : editServiceDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_vendorId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "editService").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editServiceDetails Dao ends");
		return resp;
	}
}
