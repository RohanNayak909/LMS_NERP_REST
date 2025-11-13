/*
 * package nirmalya.aatithya.restmodule.hotel.controller;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import nirmalya.aatithya.restmodule.common.utils.JsonResponse; import
 * nirmalya.aatithya.restmodule.hotel.dao.OrganisationFreeTrialRegestrationDao;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping(value = { "user" }) public class
 * RestOrganisationFreeTrialRegestration { Logger logger =
 * LoggerFactory.getLogger(RestOrganisationFreeTrialRegestration.class);
 * 
 * @Autowired OrganisationFreeTrialRegestrationDao
 * organisationFreeTrialRegestrationDao;
 * 
 * @PostMapping(value = "free-trail-org-registration") public
 * ResponseEntity<JsonResponse<Object>> freeTrailOrgRegistartion(@RequestBody
 * String orgData) { logger.info("Method :freeTrailOrgRegistartion starts");
 * logger.info("Method :freeTrailOrgRegistartion endss"); return
 * organisationFreeTrialRegestrationDao.freeTrailOrgRegistartion(orgData); } }
 */