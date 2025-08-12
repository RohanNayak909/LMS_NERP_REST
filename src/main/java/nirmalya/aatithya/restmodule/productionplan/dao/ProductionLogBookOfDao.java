package nirmalya.aatithya.restmodule.productionplan.dao;

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
import nirmalya.aatithya.restmodule.common.utils.productionplan.GenerateProductionLogBookOfParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.productionplan.model.ProductionLogBookOfRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ProductionLogBookOfDao {
	
	Logger logger = LoggerFactory.getLogger(ProductionLogBookOfDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	

	// getAggridDet
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getProductionLogOfAggridDatas(String orgName, String orgDivision) {
		logger.info("Method : getProductionLogOfAggridDatas Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_productionLogOf_routines")
					.setParameter("actionType", "getGridData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getProductionLogOfAggridDatas Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	
	
	// add.

		public ResponseEntity<JsonResponse<ProductionLogBookOfRestModel>> addProductionLogBookOf(
				ProductionLogBookOfRestModel qc) {
			logger.info("Method : addLaminates dao starts");
			System.out.println(qc);
			JsonResponse<ProductionLogBookOfRestModel> resp = new JsonResponse<ProductionLogBookOfRestModel>();

			

			try {
				String value = GenerateProductionLogBookOfParam.getProductionLogBook(qc);
				System.out.println("value===" + value);
				System.out.println("Modify qc===" + qc.getLogId());
				if (qc.getLogId() != null && qc.getLogId() != "") {

					em.createNamedStoredProcedureQuery("production_plan_productionLogOf_routines")
					.setParameter("actionType", "modifyLog").setParameter("actionValue", value).execute();

					resp.setCode("success");
					resp.setMessage("Data Modified successfully");

				} else {
					em.createNamedStoredProcedureQuery("production_plan_productionLogOf_routines")
					.setParameter("actionType", "addLog").setParameter("actionValue", value).execute();

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

			ResponseEntity<JsonResponse<ProductionLogBookOfRestModel>> response = new ResponseEntity<JsonResponse<ProductionLogBookOfRestModel>>(
					resp, HttpStatus.CREATED);
			System.out.println("response===" + response);
			logger.info("Method : addLaminates dao ends");
			return response;

		}
		

		// view

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getProductionLogOfView(String org, String orgDiv, String pageno) {
			logger.info("Method : getProductionLogOfView Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_pageNo='" + pageno + "';";
				logger.info("valuesss------------" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_productionLogOf_routines")
						.setParameter("actionType", "viewLog").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getProductionLogOfView Dao ends" + resp);
			return resp;
		}

		// view edit

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editProductionLogOf(String id, String orgName, String orgDivision) {
			logger.info("Method : editProductionLogOf Dao starts");
			
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_logId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("valuesss------------" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_productionLogOf_routines")
						.setParameter("actionType", "editLog").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : editProductionLogOf Dao ends" + resp);
			return resp;
		}
		

		// delete

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> deleteProductionLogOf(String id, String orgName, String orgDivision) {
			logger.info("Method : deleteProductionLogOf Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_logId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("valuesss------------" + value);
				em.createNamedStoredProcedureQuery("production_plan_productionLogOf_routines")
						.setParameter("actionType", "deleteLog").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("UNsuccess");
				resp.setMessage("Data Deleted failed");
			}
			logger.info("Method : deleteProductionLogOf Dao ends" + resp);
			return resp;
		}
		
		

		// approve

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> approveProductionLogOf(String id, String orgName, String orgDivision , String userId ) {
			logger.info("Method : approveProductionLogOf Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_logId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_approveBy='" + userId + "';";
				logger.info("valuesss------------" + value);
				em.createNamedStoredProcedureQuery("production_plan_productionLogOf_routines")
						.setParameter("actionType", "approveLog").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Approved successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("UNsuccess");
				resp.setMessage("Data Approve failed");
			}
			logger.info("Method : approveProductionLogOf Dao ends" + resp);
			return resp;
		}
		
		

		// Pdf.
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getProductionLogOfPdfDtls(String id, String orgName, String orgDivision) {
			logger.info("Method : getProductionLogOfPdfDtls Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			String value = "SET @p_logId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_productionLogOf_routines")
						.setParameter("actionType", "dloadLog").setParameter("actionValue", value).getResultList();
				
				resp.setBody(x.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getProductionLogOfPdfDtls Dao ends");
			System.out.println("resp**************EDIT**************" + resp);
			return resp;
		}
// search

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> searchProductionLogOfView(String orgName, String orgDivision, String value) {
			logger.info("Method : getProductionLogOfView Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String values = "SET  @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_searchvalue='" + value + "';";
				logger.info("valuesss------------" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_productionLogOf_routines")
						.setParameter("actionType", "searchLog").setParameter("actionValue", values).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getProductionLogOfView Dao ends" + resp);
			return resp;
		}

}
