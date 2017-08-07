package com.team3.stockPhoto.automation.utils;

import com.team3.stockPhoto.automation.base.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by rafsan on 8/7/2017.
 */
public class GeneralUtils extends BaseTest{

  private static final Logger log = Logger.getLogger(GeneralUtils.class);

  private boolean acceptNextAlert = true;

  public static boolean isElementPresent(By id) {
    try {
      driver.findElement(id);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public static void waitFor(int timeInMillSec) {
    try {
      Thread.sleep(timeInMillSec);

    }catch (InterruptedException ie){

      ie.printStackTrace();

    }

  }

}
