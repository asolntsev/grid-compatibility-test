package io.github.asolntsev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.grid.selenium.GridLauncherV3;

import static org.openqa.selenium.net.PortProber.findFreePort;

public class StartGrid3 {

  private static final int port = 3333;

  public static void main(String[] args) throws Exception {
    WebDriverManager.chromedriver().setup();
    WebDriverManager.firefoxdriver().setup();

    GridLauncherV3.main(new String[]{"-port", "" + port});

    GridLauncherV3.main(new String[]{"-port", "" + findFreePort(),
        "-role", "node",
        "-hub", "http://localhost:" + port + "/grid/register"
    });
  }
}
