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

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateVendorMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateemployeemasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeBankDetailsRestModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.VendorContactMasterModel;
import nirmalya.aatithya.restmodule.master.model.VendorDocumentMaster;
import nirmalya.aatithya.restmodule.master.model.VendorLocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.VendorMasterModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class VendorMasterDao {
	Logger logger = LoggerFactory.getLogger(VendorMasterDao.class);
	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getTypeListByCategoryWise(String id) {
		logger.info("Method : getTypeListByCategoryWise starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_Category='" + id + "';";
		logger.info("value====="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "getTypeListByCategoryWise").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}
			if (stateList.size() > 0) {
				Util.setJsonResponse(resp, stateList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, stateList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getTypeListByCategoryWise ends"+response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<VendorMasterModel>> saveVendorMaster(VendorMasterModel vendorMasterModel) {
		logger.info("Method : saveVendorMaster starts");

		Boolean validity = true;
		JsonResponse<VendorMasterModel> resp = new JsonResponse<VendorMasterModel>();
		resp.setMessage("868iohjkjnmn");
		resp.setCode("");

		List<VendorMasterModel> newVendor = new ArrayList<VendorMasterModel>();

		/*
		 * if (vendorMasterModel.getCode() == null || vendorMasterModel.getCode() == "")
		 * { resp.setMessage("Code Required"); validity = false; } else
		 */
		if (vendorMasterModel.getVendorName() == null || vendorMasterModel.getVendorName() == "") {
			resp.setMessage("Vendor Name Required");
			validity = false;
		} 
		/*
			 * else if (vendorMasterModel.getCategory() == null ||
			 * vendorMasterModel.getCategory() == "") {
			 * resp.setMessage("Category Required"); validity = false; } else if
			 * (vendorMasterModel.getCategoryType() == null ||
			 * vendorMasterModel.getCategoryType() == "") {
			 * resp.setMessage("Category Type Required"); validity = false; } else if
			 * (vendorMasterModel.getComapanyOverview() == null ||
			 * vendorMasterModel.getComapanyOverview() == "") {
			 * resp.setMessage("Companny Overview Required"); validity = false; }
			 */

		if (validity)
			try {
				String values = GenerateVendorMasterParameter.saveVendorMaster(vendorMasterModel);
				logger.info("@@@@@@@" +values);

				if (vendorMasterModel.getVendorId() != null && vendorMasterModel.getVendorId() != "") {
					// em.createNamedStoredProcedureQuery("locationMasterRoutines")
					// .setParameter("actionType", "modifyLocation").setParameter("actionValue",
					// values).execute();

					List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
							.setParameter("actionType", "modifyVendor").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						Object createDate = null;
						Object establishDate = null;

						if (m[7] != null) {
							createDate = m[7].toString();
						}
						if (m[17] != null) {
							createDate = m[17].toString();
						}
						VendorMasterModel vendorMasterModelData = new VendorMasterModel(m[0], m[1], m[2], m[3], m[4],
								m[5], m[6].toString(), createDate, m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
								null, null, null, establishDate, m[18], m[19], m[20], m[21],null,null,null,null,null,null,null,null);
						newVendor.add(vendorMasterModelData);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
							.setParameter("actionType", "addVendor").setParameter("actionValue", values)
							.getResultList();
					logger.info("@@@@@@@@@@@@@@@@@@@@@@@@#" +values);
					for (Object[] m : x) {

						Object createDate = null;

						if (m[7] != null) {
							createDate = m[7].toString();
						}

						/*
						 * VendorMasterModel vendorMasterModelData = new VendorMasterModel(m[0], m[1],
						 * m[2], m[3], m[4], m[5], m[6], createDate, m[8], m[9], m[10], m[11], m[12],
						 * m[13], m[14], m[15], m[16], null, null, null, null, null, null, null,
						 * null,m[22],m[23]); newVendor.add(vendorMasterModelData);
						 */
						
						VendorMasterModel vendorMasterModelData = new VendorMasterModel(m[0], m[1], m[2], m[3], m[4],
								m[5], m[6].toString(), createDate, m[8], m[9], null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null,m[10],m[11],null,null,null,null,null,null);
						newVendor.add(vendorMasterModelData);
						
						
					}
				}

				resp.setBody(newVendor.get(0));
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

		ResponseEntity<JsonResponse<VendorMasterModel>> response = new ResponseEntity<JsonResponse<VendorMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveVendorMaster ends"+response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCategoryList() {
		logger.info("Method : getCategoryList starts");

		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "getCategoryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				categoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
logger.info("categoryList===="+categoryList);
		logger.info("Method : getCategoryList ends");
		return categoryList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<VendorLocationMasterModel>> saveVendorLocationMaster(
			VendorLocationMasterModel vendorLocationMasterModel) {
		logger.info("Method : saveVendorMaster starts");

		Boolean validity = true;
		JsonResponse<VendorLocationMasterModel> resp = new JsonResponse<VendorLocationMasterModel>();
		resp.setMessage("");
		resp.setCode("");

		List<VendorLocationMasterModel> newVendor = new ArrayList<VendorLocationMasterModel>();

		if (vendorLocationMasterModel.getVendorLocationName() == null
				|| vendorLocationMasterModel.getVendorLocationName() == "") {
			resp.setMessage("Location Name Required");
			validity = false;
		} else if (vendorLocationMasterModel.getVendorLocationType() == null
				|| vendorLocationMasterModel.getVendorLocationType() == "") {
			resp.setMessage("Vendor Location Type Required");
			validity = false;

		} else if (vendorLocationMasterModel.getVendorLocAddress() == null
				|| vendorLocationMasterModel.getVendorLocAddress() == "") {
			resp.setMessage("Vendor Location Address Required");
			validity = false;

		}  
		if (validity)
			try {
				String values = GenerateVendorMasterParameter.saveVendorLocationMaster(vendorLocationMasterModel);

				if (vendorLocationMasterModel.getVendorLocationId() != null
						&& vendorLocationMasterModel.getVendorLocationId() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
							.setParameter("actionType", "modifyVendorLocation").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
			logger.info("modify======"+values);
						Object sDate = null;
						if (m[11] != null) {
							sDate = DateFormatter.returnStringDate(m[11]);
						}

						VendorLocationMasterModel vendorLocation = new VendorLocationMasterModel(m[0], m[1], m[2], m[3],
								m[4], m[5], m[6], m[7], m[8], m[9], m[10], sDate,null,null);
						newVendor.add(vendorLocation);
					}
				} else {
logger.info("add======"+values);
					List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
							.setParameter("actionType", "addVendorLocation").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						Object sDate = null;
						if (m[11] != null) {
							sDate = DateFormatter.returnStringDate(m[11]);
						}

						VendorLocationMasterModel vendorLocation = new VendorLocationMasterModel(m[0], m[1], m[2], m[3],
								m[4], m[5], m[6], m[7], m[8], m[9], m[10], sDate,m[12],m[13]);
						newVendor.add(vendorLocation);
					}
				}

				resp.setBody(newVendor.get(0));
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

		ResponseEntity<JsonResponse<VendorLocationMasterModel>> response = new ResponseEntity<JsonResponse<VendorLocationMasterModel>>(
				resp, HttpStatus.CREATED);
logger.info("response==="+response);
		logger.info("Method : saveVendorLocationMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<VendorLocationMasterModel>>> getVendorLocationview(String id,String orgName, String orgDiv) {
		logger.info("Method : getRequistionview starts");

		List<VendorLocationMasterModel> viewVendorLocation = new ArrayList<VendorLocationMasterModel>();

		try {
			String value = "SET @p_vendorId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "viewVendorLocation").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object sDate = null;
				if (m[11] != null) {
					sDate = m[11].toString();
				}
				VendorLocationMasterModel vendorLocation = new VendorLocationMasterModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], sDate,null,null);
				viewVendorLocation.add(vendorLocation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<VendorLocationMasterModel>> resp = new JsonResponse<List<VendorLocationMasterModel>>();
		resp.setBody(viewVendorLocation);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<VendorLocationMasterModel>>> response = new ResponseEntity<JsonResponse<List<VendorLocationMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getRequistionview ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<VendorMasterModel>>> getVendorList(String createdBy,String orgName, String orgDiv) {
		logger.info("Method : getVendorList starts");

		List<VendorMasterModel> viewVendor = new ArrayList<VendorMasterModel>();
		String value = "SET @p_createdBy='" + createdBy + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
	logger.info("value===="+value);
		try {

			
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "viewVendor").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[7] != null) {
					sDate = m[7].toString();
				}
				VendorMasterModel vendorMasterModel = new VendorMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6].toString(),
						sDate, m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], null, null, null, null,
						null, null, null, null,null,null,null,null,null,null,null,null);
				viewVendor.add(vendorMasterModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<VendorMasterModel>> resp = new JsonResponse<List<VendorMasterModel>>();
		resp.setBody(viewVendor);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<VendorMasterModel>>> response = new ResponseEntity<JsonResponse<List<VendorMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getVendorList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<VendorLocationMasterModel>> editVendorLoactionById(String id,String orgName, String orgDiv) {
		logger.info("Method : editVendorLoactionById starts");

		JsonResponse<VendorLocationMasterModel> resp = new JsonResponse<VendorLocationMasterModel>();
		List<VendorLocationMasterModel> newVendor = new ArrayList<VendorLocationMasterModel>();

		try {

			//String value = "SET @P_vendorId='" + id + "';";
			String value = "SET @P_vendorId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "editVendorLocation").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object sDate = null;
				if (m[11] != null) {
					sDate = DateFormatter.returnStringDate(m[11]);
				}

				VendorLocationMasterModel vendorLocation = new VendorLocationMasterModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], sDate,null,null);
				newVendor.add(vendorLocation);
			}

			resp.setBody(newVendor.get(0));
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

		ResponseEntity<JsonResponse<VendorLocationMasterModel>> response = new ResponseEntity<JsonResponse<VendorLocationMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : editVendorLoactionById ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteVendorLocation(String id, String simpleid, String vendorId,
			String createdBy,String orgName, String orgDiv) {
		logger.info("Method : deleteVendorLocation starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				/*
				 * String value = "SET @P_ModifiedBy='" + createdBy + "',@P_Id='" + simpleid +
				 * "',@vendorId='" + vendorId + "', @P_VendorLocId='(" + id + ")';";
				 */
				String value = "SET @P_ModifiedBy='" + createdBy + "',@P_Id='" + simpleid + "',@vendorId='" + vendorId
						+ "', @P_VendorLocId='(" + id + ")',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

				em.createNamedStoredProcedureQuery("vendorMasterRoutines").setParameter("actionType", "deleteVendorLoc")
						.setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteVendorLocation ends"+response);
		return response;
	}
	
	
	
	  
	  public ResponseEntity<JsonResponse<Object>> deleteVendorContacts(String id, String simpleid, String vendorId,
				String createdBy,String orgName, String orgDiv) {
			logger.info("Method : deleteVendorContacts starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					/*
					 * String value = "SET @P_ModifiedBy='" + createdBy + "',@P_Id='" + simpleid +
					 * "',@vendorId='" + vendorId + "', @P_contactId='(" + id + ")';";
					 */
					String value = "SET @P_ModifiedBy='" + createdBy + "',@P_Id='" + simpleid + "',@p_cid='" + vendorId
							+ "', @P_contactId='(" + id + ")',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
					
logger.info(value);
					em.createNamedStoredProcedureQuery("vendorMasterRoutines").setParameter("actionType", "deleteVendorContacts")
							.setParameter("actionValue", value).execute();

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

			logger.info("Method : deleteVendorContacts ends");
			return response;
		}
	 
	  public ResponseEntity<JsonResponse<Object>> deleteBankDetails(String id, String simpleid, String vendorId,
				String createdBy,String orgName, String orgDiv) {
			logger.info("Method : deleteBankDetails starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					/*
					 * String value = "SET @P_ModifiedBy='" + createdBy + "',@P_Id='" + simpleid +
					 * "',@vendorId='" + vendorId + "', @P_bankId='(" + id + ")';";
					 */
					
					String value = "SET @P_ModifiedBy='" + createdBy + "',@P_Id='" + simpleid + "',@vendorId='" + vendorId
							+ "', @P_bankId='(" + id + ")',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
					em.createNamedStoredProcedureQuery("vendorMasterRoutines").setParameter("actionType", "deleteBankDetails")
							.setParameter("actionValue", value).execute();

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

			logger.info("Method : deleteBankDetails ends");
			return response;
		}
	  
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<VendorMasterModel>> editVendorById(String id,String orgName, String orgDiv) {
		logger.info("Method : editVendorById starts");

		JsonResponse<VendorMasterModel> resp = new JsonResponse<VendorMasterModel>();
		List<VendorMasterModel> newVendor = new ArrayList<VendorMasterModel>();

		try {
			String value = "SET @P_vendorId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		 logger.info("value===="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "editVendor").setParameter("actionValue", value).getResultList();
			Object sDate = null;
			Object establishDate = null;
			for (Object[] m : x) {

				if (m[7] != null) {
					sDate = m[7].toString();
				}
				if (m[10] != null) {
					establishDate = m[10].toString();
				}
				/*
				 * Object Date = null; if (m[8] != null) { Date =
				 * DateFormatter.returnStringDate(m[8]); }
				 */

				VendorMasterModel vendorMasterModel = new VendorMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6].toString(),
						sDate, m[8], m[9], null, null, null, null, null, null, null, null, null, null, establishDate,
						m[11], m[12], m[13], m[14],null,null,m[15],m[16],m[17],m[18],m[19],m[20]);
				newVendor.add(vendorMasterModel);
			}
			resp.setBody(newVendor.get(0));
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

		ResponseEntity<JsonResponse<VendorMasterModel>> response = new ResponseEntity<JsonResponse<VendorMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : editVendorById ends"+response);

		return response;
	}
	//isExistVendorMobileNumber
	@SuppressWarnings("unchecked")
	public Boolean isExistVendorMobileNumber(String mob,String id,String type) {
		logger.info("Method : isExistVendorMobileNumber Dao starts");

		Boolean isExist = false;

		List<DropDownModel> dataList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_mob='" + mob + "',@p_id='" + id + "',@p_type='" + type + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "vendor_mob_exist").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				dataList.add(dropDownModel);
			}
			if (dataList != null) {
				isExist = true;
			}
			if (dataList.size() > 0) {
				isExist = true;
			} else {
				isExist = false;
			}
		} catch (Exception e) {
			isExist = false;
		}
		logger.info("Method : isValidEmployeeNumber Dao ends");
		return isExist;
	}
	//isExistVendorEmail
	@SuppressWarnings("unchecked")
	public Boolean isExistVendorEmail(String email,String id,String type) {
		logger.info("Method : isExistVendorEmail Dao starts");
		
		Boolean isExist = false;
		
		List<DropDownModel> dataList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_email='" + email + "',@p_id='" + id + "',@p_type='" + type + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "vendor_email_exist").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				dataList.add(dropDownModel);
			}
			if (dataList != null) {
				isExist = true;
			}
			if (dataList.size() > 0) {
				isExist = true;
			} else {
				isExist = false;
			}
		} catch (Exception e) {
			isExist = false;
		}
		logger.info("Method : isExistVendorEmail Dao ends");
		return isExist;
	}
	//isExistUserMobileNumber
	@SuppressWarnings("unchecked")
	public Boolean isExistUserMobileNumber(String mob,String type) {
		logger.info("Method : isExistUserMobileNumber Dao starts");
		
		Boolean isExist = false;
		
		List<DropDownModel> dataList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_mob='" + mob + "',@p_type='" + type + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "user_mob_exist").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				dataList.add(dropDownModel);
			}
			if (dataList != null) {
				isExist = true;
			}
			if (dataList.size() > 0) {
				isExist = true;
			} else {
				isExist = false;
			}
		} catch (Exception e) {
			isExist = false;
		}
		logger.info("Method : isExistUserMobileNumber Dao ends");
		return isExist;
	}
	//isExistUserEmail
	@SuppressWarnings("unchecked")
	public Boolean isExistUserEmail(String email,String type) {
		logger.info("Method : isExistUserEmail Dao starts");
		
		Boolean isExist = false;
		
		List<DropDownModel> dataList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_email='" + email + "',@p_type='" + type + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "user_email_exist").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				dataList.add(dropDownModel);
			}
			if (dataList != null) {
				isExist = true;
			}
			if (dataList.size() > 0) {
				isExist = true;
			} else {
				isExist = false;
			}
		} catch (Exception e) {
			isExist = false;
		}
		logger.info("Method : isExistUserEmail Dao ends");
		return isExist;
	}
//
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<VendorContactMasterModel>> saveVendorContactMaster(
			VendorContactMasterModel vendorContactMasterModel) {
		logger.info("Method : saveVendorMaster starts");

		Boolean validity = true;
		JsonResponse<VendorContactMasterModel> resp = new JsonResponse<VendorContactMasterModel>();
		resp.setMessage("");
		resp.setCode("");

		List<VendorContactMasterModel> newVendor = new ArrayList<VendorContactMasterModel>();

		if (vendorContactMasterModel.getContactName() == null || vendorContactMasterModel.getContactName() == "") {
			resp.setMessage("Contact Name Required");
			validity = false;
		} else if (vendorContactMasterModel.getPhone() == null || vendorContactMasterModel.getPhone() == "") {
			resp.setMessage("Mobile Number Required");
			validity = false;

		} else if (vendorContactMasterModel.getEmail() == null || vendorContactMasterModel.getEmail() == "") {
			resp.setMessage("Email Required");
			validity = false;
		} 
		Boolean mob;
		Boolean email;
		if (vendorContactMasterModel.getContactId() != null && vendorContactMasterModel.getContactId() != "") {
			 mob=isExistVendorMobileNumber(vendorContactMasterModel.getPhone(),vendorContactMasterModel.getContactId(),"modify");
			 email=isExistVendorEmail(vendorContactMasterModel.getEmail(),vendorContactMasterModel.getContactId(),"modify");
				if (vendorContactMasterModel.getPrimaryStatusContact()=="1" || vendorContactMasterModel.getPrimaryStatusContact().contentEquals("1")) {
					mob=isExistUserMobileNumber(vendorContactMasterModel.getPhone(),"modify");
					email=isExistUserEmail(vendorContactMasterModel.getEmail(),"modify");	
				}
		}else {
			 mob=isExistVendorMobileNumber(vendorContactMasterModel.getPhone(),vendorContactMasterModel.getContactId(),"add");	
			 email=isExistVendorEmail(vendorContactMasterModel.getEmail(),vendorContactMasterModel.getContactId(),"add");	
		}
		if(email) {
			resp.setMessage("Email already exists");
			validity = false;
		}
		if(mob) {
			resp.setMessage("Mobile number already exists");
			validity = false;
		}
		if (validity)
			try {
				String values = GenerateVendorMasterParameter.saveVendorContactMaster(vendorContactMasterModel);
                      logger.info("@@@@@@@@@@@@@@@@@@@@@#$%^" +values);
				if (vendorContactMasterModel.getContactId() != null && vendorContactMasterModel.getContactId() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
							.setParameter("actionType", "modifyContact").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						Object sDate = null;
						if (m[10] != null) {
							sDate = DateFormatter.returnStringDate(m[10]);
						}

						VendorContactMasterModel vendorContactMasterModelData = new VendorContactMasterModel(m[0], m[1],
								m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], sDate, m[11],null,null);
						newVendor.add(vendorContactMasterModelData);
					}
				} else {
logger.info("dddddddddddd"+values);
					List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
							.setParameter("actionType", "addContact").setParameter("actionValue", values)
							.getResultList();
					   logger.info("#################@@@@@@@@@#$%^" +values);
					for (Object[] m : x) {
						Object sDate = null;
						
						if (m[10] != null) {
							sDate = DateFormatter.returnStringDate(m[10]);
						}

						VendorContactMasterModel vendorContactMasterModelData = new VendorContactMasterModel(m[0], m[1],
								m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], sDate, m[11],m[12],m[13]);
						newVendor.add(vendorContactMasterModelData);
					}
				}
				resp.setBody(newVendor.get(0));
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
		ResponseEntity<JsonResponse<VendorContactMasterModel>> response = new ResponseEntity<JsonResponse<VendorContactMasterModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveVendorLocationMaster ends"+response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<VendorContactMasterModel>>> getVendorContact(String id,String orgName, String orgDiv) {
		logger.info("Method : getVendorContact starts");

		List<VendorContactMasterModel> viewVendorContact = new ArrayList<VendorContactMasterModel>();

		try {
		
			String value = "SET @p_vendorId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
logger.info("value contact===="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "viewVendorContact").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[10] != null) {
					sDate = m[10].toString();
				}

				VendorContactMasterModel vendorContactMasterModelData = new VendorContactMasterModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], sDate, m[11],null,null);
				viewVendorContact.add(vendorContactMasterModelData);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<VendorContactMasterModel>> resp = new JsonResponse<List<VendorContactMasterModel>>();
		resp.setBody(viewVendorContact);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<VendorContactMasterModel>>> response = new ResponseEntity<JsonResponse<List<VendorContactMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getVendorContact ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<VendorContactMasterModel>> editVendorContactById(String id,String orgName, String orgDiv) {
		logger.info("Method : editVendorContactById starts");

		JsonResponse<VendorContactMasterModel> resp = new JsonResponse<VendorContactMasterModel>();
		List<VendorContactMasterModel> viewVendorContact = new ArrayList<VendorContactMasterModel>();

		try {

			String value = "SET @P_contactId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "editContact").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[10] != null) {
					sDate = DateFormatter.returnStringDate(m[10]);
				}

				VendorContactMasterModel vendorContactMasterModelData = new VendorContactMasterModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], sDate, null,null,null);
				viewVendorContact.add(vendorContactMasterModelData);
			}
			resp.setBody(viewVendorContact.get(0));
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

		ResponseEntity<JsonResponse<VendorContactMasterModel>> response = new ResponseEntity<JsonResponse<VendorContactMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : editVendorContactById ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDocumentTypeList() {
		logger.info("Method : getDocumentTypeList starts");

		List<DropDownModel> documentTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "getDocumentTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				documentTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCategoryList ends");
		return documentTypeList;
	}
 

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeBankDetailsRestModel>>> saveemployeebankdetailsVendor(
			ManageEmployeeBankDetailsRestModel manageEmployeeBankDetailsRestModel) {
		logger.info("Method : saveemployeebankdetails starts");
		
		Boolean validity = true;
		JsonResponse<List<ManageEmployeeBankDetailsRestModel>> resp = new JsonResponse<List<ManageEmployeeBankDetailsRestModel>>();
		/*
		 * resp.setMessage(""); resp.setCode("");
		 */

		List<ManageEmployeeBankDetailsRestModel> saveemployeebankdetails = new ArrayList<ManageEmployeeBankDetailsRestModel>();

		if (manageEmployeeBankDetailsRestModel.getEbankName() == null
				|| manageEmployeeBankDetailsRestModel.getEbankName() == "") {
			resp.setMessage("E Bank Name");
			validity = false;
		} else if (manageEmployeeBankDetailsRestModel.getEbankAddress() == null
				|| manageEmployeeBankDetailsRestModel.getEbankAddress() == "") {
			resp.setMessage("E Address");
			validity = false;

			/*
			 * } else if (manageEmployeeBankDetailsRestModel.getEbankCity() == null ||
			 * manageEmployeeBankDetailsRestModel.getEbankCity() == "") {
			 * resp.setMessage("E city"); validity = false;
			 * 
			 * } else if (manageEmployeeBankDetailsRestModel.getEbankState() == null ||
			 * manageEmployeeBankDetailsRestModel.getEbankState() == "") {
			 * resp.setMessage("E city"); validity = false;
			 * 
			 * } else if (manageEmployeeBankDetailsRestModel.getEbankCountry() == null ||
			 * manageEmployeeBankDetailsRestModel.getEbankCountry() == "") {
			 * resp.setMessage("E Country"); validity = false;
			 */
		} else if (manageEmployeeBankDetailsRestModel.getEbankAccountNo() == null
				|| manageEmployeeBankDetailsRestModel.getEbankAccountNo() == "") {
			resp.setMessage("E Bank Account Number");
			validity = false;
		} else if (manageEmployeeBankDetailsRestModel.geteIfic() == null
				|| manageEmployeeBankDetailsRestModel.geteIfic() == "") {
			resp.setMessage("E IFSC");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateemployeemasterParameter
						.saveemployeebankdetails(manageEmployeeBankDetailsRestModel);
			

				if (manageEmployeeBankDetailsRestModel.getEbankId() != null
						&& manageEmployeeBankDetailsRestModel.getEbankId() != "") {

					List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
							.setParameter("actionType", "modifyBank").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ManageEmployeeBankDetailsRestModel saveemployeebankdetailsssss = new ManageEmployeeBankDetailsRestModel(
								m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], null, m[9], null, null, null,
								null,null,null,null);
						saveemployeebankdetails.add(saveemployeebankdetailsssss);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
							.setParameter("actionType", "addBankDetails").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ManageEmployeeBankDetailsRestModel saveemployeebankdetailsssss = new ManageEmployeeBankDetailsRestModel(
						  m[0], m[1], m[2],null, m[3], m[4], null, m[5], null, m[6], null, m[7], m[8], m[9],
						m[10],m[11],null,null);
						 saveemployeebankdetails.add(saveemployeebankdetailsssss);
					}
				}

				resp.setBody(saveemployeebankdetails);

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

		ResponseEntity<JsonResponse<List<ManageEmployeeBankDetailsRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeBankDetailsRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveemployeedependent ends"+response);

		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeBankDetailsRestModel>>> viewVendorBankDetails(String id,String orgName, String orgDiv) {
		logger.info("Method : viewVendorBankDetails starts");
		List<ManageEmployeeBankDetailsRestModel> manageEmployeeBankDetailsRestModel = new ArrayList<ManageEmployeeBankDetailsRestModel>();
		try {
			
			String value = "SET @p_vendorId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "viewVendorBank").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object sDate = null;
				if (m[9] != null) {
					sDate = m[9].toString();
				}
				ManageEmployeeBankDetailsRestModel saveemployeebankdetailsssss = new ManageEmployeeBankDetailsRestModel(
						m[0], m[1], m[2], null, m[3], m[4], null, m[5], null, m[6], null, m[7], m[8], sDate, m[10],null,null,null);
				manageEmployeeBankDetailsRestModel.add(saveemployeebankdetailsssss);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ManageEmployeeBankDetailsRestModel>> resp = new JsonResponse<List<ManageEmployeeBankDetailsRestModel>>();
		resp.setBody(manageEmployeeBankDetailsRestModel);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeBankDetailsRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeBankDetailsRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewVendorBankDetails ends"+response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageEmployeeBankDetailsRestModel>> editVendorBankById(String id,String orgName, String orgDiv) {
		logger.info("Method : editVendorBankById starts");

		JsonResponse<ManageEmployeeBankDetailsRestModel> resp = new JsonResponse<ManageEmployeeBankDetailsRestModel>();
		List<ManageEmployeeBankDetailsRestModel> viewVendorBank = new ArrayList<ManageEmployeeBankDetailsRestModel>();

		try {

			//String value = "SET @P_bankId='" + id + "';";
			String value = "SET @P_bankId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "editBank").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				ManageEmployeeBankDetailsRestModel saveemployeebankdetailsssss = new ManageEmployeeBankDetailsRestModel(
						m[0], m[1], m[2], null, m[3], m[4], null, m[5], null, m[6], null, m[7], m[8], null, m[9],null,null,null);
				viewVendorBank.add(saveemployeebankdetailsssss);
			}
			resp.setBody(viewVendorBank.get(0));
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

		ResponseEntity<JsonResponse<ManageEmployeeBankDetailsRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeBankDetailsRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : editVendorBankById ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public List<ActivitylogModel> getActivityLogVendor(String id,String orgName, String orgDiv) {
		logger.info("Method : getActivityLog starts");
		List<ActivitylogModel> activitylogModelList = new ArrayList<ActivitylogModel>();
		try {
			//String value = "SET @p_vendorId='" + id + "'";
			String value = "SET @p_vendorId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "getActivityLogVendor").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[6] != null) {
					oa = m[6].toString();
				}
				ActivitylogModel activitylogModel = new ActivitylogModel(m[0], m[1], m[2], m[3], m[4], m[5], oa);
				activitylogModelList.add(activitylogModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getActivityLog ends");
		return activitylogModelList;
	}

	public ResponseEntity<JsonResponse<Object>> deleteVendor(String id,String createdBy,String simpleid,String orgName, String orgDiv) {
		logger.info("Method : deleteVendor starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				//String value = "SET @p_reqId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				String value = "SET @P_ModifiedBy='" + createdBy + "',@P_Id='" + simpleid + "', @P_VendorId='(" + id
						+ ")',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
logger.info("value 2 ==="+value);
				em.createNamedStoredProcedureQuery("vendorMasterRoutines").setParameter("actionType", "deleteVendor")
						.setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteVendor ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> createVendorWiseUser(VendorContactMasterModel id) {
		logger.info("Method : createVendorWiseUser starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setBody("");
		resp.setMessage("");
		resp.setCode("");
		Boolean mob=isExistUserMobileNumber(id.getPhone(),"add");
		Boolean email=isExistUserEmail(id.getEmail(),"add");	
		if(mob) {
			resp.setMessage("Mobile number already exists");
			validity = false;
		}
		if(email) {
			resp.setMessage("Email already exists");
			validity = false;
		}

		if (validity)
			try {
				String value = "SET @P_CreatedBy='" + id.getCreatedBy() + "',@P_ContactId='" + id.getContactId()
						+ "', @P_Vendorid='" + id.getVendorId() + "', @P_userName='" + id.getContactName()
						+ "', @P_Phone='" + id.getPhone() + "', @P_Email='" + id.getEmail() + "', @P_Pwd='"
						+ id.getPwd()+ "',@p_orgNameName='" + id.getOrganizationName() + "',@p_orgDiv='" + id.getOrganizationDivision() + "';";
logger.info("value======="+value);
				List<Object[]> x =em.createNamedStoredProcedureQuery("vendorMasterRoutines")
						.setParameter("actionType", "createVendorWiseUser").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
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
		logger.info("Method : createVendorWiseUser ends"+response);
		return response;
	}
 
	public ResponseEntity<JsonResponse<Object>> resetPasswordVendor(VendorContactMasterModel id) {
		logger.info("Method : resetPasswordVendor starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @P_CreatedBy='" + id.getCreatedBy() + "',@P_ContactId='" + id.getContactId()
						+ "', @P_Vendorid='" + id.getVendorId() + "', @P_Pwd='" + id.getPwd() + "',@p_orgNameName='" + id.getOrganizationName() + "',@p_orgDiv='" + id.getOrganizationDivision() + "';";

				em.createNamedStoredProcedureQuery("vendorMasterRoutines")
						.setParameter("actionType", "resetPasswordVendor").setParameter("actionValue", value).execute();

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
		logger.info("Method : resetPasswordVendor ends");
		return response;
	}

	/**
	 * @return a particular vendor by its id
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<VendorMasterModel>>> getVendorListByVendor(String vendorId,String orgName, String orgDiv) {
		logger.info("Method : getVendorListByVendor starts");

		List<VendorMasterModel> viewVendor = new ArrayList<VendorMasterModel>();

		try {
			String value = "SET @p_vendor='" + vendorId + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("value===1=="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "viewVendorById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object sDate = null;
				if (m[7] != null) {
					sDate = m[7].toString();
				}
				VendorMasterModel vendorMasterModel = new VendorMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6].toString(),
						sDate, m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], null, null, null, null,
						null, null, null, null,null,null,null,null,null,null,null,null);
				viewVendor.add(vendorMasterModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<VendorMasterModel>> resp = new JsonResponse<List<VendorMasterModel>>();
		resp.setBody(viewVendor);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<VendorMasterModel>>> response = new ResponseEntity<JsonResponse<List<VendorMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getVendorListByVendor ends");
		return response;
	}

	//for save documents
	public ResponseEntity<JsonResponse<VendorDocumentMaster>> addVendorDocument(
			VendorDocumentMaster VendorDocumentMaster) {
		logger.info("Method : addEmpDocument starts");

		JsonResponse<VendorDocumentMaster> resp = new JsonResponse<VendorDocumentMaster>();
		try {
			String value = GenerateVendorMasterParameter.getVendorOtherDocuments(VendorDocumentMaster);
			logger.info("value===" + value);
			if(VendorDocumentMaster.getDocumentId()=="" || VendorDocumentMaster.getDocumentId()==null) {
				em.createNamedStoredProcedureQuery("vendorMasterRoutines").setParameter("actionType", "addMultiDoc")
					.setParameter("actionValue", value).execute();
			}else {
				em.createNamedStoredProcedureQuery("vendorMasterRoutines").setParameter("actionType", "modifyMultiDoc")
				.setParameter("actionValue", value).execute();	
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<VendorDocumentMaster>> response = new ResponseEntity<JsonResponse<VendorDocumentMaster>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addEmpDocument ends");

		return response;
	}

	
	//view vendor documents
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<VendorDocumentMaster>>> viewVendorDocument(String id,
			String organization, String orgDivision) {
		logger.info("Method : viewvendordocument starts");

		List<VendorDocumentMaster> viewempdoc = new ArrayList<VendorDocumentMaster>();
		JsonResponse<List<VendorDocumentMaster>> resp = new JsonResponse<List<VendorDocumentMaster>>();

		try {

			String value = "SET @p_venderId='" + id + "',@p_orgName='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "viewvendordocument").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				VendorDocumentMaster viewVendorDoc = new VendorDocumentMaster(m[0], m[1], m[2],m[3], m[4], m[5]);
				viewempdoc.add(viewVendorDoc);
			}
			if (viewempdoc.size() > 0) {
				Util.setJsonResponse(resp, viewempdoc, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, viewempdoc, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		resp.setBody(viewempdoc);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<VendorDocumentMaster>>> response = new ResponseEntity<JsonResponse<List<VendorDocumentMaster>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("response==="+response);
		logger.info("Method : viewedocument ends");
		return response;
	}
	// EDIT VRNDOR DOCUMENTS
@SuppressWarnings("unchecked")
public JsonResponse<VendorDocumentMaster> editDocumentDetails(String docid,String organization,String orgDivision){
	logger.info("Method : editDocumentDetails dao starts");

	VendorDocumentMaster req = new VendorDocumentMaster();
	JsonResponse<VendorDocumentMaster> resp = new JsonResponse<VendorDocumentMaster>();
	try {
		String value = "SET @p_docid='" + docid + "',@p_orgName='" + organization + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("value===="+value);

		List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
				.setParameter("actionType", "editDocumentDetails").setParameter("actionValue", value)
				.getResultList();
		for (Object[] m : x) {
			VendorDocumentMaster viewEmployeesss = new VendorDocumentMaster(m[0], m[1], m[2],
					m[3], m[4],m[5]);
			req = viewEmployeesss;

		}
		resp.setBody(req);
	} catch (Exception e) {
		e.printStackTrace();
	}
	logger.info("editDocumentDetails" + resp);
	logger.info("Method : editDocumentDetails dao ends");
	return resp;
}

//delete documents
	public ResponseEntity<JsonResponse<Object>> deleteVendorDoc(String docid,String organization, String orgDivision) {
		logger.info("Method : deleteEmpDoc starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_docid='" + docid + "',@p_orgName='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value===="+value);
			em.createNamedStoredProcedureQuery("vendorMasterRoutines").setParameter("actionType", "deleteVendorDoc")
					.setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
		} catch

		(Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteEmpDoc ends");
		return response;
	}

}
