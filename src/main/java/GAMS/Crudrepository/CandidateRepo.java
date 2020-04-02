package GAMS.Crudrepository;

import GAMS.entity.Candidate;
import GAMS.entity.EndUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//This is how we interface with the database and do our object relational mapping
@Repository
public interface CandidateRepo extends CrudRepository<Candidate, Long > {
}
