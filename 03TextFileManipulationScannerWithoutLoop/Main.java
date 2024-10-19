import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File mamamofile = new File("wawarnn.txt");
        Scanner sc = new Scanner(wrfile);
     
        sc.useDelimiter("\\Z");
        System.out.println(sc.next());
    }
}
