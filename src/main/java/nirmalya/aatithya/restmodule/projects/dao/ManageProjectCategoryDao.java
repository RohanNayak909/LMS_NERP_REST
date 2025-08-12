package nirmalya.aatithya.restmodule.projects.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateManageProjectCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectSubContractorParameter;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;

@Repository
public class ManageProjectCategoryDao {
	Logger logger = LoggerFactory.getLogger(ManageProjectCategoryDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	public ResponseEntity<JsonResponse<Object>> saveCategoryDao(RestProjectCategoryModel category) {
		logger.info("Method : saveCategory Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateManageProjectCategoryParameter.getProjectCategoryParam(category);

			System.out.println("valuessss" + values);

			if (category.getCategoryId() == null || category.getCategoryId() == "") {

				em.createNamedStoredProcedureQuery("project_category_routines")
						.setParameter("actionType", "addCategory").setParameter("actionValue", values)
						.execute();
				System.out.println("if");
			} else {

				em.createNamedStoredProcedureQuery("project_category_routines")
						.setParameter("actionType", "modifyCategory").setParameter("actionValue", values)
						.execute();
				System.out.println("else");
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

		logger.info("Method : saveCategory Dao ends"+response);
		return response;
	}
	
	
	// FOR PROJECT CATEGORY DAO VIEW STARTS
		@SuppressWarnings("unchecked")

		public JsonResponse<Object> viewCategoryDao(String userid, String org,
				String div) {

			logger.info("Method : viewCategory Dao startssssssssssssssssssssss");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "';";
				logger.info("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("project_category_routines")
						.setParameter("actionType", "viewCategory").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : viewCategory Dao ends");
			logger.info("resp****************************" + resp);
			return resp;

		}

	// FOR Category  DELETE

		public ResponseEntity<JsonResponse<Object>> deleteCategoryDao(String id) {
			logger.info("Method : deleteCategoryDao starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {
					String value = "SET @p_categoryId='" + id + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("project_category_routines")
							.setParameter("actionType", "deleteCategory").setParameter("actionValue", value).execute();

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

			logger.info("Method : deleteCategoryDao ends");
			return response;
		}
    //Save sub category		
		public ResponseEntity<JsonResponse<Object>> savesubcategoryDao(RestProjectCategoryModel category) {
			logger.info("Method : savesubcategory Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String values = GenerateManageProjectCategoryParameter.getProjectSubCategoryParam(category);

				System.out.println("valuessss" + values);

				if (category.getSubcategoryId() == null || category.getSubcategoryId() == "") {

					em.createNamedStoredProcedureQuery("project_category_routines")
							.setParameter("actionType", "addSubCategory").setParameter("actionValue", values)
							.execute();
					System.out.println("if");
				} else {

					em.createNamedStoredProcedureQuery("project_category_routines")
							.setParameter("actionType", "modifySubCategory").setParameter("actionValue", values)
							.execute();
					System.out.println("else");
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

			logger.info("Method : savesubcategory Dao ends");
			return response;
		}
	//for view Sub Category	
		@SuppressWarnings("unchecked")

		public JsonResponse<Object> viewsubcategoryDao(String userid, String org,
				String div,String cdId) {

			
			logger.info("Method : viewCategory Dao startssssssssssssssssssssss"+cdId);

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_cdId='" + cdId + "';";
				logger.info("values****************************" + value); 
				List<Object[]> x = em.createNamedStoredProcedureQuery("project_category_routines")
						.setParameter("actionType", "viewSubCategory").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : viewCategory Dao ends");
			logger.info("resp****************************" + resp);
			return resp;

		}
		
		// FOR SubCategory  DELETE

				public ResponseEntity<JsonResponse<Object>> deleteSubCategoryDao(String id) {
					logger.info("Method : deleteSubCategory Dao starts");

					Boolean validity = true;
					JsonResponse<Object> resp = new JsonResponse<Object>();
					resp.setMessage("");
					resp.setCode("");

					if (validity)
						try {
							String value = "SET @p_subcategoryId='" + id + "';";
							System.out.println("IDD" + value);
							em.createNamedStoredProcedureQuery("project_category_routines")
									.setParameter("actionType", "deleteSubCategory").setParameter("actionValue", value).execute();

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

					logger.info("Method : deleteSubCategory Dao ends");
					return response;
				}		

}
