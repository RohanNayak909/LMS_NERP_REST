package nirmalya.aatithya.restmodule.purchase.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateVendorDeliveryChallanParam;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;
import nirmalya.aatithya.restmodule.purchase.model.VendorDeliveryChallanModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;


@Repository
public class VendorDeliveryChallanDao {
	Logger logger = LoggerFactory.getLogger(VendorDeliveryChallanDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * add
	 */
	public ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>> addvendorDeliveryChallan(
			List<VendorDeliveryChallanModel> VendorDeliveryChallanModel) {

		logger.info("Method : addvendorDeliveryChallan starts");
		JsonResponse<List<VendorDeliveryChallanModel>> resp = new JsonResponse<List<VendorDeliveryChallanModel>>();
		List<VendorDeliveryChallanModel> listData = new ArrayList<VendorDeliveryChallanModel>();

		try {
			String values = GenerateVendorDeliveryChallanParam.getAddChallanParam(VendorDeliveryChallanModel);

			if (VendorDeliveryChallanModel.get(0).getVendorDeliveryChallan() == null
					|| VendorDeliveryChallanModel.get(0).getVendorDeliveryChallan() == "") {

				em.createNamedStoredProcedureQuery("vendor_DeliveryChallan_routines")
						.setParameter("actionType", "addvendorDeliveryChallan").setParameter("actionValue", values)
						.execute();

			} else {
				em.createNamedStoredProcedureQuery("vendor_DeliveryChallan_routines")
						.setParameter("actionType", "modifyDeliveryChallan").setParameter("actionValue", values)
						.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>> response = new ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addvendorDeliveryChallan ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>> viewvendordeliveryChallan(String orgName,
			String orgDiv, String userId) {
		logger.info("Method : viewvendordeliveryChallan Dao starts");

		List<VendorDeliveryChallanModel> getAllemployee = new ArrayList<VendorDeliveryChallanModel>();
		JsonResponse<List<VendorDeliveryChallanModel>> resp = new JsonResponse<List<VendorDeliveryChallanModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendor_DeliveryChallan_routines")
					.setParameter("actionType", "viewvendordeliveryChallanDetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[4] != null) {
					createdOn = m[4].toString();
				}
				VendorDeliveryChallanModel viewdemo = new VendorDeliveryChallanModel(m[0], m[1], m[2], m[3], createdOn,
						m[5], m[6], m[7], null, null, m[8], m[9], null, m[10], m[11], m[12],m[13]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>> response = new ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewvendordeliveryChallan Dao ends");

		return response;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<VendorDeliveryChallanModel> viewDeliveryChallanEdit(String id, String orgName, String orgDivision) {
		logger.info("Method : viewDeliveryChallanEdit starts");
		List<VendorDeliveryChallanModel> getRequisitionTypeList = new ArrayList<VendorDeliveryChallanModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_vendorDeliveryChallan='" + id + "',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDivision + "';";
			logger.info("DATAAAA" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendor_DeliveryChallan_routines")
					.setParameter("actionType", "viewDeliveryChallanEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

				

					Object createdOn = null;
					if (m[28] != null) {
						createdOn = m[28].toString();
					}

					Object charge = null;
					if (m[29] != null) {
						charge = Double.parseDouble(m[29].toString());
					}
					Object charge2 = null;
					if (m[31] != null) {
						charge2 = Double.parseDouble(m[31].toString());
					}
					Object tdsmat = null;
					if (m[50] != null) {
						tdsmat = m[50].toString();
					} else {
						tdsmat = "0.00";
					}

					VendorDeliveryChallanModel dropDownModel = new VendorDeliveryChallanModel(m[0], m[1], m[2], m[3],
							m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
							m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], createdOn, charge,
							m[30], m[31], m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42],
							m[43], m[44], m[45], m[46], m[47], m[48], m[49], tdsmat,m[51],m[52]);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				String subValues = "SET @p_vendorDeliveryChallan='" + getRequisitionTypeList.get(0).getVendorDeliveryChallan() + "';";
				logger.info("DOCUMRNt" + subValues);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("vendor_DeliveryChallan_routines")
						.setParameter("actionType", "getVendorDocs1").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
					docList.add(dropDownModel);
				}
			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("Method : viewDeliveryChallanEdit ends");
		return getRequisitionTypeList;
	}
	// delete

	public ResponseEntity<JsonResponse<Object>> deleteDeliveryChallan(String id) {
		logger.info("Method : deleteDeliveryChallan starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_dId='" + id + "';";
				em.createNamedStoredProcedureQuery("vendor_DeliveryChallan_routines")
						.setParameter("actionType", "deleteDeliveryChallan").setParameter("actionValue", value)
						.execute();

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteDeliveryChallan ends");
		return response;
	}

	// approve

	public JsonResponse<DropDownModel> approveDeliverychallan(String approveStatus, String vendorDeliveryChallan, String orgName,
			String orgDivision, String userId) {
		logger.info("Method : approveDeliverychallan starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_approveStatus='" + approveStatus + "',@p_vendorDeliveryChallan='" + vendorDeliveryChallan + "', @p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "' ;";

			em.createNamedStoredProcedureQuery("vendor_DeliveryChallan_routines")
					.setParameter("actionType", "approveDeliverychallan").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approveDeliverychallan ends");
		return resp;
	}
}
