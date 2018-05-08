package cnam.nsy209.selServices.association.server.dto;

import java.io.Serializable;

import com.squareup.moshi.Json;

public class MessageDto implements Serializable {

	/**
	 * For checking version
	 */
	private static final long serialVersionUID = 1L;
	
	@Json(name ="id")
	private Long id;

	@Json(name ="title")
	private String title;

	@Json(name ="text")
	private String text;

	@Json(name ="emitterPerson")
	private PersonDto emitterPerson;
	
	
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

	public PersonDto getEmitterPerson() {
		return emitterPerson;
	}

	public void setEmitterPerson(PersonDto emitterPerson) {
		this.emitterPerson = emitterPerson;
	}
	
	

}
