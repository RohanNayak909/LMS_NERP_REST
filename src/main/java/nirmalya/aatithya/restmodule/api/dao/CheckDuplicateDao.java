package nirmalya.aatithya.restmodule.api.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

@Repository
public class CheckDuplicateDao {

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@Autowired PasswordEncoder passEncoder;
	Logger logger = LoggerFactory.getLogger(CheckDuplicateDao.class);
 
	@SuppressWarnings("unchecked")
	public Boolean isValidEmployeeNumber(String employeeId) {
		logger.info("Method : isValidEmployeeNumber Dao starts");

		Boolean isExist = false;

		List<DropDownModel> dataList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_empid='" + employeeId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "employeeid_exist").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				dataList.add(dropDownModel);
			}
			if (dataList != null) {
				isExist = true;
			}

			if (dataList.size() > 0) {
				isExist = true;
			} else {
				isExist = false;
			}
		} catch (Exception e) {
			isExist = false;
		}
		logger.info("Method : isValidEmployeeNumber Dao ends");
		return isExist;
	}
	//isValidUserName
		@SuppressWarnings("unchecked")
		public Boolean isValidUserName(String userName) {
			logger.info("Method : isValidUserName Dao starts");
			
			Boolean isExist = false;
			
			List<DropDownModel> dataList = new ArrayList<DropDownModel>();
			try {
				String value = "SET @p_userName='" + userName + "';";
				logger.info("check user=="+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
						.setParameter("actionType", "username_exist").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
					dataList.add(dropDownModel);
				}
				if (dataList != null) {
					isExist = true;
				}
				
				if (dataList.size() > 0) {
					isExist = true;
				} else {
					isExist = false;
				}
			} catch (Exception e) {
				isExist = false;
			}
			
			logger.info("Method : isValidUserName Dao ends");
			return isExist;
		}
	@SuppressWarnings("unchecked")
	public Boolean isValidEmployeeMobileNumber(String employeeId,String mobileNo) {
		logger.info("Method : isValidEmployeeMobileNumber Dao starts");

		Boolean isExist = false;

		List<DropDownModel> dataList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_mobileNo='" + mobileNo + "',@p_empid='" + employeeId + "';";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "check_valid_mob").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				dataList.add(dropDownModel);
			}
			if (dataList != null) {
				isExist = true;
			}

			if (dataList.size() > 0) {
				isExist = true;
			} else {
				isExist = false;
			}

		} catch (Exception e) {
			isExist = false;
		}

		logger.info("Method : isValidEmployeeMobileNumber Dao ends");
		return isExist;
	}

	@SuppressWarnings("unchecked")
	public String getUserPassword(String userid) {
		logger.info("Method : getUserPassword Dao starts");
		List<DropDownModel> dataList = new ArrayList<DropDownModel>();
		String password = "";
		try {
			String value = "SET @p_userid='" + userid + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "get_password").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				dataList.add(dropDownModel);
			}
			if (dataList.size() > 0) {
				password = dataList.get(0).getName();
			} else {
				password = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			password = null;
		}
		logger.info("Get---Password===" + password);
		logger.info("Method : getUserPassword Dao ends");
		return password;
	}
	//manager List
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getManagerByUser(String userid) {
		logger.info("Method : manager List Dao starts");

		List<DropDownModel> managerList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_userid='" + userid + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "managerListByUser").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				managerList.add(dropDownModel);
			}

		} catch (Exception e) {
			logger.error("managerList: "+e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : manager List Dao ends");
		return managerList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getUserByRequisitionId(String reqid,String managerid) {
		logger.info("Method : manager List Dao starts");
		List<DropDownModel> employeeList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_reqid='" + reqid + "',@p_managerid='" + managerid + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "getUserByRequisitionId").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employeeList.add(dropDownModel);
			}
		} catch (Exception e) {
			logger.error("getUserByRequisitionId: "+e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getUserByRequisitionId Dao ends");
		return employeeList;
	}

}
