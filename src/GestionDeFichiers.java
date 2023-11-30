import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GestionDeFichiers {
    public static void main(String[] args) throws IOException {
        Path monChemin = Paths.get("C:\\temp");
        System.out.println(Files.exists(monChemin));
        System.out.println(monChemin.toAbsolutePath());
        System.out.println(monChemin.getFileName());

        DirectoryStream<Path> stream = Files.newDirectoryStream(monChemin);

        for (Path p: stream) {
            System.out.println(p.toString());
        }
    }
}
