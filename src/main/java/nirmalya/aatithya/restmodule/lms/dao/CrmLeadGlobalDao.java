package nirmalya.aatithya.restmodule.lms.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CrmLeadGlobalDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Calls:
     *   CALL sp_crm_lead_create_global(<json>, <swallowErrors>);
     *
     * Procedure should return a single row like:
     *   status | leadId | message
     */
    public Map<String, Object> createLeadGlobal(String payloadJson, boolean swallowErrors) {

        Map<String, Object> out = new LinkedHashMap<>();
        out.put("data", null);

        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(
                    "CALL sp_crm_lead_create_global(?, ?)",
                    payloadJson,
                    swallowErrors ? 1 : 0
            );

            if (rows == null || rows.isEmpty()) {
                out.put("status", "ERROR");
                out.put("leadId", null);
                out.put("message", "Procedure returned no data");
                return out;
            }

            Map<String, Object> r = rows.get(0);

            Object status = getIgnoreCase(r, "status");
            Object leadId = getIgnoreCase(r, "leadId");
            Object message = getIgnoreCase(r, "message");

            out.put("status", status != null ? status : "SUCCESS");
            out.put("leadId", leadId);
            out.put("message", message != null ? message : "OK");
            out.put("data", r); // full raw row for debugging/extra columns if any

            return out;

        } catch (Exception e) {
            out.put("status", "ERROR");
            out.put("leadId", null);
            out.put("message", e.getMessage());
            return out;
        }
    }

    private Object getIgnoreCase(Map<String, Object> map, String key) {
        if (map == null || key == null) return null;
        for (Map.Entry<String, Object> en : map.entrySet()) {
            if (en.getKey() != null && en.getKey().equalsIgnoreCase(key)) {
                return en.getValue();
            }
        }
        return null;
    }
}
