package nirmalya.aatithya.restmodule.his.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISPatientDao;
import nirmalya.aatithya.restmodule.his.dao.RestHISOTReservationDao;
import nirmalya.aatithya.restmodule.his.model.HISBedMasterRestModel;
import nirmalya.aatithya.restmodule.his.model.HISOTReservationRestModel;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;
import nirmalya.aatithya.restmodule.user.model.RolesAccessModel;
import nirmalya.aatithya.restmodule.user.model.UserAccessModel;

@RestController
@RequestMapping(value = "his/")
public class RestHISOTReservationController {

	Logger logger = LoggerFactory.getLogger(RestHISOTReservationController.class);

	@Autowired
	RestHISOTReservationDao otDao;

	@GetMapping(value = "getOTPatientList")
	public ResponseEntity<JsonResponse<List<HISPatientRestModel>>> getOTPatientList(@RequestParam String id) {
		logger.info("Method : Rest getOTPatientList starts");

		logger.info("Method :Rest getOTPatientList ends");
		return otDao.getOTPatientList(id);
	}
	
	@RequestMapping(value = "groupList", method = { RequestMethod.GET })
	public List<DropDownModel> groupList() {
		logger.info("Method : groupList starts");

		logger.info("Method : groupList ends");
		return otDao.groupList();
	}
	
	@RequestMapping(value = "subGroupList", method = { RequestMethod.GET })
	public List<DropDownModel> subGroupList() {
		logger.info("Method : subGroupList starts");

		logger.info("Method : subGroupList ends");
		return otDao.subGroupList();
	}
	
	@RequestMapping(value = "empList", method = { RequestMethod.GET })
	public List<DropDownModel> empList() {
		logger.info("Method : empList starts");

		logger.info("Method : empList ends");
		return otDao.empList();
	}
	
	@RequestMapping(value = "surgeryList", method = { RequestMethod.GET })
	public List<DropDownModel> surgeryList() {
		logger.info("Method : surgeryList starts");

		logger.info("Method : surgeryList ends");
		return otDao.surgeryList();
	}
	
	/* add */

	@RequestMapping(value = "addOtReserve", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addOtReserve(@RequestBody HISOTReservationRestModel restData) {
		logger.info("Method : addOtReserve starts"/* +restData */);

		logger.info("Method : addOtReserve ends");
		return otDao.addOtReserve(restData);
	}
	
	@GetMapping(value = "rest-ot-reservation-view")
	public JsonResponse<List<HISOTReservationRestModel>> viewReservation() {
		logger.info("Method : viewReservation starts");

		logger.info("Method : viewReservation ends");
		return otDao.viewReservation();
	}
	
	@RequestMapping(value = "editReservation", method = { RequestMethod.GET })
	public JsonResponse<HISOTReservationRestModel> editReservation(@RequestParam String id, String orgName, String orgDivision,
			String uId) {
		logger.info("Method : editReservation rest starts");

		logger.info("Method :editReservation rest ends");
		return otDao.editReservation(id, orgName, orgDivision, uId);
	}
	
	@RequestMapping(value = "subGroupListData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> subGroupListData(@RequestParam String id) {
		logger.info("Method : subGroupListData starts");
		logger.info("Method : subGroupListData ends");
		return otDao.subGroupListData(id);
	}
	
	@RequestMapping(value = "getResEmployeeList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RolesAccessModel>>> getResEmployeeList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getResEmployeeList starts");
		
		logger.info("Method : getResEmployeeList ends");
		return otDao.getResEmployeeList(org,orgDiv);
	}
	
	@RequestMapping(value = "saveOtReserve", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveOtReserve(@RequestBody HISOTReservationRestModel id) {
		logger.info("Method : saveOtReserve starts");
		
		logger.info("Method : saveOtReserve ends");
		return otDao.saveOtReserve(id);
	}
	
	@RequestMapping(value = "getReserveList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HISOTReservationRestModel>>> getReserveList() {
		logger.info("Method : getReserveList starts");
		
		logger.info("Method : getReserveList ends");
		return otDao.getReserveList();
	}
	
	@RequestMapping(value = "editReserveList", method = { RequestMethod.GET }) 
	public ResponseEntity<JsonResponse<HISOTReservationRestModel>> editReserveList(@RequestParam String id) {
		logger.info("Method : editReserveList starts");
		
		logger.info("Method : editReserveList ends");
		return otDao.editReserveList(id);
	}
	
	@RequestMapping(value = "deleteReserved", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> deleteReserved(@RequestBody List<DropDownModel> roleList) {
		logger.info("Method : deleteReserved starts");
		
		logger.info("Method : deleteReserved ends");
		return otDao.deleteReserved(roleList);
	}
}
