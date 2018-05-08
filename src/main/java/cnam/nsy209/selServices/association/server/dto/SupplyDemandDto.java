package cnam.nsy209.selServices.association.server.dto;

import java.io.Serializable;

import com.squareup.moshi.Json;

public class SupplyDemandDto implements Serializable {

	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;

	@Json(name = "id")
	private Long id;

	@Json(name = "type")
	private String type;

	@Json(name = "category")
	private String category;

	@Json(name = "title")
	private String title;

	@Json(name = "member")
	private MemberDto member;


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

	public MemberDto getMember() {
		return member;
	}

	public void setMember(MemberDto member) {
		this.member = member;
	}
	
	public void copy(SupplyDemandDto supplyDemand) {
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
