
package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;

import nirmalya.aatithya.restmodule.account.model.DataSetAccountTree;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateAccountBankParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateCrmCustomerDetails;
import nirmalya.aatithya.restmodule.common.utils.GenerateDataforChildParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateOrganizationParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestOrganizationMasterModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCustomerModel;

import org.springframework.http.HttpHeaders;

@Repository
public class RestAccountInventoryGroupDao {
	
	Logger logger = LoggerFactory.getLogger(RestAccountInventoryGroupDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	//getAccountTreeDetails
	
	/*
	 * 
	 * 
	 * getAccountTreeDetails
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DataSetAccountTree>>> getAccountInventoryTreeDetails(String getAccountInventoryTreeDetails, String orgName, String orgDiv) {

		logger.info("Method : DAO getAccountTreeDetails starts");

		List<DataSetAccountTree> DataSetAccountTree = new ArrayList<DataSetAccountTree>();

		try {
			//String value = "SET @p_activityName=" + 0 + ";";
			String value = "SET @p_activityName='" + 0 + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_inventory_stock_Routines")
					.setParameter("actionType", getAccountInventoryTreeDetails).setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DataSetAccountTree DataSetForActivityConstructor = new DataSetAccountTree(m[0], m[1], m[2], m[3], m[4], null, null);
				DataSetAccountTree.add(DataSetForActivityConstructor);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonResponse<List<DataSetAccountTree>> resp = new JsonResponse<List<DataSetAccountTree>>();
		resp.setBody(DataSetAccountTree);

		ResponseEntity<JsonResponse<List<DataSetAccountTree>>> response = new ResponseEntity<JsonResponse<List<DataSetAccountTree>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : DAO getAccountInventoryTreeDetails ends");
		System.out.print(response);
		return response;
	}
	
	
	//getAllAccountGroupList
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestOrganizationMasterModel>>> getAllAccountGroupList(String orgName,String orgDivision) {
		logger.info("Method : getAllAccountGroupList starts");

		JsonResponse<List<RestOrganizationMasterModel>> resp = new JsonResponse<List<RestOrganizationMasterModel>>();
		List<RestOrganizationMasterModel> newLoc = new ArrayList<RestOrganizationMasterModel>();

		try {
			String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\";";
			System.out.println("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_inventory_stock_Routines")
					.setParameter("actionType", "getAccGroupList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestOrganizationMasterModel item = new RestOrganizationMasterModel(m[0], m[1], null, null, m[2], null,
						m[3], m[4], m[5]);
				newLoc.add(item);
			}

			resp.setBody(newLoc);
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

		ResponseEntity<JsonResponse<List<RestOrganizationMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestOrganizationMasterModel>>>(
				resp, HttpStatus.CREATED);

		
		logger.info("Method : getAllAccountGroupList ends");
		return response;
	}
	
	//restAddParent
	
	/*
	 * DAO Function to restAddParent
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restAddParentforInvntory(DataSetAccountTree table) {
    
		logger.info("Method : restAddParent starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		 
		if (validity)
			try {
				
				String values = GenerateDataforChildParameter.getAddParent(table);
				
				logger.info("values====>"+values);

				if (table.getParentName() != null && table.getParentName() != "") {
					//System.out.println("update required");
					em.createNamedStoredProcedureQuery("account_inventory_stock_Routines")
					.setParameter("actionType", "addParent")
					.setParameter("actionValue", values)
					.execute();
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
		
		logger.info("Method : restAddParentforInvntory ends");
		
		return response;
	}
	
	//restAddChild
	
	/*
	 * DAO Function to restAddChild
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> restAddChildForInventory(DataSetAccountTree table) {
    
		logger.info("Method : restAddChildForInventory starts");
		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		 
		if (validity)
			try {
				
				String values = GenerateDataforChildParameter.getAddChild(table);

				if (table.getParentId() != null && table.getParentId() != "") {
					//System.out.println("update required");
					em.createNamedStoredProcedureQuery("account_inventory_stock_Routines")
					.setParameter("actionType", "addChild")
					.setParameter("actionValue", values)
					.execute();
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
		
		logger.info("Method : restAddChildForInventory ends");
		
		return response;
	}

	//modify name
	public ResponseEntity<JsonResponse<Object>> modifyHeaderNameForInventory(String id, String nameGroup, String orgName, String orgDiv) {
		logger.info("Method : modifyHeaderNameForInventory starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String value = "SET @p_groupId='" + id + "',@p_groupName='" + nameGroup + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				logger.info("value====>" + value);
				em.createNamedStoredProcedureQuery("account_inventory_stock_Routines")
						.setParameter("actionType", "modifyGroup").setParameter("actionValue", value).execute();

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
			resp.setMessage("Modified successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method :  modifyHeaderNameForInventory ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> modifyHeaderNameParentForInventory(String id, String nameGroup, String natureGrp, String orgName, String orgDiv) {
		logger.info("Method : modifyHeaderNameParent starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		//System.out.println("ID...." + id);
		if (validity)
			try {
				String value = "SET @p_groupId='" + id + "',@p_groupName='" + nameGroup + "',@p_natureGrp='" + natureGrp + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				logger.info("value====>" + value);

				em.createNamedStoredProcedureQuery("account_inventory_stock_Routines")
						.setParameter("actionType", "modifyGroupParent").setParameter("actionValue", value).execute();

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
			resp.setMessage("Modified successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  modifyHeaderNameParentForInventory ends"+response);
		//System.out.println("DELETE" + response);
		return response;
	}
}

