package GAMS.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Student extends EndUser implements Serializable {


    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String email;
    private String cv;
    private String diploma;
    private String gradeAudit;

    public Student() {
        super();
        setRole(Role.STUDENT);
    }

    public Student(String emailAddress,String username, String password, String confPassword) {
        super(emailAddress,username, password, confPassword, Role.STUDENT);
    }

    public Student(String emailAddress,String username, String password, String confPassword, String email,
                   String cv, String diploma, String gradeAudit) {
        super(emailAddress,username, password, confPassword, Role.STUDENT);
        this.email = email;
        this.cv = cv;
        this.diploma = diploma;
        this.gradeAudit = gradeAudit;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setGradeAudit(String gradeAudit) {
        this.gradeAudit = gradeAudit;
    }

    public String getGradeAudit() {
        return gradeAudit;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getCv() {
        return cv;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
