package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

        userDaoJDBC.createUsersTable();


        userDaoJDBC.saveUser("Chuck", "Norris", (byte) 45);
        userDaoJDBC.saveUser("Jack", "Sparrow", (byte) 30);
        userDaoJDBC.saveUser("Bruce", "Lee", (byte) 45);
        userDaoJDBC.saveUser("Janclod", "Vandam", (byte) 30);

       List <User> users = userDaoJDBC.getAllUsers();

        for (User u : users) {
            System.out.println(u);
        }
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
    }
}