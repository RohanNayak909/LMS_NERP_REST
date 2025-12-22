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
import nirmalya.aatithya.restmodule.common.utils.GenerateCrmCustomerDetails;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCustomerModel;

@Repository
public class RestCrmCustomerDao {
	
	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	

/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> addCustomer(RestCrmCustomerModel restCrmCustomerModel) {

		logger.info("Method in Dao: addCustomer starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		//resp.setMessage("");
		//resp.setCode("");
			try {
				//String values ="";// 
				String values = GenerateCrmCustomerDetails.generateCrmCustomerParam(restCrmCustomerModel);
				logger.info(values);
				if (restCrmCustomerModel.getCustomerId() =="" || restCrmCustomerModel.getCustomerId() ==null) {
			
					em.createNamedStoredProcedureQuery("crmCustomer_routines").setParameter("actionType", "addCustomer")
							.setParameter("actionValue", values).execute();
					
				} else {
					em.createNamedStoredProcedureQuery("crmCustomer_routines").setParameter("actionType", "modifyCustomer")
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
		if (resp.getMessage() == null) {
			resp.setMessage("Saved successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: addCustomer ends");

		return response;
	}
	
	
	
	//restViewVendorDetails
	////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmCustomerModel>>> restViewCustDetails() {
		logger.info("Method : restViewCustDetails starts");
		List<RestCrmCustomerModel> respList = new ArrayList<RestCrmCustomerModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmCustomer_routines").setParameter("actionType", "getCustomerDetails")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
				String dob1 = null;
				String dob2 = null;
				String dob3 = null;
				
				String marrigeDate1 = null;
				String marrigeDate2 = null;
				String marrigeDate3 = null;
				
				
				if (m[18] != null) {
					dob1 = m[11].toString();
				}
				
				if (m[19] != null) {
					marrigeDate1 = m[11].toString();
				}
				
				if (m[24] != null) {
					dob2 = m[11].toString();
				}
				
				if (m[25] != null) {
					marrigeDate2 = m[11].toString();
				}
				
				
				if (m[30] != null) {
					dob3 = m[11].toString();
				}
				
				if (m[31] != null) {
					marrigeDate3 = m[11].toString();
				}
			
				
				RestCrmCustomerModel restPayroll = new RestCrmCustomerModel(m[0], m[1], m[2], m[3],	m[4], m[5], m[6], m[7], 
						m[8], m[9], m[10], m[11], m[12], m[13], m[14],m[15],m[16],m[17],dob1, marrigeDate1,
						m[20], m[21], m[22], m[23], dob2, marrigeDate2,
						m[26],m[27],m[28], m[29], dob3, marrigeDate3, m[32], m[33], m[34],m[35],m[36],m[37],
						m[38], m[39].toString(), m[40]);
				respList.add(restPayroll); 

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCrmCustomerModel>> resp = new JsonResponse<List<RestCrmCustomerModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmCustomerModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCustomerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : restViewCustDetails ends");
		
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
	
	

	///editCustomerInfo   
			
			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<RestCrmCustomerModel>>>editCustomerInfo(String id) {
				logger.info("Method : editCustomerInfo starts");

				JsonResponse<List<RestCrmCustomerModel>> resp = new JsonResponse<List<RestCrmCustomerModel>>();
				List<RestCrmCustomerModel> rs = new ArrayList<RestCrmCustomerModel>();

				try {

					String value = "SET @p_custId='" + id +"';";
					logger.info(value);

					List<Object[]> x = em.createNamedStoredProcedureQuery("crmCustomer_routines")
							.setParameter("actionType", "editCustomerInfo").setParameter("actionValue", value).getResultList();
					logger.info("asdfasdf"+x);
		           
					for (Object[] m : x) {
						String dob1 = null;
						String dob2 = null;
						String dob3 = null;
						
						String marrigeDate1 = null;
						String marrigeDate2 = null;
						String marrigeDate3 = null;
						
						
						if (m[18] != null) {
							dob1 = m[18].toString();
						}
						
						if (m[19] != null) {
							marrigeDate1 = m[19].toString();
						}
						
						if (m[24] != null) {
							dob2 = m[24].toString();
						}
						
						if (m[25] != null) {
							marrigeDate2 = m[25].toString();
						}
						
						
						if (m[30] != null) {
							dob3 = m[30].toString();
						}
						
						if (m[31] != null) {
							marrigeDate3 = m[31].toString();
						}
					
						
						RestCrmCustomerModel restPayroll = new RestCrmCustomerModel(m[0], m[1], m[2], m[3],	m[4], m[5], m[6], m[7], 
								m[8], m[9], m[10], m[11], m[12], m[13], m[14],m[15],m[16],m[17],dob1, marrigeDate1,
								m[20], m[21], m[22], m[23], dob2, marrigeDate2,
								m[26],m[27],m[28], m[29], dob3, marrigeDate3, m[32], m[33], m[34],m[35],m[36],m[37],
								m[38], m[39].toString(), m[40]);
						rs.add(restPayroll);
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		resp.setBody(rs);
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("MyResponseHeader", "MyValue");

				ResponseEntity<JsonResponse<List<RestCrmCustomerModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCustomerModel>>>(resp,responseHeaders,
						HttpStatus.CREATED);

				logger.info("Method : editCustomerInfo ends");
				
				if (resp.getMessage() == null) {
					resp.setMessage("View successfully");
				}
				
				if (resp.getCode() == null) {
					resp.setCode("Success");
				}
				
				return response;
			}


		//deleteCrmCustomersDetails
			
			
			/*
			 * delete
			 */

		public ResponseEntity<JsonResponse<Object>> deleteCrmCustomersDetails(String id) {
				logger.info("Method : deleteCrmCustomersDetails starts");

				Boolean validity = true;
				JsonResponse<Object> resp = new JsonResponse<Object>();
				//resp.setMessage("");
				//resp.setCode("");
				logger.info("ID...."+id);
				if (validity)
					try {

						//String result=id.replaceAll("^|$", "'").replaceAll(",", "','"); 
						//String value = "SET  @p_vendorId='(" + result + ")';";
						//String value = "SET  @p_vendorId=('TVM00001','TVM00002');";
						//logger.info(value);
						
						String value = "SET  @p_custId='(" + id + ")';";
						
						logger.info("value------------------"+value);
						

						em.createNamedStoredProcedureQuery("crmCustomer_routines")
								.setParameter("actionType", "deleteCustomer").setParameter("actionValue", value).execute();

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
				
				if (resp.getMessage() == null) {
					resp.setMessage("Deleted successfully");
				}
				
				if (resp.getCode() == null) {
					resp.setCode("Success");
				}

				logger.info("Method :  deleteCrmCustomersDetails ends");
				logger.info("DELETE" + response);
				return response;
			}
			

			//getVendorNameAutoSearch
		
			/*			@SuppressWarnings("unchecked")
						public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorNameAutoSearch(String id) {
							logger.info("Method : getVendorNameAutoSearch starts");
							List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
							JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
							String value = "SET @p_searchValue='" + id + "';";

							try {
								logger.info("VALUE"+value);
								List<Object[]> x = em.createNamedStoredProcedureQuery("crmVendors_routines")
										.setParameter("actionType", "getVendorNameAutoSearch").setParameter("actionValue", value)
										.getResultList();
								for (Object[] m : x) {
									DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
									itemNameList.add(dropDownModel);
								}
								resp.setBody(itemNameList);
							} catch (Exception e) {
								e.printStackTrace();
							}
							ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
									resp, HttpStatus.CREATED);
							logger.info("Method : getVendorNameAutoSearch ends");
							logger.info("AUTODATAAA" + response);
							return response;
						}*/

}
