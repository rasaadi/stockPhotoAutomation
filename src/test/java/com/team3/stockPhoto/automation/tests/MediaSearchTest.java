package com.team3.stockPhoto.automation.tests;

import com.team3.stockPhoto.automation.actions.UiActions;
import com.team3.stockPhoto.automation.base.BaseTest;
import com.team3.stockPhoto.automation.verifications.UiVerifications;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by rafsan on 8/7/2017.
 */
public class MediaSearchTest extends BaseTest {
  private static final Logger log = Logger.getLogger(MediaSearchTest.class);

  @Test(enabled = true, description = "Verify un-registered user can search for desired media")
  public void  testUnRegisteredUserSearchMediaSuccess() throws Exception{

    // ==== CONFIGURATION ====
    String searchMediaTitle = "Banana Gun";
    String searchMediaDescription = "hold it!";

    // ==== ACTION ====
    UiActions.openingHomePage();
    UiActions.searchWithoutCategory(searchMediaTitle);

    // ==== VERIFICATION ====
    UiVerifications.verifySearchResultWithOneItem(searchMediaTitle, searchMediaDescription );
  }
}
