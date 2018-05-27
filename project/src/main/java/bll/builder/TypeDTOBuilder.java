package bll.builder;

import bll.dto.TypeDTO;

public class TypeDTOBuilder {

	private TypeDTO t;

	public TypeDTOBuilder() {
		this.t = new TypeDTO();
	}
	
	public TypeDTOBuilder type(String type) {
		this.t.setType(type);
		return this;
	}
	
	public TypeDTO build() {
		return this.t;
	}
}
