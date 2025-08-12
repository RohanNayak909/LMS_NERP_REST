package nirmalya.aatithya.restmodule.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.dao.UserAllTaskDao;

@RestController
@RequestMapping(value = { "user" })
public class UserAllTaskRestController {
	Logger logger = LoggerFactory.getLogger(UserAllTaskRestController.class);

	@Autowired
	UserAllTaskDao userAllTaskDao;
	
	//allTasksView
	@RequestMapping(value = "all-tasks-view", method = { RequestMethod.GET })
	public JsonResponse<Object> allTasksView(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method :allTasksView start");

		logger.info("Method :allTasksView endss");
		return userAllTaskDao.allTasksView(orgName, orgDivision,userId);
	}
	@GetMapping("all-task-list-calendar-wise")
	public JsonResponse<Object> getTaskForCalendars(@RequestParam String startDate,String endtDate,String orgName,String orgDiv,String userId) {
		logger.info("Method :getTaskForCalendars start");

		logger.info("Method :getTaskForCalendars ends");
		return userAllTaskDao.getTaskForCalendars(startDate, endtDate, orgName, orgDiv, userId);
	}

}
