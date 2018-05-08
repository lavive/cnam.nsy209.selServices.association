package cnam.nsy209.selServices.association.server.dto;

import java.io.Serializable;

import com.squareup.moshi.Json;

public class Dto implements Serializable {
	
	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;

	@Json(name ="id")
	private Long id;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}	

	public void copy(Dto dto) {
		setId(dto.getId());		
	}

}
