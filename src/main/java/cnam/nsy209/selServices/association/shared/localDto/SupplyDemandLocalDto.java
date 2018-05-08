package cnam.nsy209.selServices.association.shared.localDto;

import java.io.Serializable;

public class SupplyDemandLocalDto implements Serializable {

	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String type;

	private String category;

	private String title;

	private MemberLocalDto member;


	/* getter and setter */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MemberLocalDto getMember() {
		return member;
	}

	public void setMember(MemberLocalDto member) {
		this.member = member;
	}
	
	public void copy(SupplyDemandLocalDto supplyDemand) {
		setId(supplyDemand.getId());
		setType(supplyDemand.getType());
		setCategory(supplyDemand.getCategory());
		setTitle(supplyDemand.getTitle());
		setMember(supplyDemand.getMember());
	}

	@Override
	public String toString() {
		return getType()+" "+getCategory()+" "+getTitle();
	}
	
	/* helper method */
	
	public static long getIdByFullName(String fullName) {
		String[] name = fullName.split("_");
		return Long.parseLong(name[name.length-1]);
	}
	
}
