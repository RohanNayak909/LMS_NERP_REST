/*
 * package nirmalya.aatithya.restmodule.master.dao;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import javax.persistence.EntityManager;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Repository;
 * 
 * import nirmalya.aatithya.restmodule.common.ServerDao; import
 * nirmalya.aatithya.restmodule.common.utils.JsonResponse; import
 * nirmalya.aatithya.restmodule.master.model.RestBankMasterModel;
 * 
 *//**
	 * @author NirmalyaLabs
	 *
	 *//*
		 * @Repository public class BankMasterDao {
		 * 
		 * Logger logger = LoggerFactory.getLogger(BankMasterDao.class);
		 * 
		 * @Autowired EntityManager em;
		 * 
		 * @Autowired ServerDao serverDao;
		 * 
		 * 
		 * @SuppressWarnings("unchecked") public
		 * ResponseEntity<JsonResponse<List<RestBankMasterModel>>> getTotalBankList() {
		 * logger.info("Method : getTotalBankList starts");
		 * 
		 * JsonResponse<List<RestBankMasterModel>> resp = new
		 * JsonResponse<List<RestBankMasterModel>>();
		 * 
		 * List<RestBankMasterModel> mailDtls = new ArrayList<RestBankMasterModel>();
		 * 
		 * try {
		 * 
		 * List<Object[]> x = em.createNamedStoredProcedureQuery("bankConfigRoutines")
		 * .setParameter("actionType", "getTotalBankList").setParameter("actionValue",
		 * "").getResultList(); for (Object[] m : x) {
		 * 
		 * RestBankMasterModel item = new RestBankMasterModel(m[0], m[1], m[2], m[3],
		 * m[4]); mailDtls.add(item); }
		 * 
		 * resp.setBody(mailDtls); } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * ResponseEntity<JsonResponse<List<RestBankMasterModel>>> response = new
		 * ResponseEntity<JsonResponse<List<RestBankMasterModel>>>( resp,
		 * HttpStatus.CREATED);
		 * 
		 * logger.info("Method : getTotalBankList ends"); return response; } }
		 */