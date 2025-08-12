package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.RestTDSDao;
import nirmalya.aatithya.restmodule.master.model.RestTDSModel;

@RestController
@RequestMapping(value = "master/")
public class RestTDSController {
	Logger logger = LoggerFactory.getLogger(RestTDSController.class);

	@Autowired
	RestTDSDao restTDSDao;

	//employeeTdsView
	@GetMapping(value = "employee-tds-view-data")
	public JsonResponse<Object> employeeTdsView(@RequestParam String orgName,
			String orgDivision, String year, String month) {
		logger.info("Method : viewTDSdata starts");

		logger.info("Method : viewTDSdata ends");
		return restTDSDao.viewTDSdata(orgName, orgDivision, year, month);
	}
	//employeeTdsSave
	@PostMapping(value = "employee-tds-details-save")
	public ResponseEntity<JsonResponse<Object>> employeeTdsSave(@RequestBody RestTDSModel model) {
		logger.info("Method : employeeTdsSave starts");

		logger.info("Method : employeeTdsSave ends");
		return restTDSDao.employeeTdsSave(model);
	}

	//employeeTdsEdit
	@RequestMapping(value = "employee-tds-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> employeeTdsEdit(@RequestParam String id,String orgName,String orgDivision, String userId) {
		logger.info("Method : employeeTdsEdit rest starts");

		logger.info("Method :employeeTdsEdit rest ends");
		return restTDSDao.employeeTdsEdit(id,orgName, orgDivision, userId);
	}
//employeeTdsApprove
	@GetMapping(value = "employee-tds-approve")
	public JsonResponse<Object> employeeTdsApprove(@RequestParam String approveId,String orgName,String orgDivision, String userId) {
		logger.info("Method : employeeTdsApprove starts");

		logger.info("Method : employeeTdsApprove ends");
		return restTDSDao.employeeTdsApprove(approveId,orgName, orgDivision, userId);
	}
//employeeTdsDelete
	@GetMapping(value = "employee-tds-delete")
	public JsonResponse<Object> employeeTdsDelete(@RequestParam String dltId,String orgName,String orgDivision, String userId) {
		logger.info("Method : employeeTdsDelete starts");

		logger.info("Method : employeeTdsDelete ends");
		return restTDSDao.employeeTdsDelete(dltId,orgName, orgDivision, userId);
	}
}
