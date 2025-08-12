package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestProductVendorReportModel;

@Repository
public class ProductVendorReportDao {
	Logger logger = LoggerFactory.getLogger(ProductVendorReportDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestProductVendorReportModel>>> viewProductVendorReport(String orgName, String orgDiv) {
		logger.info("Method : viewProductVendorReport Dao starts");

		List<RestProductVendorReportModel> getAllData = new ArrayList<RestProductVendorReportModel>();
		JsonResponse<List<RestProductVendorReportModel>> resp = new JsonResponse<List<RestProductVendorReportModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("viewProductVendorReport -----------"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("vendorMasterRoutines")
					.setParameter("actionType", "viewProductVendorReport").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
			Object CREATEDON = null;
			if (m[11] != null) {
				CREATEDON  = DateFormatter.returnStringDate(m[11]);
			}
			Object compdate = null;
			if (m[12] != null) {
				compdate  = DateFormatter.returnStringDate(m[12]);
			}
			RestProductVendorReportModel viewdemo = new RestProductVendorReportModel(m[0],m[1], m[2], m[3], m[4],m[5],m[6],m[7],m[8],m[9],m[10],CREATEDON,
															compdate,m[13],m[14],m[15],m[16],m[17],m[18],m[19],m[20],
															m[21],m[22],m[23],m[24],m[25],m[26],m[27],m[28],m[29],m[30],m[31],m[32],m[33],m[34]);
			getAllData.add(viewdemo);
			}
			resp.setBody(getAllData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//logger.info("resp -----------"+resp);
		ResponseEntity<JsonResponse<List<RestProductVendorReportModel>>> response = new ResponseEntity<JsonResponse<List<RestProductVendorReportModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewProductVendorReport Dao ends");
	
		return response;

	}
}
