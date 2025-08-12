package nirmalya.aatithya.restmodule.weight.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.weight.GenerateWeightBridgeParameter;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.gatepass.dao.GatePassDao;
import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassDetailsModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;
import nirmalya.aatithya.restmodule.weight.model.RestWeightBridgeModel;

@Repository
public class ManageGateInWeightRestDao {
	
	Logger logger = LoggerFactory.getLogger(GatePassDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;
	
	// view gate in
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewGatePassInWeight(@RequestParam String pageno, String orgName, String orgDiv) {
		logger.info("Method : viewGatePassOutWeight starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName=\"" + orgName + "\", @p_orgDiv=\"" + orgDiv + "\", @p_pageno=\"" + pageno + "\";";
System.out.println("value>>>>>"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("weight_bridge_routines")
					.setParameter("actionType", "viewGateIn").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		logger.info("Method : viewGatePassOutWeight ends");
		return resp;

	}
	// view
//	@SuppressWarnings("unchecked")
//	public ResponseEntity<JsonResponse<List<RestWeightBridgeModel>>> viewGatePassInWeight() {
//		logger.info("Method : viewGatePassInWeight starts");
//		List<RestWeightBridgeModel> respList = new ArrayList<RestWeightBridgeModel>();
//
//		try {
//			//String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\""
//			//		+ orgDivision + "\";";
//
//			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("gatePass_Routines")
//					.setParameter("actionType", "viewGateIn").setParameter("actionValue", "").getResultList();
//
//			for (Object[] m : x) {
//
//				
//				RestWeightBridgeModel viewdemo = new RestWeightBridgeModel(m[0], m[1], m[2], m[3],
//						m[4], m[5], m[6], m[7], m[8], m[9]);
//				respList.add(viewdemo);
//
//			}
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
//
//		JsonResponse<List<RestWeightBridgeModel>> resp = new JsonResponse<List<RestWeightBridgeModel>>();
//		resp.setBody(respList);
//		ResponseEntity<JsonResponse<List<RestWeightBridgeModel>>> response = new ResponseEntity<JsonResponse<List<RestWeightBridgeModel>>>(
//				resp, HttpStatus.CREATED);
//		logger.info("Method : viewGatePassInWeight ends");
//		return response;
//
//	}
	
	//add gate in weight
	public ResponseEntity<JsonResponse<Object>> addWeightBridgeGateIn(RestWeightBridgeModel restWeightBridgeModel) {

		logger.info("Method in Dao: addWeightBridgeGateIn starts"+restWeightBridgeModel);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateWeightBridgeParameter.addWeightParam(restWeightBridgeModel);

			System.out.println("==============" + values);
			entityManager.createNamedStoredProcedureQuery("weight_bridge_routines").setParameter("actionType", "addGateIn")
					.setParameter("actionValue", values).execute();
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				resp.setCode("failed");
				resp.setMessage("Something is wrong");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addWeightBridgeGateIn ends");

		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestWeightBridgeModel>> viewGatePassOutWeight(@RequestParam String pageno, String orgName, String orgDiv) {
		logger.info("Method : viewGatePassOutWeight starts");

		List<RestWeightBridgeModel> getAllemployee = new ArrayList<RestWeightBridgeModel>();
		JsonResponse<List<RestWeightBridgeModel>> resp = new JsonResponse<List<RestWeightBridgeModel>>();

		try {
			String value = "SET @p_orgName=\"" + orgName + "\", @p_orgDiv=\"" + orgDiv + "\", @p_pageno=\"" + pageno + "\";";
			System.out.println("value>>>>"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("weight_bridge_routines")
					.setParameter("actionType", "viewGateOut").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				if(m[7]==null || m[7]=="") {
					m[7]="N/A";
				}
				if(m[8]==null || m[8]=="") {
					m[8]="N/A";
				}
				if(m[9]==null || m[9]=="") {
					m[9]="N/A";
				}
				if(m[10]==null || m[10]=="") {
					m[10]="N/A";
				}
				RestWeightBridgeModel viewdemo = new RestWeightBridgeModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],m[17]);

				getAllemployee.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(getAllemployee);
		System.out.println("getAllemployee>>>>----"+getAllemployee);
		logger.info("Method : viewGatePassOutWeight ends");
		return resp;

	}
	
	//add gate out weight
	public ResponseEntity<JsonResponse<Object>> addWeightBridgeGateOut(RestWeightBridgeModel restWeightBridgeModel) {

		logger.info("Method in Dao: addWeightBridgeGateOut starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateWeightBridgeParameter.addWeightParam(restWeightBridgeModel);

			System.out.println("==============" + values);
			entityManager.createNamedStoredProcedureQuery("weight_bridge_routines").setParameter("actionType", "addGateOut")
					.setParameter("actionValue", values).execute();
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				resp.setCode("failed");
				resp.setMessage("Something is wrong");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addWeightBridgeGateOut ends");

		return response;
	}
	
	//entry approval
	public JsonResponse<RestWeightBridgeModel> entryApproval(String entryId, String userId) {
		logger.info("Method : entryApproval starts");

		JsonResponse<RestWeightBridgeModel> resp = new JsonResponse<RestWeightBridgeModel>();
		try {
			String value = "SET @p_entryId='" + entryId + "',@p_userId='" + userId + "';";
			System.out.println("value===" + value);
			entityManager.createNamedStoredProcedureQuery("weight_bridge_routines").setParameter("actionType", "entryApproval")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Entry approved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("resp===" + resp);
		logger.info("Method : entryApproval ends");
		return resp;
	}
	
	//exit approval
	public JsonResponse<RestWeightBridgeModel> exitApproval(String registerId, String userId) {
		logger.info("Method : exitApproval starts");

		JsonResponse<RestWeightBridgeModel> resp = new JsonResponse<RestWeightBridgeModel>();
		try {
			String value = "SET @p_registerId='" + registerId + "',@p_userId='" + userId + "';";
			System.out.println("value===" + value);
			entityManager.createNamedStoredProcedureQuery("weight_bridge_routines").setParameter("actionType", "exitApproval")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Entry approved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("resp===" + resp);
		logger.info("Method : exitApproval ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestWeightBridgeModel>> viewGatePassTotalWeight(@RequestParam String pageno, String orgName, String orgDiv) {
		logger.info("Method : viewGatePassTotalWeight starts");

		List<RestWeightBridgeModel> getAllemployee = new ArrayList<RestWeightBridgeModel>();
		JsonResponse<List<RestWeightBridgeModel>> resp = new JsonResponse<List<RestWeightBridgeModel>>();

		try {
			String value = "SET @p_orgName=\"" + orgName + "\", @p_orgDiv=\"" + orgDiv + "\", @p_pageno=\"" + pageno + "\";";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("weight_bridge_routines")
					.setParameter("actionType", "totalView").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestWeightBridgeModel viewdemo = new RestWeightBridgeModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12],m[13],m[14],m[15],m[16]);

				getAllemployee.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(getAllemployee);
		logger.info("Method : viewGatePassTotalWeight ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewGatePassReport(String orgName, String orgDivision, String fromdate, String todate, String type) {
		logger.info("Method : viewGatePassReport starts");

		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String FormDate = DateFormatter.getStringDate(fromdate);
		String ToDate = DateFormatter.getStringDate(todate);
		
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromdate='" + FormDate + "',@p_todate='" + ToDate + "',@p_type='" + type  + "';";
			System.out.println("values****************************" + value);

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("weight_bridge_routines")
					.setParameter("actionType", "totalViewReport").setParameter("actionValue", value)
					.getResultList();
			
			resp.setBody(x);
			
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
	
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		
		System.out.println("getAllemployee>>>>---"+resp);
		logger.info("Method : viewGatePassReport ends");
		return resp;

	}
	
	// Download Slip
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> downloadSlip(String id, String orgName, String orgDivision) {
		logger.info("Method : downloadSlip Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_slipId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("weight_bridge_routines")
					.setParameter("actionType", "downloadSlip").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : downloadSlip Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}
	
	// weigh In Delete.
	
	public ResponseEntity<JsonResponse<Object>> weighInDelete(String id, String orgName, String orgDivision) {
		logger.info("Method : weighInDelete dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_gateInId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			
			entityManager.createNamedStoredProcedureQuery("weight_bridge_routines")
					.setParameter("actionType", "weighInDelete").setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
			resp.setMessage("Data Deleted Successfully");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : weighInDelete dao ends");
		return response;
	}
	
	// weighOut Delete.
	
	public ResponseEntity<JsonResponse<Object>> weighOutDelete(String id, String orgName, String orgDivision) {
		logger.info("Method : weighOutDelete dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_slipId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("value>>>>-----"+value);
			entityManager.createNamedStoredProcedureQuery("weight_bridge_routines")
					.setParameter("actionType", "weighOutDelete").setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
			resp.setMessage("Data Deleted Successfully");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : weighOutDelete dao ends");
		return response;
	}
	
	//Search
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> gatePassInWeightSearch(@RequestParam String sValue, String orgName, String orgDiv) {
		logger.info("Method : gatePassInWeightSearch starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName=\"" + orgName + "\", @p_orgDiv=\"" + orgDiv + "\", @p_sValue=\"" + sValue + "\";";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("weight_bridge_routines")
					.setParameter("actionType", "gatePassInWeightSearch").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		logger.info("Method : gatePassInWeightSearch ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestWeightBridgeModel>> gatePassOutWeightSearch(@RequestParam String sValue, String orgName, String orgDiv) {
		logger.info("Method : gatePassOutWeightSearch starts");

		List<RestWeightBridgeModel> getAllemployee = new ArrayList<RestWeightBridgeModel>();
		JsonResponse<List<RestWeightBridgeModel>> resp = new JsonResponse<List<RestWeightBridgeModel>>();

		try {
			String value = "SET @p_orgName=\"" + orgName + "\", @p_orgDiv=\"" + orgDiv + "\", @p_sValue=\"" + sValue + "\";";
			System.out.println("value>>>>"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("weight_bridge_routines")
					.setParameter("actionType", "gatePassOutWeightSearch").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				if(m[7]==null || m[7]=="") {
					m[7]="N/A";
				}
				if(m[8]==null || m[8]=="") {
					m[8]="N/A";
				}
				if(m[9]==null || m[9]=="") {
					m[9]="N/A";
				}
				if(m[10]==null || m[10]=="") {
					m[10]="N/A";
				}
				RestWeightBridgeModel viewdemo = new RestWeightBridgeModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], null,null);

				getAllemployee.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(getAllemployee);
		System.out.println("getAllemployee>>>>----"+getAllemployee);
		logger.info("Method : gatePassOutWeightSearch ends");
		return resp;

	}
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestWeightBridgeModel>> gatePassTotalWeightSearch(@RequestParam String sValue, String orgName, String orgDiv) {
		logger.info("Method : gatePassTotalWeightSearch starts");

		List<RestWeightBridgeModel> getAllemployee = new ArrayList<RestWeightBridgeModel>();
		JsonResponse<List<RestWeightBridgeModel>> resp = new JsonResponse<List<RestWeightBridgeModel>>();

		try {
			String value = "SET @p_orgName=\"" + orgName + "\", @p_orgDiv=\"" + orgDiv + "\", @p_sValue=\"" + sValue + "\";";
			System.out.println("value>>>>"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("weight_bridge_routines")
					.setParameter("actionType", "gatePassTotalWeightSearch").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestWeightBridgeModel viewdemo = new RestWeightBridgeModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12],m[13],m[14],null,null);

				getAllemployee.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(getAllemployee);
		logger.info("Method : gatePassTotalWeightSearch ends");
		return resp;

	}
}
