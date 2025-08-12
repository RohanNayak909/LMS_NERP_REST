package nirmalya.aatithya.restmodule.grc.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.InspectionGenerateRestDao;
import nirmalya.aatithya.restmodule.grc.model.InspectionGenerateRestModel;
import nirmalya.aatithya.restmodule.grc.model.InspectionGenerateRestSubModel;

@RestController
@RequestMapping(value = { "grc/" })
public class InspectionGenerateRestController {

	Logger logger = LoggerFactory.getLogger(InspectionGenerateRestController.class);
	@Autowired
	InspectionGenerateRestDao daoManager;

	// viewChecklist
	@RequestMapping(value = "rest-viewChecklist", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<InspectionGenerateRestSubModel>>> viewChecklist(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewChecklist starts" + id + " @@@@ " + org + " @@@@ " + orgDiv);

		logger.info("Method : viewChecklist ends");
		return daoManager.viewChecklist(id, org, orgDiv);
	}

	// addInspectionGenerate
	@PostMapping(value = "rest-addInspectionGenerate")
	public ResponseEntity<JsonResponse<InspectionGenerateRestModel>> addInspectionGenerate(
			@RequestBody InspectionGenerateRestModel model) {
		logger.info("Method :addInspectionGenerate starts" + model);
		logger.info("Method :addInspectionGenerate endss");
		return daoManager.addInspectionGenerate(model);
	}

	// viewInspection
	@RequestMapping(value = "rest-viewInspection", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<InspectionGenerateRestModel>>> viewInspection(@RequestParam String id,
			@RequestParam String uId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewInspection starts" + id + " @@@@ " + uId + " @@@@ " + org + " @@@@ " + orgDiv);

		logger.info("Method : viewInspection ends");
		return daoManager.viewInspection(id, uId, org, orgDiv);
	}

	// addInspectionGenerate
	@RequestMapping(value = "rest-editInspection")
	public ResponseEntity<JsonResponse<List<InspectionGenerateRestModel>>> editInspection(@RequestParam String id,
			@RequestParam String type, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :editInspection starts" + id + " @@@@ " + type + " @@@@ " + org + " @@@@ " + orgDiv);
		logger.info("Method :editInspection endss");
		return daoManager.editInspection(id, type, org, orgDiv);
	}

	// rest auto search
	@GetMapping(value = "rest-getVendorAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorAutoSearchList(@RequestParam String id) {
		logger.info("Method : getVendorAutoSearchList starts" + id);

		logger.info("Method :getVendorAutoSearchList endss");
		return daoManager.getVendorAutoSearchList(id);
	}

	// addInspectionGenerate
	@PostMapping(value = "rest-addAssignedTo")
	public ResponseEntity<JsonResponse<List<InspectionGenerateRestSubModel>>> addAssignedTo(
			@RequestBody List<InspectionGenerateRestSubModel> model) {
		logger.info("Method :addAssignedTo starts" + model);
		logger.info("Method :addAssignedTo endss");
		return daoManager.addAssignedTo(model);
	}

	/*
	 * delete
	 * 
	 */
	@RequestMapping(value = "deleteinspectionDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteinspectionDetails(@RequestParam String id,
			@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : deleteinspectionDetails starts");

		logger.info("Method : deleteinspectionDetails ends");
		return daoManager.deleteinspectionDetails(id, organization, orgDivision);
	}

	/*
	 * delete
	 * 
	 */
	@RequestMapping(value = "deletecheckListDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletecheckListDetails(@RequestParam String id,
			@RequestParam String checkId, @RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : deletecheckListDetails starts");

		logger.info("Method : deletecheckListDetails ends");
		return daoManager.deletecheckListDetails(id,checkId, organization, orgDivision);
	}
}
