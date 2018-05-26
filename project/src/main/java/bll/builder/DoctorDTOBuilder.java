package bll.builder;

import java.util.List;

import bll.dto.AnalysisDTO;
import bll.dto.DoctorDTO;

public class DoctorDTOBuilder {
	
	private DoctorDTO doctor;
	
	public DoctorDTOBuilder() {
		this.doctor = new DoctorDTO();
	}
	
	public DoctorDTOBuilder name(String name) {
		this.doctor.setName(name);
		return this;
	}
	
	public DoctorDTOBuilder password(String pass) {
		this.doctor.setPassword(pass);
		return this;
	}
	
	public DoctorDTOBuilder address(String address) {
		this.doctor.setAddress(address);
		return this;
	}
	
	public DoctorDTOBuilder telephone(String telephone) {
		this.doctor.setTelephone(telephone);
		return this;
	}
	
	public DoctorDTOBuilder email(String email) {
		this.doctor.setEmail(email);
		return this;
	}
	
	public DoctorDTOBuilder analysis(List<AnalysisDTO> a) {
		this.doctor.setAnalysis(a);
		return this;
	}
	
	public DoctorDTO build() {
		return this.doctor;
	}
}
