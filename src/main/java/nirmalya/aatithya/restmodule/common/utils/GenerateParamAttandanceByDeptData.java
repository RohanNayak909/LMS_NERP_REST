package nirmalya.aatithya.restmodule.common.utils;

import java.util.Map;

public class GenerateParamAttandanceByDeptData {

	public static String getAttandanceByDeptParam(Map<String, String> data) {
		 StringBuilder paramBuilder = new StringBuilder();
		    
		    // Iterate through the map entries and construct the parameter string
		    for (Map.Entry<String, String> entry : data.entrySet()) {
		        String key = entry.getKey();
		        String value = entry.getValue();

		        // Append the key-value pair to the parameter string
		        paramBuilder.append("@p_").append(key).append("='").append(value).append("',");
		    }

		    // Remove the trailing comma if the string is not empty
		    if (paramBuilder.length() > 0) {
		        paramBuilder.deleteCharAt(paramBuilder.length() - 1);
		    }

		    // Construct the final parameter string
		    String parameterString = paramBuilder.toString();
		    if (!parameterString.isEmpty()) {
		        parameterString = "SET " + parameterString + ";";
		    }

		    return parameterString;
	}

}
