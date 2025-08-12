package nirmalya.aatithya.restmodule.vms.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.time.LocalDate;

import com.google.gson.reflect.TypeToken;

import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RestTenderManagementDao {
	Logger logger = LoggerFactory.getLogger(RestTenderManagementDao.class);
	@Autowired
	ServerDao serverDao;
	@PersistenceContext
	private EntityManager em;

	/* Added By Pankaj */
	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveTender(String data, String userId, String org, String orgDiv) {
		logger.info("method: saveTender Starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			// Parse the JSON data
			JSONObject jsonData = new JSONObject(data);
			String templateId = jsonData.optString("templateId", null);
			String templateDescription = jsonData.optString("templateDescription", null);
			String templateName = jsonData.optString("templateName", null);
			String creationDate = jsonData.optString("creationDate", null);
			String effectiveDate = jsonData.optString("effectiveDate", null);
			String status = jsonData.optString("status", null);

			JSONArray sectionsArray = jsonData.optJSONArray("sections");
			JSONArray criteriaArray = jsonData.optJSONArray("criteria");

			// Determine action type based on the presence of templateId
			String actionType = (templateId != null && !templateId.isEmpty()) ? "modifyTenderData" : "addTenderData";

			if ("addTenderData".equals(actionType)) {
				// Get next Tender ID
				String getNextTenderIdSQL = "SELECT FN_GET_PREFIX('tbl_vms_tender_mstr', COALESCE(MAX(TDM_Tender_Id), 0), 'Tender', '') FROM tbl_vms_tender_mstr";
				String nextTenderId = (String) em.createNativeQuery(getNextTenderIdSQL).getSingleResult();
				System.out.println("Next Tender Id-->" + nextTenderId);
				String[] ids = nextTenderId.split("/");
				LocalDate currentDate = LocalDate.now();
				int year = currentDate.getYear();
				String updatedTenderId = ids[0] + "/" + year + "/" + ids[1];
				System.out.println(updatedTenderId);

				String insertTenderSQL = "INSERT INTO tbl_vms_tender_mstr (TDM_Tender_Id, TDM_Tender_Name, "
						+ "TDM_Tender_Description, TDM_Tender_CreatedDate, TDM_Tender_EffectiveDate, TDM_Tender_Status, "
						+ "TDM_Tender_CreatedBy, TOD_Org_Name, TOD_Org_Division) VALUES (:tenderId, :templateName, :templateDescription, :creationDate, :effectiveDate, :status, :userId, :org, :orgDiv)";

				em.createNativeQuery(insertTenderSQL).setParameter("tenderId", updatedTenderId)
						.setParameter("templateName", templateName)
						.setParameter("templateDescription", templateDescription)
						.setParameter("creationDate", creationDate).setParameter("effectiveDate", effectiveDate)
						.setParameter("status", status).setParameter("userId", userId).setParameter("org", org)
						.setParameter("orgDiv", orgDiv).executeUpdate();

				String getNextAuditLogIdSQL = "SELECT FN_GET_PREFIX('tbl_vms_audit_trail', COALESCE(MAX(TVAT_AUDIT_ID), 0), 'AuditTrail', '') FROM tbl_vms_audit_trail";
				String nextAuditLogId = (String) em.createNativeQuery(getNextAuditLogIdSQL).getSingleResult();

				String insertAuditTrailSQL = "INSERT INTO tbl_vms_audit_trail (TVAT_AUDIT_ID, TVAT_AUDIT_ENTITY_TYPE, TVAT_AUDIT_ENTITY_ID, "
						+ "TVAT_AUDIT_ACTION, TVAT_AUDIT_CREATEDBY, TVAT_AUDIT_CREATEDON) "
						+ "VALUES (:auditTrailId, :entityType, :entityId, :action, :userId, :creationDate)";

				em.createNativeQuery(insertAuditTrailSQL).setParameter("auditTrailId", nextAuditLogId)
						.setParameter("entityType", "Tender").setParameter("entityId", updatedTenderId)
						.setParameter("action", "Created").setParameter("userId", userId)
						.setParameter("creationDate", creationDate).executeUpdate();

				if (sectionsArray != null) {

					for (int i = 0; i < sectionsArray.length(); i++) {
						JSONObject section = sectionsArray.getJSONObject(i);
						String sectionName = section.optString("name", null);
						String sectionDescription = section.optString("description", null);

						String getNextSectionIdSQL = "SELECT FN_GET_PREFIX('tbl_vms_tender_section_data', COALESCE(MAX(TDS_Section_Id), 0), 'Tender-Section', '') FROM tbl_vms_tender_section_data";
						String nextSectionId = (String) em.createNativeQuery(getNextSectionIdSQL).getSingleResult();

						String insertSectionSQL = "INSERT INTO tbl_vms_tender_section_data (TDS_Section_Id, TDS_Tender_Id, "
								+ "TDS_Section_Name, TDS_Section_Description) VALUES (:sectionId, :tenderId, :sectionName, :sectionDescription)";

						em.createNativeQuery(insertSectionSQL).setParameter("sectionId", nextSectionId)
								.setParameter("tenderId", updatedTenderId).setParameter("sectionName", sectionName)
								.setParameter("sectionDescription", sectionDescription).executeUpdate();
					}
				}

				if (criteriaArray != null) {
					for (int i = 0; i < criteriaArray.length(); i++) {
						JSONObject criteria = criteriaArray.getJSONObject(i);
						String criteriaName = criteria.optString("name", null);
						String criteriaDescription = criteria.optString("description", null);

						String getNextSectionIdSQL1 = "SELECT FN_GET_PREFIX('tbl_vms_tender_section_data', COALESCE(MAX(TDS_Section_Id), 0), 'Tender-Section', '') FROM tbl_vms_tender_section_data";
						String nextSectionId1 = (String) em.createNativeQuery(getNextSectionIdSQL1).getSingleResult();

						String insertCriteriaSQL = "INSERT INTO tbl_vms_tender_section_data (TDS_Section_Id, TDS_Tender_Id, "
								+ "TDS_Section_Name, TDS_Section_Description) VALUES (:sectionId, :tenderId, :criteriaName, :criteriaDescription)";

						em.createNativeQuery(insertCriteriaSQL).setParameter("sectionId", nextSectionId1)
								.setParameter("tenderId", updatedTenderId).setParameter("criteriaName", criteriaName)
								.setParameter("criteriaDescription", criteriaDescription).executeUpdate();
					}
				}

				resp.setMessage("Tender Created Successfully!");
				resp.setCode("Success");

			} else if ("modifyTenderData".equals(actionType)) {
				resp.setMessage("Tender Modified Successfully!");
				resp.setCode("Success");
			}

		} catch (Exception e) {
			logger.error("Error while saving tender", e);
			resp.setCode("Failed");
			resp.setMessage("Oops! Something Went Wrong: " + e.getMessage());
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveTender Ends");
		return response;
	}

	/*
	 * public ResponseEntity<JsonResponse<Object>> saveTender(String data, String
	 * userId, String org, String orgDiv) {
	 * logger.info("method: saveTender Starts");
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<Object>();
	 * 
	 * try { JSONObject jsonData = new JSONObject(data); String templateId =
	 * jsonData.optString("templateId", null); String templateDescription =
	 * jsonData.getString("templateDescription");
	 * 
	 * String actionType = (templateId != null && !templateId.isEmpty()) ?
	 * "modifyTenderData" : "addTenderData";
	 * 
	 * String values = "SET @p_userId='" + userId + "',@p_org='" + org +
	 * "',@p_orgDiv='" + orgDiv + "',@p_jsonData='" + data +
	 * "',@p_templateDescription='" + templateDescription + "';";
	 * System.out.println(values);
	 * em.createNamedStoredProcedureQuery("vms_tender_routines").setParameter(
	 * "actionType", actionType) .setParameter("actionValue", values).execute();
	 * 
	 * resp.setMessage( "Tender " + (actionType.equals("modifyTenderData") ?
	 * "Modified" : "Created") + " Successfully!"); resp.setCode("Success");
	 * 
	 * } catch (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
	 * resp.setCode("Failed"); resp.setMessage("Oops! Something Went Wrong");
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); }
	 * e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp,
	 * HttpStatus.CREATED);
	 * 
	 * logger.info("method: saveTender Ends"); return response; }
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTenderDetails(String org, String orgDiv, String userId, String fromDate,
			String toDate) {
		logger.info("Method : getTenderDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @org='" + org + "', @org_div='" + orgDiv + "',@userId='" + userId + "',@p_frommDate= '"
				+ fromDate + "',@p_toDate='" + toDate + "';";
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("vms_tender_routines")
					.setParameter("actionType", "getTenders").setParameter("actionValue", value).getResultList();

			if (x.size() > 0 && x.get(0) != null) {
				resp.setBody(x.get(0));
				resp.setMessage("Tenders fetched successfully.");
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

		logger.info("Method : getTenderDetails Dao ends");
		return resp;
	}

	/*
	 * public ResponseEntity<JsonResponse<Object>> updateTenderData(String data,
	 * String userId, String org, String orgDiv) {
	 * logger.info("method: updateTenderData Starts");
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<Object>();
	 * 
	 * try { String values = "SET @p_userId='" + userId + "',@p_org='" + org +
	 * "',@p_orgDiv='" + orgDiv + "',@p_jsonData='" + data + "';";
	 * System.out.println(values);
	 * em.createNamedStoredProcedureQuery("vms_tender_routines").setParameter(
	 * "actionType", "updateTenderData") .setParameter("actionValue",
	 * values).execute();
	 * 
	 * resp.setMessage("Tender Updated Successfully!"); resp.setCode("Success");
	 * 
	 * } catch (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
	 * resp.setCode("Failed"); resp.setMessage("Oops! Something Went Wrong");
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); }
	 * e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp,
	 * HttpStatus.CREATED);
	 * 
	 * logger.info("method: updateTenderData Ends"); return response; }
	 */

	@Transactional
	public ResponseEntity<JsonResponse<Object>> updateTenderData(String data, String userId, String org,
			String orgDiv) {
		logger.info("method: updateTenderData Starts");

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

				// Escaping single quotes in the content data
				contents = contents.replace("'", "''");

				// Using parameterized query instead of String.format
				Query query = em.createNativeQuery("UPDATE tbl_vms_tender_section_data "
						+ "SET TDS_Section_Status = ?, TDS_Section_User = ?, TDS_Section_Data = ? "
						+ "WHERE TDS_Section_Id = ?");

				query.setParameter(1, sectionStatus);
				query.setParameter(2, users);
				query.setParameter(3, contents);
				query.setParameter(4, sectionNo);

				query.executeUpdate();
			}

			resp.setMessage("Tender Updated Successfully!");
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

		logger.info("method: updateTenderData Ends");
		return response;
	}

	@Transactional
	public ResponseEntity<JsonResponse<Object>> updateCriteriaTenderData(String criteriaData, String userId, String org,
			String orgDiv) {
		logger.info("method: updateCriteriaTenderData Starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			Gson gson = new Gson();

			Type listType = new TypeToken<List<Map<String, String>>>() {
			}.getType();
			List<Map<String, String>> criteriaList = gson.fromJson(criteriaData, listType);

			for (Map<String, String> criteriaItem : criteriaList) {
				String tenderId = criteriaItem.get("tenderId");
				String criteria = criteriaItem.get("criteria");
				String description = criteriaItem.get("description");
				String score = criteriaItem.get("score");

				String sectionIdQuerry = "select TDS_Section_Id from tbl_vms_tender_section_data where TDS_Tender_Id = '"
						+ tenderId + "' And TDS_Section_Name = 'Criteria' limit 1";
				String sectionId = (String) em.createNativeQuery(sectionIdQuerry).getSingleResult();
				String insertQuery = "INSERT INTO tbl_vms_tender_criteria_data (TDC_Section_Id, TDC_Tender_Id, TDC_Criteria_Name, TDC_Criteria_Data, TDC_Criteria_Score) "
						+ "VALUES (?1, ?2, ?3, ?4, ?5)";

				em.createNativeQuery(insertQuery).setParameter(1, sectionId).setParameter(2, tenderId)
						.setParameter(3, criteria).setParameter(4, description).setParameter(5, score).executeUpdate();
			}

			resp.setMessage("Criteria Added Successfully!");
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

		logger.info("method: updateCriteriaTenderData Ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveTenderPdf(String filePath, String tenderId, String userId) {
		logger.info("Method : saveTenderPdf Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @filePath='" + filePath + "', @tenderId='" + tenderId + "',@p_userId='" + userId + "';";
		logger.info(value);
		System.out.println(value);
		try {
			em.createNamedStoredProcedureQuery("vms_tender_routines").setParameter("actionType", "saveTenderPdf")
					.setParameter("actionValue", value).execute();
			resp.setMessage("Pdf Save successfully.");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : saveTenderPdf Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllTendersData(String org, String orgDiv, String userId, String status) {
		logger.info("Method : getAllTendersData For Vendor Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @org='" + org + "', @org_div='" + orgDiv + "',@userId='" + userId + "',@tenderStatus='"
				+ status + "';";
		System.out.println(value);
		try {

			if (status.equals("vendor")) {
				System.out.println("If");
				List<Object> x = em.createNamedStoredProcedureQuery("vms_tender_routines")
						.setParameter("actionType", "get-applied-tenders").setParameter("actionValue", value)
						.getResultList();

				if (x.size() > 0 && x.get(0) != null) {
					resp.setBody(x.get(0));
					resp.setMessage("Tenders fetched successfully.");
					resp.setCode("Success");
				} else {
					resp.setMessage("No data found.");
					resp.setCode("Failed");
				}

			} else {
				System.out.println("else");
				List<Object> x = em.createNamedStoredProcedureQuery("vms_tender_routines")
						.setParameter("actionType", "get-tenders-for-vendors").setParameter("actionValue", value)
						.getResultList();

				if (x.size() > 0 && x.get(0) != null) {
					resp.setBody(x.get(0));
					resp.setMessage("Tenders fetched successfully.");
					resp.setCode("Success");
				} else {
					resp.setMessage("No data found.");
					resp.setCode("Failed");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : getAllTendersData For Vendor Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllAppliedVendorData(String org, String orgDiv, String userId, String tenderId,
			String status) {
		logger.info("Method : getAllAppliedVendorData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @org='" + org + "', @org_div='" + orgDiv + "',@userId='" + userId + "',@tenderId='"
				+ tenderId + "',@status='" + status + "';";

		logger.info("values is --->" + value);
		try {
			if (status.equals("applied-vendors")) {
				List<Object> x = em.createNamedStoredProcedureQuery("vms_tender_routines")
						.setParameter("actionType", "get-vendor-data").setParameter("actionValue", value)
						.getResultList();

				if (x.size() > 0 && x.get(0) != null) {
					resp.setBody(x.get(0));
					resp.setMessage("Data fetched successfully.");
					resp.setCode("Success");
				} else {
					resp.setMessage("No data found.");
					
					resp.setCode("Failed");
				}
			} else if (status.equals("awarded-vendors")) {
				List<Object> x = em.createNamedStoredProcedureQuery("vms_tender_routines")
						.setParameter("actionType", "get-awarded-vendor-data").setParameter("actionValue", value)
						.getResultList();

				if (x.size() > 0 && x.get(0) != null) {
					resp.setBody(x.get(0));
					resp.setMessage("Data fetched successfully.");
					resp.setCode("Success");
				} else {
					resp.setMessage("No data found.");
					resp.setCode("Failed");
				}
			} else {
				resp.setMessage("Something went wrong!");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : getAllAppliedVendorData Dao ends");
		return resp;
	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Transactional public ResponseEntity<JsonResponse<Object>>
	 * saveVenderActivity(String data, String userId, String org, String orgDiv) {
	 * logger.info("method: saveVenderActivity Starts");
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<>(); String value =
	 * "SET @json_data='" + data + "', @userId='" + userId + "';";
	 * 
	 * try { Gson gson = new Gson(); Type type = new TypeToken<Map<String,
	 * Object>>() { }.getType(); Map<String, Object> jsonData = gson.fromJson(data,
	 * type);
	 * 
	 * String applicationFee = (String) jsonData.get("applicationFee"); String
	 * applicationFeeType = (String) jsonData.get("applicationFeeType"); String
	 * tenderId = (String) jsonData.get("tenderId"); String technicalFile = "";
	 * String technicalDescription = ""; String financialFile = ""; String
	 * financialDescription = "";
	 * 
	 * Map<String, String> technicalProposalData = (Map<String, String>)
	 * jsonData.get("technicalProposalData"); if (technicalProposalData != null) {
	 * technicalFile = technicalProposalData.get("technicalFile");
	 * technicalDescription = sanitize(technicalProposalData.get("description")); }
	 * 
	 * Map<String, String> financialProposalData = (Map<String, String>)
	 * jsonData.get("financialProposalData"); if (financialProposalData != null) {
	 * financialFile = financialProposalData.get("financialFile");
	 * financialDescription = sanitize(financialProposalData.get("description")); }
	 * 
	 * String insertQuery =
	 * "INSERT INTO tbl_vms_tender_application_dtls (Tender_Id, Vendor_Id, Financial_Desc, Financial_Doc, Technical_Desc,Technical_Doc,Quotation_Price,Quotation_Price_Type) "
	 * + "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)";
	 * 
	 * em.createNativeQuery(insertQuery).setParameter(1, tenderId).setParameter(2,
	 * userId) .setParameter(3, financialDescription).setParameter(4,
	 * financialFile).setParameter(5, technicalDescription) .setParameter(6,
	 * technicalFile).setParameter(7, applicationFee).setParameter(8,
	 * applicationFeeType) .executeUpdate();
	 * 
	 * List<Map<String, Object>> criteriaData = (List<Map<String, Object>>)
	 * jsonData.get("criteriaData"); if (criteriaData != null) { for (Map<String,
	 * Object> criteriaItem : criteriaData) { String criteriaId = (String)
	 * criteriaItem.get("criteriaId"); Boolean status = (Boolean)
	 * criteriaItem.get("toggle"); String documentName = (String)
	 * criteriaItem.get("documentName");
	 * 
	 * String applicationQuery =
	 * "INSERT INTO tbl_vms_document_tender_application_dtls (Vendor_Id, Tender_Id, Criteria_Id, Document, Acceptance_Status) "
	 * + "VALUES (?1, ?2, ?3, ?4, ?5)";
	 * em.createNativeQuery(applicationQuery).setParameter(1,
	 * userId).setParameter(2, tenderId) .setParameter(3,
	 * criteriaId).setParameter(4, documentName).setParameter(5, status)
	 * .executeUpdate(); } }
	 * 
	 * resp.setMessage("Data saved successfully."); resp.setCode("Success"); } catch
	 * (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
	 * resp.setCode("Failed"); resp.setMessage("Oops! Something Went Wrong");
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); }
	 * e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp,
	 * HttpStatus.CREATED); logger.info("method: saveVenderActivity Ends"); return
	 * response; }
	 * 
	 * private String sanitize(String value) { if (value == null) return null; //
	 * Add your sanitization logic here, for example: return
	 * value.replaceAll("[^\\w\\s]", ""); // Example: Remove special characters }
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveVendorActivity(String data, String userId, String org,
			String orgDiv) {
		logger.info("method: saveVendorActivity Starts");

		JsonResponse<Object> response = new JsonResponse<>();

		try {
			Gson gson = new Gson();
			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();
			Map<String, Object> jsonData = gson.fromJson(data, type);

			// Extracting and sanitizing proposal data
			String tenderId = (String) jsonData.get("tenderId");
			String applicationFee = (String) jsonData.get("applicationFee");
			String applicationFeeType = (String) jsonData.get("applicationFeeType");

			String technicalFile = getOptionalFile(jsonData, "technicalProposalData", "technicalFile");

			String technicalDescription = sanitize(getOptionalDescription(jsonData, "technicalProposalData"));

			String financialFile = getOptionalFile(jsonData, "financialProposalData", "financialFile");

			String financialDescription = sanitize(getOptionalDescription(jsonData, "financialProposalData"));

			// Insert into the tender application details
			insertTenderApplicationDetails(tenderId, userId, financialDescription, financialFile, technicalDescription,
					technicalFile, applicationFee, applicationFeeType);

			// Insert criteria data
			List<Map<String, Object>> criteriaData = (List<Map<String, Object>>) jsonData.get("criteriaData");
			if (criteriaData != null) {
				for (Map<String, Object> criteriaItem : criteriaData) {
					String criteriaId = (String) criteriaItem.get("criteriaId");
					Boolean status = (Boolean) criteriaItem.get("toggle");
					String documentName = (String) criteriaItem.get("documentName");

					insertCriteriaData(userId, tenderId, criteriaId, documentName, status);
				}
			}

			response.setMessage("Data saved successfully.");
			response.setCode("Success");
		} catch (Exception e) {
			handleException(e, response);
		}

		logger.info("method: saveVendorActivity Ends");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// Helper methods

	private void insertTenderApplicationDetails(String tenderId, String userId, String financialDesc,
			String financialFile, String technicalDesc, String technicalFile, String applicationFee,
			String applicationFeeType) {
		String insertQuery = "INSERT INTO tbl_vms_tender_application_dtls (Tender_Id, Vendor_Id, Financial_Desc, Financial_Doc, Technical_Desc, Technical_Doc, Quotation_Price, Quotation_Price_Type,Tender_Status) "
				+ "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)";

		em.createNativeQuery(insertQuery).setParameter(1, tenderId).setParameter(2, userId)
				.setParameter(3, financialDesc).setParameter(4, financialFile).setParameter(5, technicalDesc)
				.setParameter(6, technicalFile).setParameter(7, applicationFee).setParameter(8, applicationFeeType)
				.setParameter(9, "1").executeUpdate();
	}

	private void insertCriteriaData(String userId, String tenderId, String criteriaId, String documentName,
			Boolean status) {
		String insertQuery = "INSERT INTO tbl_vms_document_tender_application_dtls (Vendor_Id, Tender_Id, Criteria_Id, Document, Acceptance_Status) "
				+ "VALUES (?1, ?2, ?3, ?4, ?5)";

		em.createNativeQuery(insertQuery).setParameter(1, userId).setParameter(2, tenderId).setParameter(3, criteriaId)
				.setParameter(4, documentName).setParameter(5, status).executeUpdate();
	}

	private String sanitize(String value) {
		return value == null ? "" : value.replaceAll("[^a-zA-Z0-9\\s]", "");
	}

	private String getOptionalFile(Map<String, Object> jsonData, String key, String fileKey) {
		Map<String, String> proposalData = (Map<String, String>) jsonData.get(key);
		return proposalData == null ? "" : proposalData.get(fileKey);
	}

	private String getOptionalDescription(Map<String, Object> jsonData, String key) {
		Map<String, String> proposalData = (Map<String, String>) jsonData.get(key);
		return proposalData == null ? "" : proposalData.get("description");
	}

	private void handleException(Exception e, JsonResponse<Object> response) {
		try {
			String[] err = serverDao.errorProcedureCall(e);
			response.setCode("Failed");
			response.setMessage(err[1]);
		} catch (Exception innerException) {
			innerException.printStackTrace();
		}
		e.printStackTrace();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public ResponseEntity<JsonResponse<Object>> assignVendorDetails(String data, String userId, String org,
			String orgDiv, String vendorRemarks, String cancelledVendors) {
		logger.info("method: assignVendorDetails Starts");
		System.out.println(cancelledVendors);

		JsonResponse<Object> resp = new JsonResponse<>();
		Gson gson = new Gson();
		try {
			Type listType = new TypeToken<List<Map<String, String>>>() {
			}.getType();
			List<Map<String, String>> vendorList = gson.fromJson(data, listType);

			for (Map<String, String> vendorItem : vendorList) {
				String tenderId = vendorItem.get("tenderId");
				String vendorId = vendorItem.get("vendorId");
				String technicalScore = vendorItem.get("technicalScore");
				String financialScore = vendorItem.get("financialScore");
				String totalCriteriaEvaluation = vendorItem.get("totalCriteriaEvaluation");
				String totalEvaluation = vendorItem.get("totalEvaluation");

				String encodedRemark = vendorRemarks.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'")
						.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t").replace("\b", "\\b")
						.replace("\f", "\\f");

				String value = "SET @tenderId='" + tenderId + "', @vendorId='" + vendorId + "',@technicalScore='"
						+ technicalScore + "',@financialScore='" + financialScore + "',@totalCriteriaEvaluation='"
						+ totalCriteriaEvaluation + "'" + ",@totalEvaluation='" + totalEvaluation + "',@userId='"
						+ userId + "',@org='" + org + "',@orgDiv='" + orgDiv + "',@vendorRemarks='" + encodedRemark
						+ "';";

				em.createNamedStoredProcedureQuery("vms_tender_routines")
						.setParameter("actionType", "assign-vendor-details").setParameter("actionValue", value)
						.execute();

			}

			// Fix the JSON format if necessary
			/*
			 * String formattedCancelledVendors = cancelledVendors.replace("=", "\": \"")
			 * .replace("{", "{\"") .replace("}", "\"}") .replace(", ", "\", \"");
			 * 
			 * // Fix the JSON format if necessary String formattedCancelledVendors =
			 * cancelledVendors.replace("=", "\": \"").replace("{", "{\"") .replace("}",
			 * "\"}").replace(", ", "\", \"");
			 * 
			 * System.out.println("Formatted Cancelled Vendors JSON: " +
			 * formattedCancelledVendors);
			 * 
			 * // Parse the fixed JSON string List<Map<String, String>> cancelledVendorList
			 * = gson.fromJson(formattedCancelledVendors, listType);
			 * 
			 * for (Map<String, String> cancelledVendorItem : cancelledVendorList) { String
			 * vendorId = cancelledVendorItem.get("vendorIds"); String tenderId =
			 * cancelledVendorItem.get("tenderIds");
			 * 
			 * em.createNamedStoredProcedureQuery("vms_tender_routines")
			 * .setParameter("actionType", "cancel-vendors-status")
			 * .setParameter("actionValue", cancelValue) .execute(); }
			 */

			resp.setMessage("Data save Successfully!");
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

		logger.info("method: assignVendorDetails Ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAssignUserList(String id, String orgName, String orgDivision) {
		logger.info("Method : getAssignUserList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_orgName='" + orgName + "', @p_orgDiv='" + orgDivision + "',@p_searchValue='" + id + "';";
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("vms_tender_routines")
					.setParameter("actionType", "evalutionAssignUser").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setMessage("Data fetched successfully.");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : getAssignUserList Dao ends");
		return resp;
	}

	@Transactional
	public ResponseEntity<JsonResponse<Object>> evalutionUserAdd(String compliance, String userId, String org,
			String orgDiv, String id) {
		logger.info("method: evalutionUserAdd Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @vitalData='" + compliance + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "', @p_id='" + id + "';";

			logger.info("value " + value);

			em.createNamedStoredProcedureQuery("vms_tender_routines").setParameter("actionType", "evalutionworkflowdetailsadd") //evalutionDetailsAdd
					.setParameter("actionValue", value).execute();

			resp.setMessage("Evalution Details saved successfully!");
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

		logger.info("method: evalutionUserAdd Ends");
		return response;
	}

	@Transactional
	public ResponseEntity<JsonResponse<Object>> assignUserEvalutionDetailsAdd(String evalutionDetails, String userId,
			String org, String orgDiv, String id) {
		logger.info("method: assignUserEvalutionDetailsAdd Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @evalutionData='" + evalutionDetails + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "', @p_id='" + id + "';";

			logger.info("value " + value);

			em.createNamedStoredProcedureQuery("vms_tender_routines")
					.setParameter("actionType", "vendorEvalutionDetailsAdd").setParameter("actionValue", value)
					.execute();

			resp.setMessage("Evalution Details saved successfully!");
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

		logger.info("method: assignUserEvalutionDetailsAdd Ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> fetchAppliedTenderVendors(String org, String orgDiv, String userId, String tenderId) {
		logger.info("Method : fetchAppliedTenderVendors Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @org='" + org + "', @org_div='" + orgDiv + "',@userId='" + userId + "',@tenderId='"
				+ tenderId + "';";

		logger.info("values is --->" + value);
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("vms_tender_routines")
					.setParameter("actionType", "fetchvendorlist").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setMessage("Data Fetch Successfully!");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : fetchAppliedTenderVendors Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> vendorevalutiondetails(String org, String orgDiv, String userId, String tenderId,
			String vendorId) {
		logger.info("Method : vendorevalutiondetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @org='" + org + "', @org_div='" + orgDiv + "',@userId='" + userId + "',@tenderId='"
				+ tenderId + "',@vendorId='" + vendorId + "';";

		logger.info("values is --->" + value);
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("vms_tender_routines")
					.setParameter("actionType", "getvendorevalutiondetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setMessage("Data Fetch Successfully!");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : vendorevalutiondetails Dao ends");
		return resp;
	}
	
	@Transactional
	public ResponseEntity<JsonResponse<Object>> vendortrackingstatus(String compliance, String userId, String org,
			String orgDiv) {
		logger.info("method: vendortrackingstatus Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @vitalData='" + compliance + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";

			logger.info("value " + value);

			em.createNamedStoredProcedureQuery("vms_tender_routines").setParameter("actionType", "vendortrackingstatus") 
					.setParameter("actionValue", value).execute();

			resp.setMessage("Evalution Details saved successfully!");
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

		logger.info("method: vendortrackingstatus Ends");
		return response;
	}
	
	@Transactional
	public ResponseEntity<JsonResponse<Object>> vendorAllocationDetails(String data, String userId, String org,
			String orgDiv) {
		logger.info("method: vendorAllocationDetails Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @allocationData='" + data + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";

			logger.info("value " + value);

			em.createNamedStoredProcedureQuery("vms_tender_routines").setParameter("actionType", "vendorallocationdetailsadd") 
					.setParameter("actionValue", value).execute();

			resp.setMessage("Evalution Details saved successfully!");
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

		logger.info("method: vendorAllocationDetails Ends");
		return response;
	}
}
