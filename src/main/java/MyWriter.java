import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyWriter {
    public void writeData(String url, String userName, String password, String path) {

        DBProcessor dbProcessor = new DBProcessor();
        BasicFileAttributes attr;
        String insert = "insert into newdb.file_info (file_name, file_date) values (?, ?) ";

        try(Connection connection = dbProcessor.getConnection("jdbc:mysql://localhost:3306/" + url +
                "?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Moscow", userName, password);
            PreparedStatement prepInsert = connection.prepareStatement(insert);
            DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path));
            Statement statement = connection.createStatement()){

            statement.executeUpdate("DELETE  FROM newdb.file_info ");
            statement.executeUpdate("ALTER TABLE newdb.file_info AUTO_INCREMENT=0");

            for (Path file: stream) {
                if (!file.toFile().isDirectory()) {
                    attr = Files.readAttributes(file, BasicFileAttributes.class);
                    FileTime dateTime = attr.lastModifiedTime();

                    DateFormat inputformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
                    DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = inputformat.parse(String.valueOf(dateTime));
                    String outputText = outputformat.format(date);

                    String fileName = String.valueOf(file.getFileName());

                    prepInsert.setString(1, fileName);
                    prepInsert.setTimestamp(2, Timestamp.valueOf(outputText));
                    prepInsert.execute();
                }
            }

            // statement.execute("insert into newdb.file_info (file_name, file_date) values (\"readme4\", NOW()) ");

        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (IOException | DirectoryIteratorException | ParseException x) {
            System.err.println(x);
        }
    }
}
