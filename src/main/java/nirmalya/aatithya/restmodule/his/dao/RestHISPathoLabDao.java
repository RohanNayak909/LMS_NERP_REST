package nirmalya.aatithya.restmodule.his.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.his.GeneratePathoLabParameter;
import nirmalya.aatithya.restmodule.his.model.RestHISPathoLabModel;

@RestController
@RequestMapping(value = { "his" })
public class RestHISPathoLabDao {

	Logger logger = LoggerFactory.getLogger(RestHISPathoLabDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
/* get getFloorType list */	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFloorTypeDao() {

		logger.info("Method : getFloorTypeDao starts");

		List<DropDownModel> floorType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patholab_routines")
					.setParameter("actionType", "getFloorType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				floorType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getFloorTypeDao ends" + floorType);
		return floorType;
	}
	
	/* add */

	public ResponseEntity<JsonResponse<Object>> addPathoLab(RestHISPathoLabModel restHISPathoLabModel) {
		logger.info("Method : addPathoLab Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("Method : restHISPathoLabModel====" + restHISPathoLabModel);
		if (validity)
			try {
				String values = GeneratePathoLabParameter.getAddLab(restHISPathoLabModel);

				if (restHISPathoLabModel.getPathoLab() == null || restHISPathoLabModel.getPathoLab() == "") {
					System.out.println("addddd in daooooooooooo" + restHISPathoLabModel);
					em.createNamedStoredProcedureQuery("his_patholab_routines").setParameter("actionType", "addPathoLab")
							.setParameter("actionValue", values).execute();

				}

				else {
					System.out.println("MODIFYYYYYYY  in daooooooooo " + restHISPathoLabModel);
					System.out.println("VALUEEEEE" + values);
					em.createNamedStoredProcedureQuery("his_patholab_routines")
							.setParameter("actionType", "modifyPathoLab").setParameter("actionValue", values)
							.execute();
				}

				System.out.println("VALLLLUUUUUUEEEEE" + values);
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
		logger.info("Method : addPathoLab Dao ends");
		return response;
	}
	
	/// view 

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHISPathoLabModel>>> viewPathoLab() {
		logger.info("Method : viewPathoLab starts");
		List<RestHISPathoLabModel> respList = new ArrayList<RestHISPathoLabModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patholab_routines")
					.setParameter("actionType", "viewPathoLab").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestHISPathoLabModel restHISPathoLabModel = new RestHISPathoLabModel(m[0], m[1], m[2],
						m[3], m[4], m[5],m[6]);
				
				respList.add(restHISPathoLabModel);

				logger.info("RestHISPathoLabModel" + restHISPathoLabModel);
			}
			logger.info("respList" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHISPathoLabModel>> resp = new JsonResponse<List<RestHISPathoLabModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestHISPathoLabModel>>> response = new ResponseEntity<JsonResponse<List<RestHISPathoLabModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewPathoLab ends");
		return response;

	}
	
	//edit

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHISPathoLabModel>>> editPathoLab(String id) {
		logger.info("Method : editPathoLab starts");

		JsonResponse<List<RestHISPathoLabModel>> resp = new JsonResponse<List<RestHISPathoLabModel>>();
		List<RestHISPathoLabModel> newResp = new ArrayList<RestHISPathoLabModel>();

		try {
			String value = "SET @p_lab='" + id + "';";
			logger.info("@@@@@@@@@@@@@@@@@@@" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patholab_routines")
					.setParameter("actionType", "editPathoLab").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestHISPathoLabModel restHISPathoLabModel = new RestHISPathoLabModel(m[0], m[1], m[2], m[3], m[4].toString(),null,null);
				newResp.add(restHISPathoLabModel);
			}

			resp.setBody(newResp);
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

		ResponseEntity<JsonResponse<List<RestHISPathoLabModel>>> response = new ResponseEntity<JsonResponse<List<RestHISPathoLabModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : editPathoLab ends");
		return response;
	}
	
	/*
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deletePathoLab(String id) {
		logger.info("Method : deletePathoLab starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_lab='" + id + "';";

				em.createNamedStoredProcedureQuery("his_patholab_routines")
						.setParameter("actionType", "deletePathoLab").setParameter("actionValue", value).execute();

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

		logger.info("Method : deletePathoLab ends");
		logger.info("DELETEE" + response);
		return response;
	}
	

}
