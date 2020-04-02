package GAMS.Crudrepository;

import GAMS.entity.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepo extends CrudRepository<Email, String> {
    Email findById(long id);
    Email findByToField(String to);
    Email findByFromField(String from);

    List<Email> findAllByToField(String to);
    List<Email> findAll();
}
