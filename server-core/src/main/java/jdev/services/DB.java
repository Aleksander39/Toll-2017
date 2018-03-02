package jdev.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static void main(String...args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");//подключение драйвера
        Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/e:/JavaDev/jdbc-drives/db");
    }
}
