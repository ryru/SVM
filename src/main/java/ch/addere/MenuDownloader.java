package ch.addere;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MenuDownloader {

  private MenuDownloader() {
  }

  static File downloadMenu(String url) throws IOException {
    File tempFile;

    try (InputStream in = new URL(url).openStream()) {
      tempFile = File.createTempFile("mensa", "html");
      tempFile.deleteOnExit();
      Files.copy(in, Paths.get(tempFile.toURI()), StandardCopyOption.REPLACE_EXISTING);

    }

    return tempFile;
  }

}
