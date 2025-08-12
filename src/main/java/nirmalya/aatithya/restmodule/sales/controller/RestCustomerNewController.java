package nirmalya.aatithya.restmodule.sales.controller;

import java.util.List;
import java.util.Map;

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
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.master.model.ProductDetailsModel;
import nirmalya.aatithya.restmodule.sales.dao.CustomerNewDao;
import nirmalya.aatithya.restmodule.sales.model.RestCustoomerNewModel;




@RestController
@RequestMapping(value = "sales/")

public class RestCustomerNewController {

Logger logger = LoggerFactory.getLogger(RestCustomerNewController.class);
	
	@Autowired
	
	CustomerNewDao customerNewDao;
	
	
	
	
	@RequestMapping(value="addAccountCustomer" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<RestCustoomerNewModel>> addAccountCustomer(@RequestBody RestCustoomerNewModel restCustoomerNewModel) 
	{
		logger.info("Method : addAccountCustomer starts");
		
		logger.info("addAccount---------------------"+restCustoomerNewModel);
		
		logger.info("Method : addAccountCustomer ends");
		
		return customerNewDao.addAccountCustomer(restCustoomerNewModel);
	}
	

		
	//restViewCustDtls
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewCustDtls" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCustoomerNewModel>>> restViewCustDtls(){
		logger.info("Method: restViewCustDtls View Start");
		
		logger.info("Method: restViewCustDtls ends");
		return customerNewDao.restViewCustDtls();
	}
	
	
	//editAccCusInfo

	
	@GetMapping(value = "editAccCusInfo")
	public ResponseEntity<JsonResponse<List<RestCustoomerNewModel>>> editAccCusInfo(@RequestParam String id) {
		logger.info("Method :editAccCusInfo starts");

		logger.info("Method :editAccCusInfo ends"+id);
		return customerNewDao.editAccCusInfo(id);

	}
	
	//getStateLists1
	
	@RequestMapping(value = "getStateLists1",method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateLists1(@RequestParam String id) {
		logger.info("Method : getStateLists1 starts");
		logger.info("Method : getStateLists1 ends");
		return customerNewDao.getStateLists1(id);
	}
	
	
	//delete-customer-Details
	
	@RequestMapping(value = "deleteCusAccDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCusAccDetails(@RequestParam String id) {
		logger.info("Method :  deleteCusAccDetails starts"+id);

		logger.info("Method :  deleteCusAccDetails ends");
		return customerNewDao.deleteCusAccDetails(id);
	}
	
	@RequestMapping(value = "saveAddressDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<RestCustoomerNewModel>> saveProductDetails(@RequestBody RestCustoomerNewModel restCustoomerNewModel) {
		logger.info("Method : saveAddressDetails starts");
		
		logger.info("Method : saveAddressDetails ends");
		return customerNewDao.saveAddressDetails(restCustoomerNewModel);
	}
	
	@RequestMapping(value = "rest-viewShippingDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> viewShippingDetails(@RequestParam String customerIdd, String orgName, String orgDivision) {
		logger.info("Method :viewShippingDetails start");

		logger.info("Method :viewShippingDetails endss");
		return customerNewDao.viewShippingDetails(customerIdd,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-editShippingDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> editShippingDetails(@RequestParam String addressId,String orgName, String orgDivision) {
		logger.info("Method :editShippingDetails start");

		logger.info("Method :editShippingDetails endss");
		return customerNewDao.editShippingDetails(addressId,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-deleteaddressdata", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteaddressdata(@RequestParam String deleteId, String org,String orgDiv) {
		logger.info("Method :deleteaddressdata start");

		logger.info("Method :deleteaddressdata endss");
		return customerNewDao.deleteaddressdata(deleteId,org, orgDiv);
	}
	/*
	 * @GetMapping(value = "panDuplicateCheck") public
	 * ResponseEntity<JsonResponse<List<RestCustoomerNewModel>>>
	 * panDuplicateCheck(@RequestParam String id) {
	 * logger.info("Method :panDuplicateCheck starts");
	 * 
	 * logger.info("Method :panDuplicateCheck ends"+id); return
	 * customerNewDao.panDuplicateCheck(id);
	 * 
	 * }
	 */
	@PostMapping("rest-update-shipping-address")
	public JsonResponse<Object> updateShippingAddress(@RequestBody List<Map<String, Object>> dataset) {
		logger.info("Method : updateShippingAddress starts");

		logger.info("Method : updateShippingAddress ends");
		return customerNewDao.updateShippingAddress(dataset);
	}
}
