package com.team3.stockPhoto.automation.verifications;

import com.team3.stockPhoto.automation.base.BaseTest;
import com.team3.stockPhoto.automation.utils.GeneralUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.team3.stockPhoto.automation.utils.GeneralUtils.isElementPresent;

/**
 * Created by rafsan on 8/7/2017.
 */
public class UiVerifications extends BaseTest {
  private static final Logger log = Logger.getLogger(UiVerifications.class);

  public static void verifySearchResultWithOneItem(String searchedTitle, String searchedDescription){

    log.info("Verifying one item search result for: " + searchedTitle );

    GeneralUtils.waitFor(100);

    Assert.assertEquals(driver.findElement(By.cssSelector("div.container.clearfix > div")).getText(),
        "1 Results found.", "Incorrect number of search item ");
    Assert.assertEquals(driver.findElement(By.cssSelector("div.watermark > p")).getText(),
        "Stock Photo MarketplaceCopyright 2017", "No watermark found");

    Assert.assertEquals(driver.findElement(By.xpath("//div[4]")).getText(),
        "Media Title: " + searchedTitle, "Media Title does not match");
    Assert.assertEquals(driver.findElement(By.xpath("//div[5]")).getText(),
        "Media description: " + searchedDescription, "Media description does not match");

//    Assert.assertEquals(driver.findElement(By.linkText("DOWNLOAD")).getText(), "DOWNLOAD");

  }

  public static void verifyUserRegistrationSuccessful() {
    log.info("Verifying user registration was successful" );

    GeneralUtils.waitFor(100);

    Assert.assertTrue(isElementPresent(By.cssSelector("div.message.success")),
        "Registration message not present");
    Assert.assertEquals(driver.findElement(By.cssSelector("div.message.success")).getText(),
        "Congratulations! User is created.", "User Registration failed");

  }

  public static void verifyUserLoginSuccessful() {

    log.info("Verifying user login was successful" );

    GeneralUtils.waitFor(100);

    Assert.assertEquals(driver.findElement(By.linkText("Dashboard")).getText(),
        "Dashboard", "Dashboard link does not exist");

    Assert.assertEquals(driver.findElement(By.linkText("Logout")).getText(),
        "Logout", "Logout element does not exist");

    // Logging out so that other test can run without any issue
    driver.findElement(By.linkText("Logout")).click();
    Assert.assertEquals(driver.findElement(By.linkText("Login")).getText(),
        "Login", "User did not log out");
  }

  public static void verifyUserLoginFail() {
    log.info("Verifying user login failed" );

    GeneralUtils.waitFor(100);

    Assert.assertTrue(GeneralUtils.isElementPresent(By.cssSelector("div.message.error")),
        "Error msg element is not present");
    Assert.assertEquals(driver.findElement(By.cssSelector("div.message.error")).getText(),
        "Your username or password is incorrect.", "Login failed message is not displayed");

    Assert.assertTrue(GeneralUtils.isElementPresent(By.linkText("Login")),
        "Login link element is not present");
    Assert.assertEquals(driver.findElement(By.linkText("Login")).getText(),
        "Login", "Login link is not present");
  }
}
