package nirmalya.aatithya.restmodule.master.dao;
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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateOrgMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.master.model.RestOrganisationTypeModel;

@Repository
public class RestOrganisationTypeDao {
	Logger logger = LoggerFactory.getLogger(RestOrganisationTypeDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
 
	
	public ResponseEntity<JsonResponse<Object>> addOrgType(RestOrganisationTypeModel restOrganisationTypeModel) {
		logger.info("Method : addOrganiser Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateOrgMasterParameter.addOrgType(restOrganisationTypeModel);

				logger.info("organization id: " + restOrganisationTypeModel.getOrgId());
				if (restOrganisationTypeModel.getOrgId() != null
						&& restOrganisationTypeModel.getOrgId() == "") {
					logger.info("if part: " + values);
					em.createNamedStoredProcedureQuery("masterOrgTypeRoutines")
							.setParameter("actionType", "addOrgType").setParameter("actionValue", values)
							.execute();
				} 
					  else { 
						  logger.info("else part: " + values);
					  em.createNamedStoredProcedureQuery("masterOrgTypeRoutines")
					 .setParameter("actionType", "modifyOrgTypeRoutines").setParameter("actionValue", values)
					  .execute(); }
		
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
		logger.info("resp" + response);
		logger.info("Method : addOrganiser Dao ends");
		return response;
	}

	/// rest view

    @SuppressWarnings("unchecked")
    public ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> vieworgType() {
    logger.info("Method : vieworgType starts");
    List<RestOrganisationTypeModel> respList = new ArrayList<RestOrganisationTypeModel>();

	try {
		List<Object[]> x = em.createNamedStoredProcedureQuery("masterOrgTypeRoutines")
				.setParameter("actionType", "vieworgTypeDetails").setParameter("actionValue", "").getResultList();

		for (Object[] m : x) {

			RestOrganisationTypeModel restOrganisationTypeModel = new RestOrganisationTypeModel(m[0],m[1],m[2],null,null,null,null,null);
			respList.add(restOrganisationTypeModel);
			logger.info("RestOrganisationTypeModel" + restOrganisationTypeModel);
		}
		logger.info("respList" + respList);
	} catch (Exception e) {
		e.printStackTrace();
	}

	JsonResponse<List<RestOrganisationTypeModel>> resp = new   JsonResponse<List<RestOrganisationTypeModel>>();
	resp.setBody(respList);
	ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> response = new ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>>(
			resp, HttpStatus.CREATED);
	logger.info("response" + response);
	logger.info("Method : vieworg ends");
	return response;
}
    
    
  //edit Dao
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> editOrganizerType(String id) {
		logger.info("Method : editOrganizerType starts");

		JsonResponse<List<RestOrganisationTypeModel>> resp = new JsonResponse<List<RestOrganisationTypeModel>>();
		List<RestOrganisationTypeModel> newResp = new ArrayList<RestOrganisationTypeModel>();

		try {
			String value = "SET @p_OrgId='" + id + "';";
			logger.info("@@@@@@@@@@@@@@@@@@@" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("masterOrgTypeRoutines")
					.setParameter("actionType", "editOrganiserTypeDetails").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestOrganisationTypeModel restOrganisationTypeModel = new RestOrganisationTypeModel(m[0], m[1], m[2],null,null,null,null,null);
				newResp.add(restOrganisationTypeModel);
			}
			
			resp.setBody(newResp);
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
        
		ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> response = new ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : editOrganizerType ends");
		return response;
	}
	
 
	public ResponseEntity<JsonResponse<Object>> deleteOrganzierType(String id) {

		logger.info("Method : deleteOrganzierType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_OrgId='" + id + "';";

			em.createNamedStoredProcedureQuery("masterOrgTypeRoutines").setParameter("actionType", "deleteOrgTypeDetails")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteOrganzierType Dao ends");
		return response;
	}

	
	///holiday add
	
	public ResponseEntity<JsonResponse<Object>> addOrgTypeHoliday(RestOrganisationTypeModel restOrganisationTypeModel) {
		logger.info("Method : addOrgTypeHoliday Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateOrgMasterParameter.addOrgTypeHoliday(restOrganisationTypeModel);

				logger.info("organization id: " + restOrganisationTypeModel.getHolidayId());
 
						
				 if (restOrganisationTypeModel.getHolidayId() == "" || restOrganisationTypeModel.getHolidayId() == null)
				 {
				  logger.info("if part: " + values);
				  em.createNamedStoredProcedureQuery("masterOrgHolidaysRoutines").setParameter(
						  "actionType", "addOrgHoliday") .setParameter("actionValue",values).execute();
				 
				  } else {
				  logger.info("Else part");
				  em.createNamedStoredProcedureQuery("masterOrgHolidaysRoutines").setParameter(
						  "actionType", "modifyOrgHolidays") .setParameter("actionValue",values).execute(); 
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
		logger.info("resp" + response);
		logger.info("Method : addOrgTypeHoliday Dao ends");
		return response;
	}
	
	
	/// holiday view

    @SuppressWarnings("unchecked")
    public ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> vieworgTypeHoliday() {
    logger.info("Method : vieworgTypeHoliday starts");
    List<RestOrganisationTypeModel> respList = new ArrayList<RestOrganisationTypeModel>();

	try {
		List<Object[]> x = em.createNamedStoredProcedureQuery("masterOrgHolidaysRoutines")
				.setParameter("actionType", "vieworgTypeHolidayDetails").setParameter("actionValue", "").getResultList();

		for (Object[] m : x) {
			Object fdate = null;
			if (m[2] != null) {
				fdate  =DateFormatter.returnStringDate(m[2]);
			}
			Object tdate = null;
			if (m[3] != null) {
				tdate  =DateFormatter.returnStringDate(m[3]);
			}
			RestOrganisationTypeModel restOrganisationTypeModel = new RestOrganisationTypeModel(m[0],m[1],fdate,tdate,m[4]);
			respList.add(restOrganisationTypeModel);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	JsonResponse<List<RestOrganisationTypeModel>> resp = new   JsonResponse<List<RestOrganisationTypeModel>>();
	resp.setBody(respList);
	ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> response = new ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>>(
			resp, HttpStatus.CREATED);
	logger.info("Method : vieworgTypeHoliday ends");
	return response;
}
    //holiday delete
    public ResponseEntity<JsonResponse<Object>> deleteOrganzierTypeHoliday(String id) {

		logger.info("Method : deleteOrganzierTypeHoliday Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_HolidayId='" + id + "';";

			em.createNamedStoredProcedureQuery("masterOrgHolidaysRoutines").setParameter("actionType", "deleteOrgTypeholidayDetails")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteOrganzierTypeHoliday Dao ends");
		return response;
	}
    
    
    
    //bank add
    
    public ResponseEntity<JsonResponse<Object>> addBank(RestOrganisationTypeModel restOrganisationTypeModel) {
		logger.info("Method : addBank Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("Method : restOrganisationTypeModel===="+restOrganisationTypeModel);
		if (validity)
			try {
				String values = GenerateOrgMasterParameter.addBankDetails(restOrganisationTypeModel);
				logger.info("organization id: " + restOrganisationTypeModel.getBankId());
				if (restOrganisationTypeModel.getBankId() != null
						&& restOrganisationTypeModel.getBankId() == "") {
					logger.info("if part: " + values);
					em.createNamedStoredProcedureQuery("masterBankRoutines")
							.setParameter("actionType", "addBank").setParameter("actionValue", values)
							.execute();
				} 
					  else { 
						  logger.info("else part: " + values);
					  em.createNamedStoredProcedureQuery("masterBankRoutines")
					 .setParameter("actionType", "modifyBankRoutines").setParameter("actionValue", values)
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
		logger.info("Method : addBank Dao ends");
		return response;
	}
    
    
    
    
  /// rest bank view

    @SuppressWarnings("unchecked")
    public ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> viewBank() {
    logger.info("Method : viewBank starts");
    List<RestOrganisationTypeModel> respList = new ArrayList<RestOrganisationTypeModel>();

	try {
		List<Object[]> x = em.createNamedStoredProcedureQuery("masterBankRoutines")
				.setParameter("actionType", "viewbankDetails").setParameter("actionValue", "").getResultList();

		for (Object[] m : x) {

			RestOrganisationTypeModel restOrganisationTypeModel = new RestOrganisationTypeModel(m[0],m[1],m[2],m[3]);
			respList.add(restOrganisationTypeModel);
			logger.info("RestOrganisationTypeModel" + restOrganisationTypeModel);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	JsonResponse<List<RestOrganisationTypeModel>> resp = new   JsonResponse<List<RestOrganisationTypeModel>>();
	resp.setBody(respList);
	ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> response = new ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>>(
			resp, HttpStatus.CREATED);
	logger.info("Method : viewBank ends");
	return response;
}
    
   
   	

	public ResponseEntity<JsonResponse<Object>> deleteBankTypeDetails(String id) {

		logger.info("Method : deleteBankTypeDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_BankId='" + id + "';";

			em.createNamedStoredProcedureQuery("masterBankRoutines").setParameter("actionType", "deleteBankTypeDetails")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteBankTypeDetails Dao ends");
		return response;
	}

	
	
	// Add Announcement Details
	public ResponseEntity<JsonResponse<Object>> addannouncement(RestOrganisationTypeModel restOrganisationTypeModel) {
		logger.info("Method : addannouncement Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("Method : restOrganisationTypeModel===="+restOrganisationTypeModel);
		if (validity)
			try {
				String values = GenerateOrgMasterParameter.addAnnouncement(restOrganisationTypeModel);
				logger.info("announcement id: " + restOrganisationTypeModel.getAnnouncementId());
				if (restOrganisationTypeModel.getAnnouncementId()!=null
						&& restOrganisationTypeModel.getAnnouncementId()!="") {
					logger.info("if part: " + values);
					em.createNamedStoredProcedureQuery("masterAnnouncementRoutines")
							.setParameter("actionType", "modifyAnnouncement").setParameter("actionValue", values)
							.execute();
				} 
					  else { 
						  logger.info("else part: " + values);
					  em.createNamedStoredProcedureQuery("masterAnnouncementRoutines")
					 .setParameter("actionType", "addannouncement").setParameter("actionValue", values)
					  .execute(); }
 
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
		logger.info("Method : addannouncement Dao ends");
		return response;
	}
	
	
	//View Announcement
	@SuppressWarnings("unchecked")
    public ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> viewannouncement() {
    logger.info("Method : viewannouncement starts");
    List<RestOrganisationTypeModel> respList = new ArrayList<RestOrganisationTypeModel>();

	try {
		List<Object[]> x = em.createNamedStoredProcedureQuery("masterAnnouncementRoutines")
				.setParameter("actionType", "viewannouncement").setParameter("actionValue", "").getResultList();

		for (Object[] m : x) {

			RestOrganisationTypeModel restOrganisationTypeModel = new RestOrganisationTypeModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6]);
			respList.add(restOrganisationTypeModel);
		}
		logger.info("respListsdsdsddd" + respList);
	} catch (Exception e) {
		e.printStackTrace();
	}

	JsonResponse<List<RestOrganisationTypeModel>> resp = new   JsonResponse<List<RestOrganisationTypeModel>>();
	resp.setBody(respList);
	ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> response = new ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>>(
			resp, HttpStatus.CREATED);
	logger.info("response Ann===" + response);
	logger.info("Method : viewannouncement ends");
	return response;
}
    
	//Delete Announcement
	 public ResponseEntity<JsonResponse<Object>> deleteannouncement(String id) {

			logger.info("Method : deleteannouncement Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String values = "SET @p_AnncId='" + id + "';";

				em.createNamedStoredProcedureQuery("masterAnnouncementRoutines").setParameter("actionType", "deleteannouncement")
						.setParameter("actionValue", values).execute();

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

			logger.info("Method : deleteannouncement Dao ends");
			return response;
		}
	    
	    
	// Add Leave Policy
		public ResponseEntity<JsonResponse<Object>> addleavepolicy(RestOrganisationTypeModel restOrganisationTypeModel) {
			logger.info("Method : addleavepolicy Dao starts");
			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();

			if (validity)
				try {
					String values = GenerateOrgMasterParameter.addleavepolicy(restOrganisationTypeModel);
					logger.info("Method : addleavepolicy Dao starts"+values);

					logger.info("policy id: " + restOrganisationTypeModel.getLeavePolicyId());
					if (restOrganisationTypeModel.getLeavePolicyId()!=null
							&& restOrganisationTypeModel.getLeavePolicyId()!="") {
						logger.info("if part: " + values);
						em.createNamedStoredProcedureQuery("masterLeavePolicyRoutines")
								.setParameter("actionType", "modifyleavepolicy").setParameter("actionValue", values)
								.execute();
					} 
						  else { 
							  logger.info("else part: " + values);
						  em.createNamedStoredProcedureQuery("masterLeavePolicyRoutines")
						 .setParameter("actionType", "addleavepolicy").setParameter("actionValue", values)
						  .execute(); }
			
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
			logger.info("resp" + response);
			logger.info("Method : addleavepolicy Dao ends");
			return response;
		}
		
		
		//View Leave Policy
		@SuppressWarnings("unchecked")
	    public ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> viewleavepolicy() {
	    logger.info("Method : viewleavepolicy starts");
	    List<RestOrganisationTypeModel> respList = new ArrayList<RestOrganisationTypeModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("masterLeavePolicyRoutines")
					.setParameter("actionType", "viewleavepolicy").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				Object fdate = null;
				if (m[1] != null) {
					fdate  =DateFormatter.returnStringDate(m[1]);
				}
				Object tdate = null;
				if (m[2] != null) {
					tdate  =DateFormatter.returnStringDate(m[2]);
				}
				RestOrganisationTypeModel restOrganisationTypeModel = new RestOrganisationTypeModel(m[0].toString(),fdate,tdate,m[3].toString(),m[4].toString(),m[5].toString());
				respList.add(restOrganisationTypeModel);
			}
			logger.info("respListsdsdsddd" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestOrganisationTypeModel>> resp = new   JsonResponse<List<RestOrganisationTypeModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>> response = new ResponseEntity<JsonResponse<List<RestOrganisationTypeModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewleavepolicy ends");
		return response;
	}
	    
   //Leave Policy Edit
	
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<RestOrganisationTypeModel>>editleavepolicy(String id) {
			logger.info("Method : editleavepolicy starts");

			RestOrganisationTypeModel req = new RestOrganisationTypeModel();
			JsonResponse<RestOrganisationTypeModel> resp = new JsonResponse<RestOrganisationTypeModel>();

			try {

				String value = "SET @p_PolicylId='" + id + "';";
				logger.info(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("masterLeavePolicyRoutines")
						.setParameter("actionType", "editleavepolicy").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {

					RestOrganisationTypeModel reqemp = new RestOrganisationTypeModel(m[0].toString(), m[1].toString(), m[2].toString(), m[3].toString(), m[4].toString(),null);
					req=reqemp;

				}

				resp.setBody(req);
			} catch (Exception e) {
				e.printStackTrace();
			}

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<RestOrganisationTypeModel>> response = new ResponseEntity<JsonResponse<RestOrganisationTypeModel>>(
					resp, responseHeaders, HttpStatus.CREATED);

			logger.info("Method : editleavepolicy ends");
			return response;
		}
		
		
		
		//Delete Leave Policy
		 public ResponseEntity<JsonResponse<Object>> deleteleavepolicy(String id) {

				logger.info("Method : deleteleavepolicy Dao starts");

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String values = "SET @p_PolicylId='" + id + "';";
					logger.info("Method : deleteleavepolicy Dao starts"+values);

					em.createNamedStoredProcedureQuery("masterLeavePolicyRoutines").setParameter("actionType", "deleteleavepolicy")
							.setParameter("actionValue", values).execute();

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

				logger.info("Method : deleteleavepolicy Dao ends");
				return response;
			}
 
}