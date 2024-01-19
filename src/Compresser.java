import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compresser {
    String rootName,filePassword;
    List<FileWithDepth> filesList;

    public Compresser(String rootName,String filePassword,List<FileWithDepth> filesList) {
        this.rootName = rootName;
        this.filesList = filesList;
        this.filePassword=filePassword;
    }

    public void saveCompression(String compressionName) {
        File compressedFile = new File("./",compressionName+".zft");
        List<Name_Content> nameContents = new ArrayList<>();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(compressedFile));
            for (var file:filesList) {
                String[] allTree = file.file().getPath().split("\\\\");
                int i=0;
                for (;i< allTree.length;i++)
                    if(allTree[i].equals(rootName))break;

                // Initialising the Name_Content inside the variable
                {
                    String insideRelativePath = String.join("/", Arrays.copyOfRange(allTree, i + 1, allTree.length));
                    var isFile = file.file().isFile();
                    Type thisFileType = isFile ? Type.File : Type.Directory;
                    if(isFile){
                        FileInputStream fis = new FileInputStream(file.file());
                        long fileSize = file.file().length();
                        byte[] fileContent = new byte[(int) fileSize];
                        int bytesRead = fis.read(fileContent);
                        if(bytesRead == fileSize)
                            nameContents.add(new Name_Content(insideRelativePath, thisFileType, fileContent));

                        fis.close();

                    }
                    else
                        nameContents.add(new Name_Content(insideRelativePath,thisFileType,null));


                }
            }
            oos.writeObject(new CompressedFile(filePassword,nameContents));

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
