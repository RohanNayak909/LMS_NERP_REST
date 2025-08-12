package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssetDocumentRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetPropertyRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetProprtyOwnerRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.LocationRoomModel;
import nirmalya.aatithya.restmodule.master.model.LocationSectionModel;
import nirmalya.aatithya.restmodule.training.model.ManageTrainingRestDocumentModel;

public class GenerateAssetPropertyParam {

	public static String saveLocation(AssetPropertyRestModel location) {
		
		String s = "";
		String document = "";
		
		if(location.getLocationId()!=null && location.getLocationId()!="") {
			s = s + "@p_locationId='" + location.getLocationId() + "',";
		}else {
			s = s + "@p_locationId='',";
		}
		if(location.getFloorId()!=null && location.getFloorId()!="") {
			s = s + "@p_floorId='" + location.getFloorId() + "',";
		}else {
			s = s + "@p_floorId='',";
		}
		if(location.getLocationName()!=null && location.getLocationName()!="") {
			s = s + "@p_locationName='" + location.getLocationName() + "',";
		}else {
			s = s + "@p_locationName='',";
		}
		if(location.getLocationCode()!=null && location.getLocationCode()!="") {
			s = s + "@p_locationCode='" + location.getLocationCode() + "',";
		}else {
			s = s + "@p_locationCode='',";
		}
		if(location.getLocVirtual()!=null && location.getLocVirtual()!="") {
			s = s + "@p_isVirtual='" + location.getLocVirtual() + "',";
		} else {
			s = s + "@p_isVirtual='" + 0 + "',";
		}
		if(location.getLocationType()!=null && location.getLocationType()!="") {
			s = s + "@p_locType='" + location.getLocationType() + "',";
		}else {
			s = s + "@p_locType='',";
		}
		if(location.getLocCountry()!=null && location.getLocCountry()!="") {
			s = s + "@p_locCountry='" + location.getLocCountry() + "',";
		}else {
			s = s + "@p_locCountry='',";
		}
		if(location.getLocState()!=null && location.getLocState()!="") {
			s = s + "@p_locState='" + location.getLocState() + "',";
		}else {
			s = s + "@p_locState='',";
		}
		if(location.getLocCity()!=null && location.getLocCity()!="") {
			s = s + "@p_locCity='" + location.getLocCity() + "',";
		}else {
			s = s + "@p_locCity='',";
		}
		if(location.getLocStreet()!=null && location.getLocStreet()!="") {
			s = s + "@p_locStreet='" + location.getLocStreet() + "',";
		}else {
			s = s + "@p_locStreet='',";
		}
		if(location.getLocWidth()!=null && location.getLocWidth()!="") {
			s = s + "@p_locWidth='" + location.getLocWidth() + "',";
		}else {
			s = s + "@p_locWidth='',";
		}
		if(location.getLocHeight()!=null && location.getLocHeight()!="") {
			s = s + "@p_locHeight='" + location.getLocHeight() + "',";
		}else {
			s = s + "@p_locHeight='',";
		}
		if(location.getLocLength()!=null && location.getLocLength()!="") {
			s = s + "@p_locLength='" + location.getLocLength() + "',";
		}else {
			s = s + "@p_locLength='',";
		}
		if(location.getFileLocation()!=null && location.getFileLocation()!="") {
			s = s + "@p_fileLocation='" + location.getFileLocation() + "',";
		}else {
			s = s + "@p_fileLocation='',";
		}
		if(location.getLocOwnership()!=null && location.getLocOwnership()!="") {
			s = s + "@p_locOwnership='" + location.getLocOwnership() + "',";
		}else {
			s = s + "@p_locOwnership='',";
		}
		if(location.getCreatedBy()!=null && location.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + location.getCreatedBy() + "',";
		}else {
			s = s + "@p_createdBy='',";
		}
		if(location.getLocStatus()!=null && location.getLocStatus()!="") {
			s = s + "@p_isActive='" + location.getLocStatus() + "',";
		} else {
			s = s + "@p_isActive='" + 0 + "',";
		}
		if (location.getOrganization() != null || location.getOrganization() != "") {
			s = s + "@p_org='" + location.getOrganization() + "',";
		}else {
			s = s + "@p_org='',";
		}
		if (location.getOrgDivision() != null || location.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + location.getOrgDivision() + "',";
		}else {
			s = s + "@p_orgDiv='',";
		}
		
		if(location.getRoomHeight()!=null && location.getRoomHeight()!="") {
			s = s + "@p_RoomHeight='" + location.getRoomHeight() + "',";
		}else {
			s = s + "@p_RoomHeight='',";
		}
		if(location.getRoomWidth()!=null && location.getRoomWidth()!="") {
			s = s + "@p_RoomWidth='" + location.getRoomWidth() + "',";
		}else {
			s = s + "@p_RoomWidth='',";
		}
		if(location.getRoomLength()!=null && location.getRoomLength()!="") {
			s = s + "@p_RoomLength='" + location.getRoomLength() + "',";
		}else {
			s = s + "@p_RoomLength='',";
		}
		if(location.getFloorHeight()!=null && location.getFloorHeight()!="") {
			s = s + "@p_FloorHeight='" + location.getFloorHeight() + "',";
		}else {
			s = s + "@p_FloorHeight='',";
		}
		if(location.getFloorWidth()!=null && location.getFloorWidth()!="") {
			s = s + "@p_FloorWidth='" + location.getFloorWidth() + "',";
		}else {
			s = s + "@p_FloorWidth='',";
		}
		if(location.getFloorLength()!=null && location.getFloorLength()!="") {
			s = s + "@p_FloorLength='" + location.getFloorLength() + "',";
		}else {
			s = s + "@p_FloorLength='',";
		}
		if(location.getLocArea()!=null && location.getLocArea()!="") {
			s = s + "@p_LocArea='" + location.getLocArea() + "',";
		}else {
			s = s + "@p_LocArea='',";
		}
		if(location.getLocDescription()!=null && location.getLocDescription()!="") {
			s = s + "@p_LocDescription='" + location.getLocDescription() + "',";
		}else {
			s = s + "@p_LocDescription='',";
		}
		if(location.getLocPincode()!=null && location.getLocPincode()!="") {
			s = s + "@p_LocPincode='" + location.getLocPincode() + "',";
		}else {
			s = s + "@p_LocPincode='',";
		}
		if(location.getLocSdate()!=null && location.getLocSdate()!="") {
			s = s + "@p_LocSdate='" + location.getLocSdate() + "',";
		}else {
			s = s + "@p_LocSdate='',";
		}
		if(location.getLocEdate()!=null && location.getLocEdate()!="") {
			s = s + "@p_LocEdate='" + location.getLocEdate() + "',";
		}else {
			s = s + "@p_LocEdate='',";
		}
		if(location.getLocRent()!=null && location.getLocRent()!="") {
			s = s + "@p_LocRent='" + location.getLocRent() + "',";
		}else {
			s = s + "@p_LocRent='',";
		}
		if(location.getLocPdate()!=null && location.getLocPdate()!="") {
			s = s + "@p_LocPdate='" + location.getLocPdate() + "',";
		}else {
			s = s + "@p_LocPdate='',";
		}
		for (AssetDocumentRestModel a : location.getDocumentList()) {
			document = document + "(@p_locationId,\"" + a.getDocumnentName() + "\",\""
					+ a.getFileName() + "\",\"" + a.getDocumentURL() + "\",@p_createdBy,@p_org,@p_orgDiv),";
		}
		if(document.length()!=0) {
			document = document.substring(0, document.length() - 1);
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ","+ "@p_documentQuery='" + document+ "';";
		}
		System.out.println("VALUE::::"+s);
		return s;
	}

	public static String saveSection(LocationSectionModel location) {

		String s = "";
		
		if(location.getLocationId()!=null && location.getLocationId()!="") {
			s = s + "@p_locationId='" + location.getLocationId() + "',";
		}
		if(location.getFloorId()!=null && location.getFloorId()!="") {
			s = s + "@p_floorId='" + location.getFloorId() + "',";
		}
		if(location.getSectionId()!=null && location.getSectionId()!="") {
			s = s + "@p_sectionId='" + location.getSectionId() + "',";
		}
		if(location.getSectionCode()!=null && location.getSectionCode()!="") {
			s = s + "@p_sectionCode='" + location.getSectionCode() + "',";
		}
		if(location.getSectionName()!=null && location.getSectionName()!="") {
			s = s + "@p_sectionName='" + location.getSectionName() + "',";
		}
		if(location.getCreatedBy()!=null && location.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + location.getCreatedBy() + "',";
		}
		if (location.getOrganization() != null || location.getOrganization() != "") {
			s = s + "@p_org='" + location.getOrganization() + "',";
		}
		if (location.getOrgDivision() != null || location.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + location.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String saveRoom(LocationRoomModel location) {
		
		String s = "";
		
		if(location.getFloorId()!=null && location.getFloorId()!="") {
			s = s + "@p_FloorId='" + location.getFloorId() + "',";
		}
		if(location.getRoomId()!=null && location.getRoomId()!="") {
			s = s + "@p_roomId='" + location.getRoomId() + "',";
		}
		if(location.getRoomCode()!=null && location.getRoomCode()!="") {
			s = s + "@p_roomCode='" + location.getRoomCode() + "',";
		}
		if(location.getRoomName()!=null && location.getRoomName()!="") {
			s = s + "@p_roomName='" + location.getRoomName() + "',";
		}
		if(location.getRoomType()!=null && location.getRoomType()!="") {
			s = s + "@p_roomType='" + location.getRoomType() + "',";
		}
		if(location.getCreatedBy()!=null && location.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + location.getCreatedBy() + "',";
		}
		if (location.getOrganization() != null || location.getOrganization() != "") {
			s = s + "@p_org='" + location.getOrganization() + "',";
		}
		if (location.getOrgDivision() != null || location.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + location.getOrgDivision() + "',";
		}
		if(location.getRoomHeight()!=null && location.getRoomHeight()!="") {
			s = s + "@p_RoomHeight='" + location.getRoomHeight() + "',";
		}
		if(location.getRoomWidth()!=null && location.getRoomWidth()!="") {
			s = s + "@p_RoomWidth='" + location.getRoomWidth() + "',";
		}
		if(location.getRoomLength()!=null && location.getRoomLength()!="") {
			s = s + "@p_RoomLength='" + location.getRoomLength() + "',";
		}
		
		if(location.getVariationType()!=null && location.getVariationType()!="") {
			s = s + "@p_VariationType='" + location.getVariationType() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("VALUESXX::::"+s);
		return s;
		
	}

	public static String getSectionIdList(List<String> id) {

		String s = "";
		String section = "";
		
		if(id.size() > 0) {
			for(String m : id) {
				section = section + "\"" + m + "\",";
			}
			
			section = section.substring(0, section.length() - 1);
		}
		
		s = "(" + section + ")";
		
		s = "SET @p_sectionListSubQuery='" + s + "';";
		
		return s;
	}

	public static String getLocationIdList(List<DropDownModel> id) {
		
		String s = "";
		String a = "";
		String section = "";
		
		if(id.get(0).getName()!=null && id.get(0).getName()!="") {
			s = s + "@P_ModifiedBy='" + id.get(0).getName() + "',";
		}
		
		if(id.size() > 0) {
			for(DropDownModel m : id) {
				section = section + "\"" + m.getKey() + "\",";
			}
			
			section = section.substring(0, section.length() - 1);
		} else {
			s = s.substring(0, s.length() - 1);
		}
		
		a = "(" + section + ")";
		
		s = s + "@p_locationListSubQuery='" + a + "';";
		
		s = "SET " + s ;
		
		return s;
	}
	
	public static String getLocationList(List<String> id) {

		String s = "";
		String section = "";
		
		if(id.size() > 0) {
			for(String m : id) {
				section = section + "\"" + m + "\",";
			}
			
			section = section.substring(0, section.length() - 1);
		}
		
		s = "(" + section + ")";
		
		s = "SET @p_LocSubQuery='" + s + "';";
		
		return s;
	}
	
	public static String getAddOwnerDetails(List<AssetProprtyOwnerRestModel> av) {
		String s = "";
		String document = "";

		if (av.get(0).getOwnerId() != null || av.get(0).getOwnerId() != "") {
			s = s + "@p_OwnerId='" + av.get(0).getOwnerId() + "',";
		}
		if (av.get(0).getOwnerName() != null || av.get(0).getOwnerName() != "") {
			s = s + "@p_OwnerName='" + av.get(0).getOwnerName() + "',";
		}
		if (av.get(0).getOwnerCountry() != null || av.get(0).getOwnerCountry() != "") {
			s = s + "@p_OwnerCountry='" + av.get(0).getOwnerCountry() + "',";
		}
		if (av.get(0).getOwnerState() != null || av.get(0).getOwnerState() != "") {
			s = s + "@p_OwnerState='" + av.get(0).getOwnerState() + "',";
		}
		if (av.get(0).getOwnerCity() != null || av.get(0).getOwnerCity() != "") {
			s = s + "@p_OwnerCity='" + av.get(0).getOwnerCity() + "',";
		}
		if (av.get(0).getOwnerStreet() != null || av.get(0).getOwnerStreet() != "") {
			s = s + "@p_OwnerStreet='" + av.get(0).getOwnerStreet() + "',";
		}
		if (av.get(0).getOwnerPincode() != null || av.get(0).getOwnerPincode() != "") {
			s = s + "@p_OwnerPincode='" + av.get(0).getOwnerPincode() + "',";
		}
		if (av.get(0).getOwnerContact() != null || av.get(0).getOwnerContact() != "") {
			s = s + "@p_OwnerContact='" + av.get(0).getOwnerContact() + "',";
		}
		if (av.get(0).getOwnerEmail() != null || av.get(0).getOwnerEmail() != "") {
			s = s + "@p_OwnerEmail='" + av.get(0).getOwnerEmail() + "',";
		}
		if (av.get(0).getLocationId() != null || av.get(0).getLocationId() != "") {
			s = s + "@p_LocationId='" + av.get(0).getLocationId() + "',";
		}
		if (av.get(0).getType() != null || av.get(0).getType() != "") {
			s = s + "@p_Type='" + av.get(0).getType() + "',";
		}
		if (av.get(0).getCreatedBy() != null || av.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + av.get(0).getCreatedBy() + "',";
		}
		if (av.get(0).getOrganization() != null || av.get(0).getOrganization() != "") {
			s = s + "@p_org='" + av.get(0).getOrganization() + "',";
		}
		if (av.get(0).getOrgDivision() != null || av.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.get(0).getOrgDivision() + "',";
		}

		if (av.get(0).getRentSDate() != null || av.get(0).getRentSDate() != "") {
			s = s + "@p_RentSDate='" + av.get(0).getRentSDate() + "',";
		}
		if (av.get(0).getRentEDate() != null || av.get(0).getRentEDate() != "") {
			s = s + "@p_RentEDate='" + av.get(0).getRentEDate() + "',";
		}
		if (av.get(0).getRentSecDeposit() != null || av.get(0).getRentSecDeposit() != "") {
			s = s + "@p_RentSecDeposit='" + av.get(0).getRentSecDeposit() + "',";
		}
		if (av.get(0).getRentRentPMonth() != null || av.get(0).getRentRentPMonth() != "") {
			s = s + "@p_RentRentPMonth='" + av.get(0).getRentRentPMonth() + "',";
		}
		if (av.get(0).getRentBankName() != null || av.get(0).getRentBankName() != "") {
			s = s + "@p_RentBankName='" + av.get(0).getRentBankName() + "',";
		}
		if (av.get(0).getRentIFSC() != null || av.get(0).getRentIFSC() != "") {
			s = s + "@p_RentIFSC='" + av.get(0).getRentIFSC() + "',";
		}
		if (av.get(0).getRentAcNo() != null || av.get(0).getRentAcNo() != "") {
			s = s + "@p_RentAcNo='" + av.get(0).getRentAcNo() + "',";
		}
		if (av.get(0).getOwnerStatus() != null || av.get(0).getOwnerStatus() != "") {
			s = s + "@p_OwnerStatus='" + av.get(0).getOwnerStatus() + "',";
		}

		for (AssetDocumentRestModel a : av.get(0).getDocumentList()) {
			document = document + "(@p_OwnerId,\"" + a.getDocumnentName() + "\",\""
					+ a.getFileName() + "\",\"" + a.getDocumentURL() + "\",@p_createdBy,@p_org,@p_orgDiv),";
		}
		if(document.length()!=0) {
			document = document.substring(0, document.length() - 1);
		}

		s = s + "@p_documentList='" + document + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	public static String getAddDocsDetails(List<AssetProprtyOwnerRestModel> av) {
		String s = "";
		String document = "";

		if (av.get(0).getOwnerId() != null || av.get(0).getOwnerId() != "") {
			s = s + "@p_OwnerId='" + av.get(0).getOwnerId() + "',";
		}
		if (av.get(0).getCreatedBy() != null || av.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + av.get(0).getCreatedBy() + "',";
		}
		if (av.get(0).getOrganization() != null || av.get(0).getOrganization() != "") {
			s = s + "@p_org='" + av.get(0).getOrganization() + "',";
		}
		if (av.get(0).getOrgDivision() != null || av.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.get(0).getOrgDivision() + "',";
		}

		for (AssetDocumentRestModel a : av.get(0).getDocumentList()) {
			document = document + "(@p_OwnerId,\"" + a.getDocumnentName() + "\",\""
					+ a.getFileName() + "\",\"" + a.getDocumentURL() + "\",@p_createdBy,@p_org,@p_orgDiv),";
		}
		if(document.length()!=0) {
			document = document.substring(0, document.length() - 1);
		}

		s = s + "@p_documentList='" + document + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String saveFloorDetails(LocationRoomModel location) {
String s = "";
		if(location.getDetailId()!=null && location.getDetailId()!="") {
			s = s + "@p_detailId='" + location.getDetailId() + "',";
		}
		if(location.getFloorId()!=null && location.getFloorId()!="") {
			s = s + "@p_FloorId='" + location.getFloorId() + "',";
		}
		if(location.getType()!=null && location.getType()!="") {
			s = s + "@p_type='" + location.getType() + "',";
		}
		if(location.getQuantity()!=null && location.getQuantity()!="") {
			s = s + "@p_qty='" + location.getQuantity() + "',";
		}
		if(location.getCreatedBy()!=null && location.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + location.getCreatedBy() + "',";
		}
		if (location.getOrganization() != null || location.getOrganization() != "") {
			s = s + "@p_org='" + location.getOrganization() + "',";
		}
		if (location.getOrgDivision() != null || location.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + location.getOrgDivision() + "',";
		}
		if(location.getHeight()!=null && location.getHeight()!="") {
			s = s + "@p_height='" + location.getHeight() + "',";
		}
		if(location.getWidth()!=null && location.getWidth()!="") {
			s = s + "@p_width='" + location.getWidth() + "',";
		}
		if(location.getLength()!=null && location.getLength()!="") {
			s = s + "@p_length='" + location.getLength() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("VALUESXX::::"+s);
		return s;
	}
}
