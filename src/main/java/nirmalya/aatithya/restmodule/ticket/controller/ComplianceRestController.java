package nirmalya.aatithya.restmodule.ticket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.ticket.dao.ComplianceRestDao;


	@RestController
	@RequestMapping(value = { "ticket/" })
	public class ComplianceRestController {

		Logger logger = LoggerFactory.getLogger(ComplianceRestController.class);

		@Autowired
		ComplianceRestDao complianceRestDao;
		
		
		@PostMapping(value = "rest-addCompliance")
		public JsonResponse<Object> addCompliance(@RequestBody List<AssetViewMasterRestModel> assetMasterModel) {
			logger.info("Method : addCompliance starts");
			logger.info("Method : addCompliance ends");
			return complianceRestDao.addCompliance(assetMasterModel);
		}		
}
