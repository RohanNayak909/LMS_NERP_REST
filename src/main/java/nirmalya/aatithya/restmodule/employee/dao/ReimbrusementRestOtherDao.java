package nirmalya.aatithya.restmodule.employee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateReimbrusementOtherParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ReimbrusementRestOtherModel;

@Repository
public class ReimbrusementRestOtherDao {
	Logger logger = LoggerFactory.getLogger(ReimbrusementRestOtherDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	/**
	 * DAO DROPDOWN policy type
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getReimbTypeLists() {
		logger.info("Method : getReimbTypeLists starts");
		List<DropDownModel> getPolicyTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "getPolicyType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getPolicyTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getReimbTypeLists ends");
		return getPolicyTypeList;
	}
	

	
	/*
	 * Add ReimbursementRest Dao
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addReimbursementOther(ReimbrusementRestOtherModel reimbursementModel) {
		logger.info("Method : Rest Add addReimbursementOther Type Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateReimbrusementOtherParameter.getReimbursementParamOther(reimbursementModel);
logger.info("idddddddddddd"+reimbursementModel);
				if (reimbursementModel.getOtherReimbrusementId() != null && reimbursementModel.getOtherReimbrusementId() != "") {
					em.createNamedStoredProcedureQuery("reimbursementRoutine").setParameter("actionType", "modifyReimbruseimentOther")
							.setParameter("actionValue", values).execute();
					logger.info("Modify" + values);
				} else {
					em.createNamedStoredProcedureQuery("reimbursementRoutine").setParameter("actionType", "addReimbursementOther")
							.setParameter("actionValue", values).execute();
					logger.info("ADDDD" + values);
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
		logger.info("REMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM" + resp);
		logger.info("Method : Rest Add addReimbursementOther Type Dao ends");

		return response;
	}
	
	// View Reimbursement

			@SuppressWarnings("unchecked")
			public JsonResponse<List<ReimbrusementRestOtherModel>> viewReimbursementOther() {
					logger.info("Method : viewReimbursementOther Dao starts");
		  
					List<ReimbrusementRestOtherModel> viewReimbursementTravels = new ArrayList<ReimbrusementRestOtherModel>();
		  
						// logger.info("viewEmployeeDetails"+viewEmployeeDetails);
						JsonResponse<List<ReimbrusementRestOtherModel>> resp = new JsonResponse<List<ReimbrusementRestOtherModel>>(); 
						try {
		  
							List<Object[]> x =em.createNamedStoredProcedureQuery("reimbursementRoutine") 
									.setParameter("actionType", "viewAllReimDetailsOther").setParameter("actionValue", "").getResultList();
		  
							for (Object[] m : x) {
							
								Object DATE = null;
								if (m[1] != null) {

									DATE = m[1].toString();
								}
								Object EDATE = null;
								if (m[4] != null) {

									EDATE = m[4].toString();
								}
								Object amt = null;
								if (m[6] != null) {
									amt = (Double) m[6];
								}else {
									amt="0.00";
								}
								/*
								 * TRD_Reimbursement_Slno, TRD_Reimbursement, TRD_ReimDtls_REim_Type,
								 * TRD_ReimDtls_Policy, TRD_ReimDtls_ExpenseDate, TRD_ReimDtls_ExpenseDesc,
								 * TRD_ReimDtls_Amount, TRD_ReimDtls_ReferenceNo, TRD_ReimDtls_DocumntName,
								 * TRD_ReimDtls_File
								 */
								
								ReimbrusementRestOtherModel restStudentModel = new ReimbrusementRestOtherModel(m[0],
								 DATE,m[2],m[3],EDATE, m[5],(Double) amt, m[7],m[8],m[9],m[10],m[11],m[12].toString());
								 
								/*
								 * Object otherReimbrusementId, Object date, Object travellingPurpose, Object
								 * typeReimbrusement, Object expenseDate, Object descExpense, Double
								 * expenseAmount,Object docName, Object referenceNo
								 */
								viewReimbursementTravels.add(restStudentModel);
								//logger.info("viewEmployeeDetails viewwwwwwwwwwwwwwwwwww" + viewReimbursementTravels);
								logger.info("restStudentModeldao viewwwwwwwwwwwwwwwwwww" + viewReimbursementTravels);

							}

						} catch (Exception e) {
							e.printStackTrace();
						}
						logger.info("esdrftgyhujikfghj" + resp);
						resp.setBody(viewReimbursementTravels);
						logger.info("Method : viewReimbursementOther Dao ends");
						return resp;
					}
			/*
			 * Edit Reimbursement
			 * 
			 * 
			 */
			@SuppressWarnings("unchecked")
			public JsonResponse<ReimbrusementRestOtherModel> editReimbursementOther(String id) {
				logger.info("Method : editReimbursementOther dao starts");

				ReimbrusementRestOtherModel req = new ReimbrusementRestOtherModel();
				JsonResponse<ReimbrusementRestOtherModel> resp = new JsonResponse<ReimbrusementRestOtherModel>();

				try {

					String value = "SET @p_otherReimbursementReqId='" + id + "';";
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
							.setParameter("actionType", "editReimbruseimentOther").setParameter("actionValue", value).getResultList();

					for (Object[] m : x) {
						
						Object DATE = null;
						if (m[1] != null) {

							DATE = m[1].toString();
						}
						Object EDATE = null;
						if (m[4] != null) {

							EDATE = m[4].toString();
						}
						
											
						ReimbrusementRestOtherModel reqEdit = new ReimbrusementRestOtherModel(m[0],
								 DATE,m[2],m[3],EDATE, m[5],(Double) m[6], m[7],m[8],null,null,null,null);
						  req = reqEdit;
						 
							/*
							 * Object otherReimbrusementId, Object date, Object travellingPurpose, Object
							 * typeReimbrusement, Object expenseDate, Object descExpense, Double
							 * expenseAmount,Object docName, Object referenceNo
							 */
					}

					resp.setBody(req);
				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("Method : editReimbursementOther dao ends");
		        logger.info("EDIT@@@@"+resp);
				return resp;
			}
			
			/*
			 *Delete Reimbursement 
			 * 
			 */

			public JsonResponse<ReimbrusementRestOtherModel> deleteReimbursementOther(String id) {
				logger.info("Method : deleteReimbursementOther dao starts");
				logger.info("idddddd"+id);
				ReimbrusementRestOtherModel req = new ReimbrusementRestOtherModel();
				JsonResponse<ReimbrusementRestOtherModel> resp = new JsonResponse<ReimbrusementRestOtherModel>();

				try {

					String value = "SET @p_otherReimbursementReqId='(" + id + ")';";
					logger.info(value);
					em.createNamedStoredProcedureQuery("reimbursementRoutine").setParameter("actionType", "deleteReimbursementOther")
							.setParameter("actionValue", value).execute();

					resp.setBody(req);
				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("Method : deleteReimbursementOther dao ends");
				return resp;
			}
			
			// approve  apply

			public JsonResponse<ReimbrusementRestOtherModel> approvereimbursementOtherApply(String id, String name, String comment,String roleid) {
				logger.info("Method : approvereimbursementOtherApply starts");

				ReimbrusementRestOtherModel req = new ReimbrusementRestOtherModel();
				JsonResponse<ReimbrusementRestOtherModel> resp = new JsonResponse<ReimbrusementRestOtherModel>();
				try {

					String value = "SET @p_otherReimbursementReqId='" + id + "',@p_approveBy='" + name + "',@p_comment='" + comment + "',@p_userRole=\'("+roleid+")\';";
					logger.info("value====="+value);
					em.createNamedStoredProcedureQuery("reimbursementRoutine").setParameter("actionType", "approvereimbursementOtherApply")
							.setParameter("actionValue", value).execute();

					resp.setBody(req);
				} catch (Exception e) {
					logger.error("approveAdvanceApply: " + e.getMessage());
					e.printStackTrace();
				}

				logger.info("Method : approvereimbursementOtherApply ends");
				logger.info("ADDDDAAOOO"+resp);
				return resp;
			}
			
			// reject apply

			public JsonResponse<ReimbrusementRestOtherModel> rejectreimbursementOtherApply(String id, String name, String comment) {
				logger.info("Method : rejectReimbursementApply starts");

				ReimbrusementRestOtherModel req = new ReimbrusementRestOtherModel();
				JsonResponse<ReimbrusementRestOtherModel> resp = new JsonResponse<ReimbrusementRestOtherModel>();

				try {

					String value = "SET @p_otherReimbursementReqId='" + id + "',@p_rejectBy='" + name + "',@p_comment='" + comment + "';";

					em.createNamedStoredProcedureQuery("reimbursementRoutine").setParameter("actionType", "rejectreimbursementOtherApply")
							.setParameter("actionValue", value).execute();

					resp.setBody(req);
				} catch (Exception e) {
					logger.error("rejectAdvanceApply: " + e.getMessage());
					e.printStackTrace();
				}

				logger.info("Method : rejectreimbursementOtherApply ends");
				logger.info("ADDDDAAOOO"+resp);
				return resp;
			}
}
