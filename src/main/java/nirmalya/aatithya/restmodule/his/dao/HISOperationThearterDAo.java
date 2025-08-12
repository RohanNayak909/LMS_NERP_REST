package nirmalya.aatithya.restmodule.his.dao;

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
import nirmalya.aatithya.restmodule.common.utils.his.GenerateOperationTheaterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.model.RestHISOperationThearterModel;

@Repository
public class HISOperationThearterDAo {
	Logger logger = LoggerFactory.getLogger(HISOperationThearterDAo.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// restAddWardModel

	public ResponseEntity<JsonResponse<Object>> addOperationTheater(
			RestHISOperationThearterModel operationThearterModel) {
		logger.info("Method : Rest Add OperationTheater Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateOperationTheaterParameter.addOperationTheaterParam(operationThearterModel);

			if (operationThearterModel.getOtId() != null && operationThearterModel.getOtId() != "") {

				em.createNamedStoredProcedureQuery("his_ot_routines").setParameter("actionType", "modifyOt")
						.setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("his_ot_routines").setParameter("actionType", "addOt")
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

		logger.info("Method :  Rest Add OperationTheater Dao ends");

		return response;
	}

	// viewOTDetails

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHISOperationThearterModel>>> viewOTDetails(String org, String orgDiv) {
		logger.info("Method : view viewOTDetails dao starts==========");

		List<RestHISOperationThearterModel> wardList = new ArrayList<RestHISOperationThearterModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			logger.info("for ward views====" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ot_routines").setParameter("actionType", "viewOTDetails")
					.setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				RestHISOperationThearterModel otList = new RestHISOperationThearterModel(m[0], m[1], m[2], m[3], m[4],m[5]);
				wardList.add(otList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHISOperationThearterModel>> resp = new JsonResponse<List<RestHISOperationThearterModel>>();
		resp.setBody(wardList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestHISOperationThearterModel>>> response = new ResponseEntity<JsonResponse<List<RestHISOperationThearterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : view viewOTDetails dao starts");
		return response;
	}
	
	//deleteOTDetails

	public ResponseEntity<JsonResponse<Object>> deleteOTDetails(String id) {

		logger.info("Method : deleteOTDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_otId='" + id + "';";
			logger.info("it is for delete=========="+  values);
			em.createNamedStoredProcedureQuery("his_ot_routines").setParameter("actionType", "deleteOT")
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

		logger.info("Method : deleteOTDetails Dao starts");
		return response;
	}
}
