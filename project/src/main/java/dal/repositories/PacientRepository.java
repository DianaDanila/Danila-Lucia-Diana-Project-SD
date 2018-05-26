package dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dal.model.Pacient;

public interface PacientRepository extends JpaRepository<Pacient, Integer>{

	Pacient findByNameAndPassword(String name, String password);
	
	Pacient findByName(String name);
}
