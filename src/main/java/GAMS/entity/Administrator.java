package GAMS.entity;

public class Administrator extends EndUser {


    public Administrator(String username, String password, String confPassword) {
        super(username, password, confPassword, Role.ADMINISTRATOR);

    }

   }
