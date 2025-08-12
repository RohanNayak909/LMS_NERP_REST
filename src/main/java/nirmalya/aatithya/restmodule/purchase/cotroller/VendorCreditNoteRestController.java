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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.VendorCreditNoteDao;

@RestController
@RequestMapping("purchase/")
public class VendorCreditNoteRestController {
	Logger logger = LoggerFactory.getLogger(VendorCreditNoteRestController.class);

	@Autowired

	VendorCreditNoteDao vendorCreditNoteDao;

	@RequestMapping(value = "viewcreditNoteDataForVendor", method = { RequestMethod.GET })
	public JsonResponse<Object> viewcreditNoteDataForVendor(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method :viewcreditNoteDataForVendor start");

		logger.info("Method :viewcreditNoteDataForVendor endss");
		return vendorCreditNoteDao.viewcreditNoteDataForVendor(orgName, orgDivision,userId);

	}

}
