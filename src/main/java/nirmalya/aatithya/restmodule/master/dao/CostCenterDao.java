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
import nirmalya.aatithya.restmodule.common.utils.GenerateCostCenterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.CostCenterModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class CostCenterDao {
	Logger logger = LoggerFactory.getLogger(CostCenterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<CostCenterModel>> saveCostCenter(CostCenterModel costCenterModel) {
		logger.info("Method : saveCostCenter starts");

		Boolean validity = true;
		JsonResponse<CostCenterModel> resp = new JsonResponse<CostCenterModel>();
		resp.setMessage("");
		resp.setCode("");

		List<CostCenterModel> newLoc = new ArrayList<CostCenterModel>();

		if (costCenterModel.getCcName() == null || costCenterModel.getCcName() == "") {
			resp.setMessage(" Name Required");
			validity = false;
		
		}

		if (validity)
			try {
				String values = GenerateCostCenterParameter.saveCostCenter(costCenterModel);
logger.info(values);
				if (costCenterModel.getCcId() != null && costCenterModel.getCcId() != "") {
				
					List<Object[]> x = em.createNamedStoredProcedureQuery("costCenterRoutines")
							.setParameter("actionType", "modifyCostCenter").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						CostCenterModel item = new CostCenterModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8],null);
						newLoc.add(item);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("costCenterRoutines")
							.setParameter("actionType", "addCostCenter").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						CostCenterModel item = new CostCenterModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8],m[9]);
						newLoc.add(item);
					}
				}

				resp.setBody(newLoc.get(0));
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

		ResponseEntity<JsonResponse<CostCenterModel>> response = new ResponseEntity<JsonResponse<CostCenterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveCostCenter ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLabourType() {
		logger.info("Method : getLabourType starts");

		List<DropDownModel> labourList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("costCenterRoutines")
					.setParameter("actionType", "getLabourType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				labourList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBrandListForProduct ends");
		return labourList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCostNature() {
		logger.info("Method : getCostNature starts");

		List<DropDownModel> costNatureList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("costCenterRoutines")
					.setParameter("actionType", "getCostNature").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				costNatureList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBrandListForProduct ends");
		return costNatureList;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CostCenterModel>>> getAllCostCenterList() {
		logger.info("Method : getAllCostCenterList starts");
		
		JsonResponse<List<CostCenterModel>> resp = new JsonResponse<List<CostCenterModel>>();
		List<CostCenterModel> newLoc = new ArrayList<CostCenterModel>();
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("costCenterRoutines")
					.setParameter("actionType", "getCostCenterList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				CostCenterModel item = new CostCenterModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8],m[9]);
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
		
		ResponseEntity<JsonResponse<List<CostCenterModel>>> response = new ResponseEntity<JsonResponse<List<CostCenterModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getAllCostCenterList ends");
		return response;
	}
	

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CostCenterModel>>> getCostCenterListById(String id) {
		logger.info("Method : getCostCenterListById starts");
		
		JsonResponse<List<CostCenterModel>> resp = new JsonResponse<List<CostCenterModel>>();
		List<CostCenterModel> newLoc = new ArrayList<CostCenterModel>();
		
		try {
			String value = "SET @P_ccId='" + id + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("costCenterRoutines")
					.setParameter("actionType", "getCostCenterById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				CostCenterModel item = new CostCenterModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8],null);
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
		
		ResponseEntity<JsonResponse<List<CostCenterModel>>> response = new ResponseEntity<JsonResponse<List<CostCenterModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getCostCenterListById ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<CostCenterModel>> saveSubCostCenter(CostCenterModel costCenterModel) {
		logger.info("Method : saveSubCostCenter starts");
		
		Boolean validity = true;
		JsonResponse<CostCenterModel> resp = new JsonResponse<CostCenterModel>();
		resp.setMessage("");
		resp.setCode("");
		
		List<CostCenterModel> newLoc = new ArrayList<CostCenterModel>();
		
		if (costCenterModel.getCcName() == null || costCenterModel.getCcName() == "") {
			resp.setMessage(" Name Required");
			validity = false;
		
		}
		
		if (validity)
			try {
				String values = GenerateCostCenterParameter.saveCostCenter(costCenterModel);
				
				if (costCenterModel.getCcId() != null && costCenterModel.getCcId() != "") {
					logger.info("modifyCostCenter");
					List<Object[]> x = em.createNamedStoredProcedureQuery("costCenterRoutines")
							.setParameter("actionType", "modifyCostCenter").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						
						CostCenterModel item = new CostCenterModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8],null);
						newLoc.add(item);
					}
				} else {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("costCenterRoutines")
							.setParameter("actionType", "addSubCostCenter").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						
						CostCenterModel item = new CostCenterModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8],m[9]);
						newLoc.add(item);
					}
					
				}
				
				resp.setBody(newLoc.get(0));
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
		
		ResponseEntity<JsonResponse<CostCenterModel>> response = new ResponseEntity<JsonResponse<CostCenterModel>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveProductSubCategory ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CostCenterModel>>> getLeafListById(String id) {
		logger.info("Method : getLeafListById starts");
		
		JsonResponse<List<CostCenterModel>> resp = new JsonResponse<List<CostCenterModel>>();
		List<CostCenterModel> newLoc = new ArrayList<CostCenterModel>();
		
		try {
			String value = "SET @P_ParentID='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("costCenterRoutines")
					.setParameter("actionType", "getLeafListById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				CostCenterModel item = new CostCenterModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8],m[9]);
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
		
		ResponseEntity<JsonResponse<List<CostCenterModel>>> response = new ResponseEntity<JsonResponse<List<CostCenterModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getLeafListById ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteCostCenter(String id, String createdBy) {
		logger.info("Method : deleteCostCenter starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_ccId='" + id + "', @P_ModifiedBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("costCenterRoutines").setParameter("actionType", "deleteCostCenter")
					.setParameter("actionValue", value).execute();
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
		logger.info("Method : deleteCategory ends");
		return response;
	}
}
