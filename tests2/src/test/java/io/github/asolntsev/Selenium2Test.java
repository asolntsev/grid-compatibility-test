package io.github.asolntsev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.Keys.ENTER;

public class Selenium2Test {
  private WebDriver driver;

  @Test
  void checkChrome() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    clickAndCheck();
  }

  @Test @Disabled
  void checkFirefox() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    clickAndCheck();
  }

  @Test
  void checkChromeInGrid2() throws MalformedURLException {
    RemoteWebDriver rd = new RemoteWebDriver(new URL("http://localhost:2222/wd/hub"), DesiredCapabilities.chrome());
    rd.setFileDetector(new LocalFileDetector());
    driver = rd;
    clickAndCheck();
  }

  @Test
  void checkChromeInGrid3() throws MalformedURLException {
    RemoteWebDriver rd = new RemoteWebDriver(new URL("http://localhost:3333/wd/hub"), DesiredCapabilities.chrome());
    rd.setFileDetector(new LocalFileDetector());
    driver = rd;
    clickAndCheck();
  }

  @Test
  void checkChromeInGrid4() throws MalformedURLException {
    RemoteWebDriver rd = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
    rd.setFileDetector(new LocalFileDetector());
    driver = rd;
    clickAndCheck();
  }

  private void clickAndCheck() {
    driver.navigate().to("https://duckduckgo.com");
    driver.findElement(By.name("q")).sendKeys("Is Grid backward compatible?", ENTER);
  }

  @AfterEach
  void tearDown() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
