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

/*
 * @author NirmalyaLabs
 *
 */
@Repository
public class VendorRegistrationDao {

	Logger logger = LoggerFactory.getLogger(VendorRegistrationDao.class);

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;


	public ResponseEntity<JsonResponse<Object>> addVendorRegistration(VendorRegistrationRestModal vendorRegistrationRestModal) {

		logger.info("Method in Dao: addVendorRegistration starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		try {
			String values = GenerateVendorRegistrationParams.getAddVendorParam(vendorRegistrationRestModal);
			System.out.println("VALUES::::::::  " + values);
			if (vendorRegistrationRestModal.getVendorId() == "" || vendorRegistrationRestModal.getVendorId() == null) {

				em.createNamedStoredProcedureQuery("asset_maintenance_routines").setParameter("actionType", "addVendor")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("asset_maintenance_routines").setParameter("actionType", "modifyVendor")
						.setParameter("actionValue", values).execute();
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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,HttpStatus.CREATED);
		if (resp.getMessage() == null) {
			resp.setMessage("Saved successfully");
		}
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method in Dao: addVendorRegistration ends");

		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRegistrationOfVendor(String orgName, String orgDivision) {
		logger.info("Method : viewRegistrationOfVendor Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "viewVendor").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewRegistrationOfVendor Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editVendorDetails(String id, String orgName, String orgDivision) {
		logger.info("Method : editVendorDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_vendorId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "editVendor").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editVendorDetails Dao ends");
		return resp;
	}
	
	
	public ResponseEntity<JsonResponse<Object>> deleteVendorDetails(String id) {
		logger.info("Method : deleteVendorDetails starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_vendorId='(" + id + ")';";
				System.out.println("VALUES:::"+value);
				em.createNamedStoredProcedureQuery("asset_maintenance_routines")
						.setParameter("actionType", "deleteVendor").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted Successfully");

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

		logger.info("Method :  deleteVendorDetails ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> activeVendorDetails(String id,String operation,String org,String orgDiv) {
		logger.info("Method : activeVendorDetails starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_vendorId='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv+ "',@p_operation=" + operation + ";";
				System.out.println("VALUES:::"+value);
				em.createNamedStoredProcedureQuery("asset_maintenance_routines")
						.setParameter("actionType", "activeVendor").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Operation Done Successfully");

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

		logger.info("Method :  activeVendorDetails ends");
		return response;
	}
}
