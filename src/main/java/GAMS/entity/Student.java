package GAMS.entity;

import java.io.Serializable;

public class Student extends EndUser implements Serializable {

    public Student(String username, String password, String confPassword) {
        super(username, password, confPassword, Role.STUDENT);

    }


}
