import java.util.List;

public class FileTest {
    public static void main(String[] args) {

        MyFile myFile = new MyFile();
        List<String> data = myFile.read("D:\\JPROJECT\\Jproject\\src\\main\\java\\parameters");

        MyConfig myConfig = new MyConfig();
        myConfig.setParametres(data);

        myFile.download(myConfig.getsftpUser(), myConfig.getsftpHost(), myConfig.getsftpPort(),
                myConfig.getsftpPassword(), myConfig.getsftpRemoteDir(), myConfig.getlocalDir());


        MyWriter myWriter = new MyWriter();
        myWriter.writeData(myConfig.getsqlDatabase(), myConfig.getsqlUser(),
                myConfig.getsqlPassword(), myConfig.getlocalDir());

        MyPrinter myPrinter = new MyPrinter();
        myPrinter.printData(myConfig.getsqlDatabase(), myConfig.getsqlUser(),
                myConfig.getsqlPassword());
    }
}


