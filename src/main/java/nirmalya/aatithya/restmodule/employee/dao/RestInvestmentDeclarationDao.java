package nirmalya.aatithya.restmodule.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateInvestmentDeclarationParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.InvestDeclareSubModel;
import nirmalya.aatithya.restmodule.employee.model.RestInvestmentDeclarationModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

import javax.persistence.EntityManager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class RestInvestmentDeclarationDao {
	Logger logger = LoggerFactory.getLogger(RestInvestmentDeclarationDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	/*
	 * View current Header Details
	 * 
	 */
	public String saveAllImage(byte[] imageBytes, String ext, String pId) {
		logger.info("Method : saveAllImage starts");

		String imageName = null;

		try {

			if (imageBytes != null) {
				long nowTime = new Date().getTime();
				if (ext.contentEquals("jpeg") || ext.contentEquals("jpg") || ext.contentEquals("png")) {
					imageName = pId + "_" + nowTime + ".jpg";
				} else {
					imageName = pId + "_" + nowTime + "." + ext;
				}

			}
			logger.info("xxxxxxxxxxxxxxxxxyyyyyyy" + imageName);
			Path path = Paths.get(env.getFileUploadtaskdocumentUrl() + imageName);
			logger.info("xxxxxxxxxxxxxxxxxyyyyyyy" + path);
			if (imageBytes != null) {
				if (pId != null && pId != "") {
					Files.write(path, imageBytes);
				}
			}
			/*
			 * if (imageBytes != null) {
			 * 
			 * if (pId != null && pId != "") { Files.write(path, imageBytes);
			 * 
			 * ByteArrayInputStream in = new ByteArrayInputStream(imageBytes); Integer
			 * height = 50; Integer width = 50;
			 * logger.info("xxxxxxxxxxxxxxxxxyyyyyyy"+in);
			 * 
			 * try { BufferedImage img = ImageIO.read(in);
			 * logger.info("xxxxxxxxxxxxxxxxx"+img); if (height == 0) { height =
			 * (width img.getHeight()) / img.getWidth(); } if (width == 0) { width = (height
			 * img.getWidth()) / img.getHeight(); }
			 * 
			 * BufferedImage outputImage = new BufferedImage(width, height, img.getType());
			 * logger.info("++++++++++++++++++++++++++++++++++++++++++++++"+img.
			 * getType());
			 * 
			 * Graphics2D g2d = outputImage.createGraphics(); g2d.drawImage(img, 0, 0,
			 * width, height, null); g2d.dispose(); String outputImagePath =
			 * env.getFileUploadProfile() + "thumb/" + imageName; ImageIO.write(null, ext,
			 * new File(outputImagePath));
			 * 
			 * } catch (Exception e) { e.printStackTrace(); } }
			 * 
			 * }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : saveAllImage ends");
		logger.info("imageName===" + imageName);
		return imageName;
	}

	@SuppressWarnings("unchecked")

	public JsonResponse<List<RestInvestmentDeclarationModel>> investmentDeclareDetails(String id, String organization,
			String orgDivision) {

		logger.info("Method in Dao: investmentDeclareDetails starts");

		List<RestInvestmentDeclarationModel> inestmentDeclaration = new ArrayList<RestInvestmentDeclarationModel>();
		String values = "set @p_empid ='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
		try {
			List<String> x = em.createNamedStoredProcedureQuery("investmentRoutines")
					.setParameter("actionType", "viewInvestmentDeclaration").setParameter("actionValue", values)
					.getResultList();
			for (String m1 : x) {
				RestInvestmentDeclarationModel invDetails = new RestInvestmentDeclarationModel(m1);
				inestmentDeclaration.add(invDetails);

			}
			logger.info("inestmentDeclaration ===============" + inestmentDeclaration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!Util.isNull(inestmentDeclaration)) {
			for (RestInvestmentDeclarationModel a : inestmentDeclaration) {
				List<InvestDeclareSubModel> investDetails = new ArrayList<InvestDeclareSubModel>();
				try {
					String value = "set @p_headerid='" + a.getHeaderid() + "';";
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("investmentRoutines")
							.setParameter("actionType", "investmentDeclarelist").setParameter("actionValue", value)
							.getResultList();

					for (Object[] m1 : x1) {
						InvestDeclareSubModel dropDownModel = new InvestDeclareSubModel(m1[0].toString(),
								m1[1].toString(), m1[2]);
						investDetails.add(dropDownModel);
					}
					a.setInvestDetails(investDetails);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		JsonResponse<List<RestInvestmentDeclarationModel>> resp = new JsonResponse<List<RestInvestmentDeclarationModel>>();
		resp.setBody(inestmentDeclaration);
		logger.info("Method in Dao: investmentDeclareDetails ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestInvestmentDeclarationModel>> investmentDeclareDetailsApi(String organization,
			String orgDivision) {

		logger.info("Method in Dao: investmentDeclareDetailsApi starts");

		List<RestInvestmentDeclarationModel> inestmentDeclaration = new ArrayList<RestInvestmentDeclarationModel>();
		JsonResponse<List<RestInvestmentDeclarationModel>> resp = new JsonResponse<List<RestInvestmentDeclarationModel>>();

		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<String> x = em.createNamedStoredProcedureQuery("investmentRoutines")
					.setParameter("actionType", "viewInvestmentDeclaration").setParameter("actionValue", values)
					.getResultList();
			for (String m : x) {
				RestInvestmentDeclarationModel invDetails = new RestInvestmentDeclarationModel(m);
				inestmentDeclaration.add(invDetails);

				if (inestmentDeclaration.size() > 0) {
					Util.setJsonResponse(resp, inestmentDeclaration, ResponseStatus.success,
							ApiResponseMessage.DATA_FETCH_SUCCESS);
				} else {
					Util.setJsonResponse(resp, inestmentDeclaration, ResponseStatus.success,
							ApiResponseMessage.NO_DATA_FOUND);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		resp.setBody(inestmentDeclaration);
		logger.info("Method in Dao: investmentDeclareDetailsApi ends");
		return resp;
	}

	@SuppressWarnings("unchecked")

	public JsonResponse<List<InvestDeclareSubModel>> investmentDeclareHeadersDetailsApi(String headerId,
			String organization, String orgDivision) {

		logger.info("Method in Dao: investmentDeclareHeadersDetailsApi starts");

		JsonResponse<List<InvestDeclareSubModel>> resp = new JsonResponse<List<InvestDeclareSubModel>>();

		List<InvestDeclareSubModel> investDetails = new ArrayList<InvestDeclareSubModel>();
		try {
			String value = "set @p_headerid ='" + headerId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";
			logger.info("value=====" + value);
			List<Object[]> x1 = em.createNamedStoredProcedureQuery("investmentRoutines")
					.setParameter("actionType", "investmentDeclarelist").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x1) {
				InvestDeclareSubModel dropDownModel = new InvestDeclareSubModel(m[0].toString(), m[1], m[2]);
				investDetails.add(dropDownModel);
			}
			if (investDetails.size() > 0) {
				Util.setJsonResponse(resp, investDetails, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, investDetails, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		resp.setBody(investDetails);
		logger.info("Method in Dao: investmentDeclareHeadersDetailsApi ends");
		return resp;
	}

	// Add Investment Declare
	public ResponseEntity<JsonResponse<List<RestInvestmentDeclarationModel>>> addInvestment(
			List<RestInvestmentDeclarationModel> restInvestmentDeclarationModel) {
		logger.info("Method : addInvestment starts");
		logger.info("restInvestmentDeclarationModel====" + restInvestmentDeclarationModel);
		JsonResponse<List<RestInvestmentDeclarationModel>> resp = new JsonResponse<List<RestInvestmentDeclarationModel>>();
		List<RestInvestmentDeclarationModel> listData = new ArrayList<RestInvestmentDeclarationModel>();
		try {
			String values = GenerateInvestmentDeclarationParam.getInvestmentDeclaration(restInvestmentDeclarationModel);
			logger.info("values====" + values);
			if (restInvestmentDeclarationModel.get(0).getDeclarId() == null || restInvestmentDeclarationModel.get(0).getDeclarId()=="") {
				em.createNamedStoredProcedureQuery("investmentRoutines")
						.setParameter("actionType", "addInvestmentDetails").setParameter("actionValue", values)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data saved successfully");
			} else {
				em.createNamedStoredProcedureQuery("investmentRoutines")
						.setParameter("actionType", "modifyInvestmentDetails").setParameter("actionValue", values)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data modified successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				if (err[0] == "1062") {
					resp.setCode("failed");
					resp.setMessage("you are already submit investment declaration for financial year ");
				} else {
					resp.setCode("failed");
					resp.setMessage("Someting went to wrong");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestInvestmentDeclarationModel>>> response = new ResponseEntity<JsonResponse<List<RestInvestmentDeclarationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addInvestment ends" + response);
		return response;
	}

	public ResponseEntity<JsonResponse<List<RestInvestmentDeclarationModel>>> addInvestmentApi(
			List<RestInvestmentDeclarationModel> restInvestmentDeclarationModel) {
		logger.info("Method : addInvestment starts");
		JsonResponse<List<RestInvestmentDeclarationModel>> resp = new JsonResponse<List<RestInvestmentDeclarationModel>>();
		List<RestInvestmentDeclarationModel> listData = new ArrayList<RestInvestmentDeclarationModel>();
		String File = null;
		logger.info("restInvestmentDeclarationModel=====" + restInvestmentDeclarationModel);

		int i;
		for (i = 0; i < 6; i++) {
			if (restInvestmentDeclarationModel.get(i).getDocName().length() > 0) {

				if (restInvestmentDeclarationModel.get(i).getDocFile() != null
						&& restInvestmentDeclarationModel.get(i).getDocFile() != "") {
					logger.info("asds=" + restInvestmentDeclarationModel.get(i).getDocFile());
					try {
						byte[] bytes = Base64.getDecoder()
								.decode(restInvestmentDeclarationModel.get(i).getDocFile().trim());
//					byte[] bytes = Base64.getDecoder().decode("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");
						File = saveAllImage(bytes, restInvestmentDeclarationModel.get(i).getExtension(),
								restInvestmentDeclarationModel.get(i).getEmpId());
						restInvestmentDeclarationModel.get(i).setDocFile(File);
						logger.info("Fileee" + File);
						// image = docFile;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		logger.info("restInvestmentDeclarationModel after =====" + restInvestmentDeclarationModel);
		String values = GenerateInvestmentDeclarationParam.getInvestmentDeclaration(restInvestmentDeclarationModel);
		logger.info("values====" + values);

		try {
			logger.info("restInvestmentDeclarationModel Dao" + restInvestmentDeclarationModel);
			if (restInvestmentDeclarationModel.get(0).getDeclarId() == null || restInvestmentDeclarationModel.get(0).getDeclarId()=="") {
				logger.info("values====" + values);
				em.createNamedStoredProcedureQuery("investmentRoutines")
						.setParameter("actionType", "addInvestmentDetails").setParameter("actionValue", values)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data saved successfully");
			} else {
				em.createNamedStoredProcedureQuery("investmentRoutines")
						.setParameter("actionType", "addInvestmentDetails").setParameter("actionValue", values)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data modified successfully");
			}

			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);

		ResponseEntity<JsonResponse<List<RestInvestmentDeclarationModel>>> response = new ResponseEntity<JsonResponse<List<RestInvestmentDeclarationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addInvestment ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")

	public JsonResponse<List<RestInvestmentDeclarationModel>> investmentDeclareSubheaderDetailsDao(String id,String userId,String organization,String orgDivision) {

		logger.info("Method in Dao: investmentDeclareSubheaderDetails Dao starts");

		List<RestInvestmentDeclarationModel> inestmentDeclaration = new ArrayList<RestInvestmentDeclarationModel>();
		JsonResponse<List<RestInvestmentDeclarationModel>> resp = new JsonResponse<List<RestInvestmentDeclarationModel>>();
		String values = "SET @p_declareId='" + id + "',@p_userId='" + userId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
		try {
			logger.info("values==="+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("investmentRoutines")
					.setParameter("actionType", "viewInvestmentsubheaderData").setParameter("actionValue",values)
					.getResultList();
			for (Object[] m : x) {
				logger.info("x==="+Arrays.toString(m));
				String doc = null;
				if (m[6] != null && m[6] != "" && m[6] != " " && !m[6].toString().equals(" ")
						&& !m[6].toString().equals(null) && !m[6].toString().equals("")) {
					doc = env.getMobileView() + "document/taskdocument/" + m[6].toString();
				} else {
					doc = "";
				}
				RestInvestmentDeclarationModel invDetails = new RestInvestmentDeclarationModel(m[0], m[1], m[2], m[3],
						m[4],null,m[5], doc,m[6]);
				inestmentDeclaration.add(invDetails);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("inestmentDeclaration===="+inestmentDeclaration);
		if (!Util.isNull(inestmentDeclaration)&&!inestmentDeclaration.isEmpty()) {
			for (RestInvestmentDeclarationModel a : inestmentDeclaration) {
				List<InvestDeclareSubModel> investDetails = new ArrayList<InvestDeclareSubModel>();
				try {
					String value = "set @p_declareId ='" + a.getDeclarId() + "',@p_empId ='" + a.getEmpId() + "',@p_header ='" + a.getHeaderid() + "';";
					logger.info("value==="+value);
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("investmentRoutines")
							.setParameter("actionType", "investmentDeclareAllDataList")
							.setParameter("actionValue", value).getResultList();

					for (Object[] m : x1) {

						Object fDATE = null;
						if (m[0] != null) {
							fDATE = DateFormatter.returnStringDate(m[0]);
						}
						Object tDATE = null;
						if (m[1] != null) {
							tDATE = DateFormatter.returnStringDate(m[1]);
						}

						InvestDeclareSubModel dropDownModel = new InvestDeclareSubModel(fDATE, tDATE, m[2], m[3], m[4],
								m[5]);
						investDetails.add(dropDownModel);
						if (dropDownModel.equals("")) {
							resp.setCode("failed");
							resp.setMessage("Data not found");
						} else {
							resp.setCode("success");
							resp.setMessage("Data fetched successfully");
						}
					}
					a.setInvestDetails(investDetails);
				} catch (Exception e) {
					e.printStackTrace();
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
			}
			resp.setBody(inestmentDeclaration);
		}else {
			resp.setCode("failed");
			resp.setMessage("Data not found");
		}
		logger.info("Method in Dao: investmentDeclareSubheaderDetails Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestInvestmentDeclarationModel>> declarationviewDao(String empId, String organization,
			String orgDivision) {
		logger.info("Method : declaration view Dao starts");

		List<RestInvestmentDeclarationModel> getAllemployee = new ArrayList<RestInvestmentDeclarationModel>();
		JsonResponse<List<RestInvestmentDeclarationModel>> resp = new JsonResponse<List<RestInvestmentDeclarationModel>>();

		try {
			String values = "SET @p_empId='" + empId + "',@p_organisation='" + organization + "',@p_orgDiv='"
					+ orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("investmentRoutines")
					.setParameter("actionType", "viewdeclaration").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				RestInvestmentDeclarationModel viewdemo = new RestInvestmentDeclarationModel(m[0], m[1], m[2], m[3],
						m[4], m[5]);
				getAllemployee.add(viewdemo);
			}
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			logger.info("111qqqqqqqqqqq#######" + getAllemployee);
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DATA_FECTH_FAILED);
		}

		logger.info("111qqqqqqqqqq$$$$$$$" + getAllemployee);
		resp.setBody(getAllemployee);
		logger.info("111qqqqqq@@@@@@@@" + resp);
		logger.info("Method : declaration view Dao ends" + resp);

		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestInvestmentDeclarationModel>> restdeclarationviewApi(String empId, String organisation,
			String orgDiv) {
		logger.info("Method : restdeclarationviewApi Dao starts");

		List<RestInvestmentDeclarationModel> getAllemployee = new ArrayList<RestInvestmentDeclarationModel>();
		JsonResponse<List<RestInvestmentDeclarationModel>> resp = new JsonResponse<List<RestInvestmentDeclarationModel>>();

		try {
			String values = "SET @p_empId='" + empId + "',@p_organisation='" + organisation + "',@p_orgDiv='" + orgDiv
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("investmentRoutines")
					.setParameter("actionType", "viewdeclarationApi").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				RestInvestmentDeclarationModel viewdemo = new RestInvestmentDeclarationModel(m[0], m[1], m[2], m[3],
						m[4], m[5]);
				getAllemployee.add(viewdemo);
			}
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DATA_FECTH_FAILED);
		}

		resp.setBody(getAllemployee);

		logger.info("Method : restdeclarationviewApi Dao ends");

		return resp;

	}
	//check Edit Available
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>>checkEditAvailable(String userId,String financialYear, String organization,String orgDivision) {
		logger.info("Method : checkEditAvailable starts");

		DropDownModel pf = new DropDownModel();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		String value = "SET @p_userName='" + userId + "',@p_financialYear='" + financialYear + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision+ "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "checkEditAvailable").setParameter("actionValue",value).getResultList();
			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.failed, ApiResponseMessage.NO_DATA_FOUND);
			}
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString(),m[2].toString());
				pf = dropDownModel;
				
				if (dropDownModel.equals("")) {
					resp.setBody(dropDownModel);
					resp.setCode("failed");
					resp.setMessage("Data not found");
				} else {
					resp.setBody(dropDownModel);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			 resp.setBody(pf);
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("checkEditAvailable: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(pf);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				responseHeaders, HttpStatus.CREATED);
		logger.info("Method : checkEditAvailable ends");
		return response;
	}
}
