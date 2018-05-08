package cnam.nsy209.selServices.association.server.dto;

import java.util.ArrayList;
import java.util.List;

import com.squareup.moshi.Json;

public class MemberDto extends PersonDto{


	private static final long serialVersionUID = 1L;

	@Json(name ="forname")
	private String forname;

	@Json(name ="mobileId")
	private String mobileId;

	@Json(name ="supplyDemandIds")
	private List<Long> supplyDemandIds = new ArrayList<Long>();

	@Json(name ="wealthSheet")
	private WealthSheetDto wealthSheet;

	

	/* getter and setter */

	public String getForname() {
		return forname;
	}

	public void setForname(String forname) {
		this.forname = forname;
	}

	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	public WealthSheetDto getWealthSheet() {
		return wealthSheet;
	}

	public void setWealthSheet(WealthSheetDto wealthSheet) {
		this.wealthSheet = wealthSheet;
	}

	public List<Long> getSupplyDemandIds() {
		return supplyDemandIds;
	}

	public void setSupplyDemandIds(List<Long> supplyDemandIds) {
		this.supplyDemandIds = supplyDemandIds;
	}
	
	public String getFullName() {
		return getName()+"_"+getForname()+"_"+getTown()+"_"+getId();
	}
	
	public void copy(MemberDto memberDto) {
		super.copy(memberDto);
		setForname(memberDto.getForname());
		setMobileId(memberDto.getMobileId());
		setSupplyDemandIds(memberDto.getSupplyDemandIds());
		setWealthSheet(memberDto.getWealthSheet());
	}



	@Override
	public String toString() {
		return getId()+": "+getName()+" "+getForname()+" "+getAddress()+" "+getPostalCode()+" "+getTown()+" "+getCellNumber()+" "+
				getPhoneNumber()+" "+getEmail();
	}
	
	/* helper method */
	
//	public static MemberDto getByFullName(long idToFind,List<MemberDto> members) {
//		for(MemberDto member:members) {
//			String[] name = member.getFullName().split("_");
//			long id = Long.parseLong(name[name.length-1]);
//			if(idToFind == id)
//				return member;
//		}
//		return null;
//	}
	
	public static long getIdByFullName(String fullName) {
		String[] name = fullName.split("_");
		return Long.parseLong(name[name.length-1]);
	}


}
