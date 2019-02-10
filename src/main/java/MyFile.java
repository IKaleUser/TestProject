import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.jcraft.jsch.*;

public class MyFile {
    public List<String> read(String pathToFile) {
        List<String> allParameters = new ArrayList<>();
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(pathToFile), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line.trim();
                String[] oneParameter = line.split("=");
                allParameters.add(oneParameter[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allParameters;
    }

    public void download(String userName, String host, int port, String password, String remotefile, String localfile) {
        JSch jsch = new JSch();
        Session session = null;

        try {
            session = jsch.getSession(userName, host, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;

            sftpChannel.get(remotefile, localfile);
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }
}