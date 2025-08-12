
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestRequestFeedBackModel;

public class GenerateFeedBackParam {

	
	public static String saveFeedBackRequest(RestRequestFeedBackModel id) {
		String s = "";
		String data = "";
		
		if(id.getAddId()!=null && id.getAddId()!="") {
			s = s + "@p_addId='" + id.getAddId() + "',";
		}
		if(id.getEmployeeId()!=null && id.getEmployeeId()!="") {
			s = s + "@p_empolyeeId='" + id.getEmployeeId() + "',";
		}
		if(id.getMessages()!=null && id.getMessages()!="") {
			s = s + "@p_messages='" + id.getMessages() + "',";
		}
		if(id.getCreatedBy() != null || id.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + id.getCreatedBy() + "',";
		}
	
		
		
 		if(id.getEmpList().size() > 0) {
			for(String m : id.getEmpList()) {
				data = data + "(@p_empolyeeId,@p_createdBy,@p_messages,\"" + m + "\"),";
			}
			
			data = data.substring(0, data.length() - 1);
		}
		
		
		
		s = s + "@p_employeeList='" + data + "';";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		System.out.println(s);
		
		return s;
	}
}

/*
 * package nirmalya.aatithya.restmodule.common.utils;
 * 
 * import nirmalya.aatithya.restmodule.master.model.RestRequestFeedBackModel;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import nirmalya.aatithya.restmodule.master.model.RestGoalMastersModel;
 * 
 * public class GenerateFeedBackParam {
 * 
 * public static String saveFeedBackRequest(List<RestRequestFeedBackModel>
 * restRequestFeedBackModel) {
 * 
 * System.out.println("restRequestFeedBackModel"+restRequestFeedBackModel);
 * 
 * 
 * String s = ""; String listdata =""; String addId=""; String employeeId="";
 * String createdBy=""; List<String> empList = new ArrayList<String>();
 * List<String> empNameList = new ArrayList<String>();
 * 
 * String messages=""; String empName="";
 * 
 * 
 * 
 * for (RestRequestFeedBackModel m : restRequestFeedBackModel) {
 * addId=m.getAddId(); employeeId=m.getEmployeeId(); createdBy=m.getCreatedBy();
 * empList=m.getEmpList();
 * 
 * messages=m.getMessages();
 * 
 * 
 * }
 * 
 * 
 * for(RestRequestFeedBackModel m: restRequestFeedBackModel) { listdata =
 * listdata+"(\""+m.getEmployeeId() + "\",\""+m.getEmpList() +
 * "\",\""+m.getCreatedBy() + "\",\""+m.getMessages() + "\"),"; } listdata =
 * listdata.substring(0, listdata.length() - 1);
 * 
 * s = "SET " + s +"@p_SQL='"+listdata+"';";
 * System.out.println("Generation Parama: "+s); return s;
 * 
 * } }
 */