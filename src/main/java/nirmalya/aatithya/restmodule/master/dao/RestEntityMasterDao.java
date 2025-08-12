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
import nirmalya.aatithya.restmodule.common.utils.GenerateEntityMaster;
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterReferenceHr;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestEntityMasterModel;
import nirmalya.aatithya.restmodule.master.model.RestHrMasterModel;

@Repository
public class RestEntityMasterDao {

	Logger logger = LoggerFactory.getLogger(RestEntityMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to Add jobTypes
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addCostNature(RestEntityMasterModel restEntityMasterModel) {
		logger.info("Method : addCostNature Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateEntityMaster.addCostNatureParam(restEntityMasterModel);

				if (restEntityMasterModel.getCostnatureId() != null && restEntityMasterModel.getCostnatureId() != "") {
					em.createNamedStoredProcedureQuery("EntityCostNature")
							.setParameter("actionType", "modifyCostNature").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("EntityCostNature").setParameter("actionType", "addCostNature")
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

		logger.info("Method : addCostNature Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> viewCostNature(String org, String orgDiv) {
		logger.info("Method : viewCostNature starts");

		List<RestEntityMasterModel> CostNatureList = new ArrayList<RestEntityMasterModel>();

		try {
			String values = "SET @p_org='"+ org + "',@p_orgDiv='"+orgDiv +"';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("EntityCostNature")
					.setParameter("actionType", "viewCostNature").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestEntityMasterModel dropDownModel = new RestEntityMasterModel(m[0], m[1], m[2], status, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null);
				CostNatureList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestEntityMasterModel>> resp = new JsonResponse<List<RestEntityMasterModel>>();
		resp.setBody(CostNatureList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestEntityMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewCostNature ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteCostNatureType(String id) {

		logger.info("Method : deleteCostNatureType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_costNatureId='" + id + "';";

			em.createNamedStoredProcedureQuery("EntityCostNature").setParameter("actionType", "deleteCostNatureType")
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

		logger.info("Method : deleteCostNatureType Dao starts");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addCostLabour(RestEntityMasterModel restEntityMasterModel) {
		logger.info("Method : Rest addCostLabour Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateEntityMaster.addCostLabourParam(restEntityMasterModel);

				if (restEntityMasterModel.getCostLabourId() != null && restEntityMasterModel.getCostLabourId() != "") {
					em.createNamedStoredProcedureQuery("EntityCostLabour")
							.setParameter("actionType", "modifyCostLabourType").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("EntityCostLabour")
							.setParameter("actionType", "addCostLabourType").setParameter("actionValue", values)
							.execute();
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

		logger.info("Method : Rest addCostLabour Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> viewCostLabour(String org, String orgDiv) {
		logger.info("Method : viewCostLabour starts");

		List<RestEntityMasterModel> costLabourList = new ArrayList<RestEntityMasterModel>();

		try {
			String values = "SET @p_org='"+ org + "',@p_orgDiv='"+orgDiv +"';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("EntityCostLabour")
					.setParameter("actionType", "viewCostLabour").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestEntityMasterModel dropDownModel = new RestEntityMasterModel(null, null, null, null, null, null,
						null, null, m[0], m[1], m[2], status, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null);
				costLabourList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestEntityMasterModel>> resp = new JsonResponse<List<RestEntityMasterModel>>();
		resp.setBody(costLabourList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestEntityMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewCostLabour ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteCostLabour(String id) {

		logger.info("Method : deleteCostLabour Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_costLabourId='" + id + "';";

			em.createNamedStoredProcedureQuery("EntityCostLabour").setParameter("actionType", "deleteCostLabour")
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

		logger.info("Method : deleteCostLabour Dao starts");
		return response;
	}

	// Vendor Type Master

	public ResponseEntity<JsonResponse<Object>> addVendorCatagory(RestEntityMasterModel restEntityMasterModel) {
		logger.info("Method : Rest addVendorCatagory Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateEntityMaster.addVendorCategoryParam(restEntityMasterModel);

				if (restEntityMasterModel.getVendorCategoryId() != null
						&& restEntityMasterModel.getVendorCategoryId() != "") {
					em.createNamedStoredProcedureQuery("EntityVendorCategory")
							.setParameter("actionType", "modifyVendorCategory").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("EntityVendorCategory")
							.setParameter("actionType", "addVendorCategory").setParameter("actionValue", values)
							.execute();
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

		logger.info("Method : Rest addVendorCatagory Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> viewVendorCatagory(String org, String orgDiv) {
		logger.info("Method : viewVendorCatagory starts");

		List<RestEntityMasterModel> vendorList = new ArrayList<RestEntityMasterModel>();

		try {
			
			String values = "SET @p_org='"+ org + "',@p_orgDiv='"+orgDiv +"';";
		
			List<Object[]> x = em.createNamedStoredProcedureQuery("EntityVendorCategory")
					.setParameter("actionType", "viewVendorCatagory").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestEntityMasterModel dropDownModel = new RestEntityMasterModel(null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2], status, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null);
				vendorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestEntityMasterModel>> resp = new JsonResponse<List<RestEntityMasterModel>>();
		resp.setBody(vendorList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestEntityMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewVendorCatagory ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteVendorCatagory(String id) {

		logger.info("Method : deleteVendorCatagory Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_vendorCategoryId='" + id + "';";

			em.createNamedStoredProcedureQuery("EntityVendorCategory").setParameter("actionType", "deleteVendorCatagory")
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

		logger.info("Method : deleteVendorCatagory Dao ends");
		return response;
	}

	// Location Type Master

	public ResponseEntity<JsonResponse<Object>> addLocationType(RestEntityMasterModel restEntityMasterModel) {
		logger.info("Method : addLocationType Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateEntityMaster.addLocationTypeParam(restEntityMasterModel);

				if (restEntityMasterModel.getLocationTypeId() != null
						&& restEntityMasterModel.getLocationTypeId() != "") {
					em.createNamedStoredProcedureQuery("EntityLocationType")
							.setParameter("actionType", "modifyLocationType").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("EntityLocationType")
							.setParameter("actionType", "addLocationType").setParameter("actionValue", values)
							.execute();
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

		logger.info("Method : addLocationType Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> viewLocationType(String org, String orgDiv) {
		logger.info("Method : viewLocationType starts");

		List<RestEntityMasterModel> locationTypeList = new ArrayList<RestEntityMasterModel>();

		try {
			String values = "SET @p_org='"+ org + "',@p_orgDiv='"+orgDiv +"';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("EntityLocationType")
					.setParameter("actionType", "viewLocationType").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestEntityMasterModel dropDownModel = new RestEntityMasterModel(null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, m[0], m[1], m[2], status, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null);
				locationTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestEntityMasterModel>> resp = new JsonResponse<List<RestEntityMasterModel>>();
		resp.setBody(locationTypeList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestEntityMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewLocationType ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteLocationType(String id) {

		logger.info("Method : deleteLocationType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_locationTypeId='" + id + "';";

			em.createNamedStoredProcedureQuery("EntityLocationType").setParameter("actionType", "deleteLocationType")
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

		logger.info("Method : deleteLocationType Dao ends");
		return response;
	}

	// Room Type Master

	public ResponseEntity<JsonResponse<Object>> addRoomType(RestEntityMasterModel restEntityMasterModel) {
		logger.info("Method : addRoomType Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateEntityMaster.addRoomTypeParam(restEntityMasterModel);

				if (restEntityMasterModel.getRoomTypeId() != null && restEntityMasterModel.getRoomTypeId() != "") {
					em.createNamedStoredProcedureQuery("EntityRoomType").setParameter("actionType", "modifyRoomType")
							.setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("EntityRoomType").setParameter("actionType", "addRoomType")
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

		logger.info("Method : addRoomType Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> viewRoomType(String org, String orgDiv) {
		logger.info("Method : viewRoomType starts");

		List<RestEntityMasterModel> roomTypeList = new ArrayList<RestEntityMasterModel>();

		try {
			String values = "SET @p_org='"+ org + "',@p_orgDiv='"+orgDiv +"';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("EntityRoomType")
					.setParameter("actionType", "viewRoomType").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[3].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestEntityMasterModel dropDownModel = new RestEntityMasterModel(null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2], status, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null);
				roomTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestEntityMasterModel>> resp = new JsonResponse<List<RestEntityMasterModel>>();
		resp.setBody(roomTypeList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestEntityMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewRoomType ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteRoomType(String id) {

		logger.info("Method : deleteRoomType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_roomTypeId='" + id + "';";

			em.createNamedStoredProcedureQuery("EntityRoomType").setParameter("actionType", "deleteRoomType")
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

		logger.info("Method : deleteRoomType Dao ends");
		return response;
	}

	// Vendor Type Master

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVendorCategoryList() {
		logger.info("Method : getVendorCategoryList starts");

		List<DropDownModel> getVendorCategoryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EntityVendorType")
					.setParameter("actionType", "getVendorCategoryList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getVendorCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVendorCategoryList ends");
		return getVendorCategoryList;
	}

	public ResponseEntity<JsonResponse<Object>> addVendorTypeMaster(RestEntityMasterModel restEntityMasterModel) {
		logger.info("Method : Rest addVendorTypeMaster Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateEntityMaster.addVendorTypeParam(restEntityMasterModel);

				if (restEntityMasterModel.getVendorTypeId() != null && restEntityMasterModel.getVendorTypeId() != "") {
					em.createNamedStoredProcedureQuery("EntityVendorType")
							.setParameter("actionType", "modifyVendorTypeMaster").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("EntityVendorType")
							.setParameter("actionType", "addVendorTypeMaster").setParameter("actionValue", values)
							.execute();
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

		logger.info("Method : Rest addVendorTypeMaster Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> viewVendorTypeMaster(String org, String orgDiv) {
		logger.info("Method : viewVendorTypeMaster starts");

		List<RestEntityMasterModel> vendorList = new ArrayList<RestEntityMasterModel>();

		try {
			String values = "SET @p_org='"+ org + "',@p_orgDiv='"+orgDiv +"';";
			logger.info("Method : viewVendorTypeMaster starts"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("EntityVendorType")
					.setParameter("actionType", "viewVendorTypeMaster").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object status = "";
				if (m[5].equals("1")) {
					status = "Active";
				} else {
					status = "Inactive";
				}
				RestEntityMasterModel dropDownModel = new RestEntityMasterModel(null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, m[0], m[1], m[2], m[3], m[4], status, null, null, null, null);
				vendorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestEntityMasterModel>> resp = new JsonResponse<List<RestEntityMasterModel>>();
		resp.setBody(vendorList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestEntityMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestEntityMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewVendorTypeMaster ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteVendorTypeMaster(String id) {

		logger.info("Method : deleteVendorTypeMaster Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_vendorTypeId='" + id + "';";

			em.createNamedStoredProcedureQuery("EntityVendorType").setParameter("actionType", "deleteVendorTypeMaster")
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

		logger.info("Method : deleteVendorTypeMaster Dao ends");
		return response;
	}
}
