package nirmalya.aatithya.restmodule.sales.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.sales.GeneratePoOrWoParamater;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestPoOrWoModel;

@Repository
public class RestPoOrWoDao {
	Logger logger = LoggerFactory.getLogger(RestPoOrWoDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * add
	 */
	public ResponseEntity<JsonResponse<List<RestPoOrWoModel>>> addSalesPo(List<RestPoOrWoModel> restPoOrWoModel) {

		logger.info("Method : addSalesPo starts");

		logger.info("RestPoOrWoModel" + restPoOrWoModel);
		JsonResponse<List<RestPoOrWoModel>> resp = new JsonResponse<List<RestPoOrWoModel>>();
		List<RestPoOrWoModel> listData = new ArrayList<RestPoOrWoModel>();
		
		String status = "failed";
		if(restPoOrWoModel.size() > 0 && restPoOrWoModel.get(0).getIsUpdateSo().equals(true)) {
			status = isSoGenerated(restPoOrWoModel.get(0).getPoRef(),restPoOrWoModel.get(0).getOrganization(),restPoOrWoModel.get(0).getOrgDivision());
		}
		if(status.equals("success")) {
			resp.setMessage("Revision failed: No Sales Order exists for the provided PO reference '"+restPoOrWoModel.get(0).getPoRef()+"'");
			ResponseEntity<JsonResponse<List<RestPoOrWoModel>>> response = new ResponseEntity<JsonResponse<List<RestPoOrWoModel>>>(
					resp, HttpStatus.CREATED);
			return response;
		}

		try {
			String values = GeneratePoOrWoParamater.getAddPoParam(restPoOrWoModel);
			System.out.println("VALUE FOR ADDING THE PURCHASE ORDER---------->" + values);
			// logger.info("restPoOrWoModel#" + restPoOrWoModel);

			if (restPoOrWoModel.get(0).getReferenceId() == null || restPoOrWoModel.get(0).getReferenceId() == "") {
				logger.info("ADD#" + values);
				System.out.println("calling addSalesPo action type");
				em.createNamedStoredProcedureQuery("salesPurchaseOrder").setParameter("actionType", "addSalesPo")
						.setParameter("actionValue", values).execute();
			} else {
				System.out.println("calling modifySalesPo action type");
				logger.info("@restPoOrWoModel" + restPoOrWoModel);
				em.createNamedStoredProcedureQuery("salesPurchaseOrder").setParameter("actionType", "modifySalesPo")
						.setParameter("actionValue", values).execute();
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
		ResponseEntity<JsonResponse<List<RestPoOrWoModel>>> response = new ResponseEntity<JsonResponse<List<RestPoOrWoModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addSalesPo ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public String isSoGenerated(String poRefId, String org, String orgDiv) {
		logger.info("Method : isSoGenerated starts");

		String status = "failed";

		try {
			String value = "SET @p_poRefId='" + poRefId + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
					.setParameter("actionType", "isSoGenerated").setParameter("actionValue", value).getResultList();
			
			System.out.println(x);
			if (!x.isEmpty() && x.get(0) != null && x.get(0)[0] != null && !((String) x.get(0)[0]).isEmpty()) {
			    status = "failed";
			} else {
			    status = "success";
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			status = "failed";
		}

		System.out.println("Statussss="+status);
		
		logger.info("Method : isSoGenerated ends");
		return status;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewsalesPo(String orgName, String orgDivision, String pageno, String userId,String fDate,String tDate) {
		logger.info("Method : viewsalesPo Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			 SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
		        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

		        String formattedFDate = "";
		        String formattedTDate = "";

		        if (fDate != null && !fDate.isEmpty()) {
		            Date date1 = inputFormat.parse(fDate);
		            formattedFDate = outputFormat.format(date1);
		        }

		        if (tDate != null && !tDate.isEmpty()) {
		            Date date2 = inputFormat.parse(tDate);
		            formattedTDate = outputFormat.format(date2);
		        }
			
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pageno='" + pageno
					+ "',@p_userId='" + userId + "', @p_fDate='" + formattedFDate  + "', @p_tDate='" + formattedTDate  + "';";
			System.out.println("Value For View PO/WO----------->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
					.setParameter("actionType", "viewsalesPo").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewsalesPo Dao ends");
		return resp;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestPoOrWoModel> viewsalesPoEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : viewsalesPoEdit starts");
		List<RestPoOrWoModel> getRequisitionTypeList = new ArrayList<RestPoOrWoModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_poId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
					.setParameter("actionType", "viewsalesPoEdit").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {

					Object podate = null;
					if (m[3] != null) {
						podate = m[3].toString();
					}
					Object sDate = null;
					if (m[29] != null) {
						sDate = m[29].toString();
					}
					Object soDate = null;
					if (m[46] != null) {
						soDate = m[46].toString();
					}

					RestPoOrWoModel dropDownModel = new RestPoOrWoModel(m[0], m[1], m[2], podate, m[4], m[5], null,
							m[6], m[7], null, m[8], null, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
							m[18], m[19], m[20], m[21], m[22], m[23], m[24], null, m[25], null, m[26], m[27], m[28],
							null, null, sDate, m[30], m[31], m[32], m[33], null, m[34], m[35], m[36], m[37], m[38],
							m[39], m[40], m[41], m[42], m[43], null, m[44], m[45], soDate, null, m[47], null, m[48],
							m[49], m[50], m[51], m[52], m[53]);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getReferenceId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
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

		System.out.println("getRequisitionTypeList==" + getRequisitionTypeList);
		System.out.println("docList==" + docList);

		if (getRequisitionTypeList.size() > 0)
			getRequisitionTypeList.get(0).setDocumentList(docList);

		logger.info("Method : viewsalesPoEdit ends");
		return getRequisitionTypeList;
	}

	/*
	 * delete
	 * 
	 */
	public ResponseEntity<JsonResponse<Object>> deleteSalesPo(RestPoOrWoModel deletePo) {
		logger.info("Method : deleteSalesPo starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GeneratePoOrWoParamater.getDeleteSalesPo(deletePo);
			System.out.println("value for delete po--------->" + value);
			// logger.info(value);
			em.createNamedStoredProcedureQuery("salesPurchaseOrder").setParameter("actionType", "deleteSalesPo")
					.setParameter("actionValue", value).execute();
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
		logger.info("Method : deleteSalesPo ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<RestPoOrWoModel> getSoData(String id, String skuid, String orgName, String orgDiv) {
		logger.info("Method : getSoData starts");
		List<RestPoOrWoModel> getRequisitionTypeList = new ArrayList<RestPoOrWoModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_poId='" + id + "',@p_skuid='(" + skuid + ")',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
					.setParameter("actionType", "getSoData").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {

					Object podate = null;
					if (m[3] != null) {
						podate = m[3].toString();
					}
					Object sDate = null;
					if (m[29] != null) {
						sDate = m[29].toString();
					}

					RestPoOrWoModel dropDownModel = new RestPoOrWoModel(m[0], m[1], m[2], podate, m[4], m[5], null,
							m[6], m[7], null, m[8], null, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
							m[18], m[19], m[20], m[21], m[22], m[23], m[24], null, m[25], null, m[26], m[27], m[28],
							null, null, sDate, m[30], m[31], m[32], m[33], null, m[34], m[35], m[36], m[37], m[38],
							m[39], m[40], m[41], m[42], m[43], null, null, null, null, null, null, null, m[44], null,
							m[45], m[46], null, null);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getReferenceId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
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
		logger.info("Method : getSoData ends");
		return getRequisitionTypeList;
	}

//Block Order

	/*
	 * public JsonResponse<RestPoOrWoModel> blockSaleOrder(String blockeOrder,
	 * String referenceId,String sku) {
	 * logger.info("Method : blockSaleOrder starts");
	 * 
	 * RestPoOrWoModel req = new RestPoOrWoModel(); JsonResponse<RestPoOrWoModel>
	 * resp = new JsonResponse<RestPoOrWoModel>(); try {
	 * 
	 * String value = "SET @p_blockeOrder='" + blockeOrder + "',@p_referenceId='" +
	 * referenceId + "',@p_sku='" + sku + "';"; logger.info("value==="+value);
	 * em.createNamedStoredProcedureQuery("salesPurchaseOrder").setParameter(
	 * "actionType", "blockSaleOrder") .setParameter("actionValue",
	 * value).execute(); resp.setBody(req); resp.setCode("success");
	 * resp.setMessage("approveItemQuatation successfully");
	 * 
	 * 
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } logger.info("resp==="+resp);
	 * logger.info("Method : blockSaleOrder ends"); return resp; }
	 */
	@SuppressWarnings("unchecked")
	public List<RestPoOrWoModel> viewsalesCreateversionEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : viewsalesCreateversionEdit starts");
		logger.info("RestPoOrWoModel" + id);
		List<RestPoOrWoModel> getRequisitionTypeList = new ArrayList<RestPoOrWoModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_poId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
					.setParameter("actionType", "viewsalesCreateversionEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					Object podate = null;
					if (m[3] != null) {
						podate = m[3].toString();
					}
					Object sDate = null;
					if (m[29] != null) {
						sDate = m[29].toString();
					}
					Object soDate = null;
					if (m[46] != null) {
						soDate = m[46].toString();
					}

					RestPoOrWoModel dropDownModel = new RestPoOrWoModel(m[0], m[1], m[2], podate, m[4], m[5], null,
							m[6], m[7], null, m[8], null, m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
							m[18], m[19], m[20], m[21], m[22], m[23], m[24], null, m[25], null, m[26], m[27], m[28],
							null, null, sDate, m[30], m[31], m[32], m[33], null, m[34], m[35], m[36], m[37], m[38],
							m[39], m[40], m[41], m[42], m[43], null, m[44], m[45], soDate, null, m[47].toString(),
							m[48], m[49], m[50], m[51], m[52], m[53], m[54]);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getReferenceId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
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
		logger.info("Method : viewsalesCreateversionEdit ends");
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getQuotationOnselectedCustomer(String custId, String orgName, String orgDiv) {
		logger.info("Method : getQuotationOnselectedCustomer Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_custId='" + custId + "';";
			System.out.println("getQuotationOnselectedCustomer ========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
					.setParameter("actionType", "getQuotation").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getQuotationOnselectedCustomer Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getQuotationDetails(String quotationId, String orgName, String orgDiv) {
		logger.info("Method : getQuotationDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_quotationId='" + quotationId
					+ "';";
			System.out.println("getQuotationDetails ========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
					.setParameter("actionType", "getQuotationDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getQuotationDetails Dao ends" + resp);
		return resp;

	}

	public JsonResponse<Object> approvePoWodata(String poId, String orgName, String orgDiv, String poRef) {
		logger.info("Method : approvePoWodata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_poId='" + poId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_poRef='"
					+ poRef + "';";
			em.createNamedStoredProcedureQuery("salesPurchaseOrder").setParameter("actionType", "approvePoWodata")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Request To Stacking Successfully");
			// resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approvePoWodata Dao ends");
		return resp;

	}

//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addShippingAddressDaoPO(DropDownModel data) {
		logger.info("Method : addShippingAddressDaoPO starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(data);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPurchaseOrder")
					.setParameter("actionType", "addShipAddressPO").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				resp.setBody(x.get(0));
			}
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode("failed");
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		logger.info("Method : addShippingAddressDaoPO ends");
		return resp;
	}
}
