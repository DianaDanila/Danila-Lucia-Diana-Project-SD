package dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dal.model.Type;

public interface TypeRepository extends JpaRepository<Type, Integer>{

	
	Type findByType(String type);
}
