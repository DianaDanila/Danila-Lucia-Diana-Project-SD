package bll;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bll.builder.AnalysisBuilder;
import bll.builder.AnalysisDTOBuilder;
import bll.dto.AnalysisDTO;
import bll.dto.TypeDTO;
import dal.model.Analysis;
import dal.repositories.AnalysisRepository;
import dal.repositories.DoctorRepository;
import dal.repositories.PacientRepository;
import dal.repositories.TypeRepository;

@Service
public class AnalysisBLL {
	
	@Autowired // not null
	private AnalysisRepository arepo;
	
	@Autowired // not null
	private DoctorRepository drepo;
	
	@Autowired // not null
	private PacientRepository prepo;
	
	@Autowired // not null
	private TypeRepository trepo;
	
	public AnalysisDTO getById(int id) {
		Analysis a = arepo.findById(id).get();
		AnalysisDTO dto = new AnalysisDTOBuilder()
				.name(a.getName())
				.result(a.getResult())
				.pacient(a.getPacient().getName())
				.doctor(a.getDoctor().getName())
				.types(a.getTypes().stream().map(TypeDTO::new).collect(Collectors.toList()))
				.build();
		return dto;
	}
	
	public void insert(AnalysisDTO a) {
		//Analysis an = arepo.findById(a.getId()).get();;
		Analysis an = new AnalysisBuilder()
				.name(a.getName())
				.result(a.getResult())
				.pacient(prepo.findByName(a.getPacient()))
				.doctor(drepo.findByName(a.getDoctor()))
				.types(a.getTypes().stream().map(t -> 
					trepo.findByType(t.getType())
				).collect(Collectors.toList()))
				.build();
		arepo.save(an);
	}
//	
//	public void update(String name, DoctorDTO d) {
//		Doctor old = drepo.findByName(name);
//		old.setAddress(d.getAddress());
//		old.setEmail(d.getEmail());
//		old.setPassword(d.getPassword());
//		old.setTelephone(d.getTelephone());
//		drepo.save(old);
//	}
//	
//	public void delete(Doctor d) {
//		Doctor doctor = drepo.findByName(d.getName());
//		drepo.delete(doctor);
//	}
	
	public List<AnalysisDTO> findAll(){
		return arepo.findAll().stream().map(AnalysisDTO::new).collect(Collectors.toList());
	}
}
