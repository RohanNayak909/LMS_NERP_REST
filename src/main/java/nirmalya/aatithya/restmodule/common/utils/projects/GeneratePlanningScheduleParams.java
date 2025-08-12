package nirmalya.aatithya.restmodule.common.utils.projects;

import java.util.List;

import nirmalya.aatithya.restmodule.projects.model.ProjectPlanningSchedulingRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestPlanningSchedulesubModel;

public class GeneratePlanningScheduleParams {
	public static String getAddPlan(ProjectPlanningSchedulingRestModel plan) {
		String s = "";
		String sitem = "";

		if (plan.getPriority() != null || plan.getPriority() != "") {
			s = s + "@p_getProjectId='" + plan.getPriority() + "',";
		}
		if (plan.getProjectId() != null || plan.getProjectId() != "") {
			s = s + "@p_id='" + plan.getProjectId() + "',";
		}

		String itemparam = "";
		List<RestPlanningSchedulesubModel> items = plan.getCopylist();
		if (plan.getCopylist().size() > 0) {
			itemparam = itemparam +"(";
			for (RestPlanningSchedulesubModel m : items) {

				itemparam = itemparam  + m.getSlnoId() + ",";
			}
			
			itemparam = itemparam.substring(0, itemparam.length() - 1);
			itemparam = itemparam +")";
		} else {
			itemparam = "";
		}
		s = s + "@p_itemParam='" + itemparam + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
