package nirmalya.aatithya.restmodule.purchase.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GeneratePurchaseOrderParameter;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;

@Repository
public class RestPurchaseProductDao {

	Logger logger = LoggerFactory.getLogger(RestPurchaseProductDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	public JsonResponse<Object> addbrandDetails(ProductMasterModel productMasterModel) {
		logger.info("Method : addbrandDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GeneratePurchaseOrderParameter.getBrandAdd(productMasterModel);
			if (productMasterModel.getBrandId() == null || productMasterModel.getBrandId() == "") {
				System.out.println("ADD" + values);
				em.createNamedStoredProcedureQuery("purchaseProduct").setParameter("actionType", "addbrandDetails")
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
		}
		logger.info("ADDDDDDD" + resp);
		logger.info("Method : addbrandDetails ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBrandList(String id,String orgName,
			String orgDiv) {

		logger.info("Method : getBrandList starts");
		List<DropDownModel> referenceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseProduct")
					.setParameter("actionType", "getBrandList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				referenceList.add(dropDownModel);
			}
			resp.setBody(referenceList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getBrandList ends"+response);
		return response;
	}
}
