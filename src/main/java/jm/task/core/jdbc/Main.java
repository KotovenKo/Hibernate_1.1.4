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
            System.out.println("---------------------------------------------------------------");

            // Specified user extract from DB





            // User1 extract from DB
            ResultSet resultSet1 = statement.executeQuery("select * from katausers where id = 1");
            resultSet1.next();
            user1.setId(resultSet1.getLong("ID"));
            user1.setName(resultSet1.getString("name"));
            user1.setLastName(resultSet1.getString("secondName"));
            user1.setAge((byte)resultSet1.getInt("age"));
            System.out.println(user1);
            System.out.println("---------------------------------------------------------------");

            // User2 extract from DB
            ResultSet resultSet2 = statement.executeQuery("select * from katausers where id = 2");
            resultSet2.next();
            user1.setId(resultSet2.getLong("ID"));
            user1.setName(resultSet2.getString("name"));
            user1.setLastName(resultSet2.getString("secondName"));
            user1.setAge((byte)resultSet2.getInt("age"));
            System.out.println(user2);
            System.out.println("---------------------------------------------------------------");

            // User2 extract from DB
            ResultSet resultSet3 = statement.executeQuery("select * from katausers where id = 3");
            resultSet3.next();
            user1.setId(resultSet3.getLong("ID"));
            user1.setName(resultSet3.getString("name"));
            user1.setLastName(resultSet3.getString("secondName"));
            user1.setAge((byte)resultSet3.getInt("age"));
            System.out.println(user3);
            System.out.println("---------------------------------------------------------------");

            // User2 extract from DB
            ResultSet resultSet4 = statement.executeQuery("select * from katausers where id = 4");
            resultSet4.next();
            user1.setId(resultSet4.getLong("ID"));
            user1.setName(resultSet4.getString("name"));
            user1.setLastName(resultSet4.getString("secondName"));
            user1.setAge((byte)resultSet4.getInt("age"));
            System.out.println(user4);
            System.out.println("---------------------------------------------------------------");

            //Extract all users from DB
            ResultSet resultSet = statement.executeQuery("select * from katausers");
            while ((resultSet.next())) {
                User user = new User();
                //user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("secondName"));
                user.setAge((byte)resultSet.getInt("age"));
                System.out.println(user);
            }

            /*// Specified user extract from DB
            ResultSet resultSetIndifidual = statement.executeQuery("select * from katausers where id = 1");
            resultSetIndifidual.next();
            user1.setId(resultSetIndifidual.getLong("ID"));
            user1.setName(resultSetIndifidual.getString("name"));
            user1.setLastName(resultSetIndifidual.getString("secondName"));
            user1.setAge((byte)resultSetIndifidual.getInt("age"));
            System.out.println(user1);
            System.out.println("---------------------------------------------------------------");*/



            //Delete user with ID
            statement.execute("delete from katausers where id=1");



            // Table clean
            statement.execute("TRUNCATE TABLE katausers");

            //Table delete
            statement.execute("DROP TABLE katausers");














        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
