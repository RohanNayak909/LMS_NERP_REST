/*
 * package nirmalya.aatithya.restmodule.pos.controller;
 * 
 * import java.util.List;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import nirmalya.aatithya.restmodule.common.utils.DropDownModel; import
 * nirmalya.aatithya.restmodule.common.utils.JsonResponse; import
 * nirmalya.aatithya.restmodule.pos.dao.PosDao; import
 * nirmalya.aatithya.restmodule.pos.model.POSCustomerDetailsRestModel; import
 * nirmalya.aatithya.restmodule.pos.model.POSDashboardRestModel; import
 * nirmalya.aatithya.restmodule.pos.model.POSRestModel;
 * 
 * @RestController
 * 
 * @RequestMapping(value = "ecommerce") public class PosRestController { Logger
 * logger = LoggerFactory.getLogger(PosRestController.class);
 * 
 * @Autowired PosDao posDao;
 * 
 * // catogary list
 * 
 * @GetMapping(value = "pos-catogarylist") public
 * JsonResponse<List<DropDownModel>> catogarylist(@RequestParam String userid) {
 * logger.info("Method : catogarylist starts");
 * 
 * logger.info("Method : catogarylist ends"); return
 * posDao.catogarylist(userid); }
 * 
 * // updated sub category list according to stock
 * 
 * @GetMapping(value = "pos-productSubCatogary") public
 * JsonResponse<List<POSRestModel>> subcatogarylist(@RequestParam String id,
 * String userId) { logger.info("Method : subcatogarylist starts");
 * logger.info("Method : subcatogarylist ends"); return
 * posDao.subcatogarylist(id, userId); }
 * 
 * // updated product list according to stock
 * 
 * @GetMapping(value = "pos-productList") public
 * JsonResponse<List<POSRestModel>> productList(@RequestParam String id, String
 * userId) { logger.info("Method : productList starts");
 * logger.info("Method : productList ends"); return posDao.productList(id,
 * userId); }
 * 
 * // product size list
 * 
 * @GetMapping(value = "pos-productSizeList") public
 * JsonResponse<List<POSRestModel>> productSizeList(@RequestParam String id,
 * String userId) { logger.info("Method : productSizeList starts");
 * logger.info("Method : productSizeList ends"); return
 * posDao.productSizeList(id, userId); }
 * 
 * // product Stock list
 * 
 * @GetMapping(value = "pos-viewStock") public JsonResponse<List<POSRestModel>>
 * viewStock(@RequestParam String id, @RequestParam String size, String userId)
 * { logger.info("Method : viewStock starts");
 * 
 * logger.info("Method : viewStock ends"); return posDao.viewStock(id, size,
 * userId); }
 * 
 * // add order details
 * 
 * @RequestMapping(value = "addOrderDetails", method = { RequestMethod.POST })
 * public ResponseEntity<JsonResponse<Object>> addOrderDetails(@RequestBody
 * POSCustomerDetailsRestModel posOrder) {
 * logger.info("Method : addOrderDetails starts");
 * 
 * logger.info("Method : addOrderDetails ends");
 * 
 * return posDao.addOrderDetails(posOrder); } // customer details
 * 
 * @GetMapping(value = "pos-customerDetails") public
 * JsonResponse<List<POSCustomerDetailsRestModel>> customerDetails(@RequestParam
 * String id) { logger.info("Method : customerDetails starts");
 * 
 * logger.info("Method : customerDetails ends"); return
 * posDao.customerDetails(id); }
 * 
 * @GetMapping(value = "pos-customerview") public
 * JsonResponse<List<POSCustomerDetailsRestModel>> customerview(@RequestParam
 * String id, String pageno) { logger.info("Method : customerview starts");
 * 
 * logger.info("Method : customerview ends"); return posDao.customerview(id,
 * pageno); }
 * 
 * @GetMapping(value = "pos-customeredit") public
 * JsonResponse<List<POSCustomerDetailsRestModel>> customeredit(@RequestParam
 * String id) { logger.info("Method : customeredit starts");
 * 
 * logger.info("Method : customeredit ends"); return posDao.customeredit(id); }
 * 
 * @GetMapping(value = "getPOSDashboard") public
 * JsonResponse<List<POSDashboardRestModel>> getPOSDashboard(@RequestParam
 * String id) { logger.info("Method :getPOSDashboard starts");
 * logger.info("Method :getPOSDashboard endss"); return
 * posDao.getPOSDashboard(id);
 * 
 * }
 * 
 * @GetMapping(value = "getDealerPOSDashboard") public
 * JsonResponse<List<POSDashboardRestModel>> getDealerPOSDashboard(@RequestParam
 * String id) { logger.info("Method :getDealerPOSDashboard starts");
 * logger.info("Method :getDealerPOSDashboard endss"); return
 * posDao.getDealerPOSDashboard(id);
 * 
 * }
 * 
 * @GetMapping(value = "getManagerDashboard") public
 * JsonResponse<List<POSDashboardRestModel>> getManagerDashboard(@RequestParam
 * String id) { logger.info("Method :getManagerDashboard starts");
 * logger.info("Method :getManagerDashboard endss"); return
 * posDao.getManagerDashboard(id);
 * 
 * }
 * 
 * // pos-productSizeSearchList
 * 
 * @GetMapping(value = "pos-productSizeSearchList") public
 * JsonResponse<List<POSRestModel>> productSizeSearchList(@RequestParam String
 * id,
 * 
 * @RequestParam String searchKey) {
 * logger.info("Method : productSizeSearchList starts");
 * 
 * logger.info("Method : productSizeSearchList ends"); return
 * posDao.productSizeSearchList(id, searchKey); }
 * 
 * @GetMapping(value = "getCurrentStockPos") public
 * JsonResponse<List<POSRestModel>> getCurrentStockPos(@RequestParam String
 * productId, String size, String userId) {
 * logger.info("Method : getCurrentStockPos starts");
 * 
 * logger.info("Method : getCurrentStockPos ends"); return
 * posDao.getCurrentStockPos(productId, size, userId); } }
 */