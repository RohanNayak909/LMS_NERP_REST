package nirmalya.aatithya.restmodule.qa.controller;

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
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.employee.dao.TravelRequsitionRestDao;
import nirmalya.aatithya.restmodule.employee.model.TravelRequisitionRestModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.qa.dao.QcMasterDao;
import nirmalya.aatithya.restmodule.qa.dao.QcPcroDao;
import nirmalya.aatithya.restmodule.qa.model.QaPcroRestModel;
import nirmalya.aatithya.restmodule.qa.model.QcMasterRestModel;

@RestController
@RequestMapping(value = { "production/" })
public class QcPcroRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	QcPcroDao qcPcroDao;

	// viewPCRO
	@RequestMapping(value = "rest-pcro-shift-slno", method = { RequestMethod.GET })
	public JsonResponse<Object> getShiftSlno(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getShiftSlno start");

		logger.info("Method :getShiftSlno endss");
		return qcPcroDao.getShiftSlno(orgName, orgDivision);
	}
	// viewMain
		@RequestMapping(value = "rest-pcro-view", method = { RequestMethod.GET })
		public JsonResponse<Object> getTotalView(@RequestParam String orgName, String orgDivision) {
			logger.info("Method :getTotalView start");

			logger.info("Method :getTotalView endss");
			return qcPcroDao.getTotalView(orgName, orgDivision);
		}

	// addPCRO
	@PostMapping(value = "rest-pcro-details-add")
	public ResponseEntity<JsonResponse<List<QaPcroRestModel>>> addQc(

			@RequestBody List<QaPcroRestModel> qaPcroRestModel) {
		logger.info("Method : restaddQc starts");
		logger.info("Method : restaddQc ends");
		return qcPcroDao.addPcro(qaPcroRestModel);
	}
	
	// editPCRO
	@RequestMapping(value = "rest-pcro-reqst-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> downloadPCRO(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :downloadPCRO start");

		logger.info("Method :downloadPCRO endss");
		return qcPcroDao.downloadPcro(id, orgName, orgDivision);
	}
	
	// editPCROView
		@RequestMapping(value = "rest-pcro-reqst-editview", method = { RequestMethod.GET })
		public JsonResponse<Object> editPCRO(@RequestParam String id, String orgName, String orgDivision) {
			logger.info("Method :editPCRO start");

			logger.info("Method :editPCRO endss");
			return qcPcroDao.editPcroView(id, orgName, orgDivision);
		}
	
	// deletePcro
		@RequestMapping(value = "rest-pcro-detls-delete", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deletePcro(@RequestParam String id, String org, String div) {
			logger.info("Method : deletePcro starts");

			logger.info("Method : deletePcro ends");
			return qcPcroDao.deletePcro(id, org, div);

		}
		
		// approvePcro
				@RequestMapping(value = "rest-pcro-detls-approve", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<Object>> restapprovePcro(@RequestParam String id, String org, String div) {
					logger.info("Method : approvePcro starts");

					logger.info("Method : approvePcro ends");
					return qcPcroDao.approvePcro(id, org, div);

				}
				
				// editPCROView
				@RequestMapping(value = "rest-pcro-product_detls_drop", method = { RequestMethod.GET })
				public JsonResponse<Object> productDetailsDrop(@RequestParam String id, String orgName, String orgDivision) {
					logger.info("Method :productDetailsDrop start");

					logger.info("Method :productDetailsDrop endss");
					return qcPcroDao.productDetailsDrop(id, orgName, orgDivision);
				}
			

		
}