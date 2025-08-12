/*
 * package nirmalya.aatithya.restmodule.pos.controller;
 * 
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
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import nirmalya.aatithya.restmodule.common.utils.JsonResponse; import
 * nirmalya.aatithya.restmodule.pos.dao.StockDao; import
 * nirmalya.aatithya.restmodule.pos.model.StockProductRestModel;
 * 
 * @RestController
 * 
 * @RequestMapping(value = "ecommerce") public class StoreStockRestController {
 * Logger logger = LoggerFactory.getLogger(StoreStockRestController.class);
 * 
 * @Autowired StockDao stockDao;
 * 
 * 
 * @GetMapping(value = "pos-stocksview") public
 * JsonResponse<List<StockProductRestModel>> customerview(@RequestParam String
 * id, String userType) { logger.info("Method : customerview starts");
 * 
 * logger.info("Method : customerview ends"); return
 * stockDao.stocksview(id,userType); }
 * 
 * 
 * 
 * @GetMapping(value = "pos-stocksdit") public
 * ResponseEntity<JsonResponse<StockProductRestModel>> stocksdit(@RequestParam
 * String id,@RequestParam String userid, String userType) {
 * logger.info("Method :stocksdit starts");
 * 
 * logger.info("Method :stocksdit ends"+id); return
 * stockDao.stocksdit(id,userid,userType);
 * 
 * }
 * 
 * @PostMapping(value = "addStock") public
 * ResponseEntity<JsonResponse<List<StockProductRestModel>>> addStock(
 * 
 * @RequestBody List<StockProductRestModel> RestShoukeenCustomerOrderModel) {
 * logger.info("Method :addStock starts");
 * 
 * logger.info("Method :addStock endss"); return
 * stockDao.addStock(RestShoukeenCustomerOrderModel); } }
 */