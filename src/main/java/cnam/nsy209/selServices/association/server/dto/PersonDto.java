package cnam.nsy209.selServices.association.server.dto;

import com.squareup.moshi.Json;

public class PersonDto extends Dto {
	
	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;

	@Json(name ="name")
	private String name;

	@Json(name ="address")
	private String address;

	@Json(name ="postalCode")
	private String postalCode;

	@Json(name ="town")
	private String town;

	@Json(name ="email")
	private String email;

	@Json(name ="cellNumber")
	private String cellNumber;

	@Json(name ="phoneNumber")
	private String phoneNumber;

	@Json(name ="password")
	private String password;
	
	
	/* getter and setter */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void copy(PersonDto personDto) {
		super.copy(personDto);
		setName(personDto.getName());
		setAddress(personDto.getAddress());
		setPostalCode(personDto.getPostalCode());
		setTown(personDto.getTown());
		setEmail(personDto.getEmail());
		setPhoneNumber(personDto.getPhoneNumber());
		setCellNumber(personDto.getCellNumber());
		setPassword(personDto.getPassword());
	}
	
}
