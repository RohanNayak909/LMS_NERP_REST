package nirmalya.aatithya.restmodule.pipeline.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateCrmProductDetails;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmProductModel;

@Repository
public class RestCrmProductDao {
	
	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	

	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> addProductCRM(RestCrmProductModel productDetails) {

		logger.info("Method in Dao: addProductCRM starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
			try {
				//String values ="";// 
				String values = GenerateCrmProductDetails.generateCrmProductParam(productDetails);
				logger.info(values);
				if (productDetails.getProductId() =="" || productDetails.getProductId() ==null) {
			
					em.createNamedStoredProcedureQuery("crmProduct_routines").setParameter("actionType", "addProductData")
							.setParameter("actionValue", values).execute();
					
				} else {
					em.createNamedStoredProcedureQuery("crmProduct_routines").setParameter("actionType", "modifyProductData")
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addProductCRM ends");

		return response;
	}
	
	
	
	//restViewCrmProducts
	////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmProductModel>>> restViewCrmProducts() {
		logger.info("Method : restViewCrmProducts starts");
		List<RestCrmProductModel> respList = new ArrayList<RestCrmProductModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmProduct_routines").setParameter("actionType", "getProductDetails")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
				RestCrmProductModel restPayroll = new RestCrmProductModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), 
						m[13].toString(), m[14].toString(),m[15],m[16], m[17],m[18],m[19], m[20],m[21],m[22], m[23],m[24].toString());
				respList.add(restPayroll); 

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCrmProductModel>> resp = new JsonResponse<List<RestCrmProductModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmProductModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmProductModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : restViewCrmProducts ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
	
	

	///editProductInfo   
			
			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<RestCrmProductModel>>>editProductInfo(String id) {
				logger.info("Method : editProductInfo starts");

				JsonResponse<List<RestCrmProductModel>> resp = new JsonResponse<List<RestCrmProductModel>>();
				List<RestCrmProductModel> rs = new ArrayList<RestCrmProductModel>();

				try {

					String value = "SET @p_productId='" + id +"';";
					logger.info(value);

					List<Object[]> x = em.createNamedStoredProcedureQuery("crmProduct_routines")
							.setParameter("actionType", "editProductInfo").setParameter("actionValue", value).getResultList();
					logger.info("asdfasdf"+x);
		           
					for (Object[] m : x) {
						RestCrmProductModel restPayroll = new RestCrmProductModel(m[0], m[1], m[2], m[3],
								m[4], m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(), m[12].toString(), 
								m[13].toString(), m[14].toString(),m[15],m[16], m[17],m[18],m[19], m[20],m[21],m[22], m[23],m[24].toString());
						rs.add(restPayroll);
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		resp.setBody(rs);
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("MyResponseHeader", "MyValue");

				ResponseEntity<JsonResponse<List<RestCrmProductModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmProductModel>>>(resp,responseHeaders,
						HttpStatus.CREATED);
				
				logger.info("response in edit product-------------"+response);

				logger.info("Method : editProductInfo ends");
				return response;
			}


		//deleteVendorDetails
			
			
			/*
			 * delete
			 */

		public ResponseEntity<JsonResponse<Object>> deleteProductDetails(String id) {
				logger.info("Method : deleteProductDetails starts");

				Boolean validity = true;
				JsonResponse<Object> resp = new JsonResponse<Object>();
				resp.setMessage("");
				resp.setCode("");
				logger.info("ID...."+id);
				if (validity)
					try {

						//String result=id.replaceAll("^|$", "'").replaceAll(",", "','"); 
						
						String value = "SET  @p_productId='(" + id + ")';";
						
						logger.info("value------------------"+value);
						

						em.createNamedStoredProcedureQuery("crmProduct_routines")
								.setParameter("actionType", "deleteProduct").setParameter("actionValue", value).execute();

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

				logger.info("Method :  deleteProductDetails ends");
				logger.info("DELETE" + response);
				return response;
			}
			



}
