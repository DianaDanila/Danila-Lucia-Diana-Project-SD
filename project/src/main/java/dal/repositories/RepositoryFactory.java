package dal.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RepositoryFactory {

	
	@Autowired
	AnalysisRepository arepo;
	
	@Autowired
	DoctorRepository drepo;
	
	@Autowired
	PacientRepository prepo;
	
	@Autowired
	TypeRepository trepo;
	
	public JpaRepository getRepository(String type) {
		switch (type) {
		case "Analysis":
			return arepo;
		case "Doctor":
			return drepo;
		case "Pacient":
			return prepo;
		case "Type":
			return trepo;
		default:
			throw new IllegalArgumentException("Invalid repository");
	}
	}
}
