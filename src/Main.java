import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Main {

    public static List<FileWithDepth> allSubFiles = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to compress(to folder.zft) or decompress(from folder.zft) [C/D]? ");
        char option = sc.next().toUpperCase().charAt(0);
        sc.nextLine();
        System.out.println();
        String inputPath;
        try {
            if(option=='D') {
                System.out.println("---You chose DECOMPRESSION---");
                System.out.println();
                System.out.print("Please enter .zft file path :");
                inputPath = sc.nextLine().trim();
                if(!inputPath.endsWith(".zft")) throw new RuntimeException("This is not a valid zft file path.");
                Decompresser dcp = new Decompresser(inputPath);
                dcp.decompress();
                System.out.println("\nFILE WAS DECOMPRESSED SUCCESSFULLY!");
            }

            else if(option=='C') {
                System.out.println("---You chose COMPRESSION---");
                System.out.println();
                System.out.print("Please enter the path of the folder to compress :");
                inputPath = sc.nextLine().trim();
                System.out.print("->If you want to add a password type it : ");
                String filePassword = sc.nextLine().trim();
                if(inputPath.contains(".")) throw new RuntimeException("This is not a valid folder path.");
                File rootFile = new File(inputPath);
                setAllSubFiles(inputPath,0);
                Collections.sort(allSubFiles);
                Compresser cp = new Compresser(rootFile.getName(),filePassword,allSubFiles );
                cp.saveCompression(rootFile.getName());
                System.out.println("\nFOLDER WAS COMPRESSED SUCCESSFULLY!");
            }

            else System.out.println("No corresponding functionality.");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("\nSomething is not working!");
        }


    }

    public static void setAllSubFiles(String chemin,int iteration){
        File file=new File(chemin);
        for (String fich: Objects.requireNonNull(file.list())) {
            File currentFile=new File(chemin,fich);
            allSubFiles.add(new FileWithDepth(iteration,currentFile));
            if(currentFile.isDirectory())
                setAllSubFiles(currentFile.getPath(),iteration+1);
        }
    }
}