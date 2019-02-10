import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyPrinter {
    public void printData(String url, String userName, String password) {
        DBProcessor dbProcessor = new DBProcessor();
        String query = "select * from newdb.file_info";

        try(Connection connection = dbProcessor.getConnection("jdbc:mysql://localhost:3306/" + url +
                "?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", userName, password);
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id;
                String name;
                String date;
                id = resultSet.getInt("file_id");
                name = resultSet.getString("file_name");
                date = resultSet.getString("file_date");
                FileInfo fileInfo = new FileInfo(id, name, date);
                System.out.println(fileInfo);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}

