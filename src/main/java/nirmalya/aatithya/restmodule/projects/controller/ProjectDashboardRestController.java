package nirmalya.aatithya.restmodule.projects.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.projects.dao.ProjectDashboardDao;
import nirmalya.aatithya.restmodule.projects.model.ProjectBudgetRestHourGraph;
import nirmalya.aatithya.restmodule.projects.model.ProjectDashboardRestModel;

@RestController
@RequestMapping(value = "projects/")
public class ProjectDashboardRestController {
Logger logger = LoggerFactory.getLogger(ProjectDashboardRestController.class);
	
	@Autowired
	ProjectDashboardDao projectDashboardDao;
	/*
	 * totla assets
	 */
	@GetMapping(value = "projectCount")
	public List<DropDownModel> totalProjects() {
		logger.info("Method : totalProjects starts");

		logger.info("Method : totalProjects ends");
		return projectDashboardDao.totalProjects();
	}
	/*
	 * totla generalTicket
	 */
	@GetMapping(value = "internalCount")
	public List<DropDownModel> internalProjects() {
		logger.info("Method : internalProjects starts");
		
		logger.info("Method : internalProjects ends");
		return projectDashboardDao.internalProjects();
	}
	/*
	 * total serviceTicket
	 */
	@GetMapping(value = "externalcount")
	public List<DropDownModel> externalProjects() {
		logger.info("Method : externalProjects starts");
		
		logger.info("Method : externalProjects ends");
		return projectDashboardDao.externalProjects();
	}
	/*
	 * priority Table
	 */
	@GetMapping(value = "projectPriority")
	public List<DropDownModel> projectPriorityList() {
		logger.info("Method : projectPriorityList starts");
		
		logger.info("Method : projectPriorityList ends");
		return projectDashboardDao.projectPriorityList();
	}
	/*
	 * priority Table
	 */
	@GetMapping(value = "projecttable")
	public List<ProjectDashboardRestModel> projectTable() {
		logger.info("Method : projectTable starts");
		
		logger.info("Method : projectTable ends");
		return projectDashboardDao.projectTable();
	}
	/*
	 *General tickets For Graph
	 */
	@RequestMapping(value = "getProjectPriority", method = { RequestMethod.GET })
	public List<ProjectDashboardRestModel> getPriorityPieChart() {

		logger.info("Method : getPriorityPieChart starts");
		logger.info("Method : getPriorityPieChart ends");

		return projectDashboardDao.getPriorityPieChart();
	}
	/*
	 * total Budget Count
	 */
	@GetMapping(value = "totalBudgetCount")
	public List<DropDownModel> totalBudget() {
		logger.info("Method : totalBudget starts");
		
		logger.info("Method : totalBudget ends");
		return projectDashboardDao.totalBudget();
	}
	/*
	 * total no resource
	 */
	@GetMapping(value = "noResourceCount")
	public List<DropDownModel> noResourceBudget() {
		logger.info("Method : noResourceBudget starts");
		
		logger.info("Method : noResourceBudget ends");
		return projectDashboardDao.noResourceBudget();
	}
	/*
	 *Department Graph
	 */
	@RequestMapping(value = "getDepartmentGraph", method = { RequestMethod.GET })
	public List<ProjectDashboardRestModel> getDepartmentGraph() {

		logger.info("Method : getDepartmentGraph starts");
		logger.info("Method : getDepartmentGraph ends");

		return projectDashboardDao.getDepartmentGraph();
	}
	/*
	 *Budget hour Graph
	 */
	@RequestMapping(value = "getHourGraph", method = { RequestMethod.GET })
	public List<ProjectBudgetRestHourGraph> getBudgetHourGraph() {
		
		logger.info("Method : getBudgetHourGraph starts");
		logger.info("Method : getBudgetHourGraph ends");
		
		return projectDashboardDao.getBudgetHourGraph();
	}
}
