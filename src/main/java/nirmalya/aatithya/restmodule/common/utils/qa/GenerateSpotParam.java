package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.QaSpotRestModel;


public class GenerateSpotParam {
	public static String getAddSpot(List<QaSpotRestModel> qp) {
		String s = "";
		String sitem = "";
		String sitem1 = "";

		if (qp.get(0).getSpotId() != null || qp.get(0).getSpotId() != "") {
			s = s + "@p_spotId='" + qp.get(0).getSpotId() + "',";
		}
		if (qp.get(0).getWeightSample() != null || qp.get(0).getWeightSample() != "") {
			s = s + "@p_weightsample='" + qp.get(0).getWeightSample() + "',";
		}
		if (qp.get(0).getWeightdiscsample() != null || qp.get(0).getWeightdiscsample() != "") {
			s = s + "@p_weightdiscsample='" + qp.get(0).getWeightdiscsample() + "',";
		}
		if (qp.get(0).getWeightdisc() != null || qp.get(0).getWeightdisc() != "") {
			s = s + "@p_weightdisc='" + qp.get(0).getWeightdisc() + "',";
		}
		if (qp.get(0).getWeightloss() != null || qp.get(0).getWeightloss() != "") {
			s = s + "@p_weightloss='" + qp.get(0).getWeightloss() + "',";
		}
		if (qp.get(0).getSaltmoisture() != null || qp.get(0).getSaltmoisture() != "") {
			s = s + "@p_saltmoisture='" + qp.get(0).getSaltmoisture() + "',";
		}
		if (qp.get(0).getWeightsample1() != null || qp.get(0).getWeightsample1() != "") {
			s = s + "@p_weightsample1='" + qp.get(0).getWeightsample1() + "',";
		}
		if (qp.get(0).getH2s041() != null || qp.get(0).getH2s041() != "") {
			s = s + "@p_h2s041='" + qp.get(0).getH2s041() + "',";
		}
		if (qp.get(0).getFactor1() != null || qp.get(0).getFactor1() != "") {
			s = s + "@p_factor1='" + qp.get(0).getFactor1() + "',";
		}
		if (qp.get(0).getSoda1() != null || qp.get(0).getSoda1() != "") {
			s = s + "@p_soda1='" + qp.get(0).getSoda1() + "',";
		}
		if (qp.get(0).getWeightsample2() != null || qp.get(0).getWeightsample2() != "") {
			s = s + "@p_weightsample2='" + qp.get(0).getWeightsample2() + "',";
		}
		if (qp.get(0).getH2s042() != null || qp.get(0).getH2s042() != "") {
			s = s + "@p_h2s042='" + qp.get(0).getH2s042() + "',";
		}
		if (qp.get(0).getFactor2() != null || qp.get(0).getFactor2() != "") {
			s = s + "@p_factor2='" + qp.get(0).getFactor2() + "',";
		}
		if (qp.get(0).getSoda2() != null || qp.get(0).getSoda2() != "") {
			s = s + "@p_soda2='" + qp.get(0).getSoda2() + "',";
		}
		if (qp.get(0).getLabsadose() != null || qp.get(0).getLabsadose() != "") {
			s = s + "@p_labsadose='" + qp.get(0).getLabsadose() + "',";
		}
		if (qp.get(0).getPerfumeimpact() != null || qp.get(0).getPerfumeimpact() != "") {
			s = s + "@p_perfumeimpact='" + qp.get(0).getPerfumeimpact() + "',";
		}
		if (qp.get(0).getColour() != null || qp.get(0).getColour() != "") {
			s = s + "@p_colour='" + qp.get(0).getColour() + "',";
		}
		if (qp.get(0).getBdgmm3() != null || qp.get(0).getBdgmm3() != "") {
			s = s + "@p_bdgmm3='" + qp.get(0).getBdgmm3() + "',";
		}
		if (qp.get(0).getDfr() != null || qp.get(0).getDfr() != "") {
			s = s + "@p_dfr='" + qp.get(0).getDfr() + "',";
		}
		if (qp.get(0).getAd() != null || qp.get(0).getAd() != "") {
			s = s + "@p_ad='" + qp.get(0).getAd() + "',";
		}
		if (qp.get(0).getMc() != null || qp.get(0).getMc() != "") {
			s = s + "@p_mc='" + qp.get(0).getMc() + "',";
		}
		if (qp.get(0).getSleve1020() != null || qp.get(0).getSleve1020() != "") {
			s = s + "@p_sleve1020='" + qp.get(0).getSleve1020() + "',";
		}
		if (qp.get(0).getFgsleve8() != null || qp.get(0).getFgsleve8() != "") {
			s = s + "@p_fgsleve8='" + qp.get(0).getFgsleve8() + "',";
		}
		if (qp.get(0).getMagnetcondition() != null || qp.get(0).getMagnetcondition() != "") {
			s = s + "@p_magnetcondition='" + qp.get(0).getMagnetcondition() + "',";
		}
		if (qp.get(0).getSprayquality() != null || qp.get(0).getSprayquality() != "") {
			s = s + "@p_sprayquality='" + qp.get(0).getSprayquality() + "',";
		}
		if (qp.get(0).getTemppowder() != null || qp.get(0).getTemppowder() != "") {
			s = s + "@p_temppowder='" + qp.get(0).getTemppowder() + "',";
		}
		if (qp.get(0).getBasepowdersleve10() != null || qp.get(0).getBasepowdersleve10() != "") {
			s = s + "@p_basepowdersleve10='" + qp.get(0).getBasepowdersleve10() + "',";
		}
		if (qp.get(0).getBdgmml() != null || qp.get(0).getBdgmml() != "") {
			s = s + "@p_bdgmml='" + qp.get(0).getBdgmml() + "',";
		}
		if (qp.get(0).getDyeav50() != null || qp.get(0).getDyeav50() != "") {
			s = s + "@p_dyeav50='" + qp.get(0).getDyeav50() + "',";
		}
		if (qp.get(0).getZeolite() != null || qp.get(0).getZeolite() != "") {
			s = s + "@p_zeolite='" + qp.get(0).getZeolite() + "',";
		}
		if (qp.get(0).getUct() != null || qp.get(0).getUct() != "") {
			s = s + "@p_uct='" + qp.get(0).getUct() + "',";
		}
		if (qp.get(0).getAppearance() != null || qp.get(0).getAppearance() != "") {
			s = s + "@p_appearance='" + qp.get(0).getAppearance() + "',";
		}
		if (qp.get(0).getOdour() != null || qp.get(0).getOdour() != "") {
			s = s + "@p_odour='" + qp.get(0).getOdour() + "',";
		}
		if (qp.get(0).getPh() != null || qp.get(0).getPh() != "") {
			s = s + "@p_ph='" + qp.get(0).getPh() + "',";
		}
		if (qp.get(0).getRmsleve20() != null || qp.get(0).getRmsleve20() != "") {
			s = s + "@p_rmsleve20='" + qp.get(0).getRmsleve20() + "',";
		}
		if (qp.get(0).getFpsleve10() != null || qp.get(0).getFpsleve10() != "") {
			s = s + "@p_fpsleve10='" + qp.get(0).getFpsleve10() + "',";
		}
		if (qp.get(0).getProduct() != null || qp.get(0).getProduct() != "") {
			s = s + "@p_product='" + qp.get(0).getProduct() + "',";
		}
		if (qp.get(0).getBatchsize() != null || qp.get(0).getBatchsize() != "") {
			s = s + "@p_batchsize='" + qp.get(0).getBatchsize() + "',";
		}
		if (qp.get(0).getTad() != null || qp.get(0).getTad() != "") {
			s = s + "@p_tad='" + qp.get(0).getTad() + "',";
		}
		if (qp.get(0).getTmc() != null || qp.get(0).getTmc() != "") {
			s = s + "@p_tmc='" + qp.get(0).getTmc() + "',";
		}
		if (qp.get(0).getPdate() != null || qp.get(0).getPdate() != "") {
			s = s + "@p_pdate='" + qp.get(0).getPdate() + "',";
		}
		if (qp.get(0).getToDateCalendarTime1() != null || qp.get(0).getToDateCalendarTime1() != "") {
			s = s + "@p_toDateCalendarTime1='" + qp.get(0).getToDateCalendarTime1() + "',";
		}
		if (qp.get(0).getShift() != null || qp.get(0).getShift() != "") {
			s = s + "@p_shift='" + qp.get(0).getShift() + "',";
		}
		if (qp.get(0).getOperator() != null || qp.get(0).getOperator() != "") {
			s = s + "@p_operator='" + qp.get(0).getOperator() + "',";
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




		for (QaSpotRestModel m : qp) {

			sitem = sitem + "(@p_spotId,\"" + m.getAdd() + "\",\"" + m.getSkg() +"\",\"" + m.getAkg() + "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
					+ "\",\"" + m.getRemark() + "\"),";
		}
		
		for (QaSpotRestModel m : qp) {

			sitem1 = sitem1 + "(@p_product,\"" + m.getAdd() + "\",\"" + m.getSkg()  +  "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
					+ "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);
		sitem1 = sitem1.substring(0, sitem1.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";
		s = s + "@p_itemSubQuery1='" + sitem1 + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
