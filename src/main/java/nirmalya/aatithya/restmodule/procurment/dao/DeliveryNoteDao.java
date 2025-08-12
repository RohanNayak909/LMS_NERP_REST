package nirmalya.aatithya.restmodule.procurment.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateDelNoteDtlsParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.model.DeliveryNoteModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

@Repository
public class DeliveryNoteDao {

	Logger logger = LoggerFactory.getLogger(DeliveryNoteDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDeliveryMethod() {
		logger.info("Method : getDeliveryMethod starts");

		List<DropDownModel> delMethodList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("deliveryNoteRoutines")
					.setParameter("actionType", "getDeliveryMethod").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				DropDownModel delnote = new DropDownModel(m[0], m[1]);
				delMethodList.add(delnote);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDeliveryMethod ends");
		return delMethodList;
	}

	@SuppressWarnings("unchecked")
	public List<DeliveryNoteModel> getDeliveryNoteList(String vendorId,String orgName, String orgDiv) {
		logger.info("Method : getDeliveryNoteList starts");

		List<DeliveryNoteModel> delNoteList = new ArrayList<DeliveryNoteModel>();
		try {
			String value = "SET @p_vendor='" + vendorId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("deliveryNoteRoutines")
					.setParameter("actionType", "getDeliveryNoteList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
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
				Object estDelDate = null;
				if (m[8] != null) {
					estDelDate = m[8].toString();
				}
				Object craetedDate = null;
				if (m[12] != null) {
					craetedDate = m[12].toString();
				}
				Object submittedDate = null;
				if (m[13] != null) {
					submittedDate = m[13].toString();
				}
				Object completedDate = null;
				if (m[14] != null) {
					completedDate = m[14].toString();
				}

				DeliveryNoteModel delnote = new DeliveryNoteModel(m[0], invDate, m[2], m[3], poDate, dispatchDate, m[6],
						m[7], estDelDate, m[9], m[10], m[11], craetedDate, submittedDate, completedDate);
				delNoteList.add(delnote);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
logger.info("delNoteList==="+delNoteList);
		logger.info("Method : getDeliveryNoteList ends");
		return delNoteList;
	}

	@SuppressWarnings("unchecked")
	public List<InventoryProductModel> getDeliveryItemNoteList(String id,String orgName, String orgDiv) {
		logger.info("Method : getDeliveryItemNoteList starts");

		List<InventoryProductModel> delNoteList = new ArrayList<InventoryProductModel>();
		try {
			String value = "SET @P_DelNoteId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("deliveryNoteRoutines")
					.setParameter("actionType", "getDelNoteItemList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				InventoryProductModel delnote = new InventoryProductModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10]);
				delNoteList.add(delnote);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDeliveryItemNoteList ends");
		return delNoteList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DeliveryNoteModel>> getDelNoteDtlsById(String id,String orgName, String orgDiv) {
		logger.info("Method : getDelNoteDtlsById starts");

		List<DeliveryNoteModel> delNoteList = new ArrayList<DeliveryNoteModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		JsonResponse<DeliveryNoteModel> resp = new JsonResponse<DeliveryNoteModel>();

		String value = "SET @P_DelNoteId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("deliveryNoteRoutines")
					.setParameter("actionType", "getDelNoteDtlsById").setParameter("actionValue", value)
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
				Object estDelDate = null;
				if (m[8] != null) {
					estDelDate = m[8].toString();
				}
				Object craetedDate = null;
				if (m[12] != null) {
					craetedDate = m[12].toString();
				}
				Object submittedDate = null;
				if (m[13] != null) {
					submittedDate = m[13].toString();
				}
				Object completedDate = null;
				if (m[14] != null) {
					completedDate = m[14].toString();
				}

				DeliveryNoteModel delnote = new DeliveryNoteModel(m[0], invDate, m[2], m[3], poDate, dispatchDate, m[6],
						m[7], estDelDate, m[9], m[10], m[11], craetedDate, submittedDate, completedDate);
				delNoteList.add(delnote);
			}

			if (delNoteList != null) {
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("deliveryNoteRoutines")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", value).getResultList();
				for (Object[] m1 : x1) {

					InventoryVendorDocumentModel dd = new InventoryVendorDocumentModel(m1[0], m1[1], m1[2]);
					docList.add(dd);
				}
				delNoteList.get(0).setDocList(docList);
			}

			resp.setBody(delNoteList.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<DeliveryNoteModel>> response = new ResponseEntity<JsonResponse<DeliveryNoteModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getDelNoteDtlsById ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveDeliveryNoteDetails(List<DeliveryNoteModel> delNote) {
		logger.info("Method : saveDeliveryNoteDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateDelNoteDtlsParameter.saveDeliveryNoteDetails(delNote);

				em.createNamedStoredProcedureQuery("deliveryNoteRoutines")
						.setParameter("actionType", "saveDeliveryNoteDetails").setParameter("actionValue", values)
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

		logger.info("Method : saveDeliveryNoteDetails ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> submitToCompany(DeliveryNoteModel delNote) {
		logger.info("Method : submitToCompany starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity) 
			try {
				String value = "SET @P_DelNote = '" + delNote.getDelNote() + "', @P_CreatedBy='" 
						+ delNote.getCreatedBy() + "', @P_Module='" + delNote.getModuleId() + "', @P_Component='" 
									+ delNote.getComponentId() + "', @P_SubComponent='" + delNote.getSubComponentId() + "', @P_org='" + delNote.getOrg() + "', @P_orgDiv='" + delNote.getOrgDiv() + "';";
				em.createNamedStoredProcedureQuery("deliveryNoteRoutines")
				.setParameter("actionType", "submitToCompany").setParameter("actionValue", value)
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
		
		logger.info("Method : submitToCompany ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> createNewDeliveryNote(DeliveryNoteModel delNote) {
		logger.info("Method : createNewDeliveryNote starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity) 
			try {
				String value = "SET @P_DelNote = '" + delNote.getDelNote() + "', @P_CreatedBy='" 
			+ delNote.getCreatedBy() + "', @P_Module='" + delNote.getModuleId() + "', @P_Component='" 
						+ delNote.getComponentId() + "', @P_SubComponent='" + delNote.getSubComponentId() + "';";
				em.createNamedStoredProcedureQuery("deliveryNoteRoutines")
				.setParameter("actionType", "createNewDeliveryNote").setParameter("actionValue", value)
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
		
		logger.info("Method : submitToCompany ends");
		return response;
	}
}
