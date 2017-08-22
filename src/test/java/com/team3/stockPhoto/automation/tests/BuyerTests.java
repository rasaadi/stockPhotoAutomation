package com.team3.stockPhoto.automation.tests;

import com.team3.stockPhoto.automation.actions.UiActions;
import com.team3.stockPhoto.automation.base.BaseTest;
import org.testng.annotations.Test;

/**
 * Created by rafsan on 8/9/2017.
 */
public class BuyerTests extends BaseTest {

    @Test(enabled = true, description = "Verify buyer can contact media owner")
    public void  testBuyerContactMediaOwnerSuccess() throws Exception{

      // ==== CONFIGURATION ====
      String mediaTitle = "Banana Gun";
      String mediaDescription = "hold it!";
      String mediaPrice = " 25.95";


      // ==== ACTION ====
      UiActions.openUrl(USER_LOGIN_URL);
      UiActions.loginToServerWith(BUYER_USER_NAME,BUYER_USER_PASSWORD );

      UiActions.openingHomePage();
      UiActions.searchWithoutCategory(mediaTitle);

      UiActions.contactMediaOwnerOfSearchedItem();

      // ==== VERIFICATION ====
//      UiVerifications.verifySearchResultWithOneItem(searchMediaTitle, searchMediaDescription );
    }
}
