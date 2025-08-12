package nirmalya.aatithya.restmodule.account.dao;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateAccountMonthlyProvision;
import nirmalya.aatithya.restmodule.account.model.RestMonthlyProvisionModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;
@Repository
public class RestAccountMonthlyProvisionDao {
	Logger logger = LoggerFactory.getLogger(RestAccountMonthlyProvisionDao.class);
	
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;

	/*@SuppressWarnings("unchecked")
	public List<DropDownModel> getYearListDao() {
		logger.info("Method : getYearListDao starts");
		List<DropDownModel> farmList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("view_monthly_provisions")
					.setParameter("actionType", "getYearList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				farmList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getYearListDao ends");
		return farmList;
	}*/
	//category Name AutoSearch

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getCategoryAutoSearchList(String id, String org, String orgDiv) {
			logger.info("Method : getCategoryAutoSearchList Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_searchValue='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

				List<Object[]> x = em.createNamedStoredProcedureQuery("view_monthly_provisions")
						.setParameter("actionType", "getCatgorySearchList").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				if (x.toString().contentEquals("[null]")) {
					Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
				} else {
					Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

				}
			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			logger.info("ADDDDDDDDDDD" + resp);
			logger.info("Method : getCategoryAutoSearchList Dao ends");
			return resp;
		}
		
		

		/**
		 * DAO Function to Add
		 *
		 */
		public ResponseEntity<JsonResponse<Object>> addmonthlyprovisionMasterdetails(RestMonthlyProvisionModel restProvision) {
			logger.info("Method : Rest addmonthlyprovisionMasterdetails  Dao starts");
			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			if (validity)
				try {

					String values = GenerateAccountMonthlyProvision.getMonthlyprovisionParam(restProvision);
					if (restProvision.getProvisionId() == null || restProvision.getProvisionId() == "") {
						em.createNamedStoredProcedureQuery("view_monthly_provisions")
								.setParameter("actionType", "addmonthprovision")
								.setParameter("actionValue", values)
								.execute();

					} else {
						em.createNamedStoredProcedureQuery("view_monthly_provisions")
								.setParameter("actionType", "modifymonth").setParameter("actionValue", values)
								.execute();
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
		
			logger.info("Method : Rest addmonthlyprovisionMasterdetails  Dao ends");

			return response;
		}
		
		
		      //view 
		        @SuppressWarnings("unchecked")
		        public JsonResponse<List<RestMonthlyProvisionModel>> restviewMonthlyprovision(String year,String month) {
				logger.info("Method : restviewMonthlyprovision Dao starts");
				List<RestMonthlyProvisionModel> viewmonthlyprovision = new ArrayList<RestMonthlyProvisionModel>();
				JsonResponse<List<RestMonthlyProvisionModel>> resp = new JsonResponse<List<RestMonthlyProvisionModel>>(); 
					try {
						String value = "SET @p_year='" + year + "', @p_month='" + month + "';";
						List<Object[]> x =em.createNamedStoredProcedureQuery("view_monthly_provisions") 
						.setParameter("actionType", "viewMonthlyprovision").setParameter("actionValue", value).getResultList();
	  
						for (Object[] m : x) {
							RestMonthlyProvisionModel restviewMonthlyprovision = new RestMonthlyProvisionModel(m[0].toString(),null, m[1].toString(), m[2].toString(), m[3].toString(), m[4].toString(),null,null);
							System.out.println(m[0].toString()); 
							viewmonthlyprovision.add(restviewMonthlyprovision);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					resp.setBody(viewmonthlyprovision);
					logger.info("Method : restviewMonthlyprovision Dao ends");
					return resp;
				}
		
		//Edit
		@SuppressWarnings("unchecked")
		public JsonResponse<RestMonthlyProvisionModel> editmonthlyprovision(String id) {
			logger.info("Method : editmonthlyprovision dao starts");
			RestMonthlyProvisionModel req = new RestMonthlyProvisionModel();
			JsonResponse<RestMonthlyProvisionModel> resp = new JsonResponse<RestMonthlyProvisionModel>();
			try {
				String value = "SET @p_provisionId='" + id + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("view_monthly_provisions")
						.setParameter("actionType", "editmonthlyprovision").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					

					RestMonthlyProvisionModel restPayroll = new RestMonthlyProvisionModel(m[0].toString(),null, m[1].toString(), m[2].toString(), m[3].toString(), m[4].toString(),null,null);
					req = restPayroll;

				}
				resp.setBody(req);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : editmonthlyprovision dao ends");
			return resp;
		}
		
		
		
		 // delete

		public ResponseEntity<JsonResponse<Object>> deletemonthlyprovision(String id) {
			logger.info("Method : deletemonthlyprovision starts");
			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {
					String value = "SET @p_provisionId='" + id + "';";
					em.createNamedStoredProcedureQuery("view_monthly_provisions").setParameter("actionType", "deleteprovision")
							.setParameter("actionValue", value).execute();

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

			logger.info("Method : deletemonthlyprovision ends");
			return response;
		}
		  
}




