package nirmalya.aatithya.restmodule.sales.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateSalesPackagesParameter;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesPackagesModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestSalesPackagesDao {
	Logger logger = LoggerFactory.getLogger(RestSalesPackagesDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPackagingtypeList() {
		logger.info("Method : getPackagingtypeList starts");

		List<DropDownModel> getPackagingtypeList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
					.setParameter("actionType", "getPackagingtypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				getPackagingtypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPackagingtypeList ends");

		return getPackagingtypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderList(String id, String type) {

		logger.info("Method : getSalesOrderList starts");
		List<DropDownModel> salesInvoiceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_customerId='" + id + "',@p_type='" + type + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
					.setParameter("actionType", "getSalesOrderList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesInvoiceList.add(dropDownModel);
				// logger.info("stateeeeeeeeeee"+dropDownModel);
			}

			resp.setBody(salesInvoiceList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("stateeeeeeeeeee======" + response);
		logger.info("Method : getSalesOrderList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewsalesPackages(String orgName, String orgDivision, String pageno) {
		logger.info("Method : viewsalesPackages Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pageno='" + pageno + "';";
			System.out.println("Value For View Package-----------."+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
					.setParameter("actionType", "viewsalesPackages").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewsalesPackages Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesPackagesModel>>> addpackagesnew(
			List<RestSalesPackagesModel> restSalesPackagesModel) {

		logger.info("Method : addpackagesnew starts");

		JsonResponse<List<RestSalesPackagesModel>> resp = new JsonResponse<List<RestSalesPackagesModel>>();
		List<RestSalesPackagesModel> listData = new ArrayList<RestSalesPackagesModel>();

		logger.info("=====>>>>>" + restSalesPackagesModel);

		try {
			String values = GenerateSalesPackagesParameter.getAddPackageParam(restSalesPackagesModel);

			if (restSalesPackagesModel.get(0).getSalePackageId() == null
					|| restSalesPackagesModel.get(0).getSalePackageId() == "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
						.setParameter("actionType", "addpackagesnew").setParameter("actionValue", values)
						.getResultList();
				resp.setCode("success");
				resp.setMessage("Packaging Saved Successfully");
				try {
					for (Object[] m : x) {
						/*
						 * Object DATE = null; if (m[4] != null) { DATE = m[4].toString(); }
						 */

						RestSalesPackagesModel dropDownModel = new RestSalesPackagesModel(m[0], m[1], null, null, m[2],
								null, null, null, m[3], null, m[4], null, null, null, null, null, null, null, m[5],
								null, null, m[6]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("@addd" + listData);
			} else {
				logger.info("@modify" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
						.setParameter("actionType", "modifypackagesnew").setParameter("actionValue", values)
						.getResultList();
				resp.setCode("success");
				resp.setMessage("Packaging Modified Successfully");

				try {
					for (Object[] m : x) {
						/*
						 * Object DATE = null; if (m[4] != null) { DATE = m[4].toString(); }
						 */

						RestSalesPackagesModel dropDownModel = new RestSalesPackagesModel(m[0], m[1], null, null, m[2],
								null, null, null, m[3], null, m[4], null, null, null, null, null, null, null, m[5],
								null, null, m[6]);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("print in modify block" + listData);
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
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestSalesPackagesModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesPackagesModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addpackagesnew ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesPackagesModel>>> viewsalesPackages() {
		logger.info("Method : viewsalesPackages Dao startssssssssssssssssssssss");

		List<RestSalesPackagesModel> getAllemployee = new ArrayList<RestSalesPackagesModel>();
		JsonResponse<List<RestSalesPackagesModel>> resp = new JsonResponse<List<RestSalesPackagesModel>>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
					.setParameter("actionType", "viewsalesPackages").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				Object createdOn = null;
				if (m[4] != null) {
					createdOn = m[4].toString();
				}
				RestSalesPackagesModel viewdemo = new RestSalesPackagesModel(m[0], m[1], m[2], null, m[3], null, null,
						null, null, createdOn, null, null, m[5], null, null, null, null, null, null, m[6], m[7], null);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("resp====" + resp);
		ResponseEntity<JsonResponse<List<RestSalesPackagesModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesPackagesModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewsalesPackages Dao ends");
		return response;

	}

	// Edit

/*	@SuppressWarnings("unchecked")
	public List<RestSalesPackagesModel> viewPackageEdit(String id) {
		logger.info("Method : viewPackageEdit starts");
		List<RestSalesPackagesModel> getRequisitionTypeList = new ArrayList<RestSalesPackagesModel>();
		try {
			String values = "SET @p_packageId='" + id + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
					.setParameter("actionType", "viewPackageEdit").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {

					Object DATE = null;
					if (m[5] != null) {
						DATE = m[5].toString();
					}
					RestSalesPackagesModel dropDownModel = new RestSalesPackagesModel(m[0], m[1], m[2], m[3], m[4],
							DATE, m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18],
							m[19], m[20], m[21], m[22], m[23], m[24]);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// resp.setBody(getRequisitionTypeList);
		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : viewPackageEdit ends");
		return getRequisitionTypeList;
	}
*/
	public ResponseEntity<JsonResponse<Object>> deletPackage(String id) {
		logger.info("Method : deletPackage starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_packageId='" + id + "';";

				em.createNamedStoredProcedureQuery("salesPackagesNew").setParameter("actionType", "deletPackage")
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

		logger.info("Method : deletPackage ends");
		logger.info("DELETEE" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInsertedId() {
		logger.info("Method : getLastJobId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
					.setParameter("actionType", "getInsertedId1").setParameter("actionValue", "").getResultList();

			Object jobId = x.get(0);
			logger.info("job id--------" + jobId);

			DropDownModel dropDownModel = new DropDownModel(jobId, null);

			itemList.add(dropDownModel);
			resp.setBody(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("response for getting job card id -------" + response);
		logger.info("Method : getLastJobId ends");
		return response;
	}
//Save  apply

	// For add
	public ResponseEntity<JsonResponse<Object>> savepackedQutdetails(RestSalesPackagesModel restSalesPackagesModel) {
		logger.info("Method : savepackedQutdetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("ADDDDDDDDDDDDD" + restSalesPackagesModel.getSalesOrderId());
		try {
			String values = GenerateSalesPackagesParameter.getAddsalesParam(restSalesPackagesModel);

			if (restSalesPackagesModel.getSalesOrderId() != null || restSalesPackagesModel.getSalesOrderId() != "") {

				em.createNamedStoredProcedureQuery("salesPackagesNew")
						.setParameter("actionType", "savepackedQutdetails").setParameter("actionValue", values)
						.execute();
			} else {

				em.createNamedStoredProcedureQuery("salesPackagesNew").setParameter("actionType", "modifyPolicy")
						.setParameter("actionValue", values).execute();
			}

		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		logger.info("respfvbnm" + resp);

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("savepackedQutdetails" + response);

		logger.info("Method : savepackedQutdetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<RestSaleOrderNewModel> viewsalesOrderItemDetails(String id) {
		logger.info("Method : viewsalesOrderItemDetails starts");
		logger.info("RestSaleOrderNewModel" + id);
		List<RestSaleOrderNewModel> getRequisitionTypeList = new ArrayList<RestSaleOrderNewModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_salesId='" + id + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
					.setParameter("actionType", "viewsalesOrderItemDetails").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel(m[0], m[1], m[2], m[3], m[4], m[5],
							m[6], m[7], m[8], m[9], m[10], m[11].toString(), m[12].toString(), m[13].toString());
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getQuotationId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesPackagesNew")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
					docList.add(dropDownModel);
				}
			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : viewsalesOrderItemDetails ends");
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public List<RestSalesPackagesModel> getDeliveryChallanDataOnPackageId(String id) {
		logger.info("Method : getDeliveryChallanDataOnPackageId starts");

		List<RestSalesPackagesModel> getRequisitionTypeList = new ArrayList<RestSalesPackagesModel>();
		try {
			String values = "SET @p_packageId='" + id + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
					.setParameter("actionType", "getDeliveryChallanDataOnPackageId").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					Object qnt = null;
					if (m[7] != null) {
						double d = Double.parseDouble(m[7].toString());
						qnt = d;
					}

					RestSalesPackagesModel dropDownModel = new RestSalesPackagesModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], qnt, m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18],
							m[19], m[20], m[21], null, m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30]);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// resp.setBody(getRequisitionTypeList);
		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : getDeliveryChallanDataOnPackageId ends");
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllsalesOrder(String orgName, String orgDivision, String pageno) {
		logger.info("Method : getAllsalesOrder Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pageno='" + pageno + "';";
			System.out.println("Value For View Sales Order------->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
					.setParameter("actionType", "getSalesOrder").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllsalesOrder Dao ends");
		return resp;

	}
	
//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewsalesForPacking(String id, String poidd, String orgName, String orgDivision) {
		logger.info("Method : viewsalesForPacking Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_poId='" + poidd + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("valuee======"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
					.setParameter("actionType", "getPackagingDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Response Data===="+resp);
		logger.info("Method : viewsalesForPacking Dao ends"+resp);
		return resp;
	}
	
//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPackageEdit(String id, String orgName, String orgDivision) {
		logger.info("Method : viewPackageEdit Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("valuee======"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPackagesNew")
					.setParameter("actionType", "viewPackageEdit").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPackageEdit Dao ends"+resp);
		return resp;
	}
}
