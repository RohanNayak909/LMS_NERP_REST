package nirmalya.aatithya.restmodule.his.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateBedCategoryParameter;
import nirmalya.aatithya.restmodule.his.model.RestHISConfigurationModel;

@RestController
@RequestMapping(value = { "his" })
public class RestHISConfigurationDao {

	Logger logger = LoggerFactory.getLogger(RestHISConfigurationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGroupId() {

		logger.info("Method : getGroupId starts");

		List<DropDownModel> group = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
					.setParameter("actionType", "getGroupId").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				group.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getGroupId ends" + group);
		return group;
	}

	/* Bed add */

	public ResponseEntity<JsonResponse<Object>> addBedCategoryMaster(RestHISConfigurationModel beddetails) {
		logger.info("Method : Rest addBedCategoryMaster   starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ADDDDDDID" + beddetails);

		if (validity)
			try {
				String values = GenerateBedCategoryParameter.getAddempParam(beddetails);

				if (beddetails.getBedcat() == null || beddetails.getBedcat() == "") {
					System.out.println("addddd in daooooooooooo" + beddetails);
					em.createNamedStoredProcedureQuery("his_bed_routines")
							.setParameter("actionType", "addBedCategoryMaster").setParameter("actionValue", values)
							.execute();

				}

				else {
					System.out.println("MODIFYYYYYYY  in daooooooooo " + beddetails);
					System.out.println("VALUEEEEE" + values);
					em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "modifyBedCate")
							.setParameter("actionValue", values).execute();
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

		logger.info("Method : Rest addBedCategoryMaster Dao ends" + response);
		return response;

	}

	/// view bed category

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewBedcat() {
		logger.info("Method : viewBedcat starts");
		List<RestHISConfigurationModel> respList = new ArrayList<RestHISConfigurationModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
					.setParameter("actionType", "viewBedcat").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
						m[3], m[4], m[5]);
				respList.add(restHISConfigurationModel);
				logger.info("RestHISConfigurationModel" + restHISConfigurationModel);
			}
			logger.info("respList" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewBedcat ends");
		return response;
	}

	// edit Bed Category

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editBedCat(String bedcat) {
		logger.info("Method : editBedCat starts");

		JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
		List<RestHISConfigurationModel> newResp = new ArrayList<RestHISConfigurationModel>();

		try {
			String value = "SET @p_bedcat='" + bedcat + "';";
			logger.info("@@@@@@@@@@@@@@@@@@@" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
					.setParameter("actionType", "editBedCat").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
						null, null, null);
				newResp.add(restHISConfigurationModel);
			}

			resp.setBody(newResp);
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

		ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : editBedCat ends");
		return response;
	}

	// delete Bed Category

	public ResponseEntity<JsonResponse<Object>> deleteBedCategory(String bedcat) {

		logger.info("Method : deleteBedCategory Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_bedcat='" + bedcat + "';";

			em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "deleteBedCategory")
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

		logger.info("Method : deleteBedCategory Dao ends");
		return response;
	}

	// discharge add

	public ResponseEntity<JsonResponse<Object>> adddischarge(RestHISConfigurationModel restHISConfigurationModel) {
		logger.info("Method : adddischarge Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("Method : restHISConfigurationModel====" + restHISConfigurationModel);
		if (validity)
			try {
				String values = GenerateBedCategoryParameter.getAdddischarge(restHISConfigurationModel);

				if (restHISConfigurationModel.getDistype() == null || restHISConfigurationModel.getDistype() == "") {
					System.out.println("addddd in daooooooooooo" + restHISConfigurationModel);
					em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "addDischarge")
							.setParameter("actionValue", values).execute();

				}

				else {
					System.out.println("MODIFYYYYYYY  in daooooooooo " + restHISConfigurationModel);
					System.out.println("VALUEEEEE" + values);
					em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "modifyDischarge")
							.setParameter("actionValue", values).execute();
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
		logger.info("Method : adddischarge Dao ends");
		return response;
	}

	/// view discharge

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewDisType() {
		logger.info("Method : viewDisType starts");
		List<RestHISConfigurationModel> respList = new ArrayList<RestHISConfigurationModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
					.setParameter("actionType", "viewDisType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
						m[3], m[4], m[5], null);
				respList.add(restHISConfigurationModel);
				logger.info("RestHISConfigurationModel" + restHISConfigurationModel);
			}
			logger.info("respList" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewDisType ends");
		return response;
	}

	// edit discharge

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editDisType(String Distype) {
		logger.info("Method : editDisType starts");

		JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
		List<RestHISConfigurationModel> newResp = new ArrayList<RestHISConfigurationModel>();

		try {
			String value = "SET @p_Distype='" + Distype + "';";
			logger.info("@@@@@@@@@@@@@@@@@@@" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
					.setParameter("actionType", "editDisType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
						m[3], m[4], null);
				newResp.add(restHISConfigurationModel);
			}

			resp.setBody(newResp);
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

		ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : editDisType ends");
		return response;
	}

	// delete discharge

	public ResponseEntity<JsonResponse<Object>> deleteDischargeType(String distype) {

		logger.info("Method : deleteDischargeType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_Distype='" + distype + "';";

			em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "deleteDischargeType")
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

		logger.info("Method : deleteDischargeType Dao ends");
		return response;
	}

	/* Destination add */

	public ResponseEntity<JsonResponse<Object>> adddestination(RestHISConfigurationModel restHISConfigurationModel) {
		logger.info("Method : adddestination Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("Method : restHISConfigurationModel====" + restHISConfigurationModel);
		if (validity)
			try {
				String values = GenerateBedCategoryParameter.getDisDesParam(restHISConfigurationModel);

				if (restHISConfigurationModel.getDisDes() == null || restHISConfigurationModel.getDisDes() == "") {
					System.out.println("addddd in daooooooooooo" + restHISConfigurationModel);
					em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "adddestination")
							.setParameter("actionValue", values).execute();

				}

				else {
					System.out.println("MODIFYYYYYYY  in daooooooooo " + restHISConfigurationModel);
					System.out.println("VALUEEEEE" + values);
					em.createNamedStoredProcedureQuery("his_bed_routines")
							.setParameter("actionType", "modifyDestination").setParameter("actionValue", values)
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
		logger.info("Method : adddestination Dao ends");
		return response;
	}

	/// view Destination

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewDestination() {
		logger.info("Method : viewDestination starts");
		List<RestHISConfigurationModel> respList = new ArrayList<RestHISConfigurationModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
					.setParameter("actionType", "viewDestination").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
						m[3], m[4], m[5], null, null);
				respList.add(restHISConfigurationModel);

				logger.info("RestHISConfigurationModel" + restHISConfigurationModel);
			}
			logger.info("respList" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewDestination ends");
		return response;

	}

	// edit Destination

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editDestination(String id) {
		logger.info("Method : editDestination starts");

		JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
		List<RestHISConfigurationModel> newResp = new ArrayList<RestHISConfigurationModel>();

		try {
			String value = "SET @p_disDes='" + id + "';";
			logger.info("@@@@@@@@@@@@@@@@@@@" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
					.setParameter("actionType", "editDestination").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
						m[3], m[4], m[5], null);
				newResp.add(restHISConfigurationModel);
			}

			resp.setBody(newResp);
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

		ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : editDestination ends");
		return response;
	}

	// delete Destination

	public ResponseEntity<JsonResponse<Object>> deleteDestination(String id) {

		logger.info("Method : deleteDestination Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_disDes='" + id + "';";

			em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "deleteDestination")
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

		logger.info("Method : deleteDestination Dao ends");
		return response;
	}

	/* add Concession */

	public ResponseEntity<JsonResponse<Object>> addconcession(RestHISConfigurationModel restHISConfigurationModel) {
		logger.info("Method : addconcession Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("Method : restHISConfigurationModel====" + restHISConfigurationModel);
		if (validity)
			try {
				String values = GenerateBedCategoryParameter.getConcessionParam(restHISConfigurationModel);

				if (restHISConfigurationModel.getConCat() == null || restHISConfigurationModel.getConCat() == "") {
					System.out.println("addddd in daooooooooooo" + restHISConfigurationModel);
					em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "addconcession")
							.setParameter("actionValue", values).execute();

				}

				else {
					System.out.println("MODIFYYYYYYY  in daooooooooo " + restHISConfigurationModel);
					System.out.println("VALUEEEEE" + values);
					em.createNamedStoredProcedureQuery("his_bed_routines")
							.setParameter("actionType", "modifyConcession").setParameter("actionValue", values)
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
		logger.info("Method : addconcession Dao ends");
		return response;
	}

	/// view Concession

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewConcession() {
		logger.info("Method : viewConcession starts");
		List<RestHISConfigurationModel> respList = new ArrayList<RestHISConfigurationModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
					.setParameter("actionType", "viewConcession").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
						m[3], m[4], m[5], null, null, null);
				respList.add(restHISConfigurationModel);

				logger.info("RestHISConfigurationModel" + restHISConfigurationModel);
			}
			logger.info("respList" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewConcession ends");
		return response;

	}

	// edit Concession

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editConcession(String id) {
		logger.info("Method : editConcession starts");

		JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
		List<RestHISConfigurationModel> newResp = new ArrayList<RestHISConfigurationModel>();

		try {
			String value = "SET @p_concat='" + id + "';";
			logger.info("@@@@@@@@@@@@@@@@@@@" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
					.setParameter("actionType", "editConcession").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
						m[3], m[4], m[5],null, null, null);
				newResp.add(restHISConfigurationModel);
			}

			resp.setBody(newResp);
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

		ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : editConcession ends");
		return response;
	}
	
	// delete Concession

		public ResponseEntity<JsonResponse<Object>> deleteConcession(String id) {

			logger.info("Method : deleteConcession Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String values = "SET @p_concat='" + id + "';";

				em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "deleteConcession")
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

			logger.info("Method : deleteConcession Dao ends");
			return response;
		}
		
		/* add Pathology */

		public ResponseEntity<JsonResponse<Object>> addpathology(RestHISConfigurationModel restHISConfigurationModel) {
			logger.info("Method : addpathology Dao starts");
			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			logger.info("Method : restHISConfigurationModel====" + restHISConfigurationModel);
			if (validity)
				try {
					String values = GenerateBedCategoryParameter.getPathologyParam(restHISConfigurationModel);

					if (restHISConfigurationModel.getTestType() == null || restHISConfigurationModel.getTestType() == "") {
						System.out.println("addddd in daooooooooooo" + restHISConfigurationModel);
						em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "addpathology")
								.setParameter("actionValue", values).execute();

					}

					else {
						System.out.println("MODIFYYYYYYY  in daooooooooo " + restHISConfigurationModel);
						System.out.println("VALUEEEEE" + values);
						em.createNamedStoredProcedureQuery("his_bed_routines")
								.setParameter("actionType", "modifyPathology").setParameter("actionValue", values)
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
			logger.info("Method : addpathology Dao ends");
			return response;
		}
		
		/// view Pathology

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewPathology() {
			logger.info("Method : viewPathology starts");
			List<RestHISConfigurationModel> respList = new ArrayList<RestHISConfigurationModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
						.setParameter("actionType", "viewPathology").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {

					RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
							m[3], m[4], m[5],null, null, null, null);
					respList.add(restHISConfigurationModel);

					logger.info("RestHISConfigurationModel" + restHISConfigurationModel);
				}
				logger.info("respList" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}

			JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("response" + response);
			logger.info("Method : viewPathology ends");
			return response;

		}
		
		// edit Pathology

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editPathology(String id) {
			logger.info("Method : editPathology starts");

			JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
			List<RestHISConfigurationModel> newResp = new ArrayList<RestHISConfigurationModel>();

			try {
				String value = "SET @p_testType='" + id + "';";
				logger.info("@@@@@@@@@@@@@@@@@@@" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
						.setParameter("actionType", "editPathology").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {

					RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
							null, null,null,null,null, null, null);
					newResp.add(restHISConfigurationModel);
				}

				resp.setBody(newResp);
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

			ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : editPathology ends");
			return response;
		}
		
		// delete Pathology

				public ResponseEntity<JsonResponse<Object>> deletePathology(String id) {

					logger.info("Method : deletePathology Dao starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						String values = "SET @p_testType='" + id + "';";

						em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "deletePathology")
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

					logger.info("Method : deletePathology Dao ends");
					return response;
				}
				
				
				/* add Group */

				public ResponseEntity<JsonResponse<Object>> addgroup(RestHISConfigurationModel restHISConfigurationModel) {
					logger.info("Method : addgroup Dao starts");
					Boolean validity = true;
					JsonResponse<Object> resp = new JsonResponse<Object>();
					logger.info("Method : restHISConfigurationModel====" + restHISConfigurationModel);
					if (validity)
						try {
							String values = GenerateBedCategoryParameter.getGroupMstr(restHISConfigurationModel);

							if (restHISConfigurationModel.getGroup() == null || restHISConfigurationModel.getGroup() == "") {
								System.out.println("addddd in daooooooooooo" + restHISConfigurationModel);
								em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "addgroup")
										.setParameter("actionValue", values).execute();

							}

							else {
								System.out.println("MODIFYYYYYYY  in daooooooooo " + restHISConfigurationModel);
								System.out.println("VALUEEEEE" + values);
								em.createNamedStoredProcedureQuery("his_bed_routines")
										.setParameter("actionType", "modifyGroup").setParameter("actionValue", values)
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
					logger.info("Method : addgroup Dao ends");
					return response;
				}
				
				
				/// view Group

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewGroup() {
					logger.info("Method : viewGroup starts");
					List<RestHISConfigurationModel> respList = new ArrayList<RestHISConfigurationModel>();

					try {
						List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
								.setParameter("actionType", "viewGroup").setParameter("actionValue", "").getResultList();

						for (Object[] m : x) {

							RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
									m[3], m[4], m[5],null, null, null, null,null);
							respList.add(restHISConfigurationModel);

							logger.info("RestHISConfigurationModel" + restHISConfigurationModel);
						}
						logger.info("respList" + respList);
					} catch (Exception e) {
						e.printStackTrace();
					}

					JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
					resp.setBody(respList);
					ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
							resp, HttpStatus.CREATED);
					logger.info("response" + response);
					logger.info("Method : viewGroup ends");
					return response;

				}
				
				
				// edit Group

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editGroup(String id) {
					logger.info("Method : editGroup starts");

					JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
					List<RestHISConfigurationModel> newResp = new ArrayList<RestHISConfigurationModel>();

					try {
						String value = "SET @p_group='" + id + "';";
						logger.info("@@@@@@@@@@@@@@@@@@@" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
								.setParameter("actionType", "editGroup").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {

							RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
									null, null,null,null,null, null, null,null);
							newResp.add(restHISConfigurationModel);
						}

						resp.setBody(newResp);
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

					ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
							resp, HttpStatus.CREATED);
					logger.info("Method : editGroup ends");
					return response;
				}
				
				// delete Group

				public ResponseEntity<JsonResponse<Object>> deleteGroup(String id) {

					logger.info("Method : deleteGroup Dao starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						String values = "SET @p_group='" + id + "';";

						em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "deleteGroup")
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

					logger.info("Method : deleteGroup Dao ends");
					return response;
				}
				
				
				/* add Sub Group */

				public ResponseEntity<JsonResponse<Object>> addsubgroup(RestHISConfigurationModel restHISConfigurationModel) {
					logger.info("Method : addsubgroup Dao starts");
					Boolean validity = true;
					JsonResponse<Object> resp = new JsonResponse<Object>();
					logger.info("Method : restHISConfigurationModel====" + restHISConfigurationModel);
					if (validity)
						try {
							String values = GenerateBedCategoryParameter.getSubGroupMstr(restHISConfigurationModel);
								
							if (restHISConfigurationModel.getSubGroup() == null || restHISConfigurationModel.getSubGroup() == "") {
								System.out.println("addddd in daooooooooooo" + restHISConfigurationModel);
								em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "addsubgroup")
										.setParameter("actionValue", values).execute();

							}

							else {
								System.out.println("MODIFYYYYYYY  in daooooooooo " + restHISConfigurationModel);
								System.out.println("VALUEEEEE" + values);
								em.createNamedStoredProcedureQuery("his_bed_routines")
										.setParameter("actionType", "modifySubGroup").setParameter("actionValue", values)
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
					logger.info("Method : addsubgroup Dao ends");
					return response;
				}
				
				
				/// view Sub Group

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewSubGroup() {
					logger.info("Method : viewSubGroup starts");
					List<RestHISConfigurationModel> respList = new ArrayList<RestHISConfigurationModel>();

					try {
						List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
								.setParameter("actionType", "viewSubGroup").setParameter("actionValue", "").getResultList();

						for (Object[] m : x) {

							RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
									m[3], m[4], m[5],m[6], m[7], null, null,null,null,null, null, null);
							respList.add(restHISConfigurationModel);

							logger.info("RestHISConfigurationModel" + restHISConfigurationModel);
						}
						logger.info("respList" + respList);
					} catch (Exception e) {
						e.printStackTrace();
					}

					JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
					resp.setBody(respList);
					ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
							resp, HttpStatus.CREATED);
					logger.info("response" + response);
					logger.info("Method : viewSubGroup ends");
					return response;

				}
				
				// edit SUb Group

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editSubGroup(String id) {
					logger.info("Method : editSubGroup starts");

					JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
					List<RestHISConfigurationModel> newResp = new ArrayList<RestHISConfigurationModel>();

					try {
						String value = "SET @p_subgroup='" + id + "';";
						logger.info("@@@@@@@@@@@@@@@@@@@" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
								.setParameter("actionType", "editSubGroup").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {

							RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
									m[3], m[4],null,null,null, null, null,null,null,null);
							newResp.add(restHISConfigurationModel);
						}

						resp.setBody(newResp);
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

					ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
							resp, HttpStatus.CREATED);
					logger.info("Method : editSubGroup ends");
					return response;
				}
				
				
				// delete SUb Group

				public ResponseEntity<JsonResponse<Object>> deleteSubGroup(String id) {

					logger.info("Method : deleteSubGroup Dao starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						String values = "SET @p_subgroup='" + id + "';";

						em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "deleteSubGroup")
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

					logger.info("Method : deleteSubGroup Dao ends");
					return response;
				}/* add Surgery */

				public ResponseEntity<JsonResponse<Object>> addSurgery(RestHISConfigurationModel restHISConfigurationModel) {
					logger.info("Method : addSurgery Dao starts");
					Boolean validity = true;
					JsonResponse<Object> resp = new JsonResponse<Object>();
					logger.info("Method : restHISConfigurationModel====" + restHISConfigurationModel);
					if (validity)
						try {
							String values = GenerateBedCategoryParameter.getSurgeryParam(restHISConfigurationModel);

							if (restHISConfigurationModel.getSurgeryId() == null || restHISConfigurationModel.getSurgeryId() == "") {
								System.out.println("addddd in daooooooooooo" + restHISConfigurationModel);
								em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "addSurgery")
										.setParameter("actionValue", values).execute();

							}

							else {
								System.out.println("MODIFYYYYYYY  in daooooooooo " + restHISConfigurationModel);
								System.out.println("VALUEEEEE" + values);
								em.createNamedStoredProcedureQuery("his_bed_routines")
										.setParameter("actionType", "modifySurgery").setParameter("actionValue", values)
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
					logger.info("Method : addSurgery Dao ends");
					return response;
				}
				
		/// view Surgery

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewSurgery() {
					logger.info("Method : viewSurgery starts");
					List<RestHISConfigurationModel> respList = new ArrayList<RestHISConfigurationModel>();

					try {
						List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
								.setParameter("actionType", "viewSurgery").setParameter("actionValue", "").getResultList();

						for (Object[] m : x) {

							RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
									m[3], m[4], m[5],null, null, null, null, null,null,null,null);
							respList.add(restHISConfigurationModel);

							logger.info("RestHISConfigurationModel" + restHISConfigurationModel);
						}
						logger.info("respList" + respList);
					} catch (Exception e) {
						e.printStackTrace();
					}

					JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
					resp.setBody(respList);
					ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
							resp, HttpStatus.CREATED);
					logger.info("response" + response);
					logger.info("Method : viewSurgery ends");
					return response;

				}
				
		// edit Surgery

				@SuppressWarnings("unchecked")
				public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> editSurgery(String id) {
					logger.info("Method : editSurgery starts");

					JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
					List<RestHISConfigurationModel> newResp = new ArrayList<RestHISConfigurationModel>();

					try {
						String value = "SET @p_surgeryId='" + id + "';";
						logger.info("@@@@@@@@@@@@@@@@@@@" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
								.setParameter("actionType", "editSurgery").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {

							RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
									null, null,null,null,null, null, null, null,null,null,null);
							newResp.add(restHISConfigurationModel);
						}

						resp.setBody(newResp);
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

					ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
							resp, HttpStatus.CREATED);
					logger.info("Method : editSurgery ends");
					return response;
				}
				
		// delete Surgery

						public ResponseEntity<JsonResponse<Object>> deleteSurgery(String id) {

							logger.info("Method : deleteSurgery Dao starts");

							JsonResponse<Object> resp = new JsonResponse<Object>();

							try {
								String values = "SET @p_surgeryId='" + id + "';";

								em.createNamedStoredProcedureQuery("his_bed_routines").setParameter("actionType", "deleteSurgery")
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

							logger.info("Method : deleteSurgery Dao ends");
							return response;
						}
				
						
			//viewOnclickSubGroup			
						@SuppressWarnings("unchecked")
						public ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> viewOnclickSubGroup(String id) {
							logger.info("Method : viewOnclickSubGroup starts");

							List<RestHISConfigurationModel> clickData = new ArrayList<RestHISConfigurationModel>();

							String values = "SET @p_groupId='" + id + "';";

							try {
								List<Object[]> x = em.createNamedStoredProcedureQuery("his_bed_routines")
										.setParameter("actionType", "viewOnclickSubGroup").setParameter("actionValue", values).getResultList();

								for (Object[] m : x) {

									RestHISConfigurationModel restHISConfigurationModel = new RestHISConfigurationModel(m[0], m[1], m[2],
											m[3], m[4], m[5],m[6], m[7], null, null,null,null,null, null, null);
									clickData.add(restHISConfigurationModel);

									logger.info("viewOnclickSubGroupDATAAAA" + restHISConfigurationModel);
								}
								logger.info("respList" + clickData);

							} catch (Exception e) {
								e.printStackTrace();
							}	
							
							JsonResponse<List<RestHISConfigurationModel>> resp = new JsonResponse<List<RestHISConfigurationModel>>();
							resp.setBody(clickData);

		
							ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>> response = new ResponseEntity<JsonResponse<List<RestHISConfigurationModel>>>(
									resp, HttpStatus.CREATED);
							logger.info("Method : viewOnclickState ends");
							return response;
						}
}