package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateProductReferenceParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 
import nirmalya.aatithya.restmodule.master.model.RestReferenceProductModel;

@Repository
public class RestReferenceProductDao {

	Logger logger = LoggerFactory.getLogger(RestReferenceProductDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to Add brand type
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addBrandType(RestReferenceProductModel restProcurementMasterModel) {
		logger.info("Method : Rest Add Brand Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateProductReferenceParameter.addBrandTypeParam(restProcurementMasterModel);

				if (restProcurementMasterModel.getBrandId() != null && restProcurementMasterModel.getBrandId() != "") {
					em.createNamedStoredProcedureQuery("BrandTypeReference")
							.setParameter("actionType", "modifyBrandType").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("BrandTypeReference").setParameter("actionType", "addBrandType")
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
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest Add Brand Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> viewBrandType(String org,String orgDiv) {
		logger.info("Method : viewBrandType starts");

		List<RestReferenceProductModel> brandList = new ArrayList<RestReferenceProductModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("BrandTypeReference")
					.setParameter("actionType", "viewBrandType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[4] != null && m[4].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestReferenceProductModel dropDownModel = new RestReferenceProductModel(m[0], m[1], m[2], m[3], null,
						status, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				brandList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestReferenceProductModel>> resp = new JsonResponse<List<RestReferenceProductModel>>();
		resp.setBody(brandList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> response = new ResponseEntity<JsonResponse<List<RestReferenceProductModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewBrandType ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deletebrandType(String id, String org,String orgDiv) {

		logger.info("Method : deletebrandType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_brandId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv  + "';";

			em.createNamedStoredProcedureQuery("BrandTypeReference").setParameter("actionType", "deleteBrand")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deletebrandType Dao starts");
		return response;
	}
	
	
	/**
	 *  insurance type
	 *
	 */
	
	public ResponseEntity<JsonResponse<Object>> addInsuranceType(RestReferenceProductModel restProcurementMasterModel) {
		logger.info("Method : Rest addInsuranceType Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateProductReferenceParameter.addInsuranceTypeParam(restProcurementMasterModel);
//				System.out.println("Print Data::::::::"+values);
				if (restProcurementMasterModel.getInsuranceId() != null && restProcurementMasterModel.getInsuranceId() != "") {
					em.createNamedStoredProcedureQuery("InsuranceTypeReference")
							.setParameter("actionType", "modifyInsuranceType").setParameter("actionValue", values)
							.execute();
				} else {
					
					em.createNamedStoredProcedureQuery("InsuranceTypeReference").setParameter("actionType", "addInsuranceType")
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
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest addInsuranceType Dao ends");

		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> viewInsuranceType(String org, String orgDiv) {
		logger.info("Method :DAO viewInsuranceType starts");

		List<RestReferenceProductModel> insuranceList = new ArrayList<RestReferenceProductModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("InsuranceTypeReference")
					.setParameter("actionType", "viewInsuranceType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestReferenceProductModel dropDownModel = new RestReferenceProductModel( null, null, null, null, null, null, null, null, null, 
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2], status, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				insuranceList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestReferenceProductModel>> resp = new JsonResponse<List<RestReferenceProductModel>>();
		resp.setBody(insuranceList);
		

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> response = new ResponseEntity<JsonResponse<List<RestReferenceProductModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method :DAO viewInsuranceType ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteInsuranceType(String id, String org, String orgDiv) {

		logger.info("Method : deleteInsuranceType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_insuranceId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv  + "';";

			em.createNamedStoredProcedureQuery("InsuranceTypeReference").setParameter("actionType", "deleteInsuranceType")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteInsuranceType Dao starts");
		return response;
	}
	
	/**
	 *  insurance provider type
	 *
	 */
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getinsuranceList(String org, String orgDiv) {

		logger.info("Method : getinsuranceList starts");

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> model = new ArrayList<DropDownModel>();

		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("InsuranceProviderTypeReference")
					.setParameter("actionType", "getinsuranceList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel item = new DropDownModel(m[0], m[1]);
				model.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(model);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response===" + response);
		logger.info("Method : getinsuranceList ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> addInsuranceProvdrType(RestReferenceProductModel restProcurementMasterModel) {
		logger.info("Method : Rest addInsuranceProvdrType Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateProductReferenceParameter.addInsuranceProvdrTypeParam(restProcurementMasterModel);
				System.out.println("Print Data::::::::"+values);
				if (restProcurementMasterModel.getInsurancePrvdrId() != null && restProcurementMasterModel.getInsurancePrvdrId() != "") {
					em.createNamedStoredProcedureQuery("InsuranceProviderTypeReference")
							.setParameter("actionType", "modifyInsuranceProvdrType").setParameter("actionValue", values)
							.execute();
				} else {
					
					em.createNamedStoredProcedureQuery("InsuranceProviderTypeReference").setParameter("actionType", "addInsuranceProvdrType")
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
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest addInsuranceProvdrType Dao ends");

		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> viewInsuranceProviderType(String org, String orgDiv) {
		logger.info("Method :DAO viewInsuranceProviderType starts");

		List<RestReferenceProductModel> insuranceProviderList = new ArrayList<RestReferenceProductModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("InsuranceProviderTypeReference")
					.setParameter("actionType", "viewInsuranceProviderType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				/*
				 * Object status = ""; if (m[3].equals("1")) { status = "Active"; } else {
				 * status = "Inactive"; }
				 */
				RestReferenceProductModel dropDownModel = new RestReferenceProductModel(null, null, null, null, null, null, null, null, null, 
						null, null, null, null, null ,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2], m[3], m[4], m[5], m[6], null, null, null, null, null, null, null, null, null, null);
				insuranceProviderList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestReferenceProductModel>> resp = new JsonResponse<List<RestReferenceProductModel>>();
		resp.setBody(insuranceProviderList);
		

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> response = new ResponseEntity<JsonResponse<List<RestReferenceProductModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method :DAO viewInsuranceProviderType ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteInsuranceProviderType(String id, String org, String orgDiv) {

		logger.info("Method : deleteInsuranceProviderType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_insurancePrvdrId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv  + "';";

			em.createNamedStoredProcedureQuery("InsuranceProviderTypeReference").setParameter("actionType", "deleteInsuranceProviderType")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteInsuranceProviderType Dao starts");
		return response;
	}
	
	
	/**
	 *  mode of transport type
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addTransportType(RestReferenceProductModel restProcurementMasterModel) {
		logger.info("Method : Rest addTransportType Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateProductReferenceParameter.addTransportTypeParam(restProcurementMasterModel);
//				System.out.println("Print Data::::::::"+values);
				if (restProcurementMasterModel.getTransportId() != null && restProcurementMasterModel.getTransportId() != "") {
					em.createNamedStoredProcedureQuery("TransportTypeReference")
							.setParameter("actionType", "modifyTransportType").setParameter("actionValue", values)
							.execute();
				} else {
					
					em.createNamedStoredProcedureQuery("TransportTypeReference").setParameter("actionType", "addTransportType")
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
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest addTransportType Dao ends");

		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> viewtransportType(String org, String orgDiv) {
		logger.info("Method :DAO viewtransportType starts");

		List<RestReferenceProductModel> transportList = new ArrayList<RestReferenceProductModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("TransportTypeReference")
					.setParameter("actionType", "viewtransportType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				/*
				 * Object status = ""; if (m[3].equals("1")) { status = "Active"; } else {
				 * status = "Inactive"; }
				 */
				RestReferenceProductModel dropDownModel = new RestReferenceProductModel( null, null, null, null, null, null, null, null, null, 
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2], null, null, null, null);
				transportList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestReferenceProductModel>> resp = new JsonResponse<List<RestReferenceProductModel>>();
		resp.setBody(transportList);
		

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> response = new ResponseEntity<JsonResponse<List<RestReferenceProductModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method :DAO viewtransportType ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteTransportType(String id, String org, String orgDiv) {

		logger.info("Method : deleteTransportType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_transportId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv  + "';";

			em.createNamedStoredProcedureQuery("TransportTypeReference").setParameter("actionType", "deleteTransportType")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteTransportType Dao starts");
		return response;
	}
	
	/**
	 *  product type
	 *
	 */
	
	
	
	public ResponseEntity<JsonResponse<Object>> addProductType(RestReferenceProductModel restProcurementMasterModel) {
		logger.info("Method : Rest addProductType Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateProductReferenceParameter.addProductTypeParam(restProcurementMasterModel);

				if (restProcurementMasterModel.getProductId() != null && restProcurementMasterModel.getProductId() != "") {
					em.createNamedStoredProcedureQuery("ProductTypeReference")
							.setParameter("actionType", "modifyProductType").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("ProductTypeReference").setParameter("actionType", "addProductType")
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
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest addProductType Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> viewProductType(String org, String orgDiv) {
		logger.info("Method :DAO viewProductType starts");

		List<RestReferenceProductModel> productList = new ArrayList<RestReferenceProductModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ProductTypeReference")
					.setParameter("actionType", "viewProductType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestReferenceProductModel dropDownModel = new RestReferenceProductModel( null, null, null, null, null, null, null, null, null, 
						null, m[0], m[1], m[2], status ,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				productList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestReferenceProductModel>> resp = new JsonResponse<List<RestReferenceProductModel>>();
		resp.setBody(productList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> response = new ResponseEntity<JsonResponse<List<RestReferenceProductModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method :DAO viewProductType ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteProductType(String id, String org, String orgDiv) {

		logger.info("Method : deleteProductType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_productId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv  + "';";

			em.createNamedStoredProcedureQuery("ProductTypeReference").setParameter("actionType", "deleteProductType")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteProductType Dao starts");
		return response;
	}
	
	/**
	 *   variation  type
	 *
	 */
	
	
	
	public ResponseEntity<JsonResponse<Object>> addVariationType(RestReferenceProductModel restProcurementMasterModel) {
		logger.info("Method : Rest addVariationType Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateProductReferenceParameter.addVariationTypeParam(restProcurementMasterModel);

				if (restProcurementMasterModel.getVariationId() != null && restProcurementMasterModel.getVariationId() != "") {
					em.createNamedStoredProcedureQuery("VariationTypeReference")
							.setParameter("actionType", "modifyVariationType").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("VariationTypeReference").setParameter("actionType", "addVariationType")
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
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest addVariationType Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> viewVariationType(String org, String orgDiv) {
		logger.info("Method :DAO viewVariationType starts");

		List<RestReferenceProductModel> varList = new ArrayList<RestReferenceProductModel>();
		
		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("VariationTypeReference")
					.setParameter("actionType", "viewVariationType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestReferenceProductModel dropDownModel = new RestReferenceProductModel( null, null, null, null, null, null, null, null, null, 
						null,null, null, null, null, null, null, null, null, m[0], m[1], m[2], status,  null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				varList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestReferenceProductModel>> resp = new JsonResponse<List<RestReferenceProductModel>>();
		resp.setBody(varList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestReferenceProductModel>>> response = new ResponseEntity<JsonResponse<List<RestReferenceProductModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method :DAO viewVariationType ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteVariationType(String id, String org, String orgDiv) {

		logger.info("Method : deleteVariationType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_variationId='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv  + "';";

			em.createNamedStoredProcedureQuery("VariationTypeReference").setParameter("actionType", "deleteVariationType")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteVariationType Dao starts");
		return response;
	}


	/**
	 * for add payment status master data 
	 * @param reqtypeList
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addBrandTypeCsv(List<RestReferenceProductModel> reqtypeList) {
		logger.info("Method : addBrandTypeCsv Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		for (RestReferenceProductModel a : reqtypeList) {
			try {
				String selectPatam = "SET @p_Name='" + a.getBrandName()+ "';";
				@SuppressWarnings("unchecked")
				List<String> resultList = em.createNamedStoredProcedureQuery("BrandTypeReference")
						.setParameter("actionType", "isBrandTypeRecordExsit").setParameter("actionValue", selectPatam)
						.getResultList();
				if (resultList != null && !resultList.isEmpty()) {
					a.setBrandId(resultList.get(0));
					String values = GenerateProductReferenceParameter.addBrandTypeParam(a);
							em.createNamedStoredProcedureQuery("BrandTypeReference")
							.setParameter("actionType", "modifyBrandType").setParameter("actionValue", values)
							.execute();
				} else {
					String values = GenerateProductReferenceParameter.addBrandTypeParam(a);
					em.createNamedStoredProcedureQuery("BrandTypeReference")
							.setParameter("actionType", "addBrandType").setParameter("actionValue", values)
							.execute();
				}

			} catch (Exception e) {
				logger.error(e.getMessage());
				resp.setMessage(e.getMessage());
			}
		} 
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :addBrandTypeCsv Dao ends");
		return response;
	}
	
	/**
	 * for add payment status master data 
	 * @param reqtypeList
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addProductTypeCsv(List<RestReferenceProductModel> reqtypeList) {
		logger.info("Method : addProductTypeCsv Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		for (RestReferenceProductModel a : reqtypeList) {
			try {
				String selectPatam = "SET @p_Name='" + a.getProductName() + "';";
				@SuppressWarnings("unchecked")
				List<String> resultList = em.createNamedStoredProcedureQuery("ProductTypeReference")
						.setParameter("actionType", "isProductTypeRecordExsit").setParameter("actionValue", selectPatam)
						.getResultList();
				if (resultList != null && !resultList.isEmpty()) {
					a.setProductId(resultList.get(0));
					String values = GenerateProductReferenceParameter.addProductTypeParam(a);
							em.createNamedStoredProcedureQuery("ProductTypeReference")
							.setParameter("actionType", "modifyProductType").setParameter("actionValue", values)
							.execute();
				} else {
					String values = GenerateProductReferenceParameter.addProductTypeParam(a);
					em.createNamedStoredProcedureQuery("ProductTypeReference")
							.setParameter("actionType", "addProductType").setParameter("actionValue", values)
							.execute();
				}

			} catch (Exception e) {
				logger.error(e.getMessage());
				resp.setMessage(e.getMessage());
			}
		} 
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :addBrandTypeCsv Dao ends");
		return response;
	}
	
	/**
	 * for add payment status master data 
	 * @param reqtypeList
	 * @return
	 */
	public ResponseEntity<JsonResponse<Object>> addVariationTypeCsv(List<RestReferenceProductModel> reqtypeList) {
		logger.info("Method : addVariationTypeCsv Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		for (RestReferenceProductModel a : reqtypeList) {
			try {
				String selectPatam = "SET @p_Name='" + a.getVariationName() + "';";
				@SuppressWarnings("unchecked")
				List<String> resultList = em.createNamedStoredProcedureQuery("VariationTypeReference")
						.setParameter("actionType", "isVariationTypeRecordExsit").setParameter("actionValue", selectPatam)
						.getResultList();
				if (resultList != null && !resultList.isEmpty()) {
					a.setVariationId(resultList.get(0));
					String values = GenerateProductReferenceParameter.addVariationTypeParam(a);
							em.createNamedStoredProcedureQuery("VariationTypeReference")
							.setParameter("actionType", "modifyVariationType").setParameter("actionValue", values)
							.execute();
				} else {
					String values = GenerateProductReferenceParameter.addVariationTypeParam(a);
					em.createNamedStoredProcedureQuery("VariationTypeReference")
							.setParameter("actionType", "addVariationType").setParameter("actionValue", values)
							.execute();
				}

			} catch (Exception e) {
				logger.error(e.getMessage());
				resp.setMessage(e.getMessage());
			}
		} 
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :addVariationTypeCsv Dao ends");
		return response;
	}
	
}
