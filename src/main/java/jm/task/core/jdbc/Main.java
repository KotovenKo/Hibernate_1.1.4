package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Chuck", "Norris", (byte) 45);
        userDaoJDBC.saveUser("Jack", "Sparrow", (byte) 30);
        userDaoJDBC.saveUser("Bruce", "Lee", (byte) 45);
        userDaoJDBC.saveUser("Janclod", "Vandam", (byte) 30);
        List<User> user = userDaoJDBC.getAllUsers();
        for (User u : user) {
            System.out.println(u);
        }
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
    }
}