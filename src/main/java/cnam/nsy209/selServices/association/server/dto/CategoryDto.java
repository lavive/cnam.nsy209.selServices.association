package cnam.nsy209.selServices.association.server.dto;

import java.io.Serializable;

import com.squareup.moshi.Json;

public class CategoryDto implements Serializable {

	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;

	@Json(name ="id")
	private Long id;

	@Json(name ="name")
	private String name;

	
	/* getter and setter */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return getName();
	}


}
