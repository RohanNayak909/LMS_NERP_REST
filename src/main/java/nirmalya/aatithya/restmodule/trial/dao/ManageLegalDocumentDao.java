package nirmalya.aatithya.restmodule.trial.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.google.common.net.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.trial.GenerateManageLegalDocumentParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.trial.model.RestManageLegalDocumentModel;


@Repository
public class ManageLegalDocumentDao {

	Logger logger = LoggerFactory.getLogger(ManageLegalDocumentDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	
	public List<DropDownModel> legaldoculist() {
		logger.info("Method : getDocumentList starts");

		List<DropDownModel> documentdropdown = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_Legaldoc_Routines")
					.setParameter("actionType", "getDocumentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				documentdropdown.add(dropDownModel);
				System.out.println("###############" + dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDocumentList ends");

		return documentdropdown;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> legalvendorlist() {
		logger.info("Method : getVendorList starts");

		List<DropDownModel> vdlistdropdown = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_Legaldoc_Routines")
					.setParameter("actionType", "getVendorList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vdlistdropdown.add(dropDownModel);
				System.out.println("###############" + dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVendorList ends");

		return vdlistdropdown;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> legalvehiclelist() {
		logger.info("Method : getVehicleList starts");

		List<DropDownModel> vhlistdropdown = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_Legaldoc_Routines")
					.setParameter("actionType", "getVehicleList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vhlistdropdown.add(dropDownModel);
				System.out.println("###############" + dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVehicleList ends");

		return vhlistdropdown;
	}

	// add student data
	public ResponseEntity<JsonResponse<Object>> addLegalDoc(RestManageLegalDocumentModel restManageLegalDocumentModel) {

		logger.info("aaaaaaaaaaaaaaaaaaaaaa");
		logger.info("Method : addlegaldoc starts");
		System.out.println("RestManageLegalDocumentModel" + restManageLegalDocumentModel);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateManageLegalDocumentParameter
					.getManagelegalDocumentParam(restManageLegalDocumentModel);
			System.out.println(values);

			if (restManageLegalDocumentModel.getLegalId() == null || restManageLegalDocumentModel.getLegalId() == "") {
				System.out.println("Hii New");
				em.createNamedStoredProcedureQuery("vm_Legaldoc_Routines").setParameter("actionType", "addLegalDoc")
						.setParameter("actionValue", values).execute();
				System.out.println("print in addlegaldoc block");

			}

			else {
				System.out.println("print in modify block");
				em.createNamedStoredProcedureQuery("vm_Legaldoc_Routines").setParameter("actionType", "modifylegalDoc")
						.setParameter("actionValue", values).execute();
				System.out.println("print end in modify block");

			}

		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : adddist ends");
		return response;

	}

	// view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageLegalDocumentModel>>> legalDocDao() {
		logger.info("Method : legalDocDao starts");
		List<RestManageLegalDocumentModel> respList = new ArrayList<RestManageLegalDocumentModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_Legaldoc_Routines")
					.setParameter("actionType", "viewLegalDoc").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
				if(m[6]==null)
				{
					m[6]="";
				}

				RestManageLegalDocumentModel restView = new RestManageLegalDocumentModel(m[0], m[1], m[2], m[3], null,
						m[4].toString(), null, m[5].toString(), null, null, m[6].toString(),null,null);

				respList.add(restView);
				logger.info("restView" + restView);
			}

			logger.info("VIEWWWW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestManageLegalDocumentModel>> resp = new JsonResponse<List<RestManageLegalDocumentModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestManageLegalDocumentModel>>> response = new ResponseEntity<JsonResponse<List<RestManageLegalDocumentModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : legalDocDao ends");
		System.out.println("VIEWWWWWWWWWW" + response);
		return response;

	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteLegalDoc(String id) {
		logger.info("Method : deleteLegalDoc Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("id" + id);

		try {
			String values = "SET @p_legalid='" + id + "';";

			em.createNamedStoredProcedureQuery("vm_Legaldoc_Routines").setParameter("actionType", "deleteLegalDoc")
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

		logger.info("Method : deleteLegalDoc Dao ends");
		return response;
	}


	// edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestManageLegalDocumentModel>> legalDoc(String id) {
		logger.info("Method : editlegalDoc starts");

		RestManageLegalDocumentModel req = new RestManageLegalDocumentModel();
		JsonResponse<RestManageLegalDocumentModel> resp = new JsonResponse<RestManageLegalDocumentModel>();
		logger.info(id);

		try {

			String value = "SET @p_legalId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("vm_Legaldoc_Routines")
					.setParameter("actionType", "editlegalDoc").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				
				Object DATE = null;
				if (m[5] != null) {
					DATE = m[5].toString();
				}

				Object DATE1 = null;
				if (m[7] != null) {
					DATE1 = m[7].toString();
				}

				RestManageLegalDocumentModel reqemp = new RestManageLegalDocumentModel(m[0], m[1], m[2], m[3], m[4].toString(),DATE,
						m[6].toString(), DATE1, m[8].toString(), m[9].toString(), m[10].toString(),m[11],m[12]);
				req = reqemp;

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<RestManageLegalDocumentModel>> response = new ResponseEntity<JsonResponse<RestManageLegalDocumentModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : editlegalDoc ends");
		System.out.println(response);
		return response;

	}

}
