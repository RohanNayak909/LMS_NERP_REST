package nirmalya.aatithya.restmodule.canteen.dao;

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

import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCanteenComboParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateCanteenMenuParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@Repository
public class RestCanteenComboDao {

	
	Logger logger = LoggerFactory.getLogger(RestMenuDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getincentive() {
		logger.info("Method : getincentive starts");

		List<DropDownModel> getincentive = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-combo")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-combo")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-combo")
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
	
	// Add
	public ResponseEntity<JsonResponse<Object>> addIncentiveDetails(RestMenuModel incentiveDetails) {

		logger.info("Method in Dao: addIncentiveDetailsdao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateCanteenComboParameter.addcanteenComboParam(incentiveDetails);
			System.out.println("===================combo id==================================="+incentiveDetails.getComboId());
			//if (incentiveDetails.getItemId() == "" || incentiveDetails.getItemId() == null) {

			if (incentiveDetails.getComboId() == "" || incentiveDetails.getComboId() == null) {
       System.out.println("addd part");
				em.createNamedStoredProcedureQuery("canteen-combo")
						.setParameter("actionType", "addCombo")
						.setParameter("actionValue", values).execute();

			} else {
				System.out.println("modify part");
				em.createNamedStoredProcedureQuery("canteen-combo").setParameter("actionType", "modifyCombo")
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

		logger.info("Method in Dao:addIncentiveDetailsdao ends" + response);

		return response;
	}
	
	

////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> viewCombo( String CatId ,String SubCatId ,String Variant) {
		logger.info("Method : viewCombo starts");
		List<RestMenuModel> respList = new ArrayList<RestMenuModel>();
		
		String value = "SET @p_catId='" + CatId + "',@p_subcatid='" + SubCatId + "',@p_varId='" + Variant + "';";
		//System.out.print("sacdaaaaaaaaaaaaaaaaaaaaaaaaa"+value);
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-combo")
					.setParameter("actionType", "viewCombo")
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
	
////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> viewShoukeenIncentive() {
		logger.info("Method : viewComboAlldao starts");
		List<RestMenuModel> respList = new ArrayList<RestMenuModel>();
		
		
		System.out.print("sacdaaaaaaaaaaaaaaaaaaaaaaaaa"+respList);

		try {
            System.out.print("hibulet");
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-combo")
					.setParameter("actionType", "viewallcombo")
					.setParameter("actionValue", "").getResultList();
			 System.out.print("hibulet");
			for (Object[] m : x) {
				
				RestMenuModel restPayroll = new RestMenuModel(m[0], m[1],m[2],m[3]);
				
				respList.add(restPayroll);
				
				System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<,"+restPayroll);

			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestMenuModel>> resp = new JsonResponse<List<RestMenuModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestMenuModel>>> response = new ResponseEntity<JsonResponse<List<RestMenuModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : viewComboAlldao ends");
		
		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}
	
	
////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> viewRowdata( String rowData ) {
		logger.info("Method : viewCombo starts");
		List<RestMenuModel> respList = new ArrayList<RestMenuModel>();
		
		String value = "SET @p_rowData='" + rowData + "';";
		System.out.print("sacdaaaaaaaaaaaaaaaaaaaaaaaaa"+value);
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-combo")
					.setParameter("actionType", "viewRowData")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestMenuModel restPayroll = new RestMenuModel(m[0], m[1],m[2],m[3]);
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
	
	
	//searching
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> getProductList(String id) {
		logger.info("Method : getProductSearchList starts");

		List<RestMenuModel> itemNameList = new ArrayList<RestMenuModel>();
		JsonResponse<List<RestMenuModel>> resp = new JsonResponse<List<RestMenuModel>>();
		String value = "SET @p_searchValue='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-combo")
					.setParameter("actionType", "getMenu").setParameter("actionValue", value)
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
	
	//Edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMenuModel>>>editcanteencombo(String id) {
		logger.info("Method : editIncentiveInfo starts");

		JsonResponse<List<RestMenuModel>> resp = new JsonResponse<List<RestMenuModel>>();
		List<RestMenuModel> rs = new ArrayList<RestMenuModel>();

		try {

			String value = "SET @combo_id='" + id +"';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-combo")
					.setParameter("actionType", "editCombo").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {

				RestMenuModel restPayroll = new RestMenuModel(m[0], m[1], m[2], m[4], m[3], m[5],m[6],m[7],m[8]);
			
				rs.add(restPayroll);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	  resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestMenuModel>>> response = new ResponseEntity<JsonResponse<List<RestMenuModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : editIncentiveInfo ends");
		System.out.println("hello"+response);
		return response;
	}
	
	
	
	//delete
		public ResponseEntity<JsonResponse<Object>> deleteComboDetails(String id) {
			logger.info("Method : deleteincentiveDetails starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			
			System.out.println("ID...."+id);
			if (id != "" || id != null) {
				try {

					
					String value = "SET  @combo_id=" + id + ";";
					
					System.out.println("value------------------"+value);
					

					em.createNamedStoredProcedureQuery("canteen-combo")
							.setParameter("actionType", "deletcombo").setParameter("actionValue", value).execute();

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
			} else {
				resp.setMessage("Please Provide Item Id");
			}

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);

			logger.info("Method :  deleteincentiveDetails ends");
			System.out.println("DELETE" + response);
			return response;
		}
	   
}
