package dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dal.model.Analysis;

public interface AnalysisRepository extends JpaRepository<Analysis, Integer>{//class, id type{

}
