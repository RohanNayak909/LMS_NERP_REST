package nirmalya.aatithya.restmodule.ticket.controller;

	import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
	import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
	import nirmalya.aatithya.restmodule.ticket.dao.WorkPermitRestDao;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	@RestController
	@RequestMapping("ticket/")
	public class WorkPermitRestController {
	    Logger logger = LoggerFactory.getLogger(WorkPermitRestController.class);
	    @Autowired
	    WorkPermitRestDao workPermitDao;

	    @Autowired
	    EnvironmentVaribles env;
	    //add workpermit
	    @RequestMapping(value = "saveWorkPermit", method = { RequestMethod.POST })
	    public ResponseEntity<JsonResponse<Object>> saveWorkPermit(
	            @RequestBody String workpermit) {
	        logger.info("Method : saveWorkPermit  starts");

	        logger.info("Method : saveWorkPermit  ends");
	        return workPermitDao.saveWorkPermit(workpermit);
	    }
	    //fetch all acheivement
	    @RequestMapping(value = "rest-fetch-workpermit", method = { RequestMethod.GET })
	    public JsonResponse<Object> fetchWorkPermitData(@RequestParam String org, @RequestParam String orgDiv) {
	        logger.info("Method :fetchWorkPermitData start");

	        logger.info("Method :fetchWorkPermitData endss");
	        return workPermitDao.fetchWorkPermitData(org,orgDiv);
	    }

	    //edit work permit
	    @RequestMapping(value = "edit-work-permit", method = { RequestMethod.GET })
	    public JsonResponse<Object> editWorkPermit(@RequestParam String org,@RequestParam String orgDiv,@RequestParam String id) {
	        logger.info("Method :editWorkPermit start");

	        logger.info("Method :editWorkPermit endss");
	        return workPermitDao.editWorkPermit(org,orgDiv,id);
	    }
	    // delete work permit
	    @RequestMapping(value = "rest-delete-workpermit", method = { RequestMethod.GET })
	    public ResponseEntity<JsonResponse<Object>> deleteWorkpermit(@RequestParam String id, String org, String div) {
	        logger.info("Method : deleteWorkpermit starts");

	        logger.info("Method : deleteWorkpermit ends");
	        return workPermitDao.deleteWorkpermit(id, org, div);

	    }	
	   //Approve
	    @RequestMapping(value = "rest-approve-workpermit", method = { RequestMethod.GET })
	    public ResponseEntity<JsonResponse<Object>> approveWorkpermit(@RequestParam String id, String org, String div, String userId) {
	        logger.info("Method : approveWorkpermit starts");

	        logger.info("Method : approveWorkpermit ends");
	        return workPermitDao.approveWorkpermit(id, org, div,userId);

	    }	

}
