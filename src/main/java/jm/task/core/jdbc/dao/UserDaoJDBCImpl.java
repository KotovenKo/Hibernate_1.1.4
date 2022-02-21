package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            // TABLE CREATION
            statement.execute("CREATE TABLE IF NOT EXISTS katausers (id BIGINT NOT NULL AUTO_INCREMENT, " +
                    "name VARCHAR(40) NOT NULL , " +
                    "lastName VARCHAR(40) NOT NULL , " +
                    "age SMALLINT NOT NULL , " +
                    "PRIMARY KEY (id))");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Ошибка создания таблицы");
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.execute("DROP TABLE IF EXISTS katausers");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Ошибка удаления таблицы");
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {

        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement("insert into katausers (name, lastName, age) values (?,?,?)")) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.execute();
            System.out.printf("User с именем %s добавлен в базу данных\n", name);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Ошибка добавления Юзера в БД");
            e.printStackTrace();
        }

/*        try {
            Statement statement = Util.getConnection().createStatement();
            statement.execute("INSERT INTO katausers (name, secondName, age) VALUES ('"+name+"', '"+lastName+"', '"+age+"')");
            System.out.printf("User с именем %s добавлен в базу данных\n", name);
        } catch (SQLException e) {
            System.out.println("Ошибка удаления таблицы");
        }*/

    }


    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement("delete from katausers where id = ?")) {
            preparedStatement.setLong(1, id);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Ошибка удаления юзера по ID");
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Statement statement = Util.getConnection().createStatement()) {
            ResultSet resultSettoList = statement.executeQuery("select * from katausers");
            while (resultSettoList.next()) {
                User user = new User();
                user.setId(resultSettoList.getLong("ID"));
                user.setName(resultSettoList.getString("name"));
                user.setLastName(resultSettoList.getString("lastName"));
                user.setAge(resultSettoList.getByte("age"));
                userList.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Ошибка сохранения всех Юзеров");
            e.printStackTrace();
        }
        return userList;

    }

    public void cleanUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            // TABLE CREATION
            statement.execute("TRUNCATE TABLE katausers");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Ошибка очистки таблицы");
            e.printStackTrace();
        }

    }
}
