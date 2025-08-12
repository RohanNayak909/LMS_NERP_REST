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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCrmVendorDetails;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmVendorModel;

@Repository
public class RestCrmVendorDao {
	
	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	

/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> addVendorCRM(RestCrmVendorModel vendorDetails) {

		logger.info("Method in Dao: restAddLeadDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
			try {
				//String values ="";// 
				String values = GenerateCrmVendorDetails.generateCrmVendorParam(vendorDetails);
				logger.info(values);
				if (vendorDetails.getVendorId() =="" || vendorDetails.getVendorId() ==null) {
			
					em.createNamedStoredProcedureQuery("crmVendors_routines").setParameter("actionType", "addVendorData")
							.setParameter("actionValue", values).execute();
					
				} else {
					em.createNamedStoredProcedureQuery("crmVendors_routines").setParameter("actionType", "modifyVendorData")
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

		logger.info("Method in Dao: restAddLeadDetails ends");

		return response;
	}
	
	
	
	//restViewVendorDetails
	////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmVendorModel>>> restViewVendorDetails() {
		logger.info("Method : restViewVendorDetails starts");
		List<RestCrmVendorModel> respList = new ArrayList<RestCrmVendorModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmVendors_routines").setParameter("actionType", "getVendorDetails")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
				RestCrmVendorModel restPayroll = new RestCrmVendorModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14],m[15],m[16].toString());
				respList.add(restPayroll); 

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCrmVendorModel>> resp = new JsonResponse<List<RestCrmVendorModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmVendorModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmVendorModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : restViewVendorDetails ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
	
	

	///editVendorInfo   
			
			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<RestCrmVendorModel>>>editVendorInfo(String id) {
				logger.info("Method : editVendorInfo starts");

				JsonResponse<List<RestCrmVendorModel>> resp = new JsonResponse<List<RestCrmVendorModel>>();
				List<RestCrmVendorModel> rs = new ArrayList<RestCrmVendorModel>();

				try {

					String value = "SET @p_vendorId='" + id +"';";
					logger.info(value);

					List<Object[]> x = em.createNamedStoredProcedureQuery("crmVendors_routines")
							.setParameter("actionType", "editVendorInfo").setParameter("actionValue", value).getResultList();
					logger.info("asdfasdf"+x);
		           
					for (Object[] m : x) {
						RestCrmVendorModel restPayroll = new RestCrmVendorModel(m[0], m[1], m[2], m[3],
								m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14],m[15],m[16].toString());
					
						rs.add(restPayroll);
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		resp.setBody(rs);
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("MyResponseHeader", "MyValue");

				ResponseEntity<JsonResponse<List<RestCrmVendorModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmVendorModel>>>(resp,responseHeaders,
						HttpStatus.CREATED);

				logger.info("Method : editVendorInfo ends");
				return response;
			}


		//deleteVendorDetails
			
			
			/*
			 * delete
			 */

		public ResponseEntity<JsonResponse<Object>> deleteVendorDetails(String id) {
				logger.info("Method : deleteVendorDetails starts");

				Boolean validity = true;
				JsonResponse<Object> resp = new JsonResponse<Object>();
				resp.setMessage("");
				resp.setCode("");
				logger.info("ID...."+id);
				if (validity)
					try {

						//String result=id.replaceAll("^|$", "'").replaceAll(",", "','"); 
						//String value = "SET  @p_vendorId='(" + result + ")';";
						//String value = "SET  @p_vendorId=('TVM00001','TVM00002');";
						//logger.info(value);
						
						String value = "SET  @p_vendorId='(" + id + ")';";
						
						logger.info("value------------------"+value);
						

						em.createNamedStoredProcedureQuery("crmVendors_routines")
								.setParameter("actionType", "deleteVendor").setParameter("actionValue", value).execute();

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

				logger.info("Method :  deleteVendorDetails ends");
				logger.info("DELETE" + response);
				return response;
			}
			

			//getVendorNameAutoSearch
		
						@SuppressWarnings("unchecked")
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
						}

}
