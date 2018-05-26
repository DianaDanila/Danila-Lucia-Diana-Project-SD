package bll.builder;

import java.util.List;

import bll.dto.AnalysisDTO;
import bll.dto.PacientDTO;

public class PacientDTOBuilder {

	
	private PacientDTO pacient;
	
	public PacientDTOBuilder () {
		this.pacient = new PacientDTO();
	}
	
	public PacientDTOBuilder name(String name) {
		this.pacient.setName(name);
		return this;
	}
	
	public PacientDTOBuilder password(String pass) {
		this.pacient.setPassword(pass);
		return this;
	}
	
	public PacientDTOBuilder address(String address) {
		this.pacient.setAddress(address);
		return this;
	}
	
	public PacientDTOBuilder telephone(String telephone) {
		this.pacient.setTelephone(telephone);
		return this;
	}
	
	public PacientDTOBuilder email(String email) {
		this.pacient.setEmail(email);
		return this;
	}
	
	public PacientDTOBuilder analysis(List<AnalysisDTO> a) {
		this.pacient.setAnalysis(a);
		return this;
	}
	
	public PacientDTO build() {
		return this.pacient;
	}
}
