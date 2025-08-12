package nirmalya.aatithya.restmodule.samudyamproduction.dao;

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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.InvestDeclareSubModel;
import nirmalya.aatithya.restmodule.employee.model.RestInvestmentDeclarationModel;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestPatternMasterModel;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestProductionOrderItemModel;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestProductionOrderModel;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ProductionOrderDao {
	Logger logger = LoggerFactory.getLogger(ProductionOrderDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager entityManager;
	
	//getProductionOrder
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProductionOrderModel>>> getProductionOrder(String org, String orgDiv) {
		logger.info("Method : getProductionOrder starts");
		List<RestProductionOrderModel> respList = new ArrayList<RestProductionOrderModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("nerp_production_orderSchedulingRoutines")
					.setParameter("actionType", "getProductionOrder").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object ordDate = null;
				if (m[3] != null) {
					ordDate = DateFormatter.returnStringDate(m[3]);
				}
				Object shiftDate = null;
				if (m[4] != null) {
					shiftDate = DateFormatter.returnStringDate(m[4]);
				}
				logger.info("m[6]==="+m[6]);
				Object schDate = null;
				if (m[6] != null && !m[6].equals("")) {
					schDate = DateFormatter.returnStringDate(m[6]);
				}
				RestProductionOrderModel mdata = new RestProductionOrderModel(m[0], m[1], m[2], ordDate,shiftDate, m[5],schDate,m[7]);
				respList.add(mdata);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestProductionOrderModel>> resp = new JsonResponse<List<RestProductionOrderModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestProductionOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestProductionOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response===="+response);
		logger.info("Method : getProductionOrder ends");
		return response;
	}
	//getOrderItemDetails
	@SuppressWarnings("unchecked")
	public List<RestProductionOrderModel> getOrderItemDetails(String orderId,String org, String orgDiv) {
		logger.info("Method : getOrderItemDetails starts");
		List<RestProductionOrderModel> respList = new ArrayList<RestProductionOrderModel>();
		JsonResponse<List<RestProductionOrderModel>> resp = new JsonResponse<List<RestProductionOrderModel>>();
		String value = "SET @p_orderId='" + orderId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("nerp_production_orderSchedulingRoutines")
					.setParameter("actionType", "getProductionOrder").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object ordDate = null;
				if (m[3] != null) {
					ordDate = DateFormatter.returnStringDate(m[3]);
				}
				Object shiftDate = null;
				if (m[4] != null) {
					shiftDate = DateFormatter.returnStringDate(m[4]);
				}
				Object schDate = null;
				if (m[6] != null && !m[6].equals("")) {
					schDate = DateFormatter.returnStringDate(m[6]);
				}
				RestProductionOrderModel mdata = new RestProductionOrderModel(m[0], m[1], m[2], ordDate,shiftDate, m[5],schDate,m[7]);
				respList.add(mdata);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("respList==="+respList);
		if (!Util.isNull(respList)&&!respList.isEmpty()) {
			for (RestProductionOrderModel a : respList) {
				List<RestProductionOrderItemModel> itemDetails = new ArrayList<RestProductionOrderItemModel>();
				logger.info("a.getSalesOrder()==="+a.getSalesOrder());
				try {
					String values = "SET @p_orderId='" + a.getSalesOrder() + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
					logger.info("values==="+values);
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("nerp_production_orderSchedulingRoutines")
							.setParameter("actionType", "getOrderItemDetails")
							.setParameter("actionValue", value).getResultList();
					for (Object[] m : x1) {
						logger.info("aa==="+Arrays.toString(m));
						RestProductionOrderItemModel dropDownModel = new RestProductionOrderItemModel(m[0], m[1], m[2], m[3], m[4],m[5],m[6]);
						itemDetails.add(dropDownModel);
						logger.info("dropDownModel==="+dropDownModel);
						if (dropDownModel.equals("")) {
							resp.setCode("success");
							resp.setMessage("Data not found");
						} else {
							resp.setCode("success");
							resp.setMessage("Data fetched successfully");
						}
					}
					a.setItemList(itemDetails);
				} catch (Exception e) {
					e.printStackTrace();
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
			}
			resp.setBody(respList);
		}else {
			resp.setCode("success");
			resp.setMessage("Data not found");
		}
		
		resp.setBody(respList);
		logger.info("response===="+resp);
		logger.info("Method : getOrderItemDetails ends");
		return respList;
	}
}
