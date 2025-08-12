package nirmalya.aatithya.restmodule.his.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.model.HISPrescriptionRestModel;

@Repository
public class HISPrescriptionRestDao {

	Logger logger = LoggerFactory.getLogger(HISPrescriptionRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPrescription(String orgName, String orgDivision, String fromdate, String todate) {
		logger.info("Method : viewPrescription Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromdate='" + fromdate
					+ "',@p_todate='" + todate + "' ;";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "viewPrescription").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPrescription Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public List<HISPrescriptionRestModel> viewPrescriptionEdit(String id) {
		logger.info("Method : viewPrescriptionEdit starts");
		System.out.println("viewPrescriptionEdit" + id);
		List<HISPrescriptionRestModel> getRequisitionTypeList = new ArrayList<HISPrescriptionRestModel>();

		try {
			String values = "SET @p_prescriptionId='" + id + "';";
			System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "viewPrescriptionData").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					Object DATE = null;
					if (m[9] != null) {
						DATE = m[9].toString();
					}

					Object SDATE = null;
					if (m[11] != null) {
						SDATE = m[11].toString();
					}

					Object DDATE = null;
					if (m[20] != null) {
						DDATE = m[20].toString();
					}

					HISPrescriptionRestModel dropDownModel = new HISPrescriptionRestModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7], m[8], DATE, m[10], SDATE, m[12], m[13], m[14], m[15].toString(),
							m[16].toString(), m[17].toString(), m[18].toString(), m[19], DDATE, m[21],m[22],m[23]);
					getRequisitionTypeList.add(dropDownModel);
					System.out.println("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// resp.setBody(getRequisitionTypeList);
		System.out.println("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : viewPrescriptionEdit ends");
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HISPrescriptionRestModel>>> prescriptionData(String appointmentId) {
		logger.info("Method : prescriptionData starts" + appointmentId);

		JsonResponse<List<HISPrescriptionRestModel>> resp = new JsonResponse<List<HISPrescriptionRestModel>>();
		List<HISPrescriptionRestModel> rs = new ArrayList<HISPrescriptionRestModel>();
		List<DropDownModel> test = new ArrayList<DropDownModel>();
		// String value = "SET @p_dealerId='" + id + "';";
		

		try {
			String value = "SET @p_appointmentId='" + appointmentId + "';";
			System.out.println("value====" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "prescriptionData").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object DATE = null;
				if (m[9] != null) {
					DATE = m[9].toString();
				}

				Object SDATE = null;
				if (m[11] != null) {
					SDATE = m[11].toString();
				}

				Object DDATE = null;
				if (m[20] != null) {
					DDATE = m[20].toString();
				}

				HISPrescriptionRestModel dropDownModel = new HISPrescriptionRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], DATE, m[10], SDATE, m[12], m[13], m[14], m[15].toString(),
						m[16].toString(), m[17].toString(), m[18].toString(), m[19], DDATE, m[21],m[22],m[23]);

				rs.add(dropDownModel);
			}

			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<HISPrescriptionRestModel>>> response = new ResponseEntity<JsonResponse<List<HISPrescriptionRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : prescriptionData ends" + response);
		System.out.println(response);
		return response;
	}
}
