package nirmalya.aatithya.restmodule.sales.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateSalesDeliveryChallanParameter;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestDeliveryChallanModel;

@Repository
public class RestDeliveryChallanDao {
	Logger logger = LoggerFactory.getLogger(RestDeliveryChallanDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTransportationModeLists() {
		logger.info("Method : getTransportationModeLists starts");

		List<DropDownModel> tModeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "getTransportationModeList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				tModeList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTransportationModeLists ends");
		return tModeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesInvoiceList(String id, String type) {

		logger.info("Method : getSalesInvoiceList starts");
		List<DropDownModel> salesInvoiceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_customerId='" + id + "',@p_type='" + type + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "getSalesInvoiceList").setParameter("actionValue", value)
					.getResultList();
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
		logger.info("Method : getSalesInvoiceList ends");
		return response;
	}

	/*
	 * add
	 */
	public ResponseEntity<JsonResponse<List<RestDeliveryChallanModel>>> addsaleDeliveryChallan(
			List<RestDeliveryChallanModel> restDeliveryChallanModel) {

		logger.info("Method : addsaleDeliveryChallan starts");

		logger.info("RestSalesInvoiceNewModel" + restDeliveryChallanModel);
		JsonResponse<List<RestDeliveryChallanModel>> resp = new JsonResponse<List<RestDeliveryChallanModel>>();
		List<RestDeliveryChallanModel> listData = new ArrayList<RestDeliveryChallanModel>();

		try {
			String values = GenerateSalesDeliveryChallanParameter.getAddChallanParam(restDeliveryChallanModel);

			if (restDeliveryChallanModel.get(0).getSaleDeliveryChallan() == null
					|| restDeliveryChallanModel.get(0).getSaleDeliveryChallan() == "") {
				logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);

				em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
						.setParameter("actionType", "addsaleDeliveryChallan").setParameter("actionValue", values)
						.execute();

			} else {
				logger.info("@modifyyyyyyyyyyyyyy" + values);

				em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
						.setParameter("actionType", "modifysaleDeliveryChallan").setParameter("actionValue", values)
						.execute();

				logger.info("modify printttttttttttttttttt" + listData);

			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestDeliveryChallanModel>>> response = new ResponseEntity<JsonResponse<List<RestDeliveryChallanModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data issssssssssssssssssssss" + response);
		logger.info("Method : addsaleDeliveryChallan ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDeliveryChallanModel>>> viewsalesdeliveryChallan(String orgName,
			String orgDiv) {
		logger.info("Method : viewsalesdeliveryChallan Dao startssssssssssssssssssssss");

		List<RestDeliveryChallanModel> getAllemployee = new ArrayList<RestDeliveryChallanModel>();
		JsonResponse<List<RestDeliveryChallanModel>> resp = new JsonResponse<List<RestDeliveryChallanModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "viewsalesdeliveryChallan").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[4] != null) {
					createdOn = m[4].toString();
				}

				RestDeliveryChallanModel viewdemo = new RestDeliveryChallanModel(m[0], m[1], m[2], m[3], createdOn,
						m[5], m[6], m[7], m[8], null, m[9], m[10], m[11], m[12]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestDeliveryChallanModel>>> response = new ResponseEntity<JsonResponse<List<RestDeliveryChallanModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewsalesdeliveryChallan Dao ends");
		logger.info("resp****************************" + response);
		return response;

	}

	/*
	 * edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<RestDeliveryChallanModel> viewsalesChallanEdit(String id) {
		logger.info("Method : viewsalesChallanEdit starts");
		// logger.info("RestDeliveryChallanModel" + id);
		List<RestDeliveryChallanModel> getRequisitionTypeList = new ArrayList<RestDeliveryChallanModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_salesDeliveryChallan='" + id + "';";
			System.out.println("Value for edit the delivery challan------------>" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "viewsalesChallanEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					Object createdOn = null;
					if (m[26] != null) {
						createdOn = m[26].toString();
					}
					Object ebillDate = null;
					if (m[38] != null) {
						ebillDate = m[38].toString();
					}

					RestDeliveryChallanModel dropDownModel = new RestDeliveryChallanModel(m[0], null, null, null, m[1],
							null, null, m[2], null, m[3], null, m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12],
							m[13], m[14], m[15], m[16], m[17], m[18], m[19], null, null, null, m[20], m[21], m[22],
							m[23], m[24], m[25], m[32], m[33], null, m[34], m[35], m[36], createdOn, m[27], null, m[28],
							null, m[29], m[30], m[31], m[37], ebillDate, m[39], null, null, m[40], m[41], m[42], m[43],
							null, null, null, m[44], m[45], m[46], m[47], m[48], null, null, null, null, null, null,
							null, null, null, null, null, null, null, m[49], null, null, m[50], m[51], m[52], m[53]);

					if (m[54] != null) {
						dropDownModel.setItemDesc(m[54].toString());
					}
					if (m[55] != null) {
						dropDownModel.setItemSlNo(m[55].toString());
					}
					if (m[56] != null) {
						dropDownModel.setChQty(m[56].toString());
					}
					if (m[57] != null) {
						dropDownModel.setPackedQty(m[57].toString());
					}
					if (m[58] != null) {
						dropDownModel.setPendingQty(m[58].toString());
					}

					getRequisitionTypeList.add(dropDownModel);
					// logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getSaleDeliveryChallan()
						+ "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
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
		logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewsalesChallanEdit ends");
		return getRequisitionTypeList;
	}

	/*
	 * delete
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> deletesalesDeliveryChallan(
			RestDeliveryChallanModel deletesalesDeliveryChallan) {
		logger.info("Method : deletesalesDeliveryChallan starts");
		// logger.info("restDeliveryChallanModel" + deletesalesDeliveryChallan);
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateSalesDeliveryChallanParameter.getDeleteParamnew(deletesalesDeliveryChallan);
			// logger.info(value);
			em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "deletesalesDeliveryChallan").setParameter("actionValue", value)
					.execute();
			// logger.info("print block" + deletesalesInvoice);
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
		// logger.info("@@@@@@@@@@@@@@@@" + deletesalesInvoice);
		logger.info("Method : deletesalesDeliveryChallan ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeliveryChallanInsertedId() {
		logger.info("Method : getDeliveryChallanInsertedId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "getDeliveryChallanInsertedId").setParameter("actionValue", "")
					.getResultList();

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
		logger.info("Method : getDeliveryChallanInsertedId ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesOrderListDc(String id, String type) {

		logger.info("Method : getSalesOrderListDc starts");
		List<DropDownModel> salesInvoiceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_customerId='" + id + "',@p_type='" + type + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "getSalesOrderListDc").setParameter("actionValue", value)
					.getResultList();
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
		logger.info("Method : getSalesOrderListDc ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPackageIdDc(String id) {

		logger.info("Method : getPackageIdDc starts");
		List<DropDownModel> salespackageList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_salesOrderId='" + id + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "getPackageIdDc").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salespackageList.add(dropDownModel);
				// logger.info("stateeeeeeeeeee"+dropDownModel);
			}

			resp.setBody(salespackageList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("stateeeeeeeeeee======" + response);
		logger.info("Method : getPackageIdDc ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<RestDeliveryChallanModel> viewDcViewPdf(String id, String orgName, String orgDiv) {
		logger.info("Method : viewPoViewPdf starts");
		List<RestDeliveryChallanModel> getRequisitionTypeList = new ArrayList<RestDeliveryChallanModel>();
		try {
			String values = "SET @p_deliverychallanId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "viewDcViewPdf").setParameter("actionValue", values).getResultList();

			try {
				for (Object[] m : x) {
					logger.info(Arrays.toString(m));
					Object createdOn = null;
					if (m[26] != null) {
						createdOn = m[26].toString();
					}
					Object sodate = null;
					if (m[29] != null) {
						sodate = m[29].toString();
					}
					Object refDate = null;
					if (m[42] != null) {
						refDate = m[42].toString();
					}

					String orgImg = null;
					if (m[54] != null && m[54] != "" && m[54] != " " && !m[54].toString().equals(" ")
							&& !m[54].toString().equals(null) && !m[54].toString().equals("")) {
						orgImg = env.getMobileView() + "document/document/" + m[54].toString();
					} else {
						orgImg = "";
					}
					RestDeliveryChallanModel dropDownModel = new RestDeliveryChallanModel(m[0], null, null, null, m[1],
							null, null, m[2], null, m[3], null, m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12],
							m[13], m[14], m[15], m[16], m[17], m[18], m[19], null, m[55], null, m[20], m[21], m[22],
							m[23], m[24], m[25], null, null, null, null, null, null, createdOn, m[27], null, m[28],
							sodate, m[30], m[31], m[32], m[44], null, m[33], m[34], m[35], m[36], m[37], m[38], m[39],
							m[40], m[41], refDate, m[43], m[45], m[46], m[47], m[48], m[49], m[50], null, null, null,
							null, null, null, null, m[51], m[52], m[53], orgImg, null, m[56], m[57], null, null, null,
							null);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("=======aaaaaaaaaaaa=================" + getRequisitionTypeList);
		logger.info("Method : viewDcViewPdf ends");
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDeliveryChallanModel>>> viewsalesPOWiseDeliveryChallan(String orgName,
			String orgDiv, String id) {
		logger.info("Method : viewsalesPOWiseDeliveryChallan Dao starts");

		List<RestDeliveryChallanModel> getAllemployee = new ArrayList<RestDeliveryChallanModel>();
		JsonResponse<List<RestDeliveryChallanModel>> resp = new JsonResponse<List<RestDeliveryChallanModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_poId='" + id + "';";
			logger.info("values****************************" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "viewsalesPOWiseDeliveryChallan").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[4] != null) {
					createdOn = m[4].toString();
				}

				RestDeliveryChallanModel viewdemo = new RestDeliveryChallanModel(m[0], m[1], m[2], m[3], createdOn,
						m[5], m[6], m[7], m[8], null, null, null, m[9], m[10]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestDeliveryChallanModel>>> response = new ResponseEntity<JsonResponse<List<RestDeliveryChallanModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewsalesPOWiseDeliveryChallan Dao ends");
		logger.info("resp****************************" + response);
		return response;

	}

	@SuppressWarnings("unchecked")
	public List<RestDeliveryChallanModel> viewsalesChallanGetInvoice(String id, String poid, String noOfChallan) {
		logger.info("Method : viewsalesChallanGetInvoice starts");
		List<RestDeliveryChallanModel> getRequisitionTypeList = new ArrayList<RestDeliveryChallanModel>();

		try {
			String values = "SET @p_salesDeliveryChallan='(" + id + ")',@p_poid='" + poid + "',@p_noOfChallan='"
					+ noOfChallan + "';";
			logger.info("valuesooooooooooooo" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "viewsalesChallanGetInvoice").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					RestDeliveryChallanModel dropDownModel = new RestDeliveryChallanModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7], m[8], m[9], m[10], null, m[11], m[12], m[13], m[14], m[15], m[16], m[17],
							m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30],
							m[31], m[32], m[33], m[34], m[35], null, m[36]);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewsalesChallanGetInvoice ends");
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesPoListForDc(String id) {

		logger.info("Method : getSalesPoListForDc starts");
		List<DropDownModel> salesPOList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_customerId='" + id + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "getSalesPoListForDc").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesPOList.add(dropDownModel);
			}
			resp.setBody(salesPOList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSalesPoListForDc ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewsalesPackages(String orgName, String orgDivision, String pageno) {
		logger.info("Method : viewsalesPackages Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pageno='" + pageno + "';";
			System.out.println("Value For View Package-----------." + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
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
	public JsonResponse<Object> getPoOnCustomerChange(String custId, String orgName, String orgDiv) {
		logger.info("Method : getPoOnCustomerChange Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_custId='" + custId + "';";
			System.out.println("getPoOnCustomerChange ========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "getPoOnCustomerChange").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getPoOnCustomerChange Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPoOnCustomerChangeEdit(String custId, String orgName, String orgDiv, String chId) {
		logger.info("Method : getPoOnCustomerChangeEdit Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_custId='" + custId + "', @p_chId='" + chId + "';";
			System.out.println("getPoOnCustomerChange ========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "getPoOnCustomerChangeEdit").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("Method : getPoOnCustomerChangeEdit Dao ends" + resp);
		return resp;
		
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPackageOnPo(String poId, String orgName, String orgDiv) {
		logger.info("Method : getPackageOnPo Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_poId='" + poId + "';";
			System.out.println("getPackageOnPo ========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "getPackageOnPo").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getPackageOnPo Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getItemDetailsOnPackage(String selectedValuesStr, String orgName, String orgDiv) {
		logger.info("Method : getItemDetailsOnPackage Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_selectedValue='"
					+ selectedValuesStr + "';";
			System.out.println("getItemDetailsOnPackage ========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "getItemDetailsOnPackage").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getItemDetailsOnPackage Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewsalesdeliveryChallan(String orgName, String orgDivision, String pageno,
			String fromDate, String toDate) {
		logger.info("Method : viewsalesdeliveryChallan Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pageno='" + pageno
					+ "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate + "';";
			System.out.println("value to get the delivery challan view--------->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "viewsalesdeliveryChallan").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewsalesdeliveryChallan Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTransporterDetails(String id, String org, String orgDiv) {
		logger.info("Method : getTransporterDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_searchValue='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("Value For Get Transport Details----->" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "getTransporterDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTransporterDetails Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getChallanDataForPdf(String challanId, String org, String orgDiv) {
		logger.info("Method : getChallanDataForPdf Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + org + "',@p_orgDiv='" + orgDiv + "',@p_challanId='" + challanId + "';";
			System.out.println("viewMeetingCalendar========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesDeliveryChallanNew")
					.setParameter("actionType", "getChallanDataForPdf").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getChallanDataForPdf Dao ends" + resp);
		return resp;

	}
}
