import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBProcessor {
    private  Connection connection;

    public Connection getConnection(String url, String userName, String password) throws SQLException {
        if (connection != null)
            return  connection;
        connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }
}

