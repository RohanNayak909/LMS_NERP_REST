package nirmalya.aatithya.restmodule.employee.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateGradeSalaryNewParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestGradeSalaryNewMasterModel;

@Repository
public class RestGradeSalaryNewDao {
	Logger logger = LoggerFactory.getLogger(RestGradeSalaryNewDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGradeNameNewList() {

		logger.info("Method : getGradeNameNewList starts");

		List<DropDownModel> gradeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalarynewRoutines")
					.setParameter("actionType", "getGradeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				gradeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getGradeNameNewList ends");

		return gradeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getComponenmewtList() {

		logger.info("Method : getComponenmewtList starts");

		List<DropDownModel> getComponentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalarynewRoutines")
					.setParameter("actionType", "getComponentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getComponentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getComponenmewtList ends");

		return getComponentList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCalnewtList() {

		logger.info("Method : getCalnewtList starts");

		List<DropDownModel> getComponentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalarynewRoutines")
					.setParameter("actionType", "getCalnewtList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getComponentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCalnewtList ends");

		return getComponentList;
	}

	/*
	 * DAO Function to view particular Description for Grade
	 *
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGradeDescription(String id) {
		logger.info("Method : getGradeDescription starts");
		List<DropDownModel> gradeDesc = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_grade='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalarynewRoutines")
					.setParameter("actionType", "getGradeDescription").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				gradeDesc.add(dropDownModel);
			}

			resp.setBody(gradeDesc);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getGradeDescription ends");

		return response;
	}

	/*
	 * DAO Function to view particular Component type for Selected Salary Component
	 *
	 * 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGradeSalaryNewMasterModel>>> getgrdsalComponentType(String id) {
		logger.info("Method : getgrdsalComponentType starts");
		List<RestGradeSalaryNewMasterModel> componentType = new ArrayList<RestGradeSalaryNewMasterModel>();
		JsonResponse<List<RestGradeSalaryNewMasterModel>> resp = new JsonResponse<List<RestGradeSalaryNewMasterModel>>();
		String value = "SET @p_component='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalarynewRoutines")
					.setParameter("actionType", "getsalComponentType").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestGradeSalaryNewMasterModel dropDownModel = new RestGradeSalaryNewMasterModel(null, null, null, null,
						null, null, null, m[0],m[1], null, null);
				componentType.add(dropDownModel);
			}
			logger.info("componentType" + componentType);
			resp.setBody(componentType);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestGradeSalaryNewMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestGradeSalaryNewMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getgrdsalComponentType ends");

		return response;
	}

	/*
	 * add
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGradeSalaryNewMasterModel>>> addgrdSalarynew(
			List<RestGradeSalaryNewMasterModel> restGradeSalaryNewMasterModel) {

		logger.info("Method : addgrdSalarynew starts");

		logger.info("RestGradeSalaryNewMasterModel" + restGradeSalaryNewMasterModel);
		JsonResponse<List<RestGradeSalaryNewMasterModel>> resp = new JsonResponse<List<RestGradeSalaryNewMasterModel>>();
		List<RestGradeSalaryNewMasterModel> listData = new ArrayList<RestGradeSalaryNewMasterModel>();

		try {
			String values = GenerateGradeSalaryNewParameter.addGradeSalaryParam(restGradeSalaryNewMasterModel);
			logger.info("value#" + values);

			if (restGradeSalaryNewMasterModel.get(0).getGrade() == null
					|| restGradeSalaryNewMasterModel.get(0).getGrade() == "") {

				em.createNamedStoredProcedureQuery("gradeSalarynewRoutines")
						.setParameter("actionType", "addgrdSalarynew").setParameter("actionValue", values).execute();
				logger.info("add print" + restGradeSalaryNewMasterModel.get(0).getGrade());

			} else {
				
				logger.info("@modify" + values);
				em.createNamedStoredProcedureQuery("gradeSalarynewRoutines")
						.setParameter("actionType", "modifygrdSalarynew").setParameter("actionValue", values).execute();

				logger.info("modify print" + restGradeSalaryNewMasterModel.get(0).getGrade());

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
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestGradeSalaryNewMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestGradeSalaryNewMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addgrdSalarynew ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestGradeSalaryNewMasterModel>> getAllgrdsal() {
		logger.info("Method : getAllgrdsal Dao starts");

		List<RestGradeSalaryNewMasterModel> getAllemployee = new ArrayList<RestGradeSalaryNewMasterModel>();
		JsonResponse<List<RestGradeSalaryNewMasterModel>> resp = new JsonResponse<List<RestGradeSalaryNewMasterModel>>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalarynewRoutines")
					.setParameter("actionType", "viewgrdsalnewr").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestGradeSalaryNewMasterModel viewdemo = new RestGradeSalaryNewMasterModel( m[0], m[1], m[2], m[3],
						m[4],m[5],null, null, null, null, null);
				getAllemployee.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(getAllemployee);
		logger.info("Method : getAllgrdsal Dao ends");

		return resp;

	}
	
	  
	/*
	 * edit
	 */
	  
	@SuppressWarnings("unchecked")
	public List<RestGradeSalaryNewMasterModel> viewgrdSalEdit(String id) {
		logger.info("Method : viewgrdSalEdit starts");
		logger.info("RestGradeSalaryNewMasterModel" + id);
		List<RestGradeSalaryNewMasterModel> getRequisitionTypeList = new ArrayList<RestGradeSalaryNewMasterModel>();

		try {
			String values = "SET @p_grdsalesId='" + id + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gradeSalarynewRoutines")
					.setParameter("actionType", "getgrdSalEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					RestGradeSalaryNewMasterModel dropDownModel = new RestGradeSalaryNewMasterModel( 
							m[0], m[1], m[2], m[3],m[4],m[5], null, m[6], m[7], m[8], m[9]);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : viewgrdSalEdit ends");
		return getRequisitionTypeList;
	}
	  
	  
	/*  delete
	  */
	  
	public JsonResponse<RestGradeSalaryNewMasterModel> deletegrdsal(String selectedRowsString) {
		logger.info("Method : deletegrdsal starts");

	RestGradeSalaryNewMasterModel req = new RestGradeSalaryNewMasterModel();
		JsonResponse<RestGradeSalaryNewMasterModel> resp = new JsonResponse<RestGradeSalaryNewMasterModel >();

		try {
			String value = "SET  @p_custId='(" + selectedRowsString + ")';";
			logger.info("DELETE " + value);

			em.createNamedStoredProcedureQuery("gradeSalarynewRoutines").setParameter("actionType", "deletegrdsal")
					.setParameter("actionValue", value).
					execute();
			
			
			resp.setBody(req);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		
		logger.info("Method : deletegrdsal ends");
		return resp;
		
	}
	 
}
