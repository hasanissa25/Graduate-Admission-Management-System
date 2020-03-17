package GAMS.Crudrepository;

import GAMS.entity.FieldOfResearch;
import GAMS.entity.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FieldOfResearchRepo extends CrudRepository<FieldOfResearch, String> {
    FieldOfResearch findById(long id);
    FieldOfResearch findByName(String name);
    FieldOfResearch findByProfessor(Professor professor);
}