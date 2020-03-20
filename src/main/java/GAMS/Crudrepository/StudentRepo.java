package GAMS.Crudrepository;

import GAMS.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//This is how we interface with the database and do our object relational mapping
@Repository
public interface StudentRepo extends CrudRepository<Student, String > {
    //this is for when are going to delete/update using the id
    Student findById(long id);
    Student findByUsername(String username);

}