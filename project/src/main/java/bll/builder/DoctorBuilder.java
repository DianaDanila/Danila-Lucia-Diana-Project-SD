package bll.builder;

import java.util.List;

import dal.model.Analysis;
import dal.model.Doctor;

public class DoctorBuilder {

	private Doctor doctor;
	
	public DoctorBuilder() {
		this.doctor = new Doctor();
	}
	
	public DoctorBuilder name(String name) {
		this.doctor.setName(name);
		return this;
	}
	
	public DoctorBuilder password(String pass) {
		this.doctor.setPassword(pass);
		return this;
	}
	
	public DoctorBuilder address(String address) {
		this.doctor.setAddress(address);
		return this;
	}
	
	public DoctorBuilder telephone(String telephone) {
		this.doctor.setTelephone(telephone);
		return this;
	}
	
	public DoctorBuilder email(String email) {
		this.doctor.setEmail(email);
		return this;
	}
	
	public DoctorBuilder analysis(List<Analysis> a) {
		this.doctor.setAnalysis(a);
		return this;
	}
	
	public Doctor build() {
		return this.doctor;
	}
}
