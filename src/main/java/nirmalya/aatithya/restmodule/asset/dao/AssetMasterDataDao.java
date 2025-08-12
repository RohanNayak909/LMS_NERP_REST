package nirmalya.aatithya.restmodule.asset.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.asset.model.AssetMasterDataRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetMasterDataParam;
 
@Repository
public class AssetMasterDataDao {
	Logger logger = LoggerFactory.getLogger(AssetMasterDataDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

 

	public ResponseEntity<JsonResponse<Object>> addAsset(AssetMasterDataRestModel assetMaster) {
		logger.info("Method in Dao: addAsset starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			 
			String values = GenerateAssetMasterDataParam.addAssetData(assetMaster);
			
			
			if (assetMaster.getAsssetInfo().equals("assetInfo")) {

				if (assetMaster.getAssetId() == "" || assetMaster.getAssetId() == null) {

					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "addAsset").setParameter("actionValue", values).execute();
					
					
					resp.setMessage("Asset data saved successfully");
					resp.setCode("success");
                 }
				else {
					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "modifyAsset").setParameter("actionValue", values).execute();
					
					
					resp.setMessage(" Asset data Modified successfully");
					resp.setCode("success");
				}

			} else if (assetMaster.getAsssetInfo().equals("assetCat")) {

				if (assetMaster.getCategoryId() == "" || assetMaster.getCategoryId() == null) {

					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "addAssetCategory").setParameter("actionValue", values)
							.execute();
					
					
					resp.setMessage("Asset Category saved successfully");
					resp.setCode("success");

				} else {
					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "modifyAssetCategory").setParameter("actionValue", values)
							.execute();
					
					resp.setMessage("Asset Category Modified successfully");
					resp.setCode("success");
				}

			} else if (assetMaster.getAsssetInfo().equals("dummyAst")) {

				 

				if (assetMaster.getDummyId() == "" || assetMaster.getDummyId() == null) {
					 
					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "addDummyAsset").setParameter("actionValue", values).execute();
                       
					
					resp.setMessage("Dummy asset saved successfully");
					resp.setCode("success");
				}
				else {
					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "modifyDummyAsset").setParameter("actionValue", values)
							.execute();
					
					
					resp.setMessage("Dummy asset modified successfully");
					resp.setCode("success");
				}
				

			} else if (assetMaster.getAsssetInfo().equals("ownerShip")) {

				if (assetMaster.getOwnershipId() == "" || assetMaster.getOwnershipId() == null) {

					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "addOwnership").setParameter("actionValue", values).execute();
					
					
					resp.setMessage(" Asset Ownership saved successfully");
					resp.setCode("success");

				}
				
				else {
					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "modifyOwnership").setParameter("actionValue", values)
							.execute();
					
					
					resp.setMessage("Asset Owner Modified successfully");
					resp.setCode("success");
				}

			} else if (assetMaster.getAsssetInfo().equals("subCategory")) {
				 

				if (assetMaster.getAssetSubCatId() == "" || assetMaster.getAssetSubCatId() == null) {
					 

					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "addSubCategory").setParameter("actionValue", values).execute();
					
					
					resp.setMessage(" Asset Sub Category saved successfully");
					resp.setCode("success");

				}
				
				else {
					 
					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "modifySubCategory").setParameter("actionValue", values)
							.execute();
					
					
					resp.setMessage(" Asset Sub Category Modified successfully");
					resp.setCode("success");
				}

			} else if (assetMaster.getAsssetInfo().equals("sparePartCategory")) {
				 

				if (assetMaster.getAssetSpId() == "" || assetMaster.getAssetSpId() == null) {
					 

					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "addSpCategory").setParameter("actionValue", values).execute();
					
					
					resp.setMessage(" Asset Spare Part Category saved successfully");
					resp.setCode("success");

				}
				
				else {
					 
					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "modifySpCategory").setParameter("actionValue", values)
							.execute();
					
					
					resp.setMessage(" Asset Spare Part Category Modified successfully");
					resp.setCode("success");
				}

			}
			
			else if (assetMaster.getAsssetInfo().equals("spSubCategory")) {
				 

				if (assetMaster.getSpSubCatId() == "" || assetMaster.getSpSubCatId() == null) {
					 

					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "addSpSubCategory").setParameter("actionValue", values).execute();
					
					
					resp.setMessage(" Asset Spare Part Sub Category saved successfully");
					resp.setCode("success");

				}
				
				else {
					 
					em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
							.setParameter("actionType", "modifySpSubCategory").setParameter("actionValue", values)
							.execute();
					
					
					resp.setMessage(" Asset Spare Part Sub Category Modified successfully");
					resp.setCode("success");
				}

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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);

		logger.info("Method in Dao: addAsset ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAsset(String type) {
		logger.info("Method in Dao: getAsset starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_type='" + type + "';";
			
 			List<Object[]> x = em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
					.setParameter("actionType", "getAssetMaster").setParameter("actionValue", value).getResultList();
 			 
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method in Dao: getAsset ends");
		
		 
		return resp;
	}

	public ResponseEntity<JsonResponse<Object>> deleteAsset(String type, String id) {
		logger.info("Method in Dao: deleteAsset starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		resp.setMessage("");
		resp.setCode("");
		 
			try {

				String value = "SET @p_id='" + id + "',@p_type='" + type + "';";
				System.out.println("value=================="+value);
		 
				 
				Boolean status = em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
						.setParameter("actionType", "deleteAsset").setParameter("actionValue", value).execute();
				 
				resp.setMessage("Data Deleted Succesfully");
				resp.setCode("Success");

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

		logger.info("Method in Dao :  deleteAsset ends");
		 
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> assetCategoryList() {
		logger.info("Method in Dao: assetCategoryList starts");
		List<DropDownModel> assetCategoryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
					.setParameter("actionType", "assetCategoryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				assetCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao : assetCategoryList end");
		return assetCategoryList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> assetSpCategoryList() {
		logger.info("Method in Dao: assetSpCategoryList starts");
		List<DropDownModel> assetSpCategoryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assets_property_dropdown_routines")
					.setParameter("actionType", "assetSpCategoryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				assetSpCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao : assetSpCategoryList end");
		return assetSpCategoryList;
	}

}
