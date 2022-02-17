package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        //USER CREATION
        User user1 = new User("Chack", "Norris", (byte) 45);
        User user2 = new User("Jack", "Nicolson", (byte) 50);
        User user3 = new User("Jan", "Vandam", (byte) 55);
        User user4 = new User("Bruce", "Lee", (byte) 45);


        try {
            Statement statement = util.getConnection().createStatement();
            // TABLE CREATION
            statement.execute("CREATE TABLE if not exists katausers (id int not null AUTO_INCREMENT, " +
                    "name varchar(40), " +
                    "secondName varchar(40), " +
                    "age int, " +
                    "primary key (id))");
            statement.execute("insert into katausers (name, secondName, age) values ('" + user1.getName() + "', '" + user1.getLastName() + "', '" + user1.getAge() + "')");
            System.out.printf("User с именем %s добавлен в базу данных\n", user1.getName());
            statement.execute("insert into katausers (name, secondName, age) values ('" + user2.getName() + "', '" + user2.getLastName() + "', '" + user2.getAge() + "')");
            System.out.printf("User с именем %s добавлен в базу данных\n", user2.getName());
            statement.execute("insert into katausers (name, secondName, age) values ('" + user3.getName() + "', '" + user3.getLastName() + "', '" + user3.getAge() + "')");
            System.out.printf("User с именем %s добавлен в базу данных\n", user3.getName());
            statement.execute("insert into katausers (name, secondName, age) values ('" + user4.getName() + "', '" + user4.getLastName() + "', '" + user4.getAge() + "')");
            System.out.printf("User с именем %s добавлен в базу данных\n", user4.getName());

            ResultSet resultSet = statement.executeQuery("select * from katausers");
            while (resultSet.next()) {
               User newUser1 = new User(resultSet.getString("name"), resultSet.getString("secondName"), resultSet.getByte("age"));
                System.out.println(newUser1);
/*               User newUser2 = new User(resultSet.getString("name"), resultSet.getString("secondName"), resultSet.getByte("age"));
                System.out.println(newUser2);
               User newUser3 = new User(resultSet.getString("name"), resultSet.getString("secondName"), resultSet.getByte("age"));
                System.out.println(newUser3);
               User newUser4 = new User(resultSet.getString("name"), resultSet.getString("secondName"), resultSet.getByte("age"));
                System.out.println(newUser4);*/
            }

            statement.execute("TRUNCATE TABLE katausers");










            //TABLE REMOVING
            //statement.execute("DROP TABLE IF EXISTS katausers");
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
