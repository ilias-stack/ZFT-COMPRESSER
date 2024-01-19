import java.io.Serial;
import java.io.Serializable;

public class Name_Content implements Serializable {
    final private String filepath;
    final private byte[] data;
    final private Type type;

    @Serial
    private static final long serialVersionUID = 882504630376625325L;

    public String getFilepath() {
        return filepath;
    }

    public byte[] getData() {
        return data;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Name_Content=> " +
                "filepath='" + filepath + '\'' +
                ", type=" + type ;
    }

    public Name_Content(String filepath, Type type, byte[] data) {
        this.filepath = filepath;
        this.data = data;
        this.type=type;
    }
}
