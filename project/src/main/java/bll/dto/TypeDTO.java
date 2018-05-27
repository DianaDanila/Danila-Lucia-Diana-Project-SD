package bll.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dal.model.Type;

public class TypeDTO {

	private String type;
	
	//private List<String> analysis;
	
	@JsonCreator
	public TypeDTO(@JsonProperty(value = "type") String type) {
		this.type = type;
		//this.analysis = a;
	}
	
	public TypeDTO() {
		super();
	}

	public TypeDTO(Type t) {
		this.type = t.getType();
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public List<AnalysisDTO> getAnalysis() {
//		return analysis;
//	}
//
//	public void setAnalysis(List<AnalysisDTO> analysis) {
//		this.analysis = analysis;
//	}

	@Override
	public String toString() {
		return "Type [type=" + type + "]";
	}
	
	
}
