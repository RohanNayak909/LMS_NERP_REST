package nirmalya.aatithya.restmodule.common.utils.qa;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.qa.model.RestMicrobiologyLabratoryModel;

public class GenerateMicrobiologyLab {
	
	public static String getSaveData(List<RestMicrobiologyLabratoryModel> qp) {
		String s = "";
		String sitem = "";
		
		if (qp.get(0).getLabId() != null || qp.get(0).getLabId() != "") {
			s = s + "@p_labId='" + qp.get(0).getLabId() + "',";
		}
		
		if (qp.get(0).getRecordNumber() != null || qp.get(0).getRecordNumber() != "") {
			s = s + "@p_recordNumber='" + qp.get(0).getRecordNumber() + "',";
		}
		
		if (qp.get(0).getDateOfAnalysis() != null || qp.get(0).getDateOfAnalysis() != "") {
			s = s + "@p_doa='" + qp.get(0).getDateOfAnalysis() + "',";
		}
		
		if (qp.get(0).getVersion() != null || qp.get(0).getVersion() != "") {
			s = s + "@p_version='" + qp.get(0).getVersion() + "',";
		}
		
		if (qp.get(0).getDay() != null || qp.get(0).getDay() != "") {
			s = s + "@p_day='" + qp.get(0).getDay() + "',";
		}
	
		
		if (qp.get(0).getCreatedBy() != null || qp.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qp.get(0).getCreatedBy() + "',";
		}
		
		if (qp.get(0).getOrganization() != null || qp.get(0).getOrganization() != "") {
			s = s + "@p_organization='" + qp.get(0).getOrganization() + "',";
		}
		
		if (qp.get(0).getOrgDivision() != null || qp.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + qp.get(0).getOrgDivision() + "',";
		}
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String createdOn = sdf.format(date);
		
		for (RestMicrobiologyLabratoryModel m : qp) {

			sitem = sitem + "(@p_labId,\""+ m.getRowno() + "\",\""  + m.getDay() + "\",\""  + DateFormatter.getStringDate(m.getDayDate())  + "\",\""  + m.getSlno() + "\",\""  + m.getV1() + "\",\"" + m.getV2() +"\",\"" + m.getV3() +"\",\"" + m.getV4() +"\",\"" + m.getV5() +"\",\"" + m.getV6() +"\",\"" + m.getV7() +"\",\"" 
			+ m.getV8() + "\",\"" + m.getV9()+ "\",\"" +m.getV10() +  "\",\"" +m.getV11() +  "\",\"" +m.getV12() +  "\",\"" +m.getV13() +  "\",\"" + m.getCreatedBy() + "\",\"" +
					m.getOrganization() + "\",\"" + m.getOrgDivision() + "\",\"" + createdOn + "\",\"" + m.getParameter() + "\",\"" + m.getStep() + "\"),";
		}
		
		sitem = sitem.substring(0, sitem.length() - 1);
		
		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		
		
		return s;
		
	}

}
