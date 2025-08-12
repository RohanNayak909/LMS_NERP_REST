package nirmalya.aatithya.restmodule.his.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateBedMasterParameters;
import nirmalya.aatithya.restmodule.his.model.HISBedMasterRestModel;

@Repository
public class HISBedMasterDao {

	Logger logger = LoggerFactory.getLogger(HISBedMasterDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/* get bedcategory list */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBedCategoryTypeDao() {

		logger.info("Method : getBedCategoryTypeDao starts");

		List<DropDownModel> bedCategory = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hisBedMasterRoutines")
					.setParameter("actionType", "getBedCategoryType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bedCategory.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBedCategoryTypeDao ends" + bedCategory);
		return bedCategory;
	}

	/* get getFloorType list */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFloorTypeDao() {

		logger.info("Method : getFloorTypeDao starts");

		List<DropDownModel> floorType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hisBedMasterRoutines")
					.setParameter("actionType", "getFloorType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				floorType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getFloorTypeDao ends" + floorType);
		return floorType;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList() {

		logger.info("Method : getDepartmentList starts");

		List<DropDownModel> departType = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hisBedMasterRoutines")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentList ends" + departType);
		return departType;
	}

	/* getwardList */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getWardListDao(String id) {

		logger.info("Method : getWardListDao starts");
		List<DropDownModel> wardList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_floorId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hisBedMasterRoutines")
					.setParameter("actionType", "getWardList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				wardList.add(dropDownModel);
			}

			resp.setBody(wardList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getWardListDao ends" + response);
		return response;
	}

	/* DAO Function to Add */

	public ResponseEntity<JsonResponse<Object>> addBedMasterDao(HISBedMasterRestModel restData) {
		logger.info("Method : Rest addBedMasterDao   starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ADDDDDDID" + restData);

		if (validity)
			try {
				String values = GenerateBedMasterParameters.getBedMasterParam(restData);

				if (restData.getBedId() == null || restData.getBedId() == "") {
					System.out.println("addddd in daooooooooooo" + restData);
					em.createNamedStoredProcedureQuery("hisBedMasterRoutines")
							.setParameter("actionType", "addBedMaster").setParameter("actionValue", values).execute();

				}

				else {
					System.out.println("MODIFYYYYYYY  in daooooooooo " + restData);
					System.out.println("VALUEEEEE" + values);
					em.createNamedStoredProcedureQuery("hisBedMasterRoutines")
							.setParameter("actionType", "modifyBedMaster").setParameter("actionValue", values)
							.execute();
				}
				System.out.println("VALLLLUUUUUUEEEEE" + values);
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

		logger.info("Method : Rest addBedMaster Dao ends" + response);
		return response;

	}

	/* view */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<HISBedMasterRestModel>> viewBedMasterDao() {
		logger.info("Method : viewBedMasterDao starts");

		List<HISBedMasterRestModel> viewMasterData = new ArrayList<HISBedMasterRestModel>();
		JsonResponse<List<HISBedMasterRestModel>> resp = new JsonResponse<List<HISBedMasterRestModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hisBedMasterRoutines")
					.setParameter("actionType", "viewBedMaster").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				System.out.println("x====" + x);
				HISBedMasterRestModel restMasterData = new HISBedMasterRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9],m[10]);
				viewMasterData.add(restMasterData);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(viewMasterData);
		logger.info("Method : viewBedMasterDao ends");
		System.out.println("VIEWWWWW" + resp);

		return resp;
	}

	/* edit */

	@SuppressWarnings("unchecked")
	public JsonResponse<HISBedMasterRestModel> editBedMasterDao(String id, String orgName, String orgDivision,
			String uId) {
		logger.info("Method : editMaster Dao starts");
		System.out.println("Edit" + id);
		HISBedMasterRestModel req = new HISBedMasterRestModel();
		JsonResponse<HISBedMasterRestModel> resp = new JsonResponse<HISBedMasterRestModel>();
		try {
			String value = "SET @p_bedId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hisBedMasterRoutines")
					.setParameter("actionType", "editBedMaster").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				HISBedMasterRestModel restData = new HISBedMasterRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7],m[8]);
				req = restData;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editMaster Dao ends" + resp);
		return resp;
	}

	/* delete */

	public ResponseEntity<JsonResponse<Object>> deleteBed(String id) {
		logger.info("Method : deleteBed Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {

			String value = "SET @p_bedId='" + id + "';";

			em.createNamedStoredProcedureQuery("hisBedMasterRoutines").setParameter("actionType", "deleteBed")
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

		logger.info("Method : deleteBed Dao ends");
		System.out.println("DELETEE" + response);
		return response;
	}

}
