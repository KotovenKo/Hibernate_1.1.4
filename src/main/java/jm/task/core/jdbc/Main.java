package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();


        userService.saveUser("Chuck", "Norris", (byte) 45);
        userService.saveUser("Jack", "Sparrow", (byte) 30);
        userService.saveUser("Bruce", "Lee", (byte) 45);
        userService.saveUser("Janclod", "Vandam", (byte) 30);

       List <User> users = userService.getAllUsers();

        for (User u : users) {
            System.out.println(u);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}