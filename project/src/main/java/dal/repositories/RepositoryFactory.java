package dal.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RepositoryFactory {

	@Autowired
	PacientRepository prepo;

	@Autowired
	DoctorRepository drepo;

	public JpaRepository getRepository(String type) throws Exception {

		switch (type) {
		case "Pacient":
			return prepo;
		case "Doctor":
			return drepo;
		default:
			throw new Exception("Unkown Repository Required");
		}

	}
}
