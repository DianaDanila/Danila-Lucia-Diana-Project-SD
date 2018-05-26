package bll.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dal.model.Pacient;

public class PacientDTO {
	
	private String name;

	private String password;
	
	private String address;

	private String telephone;
	
	private String email;
	
	private List<AnalysisDTO> analysis;
	
	@JsonCreator
	public PacientDTO(@JsonProperty(value = "name") String n, @JsonProperty(value = "password") String p,
			@JsonProperty(value = "address") String a, @JsonProperty(value = "telephone") String t, @JsonProperty(value = "email") String e, @JsonProperty(value = "analysis") List<AnalysisDTO> an) {
		this.name = n;
		this.password = p;
		this.address = a;
		this.telephone = t;
		this.email = e;
		this.analysis = an;
	}
	
	public PacientDTO(Pacient p) {
		this.name = p.getName();
		this.password = p.getPassword();
		this.address = p.getAddress();
		this.telephone = p.getTelephone();
		this.email = p.getEmail();
		this.analysis = p.getAnalysis().stream().map(AnalysisDTO::new).collect(Collectors.toList());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AnalysisDTO> getAnalysis() {
		return analysis;
	}

	public void setAnalysis(List<AnalysisDTO> analysis) {
		this.analysis = analysis;
	}
	
	public void addAnalysisDTO(AnalysisDTO a) {
		this.analysis.add(a);
	}

	public PacientDTO() {
		super();
	}

	@Override
	public String toString() {
		return "Pacient [name=" + name + ", address=" + address + ", telephone="
				+ telephone + ", email=" + email + ", analysis=" + analysis + "]";
	}
	
	
}
