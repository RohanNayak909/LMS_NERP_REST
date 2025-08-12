package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterProcurementTypeParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestProcurementMasterModel;

@Repository
public class RestProcurementDao {

	Logger logger = LoggerFactory.getLogger(RestProcurementDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	////////////////////// MEASUREMENT//////////////////

	public ResponseEntity<JsonResponse<Object>> addMeasureType(RestProcurementMasterModel restProcurementMasterModel) {
		logger.info("Method : addMeasureType Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterProcurementTypeParameter.addMeasureTypeParam(restProcurementMasterModel);
				if (restProcurementMasterModel.getMeasurementId() != null
						&& restProcurementMasterModel.getMeasurementId() != "") {
					em.createNamedStoredProcedureQuery("MeasurementTypeReference")
							.setParameter("actionType", "modifyMeasureType").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("MeasurementTypeReference")
							.setParameter("actionType", "addMeasureType").setParameter("actionValue", values).execute();
				}

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

		logger.info("Method : addMeasureType Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> viewMeasureType(String org, String orgDiv) {
		logger.info("Method : viewMeasureType starts");

		List<RestProcurementMasterModel> measureList = new ArrayList<RestProcurementMasterModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("MeasurementTypeReference")
					.setParameter("actionType", "viewMeasureType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object status = "";
				if (m[4].toString().equals("true")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestProcurementMasterModel dropDownModel = new RestProcurementMasterModel(m[0], m[1], m[2], m[3], null,
						status, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null);
				measureList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestProcurementMasterModel>> resp = new JsonResponse<List<RestProcurementMasterModel>>();
		resp.setBody(measureList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewMeasureType ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteMeasureType(String id, String org, String orgDiv) {

		logger.info("Method : deleteMeasureType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_measureId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("MeasurementTypeReference")
					.setParameter("actionType", "deleteMeasureType").setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteMeasureType Dao starts");
		return response;
	}

//////////////////////RequisitionType//////////////////

	public ResponseEntity<JsonResponse<Object>> addReqiType(RestProcurementMasterModel restProcurementMasterModel) {
		logger.info("Method : addReqiType Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterProcurementTypeParameter.addReqiTypeParam(restProcurementMasterModel);

				if (restProcurementMasterModel.getRequisitionId() != null
						&& restProcurementMasterModel.getRequisitionId() != "") {
					em.createNamedStoredProcedureQuery("RequisitionTypeReference")
							.setParameter("actionType", "modifyReqiType").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("RequisitionTypeReference")
							.setParameter("actionType", "addReqiType").setParameter("actionValue", values).execute();
				}

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

		logger.info("Method : addReqiType Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> viewRequisitionType(String org, String orgDiv) {
		logger.info("Method : viewRequisitionType starts");

		List<RestProcurementMasterModel> reqiList = new ArrayList<RestProcurementMasterModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("RequisitionTypeReference")
					.setParameter("actionType", "viewRequisitionType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}

				RestProcurementMasterModel dropDownModel = new RestProcurementMasterModel(null, null, null, null, null,
						null, null, null, null, null, m[0], m[1], m[2], status, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null);
				reqiList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestProcurementMasterModel>> resp = new JsonResponse<List<RestProcurementMasterModel>>();
		resp.setBody(reqiList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewRequisitionType ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteRequiType(String id, String org, String orgDiv) {

		logger.info("Method : deleteRequiType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_reqiId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("RequisitionTypeReference").setParameter("actionType", "deleteRequiType")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteRequiType Dao starts");
		return response;
	}

//////////////////////RequisitionType//////////////////

	public ResponseEntity<JsonResponse<Object>> addReqiPriorityType(
			RestProcurementMasterModel restProcurementMasterModel) {
		logger.info("Method : addReqiType Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterProcurementTypeParameter
						.addReqiPriorityTypeParam(restProcurementMasterModel);

				if (restProcurementMasterModel.getRequiPriorityId() != null
						&& restProcurementMasterModel.getRequiPriorityId() != "") {
					em.createNamedStoredProcedureQuery("RequisitionPrioTypeReference")
							.setParameter("actionType", "modifyReqiPriorityType").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("RequisitionPrioTypeReference")
							.setParameter("actionType", "addReqiPriorityType").setParameter("actionValue", values)
							.execute();
				}

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

		logger.info("Method : addReqiType Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> viewReqiPriorityType(String org, String orgDiv) {
		logger.info("Method : viewReqiPriorityType starts");

		List<RestProcurementMasterModel> reqiprioList = new ArrayList<RestProcurementMasterModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("RequisitionPrioTypeReference")
					.setParameter("actionType", "viewReqiPriorityType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestProcurementMasterModel dropDownModel = new RestProcurementMasterModel(null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2],
						status, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null);
				reqiprioList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestProcurementMasterModel>> resp = new JsonResponse<List<RestProcurementMasterModel>>();
		resp.setBody(reqiprioList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewReqiPriorityType ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteRequiPriorityType(String id, String org, String orgDiv) {

		logger.info("Method : deleteRequiPriorityType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_reqiprioId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("RequisitionPrioTypeReference")
					.setParameter("actionType", "deleteRequiPriorityType").setParameter("actionValue", values)
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
		logger.info("Method : deleteRequiType Dao starts");
		return response;
	}

//////////////////////Payment Term Type//////////////////

	public ResponseEntity<JsonResponse<Object>> addPayTerm(RestProcurementMasterModel restProcurementMasterModel) {
		logger.info("Method : addPayTerm Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterProcurementTypeParameter.addPaymentTermParam(restProcurementMasterModel);

				if (restProcurementMasterModel.getPaymentTermId() != null
						&& restProcurementMasterModel.getPaymentTermId() != "") {
					em.createNamedStoredProcedureQuery("PaymentTermReference")
							.setParameter("actionType", "modifyPayTerm").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("PaymentTermReference").setParameter("actionType", "addPayTerm")
							.setParameter("actionValue", values).execute();
				}

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

		logger.info("Method : addPayTerm Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> viewPaymentTerm(String org, String orgDiv) {
		logger.info("Method : viewPaymentTerm starts");

		List<RestProcurementMasterModel> paymentList = new ArrayList<RestProcurementMasterModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("PaymentTermReference")
					.setParameter("actionType", "viewPaymentTerm").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestProcurementMasterModel dropDownModel = new RestProcurementMasterModel(null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, m[0], m[1], m[2], status, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null);
				paymentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestProcurementMasterModel>> resp = new JsonResponse<List<RestProcurementMasterModel>>();
		resp.setBody(paymentList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewPaymentTerm ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deletePaymentTerm(String id, String org, String orgDiv) {

		logger.info("Method : deletePaymentTerm Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_payTermId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("PaymentTermReference").setParameter("actionType", "deletePaymentTerm")
					.setParameter("actionValue", values).execute();

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
		logger.info("Method : deletePaymentTerm Dao starts");
		return response;
	}

//////////////////////Legal Term Type//////////////////

	public ResponseEntity<JsonResponse<Object>> addLegalTerm(RestProcurementMasterModel restProcurementMasterModel) {
		logger.info("Method : addLegalTerm Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterProcurementTypeParameter.addLegalTermParam(restProcurementMasterModel);

				if (restProcurementMasterModel.getLegalTermId() != null
						&& restProcurementMasterModel.getLegalTermId() != "") {
					em.createNamedStoredProcedureQuery("LegalTermReference")
							.setParameter("actionType", "modifyLegalTerm").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("LegalTermReference").setParameter("actionType", "addLegalTerm")
							.setParameter("actionValue", values).execute();
				}

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

		logger.info("Method : addLegalTerm Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> viewLegalTerm(String org, String orgDiv) {
		logger.info("Method : viewLegalTerm starts");

		List<RestProcurementMasterModel> legalList = new ArrayList<RestProcurementMasterModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("LegalTermReference")
					.setParameter("actionType", "viewLegalTerm").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestProcurementMasterModel dropDownModel = new RestProcurementMasterModel(null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2],
						status, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null);
				legalList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestProcurementMasterModel>> resp = new JsonResponse<List<RestProcurementMasterModel>>();
		resp.setBody(legalList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewLegalTerm ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteLegalTerm(String id, String org, String orgDiv) {

		logger.info("Method : deleteLegalTerm Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_LegalTermId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("LegalTermReference").setParameter("actionType", "deleteLegalTerm")
					.setParameter("actionValue", values).execute();

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
		logger.info("Method : deleteLegalTerm Dao starts");
		return response;
	}

//////////////////////Payment Status Type//////////////////

	public ResponseEntity<JsonResponse<Object>> addPaymentStatus(
			RestProcurementMasterModel restProcurementMasterModel) {
		logger.info("Method : addPaymentStatus Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterProcurementTypeParameter
						.addPaymentStatusParam(restProcurementMasterModel);

				if (restProcurementMasterModel.getPaymentStatusId() != null
						&& restProcurementMasterModel.getPaymentStatusId() != "") {
					em.createNamedStoredProcedureQuery("PaymentStatusReference")
							.setParameter("actionType", "modifyPaymentStatus").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("PaymentStatusReference")
							.setParameter("actionType", "addPaymentStatus").setParameter("actionValue", values)
							.execute();
				}

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

		logger.info("Method : addPaymentStatus Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> viewPaymentStatus(String org, String orgDiv) {
		logger.info("Method : viewPaymentStatus starts");

		List<RestProcurementMasterModel> payStatusList = new ArrayList<RestProcurementMasterModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("PaymentStatusReference")
					.setParameter("actionType", "viewPaymentStatus").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestProcurementMasterModel dropDownModel = new RestProcurementMasterModel(null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, m[0], m[1], m[2], status, null, null, null, null, null, null,
						null, null, null, null, null, null);
				payStatusList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestProcurementMasterModel>> resp = new JsonResponse<List<RestProcurementMasterModel>>();
		resp.setBody(payStatusList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewPaymentStatus ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deletePaymentStatus(String id, String org, String orgDiv) {

		logger.info("Method : deletePaymentStatus Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_payStatusId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("PaymentStatusReference")
					.setParameter("actionType", "deletePaymentStatus").setParameter("actionValue", values).execute();

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
		logger.info("Method : deletePaymentStatus Dao starts");
		return response;
	}

//////////////////////Delivery Method Type//////////////////

	public ResponseEntity<JsonResponse<Object>> addDeliveryMethod(
			RestProcurementMasterModel restProcurementMasterModel) {
		logger.info("Method : addDeliveryMethod Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateMasterProcurementTypeParameter.addDeliveryMethodParam(restProcurementMasterModel);

				if (restProcurementMasterModel.getDeliveryMethodId() != null
						&& restProcurementMasterModel.getDeliveryMethodId() != "") {
					em.createNamedStoredProcedureQuery("DeliveryMethodReference")
							.setParameter("actionType", "modifyDeliveryMethod").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("DeliveryMethodReference")
							.setParameter("actionType", "addDeliveryMethod").setParameter("actionValue", values)
							.execute();
				}

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

		logger.info("Method : addDeliveryMethod Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> viewDeliveryMethod(String org, String orgDiv) {
		logger.info("Method : viewDeliveryMethod starts");

		List<RestProcurementMasterModel> DeliveryMethodList = new ArrayList<RestProcurementMasterModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("DeliveryMethodReference")
					.setParameter("actionType", "viewDeliveryMethod").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestProcurementMasterModel dropDownModel = new RestProcurementMasterModel(null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2],
						status, null, null, null, null);
				DeliveryMethodList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestProcurementMasterModel>> resp = new JsonResponse<List<RestProcurementMasterModel>>();
		resp.setBody(DeliveryMethodList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestProcurementMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewDeliveryMethod ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteDeliveryMethod(String id, String org, String orgDiv) {

		logger.info("Method : deleteDeliveryMethod Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_deliveryId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("DeliveryMethodReference")
					.setParameter("actionType", "deleteDeliveryMethod").setParameter("actionValue", values).execute();

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
		logger.info("Method : deleteDeliveryMethod Dao starts");
		return response;
	}

	/**
	 * add and update req type from csv
	 * 
	 * @param reqtypeList
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addReqiTypeFromCsv(List<RestProcurementMasterModel> reqtypeList) {
		logger.info("Method : addReqiTypeFromCsv Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		for (RestProcurementMasterModel a : reqtypeList) {
			try {
				String selectPatam = "SET @p_Name='" + a.getRequisitionName() + "';";
				@SuppressWarnings("unchecked")
				List<String> resultList = em.createNamedStoredProcedureQuery("RequisitionTypeReference")
						.setParameter("actionType", "isReqTypeRecordExsit").setParameter("actionValue", selectPatam)
						.getResultList();
				if (resultList != null && !resultList.isEmpty()) {
					a.setRequisitionId(resultList.get(0));
					String values = GenerateMasterProcurementTypeParameter.addReqiTypeParam(a);
					em.createNamedStoredProcedureQuery("RequisitionTypeReference")
							.setParameter("actionType", "modifyReqiType").setParameter("actionValue", values).execute();
				} else {
					String values = GenerateMasterProcurementTypeParameter.addReqiTypeParam(a);
					em.createNamedStoredProcedureQuery("RequisitionTypeReference")
							.setParameter("actionType", "addReqiType").setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				logger.error(e.getMessage());
				resp.setMessage(e.getMessage());
			}
		}
		/*
		 * try { String values =
		 * GenerateMasterProcurementTypeParameter.getReqTypeCsvList(reqtypeList);
		 * 
		 * em.createNamedStoredProcedureQuery("RequisitionTypeReference")
		 * .setParameter("actionType", "addReqiTypeFromCsv").setParameter("actionValue",
		 * values).execute();
		 * 
		 * } catch (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
		 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
		 * e1.printStackTrace(); } e.printStackTrace(); }
		 */

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :addReqiTypeFromCsv Dao ends");
		return response;
	}

	/**
	 * save data req priority
	 * 
	 * @param reqtypeList
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addReqiPrioTypeFromCsv(List<RestProcurementMasterModel> reqtypeList) {
		logger.info("Method : addReqiPrioTypeFromCsv Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		for (RestProcurementMasterModel a : reqtypeList) {
			try {
				String selectPatam = "SET @p_Name='" + a.getRequiPriorityName() + "';";
				@SuppressWarnings("unchecked")
				List<String> resultList = em.createNamedStoredProcedureQuery("RequisitionPrioTypeReference")
						.setParameter("actionType", "isReqPrioRecordExsit").setParameter("actionValue", selectPatam)
						.getResultList();
				if (resultList != null && !resultList.isEmpty()) {
					a.setRequiPriorityId(resultList.get(0));
					String values = GenerateMasterProcurementTypeParameter.addReqiPriorityTypeParam(a);
					em.createNamedStoredProcedureQuery("RequisitionPrioTypeReference")
							.setParameter("actionType", "modifyReqiPriorityType").setParameter("actionValue", values)
							.execute();
				} else {
					String values = GenerateMasterProcurementTypeParameter.addReqiPriorityTypeParam(a);
					em.createNamedStoredProcedureQuery("RequisitionPrioTypeReference")
							.setParameter("actionType", "addReqiPriorityType").setParameter("actionValue", values)
							.execute();
				}

			} catch (Exception e) {
				logger.error(e.getMessage());
				resp.setMessage(e.getMessage());
			}
		}
		/*
		 * try { String values =
		 * GenerateMasterProcurementTypeParameter.getReqPrioTypeCsvList(reqtypeList);
		 * 
		 * em.createNamedStoredProcedureQuery("RequisitionPrioTypeReference")
		 * .setParameter("actionType",
		 * "addReqiPrioTypeFromCsv").setParameter("actionValue", values).execute();
		 * 
		 * } catch (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
		 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
		 * e1.printStackTrace(); } e.printStackTrace(); }
		 */

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :addReqiPrioTypeFromCsv Dao ends");
		return response;
	}

	/**
	 * for add payment term master data
	 * 
	 * @param reqtypeList
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addPaymentTermFromCsv(List<RestProcurementMasterModel> reqtypeList) {
		logger.info("Method : addPaymentTermFromCsv Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		for (RestProcurementMasterModel a : reqtypeList) {
			try {
				String selectPatam = "SET @p_Name='" + a.getPaymentTermName() + "';";
				@SuppressWarnings("unchecked")
				List<String> resultList = em.createNamedStoredProcedureQuery("PaymentTermReference")
						.setParameter("actionType", "isPayTermRecordExsit").setParameter("actionValue", selectPatam)
						.getResultList();
				if (resultList != null && !resultList.isEmpty()) {
					a.setPaymentTermId(resultList.get(0));
					String values = GenerateMasterProcurementTypeParameter.addPaymentTermParam(a);
					em.createNamedStoredProcedureQuery("PaymentTermReference")
							.setParameter("actionType", "modifyPayTerm").setParameter("actionValue", values).execute();
				} else {

					String values = GenerateMasterProcurementTypeParameter.addPaymentTermParam(a);

					em.createNamedStoredProcedureQuery("PaymentTermReference").setParameter("actionType", "addPayTerm")
							.setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				logger.error(e.getMessage());
				resp.setMessage(e.getMessage());
			}
		}

		/*
		 * try { String values =
		 * GenerateMasterProcurementTypeParameter.getPaymentTermCsvList(reqtypeList);
		 * 
		 * em.createNamedStoredProcedureQuery("PaymentTermReference")
		 * .setParameter("actionType",
		 * "addPaymentTermFromCsv").setParameter("actionValue", values).execute();
		 * 
		 * } catch (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
		 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
		 * e1.printStackTrace(); } e.printStackTrace(); }
		 */

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :addPaymentTermFromCsv Dao ends");
		return response;
	}

	/**
	 * for add payment term master data
	 * 
	 * @param reqtypeList
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addLegalTermFromCsv(List<RestProcurementMasterModel> reqtypeList) {
		logger.info("Method : addLegalTermFromCsv Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		for (RestProcurementMasterModel a : reqtypeList) {
			try {
				String selectPatam = "SET @p_Name='" + a.getPaymentTermName() + "';";
				@SuppressWarnings("unchecked")
				List<String> resultList = em.createNamedStoredProcedureQuery("LegalTermReference")
						.setParameter("actionType", "isLegalTermRecordExsit").setParameter("actionValue", selectPatam)
						.getResultList();
				if (resultList != null && !resultList.isEmpty()) {
					a.setPaymentTermId(resultList.get(0));
					String values = GenerateMasterProcurementTypeParameter.addLegalTermParam(a);
					em.createNamedStoredProcedureQuery("LegalTermReference")
							.setParameter("actionType", "modifyLegalTerm").setParameter("actionValue", values)
							.execute();
				} else {
					String values = GenerateMasterProcurementTypeParameter.addLegalTermParam(a);
					em.createNamedStoredProcedureQuery("LegalTermReference").setParameter("actionType", "addLegalTerm")
							.setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				logger.error(e.getMessage());
				resp.setMessage(e.getMessage());
			}
		}
		/*
		 * try { String values =
		 * GenerateMasterProcurementTypeParameter.getLegalTermCsvList(reqtypeList);
		 * 
		 * em.createNamedStoredProcedureQuery("LegalTermReference").setParameter(
		 * "actionType", "addLegalTermFromCsv") .setParameter("actionValue",
		 * values).execute();
		 * 
		 * } catch (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
		 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
		 * e1.printStackTrace(); } e.printStackTrace(); }
		 */

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :addLegalTermFromCsv Dao ends");
		return response;
	}

	/**
	 * for add payment status master data
	 * 
	 * @param reqtypeList
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addPayStatusFromCsv(List<RestProcurementMasterModel> reqtypeList) {
		logger.info("Method : addPayStatusFromCsv Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		for (RestProcurementMasterModel a : reqtypeList) {
			try {
				String selectPatam = "SET @p_Name='" + a.getPaymentStatusName() + "';";
				@SuppressWarnings("unchecked")
				List<String> resultList = em.createNamedStoredProcedureQuery("PaymentStatusReference")
						.setParameter("actionType", "isPayStatusRecordExsit").setParameter("actionValue", selectPatam)
						.getResultList();
				if (resultList != null && !resultList.isEmpty()) {
					a.setPaymentStatusId(resultList.get(0));
					String values = GenerateMasterProcurementTypeParameter.addPaymentStatusParam(a);
					em.createNamedStoredProcedureQuery("PaymentStatusReference")
							.setParameter("actionType", "modifyPaymentStatus").setParameter("actionValue", values)
							.execute();
				} else {
					String values = GenerateMasterProcurementTypeParameter.addPaymentStatusParam(a);
					em.createNamedStoredProcedureQuery("PaymentStatusReference")
							.setParameter("actionType", "addPaymentStatus").setParameter("actionValue", values)
							.execute();
				}

			} catch (Exception e) {
				logger.error(e.getMessage());
				resp.setMessage(e.getMessage());
			}
		}
		/*
		 * try { String values =
		 * GenerateMasterProcurementTypeParameter.getLegalTermCsvList(reqtypeList);
		 * 
		 * em.createNamedStoredProcedureQuery("LegalTermReference").setParameter(
		 * "actionType", "addLegalTermFromCsv") .setParameter("actionValue",
		 * values).execute();
		 * 
		 * } catch (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
		 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
		 * e1.printStackTrace(); } e.printStackTrace(); }
		 */

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :addPayStatusFromCsv Dao ends");
		return response;
	}

	/**
	 * for add payment status master data
	 * 
	 * @param reqtypeList
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addDlvMethodFromCsv(List<RestProcurementMasterModel> reqtypeList) {
		logger.info("Method : addDlvMethodFromCsv Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		for (RestProcurementMasterModel a : reqtypeList) {
			try {
				String selectPatam = "SET @p_Name='" + a.getDeliveryMethodName() + "';";
				@SuppressWarnings("unchecked")
				List<String> resultList = em.createNamedStoredProcedureQuery("DeliveryMethodReference")
						.setParameter("actionType", "isDlvMethodRecordExsit").setParameter("actionValue", selectPatam)
						.getResultList();
				if (resultList != null && !resultList.isEmpty()) {
					a.setDeliveryMethodId(resultList.get(0));
					String values = GenerateMasterProcurementTypeParameter.addDeliveryMethodParam(a);
							em.createNamedStoredProcedureQuery("DeliveryMethodReference")
							.setParameter("actionType", "modifyDeliveryMethod").setParameter("actionValue", values)
							.execute();
				} else {
					String values = GenerateMasterProcurementTypeParameter.addDeliveryMethodParam(a);
					em.createNamedStoredProcedureQuery("DeliveryMethodReference")
							.setParameter("actionType", "addDeliveryMethod").setParameter("actionValue", values)
							.execute();
				}

			} catch (Exception e) {
				logger.error(e.getMessage());
				resp.setMessage(e.getMessage());
			}
		} 
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :addDlvMethodFromCsv Dao ends");
		return response;
	}

	/**
	 * for add payment term master data
	 * 
	 * @param reqtypeList
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addMeasureTypeFromCsv(List<RestProcurementMasterModel> reqtypeList) {
		logger.info("Method : addMeasureTypeFromCsv Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		for (RestProcurementMasterModel a : reqtypeList) {
			try {
				String selectPatam = "SET @p_Code='" + a.getMeasurementCode() + "',@p_order='" + a.getMeasurementOrder()
						+ "',@p_name='" + a.getMeasurementName() + "';";
				@SuppressWarnings("unchecked")
				List<String> resultList = em.createNamedStoredProcedureQuery("MeasurementTypeReference")
						.setParameter("actionType", "isMeasureRecordExsit").setParameter("actionValue", selectPatam)
						.getResultList();
				if (resultList != null && !resultList.isEmpty()) {
					a.setMeasurementId(resultList.get(0));
					String values = GenerateMasterProcurementTypeParameter.addMeasureTypeParam(a);
					em.createNamedStoredProcedureQuery("MeasurementTypeReference")
							.setParameter("actionType", "modifyMeasureType").setParameter("actionValue", values)
							.execute();
				} else {
					String values = GenerateMasterProcurementTypeParameter.addMeasureTypeParam(a);
					em.createNamedStoredProcedureQuery("MeasurementTypeReference")
							.setParameter("actionType", "addMeasureType").setParameter("actionValue", values).execute();
				}

			} catch (Exception e) {
				logger.error(e.getMessage());
				resp.setMessage(e.getMessage());
			}
		}
		/*
		 * try { String values =
		 * GenerateMasterProcurementTypeParameter.getMeasureTypeCsvList(reqtypeList);
		 * 
		 * em.createNamedStoredProcedureQuery("MeasurementTypeReference")
		 * .setParameter("actionType",
		 * "addMeasureTypeFromCsv").setParameter("actionValue", values).execute();
		 * 
		 * } catch (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
		 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
		 * e1.printStackTrace(); } e.printStackTrace(); }
		 */
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :addMeasureTypeFromCsv Dao ends");
		return response;
	}
}
