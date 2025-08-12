package nirmalya.aatithya.restmodule.common.utils.productionplan;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import java.util.List;

import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionParentModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionRawmaterialModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionTotalmanpowerList;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionVariantModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestProductionPlanningProductList;
import nirmalya.aatithya.restmodule.productionplan.model.RestProductionPlanningmachineManpowerList;
import nirmalya.aatithya.restmodule.productionplan.model.UploadedPlanRestModel;

public class GenerateParamPlanningProduction {
	public static String getManPowerList(RestPlanningProductionModel planningmodel) {
		String[] userIds = planningmodel.getMachineid().split(",");
		System.out.println("purchase====" + planningmodel);

		String s = "";
		String litem = "";

		for (String a : userIds) {
			System.out.println("userIds====" + userIds);
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_userId='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ",";
			s = s + "@p_brand= '" + planningmodel.getOther() + "';";
		}

		System.out.println("EE" + s);

		return s;
	}

	public static String getMachineList(RestPlanningProductionModel planningmodel) {
		String[] userIds = planningmodel.getMachineid().split(",");
		System.out.println("purchase====" + planningmodel);

		String s = "";
		String litem = "";

		for (String a : userIds) {
			System.out.println("userIds====" + userIds);
			litem = litem + a;
		}
		s = s + "@p_userId='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("EE" + s);

		return s;
	}

	public static String getRawMaterialList(RestPlanningProductionModel planningmodel) {
		String[] userIds = planningmodel.getMachineid().split(",");
		String[] quantity = planningmodel.getQuantity().split(",");
		System.out.println("Raw-Material" + planningmodel);
		String s = "";
		String idqty = "";
		for (int i = 0; i < userIds.length; i++) {
			idqty = idqty + "(\"" + userIds[i] + "\",\"" + quantity[i] + "\"),";

		}

		System.out.println("Raw-Material" + idqty);

		idqty = idqty.substring(0, idqty.length() - 1);

		s = s + "SET @p_values='" + idqty + "',";
		s = s + "@p_week= '" + planningmodel.getWeek() + "';";
		
		System.out.println("EE" + s);

		return s;
	}

	public static String getAddPlanningParam(RestPlanningProductionParentModel planningmodel) {

		String s = "";

		s = s + "@p_planid='" + planningmodel.getPlanningid() + "',";

		if (planningmodel.getPlant() != null && planningmodel.getPlant() != "") {
			s = s + "@p_plant='" + planningmodel.getPlant() + "',";
		}

		if (planningmodel.getPlantweek() != null && planningmodel.getPlantweek() != "") {
			s = s + "@p_planweek='" + planningmodel.getPlantweek() + "',";
		}
		if (planningmodel.getPlanning() != null && planningmodel.getPlanning() != "") {
			s = s + "@p_planning='" + planningmodel.getPlanning() + "',";
		}
		if (planningmodel.getFromdate() != null && planningmodel.getFromdate() != " ") {
			s = s + "@p_fromdate='" + DateFormatter.getStringDate(planningmodel.getFromdate()) + "',";
		}
		if (planningmodel.getTodate() != null && planningmodel.getTodate() != "") {
			s = s + "@p_todate='" + DateFormatter.getStringDate(planningmodel.getTodate()) + "',";
		}
		if (planningmodel.getBrand() != null && planningmodel.getBrand() != " ") {
			s = s + "@p_brand='" + planningmodel.getBrand() + "',";
		}

		if (planningmodel.getStatus() != null && planningmodel.getStatus() != " ") {
			s = s + "@p_status='" + planningmodel.getStatus() + "',";
		}
		if (planningmodel.getTotalqty() != null && planningmodel.getTotalqty() != "") {
			s = s + "@p_tqty='" + planningmodel.getTotalqty() + "',";
		}
		if (planningmodel.getOrg() != null && planningmodel.getOrg() != "") {
			s = s + "@p_org='" + planningmodel.getOrg() + "',";
		}
		if (planningmodel.getOrgDiv() != null && planningmodel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + planningmodel.getOrgDiv() + "',";
		}

		String itemparam = "";
		List<RestPlanningProductionRawmaterialModel> items = planningmodel.getRawmaterialist();
		if (planningmodel.getRawmaterialist().size() > 0) {
			for (RestPlanningProductionRawmaterialModel m : items) {

				itemparam = itemparam + "(@p_planid,\"" + m.getProductname() + "\",\"" + m.getProdqty() + "\",\""
						+ m.getUnit() + "\",@p_org,@p_orgDiv),";
			}

			itemparam = itemparam.substring(0, itemparam.length() - 1);
		} else {
			itemparam = "";
		}
		s = s + "@p_rawmaterialParam='" + itemparam + "',";

		String itemparam1 = "";
		List<RestPlanningProductionVariantModel> items1 = planningmodel.getVariant();
		if (planningmodel.getVariant().size() > 0) {
			for (RestPlanningProductionVariantModel m : items1) {

				itemparam1 = itemparam1 + "(@p_planid,\"" + m.getItemname() + "\",\"" + m.getQty() + "\",@p_org,@p_orgDiv),";
			}

			itemparam1 = itemparam1.substring(0, itemparam1.length() - 1);
		} else {
			itemparam1 = "";
		}
		s = s + "@p_variantParam='" + itemparam1 + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String getDeleteInvoice(RestPlanningProductionParentModel planning) {
		String[] userIds = planning.getPlanningid().split(",");
		System.out.println("purchase====" + planning);

		String s = "";
		String litem = "";

		for (String a : userIds) {
			System.out.println("userIds====" + userIds);
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_userId='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("EE" + s);

		return s;
	}

	public static String setScheduleParam(RestPlanningProductionParentModel schedulemodel) {

		String s = "";

		s = s + "@p_planid='" + schedulemodel.getPlanningid() + "',";
		s = s + "@p_org='" + schedulemodel.getOrg() + "',";
		s = s + "@p_orgDiv='" + schedulemodel.getOrgDiv() + "',";

		String itemparam = "";
		List<RestProductionPlanningProductList> items = schedulemodel.getProductList();
		if (schedulemodel.getProductList().size() > 0) {
			for (RestProductionPlanningProductList m : items) {

				itemparam = itemparam + "(@p_planid,\"" + DateFormatter.getStringDate(m.getDate()) + "\",\""
						+ m.getShift() + "\",\"" + m.getProductid() + "\",\""
						+ m.getProductname() + "\",\"" + m.getQtyval() 
						+ "\",\"" + m.getMachineid() + "\",\"" + m.getMachineHour() + "\",@p_org,@p_orgDiv),";
			}

			itemparam = itemparam.substring(0, itemparam.length() - 1);
		} else {
			itemparam = "";
		}
		s = s + "@p_productParam='" + itemparam + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
//		String itemparam1 = "";
//		List<RestProductionPlanningmachineManpowerList> items1 = schedulemodel.getMachineManpowerList();
//		if (schedulemodel.getMachineManpowerList().size() > 0) {
//			for (RestProductionPlanningmachineManpowerList m : items1) {
//
//				itemparam1 = itemparam1 + "(@p_planid,\"" + DateFormatter.getStringDate(m.getDate()) + "\",\""
//						+ m.getShift() + "\",\"" + m.getMacid() + "\",\"" + m.getMachineid() + "\",@p_org,@p_orgDiv),";
//			}
//
//			itemparam1 = itemparam1.substring(0, itemparam1.length() - 1);
//		} else {
//			itemparam1 = "";
//		}
//		s = s + "@p_macmanpowerParam='" + itemparam1 + "',";
//
//		String itemparam2 = "";
//		List<RestPlanningProductionTotalmanpowerList> items2 = schedulemodel.getTotalmanpowerList();
//		if (schedulemodel.getTotalmanpowerList().size() > 0) {
//			for (RestPlanningProductionTotalmanpowerList m : items2) {
//
//				itemparam2 = itemparam2 + "(@p_planid,\"" + DateFormatter.getStringDate(m.getDate()) + "\",\""
//						+ m.getShift() + "\",\"" + m.getOpr() + "\",\"" + m.getTcn() + "\",\"" + m.getHpr() + "\",\""
//						+ m.getMtn() + "\",\"" + m.getOth() + "\",\"" + m.getTpowerid() + "\",@p_org,@p_orgDiv),";
//			}
//
//			itemparam2 = itemparam2.substring(0, itemparam2.length() - 1);
//		} else {
//			itemparam2 = "";
//		}
//		s = s + "@p_totalmanpowerParam='" + itemparam2 + "',";
	}

	public static String dailyRosterData(List<RestProductionPlanningProductList> data) {
		String s = "";
		String bitem = "";

		for (RestProductionPlanningProductList m : data) {
			bitem = bitem + "(\"" + m.getQtyid() + "\",\"" + m.getQtyval() + "\"),";
		}

		bitem = bitem.substring(0, bitem.length() - 1);
		s = s + "@p_subQuery='" + bitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
}
