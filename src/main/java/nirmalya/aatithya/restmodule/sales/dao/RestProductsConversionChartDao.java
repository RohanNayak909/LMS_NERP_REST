package nirmalya.aatithya.restmodule.sales.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateProductConversionParameter;
import nirmalya.aatithya.restmodule.sales.model.RestProductsConversionChartModel;

@Repository
public class RestProductsConversionChartDao {
	
	Logger logger = LoggerFactory.getLogger(RestProductsConversionChartDao.class);
	
	@Autowired
	EntityManager em;
	
	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public List<RestProductsConversionChartModel> getProductConversionList(String orgName, String orgDiv) {

		logger.info("Method : getProductConversionList starts");

		List<RestProductsConversionChartModel> productList = new ArrayList<RestProductsConversionChartModel>();

		try {
			String value = "SET  @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("value==>"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("sales_productConversionChart")
					.setParameter("actionType", "productList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestProductsConversionChartModel dropDownModel = new RestProductsConversionChartModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				productList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Product List--->" + productList);
		logger.info("Method : getProductConversionList ends");
		
		return productList;
	}
	
	public ResponseEntity<JsonResponse<Object>> restAddProductConversion(RestProductsConversionChartModel restProductsConversionChartModel) {

		logger.info("Method in Dao: restAddProductConversion starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateProductConversionParameter.getAddProductConversionParam(restProductsConversionChartModel);
			logger.info("values===>"+values);
			if (restProductsConversionChartModel.getProductId() != "" || restProductsConversionChartModel.getProductId() != null) {

				em.createNamedStoredProcedureQuery("sales_productConversionChart").setParameter("actionType", "addPConversion")
						.setParameter("actionValue", values).execute();

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		if (resp.getMessage() == null) {
			resp.setMessage("Saved successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: restAddProductConversion ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> restViewProductConversionChart(String orgName, String orgDivision) {
		logger.info("Method : restViewProductConversionChart Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values==>"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("sales_productConversionChart")
					.setParameter("actionType", "viewPConversion").setParameter("actionValue", values)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : restViewProductConversionChart Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> restEditProductConversionChart(String orgName, String orgDivision, String id) {
		logger.info("Method : restEditProductConversionChart Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_productId='" + id + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values==>"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("sales_productConversionChart")
					.setParameter("actionType", "editPConversion").setParameter("actionValue", values)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : restEditProductConversionChart Dao ends" + resp);
		return resp;

	}
}
