package nirmalya.aatithya.restmodule.employee.dao;

import java.util.ArrayList;
import java.util.Arrays;
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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateTravelManagementParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.TravelRequisitionRestModel;
import nirmalya.aatithya.restmodule.employee.model.TravelServiceRestModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.PushNotification;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class TravelRequsitionRestDao {

	Logger logger = LoggerFactory.getLogger(TravelRequsitionRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	PushNotification pushNotification = new PushNotification();
	 
	@SuppressWarnings("unchecked")
	public JsonResponse<List<TravelRequisitionRestModel>> viewTravelRequisition(String userId, String userRole,String organization,String orgDivision,String type,String selftype) {
		logger.info("Method : viewTravelRequisition dao starts");
		JsonResponse<List<TravelRequisitionRestModel>> resp = new JsonResponse<List<TravelRequisitionRestModel>>();
		List<TravelRequisitionRestModel> viewTravelRequisition = new ArrayList<TravelRequisitionRestModel>();
		try {
			String value = "SET @p_empId=\"" + userId + "\",@p_userRole='(" + userRole + ")',@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision + "\",@p_type=\"" + type + "\",@p_selfType=\"" + selftype + "\";";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
					.setParameter("actionType", "viewTravel").setParameter("actionValue", value).getResultList();
			if(x.size()>0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success,ApiResponseMessage.DATA_FETCH_SUCCESS);
			}else {
				Util.setJsonResponse(resp, x, ResponseStatus.success,ApiResponseMessage.NO_DATA_FOUND);
			}
			for (Object[] m : x) {
				Object sDate = null;
				if (m[7] != null) {
					sDate = DateFormatter.returnStringDate(m[7]);
				}
				Object Date = null;
				if (m[8] != null) {
					Date  = DateFormatter.returnStringDate(m[8]);
				}
				Object cDate = null;
				if (m[12] != null) {
					cDate  = DateFormatter.returnStringDate(m[12]);
				}
				/*
				 * double stringAmount = 0; if (m[5] != null) { stringAmount =
				 * Double.parseDouble(m[5].toString()); } 
				 */
				TravelRequisitionRestModel travelModel = new TravelRequisitionRestModel(m[0], m[1], m[2], m[3], m[4].toString(),m[5].toString(),
						m[6].toString(), sDate, Date, m[9],m[10], m[11],cDate,m[13],m[14],m[15],m[16].toString());
				viewTravelRequisition.add(travelModel);
			}

			if (viewTravelRequisition.size() > 0) {
				resp.setBody(viewTravelRequisition);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(viewTravelRequisition);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed,ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("viewReimbursement: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(viewTravelRequisition);
			resp.setCode("success");
			resp.setMessage(e.getMessage());
		}
		
		resp.setBody(viewTravelRequisition);
		logger.info("Method : viewTravelRequisition Dao ends");
		logger.info("VIEW+++++++++++++++++++++++++++++++++++++++++"+resp);
		return resp;
	}

	
	//add travel// 
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<TravelRequisitionRestModel>>> addTravel(
			TravelRequisitionRestModel travelModel) {
		
		logger.info("Method : addTravel dao starts"+travelModel);
		
		System.out.println("travelModel>>>"+travelModel);
		JsonResponse<List<TravelRequisitionRestModel>> resp = new JsonResponse<List<TravelRequisitionRestModel>>();
	
		String value = GenerateTravelManagementParam.getTravelRequisitionParam(travelModel);
			logger.info("value==="+value);
		try {
			if (travelModel.getTravelingReqId() != null && travelModel.getTravelingReqId() != "") {
				List<Object[]> x=entityManager.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "modifyTravel").setParameter("actionValue", value).getResultList();
				logger.info("value=================================="+x.get(0)[0].toString());
				 if(x.get(0)[0].toString()==null || x.get(0)[0].toString()=="" 
						 || x.get(0)[0].toString().equals(null) || x.get(0)[0].toString().equals("") ) {
							resp.setCode("success");
							resp.setMessage("Travel modified successfully");
						}else {
							resp.setCode("failed");
							resp.setMessage("Travel has already been applied for this employee on the selected date. Please choose a different date.");
						}
				
			} else {

				List<Object[]> x=entityManager.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "addTravel").setParameter("actionValue", value).getResultList();
				
				 if(x.get(0)[0].toString()==null || x.get(0)[0].toString()=="" 
						 || x.get(0)[0].toString().equals(null) || x.get(0)[0].toString().equals("") ) {
							resp.setCode("success");
							resp.setMessage("Travel Saved successfully");
							
							List<DropDownModel> managerByUesr = checkDuplicateDao.getManagerByUser(travelModel.getCreatedBy());
							 
							for(DropDownModel m : managerByUesr) {
								String msg=m.getName()+" apply for Travel";
								try {
									
									String msgId = pushNotification.pushFCMNotification(m.getKey(),msg);
									
								} catch (Exception e) {
									e.printStackTrace(); 
								}
							}
						}else {
							resp.setCode("failed");
							resp.setMessage("Travel has already been applied for this employee on the selected date. Please choose a different date.");
						}

			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed,err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		
		ResponseEntity<JsonResponse<List<TravelRequisitionRestModel>>> response = new ResponseEntity<JsonResponse<List<TravelRequisitionRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response==="+response);
		logger.info("Method : addTravel dao ends"+travelModel);
		return response;
		
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<TravelRequisitionRestModel>> getTravelEdit(String id) {
		logger.info("Method : getTravelEdit starts");

		JsonResponse<TravelRequisitionRestModel> resp = new JsonResponse<TravelRequisitionRestModel>();
		List<TravelRequisitionRestModel> getItem = new ArrayList<TravelRequisitionRestModel>();
		List<TravelServiceRestModel> itemattribute = new ArrayList<TravelServiceRestModel>();

		try {

			String value = "SET @p_reqId='" + id +  "';";
			System.out.println("value"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
					.setParameter("actionType", "getTravelEditNew").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				TravelRequisitionRestModel restPayroll = new TravelRequisitionRestModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5].toString(), m[6].toString(), m[7], m[8], m[9], m[10], m[11],m[12],m[13],m[14]);
				getItem.add(restPayroll);
				System.out.println("restPayroll"+restPayroll);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("getItem"+getItem);
		if (getItem.size() > 0) {
			try {
				String subValues = "SET @p_serviceId='" + id + "';";
				System.out.println("subValues>>>>" + subValues);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "getServiceData").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {
					TravelServiceRestModel dropDownModel = new TravelServiceRestModel(m[0], m[1], m[2].toString(),
							m[3], m[4], m[5], m[6]);
					itemattribute.add(dropDownModel);

				}
				getItem.get(0).setServicedtls(itemattribute);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		resp.setBody(getItem.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		if (resp.getBody().getTravelingReqId() != null) {
			resp.setCode("Success");
			resp.setMessage("Data fetched  succesfully");
		} else {
			resp.setCode("Failed");
			resp.setMessage("Data Not Found");
		}

		ResponseEntity<JsonResponse<TravelRequisitionRestModel>> response = new ResponseEntity<JsonResponse<TravelRequisitionRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		System.out.println("=====>>>>" + resp);
		logger.info("Method : getTravelEdit ends");
		return response;
	}
	//delete travel
 
	
	public ResponseEntity<JsonResponse<Object>> deleteTravel(TravelRequisitionRestModel travelModel) {
		logger.info("Method : deleteTravel dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateTravelManagementParam.getDeleteParam(travelModel);

			entityManager.createNamedStoredProcedureQuery("travelRequisitionRoutines")
					.setParameter("actionType", "deleteTravel").setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success,ApiResponseMessage.DELETE_DATA);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed,ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteTravel dao ends" + response);

		return response;
	}
	
	
	//approve Travel Requisition
	
	public JsonResponse<TravelRequisitionRestModel> approveRequisition(String id,String name,String comment,String roleid) {
		logger.info("Method : approveRequisition starts"+id+name+comment+roleid);

		if (comment != null) {
	        comment = comment.replace("'", "\\'");
	    }
		TravelRequisitionRestModel req = new TravelRequisitionRestModel();
		JsonResponse<TravelRequisitionRestModel> resp = new JsonResponse<TravelRequisitionRestModel>();

		try {
			String sanitizedComment = comment.replace("'", "''").replace("\"", "\\\"");
			String value = "SET @p_requisitionId='" + id + "',@p_approveBy='"+name+"',@p_comment='"+sanitizedComment+"',@p_userRole='(" + roleid + ")';";
			
			logger.info("value==="+value);
			em.createNamedStoredProcedureQuery("travelRequisitionRoutines").setParameter("actionType", "approveRequisition")
					.setParameter("actionValue", value).execute();
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Travel approved successfully");
			List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id,name);
			for(DropDownModel m : managerByUesr) {
				String msg=m.getName()+" approved your Travel";
				try {
					String msgId = pushNotification.pushFCMNotification(m.getKey(),msg);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				if(err[1].equals("Duplicate entry 'x' for  'tbl_approval_history.PRIMARY'")) {
					resp.setCode("failed");
					resp.setMessage("You are already travel approved");
				}else {
					resp.setCode("failed");
					resp.setMessage("Something went wrong");
				}
				// resp.setMessage(err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			logger.error("approveRequisition: "+e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : approveRequisition ends");
		return resp;
	}
	
	//reject Requisition
	
		public JsonResponse<TravelRequisitionRestModel> rejectRequisition(String id,String name,String comment,String roleid) {
			logger.info("Method : rejectRequisition starts");

			TravelRequisitionRestModel req = new TravelRequisitionRestModel();
			JsonResponse<TravelRequisitionRestModel> resp = new JsonResponse<TravelRequisitionRestModel>();

			try {
				String sanitizedComment = comment.replace("'", "''").replace("\"", "\\\"");
				String value = "SET @p_requisitionId='" + id + "',@p_rejectBy='"+name+"',@p_comment='"+sanitizedComment+"',@p_userRole='(" + roleid + ")';";
				em.createNamedStoredProcedureQuery("travelRequisitionRoutines").setParameter("actionType", "rejectRequisition")
						.setParameter("actionValue", value).execute();
				resp.setBody(req);
				resp.setCode("success");
				resp.setMessage("Travel rejected successfully");
				List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id,name);
				for(DropDownModel m : managerByUesr) {
					String msg=m.getName()+" rejected your Travel";
					try {
						String msgId = pushNotification.pushFCMNotification(m.getKey(),msg);
					} catch (Exception e) {
						e.printStackTrace(); 
					}
				}
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					if(err[1].equals("Duplicate entry 'x' for  'tbl_approval_history.PRIMARY'")) {
						resp.setCode("failed");
						resp.setMessage("You are already travel rejected");
					}else {
						resp.setCode("failed");
						resp.setMessage("Something went wrong");
					}
					// resp.setMessage(err[1]);
				} catch (Exception e1) {
					resp.setCode("failed");
					e1.printStackTrace();
					resp.setMessage("Something went wrong");
				}
				logger.error("rejectRequisition: "+e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : rejectRequisition ends");
			return resp;
		}
		//view travel api
		@SuppressWarnings("unchecked")
		public JsonResponse<List<TravelRequisitionRestModel>> viewTravelRequisitionApi(String userId,String organization,String orgDivision) {
			logger.info("Method : viewTravelRequisition dao starts");
			JsonResponse<List<TravelRequisitionRestModel>> resp = new JsonResponse<List<TravelRequisitionRestModel>>();
			List<TravelRequisitionRestModel> viewTravelRequisition = new ArrayList<TravelRequisitionRestModel>();
			try {
				String value = "SET @p_empId=\"" + userId + "\",@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision + "\";";
				logger.info("value==="+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "viewTravelApiForSelfView").setParameter("actionValue", value).getResultList();
				if(x.size()>0) {
					Util.setJsonResponse(resp, x, ResponseStatus.success,ApiResponseMessage.DATA_FETCH_SUCCESS);
				}else {
					Util.setJsonResponse(resp, x, ResponseStatus.success,ApiResponseMessage.NO_DATA_FOUND);
				}
				for (Object[] m : x) {
					Object sDate = null;
					if (m[7] != null) {
						sDate = DateFormatter.returnStringDate(m[7]);
					}
					Object Date = null;
					if (m[8] != null) {
						Date  = DateFormatter.returnStringDate(m[8]);
					}
					Object cDate = null;
					if (m[12] != null) {
						cDate  = DateFormatter.returnStringDate(m[12]);
					}
					TravelRequisitionRestModel travelModel = new TravelRequisitionRestModel(m[0], m[1], m[2], m[3], m[4],m[5].toString(),
							m[6].toString(), sDate, Date, m[9],m[10], m[11],cDate,m[13],m[14],m[15],m[16].toString());
					viewTravelRequisition.add(travelModel);
				}

				if (viewTravelRequisition.size() > 0) {
					resp.setBody(viewTravelRequisition);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} else {
					resp.setBody(viewTravelRequisition);
					resp.setCode("success");
					resp.setMessage("Data not found");
				}
			} catch (Exception e) {
				Util.setJsonResponse(resp, null, ResponseStatus.failed,ApiResponseMessage.UNKNOWN_EXCEPTION);
				logger.error("viewReimbursement: " + e.getMessage());
				e.printStackTrace();
				resp.setBody(viewTravelRequisition);
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
			
			resp.setBody(viewTravelRequisition);
			logger.info("Method : viewTravelRequisitionApi Dao ends");
			logger.info("VIEW"+resp);
			return resp;
		}
///Purpose List
	@SuppressWarnings("unchecked")
		public List<DropDownModel> purposeList() {
			logger.info("Method : purposeList starts");

			List<DropDownModel> purposeList = new ArrayList<DropDownModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "purposeList1").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					purposeList.add(dropDownModel);
				}
			

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : purposeList ends"+purposeList);
			return purposeList;
		}
		
		
//ServiceList
		@SuppressWarnings("unchecked")
		public List<DropDownModel> serviceList() {
			logger.info("Method : serviceList starts");

			List<DropDownModel> serviceList = new ArrayList<DropDownModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "serviceList1").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					serviceList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : serviceList ends"+serviceList);
			return serviceList;
		}
//
		@SuppressWarnings("unchecked")
		public JsonResponse<DropDownModel> getEmpData(String id) {
			
			logger.info("Method : getEmpData dao starts");
			DropDownModel req = new DropDownModel();
			JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
			
			String value = "SET @p_empId='" +id + "';";
			System.out.println("@@@@@@@@@@@@"+value);
			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "getEmpData").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel restaddress = new DropDownModel(m[0], m[1], m[2],m[3]);
					req = restaddress;

				}
				resp.setBody(req);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getEmpData dao ends"+resp);
			return resp;
		}
//EmployeeList
		
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getEmployeeList(String userId) {
			logger.info("Method : getEmployeeList starts");

			List<DropDownModel> getEmployeeList = new ArrayList<DropDownModel>();
			String value = "SET @P_userId='" +userId + "';";
			System.out.println("qqqqqqqqq"+value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
					getEmployeeList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getEmployeeList ends"+getEmployeeList);
			return getEmployeeList;
		}
//purposeList dropdown Api
		
		@SuppressWarnings("unchecked")
		public JsonResponse<List<DropDownModel>> getPurposeListApi() {
			logger.info("Method : getPurposeListApi starts");

			List<DropDownModel> getPurposeList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			try {
				//String value = "SET @p_organization='" + organization + "',@p_orgDivision='"
				//		+ orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "getPurposeList").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {

					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					getPurposeList.add(dropDownModel);
					System.out.println("getPurposeList-=="+getPurposeList);
				}
				if (getPurposeList.size() > 0) {
					Util.setJsonResponse(resp, getPurposeList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
					System.out.println("respresp===="+resp);
				} else {
					Util.setJsonResponse(resp, getPurposeList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error " + e.getMessage());
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}

			resp.setBody(getPurposeList);
			logger.info("Method : getPurposeList Dao ends");
			logger.info("VIEWRESP===="+resp);
			return resp;
		}
//getServiceListApi
		@SuppressWarnings("unchecked")
		public JsonResponse<List<DropDownModel>> getServiceListApi() {
			logger.info("Method : getServiceListApi starts");

			List<DropDownModel> getServiceList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			try {
				
				List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "getServiceListApi").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {

					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					getServiceList.add(dropDownModel);
					System.out.println("getServiceList-=="+getServiceList);
				}
				if (getServiceList.size() > 0) {
					Util.setJsonResponse(resp, getServiceList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
					System.out.println("respresp===="+resp);
				} else {
					Util.setJsonResponse(resp, getServiceList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error " + e.getMessage());
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}

			resp.setBody(getServiceList);
			logger.info("Method : getServiceListApi Dao ends");
			logger.info("VIEWRESP===="+resp);
			return resp;
		}
//EmpList DropDown
		@SuppressWarnings("unchecked")
		public JsonResponse<List<DropDownModel>> getempListApi(String userId) {
			logger.info("Method : getempListApi starts");

			List<DropDownModel> getEmpList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			try {
				String value = "SET @P_userId='" +userId + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "getempListApi").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {

					DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
					getEmpList.add(dropDownModel);
					System.out.println("getEmpList-=="+getEmpList);
				}
				if (getEmpList.size() > 0) {
					Util.setJsonResponse(resp, getEmpList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
					System.out.println("respresp===="+resp);
				} else {
					Util.setJsonResponse(resp, getEmpList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error " + e.getMessage());
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}

			resp.setBody(getEmpList);
			logger.info("Method : getempListApi Dao ends");
			logger.info("VIEWRESP===="+resp);
			return resp;
		}
//EmpData api
		@SuppressWarnings("unchecked")
		public JsonResponse<List<DropDownModel>>getempDataApi(String id) {
			logger.info("Method : getempDataApi starts");

			List<DropDownModel> getEmpData = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			try {
				String value = "SET @P_userId='" +id + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "getempDataApi").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {

					DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2],m[3]);
					getEmpData.add(dropDownModel);
					System.out.println("getEmpData-=="+getEmpData);
				}
				if (getEmpData.size() > 0) {
					Util.setJsonResponse(resp, getEmpData, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
					System.out.println("respresp===="+resp);
				} else {
					Util.setJsonResponse(resp, getEmpData, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error " + e.getMessage());
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}

			resp.setBody(getEmpData);
			logger.info("Method : getempDataApi Dao ends");
			logger.info("VIEWRESP===="+resp);
			return resp;
		}
//
		@SuppressWarnings("unchecked")
		public JsonResponse<List<TravelRequisitionRestModel>> viewTravelReqServiceOther(String id) {
			logger.info("Method : viewTravelClaimOther starts");
			List<TravelRequisitionRestModel> viewTravelClaim = new ArrayList<TravelRequisitionRestModel>();
			JsonResponse<List<TravelRequisitionRestModel>> resp = new JsonResponse<List<TravelRequisitionRestModel>>();
			try {
				String values = "SET @P_requisition='" + id + "';";
				logger.info("values@@@@=="+values);
				List<Object[]> x = entityManager.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "getReqServiceData").setParameter("actionValue", values).getResultList();
				if (x.size() > 0) {
					for (Object[] m : x) {
						
						Object date = null;
						if (m[2] != null) {
							date = DateFormatter.returnStringDate(m[2]);
							date = date.toString();
						}
						
						TravelRequisitionRestModel travelModel = new TravelRequisitionRestModel(null,null,null,null,null,null,null,
								null,null,null,null,null,null,null,null);
						viewTravelClaim.add(travelModel);
						Util.setJsonResponse(resp, viewTravelClaim, ResponseStatus.success,ApiResponseMessage.DATA_FETCH_SUCCESS);
						
					}
				}else {
					Util.setJsonResponse(resp, viewTravelClaim, ResponseStatus.failed, ApiResponseMessage.NO_DATA_FOUND);
				}
					

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("viewTravelReqServiceOther: "+e.getMessage());
			}
			resp.setBody(viewTravelClaim);
			logger.info("Method : viewTravelReqServiceOther ends");
			logger.info("viewTravelReqServiceOther resp===="+resp);
			return resp;
		}
//
		
		
		//EmployeeAutoSearchForAttendance
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> EmployeeAutoSearchForTravel(String id,String org,String orgDiv) {
			logger.info("Method : EmployeeAutoSearchForTravel starts");
			List<DropDownModel> empNameList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
			String value = "SET @p_searchValue='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("SRCHVALUE"+value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "getEmpListForTravel").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
					empNameList.add(dropDownModel);
				}
				resp.setBody(empNameList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : EmployeeAutoSearchForTravel ends");
			return response;
		}
		
}
