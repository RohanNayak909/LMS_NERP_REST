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
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateSpotParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.QaPcroRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaSpotRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class QaSpotDao {
	Logger logger = LoggerFactory.getLogger(QaSpotDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

		// downloadPcro
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> spotAggridView(String id, String orgName, String orgDivision) {
			logger.info("Method : spotAggridView Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_productId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_spot_routines")
						.setParameter("actionType", "spotAggridView").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : spotAggridView Dao ends");
			System.out.println("resp**************AGGRID**************" + resp);
			return resp;
		}
		
		
		// addQc
		public ResponseEntity<JsonResponse<List<QaSpotRestModel>>> addSpot(List<QaSpotRestModel> qc) {
			logger.info("Method : addSpot dao starts");
			System.out.println(qc);
			JsonResponse<List<QaSpotRestModel>> resp = new JsonResponse<List<QaSpotRestModel>>();

			String value = GenerateSpotParam.getAddSpot(qc);
			System.out.println("value===" + value);
			System.out.println("Modify qc===" + qc.get(0).getSpotId());
			try {

				if (qc.get(0).getSpotId() != null && qc.get(0).getSpotId() != "") {

					em.createNamedStoredProcedureQuery("qa_spot_routines")
							.setParameter("actionType", "modifyspot").setParameter("actionValue", value).execute();

					resp.setCode("success");
					resp.setMessage("Data Modified successfully");

				} else {
					em.createNamedStoredProcedureQuery("qa_spot_routines")
							.setParameter("actionType", "addspot").setParameter("actionValue", value).execute();

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

			ResponseEntity<JsonResponse<List<QaSpotRestModel>>> response = new ResponseEntity<JsonResponse<List<QaSpotRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response===" + response);
			logger.info("Method : addSpot dao ends");
			return response;

		}

		
		// viewSpot
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getTotalSpotView(String orgName, String orgDivision) {
			logger.info("Method : getTotalView Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_spot_routines")
						.setParameter("actionType", "getTotalSpotView").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getTotalView Dao ends");
			System.out.println("resp**************rrreessuulltt**************" + resp);
			return resp;

		}

		
		// editSpot
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editSpotView(String id, String orgName, String orgDivision) {
			logger.info("Method : editSpotView Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_spotId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_spot_routines")
						.setParameter("actionType", "editSpot").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : editSpotView Dao ends");
			System.out.println("resp**************EDIT**************" + resp);
			return resp;
		}


		// deleteSpot
		public ResponseEntity<JsonResponse<Object>> deleteSpot(String id, String orgName, String orgDivision) {
			logger.info("Method : deleteSpot starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_spotId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("qa_spot_routines")
							.setParameter("actionType", "deleteSpot").setParameter("actionValue", value).execute();

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

			logger.info("Method : deleteSpot ends");
			System.out.println("DELETEE" + response);
			return response;
		}

		
		// approveSpot
		public ResponseEntity<JsonResponse<Object>> approveSpot(String id, String orgName, String orgDivision) {
			logger.info("Method : approveSpot starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_spotId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("qa_spot_routines")
							.setParameter("actionType", "approveSpot").setParameter("actionValue", value).execute();

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

			logger.info("Method : approveSpot ends");
			return response;
		}
		

		// downlaodSpotPdf
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> downlaodSpotPdf(String id, String orgName, String orgDivision) {
			logger.info("Method : downlaodSpotPdf Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_spotId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_spot_routines")
						.setParameter("actionType", "downlaodSpotPdf").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : downlaodSpotPdf Dao ends");
			System.out.println("resp**************EDIT**************" + resp);
			return resp;
		}
		
		//addchild
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> addNameAddition(String add, String skg,String product,String orgName, String orgDiv) {
			logger.info("Method : addNameAddition Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_add='" + add + "',@p_skg='" + skg + "',@p_product='" + product + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv
						+ "';";
				System.out.println("values****************************" + value);
				em.createNamedStoredProcedureQuery("qa_spot_routines")
						.setParameter("actionType", "addNameAddition").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Name Added Successfully");
				// resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : addNameAddition Dao ends");
			return resp;

		}

}