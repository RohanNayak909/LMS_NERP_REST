package nirmalya.aatithya.restmodule.lms.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.lms.dao.CrmLeadGlobalDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("master")
public class RestCrmLeadGlobalController {

    @Autowired
    private CrmLeadGlobalDao crmLeadGlobalDao;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Global endpoint to create a Lead from ANY module.
     * Body is raw JSON payload. No model needed.
     *
     * Example:
     * POST /master/crm/lead/global?swallowErrors=0
     * { ... any payload keys used by sp_crm_lead_create_global ... }
     */
    @PostMapping("crm/lead/global")
    public ResponseEntity<Map<String, Object>> createLeadGlobal(
            @RequestBody(required = false) Object payload,
            @RequestParam(name = "swallowErrors", defaultValue = "0") int swallowErrors
    ) {
        Map<String, Object> resp = new LinkedHashMap<>();
        try {
            String json = (payload == null) ? "{}" : objectMapper.writeValueAsString(payload);

            Map<String, Object> dbResp = crmLeadGlobalDao.createLeadGlobal(json, swallowErrors == 1);

            // Always return a predictable structure
            resp.put("status", dbResp.getOrDefault("status", "ERROR"));
            resp.put("leadId", dbResp.getOrDefault("leadId", null));
            resp.put("message", dbResp.getOrDefault("message", "No response from procedure"));
            resp.put("data", dbResp.getOrDefault("data", null));

            // HTTP code: SUCCESS/UPDATED -> 200, ERROR -> 500 (you can change)
            String st = String.valueOf(resp.get("status"));
            if ("SUCCESS".equalsIgnoreCase(st) || "UPDATED".equalsIgnoreCase(st) || "DUPLICATE".equalsIgnoreCase(st)) {
                return new ResponseEntity<>(resp, HttpStatus.OK);
            }
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (DataAccessException dae) {
            resp.put("status", "ERROR");
            resp.put("message", dae.getMostSpecificCause() != null ? dae.getMostSpecificCause().getMessage() : dae.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            resp.put("status", "ERROR");
            resp.put("message", e.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
