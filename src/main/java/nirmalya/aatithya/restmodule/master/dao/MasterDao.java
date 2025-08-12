package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.MasterModel;
import nirmalya.aatithya.restmodule.master.model.MasterWarehouseModel;

@Repository
public class MasterDao {

	Logger logger = LoggerFactory.getLogger(MasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCategoryListDao(String org, String orgDiv) {
		logger.info("Method : getCategoryListDao Dao starts");

		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
					.setParameter("actionType", "getCategoryList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dd = new DropDownModel(m[0], m[1]);
				categoryList.add(dd);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCategoryListDao Dao ends");
		return categoryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getprojectcategorylistDao(String org, String orgDiv) {
		logger.info("Method : getprojectcategorylistDao Dao starts");

		List<DropDownModel> categoryList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
					.setParameter("actionType", "getPCategoryList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dd = new DropDownModel(m[0], m[1]);
				categoryList.add(dd);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getprojectcategorylistDao Dao ends");
		return categoryList;
	}
 
	public ResponseEntity<JsonResponse<Object>> addMasterDataDao(MasterModel masterModel) {
		logger.info("Method : addMasterDataDao Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(masterModel);

			if (masterModel.getType().equals("category")) {
				if (masterModel.getCategoryId() != null && masterModel.getCategoryId() != "") {
					em.createNamedStoredProcedureQuery("masterDataRoutines")
							.setParameter("actionType", "modifyCategory").setParameter("actionValue", values).execute();

					resp.setMessage("Data updated successfully");
				} else {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "addCategory")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data saved successfully");
				}
			}
			if (masterModel.getType().equals("subcategory")) {
				if (masterModel.getSubCategoryId() != null && masterModel.getSubCategoryId() != "") {
					em.createNamedStoredProcedureQuery("masterDataRoutines")
							.setParameter("actionType", "modifySubCategory").setParameter("actionValue", values)
							.execute();

					resp.setMessage("Data updated successfully");
				} else {

					em.createNamedStoredProcedureQuery("masterDataRoutines")
							.setParameter("actionType", "addSubCategory").setParameter("actionValue", values).execute();

					resp.setMessage("Data saved successfully");
				}
			}
			if (masterModel.getType().equals("variant")) {
				if (masterModel.getVariantId() != null && masterModel.getVariantId() != "") {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "modifyVariant")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data updated successfully");
				} else {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "addVariant")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data saved successfully");
				}
			}
			if (masterModel.getType().equals("pcategory")) {
				if (masterModel.getCategoryId() != null && masterModel.getCategoryId() != "") {
					em.createNamedStoredProcedureQuery("masterDataRoutines")
							.setParameter("actionType", "modifypCategory").setParameter("actionValue", values)
							.execute();

					resp.setMessage("Data updated successfully");
				} else {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "addpCategory")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data saved successfully");
				}
			}
			if (masterModel.getType().equals("psubcategory")) {
				if (masterModel.getSubCategoryId() != null && masterModel.getSubCategoryId() != "") {
					em.createNamedStoredProcedureQuery("masterDataRoutines")
							.setParameter("actionType", "modifypSubCategory").setParameter("actionValue", values)
							.execute();

					resp.setMessage("Data updated successfully");
				} else {

					em.createNamedStoredProcedureQuery("masterDataRoutines")
							.setParameter("actionType", "addpSubCategory").setParameter("actionValue", values)
							.execute();

					resp.setMessage("Data saved successfully");
				}
			}
			if (masterModel.getType().equals("pvariant")) {
				if (masterModel.getVariantId() != null && masterModel.getVariantId() != "") {
					em.createNamedStoredProcedureQuery("masterDataRoutines")
							.setParameter("actionType", "modifypVariant").setParameter("actionValue", values).execute();

					resp.setMessage("Data updated successfully");
				} else {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "addpVariant")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data saved successfully");
				}
			}
			if (masterModel.getType().equals("ptype")) {
				if (masterModel.getCategoryId() != null && masterModel.getCategoryId() != "") {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "modifypType")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data updated successfully");
				} else {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "addpType")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data saved successfully");
				}
			}
			
			if (masterModel.getType().equals("btype")) {
				if (masterModel.getCategoryId() != null && masterModel.getCategoryId() != "") {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "modifybType")
							.setParameter("actionValue", values).execute();
 
					resp.setMessage("Data updated successfully");
				} else {
					System.out.println(values);
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "addbType")
							.setParameter("actionValue", values).execute();
 
					resp.setMessage("Data saved successfully");
				}
			}
			if (masterModel.getType().equals("rtype")) {
				if (masterModel.getCategoryId() != null && masterModel.getCategoryId() != "") {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "modifyrType")
							.setParameter("actionValue", values).execute();
 
					resp.setMessage("Data updated successfully");
				} else {
					
					System.out.println(values);
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "addrType")
							.setParameter("actionValue", values).execute();
 
					resp.setMessage("Data saved successfully");
				}
			}
 
			if (masterModel.getType().equals("HLtype")) {
				System.out.println("VALUES=============="+values);
				if (masterModel.getHolidayId() != null && masterModel.getHolidayId() != "") {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "modifyHoliday")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data updated successfully");
				} else {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "addHoliday")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data saved successfully");
				}
			}
			if (masterModel.getType().equals("PModeType")) {
				System.out.println("VALUES=============="+values);
				if (masterModel.getModeId() != null && masterModel.getModeId() != "") {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "modifyPaymentMode")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data updated successfully");
				} else {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "addPaymentMode")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data saved successfully");
				}
			}
			if (masterModel.getType().equals("SACType")) {
				System.out.println("VALUES=============="+values);
				if (masterModel.getSacId() != null && masterModel.getSacId() != "") {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "modifySac")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data updated successfully");
				} else {
					em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "addSac")
							.setParameter("actionValue", values).execute();

					resp.setMessage("Data saved successfully");
				}
			}

			resp.setCode("success");

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addMasterDataDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<MasterModel>>> viewMasterDataDao(String org, String orgDiv, String type) {
		logger.info("Method : viewMasterDataDao starts");

		List<MasterModel> dependent = new ArrayList<MasterModel>();
		JsonResponse<List<MasterModel>> resp = new JsonResponse<List<MasterModel>>();

		try {
			String values = "SET @p_type='" + type + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
					.setParameter("actionType", "viewMasterData").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				MasterModel masterModel = new MasterModel();

				if (type.equals("category")) {
					Object status = "";
					if (m[3].equals(true)) {
						status = "Active";
					} else {
						status = "Inactive";
					}

					masterModel = new MasterModel(m[0], m[1], m[2], status);
				}
				if (type.equals("subcategory")) {
					Object status = "";
					if (m[4].equals(true)) {
						status = "Active";
					} else {
						status = "Inactive";
					}

					masterModel = new MasterModel(m[0], m[1], m[2], m[3], status, m[5]);
				}
				if (type.equals("variant")) {
					Object status = "";
					if (m[5].equals("1")) {
						status = "Active";
					} else {
						status = "Inactive";
					}

					masterModel = new MasterModel(m[0], m[1], m[2], m[3], m[4], status, m[6], m[7]);
				}

				if (type.equals("pcategory")) {
					Object status = "";
					if (m[3].equals("1")) {
						status = "Active";
					} else {
						status = "Inactive";
					}

					Object order = null;
					if (m[1] != null && m[1] != "") {
						order = m[1].toString();
					}

					masterModel = new MasterModel(m[0], order, m[2], status);
				}

				if (type.equals("psubcategory")) {
					Object status = "";
					if (m[4].equals("1")) {
						status = "Active";
					} else {
						status = "Inactive";
					}

					Object order = null;
					if (m[2] != null && m[1] != "") {
						order = m[2].toString();
					}

					masterModel = new MasterModel(m[0], m[1], order, m[3], status, m[5]);
				}
				if (type.equals("pvariant")) {
					Object status = "";
					if (m[5].equals("1")) {
						status = "Active";
					} else {
						status = "Inactive";
					}

					Object order = null;
					if (m[3] != null && m[1] != "") {
						order = m[3].toString();
					}

					masterModel = new MasterModel(m[0], m[1], m[2], order, m[4], status, m[6], m[7]);
				}

				if (type.equals("ptype")) {
					Object status = "";
					if (m[3].equals("1")) {
						status = "Active";
					} else {
						status = "Inactive";
					}

					masterModel = new MasterModel(m[0], m[1], m[2], status);
				}
				if (type.equals("btype")) {
					Object status = "";
					if (m[2].equals("1")) {
						status = "Active";
					} else {
						status = "Inactive";
					}
 
					masterModel = new MasterModel(m[0],m[3],m[1] ,status);
				}
				
				if (type.equals("rtype")) {
					Object status = "";
					if (m[2].equals("1")) {
						status = "Active";
					} else {
						status = "Inactive";
					}
 
					masterModel = new MasterModel(m[0],m[3],m[1] ,status);
				}
 

				dependent.add(masterModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (dependent.size() > 0) {
			resp.setBody(dependent);
			resp.setCode("success");
			resp.setCode("Data fetched successfully");
		} else {
			resp.setBody(dependent);
			resp.setCode("failed");
			resp.setCode("Data not found");
		}

		ResponseEntity<JsonResponse<List<MasterModel>>> response = new ResponseEntity<JsonResponse<List<MasterModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewMasterDataDao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteMasterDataDao(String id, String type, String userId, String org,
			String orgDiv) {
		logger.info("Method : deleteMasterDataDao  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='" + id + "', @p_type='" + type + "', @p_deletedBy='" + userId + "', @p_org='"
					+ org + "', @p_orgDiv='" + orgDiv + "';";

			em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "deleteMasterData")
					.setParameter("actionValue", values).execute();

			resp.setCode("success");
			resp.setMessage("Data deleted successfully");

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteMasterDataDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getSubCatDataDao(String id, String org, String orgDiv) {
		logger.info("Method : getSubCatDataDao  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<DropDownModel> subCatList = new ArrayList<DropDownModel>();

		try {
			String values = "SET @p_id='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
					.setParameter("actionType", "getSubCatData").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dd = new DropDownModel(m[0], m[1]);
				subCatList.add(dd);
			}

			if (subCatList.size() > 0) {
				resp.setBody(subCatList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getSubCatDataDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getProjectSubCatDataDao(String id, String org, String orgDiv) {
		logger.info("Method : getProjectSubCatDataDao  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<DropDownModel> subCatList = new ArrayList<DropDownModel>();

		try {
			String values = "SET @p_id='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
					.setParameter("actionType", "getPSubCatData").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dd = new DropDownModel(m[0], m[1]);
				subCatList.add(dd);
			}

			if (subCatList.size() > 0) {
				resp.setBody(subCatList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getProjectSubCatDataDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getConfigDataDao(String org, String orgDiv) {
		logger.info("Method : getConfigDataDao  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
					.setParameter("actionType", "getConfigData").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getConfigDataDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getWarehouseListDao(String org, String orgDiv) {
		logger.info("Method : getWarehouseListDao  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
					.setParameter("actionType", "getWarehouse").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getWarehouseListDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getTestListTypeWiseDao(String type, String org, String orgDiv) {
		logger.info("Method : getTestListTypeWiseDao  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_type='" + type + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
					.setParameter("actionType", "getTestLists").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getTestListTypeWiseDao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> restChangePassword(DropDownModel data) {
		logger.info("Method : restChangePassword Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(data);

			em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "changePassword")
					.setParameter("actionValue", values).execute();

			resp.setCode("success");
			resp.setMessage("Password changed successfully");

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : restChangePassword Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getShiftDetails(String dt1, String dt2, String org, String orgDiv, String userId) {
		logger.info("Method : getShiftDetails  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<DropDownModel> subCatList = new ArrayList<DropDownModel>();

		try {
			String values = "SET @p_dt1='" + dt1 + "', @p_dt2='" + dt2 + "', @p_userId='" + userId + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
					.setParameter("actionType", "getShiftDetails").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dd = new DropDownModel(m[0].toString(), m[1]);
				subCatList.add(dd);
			}
			
			if (x.size() > 0) {
				resp.setBody(subCatList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(null);
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Something went wrong");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getShiftDetails ends");
		return response;
	}
	//getTransactionDocumentNumberingData
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getTransactionDocumentNumberingData(String org, String orgDiv) {
		logger.info("Method : getTransactionDocumentNumberingData  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
					.setParameter("actionType", "getTransactionDocumentNumberingData").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getTransactionDocumentNumberingData ends");
		return response;
	}
	// modifyTransactionDocumentNumberingData
				@Transactional
				public ResponseEntity<JsonResponse<Object>> modifyTransactionDocumentNumberingData(String prefixData, String userId, String org, String orgDiv) {
					logger.info("method: modifyTransactionDocumentNumberingData Dao Starts");

					JsonResponse<Object> resp = new JsonResponse<>();
					try {
						String value = "SET @p_prefixData='" + prefixData + "', @p_userId='" + userId + "', @p_org='" + org + "', @p_orgDiv='"
								+ orgDiv + "';";
						
						System.out.println("value for prefix details============= >"+value);

						String pfix_id = "";
						try {
							Gson gson = new Gson();
							JsonObject jsonObject = gson.fromJson(prefixData, JsonObject.class);
							if (jsonObject.has("pfix_id")) {
								pfix_id = jsonObject.get("pfix_id").getAsString();
							}
						} catch (Exception parseException) {
							logger.error("Error parsing prefix with Gson: ", parseException);
						}

						if (pfix_id != null && !pfix_id.trim().isEmpty()) {
							Object singleResult = em.createNamedStoredProcedureQuery("masterDataRoutines")
						        .setParameter("actionType", "modifyTransactionDocumentNumbering")
						        .setParameter("actionValue", value).getSingleResult();
							System.out.println("singleResult.toString()==="+singleResult.toString());
							JSONObject json = new JSONObject(singleResult.toString());
						    resp.setMessage(json.getString("message"));
						    resp.setCode(json.getString("code"));
						}

					} catch (Exception e) {
						logger.error("Error in prefix details: ", e);
					}

					ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

					logger.info("method: modifyTransactionDocumentNumberingData Dao Ends");
					return response;
				}
//
				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<List<DropDownModel>>> EmployeeAutoSearch(String id,String org,String orgDiv) {
					logger.info("Method : EmployeeAutoSearch starts");
					List<DropDownModel> empNameList = new ArrayList<DropDownModel>();
					JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
					String value = "SET @p_searchValue='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
					logger.info("SRCHVALUE"+value);
					try {
						List<Object[]> x = em.createNamedStoredProcedureQuery("attendenceEmployeeRoutines")
								.setParameter("actionType", "getEmpListForAttendance").setParameter("actionValue", value)
								.getResultList();
						for (Object[] m : x) {
							DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
							empNameList.add(dropDownModel);
						}
						resp.setBody(empNameList);
					} catch (Exception e) {
						e.printStackTrace();
					}
					ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
							resp, HttpStatus.CREATED);
					logger.info("Method : EmployeeAutoSearch ends");
					return response;
				}
				
//
				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<Object>> viewMasterOffdaysData(String org, String orgDiv) {
					logger.info("Method : viewMasterOffdaysData  starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						String values = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

						List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
								.setParameter("actionType", "viewMasterOffdaysData").setParameter("actionValue", values).getResultList();

						if (x.size() > 0) {
							resp.setBody(x);
							resp.setCode("success");
							resp.setMessage("Data fetched successfully");
						} else {
							resp.setCode("failed");
							resp.setMessage("Data not found");
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
							HttpStatus.CREATED);

					logger.info("Method : viewMasterOffdaysData ends"+response);
					return response;
				}
				
//
				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<Object>> saveOffDaysMaster(MasterWarehouseModel data) {
					logger.info("Method : saveOffDaysMaster starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						String values = DynamicQueryBuilder.buildDynamicQuery(data);
						System.out.println("VALUES================="+values);
						if (data.getOffId() != null && data.getOffId() != "") {
							em.createNamedStoredProcedureQuery("masterDataRoutines")
									.setParameter("actionType", "modifyoffDays").setParameter("actionValue", values).execute();

							resp.setMessage("Data updated successfully");
						} else {
							
							em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "addoffDays")
									.setParameter("actionValue", values).execute();
							resp.setMessage("Data saved successfully");
						}
						resp.setCode("success");
					} catch (Exception e) {
						try {
							String[] err = serverDao.errorProcedureCall(e);
							resp.setCode("failed");
							resp.setMessage(err[1]);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						e.printStackTrace();
					}

					ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
							HttpStatus.CREATED);

					logger.info("Method : saveOffDaysMaster ends");
					return response;
				}
				
//
				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<Object>> deleteMasterOffDaysData(String id,String userId, String org,
						String orgDiv) {
					logger.info("Method : deleteMasterOffDaysData  starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						String values = "SET @p_id='" + id + "', @p_deletedBy='" + userId + "', @p_org='"
								+ org + "', @p_orgDiv='" + orgDiv + "';";
						System.out.println("values============="+values);
						em.createNamedStoredProcedureQuery("masterDataRoutines").setParameter("actionType", "deleteMasterOffDaysData")
								.setParameter("actionValue", values).execute();

						resp.setCode("success");
						resp.setMessage("Data deleted successfully");

					} catch (Exception e) {
						try {
							String[] err = serverDao.errorProcedureCall(e);
							resp.setCode("failed");
							resp.setMessage(err[1]);
						} catch (Exception e1) {
							resp.setCode("failed");
							resp.setMessage("Something went wrong");
							e1.printStackTrace();
						}
						e.printStackTrace();
					}

					ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
							HttpStatus.CREATED);

					logger.info("Method : deleteMasterOffDaysData ends"+response);
					return response;
				}
//
				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<Object>> viewHolidayList(String org, String orgDiv) {
					logger.info("Method : viewHolidayList  starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						String values = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

						List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
								.setParameter("actionType", "viewHolidayList").setParameter("actionValue", values).getResultList();

						if (x.size() > 0) {
							resp.setBody(x);
							resp.setCode("success");
							resp.setMessage("Data fetched successfully");
						} else {
							resp.setCode("failed");
							resp.setMessage("Data not found");
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
							HttpStatus.CREATED);

					logger.info("Method : viewHolidayList ends"+response);
					return response;
				}
				
				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<Object>> viewPModeList(String org, String orgDiv) {
					logger.info("Method : viewPModeList  starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						String values = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

						List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
								.setParameter("actionType", "viewPModeList").setParameter("actionValue", values).getResultList();

						if (x.size() > 0) {
							resp.setBody(x);
							resp.setCode("success");
							resp.setMessage("Data fetched successfully");
						} else {
							resp.setCode("failed");
							resp.setMessage("Data not found");
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
							HttpStatus.CREATED);

					logger.info("Method : viewPModeList ends"+response);
					return response;
				}
				
				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<Object>> viewSac(String org, String orgDiv) {
					logger.info("Method : viewSac  starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						String values = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

						List<Object[]> x = em.createNamedStoredProcedureQuery("masterDataRoutines")
								.setParameter("actionType", "viewSac").setParameter("actionValue", values).getResultList();

						if (x.size() > 0) {
							resp.setBody(x);
							resp.setCode("success");
							resp.setMessage("Data fetched successfully");
						} else {
							resp.setCode("failed");
							resp.setMessage("Data not found");
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
							HttpStatus.CREATED);

					logger.info("Method : viewSac ends"+response);
					return response;
				}
}
