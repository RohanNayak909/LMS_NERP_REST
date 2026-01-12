package nirmalya.aatithya.restmodule.procurment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.procurment.model.InventoryActionRfqModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorBidModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorBidParentModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryRfqActionDao {

	Logger logger = LoggerFactory.getLogger(InventoryRfqActionDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	/*
	 * for action rfq view list 
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryActionRfqModel> getActionRfqViewList(String orgName, String orgDiv) {
		logger.info("Method : getActionRfqViewList starts");
		List<InventoryActionRfqModel> getRequisitionTypeList = new ArrayList<InventoryActionRfqModel>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesfffffffffff"+values);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ActionRfqRoutines")
					.setParameter("actionType", "getActionRfqViewList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[16] != null) {
					oa = m[16].toString();
				}
				Object createdon = null;
				if (m[19] != null) {
					createdon = m[19].toString();
				}
				Object activeDate = null;
				if (m[21] != null) {
					activeDate = m[21].toString();
				}
				Object onHoldDate = null;
				if (m[22] != null) {
					onHoldDate = m[22].toString();
				}
				Object completeDate = null;
				if (m[23] != null) {
					completeDate = m[23].toString();
				}
				InventoryActionRfqModel dropDownModel = new InventoryActionRfqModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], oa, m[17], m[18], createdon,
						m[20], activeDate, onHoldDate, completeDate, m[24].toString());

				if (dropDownModel.getApproveStatus().contentEquals("1")) {
					dropDownModel.setApproveStatus("Approve");
				} else if (dropDownModel.getApproveStatus().contentEquals("0")) {
					dropDownModel.setApproveStatus("Active");
				} else if (dropDownModel.getApproveStatus().contentEquals("2")) {
					dropDownModel.setApproveStatus("Pending");
				} else if (dropDownModel.getApproveStatus().contentEquals("3")) {
					dropDownModel.setApproveStatus("Rejected ");
				}
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("Method : getActionRfqViewList ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to for rfq edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryActionRfqModel> getActionRfqEdit(String id,String orgName, String orgDiv) {
		logger.info("Method : getRfqEdit starts");
		List<InventoryActionRfqModel> getRequisitionTypeList = new ArrayList<InventoryActionRfqModel>();
		List<InventoryVendorBidParentModel> vendorParentList = new ArrayList<InventoryVendorBidParentModel>();

		String values = "SET @P_req='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("aaaaaaaaaaaaaaaaaaaaaaa"+values);
		try {

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("RfqRoutines")
					.setParameter("actionType", "getRfqEdit").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[18] != null) {
					oa = m[18].toString();
				}
				Object receiveDate = null;
				if (m[22] != null) {
					receiveDate = m[22].toString();
				}
				Object activeDate = null;
				if (m[24] != null) {
					activeDate = m[24].toString();
				}
				Object onHoldDate = null;
				if (m[25] != null) {
					onHoldDate = m[25].toString();
				}
				Object completeDate = null;
				if (m[26] != null) {
					completeDate = m[26].toString();
				}

				InventoryActionRfqModel dropDownModel = new InventoryActionRfqModel(m[28], m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], oa, m[19],
						m[20], m[21], receiveDate, m[23], activeDate, onHoldDate, completeDate, m[27], null);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("ActionRfqRoutines")
					.setParameter("actionType", "getVendorIds").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				List<InventoryVendorBidModel> vendorChildList = new ArrayList<InventoryVendorBidModel>();
				InventoryVendorBidParentModel dropDownModel = new InventoryVendorBidParentModel(m[0], m[1], m[2], m[3],
						m[4], m[5].toString());

				try {
					String subQuery = "SET @P_rfq='" + dropDownModel.getRfqId() + "',@P_VendID='"
							+ dropDownModel.getVendorId() + "';";
					List<Object[]> x1 = entityManager.createNamedStoredProcedureQuery("ActionRfqRoutines")
							.setParameter("actionType", "getVendorDetails").setParameter("actionValue", subQuery)
							.getResultList();
					for (Object[] m2 : x1) {
						InventoryVendorBidModel bidDetails = new InventoryVendorBidModel(m2[0], m2[1], m2[2], m2[3],
								m2[4], m2[5], m2[6], m2[7], m2[8], m2[9], m2[10], m2[11], m2[12]);
						vendorChildList.add(bidDetails);
					}

				} catch (Exception e) {
					logger.error(e.getMessage());
				}
				dropDownModel.setVendorBidDetails(vendorChildList);
				vendorParentList.add(dropDownModel);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		if (getRequisitionTypeList != null) {
			getRequisitionTypeList.get(0).setVendorBidParentDetails(vendorParentList);
		}
		logger.info("Method : getRfqEdit ends");
		return getRequisitionTypeList;
	}

}
