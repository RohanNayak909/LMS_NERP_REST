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
import nirmalya.aatithya.restmodule.common.utils.trial.GenerateFuelParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.trial.model.ManageFuelRestModel;

@Repository
public class ManageFuelDao {
	Logger logger = LoggerFactory.getLogger(ManageFuelDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	// dao for vehicle reg list

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getreglist() {
		logger.info("Method : getIssueList starts");

		List<DropDownModel> issuevehicle = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vmFuelReport")
					.setParameter("actionType", "vm_fetchRegList").setParameter("actionValue", "").getResultList();

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

	// dao for fuel list

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getfuellist() {
		logger.info("Method : getVehicleList starts");

		List<DropDownModel> fuel = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vmFuelReport")
					.setParameter("actionType", "vm_fetchFuelList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				System.out.println("Vehicle" + dropDownModel);
				fuel.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVehicleList ends");
		return fuel;
	}

//DAO for ADD

	public ResponseEntity<JsonResponse<Object>> addfuelDetails(ManageFuelRestModel restPayroll) {
		logger.info("Method : Rest vehicle Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		// System.out.println("restPayroll.getpId() ====" + restPayroll.getpId());

		if (validity)
			try {

				String values = GenerateFuelParameter.addvehicleparam(restPayroll);

				if (restPayroll.getFsid() == null || restPayroll.getFsid() == "") {

					em.createNamedStoredProcedureQuery("vmFuelReport").setParameter("actionType", "vm_addissuehistory")
							.setParameter("actionValue", values).execute();

				} else {

					em.createNamedStoredProcedureQuery("vmFuelReport")
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

// view DAO

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageFuelRestModel>>> viewfueldetails() {
		logger.info("Method : viewissuedetails starts");

		List<ManageFuelRestModel> respList = new ArrayList<ManageFuelRestModel>();
		JsonResponse<List<ManageFuelRestModel>> resp = new JsonResponse<List<ManageFuelRestModel>>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vmFuelReport")
					.setParameter("actionType", "vm_viewissuehistory").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
				Object DATE = null;
				Object NEWDATE= null;
				
				if ((m[5] != null) && (m[6]!= null)){
					DATE = DateFormatter.returnStringDate(m[5]);
					NEWDATE= DateFormatter.returnStringDate(m[6]);
				 } 

				ManageFuelRestModel restDetails = new ManageFuelRestModel(m[0], m[1], m[2], m[3], m[4], DATE,
						NEWDATE, m[7], m[8], m[9], m[10], m[11], m[12]);
				

				respList.add(restDetails);
			}

			System.out.println("POLICY" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		resp.setBody(respList);

		ResponseEntity<JsonResponse<List<ManageFuelRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageFuelRestModel>>>(
				resp, HttpStatus.CREATED);

		System.out.println("response" + response);
		logger.info("Method : viewissuedetails ends");
		return response;
	}
	
	// edit DAO
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageFuelRestModel>>> editfueldetails(String id) {
			logger.info("Method : editIssue starts");

			JsonResponse<List<ManageFuelRestModel>> resp = new JsonResponse<List<ManageFuelRestModel>>();
			List<ManageFuelRestModel> newResp = new ArrayList<ManageFuelRestModel>();

			try {
				String value = "SET @p_fsid='" + id + "';";
				System.out.println("aa" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("vmFuelReport")
						.setParameter("actionType", "vm_editissuehistory").setParameter("actionValue", value).getResultList();
				
				for (Object[] m : x) {
					
					Object DATE = null;
					Object NEWDATE= null;
					
					if ((m[5] != null) && (m[6]!= null)){
						DATE = DateFormatter.returnStringDate(m[5]);
						NEWDATE= DateFormatter.returnStringDate(m[6]);
					 } 
			
					ManageFuelRestModel restDetails = new ManageFuelRestModel(m[0], m[1], m[2], m[3], m[4], DATE,
							NEWDATE, m[7], m[8], m[9], m[10], m[11], m[12]);
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
	        
			ResponseEntity<JsonResponse<List<ManageFuelRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageFuelRestModel>>>(resp,
					HttpStatus.CREATED);
			System.out.println("response" + response);
			logger.info("Method : editDetails ends");
			return response;
			
	}
			
		// delete Dao
			
		public ResponseEntity<JsonResponse<Object>> deletefueldetails (String id) {
				logger.info("Method : deleteIssue starts");

				Boolean validity = true;
				JsonResponse<Object> resp = new JsonResponse<Object>();
				resp.setMessage("");
				resp.setCode("");

				if (validity)
					try {

						String value = "SET @p_fsid='" + id + "';";

						em.createNamedStoredProcedureQuery("vmFuelReport")
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