package nirmalya.aatithya.restmodule.purchase.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;

@Repository
public class RestRequestedRawMaterialDao {
	Logger logger = LoggerFactory.getLogger(RestRequestedRawMaterialDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * view Product ItemData
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewProductItemData(String orgName, String orgDivision) {
		logger.info("Method : viewProductItemData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("requesteed_raw_material_Routine")
					.setParameter("actionType", "viewProductItemData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewProductItemData Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

//

	@SuppressWarnings("unchecked")
	public List<RestPurchaseOrderModel> getPOItemdata(String itemId, String sku, String orgName, String orgDiv) {
		logger.info("Method : getPOItemdata starts");
		logger.info("RestPurchaseOrderModel" + itemId);
		List<RestPurchaseOrderModel> getRequisitionTypeList = new ArrayList<RestPurchaseOrderModel>();
		// List<InventoryVendorDocumentModel> docList = new
		// ArrayList<InventoryVendorDocumentModel>();
		try {
			// String values = "SET @p_poId='" + id + "',@p_hsnCode='" + hsnCode + "',
			// @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			String values = "SET @p_itemId='(" + itemId + ")',@p_sku='(" + sku + ")',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("requesteed_raw_material_Routine")
					.setParameter("actionType", "getPOItemdata").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {
					/*
					 * Object createdOn = null; if (m[31] != null) { createdOn = m[31].toString(); }
					 * Object createdOn1 = null; if (m[3] != null) { createdOn1 = m[3].toString(); }
					 */

					double gst = 0;
					if (m[6] != null) {
						gst = Double.parseDouble(m[6].toString());
					}

					RestPurchaseOrderModel dropDownModel = new RestPurchaseOrderModel(m[0], m[1], m[2], m[3], m[4],
							m[5], gst, m[7], m[8], m[9]);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : getPOItemdata ends");
		return getRequisitionTypeList;
	}

	// editPlanData
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editPlanData(String id, String orgName, String orgDivision) {
		logger.info("Method : editPlanData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("requesteed_raw_material_Routine")
					.setParameter("actionType", "editPlanData").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editPlanData Dao ends");
		logger.info("resp****************************" + resp);
		return resp;
	}

}
