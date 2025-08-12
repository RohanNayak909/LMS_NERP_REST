package nirmalya.aatithya.restmodule.projects.dao;

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
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectMonitoringParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.model.ProjectMonitoringRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectExecutionModel;

@Repository

public class ProjectMonitoringRestDao {

	Logger logger = LoggerFactory.getLogger(ProjectMonitoringRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	//***********************************PROJECT HEALTH CRUD STARTS************************************//

	// rest add monitoring control 
	public ResponseEntity<JsonResponse<Object>> addMonitoringControlDao(ProjectMonitoringRestModel monitoringControl) {
		logger.info("Method : restaddMonitoringControlDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateProjectMonitoringParameter.getprjMonitoringParam(monitoringControl);

			System.out.println("valuessss==" + values);

			if (monitoringControl.getSlnoId() == null || monitoringControl.getSlnoId() == "") {

				em.createNamedStoredProcedureQuery("project_monitoring_routines")
						.setParameter("actionType", "addprojectmonitoring").setParameter("actionValue", values)
						.execute();
			} else {

				em.createNamedStoredProcedureQuery("project_monitoring_routines")
						.setParameter("actionType", "modifyprojectmonitoring").setParameter("actionValue", values)
						.execute();
			}

		} catch

		(Exception e) {
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

		logger.info("Method : restaddMonitoringControlDao ends" + response);
		return response;
	}

	// view monitoring control

	@SuppressWarnings("unchecked")
	public JsonResponse<List<ProjectMonitoringRestModel>> viewMonitoringControlDao(String org, String orgDiv) {
		logger.info("Method : restViewMonitoringControlDao starts");

		List<ProjectMonitoringRestModel> viewMonitoringControl = new ArrayList<ProjectMonitoringRestModel>();

		JsonResponse<List<ProjectMonitoringRestModel>> resp = new JsonResponse<List<ProjectMonitoringRestModel>>();
		try {
			String value = "SET @p_OrganizationName='" + org + "',@p_OrganizationDivision='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("project_monitoring_routines")
					.setParameter("actionType", "viewprojectmonitoring").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				ProjectMonitoringRestModel restMonitoringControl = new ProjectMonitoringRestModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
						m[17], m[18], m[19], m[20], null, null, null);


				viewMonitoringControl.add(restMonitoringControl);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(viewMonitoringControl);
		logger.info("Method : restViewMonitoringControlDao ends" + viewMonitoringControl);
		return resp;
	}
	
	// edit monitoring control

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<ProjectMonitoringRestModel>> editMonitoringControlDao(String id) {
			logger.info("Method : restMonitoringControlEditDao starts");

			ProjectMonitoringRestModel req = new ProjectMonitoringRestModel();
			JsonResponse<ProjectMonitoringRestModel> resp = new JsonResponse<ProjectMonitoringRestModel>();

			try {
				String value = "SET @p_SlnoId='" + id + "';";
				System.out.println("@@@@@@@@@@@@@@@@@@@" + value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("project_monitoring_routines")
						.setParameter("actionType", "editprojectmonitoring").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : x) {

					ProjectMonitoringRestModel reqemp = new ProjectMonitoringRestModel(m[0], m[1], m[2],
							m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19], m[20], null, null, null);
					
					req = reqemp;

				}
				resp.setBody(req);
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

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<ProjectMonitoringRestModel>> response = new ResponseEntity<JsonResponse<ProjectMonitoringRestModel>>(
					resp, responseHeaders, HttpStatus.CREATED);
			logger.info("Method : restMonitoringControlEditDao ends" + req);
			return response;
		}
		
		// delete monitoring control

		public ResponseEntity<JsonResponse<Object>> deleteMonitoringControlDao(String id) {
			logger.info("Method : deleteMonitoringControlDao dao starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_SlnoId='" + id + "';";

					em.createNamedStoredProcedureQuery("project_monitoring_routines")
							.setParameter("actionType", "deleteprojectmonitoring").setParameter("actionValue", value)
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

			logger.info("Method : deleteMonitoringControlDao ends");
			System.out.println("DELETEE" + response);
			return response;
		}
		
		//***********************************PROJECT HEALTH CRUD ENDS************************************//
		
		//***********************************RUNNING PROJECT VIEW STARTS********************************//
		
		// project table view

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<ProjectMonitoringRestModel>>> viewProjectTblDao(String userid) {
			logger.info("Method : viewProjectTbl dao starts");
			List<ProjectMonitoringRestModel> respList = new ArrayList<ProjectMonitoringRestModel>();

			try {

				String value = "SET @p_userId='" + userid + "';";
				System.out.println("dddddddddddddddddddddddd" + value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("project_monitoring_routines")
						.setParameter("actionType", "viewprojectTable").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {

					ProjectMonitoringRestModel restProjectTbl = new ProjectMonitoringRestModel(m[0], m[1], m[2], m[3], m[4]);
					respList.add(restProjectTbl);

				}

				System.out.println("VIEW" + respList);

			} catch (Exception e) {

				e.printStackTrace();

			}

			JsonResponse<List<ProjectMonitoringRestModel>> resp = new JsonResponse<List<ProjectMonitoringRestModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<ProjectMonitoringRestModel>>> response = new ResponseEntity<JsonResponse<List<ProjectMonitoringRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			logger.info("Method : ViewProjectTbl dao ends");

			System.out.println("viewProjectTbl" + respList);
			return response;

		}
		
		//***********************************RUNNING PROJECT VIEW STARTS********************************//
		
		//***********************************FORECASTING CRUD STARTS**********************************//
		
		// rest add monitoring control forecasting
		
		public ResponseEntity<JsonResponse<Object>> addMonitoringControlForecastingDao(ProjectMonitoringRestModel monitoringControlforecasting) {
			logger.info("Method : rest addMonitoringControlForecastingDao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String values = GenerateProjectMonitoringParameter.getprjMonitoringParam(monitoringControlforecasting);

				System.out.println("Forecasting=========" + values);

				if (monitoringControlforecasting.getSlnoId4() == null || monitoringControlforecasting.getSlnoId4() == "") {

					em.createNamedStoredProcedureQuery("project_monitoring_routines")
							.setParameter("actionType", "addprojectforecasting").setParameter("actionValue", values)
							.execute();
				} else {

					em.createNamedStoredProcedureQuery("project_monitoring_routines")
							.setParameter("actionType", "modifyprojectforecasting").setParameter("actionValue", values)
							.execute();
				}

			} catch

			(Exception e) {
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

			logger.info("Method : rest addMonitoringControlForecastingDao ends" + response);
			return response;
		}
		
		// rest view monitoring control forecasting

		@SuppressWarnings("unchecked")
		public JsonResponse<List<ProjectMonitoringRestModel>> viewMonitoringControlForecastingDao(String org, String orgDiv) {
			logger.info("Method : rest viewMonitoringControlForecastingDao starts");

			List<ProjectMonitoringRestModel> viewMonitoringControlForecasting = new ArrayList<ProjectMonitoringRestModel>();

			JsonResponse<List<ProjectMonitoringRestModel>> resp = new JsonResponse<List<ProjectMonitoringRestModel>>();
			try {
				String value = "SET @p_OrganizationName='" + org + "',@p_OrganizationDivision='" + orgDiv + "';";

				List<Object[]> x = em.createNamedStoredProcedureQuery("project_monitoring_routines")
						.setParameter("actionType", "viewprojectforecasting").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : x) {

					ProjectMonitoringRestModel restMonitoringControlForecasting = new ProjectMonitoringRestModel(m[0], m[1], m[2],
							m[3], m[4], m[5]);


					viewMonitoringControlForecasting.add(restMonitoringControlForecasting);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			resp.setBody(viewMonitoringControlForecasting);
			logger.info("Method : rest viewMonitoringControlForecastingDao ends" + viewMonitoringControlForecasting);
			return resp;
		}
		
		// rest edit monitoring control forecasting

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<ProjectMonitoringRestModel>> editMonitoringControlForecastingDao(String id) {
					logger.info("Method : rest editMonitoringControlForecastingDao starts");

					ProjectMonitoringRestModel req = new ProjectMonitoringRestModel();
					JsonResponse<ProjectMonitoringRestModel> resp = new JsonResponse<ProjectMonitoringRestModel>();

					try {
						String value = "SET @p_SlnoId4='" + id + "';";
						System.out.println("@@@@@@@@@@@@@@@@@@@" + value);

						List<Object[]> x = em.createNamedStoredProcedureQuery("project_monitoring_routines")
								.setParameter("actionType", "editprojectforecasting").setParameter("actionValue", value)
								.getResultList();

						for (Object[] m : x) {

							ProjectMonitoringRestModel reqemp = new ProjectMonitoringRestModel(m[0], m[1], m[2],
									m[3], m[4], m[5]);
							
							req = reqemp;

						}
						resp.setBody(req);
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

					HttpHeaders responseHeaders = new HttpHeaders();
					responseHeaders.set("MyResponseHeader", "MyValue");

					ResponseEntity<JsonResponse<ProjectMonitoringRestModel>> response = new ResponseEntity<JsonResponse<ProjectMonitoringRestModel>>(
							resp, responseHeaders, HttpStatus.CREATED);
					logger.info("Method : rest editMonitoringControlForecastingDao ends" + req);
					return response;
				}
				
				// rest delete monitoring control forecasting

				public ResponseEntity<JsonResponse<Object>> deleteMonitoringControlForecastingDao(String id) {
					logger.info("Method : deleteMonitoringControlForecastingDao dao starts");
					
					// Print the 'id' parameter value to the console
				    System.out.println("Received ID for deletion: " + id);

					Boolean validity = true;
					JsonResponse<Object> resp = new JsonResponse<Object>();
					resp.setMessage("");
					resp.setCode("");

					if (validity)
						try {

							String value = "SET @p_SlnoId4='" + id + "';";
							logger.info("Method : deleteMonitoringControlForecastingDao dao starts");
							em.createNamedStoredProcedureQuery("project_monitoring_routines")
									.setParameter("actionType", "deleteprojectforecasting").setParameter("actionValue", value)
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

					logger.info("Method : deleteMonitoringControlForecastingDao ends");
					System.out.println("DELETEEEEEEEEEEEEE" + response);
					return response;
				}
				
				//***********************************FORECASTING CRUD ENDS**********************************//
				
				//***********************************CATCH UP CRUD STARTS**********************************//


				// rest add monitoring control catch up
								
				public JsonResponse<Object> restaddCatchUpDao(ProjectMonitoringRestModel projectManagementModel) {
					// TODO Auto-generated method stub
					Boolean validity = true;
					JsonResponse<Object> resp = new JsonResponse<Object>();
					if (validity)
						System.out.println("AAAAAAAAAAAAAA"+projectManagementModel.getCatchupId());
						try {
											
							if(projectManagementModel.getCatchupId()==null || projectManagementModel.getCatchupId()=="") {
								String values = GenerateProjectMonitoringParameter.addEvent(projectManagementModel);
								System.out.println("Model  :" + projectManagementModel);
								System.out.println("ADDDDDDDDDDD: " + values);
							em.createNamedStoredProcedureQuery("project_monitoring_routines").setParameter("actionType", "addCatchUp")
									.setParameter("actionValue", values).execute();
							}
							else
							{
								String values = GenerateProjectMonitoringParameter.modifyEvent(projectManagementModel);
								System.out.println("Model  :" + projectManagementModel);
								System.out.println("MODIFYY: " + values);
								em.createNamedStoredProcedureQuery("project_monitoring_routines").setParameter("actionType", "modifyCatchUp")
								.setParameter("actionValue", values).execute();
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
					return resp;
				}
				
				// rest view monitoring control catch up

				@SuppressWarnings("unchecked")
				public JsonResponse<List<ProjectMonitoringRestModel>> restviewCatchUpDao(String org, String orgDiv) {
					logger.info("Method : rest viewprojectCatchUpDao starts");

					List<ProjectMonitoringRestModel> viewCatchUpDao = new ArrayList<ProjectMonitoringRestModel>();

					JsonResponse<List<ProjectMonitoringRestModel>> resp = new JsonResponse<List<ProjectMonitoringRestModel>>();
					try {
						String value = "SET @p_OrganizationName='" + org + "',@p_OrganizationDivision='" + orgDiv + "';";

						List<Object[]> x = em.createNamedStoredProcedureQuery("project_monitoring_routines")
								.setParameter("actionType", "viewCatchUp").setParameter("actionValue", value)
								.getResultList();

						for (Object[] m : x) {

							ProjectMonitoringRestModel restviewCatchUpDao = new ProjectMonitoringRestModel(m[0], m[1], m[2],
									m[3],m[4],m[5],m[6],m[7]);


							viewCatchUpDao.add(restviewCatchUpDao);
							
							// Print the data for each iteration
				            System.out.println("Data added: " + restviewCatchUpDao);

						}
					} catch (Exception e) {
						e.printStackTrace();
					}

					resp.setBody(viewCatchUpDao);
					
					// Print the final data before returning the response
				    System.out.println("Final data: " + viewCatchUpDao);
				    
					logger.info("Method : rest viewprojectCatchUpDao ends" + viewCatchUpDao);
					return resp;
				}
				
				// rest edit monitoring control catch up

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<ProjectMonitoringRestModel>> resteditCatchUpDao(String id) {
					logger.info("Method : rest editCatchUpDao starts>>>>>>>>>>>");

					ProjectMonitoringRestModel req = new ProjectMonitoringRestModel();
					JsonResponse<ProjectMonitoringRestModel> resp = new JsonResponse<ProjectMonitoringRestModel>();

					try {
						String value = "SET @p_CatchUpId='" + id + "';";
						System.out.println("@@@@@@@@@@@@@@@@@@@" + value);

						List<Object[]> x = em.createNamedStoredProcedureQuery("project_monitoring_routines")
								.setParameter("actionType", "editCatchUp").setParameter("actionValue", value)
								.getResultList();

						for (Object[] m : x) {
							
							ProjectMonitoringRestModel reqemp = new ProjectMonitoringRestModel(m[0], m[1], m[2],
									m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10]);
							
							req = reqemp;

						}
						resp.setBody(req);
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

					HttpHeaders responseHeaders = new HttpHeaders();
					responseHeaders.set("MyResponseHeader", "MyValue");

					ResponseEntity<JsonResponse<ProjectMonitoringRestModel>> response = new ResponseEntity<JsonResponse<ProjectMonitoringRestModel>>(
							resp, responseHeaders, HttpStatus.CREATED);
					logger.info("Method : rest editCatchUpDao ends>>>>>>>>" + req);
					return response;
				}
				
				//delete 
				 
				public ResponseEntity<JsonResponse<Object>> restdeleteCatchUpDao(String id) {
				    logger.info("Method : restdeleteCatchUpDao starts");
				    
				 // Print the received 'id' parameter
				    System.out.println("Received ID: " + id);

				    Boolean validity = true;
				    JsonResponse<Object> resp = new JsonResponse<Object>();
				    resp.setMessage("");
				    resp.setCode("");

				    if (validity)
				        try {
				            String value = "SET @p_CatchUpId='" + id + "';";
				            em.createNamedStoredProcedureQuery("project_monitoring_routines").setParameter("actionType", "deleteCatchUp")
				                    .setParameter("actionValue", value).execute();

				        } catch (Exception e) {
				            try {
				                String[] err = serverDao.errorProcedureCall(e);
				                resp.setCode(err[0]);
				                resp.setMessage(err[1]);
				                
				                 System.out.println("Error in catch block: " + err[0] + " - " + err[1]);
				                 
				            } catch (Exception e1) {
				                e1.printStackTrace();
				            }
				            e.printStackTrace();
				        }

				    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				            HttpStatus.CREATED);

				    logger.info("Method : restdeleteCatchUpDao ends");
				    System.out.println("DELETEE" + response);
				    return response;
				}
				
				//***********************************CATCH UP CRUD ENDS**********************************//
				
				//***********************************NOTES CRUD STARTS**********************************//

				// rest add monitoring control 
				
				public ResponseEntity<JsonResponse<Object>> restaddNotesDao(ProjectMonitoringRestModel monitoringControlNotes) {
					logger.info("Method : rest restaddNotesDao starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String values = GenerateProjectMonitoringParameter.getprjMonitoringParam(monitoringControlNotes);

						System.out.println("Notes=========" + values);

						if (monitoringControlNotes.getNoteId() == null || monitoringControlNotes.getNoteId() == "") {

							em.createNamedStoredProcedureQuery("project_monitoring_routines")
									.setParameter("actionType", "addnotes").setParameter("actionValue", values)
									.execute();
						} else {

							em.createNamedStoredProcedureQuery("project_monitoring_routines")
									.setParameter("actionType", "modifynotes").setParameter("actionValue", values)
									.execute();
						}

					} catch

					(Exception e) {
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

					logger.info("Method : rest restaddNotesDao ends" + response);
					return response;
				}
				
				
				// rest view notes

				@SuppressWarnings("unchecked")
				public JsonResponse<List<ProjectMonitoringRestModel>> restviewNotesDao(String org, String orgDiv) {
					logger.info("Method : rest viewNotesDao starts");

					List<ProjectMonitoringRestModel> viewnotes = new ArrayList<ProjectMonitoringRestModel>();

					JsonResponse<List<ProjectMonitoringRestModel>> resp = new JsonResponse<List<ProjectMonitoringRestModel>>();
					try {
						String value = "SET @p_OrganizationName='" + org + "',@p_OrganizationDivision='" + orgDiv + "';";

						List<Object[]> x = em.createNamedStoredProcedureQuery("project_monitoring_routines")
								.setParameter("actionType", "viewnotes").setParameter("actionValue", value)
								.getResultList();

						for (Object[] m : x) {

							ProjectMonitoringRestModel restviewnotes = new ProjectMonitoringRestModel(m[0], m[1], m[2],
									m[3], m[4], m[5],null);


							viewnotes.add(restviewnotes);

						}
					} catch (Exception e) {
						e.printStackTrace();
					}

					resp.setBody(viewnotes);
					logger.info("Method : rest viewNotesDao ends" + viewnotes);
					return resp;
				}
				
				// rest edit notes

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<ProjectMonitoringRestModel>> resteditNotesDao(String id) {
					logger.info("Method : rest editNotesDao starts");

					ProjectMonitoringRestModel req = new ProjectMonitoringRestModel();
					JsonResponse<ProjectMonitoringRestModel> resp = new JsonResponse<ProjectMonitoringRestModel>();

					try {
						String value = "SET @p_NoteId='" + id + "';";
						System.out.println("@@@@@@@@@@@@@@@@@@@" + value);

						List<Object[]> x = em.createNamedStoredProcedureQuery("project_monitoring_routines")
								.setParameter("actionType", "editnotes").setParameter("actionValue", value)
								.getResultList();

						for (Object[] m : x) {

							ProjectMonitoringRestModel reqemp = new ProjectMonitoringRestModel(m[0], m[1], m[2],
									m[3], m[4], m[5],null);
							
							req = reqemp;

						}
						resp.setBody(req);
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

					HttpHeaders responseHeaders = new HttpHeaders();
					responseHeaders.set("MyResponseHeader", "MyValue");

					ResponseEntity<JsonResponse<ProjectMonitoringRestModel>> response = new ResponseEntity<JsonResponse<ProjectMonitoringRestModel>>(
							resp, responseHeaders, HttpStatus.CREATED);
					logger.info("Method : rest editNotesDao ends" + req);
					return response;
				}
				
				// rest delete notes

				public ResponseEntity<JsonResponse<Object>> restdeleteNotesDao(String id) {
					logger.info("Method : restdeleteNotes dao starts>>>>>>>>>");
					
					// Print the 'id' parameter value to the console
				    System.out.println("Received ID for deletion: " + id);

					Boolean validity = true;
					JsonResponse<Object> resp = new JsonResponse<Object>();
					resp.setMessage("");
					resp.setCode("");

					if (validity)
						try {

							String value = "SET @p_NoteId='" + id + "';";							
							
							em.createNamedStoredProcedureQuery("project_monitoring_routines")
									.setParameter("actionType", "deletenotes").setParameter("actionValue", value)
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

					logger.info("Method : restdeleteNotes dao ends>>>>>>>>>>>>>");
					System.out.println("DELETEEEEEEEEEEEEE" + response);
					return response;
				}
				
				//***********************************NOTES CRUD ENDS**********************************//
				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> getAllProjectMoniteringDetails(String id,
						String userid, String org, String div) {
					logger.info("Method : getAllProjectMoniteringDetails starts" + id);

					JsonResponse<List<RestProjectExecutionModel>> resp = new JsonResponse<List<RestProjectExecutionModel>>();
					List<RestProjectExecutionModel> newLoc = new ArrayList<RestProjectExecutionModel>();

					try {
						String value = "SET @p_projectId='" + id + "',@p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='"
								+ div + "';";

						System.out.println("EXECUTION" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("project_monitoring_routines")
								.setParameter("actionType", "viewprojectmonitoring").setParameter("actionValue", value)
								.getResultList();
						if (x.size() > 0) {
							for (Object[] m : x) {

								RestProjectExecutionModel item = new RestProjectExecutionModel(m[0], m[1], null, null, m[2], null,
										m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
										m[17], m[18], m[19], m[20], m[21],m[22],m[23],m[24],m[25],m[26],m[27]);
								newLoc.add(item);
							}

							resp.setBody(newLoc);
							resp.setCode("success");
							resp.setMessage("Data Fetched Successfully");
						} else {
							resp.setBody(newLoc);
							resp.setCode("success");
							resp.setMessage("No Data Found");
						}

					} catch (Exception e) {
						resp.setCode("failed");
						resp.setMessage(e.getMessage());
					}

					ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> response = new ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>>(
							resp, HttpStatus.CREATED);

					logger.info("Method : getAllProjectMoniteringDetails ends" + response.getBody());
					logger.info("Method : AAAAAAAAA" + response);
					return response;
				}
				
				// edit Parent

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<RestProjectExecutionModel>> getMonitorParentEdit(String id, String pid) {
					logger.info("Method : getMonitorParentEdit Dao starts" + id);

					JsonResponse<RestProjectExecutionModel> resp = new JsonResponse<RestProjectExecutionModel>();
					List<RestProjectExecutionModel> newLoc = new ArrayList<RestProjectExecutionModel>();

					try {
						String value = "SET @P_PCategory='" + id + "', @p_id='" + pid + "';";
						logger.info("baluew" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("project_monitoring_routines")
								.setParameter("actionType", "getMonitorParentEditDao").setParameter("actionValue", value).getResultList();
						for (Object[] m : x) {

							RestProjectExecutionModel item = new RestProjectExecutionModel(m[0],m[1],m[2],m[3].toString(),m[4].toString(),
									m[5].toString(),m[6].toString(),
									m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19],m[20]);
							newLoc.add(item);
						}

						resp.setBody(newLoc.get(0));
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

					ResponseEntity<JsonResponse<RestProjectExecutionModel>> response = new ResponseEntity<JsonResponse<RestProjectExecutionModel>>(
							resp, HttpStatus.CREATED);
					System.out.println(response);
					logger.info("Method : getMonitorParentEdit Dao ends");
					return response;
				}

				// edit Child

				
				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<RestProjectExecutionModel>> getMonitorChildEdit(String id, String pid,
						String userId, String orgName, String orgDiv) {
					logger.info("Method : getMonitorChildEdit Dao starts");

					RestProjectExecutionModel getLabDashboardcount = new RestProjectExecutionModel();
					JsonResponse<RestProjectExecutionModel> jsonResponse = new JsonResponse<RestProjectExecutionModel>();
					try {
						String value = "SET @P_PCategory='" + id + "', @p_id='" + pid + "', @p_userId='" + userId
								+ "', @p_orgName='" + orgName + "', @p_orgDiv='" + orgDiv + "' ;";
						logger.info("baluew" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("project_monitoring_routines")
								.setParameter("actionType", "getMonitorChildEdit").setParameter("actionValue", value).getResultList();
						for (Object[] m : x) {
							RestProjectExecutionModel item = new RestProjectExecutionModel(m[0],m[1],m[2],m[3].toString(),m[4].toString(),
									m[5].toString(),m[6].toString(),
									m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19],m[20]);
							System.out.println("labDashboardCountModel" + item);
							getLabDashboardcount = item;
						}
						jsonResponse.setBody(getLabDashboardcount);
						jsonResponse.setCode("success");
						jsonResponse.setMessage("Data Fetched Successfully");
					} catch (Exception e) {
						jsonResponse.setCode("failed");
						jsonResponse.setMessage(e.getMessage());
					}
					ResponseEntity<JsonResponse<RestProjectExecutionModel>> response = new ResponseEntity<JsonResponse<RestProjectExecutionModel>>(
							jsonResponse, HttpStatus.OK);
					logger.info("Method : getMonitorChildEdit Dao ends" + response);

					return response;
				}
}
