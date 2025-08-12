package nirmalya.aatithya.restmodule.his.controller;

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

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISOPDDao;
import nirmalya.aatithya.restmodule.his.dao.HisOpdBillingDao;
import nirmalya.aatithya.restmodule.his.model.ItemBillModel;

@RestController
@RequestMapping(value = "his/")
public class RestHisOpdBillingController {

	Logger logger = LoggerFactory.getLogger(HISOPDRestController.class);

	@Autowired
	HisOpdBillingDao hisOpdBillingDao;

	@RequestMapping(value = "categoryList", method = { RequestMethod.GET })
	public List<DropDownModel> categoryList(@RequestParam String org, String orgDiv) {
		logger.info("Method : categoryList starts");

		logger.info("Method : categoryList ends");
		return hisOpdBillingDao.categoryList(org, orgDiv);
	}

	@RequestMapping(value = "getSkuListCatWise", method = { RequestMethod.GET })
	public List<ItemBillModel> getSkuListCatWise(@RequestParam String org, String orgDiv, String cat_id) {
		logger.info("Method : getSkuListCatWise starts");

		logger.info("Method : getSkuListCatWise ends");
		return hisOpdBillingDao.getSkuListCatWise(org, orgDiv, cat_id);
	}

	// rest-viewOpdDetails
	@RequestMapping(value = "rest-opd-billing-viewOpdDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> viewOpdDetqails(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method :viewOpdDetqails start");
		logger.info("Method :viewOpdDetqails endss");
		return hisOpdBillingDao.viewOpdDetails(orgName, orgDivision, fromdate, todate);
	}

	@RequestMapping(value = "rest-opd-billing-editOpd", method = { RequestMethod.GET })
	public JsonResponse<Object> editOpd(@RequestParam String Id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :editOpd start");
		logger.info("Method :editOpd endss");
		return hisOpdBillingDao.editOpd(Id, organization, orgDivision);
	}
	
	@RequestMapping(value = "rest-opd-billing-get-balancesheet", method = { RequestMethod.GET })
	public JsonResponse<Object> getBalanceSheet(@RequestParam String id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :getBalanceSheet start");
		logger.info("Method :getBalanceSheet endss");
		return hisOpdBillingDao.getBalanceSheet(id, organization, orgDivision);
	}
	
	/*
	 * @RequestMapping(value = "rest-opd-billing-get-orderlist", method = {
	 * RequestMethod.GET }) public JsonResponse<Object>
	 * getOrderListRest(@RequestParam String id, @RequestParam String organization,
	 * 
	 * @RequestParam String orgDivision) {
	 * logger.info("Method :getOrderListRest start");
	 * logger.info("Method :getOrderListRest endss"); return
	 * hisOpdBillingDao.getOrderListDao(id, organization, orgDivision); }
	 * 
	 * @RequestMapping(value = "rest-opd-billing-orderdtls", method = {
	 * RequestMethod.GET }) public JsonResponse<Object>
	 * getOrderFullDetailstRest(@RequestParam String id, @RequestParam String
	 * bookId, @RequestParam String organization,
	 * 
	 * @RequestParam String orgDivision) {
	 * logger.info("Method :getOrderFullDetailstRest start");
	 * logger.info("Method :getOrderFullDetailstRest endss"); return
	 * hisOpdBillingDao.getOrderFullDetailstDao(id, bookId, organization,
	 * orgDivision); }
	 */

	@RequestMapping(value = "rest-saveBill", method = { RequestMethod.POST })
	public JsonResponse<Object> saveBill(@RequestParam String orgName, String orgDivision, String userId,
			@RequestBody String data) {
		logger.info("Method :saveBill start");

		logger.info("Method :saveBill endss");
		return hisOpdBillingDao.saveBill(orgName, orgDivision, userId, data);
	}
	
	/*
	 * @RequestMapping(value = "rest-modifyBillInvoice", method = {
	 * RequestMethod.POST }) public JsonResponse<Object>
	 * modifyBillInvoice(@RequestParam String orgName, String orgDivision, String
	 * userId,
	 * 
	 * @RequestBody String data) { logger.info("Method :modifyBillInvoice start");
	 * 
	 * logger.info("Method :modifyBillInvoice endss"); return
	 * hisOpdBillingDao.modifyBillInvoice(orgName, orgDivision, userId, data); }
	 */
	
	@RequestMapping(value = "ipdBillingPay", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> ipdBillingPay(@RequestParam String userId, String orgName, String orgDivision, @RequestBody String data) {
		logger.info("Method : ipdBillingPay starts");
		logger.info("Method : ipdBillingPay ends");
		return hisOpdBillingDao.ipdBillingPay(userId,orgName,orgDivision,data);
	}
	
	@RequestMapping(value = "rest-opd-billing-get-orderlist", method = { RequestMethod.GET })
	public JsonResponse<Object> getOrderListRest(@RequestParam String id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :getOrderListRest start");
		logger.info("Method :getOrderListRest endss");
		return hisOpdBillingDao.getOrderListDao(id, organization, orgDivision);
	}
	@RequestMapping(value = "rest-opd-billing-orderdtls", method = { RequestMethod.GET })
	public JsonResponse<Object> getOrderFullDetailstRest(@RequestParam String id, @RequestParam String bookId, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :getOrderFullDetailstRest start");
		logger.info("Method :getOrderFullDetailstRest endss");
		return hisOpdBillingDao.getOrderFullDetailstDao(id, bookId, organization, orgDivision);
	}
	@RequestMapping(value = "rest-modifyBillInvoice", method = { RequestMethod.POST })
	public JsonResponse<Object> modifyBillInvoice(@RequestParam String orgName, String orgDivision, String userId,
			@RequestBody String data) {
		logger.info("Method :modifyBillInvoice start");
		
		logger.info("Method :modifyBillInvoice endss");
		return hisOpdBillingDao.modifyBillInvoice(orgName, orgDivision, userId, data);
	}
	

}
