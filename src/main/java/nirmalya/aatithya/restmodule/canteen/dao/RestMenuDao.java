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
import nirmalya.aatithya.restmodule.common.utils.GenerateCanteenMenuParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestMenuDao {
	
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-menu")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-menu")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-menu")
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
	public ResponseEntity<JsonResponse<Object>> addIncentiveDetails(RestMenuModel incentiveDetails ,String orgName, String orgDivision) {

		logger.info("Method in Dao: addIncentiveDetailsdao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.print("hhhhhhhhhhhhhhhhhhhh"+value);
			String values = GenerateCanteenMenuParameter.addcanteenmenuParam(incentiveDetails);
			System.out.println(values);
			
			if (incentiveDetails.getItemId() == "" || incentiveDetails.getItemId() == null) {

				em.createNamedStoredProcedureQuery("canteen-menu")
						.setParameter("actionType", "addmenu").setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("canteen-menu")
						.setParameter("actionType", "modifymenu").setParameter("actionValue", values).execute();
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
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> restViewIncentiveDetails() {
		logger.info("Method : viewincentivedao starts");
		List<RestMenuModel> respList = new ArrayList<RestMenuModel>();
		
		
		
		System.out.print("sacdaaaaaaaaaaaaaaaaaaaaaaaaa"+respList);

		try {
			

			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-menu")
					.setParameter("actionType", "viewMenu").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestMenuModel restPayroll = new RestMenuModel(m[0], m[1],m[2], m[3],
						m[4], m[5], m[6]);
				
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
		logger.info("Method : viewincentivedao ends");

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMenuModel>>>editincentivedetailInfo(String id) {
		logger.info("Method : editIncentiveInfo starts");

		JsonResponse<List<RestMenuModel>> resp = new JsonResponse<List<RestMenuModel>>();
		List<RestMenuModel> rs = new ArrayList<RestMenuModel>();

		try {

			String value = "SET @p_itemid='" + id +"';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("canteen-menu")
					.setParameter("actionType", "editmenu").setParameter("actionValue", value).getResultList();
			
	     
			for (Object[] m : x) {

				RestMenuModel restPayroll = new RestMenuModel(m[0], m[1],m[2], m[3],
						m[4], m[5], m[6]);
			
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
	public ResponseEntity<JsonResponse<Object>> deleteIncentiveDetails(String id) {
		logger.info("Method : deleteincentiveDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		System.out.println("ID...."+id);
		if (id != "" || id != null) {
			try {

				
				String value = "SET  @p_itemid=" + id + ";";
				
				System.out.println("value------------------"+value);
				

				em.createNamedStoredProcedureQuery("canteen-menu")
						.setParameter("actionType", "deletemenu").setParameter("actionValue", value).execute();

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
