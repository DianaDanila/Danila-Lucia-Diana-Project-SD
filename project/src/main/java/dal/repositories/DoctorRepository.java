package dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dal.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{//class, id type

	Doctor findByNameAndPassword(String name, String password);
	
	Doctor findByName(String name);
	
}
