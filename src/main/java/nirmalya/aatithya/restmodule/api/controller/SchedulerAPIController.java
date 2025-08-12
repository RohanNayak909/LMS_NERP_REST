package nirmalya.aatithya.restmodule.api.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.api.dao.SchedulerAPIDao;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;

@EnableScheduling
@RestController
@RequestMapping(value = "api")
public class SchedulerAPIController {

	@Autowired
	EnvironmentVaribles env;
 
	@Autowired
	SchedulerAPIDao schedulerAPIDao;

	Logger logger = LoggerFactory.getLogger(SchedulerAPIController.class);

	@Scheduled(cron = "0 30 10 ? * *")
	public void leadFollowUpReminder() throws Exception {
	    logger.info("Lead Follow-up Reminder Scheduler Start");

	    Date dt = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	    String date = formatter.format(dt);
	    logger.info("Reminder Date: {}", date); 

	    schedulerAPIDao.leadFollowUpReminder(date);

	    logger.info("Lead Follow-up Reminder Scheduler End");
	}


	@RequestMapping(value = "/leadFollowUpReminder-api", method = { RequestMethod.GET })
	public void leadFollowUpReminderApi() {
		logger.info("Method : leadFollowUpReminderApi starts");
		Date dt = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String date = formatter.format(dt);
		logger.info("date");
		schedulerAPIDao.attendanceReminder(date);
	}

}
