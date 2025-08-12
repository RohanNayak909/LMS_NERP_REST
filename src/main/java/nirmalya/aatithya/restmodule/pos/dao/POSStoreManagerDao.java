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
 * import nirmalya.aatithya.restmodule.pos.model.POSPackagingRestModel; import
 * nirmalya.aatithya.restmodule.common.ServerDao; import
 * nirmalya.aatithya.restmodule.common.utils.JsonResponse; import
 * nirmalya.aatithya.restmodule.common.utils.ecommerce.
 * POSStoreManagerGenerateParameter; import
 * nirmalya.aatithya.restmodule.pos.model.POSCustomerDetailsRestModel; import
 * nirmalya.aatithya.restmodule.pos.model.POSProductDetailsRestModel;
 * 
 * @Repository public class POSStoreManagerDao { Logger logger =
 * LoggerFactory.getLogger(POSStoreManagerDao.class);
 * 
 * @Autowired EntityManager em;
 * 
 * @Autowired ServerDao serverDao;
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<List<POSCustomerDetailsRestModel>>>
 * restprocessedOrder(String id) {
 * logger.info("Method : restprocessedOrder starts");
 * List<POSCustomerDetailsRestModel> respList = new
 * ArrayList<POSCustomerDetailsRestModel>(); String value = "SET @u_Id='" + id +
 * "';"; try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType",
 * "getStoreManagerOrdList").setParameter("actionValue", value)
 * .getResultList();
 * 
 * for (Object[] m : x) { POSCustomerDetailsRestModel orderdeatils = new
 * POSCustomerDetailsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
 * m[7].toString()); respList.add(orderdeatils);
 * 
 * }
 * 
 * } catch (Exception e) {
 * 
 * e.printStackTrace();
 * 
 * }
 * 
 * JsonResponse<List<POSCustomerDetailsRestModel>> resp = new
 * JsonResponse<List<POSCustomerDetailsRestModel>>(); resp.setBody(respList);
 * ResponseEntity<JsonResponse<List<POSCustomerDetailsRestModel>>> response =
 * new ResponseEntity<JsonResponse<List<POSCustomerDetailsRestModel>>>( resp,
 * HttpStatus.CREATED); logger.info("Method : restprocessedOrder ends"); return
 * response;
 * 
 * }
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<List<POSCustomerDetailsRestModel>>>
 * restfutureOrderList(String id) {
 * logger.info("Method : restfutureOrderList starts");
 * List<POSCustomerDetailsRestModel> respList = new
 * ArrayList<POSCustomerDetailsRestModel>(); String value = "SET @u_Id='" + id +
 * "';"; try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType",
 * "getStoreManagerFutureOrdList").setParameter("actionValue", value)
 * .getResultList();
 * 
 * for (Object[] m : x) { POSCustomerDetailsRestModel orderdeatils = new
 * POSCustomerDetailsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
 * m[7].toString()); respList.add(orderdeatils);
 * 
 * }
 * 
 * } catch (Exception e) {
 * 
 * e.printStackTrace();
 * 
 * }
 * 
 * JsonResponse<List<POSCustomerDetailsRestModel>> resp = new
 * JsonResponse<List<POSCustomerDetailsRestModel>>(); resp.setBody(respList);
 * ResponseEntity<JsonResponse<List<POSCustomerDetailsRestModel>>> response =
 * new ResponseEntity<JsonResponse<List<POSCustomerDetailsRestModel>>>( resp,
 * HttpStatus.CREATED); logger.info("Method : restfutureOrderList ends"); return
 * response;
 * 
 * }
 * 
 * // for creating POS packaging
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> addPackagingPos(
 * List<POSPackagingRestModel> packageModel) {
 * 
 * logger.info("Method : addPackagingPos starts" + packageModel);
 * 
 * JsonResponse<List<POSPackagingRestModel>> resp = new
 * JsonResponse<List<POSPackagingRestModel>>(); List<POSPackagingRestModel>
 * listData = new ArrayList<POSPackagingRestModel>(); try { String values =
 * POSStoreManagerGenerateParameter.getPackagingParam(packageModel);
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "addPOSPackages").setParameter("actionValue",
 * values).getResultList(); try { for (Object[] m : x) {
 * 
 * POSPackagingRestModel dropDownModel = new POSPackagingRestModel(m[0], m[1],
 * m[2], m[3]); listData.add(dropDownModel); }
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
 * resp.setMessage(err[1]);
 * 
 * } catch (Exception e1) { e1.printStackTrace(); } } resp.setBody(listData);
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> response = new
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>( resp,
 * HttpStatus.CREATED); logger.info("Method : addPackagingPos ends"); return
 * response; }
 * 
 * // pos packaging list
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>
 * restPackagingList(String id) {
 * logger.info("Method : restPackagingList starts"); List<POSPackagingRestModel>
 * respList = new ArrayList<POSPackagingRestModel>(); String value =
 * "SET @u_Id='" + id + "';"; try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType",
 * "getPOSpackagingList").setParameter("actionValue", value) .getResultList();
 * 
 * for (Object[] m : x) { POSPackagingRestModel orderdeatils = new
 * POSPackagingRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6].toString(),
 * m[7]); respList.add(orderdeatils);
 * 
 * }
 * 
 * } catch (Exception e) {
 * 
 * e.printStackTrace();
 * 
 * }
 * 
 * JsonResponse<List<POSPackagingRestModel>> resp = new
 * JsonResponse<List<POSPackagingRestModel>>(); resp.setBody(respList);
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> response = new
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>( resp,
 * HttpStatus.CREATED); logger.info("Method : restPackagingList ends"); return
 * response;
 * 
 * }
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<POSPackagingRestModel>>
 * restPackagingDetails(String id) {
 * logger.info("Method : restPackagingDetails starts");
 * 
 * JsonResponse<POSPackagingRestModel> resp = new
 * JsonResponse<POSPackagingRestModel>(); List<POSPackagingRestModel>
 * getShoukeenProduct = new ArrayList<POSPackagingRestModel>();
 * List<POSProductDetailsRestModel> docList = new
 * ArrayList<POSProductDetailsRestModel>();
 * 
 * try {
 * 
 * String value = "SET @p_pkgId='" + id + "';"; List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType",
 * "getPackagingDetails").setParameter("actionValue", value) .getResultList();
 * 
 * for (Object[] m : x) {
 * 
 * POSPackagingRestModel orderdeatils = new POSPackagingRestModel(m[0], m[1],
 * m[2], m[3], m[4], m[5], m[6].toString(), m[7], m[8], m[9], m[10], m[11],
 * m[12], m[13]); getShoukeenProduct.add(orderdeatils);
 * 
 * }
 * 
 * } catch (Exception e) { e.printStackTrace(); } if (getShoukeenProduct.size()
 * > 0) { try { String subValues = "SET @p_orderId='" +
 * getShoukeenProduct.get(0).getCustOrderId() + "';"; List<Object[]> x1 =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getProductDetails").setParameter("actionValue",
 * subValues) .getResultList(); for (Object[] m : x1) {
 * 
 * POSProductDetailsRestModel dropDownModel = new
 * POSProductDetailsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7]);
 * docList.add(dropDownModel); }
 * getShoukeenProduct.get(0).setPrdctDtls(docList); } catch (Exception e) {
 * e.printStackTrace(); } }
 * 
 * resp.setBody(getShoukeenProduct.get(0)); HttpHeaders responseHeaders = new
 * HttpHeaders(); responseHeaders.set("MyResponseHeader", "MyValue");
 * 
 * ResponseEntity<JsonResponse<POSPackagingRestModel>> response = new
 * ResponseEntity<JsonResponse<POSPackagingRestModel>>( resp, responseHeaders,
 * HttpStatus.CREATED);
 * 
 * logger.info("Method : restPackagingDetails ends"); return response;
 * 
 * }
 * 
 * // for creating POS shipment
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> addShippmentPos(
 * List<POSPackagingRestModel> packageModel) {
 * 
 * logger.info("Method : addShippmentPos starts" + packageModel);
 * 
 * JsonResponse<List<POSPackagingRestModel>> resp = new
 * JsonResponse<List<POSPackagingRestModel>>(); List<POSPackagingRestModel>
 * listData = new ArrayList<POSPackagingRestModel>(); try { String values =
 * POSStoreManagerGenerateParameter.getShipmentParam(packageModel);
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "addPOSShipment").setParameter("actionValue",
 * values).getResultList(); try { for (Object[] m : x) {
 * 
 * POSPackagingRestModel dropDownModel = new POSPackagingRestModel(m[0], m[1],
 * m[2], m[3], m[4]); listData.add(dropDownModel); } } catch (Exception e) {
 * e.printStackTrace(); } } catch (Exception e) { e.printStackTrace(); try {
 * String[] err = serverDao.errorProcedureCall(e); resp.setCode(err[0]);
 * resp.setMessage(err[1]);
 * 
 * } catch (Exception e1) { e1.printStackTrace(); } } resp.setBody(listData);
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> response = new
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>( resp,
 * HttpStatus.CREATED); logger.info("Method : addShippmentPos ends"); return
 * response; }
 * 
 * // POS shipment list
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>
 * restshipmentList(String id) {
 * logger.info("Method : restshipmentList starts"); List<POSPackagingRestModel>
 * respList = new ArrayList<POSPackagingRestModel>(); String value =
 * "SET @u_Id='" + id + "';"; try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getPOSShippingList").setParameter("actionValue",
 * value) .getResultList();
 * 
 * for (Object[] m : x) { POSPackagingRestModel orderdeatils = new
 * POSPackagingRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
 * m[7].toString(), m[8]); respList.add(orderdeatils); }
 * 
 * } catch (Exception e) {
 * 
 * e.printStackTrace(); } JsonResponse<List<POSPackagingRestModel>> resp = new
 * JsonResponse<List<POSPackagingRestModel>>(); resp.setBody(respList);
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> response = new
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>( resp,
 * HttpStatus.CREATED); logger.info("Method : restshipmentList ends"); return
 * response;
 * 
 * }
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<POSPackagingRestModel>>
 * restShippingDetails(String id) {
 * logger.info("Method : restShippingDetails starts");
 * 
 * JsonResponse<POSPackagingRestModel> resp = new
 * JsonResponse<POSPackagingRestModel>(); List<POSPackagingRestModel>
 * getShoukeenProduct = new ArrayList<POSPackagingRestModel>();
 * List<POSProductDetailsRestModel> docList = new
 * ArrayList<POSProductDetailsRestModel>(); try { String value =
 * "SET @p_shipId='" + id + "';"; List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getShippingDetails").setParameter("actionValue",
 * value) .getResultList();
 * 
 * for (Object[] m : x) {
 * 
 * POSPackagingRestModel orderdeatils = new POSPackagingRestModel(m[0], m[1],
 * m[2], m[3], m[4], m[5], m[6], m[7].toString(), m[8], m[9], m[10], m[11],
 * m[12], m[13], m[14], m[15], m[16], m[17]);
 * getShoukeenProduct.add(orderdeatils); }
 * 
 * } catch (Exception e) { e.printStackTrace(); } if (getShoukeenProduct.size()
 * > 0) { try { String subValues = "SET @p_orderId='" +
 * getShoukeenProduct.get(0).getCustOrderId() + "';"; List<Object[]> x1 =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getProductDetails").setParameter("actionValue",
 * subValues) .getResultList(); for (Object[] m : x1) {
 * POSProductDetailsRestModel dropDownModel = new
 * POSProductDetailsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7]);
 * docList.add(dropDownModel); }
 * getShoukeenProduct.get(0).setPrdctDtls(docList); } catch (Exception e) {
 * e.printStackTrace(); } }
 * 
 * resp.setBody(getShoukeenProduct.get(0)); HttpHeaders responseHeaders = new
 * HttpHeaders(); responseHeaders.set("MyResponseHeader", "MyValue");
 * 
 * ResponseEntity<JsonResponse<POSPackagingRestModel>> response = new
 * ResponseEntity<JsonResponse<POSPackagingRestModel>>( resp, responseHeaders,
 * HttpStatus.CREATED);
 * 
 * logger.info("Method : restShippingDetails ends"); return response;
 * 
 * }
 * 
 * // for creating POS addDeliveryPos
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> addDeliveryPos(
 * List<POSPackagingRestModel> packageModel) {
 * 
 * logger.info("Method : addShippmentPos starts" + packageModel);
 * 
 * JsonResponse<List<POSPackagingRestModel>> resp = new
 * JsonResponse<List<POSPackagingRestModel>>(); List<POSPackagingRestModel>
 * listData = new ArrayList<POSPackagingRestModel>(); try { String values =
 * POSStoreManagerGenerateParameter.getDeliveryParam(packageModel);
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "addPOSDelivery").setParameter("actionValue",
 * values).getResultList(); try { for (Object[] m : x) {
 * 
 * POSPackagingRestModel dropDownModel = new POSPackagingRestModel(m[0], m[1],
 * m[2], m[3], m[4], m[5]); listData.add(dropDownModel); } } catch (Exception e)
 * { e.printStackTrace(); } } catch (Exception e) { e.printStackTrace(); try {
 * String[] err = serverDao.errorProcedureCall(e); resp.setCode(err[0]);
 * resp.setMessage(err[1]);
 * 
 * } catch (Exception e1) { e1.printStackTrace(); } } resp.setBody(listData);
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> response = new
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>( resp,
 * HttpStatus.CREATED); logger.info("Method : addDeliveryPos ends"); return
 * response; }
 * 
 * // POS shipment list
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>
 * restdeliveryList(String id) {
 * logger.info("Method : restdeliveryList starts"); List<POSPackagingRestModel>
 * respList = new ArrayList<POSPackagingRestModel>(); String value =
 * "SET @u_Id='" + id + "';"; try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getPOSDeliveryList").setParameter("actionValue",
 * value) .getResultList();
 * 
 * for (Object[] m : x) { POSPackagingRestModel orderdeatils = new
 * POSPackagingRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
 * m[8].toString(), m[9], m[10], m[11], m[12], m[13].toString(),
 * m[14].toString(), m[15]); respList.add(orderdeatils); } } catch (Exception e)
 * { e.printStackTrace(); } JsonResponse<List<POSPackagingRestModel>> resp = new
 * JsonResponse<List<POSPackagingRestModel>>(); resp.setBody(respList);
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> response = new
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>( resp,
 * HttpStatus.CREATED); logger.info("Method : restdeliveryList ends"); return
 * response;
 * 
 * }
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<POSPackagingRestModel>>
 * restDeliveryDetails(String id) {
 * logger.info("Method : restDeliveryDetails starts");
 * 
 * JsonResponse<POSPackagingRestModel> resp = new
 * JsonResponse<POSPackagingRestModel>(); List<POSPackagingRestModel>
 * getShoukeenProduct = new ArrayList<POSPackagingRestModel>();
 * List<POSProductDetailsRestModel> docList = new
 * ArrayList<POSProductDetailsRestModel>(); try { String value =
 * "SET @p_deliId='" + id + "';"; List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getDelveryDetails").setParameter("actionValue",
 * value).getResultList();
 * 
 * for (Object[] m : x) {
 * 
 * POSPackagingRestModel orderdeatils = new POSPackagingRestModel(m[0], m[1],
 * m[2], m[3], m[4], m[5], m[6], m[7], m[8].toString(), m[9], m[10], m[11],
 * m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
 * m[22].toString(), m[23].toString(), m[24]);
 * getShoukeenProduct.add(orderdeatils);
 * 
 * }
 * 
 * } catch (Exception e) { e.printStackTrace(); } if (getShoukeenProduct.size()
 * > 0) { try { String subValues = "SET @p_orderId='" +
 * getShoukeenProduct.get(0).getCustOrderId() + "';"; List<Object[]> x1 =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getProductDetails").setParameter("actionValue",
 * subValues) .getResultList(); for (Object[] m : x1) {
 * 
 * POSProductDetailsRestModel dropDownModel = new
 * POSProductDetailsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7]);
 * docList.add(dropDownModel); }
 * getShoukeenProduct.get(0).setPrdctDtls(docList); } catch (Exception e) {
 * e.printStackTrace(); } } resp.setBody(getShoukeenProduct.get(0)); HttpHeaders
 * responseHeaders = new HttpHeaders(); responseHeaders.set("MyResponseHeader",
 * "MyValue");
 * 
 * ResponseEntity<JsonResponse<POSPackagingRestModel>> response = new
 * ResponseEntity<JsonResponse<POSPackagingRestModel>>( resp, responseHeaders,
 * HttpStatus.CREATED);
 * 
 * logger.info("Method : restDeliveryDetails ends"); return response;
 * 
 * }
 * 
 * // for creating POS addDeliveryPos
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> posOrderDelivered(
 * List<POSPackagingRestModel> packageModel) {
 * 
 * logger.info("Method : posOrderDelivered starts" + packageModel);
 * 
 * JsonResponse<List<POSPackagingRestModel>> resp = new
 * JsonResponse<List<POSPackagingRestModel>>(); List<POSPackagingRestModel>
 * listData = new ArrayList<POSPackagingRestModel>(); try { String values =
 * POSStoreManagerGenerateParameter.getOrderDeliveredParam(packageModel);
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "orderDelivered").setParameter("actionValue",
 * values).getResultList(); try { for (Object[] m : x) {
 * 
 * POSPackagingRestModel dropDownModel = new POSPackagingRestModel(m[0], m[1],
 * m[2], m[3], m[4], m[5]); listData.add(dropDownModel); } } catch (Exception e)
 * { e.printStackTrace(); } } catch (Exception e) { e.printStackTrace(); try {
 * String[] err = serverDao.errorProcedureCall(e); resp.setCode(err[0]);
 * resp.setMessage(err[1]);
 * 
 * } catch (Exception e1) { e1.printStackTrace(); } } resp.setBody(listData);
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> response = new
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>( resp,
 * HttpStatus.CREATED); logger.info("Method : posOrderDelivered ends"); return
 * response; }
 * 
 * // POS shipment list
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>
 * restAllDeliveredOrderList(String id) {
 * logger.info("Method : restAllDeliveredOrderList starts");
 * List<POSPackagingRestModel> respList = new
 * ArrayList<POSPackagingRestModel>(); String value = "SET @u_Id='" + id + "';";
 * try {
 * 
 * List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType",
 * "getDeliveredOrderList").setParameter("actionValue", value) .getResultList();
 * 
 * for (Object[] m : x) { POSPackagingRestModel orderdeatils = new
 * POSPackagingRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
 * m[8].toString(), m[9], m[10], m[11], m[12]); respList.add(orderdeatils); }
 * 
 * } catch (Exception e) {
 * 
 * e.printStackTrace();
 * 
 * }
 * 
 * JsonResponse<List<POSPackagingRestModel>> resp = new
 * JsonResponse<List<POSPackagingRestModel>>(); resp.setBody(respList);
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> response = new
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>( resp,
 * HttpStatus.CREATED); logger.info("Method : restAllDeliveredOrderList ends");
 * return response; }
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<POSPackagingRestModel>>
 * restDeliveredDetails(String id) {
 * logger.info("Method : restDeliveredDetails starts");
 * 
 * JsonResponse<POSPackagingRestModel> resp = new
 * JsonResponse<POSPackagingRestModel>(); List<POSPackagingRestModel>
 * getShoukeenProduct = new ArrayList<POSPackagingRestModel>();
 * List<POSProductDetailsRestModel> docList = new
 * ArrayList<POSProductDetailsRestModel>();
 * 
 * try { String value = "SET @p_ordId='" + id + "';"; List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getDelveredDetails").setParameter("actionValue",
 * value) .getResultList();
 * 
 * for (Object[] m : x) { POSPackagingRestModel orderdeatils = new
 * POSPackagingRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
 * m[8].toString(), m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
 * m[17], m[18], m[19], m[20], m[21], m[22].toString(), m[23].toString(), m[24],
 * m[25].toString(), m[26]); getShoukeenProduct.add(orderdeatils);
 * 
 * }
 * 
 * } catch (Exception e) { e.printStackTrace(); } if (getShoukeenProduct.size()
 * > 0) { try { String subValues = "SET @p_orderId='" +
 * getShoukeenProduct.get(0).getCustOrderId() + "';"; List<Object[]> x1 =
 * em.createNamedStoredProcedureQuery("ecommerce_pos")
 * .setParameter("actionType", "getProductDetails").setParameter("actionValue",
 * subValues) .getResultList(); for (Object[] m : x1) {
 * 
 * POSProductDetailsRestModel dropDownModel = new
 * POSProductDetailsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7]);
 * docList.add(dropDownModel); }
 * getShoukeenProduct.get(0).setPrdctDtls(docList); } catch (Exception e) {
 * e.printStackTrace(); } }
 * 
 * resp.setBody(getShoukeenProduct.get(0)); HttpHeaders responseHeaders = new
 * HttpHeaders(); responseHeaders.set("MyResponseHeader", "MyValue");
 * 
 * ResponseEntity<JsonResponse<POSPackagingRestModel>> response = new
 * ResponseEntity<JsonResponse<POSPackagingRestModel>>( resp, responseHeaders,
 * HttpStatus.CREATED);
 * 
 * logger.info("Method : restDeliveredDetails ends"); return response;
 * 
 * } }
 */