package nirmalya.aatithya.restmodule.projects.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import org.slf4j.LoggerFactory;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectCloseOut;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectCreationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModelNew;
import nirmalya.aatithya.restmodule.projects.model.CloseOutRestModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;
import nirmalya.aatithya.restmodule.user.model.RolesAccessModel;

@Repository
public class CloseOutRestDao {
	private static final org.springframework.http.HttpStatus HttpStatus = null;

	org.slf4j.Logger logger = LoggerFactory.getLogger(CloseOutRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

//for project dropdown

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getprojectList() {
		logger.info("Method : getprojectList starts");

		List<DropDownModel> getRequisitionList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("closeOutRoutines")
					.setParameter("actionType", "getprojectList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getprojectList ends");

		return getRequisitionList;
	}

	// for project drop down list
	@SuppressWarnings("unchecked")
	public List<CloseOutRestModel> viewProjectName(String id) {
		logger.info("Method : getProjectNameList starts");
		List<CloseOutRestModel> getProjectList = new ArrayList<CloseOutRestModel>();
		try {

			String values = "SET @p_getProjectId='" + id + "';";
			System.out.println("AAAAAAAAAAAAAAAAA" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("closeOutRoutines")
					.setParameter("actionType", "getProjectNameList").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					CloseOutRestModel dropDownModel = new CloseOutRestModel(m[0], m[1], m[2], m[3], m[4],null);
					getProjectList.add(dropDownModel);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr" + getProjectList);
		logger.info("Method : getProjectNameList ends");
		return getProjectList;
	}

	// view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CloseOutRestModel>>> viewCloseOut() {
		logger.info("Method : viewCloseOut  starts");
		List<CloseOutRestModel> respList = new ArrayList<CloseOutRestModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("closeOutRoutines")
					.setParameter("actionType", "viewCloseOut").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				CloseOutRestModel cusData = new CloseOutRestModel(m[0], m[1], m[2], m[3], m[4], m[5], null, null, null,
						null, null, null, null, null);
				respList.add(cusData);
			}
			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<CloseOutRestModel>> resp = new JsonResponse<List<CloseOutRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<CloseOutRestModel>>> response = new ResponseEntity<JsonResponse<List<CloseOutRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : viewCloseOut  ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}
	
	//CRUD Operation
	//add
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> restCloseOutadd(CloseOutRestModel CloseOut) {
			logger.info("Method : restaddCloseOutDao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String values = GenerateProjectCloseOut.getPrjCreateParam(CloseOut);

				if (CloseOut.getCloseOutId() == null || CloseOut.getCloseOutId() == "") {
					
					em.createNamedStoredProcedureQuery("closeOutRoutines")
							.setParameter("actionType", "addCloseOut").setParameter("actionValue", values).execute();
				} else {
					System.out.println("welcome to modify");

					em.createNamedStoredProcedureQuery("closeOutRoutines")
							.setParameter("actionType", "modifyCloseOut").setParameter("actionValue", values).execute();
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
			
			System.out.println("responseeeeeeeeee" + response);

			logger.info("Method : restaddCloseOutDao ends");
			return response;
		}
	
	// view

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<CloseOutRestModel>>> viewCloseOutLesson() {
			logger.info("Method : viewCloseOutLessonRest  starts");
			List<CloseOutRestModel> respList = new ArrayList<CloseOutRestModel>();
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("closeOutRoutines")
						.setParameter("actionType", "viewCloseOutLesson").setParameter("actionValue", "").getResultList();
				for (Object[] m : x) {
					CloseOutRestModel cusData = new CloseOutRestModel(m[0], m[1], m[2], m[3], m[4],m[5]);
					respList.add(cusData);
				}
				System.out.println("VIEW" + respList);

			} catch (Exception e) {

				e.printStackTrace();

			}

			JsonResponse<List<CloseOutRestModel>> resp = new JsonResponse<List<CloseOutRestModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<CloseOutRestModel>>> response = new ResponseEntity<JsonResponse<List<CloseOutRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			logger.info("Method : viewCloseOutLessonRest  ends");

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}

			System.out.println("VIEWWWWWWWW" + respList);
			return response;

		}
		
		// edit

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<CloseOutRestModel>>> editCloseOutLesson(String id) {
			logger.info("Method : restEditCloseOut starts");

			JsonResponse<List<CloseOutRestModel>> resp = new JsonResponse<List<CloseOutRestModel>>();
			List<CloseOutRestModel> newResp = new ArrayList<CloseOutRestModel>();

			try {
				String value = "SET @p_getProjectId='" + id + "';";
				System.out.println("@@@@@@@@@@@@@@@@@@@" + value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("closeOutRoutines")
						.setParameter("actionType", "editCloseOutLesson").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					
					CloseOutRestModel restCloseOutModule = new CloseOutRestModel(m[0], m[1], m[2], m[3], m[4],m[5]);
					newResp.add(restCloseOutModule);
					System.out.println("RestCloseOutModel" + restCloseOutModule);
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

			ResponseEntity<JsonResponse<List<CloseOutRestModel>>> response = new ResponseEntity<JsonResponse<List<CloseOutRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			logger.info("Method : restEditCloseOut ends");
			return response;
		}
		
		//delete
        
		@SuppressWarnings("static-access")
		public ResponseEntity<JsonResponse<Object>> deleteCloseOutLesson(String id) {
			logger.info("Method : deleteCloseOutDao starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_getProjectId='" + id + "';";

					em.createNamedStoredProcedureQuery("closeOutRoutines")
							.setParameter("actionType", "deleteCloseOutLesson").setParameter("actionValue", value).execute();

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

			logger.info("Method : deleteCloseOutDao ends");
			System.out.println("DELETEE" + response);
			return response;
		}
		
		//FOR COPY VIEW
		
		public ResponseEntity<JsonResponse<List<CloseOutRestModel>>> projectViewDataDao(String id) {
			logger.info("Method : projectViewDataDao starts");
			List<CloseOutRestModel> respList = new ArrayList<CloseOutRestModel>();

			try {
				String value = "SET @p_pId='" + id + "';";

				System.out.println("value------------------" + value);
				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("closeOutRoutines")
						.setParameter("actionType", "ViewProjectData").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					CloseOutRestModel cusData = new CloseOutRestModel(m[0], m[1], m[2], m[3],m[4]);
					respList.add(cusData);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<CloseOutRestModel>> resp = new JsonResponse<List<CloseOutRestModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<CloseOutRestModel>>> response = new ResponseEntity<JsonResponse<List<CloseOutRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			logger.info("Method : projectViewDataDao ends");
			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}
			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			System.out.println("VIEWWWWWWWW" + respList);
			return response;
		}
		
		//FOR COPY ADD
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<CloseOutRestModel>>> addProjectDataDao(List<CloseOutRestModel> model) {
			logger.info("Method : addProjectDataDao starts");

					JsonResponse<List<CloseOutRestModel>> resp = new JsonResponse<List<CloseOutRestModel>>();
					List<CloseOutRestModel> listData = new ArrayList<CloseOutRestModel>();

					try {
						String values = GenerateProjectCloseOut.getAddQuotParam(model);
						System.out.println(values);
						if (model.get(0).getCloseOutId() == "" || model.get(0).getCloseOutId() == null) {

							em.createNamedStoredProcedureQuery("closeOutRoutines")
									.setParameter("actionType", "addProjectData").setParameter("actionValue", values)
									.execute();
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
					resp.setBody(listData);
					ResponseEntity<JsonResponse<List<CloseOutRestModel>>> response = new ResponseEntity<JsonResponse<List<CloseOutRestModel>>>(
							resp, HttpStatus.CREATED);
					logger.info("Method : addProjectDataDao ends");
					return response;
		}

}
