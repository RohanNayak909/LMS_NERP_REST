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
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import nirmalya.aatithya.restmodule.pos.model.StorePosRestModel; import
 * nirmalya.aatithya.restmodule.common.utils.DropDownModel; import
 * nirmalya.aatithya.restmodule.common.utils.JsonResponse; import
 * nirmalya.aatithya.restmodule.pos.dao.PosProfileRestDao;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping(value = "ecommerce/") public class PosProfileRestController {
 * 
 * Logger logger = LoggerFactory.getLogger(PosProfileRestController.class);
 * 
 * @Autowired PosProfileRestDao posProfileDao;
 * 
 * @GetMapping(value = "viewProfilePosCounter") public
 * ResponseEntity<JsonResponse<List<StorePosRestModel>>>
 * viewPosProfile(@RequestParam String id) {
 * logger.info("Method :viewPosProfile starts");
 * 
 * logger.info("Method :viewPosProfile ends" + id); return
 * posProfileDao.viewPosProfile(id); }
 * 
 * @RequestMapping(value = "addProfilePosCounter", method = { RequestMethod.POST
 * }) public ResponseEntity<JsonResponse<Object>> addProfilePosCounter(
 * 
 * @RequestBody StorePosRestModel storePosRestModel) {
 * logger.info("Method : addProfilePosCounter starts");
 * 
 * logger.info("Method : addProfilePosCounter ends");
 * 
 * return posProfileDao.addProfilePosCounter(storePosRestModel); }
 * 
 * 
 * @RequestMapping(value="updateposCounterPassword" ,
 * method={RequestMethod.POST}) public ResponseEntity<JsonResponse<Object>>
 * updatePosCounterPassword(@RequestBody StorePosRestModel factoryDetails) {
 * logger.info("Method : updateposCounterPassword starts");
 * 
 * logger.info("Method : updateposCounterPassword ends");
 * 
 * return posProfileDao.updateposCounterPassword(factoryDetails); }
 * 
 * @GetMapping(value = "getposCounterOTP") public JsonResponse<DropDownModel>
 * getposCounterOTP(@RequestParam String userId) {
 * logger.info("Method : getposCounterOTP starts");
 * 
 * logger.info("Method : getposCounterOTP ends"); return
 * posProfileDao.getposOTP(userId); }
 * 
 * 
 * }
 */