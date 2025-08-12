package nirmalya.aatithya.restmodule.common.utils;

import java.lang.reflect.Field;

public class DynamicQueryBuilder {

	public static String buildDynamicQuery(Object model) {
		
		StringBuilder query = new StringBuilder();
		query.append("SET ");
		try {
			Class<?> clazz = model.getClass();
			Field[] fields = clazz.getDeclaredFields();

			for (Field field : fields) {
				field.setAccessible(true);
				Object value = field.get(model);

				if (value != null && !value.toString().isEmpty()) {
					String paramName = convertToParameterName(field.getName());
					Class<?> fieldType = field.getType();
					if(fieldType.getName().equals("java.lang.String") || fieldType.getName().equals("java.util.List")) {
						query.append(paramName).append("='").append(value).append("',");
					} else {
						query.append(paramName).append("=").append(value).append(",");
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (query.length() > 0) {
			query.setLength(query.length() - 1);
			query.append(";");
		}

		return query.toString();
	}

	private static String convertToParameterName(String fieldName) {
		return "@p_" + Character.toLowerCase(fieldName.charAt(0)) + fieldName.substring(1);
	}
}
