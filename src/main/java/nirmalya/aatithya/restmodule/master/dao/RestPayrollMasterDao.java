package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterPayroll;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestPayrollMasterModel;

@Repository
public class RestPayrollMasterDao {
	Logger logger = LoggerFactory.getLogger(RestPayrollMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBandTypeList() {
		logger.info("Method : getBandTypeList starts");

		List<DropDownModel> bandTypeList = new ArrayList<DropDownModel>();
		//String values = "SET @p_BandName='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("payroleMasterRoutines")
					.setParameter("actionType", "getBandTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bandTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
        logger.info("#######################################"+bandTypeList);
		logger.info("Method : getBandTypeList ends");
		return bandTypeList;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getComponentTypeList() {
		logger.info("Method : getComponentTypeList starts");

		List<DropDownModel> componentTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("payroleMasterRoutines")
					.setParameter("actionType", "getComponentTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				componentTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+componentTypeList);
		logger.info("Method : getComponentTypeList ends");
		return componentTypeList;
	}


	/**
	 * DAO Function to Add jobTypes
	 *
	 */
		public ResponseEntity<JsonResponse<Object>> addCalculationType(RestPayrollMasterModel restPayrollMasterModel) {
			logger.info("Method : Rest Add Job Type Dao starts");
			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();

			if (validity)
				try {
					String values = GenerateMasterPayroll.addSalaryAmount(restPayrollMasterModel);

					if (restPayrollMasterModel.getSalaryComponent() != null && restPayrollMasterModel.getSalaryComponent() != "") {
						em.createNamedStoredProcedureQuery("payroleMasterRoutines").setParameter("actionType", "addCalculationType")
								.setParameter("actionValue", values).execute();
					} else {
						em.createNamedStoredProcedureQuery("payroleMasterRoutines").setParameter("actionType", "addAmount")
								.setParameter("actionValue", values).execute();
					}

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
			logger.info("resp"+response);             
			logger.info("Method : Rest Add Job Type Dao ends");
			
			return response;
		}
		

@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestPayrollMasterModel>>> viewSalType(String id, String org, String orgDiv) {
			logger.info("Method : viewJobType starts");
			List<RestPayrollMasterModel> SalList = new ArrayList<RestPayrollMasterModel>();
			String values = "SET @p_BandName='"  + id + "',@p_org='"+ org + "',@p_orgDiv='"+orgDiv +"';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("payroleMasterRoutines")
						.setParameter("actionType", "viewSalType").setParameter("actionValue", values).getResultList();

				for (Object[] m : x) {

					RestPayrollMasterModel dropDownModel = new RestPayrollMasterModel(m[0].toString(),null,null,m[1].toString(),m[2].toString(),m[3].toString());
					SalList.add(dropDownModel);
					logger.info("RestPayrollMasterModel"+dropDownModel);			
				}
				logger.info("SalList"+SalList);
			} catch (Exception e){
				e.printStackTrace();
			}

			JsonResponse<List<RestPayrollMasterModel>> resp = new JsonResponse<List<RestPayrollMasterModel>>();
			resp.setBody(SalList);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			ResponseEntity<JsonResponse<List<RestPayrollMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestPayrollMasterModel>>>(
			resp, responseHeaders, HttpStatus.CREATED);
            logger.info("resp"+response);
			logger.info("Method : viewSalType ends");
			return response;
		}
		

}
