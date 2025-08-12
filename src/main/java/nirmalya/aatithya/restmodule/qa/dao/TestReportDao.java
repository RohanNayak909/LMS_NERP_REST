package nirmalya.aatithya.restmodule.qa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class TestReportDao {

	Logger logger = LoggerFactory.getLogger(RestSampleTestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	// Item List.
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getItemList(String org,String orgDiv) {
		logger.info("Method : getItemList starts");

		List<DropDownModel> getDeptList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		System.out.println("value>>>>>>>>>-------"+value);
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_test_report_routines")
					.setParameter("actionType", "getItemList").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getDeptList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getItemList ends");
		return getDeptList;
	}

	// View.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewTestReportData(String orgName, String orgDivision) {
		logger.info("Method : viewTestReportData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		// String FormDate = DateFormatter.getStringDate(fromdate);
		// String ToDate = DateFormatter.getStringDate(todate);
		// String FormDate = "2023-06-28";
		// String ToDate = "2023-06-28";

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_test_report_routines")
					.setParameter("actionType", "viewTestReportData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewTestReportData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// View Details.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewTestReportDtlsData(String orgName, String orgDivision, String sku, String fdate, String tdate) {
		logger.info("Method : viewTestReportDtlsData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		 String FormDate = DateFormatter.getStringDate(fdate);
		 String ToDate = DateFormatter.getStringDate(tdate);
		// String FormDate = "2023-06-28";
		// String ToDate = "2023-06-28";

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_sku='" + sku + "',@p_fdate='" + FormDate + "',@p_tdate='" + ToDate + "';";
			System.out.println("values****************************" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_test_report_routines")
					.setParameter("actionType", "viewTestReportDtlsData").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x.get(0));

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewTestReportDtlsData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

}
