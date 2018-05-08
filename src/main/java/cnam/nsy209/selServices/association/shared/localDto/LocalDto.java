package cnam.nsy209.selServices.association.shared.localDto;

import java.io.Serializable;

public class LocalDto implements Serializable {
	
	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}	

	public void copy(LocalDto dto) {
		setId(dto.getId());		
	}

}
