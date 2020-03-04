package GAMS.Crudrepository;

import GAMS.entity.EndUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndUserRepo extends CrudRepository<EndUser, String > {
    EndUser findByUsername(String username);
}