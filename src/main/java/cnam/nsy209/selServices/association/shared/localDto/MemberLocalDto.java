package cnam.nsy209.selServices.association.shared.localDto;

import java.util.ArrayList;
import java.util.List;

public class MemberLocalDto extends PersonLocalDto{


	private static final long serialVersionUID = 1L;

	private String forname;

	private String mobileId;

	private List<Long> supplyDemandIds = new ArrayList<Long>();

	private WealthSheetLocalDto wealthSheet;

	

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

	public WealthSheetLocalDto getWealthSheet() {
		return wealthSheet;
	}

	public void setWealthSheet(WealthSheetLocalDto wealthSheet) {
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
	
	public void copy(MemberLocalDto memberDto) {
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
	
	public static long getIdByFullName(String fullName) {
		String[] name = fullName.split("_");
		return Long.parseLong(name[name.length-1]);
	}


}
