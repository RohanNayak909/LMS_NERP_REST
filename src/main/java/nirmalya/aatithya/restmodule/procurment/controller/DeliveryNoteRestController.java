package nirmalya.aatithya.restmodule.procurment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.dao.DeliveryNoteDao;
import nirmalya.aatithya.restmodule.procurment.model.DeliveryNoteModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryProductModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory/" })
public class DeliveryNoteRestController {

	Logger logger = LoggerFactory.getLogger(DeliveryNoteRestController.class);

	@Autowired
	DeliveryNoteDao deliveryNoteDao;
	
	@GetMapping(value = "getDeliveryMethod")
	public List<DropDownModel> getDeliveryMethod() {
		logger.info("Method : getDeliveryMethod starts");
		 
		logger.info("Method : getDeliveryMethod endss");
		return deliveryNoteDao.getDeliveryMethod();
	}
	
	@GetMapping(value = "getDeliveryNoteList")
	public List<DeliveryNoteModel> getDeliveryNoteList(@RequestParam String vendorId,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getDeliveryNoteList starts");
		
		logger.info("Method : getDeliveryNoteList endss");
		return deliveryNoteDao.getDeliveryNoteList(vendorId,org,orgDiv);
	}
	
	@GetMapping(value = "getDeliveryItemNoteList")
	public List<InventoryProductModel> getDeliveryItemNoteList(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getDeliveryItemNoteList starts");
		
		logger.info("Method : getDeliveryItemNoteList endss");
		return deliveryNoteDao.getDeliveryItemNoteList(id,org,orgDiv);
	}
	
	@GetMapping(value = "getDelNoteDtlsById")
	public ResponseEntity<JsonResponse<DeliveryNoteModel>> getDelNoteDtlsById(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getDelNoteDtlsById starts");
		
		logger.info("Method : getDelNoteDtlsById ends");
		return deliveryNoteDao.getDelNoteDtlsById(id,org,orgDiv);
	}
	
	@PostMapping(value = "saveDeliveryNoteDetails")
	public ResponseEntity<JsonResponse<Object>> saveDeliveryNoteDetails(@RequestBody List<DeliveryNoteModel> delnote) {
		logger.info("Method : saveDeliveryNoteDetails starts");
		
		logger.info("Method : saveDeliveryNoteDetails ends");
		return deliveryNoteDao.saveDeliveryNoteDetails(delnote);
	}
	
	@PostMapping(value = "submitToCompany")
	public ResponseEntity<JsonResponse<Object>> submitToCompany(@RequestBody DeliveryNoteModel delnote) {
		logger.info("Method : submitToCompany starts");
		
		logger.info("Method : submitToCompany ends");
		return deliveryNoteDao.submitToCompany(delnote);
	}
	
	@PostMapping(value = "createNewDeliveryNote")
	public ResponseEntity<JsonResponse<Object>> createNewDeliveryNote(@RequestBody DeliveryNoteModel delnote) {
		logger.info("Method : createNewDeliveryNote starts");
		
		logger.info("Method : createNewDeliveryNote ends");
		return deliveryNoteDao.createNewDeliveryNote(delnote);
	}
}
