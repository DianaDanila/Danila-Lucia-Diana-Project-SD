package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bll.builder.DoctorBuilder;
import bll.builder.DoctorDTOBuilder;
import bll.dto.AnalysisDTO;
import bll.dto.DoctorDTO;
import dal.model.Analysis;
import dal.model.Doctor;
import dal.repositories.DoctorRepository;
import dal.repositories.RepositoryFactory;

@Service
public class DoctorBLL {

	@Autowired // not null
	private RepositoryFactory rrepo;

	public DoctorDTO getById(int id) {
		DoctorRepository drepo = (DoctorRepository) rrepo.getRepository("Doctor");
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
	
	public DoctorDTO getByName(String name) {
		DoctorRepository drepo = (DoctorRepository) rrepo.getRepository("Doctor");
		Doctor d = drepo.findByName(name);
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
		DoctorRepository drepo = (DoctorRepository) rrepo.getRepository("Doctor");
		Doctor d = drepo.findByNameAndPassword(name, pass);
		if (d == null) {
			return false;
		}
		return true;
	}
	
	public void insert(DoctorDTO d) {
		DoctorRepository drepo = (DoctorRepository) rrepo.getRepository("Doctor");
		//Doctor doctor = drepo.findByName(d.getName());
		Doctor doctor = new DoctorBuilder()
				.name(d.getName())
				.password(d.getPassword())
				.email(d.getEmail())
				.address(d.getAddress())
				.analysis(new ArrayList<Analysis>())
				.telephone(d.getTelephone())
				.build();
		drepo.save(doctor);
	}
	
	public void update(String name, DoctorDTO d) {
		DoctorRepository drepo = (DoctorRepository) rrepo.getRepository("Doctor");
		Doctor old = drepo.findByName(name);
		old.setAddress(d.getAddress());
		old.setEmail(d.getEmail());
		old.setPassword(d.getPassword());
		old.setTelephone(d.getTelephone());
		drepo.save(old);
	}
	
	public void delete(Doctor d) {
		DoctorRepository drepo = (DoctorRepository) rrepo.getRepository("Doctor");
		Doctor doctor = drepo.findByName(d.getName());
		drepo.delete(doctor);
	}
	
	public List<DoctorDTO> findAll(){
		DoctorRepository drepo = (DoctorRepository) rrepo.getRepository("Doctor");
		return drepo.findAll().stream().map(DoctorDTO::new).collect(Collectors.toList());
	}
}
