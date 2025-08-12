
package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestManualJournalModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateAccountManualJournalParameter;

import org.springframework.http.HttpHeaders;

@Repository
public class RestManualJournalDao {
	
	Logger logger = LoggerFactory.getLogger(RestManualJournalDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	    /*
		 * getCustomerNameSearch
		 * 
		 */

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestManualJournalModel>>> getCustomerNameSearch(String id) {
			logger.info("Method : getCustomerNameSearch starts");

			List<RestManualJournalModel> itemNameList = new ArrayList<RestManualJournalModel>();
			JsonResponse<List<RestManualJournalModel>> resp = new JsonResponse<List<RestManualJournalModel>>();
			String value = "SET @p_searchValue='" + id + "';";
			System.out.println("value for search------------" + value);

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("acc_manual_journal_routines")
						.setParameter("actionType", "getCustomerSearch").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					RestManualJournalModel dropDownModel = new RestManualJournalModel(m[0], m[1]);
					itemNameList.add(dropDownModel);
				}
				resp.setBody(itemNameList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			ResponseEntity<JsonResponse<List<RestManualJournalModel>>> response = new ResponseEntity<JsonResponse<List<RestManualJournalModel>>>(
					resp, HttpStatus.CREATED);
			
			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}
			
			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : getCustomerNameSearch ends");
			return response;
		}

		
		//addManualJournalVoucher(restManualJournalModel);
		
		

/**
 * DAO Function to Add addManualJournalVoucher
 */
	public ResponseEntity<JsonResponse<Object>> addManualJournalVoucher(
			List<RestManualJournalModel> restManualJournalModel) {
		logger.info("Method : addManualJournalVoucher starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (RestManualJournalModel l : restManualJournalModel) {
			if (l.getCostCenter()== null || l.getCostCenter() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Cost Center.");
				break;
			} else if (l.getDescription() == null || l.getDescription() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Description.");
				break;
			} 
		}

		if (validation) {

			try {
				String value = GenerateAccountManualJournalParameter.saveManualJournalParam(restManualJournalModel);

				em.createNamedStoredProcedureQuery("acc_manual_journal_routines")
						.setParameter("actionType", "addManualJournal").setParameter("actionValue", value).execute();
				// }
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
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addManualJournalVoucher ends");
		return response;
	}

//restViewManualDlts
		
			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<RestManualJournalModel>>> restViewManualDlts() {
				logger.info("Method : restViewManualDlts starts");
				List<RestManualJournalModel> respList = new ArrayList<RestManualJournalModel>();
				try {
					List<Object[]> x = em.createNamedStoredProcedureQuery("acc_manual_journal_routines").setParameter("actionType", "viewManualJournalDtls")
							.setParameter("actionValue", "").getResultList();

					for (Object[] m : x) {
					
					  String dateJournal=null; 
					  if(m[1]!=null) {
						  dateJournal=m[1].toString(); 
					   }
					 
						
						RestManualJournalModel restPayroll = new RestManualJournalModel(m[0], dateJournal, m[2], m[3], m[4], m[5], m[6].toString(),m[7]);
						respList.add(restPayroll); 

					}

					System.out.println("VIEW" + respList);

				} catch (Exception e) {

					e.printStackTrace();

				}

				JsonResponse<List<RestManualJournalModel>> resp = new JsonResponse<List<RestManualJournalModel>>();
				resp.setBody(respList);
				ResponseEntity<JsonResponse<List<RestManualJournalModel>>> response = new ResponseEntity<JsonResponse<List<RestManualJournalModel>>>(
						resp, HttpStatus.CREATED);
				System.out.println("response" + response);
				logger.info("Method : restViewManualDlts ends");
				
				if (resp.getMessage() == null) {
					resp.setMessage("View successfully");
				}
				
				if (resp.getCode() == null) {
					resp.setCode("Success");
				}

				System.out.println("VIEWWWWWWWW" + respList);
				return response;

			}
			
//deleteManualJournal

			public ResponseEntity<JsonResponse<Object>> deleteManualJournal(String id) {
				logger.info("Method : deleteManualJournal starts");

				Boolean validity = true;
				JsonResponse<Object> resp = new JsonResponse<Object>();
				System.out.println("ID...."+id);
				if (validity)
					try {			
						String value = "SET  @p_journalVId='(" + id + ")';";
						em.createNamedStoredProcedureQuery("acc_manual_journal_routines")
								.setParameter("actionType", "deleteManualJournal").setParameter("actionValue", value).execute();

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

				ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
						HttpStatus.CREATED);
				
				if (resp.getMessage() == null) {
					resp.setMessage("Deleted successfully");
				}
				
				if (resp.getCode() == null) {
					resp.setCode("Success");
				}

				logger.info("Method :  deleteManualJournal ends");
				System.out.println("DELETE" + response);
				return response;
			}
			
			//editManualJournalInfo
			
			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<RestManualJournalModel>>>editManualJournalInfo(String id) {
				logger.info("Method : editManualJournalInfo starts");

				JsonResponse<List<RestManualJournalModel>> resp = new JsonResponse<List<RestManualJournalModel>>();
				List<RestManualJournalModel> rs = new ArrayList<RestManualJournalModel>();

				try {

					String value = "SET @p_journalVouId='" + id +"';";
					System.out.println(value);

					List<Object[]> x = em.createNamedStoredProcedureQuery("acc_manual_journal_routines")
							.setParameter("actionType", "editManualJournalinfo").setParameter("actionValue", value).getResultList();
					System.out.println("asdfasdf"+x);
		           
					for (Object[] m : x) {
						
						/*String contraDate=null;
						if(m[3]!=null) {
							contraDate=m[3].toString();
						}*/
						
						RestManualJournalModel restPayroll = new RestManualJournalModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6].toString(),m[7]);
						
						/*RestManualJournalModel restPayroll = new RestManualJournalModel(m[0], m[1], m[2], contraDate, m[4], m[5], m[6],
								m[7], m[8], m[9], m[10], m[11], m[12], m[13],m[14], m[15], m[16],
								m[17], m[18], m[19], m[20], m[21], m[22].toString(), m[23].toString());*/
						rs.add(restPayroll);
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
					resp.setBody(rs);
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("MyResponseHeader", "MyValue");

				ResponseEntity<JsonResponse<List<RestManualJournalModel>>> response = new ResponseEntity<JsonResponse<List<RestManualJournalModel>>>(resp,responseHeaders,
						HttpStatus.CREATED);

				logger.info("Method : editManualJournalInfo ends");
				
				if (resp.getMessage() == null) {
					resp.setMessage("View successfully");
				}
				
				if (resp.getCode() == null) {
					resp.setCode("Success");
				}
				
				System.out.println(response);
				return response;
			}
	


}

