package nirmalya.aatithya.restmodule.qa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateMicroTestingParameter;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateQuotationNewParameter;
import nirmalya.aatithya.restmodule.qa.model.MicroTestingModel;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;

@Repository
public class MicroTestingDao {
	Logger logger = LoggerFactory.getLogger(MicroTestingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<MicroTestingModel>>> saveAllMtData(
			List<MicroTestingModel> microTestingModel) {

		logger.info("Method : saveAllMtData starts");

		JsonResponse<List<MicroTestingModel>> resp = new JsonResponse<List<MicroTestingModel>>();
		List<MicroTestingModel> listData = new ArrayList<MicroTestingModel>();
		String values = GenerateMicroTestingParameter.getMtParam(microTestingModel);
		try {
			if (microTestingModel.get(0).getMictotestingId() == null
					|| microTestingModel.get(0).getMictotestingId() == "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_microtesting_routines")
						.setParameter("actionType", "saveAllMtData").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {
						MicroTestingModel dropDownModel = new MicroTestingModel(m[0], m[1], null,null);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_microtesting_routines")
						.setParameter("actionType", "modifyAllMtData").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {
						MicroTestingModel dropDownModel = new MicroTestingModel(m[0], m[1], null,null);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		ResponseEntity<JsonResponse<List<MicroTestingModel>>> response = new ResponseEntity<JsonResponse<List<MicroTestingModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addquotationnew ends");
		return response;
	}


	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewMtData(String orgName, String orgDivision) {
		logger.info("Method : viewMtData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_microtesting_routines")
					.setParameter("actionType", "viewMtData").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewMtData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> editMtData(String mictotestingId,String orgName, String orgDiv) {
		logger.info("Method : editMtData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_mictotestingId='" + mictotestingId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_microtesting_routines")
					.setParameter("actionType", "editMtData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : editMtData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteMtdata(String mictotestingId,String orgName, String orgDiv) {
		logger.info("Method : deleteMtdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_mictotestingId='" + mictotestingId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			 em.createNamedStoredProcedureQuery("qa_microtesting_routines")
					.setParameter("actionType", "deleteMtdata").setParameter("actionValue", value)
					.execute();
			 resp.setCode("200");
			 resp.setMessage("Deleted Successfully");
			//resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : deleteMtdata Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveMtdata(String mictotestingId,String orgName, String orgDiv) {
		logger.info("Method : approveMtdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_mictotestingId='" + mictotestingId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			 em.createNamedStoredProcedureQuery("qa_microtesting_routines")
					.setParameter("actionType", "approveMtdata").setParameter("actionValue", value)
					.execute();
			 resp.setCode("success");
			 resp.setMessage("Approved Successfully");
			//resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approveMtdata Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	//pdf
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> mtPdf(String id,String orgName, String orgDivision) {
				logger.info("Method : mtPdf Dao startsssss" + id );

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_mictotestingId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					logger.info("values******" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("qa_microtesting_routines")
							.setParameter("actionType", "pdfMtData").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
					e.printStackTrace();
				}
				logger.info("resp******" + resp);
				logger.info("Method : mtPdf Dao ends");
				return resp;

			}	
}
