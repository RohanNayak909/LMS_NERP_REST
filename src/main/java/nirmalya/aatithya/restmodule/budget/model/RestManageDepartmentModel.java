package nirmalya.aatithya.restmodule.budget.model;

	import java.io.IOException;

	import com.fasterxml.jackson.databind.ObjectMapper;

	public class RestManageDepartmentModel {

		private String departmentId;
		private String departmentName;
		private String deptMobile;
		private String deptEmail;
		private String departmentHODName;
		private String description;
		private String password;
		private String orgName;
		private String orgDivision;
		private String createdBy;
		
		
		public RestManageDepartmentModel(Object departmentId,Object departmentName,
				Object deptMobile,Object deptEmail,
				Object departmentHODName,Object password,Object description) {
			super();
			this.departmentId = (String) departmentId;
			this.departmentName = (String) departmentName;
			this.deptMobile = (String) deptMobile;
			this.deptEmail = (String) deptEmail;
			this.departmentHODName = (String) departmentHODName;
			this.description = (String) description;
			this.password = (String) password;
			
		}


		// TODO Auto-generated constructor stub
		public String getDepartmentId() {
			return departmentId;

		}

		public String getOrgName() {
			return orgName;
		}


		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}


		public String getOrgDivision() {
			return orgDivision;
		}


		public void setOrgDivision(String orgDivision) {
			this.orgDivision = orgDivision;
		}


		public String getCreatedBy() {
			return createdBy;
		}


		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public void setDepartmentId(String departmentId) {
			this.departmentId = departmentId;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		public String getDeptMobile() {
			return deptMobile;
		}

		public void setDeptMobile(String deptMobile) {
			this.deptMobile = deptMobile;
		}

		public String getDeptEmail() {
			return deptEmail;
		}

		public void setDeptEmail(String deptEmail) {
			this.deptEmail = deptEmail;
		}

		public String getDepartmentHODName() {
			return departmentHODName;
		}

		public void setDepartmentHODName(String departmentHODName) {
			this.departmentHODName = departmentHODName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;

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


