package nirmalya.aatithya.restmodule.common.utils.productionplan;


import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.productionplan.model.RestManufactureProcessModel;

public class GenerateManufactureProcessParameter {

	public static String getAddProcessingPlan(List<RestManufactureProcessModel> addProcessingPlan) {
		String s = "";
		String sitem = "";
		String sitem1 = "";
		String[] item = addProcessingPlan.get(0).getSelectedItemId().split(",");
		
		
		

		if (addProcessingPlan.get(0).getProcessing_id() != null || addProcessingPlan.get(0).getProcessing_id() != "") {
			s = s + "@p_processingId='" + addProcessingPlan.get(0).getProcessing_id() + "',";
		}

		if (addProcessingPlan.get(0).getShift() != null || addProcessingPlan.get(0).getShift() != "") {
			s = s + "@p_shift='" + addProcessingPlan.get(0).getShift() + "',";
		}

		if (addProcessingPlan.get(0).getDate() != null || addProcessingPlan.get(0).getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(addProcessingPlan.get(0).getDate()) + "',";
		}

		if (addProcessingPlan.get(0).getRemark() != null || addProcessingPlan.get(0).getRemark() != "") {
			s = s + "@p_remark='" + addProcessingPlan.get(0).getRemark() + "',";
		}

		if (addProcessingPlan.get(0).getCreatedBy() != null || addProcessingPlan.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + addProcessingPlan.get(0).getCreatedBy() + "',";
		}

		if (addProcessingPlan.get(0).getOrganization() != null || addProcessingPlan.get(0).getOrganization() != "") {
			s = s + "@p_org='" + addProcessingPlan.get(0).getOrganization() + "',";
		}
		if (addProcessingPlan.get(0).getOrgDivision() != null || addProcessingPlan.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + addProcessingPlan.get(0).getOrgDivision() + "',";
		}
		
		if (addProcessingPlan.get(0).getPlanId() != null || addProcessingPlan.get(0).getPlanId() != "") {
			s = s + "@p_planId='" + addProcessingPlan.get(0).getPlanId() + "',";
		}

		for (RestManufactureProcessModel m : addProcessingPlan) {

			sitem = sitem + "(@p_processingId,\"" + m.getMixerNo() + "\",\"" + m.getMixerId() + "\",\"" + m.getBrandId() + "\",\""  + m.getBrandName() + "\",\""
					+ m.getBatchSize() + "\",\"" + m.getRpQtyadd() + "\",\"" + m.getTotalBatch() + "\",\""
					+ m.gettQtyIncRp() + "\",\""+ m.getpRemark() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() + "\"),";

		}
		
		
		
		  for (String id : item) {
		  
			 sitem1 = sitem1 + "(@p_processingId,\"" + id + "\",\"" + addProcessingPlan.get(0).getOrganization()
					 + "\",\"" + addProcessingPlan.get(0).getOrgDivision() + "\"),"; 
			 
			 
		  }
		 
		 
		
		
		
	
		System.out.println("M!!!!!>>>>>______====="+sitem);
		System.out.println("M!!!!!!!!!>>>>>______====="+sitem1);

		// s = s + "@p_serviceId='" + addProcessingPlan.get(0).getServiceId() +"',";
		sitem = sitem.substring(0, sitem.length() - 1);
		sitem1 = sitem1.substring(0, sitem1.length() - 1);
		
		
		s = s + "@p_itemSubQuery='" + sitem  + "',";
		s = s + "@p_itemSubQuery1='" + sitem1 + "',";
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
