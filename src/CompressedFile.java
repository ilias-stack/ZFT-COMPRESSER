import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class CompressedFile implements Serializable {
    private final String password;
    private final List<Name_Content> filesList;

    @Serial
    private static final long serialVersionUID = 882504630376625325L;

    public CompressedFile(String password, List<Name_Content> filesList) {
        this.password = password;
        this.filesList = filesList;
        System.out.println(password.isEmpty()?"No password for this zft.":"Password is "+password);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "CompressedFile=>" +
                "password='" + password + '\'' +
                "\nfilesList=" + filesList ;
    }

    public List<Name_Content> getFilesList() {
        return filesList;
    }
}
