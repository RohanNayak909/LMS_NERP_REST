package nirmalya.aatithya.restmodule.canteen.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.canteen.model.RestAssignComboModel;
import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCanteenAssignParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateCanteenMenuParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.model.HISBedMasterRestModel;
@Repository
public class AssignDao {
	
	Logger logger = LoggerFactory.getLogger(AssignDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getincentive() {
		logger.info("Method : getincentive starts");

		List<DropDownModel> getincentive = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-assign")
					.setParameter("actionType", "incentivestats").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getincentive.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPaymentModeList ends");

		System.out.println("getincentive=======>" + getincentive);
		return getincentive;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getClubMembers() {
		logger.info("Method : getClubMembers starts");

		List<DropDownModel> getClubList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-assign")
					.setParameter("actionType", "clubMemberList")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getClubList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getClubMembers ends");

		System.out.println("getClubMembers=======>" + getClubList);
		return getClubList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getvariants() {
		logger.info("Method : getvariants starts");

		List<DropDownModel> getClubList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-assign")
					.setParameter("actionType", "variants")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getClubList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getvariants ends");

		System.out.println("getvariants=======>" + getClubList);
		return getClubList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getcombo() {
		logger.info("Method : getcombo starts");

		List<DropDownModel> getcombo = new ArrayList<DropDownModel>();	

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-assign")
					.setParameter("actionType", "combodrop")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getcombo.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();	
		}

		logger.info("Method : getcombo ends");

		System.out.println("combodrop=======>" + getcombo);
		return getcombo;
	}
	
	//view
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestMenuModel>>> viewAssign( String CatId ,String SubCatId ,String Variant , String combo) {
			logger.info("Method : viewCombo starts");
			List<RestMenuModel> respList = new ArrayList<RestMenuModel>();
			
			String value = "SET @p_catId='" + CatId + "',@p_subcatid='" + SubCatId + "',@p_varId='" + Variant + "',@combo_id='" + combo + "';";
			//System.out.print("sacdaaaaaaaaaaaaaaaaaaaaaaaaa"+value);
			
			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-assign")
						.setParameter("actionType", "viewComboItem")
						.setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : x) {

					RestMenuModel restPayroll = new RestMenuModel(m[0], m[1],m[2]);
					respList.add(restPayroll);

				}

			} catch (Exception e) {

				e.printStackTrace();

			}
			JsonResponse<List<RestMenuModel>> resp = new JsonResponse<List<RestMenuModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestMenuModel>>> response = new ResponseEntity<JsonResponse<List<RestMenuModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			logger.info("Method : viewCombo ends");
			return response;

		}
		
		//view
				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<List<RestMenuModel>>> viewAssignCombo( String comboId ) {
					logger.info("Method : viewCombo starts");
					List<RestMenuModel> respList = new ArrayList<RestMenuModel>();
					
					//String value = "SET @p_catId='" + CatId + "',@p_subcatid='" + SubCatId + "',@p_varId='" + Variant + "',@combo_id='" + combo + "';";
					String value = "SET @combo_id='" + comboId + "';";

					//System.out.print("sacdaaaaaaaaaaaaaaaaaaaaaaaaa"+value);
					
					try {

						List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-assign")
								.setParameter("actionType", "viewCombo")
								.setParameter("actionValue", value)
								.getResultList();

						for (Object[] m : x) {

							RestMenuModel restPayroll = new RestMenuModel(m[0], m[1],m[2] ,null);
							respList.add(restPayroll);

						}

					} catch (Exception e) {

						e.printStackTrace();

					}
					JsonResponse<List<RestMenuModel>> resp = new JsonResponse<List<RestMenuModel>>();
					resp.setBody(respList);
					ResponseEntity<JsonResponse<List<RestMenuModel>>> response = new ResponseEntity<JsonResponse<List<RestMenuModel>>>(
							resp, HttpStatus.CREATED);
					System.out.println("response" + response);
					logger.info("Method : viewCombo ends");
					return response;

				}
				

////view
				/*
				 * @SuppressWarnings("unchecked") public
				 * ResponseEntity<JsonResponse<List<RestMenuModel>>> viewShoukeenIncentive() {
				 * logger.info("Method : viewincentivedao starts"); List<RestMenuModel> respList
				 * = new ArrayList<RestMenuModel>();
				 * 
				 * System.out.print("sacdaaaaaaaaaaaaaaaaaaaaaaaaa"+respList);
				 * 
				 * try {
				 * 
				 * List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-assign")
				 * .setParameter("actionType", "viewmenuCombo").setParameter("actionValue",
				 * "").getResultList();
				 * 
				 * for (Object[] m : x) {
				 * 
				 * RestMenuModel restPayroll = new RestMenuModel(m[0], m[1],m[2] );
				 * 
				 * respList.add(restPayroll);
				 * 
				 * System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<,"+restPayroll);
				 * 
				 * }
				 * 
				 * System.out.println("VIEW" + respList);
				 * 
				 * } catch (Exception e) {
				 * 
				 * e.printStackTrace();
				 * 
				 * }
				 * 
				 * JsonResponse<List<RestMenuModel>> resp = new
				 * JsonResponse<List<RestMenuModel>>(); resp.setBody(respList);
				 * ResponseEntity<JsonResponse<List<RestMenuModel>>> response = new
				 * ResponseEntity<JsonResponse<List<RestMenuModel>>>( resp, HttpStatus.CREATED);
				 * System.out.println("response" + response);
				 * logger.info("Method : viewincentivedao ends");
				 * 
				 * System.out.println("VIEWWWWWWWW" + respList); return response;
				 * 
				 * }
				 */
	
	
	//searching
	
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestMenuModel>>> getProductList(String id) {
			logger.info("Method : getProductSearchList starts");

			List<RestMenuModel> itemNameList = new ArrayList<RestMenuModel>();
			JsonResponse<List<RestMenuModel>> resp = new JsonResponse<List<RestMenuModel>>();
			String value = "SET @p_searchValue='" + id + "';";

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-assign")
						.setParameter("actionType", "getAssign").setParameter("actionValue", value)
						.getResultList();

				System.out.println(value);
				for (Object[] m : x) {
					RestMenuModel dropDownModel = new RestMenuModel(m[0], m[1],m[2]);

					itemNameList.add(dropDownModel);
				}
				// System.out.println("getAllcustomer" +itemNameList);
				if (itemNameList.size() > 0) {
					resp.setBody(itemNameList);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} else {
					resp.setBody(itemNameList);
					resp.setCode("failed");
					resp.setMessage("Data not found");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseEntity<JsonResponse<List<RestMenuModel>>> response = new ResponseEntity<JsonResponse<List<RestMenuModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : getProductSearchList ends" + response);

			return response;
		}
		
		
		//searching		
			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<RestMenuModel>>> getComboList(String id) {
				logger.info("Method : getComboList starts");

				List<RestMenuModel> itemNameList = new ArrayList<RestMenuModel>();
				JsonResponse<List<RestMenuModel>> resp = new JsonResponse<List<RestMenuModel>>();
				String value = "SET @p_searchValue='" + id + "';";

				try {
					List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-assign")
							.setParameter("actionType", "getComboAssign").setParameter("actionValue", value)
							.getResultList();

					System.out.println(value);
					for (Object[] m : x) {
						RestMenuModel dropDownModel = new RestMenuModel(m[0], m[1],m[2] ,null, null,null,null);

						itemNameList.add(dropDownModel);
					}
				System.out.println("getAllcustomer" +itemNameList);
					if (itemNameList.size() > 0) {
						resp.setBody(itemNameList);
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
					} else {
						resp.setBody(itemNameList);
						resp.setCode("failed");
						resp.setMessage("Data not found");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				ResponseEntity<JsonResponse<List<RestMenuModel>>> response = new ResponseEntity<JsonResponse<List<RestMenuModel>>>(
						resp, HttpStatus.CREATED);
				logger.info("Method : getComboList ends" + response);

				return response;
			}

			
			public ResponseEntity<JsonResponse<Object>> addAssignComboModel(RestAssignComboModel incentiveDetails) {

				logger.info("Method in Dao: addIncentiveDetailsdao starts");

				JsonResponse<Object> resp = new JsonResponse<Object>();

				resp.setMessage("");
				resp.setCode("");
				try {
					
					String values = GenerateCanteenAssignParameter.addCanteenAssignParameter(incentiveDetails);
					System.out.println(values);
					
					if (incentiveDetails.getId() == "" || incentiveDetails.getId() == null) {

						em.createNamedStoredProcedureQuery("canteen-assign")
								.setParameter("actionType", "addComboAssign").setParameter("actionValue", values).execute();

					} else {
						em.createNamedStoredProcedureQuery("canteen-assign")
								.setParameter("actionType", "modifyComboAssign").setParameter("actionValue", values).execute();
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

				logger.info("Method in Dao:addIncentiveDetailsdao ends" + response);

				return response;
			}
			
			//view
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> viewAssign(String orgName, String orgDivision) {
				logger.info("Method : viewAssign Dao starts");

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-assign")
							.setParameter("actionType", "viewItemAssign").setParameter("actionValue", value).getResultList();
					resp.setBody(x);
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : viewAssign Dao ends"+resp);
				return resp;

			}
			
			/* edit */

			@SuppressWarnings("unchecked")
			public JsonResponse<Object> editAssign(String id, String orgName, String orgDivision) {
				logger.info("Method : editAssign Dao starts");
				JsonResponse<Object> resp = new JsonResponse<Object>();
				try {
					String value = "SET @p_id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println(value);
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-assign")
							.setParameter("actionType", "editAssign").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : editAssign Dao ends"+resp);
				return resp;
			}
			
			//delete
			public ResponseEntity<JsonResponse<Object>> deleteAssign(String id,String orgName,String orgDivision) {
			    logger.info("Method : deleteAssign starts");

			    JsonResponse<Object> resp = new JsonResponse<Object>();

			    try {
			    	String value = "SET @p_id='" + id + "', @p_orgName='" + orgName + "', @p_orgDiv='" + orgDivision + "';";
			        em.createNamedStoredProcedureQuery("canteen-assign").setParameter("actionType", "deleteAssign").setParameter("actionValue", value).execute();
			        
			        //resp.setMessage("Assignment deleted successfully.");
			        resp.setMessage("Success");

			    } catch (Exception e) {
			        e.printStackTrace();
			       
			    }

			    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
			    logger.info("Method : deleteAssign ends");
			    
			    return response;
			}
}

