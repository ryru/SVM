package ch.addere;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MenuDownloader {

  static File downloadMenu(String url) throws IOException {
    InputStream in = new URL(url).openStream();
    File tempFile = File.createTempFile("mensa","html");
    tempFile.deleteOnExit();
    Files.copy(in, Paths.get(tempFile.toURI()), StandardCopyOption.REPLACE_EXISTING);

    return tempFile;
  }

}
