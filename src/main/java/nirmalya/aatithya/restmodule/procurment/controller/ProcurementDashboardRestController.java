package nirmalya.aatithya.restmodule.procurment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.procurment.dao.ProcurementDashboardDao;
import nirmalya.aatithya.restmodule.procurment.model.ProcurementDashboardModel;
import nirmalya.aatithya.restmodule.procurment.model.RestProcurementPoRecptModel;
import nirmalya.aatithya.restmodule.procurment.model.RestProcurementStockDetailsModel;

@RestController
@RequestMapping(value = { "inventory/" })
public class ProcurementDashboardRestController {

	Logger logger = LoggerFactory.getLogger(ProcurementDashboardRestController.class);

	@Autowired
	ProcurementDashboardDao procurementDashboardDao;

	@GetMapping(value = "purchase-analysis")
	public List<ProcurementDashboardModel> restAddPurchaseAnalysis() {
		logger.info("Method : restAddPurchaseAnalysis starts");
		logger.info("Method : restAddPurchaseAnalysis ends");
		return procurementDashboardDao.restAddPurchaseAnalysis();
	}

	@GetMapping(value = "stock-analysis")
	public List<ProcurementDashboardModel> stock() {
		logger.info("Method : stock starts");
		logger.info("Method : stock ends");
		return procurementDashboardDao.stock();
	}

	@GetMapping(value = "poRecptHist-analysis")
	public List<ProcurementDashboardModel> poRecptHist() {
		logger.info("Method : poRecptHist starts");
		logger.info("Method : poRecptHist ends");
		return procurementDashboardDao.poRecptHist();
	}

	/*
	 * @GetMapping(value = "pending-invoices-analysis") public
	 * List<ProcurementDashboardModel> pendingInvoice() {
	 * logger.info("Method : pendingInvoice starts");
	 * logger.info("Method : pendingInvoice ends"); return
	 * procurementDashboardDao.pendingInvoice(); }
	 */
	@RequestMapping(value = "getMonthlyInitData", method = { RequestMethod.GET })
	public List<ProcurementDashboardModel> getMonthlyInitData() {

		logger.info("Method : getMonthlyInitData starts");
		logger.info("Method : getMonthlyInitData ends");

		return procurementDashboardDao.getMonthlyInitData();
	}

	@RequestMapping(value = "getReqiInitData", method = { RequestMethod.GET })
	public List<ProcurementDashboardModel> getReqiInitData() {

		logger.info("Method : getReqiInitData starts");
		logger.info("Method : getReqiInitData ends");

		return procurementDashboardDao.getReqiInitData();
	}

	@RequestMapping(value = "getPoInitData", method = { RequestMethod.GET })
	public List<ProcurementDashboardModel> getPoInitData() {

		logger.info("Method : getPoInitData starts");
		logger.info("Method : getPoInitData ends");

		return procurementDashboardDao.getPoInitData();
	}

	@RequestMapping(value = "getRequiData", method = { RequestMethod.GET })
	public List<ProcurementDashboardModel> getRequiData() {

		logger.info("Method : getRequiData starts");
		logger.info("Method : getRequiData ends");

		return procurementDashboardDao.getRequiData();
	}

	@RequestMapping(value = "getpurchaseTranData", method = { RequestMethod.GET })
	public List<DropDownModel> getpurchaseTranData() {

		logger.info("Method : getpurchaseTranData starts");
		logger.info("Method : getpurchaseTranData ends");

		return procurementDashboardDao.getpurchaseTranData();
	}

	@RequestMapping(value = "getreceivedData", method = { RequestMethod.GET })
	public List<DropDownModel> getreceivedData() {

		logger.info("Method : getreceivedData starts");
		logger.info("Method : getreceivedData ends");

		return procurementDashboardDao.getreceivedData();
	}

	@RequestMapping(value = "getreturnData", method = { RequestMethod.GET })
	public List<DropDownModel> getreturnData() {

		logger.info("Method : getreturnData starts");
		logger.info("Method : getreturnData ends");

		return procurementDashboardDao.getreturnData();
	}

	@RequestMapping(value = "getinventoryData", method = { RequestMethod.GET })
	public List<ProcurementDashboardModel> getinventoryData() {

		logger.info("Method : getinventoryData starts");
		logger.info("Method : getinventoryData ends");

		return procurementDashboardDao.getinventoryData();
	}

	
	@RequestMapping(value = "getstocksInTransit", method = { RequestMethod.GET })
	public List<ProcurementDashboardModel> getstocksInTransit() {

		logger.info("Method : getstocksInTransit starts");
		logger.info("Method : getstocksInTransit ends");

		return procurementDashboardDao.getstocksInTransit();
	}
	
	
	@RequestMapping(value = "getrequisitionData", method = { RequestMethod.GET })
	public List<RestProcurementStockDetailsModel> getrequisitionData() {

		logger.info("Method : getrequisitionData starts");
		logger.info("Method : getrequisitionData ends");

		return procurementDashboardDao.getrequisitionData();
	}
	
	@RequestMapping(value = "getpoRecptHistoryData", method = { RequestMethod.GET })
	public List<ProcurementDashboardModel> getpoRecptHistoryData() {

		logger.info("Method : getpoRecptHistoryData starts");
		logger.info("Method : getpoRecptHistoryData ends");

		return procurementDashboardDao.getpoRecptHistoryData();
	}
	
	
	@RequestMapping(value = "getpoRecptData", method = { RequestMethod.GET })
	public List<RestProcurementPoRecptModel> getpoRecptData() {

		logger.info("Method : getpoRecptData starts");
		logger.info("Method : getpoRecptData ends");

		return procurementDashboardDao.getpoRecptData();
	}
	
	
	@GetMapping(value = "pendingInvoice-analysis")
	public List<ProcurementDashboardModel> pendingInvoice() {
		logger.info("Method : pendingInvoice starts");
		logger.info("Method : pendingInvoice ends");
		return procurementDashboardDao.pendingInvoice();
	}

}
