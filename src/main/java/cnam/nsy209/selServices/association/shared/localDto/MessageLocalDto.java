package cnam.nsy209.selServices.association.shared.localDto;

import java.io.Serializable;

public class MessageLocalDto implements Serializable {

	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String title;
	
	private String text;
	
	private PersonLocalDto emitterPerson;
	
	
	
	/* getters and setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public PersonLocalDto getEmitterPerson() {
		return emitterPerson;
	}

	public void setEmitterPerson(PersonLocalDto emitterPerson) {
		this.emitterPerson = emitterPerson;
	}
	
	

}
