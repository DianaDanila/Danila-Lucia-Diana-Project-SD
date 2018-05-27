package bll.builder;

import java.util.List;

import dal.model.Analysis;
import dal.model.Type;

public class TypeBuilder {

	private Type t;

	public TypeBuilder() {
		this.t = new Type();
	}
	
	public TypeBuilder type(String type) {
		this.t.setType(type);
		return this;
	}
	
	public TypeBuilder analysis(List<Analysis> analysis) {
		this.t.setAnalysis(analysis);
		return this;
	}
	
	public Type build() {
		return this.t;
	}
}
