package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Alen", "Delon" , (byte)56);
        userService.saveUser("Brad", "Pitt" , (byte)34);
        userService.saveUser("Silvester", "Stallone" , (byte)45);
        userService.saveUser("Arnold", "Schwarzenegger" , (byte)25);
        List<User> user = userService.getAllUsers();
        for(User u : user){
            System.out.println(u);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
        }

}
