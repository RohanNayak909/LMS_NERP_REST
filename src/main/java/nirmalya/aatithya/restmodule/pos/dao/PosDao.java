/*
 * package nirmalya.aatithya.restmodule.pos.dao;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import javax.persistence.EntityManager;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Repository;
 * 
 * import nirmalya.aatithya.restmodule.common.ServerDao; import
 * nirmalya.aatithya.restmodule.common.utils.DropDownModel; import
 * nirmalya.aatithya.restmodule.common.utils.ecommerce.
 * GenerateParameterPosOrderDetails; import
 * nirmalya.aatithya.restmodule.common.utils.JsonResponse; import
 * nirmalya.aatithya.restmodule.pos.model.POSCustomerDetailsRestModel; import
 * nirmalya.aatithya.restmodule.pos.model.POSDashboardRestModel; import
 * nirmalya.aatithya.restmodule.pos.model.POSRestModel;
 * 
 * @Repository public class PosDao { Logger logger =
 * LoggerFactory.getLogger(PosDao.class);
 * 
 * @Autowired EntityManager em;
 * 
 * @Autowired ServerDao serverDao;
 * 
 * // product catogary
 * 
 * @SuppressWarnings("unchecked") public JsonResponse<List<DropDownModel>>
 * catogarylist(String userid) {
 * logger.info("Method : catogarylist Dao starts");
 * JsonResponse<List<DropDownModel>> resp = new
 * JsonResponse<List<DropDownModel>>(); List<DropDownModel> catogaryList = new
 * ArrayList<DropDownModel>();
 * 
 * String value = "SET @U_Id='" + userid + "';"; try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getCategoryList").setParameter("actionValue",
 * value).getResultList(); for (Object[] m : x) {
 * 
 * DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
 * catogaryList.add(dropDownModel); }
 * 
 * resp.setBody(catogaryList);
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * logger.info("Method : catogarylist Dao ends" + resp);
 * 
 * return resp; }
 * 
 * @SuppressWarnings("unchecked") public JsonResponse<List<POSRestModel>>
 * subcatogarylist(String id, String userId) {
 * logger.info("Method : subcatogarylist Dao starts");
 * JsonResponse<List<POSRestModel>> resp = new
 * JsonResponse<List<POSRestModel>>(); List<POSRestModel> catogaryList = new
 * ArrayList<POSRestModel>();
 * 
 * String value = "SET @P_Id='" + id + "',@p_userId='" + userId + "';"; try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getSubCategoryList").setParameter("actionValue",
 * value) .getResultList(); for (Object[] m : x) {
 * 
 * POSRestModel dropDownModel = new POSRestModel(m[0], m[1], m[2].toString());
 * catogaryList.add(dropDownModel); }
 * 
 * resp.setBody(catogaryList);
 * 
 * resp.setCode("Success");
 * resp.setMessage("Sub category data fetched successfully"); } catch (Exception
 * e) { e.printStackTrace(); resp.setCode("Failed");
 * resp.setMessage(e.getMessage()); }
 * logger.info("Method : subcatogarylist Dao ends" + resp);
 * 
 * return resp; }
 * 
 * @SuppressWarnings("unchecked") public JsonResponse<List<POSRestModel>>
 * productList(String id, String userId) {
 * logger.info("Method : productList Dao starts");
 * JsonResponse<List<POSRestModel>> resp = new
 * JsonResponse<List<POSRestModel>>(); List<POSRestModel> catogaryList = new
 * ArrayList<POSRestModel>(); String value = "SET @P_Id='" + id +
 * "',@p_userId='" + userId + "';"; try { List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getProductList").setParameter("actionValue",
 * value).getResultList(); for (Object[] m : x) {
 * 
 * POSRestModel dropDownModel = new POSRestModel(m[0], m[1], m[2].toString(),
 * null); catogaryList.add(dropDownModel); }
 * 
 * resp.setBody(catogaryList);
 * 
 * resp.setCode("Success");
 * resp.setMessage("Updated product list according to stock"); } catch
 * (Exception e) { e.printStackTrace(); resp.setCode("Failed");
 * resp.setMessage(e.getMessage()); }
 * 
 * logger.info("Method : productList Dao ends" + resp);
 * 
 * return resp; }
 * 
 * @SuppressWarnings("unchecked") public JsonResponse<List<POSRestModel>>
 * productSizeList(String id, String userId) {
 * logger.info("Method : productSizeList Dao starts");
 * JsonResponse<List<POSRestModel>> resp = new
 * JsonResponse<List<POSRestModel>>(); List<POSRestModel> catogaryList = new
 * ArrayList<POSRestModel>(); String value = "SET @P_Id='" + id +
 * "',@p_userId='" + userId + "';"; try { List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getProductSizeList").setParameter("actionValue",
 * value) .getResultList(); for (Object[] m : x) {
 * 
 * POSRestModel dropDownModel = new POSRestModel(m[0].toString(), m[1], m[2],
 * m[3], m[4], m[5].toString()); catogaryList.add(dropDownModel); }
 * 
 * resp.setBody(catogaryList);
 * 
 * resp.setCode("Success"); resp.setMessage("Size list according to stock"); }
 * catch (Exception e) { e.printStackTrace(); resp.setCode("Failed");
 * resp.setMessage(e.getMessage()); }
 * logger.info("Method : productSizeList Dao ends" + resp); return resp; }
 * 
 * // product viewStock list
 * 
 * @SuppressWarnings("unchecked") public JsonResponse<List<POSRestModel>>
 * viewStock(String id, String size, String userId) {
 * logger.info("Method : viewStock Dao starts");
 * JsonResponse<List<POSRestModel>> resp = new
 * JsonResponse<List<POSRestModel>>(); List<POSRestModel> catogaryList = new
 * ArrayList<POSRestModel>();
 * 
 * String value = "SET @p_userId='" + userId + "',@p_Id='" + id + "',@p_size='"
 * + size + "';"; try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "viewStock").setParameter("actionValue",
 * value).getResultList(); for (Object[] m : x) {
 * 
 * POSRestModel dropDownModel = new POSRestModel(m[0], m[1], m[2], m[3],
 * m[4].toString()); catogaryList.add(dropDownModel); }
 * 
 * resp.setBody(catogaryList);
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * logger.info("Method : viewStock Dao ends" + resp);
 * 
 * return resp; }
 * 
 * @SuppressWarnings("unchecked") public ResponseEntity<JsonResponse<Object>>
 * addOrderDetails(POSCustomerDetailsRestModel orderDetails) {
 * 
 * logger.info("Method in Dao: addOrderDetails starts" + orderDetails);
 * 
 * JsonResponse<Object> resp = new JsonResponse<Object>();
 * List<POSCustomerDetailsRestModel> listData = new
 * ArrayList<POSCustomerDetailsRestModel>(); resp.setMessage("");
 * resp.setCode("");
 * 
 * try { String values =
 * GenerateParameterPosOrderDetails.addorderDetails(orderDetails);
 * 
 * if (orderDetails.getCustomerId() == null || orderDetails.getCustomerId() ==
 * "") { List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType",
 * "addCustOrderDetails").setParameter("actionValue", values) .getResultList();
 * 
 * Object orderId = x.get(0);
 * 
 * POSCustomerDetailsRestModel dropDownModel = new
 * POSCustomerDetailsRestModel(orderId);
 * 
 * listData.add(dropDownModel); resp.setBody(listData);
 * 
 * } else { List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "addOrderDetails").setParameter("actionValue",
 * values) .getResultList();
 * 
 * Object orderId = x.get(0);
 * 
 * POSCustomerDetailsRestModel dropDownModel = new
 * POSCustomerDetailsRestModel(orderId);
 * 
 * listData.add(dropDownModel); resp.setBody(listData); }
 * 
 * resp.setCode("Success"); resp.setMessage("Pos order completed"); } catch
 * (Exception e) { e.printStackTrace(); resp.setCode("Failed");
 * resp.setMessage(e.getMessage()); } ResponseEntity<JsonResponse<Object>>
 * response = new ResponseEntity<JsonResponse<Object>>(resp,
 * HttpStatus.CREATED);
 * 
 * logger.info("Method in Dao: addOrderDetails ends" + response);
 * 
 * return response; }
 * 
 * // customer details
 * 
 * @SuppressWarnings("unchecked") public
 * JsonResponse<List<POSCustomerDetailsRestModel>> customerDetails(String id) {
 * logger.info("Method : customerDetails Dao starts");
 * JsonResponse<List<POSCustomerDetailsRestModel>> resp = new
 * JsonResponse<List<POSCustomerDetailsRestModel>>();
 * List<POSCustomerDetailsRestModel> catogaryList = new
 * ArrayList<POSCustomerDetailsRestModel>();
 * 
 * String value = "SET @p_Id='" + id + "';"; try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getcustomerDetails").setParameter("actionValue",
 * value) .getResultList(); for (Object[] m : x) {
 * 
 * POSCustomerDetailsRestModel dropDownModel = new
 * POSCustomerDetailsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
 * m[8], m[9], m[10]); catogaryList.add(dropDownModel); }
 * 
 * resp.setBody(catogaryList);
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * logger.info("Method : customerDetails Dao ends" + resp);
 * 
 * return resp; }
 * 
 * @SuppressWarnings("unchecked") public
 * JsonResponse<List<POSCustomerDetailsRestModel>> customerview(String id,
 * String pageno) { logger.info("Method : customerview Dao starts");
 * JsonResponse<List<POSCustomerDetailsRestModel>> resp = new
 * JsonResponse<List<POSCustomerDetailsRestModel>>();
 * List<POSCustomerDetailsRestModel> catogaryList = new
 * ArrayList<POSCustomerDetailsRestModel>(); String value = "SET @u_Id='" + id +
 * "',@p_pageno='" + pageno + "';"; try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getcustomerView").setParameter("actionValue",
 * value).getResultList(); for (Object[] m : x) {
 * 
 * POSCustomerDetailsRestModel dropDownModel = new
 * POSCustomerDetailsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
 * m[8], m[9], m[10], m[11].toString(), m[12].toString());
 * catogaryList.add(dropDownModel); }
 * 
 * resp.setBody(catogaryList);
 * 
 * resp.setCode("Success"); resp.setMessage("Customer data found"); } catch
 * (Exception e) { e.printStackTrace(); resp.setCode("Failed");
 * resp.setMessage(e.getMessage()); }
 * 
 * logger.info("Method : customerview Dao ends" + resp);
 * 
 * return resp; }
 * 
 * @SuppressWarnings("unchecked") public
 * JsonResponse<List<POSCustomerDetailsRestModel>> customeredit(String id) {
 * logger.info("Method : customeredit Dao starts");
 * JsonResponse<List<POSCustomerDetailsRestModel>> resp = new
 * JsonResponse<List<POSCustomerDetailsRestModel>>();
 * List<POSCustomerDetailsRestModel> catogaryList = new
 * ArrayList<POSCustomerDetailsRestModel>();
 * 
 * String value = "SET @cus_Id='" + id + "';"; try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getcustomeredit").setParameter("actionValue",
 * value).getResultList(); for (Object[] m : x) {
 * 
 * POSCustomerDetailsRestModel dropDownModel = new
 * POSCustomerDetailsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
 * m[8], m[9], m[10]); catogaryList.add(dropDownModel); }
 * 
 * resp.setBody(catogaryList);
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * logger.info("Method : customeredit Dao ends" + resp);
 * 
 * return resp; }
 * 
 * @SuppressWarnings("unchecked") public
 * JsonResponse<List<POSDashboardRestModel>> getPOSDashboard(String id) {
 * logger.info("Method : getPOSDashboard starts");
 * 
 * List<POSDashboardRestModel> getDealerDetails = new
 * ArrayList<POSDashboardRestModel>(); JsonResponse<List<POSDashboardRestModel>>
 * resp = new JsonResponse<List<POSDashboardRestModel>>(); try { String value =
 * "SET @p_uId='" + id + "';"; List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getPosDetails").setParameter("actionValue",
 * value).getResultList();
 * 
 * for (Object[] m : x) {
 * 
 * POSDashboardRestModel dealerModel = new
 * POSDashboardRestModel(m[0].toString(), m[1].toString(), m[2].toString(),
 * m[3].toString(), m[4].toString());
 * 
 * getDealerDetails.add(dealerModel); }
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * resp.setBody(getDealerDetails); logger.info("Method : getPOSDashboard ends");
 * return resp;
 * 
 * }
 * 
 * @SuppressWarnings("unchecked") public
 * JsonResponse<List<POSDashboardRestModel>> getDealerPOSDashboard(String id) {
 * logger.info("Method : getDealerPOSDashboard starts");
 * 
 * List<POSDashboardRestModel> getDealerDetails = new
 * ArrayList<POSDashboardRestModel>(); JsonResponse<List<POSDashboardRestModel>>
 * resp = new JsonResponse<List<POSDashboardRestModel>>();
 * 
 * try {
 * 
 * String value = "SET @p_uId='" + id + "';"; List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType",
 * "getDealerPosDetails").setParameter("actionValue", value) .getResultList();
 * 
 * for (Object[] m : x) {
 * 
 * POSDashboardRestModel dealerModel = new
 * POSDashboardRestModel(m[0].toString(), m[1].toString(), m[2].toString(),
 * m[3].toString(), m[4].toString(), m[5].toString(), m[6].toString(),
 * m[7].toString());
 * 
 * getDealerDetails.add(dealerModel); }
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * resp.setBody(getDealerDetails);
 * logger.info("Method : getDealerPOSDashboard ends"); return resp;
 * 
 * }
 * 
 * @SuppressWarnings("unchecked") public
 * JsonResponse<List<POSDashboardRestModel>> getManagerDashboard(String id) {
 * logger.info("Method : getManagerDashboard starts");
 * 
 * List<POSDashboardRestModel> getManagerDetails = new
 * ArrayList<POSDashboardRestModel>(); JsonResponse<List<POSDashboardRestModel>>
 * resp = new JsonResponse<List<POSDashboardRestModel>>();
 * 
 * try {
 * 
 * String value = "SET @p_uId='" + id + "';"; List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType",
 * "getManagerDashboard").setParameter("actionValue", value) .getResultList();
 * 
 * for (Object[] m : x) {
 * 
 * POSDashboardRestModel dealerModel = new
 * POSDashboardRestModel(m[0].toString(), m[1].toString(), m[2].toString(),
 * m[3].toString(), m[4].toString(), m[5].toString(), m[6].toString(),
 * m[7].toString());
 * 
 * getManagerDetails.add(dealerModel); }
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * resp.setBody(getManagerDetails);
 * logger.info("Method : getManagerDashboard ends"); return resp;
 * 
 * }
 * 
 * // searchSize
 * 
 * @SuppressWarnings("unchecked") public JsonResponse<List<POSRestModel>>
 * productSizeSearchList(String id, String searchKey) {
 * logger.info("Method : productSizeSearchList Dao starts");
 * JsonResponse<List<POSRestModel>> resp = new
 * JsonResponse<List<POSRestModel>>(); List<POSRestModel> catogaryList = new
 * ArrayList<POSRestModel>();
 * 
 * String value = "SET @P_Id='" + id + "',@searchKey='" + searchKey + "%';"; try
 * {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType",
 * "getProductSizeSearch").setParameter("actionValue", value) .getResultList();
 * for (Object[] m : x) {
 * 
 * POSRestModel dropDownModel = new POSRestModel(m[0].toString(), m[1], m[2],
 * m[3], m[4], m[5]); catogaryList.add(dropDownModel); }
 * 
 * resp.setBody(catogaryList);
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * logger.info("Method : productSizeSearchList Dao ends" + resp);
 * 
 * return resp; }
 * 
 * @SuppressWarnings("unchecked") public JsonResponse<List<POSRestModel>>
 * getCurrentStockPos(String productId, String size, String userId) {
 * logger.info("Method : getCurrentStockPos Dao starts");
 * JsonResponse<List<POSRestModel>> resp = new
 * JsonResponse<List<POSRestModel>>(); List<POSRestModel> catogaryList = new
 * ArrayList<POSRestModel>(); String value = "SET @p_userId='" + userId +
 * "',@p_productId='" + productId + "',@p_size='" + size + "';"; try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getStock").setParameter("actionValue",
 * value).getResultList(); for (Object[] m : x) { if (m[0] == "" || m[0] ==
 * null) { m[0] = "0"; } if (m[1] == "" || m[1] == null) { m[1] = "0"; } if
 * (m[2] == "" || m[2] == null) { m[2] = "0"; } if (m[3] == "" || m[3] == null)
 * { m[3] = "0"; } if (m[4] == "" || m[4] == null) { m[4] = "0"; } POSRestModel
 * dropDownModel = new POSRestModel(m[0], m[1], m[2], m[3], m[4].toString());
 * catogaryList.add(dropDownModel); }
 * 
 * resp.setBody(catogaryList); resp.setCode("Success");
 * resp.setMessage("Current stock checked"); } catch (Exception e) {
 * e.printStackTrace(); resp.setCode("Failed"); resp.setMessage(e.getMessage());
 * } logger.info("Method : getCurrentStockPos Dao ends" + resp); return resp; }
 * }
 */