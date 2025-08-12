package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateDemoCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestDemoTreeModel;

@Repository
public class DemoTreeDao {
	
	Logger logger = LoggerFactory.getLogger(DemoTreeDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	

	public ResponseEntity<JsonResponse<RestDemoTreeModel>> saveDemoCategory(RestDemoTreeModel category) {
		logger.info("Method : saveDemoCategory starts");

		Boolean validity = true;
		JsonResponse<RestDemoTreeModel> resp = new JsonResponse<RestDemoTreeModel>();
		resp.setMessage("");
		resp.setCode("");

		
		if (category.getDemoName() == null || category.getDemoName() == "") {
			resp.setMessage(" Name Required");
			validity = false;
		} else if (category.getDemoDesc()== null || category.getDemoDesc() == "") {
			resp.setMessage(" Description Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateDemoCategoryParameter.saveDemoCategory(category);

				if (category.getDemoId() != null && category.getDemoId() != "") {
					
					 em.createNamedStoredProcedureQuery("demoCategoryRoutines")
							.setParameter("actionType", "modifyDemoCategory").setParameter("actionValue", values)
							.getResultList();
					/*
					 * for (Object[] m : x) {
					 * 
					 * RestDemoTreeModel item = new RestDemoTreeModel(m[0], m[1], m[2], m[3], m[4],
					 * m[5], m[6],null,null); newLoc.add(item); }
					 */
				} else {

					 em.createNamedStoredProcedureQuery("demoCategoryRoutines")
							.setParameter("actionType", "addDemoCategory").setParameter("actionValue", values)
							.getResultList();
					/*
					 * for (Object[] m : x) {
					 * 
					 * RestDemoTreeModel item = new RestDemoTreeModel(m[0], m[1], m[2], m[3], m[4],
					 * m[5], m[6],null,null); newLoc.add(item); }
					 */

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

		ResponseEntity<JsonResponse<RestDemoTreeModel>> response = new ResponseEntity<JsonResponse<RestDemoTreeModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveDemoCategory ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDemoTreeModel>>> getAllDemoCategoryList() {
		logger.info("Method : getAllDemoCategoryList starts");
		
		JsonResponse<List<RestDemoTreeModel>> resp = new JsonResponse<List<RestDemoTreeModel>>();
		List<RestDemoTreeModel> newLoc = new ArrayList<RestDemoTreeModel>();
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("demoCategoryRoutines")
					.setParameter("actionType", "getDemoCategory").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				RestDemoTreeModel item = new RestDemoTreeModel(m[0], m[1], null, null, m[2], null, m[3], m[4], m[5]);
				newLoc.add(item);
			}

			resp.setBody(newLoc);
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
		
		ResponseEntity<JsonResponse<List<RestDemoTreeModel>>> response = new ResponseEntity<JsonResponse<List<RestDemoTreeModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getAllDemoCategoryList ends");
		return response;
	}
	

	public ResponseEntity<JsonResponse<RestDemoTreeModel>> saveDemoSubCategory(RestDemoTreeModel category) {
		logger.info("Method : saveDemoSubCategory starts");
		
		Boolean validity = true;
		JsonResponse<RestDemoTreeModel> resp = new JsonResponse<RestDemoTreeModel>();
		resp.setMessage("");
		resp.setCode("");
		
		
		
		if (category.getDemoName() == null || category.getDemoName() == "") {
			resp.setMessage(" Name Required");
			validity = false;
		} else if (category.getDemoDesc()== null || category.getDemoDesc() == "") {
			resp.setMessage(" Description Required");
			validity = false;
		}
		
		if (validity)
			try {
				String values =  GenerateDemoCategoryParameter.saveDemoCategory(category);
				
				if (category.getDemoId() != null && category.getDemoId() != "") {
					
					em.createNamedStoredProcedureQuery("demoCategoryRoutines")
							.setParameter("actionType", "modifyDemoCategory").setParameter("actionValue", values)
							.getResultList();
					
				} else {
					
					 em.createNamedStoredProcedureQuery("demoCategoryRoutines")
							.setParameter("actionType", "addDemoSubCategory").setParameter("actionValue", values)
							.getResultList();
						
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
		
		ResponseEntity<JsonResponse<RestDemoTreeModel>> response = new ResponseEntity<JsonResponse<RestDemoTreeModel>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveDemoSubCategory ends");
		return response;
	}
	

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestDemoTreeModel>> editDemoCategoryById(String id) {
		logger.info("Method : editDemoCategoryById starts");
		
		JsonResponse<RestDemoTreeModel> resp = new JsonResponse<RestDemoTreeModel>();
		List<RestDemoTreeModel> newLoc = new ArrayList<RestDemoTreeModel>();
		
		try {
			String value = "SET @p_demoId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("demoCategoryRoutines")
					.setParameter("actionType", "getPDemoCategoryById").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				
				RestDemoTreeModel item = new RestDemoTreeModel(m[0], m[1], m[2], m[3], m[4],null, m[5], m[6], null);
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
		
		ResponseEntity<JsonResponse<RestDemoTreeModel>> response = new ResponseEntity<JsonResponse<RestDemoTreeModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : editDemoCategoryById ends");
		return response;
	}
	public ResponseEntity<JsonResponse<Object>> deleteDemoCategory(String id, String createdBy) {
		logger.info("Method : deleteDemoCategory starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_demoId='" + id + "', @P_ModifiedBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("demoCategoryRoutines").setParameter("actionType", "deleteDemoCategory")
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
		logger.info("Method : deleteDemoCategory ends");
		return response;
	}

}
