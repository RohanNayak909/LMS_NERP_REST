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
import nirmalya.aatithya.restmodule.qa.dao.RestQaRequestDao;
import nirmalya.aatithya.restmodule.qa.model.LaminateModel;
import nirmalya.aatithya.restmodule.qa.model.QaSackRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestQaRequestModel;


@RestController
@RequestMapping(value = "production/")
public class RestQaRequestController {
	
	
	Logger logger = LoggerFactory.getLogger(RestQaRequestController.class);

	@Autowired
	RestQaRequestDao restQaRequestDao;

	@RequestMapping(value = "rest-viewQaRequstedData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewQaRequestData(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewQaRequestData start");

		logger.info("Method :viewQaRequestData endss");
		return restQaRequestDao.viewQaRequestData(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-qaRequestDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> qaRequestDtls(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :qaRequestDtls start");

		logger.info("Method :qaRequestDtls endss");
		return restQaRequestDao.qaRequestDtls(id, orgName, orgDivision);

	}
	
	
	@RequestMapping(value = "rest-qaRequestChangeStatus", method = { RequestMethod.GET })
	public JsonResponse<Object> qaRequestChangeStatus(@RequestParam String id,String QrCode, String orgName, String orgDivision) {
		logger.info("Method :qaRequestChangeStatus start");

		logger.info("Method :qaRequestChangeStatus endss");
		return restQaRequestDao.qaRequestChangeStatus(id,QrCode, orgName, orgDivision);

	}
	
	// Test Dtls.
	
	@RequestMapping(value = "rest-qaRequestTestDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> qaRequestTestDtls(@RequestParam String rid,String id,String sampleAmt, String orgName, String orgDivision) {
		logger.info("Method :qaRequestTestDtls start");

		logger.info("Method :qaRequestTestDtls endss");
		return restQaRequestDao.qaRequestTestDtls(rid, id ,sampleAmt, orgName, orgDivision);

	}
	
	
	// For Lami.
	
	@RequestMapping(value = "rest-qaRequestTestDtlsLami", method = { RequestMethod.GET })
	public JsonResponse<Object> qaRequestTestDtlsLami(@RequestParam String rid,String id,String sampleAmt, String orgName, String orgDivision) {
		logger.info("Method :qaRequestTestDtlsLami start");

		logger.info("Method :qaRequestTestDtlsLami endss");
		return restQaRequestDao.qaRequestTestDtlsLami(rid, id ,sampleAmt, orgName, orgDivision);

	}
	
	
	// For Sack.
	
	@RequestMapping(value = "rest-qaRequestTestDtlsSack", method = { RequestMethod.GET })
	public JsonResponse<Object> qaRequestTestDtlsSack(@RequestParam String rid,String id,String sampleAmt, String orgName, String orgDivision) {
		logger.info("Method :qaRequestTestDtlsSack start");

		logger.info("Method :qaRequestTestDtlsSack endss");
		return restQaRequestDao.qaRequestTestDtlsSack(rid, id ,sampleAmt, orgName, orgDivision);

	}
	
	
	
	// Test Result Submit.
	
	@RequestMapping(value = "rest-qaTestResultSubmit", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> qaTestResultSubmit(@RequestBody RestQaRequestModel data) {
		logger.info("Method :qaTestResultSubmit start");
		
		logger.info("Method :qaTestResultSubmit endss");
		return restQaRequestDao.qaTestResultSubmit(data);
	}
	
	// Test Result For Lami.
	
	@PostMapping(value = "rest-qaTestResultForLamiSubmit")
	public ResponseEntity<JsonResponse<List<LaminateModel>>> addLaminate(@RequestBody List<LaminateModel> laminateModel) {
		logger.info("Method : qaTestResultForLamiSubmit starts");
		logger.info("Method : qaTestResultForLamiSubmit ends");
		return restQaRequestDao.qaTestResultForLamiSubmit(laminateModel);
	}
	
	
	// Test Result For Sack.
	
	
	@PostMapping(value = "rest-qaTestResultForSackSubmit")
	public ResponseEntity<JsonResponse<List<QaSackRestModel>>> addSack(@RequestBody List<QaSackRestModel> sackModel) {
		logger.info("Method : qaTestResultForSackSubmit starts");
		logger.info("Method : qaTestResultForSackSubmit ends");
		return restQaRequestDao.qaTestResultForSackSubmit(sackModel);
	}	
	
	
	// Pdf
	
	@RequestMapping(value = "rest-qa-test-pdf", method = { RequestMethod.GET })
	public JsonResponse<Object> downloadTestResult(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :downloadTestResult start");

		logger.info("Method :downloadTestResult endss");
		return restQaRequestDao.downloadQaTestResult(id, orgName, orgDivision);
	}
	
	
	// Pdf Lami.
	
	@RequestMapping(value = "rest-qa-test-pdf-Lami", method = { RequestMethod.GET })
	public JsonResponse<Object> downloadLami(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :downloadLami start");

		logger.info("Method :downloadLami endss");
		return restQaRequestDao.downloadQaTestResultLami(id, orgName, orgDivision);
	}
	
	
	// Pdf Sack.
	
	@RequestMapping(value = "rest-qa-test-pdf-Sack", method = { RequestMethod.GET })
	public JsonResponse<Object> downloadSack(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :downloadPCRO start");

		logger.info("Method :downloadPCRO endss");
		return restQaRequestDao.downloadQaTestResultSack(id, orgName, orgDivision);
	}
	
	
	// Search
	@RequestMapping(value = "rest-qaRequestSearch", method = { RequestMethod.GET })
	public JsonResponse<Object> qaRequestSearch(@RequestParam String orgName, @RequestParam String orgDivision, String searchValue) {
		logger.info("Method :qaRequestSearch start");

		logger.info("Method :qaRequestSearch endss");
		return restQaRequestDao.qaRequestSearch(orgName, orgDivision, searchValue);

	}


}
