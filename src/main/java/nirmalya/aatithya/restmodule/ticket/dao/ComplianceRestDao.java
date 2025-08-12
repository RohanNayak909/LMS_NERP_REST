package nirmalya.aatithya.restmodule.ticket.dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.asset.model.AssetDocumentRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetViewMaster;
import nirmalya.aatithya.restmodule.common.utils.ticket.GenerateTicketDigitalLogBookParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;
import org.springframework.transaction.annotation.Transactional;


	@Repository
	public class ComplianceRestDao {
		Logger logger = LoggerFactory.getLogger(ComplianceRestDao.class);

		@Autowired
		EntityManager em;

		@Autowired
		ServerDao serverDao;

		@Autowired
		CheckDuplicateDao checkDuplicateDao;
		
		@Autowired
		private EnvironmentVaribles env;
		
		

	
//
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> addCompliance(List<AssetViewMasterRestModel> av) {
			logger.info("Method : addCompliance dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			JSONObject json = new JSONObject();
			
			System.out.println("DATA-------------------"+av);

			if (av.get(0).getWarrantyList().size() > 0) {
				for (AssetViewMasterRestModel a : av.get(0).getWarrantyList()) {

					String delimiters = "\\.";
					if (a.getDocumentFileBase() != null && a.getDocumentFileBase() != "") {
						String[] y = a.getFileName().split(delimiters);
						String extensionW = y[y.length - 1];
						try {
							byte[] bytes = Base64.getDecoder().decode(a.getDocumentFileBase());
							json = saveAllMediaDocuments(bytes, extensionW, av.get(0).getCreatedBy());

						} catch (Exception e) {
							e.printStackTrace();
						}
						a.setDocumentURL(json.getString("fileurl"));
					}
				}
			}
			
			String value = GenerateTicketDigitalLogBookParam.getComplianceData(av);
			System.out.println("DATA-------------------"+value);
			try {

				if (av.get(0).getComplianceId() != null && av.get(0).getComplianceId() != "") {

					List<Object[]> x =em.createNamedStoredProcedureQuery("asset_view_master_routines")
							.setParameter("actionType", "modifyCompliance").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data Modified successfully");

				} else {
					List<Object[]> x =em.createNamedStoredProcedureQuery("asset_view_master_routines").setParameter("actionType", "addCompliance")
							.setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data saved successfully");

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


			logger.info("Method : addCompliance dao ends"+resp);
			return resp;

		}
	

//
		public JSONObject saveAllMediaDocuments(byte[] imageBytes, String ext, String user_id) {
			logger.info("Method : saveAllMedicalDocuments starts");

			String imageName = null;
			try {

				if (imageBytes != null) {
					long nowTime = new Date().getTime();

					if (ext.contentEquals("jpeg")) {
						imageName = user_id + "_" + nowTime + ".jpg";
					} else {
						imageName = user_id + "_" + nowTime + "." + ext;
					}
				}

				Path path = Paths.get(env.getAssetDocUrl() + imageName);
				if (imageBytes != null) {
					Files.write(path, imageBytes);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			String url = env.getMobileView() + "document/assetDocUrl/" + imageName;

			JSONObject json = new JSONObject();

			try {
				json.put("filename", imageName);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				json.put("fileurl", url);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info("Method : saveAllMediaDocuments ends");
			return json;
		}
}
