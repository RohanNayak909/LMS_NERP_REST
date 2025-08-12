package nirmalya.aatithya.restmodule.gatepass.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.gatePass.GenerateGatePassReportParameter;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gatepass.model.ShiftRegisterReportModel;

@Repository
public class ShiftRegisterReportDao {

	Logger logger = LoggerFactory.getLogger(ShiftRegisterReportDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	/*
	 * @SuppressWarnings("unchecked") public JsonResponse<List<DropDownModel>>
	 * getShiftLists(String orgName, String orgDivision, String userId) {
	 * logger.info("Method : getShiftLists Dao starts");
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<Object>();
	 * 
	 * try { String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision
	 * + "',@p_userId='" + userId + "';";
	 * System.out.println("values****************************" + value);
	 * List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("gate_pass_report_routines")
	 * .setParameter("actionType", "getShift").setParameter("actionValue",
	 * value).getResultList(); resp.setBody(x); } catch (Exception e) {
	 * e.printStackTrace(); } logger.info("Method : getShiftLists Dao ends");
	 * System.out.println("resp**************rrreessuulltt**************" + resp);
	 * return resp;
	 * 
	 * }
	 */
	
	// Shift List.
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getShiftLists(String org, String orgDiv, String userId) {
		logger.info("Method : getShiftLists starts");
		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		System.out.println("values****************************" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "getShiftLists").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				System.out.println("x=="+Arrays.toString(m));
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
System.out.println("getCollectionList=="+getCollectionList);
		logger.info("Method : getShiftLists ends");
		return getCollectionList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCategoryList(String orgName, String orgDivision, String shift, String date) {
		logger.info("Method : getCategoryList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		String Date = DateFormatter.getStringDate(date);
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_shift='" + shift + "',@p_date='" + Date + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "getCategoryList").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCategoryList Dao ends");
		return resp;

	}
	
	

	public ResponseEntity<JsonResponse<List<ShiftRegisterReportModel>>> saveGateReportData(
			List<ShiftRegisterReportModel> restGatePassReportModel) {
		logger.info("Method : saveGateReportData starts");
		JsonResponse<List<ShiftRegisterReportModel>> resp = new JsonResponse<List<ShiftRegisterReportModel>>();
		List<ShiftRegisterReportModel> listData = new ArrayList<ShiftRegisterReportModel>();


		try {
			String values = GenerateGatePassReportParameter.saveGateReportDataParam(restGatePassReportModel);
			if (restGatePassReportModel.get(0).getRegisterId() == null
					|| restGatePassReportModel.get(0).getRegisterId() == "") {
				System.out.println("ADDDDDDDDDDDDDDDDDDS#" + values);

				em.createNamedStoredProcedureQuery("gate_pass_report_routines")
						.setParameter("actionType", "saveGateReportData").setParameter("actionValue", values).execute();
				
				resp.setCode("success");
				resp.setMessage("Register Saved Successfully");

			} else {
				System.out.println("@modifyyyyyyyyyyyyyy" + values);

				em.createNamedStoredProcedureQuery("gate_pass_report_routines")
						.setParameter("actionType", "modifyGateReportData").setParameter("actionValue", values)
						.execute();
				
				resp.setCode("success");
				resp.setMessage("Register Modified Successfully");


			}

			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<ShiftRegisterReportModel>>> response = new ResponseEntity<JsonResponse<List<ShiftRegisterReportModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveGateReportData ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewReportData(String orgName, String orgDivision) {
		logger.info("Method : viewReportData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "viewReportData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewReportData Dao ends");
		return resp;

	}


	// Emp List.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> empListData(String orgName, String orgDivision, String empCategory) {
		logger.info("Method : empListData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_empCategory='" + empCategory + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "empListData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : empListData Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editReportData(String id, String orgName, String orgDivision) {
		logger.info("Method : editReportData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_registerId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "editReportData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editReportData Dao ends");
		return resp;
	}

	public JsonResponse<Object> deleteReport(String registerId, String orgName, String orgDiv) {
		logger.info("Method : deleteAllocationdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_registerId='" + registerId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("gate_pass_report_routines").setParameter("actionType", "deleteReport")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Deleted Successfully");
			// resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : deleteReport Dao ends");
		return resp;

	}

	public JsonResponse<Object> approveReportdata(String registerId, String orgName, String orgDiv) {
		logger.info("Method : approveReportdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_registerId='" + registerId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "approveReportdata").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Approved Successfully");
			// resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approveReportdata Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getReportPdfDetails(String registerId, String orgName, String orgDivision) {
		logger.info("Method : getReportPdfDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_registerId='" + registerId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "';";

			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "getReportPdfDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getReportPdfDetails Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCategoryAutoSearchListForItem(String id) {
		logger.info("Method : getReportPdfDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_searchValue='" + id + "';";

			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "getCategoryAutoSearchListForItem").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCategoryAutoSearchListForItem Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getManPowerAutoSearchListForItem(String id) {
		logger.info("Method : getManPowerAutoSearchListForItem Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_searchValue='" + id + "';";

			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "getManPowerAutoSearchListForItem").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getManPowerAutoSearchListForItem Dao ends");
		return resp;
	}
	
	public JsonResponse<Object> addCategories(String categories, String type,String shift,String orgName, String orgDiv) {
		logger.info("Method : addNewCategoriesdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_categories='" + categories + "',@p_type='" + type + "',@p_shift='" + shift + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "addCategories").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Categories Added Successfully");
			// resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : addNewCategoriesdata Dao ends");
		return resp;

	}
	
	// Delete Category.
	
	public JsonResponse<Object> deleteCategory(String orgName, String orgDivision, String id) {
		logger.info("Method : deleteCategory Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			System.out.println("values****************************" + value);
			 em.createNamedStoredProcedureQuery("gate_pass_report_routines")
					.setParameter("actionType", "deleteCategory").setParameter("actionValue", value).execute();
			
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : deleteCategory Dao ends");
		return resp;

	}

}
