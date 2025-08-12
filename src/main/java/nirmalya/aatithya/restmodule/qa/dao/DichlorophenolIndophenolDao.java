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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateSulphuricAcidParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.RestDichlorophenolIndophenolModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class DichlorophenolIndophenolDao {
	Logger logger = LoggerFactory.getLogger(RestSulphuricAcidDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	public ResponseEntity<JsonResponse<List<RestDichlorophenolIndophenolModel>>> addDcip(List<RestDichlorophenolIndophenolModel> qc) {
		logger.info("Method : addDcip dao starts");
		System.out.println(qc);
		JsonResponse<List<RestDichlorophenolIndophenolModel>> resp = new JsonResponse<List<RestDichlorophenolIndophenolModel>>();

		String value = GenerateSulphuricAcidParam.addDcip(qc);
		System.out.println("value===" + value);
		try {

			if (qc.get(0).getDcpipId() != null && qc.get(0).getDcpipId() != "") {

				em.createNamedStoredProcedureQuery("qa_dcip_routines")
						.setParameter("actionType", "modifyDcip").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_dcip_routines")
						.setParameter("actionType", "addDcip").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<RestDichlorophenolIndophenolModel>>> response = new ResponseEntity<JsonResponse<List<RestDichlorophenolIndophenolModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addDcip dao ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getDcpipView(String orgName, String orgDivision) {
		logger.info("Method : getDcpipView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_dcip_routines")
					.setParameter("actionType", "getDcpipView").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDcpipView Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editDcpip(String dcpipId, String orgName, String orgDivision) {
		logger.info("Method : editDcpip Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_dcpipId='" + dcpipId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_dcip_routines")
					.setParameter("actionType", "editDcpip").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editDcpip Dao ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteDcpip(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteDcpip starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_dcpipId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				
				em.createNamedStoredProcedureQuery("qa_dcip_routines")
						.setParameter("actionType", "deleteDcpip").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data deleted successfully");
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

		logger.info("Method : deleteDcpip ends");
		System.out.println("DELETEE" + response);
		return response;
	}
	public ResponseEntity<JsonResponse<Object>> approveDcpip(String id, String orgName, String orgDivision) {
		logger.info("Method : approveDcpip starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_dcpipId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_dcip_routines")
						.setParameter("actionType", "approveDcpip").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Approved successfully");
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

		logger.info("Method : approveDcpip ends");
		return response;
	}
	//PDF
		 @SuppressWarnings("unchecked")
			public JsonResponse<Object> dichloroIndophenolPdf(String id,String orgName, String orgDivision) {
				logger.info("Method : dichloroIndophenolPdf Dao startsssss" + id );

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_dcpipId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					logger.info("values******" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("qa_dcip_routines")
							.setParameter("actionType", "dichloroIndophenolPdf").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
					e.printStackTrace();
				}
				logger.info("resp******" + resp);
				logger.info("Method : dichloroIndophenolPdf Dao ends");
				return resp;

			}
}

