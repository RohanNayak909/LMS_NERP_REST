package nirmalya.aatithya.restmodule.common.utils.projects;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectFileuploadModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectFileuploadModelV1;
import nirmalya.aatithya.restmodule.projects.model.RestProjectShippingModel;

public class GenerateProjectCreationParameter {

	public static String getPrjCreateParam(List<ProjectCreationRestModel> prjCreation) {
		String s = "";
		String multidocument = "";
		String listdata = "";
		String productlistdata = "";

		if (prjCreation.get(0).getProjectId() != null || prjCreation.get(0).getProjectId() != "") {
			s = s + "@p_projectId='" + prjCreation.get(0).getProjectId() + "',";
		}

		if (prjCreation.get(0).getProjectName() != null || prjCreation.get(0).getProjectName() != "") {
			s = s + "@p_getProjectName='" + prjCreation.get(0).getProjectName() + "',";
		}

//		if (DateFormatter.getStringDate(prjCreation.get(0).getCreationDate()) != null || DateFormatter.getStringDate(prjCreation.get(0).getCreationDate()) != "") {
//			s = s + "@p_getCreationDate='" + DateFormatter.getStringDate(prjCreation.get(0).getCreationDate()) + "',";
//		}

		if (prjCreation.get(0).getLocation() != null || prjCreation.get(0).getLocation() != "") {
			s = s + "@p_getLocation='" + prjCreation.get(0).getLocation() + "',";
		}
		if (prjCreation.get(0).getCountry2() != null || prjCreation.get(0).getCountry2() != "") {
			s = s + "@p_getCountry2='" + prjCreation.get(0).getCountry2() + "',";
		}
		if (prjCreation.get(0).getStateid2() != null || prjCreation.get(0).getStateid2() != "") {
			s = s + "@p_getStateid2='" + prjCreation.get(0).getStateid2() + "',";
		}
		if (prjCreation.get(0).getpPin() != null || prjCreation.get(0).getpPin() != "") {
			s = s + "@p_getpPin='" + prjCreation.get(0).getpPin() + "',";
		}

		if (prjCreation.get(0).getpIncharge() != null || prjCreation.get(0).getpIncharge() != "") {
			s = s + "@p_getpIncharge='" + prjCreation.get(0).getpIncharge() + "',";
		}

		if (prjCreation.get(0).getcName() != null || prjCreation.get(0).getcName() != "") {
			s = s + "@p_getcName='" + prjCreation.get(0).getcName() + "',";
		}

//		if (prjCreation.get(0).getcAddress() != null || prjCreation.get(0).getcAddress() != "") {
//			s = s + "@p_getcAddress='" + prjCreation.get(0).getcAddress() + "',";
//		}

		if (prjCreation.get(0).getCountry() != null || prjCreation.get(0).getCountry() != "") {
			s = s + "@p_getCountry='" + prjCreation.get(0).getCountry() + "',";
		}

		if (prjCreation.get(0).getStateid() != null || prjCreation.get(0).getStateid() != "") {
			s = s + "@p_getStateid='" + prjCreation.get(0).getStateid() + "',";
		}

		if (prjCreation.get(0).getCityb() != null || prjCreation.get(0).getCityb() != "") {
			s = s + "@p_getCityb='" + prjCreation.get(0).getCityb() + "',";
		}

		if (prjCreation.get(0).getBillingStreet1() != null || prjCreation.get(0).getBillingStreet1() != "") {
			s = s + "@p_getStreet1b='" + prjCreation.get(0).getBillingStreet1() + "',";
		}

		if (prjCreation.get(0).getBillingStreet2() != null || prjCreation.get(0).getBillingStreet2() != "") {
			s = s + "@p_getStreet2b='" + prjCreation.get(0).getBillingStreet2() + "',";
		}
		
		if (prjCreation.get(0).getBillingGstNo() != null || prjCreation.get(0).getBillingGstNo() != "") {
			s = s + "@p_billingGstNo='" + prjCreation.get(0).getBillingGstNo() + "',";
		}

		if (prjCreation.get(0).getcPin() != null || prjCreation.get(0).getcPin() != "") {
			s = s + "@p_getcPin='" + prjCreation.get(0).getcPin() + "',";
		}

		if (prjCreation.get(0).getEmail() != null || prjCreation.get(0).getEmail() != "") {
			s = s + "@p_getEmail='" + prjCreation.get(0).getEmail() + "',";
		}

		if (prjCreation.get(0).getMobile() != null || prjCreation.get(0).getMobile() != "") {
			s = s + "@p_getMobile='" + prjCreation.get(0).getMobile() + "',";
		}

		if (prjCreation.get(0).getRemark() != null || prjCreation.get(0).getRemark() != "") {
			s = s + "@p_getRemark='" + prjCreation.get(0).getRemark() + "',";
		}

		if (prjCreation.get(0).getStatus() != null || prjCreation.get(0).getStatus() != "") {
			s = s + "@p_getStatus='" + prjCreation.get(0).getStatus() + "',";
		}

		if (prjCreation.get(0).getCreatedBy() != null || prjCreation.get(0).getCreatedBy() != "") {
			s = s + "@p_getCreatedBy='" + prjCreation.get(0).getCreatedBy() + "',";
		}

		if (prjCreation.get(0).getOrganizationName() != null || prjCreation.get(0).getOrganizationName() != "") {
			s = s + "@p_getOrganizationName='" + prjCreation.get(0).getOrganizationName() + "',";
		}

		if (prjCreation.get(0).getOrganizationDivision() != null
				|| prjCreation.get(0).getOrganizationDivision() != "") {
			s = s + "@p_getOrganizationDivision='" + prjCreation.get(0).getOrganizationDivision() + "',";
		}
		
		if (prjCreation.get(0).getProjectType() != null
				|| prjCreation.get(0).getProjectType() != "") {
			s = s + "@p_ProjectType='" + prjCreation.get(0).getProjectType() + "',";
		}
		if (prjCreation.get(0).getDate() != null
				|| prjCreation.get(0).getDate() != "") {
			s = s + "@p_creationDate='" + prjCreation.get(0).getDate() + "',";
		}

		if (!prjCreation.get(0).getProjectId().contentEquals("1")) {
			// FOR SHIPPING STARTS

			for (RestProjectShippingModel m : prjCreation.get(0).getShippingList()) {
				
			//if (listdata.isEmpty()) {
					listdata = listdata + "(@p_projectId,\"" + m.getShippingName() + "\",\"" + m.getCountry1() + "\",\"" + m.getStateid1() + "\",\"" + m.getShippingCity()
							+ "\",\"" + m.getShippingStreet1() + "\",\"" + m.getShippingStreet2() + "\",\""
							+ m.getShippingPin() + "\",\"" + m.getShippingEmail() + "\",\"" + m.getShippingMobileNo()
							+ "\",\""+m.getShippingGstNo()+"\",\""+m.getShippingContact()+"\"),";

				//}

				
			}
			if (!listdata.isEmpty()) {
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
			}else {
				s = s + "@p_litemSubQuery='" + listdata + "',";
			}
			
			
			
			// FOR SHIPPING ENDS

			
			for (RestProjectShippingModel a : prjCreation.get(0).getProductList()) {
				
			
				productlistdata = productlistdata + "(@p_projectId,\"" + a.getProductId() + "\",\"" + a.getProductName()
						+ "\",\"" + a.getSku() + "\",\"" + a.getModel() + "\",\"" + a.getManufacture() + "\",\""
						+ a.getUnit() + "\",\"" + a.getBrand() + "\",\"" + a.getColor() + "\",\""
						+ prjCreation.get(0).getCreatedBy() + "\",\"" + prjCreation.get(0).getOrganizationName()
						+ "\",\"" + prjCreation.get(0).getOrganizationDivision() + "\"),";

			   
			}
			if (!productlistdata.isEmpty()) {
				productlistdata = productlistdata.substring(0, productlistdata.length() - 1);
				s = s + "@p_listProduct='" + productlistdata + "',";
			}else {
				s = s + "@p_listProduct='" + productlistdata + "',";
			}
			
			
			for (RestProjectFileuploadModel a : prjCreation.get(0).getDocumentList()) {
				multidocument = multidocument + "(@p_projectId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()
						+ "\"),";
			}
			if (!multidocument.isEmpty()) {
				multidocument = multidocument.substring(0, multidocument.length() - 1);
				s = s + "@p_vendorDocuments='" + multidocument + "',";
			}else {
				s = s + "@p_vendorDocuments='" + multidocument + "',";
			}
			/*
			 * 
			 * for (RestProjectFileuploadModelV1 a : prjCreation.get(0).getDocumentList1())
			 * { multidocument = multidocument + "(@p_projectId,\"" + a.getDocumentName() +
			 * "\",\"" + a.getDocumentFileName() + "\"),"; }
			 */
			if (!multidocument.isEmpty()) {
				multidocument = multidocument.substring(0, multidocument.length() - 1);
				s = s + "@p_projectDocList='" + multidocument + "',";
			}else {
				s = s + "@p_projectDocList='" + multidocument + "',";
			}


			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}

		}

		return s;

	}
	
	
	
	
	
	public static String getproductSkuParam(ProjectCreationRestModel prjCreation) {
		String s = "";
		String listdata = "";
		
		

		

		if (!prjCreation.getProductSkuId().contentEquals("1")) {
			
			for (RestProjectShippingModel a : prjCreation.getSkuList()) {
				for (RestProjectShippingModel a1 : prjCreation.getProductList()) {
				
				listdata = listdata + "(\""+ a.getProductId() + "\",\"" + a1.getProductName() + "\",\""
						+ a.getSku() + "\",\"" + a.getModel() + "\",\"" + a.getUnit() + "\",\"" + a.getManufacture()
						+ "\",\"" + a.getBrand() + "\",\"" + a.getColor() + "\",\""
						+ prjCreation.getCreatedBy() + "\",\"" + prjCreation.getOrganizationName()
						+ "\",\"" + prjCreation.getOrganizationDivision() + "\"),";
				}
			   
			}
			if (!listdata.isEmpty()) {
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_listProduct='" + listdata + "',";
			}else {
				s = s + "@p_listProduct='" + listdata + "',";
			}
			
			
			

			System.out.println("generate param------------------" + s);

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}

		}

		return s;

	}

}
