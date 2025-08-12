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
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateManagePropertyParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestManagePropertyModel;

@Repository
public class RestStakeholderManagePropertyDao {

	Logger logger = LoggerFactory.getLogger(RestStakeholderManagePropertyDao .class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
	

////add
	public ResponseEntity<JsonResponse<Object>> saveProperty(RestManagePropertyModel restPayroll) {

		logger.info("Method : Rest saveProperty Dao starts");
		logger.info("restPayroll" + restPayroll);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		logger.info("restPayroll.getId() ====" + restPayroll.getPropId());
	
			try {

				String values = GenerateManagePropertyParam.addPropertyParam(restPayroll);

					if (restPayroll.getPropId() == null || restPayroll.getPropId() == "") {

						logger.info("values IN ADD"+values);
						em.createNamedStoredProcedureQuery("viewProperty").setParameter("actionType", "adddetails")
								.setParameter("actionValue", values).execute();

					} else {

						logger.info("values in modify");
						em.createNamedStoredProcedureQuery("viewProperty").setParameter("actionType", "modifypropertydetails")
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

		logger.info("Method : Rest saveProperty Dao ends");

		return response;
}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAreaList() {
		logger.info("Method : getAreaList starts");

		List<DropDownModel> CountryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewProperty")
					.setParameter("actionType", "getCityList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				CountryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAreaList ends");
		return CountryList;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getpropertyList() {
		logger.info("Method : getpropertyList starts");

		List<DropDownModel> propertyList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewProperty")
					.setParameter("actionType", "getpropertyList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				propertyList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getpropertyList ends");
		return propertyList;
	}
	
	
	

	
////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManagePropertyModel>>> ViewProperty(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewProperty starts");
		List<RestManagePropertyModel> respList = new ArrayList<RestManagePropertyModel>();
		
		String value = "SET @p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
		logger.info(value);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewProperty").setParameter("actionType", "viewView")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestManagePropertyModel restPayroll = new RestManagePropertyModel(m[0], m[1], m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14]);
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestManagePropertyModel>> resp = new JsonResponse<List<RestManagePropertyModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestManagePropertyModel>>> response = new ResponseEntity<JsonResponse<List<RestManagePropertyModel>>>(
				resp, HttpStatus.CREATED);
		//logger.info("response" + response);
		logger.info("Method : ViewProperty ends");

		//logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
////edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManagePropertyModel>>>editProperty(String id) {
		logger.info("Method : editState starts");

		JsonResponse<List<RestManagePropertyModel>> resp = new JsonResponse<List<RestManagePropertyModel>>();
		List<RestManagePropertyModel> rs = new ArrayList<RestManagePropertyModel>();

		try {

			String value = "SET @p_propId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewProperty").setParameter("actionType", "viewEdit")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestManagePropertyModel reqemp = new RestManagePropertyModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14]);
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestManagePropertyModel>>> response = new ResponseEntity<JsonResponse<List<RestManagePropertyModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : editState ends");
		return response;
	}
	//delete
		public ResponseEntity<JsonResponse<Object>> deleteProperty(String id) {
			logger.info("Method : deleteProperty starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			logger.info("ID...."+id);
			if (validity)
				try {

					String value = "SET @p_propId='" + id + "';";
					logger.info(value);

					em.createNamedStoredProcedureQuery("viewProperty")
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

			logger.info("Method :  deleteProperty ends");
			logger.info("DELETEE" + response);
			return response;
		}
		

}
