package cnam.nsy209.selServices.association.shared.localDto;

public class PersonLocalDto extends LocalDto {
	
	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String address;

	private String postalCode;

	private String town;

	private String email;

	private String cellNumber;

	private String phoneNumber;

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
	
	public void copy(PersonLocalDto personDto) {
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
