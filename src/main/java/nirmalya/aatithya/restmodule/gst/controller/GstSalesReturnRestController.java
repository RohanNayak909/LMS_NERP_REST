package nirmalya.aatithya.restmodule.gst.controller;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gst.dao.GstSalesReturnDao;
import nirmalya.aatithya.restmodule.gst.model.GstReportRestModel;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gst")
public class GstSalesReturnRestController {
	Logger logger = LoggerFactory.getLogger(GstSalesReturnRestController.class);

	@Autowired
	GstSalesReturnDao gstSalesReturnDao;

	@RequestMapping(value = "getGstSalesInvoiceData", method = { RequestMethod.GET })
	public JsonResponse<Object> getGstSalesInvoiceData(@RequestParam String month, @RequestParam String year,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getGstSalesInvoiceData starts");

		logger.info("Method : getGstSalesInvoiceData ends");
		return gstSalesReturnDao.getSalesInvoiceData(month, year, org, orgDiv);
	}

	@RequestMapping(value = "deleteGstSalesInvoiceItem", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteGstSalesInvoiceItem(@RequestParam String invoiceNo, @RequestParam String itemId,
			@RequestParam String month, @RequestParam String year) {
		logger.info("Method : deleteGstSalesInvoiceItem starts");

		logger.info("Method : deleteGstSalesInvoiceItem ends");
		return gstSalesReturnDao.deleteGstSalesInvoiceItem(invoiceNo, itemId, month, year);
	}

	@RequestMapping(value = "getPurchasesasperRecord", method = { RequestMethod.GET })
	public JsonResponse<Object> getPurchasesasperRecord(@RequestParam String month, @RequestParam String year,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getPurchasesasperRecord starts");

		logger.info("Method : getPurchasesasperRecord ends");
		return gstSalesReturnDao.getPurchasesasperRecord(month, year, org, orgDiv);
	}

	@RequestMapping(value = "getInvoiceData", method = { RequestMethod.GET })
	public JsonResponse<Object> getInvoiceData(@RequestParam String month, @RequestParam String year) {
		logger.info("Method : getInvoiceData starts");

		logger.info("Method : getInvoiceData ends");
		return gstSalesReturnDao.getInvoiceData(month, year);
	}

	@RequestMapping(value = "sales-hsn", method = { RequestMethod.GET })
	public JsonResponse<Object> getHsnSales(@RequestParam String month, @RequestParam String year,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getHsnSales starts");

		logger.info("Method : getHsnSales ends");
		return gstSalesReturnDao.getHsnSales(month, year, org, orgDiv);
	}

	@RequestMapping(value = "purchase-hsn", method = { RequestMethod.GET })
	public JsonResponse<Object> getHsnPurchase(@RequestParam String month, @RequestParam String year,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getHsnPurchase starts");

		logger.info("Method : getHsnPurchase ends");
		return gstSalesReturnDao.getHsnPurchase(month, year, org, orgDiv);
	}

	// for 3B

	@RequestMapping(value = "viewGst3BList", method = { RequestMethod.GET })
	public JsonResponse<Object> viewGst3BList(@RequestParam String month, @RequestParam String year,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewGst3BList starts");

		logger.info("Method : viewGst3BList ends");
		return gstSalesReturnDao.viewGst3BList(month, year, org, orgDiv);
	}

	@GetMapping(value = "gst3BPdfReport")
	public ResponseEntity<JsonResponse<List<GstReportRestModel>>> gst3BPdfReport(@RequestParam String years,
			String months) {
		logger.info("Method :gst3BPdfReport starts");

		logger.info("Method :gst3BPdfReport ends");
		return gstSalesReturnDao.gst3BPdfReport(years, months);
	}

	@RequestMapping(value = "3B-hsn", method = { RequestMethod.GET })
	public JsonResponse<Object> getHsn3B(@RequestParam String month, @RequestParam String year,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getHsn3B starts");

		logger.info("Method : getHsn3B ends");
		return gstSalesReturnDao.getHsn3B(month, year, org, orgDiv);
	}

}
