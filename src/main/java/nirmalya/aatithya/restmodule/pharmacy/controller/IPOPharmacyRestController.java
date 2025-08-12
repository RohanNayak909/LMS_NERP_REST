package nirmalya.aatithya.restmodule.pharmacy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pharmacy.dao.IPOPharmacyDao;

@RestController
@RequestMapping(value = { "pharmacy/" })
public class IPOPharmacyRestController {
	Logger logger = LoggerFactory.getLogger(IPOPharmacyRestController.class);
	
	@Autowired
	IPOPharmacyDao ipoPharmacyDao;
	
	@RequestMapping(value = "rest-get-patient-list", method = { RequestMethod.GET })
	public List<DropDownModel> getPatientList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getPatientList starts");

		logger.info("Method : getPatientList ends");
		return ipoPharmacyDao.getPatientList(org, orgDiv);
	}
	
	@RequestMapping(value = "savePharmacy", method = { RequestMethod.POST })
    public ResponseEntity<JsonResponse<Object>> savePharmacy(
            @RequestBody String pharmacy) {
        logger.info("Method : savePharmacy  starts");

        logger.info("Method : savePharmacy  ends");
        return ipoPharmacyDao.savePharmacy(pharmacy);
    }
	
	/*
	 * @RequestMapping(value = "rest-pharmacyView", method = { RequestMethod.GET })
	 * public JsonResponse<Object> pharmacyView(@RequestParam String
	 * org, @RequestParam String orgDiv) {
	 * logger.info("Method :pharmacyView start");
	 * 
	 * logger.info("Method :pharmacyView endss"); return
	 * ipoPharmacyDao.pharmacyView(org,orgDiv); }
	 */
	
	@RequestMapping(value = "rest-pharmacyView", method = { RequestMethod.GET })
	public JsonResponse<Object> pharmacyView(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :pharmacyView start");

		logger.info("Method :pharmacyView endss");
		return ipoPharmacyDao.pharmacyView(org,orgDiv);
	}
	//PDF
	@RequestMapping(value = "rest-pharmacyPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> pharmacyPdf(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :pharmacyPdf start");

		logger.info("Method :pharmacyPdf endss");
		return ipoPharmacyDao.pharmacyPdf(id,orgName,orgDivision);

	}
}
