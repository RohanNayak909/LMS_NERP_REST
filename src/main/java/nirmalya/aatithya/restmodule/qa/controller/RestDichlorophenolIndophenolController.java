package nirmalya.aatithya.restmodule.qa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.qa.dao.DichlorophenolIndophenolDao;
import nirmalya.aatithya.restmodule.qa.model.RestDichlorophenolIndophenolModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestDichlorophenolIndophenolController {
	Logger logger = LoggerFactory.getLogger(RestDichlorophenolIndophenolController.class);
	@Autowired
	DichlorophenolIndophenolDao dichlorophenolIndophenolDao;
	@PostMapping(value = "rest-addDcip")
	public ResponseEntity<JsonResponse<List<RestDichlorophenolIndophenolModel>>> addDcip(

			@RequestBody List<RestDichlorophenolIndophenolModel> dichlorophenolIndophenolModel) {
		logger.info("Method : addDcip starts");
		logger.info("Method : addDcip ends");
		return dichlorophenolIndophenolDao.addDcip(dichlorophenolIndophenolModel);
	}
	@RequestMapping(value = "rest-getDcpipView", method = { RequestMethod.GET })
	public JsonResponse<Object> getDcpipView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getDcpipView start");

		logger.info("Method :getDcpipView endss");
		return dichlorophenolIndophenolDao.getDcpipView(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-editDcpip", method = { RequestMethod.GET })
	public JsonResponse<Object> editDcpip(@RequestParam String dcpipId, String orgName, String orgDivision) {
		logger.info("Method :editDcpip start");

		logger.info("Method :editDcpip endss");
		return dichlorophenolIndophenolDao.editDcpip(dcpipId, orgName, orgDivision);
	}
	@RequestMapping(value = "rest-deleteDcpip", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDcpip(@RequestParam String id, String org, String orgDivision) {
		logger.info("Method : deleteDcpip starts");

		logger.info("Method : deleteDcpip ends");
		return dichlorophenolIndophenolDao.deleteDcpip(id, org, orgDivision);

	}
	@RequestMapping(value = "rest-approveDcpip", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveDcpip(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveDcpip starts");
		logger.info("Method : approveDcpip ends");
		return dichlorophenolIndophenolDao.approveDcpip(id, org, orgDiv);

	}
//
	//PDF
		@RequestMapping(value = "rest-dichloroIndophenolPdf", method = { RequestMethod.GET })
		public JsonResponse<Object> dichloroIndophenolPdf(@RequestParam String id,String orgName, String orgDivision) {
			logger.info("Method :dichloroIndophenolPdf start");

			logger.info("Method :dichloroIndophenolPdf endss");
			return dichlorophenolIndophenolDao.dichloroIndophenolPdf(id,orgName,orgDivision);

		}
}

