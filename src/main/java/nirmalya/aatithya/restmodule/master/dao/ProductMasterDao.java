package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
import nirmalya.aatithya.restmodule.common.utils.GenerateProductMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.ProductDetailsModel;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class ProductMasterDao {

	Logger logger = LoggerFactory.getLogger(ProductMasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBrandListForProduct(String org, String orgDiv) {
		logger.info("Method : getBrandListForProduct starts");

		List<DropDownModel> brandList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getBrand").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				brandList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBrandListForProduct ends");
		return brandList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getModeListForProduct(String org, String orgDiv, String type) {
		logger.info("Method : getModeListForProduct starts");

		List<DropDownModel> modeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_type='" + type + "';";
		System.out.println("value>>>>>>>>>" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getMode").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				modeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getModeListForProduct ends");
		System.out.println("---------------------------------------" + modeList);
		return modeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getHSNCodeListForProduct() {
		logger.info("Method : getHSNCodeListForProduct starts");

		List<DropDownModel> hsnCodeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getHSNCode").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				hsnCodeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getHSNCodeListForProduct ends");
		return hsnCodeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVariationTypeListtForProduct() {
		logger.info("Method : getVariationTypeListtForProduct starts");

		List<DropDownModel> hsnCodeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getVariationType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				hsnCodeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVariationTypeListtForProduct ends");
		return hsnCodeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUOMListForProduct() {
		logger.info("Method : getUOMListForProduct starts");

		List<DropDownModel> hsnCodeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getUOM").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				hsnCodeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getUOMListForProduct ends");
		return hsnCodeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllItemList(String org, String orgDiv, String type) {
		logger.info("Method : getAllItemList starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_type='" + type + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getAllItemList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAllItemList ends");
		return itemList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVendorListForProduct() {
		logger.info("Method : getVendorListForProduct starts");

		List<DropDownModel> hsnCodeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getVendor").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				hsnCodeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVendorListForProduct ends");
		return hsnCodeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVendorListForProductWise(String org, String orgDiv, String type) {
		logger.info("Method : getVendorListForProductWise starts");

		List<DropDownModel> hsnCodeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_type='" + type + "';";
		logger.info("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getVendorListForProductWise").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				hsnCodeList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVendorListForProductWise ends");
		return hsnCodeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ProductMasterModel>> saveProductMaster(ProductMasterModel product) {
		logger.info("Method : saveProductMaster starts");

		Boolean validity = true;
		JsonResponse<ProductMasterModel> resp = new JsonResponse<ProductMasterModel>();
		resp.setMessage("");
		resp.setCode("");

		List<ProductMasterModel> newProduct = new ArrayList<ProductMasterModel>();

		if (product.getProductName() == null || product.getProductName() == "") {
			resp.setMessage("Product Name Required");
			validity = false;
		} else if (product.getMode() == null || product.getMode() == "") {
			resp.setMessage("Product Mode Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateProductMasterParameter.saveProduct(product);
				if (product.getProductId() != null && product.getProductId() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
							.setParameter("actionType", "modifyProduct").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ProductMasterModel item = new ProductMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
								m[8], m[9], null, null, null, null, null, null, null, null, null, m[10], m[11], null,
								m[12], m[13]);
						newProduct.add(item);
					}
					resp.setMessage("Product Details Modified Successfully.");
					resp.setCode("success");
				} else {
					List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
							.setParameter("actionType", "addProduct").setParameter("actionValue", values)
							.getResultList();
					logger.info("##################" + x);
					for (Object[] m : x) {
						ProductMasterModel item = new ProductMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
								m[8], m[9], null, null, null, null, null, null, null, null, null, m[10], m[11], null,
								m[12], m[13]);
						newProduct.add(item);
					}
					resp.setMessage("Product information has been saved successfully! Please add the item details.");
					resp.setCode("success");
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

		ResponseEntity<JsonResponse<ProductMasterModel>> response = new ResponseEntity<JsonResponse<ProductMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveProductMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveBomMaster(DropDownModel data) {
		logger.info("Method : saveBomMaster starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(data);
			System.out.println(values);

			em.createNamedStoredProcedureQuery("productMasterRoutines").setParameter("actionType", "addBom")
					.setParameter("actionValue", values).execute();

			resp.setMessage("BOM added successfully");
			resp.setCode("success");

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveBomMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ProductDetailsModel>> saveProductDetails(ProductDetailsModel product) {
		logger.info("Method : saveProductDetails starts");

		Boolean validity = true;
		JsonResponse<ProductDetailsModel> resp = new JsonResponse<ProductDetailsModel>();
		resp.setMessage("");
		resp.setCode("");

		List<ProductDetailsModel> newProduct = new ArrayList<ProductDetailsModel>();
		if (validity)
			try {
				String values = GenerateProductMasterParameter.saveProductDtls(product);
				System.out.println("values>>>>>>" + values);
				if (product.getIsEdit() != null && product.getIsEdit() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
							.setParameter("actionType", "modifyProductDtls").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						ProductDetailsModel item = new ProductDetailsModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
								m[7], m[8], m[9], m[10], null, null, null, null, null, null, m[11], m[12], m[13], m[14],
								m[15], m[16], null, m[17], m[18]);
						newProduct.add(item);
					}
					resp.setMessage("Product Details Modify Successfully.");
					resp.setCode("success");
				} else {
					List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
							.setParameter("actionType", "addProductDtls").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						System.out.println("x===="+Arrays.toString(m));
						ProductDetailsModel item = new ProductDetailsModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
								m[7], m[8], m[9], m[10], null, null, null, null, m[11], m[12], m[13], m[14], m[15],
								m[16], m[17], m[18], null, m[19], m[20]);
						newProduct.add(item);
					}
					resp.setMessage("Product Details Saved Successfully.");
					resp.setCode("success");
				}
				System.out.println("newProduct===="+newProduct);
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

		ResponseEntity<JsonResponse<ProductDetailsModel>> response = new ResponseEntity<JsonResponse<ProductDetailsModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveProductDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ProductDetailsModel>> saveProductPurchaseDetails(ProductDetailsModel product) {
		logger.info("Method : saveProductPurchaseDetails starts");

		Boolean validity = true;
		JsonResponse<ProductDetailsModel> resp = new JsonResponse<ProductDetailsModel>();
		resp.setMessage("");
		resp.setCode("");

		List<ProductDetailsModel> newProduct = new ArrayList<ProductDetailsModel>();
		if (product.getVendorId() == null || product.getVendorId() == "") {
			resp.setMessage("Vendor Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateProductMasterParameter.saveProductPurchaseDtls(product);
				logger.info("VALUES" + values);
				if (product.getIsEdit() != null && product.getIsEdit() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
							.setParameter("actionType", "modifyProductPurchase").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ProductDetailsModel item = new ProductDetailsModel(m[0], m[1], null, null, m[2], m[3], m[4],
								m[5], m[6], m[7], null, null, null, m[8], m[9], null, null, null, null, null, null,
								null, null, null);
						newProduct.add(item);
					}
					resp.setMessage("Assigned Vendor Modified Successfully");
					resp.setCode("success");
				} else {
					List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
							.setParameter("actionType", "addProductPurchase").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						ProductDetailsModel item = new ProductDetailsModel(m[0], m[1], null, null, m[2], m[3], m[4],
								m[5], m[6], m[7], null, null, null, m[8], m[9], null, null, null, null, null, null,
								null, null, null);
						newProduct.add(item);
					}
					resp.setMessage("Vendor Assigned Successfully");
					resp.setCode("success");
				}
				if (newProduct.size() > 0) {
					resp.setBody(newProduct.get(0));
				}

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					if (err[0].equals("1062")) {
						resp.setMessage("Duplicate Vendor Assign!");
					} else {
						resp.setMessage(err[1]);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<ProductDetailsModel>> response = new ResponseEntity<JsonResponse<ProductDetailsModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveProductPurchaseDetails ends");
		logger.info("resssssssssssss" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductMasterModel>>> getProductSKUListing(String type, String orgName,
			String orgDiv, String from) {
		logger.info("Method : getProductSKUListing starts");

		List<ProductMasterModel> locationList = new ArrayList<ProductMasterModel>();
		JsonResponse<List<ProductMasterModel>> resp = new JsonResponse<List<ProductMasterModel>>();
		String value = "SET @P_type='" + type + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_from='"
				+ from + "';";
		System.out.println("Value::::::::::::::::" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "viewProductList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object CREATEDON = null;
				/*
				 * if (m[9] != null) { CREATEDON = DateFormatter.returnStringDate(m[9]); }
				 */
				ProductMasterModel dropDownModel = new ProductMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], CREATEDON, m[10], m[11]);
				locationList.add(dropDownModel);
			}
			resp.setBody(locationList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ProductMasterModel>>> response = new ResponseEntity<JsonResponse<List<ProductMasterModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response>>>>>>>>" + response);
		logger.info("Method : getProductSKUListing ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductDetailsModel>>> getSKUListingById(String id, String orgName,
			String orgDiv) {
		logger.info("Method : getSKUListingById starts");

		List<ProductDetailsModel> locationList = new ArrayList<ProductDetailsModel>();
		JsonResponse<List<ProductDetailsModel>> resp = new JsonResponse<List<ProductDetailsModel>>();

		try {
			String value = "SET @P_ProductId = '" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getSKUListingById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				ProductDetailsModel dropDownModel = new ProductDetailsModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11].toString(), "2", null, null, null, null, m[12], m[13], m[14],
						m[15], m[16], m[17], null, m[18], m[19]);
				locationList.add(dropDownModel);
			}
			resp.setBody(locationList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ProductDetailsModel>>> response = new ResponseEntity<JsonResponse<List<ProductDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSKUListingById ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductDetailsModel>>> getSKUPurchaseListingById(String id, String orgName,
			String orgDiv) {
		logger.info("Method : getSKUPurchaseListingById starts");

		List<ProductDetailsModel> locationList = new ArrayList<ProductDetailsModel>();
		JsonResponse<List<ProductDetailsModel>> resp = new JsonResponse<List<ProductDetailsModel>>();

		try {

			String value = "SET @P_ProductId = '" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("VALUEID" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getSKUPurchaseListingById").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
//				Object createDate = null;
//				
//				if (m[9] != null) {
//					createDate = DateFormatter.returnStringDateMonth(m[9]);
//				}

				ProductDetailsModel dropDownModel = new ProductDetailsModel(m[0], m[1], null, null, m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9].toString(), null, m[10], m[11], null, null, null, null, null, null,
						null, null, null, m[12], m[13]);
				locationList.add(dropDownModel);
			}
			resp.setBody(locationList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ProductDetailsModel>>> response = new ResponseEntity<JsonResponse<List<ProductDetailsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSKUPurchaseListingById ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ProductMasterModel>> getProductDetailsById(String id, String orgName,
			String orgDiv) {
		logger.info("Method : getProductDetailsById starts");

		List<ProductMasterModel> locationList = new ArrayList<ProductMasterModel>();
		JsonResponse<ProductMasterModel> resp = new JsonResponse<ProductMasterModel>();

		String value = "SET @P_ProductId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("$value====" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getProductDetailsById").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				String imgUrl = null;

				if (m[10] != null && m[1] != "" && !m[10].toString().contentEquals("null")
						&& !m[10].toString().equals("")) {
					imgUrl = env.getMobileView() + "document/document/" + m[10].toString();
					logger.info("zzzzzzzzzzz" + imgUrl);

				}
				ProductMasterModel dropDownModel = new ProductMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], imgUrl, m[11], m[12], null);
				locationList.add(dropDownModel);
				resp.setMessage("Data Fetched Successfully");
				resp.setCode("success");
			}
			resp.setBody(locationList.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<ProductMasterModel>> response = new ResponseEntity<JsonResponse<ProductMasterModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductDetailsById ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ProductDetailsModel>> getSKUDetailsById(String id, String skuid) {
		logger.info("Method : getSKUDetailsById starts");

		List<ProductDetailsModel> locationList = new ArrayList<ProductDetailsModel>();
		JsonResponse<ProductDetailsModel> resp = new JsonResponse<ProductDetailsModel>();

		String value = "SET @P_ProductId='" + id + "', @P_SKUID='" + skuid + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getSKUDetailsById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ProductDetailsModel dropDownModel = new ProductDetailsModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], null, "2", null, null, null, null, m[11], m[12], m[13], m[14], m[15],
						m[16], null, m[17], null);
				locationList.add(dropDownModel);
			}
			resp.setBody(locationList.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<ProductDetailsModel>> response = new ResponseEntity<JsonResponse<ProductDetailsModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSKUDetailsById ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ProductDetailsModel>> getSKUPurchaseDetails(String id, String skuid,
			String vendor, String orgName, String orgDiv) {
		logger.info("Method : getSKUPurchaseDetails starts");

		List<ProductDetailsModel> locationList = new ArrayList<ProductDetailsModel>();
		JsonResponse<ProductDetailsModel> resp = new JsonResponse<ProductDetailsModel>();

		String value = "SET @P_ProductId='" + id + "', @P_SKUID='" + skuid + "', @P_Vendor='" + vendor
				+ "', @P_orgName='" + orgName + "', @P_orgDiv='" + orgDiv + "';";

		logger.info("@@@@@@@@@@@@2" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "editSKUPurchaseDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				ProductDetailsModel dropDownModel = new ProductDetailsModel(m[0], m[1], null, null, m[2], m[3], m[4],
						m[5], m[6], m[7], null, null, "2", m[8], m[9], null, null, null, null, null, null, null, null,
						m[10]);
				locationList.add(dropDownModel);
			}
			resp.setBody(locationList.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<ProductDetailsModel>> response = new ResponseEntity<JsonResponse<ProductDetailsModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSKUPurchaseDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>> getVariantDetails(String id, String skuid) {
		logger.info("Method : getVariantDetails starts");

		List<DropDownModel> locationList = new ArrayList<DropDownModel>();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();

		String value = "SET @P_ProductId='" + id + "', @P_SKUID='" + skuid + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getVariantDetails").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				locationList.add(dropDownModel);
			}
			resp.setBody(locationList.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : getVariantDetails ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deletesku(String id, String orgName, String orgDiv) {
		logger.info("Method : deletesku starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_sku='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("productMasterRoutines").setParameter("actionType", "deletesku")
					.setParameter("actionValue", values).execute();
			resp.setMessage("SKU Deleted Successfully");
			resp.setCode("success");
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deletesku ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deletebom(String id, String bomsku, String orgName, String orgDiv) {
		logger.info("Method : deletebom starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = "SET @p_sku='" + id + "', @p_bomsku='" + bomsku + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println(values);
			em.createNamedStoredProcedureQuery("productMasterRoutines").setParameter("actionType", "deletebom")
			.setParameter("actionValue", values).execute();
			resp.setMessage("BOM SKU Deleted Successfully");
			resp.setCode("success");
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			resp.setCode("failed");
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		
		logger.info("Method : deletebom ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteAssignedVendor(String id, String sku, String userId, String org, String orgDiv) {
		logger.info("Method : deleteAssignedVendor starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_vendor='" + id + "',@p_sku='" + sku + "',@p_userId='" + userId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv
					+ "';";
			logger.info("valuesssssss" + values);
			em.createNamedStoredProcedureQuery("productMasterRoutines").setParameter("actionType", "deletepurchase")
					.setParameter("actionValue", values).execute();
			resp.setMessage("Assigned Vendor Deleted Successfully");
			resp.setCode("success");
		} catch

		(Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteAssignedVendor ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteProductMaster(String id, String createdBy, String orgName,
			String orgDiv) {
		logger.info("Method : deleteProductMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @P_ModifiedBy='" + createdBy + "', @P_ProductId='" + id + "',@p_org='" + orgName
						+ "',@p_orgDiv='" + orgDiv + "';";
				em.createNamedStoredProcedureQuery("productMasterRoutines").setParameter("actionType", "deleteProduct")
						.setParameter("actionValue", value).execute();
				resp.setMessage("Product Deleted Successfully");
				resp.setCode("success");

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

		logger.info("Method : deleteProductMaster ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> parentCategoryList(String org, String orgDiv) {
		logger.info("Method : parentCategoryList starts");

		List<DropDownModel> stateList = new ArrayList<>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("Query parameters: " + value);

		try {
			// Call stored procedure
			List<Object[]> resultList = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getParentCategory").setParameter("actionValue", value).getResultList();

			// Map results to DropDownModel
			for (Object[] result : resultList) {
				DropDownModel dropDownModel = new DropDownModel(result[0].toString(), result[1].toString());
				stateList.add(dropDownModel);
			}

			// Populate JsonResponse
			resp.setBody(stateList);
			resp.setMessage("success");
			resp.setCode(null);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Failed to fetch parent categories");
			resp.setCode("500");
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<>(resp, HttpStatus.OK);

		logger.info("Method : parentCategoryList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> subcategory(String org, String orgDiv, String id) {
		logger.info("Method : subcategory starts");

		List<DropDownModel> stateList = new ArrayList<>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_id='" + id + "';";
		logger.info("Query parameters: " + value);

		try {
			List<Object[]> resultList = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getSubcategory").setParameter("actionValue", value).getResultList();

			for (Object[] result : resultList) {
				DropDownModel dropDownModel = new DropDownModel(result[0].toString(), result[1].toString());
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);
			resp.setMessage("success");
			resp.setCode(null);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Failed to fetch parent categories");
			resp.setCode("500");
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<>(resp, HttpStatus.OK);

		logger.info("Method : subcategory ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getProduct(String org, String orgDiv, String id) {
		logger.info("Method : getProduct starts");

		List<DropDownModel> stateList = new ArrayList<>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_id='" + id + "';";
		logger.info("Query parameters: " + value);

		try {
			List<Object[]> resultList = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getProductDD").setParameter("actionValue", value).getResultList();

			for (Object[] result : resultList) {
				DropDownModel dropDownModel = new DropDownModel(result[0].toString(), result[1].toString());
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);
			resp.setMessage("success");
			resp.setCode(null);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Failed to fetch parent categories");
			resp.setCode("500");
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<>(resp, HttpStatus.OK);

		logger.info("Method : getProduct ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIntailBrandList(String org, String orgDiv) {
		logger.info("Method : getIntailBrandList starts");

		List<DropDownModel> stateList = new ArrayList<>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("Query parameters: " + value);

		try {
			// Call stored procedure
			List<Object[]> resultList = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getBrand").setParameter("actionValue", value).getResultList();

			// Map results to DropDownModel
			for (Object[] result : resultList) {
				DropDownModel dropDownModel = new DropDownModel(result[0].toString(), result[1].toString());
				stateList.add(dropDownModel);
			}

			// Populate JsonResponse
			resp.setBody(stateList);
			resp.setMessage("success");
			resp.setCode(null);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Failed to fetch parent categories");
			resp.setCode("500");
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<>(resp, HttpStatus.OK);

		logger.info("Method : getIntailBrandList ends");
		return response;
	}

	/** For New Version Product Category & Sub-Category **/

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProductCategoryList(String org, String orgDiv) {
		logger.info("Method : getProductCategoryList starts");

		List<DropDownModel> modeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getProductCategory").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				modeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getProductCategoryList ends");
		return modeList;
	}

	// getVariationList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVariationList(String org, String orgDiv, String id) {
		logger.info("Method : getVariationList starts");
		List<DropDownModel> varlist = new ArrayList<>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_id='" + id + "';";
		logger.info("Query parameters: " + value);

		try {
			// Call stored procedure
			List<Object[]> resultList = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getVariationList").setParameter("actionValue", value).getResultList();

			// Map results to DropDownModel
			for (Object[] result : resultList) {
				DropDownModel dropDownModel = new DropDownModel(result[0].toString(), result[1].toString());
				varlist.add(dropDownModel);
			}

			// Populate JsonResponse
			resp.setBody(varlist);
			resp.setMessage("success");
			resp.setCode(null);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Failed to fetch parent categories");
			resp.setCode("500");
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<>(resp, HttpStatus.OK);

		logger.info("Method : getVariationList ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemList(String org, String orgDiv, String id) {
		logger.info("Method : getItemList starts");

		List<DropDownModel> itemList = new ArrayList<>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_id='" + id + "';";
		logger.info("Query parameters: " + value);

		try {
			List<Object[]> resultList = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getItemList").setParameter("actionValue", value).getResultList();

			for (Object[] m : resultList) {
				DropDownModel dropDownModel = new DropDownModel(m[0] != null ? m[0].toString() : null,
						m[1] != null ? m[1].toString() : null, m[2] != null ? m[2].toString() : null);
				itemList.add(dropDownModel);
			}

			if (itemList.size() > 0) {
				resp.setBody(itemList);
				resp.setMessage("Data fetched successfully");
				resp.setCode("success");
			} else {
				resp.setBody(null);
				resp.setMessage("Data not found");
				resp.setCode("failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Failed to fetch data");
			resp.setCode("failed");
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<>(resp, HttpStatus.OK);

		logger.info("Method : getItemList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getItemdDtailsBySku(String id, String org, String orgDiv) {
		logger.info("Method : getItemdDtailsBySku Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_sku='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getItemdDtailsBySku").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : getItemdDtailsBySku Dao ends");
		return resp;
	}

}
