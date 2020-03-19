package GAMS.entity;

public class Administrator extends EndUser {


    public Administrator(String username, String password, String confPassword, String email) {
        super(username, password, confPassword, email, Role.ADMINISTRATOR);

    }

   }
