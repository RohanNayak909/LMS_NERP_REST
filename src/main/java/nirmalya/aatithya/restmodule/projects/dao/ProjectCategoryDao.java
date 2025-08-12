package nirmalya.aatithya.restmodule.projects.dao;

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
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProductCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;

@Repository
public class ProjectCategoryDao {
	Logger logger = LoggerFactory.getLogger(ProjectCategoryDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestProjectCategoryModel>> saveProjectCategory(RestProjectCategoryModel category) {
		logger.info("Method : saveProjectCategory starts");

		Boolean validity = true;
		JsonResponse<RestProjectCategoryModel> resp = new JsonResponse<RestProjectCategoryModel>();
		resp.setMessage("");
		resp.setCode("");

		List<RestProjectCategoryModel> newLoc = new ArrayList<RestProjectCategoryModel>();

		if (category.getCategoryName() == null || category.getCategoryName() == "") {
			resp.setMessage("Category Name Required");
			validity = false;
		} else if (category.getCategoryDesc() == null || category.getCategoryDesc() == "") {
			resp.setMessage("Category Description Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateProductCategoryParameter.saveProjectCategory(category);

				if (category.getCategoryId() != null && category.getCategoryId() != "") {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectCategoryRoutines")
							.setParameter("actionType", "modifyCategory").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						RestProjectCategoryModel item = new RestProjectCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], null, null);
						newLoc.add(item);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectCategoryRoutines")
							.setParameter("actionType", "addCategory").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						RestProjectCategoryModel item = new RestProjectCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], null, null);
						newLoc.add(item);
					}

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

		ResponseEntity<JsonResponse<RestProjectCategoryModel>> response = new ResponseEntity<JsonResponse<RestProjectCategoryModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveProjectCategory ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestProjectCategoryModel>> saveProjectSubCategory(RestProjectCategoryModel category) {
		logger.info("Method : saveProjectSubCategory starts");
		
		Boolean validity = true;
		JsonResponse<RestProjectCategoryModel> resp = new JsonResponse<RestProjectCategoryModel>();
		resp.setMessage("");
		resp.setCode("");
		
		List<RestProjectCategoryModel> newLoc = new ArrayList<RestProjectCategoryModel>();
		
		if (category.getCategoryName() == null || category.getCategoryName() == "") {
			resp.setMessage("Category Name Required");
			validity = false;
		} else if (category.getCategoryDesc() == null || category.getCategoryDesc() == "") {
			resp.setMessage("Category Description Required");
			validity = false;
		}
		
		if (validity)
			try {
				String values = GenerateProductCategoryParameter.saveProjectCategory(category);
				
				if (category.getCategoryId() != null && category.getCategoryId() != "") {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectCategoryRoutines")
							.setParameter("actionType", "modifyCategory").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						
						RestProjectCategoryModel item = new RestProjectCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], null, null);
						newLoc.add(item);
					}
				} else {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectCategoryRoutines")
							.setParameter("actionType", "addSubCategory").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						
						RestProjectCategoryModel item = new RestProjectCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], null, null);
						newLoc.add(item);
					}
					
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
		
		ResponseEntity<JsonResponse<RestProjectCategoryModel>> response = new ResponseEntity<JsonResponse<RestProjectCategoryModel>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveProjectSubCategory ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> getAllProjectCategoryList() {
		logger.info("Method : getAllProjectCategoryList starts");
		
		JsonResponse<List<RestProjectCategoryModel>> resp = new JsonResponse<List<RestProjectCategoryModel>>();
		List<RestProjectCategoryModel> newLoc = new ArrayList<RestProjectCategoryModel>();
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectCategoryRoutines")
					.setParameter("actionType", "getPCategoryList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				RestProjectCategoryModel item = new RestProjectCategoryModel(m[0], m[1], null, null, m[2], null, m[3], m[4], m[5]);
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
		
		ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> response = new ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getAllProjectCategoryList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> getProjectCategoryListById(String id) {
		logger.info("Method : getProjectCategoryListById starts");
		
		JsonResponse<List<RestProjectCategoryModel>> resp = new JsonResponse<List<RestProjectCategoryModel>>();
		List<RestProjectCategoryModel> newLoc = new ArrayList<RestProjectCategoryModel>();
		
		try {
			String value = "SET @P_ParentID='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectCategoryRoutines")
					.setParameter("actionType", "getPCategoryListById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestProjectCategoryModel item = new RestProjectCategoryModel(m[0], m[1], null, null, m[2], null, m[3], m[4], m[5]);
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
		
		ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> response = new ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getProjectCategoryListById ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestProjectCategoryModel>> getProjectCategoryById(String id) {
		logger.info("Method : getProjectCategoryById starts");
		
		JsonResponse<RestProjectCategoryModel> resp = new JsonResponse<RestProjectCategoryModel>();
		List<RestProjectCategoryModel> newLoc = new ArrayList<RestProjectCategoryModel>();
		
		try {
			String value = "SET @P_PCategory='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectCategoryRoutines")
					.setParameter("actionType", "getPCategoryById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				
				RestProjectCategoryModel item = new RestProjectCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], null);
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
		
		ResponseEntity<JsonResponse<RestProjectCategoryModel>> response = new ResponseEntity<JsonResponse<RestProjectCategoryModel>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getProjectCategoryById ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteCategory(String id, String createdBy) {
		logger.info("Method : deleteCategory starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_PCat='" + id + "', @P_ModifiedBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("ProjectCategoryRoutines").setParameter("actionType", "deleteCategory")
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
		logger.info("Method : deleteCategory ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> getProjectCategoryDataListModal() {
		logger.info("Method : getProjectCategoryDataListModal starts");

		JsonResponse<List<RestProjectCategoryModel>> resp = new JsonResponse<List<RestProjectCategoryModel>>();
		List<RestProjectCategoryModel> yearList = new ArrayList<RestProjectCategoryModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectCategoryRoutines")
					.setParameter("actionType", "getprojectCategoryList").setParameter("actionValue", "")
					.getResultList();
			for (Object[] m : x) {

				RestProjectCategoryModel item = new RestProjectCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				yearList.add(item);

				// System.out.println("getAllItemList" +yearList);
			}
			resp.setBody(yearList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> response = new ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getProjectCategoryDataListModal ends");
		// System.out.println(response);
		return response;
	}
}
