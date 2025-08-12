package nirmalya.aatithya.restmodule.procurment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.procurment.model.InventoryGoodsReturnModel;

@Repository
public class InventoryVendorGrnReturnDao {

	Logger logger = LoggerFactory.getLogger(InventoryVendorGrnReturnDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	/**
	 * for view po list
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryGoodsReturnModel> getVendoeGrnReturnViewList(String userId,String orgName, String orgDiv) {
		logger.info("Method : getVendoeGrnReturnViewList starts");
		List<InventoryGoodsReturnModel> inventoryGoodsReturnModelList = new ArrayList<InventoryGoodsReturnModel>();
		String values = "SET @p_vendorId='" + userId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		//String value = "SET @p_grnRetId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		
	 
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("vendor_grn_return_Routines")
					.setParameter("actionType", "getGrnReturnViewList").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object invDate = null;
				if (m[1] != null) {
					invDate = m[1].toString();
				}
				Object poDate = null;
				if (m[4] != null) {
					poDate = m[4].toString();
				}
				Object dispatchDate = null;
				if (m[5] != null) {
					dispatchDate = m[5].toString();
				}
				Object createdon = null;
				if (m[13] != null) {
					createdon = m[13].toString();
				}
				Object approveDate = null;
				if (m[14] != null) {
					approveDate = m[14].toString();
				}
				Object onHoldDate = null;
				if (m[15] != null) {
					onHoldDate = m[15].toString();
				}
				Object completeDate = null;
				if (m[16] != null) {
					completeDate = m[16].toString();
				}
				Object estDeliveryDate = null;
				if (m[9] != null) {
					estDeliveryDate = m[9].toString();
				}
				InventoryGoodsReturnModel inventoryGoodsReturnModel = new InventoryGoodsReturnModel(m[0], invDate, m[2],
						m[3], poDate, dispatchDate, m[6], m[7], m[8], estDeliveryDate, m[10], m[11], m[12], createdon,
						approveDate, onHoldDate, completeDate, m[17], m[18], m[19], m[20], m[21], m[22]);

				if (inventoryGoodsReturnModel.getStatus().contentEquals("1")) {
					inventoryGoodsReturnModel.setStatus("Approve");
				} else if (inventoryGoodsReturnModel.getStatus().contentEquals("0")) {
					inventoryGoodsReturnModel.setStatus("Created");
				} else if (inventoryGoodsReturnModel.getStatus().contentEquals("2")) {
					inventoryGoodsReturnModel.setStatus("OnHold");
				} else if (inventoryGoodsReturnModel.getStatus().contentEquals("3")) {
					inventoryGoodsReturnModel.setStatus("Completed ");
				}
				inventoryGoodsReturnModel.setTotalOutStandingQty(
						inventoryGoodsReturnModel.getTotalInvQty() - inventoryGoodsReturnModel.getTotalDnQty());
				inventoryGoodsReturnModel.setTotalNotReceiveQty(
						inventoryGoodsReturnModel.getTotalDnQty() - inventoryGoodsReturnModel.getTotalReceiveQty());
				inventoryGoodsReturnModelList.add(inventoryGoodsReturnModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getVendoeGrnReturnViewList ends");
		return inventoryGoodsReturnModelList;
	}
}
