package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateOtherBenifitParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestOtherBenifitsModel;

@Repository
public class RestOtherBenifitsControllerDao {
	Logger logger = LoggerFactory.getLogger(RestOtherBenifitsControllerDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOtherBenifit(String org, String orgDiv) {
		logger.info("Method : getOtherBenifit starts");

		List<DropDownModel> otherBenifit = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
          
			List<Object[]> x = em.createNamedStoredProcedureQuery("emp_other_benifits_routines")
					.setParameter("actionType", "getOtherBenifit").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				otherBenifit.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOtherBenifit endsssssssssssssssssss");
		return otherBenifit;
	}
	
	// Save Advance apply
	public ResponseEntity<JsonResponse<Object>> saveOtherBanifits(RestOtherBenifitsModel restOtherBenifitsModel) {
		logger.info("Method : saveOtherBanifits starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateOtherBenifitParameter.saveOtherBanifitsParam(restOtherBenifitsModel);
			if (restOtherBenifitsModel.getBenifitId() == null
					|| restOtherBenifitsModel.getBenifitId() == "") {
				logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);

				em.createNamedStoredProcedureQuery("emp_other_benifits_routines")
				.setParameter("actionType", "saveOtherBanifits").setParameter("actionValue", values)
				.execute();
			

			} else {
				logger.info("@modifyyyyyyyyyyyyyy" + values);

				em.createNamedStoredProcedureQuery("emp_other_benifits_routines")
				.setParameter("actionType", "modifyOtherBanifits").setParameter("actionValue", values)
				.execute();

			}
			
			resp.setCode("Success");
				resp.setMessage("Data Saved Successfully");
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
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : saveOtherBanifits ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewBenifitsData(String orgName, String orgDivision) {
		logger.info("Method : viewBenifitsData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("emp_other_benifits_routines")
					.setParameter("actionType", "viewBenifitsData").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewBenifitsData Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	public JsonResponse<Object> deleteBenifit(String id,String orgName, String orgDiv) {
		logger.info("Method : deleteBenifit Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_benifitId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("values****************************" + value);
			 em.createNamedStoredProcedureQuery("emp_other_benifits_routines")
					.setParameter("actionType", "deleteBenifit").setParameter("actionValue", value)
					.execute();
			 resp.setCode("success");
			 resp.setMessage("Deleted Successfully");
			//resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : deleteBenifit Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveBenifitdata(String id,String orgName, String orgDiv) {
		logger.info("Method : approveBenifitdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_benifitId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("values****************************" + value);
			 em.createNamedStoredProcedureQuery("emp_other_benifits_routines")
					.setParameter("actionType", "approveBenifitdata").setParameter("actionValue", value)
					.execute();
			 resp.setCode("success");
			 resp.setMessage("Approved Successfully");
			//resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approveBenifitdata Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editBenifitData(String benifitId,String orgName, String orgDivision) {
		logger.info("Method : editBenifitData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_benifitId='" + benifitId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("emp_other_benifits_routines")
					.setParameter("actionType", "editBenifitData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editBenifitData Dao ends");
		logger.info("resp**************EDIT**************" + resp);
		return resp;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getFrequency(String category, String orgName, String orgDivision) {
		logger.info("Method : getFrequency Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_cat='" + category + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("emp_other_benifits_routines")
					.setParameter("actionType", "getFrequency").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFrequency Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}

}
