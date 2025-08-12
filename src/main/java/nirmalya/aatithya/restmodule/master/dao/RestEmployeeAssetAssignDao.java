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
import nirmalya.aatithya.restmodule.common.utils.GenerateEmpAssetAssign;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeAssetAssignModel;

@Repository
public class RestEmployeeAssetAssignDao {
	Logger logger = LoggerFactory.getLogger(RestEmployeeAssetAssignDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAssetList() {
		logger.info("Method : getDesignationDropDown starts");

		List<DropDownModel> getAssetList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeassetassign")
					.setParameter("actionType", "getAssetlist").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDown = new DropDownModel(m[0], m[1]);
				getAssetList.add(dropDown);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDesignationDropDown ends++++++++" + getAssetList);

		return getAssetList;
	}

	public ResponseEntity<JsonResponse<Object>> addAssetDetails(
			RestEmployeeAssetAssignModel RestEmployeeAssetAssignModel) {
		logger.info("Method : Rest saveDemoCategory  Dao starts");
		// Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("insuranceNewModel.getInsuranceid() ====" + RestEmployeeAssetAssignModel);

		// if (validity)
		try {

			String values = GenerateEmpAssetAssign.getAddassetassignParam(RestEmployeeAssetAssignModel);
			if (RestEmployeeAssetAssignModel.getEmpAssetId() == null
					|| RestEmployeeAssetAssignModel.getEmpAssetId() == "") {

				em.createNamedStoredProcedureQuery("employeeassetassign")
						.setParameter("actionType", "addassetassigndetails").setParameter("actionValue", values)
						.execute();
				resp.setCode("success");
				resp.setMessage("Asset Assigned Successfully");

			} else {

				logger.info("modify block");
				em.createNamedStoredProcedureQuery("employeeassetassign")
						.setParameter("actionType", "modifyAssetAssign").setParameter("actionValue", values).execute();
				resp.setCode("success");
				resp.setMessage("Assigned Details Modified Successfully");

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

		logger.info("Method : Rest saveDemoCategory  Dao ends");

		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestEmployeeAssetAssignModel>>> viewAssetAssign(String userId,
			String userRole ,String organization,String orgDivision) {
		// TODO Auto-generated method stub
		logger.info("Method : viewAssetAssign Dao starts");

		List<RestEmployeeAssetAssignModel> workList = new ArrayList<RestEmployeeAssetAssignModel>();

		try {
			String value = "SET @p_empId=\"" + userId + "\",@p_userRole='(" + userRole + ")',@p_organization=\"" + organization +"\",@p_orgDivision=\"" + orgDivision + "\";";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeassetassign")
					.setParameter("actionType", "viewassetassigndetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestEmployeeAssetAssignModel dropDownModel = new RestEmployeeAssetAssignModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6],m[7]);
				workList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestEmployeeAssetAssignModel>> resp = new JsonResponse<List<RestEmployeeAssetAssignModel>>();
		resp.setBody(workList);
		ResponseEntity<JsonResponse<List<RestEmployeeAssetAssignModel>>> response = new ResponseEntity<JsonResponse<List<RestEmployeeAssetAssignModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("RRRRRRRRRRRR===" + response);

		logger.info("Method : viewAssetAssign Dao ends");

		return response;

	}

	// edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestEmployeeAssetAssignModel>> editAssetAssign(String empAssetId) {
		logger.info("Method : editInsurance starts");

		RestEmployeeAssetAssignModel req = new RestEmployeeAssetAssignModel();
		JsonResponse<RestEmployeeAssetAssignModel> resp = new JsonResponse<RestEmployeeAssetAssignModel>();

		try {

			String value = "SET @empasetasgnid='" + empAssetId + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeassetassign")
					.setParameter("actionType", "editAssetAssign").setParameter("actionValue", value).getResultList();
			logger.info("############FFFFF" + value);
			for (Object[] m : x) {

				RestEmployeeAssetAssignModel reqemp = new RestEmployeeAssetAssignModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6],m[7]);
				req = reqemp;
			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestEmployeeAssetAssignModel>> response = new ResponseEntity<JsonResponse<RestEmployeeAssetAssignModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editInsurance ends");
		return response;
	}

	public JsonResponse<RestEmployeeAssetAssignModel> deleteAssetAssign(String empAssetId) {
		logger.info("Method : deleteDistrict starts");
		logger.info(empAssetId);

		RestEmployeeAssetAssignModel req = new RestEmployeeAssetAssignModel();
		JsonResponse<RestEmployeeAssetAssignModel> resp = new JsonResponse<RestEmployeeAssetAssignModel>();

		try {
			String value = "SET @empasetasgnid='(" + empAssetId + ")';";
			logger.info("DELETE " + value);

			em.createNamedStoredProcedureQuery("employeeassetassign").setParameter("actionType", "deleteAssetAssign")
					.setParameter("actionValue", value).execute();

			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();

		}

		logger.info("Method : deleteDistrict ends");
		logger.info("+++delete+++++" + resp);
		return resp;

	}


	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeId(String subDeptId, String orgName,
			String orgDivision) {

		logger.info("Method : getEmployeeId starts");

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> model = new ArrayList<DropDownModel>();

		String value = "SET @p_subDeptId='" + subDeptId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision
				+ "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeassetassign")
					.setParameter("actionType", "getEmployeeIdd").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DropDownModel item = new DropDownModel(m[0], m[1]);
				model.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(model);
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getEmployeeId ends");
		return response;
	}

}
