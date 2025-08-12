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
import nirmalya.aatithya.restmodule.common.utils.his.GenerateIcuParameter;
import nirmalya.aatithya.restmodule.his.model.RestHISIcuModel;

@RestController
@RequestMapping(value = { "his" })
public class RestHISIcuDao {

	Logger logger = LoggerFactory.getLogger(RestHISIcuDao.class);

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
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_icu_routines")
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

	public ResponseEntity<JsonResponse<Object>> addIcu(RestHISIcuModel restHISIcuModel) {
		logger.info("Method : addIcu Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("Method : restHISIcuModel====" + restHISIcuModel);
		if (validity)
			try {
				String values = GenerateIcuParameter.getAddIcu(restHISIcuModel);

				if (restHISIcuModel.getIcu() == null || restHISIcuModel.getIcu() == "") {
					System.out.println("addddd in daooooooooooo" + restHISIcuModel);
					em.createNamedStoredProcedureQuery("his_icu_routines").setParameter("actionType", "addIcu")
							.setParameter("actionValue", values).execute();

				}

				else {
					System.out.println("MODIFYYYYYYY  in daooooooooo " + restHISIcuModel);
					System.out.println("VALUEEEEE" + values);
					em.createNamedStoredProcedureQuery("his_icu_routines")
							.setParameter("actionType", "modifyIcu").setParameter("actionValue", values)
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
		logger.info("Method : addIcu Dao ends");
		return response;
	}
	
	
	/// view 

			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<RestHISIcuModel>>> viewIcu() {
				logger.info("Method : viewIcu starts");
				List<RestHISIcuModel> respList = new ArrayList<RestHISIcuModel>();

				try {
					List<Object[]> x = em.createNamedStoredProcedureQuery("his_icu_routines")
							.setParameter("actionType", "viewIcu").setParameter("actionValue", "").getResultList();

					for (Object[] m : x) {

						RestHISIcuModel restHISIcuModel = new RestHISIcuModel(m[0], m[1], m[2],
								m[3], m[4], m[5],m[6]);
						
						respList.add(restHISIcuModel);

						logger.info("RestHISIcuModel" + restHISIcuModel);
					}
					logger.info("respList" + respList);
				} catch (Exception e) {
					e.printStackTrace();
				}

				JsonResponse<List<RestHISIcuModel>> resp = new JsonResponse<List<RestHISIcuModel>>();
				resp.setBody(respList);
				ResponseEntity<JsonResponse<List<RestHISIcuModel>>> response = new ResponseEntity<JsonResponse<List<RestHISIcuModel>>>(
						resp, HttpStatus.CREATED);
				logger.info("response" + response);
				logger.info("Method : viewIcu ends");
				return response;

			}
			
			//edit

			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<RestHISIcuModel>>> editIcu(String id) {
				logger.info("Method : editIcu starts");

				JsonResponse<List<RestHISIcuModel>> resp = new JsonResponse<List<RestHISIcuModel>>();
				List<RestHISIcuModel> newResp = new ArrayList<RestHISIcuModel>();

				try {
					String value = "SET @p_icu='" + id + "';";
					logger.info("@@@@@@@@@@@@@@@@@@@" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("his_icu_routines")
							.setParameter("actionType", "editIcu").setParameter("actionValue", value).getResultList();

					for (Object[] m : x) {

						RestHISIcuModel restHISIcuModel = new RestHISIcuModel(m[0], m[1], m[2], m[3], m[4].toString());
						newResp.add(restHISIcuModel);
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

				ResponseEntity<JsonResponse<List<RestHISIcuModel>>> response = new ResponseEntity<JsonResponse<List<RestHISIcuModel>>>(
						resp, HttpStatus.CREATED);
				logger.info("Method : editIcu ends");
				return response;
			}
			
			/*
			 * delete
			 */

			public ResponseEntity<JsonResponse<Object>> deleteIcu(String id) {
				logger.info("Method : deleteIcu starts");

				Boolean validity = true;
				JsonResponse<Object> resp = new JsonResponse<Object>();
				resp.setMessage("");
				resp.setCode("");

				if (validity)
					try {

						String value = "SET @p_icu='" + id + "';";

						em.createNamedStoredProcedureQuery("his_icu_routines")
								.setParameter("actionType", "deleteIcu").setParameter("actionValue", value).execute();

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

				logger.info("Method : deleteIcu ends");
				logger.info("DELETEE" + response);
				return response;
			}
}
