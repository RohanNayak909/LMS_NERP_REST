package nirmalya.aatithya.restmodule.purchase.cotroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.purchase.dao.RmPmMaterialIssueDao;
import nirmalya.aatithya.restmodule.purchase.model.RestRmPmMaterialIssueModel;

@RestController
@RequestMapping(value = { "purchase" })
public class RestRmPmMaterialIssueController {
	
	Logger logger = LoggerFactory.getLogger(RestRmPmMaterialIssueController.class);
	@Autowired
	RmPmMaterialIssueDao rmPmMaterialIssueDao;
	
	

	// add.
	
	@PostMapping(value = "rest-addRmPmMaterialIssue")
	public ResponseEntity<JsonResponse<RestRmPmMaterialIssueModel>> addRmPmMaterialIssue(

			@RequestBody RestRmPmMaterialIssueModel restRmPmMaterialIssueModel) {
		logger.info("Method : addRmPmMaterialIssue starts");
		logger.info("Method : addRmPmMaterialIssue ends");
		return rmPmMaterialIssueDao.addRmPmMaterialIssue(restRmPmMaterialIssueModel);
	}
	
	// view
	
	@RequestMapping(value = "rest-viewRmPmMaterialIssue", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRmPmMaterialIssue(@RequestParam String org, String orgDiv) {
		logger.info("Method :viewRmPmMaterialIssue start");

		logger.info("Method :viewRmPmMaterialIssue endss");
		return rmPmMaterialIssueDao.viewRmPmMaterialIssue( org, orgDiv);
	}
	
	//Edit.
	
	@RequestMapping(value = "rest-editRmPmMaterialIssue", method = { RequestMethod.GET })
	public JsonResponse<Object> editRmPmMaterialIssue(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editRmPmMaterialIssue start");

		logger.info("Method :editRmPmMaterialIssue endss");
		return rmPmMaterialIssueDao.editRmPmMaterialIssue(id, orgName, orgDivision);
	}
	
	
	// Delete.
	
	@RequestMapping(value = "rest-deleterRmPmmMaterialIssue", method = { RequestMethod.GET })
	public JsonResponse<Object> deleterRmPmmMaterialIssue(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :deleterRmPmmMaterialIssue start");

		logger.info("Method :deleterRmPmmMaterialIssue endss");
		return rmPmMaterialIssueDao.deleterRmPmmMaterialIssue(id, orgName, orgDivision);
	}
	
	// Approve.
	
	@RequestMapping(value = "rest-approveRmPmMaterialIssue", method = { RequestMethod.GET })
	public JsonResponse<Object> approveRmPmMaterialIssue(@RequestParam String id, String orgName, String orgDivision, String approvedBy) {
		logger.info("Method :approveRmPmMaterialIssue start");

		logger.info("Method :approveRmPmMaterialIssue endss");
		return rmPmMaterialIssueDao.approveRmPmMaterialIssue(id, orgName, orgDivision, approvedBy);
	}

	
	@GetMapping(value = "rest-getRFQList")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getRFQList(
			@RequestParam String id,String type,String org, String orgDiv) {
		logger.info("Method : getRFQList starts");

		logger.info("Method :getRFQList endss");
		return rmPmMaterialIssueDao.getRFQList(id,type, org, orgDiv);
	}
	
	@RequestMapping(value = "rest-getItemDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> getItemDetails(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getItemDetails start");

		logger.info("Method :getItemDetails endss");
		return rmPmMaterialIssueDao.getItemDetails(id, orgName, orgDivision);
	}
	
	
}
