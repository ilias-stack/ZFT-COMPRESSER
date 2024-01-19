import javax.management.RuntimeErrorException;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Decompresser {
    String zftPath;
    public Decompresser(String zftPath) {
        this.zftPath = zftPath;
    }

    public void decompress(){
        Scanner sc= new Scanner(System.in);
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(zftPath));
            CompressedFile compressedFile = (CompressedFile) ois.readObject();
            var splitPath = zftPath.split("\\\\");
            var decompressionPathRoot = String.join("/",Arrays.copyOfRange(splitPath, 0, splitPath.length-1));
            String decompressionPath = decompressionPathRoot+ "/" + splitPath[splitPath.length-1].split("\\.")[0];
            File unzippedFile = new File(decompressionPath);
//             verify if there is a password
            if(!compressedFile.getPassword().isEmpty()){
                System.out.println("\n-This file is protected with a password! Please type it before continuing : ");
                String passKey = sc.nextLine().trim();
                if(!passKey.equals(compressedFile.getPassword()))
                    throw new RuntimeException("This is not the correct password !");

            }

            if(unzippedFile.mkdirs()){

                for (var folder: compressedFile.getFilesList().stream()
                        .filter(nameContent -> nameContent.getType() == Type.Directory)
                        .toList()) {
                    File subFolder = new File(decompressionPath+"/"+folder.getFilepath());
                    if(!subFolder.mkdirs()) new RuntimeException("Not able to finish task.");
                }
                for (var file: compressedFile.getFilesList().stream()
                        .filter(nameContent -> nameContent.getType() == Type.File)
                        .toList()) {
                    File thisFile = new File(decompressionPath+"/"+file.getFilepath());
                    FileOutputStream fos = new FileOutputStream(thisFile);
                    fos.write(file.getData());
                }
            }
            else System.out.println("**Could not decompress file in current path.**");

        } catch (IOException|ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
