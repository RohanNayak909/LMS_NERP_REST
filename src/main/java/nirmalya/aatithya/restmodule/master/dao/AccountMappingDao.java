package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountMappingParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.AccountMappingModel;
import nirmalya.aatithya.restmodule.master.model.ChartOfAccountModel;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("master")
public class AccountMappingDao {
	Logger logger = LoggerFactory.getLogger(AccountMappingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	public ResponseEntity<JsonResponse<Object>> accountMappingSave(List<AccountMappingModel> accountMappingModel) {
		logger.info("Method : accountMappingSave starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		for (AccountMappingModel l : accountMappingModel) {

			if (l.getCostCenterId() == null || l.getCostCenterId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Cost Center Required");
				break;
			} else if (l.getChartOfAcId() == null || l.getChartOfAcId() == "") {
				validity = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Chart Account Id Required");
				break;
			} 
		}
		if (Boolean.TRUE.equals(validity)) {
			try {
				String values = GenerateAccountMappingParameter.accountMappingSave(accountMappingModel);

				if (accountMappingModel.get(0).getMappingId() != null && accountMappingModel.get(0).getMappingId() != "") {
					em.createNamedStoredProcedureQuery("accountMappingRoutines")
							.setParameter("actionType", "addAccountMapping").setParameter("actionValue", values).execute();
				} else {
					em.createNamedStoredProcedureQuery("accountMappingRoutines")
							.setParameter("actionType", "addAccountMapping").setParameter("actionValue", values)
							.execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : accountMappingSave ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountMappingModel>>> getAllAccMappingList() {
		logger.info("Method : getAllAccMappingList starts");
		
		JsonResponse<List<AccountMappingModel>> resp = new JsonResponse<List<AccountMappingModel>>();
		List<AccountMappingModel> newLoc = new ArrayList<AccountMappingModel>();
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("accountMappingRoutines")
					.setParameter("actionType", "getCostList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				AccountMappingModel item = new AccountMappingModel(m[0], null,m[1], null, null);
				newLoc.add(item);
			}

			resp.setBody(newLoc);
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
		
		ResponseEntity<JsonResponse<List<AccountMappingModel>>> response = new ResponseEntity<JsonResponse<List<AccountMappingModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getAllAccMappingList ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountMappingModel>>> getAccMapListById(String id) {
		logger.info("Method : getAccMapListById starts");
		
		JsonResponse<List<AccountMappingModel>> resp = new JsonResponse<List<AccountMappingModel>>();
		List<AccountMappingModel> newLoc = new ArrayList<AccountMappingModel>();
		
		try {
			String value = "SET @P_ccId='" + id + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("accountMappingRoutines")
					.setParameter("actionType", "getCAByCostId").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				AccountMappingModel item = new AccountMappingModel(null, m[0],null, m[1], null);
				newLoc.add(item);
			}

			resp.setBody(newLoc);
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
		
		ResponseEntity<JsonResponse<List<AccountMappingModel>>> response = new ResponseEntity<JsonResponse<List<AccountMappingModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getAccMapListById ends");
		return response;
	}
}
