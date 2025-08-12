package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountantSectionPaymentParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ReimbrusementPaymentModel;
import nirmalya.aatithya.restmodule.master.model.AccountantSectionRestModel;

@Repository
public class RestAccountantSectionDao {
	Logger logger = LoggerFactory.getLogger(RestAccountantSectionDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// private Object value;
	
	
	
	/*
	 * Add payment Dao
	 * 
	 */
	public JsonResponse<Object> addAccountantSectionPaymnet(ReimbrusementPaymentModel Model) {

		logger.info("Method : addAccountantSectionPaymnet dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateAccountantSectionPaymentParam.getAccountantPayment(Model);
logger.info("ADDDVALUE"+values);
			if (Model.getReqId() != null && Model.getReqId() != "")  {
				logger.info("ADD" + values);
				em.createNamedStoredProcedureQuery("hrmsaccountsectionroutines")
						.setParameter("actionType", "addAccountantSectionPayment").setParameter("actionValue", values)
						.execute();

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		
		logger.info("ADDDDDDD"+resp);
		logger.info("Method : addAccountantSectionPaymnet dao ends");
		return resp;
	}
	
	
	
	// View

		@SuppressWarnings("unchecked")
		public JsonResponse<List<AccountantSectionRestModel>> viewAccountantSectionDetails(String userid) {
			logger.info("Method : viewAccountantSectionDetails  Dao starts");

			List<AccountantSectionRestModel> viewModel = new ArrayList<AccountantSectionRestModel>();

			JsonResponse<List<AccountantSectionRestModel>> resp = new JsonResponse<List<AccountantSectionRestModel>>();
			try {
				String value = "SET @p_userid='" + userid + "';";
				

				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsaccountsectionroutines")
						.setParameter("actionType", "viewAccountantSectionDetails").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					Object DATE = null;
					if (m[9] != null ) {
						DATE = DateFormatter.returnStringDate(m[9]);
					}
					AccountantSectionRestModel restStudentModel = new AccountantSectionRestModel(m[0].toString(),m[1].toString(), m[2].toString(),
							m[3].toString(), m[4].toString(), m[5], m[6],m[7],m[8],DATE);

					viewModel.add(restStudentModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// logger.info("viewAdvManagement" + resp);
			resp.setBody(viewModel);
			logger.info("VIEWWW"+resp);
			logger.info("Method : viewAccountantSectionDetails  Dao ends");
			return resp;
		}

	
}
