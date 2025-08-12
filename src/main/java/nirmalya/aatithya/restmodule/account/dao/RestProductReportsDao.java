package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping(value = { "account" })
public class RestProductReportsDao {
	Logger logger = LoggerFactory.getLogger(RestProductReportsDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPurchaseData(@RequestParam String fromDate, @RequestParam String toDate,@RequestParam String purchaseTypeId ,String orgName,String orgDivision) {
	    logger.info("Method in Dao: getPurchaseData starts");

	    JsonResponse<Object> resp = new JsonResponse<>();
        
	    String value= "";
	    value = "SET @p_fromDate='" +  DateFormatter.getStringDate(fromDate) + "', @p_toDate='" + DateFormatter.getStringDate(toDate) +"', @p_orgName='"+orgName+"', @p_orgDiv='"+orgDivision+"', @p_purchaseTypeId='"+purchaseTypeId+ "';";
	    
	    try {
	        
	        List<Object[]> result = em.createNamedStoredProcedureQuery("account_reports_routines")
	                                  .setParameter("actionType", "getPurchaseData")
	                                  .setParameter("actionValue",value)
	                                  .getResultList();
             
	        if (!result.isEmpty()) {
	            resp.setBody(result.get(0));
	            resp.setCode("success");
	            resp.setMessage("Data fetched successfully");
	        } else {
	            resp.setCode("no_data");
	            resp.setMessage("No data found");
	        }
	    } catch (Exception e) {
	        logger.error("Error occurred while fetching purchase data: ", e);
	        resp.setCode("failed");
	        resp.setMessage("Unable to fetch purchase data. Please try again later.");
	    }

	    logger.info("Method in Dao: getPurchaseData ends");

	    return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSalesData(@RequestParam String fromDate,String toDate,String salesTypeId,String orgName,String orgDiv) {
	    logger.info("Method in Dao: getSalesData starts");

	    JsonResponse<Object> resp = new JsonResponse<>();
	   
	    String value= "";
	    value = "SET @p_fromDate='" +  DateFormatter.getStringDate(fromDate) + "', @p_toDate='" + DateFormatter.getStringDate(toDate) + "', @p_salesTypeId='" +salesTypeId+ "', @p_orgname='" +orgName + "', @p_orgDiv='" +orgDiv + "';";
	    
	    logger.info("values--->" + value);
	    try {
	        
	        List<Object[]> result = em.createNamedStoredProcedureQuery("account_reports_routines")
	                                  .setParameter("actionType", "getSalesData")
	                                  .setParameter("actionValue",value)
	                                  .getResultList();
              
	        if (!result.isEmpty()) {
	            resp.setBody(result.get(0));
	            resp.setCode("success");
	            resp.setMessage("Data fetched successfully");
	        } else {
	            resp.setCode("no_data");
	            resp.setMessage("No data found");
	        }
	    } catch (Exception e) {
	        logger.error("Error occurred while fetching purchase data: ",e);
	        resp.setCode("failed");
	        resp.setMessage("Unable to fetch purchase data. Please try again later.");
	    }

	    logger.info("Method in Dao: getSalesData ends");

	    return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getFilterData(@RequestParam String type, String fromDate, String toDate,String purchaseTypeId,String salesTypeId) {
	    logger.info("Method in Dao: getFilterData starts");

	    JsonResponse<Object> resp = new JsonResponse<>();
	    String actionType = "";
        String value= "";
        
	           value = "SET @p_fromDate='" +  DateFormatter.getStringDate(fromDate) + "', @p_toDate='" + DateFormatter.getStringDate(toDate)+ "', @p_purchaseTypeId='" +purchaseTypeId + "', @p_salesTypeId='" +salesTypeId+ "';";
   
	    if ("Sales".equalsIgnoreCase(type)) {
	        actionType = "getSalesData";
	    } else if ("Purchase".equalsIgnoreCase(type)) {
	        actionType = "getPurchaseData";
	    } else {
	        resp.setCode("invalid_type");
	        resp.setMessage("Invalid type parameter. Must be 'sales' or 'purchase'.");
	        return resp;
	    }

	    try {
	        List<Object[]> result = em.createNamedStoredProcedureQuery("account_reports_routines")
	                                  .setParameter("actionType", actionType)
	                                  .setParameter("actionValue",value)
	                                  .getResultList();
	       
	        if (!result.isEmpty()) {
	            resp.setBody(result.get(0));
	            resp.setCode("success");
	            resp.setMessage("Data fetched successfully");
	        } else {
	            resp.setCode("no_data");
	            resp.setMessage("No data found");
	        }
	    } catch (Exception e) {
	        logger.error("Error occurred while fetching data: ", e);
	        resp.setCode("failed");
	        resp.setMessage("Unable to fetch data. Please try again later.");
	    }

	    logger.info("Method in Dao: getFilterData ends");

	    return resp;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> purchaseTypeList(String orgName,String orgDiv) {
		logger.info("Method in Dao: purchaseTypeList starts");
		List<DropDownModel> purchaseTypeList = new ArrayList<DropDownModel>();
		String value= "";
	    value = "SET @p_orgname='" +orgName + "', @p_orgDiv='" +orgDiv + "';";
	    


		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "purchaseTypeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				purchaseTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao : purchaseTypeList end");
		return purchaseTypeList;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategory() {
		logger.info("Method : getProductCategory starts");

		JsonResponse<List<ProductCategoryModel>> resp = new JsonResponse<List<ProductCategoryModel>>();
		List<ProductCategoryModel> yearList = new ArrayList<ProductCategoryModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getProductCategoryList").setParameter("actionValue", "")
					.getResultList();
			for (Object[] m : x) {

				ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				yearList.add(item);

			}
			resp.setBody(yearList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ProductCategoryModel>>> response = new ResponseEntity<JsonResponse<List<ProductCategoryModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getProductCategory ends");

		return response;
	}
	 
}
