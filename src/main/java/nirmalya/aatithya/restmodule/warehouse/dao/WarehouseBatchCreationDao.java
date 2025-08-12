package nirmalya.aatithya.restmodule.warehouse.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateWarehouseAllocationParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateWarehouseBatchCreationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@Repository
public class WarehouseBatchCreationDao {
	Logger logger = LoggerFactory.getLogger(WarehouseBatchCreationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	//saveBatch
		public ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> saveBatchData(
				List<WirehouseRomeModel> wirehouseRomeModel) {
			logger.info("Method : saveBatchData starts");
			JsonResponse<List<WirehouseRomeModel>> resp = new JsonResponse<List<WirehouseRomeModel>>();
			List<WirehouseRomeModel> listData = new ArrayList<WirehouseRomeModel>();

			System.out.println("=====>>>>>" + wirehouseRomeModel);

			try {
				String values = GenerateWarehouseBatchCreationParameter.saveBatchParam(wirehouseRomeModel);
				if (wirehouseRomeModel.get(0).getBatchId() == null
						|| wirehouseRomeModel.get(0).getBatchId() == "") {
				 em.createNamedStoredProcedureQuery("warehouseBatchCreationRoutine")
							.setParameter("actionType", "saveBatchData").setParameter("actionValue", values)
							.execute();
				} else {
					System.out.println("@modify" + values);
					em.createNamedStoredProcedureQuery("warehouseBatchCreationRoutine")
							.setParameter("actionType", "modifyBatchData").setParameter("actionValue", values)
							.execute();
				}

					resp.setCode("success");
					resp.setMessage("Data Saved Successfully");
			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode("Failed");
					resp.setMessage(err[1]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			resp.setBody(listData);
			ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> response = new ResponseEntity<JsonResponse<List<WirehouseRomeModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response data is" + response);
			logger.info("Method : saveBatchData ends");
			return response;
		}
		 //viewBatch
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewBatchData(String orgName, String orgDivision) {
			logger.info("Method : viewBatchData Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseBatchCreationRoutine")
						.setParameter("actionType", "viewBatchData").setParameter("actionValue", value)
						.getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewBatchData Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		//Edit Batch Data
		
		@SuppressWarnings("unchecked")
		public JsonResponse editBatchData(String batchId,String orgName, String orgDiv) {
			logger.info("Method : editBatchData Dao startssssssssssssssssssssss");

			JsonResponse resp = new JsonResponse();

			try {
				String value = "SET @p_batchId='" + batchId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseBatchCreationRoutine")
						.setParameter("actionType", "editBatchData").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
			logger.info("Method : editBatchData Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		 
		
		// Delete Batch data
		

		public JsonResponse<Object> deleteBatchdata(String batchId,String orgName,String orgDivision) {
			logger.info("Method : deleteBatchdata starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			try {
				String value = "SET @p_batchId='" + batchId + "',@p_org='" + orgName + "',@p_orgDiv='"+ orgDivision +"';";
				System.out.println("value==="+value);
				em.createNamedStoredProcedureQuery("warehouseBatchCreationRoutine")
						.setParameter("actionType", "deleteBatchdata").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
			logger.info("Method : deleteBatchdata ends");
			return resp;
		}
		
		//Approve Batch
		
		public JsonResponse<WirehouseRomeModel> approveBatch(String approveStatus, String batchId,String orgName,String orgDivision) {
			logger.info("Method : approveBatch starts");

			JsonResponse<WirehouseRomeModel> resp = new JsonResponse<WirehouseRomeModel>();
			try {
				
				String value = "SET @p_approveStatus='" + approveStatus + "',@p_batchId='" + batchId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision +"';";
				System.out.println("value==="+value);
				em.createNamedStoredProcedureQuery("warehouseBatchCreationRoutine").setParameter("actionType", "approveBatch")
						.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Approved successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
			System.out.println("resp==="+resp);
			logger.info("Method : approveBatch ends");
			return resp;
		}
}
