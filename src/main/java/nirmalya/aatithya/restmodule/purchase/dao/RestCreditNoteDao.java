package nirmalya.aatithya.restmodule.purchase.dao;



import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestCreditNoteDao {
	Logger logger = LoggerFactory.getLogger(RestCreditNoteDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * view Product ItemData
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewcreditNoteData(String orgName, String orgDivision) {
		logger.info("Method : viewcreditNoteData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision  + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("view_creditNoteData_Routines")
					.setParameter("actionType", "viewcreditNoteData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewcreditNoteData Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	
	/*
	 * view Debit Note.
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewDebitNoteData(String orgName, String orgDivision, String type) {
		logger.info("Method : viewDebitNoteData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_type='" + type  + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("view_creditNoteData_Routines")
					.setParameter("actionType", "viewDebitNoteData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewDebitNoteData Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	/*
	 * view Debit Note dtls.
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewDebitNoteEditData(String orgName, String orgDivision, String id) {
		logger.info("Method : viewDebitNoteEditData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id  + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("view_creditNoteData_Routines")
					.setParameter("actionType", "viewDebitNoteEditData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewDebitNoteEditData Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	/*
	 * view Credit Note dtls.
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewcreditNoteEditData(String orgName, String orgDivision, String id) {
		logger.info("Method : viewcreditNoteEditData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id  + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("view_creditNoteData_Routines")
					.setParameter("actionType", "viewcreditNoteEditData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewcreditNoteEditData Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

}
