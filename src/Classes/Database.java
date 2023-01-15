package Classes;

import java.sql.*;

public class Database {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/songsdb", "root", "toor");
    public Database() throws SQLException {
    }
}

