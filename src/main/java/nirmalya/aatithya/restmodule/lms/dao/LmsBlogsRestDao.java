package nirmalya.aatithya.restmodule.lms.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.StringUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpSession;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

	@Repository
	public class LmsBlogsRestDao {
			Logger logger = LoggerFactory.getLogger(LmsBlogsRestDao.class);

			@Autowired
			EntityManager em;

			@Autowired
			ServerDao serverDao;
			
			@Autowired
			private EnvironmentVaribles env;
			
			
	//View
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewBlog(String orgName, String orgDivision) {
		logger.info("Method : viewBlog Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("blogs_report_routines")
					.setParameter("actionType", "viewBlog").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewBlog Dao ends");
		return resp;

	}
	// ADD
/*	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addBlog(Map<String, Object> blogJsonData) {
	    logger.info("Method : addBlog starts");

	    JsonResponse<Object> resp = new JsonResponse<>();


	    if (blogJsonData == null || blogJsonData.isEmpty()) {
	        resp.setCode("failed");
	        resp.setMessage("Blog data cannot be empty.");
	        return resp;
	    }

	    String orgName = (String) blogJsonData.get("orgName");
	    String orgDiv = (String) blogJsonData.get("orgDiv");
	    String blogId = (String) blogJsonData.get("blogId");
	    String blogTittle = (String) blogJsonData.get("blogTittle");
	    String authorName = (String) blogJsonData.get("authorName");
	    String createdById = (String) blogJsonData.get("createdById");
	    String category = (String) blogJsonData.get("category");
	    String industry = (String) blogJsonData.get("industry");
	    String publish = (String) blogJsonData.get("publish");
	    String keywords = (String) blogJsonData.get("keywords");
	    String shortDesc = (String) blogJsonData.get("shortDesc");
	    String blogDesc = (String) blogJsonData.get("blogDesc");
	    
	    
	    
 
	    String value = "SET @p_orgName='" + orgName + "', " +
	                   "@p_orgDiv='" + orgDiv + "', " +
	                   "@p_blogId='" + blogId + "', " +
	                   "@p_blogTittle='" + blogTittle + "', " +
	                   "@p_authorName='" + authorName + "', " +
	                   "@p_category='" + category + "', " +
	                   "@p_createdById='" + createdById + "', " +
	                   "@p_industry='" + industry + "', " +
	                   "@p_publish='" + publish + "', " +
	                   "@p_keywords='" + keywords + "', " +
	                   "@p_shortDesc='" + shortDesc + "', " +
	                   "@p_blogDesc='" + blogDesc + "';";

         System.out.println("Values For Blog Reocrd=======>>>>"+value);
	    if (StringUtil.isNull(blogId)) {
	    	
	        em.createNamedStoredProcedureQuery("blogs_report_routines")
	                .setParameter("actionType", "addBlog")
	                .setParameter("actionValue", value)
	                .execute();
	        resp.setCode("success");
	        resp.setMessage("Blog Details added successfully.");
	    } else {
	        
	            logger.info("Modifying an existing coupon record...");
	             em.createNamedStoredProcedureQuery("blogs_report_routines")
	                    .setParameter("actionType", "modifyBlog")
	                    .setParameter("actionValue", value)
	                    .execute();
	            resp.setCode("success");
	            resp.setMessage("BLog Details updated successfully.");
	        } 
	    

	    logger.info("Method : addCoupon ends");
	    return resp;
	}*/
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addBlog(Map<String, Object> blogJsonData) {
	    logger.info("Method : addBlog starts");

	    JsonResponse<Object> resp = new JsonResponse<>();

	    if (blogJsonData == null || blogJsonData.isEmpty()) {
	        resp.setCode("failed");
	        resp.setMessage("Blog data cannot be empty.");
	        return resp;
	    }

	    String orgName = (String) blogJsonData.get("orgName");
	    String orgDiv = (String) blogJsonData.get("orgDiv");
	    String blogId = (String) blogJsonData.get("blogId");
	    String blogTittle = (String) blogJsonData.get("blogTittle");
	    String authorName = (String) blogJsonData.get("authorName");
	    String createdById = (String) blogJsonData.get("createdById");
	    String category = (String) blogJsonData.get("category");
	    String industry = (String) blogJsonData.get("industry");
	    String publish = (String) blogJsonData.get("publish");
	    String keywords = (String) blogJsonData.get("keywords");
	    String shortDesc = (String) blogJsonData.get("shortDesc");
	    String blogDesc = (String) blogJsonData.get("blogDesc");

	    String documentName = (String) blogJsonData.get("documentName");
	    String documentContent = (String) blogJsonData.get("documentContent");

	    

	    String value = "SET @p_orgName='" + orgName + "', " +
	                   "@p_orgDiv='" + orgDiv + "', " +
	                   "@p_blogId='" + blogId + "', " +
	                   "@p_blogTittle='" + blogTittle + "', " +
	                   "@p_authorName='" + authorName + "', " +
	                   "@p_category='" + category + "', " +
	                   "@p_createdById='" + createdById + "', " +
	                   "@p_industry='" + industry + "', " +
	                   "@p_publish='" + publish + "', " +
	                   "@p_keywords='" + keywords + "', " +
	                   "@p_shortDesc='" + shortDesc + "', " +
	                   "@p_blogDesc='" + blogDesc + "', " +
	                   "@p_documentName='" + (documentName != null ? documentName : "") + "', " +
	                   "@p_documentContent='" + (documentContent != null ? documentContent : "") + "';";

	    System.out.println("Values For Blog Record =======>>>> " + value);

	    if (StringUtil.isNull(blogId)) {
	        em.createNamedStoredProcedureQuery("blogs_report_routines")
	                .setParameter("actionType", "addBlog")
	                .setParameter("actionValue", value)
	                .execute();
	        resp.setCode("success");
	        resp.setMessage("Blog Details added successfully.");
	    } else {
	        em.createNamedStoredProcedureQuery("blogs_report_routines")
	                .setParameter("actionType", "modifyBlog")
	                .setParameter("actionValue", value)
	                .execute();
	        resp.setCode("success");
	        resp.setMessage("Blog Details updated successfully.");
	    }

	    logger.info("Method : addBlog ends");
	    return resp;
	}

	//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editBlog(String orgName, String orgDiv,String blogId) {
		logger.info("Method : editBlog Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_blogId='"+blogId+"';";
			System.out.println("editBlog========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("blogs_report_routines")
					.setParameter("actionType", "editBlog").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : editBlog Dao ends"+resp);
		return resp;

	}
	//
 @SuppressWarnings("unchecked")
    public JsonResponse<Object> deletBlog(String blogId,String orgName, String orgDiv) {
        logger.info("Method : deletCoupon Dao starts");

        JsonResponse<Object> resp = new JsonResponse<Object>();

        try {
             
            String value = "SET @p_blogId='" + blogId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv + "';";
            System.out.println("deletBlog========>" + value);

            Object x = em.createNamedStoredProcedureQuery("blogs_report_routines")
                    .setParameter("actionType", "deletBlog").setParameter("actionValue", value)
                    .getSingleResult();
            System.out.println("value of x ------->>>>> "+x.toString());
            if(Integer.parseInt(x.toString()) > 0) {
				resp.setCode("success");
	  			resp.setMessage("Blog Details Deleted successfully");
  			}

        } catch (Exception e) {
            resp.setCode("failed");
            resp.setMessage(e.getMessage());
            e.printStackTrace();
        }

        logger.info("Method : deletBlog Dao ends" + resp);
        return resp;
    }			
}
