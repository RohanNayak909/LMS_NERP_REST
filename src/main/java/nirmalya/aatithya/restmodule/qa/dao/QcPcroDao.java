package nirmalya.aatithya.restmodule.qa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.qa.GeneratePcroParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.QaPcroRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class QcPcroDao {
	Logger logger = LoggerFactory.getLogger(QcPcroDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// getparameterLists
	// viewAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getShiftSlno(String orgName, String orgDivision) {
		logger.info("Method : getShiftSlno Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_pcro_routines")
					.setParameter("actionType", "getSlno").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getShiftSlno Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	// getparameterLists
	// viewAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTotalView(String orgName, String orgDivision) {
		logger.info("Method : getShiftSlno Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_pcro_routines")
					.setParameter("actionType", "getTotalView").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getShiftSlno Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// addQc
		public ResponseEntity<JsonResponse<List<QaPcroRestModel>>> addPcro(List<QaPcroRestModel> qc) {
			logger.info("Method : addQc dao starts");
			System.out.println(qc);
			JsonResponse<List<QaPcroRestModel>> resp = new JsonResponse<List<QaPcroRestModel>>();

			String value = GeneratePcroParam.getAddpcro(qc);
			System.out.println("value===" + value);
			System.out.println("Modify qc===" + qc.get(0).getPcroId());
			try {

				if (qc.get(0).getPcroId() != null && qc.get(0).getPcroId() != "") {

					em.createNamedStoredProcedureQuery("qa_pcro_routines")
							.setParameter("actionType", "modifypcro").setParameter("actionValue", value).execute();

					resp.setCode("success");
					resp.setMessage("Data Modified successfully");

				} else {
					em.createNamedStoredProcedureQuery("qa_pcro_routines")
							.setParameter("actionType", "addpcro").setParameter("actionValue", value).execute();

					resp.setCode("success");
					resp.setMessage("Data saved successfully");

				}
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					e.printStackTrace();
					Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
					e.printStackTrace();
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				}
				e.printStackTrace();
			}

			ResponseEntity<JsonResponse<List<QaPcroRestModel>>> response = new ResponseEntity<JsonResponse<List<QaPcroRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response===" + response);
			logger.info("Method : addQc dao ends");
			return response;

		}
		// downloadPcro
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> downloadPcro(String id, String orgName, String orgDivision) {
			logger.info("Method : editPcro Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_pcroId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_pcro_routines")
						.setParameter("actionType", "editPcro").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : editPcro Dao ends");
			System.out.println("resp**************EDIT**************" + resp);
			return resp;
		}
		
		
		// editPcro
				@SuppressWarnings("unchecked")
				public JsonResponse<Object> editPcroView(String id, String orgName, String orgDivision) {
					logger.info("Method : editPcroView Dao starts");
					JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_pcroId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
						System.out.println("values****************************" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("qa_pcro_routines")
								.setParameter("actionType", "editPcroView").setParameter("actionValue", value).getResultList();
						resp.setBody(x.get(0));
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : editPcroView Dao ends");
					System.out.println("resp**************EDIT**************" + resp);
					return resp;
				}
		
		
		
		// deletePcro
		public ResponseEntity<JsonResponse<Object>> deletePcro(String id, String orgName, String orgDivision) {
			logger.info("Method : deletePcro starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_pcroId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("qa_pcro_routines")
							.setParameter("actionType", "deletePcro").setParameter("actionValue", value).execute();

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

			logger.info("Method : deletePcro ends");
			System.out.println("DELETEE" + response);
			return response;
		}
		
		// approvePcro
		public ResponseEntity<JsonResponse<Object>> approvePcro(String id, String orgName, String orgDivision) {
			logger.info("Method : approvePcro starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_pcroId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("qa_pcro_routines")
							.setParameter("actionType", "approvePcro").setParameter("actionValue", value).execute();

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

			logger.info("Method : approvePcro ends");
			return response;
		}
		
		
		// editPcro
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> productDetailsDrop(String id, String orgName, String orgDivision) {
			logger.info("Method : productDetailsDrop Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_productId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_pcro_routines")
						.setParameter("actionType", "productDetailsDrop").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : productDetailsDrop Dao ends");
			System.out.println("resp**************EDIT**************" + resp);
			return resp;
		}





}