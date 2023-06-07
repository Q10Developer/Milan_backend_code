package com.app.user.dto.response;

public class GenericResponseDTO {

	private String id;

	public GenericResponseDTO() {

	}

	public GenericResponseDTO(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GenericResponseDTO [id=" + id + "]";
	}

}
