package nirmalya.aatithya.restmodule.employee.dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeResignationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestEmployeeResignationDocModel;
import nirmalya.aatithya.restmodule.employee.model.RestEmployeeResignationModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestEmployeeResignationDao {
	
	Logger logger = LoggerFactory.getLogger(RestEmployeeResignationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@Autowired
	private EnvironmentVaribles env;
	
	// employee list
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeLists(String orgName, String orgDivision) {
		logger.info("Method : getEmployeeLists starts");

		List<DropDownModel> emplist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
					.setParameter("actionType", "getEmployeeLists").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				emplist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace(); 
		}

		logger.info("Method : getEmployeeLists ends");
		return emplist;
	}
	
	
	// employee list cc
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeListsCC(String orgName, String orgDivision,String managerId,String userId) {
		logger.info("Method : getEmployeeListsCC starts");
		
		List<DropDownModel> emplist = new ArrayList<DropDownModel>();
		
		try {
			String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\",@p_managerId=\"" + managerId + "\",@p_userId=\"" + userId + "\";";

			System.out.println("value>>>"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
					.setParameter("actionType", "getEmployeeListsCC").setParameter("actionValue",value).getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				emplist.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getEmployeeListsCC ends");
		return emplist;
	}
	
	// employee list TO Lists for mobile
			@SuppressWarnings("unchecked")
			public JsonResponse<List<DropDownModel>> getEmployeeListsToMobile(String orgName, String orgDivision) {
				logger.info("Method : getEmployeeListsToMobile starts");
				
				List<DropDownModel> emplist = new ArrayList<DropDownModel>();
				
				JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
				
				try {
					String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\";";
					List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
							.setParameter("actionType", "getEmployeeLists").setParameter("actionValue",value).getResultList();

					for (Object[] m : x) {
						DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
						emplist.add(dropDownModel);
					}
					
					if(emplist.size()>0) {
						Util.setJsonResponse(resp, emplist, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
					}else {
						Util.setJsonResponse(resp, emplist, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
					}
				} catch (Exception e) {
					e.printStackTrace();
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				}
				
				logger.info("Method : getEmployeeListsToMobile ends");
				return resp;
			}
	
	// employee list cc for mobile
		@SuppressWarnings("unchecked")
		public JsonResponse<List<DropDownModel>> getEmployeeListsCCMobile(String orgName, String orgDivision,String managerId,String userId) {
			logger.info("Method : getEmployeeListsCC starts");
			
			List<DropDownModel> emplist = new ArrayList<DropDownModel>();
			
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
			
			try {
				String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\",@p_managerId=\"" + managerId + "\",@p_userId=\"" + userId + "\";";

				List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
						.setParameter("actionType", "getEmployeeListsCC").setParameter("actionValue",value).getResultList();
				
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					emplist.add(dropDownModel);
				}
				
				if(emplist.size()>0) {
					Util.setJsonResponse(resp, emplist, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
				}else {
					Util.setJsonResponse(resp, emplist, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			logger.info("Method : getEmployeeListsCC ends");
			return resp;
		}
		
		
		// view Resignation Draft
		@SuppressWarnings("unchecked")
		public JsonResponse<List<RestEmployeeResignationModel>> viewResignationDraft(String userId,String organization,String orgDivision) {

			logger.info("Method : viewResignationDraft Dao starts");
			List<RestEmployeeResignationModel> viewregapply = new ArrayList<RestEmployeeResignationModel>();
			JsonResponse<List<RestEmployeeResignationModel>> resp = new JsonResponse<List<RestEmployeeResignationModel>>();
			try {

				String value = "SET @p_empId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
				
				logger.info("value==="+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
						.setParameter("actionType", "viewResignationDraft").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {

					Object ResignDATE = null;
					if (m[7] != null) {
						ResignDATE = m[7].toString();
					}
					Object ReleaseDATE = null;
					if (m[8] != null) {
						ReleaseDATE = m[8].toString();
					}
					
					RestEmployeeResignationModel reg = new RestEmployeeResignationModel(m[0],null,m[1],m[2],m[3],m[4],m[5],m[6],ResignDATE,ReleaseDATE,m[9],m[10],m[11],m[12],m[13]);
					
					viewregapply.add(reg);
					
					
					
					}
				if(viewregapply.size()>0) {
					Util.setJsonResponse(resp, viewregapply, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
				}else {
					Util.setJsonResponse(resp, viewregapply, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
				}
				} catch (Exception e) {
					logger.error("viewResignationDraft: "+e.getMessage());
					Util.setJsonResponse(resp, viewregapply, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				e.printStackTrace();
			}
			logger.info("Method : viewResignationDraft Dao ends");
			return resp;

		}		
		
		
		//edit Resignation apply Draft
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editResignationApplyDraft(String id, String org, String orgDiv) {

			logger.info("Method : editResignationApplyDraft Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {

				String value = "SET @p_resignationDraftId='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
				
				System.out.println("value>>**>>>>>"+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
						.setParameter("actionType", "editResignationApplyDraft").setParameter("actionValue", value).getResultList();

				
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
				}catch (Exception e) {
					e.printStackTrace();
					
					String[] err = serverDao.errorProcedureCall(e);
					
					System.err.println(err[0]);
					System.err.println(err[1]);
					
					Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			}
			
			logger.info("Method : editResignationApplyDraft Dao ends");
			return resp;

		}
		
		//delete Resignation apply details
		
		public JsonResponse<Object> deleteResignationApply(String id, String organization, String orgDivision) {
			logger.info("Method : deleteResignationApply starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {

				String value = "SET @p_resignationId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
				
				em.createNamedStoredProcedureQuery("resignationRoutines").setParameter("actionType", "deleteResignationApply")
						.setParameter("actionValue", value).execute();
				
				Util.setJsonResponse(resp, null, ResponseStatus.success, "Resignation Deleted Successfully.");

			}catch (Exception e) {
			    try {
			        String[] err = serverDao.errorProcedureCall(e);
			        resp.setCode(err[0]);

			            Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

			    } catch (Exception e1) {
			        e1.printStackTrace();
			    }
			    e.printStackTrace();
			}
			logger.info("Method : deleteResignationApply ends");
			return resp;
		}


		//Resign Add Draft
			@SuppressWarnings({ "unused" })
			public ResponseEntity<JsonResponse<RestEmployeeResignationModel>> resignationApplyDraftDao(
					RestEmployeeResignationModel restEmployeeResignationModel) {

				logger.info("Method : resignationApplyDraftDao starts");
				boolean validation = true;
				RestEmployeeResignationModel listData = new RestEmployeeResignationModel();
				
				JsonResponse<RestEmployeeResignationModel> resp = new JsonResponse<RestEmployeeResignationModel>();
				JSONObject json = new JSONObject();
				
					try {
						
						String resignEmployee = restEmployeeResignationModel.getEmpId();
						
						if (restEmployeeResignationModel.getDocumentList().size() > 0) {
							for (RestEmployeeResignationDocModel a : restEmployeeResignationModel.getDocumentList()) {

								
								String[] x = a.getFileName().split("\\.");
								String extension = x[x.length - 1];
								for (String s1 : a.getDocumentFile()) {
									if (s1 != null) {
										try {
											byte[] bytes = Base64.getDecoder().decode(s1);
											json = saveAllMediaDocuments(bytes, extension, resignEmployee);

										} catch (Exception e) {
											e.printStackTrace();
										}
										a.setDocumentURL(json.getString("fileurl"));
									}
								}
							}
						}

						
						String value = GenerateEmployeeResignationParameter.getEmployeeResignationParam(restEmployeeResignationModel);
						
						if (restEmployeeResignationModel.getResignationDraftId().equals("")|| restEmployeeResignationModel.getResignationDraftId().equals(null) ) {
							
							em.createNamedStoredProcedureQuery("resignationRoutines")
									.setParameter("actionType", "resignationApplyDraft").setParameter("actionValue", value)
									.execute();
							
							Util.setJsonResponse(resp, null, ResponseStatus.success, "Resignation Drafted Successfully.");
							
						}else {
							
							em.createNamedStoredProcedureQuery("resignationRoutines")
							.setParameter("actionType", "modifyResignationApplyDraft").setParameter("actionValue", value)
							.execute();
							
							
							Util.setJsonResponse(resp, null, ResponseStatus.success, "Resignation Modified Successfully.");
						}
					} catch (Exception e) {
						try {
							String[] err = serverDao.errorProcedureCall(e);
							resp.setCode(err[0]);
							resp.setMessage(err[1]);
							
							System.err.println(err[0]);
							System.err.println(err[1]);
							
							if(err[1].equals("Employee already has a resignation against this Employee ID.") || err[1].equals("Duplicate entry 'x' for  'tbl_employee_exit.TEE_EmployeeName'")) {
								Util.setJsonResponse(resp, null, ResponseStatus.duplicate, "A resignation has already been submitted for this employee.");
							}else {
								Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
							}
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						e.printStackTrace();
					}
				resp.setBody(listData);
				ResponseEntity<JsonResponse<RestEmployeeResignationModel>> response = new ResponseEntity<JsonResponse<RestEmployeeResignationModel>>(
						resp, HttpStatus.CREATED);

				
				logger.info("Method : resignationApplyDraftDao ends");
				return response;

			}
			
//Resign Add Direct Submit
	@SuppressWarnings({ "unused" })
	public ResponseEntity<JsonResponse<RestEmployeeResignationModel>> resignationApplyDao(
			RestEmployeeResignationModel restEmployeeResignationModel) {

		logger.info("Method : resignationApplyDao starts");
		boolean validation = true;
		JsonResponse<RestEmployeeResignationModel> resp = new JsonResponse<RestEmployeeResignationModel>();
		JSONObject json = new JSONObject();
		String resignEmployee = restEmployeeResignationModel.getEmpId();
		
		if (restEmployeeResignationModel.getDocumentList().size() > 0) {
			for (RestEmployeeResignationDocModel a : restEmployeeResignationModel.getDocumentList()) {
				String[] x = a.getFileName().split("\\.");
				String extension = x[x.length - 1];
				for (String s1 : a.getDocumentFile()) {
					if (s1 != null) {
						try {
							byte[] bytes = Base64.getDecoder().decode(s1);
							json = saveAllMediaDocuments(bytes, extension, resignEmployee);

						} catch (Exception e) {
							e.printStackTrace();
						}
						a.setDocumentURL(json.getString("fileurl"));
					}
				}
			}
		}
		
		String value = GenerateEmployeeResignationParameter.getEmployeeResignationParam(restEmployeeResignationModel);
			try {
				
				if (restEmployeeResignationModel.getResignationDraftId() == "" || restEmployeeResignationModel.getResignationDraftId() == null) {
				
					
					
					em.createNamedStoredProcedureQuery("resignationRoutines")
							.setParameter("actionType", "resignationApply").setParameter("actionValue", value)
							.execute();
					Util.setJsonResponse(resp, null, ResponseStatus.success, "Resignation Submitted Successfully.");
					
				}else {
					
					
					em.createNamedStoredProcedureQuery("resignationRoutines")
					.setParameter("actionType", "modifyResignationApply").setParameter("actionValue", value)
					.execute();
					
					
					Util.setJsonResponse(resp, null, ResponseStatus.success, "Resignation Submitted Successfully.");

				}
				} catch (Exception e) {
					try {
						String[] err = serverDao.errorProcedureCall(e);
						resp.setCode(err[0]);
						resp.setMessage(err[1]);
						
						System.err.println(err[0]);
						System.err.println(err[1]);
						
						if(err[1].equals("Employee already has a resignation against this Employee ID.") || err[1].equals("Duplicate entry 'x' for  'tbl_employee_exit.TEE_EmployeeName'")) {
							Util.setJsonResponse(resp, null, ResponseStatus.duplicate, "A resignation has already been submitted for this employee.");
						}else {
							Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
		ResponseEntity<JsonResponse<RestEmployeeResignationModel>> response = new ResponseEntity<JsonResponse<RestEmployeeResignationModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : resignationApplyDao ends");
		return response;

	}
	
	//Method for mail API
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getMailDetails(String mylist) {
		logger.info("Method : getMailDetails starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_id='" + mylist + "';";
				
				List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
						.setParameter("actionType", "getEmailLists").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					//DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					resp.setBody(m[1]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getMailDetails ends");
		return response;
	}
	// view Resignation
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeResignationModel>> viewResignation(String userId ,String userRole) {

		logger.info("Method : viewResignation Dao starts");
		List<RestEmployeeResignationModel> viewregapply = new ArrayList<RestEmployeeResignationModel>();
		JsonResponse<List<RestEmployeeResignationModel>> resp = new JsonResponse<List<RestEmployeeResignationModel>>();
		try {

			String value = "SET @p_empId=\"" + userId + "\",@p_userRole='(" + userRole + ")';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
					.setParameter("actionType", "viewResignation").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object ResignDATE = null;
				if (m[7] != null) {
					ResignDATE = m[7].toString();
				}
				Object ReleaseDATE = null;
				if (m[8] != null) {
					ReleaseDATE = m[8].toString();
				}
				
				RestEmployeeResignationModel reg = new RestEmployeeResignationModel( null,m[0],m[1],m[2],m[3],m[4],m[5],m[6],ResignDATE,ReleaseDATE,m[9],m[10],m[11],m[12],m[13]);
				
				viewregapply.add(reg);
				resp.setBody(viewregapply);

				}
			} catch (Exception e) {
				logger.error("viewResignation: "+e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewResignation Dao ends");
		return resp;

	}
	/*
	 * Get Employee Name for choosen Js(Edit)
	 */
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>> getEmpName(String id,String org,String orgDiv) {
		logger.info("Method : getEmpName starts");
		List<DropDownModel> form = new ArrayList<DropDownModel>();

		try {
			
			String values = "SET @p_id='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
					.setParameter("actionType", "getEmpName").setParameter("actionValue", values).getResultList();
			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel sectionMaster = new DropDownModel(m[0], m[1]);
					form.add(sectionMaster);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<DropDownModel> servicemaster = new JsonResponse<DropDownModel>();
		servicemaster.setBody(form.get(0));

		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(
				servicemaster, HttpStatus.CREATED);
		logger.info("Method : getEmpName ends");
		return response;
	}
	//EmployeeAutoSearchForAttendance
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> employeeAutoSearch(String id,String org,String orgDiv) {
			logger.info("Method : employeeAutoSearch starts");
			List<DropDownModel> empNameList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
			String value = "SET @p_searchValue='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			
			System.out.println("value>>employeeAutoSearch>"+value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("resignationRoutines")
						.setParameter("actionType", "getEmpList").setParameter("actionValue", value)
						.getResultList();
				
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1],null,null);
					empNameList.add(dropDownModel);
				}
				
				if(empNameList.size()>0) {
					Util.setJsonResponse(resp, empNameList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
				}else {
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				
				String[] err = serverDao.errorProcedureCall(e);
				
				System.err.println(err[0]);
				System.err.println(err[1]);
				
				
				Util.setJsonResponse(resp, empNameList, ResponseStatus.failed, err[1]);
			}
			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			
			logger.info("Method : employeeAutoSearch ends");
			return response;
		}
		
		public JSONObject saveAllMediaDocuments(byte[] imageBytes, String ext, String user_id) {
			logger.info("Method : saveAllMedicalDocuments starts");

			String imageName = null;
			try {

				if (imageBytes != null) {
					long nowTime = new Date().getTime();

					if (ext.contentEquals("jpeg")) {
						imageName = user_id + "_" + nowTime + ".jpg";
					} else {
						imageName = user_id + "_" + nowTime + "." + ext;
					}
				}

				Path path = Paths.get(env.getFileUploadResignationUrl() + imageName);
				if (imageBytes != null) {
					Files.write(path, imageBytes);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			String url = env.getMobileView() + "document/resign/" + imageName;

			JSONObject json = new JSONObject();

			try {
				json.put("filename", imageName);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				json.put("fileurl", url);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info("Method : saveAllMediaDocuments ends");
			return json;
		}

}
