/*
 * package nirmalya.aatithya.restmodule.pos.controller;
 * 
 * import java.util.List;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import nirmalya.aatithya.restmodule.pos.model.POSPackagingRestModel; import
 * nirmalya.aatithya.restmodule.common.utils.JsonResponse; import
 * nirmalya.aatithya.restmodule.pos.dao.POSStoreManagerDao; import
 * nirmalya.aatithya.restmodule.pos.model.POSCustomerDetailsRestModel;
 * 
 * @RestController
 * 
 * @RequestMapping(value = "ecommerce") public class
 * POSStoreManagerRestController { Logger logger =
 * LoggerFactory.getLogger(POSStoreManagerRestController.class);
 * 
 * @Autowired POSStoreManagerDao posManager;
 * 
 * @RequestMapping(value = "restprocessedOrder", method = { RequestMethod.GET })
 * public ResponseEntity<JsonResponse<List<POSCustomerDetailsRestModel>>>
 * restprocessedOrder(@RequestParam String id) {
 * logger.info("Method: restprocessedOrder View Start");
 * 
 * logger.info("Method: restprocessedOrder ends"); return
 * posManager.restprocessedOrder(id); }
 * 
 * @RequestMapping(value = "restfutureOrderList", method = { RequestMethod.GET
 * }) public ResponseEntity<JsonResponse<List<POSCustomerDetailsRestModel>>>
 * restfutureOrderList(
 * 
 * @RequestParam String id) {
 * logger.info("Method: restfutureOrderList View Start");
 * 
 * logger.info("Method: restfutureOrderList ends"); return
 * posManager.restfutureOrderList(id); }
 * 
 * @PostMapping(value = "addPackagingPos") public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> addPackagingPos(
 * 
 * @RequestBody List<POSPackagingRestModel> packageModel) {
 * logger.info("Method :addPackagingPos starts");
 * logger.info("Method :addPackagingPos endss"); return
 * posManager.addPackagingPos(packageModel); }
 * 
 * @RequestMapping(value = "restPackagingList", method = { RequestMethod.GET })
 * public ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>
 * restPackagingList(@RequestParam String id) {
 * logger.info("Method: restPackagingList View Start");
 * 
 * logger.info("Method: restPackagingList ends"); return
 * posManager.restPackagingList(id); }
 * 
 * @GetMapping(value = "rest-packaging-details") public
 * ResponseEntity<JsonResponse<POSPackagingRestModel>>
 * restPackagingDetails(@RequestParam String id) {
 * logger.info("Method :restPackagingDetails starts");
 * 
 * logger.info("Method :restPackagingDetails ends" + id); return
 * posManager.restPackagingDetails(id);
 * 
 * }
 * 
 * @PostMapping(value = "addShippmentPos") public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> addShippmentPos(
 * 
 * @RequestBody List<POSPackagingRestModel> packageModel) {
 * logger.info("Method :addShippmentPos starts");
 * logger.info("Method :addShippmentPos endss"); return
 * posManager.addShippmentPos(packageModel); }
 * 
 * @RequestMapping(value = "restshipmentList", method = { RequestMethod.GET })
 * public ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>
 * restshipmentList(@RequestParam String id) {
 * logger.info("Method: restshipmentList View Start");
 * 
 * logger.info("Method: restshipmentList ends"); return
 * posManager.restshipmentList(id); }
 * 
 * @GetMapping(value = "rest-shipping-details") public
 * ResponseEntity<JsonResponse<POSPackagingRestModel>>
 * restShippingDetails(@RequestParam String id) {
 * logger.info("Method :restShippingDetails starts");
 * 
 * logger.info("Method :restShippingDetails ends" + id); return
 * posManager.restShippingDetails(id);
 * 
 * }
 * 
 * @PostMapping(value = "addDeliveryPos") public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> addDeliveryPos(
 * 
 * @RequestBody List<POSPackagingRestModel> packageModel) {
 * logger.info("Method :addDeliveryPos starts");
 * logger.info("Method :addDeliveryPos endss"); return
 * posManager.addDeliveryPos(packageModel); }
 * 
 * @RequestMapping(value = "restdeliveryList", method = { RequestMethod.GET })
 * public ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>
 * restdeliveryList(@RequestParam String id) {
 * logger.info("Method: restdeliveryList View Start");
 * 
 * logger.info("Method: restdeliveryList ends"); return
 * posManager.restdeliveryList(id); }
 * 
 * @GetMapping(value = "rest-delivery-details") public
 * ResponseEntity<JsonResponse<POSPackagingRestModel>>
 * restDeliveryDetails(@RequestParam String id) {
 * logger.info("Method :restDeliveryDetails starts");
 * 
 * logger.info("Method :restDeliveryDetails ends" + id); return
 * posManager.restDeliveryDetails(id);
 * 
 * }
 * 
 * @PostMapping(value = "posOrderDelivered") public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>> posOrderDelivered(
 * 
 * @RequestBody List<POSPackagingRestModel> packageModel) {
 * logger.info("Method :posOrderDelivered starts");
 * logger.info("Method :posOrderDelivered endss"); return
 * posManager.posOrderDelivered(packageModel); }
 * 
 * @RequestMapping(value = "restAllDeliveredOrderList", method = {
 * RequestMethod.GET }) public
 * ResponseEntity<JsonResponse<List<POSPackagingRestModel>>>
 * restAllDeliveredOrderList(
 * 
 * @RequestParam String id) {
 * logger.info("Method: restAllDeliveredOrderList View Start");
 * 
 * logger.info("Method: restAllDeliveredOrderList ends"); return
 * posManager.restAllDeliveredOrderList(id); }
 * 
 * @GetMapping(value = "rest-delivered-details") public
 * ResponseEntity<JsonResponse<POSPackagingRestModel>>
 * restDeliveredDetails(@RequestParam String id) {
 * logger.info("Method :restDeliveredDetails starts");
 * 
 * logger.info("Method :restDeliveredDetails ends" + id); return
 * posManager.restDeliveredDetails(id);
 * 
 * } }
 */