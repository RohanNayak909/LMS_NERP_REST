package nirmalya.aatithya.restmodule.edms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.util.Util;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.edms.model.RestDocumentControlModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
@Repository
public class RestWorkFlowApproveDao {
	Logger logger = LoggerFactory.getLogger(RestWorkspaceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;  
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> workFlowApproveView(String userId, String orgName, String orgDiv) {
		logger.info("Method : workFlowApproveView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("VALUE"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("Edms_WorkFlow_Routines")
					.setParameter("actionType", "viewWorkFlowApprove").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : workFlowApproveView Dao ends"+resp);
		return resp;
	}
	
	//Approve Workflow
	public ResponseEntity<JsonResponse<RestDocumentControlModel>> approveWorkFlow(
			RestDocumentControlModel restDocumentControlModel) {
		logger.info("Method : approveWorkFlow dao starts"+restDocumentControlModel);
		JsonResponse<RestDocumentControlModel> resp = new JsonResponse<RestDocumentControlModel>();
		List<RestDocumentControlModel> rs = new ArrayList<RestDocumentControlModel>();
		try {
			String value = "SET @p_docId='" + restDocumentControlModel.getDocid() + "'" + ",@p_version='"
					+ restDocumentControlModel.getVersion() + "'" + ",@p_status='"
					+ restDocumentControlModel.getStatus() + "'" + ",@p_id='" + restDocumentControlModel.getId()
					+ "',@p_workFlowEmployee='" + restDocumentControlModel.getEmpId() + "'"
					+ ",@p_createdBy='"+restDocumentControlModel.getCreatedBy()+"'"
					+ ",@p_organisation='"+restDocumentControlModel.getOrganization()+"'"
					+ ",@p_orgDivision='"+restDocumentControlModel.getOrgDivision()+"';";

			em.createNamedStoredProcedureQuery("Edms_WorkFlow_Routines").setParameter("actionType", "approvedWorkFlow")
			.setParameter("actionValue", value).execute();
			
			resp.setCode("success");
			System.out.println("STATUS"+restDocumentControlModel.getStatus());
			if(restDocumentControlModel.getStatus().equals("1")) {
				resp.setMessage("Document Rejected");
				
			}else{
				resp.setMessage("Document Approve successfully");
			}
			

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<RestDocumentControlModel>> response = new ResponseEntity<JsonResponse<RestDocumentControlModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : approveWorkFlow dao ends");
		return response;

	}
}
