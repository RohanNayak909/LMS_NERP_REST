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
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterReferenceIncomeTax;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestIncomeTaxMasterModel;

@Repository
public class RestIncomeTaxMasterDao {
	Logger logger = LoggerFactory.getLogger(RestIncomeTaxMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * 
	 * IncomeTax Slab Master
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getcatagoryName() {

		logger.info("Method : getcatagoryName starts");
		List<DropDownModel> countryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("PayrollTaxCatagory")
					.setParameter("actionType", "getSlabName").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getcatagoryName end");
		return countryList;

	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFinancialYrForIncometax() {
		// TODO Auto-generated method stub
		logger.info("Method : getFinancialYrForIncometax starts");
		List<DropDownModel> financialYr = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("PayrollTaxCatagory")
					.setParameter("actionType", "getFinancialYrType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				financialYr.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFinancialYrForIncometax end");
		return financialYr;

	}

	/**
	 * DAO Function to Add
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addslabMaster(RestIncomeTaxMasterModel restPayroll) {
		logger.info("Method : Rest addslabMaster  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("restPayroll.getsId() ====" + restPayroll.getsId());

		if (validity)
			try {

				String values = GenerateMasterReferenceIncomeTax.addIncomeTaxParam(restPayroll);

				if (restPayroll.getsId() == null || restPayroll.getsId() == "") {

					em.createNamedStoredProcedureQuery("PayrollTaxCatagory").setParameter("actionType", "addSlabMaster")
							.setParameter("actionValue", values).execute();

				} else {

					em.createNamedStoredProcedureQuery("PayrollTaxCatagory")
							.setParameter("actionType", "modifySlabMaster").setParameter("actionValue", values)
							.execute();
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

		logger.info("Method : Rest Add slabmaster  Dao ends");

		return response;

	}

	// view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestIncomeTaxMasterModel>>> viewSlabMaster(String org, String orgDiv) {
		logger.info("Method : viewSlabMaster starts");
		List<RestIncomeTaxMasterModel> respList = new ArrayList<RestIncomeTaxMasterModel>();

		try {
			String values = "SET @p_org='"+ org + "',@p_orgDiv='"+orgDiv +"';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("PayrollTaxCatagory")
					.setParameter("actionType", "viewSlabMaster").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				RestIncomeTaxMasterModel restPayroll = new RestIncomeTaxMasterModel(m[0].toString(), m[1], m[2], m[3]);
				respList.add(restPayroll);

			}
		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestIncomeTaxMasterModel>> resp = new JsonResponse<List<RestIncomeTaxMasterModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestIncomeTaxMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestIncomeTaxMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewSlabMaster ends");
		return response;

	}

//add 

	public ResponseEntity<JsonResponse<Object>> addIncomeMaster(RestIncomeTaxMasterModel restPayroll) {
		logger.info("Method : Rest addslabMaster  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {

				String values = GenerateMasterReferenceIncomeTax.addTaxCatagoryParam(restPayroll);
				em.createNamedStoredProcedureQuery("PayrollTaxCatagory")
						.setParameter("actionType", "addIncomeSlabMaster").setParameter("actionValue", values)
						.execute();
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

		logger.info("Method : Rest Add slabmaster  Dao ends");

		return response;

	}

	// view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestIncomeTaxMasterModel>>> viewIncomeMaster(String org, String orgDiv) {
		logger.info("Method : viewIncomeMaster starts");
		List<RestIncomeTaxMasterModel> respList = new ArrayList<RestIncomeTaxMasterModel>();

		try {
			String values = "SET @p_org='"+ org + "',@p_orgDiv='"+orgDiv +"';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("PayrollTaxCatagory")
					.setParameter("actionType", "viewIncomeMaster").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				RestIncomeTaxMasterModel restPayroll = new RestIncomeTaxMasterModel(m[0], m[1], m[2],
						m[3], m[4],m[5],m[6],null);
				respList.add(restPayroll);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		JsonResponse<List<RestIncomeTaxMasterModel>> resp = new JsonResponse<List<RestIncomeTaxMasterModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestIncomeTaxMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestIncomeTaxMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewIncomeMaster ends");
		return response;

	}

//add 

	public ResponseEntity<JsonResponse<Object>> addProfessionalMaster(RestIncomeTaxMasterModel restPayroll) {
		logger.info("Method : Rest addProfessionalMaster  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String values = GenerateMasterReferenceIncomeTax.addProfessionalTaxParam(restPayroll);
				em.createNamedStoredProcedureQuery("PayrollTaxCatagory")
						.setParameter("actionType", "addProfessionalMaster").setParameter("actionValue", values)
						.execute();
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

		logger.info("Method : Rest addProfessionalMaster  Dao ends");

		return response;

	}

	// view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestIncomeTaxMasterModel>>> viewProfessionalMaster(String org, String orgDiv) {
		logger.info("Method : viewProfessionalMaster starts");
		List<RestIncomeTaxMasterModel> respList = new ArrayList<RestIncomeTaxMasterModel>();

		try {
			String values = "SET @p_org='"+ org + "',@p_orgDiv='"+orgDiv +"';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("PayrollTaxCatagory")
					.setParameter("actionType", "viewProfessionalMaster").setParameter("actionValue",values)
					.getResultList();
			for (Object[] m : x) {
				RestIncomeTaxMasterModel restPayroll = new RestIncomeTaxMasterModel(m[0], m[1], m[2],
						m[3], m[4],m[5],m[6]);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestIncomeTaxMasterModel>> resp = new JsonResponse<List<RestIncomeTaxMasterModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestIncomeTaxMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestIncomeTaxMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewProfessionalMaster ends");
		return response;

	}

	// delete
	public ResponseEntity<JsonResponse<Object>> deleteslabmaster(String id) {

		logger.info("Method : deleteslabmaster Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_sId='" + id + "';";

			em.createNamedStoredProcedureQuery("PayrollTaxCatagory").setParameter("actionType", "deleteslabmaster")
					.setParameter("actionValue", values).execute();

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

		logger.info("Method : deleteslabmaster Dao ends");
		return response;
	}

	// deleteProfessionalslabmaster

	public ResponseEntity<JsonResponse<Object>> deleteProfessionalslabmaster(String id) {

		logger.info("Method : deleteProfessionalslabmaster Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_prId='" + id + "';";

			em.createNamedStoredProcedureQuery("PayrollTaxCatagory")
					.setParameter("actionType", "deleteProfessionalslabmaster").setParameter("actionValue", values)
					.execute();

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

		logger.info("Method : deleteProfessionalslabmaster Dao ends");
		return response;
	}

	// deleteProfessionalslabmaster

	public ResponseEntity<JsonResponse<Object>> deleteIncometaxmaster(String id) {

		logger.info("Method : deleteIncometaxmaster Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_incomeId='" + id + "';";

			em.createNamedStoredProcedureQuery("PayrollTaxCatagory")
					.setParameter("actionType", "deleteIncometaxmaster").setParameter("actionValue", values)
					.execute();

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

		logger.info("Method : deleteIncometaxmaster Dao ends");
		return response;
	}
}
