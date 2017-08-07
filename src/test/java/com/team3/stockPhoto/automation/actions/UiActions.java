package com.team3.stockPhoto.automation.actions;

import com.team3.stockPhoto.automation.base.BaseTest;
import com.team3.stockPhoto.automation.utils.GeneralUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by rafsan on 8/7/2017.
 */
public class UiActions extends BaseTest {
  private static final Logger log = Logger.getLogger(UiActions.class);

  public static void openUrl(String url){

    log.info("Opening URL: " + url);
    driver.get(url);
  }

  public static void openingHomePage(){
    log.info("Opening Stock Photo Marketplace Home Page: " + BASE_SERVER_ADDRESS);

    driver.get(BASE_SERVER_ADDRESS);

    GeneralUtils.waitFor(100);

    Assert.assertTrue(GeneralUtils.isElementPresent(By.linkText("Home")), "Incorrect Home Page");
    Assert.assertTrue(GeneralUtils.isElementPresent(By.linkText("Login")), "Incorrect Home Page");
  }

  public static void searchWithoutCategory(String searchStr) {
    log.info("Searching for : " + searchStr);

    Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-warning")).getText(), "Search");
    Assert.assertTrue(GeneralUtils.isElementPresent(By.id("thetitle")));

    driver.findElement(By.id("thetitle")).clear();
    driver.findElement(By.id("thetitle")).sendKeys(searchStr);
    driver.findElement(By.cssSelector("button.btn.btn-warning")).click();

  }
}
