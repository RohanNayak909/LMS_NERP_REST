package nirmalya.aatithya.restmodule.recruitment.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestGenerateOfferLetterModel {

	private String empId;
	private String fname;
	private String lname;
	private String address;
	private String mob;
	private String basic;
	private String hra;
	private String addAll;
	private String total1;
	private String lta;
	private String medical;
	private String total2;
	private String variable;
	private String total3;
	private String empEpf;
	private String gratuity;
	private String inc;
	private String total4;
	private String monthlyCompensation;
	private String yearlyCompensation;
	private String costtoCompany;

	private String ybasic;
	private String yhra;
	private String yaddAll;
	private String ytotal1;
	private String ylta;
	private String ymedical;
	private String ytotal2;
	private String yvariable;
	private String ytotal3;
	private String yempEpf;
	private String ygratuity;
	private String yinc;
	private String ytotal4;
	private String ymonthlyCompensation;
	private String yyearlyCompensation;
	private String ycosttoCompany;
	private String logo;
	private String sign;
	private String stamp;
	private String org;
	private String orgDiv;
	private String emai;
	private String orgAddress;
	private String ordMobile;
	private String letterType;
	private String designation;
	
	public RestGenerateOfferLetterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestGenerateOfferLetterModel(Object empId, Object fname, Object lname,Object address,Object mob, Object basic, Object hra,
			Object addAll, Object total1, Object lta, Object medical, Object total2, Object variable, Object total3,
			Object empEpf, Object gratuity, Object inc, Object total4, Object monthlyCompensation,
			Object yearlyCompensation, Object costtoCompany,
			Object ybasic, Object yhra,
			Object yaddAll, Object ytotal1, Object ylta, Object ymedical, Object ytotal2, Object yvariable, Object ytotal3,
			Object yempEpf, Object ygratuity, Object yinc, Object ytotal4, Object ymonthlyCompensation,
			Object yyearlyCompensation, Object ycosttoCompany,
			Object logo,Object sign,Object stamp,Object org,Object orgDiv,Object emai,Object orgAddress,Object ordMobile,Object letterType,Object designation) {
		super();
		this.empId = (String) empId;
		this.fname = (String) fname;
		this.lname = (String) lname;
		this.address=(String) address;
		this.mob = (String) mob;
		this.basic = (String) basic;
		this.hra = (String) hra;
		this.addAll = (String) addAll;
		this.total1 = (String) total1;
		this.lta = (String) lta;
		this.medical = (String) medical;
		this.total2 = (String) total2;
		this.variable = (String) variable;
		this.total3 = (String) total3;
		this.empEpf = (String) empEpf;
		this.gratuity = (String) gratuity;
		this.inc = (String) inc;
		this.total4 = (String) total4;
		this.monthlyCompensation = (String) monthlyCompensation;
		this.yearlyCompensation = (String) yearlyCompensation;
		this.costtoCompany = (String) costtoCompany;
		
		this.ybasic = (String) ybasic;
		this.yhra = (String) yhra;
		this.yaddAll = (String) yaddAll;
		this.ytotal1 = (String) ytotal1;
		this.ylta = (String) ylta;
		this.ymedical = (String) ymedical;
		this.ytotal2 = (String) ytotal2;
		this.yvariable = (String) yvariable;
		this.ytotal3 = (String) ytotal3;
		this.yempEpf = (String) yempEpf;
		this.ygratuity = (String) ygratuity;
		this.yinc = (String) yinc;
		this.ytotal4 = (String) ytotal4;
		this.ymonthlyCompensation = (String) ymonthlyCompensation;
		this.yyearlyCompensation = (String) yyearlyCompensation;
		this.ycosttoCompany = (String) ycosttoCompany;
		this.logo = (String) logo;
		this.sign = (String) sign;
		this.stamp = (String) stamp;
		this.org = (String) org;
		this.orgDiv = (String) orgDiv;
		
		this.emai = (String) emai;
		this.orgAddress = (String) orgAddress;
		this.ordMobile = (String) ordMobile;
		this.letterType = (String) letterType;
		this.designation = (String) designation;
	}
	
	public RestGenerateOfferLetterModel(Object empId, Object fname, Object lname,Object address,Object mob, Object basic, Object hra,
			Object addAll, Object total1, Object lta, Object medical, Object total2, Object variable, Object total3,
			Object empEpf, Object gratuity, Object inc, Object total4, Object monthlyCompensation,
			Object yearlyCompensation, Object costtoCompany,
			Object ybasic, Object yhra,
			Object yaddAll, Object ytotal1, Object ylta, Object ymedical, Object ytotal2, Object yvariable, Object ytotal3,
			Object yempEpf, Object ygratuity, Object yinc, Object ytotal4, Object ymonthlyCompensation,
			Object yyearlyCompensation, Object ycosttoCompany,
			Object logo,Object sign,Object stamp,Object org,Object orgDiv) {
		super();
		this.empId = (String) empId;
		this.fname = (String) fname;
		this.lname = (String) lname;
		this.address=(String) address;
		this.mob = (String) mob;
		this.basic = (String) basic;
		this.hra = (String) hra;
		this.addAll = (String) addAll;
		this.total1 = (String) total1;
		this.lta = (String) lta;
		this.medical = (String) medical;
		this.total2 = (String) total2;
		this.variable = (String) variable;
		this.total3 = (String) total3;
		this.empEpf = (String) empEpf;
		this.gratuity = (String) gratuity;
		this.inc = (String) inc;
		this.total4 = (String) total4;
		this.monthlyCompensation = (String) monthlyCompensation;
		this.yearlyCompensation = (String) yearlyCompensation;
		this.costtoCompany = (String) costtoCompany;
		
		this.ybasic = (String) ybasic;
		this.yhra = (String) yhra;
		this.yaddAll = (String) yaddAll;
		this.ytotal1 = (String) ytotal1;
		this.ylta = (String) ylta;
		this.ymedical = (String) ymedical;
		this.ytotal2 = (String) ytotal2;
		this.yvariable = (String) yvariable;
		this.ytotal3 = (String) ytotal3;
		this.yempEpf = (String) yempEpf;
		this.ygratuity = (String) ygratuity;
		this.yinc = (String) yinc;
		this.ytotal4 = (String) ytotal4;
		this.ymonthlyCompensation = (String) ymonthlyCompensation;
		this.yyearlyCompensation = (String) yyearlyCompensation;
		this.ycosttoCompany = (String) ycosttoCompany;
		this.logo = (String) logo;
		this.sign = (String) sign;
		this.stamp = (String) stamp;
		this.org = (String) org;
		this.orgDiv = (String) orgDiv;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getHra() {
		return hra;
	}

	public void setHra(String hra) {
		this.hra = hra;
	}

	public String getAddAll() {
		return addAll;
	}

	public void setAddAll(String addAll) {
		this.addAll = addAll;
	}

	public String getTotal1() {
		return total1;
	}

	public void setTotal1(String total1) {
		this.total1 = total1;
	}

	public String getLta() {
		return lta;
	}

	public void setLta(String lta) {
		this.lta = lta;
	}

	public String getMedical() {
		return medical;
	}

	public void setMedical(String medical) {
		this.medical = medical;
	}

	public String getTotal2() {
		return total2;
	}

	public void setTotal2(String total2) {
		this.total2 = total2;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public String getTotal3() {
		return total3;
	}

	public void setTotal3(String total3) {
		this.total3 = total3;
	}

	public String getEmpEpf() {
		return empEpf;
	}

	public void setEmpEpf(String empEpf) {
		this.empEpf = empEpf;
	}

	public String getGratuity() {
		return gratuity;
	}

	public void setGratuity(String gratuity) {
		this.gratuity = gratuity;
	}

	public String getInc() {
		return inc;
	}

	public void setInc(String inc) {
		this.inc = inc;
	}

	public String getTotal4() {
		return total4;
	}

	public void setTotal4(String total4) {
		this.total4 = total4;
	}

	public String getMonthlyCompensation() {
		return monthlyCompensation;
	}

	public void setMonthlyCompensation(String monthlyCompensation) {
		this.monthlyCompensation = monthlyCompensation;
	}

	public String getYearlyCompensation() {
		return yearlyCompensation;
	}

	public void setYearlyCompensation(String yearlyCompensation) {
		this.yearlyCompensation = yearlyCompensation;
	}

	public String getCosttoCompany() {
		return costtoCompany;
	}

	public void setCosttoCompany(String costtoCompany) {
		this.costtoCompany = costtoCompany;
	}

	public String getYbasic() {
		return ybasic;
	}

	public void setYbasic(String ybasic) {
		this.ybasic = ybasic;
	}

	public String getYhra() {
		return yhra;
	}

	public void setYhra(String yhra) {
		this.yhra = yhra;
	}

	public String getYaddAll() {
		return yaddAll;
	}

	public void setYaddAll(String yaddAll) {
		this.yaddAll = yaddAll;
	}

	public String getYtotal1() {
		return ytotal1;
	}

	public void setYtotal1(String ytotal1) {
		this.ytotal1 = ytotal1;
	}

	public String getYlta() {
		return ylta;
	}

	public void setYlta(String ylta) {
		this.ylta = ylta;
	}

	public String getYmedical() {
		return ymedical;
	}

	public void setYmedical(String ymedical) {
		this.ymedical = ymedical;
	}

	public String getYtotal2() {
		return ytotal2;
	}

	public void setYtotal2(String ytotal2) {
		this.ytotal2 = ytotal2;
	}

	public String getYvariable() {
		return yvariable;
	}

	public void setYvariable(String yvariable) {
		this.yvariable = yvariable;
	}

	public String getYtotal3() {
		return ytotal3;
	}

	public void setYtotal3(String ytotal3) {
		this.ytotal3 = ytotal3;
	}

	public String getYempEpf() {
		return yempEpf;
	}

	public void setYempEpf(String yempEpf) {
		this.yempEpf = yempEpf;
	}

	public String getYgratuity() {
		return ygratuity;
	}

	public void setYgratuity(String ygratuity) {
		this.ygratuity = ygratuity;
	}

	public String getYinc() {
		return yinc;
	}

	public void setYinc(String yinc) {
		this.yinc = yinc;
	}

	public String getYtotal4() {
		return ytotal4;
	}

	public void setYtotal4(String ytotal4) {
		this.ytotal4 = ytotal4;
	}

	public String getYmonthlyCompensation() {
		return ymonthlyCompensation;
	}

	public void setYmonthlyCompensation(String ymonthlyCompensation) {
		this.ymonthlyCompensation = ymonthlyCompensation;
	}

	public String getYyearlyCompensation() {
		return yyearlyCompensation;
	}

	public void setYyearlyCompensation(String yyearlyCompensation) {
		this.yyearlyCompensation = yyearlyCompensation;
	}

	public String getYcosttoCompany() {
		return ycosttoCompany;
	}

	public void setYcosttoCompany(String ycosttoCompany) {
		this.ycosttoCompany = ycosttoCompany;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getStamp() {
		return stamp;
	}

	public void setStamp(String stamp) {
		this.stamp = stamp;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getOrgDiv() {
		return orgDiv;
	}

	public void setOrgDiv(String orgDiv) {
		this.orgDiv = orgDiv;
	}
	
	

	public String getEmai() {
		return emai;
	}

	public void setEmai(String emai) {
		this.emai = emai;
	}

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getOrdMobile() {
		return ordMobile;
	}

	public void setOrdMobile(String ordMobile) {
		this.ordMobile = ordMobile;
	}
	
	public String getLetterType() {
		return letterType;
	}

	public void setLetterType(String letterType) {
		this.letterType = letterType;
	}
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}

}
