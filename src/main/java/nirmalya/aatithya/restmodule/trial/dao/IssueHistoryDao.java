package nirmalya.aatithya.restmodule.trial.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateOrgMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateOrganisationHoliday;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.trial.GenerateIssueHistoryParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.trial.model.IssueHistoryRestModel;

@Repository
public class IssueHistoryDao {
Logger logger = LoggerFactory.getLogger(IssueHistoryDao.class);

@Autowired
EntityManager em;

@Autowired
ServerDao serverDao;

// dao for issue

@SuppressWarnings("unchecked")
public List<DropDownModel> getissuelist() {
	logger.info("Method : getIssueList starts");

	List<DropDownModel> issuevehicle = new ArrayList<DropDownModel>();

	try {
		List<Object[]> x = em.createNamedStoredProcedureQuery("vmIssueHistory")
				.setParameter("actionType", "vm_fetchIssueList").setParameter("actionValue", "").getResultList();

		for (Object[] m : x) {
			DropDownModel issuedropDownModel = new DropDownModel(m[0], m[1]);
			System.out.println("Issue Vehicle" + issuedropDownModel);
			issuevehicle.add(issuedropDownModel);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	logger.info("Method : getIssueList ends");
	return issuevehicle;
}

// dao for vehicle

@SuppressWarnings("unchecked")
public List<DropDownModel> getvehiclelist() {
	logger.info("Method : getVehicleList starts");

	List<DropDownModel> vehicle = new ArrayList<DropDownModel>();

	try {
		List<Object[]> x = em.createNamedStoredProcedureQuery("vmIssueHistory")
				.setParameter("actionType", "vm_fetchVehicleList").setParameter("actionValue", "").getResultList();

		for (Object[] m : x) {
			DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
			System.out.println("Vehicle" + dropDownModel);
			vehicle.add(dropDownModel);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	logger.info("Method : getVehicleList ends");
	return vehicle;
}

// dao for vendor

@SuppressWarnings("unchecked")
public List<DropDownModel> getvendorlist() {
	logger.info("Method : getVendorList starts");

	List<DropDownModel> vendor = new ArrayList<DropDownModel>();

	try {
		List<Object[]> x = em.createNamedStoredProcedureQuery("vmIssueHistory")
				.setParameter("actionType", "vm_fetchVendorList").setParameter("actionValue", "").getResultList();

		for (Object[] m : x) {
			DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
			System.out.println("Vendor= " + dropDownModel);
			vendor.add(dropDownModel);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	logger.info("Method : getVendorList ends");
	return vendor;
}



// DAO for ADD

public ResponseEntity<JsonResponse<Object>> addvehicleDetails(IssueHistoryRestModel restPayroll) {
	logger.info("Method : Rest vehicle Dao starts");
	Boolean validity = true;
	JsonResponse<Object> resp = new JsonResponse<Object>();
	//System.out.println("restPayroll.getpId() ====" + restPayroll.getpId());

	if (validity)
		try {

			String values = GenerateIssueHistoryParam.addvehicleparam(restPayroll);

			if (restPayroll.getIssuergnumber() == null || restPayroll.getIssuergnumber() == "") {

				em.createNamedStoredProcedureQuery("vmIssueHistory").setParameter("actionType", "vm_addissuehistory")
						.setParameter("actionValue", values).execute();

			} else {

				em.createNamedStoredProcedureQuery("vmIssueHistory")
						.setParameter("actionType", "vm_modifyissuehistory").setParameter("actionValue", values)
						.execute();
			}

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

	logger.info("Method : Rest VehicleDao ends");

	return response;
}

// DAO for view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<IssueHistoryRestModel>>> viewissuedetails() {
		logger.info("Method : viewissuedetails starts");
		
		List<IssueHistoryRestModel> respList = new ArrayList<IssueHistoryRestModel>();
		JsonResponse<List<IssueHistoryRestModel>> resp = new JsonResponse<List<IssueHistoryRestModel>>();
	
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("vmIssueHistory")
					.setParameter("actionType", "vm_viewissuehistory").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {

				Object DATE = null;
				if (m[5] != null) {
				 DATE = DateFormatter.returnStringDate(m[5]);
				 } 
	
				IssueHistoryRestModel restDetails = new IssueHistoryRestModel(m[0], m[1], m[2], m[3], m[4], DATE, m[6], m[7], m[8]);
				respList.add(restDetails);
			}
	
			System.out.println("POLICY" + respList);
	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
			
		resp.setBody(respList);
		
		ResponseEntity<JsonResponse<List<IssueHistoryRestModel>>> response = new ResponseEntity<JsonResponse<List<IssueHistoryRestModel>>>(
				resp, HttpStatus.CREATED);
		
		System.out.println("response" + response);
		logger.info("Method : viewissuedetails ends");
		return response;
	}	
	
	// edit DAO
	
	@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<IssueHistoryRestModel>>> editissue(String id) {
			// TODO Auto-generated method stub
				logger.info("Method : editIssue starts");

				JsonResponse<List<IssueHistoryRestModel>> resp = new JsonResponse<List<IssueHistoryRestModel>>();
				List<IssueHistoryRestModel> newResp = new ArrayList<IssueHistoryRestModel>();

				try {
					String value = "SET @p_issuergnumber='" + id + "';";
					System.out.println("aa" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("vmIssueHistory")
							.setParameter("actionType", "vm_editissuehistory").setParameter("actionValue", value).getResultList();
					
					for (Object[] m : x) {
						
						Object DATE = null;
						if (m[5] != null) {
							DATE = DateFormatter.returnStringDate(m[5]);
						 } 

						IssueHistoryRestModel restDetails = new IssueHistoryRestModel(m[0], m[1], m[2], m[3], m[4], DATE, m[6], m[7], m[8]);
						newResp.add(restDetails);
						System.out.println("Output=" + restDetails);
					}
					
				resp.setBody(newResp); 
					
				} 
				
				catch (Exception e) {
					
					try {
						String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
						resp.setMessage(err[1]);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
		        
				ResponseEntity<JsonResponse<List<IssueHistoryRestModel>>> response = new ResponseEntity<JsonResponse<List<IssueHistoryRestModel>>>(resp,
						HttpStatus.CREATED);
				System.out.println("response" + response);
				logger.info("Method : editDetails ends");
				return response;
				
}
	
	// DELETE DAO

	public ResponseEntity<JsonResponse<Object>> deleteissue (String id) {
		logger.info("Method : deleteIssue starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_issuergnumber='" + id + "';";

				em.createNamedStoredProcedureQuery("vmIssueHistory")
						.setParameter("actionType", "vm_deleteissuehistory").setParameter("actionValue", value)
						.execute();

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

		logger.info("Method : deleteIssue ends");
		System.out.println("DELETE2" + response);
		return response;
	}
	
}
