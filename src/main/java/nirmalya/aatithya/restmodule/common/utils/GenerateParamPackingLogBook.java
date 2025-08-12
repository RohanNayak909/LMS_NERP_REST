package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.productionplan.model.PackingLotManufacturRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.Packing2AFSSMachineRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingALCRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingFCWLRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingInitialCheckRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.PackingLogBookRestModel;

public class GenerateParamPackingLogBook {

	public static String getPackingLogBookParam(PackingLogBookRestModel offDay) {
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

	public static String getLotManufactureParam(PackingLotManufacturRestModel offDay) {
		String s = "";
		System.out.println(offDay);
		if (offDay.getManufactureId() != null && offDay.getManufactureId() != "") {
			s = s + "@p_manuId='" + offDay.getManufactureId() + "',";
		}else {
			s = s + "@p_manuId='',";
		}
		if (offDay.getPackId() != null && offDay.getPackId() != "") {
			s = s + "@p_packId='" + offDay.getPackId() + "',";
		}
		if (offDay.getMrp() != null && offDay.getMrp() != "") {
			s = s + "@p_mrp='" + offDay.getMrp() + "',";
		}
		if (offDay.getUsedBy() != null && offDay.getUsedBy() != "") {
			s = s + "@p_usedBy='" + DateFormatter.getStringDate(offDay.getUsedBy()) + "',";
		}
		if (offDay.getPackStarttime() != null && offDay.getPackStarttime() != "") {
			s = s + "@p_packStarttime='" + offDay.getPackStarttime() + "',";
		}
		if (offDay.getPackEndTime() != null && offDay.getPackEndTime() != "") {
			s = s + "@p_packEndTime='" + offDay.getPackEndTime() + "',";
		}
		if (offDay.getUnitsPacked() != null && offDay.getUnitsPacked() != "") {
			s = s + "@p_unitsPacked='" + offDay.getUnitsPacked() + "',";
		}
		if (offDay.getCldPacked() != null && offDay.getCldPacked() != "") {
			s = s + "@p_cldPacked='" + offDay.getCldPacked() + "',";
		}
		if (offDay.getBulkused() != null && offDay.getBulkused() != "") {
			s = s + "@p_bulkused='" + offDay.getBulkused() + "',";
		}
		if (offDay.getBatchsize() != null && offDay.getBatchsize() != "") {
			s = s + "@p_batchsize='" + offDay.getBatchsize() + "',";
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

	public static String get2AFSSMachineParam(Packing2AFSSMachineRestModel offDay) {
		String s = "";
		System.out.println(offDay);
		if (offDay.getId() != null && offDay.getId() != "") {
			s = s + "@p_id='" + offDay.getId() + "',";
		}else {
			s = s + "@p_id='',";
		}
		if (offDay.getPackId() != null && offDay.getPackId() != "") {
			s = s + "@p_packId='" + offDay.getPackId() + "',";
		}
		if (offDay.getJsonData() != null && offDay.getJsonData() != "") {
			s = s + "@p_jsonData='" + offDay.getJsonData() + "',";
		}
		if (offDay.getHoriJarTemp() != null && offDay.getHoriJarTemp() != "") {
			s = s + "@p_horiJarTemp='" + offDay.getHoriJarTemp() + "',";
		}
		if (offDay.getVertJarTemp() != null && offDay.getVertJarTemp() != "") {
			s = s + "@p_vertitemp='" + offDay.getVertJarTemp() + "',";
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

	public static String get2BFSSMachineParam(Packing2AFSSMachineRestModel offDay) {
		String s = "";
		System.out.println(offDay);
		if (offDay.getId() != null && offDay.getId() != "") {
			s = s + "@p_id='" + offDay.getId() + "',";
		}else {
			s = s + "@p_id='',";
		}
		if (offDay.getPackId() != null && offDay.getPackId() != "") {
			s = s + "@p_packId='" + offDay.getPackId() + "',";
		}
		if (offDay.getJsonData() != null && offDay.getJsonData() != "") {
			s = s + "@p_jsonData='" + offDay.getJsonData() + "',";
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

	public static String getCTQParam(Packing2AFSSMachineRestModel offDay) {
		String s = "";
		System.out.println(offDay);
		if (offDay.getId() != null && offDay.getId() != "") {
			s = s + "@p_id='" + offDay.getId() + "',";
		}else {
			s = s + "@p_id='',";
		}
		if (offDay.getPackId() != null && offDay.getPackId() != "") {
			s = s + "@p_packId='" + offDay.getPackId() + "',";
		}
		if (offDay.getJsonData() != null && offDay.getJsonData() != "") {
			s = s + "@p_jsonData='" + offDay.getJsonData() + "',";
		}
		if (offDay.getJsonData1() != null && offDay.getJsonData1() != "") {
			s = s + "@p_jsonData1='" + offDay.getJsonData1() + "',";
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

	public static String getInitialCheckParam(PackingInitialCheckRestModel offDay) {
		String s = "";
		System.out.println(offDay);
		if (offDay.getId() != null && offDay.getId() != "") {
			s = s + "@p_id='" + offDay.getId() + "',";
		}else {
			s = s + "@p_id='',";
		}
		if (offDay.getPackId() != null && offDay.getPackId() != "") {
			s = s + "@p_packId='" + offDay.getPackId() + "',";
		}
		if (offDay.getSpecification() != null && offDay.getSpecification() != "") {
			s = s + "@p_specification='" + offDay.getSpecification() + "',";
		}
		if (offDay.getJsonData() != null && offDay.getJsonData() != "") {
			s = s + "@p_jsonData='" + offDay.getJsonData() + "',";
		}
		if (offDay.getJsonData1() != null && offDay.getJsonData1() != "") {
			s = s + "@p_jsonData1='" + offDay.getJsonData1() + "',";
		}
		if (offDay.getJsonData2() != null && offDay.getJsonData2() != "") {
			s = s + "@p_jsonData2='" + offDay.getJsonData2() + "',";
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

	public static String getALCParam(PackingALCRestModel offDay) {
		String s = "";
		System.out.println(offDay);
		if (offDay.getId() != null && offDay.getId() != "") {
			s = s + "@p_id='" + offDay.getId() + "',";
		}else {
			s = s + "@p_id='',";
		}
		if (offDay.getPackId() != null && offDay.getPackId() != "") {
			s = s + "@p_packId='" + offDay.getPackId() + "',";
		}
		if (offDay.getChangeOver() != null && offDay.getChangeOver() != "") {
			s = s + "@p_changeOver='" + offDay.getChangeOver() + "',";
		}
		if (offDay.getFromtime() != null && offDay.getFromtime() != "") {
			s = s + "@p_fromtime='" + offDay.getFromtime() + "',";
		}
		if (offDay.getToTime() != null && offDay.getToTime() != "") {
			s = s + "@p_totime='" + offDay.getToTime() + "',";
		}
		if (offDay.getClean() != null && offDay.getClean() != "") {
			s = s + "@p_clean='" + offDay.getClean() + "',";
		}
		if (offDay.getAlcHrs() != null && offDay.getAlcHrs() != "") {
			s = s + "@p_alcHrs='" + offDay.getAlcHrs() + "',";
		}
		if (offDay.getFromtime1() != null && offDay.getFromtime1() != "") {
			s = s + "@p_fromtime1='" + offDay.getFromtime1() + "',";
		}
		if (offDay.getToTime1() != null && offDay.getToTime1() != "") {
			s = s + "@p_totime1='" + offDay.getToTime1() + "',";
		}
		if (offDay.getFromtime2() != null && offDay.getFromtime2() != "") {
			s = s + "@p_fromtime2='" + offDay.getFromtime2() + "',";
		}
		if (offDay.getToTime2() != null && offDay.getToTime2() != "") {
			s = s + "@p_totime2='" + offDay.getToTime2() + "',";
		}
		if (offDay.getFromtime3() != null && offDay.getFromtime3() != "") {
			s = s + "@p_fromtime3='" + offDay.getFromtime3() + "',";
		}
		if (offDay.getToTime3() != null && offDay.getToTime3() != "") {
			s = s + "@p_totime3='" + offDay.getToTime3() + "',";
		}
		if (offDay.getJsonData() != null && offDay.getJsonData() != "") {
			s = s + "@p_jsonData='" + offDay.getJsonData() + "',";
		}
		if (offDay.getJsonData1() != null && offDay.getJsonData1() != "") {
			s = s + "@p_jsonData1='" + offDay.getJsonData1() + "',";
		}
		if (offDay.getJsonData2() != null && offDay.getJsonData2() != "") {
			s = s + "@p_jsonData2='" + offDay.getJsonData2() + "',";
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

	public static String getFCWLParam(PackingFCWLRestModel offDay) {
		String s = "";
		System.out.println(offDay);
		if (offDay.getId() != null && offDay.getId() != "") {
			s = s + "@p_id='" + offDay.getId() + "',";
		}else {
			s = s + "@p_id='',";
		}
		if (offDay.getPackId() != null && offDay.getPackId() != "") {
			s = s + "@p_packId='" + offDay.getPackId() + "',";
		}
		if (offDay.getPmCarton() != null && offDay.getPmCarton() != "") {
			s = s + "@p_pmCarton='" + offDay.getPmCarton() + "',";
		}
		if (offDay.getPackedCarton() != null && offDay.getPackedCarton() != "") {
			s = s + "@p_packedCarton='" + offDay.getPackedCarton() + "',";
		}
		if (offDay.getSkuNo() != null && offDay.getSkuNo() != "") {
			s = s + "@p_skuNo='" + offDay.getSkuNo() + "',";
		}
		if (offDay.getPmWeight() != null && offDay.getPmWeight() != "") {
			s = s + "@p_pmWeight='" + offDay.getPmWeight() + "',";
		}
		if (offDay.getBulkWeight() != null && offDay.getBulkWeight() != "") {
			s = s + "@p_bulkWeight='" + offDay.getBulkWeight() + "',";
		}
		if (offDay.getJsonData1() != null && offDay.getJsonData1() != "") {
			s = s + "@p_jsonData1='" + offDay.getJsonData1() + "',";
		}
		if (offDay.getJsonData2() != null && offDay.getJsonData2() != "") {
			s = s + "@p_jsonData2='" + offDay.getJsonData2() + "',";
		}
		if (offDay.getJsonData3() != null && offDay.getJsonData3() != "") {
			s = s + "@p_jsonData3='" + offDay.getJsonData3() + "',";
		}
		if (offDay.getJsonData4() != null && offDay.getJsonData4() != "") {
			s = s + "@p_jsonData4='" + offDay.getJsonData4() + "',";
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

}
