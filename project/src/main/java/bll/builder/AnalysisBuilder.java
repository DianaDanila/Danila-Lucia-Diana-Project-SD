package bll.builder;

import java.util.List;

import dal.model.Analysis;
import dal.model.Doctor;
import dal.model.Pacient;
import dal.model.Type;

public class AnalysisBuilder {

	private Analysis a;
	
	public AnalysisBuilder() {
		this.a = new Analysis();
	}
	
	public AnalysisBuilder name(String name) {
		this.a.setName(name);
		return this;
	}
	
	public AnalysisBuilder result(String result) {
		this.a.setResult(result);
		return this;
	}
	
	public AnalysisBuilder pacient(Pacient pacient) {
		this.a.setPacient(pacient);
		return this;
	}
	
	public AnalysisBuilder doctor(Doctor doctor) {
		this.a.setDoctor(doctor);
		return this;
	}
	
	public AnalysisBuilder types(List<Type> types) {
		this.a.setTypes(types);
		return this;
	}
	
	public Analysis build() {
		return this.a;
	}
}
