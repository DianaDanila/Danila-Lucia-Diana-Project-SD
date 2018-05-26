package bll.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dal.model.Analysis;

public class AnalysisDTO {
	
	private String name;

	private String result;
	
	private String pacient;
	
	private String doctor;
	
	private List<TypeDTO> types;
	
	@JsonCreator
	public AnalysisDTO(@JsonProperty(value = "name") String n, @JsonProperty(value = "result") String result,
			@JsonProperty(value = "pacient") String p, @JsonProperty(value = "doctor") String d, @JsonProperty(value = "types") List<TypeDTO> types) {
		this.name = n;
		this.result = result;
		this.pacient = p;
		this.doctor = d;
		this.types = types;
	}
	
	public AnalysisDTO(Analysis a) {
		this.name = a.getName();
		this.result = a.getResult();
		this.pacient = a.getPacient().getName();
		this.doctor = a.getDoctor().getName();
		this.types = a.getTypes().stream().map(TypeDTO::new).collect(Collectors.toList());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPacient() {
		return pacient;
	}

	public void setPacient(String pacient) {
		this.pacient = pacient;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public List<TypeDTO> getTypes() {
		return types;
	}

	public void setTypes(List<TypeDTO> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Analysis [name=" + name + ", result=" + result + ", pacient=" + pacient + ", doctor=" + doctor
				+ ", types=" + types + "]";
	}
	
	
}
