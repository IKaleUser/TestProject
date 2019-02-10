import java.util.List;


public class MyConfig {

    private String sftpHost;
    private int sftpPort;
    private String sftpUser;
    private String sftpPassword;
    private String sftpRemoteDir;
    private String localDir;
    private String sqlUser;
    private String sqlPassword;
    private String sqlDatabase;

    public String getsftpHost() {
        return sftpHost;
    }

    public int getsftpPort() {
        return sftpPort;
    }

    public String getsftpUser() {
        return sftpUser;
    }

    public String getsftpPassword() {
        return sftpPassword;
    }

    public String getsftpRemoteDir() {
        return sftpRemoteDir;
    }

    public String getlocalDir() {
        return localDir;
    }

    public String getsqlUser() {
        return sqlUser;
    }

    public String getsqlPassword() {
        return sqlPassword;
    }

    public String getsqlDatabase() {
        return sqlDatabase;
    }

    public void setParametres(List<String> parameters) {
        sftpHost = parameters.get(0);
        sftpPort = Integer.parseInt(parameters.get(1));
        sftpUser = parameters.get(2);
        sftpPassword = parameters.get(3);
        sftpRemoteDir = parameters.get(4);
        localDir = parameters.get(5);
        sqlUser = parameters.get(6);
        sqlPassword = parameters.get(7);
        sqlDatabase = parameters.get(8);
    }
}

