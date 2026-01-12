package nirmalya.aatithya.restmodule.procurment.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.procurment.model.ProcurementDashboardModel;
import nirmalya.aatithya.restmodule.procurment.model.RestProcurementPoRecptModel;
import nirmalya.aatithya.restmodule.procurment.model.RestProcurementStockDetailsModel;

@Repository
public class ProcurementDashboardDao {
	Logger logger = LoggerFactory.getLogger(ProcurementDashboardDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<ProcurementDashboardModel> restAddPurchaseAnalysis() {
		logger.info("Method : restAddPurchaseAnalysis starts");

		List<ProcurementDashboardModel> response = new ArrayList<ProcurementDashboardModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "restAddPurchaseAnalysis").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[4] != null) {
					date = m[4].toString();
				}

				ProcurementDashboardModel purchase = new ProcurementDashboardModel(m[0], m[1], m[2], m[3], date, m[5],
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null);

				if (purchase.getStatus().contentEquals("1")) {
					purchase.setStatus("Approve");
				} else if (purchase.getStatus().contentEquals("0")) {
					purchase.setStatus("Active");
				} else if (purchase.getStatus().contentEquals("2")) {
					purchase.setStatus("Pending");
				} else if (purchase.getStatus().contentEquals("3")) {
					purchase.setStatus("Rejected ");
				}
				response.add(purchase);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : restAddPurchaseAnalysis ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<ProcurementDashboardModel> stock() {
		logger.info("Method : stock starts");

		List<ProcurementDashboardModel> response = new ArrayList<ProcurementDashboardModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "stockAnalysis").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				ProcurementDashboardModel purchase = new ProcurementDashboardModel(null, null, null, null, null, null,
						null, m[0], m[1], m[2], m[3], null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null);

				response.add(purchase);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : stock ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<ProcurementDashboardModel> poRecptHist() {
		logger.info("Method : poRecptHist starts");

		List<ProcurementDashboardModel> response = new ArrayList<ProcurementDashboardModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "poRecptHist").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				String rdate = null;
				if (m[4] != null) {
					rdate = m[4].toString();
				}

				ProcurementDashboardModel purchase = new ProcurementDashboardModel(null, null, null, null, null, null,
						null, null, null, null, null, null, m[0], m[1], m[2], m[3], rdate, m[5], null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null);

				if (purchase.getPoStatus().contentEquals("1")) {
					purchase.setPoStatus("Approve");
				} else if (purchase.getPoStatus().contentEquals("0")) {
					purchase.setPoStatus("Active");
				} else if (purchase.getPoStatus().contentEquals("2")) {
					purchase.setPoStatus("Pending");
				} else if (purchase.getPoStatus().contentEquals("3")) {
					purchase.setPoStatus("Rejected ");
				}
				response.add(purchase);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : poRecptHist ends");
		return response;
	}

	public List<ProcurementDashboardModel> getMonthlyInitData() {

		logger.info("Method : getMonthlyInitData ends");

		List<ProcurementDashboardModel> result = new ArrayList<ProcurementDashboardModel>();

		try {
			String value = "SET @p_totalVendor='" + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "getVendorData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				BigInteger i = (BigInteger) m[0];
				Integer val = Integer.parseInt(i.toString());
				double d = Double.parseDouble(val.toString());
				ProcurementDashboardModel data = new ProcurementDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, d, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null);
				result.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getMonthlyInitData ends");
		return result;
	}

	public List<ProcurementDashboardModel> getReqiInitData() {

		logger.info("Method : getReqiInitData ends");

		List<ProcurementDashboardModel> result = new ArrayList<ProcurementDashboardModel>();

		try {
			String value = "SET @p_totalStocks='" + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "getReqiInitData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				BigInteger i = (BigInteger) m[0];
				Integer val = Integer.parseInt(i.toString());
				double d = Double.parseDouble(val.toString());
				ProcurementDashboardModel data = new ProcurementDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, d, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null);
				result.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getReqiInitData ends");
		return result;
	}

	public List<ProcurementDashboardModel> getPoInitData() {

		logger.info("Method : getPoInitData ends");

		List<ProcurementDashboardModel> result = new ArrayList<ProcurementDashboardModel>();

		try {
			String value = "SET @p_totalPo='" + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "getPoInitData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				BigInteger i = (BigInteger) m[0];
				Integer val = Integer.parseInt(i.toString());
				double d = Double.parseDouble(val.toString());
				ProcurementDashboardModel data = new ProcurementDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, d, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null);
				result.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPoInitData ends");
		return result;
	}

	public List<ProcurementDashboardModel> getRequiData() {

		logger.info("Method : getRequiData ends");

		List<ProcurementDashboardModel> result = new ArrayList<ProcurementDashboardModel>();

		try {
			String value = "SET @p_totalRequi='" + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "getRequiData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				BigInteger i = (BigInteger) m[0];
				Integer val = Integer.parseInt(i.toString());
				double d = Double.parseDouble(val.toString());
				ProcurementDashboardModel data = new ProcurementDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, d, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null);
				result.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRequiData ends");
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getpurchaseTranData() {
		logger.info("Method : getpurchaseTranData  starts");

		List<DropDownModel> purchaseTranData = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "getpurchaseTranData").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				purchaseTranData.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : RESTMODULE getAuditorName  ends");

		return purchaseTranData;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getreceivedData() {
		logger.info("Method : getreceivedData  starts");

		List<DropDownModel> purchaseTranData = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "getreceivedData").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				purchaseTranData.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getreceivedData ends");

		return purchaseTranData;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getreturnData() {
		logger.info("Method : getreturnData  starts");

		List<DropDownModel> returnData = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "getreturnData").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				returnData.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getreturnData ends");

		return returnData;
	}

	public List<ProcurementDashboardModel> getinventoryData() {

		logger.info("Method : getinventoryData ends");

		List<ProcurementDashboardModel> result = new ArrayList<ProcurementDashboardModel>();

		try {
			String value = "SET @p_totalStocks='" + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "getinventoryData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				BigInteger i = (BigInteger) m[0];
				Integer val = Integer.parseInt(i.toString());
				double d = Double.parseDouble(val.toString());
				ProcurementDashboardModel data = new ProcurementDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, d, null, null, null, null, null, null,
						null, null, null, null, null);
				result.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getinventoryData ends");
		return result;
	}

	public List<ProcurementDashboardModel> getstocksInTransit() {

		logger.info("Method : getstocksInTransit ends");

		List<ProcurementDashboardModel> result = new ArrayList<ProcurementDashboardModel>();

		try {
			String value = "SET @p_totalStocksInTransit='" + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "getstocksInTransit").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				ProcurementDashboardModel data = new ProcurementDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2], null, null, null,
						null, null, null, null, null);
				result.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getstocksInTransit ends");
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<RestProcurementStockDetailsModel> getrequisitionData() {
		logger.info("Method : getrequisitionData  starts");

		List<RestProcurementStockDetailsModel> requisitionData = new ArrayList<RestProcurementStockDetailsModel>();

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "getrequisitionData").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				RestProcurementStockDetailsModel dropDownModel = new RestProcurementStockDetailsModel(m[0], m[1], m[2],
						m[3]);
				requisitionData.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getrequisitionData ends");
		return requisitionData;
	}

	public List<ProcurementDashboardModel> getpoRecptHistoryData() {

		logger.info("Method : getpoRecptHistoryData ends");

		List<ProcurementDashboardModel> result = new ArrayList<ProcurementDashboardModel>();

		try {
			String value = "SET @p_totalStocks='" + "';";
			@SuppressWarnings("unchecked")
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "getpoRecptHistoryData").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				ProcurementDashboardModel data = new ProcurementDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2],
						null, null, null, null, null);
				result.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getpoRecptHistoryData ends");
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<RestProcurementPoRecptModel> getpoRecptData() {
		logger.info("Method : getpoRecptData  starts");

		List<RestProcurementPoRecptModel> poRecptData = new ArrayList<RestProcurementPoRecptModel>();

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "getpoRecptData").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				RestProcurementPoRecptModel dropDownModel = new RestProcurementPoRecptModel(m[0], m[1], m[2], m[3]);
				poRecptData.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getpoRecptData ends");
		return poRecptData;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ProcurementDashboardModel> pendingInvoice() {
		logger.info("Method : pendingInvoice starts");

		List<ProcurementDashboardModel> response = new ArrayList<ProcurementDashboardModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ProcurementDashboardRoutines")
					.setParameter("actionType", "pendingInvoice").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				String duedate = null;
				if (m[0] != null) {
					duedate = m[0].toString();
				}

				ProcurementDashboardModel purchase = new ProcurementDashboardModel(null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, duedate, m[1], m[2], m[3], null);

				
				response.add(purchase);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : pendingInvoice ends");
		return response;
	}

}
