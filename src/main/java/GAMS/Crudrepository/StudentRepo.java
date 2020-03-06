package GAMS.Crudrepository;

import GAMS.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, String > {
    Student findByUsername(String username);
}
