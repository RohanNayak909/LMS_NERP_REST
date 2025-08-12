package nirmalya.aatithya.restmodule.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.dao.SetAuthorityDao;
import nirmalya.aatithya.restmodule.user.model.RestProcessMasterModel;
import nirmalya.aatithya.restmodule.user.model.UserSetAuthority;

@RestController
@RequestMapping(value = "user/")
public class SetAuthorityUsersRestController {

	@Autowired
	SetAuthorityDao setAuthorityDao;

	Logger logger = LoggerFactory.getLogger(SetAuthorityUsersRestController.class);
	
	@GetMapping(value = "getUserRoleDropDown")
	public List<DropDownModel> getUserRoleDropDown() {
		logger.info("Method : getUserRoleDropDown starts");
		
		logger.info("Method : getUserRoleDropDown ends");
		return setAuthorityDao.getUserRoleDropDown();
	}
	@GetMapping(value = "getDepartmentListDropDown")
	public List<DropDownModel> getDepartmentListDropDown() {
		logger.info("Method : getDepartmentListDropDown starts");
		
		logger.info("Method : getDepartmentListDropDown ends");
		return setAuthorityDao.getDepartmentListDropDown();
	}
	
	@GetMapping(value = "getProcessMasterList")
	public ResponseEntity<JsonResponse<List<RestProcessMasterModel>>> getProcessMasterList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getProcessMasterList starts");
		
		logger.info("Method : getProcessMasterList ends");
		return setAuthorityDao.getProcessMasterList(org,orgDiv);
	}
	
	@GetMapping(value = "getUserAuthorityList")
	public ResponseEntity<JsonResponse<List<UserSetAuthority>>> getUserAuthorityList(@RequestParam String id,String org,String orgDiv) {
		logger.info("Method : getUserAuthorityList starts");
		
		logger.info("Method : getUserAuthorityList ends");
		return setAuthorityDao.getUserAuthorityList(id,org,orgDiv);
	}
	
	@GetMapping(value = "getEmployeeListByRole")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeListByRole(@RequestParam String id) {
		logger.info("Method : getEmployeeListByRole starts");
		
		logger.info("Method : getEmployeeListByRole ends");
		return setAuthorityDao.getEmployeeListByRole(id);
	}
	
	@PostMapping(value = "saveProcessMaster")
	public ResponseEntity<JsonResponse<Object>> saveProcessMaster(@RequestBody RestProcessMasterModel id) {
		logger.info("Method : saveProcessMaster starts");
		
		logger.info("Method : saveProcessMaster ends");
		return setAuthorityDao.saveProcessMaster(id);
	}
	
	@PostMapping(value = "saveAuthorityMasterData")
	public ResponseEntity<JsonResponse<Object>> saveAuthorityMasterData(@RequestBody UserSetAuthority id) {
		logger.info("Method : saveAuthorityMasterData starts");
		
		logger.info("Method : saveAuthorityMasterData ends");
		return setAuthorityDao.saveAuthorityMasterData(id);
	}
	@RequestMapping(value = "rest-deleteProcess", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteProcess(@RequestParam String process,String userId,String org,String orgDiv) {
		logger.info("Method : deleteProcess starts");

		logger.info("Method : deleteProcess ends");
		return setAuthorityDao.deleteProcessDao(process,userId,org,orgDiv);
	}
	
	@RequestMapping(value = "rest-deleteAuthority", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAuthority(@RequestParam String process,String role,String userId,String org,String orgDiv) {
		logger.info("Method : deleteAuthority starts");
		
		logger.info("Method : deleteAuthority ends");
		return setAuthorityDao.deleteAuthorityDao(process,role,userId,org,orgDiv);
	}
 
}
