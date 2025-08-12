package nirmalya.aatithya.restmodule.common.utils.productionplan;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.productionplan.model.AreaLineClearanceRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.FemtoBlendingRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.LmrLogRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PartBIngredientRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestManageShopFloorModel;
import nirmalya.aatithya.restmodule.productionplan.model.WeighingScaleRestModel;


public class GenerateLmrLogParams {
	
	public static String getLmrLogParam(LmrLogRestModel offDay) {
		String s = "";
		System.out.println(offDay);
		if (offDay.getPackId() != null && offDay.getPackId() != "") {
			s = s + "@p_packId='" + offDay.getPackId() + "',";
		}else {
			s = s + "@p_packId='',";
		}
		if (offDay.getShift() != null && offDay.getShift() != "") {
			s = s + "@p_shift='" + offDay.getShift() + "',";
		}
		if (offDay.getDate() != null && offDay.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(offDay.getDate()) + "',";
		}
		if (offDay.getProductId() != null && offDay.getProductId() != "") {
			s = s + "@p_product='" + offDay.getProductId() + "',";
		}
		if (offDay.getRemark() != null && offDay.getRemark() != "") {
			s = s + "@p_remark='" + offDay.getRemark() + "',";
		}
		if (offDay.getLineNo() != null && offDay.getLineNo() != "") {
			s = s + "@p_lineNo='" + offDay.getLineNo() + "',";
		}
		if (offDay.getBatchNo() != null && offDay.getBatchNo() != "") {
			s = s + "@p_batchNo='" + offDay.getBatchNo() + "',";
		}
		if (offDay.getCreatedBy() != null && offDay.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + offDay.getCreatedBy() + "',";
		}
		if (offDay.getOrganization() != null && offDay.getOrganization() != "") {
			s = s + "@p_org='" + offDay.getOrganization() + "',";
		}
		if (offDay.getOrgDivision() != null && offDay.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + offDay.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	
	
	public static String getPartBIngredientParam(LmrLogRestModel offDay) {
		String s = "";
		String listdata = "";
		System.out.println(offDay);
		
		if (offDay.getPackId() != null && offDay.getPackId() != "") {
			s = s + "@p_Id='" + offDay.getPackId() + "',";
		}

		if (offDay.getPartBIngrediant() != null && !offDay.getPartBIngrediant().isEmpty()) {
			for (PartBIngredientRestModel m : offDay.getPartBIngrediant()) {
				listdata = listdata + "(\"" + offDay.getPackId() + "\",\"" + m.getSbdSts() + "\",\""+ m.getNoBags() + "\",\""+ m.getQtySugar() + "\",\""+ m.getSlno()
				+ "\",\""+ m.getBatchNoNDVP() + "\",\""+ m.getPackNoNDVP() + "\",\""+ m.getNetWtNDVP() + "\",\""+ m.getBbNoNDVP() + "\",\""+ m.getBatchNoAALP() + "\",\""+ m.getPackNoAALP()
				+ "\",\""+ m.getNetWtAALP() + "\",\""+ m.getBbNoAALP() + "\",\""+ m.getOprtSign() + "\",\"" + offDay.getCreatedBy()
				+ "\",\"" + offDay.getOrganization() + "\",\"" + offDay.getOrgDivision() + "\"),";

			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_itemSubQuery='" + listdata + "',";
		} else {
			s = s + "@p_itemSubQuery='',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details>>>>>>>>>>>>>>>>>" + s);
		return s;
	}
	
	
	public static String getFemtoBlendingParam(LmrLogRestModel offDay) {
		String s = "";
		String listdata = "";
		System.out.println(offDay);
		
		if (offDay.getPackId() != null && offDay.getPackId() != "") {
			s = s + "@p_Id='" + offDay.getPackId() + "',";
		}

		if (offDay.getFemtoBlending() != null && !offDay.getFemtoBlending().isEmpty()) {
			for (FemtoBlendingRestModel m : offDay.getFemtoBlending()) {
				listdata = listdata + "(\"" + offDay.getPackId() + "\",\"" + m.getCldFrom() + "\",\"" + m.getCldTo()  + "\",\"" + m.getSlno() + "\",\"" + m.getType() + "\",\"" + m.getRmName() 
				+ "\",\"" + m.getQuantity() + "\",\"" + m.getTolerance() + "\",\"" + m.getLot1() + "\",\"" + m.getLot2() + "\",\"" + m.getLot3() + "\",\"" + m.getLot4()
				+ "\",\"" + m.getLot5() + "\",\"" + m.getLot6() + "\",\"" + m.getLot7()
				+ "\",\"" + offDay.getCreatedBy()
				+ "\",\"" + offDay.getOrganization() + "\",\"" + offDay.getOrgDivision() + "\"),";

			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_itemSubQuery='" + listdata + "',";
		} else {
			s = s + "@p_itemSubQuery='',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details>>>>>>>>>>>>>>>>>" + s);
		return s;
	}
	
	
	public static String getWeaghingScaleParam(LmrLogRestModel offDay) {
		String s = "";
		String listdata = "";
		System.out.println(offDay);
		
		if (offDay.getPackId() != null && offDay.getPackId() != "") {
			s = s + "@p_Id='" + offDay.getPackId() + "',";
		}

		if (offDay.getWeighingScale() != null && !offDay.getWeighingScale().isEmpty()) {
			for (WeighingScaleRestModel m : offDay.getWeighingScale()) {
				listdata = listdata + "(\"" + m.getPackId() +  "\",\"" + m.getSlno() + "\",\"" + m.getTime() 
				+ "\",\"" + m.getwScale() + "\",\"" + m.getEqipRange() + "\",\"" + m.getLc() + "\",\"" + m.getStdWt() + "\",\"" + m.getActWt()
				+ "\",\"" + m.getAcptLimit() + "\",\"" + m.getStatus() + "\",\"" + m.getSign()
				+ "\",\"" + offDay.getCreatedBy()
				+ "\",\"" + offDay.getOrganization() + "\",\"" + offDay.getOrgDivision() + "\"),";

			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_itemSubQuery='" + listdata + "',";
		} else {
			s = s + "@p_itemSubQuery='',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details>>>>>>>>>>>>>>>>>" + s);
		return s;
	}
	
	public static String getAreaLineClearanceParam(LmrLogRestModel offDay) {
		String s = "";
		String listdata = "";
		String listdata1 = "";
		System.out.println(offDay);
		
		if (offDay.getPackId() != null && offDay.getPackId() != "") {
			s = s + "@p_Id='" + offDay.getPackId() + "',";
		}
		//String[] parts = null;
		String param = "";
		if (offDay.getAreaLineClearance() != null && !offDay.getAreaLineClearance().isEmpty()) {
			for (AreaLineClearanceRestModel m : offDay.getAreaLineClearance()) {
				
				if(m.getSlno().equals("2")) {
					param = m.getParameter().split("\\?")[0] + "?" + "    Change Over- " + m.getChangeOver() + ",         From- " + m.getCoFrom() + ",         To- " + m.getCoTo(); 
				}else if(m.getSlno().equals("26")) {
					param = m.getParameter().split("-")[0] + "- " + m.getMixingTime();
				}else {
					param = m.getParameter();
				}
				
				
				listdata = listdata + "(\"" + offDay.getPackId() + "\",\"" + m.getTime() + "\",\"" + m.getChangeOver() + "\",\"" + m.getCoFrom() + "\",\"" + m.getCoTo() + "\",\"" + m.getMixingTime() 
				+  "\",\"" + m.getSlno() + "\",\"" + m.getArea() 
				+ "\",\"" + param + "\",\"" + m.getAcceptance1() + "\",\"" + m.getAcceptance2() + "\",\"" + m.getAcceptance3() 
				+ "\",\"" + offDay.getCreatedBy()
				+ "\",\"" + offDay.getOrganization() + "\",\"" + offDay.getOrgDivision() + "\"),";

			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_itemSubQuery='" + listdata + "',";
		} else {
			s = s + "@p_itemSubQuery='',";
		}
		
		if (offDay.getAreaLineClearanceSub() != null && !offDay.getAreaLineClearanceSub().isEmpty()) {
			for (AreaLineClearanceRestModel m : offDay.getAreaLineClearanceSub()) {
				listdata1 = listdata1 + "(\"" + offDay.getPackId() 
				+  "\",\"" + m.getSlnoSub() + "\",\"" + m.getAreaSub() 
				+ "\",\"" + m.getVitaminRoom() + "\",\"" + m.getDumping() + "\",\"" + m.getSh() + "\",\"" + m.getRibbon() + "\",\"" + m.getWh() 
				+ "\",\"" + m.getRmSilo() 
				+ "\",\"" + offDay.getCreatedBy()
				+ "\",\"" + offDay.getOrganization() + "\",\"" + offDay.getOrgDivision() + "\"),";

			}
			listdata1 = listdata1.substring(0, listdata1.length() - 1);
			s = s + "@p_itemSubQuery1='" + listdata1 + "',";
		} else {
			s = s + "@p_itemSubQuery1='',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details>>>>>>>>>>>>>>>>>" + s);
		System.out.println("listdata1 Details>>>>>>>>>>>>>>>>>" + listdata1);
		return s;
	}

}
