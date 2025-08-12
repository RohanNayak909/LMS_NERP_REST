package nirmalya.aatithya.restmodule.property.stakeholder.dao;
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
import nirmalya.aatithya.restmodule.common.utils.GenerateManageMaintainenceDescriptionParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStackholderMaintenanceExpensesModel;

@Repository
public class RestStackholderMaintenanceExpensesDao {
	
	Logger logger = LoggerFactory.getLogger(RestStackholderMaintenanceExpensesDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

////add
	public ResponseEntity<JsonResponse<Object>> saveMaintainenceDescription(
			RestStackholderMaintenanceExpensesModel restPayroll) {

		logger.info("Method : Rest saveMaintainenceDescription  Dao starts");
		logger.info("restPayroll" + restPayroll);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		

		try {

			String values = GenerateManageMaintainenceDescriptionParameter.addMaintainenceDescriptionParam(restPayroll);
			logger.info("ssssssssssssssssssssss"+values);
			if (restPayroll.getMainid() == null || restPayroll.getMainid() == "") {

				logger.info("values IN ADD" + values);
				em.createNamedStoredProcedureQuery("viewMaintainence").setParameter("actionType", "adddetails")
						.setParameter("actionValue", values).execute();

			} else {

				logger.info("values in modify");
				em.createNamedStoredProcedureQuery("viewMaintainence").setParameter("actionType", "modifystddetails")
						.setParameter("actionValue", values).execute();

			}

		}

		catch (Exception e) {
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

		logger.info("Method : Rest saveMaintainenceDescription"
				+ " Dao ends");

		return response;
	}
////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStackholderMaintenanceExpensesModel>>> ViewMaintainenceDescription(String userid, String fromDate, String toDate) {
		logger.info("Method : ViewMaintainenceDescription starts");
		List<RestStackholderMaintenanceExpensesModel> respList = new ArrayList<RestStackholderMaintenanceExpensesModel>();

		try {
			String value=	 "SET @p_userid='" + userid + "',@p_fromDate='" + fromDate +"',@p_toDate='" + toDate + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewMaintainence").setParameter("actionType", "viewView")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestStackholderMaintenanceExpensesModel restPayroll = new RestStackholderMaintenanceExpensesModel(m[0], m[1], m[2], m[3], m[4], m[5],m[6], m[7]);
				respList.add(restPayroll);

			}

			//logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestStackholderMaintenanceExpensesModel>> resp = new JsonResponse<List<RestStackholderMaintenanceExpensesModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestStackholderMaintenanceExpensesModel>>> response = new ResponseEntity<JsonResponse<List<RestStackholderMaintenanceExpensesModel>>>(
				resp, HttpStatus.CREATED);
		//logger.info("response" + response);
		logger.info("Method : ViewMaintainenceDescription ends");

		//logger.info("VIEWWWWWWWW" + respList);
		return response;


}
////edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStackholderMaintenanceExpensesModel>>>editMaintainenceDescription(String id) {
		logger.info("Method : editMaintainenceDescription starts");

		JsonResponse<List<RestStackholderMaintenanceExpensesModel>> resp = new JsonResponse<List<RestStackholderMaintenanceExpensesModel>>();
		List<RestStackholderMaintenanceExpensesModel> rs = new ArrayList<RestStackholderMaintenanceExpensesModel>();

		try {

			String value = "SET @p_id='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewMaintainence").setParameter("actionType", "viewEdit")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestStackholderMaintenanceExpensesModel reqemp = new RestStackholderMaintenanceExpensesModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7]);
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestStackholderMaintenanceExpensesModel>>> response = new ResponseEntity<JsonResponse<List<RestStackholderMaintenanceExpensesModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : editMaintainenceDescription ends");
		return response;
	}
	//delete
			public ResponseEntity<JsonResponse<Object>> deleteMaintainenceDescription(String id) {
				logger.info("Method : deleteMaintainenceDescription starts");

				Boolean validity = true;
				JsonResponse<Object> resp = new JsonResponse<Object>();
				resp.setMessage("");
				resp.setCode("");
				logger.info("ID...."+id);
				if (validity)
					try {

						String value = "SET @p_mainid='" + id + "';";
						logger.info(value);

						em.createNamedStoredProcedureQuery("viewMaintainence")
								.setParameter("actionType", "viewDelete").setParameter("actionValue", value).execute();

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

				logger.info("Method :  deleteMaintainenceDescription ends");
				logger.info("DELETEE" + response);
				return response;
			}
}
