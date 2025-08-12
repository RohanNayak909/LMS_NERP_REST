package nirmalya.aatithya.restmodule.procurment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateActionInvoicePAram;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.model.InventoryActionInvoiceModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryProductModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryVendorInvoiceDao {
	Logger logger = LoggerFactory.getLogger(InventoryVendorInvoiceDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	/**
	 * for view po list
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryActionInvoiceModel> getInvoiceViewList(String vendorId,String orgName, String orgDiv) {
		logger.info("Method : getInvoiceViewList starts");
		List<InventoryActionInvoiceModel> inventoryPoModelList = new ArrayList<InventoryActionInvoiceModel>();
		try {
			String value = "SET @p_vendor='" + vendorId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("sssssssssssssssssssssssssss"+value);
			
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("vendor_invoice_Routines")
					.setParameter("actionType", "getInvoiceViewList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[1] != null) {
					oa = m[1].toString();
				}
				Object startDate = null;
				if (m[7] != null) {
					startDate = m[7].toString();
				}
				Object expireDate = null;
				if (m[10] != null) {
					expireDate = m[10].toString();
				}
				Object activeDate = null;
				if (m[19] != null) {
					activeDate = m[19].toString();
				}
				Object completeDate = null;
				if (m[20] != null) {
					completeDate = m[20].toString();
				}
				Object onHoldDate = null;
				if (m[21] != null) {
					onHoldDate = m[21].toString();
				}

				InventoryActionInvoiceModel inventoryPoModel = new InventoryActionInvoiceModel(m[0], oa, m[2], m[3],
						m[4], m[5], m[6], startDate, m[8], m[9], expireDate, m[11], m[12], m[13], m[14], m[15], m[16],
						m[17], m[18], activeDate, completeDate, onHoldDate, m[22], m[23],null,null);

				if (inventoryPoModel.getApproveStatus() != null) {
					if (inventoryPoModel.getApproveStatus().contentEquals("1")) {
						inventoryPoModel.setApproveStatus("Approve");
					} else if (inventoryPoModel.getApproveStatus().contentEquals("0")) {
						inventoryPoModel.setApproveStatus("Active");
					} else if (inventoryPoModel.getApproveStatus().contentEquals("2")) {
						inventoryPoModel.setApproveStatus("Pending");
					} else if (inventoryPoModel.getApproveStatus().contentEquals("3")) {
						inventoryPoModel.setApproveStatus("Rejected ");
					}
				}

				inventoryPoModelList.add(inventoryPoModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInvoiceViewList ends");
		return inventoryPoModelList;
	}

	/**
	 * DAO Function to Add po
	 *
	 */
	public ResponseEntity<JsonResponse<InventoryActionInvoiceModel>> restAddDn(
			InventoryActionInvoiceModel inventoryActionInvoiceModel) {
		logger.info("Method : restAddDn starts");
		boolean validation = true;
		JsonResponse<InventoryActionInvoiceModel> resp = new JsonResponse<InventoryActionInvoiceModel>();
		resp.setMessage("");
		resp.setCode("");
		String errorCode = "Field Validation Error";

		if (inventoryActionInvoiceModel.getInvNo() == null || inventoryActionInvoiceModel.getInvNo() == "") {
			validation = false;
			resp.setCode(errorCode);
			resp.setMessage("Please Enter Invoice No.");
		} else if (inventoryActionInvoiceModel.getInvDate() == null || inventoryActionInvoiceModel.getInvDate() == "") {
			validation = false;
			resp.setCode(errorCode);
			resp.setMessage("PleaseEnter Invoice Date.");
		} else if (inventoryActionInvoiceModel.getVendorId() == null
				|| inventoryActionInvoiceModel.getVendorId() == "") {
			validation = false;
			resp.setCode(errorCode);
			resp.setMessage("please Select Vendor.");
		}
		for (InventoryProductModel l : inventoryActionInvoiceModel.getProductList()) {
			if (l.getSku() == null || l.getSku() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please SKU .");
				break;
			} else if (l.getLocationId() == null || l.getLocationId() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please Enter Location.");
				break;
			} else if (l.getItemId() == null || l.getItemId() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("Please Select Product.");
				break;
			} else if (l.getUomId() == null || l.getUomId() == "") {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("please select UOM.");

			} else if (l.getQuantity() == null) {
				validation = false;
				resp.setCode(errorCode);
				resp.setMessage("please Enter Quantity.");
				break;
			}
		}
		if (validation) {
			try {
				String value = GenerateActionInvoicePAram.getDnParam(inventoryActionInvoiceModel);
				logger.info("value===="+value);
				entityManager.createNamedStoredProcedureQuery("vendor_invoice_Routines")
						.setParameter("actionType", "addDN").setParameter("actionValue", value).execute();

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		ResponseEntity<JsonResponse<InventoryActionInvoiceModel>> response = new ResponseEntity<JsonResponse<InventoryActionInvoiceModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : restAddDn ends");
		return response;
	}
}
