public class FileInfo {
    private int id;
    private String name;
    private String date;

    public FileInfo(){}
    public FileInfo( int id, String name, String date){
        this.id = id;
        this.name = name;
        this.date= date;
    }

    @Override
    public String toString(){
        return "[ " + id + "\t" + name + "\t" + date + " ]";
    }
}

