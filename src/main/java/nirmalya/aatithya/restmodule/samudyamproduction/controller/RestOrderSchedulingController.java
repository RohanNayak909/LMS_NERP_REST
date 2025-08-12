package nirmalya.aatithya.restmodule.samudyamproduction.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;
import nirmalya.aatithya.restmodule.samudyamproduction.dao.OrderSchedulingDao;

@RestController
@RequestMapping("production")
public class RestOrderSchedulingController {
	Logger logger = LoggerFactory.getLogger(RestOrderSchedulingController.class);
	@Autowired
	OrderSchedulingDao orderSchedulingDao;
	
	/*
	 * @PostMapping(value = "getOrderScheduling") public
	 * JsonResponse<List<RestSaleOrderNewModel>> getOrderScheduling(@RequestBody
	 * EmpRoleModel empModel) { String userId = empModel.getUserId(); String
	 * organization=empModel.getOrganization(); String
	 * orgDivision=empModel.getOrgDivision();
	 * logger.info("Method :getAllsalesOrder starts");
	 * 
	 * 
	 * logger.info("Method :getOrderScheduling endss"); return
	 * orderSchedulingDao.getOrderScheduling(userId,organization,orgDivision); }
	 */
}
