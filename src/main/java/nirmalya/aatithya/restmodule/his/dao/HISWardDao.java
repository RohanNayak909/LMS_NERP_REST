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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateWardHISParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.model.RestHISWardModel;

@Repository
public class HISWardDao {
	Logger logger = LoggerFactory.getLogger(HISWardDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFloorList() {

		logger.info("Method :getFloorList starts");

		List<DropDownModel> getFloorList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_routines")
					.setParameter("actionType", "getFloorList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getFloorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getFloorList ends" + getFloorList);

		return getFloorList;
	}

	// restAddWardModel

	public ResponseEntity<JsonResponse<Object>> addWard(RestHISWardModel restHISWardModel) {
		logger.info("Method : Rest Add Ward Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateWardHISParameter.addWardParam(restHISWardModel);

			if (restHISWardModel.getWardId() != null && restHISWardModel.getWardId() != "") {
				
				em.createNamedStoredProcedureQuery("his_routines").setParameter("actionType", "modifyWard")
						.setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("his_routines").setParameter("actionType", "addWard")
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

		logger.info("Method :  Rest Add Ward Dao ends");

		return response;
	}
	
	
	//viewWard
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHISWardModel>>> viewWard(String org, String orgDiv) {
		logger.info("Method : view ward dao starts==========");

		List<RestHISWardModel> wardList = new ArrayList<RestHISWardModel>();

		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			
			logger.info("for ward views===="+  values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_routines")
					.setParameter("actionType", "viewWard").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				
				RestHISWardModel dropDownModel = new RestHISWardModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7]);
				wardList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHISWardModel>> resp = new JsonResponse<List<RestHISWardModel>>();
		resp.setBody(wardList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestHISWardModel>>> response = new ResponseEntity<JsonResponse<List<RestHISWardModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : view ward dao starts");
		return response;
	}
	
	//deleteWard
	
	public ResponseEntity<JsonResponse<Object>> deleteWard(String id) {

		logger.info("Method : deleteWard Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_wardId='" + id + "';";
			logger.info("it is for delete=========="+  values);
			em.createNamedStoredProcedureQuery("his_routines").setParameter("actionType", "deleteWard")
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

		logger.info("Method : deleteWard Dao starts");
		return response;
	}

}
