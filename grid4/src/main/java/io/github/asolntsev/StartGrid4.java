package io.github.asolntsev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.grid.Main;

public class StartGrid4 {

  private static final int port = 4444;

  public static void main(String[] args) {
      WebDriverManager.chromedriver().setup();
      WebDriverManager.firefoxdriver().setup();

    Main.main(new String[]{"standalone", "--port", String.valueOf(port)});

  }
}
