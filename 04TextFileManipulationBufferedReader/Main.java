import java.io.*;

public class BufferedReaderTextFile {
    public static void main(String[] args) throws Exception {
		File mamamoFile = new File("wawarnn.txt");
        BufferedReader br = new BufferedReader(new FileReader(wrFile));
        String st;
        while((st = br.readLine()) != null) {
            System.out.println(st);
        }
    }
}
