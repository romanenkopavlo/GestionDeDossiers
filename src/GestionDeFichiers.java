import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class GestionDeFichiers {
    public static void main(String[] args)  {

        if (args.length < 2) {
            System.out.print("Veuillez fournir deux noms de fichiers en arguments.");
            return;
        }

        BufferedWriter bw;
        BufferedReader br;
        String s;
        Path fileSource = Paths.get(args[0] + ".txt");
        Path fileSource2 = Paths.get(args[1]+ ".txt");
        String line1 = "html";
        String line2 = "css";
        String line3 = "java script";

        try {
            if (!Files.exists(fileSource)) {
                bw = Files.newBufferedWriter(fileSource, Charset.defaultCharset());
            } else {
                bw = Files.newBufferedWriter(fileSource, Charset.defaultCharset(), StandardOpenOption.APPEND);
            }

            bw.write(line1);
            bw.newLine();
            bw.write(line2);
            bw.newLine();
            bw.write(line3);

            bw.close();


            if (!Files.exists(fileSource2)) {
                bw = Files.newBufferedWriter(fileSource2, Charset.defaultCharset());
            } else {
                bw = Files.newBufferedWriter(fileSource2, Charset.defaultCharset(), StandardOpenOption.APPEND);
            }

            br = Files.newBufferedReader(fileSource, Charset.defaultCharset());

            while ((s = br.readLine()) != null) {
                bw.write(s.toUpperCase());
                bw.newLine();
                System.out.println(s);
            }

            System.out.print("\n");
            bw.close();
            br.close();

            br = Files.newBufferedReader(fileSource2, Charset.defaultCharset());
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}