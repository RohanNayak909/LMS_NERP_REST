package nirmalya.aatithya.restmodule.purchase.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.model.RestQuotationDetailsModel;

@Repository
public class VendorQuotationDao {

	Logger logger = LoggerFactory.getLogger(VendorQuotationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>> viewquotationdetailsForVendor(String orgName,
			String orgDivision, String userId) {
		logger.info("Method : viewquotationdetailsForVendor Dao startss");

		List<RestQuotationDetailsModel> getAllemployee = new ArrayList<RestQuotationDetailsModel>();
		JsonResponse<List<RestQuotationDetailsModel>> resp = new JsonResponse<List<RestQuotationDetailsModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			logger.info("values"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendor_Qutation_Routines")
					.setParameter("actionType", "viewquotationdetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object createdOn = null;
				if (m[6] != null) {
					createdOn = m[6].toString();
				}

				RestQuotationDetailsModel viewdemo = new RestQuotationDetailsModel(m[0], m[1], m[2], m[3].toString(),
						m[4], m[5].toString(), null, createdOn, null, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],
						m[16], m[17], m[18],m[19],null);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestQuotationDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewquotationdetailsForVendor Dao ends"+response);

		return response;

	}

	// approve

	public JsonResponse<DropDownModel> approveQuotationForVendor(String approveStatus, String quotationId,
			String orgName, String orgDivision, String userId) {
		logger.info("Method : approvePorder starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {

			String value = "SET @p_approveStatus='" + approveStatus + "',@p_quotationId='" + quotationId + "',@p_org='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";

			em.createNamedStoredProcedureQuery("vendor_Qutation_Routines")
					.setParameter("actionType", "approveQuotationForVendor").setParameter("actionValue", value)
					.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : approveQuotationForVendor ends");
		return resp;
	}
}
