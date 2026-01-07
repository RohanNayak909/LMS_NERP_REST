package nirmalya.aatithya.restmodule.pipeline.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateCrmOwnerDetails;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmOwnerModel;

@Repository
public class RestCrmOwnerDao {

	Logger logger = LoggerFactory.getLogger(RestCrmOwnerDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> restAddOwnerDetails(RestCrmOwnerModel leadDetails) {

		logger.info("Method in Dao: restAddOwnerDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
			try {
				String values = GenerateCrmOwnerDetails.generateCrmOwnerParam(leadDetails);
				logger.info(values);
				if (leadDetails.getOwnerId() =="" || leadDetails.getOwnerId() ==null) {
			
					em.createNamedStoredProcedureQuery("crm_Owner_Routines").setParameter("actionType", "addOwnerData")
							.setParameter("actionValue", values).execute();
					
				} else {
					logger.info("in modify"+leadDetails.getOwnerId());
					em.createNamedStoredProcedureQuery("crm_Owner_Routines").setParameter("actionType", "modifyOwnerData")
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: restAddOwnerDao ends");

		return response;
	}
	
////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmOwnerModel>>> viewCrmOwnerDetails() {
		logger.info("Method : viewCrmOwnerDetails starts");
		List<RestCrmOwnerModel> respList = new ArrayList<RestCrmOwnerModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Owner_Routines").setParameter("actionType", "getOwnerDetails")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestCrmOwnerModel restPayroll = new RestCrmOwnerModel(m[0], m[1], m[2],m[3],m[4],m[5]);
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCrmOwnerModel>> resp = new JsonResponse<List<RestCrmOwnerModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmOwnerModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmOwnerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewCrmOwnerDetails ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
	
////edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmOwnerModel>>> editOwnerInfo(String id) {
		logger.info("Method : editOwnerInfo starts");

		JsonResponse<List<RestCrmOwnerModel>> resp = new JsonResponse<List<RestCrmOwnerModel>>();
		List<RestCrmOwnerModel> rs = new ArrayList<RestCrmOwnerModel>();

		try {

			String value = "SET @p_ownerId='" + id +"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Owner_Routines")
					.setParameter("actionType", "editOwnerInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf"+x);
           
			for (Object[] m : x) {
				RestCrmOwnerModel assignSkill = new RestCrmOwnerModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],
						m[11],m[12], m[13], m[14].toString(), m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22]);
				rs.add(assignSkill);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmOwnerModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmOwnerModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : editLeadInfo ends");
		return response;
	}
	
	
	/**
	 * DAO Function to delete Schedule
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restDeleteOwnerInfo(RestCrmOwnerModel restScheduleModel) {
		logger.info("Method : deleteSchedule dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			//String value = GenerateScheduleManagementParam.getDeleteParam(restScheduleModel);
			String value = "SET @p_ownerId='" + restScheduleModel.getOwnerId() + "';";
			logger.info(value+" is ");
			em.createNamedStoredProcedureQuery("crm_Owner_Routines")
					.setParameter("actionType", "deleteOwnerInfo").setParameter("actionValue", value).execute();

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
		logger.info("Method : deleteSchedule dao ends" + response);

		return response;
	}


	
	
}
