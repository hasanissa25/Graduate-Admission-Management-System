package GAMS.entity;

public class Administrator extends EndUser {


    public Administrator(String emailAddress,String username, String password, String confPassword) {
        super(emailAddress,username, password, confPassword, Role.ADMINISTRATOR);

    }

   }
