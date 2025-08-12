package nirmalya.aatithya.restmodule.lms.controller;

import java.util.Map;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.lms.dao.LmsBlogsRestDao;
	

		@RestController
		@RequestMapping(value = { "master" })
		public class LmsBlogRestController {

			Logger logger = LoggerFactory.getLogger(LmsBlogRestController.class);

			@Autowired
			LmsBlogsRestDao lmsBlogsRestDao;
			
			
			
			// View
			@RequestMapping(value = "rest-viewBlog", method = { RequestMethod.GET })
			public JsonResponse<Object> viewBlog(@RequestParam String orgName, String orgDivision) {
				logger.info("Method :viewBlog start");

				logger.info("Method :viewBlog endss");
				return lmsBlogsRestDao.viewBlog(orgName, orgDivision);
			}
			
		// add
			@PostMapping("rest-addBlog")
			public JsonResponse<Object> addBlog(@RequestBody Map<String, Object> blogJsonData) {
			    logger.info("Method : addBlog starts");

			    logger.info("Method : addBlog ends");
			    return lmsBlogsRestDao.addBlog(blogJsonData);
			}
		// EDIT
			@GetMapping("rest-editBlog")
			public JsonResponse<Object> editBlog( @RequestParam String orgName,
					@RequestParam String orgDiv,@RequestParam String blogId) {
				logger.info("Method :editBlog start");

				logger.info("Method :editBlog ends");
				return lmsBlogsRestDao.editBlog(orgName,orgDiv,blogId);
			}
		// DELETE
			@GetMapping("rest-deletBlog")
			public JsonResponse<Object> deletBlog(@RequestParam String blogId, @RequestParam String orgName,
					@RequestParam String orgDiv) {
				logger.info("Method :deletBlog start");

				logger.info("Method :deletBlog ends");
				return lmsBlogsRestDao.deletBlog(blogId, orgName, orgDiv);
			}
}
