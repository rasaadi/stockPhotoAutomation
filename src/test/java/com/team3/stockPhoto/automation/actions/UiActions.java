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

    GeneralUtils.waitFor(100);
  }

  public static void openingHomePage(){
    log.info("Opening Stock Photo Marketplace Home Page: " + APP_HOME_URL);

    driver.get(APP_HOME_URL);

    GeneralUtils.waitFor(100);

    Assert.assertTrue(GeneralUtils.isElementPresent(By.linkText("Home")),
        "Incorrect Home Page");
    Assert.assertTrue(GeneralUtils.isElementPresent(By.linkText("About Us")),
        "Incorrect Home Page");
  }

  public static void loggingInAs(String userEmail, String userPassword) {
    log.info("Logging into system as: " + userEmail + "/" + userPassword);

    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(userEmail);
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(userPassword);

    driver.findElement(By.cssSelector("form > button[type=\"submit\"]")).click();
  }

  public static void loggingOut(){
    log.info("Logging  out the current user");

    Assert.assertEquals(driver.findElement(By.linkText("Logout")).getText(),
        "Logout", "User is not logged in");
    driver.findElement(By.linkText("Logout")).click();

    Assert.assertEquals(driver.findElement(By.linkText("Login")).getText(),
        "Login", "User did not log out");
  }

  public static void searchWithoutCategory(String searchStr) {
    log.info("Searching for : " + searchStr);

    Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-warning")).getText(), "Search");
    Assert.assertTrue(GeneralUtils.isElementPresent(By.id("thetitle")));

    driver.findElement(By.id("thetitle")).clear();
    driver.findElement(By.id("thetitle")).sendKeys(searchStr);
    driver.findElement(By.cssSelector("button.btn.btn-warning")).click();

  }

  public static void sendMessageToSellerForSearchedItem(String messageBody) {
    log.info("Contacting seller: " + messageBody);

    GeneralUtils.waitFor(100);

    Assert.assertEquals(driver.findElement(By.linkText("Contact Seller")).getText(),
        "Contact Seller", "Failed to find contact seller option");
    driver.findElement(By.linkText("Contact Seller")).click();

    GeneralUtils.waitFor(100);

    Assert.assertEquals(driver.findElement(By.cssSelector("legend")).getText(),
        "Send Message", "Message form is not displayed");
    driver.findElement(By.id("msg-body")).clear();
    driver.findElement(By.id("msg-body")).sendKeys(messageBody);
    driver.findElement(By.cssSelector("form > button[type=\"submit\"]")).click();

  }

  public static void fillUpUserRegistrationForm(String customerEmail, String customerPassword) {
    log.info("Filling up new user registration form for: " + customerEmail + "/" + customerPassword);

    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(customerEmail);
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(customerPassword);
    driver.findElement(By.id("confirm-password")).clear();
    driver.findElement(By.id("confirm-password")).sendKeys(customerPassword);
    driver.findElement(By.id("accept-terms")).click();
  }

  public static void submitRegistrationForm() {
    log.info("Submitting user registration form");

    driver.findElement(By.cssSelector("form > button[type=\"submit\"]")).click();
  }

}
