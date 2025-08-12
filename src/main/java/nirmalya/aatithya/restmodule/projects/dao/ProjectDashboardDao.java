package nirmalya.aatithya.restmodule.projects.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectBudgetRestHourGraph;
import nirmalya.aatithya.restmodule.projects.model.ProjectDashboardRestModel;

@Repository
public class ProjectDashboardDao {
	Logger logger = LoggerFactory.getLogger(ProjectDashboardDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	EntityManager em;
	@SuppressWarnings("unchecked")
	/*
	 * Total project List
	 * 
	 */
	public List<DropDownModel> totalProjects() {
		logger.info("Method : totalProjects starts");

		List<DropDownModel> dept = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectDashBoard")
					.setParameter("actionType", "totalProjects").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(),null);
				dept.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Dept ==="+dept);
		logger.info("Method : totalProjects ends");

		return dept;
	}
	@SuppressWarnings("unchecked")
	/*
	 * internal project count
	 * 
	 */
	public List<DropDownModel> internalProjects() {
		logger.info("Method : internalProjects starts");
		
		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectDashBoard")
					.setParameter("actionType", "internalProjects").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(),null);
				dept.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Dept ==="+dept);
		logger.info("Method : internalProjects ends");
		
		return dept;
	}
	@SuppressWarnings("unchecked")
	/*
	 * external project count
	 * 
	 */
	public List<DropDownModel> externalProjects() {
		logger.info("Method : externalProjects starts");
		
		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectDashBoard")
					.setParameter("actionType", "externalProjects").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(),null);
				dept.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Dept ==="+dept);
		logger.info("Method : externalProjects ends");
		
		return dept;
	}
	@SuppressWarnings("unchecked")
	/*
	 * Project priority List
	 * 
	 */
	public List<DropDownModel> projectPriorityList() {
		logger.info("Method : projectPriorityList starts");
		
		List<DropDownModel> dept = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectDashBoard")
					.setParameter("actionType", "priorityList").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(),m[1].toString());
				dept.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Dept ==="+dept);
		logger.info("Method : projectPriorityList ends");
		
		return dept;
	}
	@SuppressWarnings("unchecked")
	/*
	 * Project priority List
	 * 
	 */
	public List<ProjectDashboardRestModel> projectTable() {
		logger.info("Method : projectTable starts");
		
		List<ProjectDashboardRestModel> dept = new ArrayList<ProjectDashboardRestModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectDashBoard")
					.setParameter("actionType", "projectTable").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				ProjectDashboardRestModel dropDownModel = new ProjectDashboardRestModel(m[0], m[1], m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString());
				dept.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("projectTable ==="+dept);
		logger.info("Method : projectTable ends");
		
		return dept;
	}
	/*
	 * Project pie chart
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectDashboardRestModel> getPriorityPieChart() {
		logger.info("Method : getPriorityPieChart dao  starts");

		List<ProjectDashboardRestModel> requisitionData = new ArrayList<ProjectDashboardRestModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectDashBoard")
					.setParameter("actionType", "priorityPie").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				ProjectDashboardRestModel dropDownModel = new ProjectDashboardRestModel(m[0], m[1], m[2]);
				requisitionData.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPriorityPieChart dao ends");
		//System.out.println("getPriorityPieChart"+requisitionData);
		return requisitionData;
	}
	
	/*
	 * totalBudget Graph
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> totalBudget() {
		logger.info("Method : totalBudget dao  starts");
		
		List<DropDownModel> requisitionData = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectDashBoard")
					.setParameter("actionType", "totalBudget").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1].toString());
				requisitionData.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : totalBudget dao ends");
		//System.out.println("totalBudget"+requisitionData);
		return requisitionData;
	}
	/*
	 * total no resource
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> noResourceBudget() {
		logger.info("Method : noResourceBudget dao  starts");
		
		List<DropDownModel> requisitionData = new ArrayList<DropDownModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectDashBoard")
					.setParameter("actionType", "noResourceBUdget").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1].toString());
				requisitionData.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : noResourceBudget dao ends");
		//System.out.println("noResourceBudget"+requisitionData);
		return requisitionData;
	}
	/*
	 * Department Graph
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectDashboardRestModel> getDepartmentGraph() {
		logger.info("Method : getDepartmentGraph dao  starts");
		Integer total = 0;
		List<ProjectDashboardRestModel> requisitionData = new ArrayList<ProjectDashboardRestModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectDashBoard")
					.setParameter("actionType", "getDepartmentGraph").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				BigInteger t = (BigInteger) m[1];
				total = Integer.parseInt((t.toString()));
				
				ProjectDashboardRestModel dropDownModel = new ProjectDashboardRestModel(m[0], total);
				requisitionData.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getDepartmentGraph dao ends");
		//System.out.println("getDepartmentGraph"+requisitionData);
		return requisitionData;
	}
	/*
	 * Budget hour Graph
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectBudgetRestHourGraph> getBudgetHourGraph() {
		logger.info("Method : getBudgetHourGraph dao  starts");
		Integer total = 0;
		List<ProjectBudgetRestHourGraph> requisitionData = new ArrayList<ProjectBudgetRestHourGraph>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectDashBoard")
					.setParameter("actionType", "getHourGraph").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				
				
				ProjectBudgetRestHourGraph dropDownModel = new ProjectBudgetRestHourGraph(m[0], m[1],m[2]);
				requisitionData.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getBudgetHourGraph dao ends");
		System.out.println("getBudgetHourGraph"+requisitionData);
		return requisitionData;
	}
}
