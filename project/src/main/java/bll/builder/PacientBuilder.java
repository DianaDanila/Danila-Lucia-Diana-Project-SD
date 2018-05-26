package bll.builder;

import java.util.List;

import dal.model.Analysis;
import dal.model.Pacient;

public class PacientBuilder {

	private Pacient pacient;
	
	public PacientBuilder () {
		this.pacient = new Pacient();
	}
	
	public PacientBuilder name(String name) {
		this.pacient.setName(name);
		return this;
	}
	
	public PacientBuilder password(String pass) {
		this.pacient.setPassword(pass);
		return this;
	}
	
	public PacientBuilder address(String address) {
		this.pacient.setAddress(address);
		return this;
	}
	
	public PacientBuilder telephone(String telephone) {
		this.pacient.setTelephone(telephone);
		return this;
	}
	
	public PacientBuilder email(String email) {
		this.pacient.setEmail(email);
		return this;
	}
	
	public PacientBuilder analysis(List<Analysis> a) {
		this.pacient.setAnalysis(a);
		return this;
	}
	
	public Pacient build() {
		return this.pacient;
	}

}
