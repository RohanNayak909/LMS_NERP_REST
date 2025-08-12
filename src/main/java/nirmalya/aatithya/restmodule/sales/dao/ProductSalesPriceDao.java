package nirmalya.aatithya.restmodule.sales.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class ProductSalesPriceDao {

	Logger logger = LoggerFactory.getLogger(CustomerNewDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// EDIT MEETING
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getProductDetais(String orgName, String orgDiv, String skuId) {
		logger.info("Method : getProductDetais Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_skuId='" + skuId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("product_sales_price_routine")
					.setParameter("actionType", "getProductDetais").setParameter("actionValue", value).getResultList();
			
			if(x.size() > 0) {
				if(x.get(0) != null) {
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} else {
					resp.setBody(null);
					resp.setCode("failed");
					resp.setMessage("Data not found");
				}
			} else {
				resp.setBody(null);
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getProductDetais Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveSalesPrice(List<Map<String, Object>> dataset, String organization,
			String orgDivision, String createdById) {
		logger.info("Method : saveSalesPrice starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println("Dataset received: " + dataset);
		try {
			String grnId = null;

			for (Map<String, Object> row : dataset) {
				if (row.containsKey("grnId") && row.get("grnId") != null) {
					grnId = row.get("grnId").toString();
					break;
				}
			}
			// Convert the dataset to JSON string
			String salesPriceDetails = objectMapper.writeValueAsString(dataset);
			String value = "SET @p_salesPriceDetails='" + salesPriceDetails + "', @p_orgName='" + organization
					+ "',@p_orgDiv='" + orgDivision + "',@p_userId='" + createdById + "',@p_grnId='" + grnId + "';";

			System.out.println("Value For Update The Shipping Address=====>" + value);
			String actionType = "addSalesPrice";
			List<Object> result = em.createNamedStoredProcedureQuery("product_sales_price_routine")
					.setParameter("actionType", actionType).setParameter("actionValue", value).getResultList();
			System.out.println("Result=======>" + result);

			if (result != null && !result.isEmpty()) {
				resp.setBody(result.get(0));
			}

			resp.setCode("success");
			resp.setMessage("Sales Price Added Successfully");

		} catch (Exception e) {
			resp.setCode("Failed");
			resp.setMessage("Error during Add The Sales Price.");
			logger.error("Error in addSales Price: ", e);
		}

		logger.info("Method : saveSalesPrice ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteSlaesItem(String orgName, String orgDivision, String slNo) {
		logger.info("Method : getProductDetais Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_slNo='" + slNo + "';";
			System.out.println("delete Vlaue ========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("product_sales_price_routine")
					.setParameter("actionType", "deleteSalesItem").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getProductDetais Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getGRNDataRest(String org, String orgDiv, String pageno) {
		logger.info("Method : getGRNDataRest Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_pageno='" + pageno + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("product_sales_price_routine")
					.setParameter("actionType", "getGRNData").setParameter("actionValue", value).getResultList();
			if (x.size() > 0) {
				if (x.get(0) != null) {
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} else {
					resp.setCode("failed");
					resp.setMessage("Data not found");
				}

			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getGRNDataRest Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSalesPriceDataRest(String org, String orgDiv, String pageno) {
		logger.info("Method : getSalesPriceDataRest Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_pageno='" + pageno + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("product_sales_price_routine")
					.setParameter("actionType", "getSalesPriceData").setParameter("actionValue", value).getResultList();
			if (x.size() > 0) {
				if (x.get(0) != null) {
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} else {
					resp.setCode("failed");
					resp.setMessage("Data not found");
				}

			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getSalesPriceDataRest Dao ends");
		return resp;
	}

}
