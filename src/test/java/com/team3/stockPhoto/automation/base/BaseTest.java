package com.team3.stockPhoto.automation.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created by rafsan on 8/6/2017.
 */
public class BaseTest extends CommonSettings {
  private static final Logger log = Logger.getLogger(BaseTest.class);

  protected static WebDriver driver = null;

  @BeforeClass(alwaysRun = true)
  public void initClass() {

    log.info("-------- START RUN ---------");
    log.info("Setting up test environment");

    startBrowser();
  }

  @BeforeMethod(alwaysRun = true)
  public void initMethod(Method method) {

    log.info("-------- START TEST --------");
    log.info("Test: " + method.getDeclaringClass().getSimpleName() + "." + method.getName());
  }

  @AfterMethod(alwaysRun = true)
  public void tearDownMethod() {

    log.info("-------- END TEST --------");
  }

  @AfterClass(alwaysRun = true)
  public void tearDownClass() {

    stopBrowser();

    log.info("-------- END CLASS --------");
  }

  public static void startBrowser(){
    log.info("Starting Browser Driver");

    // Setting up "gecko.driver" in the system path that is required by the Selenium webdriver
    System.setProperty("webdriver.gecko.driver", "C:\\rsDevelopment\\tools\\geckodriver-v0.18.0\\geckodriver.exe");

    driver = new FirefoxDriver();
    driver.get(APP_HOME_URL);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  public static void stopBrowser() {
    log.info("Stopping Browser Driver");

    if (driver != null) {
      driver.quit();
    }

    driver = null;
  }
}
