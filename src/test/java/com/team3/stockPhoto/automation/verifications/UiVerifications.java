package com.team3.stockPhoto.automation.verifications;

import com.team3.stockPhoto.automation.base.BaseTest;
import com.team3.stockPhoto.automation.utils.GeneralUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by rafsan on 8/7/2017.
 */
public class UiVerifications extends BaseTest {
  private static final Logger log = Logger.getLogger(UiVerifications.class);

  public static void verifySearchResultWithOneItem(String searchedTitle, String searchedDescription){

    log.info("Verifying one item search result for: " + searchedTitle );

    GeneralUtils.waitFor(100);

    Assert.assertEquals(driver.findElement(By.cssSelector("div.container.clearfix > div")).getText(), "1 Results found.");
    Assert.assertEquals(driver.findElement(By.cssSelector("div.watermark > p")).getText(), "Stock Photo MarketplaceCopyright 2017");

    Assert.assertEquals(driver.findElement(By.xpath("//div[4]")).getText(), "Media Title: " + searchedTitle);
    Assert.assertEquals(driver.findElement(By.xpath("//div[5]")).getText(), "Media description: " + searchedDescription);

    Assert.assertEquals(driver.findElement(By.linkText("DOWNLOAD")).getText(), "DOWNLOAD");

  }
}
