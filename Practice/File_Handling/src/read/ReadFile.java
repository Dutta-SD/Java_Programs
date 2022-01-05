package read;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File myObjFile = new File("File_Handling/src/read/sample.txt");
            Scanner myReader = new Scanner(myObjFile);

            System.out.println(myObjFile.exists());
            System.out.println(myObjFile.lastModified());
            System.out.println(myObjFile.canRead());

            while (myReader.hasNextLine()) {
                System.out.println(myReader.nextLine());
            }
            myReader.close();

        } catch (IOException e) {
            System.out.println("Exception thrown");
        }
    }

}