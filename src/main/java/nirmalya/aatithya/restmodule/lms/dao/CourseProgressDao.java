package nirmalya.aatithya.restmodule.lms.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class CourseProgressDao {

	Logger logger = LoggerFactory.getLogger(CourseProgressDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	private static final ObjectMapper MAPPER = new ObjectMapper();

	/* =========================================
	   SAVE / UPSERT PROGRESS (cross-device)
	========================================= */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveProgress(String payload, String userId, String org, String orgDiv) {
		logger.info("method: saveProgress Starts payload(size)={}", payload != null ? payload.length() : 0);

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			JsonNode n = MAPPER.readTree(payload);

			String courseId = text(n, "courseId");
			String contentKey = pickFirstNonEmpty(text(n, "contentKey"), text(n, "scormKey"), text(n, "fileName"));
			String fileName = text(n, "fileName");
			String fileType = text(n, "fileType"); // video/pdf/ppt/audio/scorm

			if (isBlank(courseId) || isBlank(contentKey) || isBlank(fileType)) {
				resp.setCode("Failed");
				resp.setMessage("Missing required fields: courseId, contentKey (or scormKey/fileName), fileType");
				return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			}

			String status = pickFirstNonEmpty(text(n, "status"), "incomplete");
			String location = text(n, "location");
			String sessionUid = text(n, "sessionUid");
			String deviceId = text(n, "deviceId");
			String eventType = pickFirstNonEmpty(text(n, "eventType"), "PROGRESS");
			String eventTs = text(n, "eventTs");

			// numeric / percent handling (supports 20, "20", "20%")
			String progressPercent = normalizePercent(n.get("progressPercent"));
			String currentSeconds = normalizeInt(n.get("currentSeconds"));
			String totalSeconds = normalizeInt(n.get("totalSeconds"));
			String runtimeVer = normalizeInt(n.get("runtimeVer"));

			String scoreRaw = text(n, "scoreRaw");
			String scoreScaled = text(n, "scoreScaled");

			// runtimeState can be huge JSON string -> store as-is
			String runtimeState = n.has("runtimeState") && !n.get("runtimeState").isNull()
					? n.get("runtimeState").asText()
					: null;

			String actionValue = buildSet(new LinkedHashMap<String, Object>() {{
				put("@p_userId", userId);
				put("@p_org", org);
				put("@p_orgDiv", orgDiv);

				put("@p_courseId", courseId);
				put("@p_contentKey", contentKey);
				put("@p_fileName", fileName);
				put("@p_fileType", fileType);

				put("@p_status", status);
				put("@p_progressPercent", progressPercent); // numeric string ok
				put("@p_currentSeconds", currentSeconds);
				put("@p_totalSeconds", totalSeconds);
				put("@p_location", location);

				put("@p_scoreRaw", scoreRaw);
				put("@p_scoreScaled", scoreScaled);

				put("@p_runtimeState", runtimeState);
				put("@p_runtimeVer", runtimeVer);

				put("@p_eventType", eventType);
				put("@p_eventTs", eventTs);

				put("@p_sessionUid", sessionUid);
				put("@p_deviceId", deviceId);
			}});
logger.info("sssssssssss"+actionValue);
			List<Map<String, Object>> rows = callForMap("upsertProgress", actionValue);

			resp.setCode("Success");
			resp.setMessage("Progress saved");
			if (rows != null && !rows.isEmpty()) {
				resp.setBody(rows.get(0)); // status/message/applied/userId/courseId/contentKey
			}

		} catch (Exception e) {
			logger.error("Error in saveProgress: ", e);
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception ex) {
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
		logger.info("method: saveProgress Ends");
		return response;
	}

	/* =========================================
	   GET PROGRESS MAP (all contents for course)
	========================================= */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getCourseProgressMap(String userId, String courseId) {
		logger.info("method: getCourseProgressMap Starts userId={}, courseId={}", userId, courseId);

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			if (isBlank(userId) || isBlank(courseId)) {
				resp.setCode("Failed");
				resp.setMessage("Missing required params: userId, courseId");
				return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			}

			String actionValue = buildSet(new LinkedHashMap<String, Object>() {{
				put("@p_userId", userId);
				put("@p_courseId", courseId);
			}});

			List<Map<String, Object>> rows = callForMap("getCourseProgressMap", actionValue);

			resp.setCode("Success");
			resp.setMessage("Data fetched");
			resp.setBody(rows);

		} catch (Exception e) {
			logger.error("Error in getCourseProgressMap: ", e);
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception ex) {
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.OK);
		logger.info("method: getCourseProgressMap Ends");
		return response;
	}

	/* =========================================
	   GET SINGLE RESUME
	========================================= */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getContentResume(String userId, String courseId, String contentKey) {
		logger.info("method: getContentResume Starts userId={}, courseId={}, contentKey={}", userId, courseId, contentKey);

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			if (isBlank(userId) || isBlank(courseId) || isBlank(contentKey)) {
				resp.setCode("Failed");
				resp.setMessage("Missing required params: userId, courseId, contentKey");
				return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			}

			String actionValue = buildSet(new LinkedHashMap<String, Object>() {{
				put("@p_userId", userId);
				put("@p_courseId", courseId);
				put("@p_contentKey", contentKey);
			}});

			List<Map<String, Object>> rows = callForMap("getContentResume", actionValue);

			resp.setCode("Success");
			resp.setMessage("Data fetched");
			resp.setBody((rows != null && !rows.isEmpty()) ? rows.get(0) : new LinkedHashMap<>());

		} catch (Exception e) {
			logger.error("Error in getContentResume: ", e);
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception ex) {
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.OK);
		logger.info("method: getContentResume Ends");
		return response;
	}

	/* =========================================
	   RESET PROGRESS
	========================================= */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> resetContentProgress(String payload, String userId, String org, String orgDiv) {
		logger.info("method: resetContentProgress Starts");

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			JsonNode n = MAPPER.readTree(payload);

			String courseId = text(n, "courseId");
			String contentKey = pickFirstNonEmpty(text(n, "contentKey"), text(n, "scormKey"), text(n, "fileName"));
			String fileType = pickFirstNonEmpty(text(n, "fileType"), "scorm");
			String sessionUid = text(n, "sessionUid");
			String deviceId = text(n, "deviceId");

			if (isBlank(courseId) || isBlank(contentKey)) {
				resp.setCode("Failed");
				resp.setMessage("Missing required fields: courseId, contentKey");
				return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			}

			String actionValue = buildSet(new LinkedHashMap<String, Object>() {{
				put("@p_userId", userId);
				put("@p_org", org);
				put("@p_orgDiv", orgDiv);
				put("@p_courseId", courseId);
				put("@p_contentKey", contentKey);
				put("@p_fileType", fileType);
				put("@p_sessionUid", sessionUid);
				put("@p_deviceId", deviceId);
			}});

			List<Map<String, Object>> rows = callForMap("resetContentProgress", actionValue);

			resp.setCode("Success");
			resp.setMessage("Progress reset");
			if (rows != null && !rows.isEmpty()) resp.setBody(rows.get(0));

		} catch (Exception e) {
			logger.error("Error in resetContentProgress: ", e);
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception ex) {
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
		logger.info("method: resetContentProgress Ends");
		return response;
	}

	/* =========================================================
	   Internal: Stored procedure call returning List<Map<String,Object>>
	   (no models; uses known select aliases from SP)
	========================================================= */
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> callForMap(String actionType, String actionValue) {

		StoredProcedureQuery q = em.createStoredProcedureQuery("lms_course_progress_routines");
		q.registerStoredProcedureParameter("actionType", String.class, ParameterMode.IN);
		q.registerStoredProcedureParameter("actionValue", String.class, ParameterMode.IN);
		q.setParameter("actionType", actionType);
		q.setParameter("actionValue", actionValue);

		q.execute();
		List<Object[]> rs = q.getResultList();

		// If SP returns status/message row (upsert/reset), it will be 1-row with columns:
		// status, message, applied, userId, courseId, contentKey (or subset)
		// If SP returns map/resume, it returns the SELECT aliases exactly.
		List<Map<String, Object>> out = new ArrayList<>();

		// Heuristic:
		// - If column count is small (<=6) -> treat as status response
		// - else treat as progress row
		for (Object rowObj : rs) {
			Object[] row = (Object[]) rowObj;

			Map<String, Object> m = new LinkedHashMap<>();

			if (row.length <= 6) {
				// status response order as in SP SELECT
				m.put("status", val(row, 0));
				m.put("message", val(row, 1));
				if (row.length > 2) m.put("applied", val(row, 2));
				if (row.length > 3) m.put("userId", val(row, 3));
				if (row.length > 4) m.put("courseId", val(row, 4));
				if (row.length > 5) m.put("contentKey", val(row, 5));
			} else {
				// progress SELECT order in SP (getCourseProgressMap/getContentResume)
				int i = 0;
				m.put("userId", val(row, i++));
				m.put("courseId", val(row, i++));
				m.put("contentKey", val(row, i++));
				m.put("fileName", val(row, i++));
				m.put("fileType", val(row, i++));
				m.put("status", val(row, i++));
				m.put("progressPercent", val(row, i++));
				m.put("currentSeconds", val(row, i++));
				m.put("totalSeconds", val(row, i++));
				m.put("location", val(row, i++));
				m.put("scoreRaw", val(row, i++));
				m.put("scoreScaled", val(row, i++));
				m.put("runtimeState", val(row, i++));
				m.put("runtimeVer", val(row, i++));
				m.put("lastEventTs", val(row, i++));
				m.put("sessionUid", val(row, i++));
				m.put("deviceId", val(row, i++));
				m.put("updatedAt", val(row, i++));
			}

			out.add(m);
		}

		return out;
	}

	private Object val(Object[] row, int idx) {
		return idx < row.length ? row[idx] : null;
	}

	/* =========================================================
	   Helpers
	========================================================= */

	private static String text(JsonNode n, String key) {
		if (n == null || key == null) return null;
		JsonNode v = n.get(key);
		if (v == null || v.isNull()) return null;
		return v.asText();
	}

	private static boolean isBlank(String s) {
		return s == null || s.trim().isEmpty();
	}

	private static String pickFirstNonEmpty(String... v) {
		if (v == null) return null;
		for (String s : v) {
			if (!isBlank(s)) return s;
		}
		return null;
	}

	private static String normalizeInt(JsonNode v) {
		if (v == null || v.isNull()) return null;
		try {
			if (v.isNumber()) return String.valueOf(v.asInt());
			String s = v.asText();
			if (s == null) return null;
			s = s.trim();
			if (s.isEmpty()) return null;
			s = s.replaceAll("[^0-9]", "");
			return s.isEmpty() ? null : s;
		} catch (Exception ex) {
			return null;
		}
	}

	private static String normalizePercent(JsonNode v) {
		if (v == null || v.isNull()) return null;
		try {
			if (v.isNumber()) return String.valueOf(v.asDouble());
			String s = v.asText();
			if (s == null) return null;
			s = s.trim();
			if (s.endsWith("%")) s = s.substring(0, s.length() - 1).trim();
			// keep digits + dot
			s = s.replaceAll("[^0-9.]", "");
			return s.isEmpty() ? null : s;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Builds actionValue:
	 *   SET @p_userId='..', @p_courseId='..', @p_currentSeconds=120, ...
	 *
	 * Escapes: backslash and single-quote for MySQL string literal.
	 */
	private static String buildSet(LinkedHashMap<String, Object> vars) {
		StringBuilder sb = new StringBuilder("SET ");
		boolean first = true;

		for (Map.Entry<String, Object> e : vars.entrySet()) {
			if (!first) sb.append(", ");
			first = false;

			sb.append(e.getKey()).append("=").append(toSqlLiteral(e.getValue()));
		}
		sb.append(";");
		return sb.toString();
	}

	private static String toSqlLiteral(Object v) {
		if (v == null) return "NULL";

		// If value is already numeric string and looks like a number -> keep unquoted
		if (v instanceof Number) return String.valueOf(v);

		String s = String.valueOf(v);
		if (s == null) return "NULL";
		s = s.trim();
		if (s.isEmpty()) return "NULL";

		// numeric string (e.g. "120" or "20.5") - allow as number for numeric params
		if (s.matches("^[0-9]+(\\.[0-9]+)?$")) return s;

		// Escape for MySQL string literal
		s = s.replace("\\", "\\\\"); // keep JSON escapes stable
		s = s.replace("'", "''");
		return "'" + s + "'";
	}
}
