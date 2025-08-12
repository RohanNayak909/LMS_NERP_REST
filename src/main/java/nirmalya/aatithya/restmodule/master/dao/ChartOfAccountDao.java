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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateChartOfAccountParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.ChartOfAccountModel;

@RestController
@RequestMapping(value = "master/")
public class ChartOfAccountDao {
	Logger logger = LoggerFactory.getLogger(ChartOfAccountDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ChartOfAccountModel>> saveChartAccount(ChartOfAccountModel chartOfAccountModel) {
		logger.info("Method : saveCostCenter starts");

		Boolean validity = true;
		JsonResponse<ChartOfAccountModel> resp = new JsonResponse<ChartOfAccountModel>();
		resp.setMessage("");
		resp.setCode("");

		List<ChartOfAccountModel> newLoc = new ArrayList<ChartOfAccountModel>();

		if (chartOfAccountModel.getCcName() == null || chartOfAccountModel.getCcName() == "") {
			resp.setMessage(" Name Required");
			validity = false;
		
		}

		if (validity)
			try {
				String values = GenerateChartOfAccountParameter.saveChartOfAccountParam(chartOfAccountModel);
			
				if (chartOfAccountModel.getCcId() != null && chartOfAccountModel.getCcId() != "") {
				
					List<Object[]> x = em.createNamedStoredProcedureQuery("chartOfAcRoutines")
							.setParameter("actionType", "modifyChartAcc").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ChartOfAccountModel item = new ChartOfAccountModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8]);
						newLoc.add(item);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("chartOfAcRoutines")
							.setParameter("actionType", "addChartAcc").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ChartOfAccountModel item = new ChartOfAccountModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8]);
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

		ResponseEntity<JsonResponse<ChartOfAccountModel>> response = new ResponseEntity<JsonResponse<ChartOfAccountModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveChartAccount ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ChartOfAccountModel>>> getAllChartAccList() {
		logger.info("Method : getAllCostCenterList starts");
		
		JsonResponse<List<ChartOfAccountModel>> resp = new JsonResponse<List<ChartOfAccountModel>>();
		List<ChartOfAccountModel> newLoc = new ArrayList<ChartOfAccountModel>();
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("chartOfAcRoutines")
					.setParameter("actionType", "getCAList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				ChartOfAccountModel item = new ChartOfAccountModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8]);
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
		
		ResponseEntity<JsonResponse<List<ChartOfAccountModel>>> response = new ResponseEntity<JsonResponse<List<ChartOfAccountModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getAllCostCenterList ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ChartOfAccountModel>>> getCAListById(String id) {
		logger.info("Method : getCAListById starts");
		
		JsonResponse<List<ChartOfAccountModel>> resp = new JsonResponse<List<ChartOfAccountModel>>();
		List<ChartOfAccountModel> newLoc = new ArrayList<ChartOfAccountModel>();
		
		try {
			String value = "SET @P_ccId='" + id + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("chartOfAcRoutines")
					.setParameter("actionType", "getCAById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ChartOfAccountModel item = new ChartOfAccountModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8]);
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
		
		ResponseEntity<JsonResponse<List<ChartOfAccountModel>>> response = new ResponseEntity<JsonResponse<List<ChartOfAccountModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getCAListById ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteCAById(String id, String createdBy) {
		logger.info("Method : deleteCAById starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_ccId='" + id + "', @P_ModifiedBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("chartOfAcRoutines").setParameter("actionType", "deleteCA")
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
		logger.info("Method : deleteCAById ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ChartOfAccountModel>> saveSubCA(ChartOfAccountModel chartOfAccountModel) {
		logger.info("Method : saveSubCostCenter starts");
		
		Boolean validity = true;
		JsonResponse<ChartOfAccountModel> resp = new JsonResponse<ChartOfAccountModel>();
		resp.setMessage("");
		resp.setCode("");
		
		List<ChartOfAccountModel> newLoc = new ArrayList<ChartOfAccountModel>();
		
		if (chartOfAccountModel.getCcName() == null || chartOfAccountModel.getCcName() == "") {
			resp.setMessage(" Name Required");
			validity = false;
		
		}
		
		if (validity)
			try {
				String values = GenerateChartOfAccountParameter.saveChartOfAccountParam(chartOfAccountModel);
				
				if (chartOfAccountModel.getCcId() != null && chartOfAccountModel.getCcId() != "") {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("chartOfAcRoutines")
							.setParameter("actionType", "modifyChartAcc").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						ChartOfAccountModel item = new ChartOfAccountModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8]);
						newLoc.add(item);
					}
				} else {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("chartOfAcRoutines")
							.setParameter("actionType", "addSubCA").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						ChartOfAccountModel item = new ChartOfAccountModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8]);
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
		
		ResponseEntity<JsonResponse<ChartOfAccountModel>> response = new ResponseEntity<JsonResponse<ChartOfAccountModel>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : saveSubCostCenter ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ChartOfAccountModel>>> getChartLeafListById(String id) {
		logger.info("Method : getChartLeafListById starts");
		
		JsonResponse<List<ChartOfAccountModel>> resp = new JsonResponse<List<ChartOfAccountModel>>();
		List<ChartOfAccountModel> newLoc = new ArrayList<ChartOfAccountModel>();
		
		try {
			String value = "SET @P_ParentID='" + id + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("chartOfAcRoutines")
					.setParameter("actionType", "getCALeafListById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				ChartOfAccountModel item = new ChartOfAccountModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8]);
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
		
		ResponseEntity<JsonResponse<List<ChartOfAccountModel>>> response = new ResponseEntity<JsonResponse<List<ChartOfAccountModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : getChartLeafListById ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllLevel() {
		logger.info("Method : getAllLevel starts");

		List<DropDownModel> levelList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("chartOfAcRoutines")
					.setParameter("actionType", "getLevelList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0],m[1].toString());
				levelList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBrandListForProduct ends");
		return levelList;
	}
}
