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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateNoticePolicyParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.ManagePolicyRestModel;

@SuppressWarnings("unchecked")
@Repository
public class ManagePolicyDao {
	Logger logger = LoggerFactory.getLogger(ManagePolicyDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	
	// private Object value; 
	public List<DropDownModel> getDeptList(String organization,String orgDivision) {
		logger.info("Method : getDeptList Dao starts");

		List<DropDownModel> shiftList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				shiftList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDeptList Dao ends");

		return shiftList;
	}
	

	// Save Notice Policy
		public ResponseEntity<JsonResponse<ManagePolicyRestModel>> addNoticePolicy(ManagePolicyRestModel notice) {
			logger.info("Method : addNoticePolicy dao starts");
			
			JsonResponse<ManagePolicyRestModel> resp = new JsonResponse<ManagePolicyRestModel>();
			
			String value = GenerateNoticePolicyParameter.addNoticePolicy(notice);
			logger.info("value======"+notice.getPolicyDate());
			try {

				if (notice.getPolicyNo() == null || notice.getPolicyNo() == "" || notice.getPolicyNo().equals("null") || notice.getPolicyNo().equals("")) {
				
					logger.info("addd======"+notice.getPolicyDate());
					em.createNamedStoredProcedureQuery("hrmManagePolicy").setParameter("actionType", "addNotice")
								.setParameter("actionValue", value).execute();
				
				} else {
					em.createNamedStoredProcedureQuery("hrmManagePolicy").setParameter("actionType", "modifyPolicy")
							.setParameter("actionValue", value).execute();
				}
				
				resp.setCode("success");
				resp.setMessage("Data Save Succefully.");
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode("failed");
					resp.setMessage("Something went wrong");
					logger.info(err[1]);
				} catch (Exception e1) {
					resp.setCode("failed");
					e1.printStackTrace();
					resp.setMessage("Something went wrong");
				}
				e.printStackTrace();
			}

			ResponseEntity<JsonResponse<ManagePolicyRestModel>> response = new ResponseEntity<JsonResponse<ManagePolicyRestModel>>(
					resp, HttpStatus.CREATED);
			logger.info("response==="+response);
			logger.info("Method : addNoticePolicy dao ends");
			return response;
		}

}
