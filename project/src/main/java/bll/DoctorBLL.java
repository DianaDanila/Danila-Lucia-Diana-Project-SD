package bll;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bll.builder.DoctorDTOBuilder;
import bll.dto.AnalysisDTO;
import bll.dto.DoctorDTO;
import dal.model.Doctor;
import dal.repositories.DoctorRepository;

@Service
public class DoctorBLL {

	@Autowired // not null
	private DoctorRepository drepo;

	public DoctorDTO getById(int id) {
		Doctor d = drepo.findById(id).get();
		DoctorDTO dto = new DoctorDTOBuilder()
				.name(d.getName())
				.password(d.getPassword())
				.email(d.getEmail())
				.address(d.getAddress())
				.analysis(d.getAnalysis().stream().map(AnalysisDTO::new).collect(Collectors.toList()))
				.telephone(d.getTelephone())
				.build();
		return dto;
	}

	public boolean login(String name, String pass) {
		Doctor d = drepo.findByNameAndPassword(name, pass);
		if (d == null) {
			return false;
		}
		return true;
	}
	
	public void insert(DoctorDTO d) {
		Doctor doctor = drepo.findByName(d.getName());
		drepo.save(doctor);
	}
	
	public void update(String name, DoctorDTO d) {
		Doctor old = drepo.findByName(name);
		old.setAddress(d.getAddress());
		old.setEmail(d.getEmail());
		old.setPassword(d.getPassword());
		old.setTelephone(d.getTelephone());
		drepo.save(old);
	}
	
	public void delete(Doctor d) {
		Doctor doctor = drepo.findByName(d.getName());
		drepo.delete(doctor);
	}
	
	public List<DoctorDTO> findAll(){
		return drepo.findAll().stream().map(DoctorDTO::new).collect(Collectors.toList());
	}
}
