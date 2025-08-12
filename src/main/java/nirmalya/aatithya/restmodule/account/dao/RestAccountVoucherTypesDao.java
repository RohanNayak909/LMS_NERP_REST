package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestAccountVoucherTypesDao {
	Logger logger = LoggerFactory.getLogger(RestAccountVoucherTypesDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	//Auto search ledger
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getLedgerListSearch(String id, String orgName,
			String orgDivision) {
		logger.info("Method : getLedgerListSearch starts");

		List<RestContraVoucherModel> itemNameList = new ArrayList<RestContraVoucherModel>();
		JsonResponse<List<RestContraVoucherModel>> resp = new JsonResponse<List<RestContraVoucherModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("value for search-->" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_voucher_type_routines")
					.setParameter("actionType", "getLedgerList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestContraVoucherModel dropDownModel = new RestContraVoucherModel(m[0], m[1], null, null, null);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> response = new ResponseEntity<JsonResponse<List<RestContraVoucherModel>>>(
				resp, HttpStatus.CREATED);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("response===>"+response);
		logger.info("Method : getLedgerListSearch ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> voucherTypeList(String orgName,String orgDivision) {

		logger.info("Method :voucherTypeList starts");

		List<DropDownModel> voucherTypeList = new ArrayList<DropDownModel>();
		String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_voucher_type_routines")
					.setParameter("actionType", "getVoucherTypesName").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				voucherTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : voucherTypeList ends" + voucherTypeList);

		return voucherTypeList;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> voucherTypesAdd(String obj,String orgName,String orgDivision,String userId,String voucherId) {
		logger.info("Method : voucherTypesAdd Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_rowDataList='" + obj+  "',@p_createdBy='" + userId  +  "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_voucherid='" + voucherId + "';";
			logger.info("values--->" + value);

			if(voucherId == "") {
				
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_voucher_type_routines")
					.setParameter("actionType", "addVoucherAndClassName").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			}
			else {
				logger.info("voucher id is present" + voucherId);
				logger.info("values-->" + value);
				
				List<Object[]> x = em.createNamedStoredProcedureQuery("account_voucher_type_routines")
						.setParameter("actionType", "modifieyVoucherTypes").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Modified Successfully");
			}
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : voucherTypesAdd Dao ends" + resp);
		return resp;

	}
	
	// view ag grid voucher types
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> restViewVoucherTypes(String orgName, String orgDivision) {
			logger.info("Method : restViewVoucherTypes Dao startss");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String values = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("values-->"+ values);

				List<Object[]> x = em.createNamedStoredProcedureQuery("account_voucher_type_routines")
						.setParameter("actionType", "viewVoucherTypes").setParameter("actionValue", values).getResultList();

				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : restViewVoucherTypes Dao ends" + resp);
			return resp;

		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editVoucherTypeFilteredData(String orgName, String orgDivision, String id) {
			logger.info("Method : editVoucherType Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String values = "SET @p_orgName='" + orgName + "',@p_id='" +id + "',@p_orgDiv='" + orgDivision + "';";
				
				logger.info("values----->"+values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("account_voucher_type_routines")
						.setParameter("actionType", "editVoucherTypes").setParameter("actionValue", values)
						.getResultList();
				
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched Successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : editVoucherType Dao ends"+resp);
			return resp;

		}
		
		
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> deleteVoucherType(String orgName, String orgDivision, String id) {
			logger.info("Method : DeleteVoucherType Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String values = "SET @p_orgName='" + orgName + "',@p_id='" +id + "',@p_orgDiv='" + orgDivision + "';";
				
				logger.info("values----->"+values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("account_voucher_type_routines")
						.setParameter("actionType", "deleteVoucherType").setParameter("actionValue", values)
						.getResultList();
				
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Delete Successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : DeleteVoucherType Dao ends"+resp);
			return resp;

		}
}
