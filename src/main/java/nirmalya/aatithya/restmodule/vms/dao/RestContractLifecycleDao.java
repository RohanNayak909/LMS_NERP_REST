package nirmalya.aatithya.restmodule.vms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.time.LocalDate;

import com.google.gson.reflect.TypeToken;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RestContractLifecycleDao {

	Logger logger = LoggerFactory.getLogger(RestContractLifecycleDao.class);
	@Autowired
	ServerDao serverDao;
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPolicyList(String org, String orgDiv) {
		logger.info("Method : getPolicyList starts");
		List<DropDownModel> userList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("Value is coming For dropDown============> " + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vms_contract_routines")
					.setParameter("actionType", "getTenderList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				userList.add(dropDownModel);
			}

			System.out.println(userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPolicyList ends");
		System.out.println("Policy List =====>" + userList);
		return userList;
	}

	// saveContract
	@Transactional
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveContract(String data, String userId, String org, String orgDiv) {
		logger.info("method: saveContractData Dao Starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		// List<String> vendorIds = new ArrayList<>();

		try {
			// Parse the JSON data
			JSONObject jsonData = new JSONObject(data);
			String tenderId = jsonData.optString("tenderId", null);
			String vendorId = jsonData.optString("vendorId", null);
			String templateId = jsonData.optString("templateId", null);
			String templateDescription = jsonData.optString("templateDescription", null);
			String templateName = jsonData.optString("templateName", null);
			String creationDate = jsonData.optString("creationDate", null);
			String effectiveDate = jsonData.optString("effectiveDate", null);
			String status = jsonData.optString("status", null);

			JSONArray sectionsArray = jsonData.optJSONArray("sections");

			// Determine action type based on presence of templateId
			String actionType = (templateId != null && !templateId.isEmpty()) ? "modifyContractData"
					: "addContractData";

//			try {
//
//				String value = "SET @p_tenderId='" + tenderId + "';";
//
//				logger.info("Tender_Id============> " + value);
//
//				List<Object[]> x = em.createNamedStoredProcedureQuery("vms_contract_routines")
//						.setParameter("actionType", "getVendorList").setParameter("actionValue", value).getResultList();
//
//				for (Object[] row : x) {
//					vendorIds.add((String) row[0]);
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

			if ("addContractData".equals(actionType)) {
				// Get next Contract ID
				String getNextContractIdSQL = "SELECT FN_GET_PREFIX('tbl_vms_contract_mstr', COALESCE(MAX(TCM_CONTRACT_Id), 0), 'Contract', '') FROM tbl_vms_contract_mstr";
				String nextContractId = (String) em.createNativeQuery(getNextContractIdSQL).getSingleResult();
				System.out.println("Next Tender Id-->" + nextContractId);
				String[] ids = nextContractId.split("/");
				LocalDate currentDate = LocalDate.now();
				int year = currentDate.getYear();
				String updatedTenderId = ids[0] + "/" + year + "/" + ids[2];
				System.out.println(updatedTenderId);
				nextContractId = updatedTenderId; 
				
				
				
				
				

				/*
				 * System.out.println("Next Tender Id-->" + nextContractId); String[] ids =
				 * nextContractId.split("/"); LocalDate currentDate = LocalDate.now(); int year
				 * = currentDate.getYear(); String updatedId = ids[0] + "/" + year + "/" +	
				 * ids[1]; System.out.println(updatedId);
				 * 
				 * nextContractId = updatedId;
				 */

				// Insert Contract Data into tbl_vms_contract_mstr
				String insertContractSQL = "INSERT INTO tbl_vms_contract_mstr (TCM_CONTRACT_Id,TCM_TENDER_Id,TCM_VENDOR_Id,TCM_CONTRACT_Name, "
						+ "TCM_CONTRACT_Description, TCM_CONTRACT_CreatedDate, TCM_CONTRACT_EffectiveDate, TCM_CONTRACT_Status, "
						+ "TCM_CONTRACT_CreatedBy) VALUES (:contractId, :tenderId,:vendorId,:templateName, :templateDescription, :creationDate, :effectiveDate, :status, :userId)";

				em.createNativeQuery(insertContractSQL).setParameter("contractId", nextContractId)
						.setParameter("tenderId", tenderId).setParameter("vendorId", vendorId)
						.setParameter("templateName", templateName)
						.setParameter("templateDescription", templateDescription)
						.setParameter("creationDate", creationDate).setParameter("effectiveDate", effectiveDate)
						.setParameter("status", status).setParameter("userId", userId).executeUpdate();

				// Get next Audit Trail ID
				String getNextAuditLogIdSQL = "SELECT FN_GET_PREFIX('tbl_vms_audit_trail', COALESCE(MAX(TVAT_AUDIT_ID), 0), 'AuditTrail', '') FROM tbl_vms_audit_trail";
				String nextAuditLogId = (String) em.createNativeQuery(getNextAuditLogIdSQL).getSingleResult();

				// Insert data into tbl_vms_audit_trail
				String insertAuditTrailSQL = "INSERT INTO tbl_vms_audit_trail (TVAT_AUDIT_ID, TVAT_AUDIT_ENTITY_TYPE, TVAT_AUDIT_ENTITY_ID, "
						+ "TVAT_AUDIT_ACTION, TVAT_AUDIT_CREATEDBY, TVAT_AUDIT_CREATEDON) "
						+ "VALUES (:auditTrailId, :entityType, :entityId, :action, :userId, :creationDate)";

				em.createNativeQuery(insertAuditTrailSQL).setParameter("auditTrailId", nextAuditLogId)
						.setParameter("entityType", "Contract").setParameter("entityId", nextContractId)
						.setParameter("action", "Created").setParameter("userId", userId)
						.setParameter("creationDate", creationDate).executeUpdate();

				// Insert Section Data into tbl_vms_tender_section_data

				if (sectionsArray != null) {

					for (int i = 0; i < sectionsArray.length(); i++) {
						JSONObject section = sectionsArray.getJSONObject(i);
						String sectionName = section.optString("name", null);
						String sectionDescription = section.optString("description", null);

						String getNextSectionIdSQL = "SELECT FN_GET_PREFIX('tbl_vms_contract_section_data', COALESCE(MAX(TCM_Section_Id), 0), 'Contract-Section', '') FROM tbl_vms_contract_section_data";
						String nextSectionId = (String) em.createNativeQuery(getNextSectionIdSQL).getSingleResult();

						String insertSectionSQL = "INSERT INTO tbl_vms_contract_section_data (TCM_Section_Id, TCM_Contract_Id, "
								+ "TCM_Section_Name, TCM_Section_Description) VALUES (:sectionId, :contractId, :sectionName, :sectionDescription)";

						em.createNativeQuery(insertSectionSQL).setParameter("sectionId", nextSectionId)
								.setParameter("contractId", nextContractId).setParameter("sectionName", sectionName)
								.setParameter("sectionDescription", sectionDescription).executeUpdate();

					}
				}

				resp.setMessage("Contract Created Successfully!");
				resp.setCode("Success");

				// calling procedure to insert into notification table
//				try {
//					String vendorIdsStr = vendorIds.toString().trim();
//
//					if (vendorIdsStr.startsWith("[") && vendorIdsStr.endsWith("]")) {
//						String[] vendorIdArray = vendorIdsStr.replace("[", "").replace("]", "").split(",");
//						for (String vendorId : vendorIdArray) {
//							vendorId = vendorId.trim();
//
//							String values = "SET @p_tenderId='" + tenderId + "',@p_vendorIds='" + vendorId
//									+ "',@p_userId='" + userId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
//
//							System.out.println("Inserting for Vendor: " + vendorId);
//							System.out.println("Values: " + values);
//
//							em.createNamedStoredProcedureQuery("vms_contract_routines")
//									.setParameter("actionType", "addContNootifi").setParameter("actionValue", values)
//									.execute();
//						}
//					} else {
//						System.out.println("Invalid vendorIds format: " + vendorIdsStr);
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}

				// sending notification to vendor on contract creation
				try {

					String values = "SET @p_tenderId='" + tenderId + "',@p_vendorIds='" + vendorId + "',@p_userId='"
							+ userId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

					em.createNamedStoredProcedureQuery("vms_contract_routines")
							.setParameter("actionType", "addContNootifi").setParameter("actionValue", values).execute();

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if ("modifyContractData".equals(actionType)) {

				// Update existing Contract
				String updateContractSQL = "UPDATE tbl_vms_contract_mstr SET TCM_CONTRACT_Name = :templateName, "
						+ "TCM_CONTRACT_Description = :templateDescription, TCM_CONTRACT_EffectiveDate = :effectiveDate, "
						+ "TCM_CONTRACT_Status = :status WHERE TCM_CONTRACT_Id = :templateId";

				em.createNativeQuery(updateContractSQL).setParameter("templateName", templateName)
						.setParameter("templateDescription", templateDescription)
						.setParameter("effectiveDate", effectiveDate).setParameter("status", status)
						.setParameter("templateId", templateId).executeUpdate();

				resp.setMessage("Contract Modified Successfully!");
				resp.setCode("Success");
			}

		} catch (Exception e) {
			logger.error("Error while saving contract", e);
			resp.setCode("Failed");
			resp.setMessage("Oops! Something Went Wrong: " + e.getMessage());
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveContractData Dao Ends");
		return response;
	}

	// getContractDetails
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getContractDetails(String org, String orgDiv, String userId, String fromDate,
			String toDate) {
		logger.info("Method : getContractDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @org='" + org + "', @org_div='" + orgDiv + "',@userId='" + userId + "',@p_fromDate='"
				+ fromDate + "',@p_toDate='" + toDate + "';";
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("vms_contract_routines")
					.setParameter("actionType", "getContract").setParameter("actionValue", value).getResultList();

			if (x.size() > 0 && x.get(0) != null) {
				resp.setBody(x.get(0));
				resp.setMessage("Contract fetched successfully.");
				resp.setCode("Success");
			} else {
				resp.setMessage("No data found.");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : getContractDetails Dao ends");
		return resp;
	}

	// updateContractData

	@Transactional
	public ResponseEntity<JsonResponse<Object>> updateContractData(String data, String userId, String org,
			String orgDiv) {
		logger.info("method: updateContractData Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		Gson gson = new Gson();

		try {
			Type listType = new TypeToken<List<Map<String, String>>>() {
			}.getType();
			List<Map<String, String>> sectionList = gson.fromJson(data, listType);

			for (Map<String, String> sectionItem : sectionList) {
				String sectionNo = sectionItem.get("sectionNo");
				String sectionStatus = sectionItem.get("sectionStatus");
				String users = sectionItem.get("users");
				String contents = sectionItem.get("data");

				String updateQuery = String.format("UPDATE tbl_vms_contract_section_data "
						+ "SET TCM_Section_Status = '%s', TCM_Section_User = '%s', TCM_Section_Data = '%s' "
						+ "WHERE TCM_Section_Id = '%s'", sectionStatus, users, contents, sectionNo);
				em.createNativeQuery(updateQuery).executeUpdate();
			}

			resp.setMessage("Contract Updated Successfully!");
			resp.setCode("Success");

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage("Oops! Something Went Wrong");
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: updateContractData Ends");
		return response;
	}

	// saveContractPdf
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveContractPdf(String filePath, String contractIds, String userId, String org,
			String orgDiv, String vendor) {
		logger.info("Method : saveContractPdf Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @filePath='" + filePath + "', @contractIds='" + contractIds + "',@p_userId='" + userId
				+ "',@p_org='" + org + "',@p_orgDiv= '" + orgDiv + "',@p_vendorId='" + vendor + "';";
		System.out.println("value is coming for ==================> " + value);
		try {
			em.createNamedStoredProcedureQuery("vms_contract_routines").setParameter("actionType", "saveContractPdf")
					.setParameter("actionValue", value).execute();
			resp.setMessage("Pdf Save successfully.");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : saveContractPdf Dao ends");
		return resp;
	}

	// getVendorList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorLists(String id) {

		logger.info("Method : getVendorList starts");
		List<DropDownModel> getVendorList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tenderId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vms_contract_routines")
					.setParameter("actionType", "getVendorLists").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getVendorList.add(dropDownModel);
			}

			resp.setBody(getVendorList);
			resp.setCode("Success");
			resp.setMessage("Vendor List Fetched Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.OK);

		logger.info("Method : getcuststateListNew ends" + resp);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> geContractVersionDetails(String contractId, String vendorId, String userId) {
		logger.info("Method : geContractVersionDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @contractId='" + contractId + "',@vendorId='" + vendorId + "',@userId='" + userId + "';";
		logger.info("Value is coming For geContractVersionDetails============> " + value);
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("vms_contract_routines")
					.setParameter("actionType", "geContractVerDetails").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0 && x.get(0) != null) {
				resp.setBody(x.get(0));
				resp.setMessage("Data Fetched Successfully.");
				resp.setCode("Success");
			} else {
				resp.setMessage("No data found.");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : geContractVersionDetails Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAssignApproveUser(String org, String orgDiv, String userId) {
		logger.info("Method : getAssignApproveUser Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @org='" + org + "', @org_div='" + orgDiv + "',@userId='" + userId + "';";
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("vms_contract_routines")
					.setParameter("actionType", "getAssignApproveUser").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0 && x.get(0) != null) {
				resp.setBody(x.get(0));
				resp.setMessage("Assign User Fetch successfully.");
				resp.setCode("Success");
			} else {
				resp.setMessage("No data found.");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : getAssignApproveUser Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> contractApproval(String org, String orgDiv, String userId, String id) {
		logger.info("Method : contractApproval Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @org='" + org + "', @org_div='" + orgDiv + "',@userId='" + userId + "',@contractid='" + id
				+ "';";
		logger.info("valuess--->" + value);

		try {
			em.createNamedStoredProcedureQuery("vms_contract_routines").setParameter("actionType", "approvecontract")
					.setParameter("actionValue", value).execute();
			resp.setMessage("Contract Approved Successfully.");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : contractApproval Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getApprovedContract(String org, String orgDiv, String userId, String fromDate,
			String toDate) {
		logger.info("Method : getApprovedContract Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @org='" + org + "', @org_div='" + orgDiv + "',@userId='" + userId + "',@p_fromDate='"
				+ fromDate + "',@p_toDate='" + toDate + "';";
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("vms_contract_routines")
					.setParameter("actionType", "getApprovedContract").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0 && x.get(0) != null) {
				resp.setBody(x.get(0));
				resp.setMessage("Contract fetched successfully.");
				resp.setCode("Success");
			} else {
				resp.setMessage("No data found.");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : getApprovedContract Dao ends");
		return resp;
	}


	@Transactional
	public ResponseEntity<JsonResponse<Object>> complianceadd(String compliance, String userId, String org,
			String orgDiv) {
		logger.info("method: complianceadd Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @vitalData='" + compliance + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";


			logger.info("value " + value);

			em.createNamedStoredProcedureQuery("vms_contract_routines").setParameter("actionType", "complianceadd")
					.setParameter("actionValue", value).execute();

			resp.setMessage("Compliance saved successfully!");
			resp.setCode("Success");


		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception nestedException) {
				logger.error("Error while handling exception: ", nestedException);
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: complianceadd Ends");
		return response;
	}
	
	
	
	@Transactional
	public ResponseEntity<JsonResponse<Object>> riskAssesmentAdd(String compliance, String userId, String org,
			String orgDiv) {
		logger.info("method: riskAssesmentAdd Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @vitalData='" + compliance + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";


			logger.info("value " + value);

			em.createNamedStoredProcedureQuery("vms_contract_routines").setParameter("actionType", "riskadd")
					.setParameter("actionValue", value).execute();

			resp.setMessage("Risk  saved successfully!");
			resp.setCode("Success");


		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception nestedException) {
				logger.error("Error while handling exception: ", nestedException);
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: riskAssesmentAdd Ends");
		return response;
	}

}
