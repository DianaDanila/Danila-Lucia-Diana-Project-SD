package bll.builder;

import java.util.List;

import bll.dto.AnalysisDTO;
import bll.dto.TypeDTO;

public class AnalysisDTOBuilder {

	private AnalysisDTO a;
	
	public AnalysisDTOBuilder() {
		this.a = new AnalysisDTO();
	}
	
	public AnalysisDTOBuilder name(String name) {
		this.a.setName(name);
		return this;
	}
	
	public AnalysisDTOBuilder result(String result) {
		this.a.setResult(result);
		return this;
	}
	
	public AnalysisDTOBuilder pacient(String pacient) {
		this.a.setPacient(pacient);
		return this;
	}
	
	public AnalysisDTOBuilder doctor(String doctor) {
		this.a.setDoctor(doctor);
		return this;
	}
	
	public AnalysisDTOBuilder types(List<TypeDTO> types) {
		this.a.setTypes(types);
		return this;
	}
	
	public AnalysisDTO build() {
		return this.a;
	}
}
