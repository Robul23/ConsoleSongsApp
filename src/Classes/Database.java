package Classes;

import java.sql.*;

public class Database {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:1522/songsdb", "root", "root");
       // 3309 root toor
    public Database() throws SQLException {
    }
}

