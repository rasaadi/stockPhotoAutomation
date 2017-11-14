package com.team3.stockPhoto.automation.tests;

import com.team3.stockPhoto.automation.actions.UiActions;
import com.team3.stockPhoto.automation.base.BaseTest;
import com.team3.stockPhoto.automation.verifications.UiVerifications;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by rafsan on 11/13/2017.
 */
public class FailTest extends BaseTest {
  private static final Logger log = Logger.getLogger(FailTest.class);

  /**
   * This test is to simulate test failure and to check the error report
   * @throws Exception
   */

  @Test(enabled = true, description = "FAIL: Verify un-registered user can search for desired media")
  public void  testUnRegisteredUserSearchMediaFail() throws Exception{

    // ==== CONFIGURATION ====
    String searchMediaTitle = "Item does not exist";
    String searchMediaDescription = "No Description";

    // ==== ACTION ====
    UiActions.openingHomePage();
    UiActions.searchWithoutCategory(searchMediaTitle);

    // ==== VERIFICATION ====
    UiVerifications.verifySearchResultWithOneItemSuccess(searchMediaTitle, searchMediaDescription );
  }
}
