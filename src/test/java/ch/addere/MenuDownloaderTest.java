package ch.addere;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class MenuDownloaderTest {


  @Test
  void testInvalidURL() {
    assertThrows(IOException.class, () -> MenuDownloader.downloadMenu("foobar"));
  }

  @Test
  void testValidURL() throws IOException {
    assertNotNull(MenuDownloader.downloadMenu("https://www.example.com"));
  }

}