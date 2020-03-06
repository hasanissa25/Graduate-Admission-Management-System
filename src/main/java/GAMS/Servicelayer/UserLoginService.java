package GAMS.Servicelayer;

import GAMS.Crudrepository.EndUserRepo;
import GAMS.entity.EndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//This is required by springboot to authenticate username and password for loging in
@Service
public class UserLoginService implements UserService {

    @Autowired
    private EndUserRepo userRepository;

    @Override
    public boolean authenticate(String username, String password) {
        // check username and password
         EndUser user = userRepository.findByUsername(username);
         if(user == null){
             return false;
         }
         String u_name = user.getUsername();
         String pass = user.getPassword();
         return u_name.equals(username) && pass.equals(password);
    }

}
