package com.app.user.dto.response;

public class GenericResponseDTO {

	private Long id;

	public GenericResponseDTO() {

	}

	public GenericResponseDTO(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GenericResponseDTO [id=" + id + "]";
	}

}
