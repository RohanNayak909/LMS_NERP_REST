package nirmalya.aatithya.restmodule.edms.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.StringUtil;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestWorkspaceNewDao {
	Logger logger = LoggerFactory.getLogger(RestWorkspaceNewDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// Get Folder Details
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getFolderDetails(String userId, String organization, String orgDivision) {
		logger.info("Method : getFolderDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_userId='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='"
					+ orgDivision + "';";
			logger.info("value-->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
					.setParameter("actionType", "getFolderDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFolderDetails Dao ends" + resp);
		return resp;
	}
	
	// Workspace Add

		public ResponseEntity<JsonResponse<Object>> addWorkspaceNew(String itm, String workSpaceId,String parentFolder,String parentId) {
			logger.info("Method : addWorkspaceNew dao starts" + itm);
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				if (!StringUtil.isNull(workSpaceId)) {
					String value = "SET @workSpaceId='" + workSpaceId + "',@itm='" + itm + "',@p_parentFolder='"+parentFolder+"'"
							+ ",@p_parentId='"+parentId+"';";
					System.out.println("value: " + value);
					em.createNamedStoredProcedureQuery("workspaceRoutines").setParameter("actionType", "modifyWorkspace")
							.setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Data Updated successfully");

				} else {
					String value = "SET @workSpaceId='" + workSpaceId + "',@itm='" + itm + "',@p_parentFolder='"+parentFolder+"',@p_parentId='"+parentId+"';";
					System.out.println("VALUE"+value);
					Object x = em.createNamedStoredProcedureQuery("workspaceRoutines").setParameter("actionType", "addWorkspace")
							.setParameter("actionValue", value).getResultList();
					resp.setBody(x.toString());
					resp.setCode("success");
					resp.setMessage("Data Added successfully");
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

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);
			logger.info("Method : addWorkspaceNew dao ends");
			return response;

		}
		
		// Get Parent Folder Details
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getParentFolder(String userId, String organization, String orgDivision,String path) {
			logger.info("Method : getParentFolder Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_userId='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='"
						+ orgDivision + "',@p_path='"+path+"';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("workspaceRoutines")
						.setParameter("actionType", "getParentFolderId").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getParentFolder Dao ends" + resp);
			return resp;
		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getAccesDetails(String orgName, String orgDivision, String id) {
			logger.info("Method : getAccesDetails Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_workspaceId='" + id + "';";
				List<Object[]> list = em.createNamedStoredProcedureQuery("workspaceRoutines")
						.setParameter("actionType", "getAccesDetails").setParameter("actionValue", value).getResultList();
				resp.setBody(list);
				resp.setCode("Success");
				resp.setMessage("Data fetched Successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getAccesDetails Dao ends");
			return resp;

		}
}
