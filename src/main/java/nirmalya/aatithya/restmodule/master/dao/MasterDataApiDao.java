package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.user.dao.UserLoginDao;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class MasterDataApiDao {

	Logger logger = LoggerFactory.getLogger(MasterDataApiDao.class);

	public final EntityManager em;

	@Autowired
	public MasterDataApiDao(EntityManager em) {
		this.em = em;
	}

	// getOwnerList

	/**
	 * for getOwnerList
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOwnerList(String userId,String org,String orgDiv) {

		logger.info("Method : getOwnerList starts");

		List<DropDownModel> ownerList = new ArrayList<DropDownModel>();
		String value = "SET @p_userId='" + userId + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
		System.out.println("values-->" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "getOwnerList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				if (m[2] == null) {
					m[2] = "";
				}
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				ownerList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOwnerList ends" + ownerList);

		return ownerList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCrmTaskStatus() {

		logger.info("Method : getCrmTaskStatus starts");

		List<DropDownModel> ownerList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "getCrmTaskStatus").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ownerList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCrmTaskStatus ends" + ownerList);

		return ownerList;
	}

}
