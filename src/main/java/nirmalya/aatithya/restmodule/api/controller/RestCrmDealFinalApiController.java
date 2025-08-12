package nirmalya.aatithya.restmodule.api.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import nirmalya.aatithya.restmodule.api.dao.RestCrmDealFinalApiDao;
import nirmalya.aatithya.restmodule.api.model.RestCrmDealFinalApiModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.DocumentUpload;

@RestController
@RequestMapping(value = "api")
public class RestCrmDealFinalApiController {

	@Autowired
	RestCrmDealFinalApiDao restDealFinalApiDao;

	@Autowired
	EnvironmentVaribles env;

	@Autowired
	DocumentUpload documentUpload;

	Logger logger = LoggerFactory.getLogger(RestCrmDealFinalApiController.class);

//Add Deal Final
	@PostMapping(value = "post-deal-final-api", headers = "content-type=multipart/*", consumes = { "application/*" })
	public ResponseEntity<JsonResponse<Object>> postDealFinalApi(RestCrmDealFinalApiModel dealModel) {
		logger.info("Method : postDealFinalApi starts");
		MultipartFile x = dealModel.getMulFile();
		String fileName = null;
		if (x != null) {
			byte[] bytes = null;
			try {
				bytes = x.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileName = saveAllDocuments(bytes, dealModel.getExtension(), dealModel.getDealCreatedBy());
		}
		dealModel.setDocName(fileName);

		logger.info("Method : postDealFinalApi ends");
		return restDealFinalApiDao.postDealFinalApi(dealModel);
	}

	public String saveAllDocuments(byte[] imageBytes, String ext, String pId) {
		logger.info("Method : saveAllDocuments starts");

		String imageName = null;
		logger.info("ext===" + ext);
		try {

			if (imageBytes != null) {
				long nowTime = new Date().getTime();

				if (ext.contentEquals("jpeg") || ext.contentEquals("jpg")) {
					imageName = pId + "_" + nowTime + ".jpg";
				} else if (ext.contentEquals("png")) {
					imageName = pId + "_" + nowTime + ".png";
				} else {
					imageName = pId + "_" + nowTime + "." + ext;
				}
			}

			Path path = Paths.get(env.getFileUploadCRM() + imageName);
			if (imageBytes != null) {
				if (pId != null && pId != "") {
					Files.write(path, imageBytes);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : saveAllDocuments ends");
		return imageName;
	}

	// view deal
	@GetMapping(value = "viewDealDetails")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealDetails(@RequestParam String createdBy,
			String organization, String orgDivision) {
		logger.info("Method : viewDealDetails");

		logger.info("Method : viewDealDetails ends");
		return restDealFinalApiDao.viewDealDetails(createdBy, organization, orgDivision);
	}

	// view status
	@GetMapping(value = "viewDealStatus")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealStatus(@RequestParam String createdBy,
			String organization, String orgDivision) {
		logger.info("Method : viewDealStatus");

		logger.info("Method : viewDealStatus ends");
		return restDealFinalApiDao.viewDealStatus(createdBy, organization, orgDivision);
	}

	// get sale Manager
	@RequestMapping(value = "/getSalesManagerList", method = { RequestMethod.GET })
	public List<DropDownModel> getSalesManagerList(@RequestParam String createdBy, String organization,
			String orgDivision) {
		logger.info("Method : getSalesManagerList starts");

		logger.info("Method : getSalesManagerList end");
		return restDealFinalApiDao.getSalesManagerList(createdBy, organization, orgDivision);
	}

	// view deal search
	@GetMapping(value = "viewDealDetailsSearch")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealDetailsSearch(@RequestParam String createdBy,
			String organization, String orgDivision, String customer) {
		logger.info("Method : viewDealDetailsSearch");

		logger.info("Method : viewDealDetailsSearch ends");
		return restDealFinalApiDao.viewDealDetailsSearch(createdBy, organization, orgDivision, customer);
	}

	// view status
	@GetMapping(value = "viewDealStatusSearch")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealStatusSearch(@RequestParam String createdBy,
			String organization, String orgDivision, String customer) {
		logger.info("Method : viewDealStatusSearch");

		logger.info("Method : viewDealStatusSearch ends");
		return restDealFinalApiDao.viewDealStatusSearch(createdBy, organization, orgDivision, customer);
	}

	// view web deal status
	@GetMapping(value = "viewDealStatusReport")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealStatusReport(@RequestParam String createdBy,
			String organization, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : viewDealStatusReport");

		logger.info("Method : viewDealStatusReport ends");
		return restDealFinalApiDao.viewDealStatusReport(createdBy, organization, orgDivision, fromDate, toDate);
	}

	// view web deal status search
	@GetMapping(value = "viewDealStatusReportSearch")
	public JsonResponse<List<RestCrmDealFinalApiModel>> viewDealStatusReportSearch(@RequestParam String createdBy,
			String organization, String orgDivision, String fromDate, String toDate, String customer, String saleTeam) {
		logger.info("Method : viewDealStatusReportSearch");

		logger.info("Method : viewDealStatusReportSearch ends");
		return restDealFinalApiDao.viewDealStatusReportSearch(createdBy, organization, orgDivision, fromDate, toDate,
				customer, saleTeam);
	}

	@RequestMapping(value = "/restGetPaymentMode", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPaymentModeList() {
		logger.info("Method : getPaymentModeList starts");

		logger.info("Method : getPaymentModeList ends");
		return restDealFinalApiDao.getPaymentModeList();
	}

	@RequestMapping(value = "/restGetBanknameList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBankNameList() {
		logger.info("Method : getBankNameList starts");

		logger.info("Method : getBankNameList ends");
		return restDealFinalApiDao.getBankNameList();
	}
}
