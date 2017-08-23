package com.team3.stockPhoto.automation.tests;

import com.team3.stockPhoto.automation.actions.UiActions;
import com.team3.stockPhoto.automation.base.BaseTest;
import com.team3.stockPhoto.automation.verifications.UiVerifications;
import org.testng.annotations.Test;

/**
 * Created by rafsan on 8/22/2017.
 */
public class SellerTests extends BaseTest {

  @Test(enabled = true, description = "Verify seller can upload their media for sell")
  public void  testSellerUploadMediaSuccess() throws Exception{

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
