package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.master.dao.MasterDataApiDao;

@RestController
@RequestMapping(value = "master/")
public class MasterDataApiRestController {

	Logger logger = LoggerFactory.getLogger(MasterDataApiRestController.class);
	
	public final MasterDataApiDao masterdao;
	
	@Autowired
	public MasterDataApiRestController(MasterDataApiDao master) {
		this.masterdao = master;
	}
	
	//getOwnerList
	
		@RequestMapping(value = "getOwnerList", method = { RequestMethod.GET })
		public List<DropDownModel> getOwnerList(@RequestParam String userId,String org,String orgDiv) {
			
			logger.info("Method : getOwnerList starts" + userId);
			logger.info("Method : getOwnerList ends");
			
			
			return masterdao.getOwnerList(userId,org,orgDiv);
		}
		
		@RequestMapping(value = "getOwnerListDash", method = { RequestMethod.GET })
		public List<DropDownModel> getOwnerListDash(@RequestParam String userId,String org,String orgDiv) {
			
			logger.info("Method : getOwnerListDash starts" + userId);
			logger.info("Method : getOwnerListDash ends");
			
			
			return masterdao.getOwnerListDash(userId,org,orgDiv);
		}
		
		
		@RequestMapping(value = "getCrmTaskStatus", method = { RequestMethod.GET })
		public List<DropDownModel> getCrmTaskStatus() {
			
			logger.info("Method : getCrmTaskStatus starts");
			logger.info("Method : getCrmTaskStatus ends");
			
			
			return masterdao.getCrmTaskStatus();
		}
		
}
