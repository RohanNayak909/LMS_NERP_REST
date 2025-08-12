package nirmalya.aatithya.restmodule.api.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.model.ApprovalModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateApproveParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.PushNotification;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ApprovalDao {

	Logger logger = LoggerFactory.getLogger(ApprovalDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	PushNotification pushNotification = new PushNotification();

	@SuppressWarnings("unchecked")
	public JsonResponse<List<ApprovalModel>> viewApproval(String userId, String userRole, String requistionName) {

		logger.info("Method : viewApproval Dao starts");
		List<ApprovalModel> viewApproval = new ArrayList<ApprovalModel>();
		JsonResponse<List<ApprovalModel>> resp = new JsonResponse<List<ApprovalModel>>();
		try {
			String value = "SET @p_empId=\"" + userId + "\",@p_requistionName=\"" + requistionName + "\",@p_userRole='("
					+ userRole + ")';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewApprovalApi")
					.setParameter("actionType", "viewApproval").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				ApprovalModel approval = new ApprovalModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7]);

				viewApproval.add(approval);

			}

			if (viewApproval.size() > 0) {
				resp.setBody(viewApproval);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(viewApproval);
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			logger.error("viewleApproval: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(viewApproval);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewApproval Dao ends");
		return resp;

	}

	public ResponseEntity<JsonResponse<ApprovalModel>> approvedApproval(ApprovalModel approvalModel) {
		logger.info("Method : approvedApproval starts");

		JsonResponse<ApprovalModel> resp = new JsonResponse<ApprovalModel>();

		try {
			String value = GenerateApproveParam.generateApproveParam(approvalModel);
			logger.info("value====" + value);
			if (approvalModel.getRequisitionName().equals("Leave")) {
				em.createNamedStoredProcedureQuery("LeaveApply").setParameter("actionType", "approveLeaveApply")
						.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data approved successfully");

				List<DropDownModel> managerByUesr = checkDuplicateDao
						.getUserByRequisitionId(approvalModel.getRequisitionId(), approvalModel.getApprovedBy());
				for (DropDownModel m : managerByUesr) {
					String msg = m.getName() + " approved your Leave";
					try {
						String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
						logger.info("msgId====" + msgId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else if (approvalModel.getRequisitionName().equals("Advanvc")) {

				em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
						.setParameter("actionType", "approveAdvanceApply").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data approved successfully");

				List<DropDownModel> managerByUesr = checkDuplicateDao
						.getUserByRequisitionId(approvalModel.getRequisitionId(), approvalModel.getApprovedBy());
				for (DropDownModel m : managerByUesr) {
					String msg = m.getName() + " approved your Advanvc";
					try {
						String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
						logger.info("msgId====" + msgId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else if (approvalModel.getRequisitionName().equals("Travel")) {

				em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "approveRequisition").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data approved successfully");

				List<DropDownModel> managerByUesr = checkDuplicateDao
						.getUserByRequisitionId(approvalModel.getRequisitionId(), approvalModel.getApprovedBy());
				for (DropDownModel m : managerByUesr) {
					String msg = m.getName() + " approved your Travel";
					try {
						String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
						logger.info("msgId====" + msgId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else if (approvalModel.getRequisitionName().equals("Reimbursement")) {

				em.createNamedStoredProcedureQuery("reimbursementRoutine")
						.setParameter("actionType", "approveReimbursementApply").setParameter("actionValue", value)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data approved successfully");

				List<DropDownModel> managerByUesr = checkDuplicateDao
						.getUserByRequisitionId(approvalModel.getRequisitionId(), approvalModel.getApprovedBy());
				for (DropDownModel m : managerByUesr) {
					String msg = m.getName() + " approved your Reimbursement";
					try {
						String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
						logger.info("msgId====" + msgId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else {
				resp.setCode("failed");
				resp.setMessage("Choice is wrong");

			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				String rcode = err[0];
				logger.info("rcode" + rcode);
				if (rcode.equals("1062")) {
					resp.setCode("failed");
					resp.setMessage("YOU’RE ALREADY APPROVED!");
				} else {
					resp.setCode("failed");
					resp.setMessage("Something went wrong ");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<ApprovalModel>> response = new ResponseEntity<JsonResponse<ApprovalModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : approvedApproval ends");

		return response;
	}

	public ResponseEntity<JsonResponse<ApprovalModel>> rejectedApproval(ApprovalModel approvalModel) {
		logger.info("Method : rejectedApproval starts");

		JsonResponse<ApprovalModel> resp = new JsonResponse<ApprovalModel>();
		logger.info("approvalModel===" + approvalModel);
		try {
			String value = GenerateApproveParam.generateApproveParam(approvalModel);
			logger.info("value===" + value);
			if (approvalModel.getRequisitionName().equals("Leave")) {

				em.createNamedStoredProcedureQuery("LeaveApply").setParameter("actionType", "rejectLeaveApply")
						.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data rejected successfully");

				List<DropDownModel> managerByUesr = checkDuplicateDao
						.getUserByRequisitionId(approvalModel.getRequisitionId(), approvalModel.getApprovedBy());
				for (DropDownModel m : managerByUesr) {
					String msg = m.getName() + " rejected your Leave";
					try {
						String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
						logger.info("msgId====" + msgId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else if (approvalModel.getRequisitionName().equals("Advanvc")) {

				em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
						.setParameter("actionType", "rejectAdvanceApply").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data rejected successfully");

				List<DropDownModel> managerByUesr = checkDuplicateDao
						.getUserByRequisitionId(approvalModel.getRequisitionId(), approvalModel.getApprovedBy());
				for (DropDownModel m : managerByUesr) {
					String msg = m.getName() + " rejected your Advanvc";
					try {
						String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
						logger.info("msgId====" + msgId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else if (approvalModel.getRequisitionName().equals("Travel")) {
				em.createNamedStoredProcedureQuery("travelRequisitionRoutines")
						.setParameter("actionType", "rejectRequisition").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data rejected successfully");

				List<DropDownModel> managerByUesr = checkDuplicateDao
						.getUserByRequisitionId(approvalModel.getRequisitionId(), approvalModel.getApprovedBy());
				for (DropDownModel m : managerByUesr) {
					String msg = m.getName() + " rejected your Travel";
					try {
						String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
						logger.info("msgId====" + msgId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else if (approvalModel.getRequisitionName().equals("Reimbursement")) {
				em.createNamedStoredProcedureQuery("reimbursementRoutine")
						.setParameter("actionType", "rejectReimbursementApply").setParameter("actionValue", value)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data rejected successfully");

				List<DropDownModel> managerByUesr = checkDuplicateDao
						.getUserByRequisitionId(approvalModel.getRequisitionId(), approvalModel.getApprovedBy());
				for (DropDownModel m : managerByUesr) {
					String msg = m.getName() + " rejected your Reimbursement";
					try {
						String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
						logger.info("msgId====" + msgId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else {
				resp.setCode("failed");
				resp.setMessage("Choice is wrong");

			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				String rcode = err[0];
				logger.info("rcode" + rcode);
				if (rcode.equals("1062")) {
					resp.setCode("failed");
					resp.setMessage("YOU’RE ALREADY REJECTED!");
				} else {
					resp.setCode("failed");
					resp.setMessage("Something went wrong ");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<ApprovalModel>> response = new ResponseEntity<JsonResponse<ApprovalModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : rejectedApproval ends");

		return response;
	}

}
