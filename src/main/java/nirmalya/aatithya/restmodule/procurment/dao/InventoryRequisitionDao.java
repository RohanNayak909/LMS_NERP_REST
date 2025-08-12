package nirmalya.aatithya.restmodule.procurment.dao;

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
import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GeneratePurchaseOrderParameter;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateRequisitionParam;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRequisitionModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class InventoryRequisitionDao {

	Logger logger = LoggerFactory.getLogger(InventoryRequisitionDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRequisitionType() {
		logger.info("Method : getRequisitionType starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getRequisitionTypeList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRequisitionType ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRequisitionPriority() {
		logger.info("Method : getRequisitionPriority starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getRequisitionPriority").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRequisitionPriority ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUom() {
		logger.info("Method : getUom starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getUom").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getUom ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryRequisitionModel> getRequisitionItemList() {
		logger.info("Method : getRequisitionItemList starts");
		List<InventoryRequisitionModel> getRequisitionTypeList = new ArrayList<InventoryRequisitionModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getRequisitionItemList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {

				InventoryRequisitionModel dropDownModel = new InventoryRequisitionModel(m[0], m[1], m[2], m[3], m[4],
						null, m[5], m[6], m[7], null, null, m[9], m[10], null);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRequisitionItemList ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<ActivitylogModel> getActivityLog(String id, String orgName, String orgDiv) {
		logger.info("Method : getActivityLog starts");
		List<ActivitylogModel> activitylogModelList = new ArrayList<ActivitylogModel>();
		try {
			String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			// String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			// logger.info("valuesssssssssssssss"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getActivityLog").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				String oa = null;
				if (m[6] != null) {
					oa = m[6].toString();
				}
				ActivitylogModel activitylogModel = new ActivitylogModel(m[0], m[1], m[2], m[3], m[4], m[5], oa);
				activitylogModelList.add(activitylogModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getActivityLog ends");
		return activitylogModelList;
	}

	/**
	 * DAO Function to Add ItemRequisition in inventory
	 *
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public ResponseEntity<JsonResponse<List<InventoryRequisitionModel>>> restAddRequisition(
			List<InventoryRequisitionModel> restItemRequisitonModel) {
		logger.info("Method : restAddRequisition starts");
		boolean validation = true;
		JsonResponse<List<InventoryRequisitionModel>> resp = new JsonResponse<List<InventoryRequisitionModel>>();
		List<InventoryRequisitionModel> listData = new ArrayList<InventoryRequisitionModel>();

		try {
			String values = GenerateRequisitionParam.getItemRequisitionDtlParam(restItemRequisitonModel);
			logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);
			logger.info("IDDDDD#" + restItemRequisitonModel.get(0).getReqId());

			if (restItemRequisitonModel.get(0).getReqId() == null || restItemRequisitonModel.get(0).getReqId() == "") {

				entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
						.setParameter("actionType", "addNewRequisitionItem").setParameter("actionValue", values)
						.execute();

			} else {
				// logger.info("@modifyyyyyyyyyyyyyy" + values);

				entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
						.setParameter("actionType", "modifyItemRequisition").setParameter("actionValue", values)
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
		ResponseEntity<JsonResponse<List<InventoryRequisitionModel>>> response = new ResponseEntity<JsonResponse<List<InventoryRequisitionModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : add item Requisition ends");
		return response;
	}

	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCostCenter() {
		logger.info("Method : getCostCenter starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getCostCenter").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCostCenter ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLocation() {
		logger.info("Method : getLocation starts");
		List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getLocation").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getLocation ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function for auto complete list
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventoryRequisitionModel>>> getProductListByAutoSearch(String id) {
		logger.info("Method : getProductListByAutoSearch starts");
		List<InventoryRequisitionModel> itemNameList = new ArrayList<InventoryRequisitionModel>();
		JsonResponse<List<InventoryRequisitionModel>> resp = new JsonResponse<List<InventoryRequisitionModel>>();
		String value = "SET @p_searchValue='" + id + "';";

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getProductList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				InventoryRequisitionModel dropDownModel = new InventoryRequisitionModel(m[0], m[1], m[2], m[3], null,
						m[5], m[6], null, null, null, null, null, m[4], null);
				itemNameList.add(dropDownModel);
			}

			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventoryRequisitionModel>>> response = new ResponseEntity<JsonResponse<List<InventoryRequisitionModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductListByAutoSearch ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<InventoryRequisitionModel> getRequisitionViewList(String id, String orgName, String orgDiv) {
		logger.info("Method : getRequisitionViewList starts");
		List<InventoryRequisitionModel> getRequisitionTypeList = new ArrayList<InventoryRequisitionModel>();
		try {
			String value = "SET @P_User='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getRequisitionViewList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				String oa = null;
				if (m[4] != null) {
					oa = m[4].toString();
				}
				String createdon = null;
				if (m[7] != null) {
					createdon = m[7].toString();
				}
				String activeDate = null;
				if (m[9] != null) {
					activeDate = m[9].toString();
				}
				String onHoldDate = null;
				if (m[10] != null) {
					onHoldDate = m[10].toString();
				}
				String completeDate = null;
				if (m[11] != null) {
					completeDate = m[11].toString();
				}
				InventoryRequisitionModel dropDownModel = new InventoryRequisitionModel(m[0], m[1], m[2], m[3], oa,
						m[5], m[6], createdon, m[8], activeDate, onHoldDate, completeDate);

				if (dropDownModel.getApproveStatus().contentEquals("1")) {
					dropDownModel.setApproveStatus("Forwarded");
				} else if (dropDownModel.getApproveStatus().contentEquals("0")) {
					dropDownModel.setApproveStatus("Pending");
				} else if (dropDownModel.getApproveStatus().contentEquals("2")) {
					dropDownModel.setApproveStatus("Rejected");
				} else if (dropDownModel.getApproveStatus().contentEquals("3")) {
					dropDownModel.setApproveStatus("Approved");
				}
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRequisitionViewList ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to for Requisition edit
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryRequisitionModel> getRequisitionEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : getRequisitionEdit starts");
		List<InventoryRequisitionModel> getRequisitionTypeList = new ArrayList<InventoryRequisitionModel>();

		try {
			String values = "SET @P_req='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			// String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getRequisitionEdit").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				String oa = null;
				if (m[18] != null) {
					oa = m[18].toString();
				}
				String receiveDate = null;
				if (m[22] != null) {
					receiveDate = m[22].toString();
				}
				String activeDate = null;
				if (m[24] != null) {
					activeDate = m[24].toString();
				}
				String onHoldDate = null;
				if (m[25] != null) {
					onHoldDate = m[25].toString();
				}
				String completeDate = null;
				if (m[26] != null) {
					completeDate = m[26].toString();
				}
				double up = 0;
				if (m[29] != null) {
					up = Double.parseDouble(m[29].toString());
				}
				double lt = 0;
				if (m[30] != null) {
					lt = Double.parseDouble(m[30].toString());
				}

				InventoryRequisitionModel dropDownModel = new InventoryRequisitionModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], oa, m[19],
						m[20], m[21], receiveDate, m[23], activeDate, onHoldDate, completeDate, m[27], null, m[28], up,
						lt);
				getRequisitionTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRequisitionEdit ends");
		return getRequisitionTypeList;
	}

	/**
	 * DAO Function to Add ItemRequisition in inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restDeleteRequisition(
			InventoryRequisitionModel restItemRequisitonModel) {
		logger.info("Method : restDeleteRequisition starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateRequisitionParam.getDeleteParam(restItemRequisitonModel);

			entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "deleteRequisitionItem").setParameter("actionValue", value).execute();

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
		logger.info("Method : restDeleteRequisition ends");
		return response;
	}

	/**
	 * DAO Function to Add ItemRequisition in inventory
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restApproveRequisition(
			InventoryRequisitionModel restItemRequisitonModel) {
		logger.info("Method : restApproveRequisition starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateRequisitionParam.getApproveParam(restItemRequisitonModel);
			entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "approveRequisitionItem").setParameter("actionValue", value).execute();

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
		logger.info("Method : restApproveRequisition ends");
		return response;
	}

	/**
	 * DAO Function to view item by req id and sku id
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<InventoryRequisitionModel>> getProductByReqList(String id, String prodId) {
		logger.info("Method : getProductByReqList starts");
		List<InventoryRequisitionModel> itemNameList = new ArrayList<InventoryRequisitionModel>();
		JsonResponse<InventoryRequisitionModel> resp = new JsonResponse<InventoryRequisitionModel>();
		String value = "SET @p_reqId='" + id + "',@p_skuId='" + prodId + "';";
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getProductByReqList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object oa = null;
				if (m[18] != null) {
					oa = DateFormatter.returnStringDate(m[18]);
				}
				InventoryRequisitionModel dropDownModel = new InventoryRequisitionModel(null, m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], oa, null,
						null, null, null, null, null, null, null, null, null, null, null, null);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<InventoryRequisitionModel>> response = new ResponseEntity<JsonResponse<InventoryRequisitionModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductByReqList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getProductByCat(String catId,String orgName,String orgDiv) {

		logger.info("Method : getProductByCat starts");

		List<InventorySkuProductModel> productList = new ArrayList<InventorySkuProductModel>();
		JsonResponse<List<InventorySkuProductModel>> resp = new JsonResponse<List<InventorySkuProductModel>>();
		try {
			String[] productCatIds = catId.split(",");
			String litem = "";
			for (String a : productCatIds) {
				litem = litem + "\"" + a + "\",";
			}
			litem = litem.substring(0, litem.length() - 1);
			litem = "(" + litem + ")";
			
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_catIds='" + litem + "';";
			//String value = GenerateRequisitionParam.getProduct(catId);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getProductByCatAll").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				InventorySkuProductModel dropDownModel = new InventorySkuProductModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], null, null,null,null,null,m[10]);
				productList.add(dropDownModel);
			}
			resp.setBody(productList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> response = new ResponseEntity<JsonResponse<List<InventorySkuProductModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductByCat ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryDataListModal() {
		logger.info("Method : getProductCategoryDataListModal starts");

		JsonResponse<List<ProductCategoryModel>> resp = new JsonResponse<List<ProductCategoryModel>>();
		List<ProductCategoryModel> yearList = new ArrayList<ProductCategoryModel>();

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getProductCategoryDataList").setParameter("actionValue", "")
					.getResultList();
			for (Object[] m : x) {

				ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				yearList.add(item);
			}
			resp.setBody(yearList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ProductCategoryModel>>> response = new ResponseEntity<JsonResponse<List<ProductCategoryModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getProductCategoryDataListModal ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>> saveOneProductMaster(ProductMasterModel product) {
		logger.info("Method : saveOneProductMaster starts");

		Boolean validity = true;
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		resp.setMessage("");
		resp.setCode("");

		List<DropDownModel> newProduct = new ArrayList<DropDownModel>();

		if (validity)
			try {
				String values = "SET @P_PName='" + product.getProductName() + "', @P_Category='"
						+ product.getProductCategory() + "', @P_CategoryText='" + product.getProductCategoryText()
						+ "', @P_Brand='" + product.getBrand() + "', @P_SKU='" + product.getSkuId() + "', @P_Model='"
						+ product.getModel() + "', @P_Manufacture='" + product.getManufacture()
						+ "', @P_VariationType='" + product.getVariationType() + "', @P_VariationValue='"
						+ product.getVariationValue() + "', @P_UOM='" + product.getUnit() + "', @P_CreatedBy='"
						+ product.getCreatedBy() + "';";

				List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
						.setParameter("actionType", "saveProduct").setParameter("actionValue", values).getResultList();
				for (Object[] m : x) {

					DropDownModel item = new DropDownModel(m[0], m[1]);
					newProduct.add(item);
				}

				resp.setBody(newProduct.get(0));
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

		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveOneProductMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<InventoryRequisitionModel> getRFQdata(String id, String sku, String orgName, String orgDiv) {
		logger.info("Method : getRFQdata starts");
		List<InventoryRequisitionModel> getRequisitionTypeList = new ArrayList<InventoryRequisitionModel>();
		// List<InventoryVendorDocumentModel> docList = new
		// ArrayList<InventoryVendorDocumentModel>();

		try {

			String values = "SET @p_refId='" + id + "',@p_sku='(" + sku + ")',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDiv + "';";
			logger.info(values);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getRFQdata").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {
					String oa = null;
					if (m[18] != null) {
						oa = m[18].toString();
					}
					String receiveDate = null;
					if (m[22] != null) {
						receiveDate = m[22].toString();
					}
					String activeDate = null;
					if (m[24] != null) {
						activeDate = m[24].toString();
					}
					String onHoldDate = null;
					if (m[25] != null) {
						onHoldDate = m[25].toString();
					}
					String completeDate = null;
					if (m[26] != null) {
						completeDate = m[26].toString();
					}
					double up = 0;
					if (m[29] != null) {
						up = Double.parseDouble(m[29].toString());
					}
					double lt = 0;
					if (m[30] != null) {
						lt = Double.parseDouble(m[30].toString());
					}
					InventoryRequisitionModel dropDownModel = new InventoryRequisitionModel(m[0], m[1], m[2], m[3],
							m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
							oa, m[19], m[20], m[21], receiveDate, m[23], activeDate, onHoldDate, completeDate, m[27],
							null, m[28], up, lt);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : getRFQdata ends");
		return getRequisitionTypeList;
	}

	public JsonResponse<Object> adddepartmentDetails(ProductMasterModel productMasterModel) {
		logger.info("Method : adddepartmentDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GeneratePurchaseOrderParameter.getDeptAdd(productMasterModel);
			if (productMasterModel.getBrandId() == null || productMasterModel.getBrandId() == "") {
				System.out.println("ADD" + values);
				entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines").setParameter("actionType", "adddepartmentDetails")
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
		}
		logger.info("ADDDDDDD" + resp);
		logger.info("Method : adddepartmentDetails ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeptList(String id, String orgName, String orgDiv) {

		logger.info("Method : getDeptList starts");
		List<DropDownModel> referenceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getDeptList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				referenceList.add(dropDownModel);
			}
			resp.setBody(referenceList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDeptList ends" + response);
		return response;
	}
}
