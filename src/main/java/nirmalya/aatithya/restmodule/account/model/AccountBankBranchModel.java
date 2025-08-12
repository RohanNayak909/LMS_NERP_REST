/**
 * 
 */
package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class AccountBankBranchModel {
	private String branchid;
	private String bankname;
	private String branchname;
	private String cityname;
	private String stateid;
	private String countryid;
	private String contactno;
	private String cityid;
	private String email;
	private String ifscode;
	private String status;
	private String address;

	/**
	 * 
	 */
	public AccountBankBranchModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Generate Constructor
	 *
	 */

	public AccountBankBranchModel(Object branchid, Object bankname, Object branchname, Object cityname, Object stateid,
			Object countryid, Object contactno, Object cityid, Object email, Object ifscode, Object status,
			Object address){
		super();
		
		this.branchid = (String)branchid;
		this.bankname = (String)bankname;
		this.branchname = (String)branchname;
		this.cityname = (String)cityname;
		this.stateid = (String)stateid;
		this.countryid = (String)countryid;
		this.contactno = (String)contactno;
		this.cityid = (String)cityid;
		this.email = (String)email;
		this.ifscode = (String)ifscode;
		this.status = (String)status;
		this.address = (String)address;

	}

	/**
	 * Generate Getter & Setter
	 *
	 */
	public String getBranchid() {
		return branchid;
	}

	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getStateid() {
		return stateid;
	}

	public void setStateid(String stateid) {
		this.stateid = stateid;
	}

	public String getCountryid() {
		return countryid;
	}

	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIfscode() {
		return ifscode;
	}

	public void setIfscode(String ifscode) {
		this.ifscode = ifscode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

