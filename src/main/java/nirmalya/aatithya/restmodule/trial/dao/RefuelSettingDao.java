package nirmalya.aatithya.restmodule.trial.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateOrgMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateOrganisationHoliday;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.trial.GenerateRefuelSettingParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.trial.model.RefuelSettingRestModel;

@Repository
public class RefuelSettingDao {

	Logger logger = LoggerFactory.getLogger(RefuelSettingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// dao for vehicle

	@SuppressWarnings("unchecked")
	public List<DropDownModel> fetchvehiclereglist() {
		logger.info("Method : getIssueList starts");

		List<DropDownModel> vgreg = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vmRefuelSetting")
					.setParameter("actionType", "vm_fetchVehicleRegList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel vgdropDownModel = new DropDownModel(m[0], m[1]);
				System.out.println("Vehicle Reg" + vgdropDownModel);
				vgreg.add(vgdropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getIssueList ends");
		return vgreg;
	}

	// dao for fuel

	@SuppressWarnings("unchecked")
	public List<DropDownModel> fetchfueltypelist() {
		logger.info("Method : getVehicleList starts");

		List<DropDownModel> ftype = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("vmRefuelSetting")
					.setParameter("actionType", "vm_fetchFuelList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel ftypedropDownModel = new DropDownModel(m[0], m[1]);
				System.out.println("Fuel Type" + ftypedropDownModel);
				ftype.add(ftypedropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVehicleList ends");
		return ftype;
	}

	// add

	public ResponseEntity<JsonResponse<Object>> addrefueldetails(RefuelSettingRestModel restPayroll) {
		logger.info("Method : Rest vehicle Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		// System.out.println("restPayroll.getpId() ====" + restPayroll.getpId());

		if (validity)
			try {

				String values = GenerateRefuelSettingParam.addvehicleparam(restPayroll);

				if (restPayroll.getRfsettingid() == null || restPayroll.getRfsettingid() == "") {

					em.createNamedStoredProcedureQuery("vmRefuelSetting").setParameter("actionType", "vm_addrefuel")
							.setParameter("actionValue", values).execute();

				} else {

					em.createNamedStoredProcedureQuery("vmRefuelSetting").setParameter("actionType", "vm_modifyrefuel")
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

		logger.info("Method : Rest VehicleDao ends");

		return response;
	}

	// DAO for view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RefuelSettingRestModel>>> viewrefueldetails() {
		logger.info("Method : viewissuedetails starts");

		List<RefuelSettingRestModel> respList = new ArrayList<RefuelSettingRestModel>();
		JsonResponse<List<RefuelSettingRestModel>> resp = new JsonResponse<List<RefuelSettingRestModel>>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vmRefuelSetting")
					.setParameter("actionType", "vm_viewrefuel").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				Object DATE = null;
				if (m[5] != null) {
					DATE = DateFormatter.returnStringDate(m[5]);
				}

				RefuelSettingRestModel restDetails = new RefuelSettingRestModel(m[0], m[1], m[2], m[3], m[4], DATE,
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17],
						m[18].toString(), m[19]);
				respList.add(restDetails);
			}

			System.out.println("POLICY" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		resp.setBody(respList);

		ResponseEntity<JsonResponse<List<RefuelSettingRestModel>>> response = new ResponseEntity<JsonResponse<List<RefuelSettingRestModel>>>(
				resp, HttpStatus.CREATED);

		System.out.println("response" + response);
		logger.info("Method : viewissuedetails ends");
		return response;
	}

	// edit DAO

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RefuelSettingRestModel>>> editrefueldetails(String id) {
		// TODO Auto-generated method stub
		logger.info("Method : editIssue starts");

		JsonResponse<List<RefuelSettingRestModel>> resp = new JsonResponse<List<RefuelSettingRestModel>>();
		List<RefuelSettingRestModel> newResp = new ArrayList<RefuelSettingRestModel>();

		try {
			String value = "SET @p_rfsettingid='" + id + "';";
			System.out.println("aa" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vmRefuelSetting")
					.setParameter("actionType", "vm_editrefuel").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object DATE = null;
				if (m[5] != null) {
					DATE = DateFormatter.returnStringDate(m[5]);
				}

				RefuelSettingRestModel restDetails = new RefuelSettingRestModel(m[0], m[1], m[2], m[3], m[4], DATE,
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18].toString(), m[19]);

				newResp.add(restDetails);
				System.out.println("Output=" + restDetails);
			}

			resp.setBody(newResp);

		}

		catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RefuelSettingRestModel>>> response = new ResponseEntity<JsonResponse<List<RefuelSettingRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : editDetails ends");
		return response;

	}

	// DELETE DAO

	public ResponseEntity<JsonResponse<Object>> deleterefueldetails(String id) {
		logger.info("Method : deleteIssue starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_rfsettingid='" + id + "';";

				em.createNamedStoredProcedureQuery("vmRefuelSetting").setParameter("actionType", "vm_deleterefuel")
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

		logger.info("Method : deleteIssue ends");
		System.out.println("DELETE2" + response);
		return response;
	}

}
