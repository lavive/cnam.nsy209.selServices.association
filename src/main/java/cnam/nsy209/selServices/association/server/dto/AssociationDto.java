package cnam.nsy209.selServices.association.server.dto;

import com.squareup.moshi.Json;

public class AssociationDto extends PersonDto {

	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;
	

	@Json(name ="website")
	private String website;

	

	/* getter and setter */

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
