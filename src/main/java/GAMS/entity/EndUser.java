package GAMS.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class EndUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public enum Role {
        STUDENT, PROFESSOR, ADMINISTRATOR
    }

    private Role role;

    private String confPassword;

    public EndUser(){}

    public EndUser(String username, String password, String confPassword, String email, Role role) {
        this.username = username;
        this.password = password;
        this.confPassword = confPassword;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public String getRoleValue(){

        switch(role) {
            case STUDENT:
                return "STUDENT";
            case PROFESSOR:
                return "PROFESSOR";
            case ADMINISTRATOR:
                return "ADMINISTRATOR";
        }
        return role.name();
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String pw){
        this.confPassword = pw;
    }
}
