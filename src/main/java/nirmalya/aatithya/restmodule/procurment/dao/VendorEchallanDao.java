package nirmalya.aatithya.restmodule.procurment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.model.InventoryActionInvoiceModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryProductModel;

@Repository
public class VendorEchallanDao {
	Logger logger = LoggerFactory.getLogger(VendorEchallanDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<InventoryActionInvoiceModel> getchallanViewList(String vendorId, String orgName, String orgDiv) {
		logger.info("Method : getchallanViewList starts");
		List<InventoryActionInvoiceModel> inventoryPoModelList = new ArrayList<InventoryActionInvoiceModel>();
		try {
			String value = "SET @p_vendor='" + vendorId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("vendor_echallan_Routines")
					.setParameter("actionType", "getChallanViewList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[1] != null) {
					oa = m[1].toString();
				}
				Object CDATE = null;
				if (m[4] != null) {
					CDATE = DateFormatter.returnStringDate(m[4]);
				}
				InventoryActionInvoiceModel inventoryPoModel = new InventoryActionInvoiceModel(m[0], oa, m[2], m[3],
						CDATE, m[5], m[6], m[7], m[8], m[9], m[10], null, null);

				inventoryPoModelList.add(inventoryPoModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("inventoryPoModelList====" + inventoryPoModelList);
		logger.info("Method : getchallanViewList ends");
		return inventoryPoModelList;
	}

	/*
	 * @SuppressWarnings("unchecked") public InventoryActionInvoiceModel
	 * geChallanEdit(String id,String orgName, String orgDiv) {
	 * logger.info("Method : geChallanEdit starts"); InventoryActionInvoiceModel
	 * poList = new InventoryActionInvoiceModel(); List<InventoryProductModel>
	 * productList = new ArrayList<InventoryProductModel>(); String value =
	 * "SET @p_invId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv +
	 * "';";
	 * 
	 * try { List<Object[]> x =
	 * entityManager.createNamedStoredProcedureQuery("vendor_echallan_Routines")
	 * .setParameter("actionType", "getChallanEdit").setParameter("actionValue",
	 * value).getResultList(); for (Object[] m : x) { Object oa = null; if (m[1] !=
	 * null) { oa = m[1].toString(); }
	 * 
	 * 
	 * 
	 * InventoryActionInvoiceModel inventoryPoModel = new
	 * InventoryActionInvoiceModel(m[0], oa, m[2], m[3], null, null,m[4], m[5],
	 * m[6],m[7],m[8],null,null);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * if (poList != null) { poList.setProductList(productList); }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage()); }
	 * logger.info("Method : geChallanEdit ends"+poList); return poList;
	 * 
	 * }
	 */

	@SuppressWarnings("unchecked")
	public InventoryActionInvoiceModel geChallanEdit(String id) {
		logger.info("Method : geChallanEdit starts");

		JsonResponse<List<InventoryActionInvoiceModel>> resp = new JsonResponse<List<InventoryActionInvoiceModel>>();
		List<InventoryActionInvoiceModel> rs = new ArrayList<InventoryActionInvoiceModel>();
		InventoryActionInvoiceModel poList = new InventoryActionInvoiceModel();
		List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();

		try {

			String value = "SET @p_invId='" + id + "';";
			logger.info(value);

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("vendor_echallan_Routines")
					.setParameter("actionType", "getChallanEdit").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object oa = null;
				if (m[1] != null) {
					oa = m[1].toString();
				}

				InventoryActionInvoiceModel inventoryPoModel = new InventoryActionInvoiceModel(m[0], oa, m[2], null,
						null, m[3], m[4], m[5], m[6], m[7], m[8], null, null);
				poList = inventoryPoModel;
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			logger.info("ssssssssss" + poList.getInvId());
			List<Object[]> y = entityManager.createNamedStoredProcedureQuery("vendor_echallan_Routines")
					.setParameter("actionType", "getChallanItemList")
					.setParameter("actionValue", "SET @p_challanId='" + poList.getInvId() + "';").getResultList();

			for (Object[] m : y) {
				Object createdDate = null;
				if (m[10] != null) {
					createdDate = m[10].toString();
				}
				InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], createdDate, m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], m[21], null);
				productList.add(productModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (poList != null) {
			poList.setProductList(productList);
		}
		logger.info("Method : geChallanEdit ends");
		return poList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<InventoryActionInvoiceModel>> getChallanPdfDetails(String id, String organization,
			String orgDivision) {
		logger.info("Method : getChallanPdfDetails starts");
		List<InventoryActionInvoiceModel> patienttestdetails = new ArrayList<InventoryActionInvoiceModel>();

		JsonResponse<List<InventoryActionInvoiceModel>> resp = new JsonResponse<List<InventoryActionInvoiceModel>>();
		List<InventoryActionInvoiceModel> rs = new ArrayList<InventoryActionInvoiceModel>();
		InventoryActionInvoiceModel poList = new InventoryActionInvoiceModel();
		// List<InventoryProductModel> productList = new
		// ArrayList<InventoryProductModel>();
		try {

			String value = "SET @p_invId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("vendor_echallan_Routines")
					.setParameter("actionType", "getChallanPdfDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object oa = null;
				if (m[1] != null) {
					oa = DateFormatter.returnStringDate(m[1]);
				}
				InventoryActionInvoiceModel reqEdit = new InventoryActionInvoiceModel(m[0], oa, m[2], null, null, m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], m[10]);
				logger.info("reqEdit" + reqEdit);
				patienttestdetails.add(reqEdit);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (patienttestdetails.isEmpty() == false) {
			List<InventoryProductModel> productList = new ArrayList<InventoryProductModel>();
			String iD = patienttestdetails.get(0).getInvId();
			logger.info("IDDDD" + iD);
			try {

				List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("vendor_echallan_Routines")
						.setParameter("actionType", "getChallanItemPdfDetails")
						.setParameter("actionValue", "SET @p_challanId='" + patienttestdetails.get(0).getInvId() + "';")
						.getResultList();
				for (Object[] m : x1) {

					Object createdDate = null;
					if (m[10] != null) {
						createdDate = m[10].toString();
					}
					InventoryProductModel productModel = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4], m[5],
							m[6], m[7], m[8], m[9], createdDate, m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18],
							m[19], null, m[20], null, m[21], m[22]);
					logger.info("productList" + productModel);
					productList.add(productModel);
				}
				logger.info("productList" + productList);
			} catch (Exception e) {
				e.printStackTrace();
			}

			patienttestdetails.get(0).setProductList(productList);
		}
		resp.setBody(patienttestdetails);
		logger.info("DaOOOOO================" + resp);
		logger.info("Method : getChallanPdfDetails ends");

		return resp;
	}

}
