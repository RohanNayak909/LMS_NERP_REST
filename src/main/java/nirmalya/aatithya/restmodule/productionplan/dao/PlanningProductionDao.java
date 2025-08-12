package nirmalya.aatithya.restmodule.productionplan.dao;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.productionplan.GenerateParamPlanningProduction;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionParentModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionRawmaterialModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionTotalmanpowerList;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionVariantModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestProductionPlanningProductList;
import nirmalya.aatithya.restmodule.productionplan.model.RestProductionPlanningmachineManpowerList;

@Repository
public class PlanningProductionDao {
	Logger logger = LoggerFactory.getLogger(PlanningProductionDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getplan(String orgName, String orgDiv) {
		logger.info("Method : getplan Dao starts");

		List<DropDownModel> brandlist = new ArrayList<DropDownModel>();

		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "getplanlist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				brandlist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getplan Dao ends");
		return brandlist;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPlantList(String orgName, String orgDiv) {

		logger.info("Method : getPlantList Dao starts");

		List<DropDownModel> plantlist = new ArrayList<DropDownModel>();

		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "getplantnamelist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				plantlist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPlantList Dao ends");
		return plantlist;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUomList() {
		logger.info("Method : getUomList Dao starts");

		List<DropDownModel> uomlist = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "getuomlist").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				uomlist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getUomList Dao ends");
		return uomlist;
	}

	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<RestPlanningProductionModel>>> getMachineList(
			RestPlanningProductionModel RestPlanningProductionModel) {
		logger.info("Method : getMachineList Dao starts");

		List<RestPlanningProductionModel> respList = new ArrayList<RestPlanningProductionModel>();

		String value = GenerateParamPlanningProduction.getMachineList(RestPlanningProductionModel);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "getmachinelist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestPlanningProductionModel purchaseOrder = new RestPlanningProductionModel(m[0], m[1].toString(),
						m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), m[6].toString(), m[7].toString());

				respList.add(purchaseOrder);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestPlanningProductionModel>> resp = new JsonResponse<List<RestPlanningProductionModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestPlanningProductionModel>>> response = new ResponseEntity<JsonResponse<List<RestPlanningProductionModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getMachineList ends");

		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getShiftListsAllocation(String org, String orgDiv, String userId) {
		logger.info("Method : getShiftListsAllocation starts");
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_mfg_process_routines")
					.setParameter("actionType", "getShiftListForProduction").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(getCollectionList);

		logger.info("Method : getShiftListsAllocation ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<RestPlanningProductionModel> getManPowerList(
			RestPlanningProductionModel RestPlanningProductionModel) {
		logger.info("Method : getManPowerList Dao starts");

		RestPlanningProductionModel purchaseOrder = new RestPlanningProductionModel();
		JsonResponse<RestPlanningProductionModel> resp = new JsonResponse<RestPlanningProductionModel>();

		String value = GenerateParamPlanningProduction.getManPowerList(RestPlanningProductionModel);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "getmanpowerlist").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				purchaseOrder = new RestPlanningProductionModel(null, null, m[0].toString(), m[1].toString(),
						m[2].toString(), m[3].toString(), m[4].toString(),null);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(purchaseOrder);

		logger.info("Method : getManPowerList Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestPlanningProductionModel>> getProductVariantList(String id, String planid,
			String orgName, String orgDiv) {
		logger.info("Method : getProductVariantList Dao starts");

		List<RestPlanningProductionModel> purchaseOrder = new ArrayList<RestPlanningProductionModel>();
		JsonResponse<List<RestPlanningProductionModel>> resp = new JsonResponse<List<RestPlanningProductionModel>>();

		String value = "SET @p_searchValue='" + id + "', @p_planid='" + planid + "',@p_org='" + orgName
				+ "',@p_orgDiv='" + orgDiv + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "getvariantlist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestPlanningProductionModel data = new RestPlanningProductionModel(m[0].toString(), m[1].toString(),
						m[2].toString(), null, null, null, null,null);
				purchaseOrder.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(purchaseOrder);

		logger.info("Method : getProductVariantList Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestPlanningProductionModel>> getProductBrandList(String id, String orgName,
			String orgDiv) {
		logger.info("Method : getProductBrandList Dao starts");

		List<RestPlanningProductionModel> purchaseOrder = new ArrayList<RestPlanningProductionModel>();
		JsonResponse<List<RestPlanningProductionModel>> resp = new JsonResponse<List<RestPlanningProductionModel>>();

		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "getbrandnamelist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object fromdate = null;
				if (m[2] != null) {
					fromdate = DateFormatter.returnStringDate(m[2]);
				}
				Object todate = null;
				if (m[3] != null) {
					todate = DateFormatter.returnStringDate(m[3]);
				}

				RestPlanningProductionModel data = new RestPlanningProductionModel(m[0].toString(), m[1].toString(),
						fromdate, todate, null, null, null,null);
				purchaseOrder.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(purchaseOrder);

		logger.info("Method : getProductBrandList Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestPlanningProductionModel>> getRawMaterialList(
			RestPlanningProductionModel RestPlanningProductionModel) {
		logger.info("Method : getRawMaterialList Dao starts");

		List<RestPlanningProductionModel> purchaseOrder = new ArrayList<RestPlanningProductionModel>();
		JsonResponse<List<RestPlanningProductionModel>> resp = new JsonResponse<List<RestPlanningProductionModel>>();

		String value = GenerateParamPlanningProduction.getRawMaterialList(RestPlanningProductionModel);
		try {
			logger.info("dataaaaaaaaaaaaaa==============---------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "getrawmaterialist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				if (m[1] == null) {
					m[1] = "";
				}
				RestPlanningProductionModel data = new RestPlanningProductionModel(m[0].toString(), m[1].toString(),
						m[2].toString(), m[3], null, null, null, null);
				purchaseOrder.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(purchaseOrder);

		logger.info("Method : getRawMaterialList Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestPlanningProductionModel>> getVarUnitDropdownList(String orgName, String orgDiv) {
		logger.info("Method : getVarUnitDropdownList Dao starts");

		List<RestPlanningProductionModel> purchaseOrder = new ArrayList<RestPlanningProductionModel>();
		JsonResponse<List<RestPlanningProductionModel>> resp = new JsonResponse<List<RestPlanningProductionModel>>();

		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "getuomlist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestPlanningProductionModel data = new RestPlanningProductionModel(m[0].toString(), m[1].toString(),
						null, null, null, null, null, null);
				purchaseOrder.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(purchaseOrder);

		logger.info("Method : getVarUnitDropdownList Dao ends" + resp);
		return resp;

	}

	public ResponseEntity<JsonResponse<Object>> savePlanningDetails(
			RestPlanningProductionParentModel planningDetaails) {
		logger.info("Method : saveEventsRest dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<RestPlanningProductionParentModel> listData = new ArrayList<RestPlanningProductionParentModel>();

		try {
			String values = GenerateParamPlanningProduction.getAddPlanningParam(planningDetaails);
			System.out.println("values added====="+values);
			if (planningDetaails.getPlanningid() == null || planningDetaails.getPlanningid() == "") {
				em.createNamedStoredProcedureQuery("planningproduction").setParameter("actionType", "addplandetails")
						.setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("planningproduction").setParameter("actionType", "modifyplandetails")
						.setParameter("actionValue", values).execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveEventsRest dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPlanningProductionParentModel>>> viewplanning(String userid, String org,
			String orgDiv) {
		logger.info("Method : viewBom starts");
		List<RestPlanningProductionParentModel> respList = new ArrayList<RestPlanningProductionParentModel>();

		try {

			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "viewplanningdetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object Sdate = null;
				if (m[3] != null && m[3] != "") {
					Sdate = DateFormatter.returnStringDate(m[3]);
				}

				Object Edate = null;
				if (m[4] != null && m[4] != "") {
					Edate = DateFormatter.returnStringDate(m[4]);
				}


				RestPlanningProductionParentModel restPayroll = new RestPlanningProductionParentModel(m[0], m[1], m[2],
						Sdate, Edate, m[5], m[6], m[7], m[8], m[9].toString());
				respList.add(restPayroll);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestPlanningProductionParentModel>> resp = new JsonResponse<List<RestPlanningProductionParentModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestPlanningProductionParentModel>>> response = new ResponseEntity<JsonResponse<List<RestPlanningProductionParentModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : ViewSuplier ends");

		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> deletePlanningProduction(
			RestPlanningProductionParentModel RestPlanningProductionParentModel) {
		logger.info("Method : deletePlanningProduction Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String value = GenerateParamPlanningProduction.getDeleteInvoice(RestPlanningProductionParentModel);
		try {
			em.createNamedStoredProcedureQuery("planningproduction").setParameter("actionType", "deletePlanningDetails")
					.setParameter("actionValue", value).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deletePlanningProduction Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<RestPlanningProductionParentModel> editPlanningProduction(String planningid) {
		logger.info("Method : editPlanningProduction Dao starts");
		RestPlanningProductionParentModel purchaseOrder = new RestPlanningProductionParentModel();
		List<RestPlanningProductionRawmaterialModel> itemList = new ArrayList<RestPlanningProductionRawmaterialModel>();
		List<RestPlanningProductionVariantModel> itemList1 = new ArrayList<RestPlanningProductionVariantModel>();
		JsonResponse<RestPlanningProductionParentModel> resp = new JsonResponse<RestPlanningProductionParentModel>();

		String value = "SET @p_userId='" + planningid + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "editplanningproduction").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object Sdate = null;
				if (m[3] != null && m[3] != "") {
					Sdate = DateFormatter.returnStringDate(m[3]);
				}

				Object Edate = null;
				if (m[4] != null && m[4] != "") {
					Edate = DateFormatter.returnStringDate(m[4]);
				}

				purchaseOrder = new RestPlanningProductionParentModel(m[0], m[1], m[2], Sdate, Edate, m[5], m[6], m[7],
						m[8].toString(), null);
			}
			try {
				List<Object[]> y = em.createNamedStoredProcedureQuery("planningproduction")
						.setParameter("actionType", "editrawmaterialplanning").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : y) {
					int i=0;
					for(Object obj : m) {

						System.out.println(i+"==="+obj);
						i++;
					}
					RestPlanningProductionRawmaterialModel item = new RestPlanningProductionRawmaterialModel(m[0], m[1],
							m[2], m[3]);
					itemList.add(item);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			purchaseOrder.setRawmaterialist(itemList);
			try {
				List<Object[]> z = em.createNamedStoredProcedureQuery("planningproduction")
						.setParameter("actionType", "editvariantplanning").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : z) {
					RestPlanningProductionVariantModel item1 = new RestPlanningProductionVariantModel(m[0], m[1]);
					itemList1.add(item1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			purchaseOrder.setVariant(itemList1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(purchaseOrder);

		logger.info("Method : editPlanningProduction Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> approvePlanningProduction(
			RestPlanningProductionParentModel RestPlanningProductionParentModel) {
		logger.info("Method : approvePlanningProduction Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String value = GenerateParamPlanningProduction.getDeleteInvoice(RestPlanningProductionParentModel);
		try {

			em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "approvePlanningDetails").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : approvePlanningProduction Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<RestPlanningProductionParentModel> schedulePlanningProduction(String planningid, String org, String orgDiv) {
		logger.info("Method : schedulePlanningProduction Dao starts");

		RestPlanningProductionParentModel purchaseOrder = new RestPlanningProductionParentModel();
		List<RestPlanningProductionVariantModel> itemList1 = new ArrayList<RestPlanningProductionVariantModel>();
		List<RestProductionPlanningProductList> itemList2 = new ArrayList<RestProductionPlanningProductList>();
		JsonResponse<RestPlanningProductionParentModel> resp = new JsonResponse<RestPlanningProductionParentModel>();

		String value = "SET @p_userId='" + planningid + "',@P_ORG='" + org + "',@P_ORG_DIV='" + orgDiv + "';";
		System.err.println("value====================="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "editplanningproductiondetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object Sdate = null;
				if (m[3] != null && m[3] != "") {
					Sdate = DateFormatter.returnStringDate(m[3]);
				}
				Object Edate = null;
				if (m[4] != null && m[4] != "") {
					Edate = DateFormatter.returnStringDate(m[4]);
				}
				purchaseOrder = new RestPlanningProductionParentModel(m[0], m[1], m[2], Sdate, Edate, m[5], m[6], m[7],
						m[8].toString(), null);
			}
			try {
				List<Object[]> z = em.createNamedStoredProcedureQuery("planningproduction")
						.setParameter("actionType", "editvariantplanningdetails").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : z) {
					RestPlanningProductionVariantModel item1 = new RestPlanningProductionVariantModel(m[0], m[1], m[2]);
					itemList1.add(item1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			purchaseOrder.setVariant(itemList1);
			try {
				System.err.println("value=="+value);
				List<Object[]> z = em.createNamedStoredProcedureQuery("planningproduction")
						.setParameter("actionType", "scheduleAllData").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : z) {
					RestProductionPlanningProductList item2 = new RestProductionPlanningProductList(m[0].toString(), m[1].toString(),
							m[2].toString(), m[3].toString(),null);// m[4]);
					itemList2.add(item2);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			purchaseOrder.setProductList(itemList2);

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(purchaseOrder);
		logger.info("Method : editPlanningProduction Dao ends");

		System.err.println("allldata==="+purchaseOrder);
		return resp;
	}

	public ResponseEntity<JsonResponse<Object>> setScheduleDetails(RestPlanningProductionParentModel scheduleModel) {
		logger.info("Method : setScheduleDetails dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<RestPlanningProductionParentModel> listData = new ArrayList<RestPlanningProductionParentModel>();
		String values = GenerateParamPlanningProduction.setScheduleParam(scheduleModel);
		System.err.println("values=======" + values);
		try {
			if (scheduleModel.getPlanningid() == null || scheduleModel.getPlanningid() == "") {

				System.out.println("values IN ADD" + values);
				em.createNamedStoredProcedureQuery("planningproduction").setParameter("actionType", "setschedule")
						.setParameter("actionValue", values).execute();
			} else {
				System.out.println("values in modify");
				em.createNamedStoredProcedureQuery("planningproduction").setParameter("actionType", "setschedule")
						.setParameter("actionValue", values).execute();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : setScheduleDetails dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<RestPlanningProductionParentModel> editSchedulePage(String planningid) {
		logger.info("Method : editSchedulePage Dao starts");

		RestPlanningProductionParentModel purchaseOrder = new RestPlanningProductionParentModel();
		List<RestProductionPlanningProductList> itemList = new ArrayList<RestProductionPlanningProductList>();
		List<RestProductionPlanningmachineManpowerList> itemList1 = new ArrayList<RestProductionPlanningmachineManpowerList>();
		List<RestPlanningProductionTotalmanpowerList> itemList2 = new ArrayList<RestPlanningProductionTotalmanpowerList>();
		JsonResponse<RestPlanningProductionParentModel> resp = new JsonResponse<RestPlanningProductionParentModel>();

		String value = "SET @p_userId='" + planningid + "';";
		try {
			try {
				List<Object[]> y = em.createNamedStoredProcedureQuery("planningproduction")
						.setParameter("actionType", "scheduleproductlist").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : y) {
					Object Sdate = null;
					if (m[0] != null && m[0] != "") {
						Sdate = DateFormatter.returnStringDate(m[0]);
					}
					RestProductionPlanningProductList item = new RestProductionPlanningProductList(Sdate, m[1], m[2],
							m[3], m[4], m[5].toString(), m[6].toString(),null,null);
					itemList.add(item);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			purchaseOrder.setProductList(itemList);
			try {
				List<Object[]> z = em.createNamedStoredProcedureQuery("planningproduction")
						.setParameter("actionType", "schedulemacmanpower").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : z) {
					Object Sdate = null;
					if (m[0] != null && m[0] != "") {
						Sdate = DateFormatter.returnStringDate(m[0]);
					}
					RestProductionPlanningmachineManpowerList item1 = new RestProductionPlanningmachineManpowerList(
							Sdate, m[1], m[2], m[3]);
					itemList1.add(item1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			purchaseOrder.setMachineManpowerList(itemList1);
			try {
				List<Object[]> z = em.createNamedStoredProcedureQuery("planningproduction")
						.setParameter("actionType", "scheduletmanpower").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : z) {
					Object Sdate = null;
					if (m[0] != null && m[0] != "") {
						Sdate = DateFormatter.returnStringDate(m[0]);
					}
					RestPlanningProductionTotalmanpowerList item2 = new RestPlanningProductionTotalmanpowerList(Sdate,
							m[1], m[2], m[3], m[4], m[5], m[6], m[7]);
					itemList2.add(item2);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			purchaseOrder.setTotalmanpowerList(itemList2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(purchaseOrder);
		logger.info("Method : editSchedulePage Dao ends");
		return resp;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPlanningProductionModel>>> getResouceOnItem(
			String item, String type, String org, String orgDiv) {
		logger.info("Method : getResouceOnItem Dao starts");

		List<RestPlanningProductionModel> respList = new ArrayList<RestPlanningProductionModel>();

		String value ="SET @p_item=\"" + item + "\",@p_type=\"" + type + "\",@p_org=\"" + org + "\",@p_orgDiv=\"" + orgDiv + "\";";
		System.err.println("values====="+value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("planningproduction")
					.setParameter("actionType", "getResourceClean").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestPlanningProductionModel purchaseOrder = new RestPlanningProductionModel(m[0], m[1].toString(),
						m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), m[6].toString(), m[7].toString());

				respList.add(purchaseOrder);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.err.println("respList====="+respList);
		JsonResponse<List<RestPlanningProductionModel>> resp = new JsonResponse<List<RestPlanningProductionModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestPlanningProductionModel>>> response = new ResponseEntity<JsonResponse<List<RestPlanningProductionModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getResouceOnItem ends");

		return response;

	}
}
