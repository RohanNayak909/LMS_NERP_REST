/*
 * package nirmalya.aatithya.restmodule.pos.dao;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import javax.persistence.EntityManager;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Repository;
 * 
 * import nirmalya.aatithya.restmodule.common.ServerDao; import
 * nirmalya.aatithya.restmodule.common.utils.ecommerce.
 * GenerateStockManagerParameter; import
 * nirmalya.aatithya.restmodule.common.utils.JsonResponse; import
 * nirmalya.aatithya.restmodule.pos.model.StockAttributeRestModel; import
 * nirmalya.aatithya.restmodule.pos.model.StockProductRestModel;
 * 
 * @Repository public class StockDao { Logger logger =
 * LoggerFactory.getLogger(PosDao.class);
 * 
 * @Autowired EntityManager em;
 * 
 * @Autowired ServerDao serverDao;
 * 
 * @SuppressWarnings("unchecked") public
 * JsonResponse<List<StockProductRestModel>> stocksview(String id, String
 * userType) { logger.info("Method : stocksview Dao starts");
 * JsonResponse<List<StockProductRestModel>> resp = new
 * JsonResponse<List<StockProductRestModel>>(); List<StockProductRestModel>
 * catogaryList = new ArrayList<StockProductRestModel>(); String value =
 * "SET @p_managerId='" + id + "',@p_userType='" + userType + "';"; try {
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getProductForStock").setParameter("actionValue",
 * value) .getResultList(); for (Object[] m : x) {
 * 
 * StockProductRestModel dropDownModel = new StockProductRestModel(m[0], m[1],
 * m[2].toString()); catogaryList.add(dropDownModel); }
 * 
 * resp.setCode("Success"); resp.setMessage("Data Fetched Successfully"); }
 * catch (Exception e) { e.printStackTrace(); resp.setCode("Failed");
 * resp.setMessage(e.getMessage()); }
 * 
 * resp.setBody(catogaryList);
 * 
 * logger.info("Method : stocksview Dao ends" + resp);
 * 
 * return resp; }
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<StockProductRestModel>> stocksdit(String id,
 * String userid, String userType) { logger.info("Method : stocksdit starts");
 * 
 * JsonResponse<StockProductRestModel> resp = new
 * JsonResponse<StockProductRestModel>(); List<StockProductRestModel>
 * getShoukeenProduct = new ArrayList<StockProductRestModel>();
 * List<StockAttributeRestModel> productList = new
 * ArrayList<StockAttributeRestModel>(); try {
 * 
 * String value = "SET @p_managerId='" + userid + "',@p_userType='" + userType +
 * "',@p_prdId='" + id + "';"; List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "editStockInfo").setParameter("actionValue",
 * value).getResultList();
 * 
 * for (Object[] m : x) {
 * 
 * StockProductRestModel orderdeatils = new StockProductRestModel(m[0], m[1],
 * m[2].toString()); getShoukeenProduct.add(orderdeatils);
 * 
 * } } catch (Exception e) { e.printStackTrace(); } if
 * (getShoukeenProduct.size() > 0) { try { String subValues =
 * "SET @p_managerId='" + userid + "',@p_userType='" + userType + "',@p_prdId='"
 * + id + "';"; List<Object[]> x1 =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getStockDetails").setParameter("actionValue",
 * subValues) .getResultList(); for (Object[] m : x1) {
 * 
 * if (m[3] == null) { m[3] = "0"; }
 * 
 * StockAttributeRestModel dropDownModel = new StockAttributeRestModel(m[0],
 * m[1], m[2], m[3].toString()); productList.add(dropDownModel); }
 * getShoukeenProduct.get(0).setProductDetails(productList); } catch (Exception
 * e) { e.printStackTrace(); } }
 * 
 * resp.setBody(getShoukeenProduct.get(0)); HttpHeaders responseHeaders = new
 * HttpHeaders(); responseHeaders.set("MyResponseHeader", "MyValue");
 * 
 * ResponseEntity<JsonResponse<StockProductRestModel>> response = new
 * ResponseEntity<JsonResponse<StockProductRestModel>>( resp, responseHeaders,
 * HttpStatus.CREATED);
 * 
 * logger.info("Method : stocksdit ends"); return response;
 * 
 * }
 * 
 * public ResponseEntity<JsonResponse<List<StockProductRestModel>>>
 * addStock(List<StockProductRestModel> stockData) {
 * 
 * logger.info("Method : addDealerOrderNew starts");
 * JsonResponse<List<StockProductRestModel>> resp = new
 * JsonResponse<List<StockProductRestModel>>(); try { String values =
 * GenerateStockManagerParameter.addStock(stockData);
 * 
 * if (stockData.get(0).getProductId() == null ||
 * stockData.get(0).getProductId() == "") {
 * 
 * em.createNamedStoredProcedureQuery("ecommerce_pos").setParameter(
 * "actionType", "addStock") .setParameter("actionValue", values).execute();
 * 
 * } resp.setCode("Success"); resp.setMessage("Order placed successfully"); }
 * catch (Exception e) { resp.setCode("Failed");
 * resp.setMessage(e.getLocalizedMessage());
 * 
 * } ResponseEntity<JsonResponse<List<StockProductRestModel>>> response = new
 * ResponseEntity<JsonResponse<List<StockProductRestModel>>>( resp,
 * HttpStatus.CREATED); logger.info("Method : addDealerOrderNew dao ends");
 * return response; } }
 */