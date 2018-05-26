package bll.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dal.model.Doctor;

public class DoctorDTO {

	private String name;

	private String password;
	
	private String address;

	private String telephone;
	
	private String email;
	
	private List<AnalysisDTO> analysis;
	
	@JsonCreator
	public DoctorDTO(@JsonProperty(value = "name") String n, @JsonProperty(value = "password") String p,
			@JsonProperty(value = "address") String a, @JsonProperty(value = "telephone") String t, @JsonProperty(value = "email") String e, @JsonProperty(value = "analysis") List<AnalysisDTO> an) {
		this.name = n;
		this.password = p;
		this.address = a;
		this.telephone = t;
		this.email = e;
		this.analysis = an;
	}
	
	public DoctorDTO(Doctor d) {
		this.name = d.getName();
		this.password = d.getPassword();
		this.address = d.getAddress();
		this.telephone = d.getTelephone();
		this.email = d.getEmail();
		this.analysis = d.getAnalysis().stream().map(AnalysisDTO::new).collect(Collectors.toList());
	}

	public DoctorDTO() {
		super();
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

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", address=" + address + ", telephone="
				+ telephone + ", email=" + email + ", analysis=" + analysis + "]";
	}
	
	
}
