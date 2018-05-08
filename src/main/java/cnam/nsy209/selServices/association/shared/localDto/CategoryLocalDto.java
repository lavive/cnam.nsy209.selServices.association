package cnam.nsy209.selServices.association.shared.localDto;

import java.io.Serializable;

public class CategoryLocalDto implements Serializable {

	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

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
