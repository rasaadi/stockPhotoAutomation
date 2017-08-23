package com.team3.stockPhoto.automation.tests;

import com.team3.stockPhoto.automation.actions.UiActions;
import com.team3.stockPhoto.automation.base.BaseTest;
import com.team3.stockPhoto.automation.utils.GeneralUtils;
import com.team3.stockPhoto.automation.verifications.UiVerifications;
import org.testng.annotations.Test;

/**
 * Created by rafsan on 8/9/2017.
 */
public class BuyerTests extends BaseTest {

    @Test(enabled = true, description = "Verify buyer can contact media owner")
    public void  testBuyerContactMediaOwnerSuccess() throws Exception{

      // ==== CONFIGURATION ====
      String mediaTitle = "Banana Gun";
      String messageToSeller = "Test Msg from Buyer on " + GeneralUtils.currentTimeStamp();


      // ==== ACTION ====
      UiActions.openUrl(USER_LOGIN_URL);
      UiActions.loggingInAs(BUYER_USER_NAME,BUYER_USER_PASSWORD );

      UiActions.openingHomePage();
      UiActions.searchWithoutCategory(mediaTitle);

      UiActions.contactSellerForSearchedItem(messageToSeller);

      // ==== VERIFICATION ====
      UiVerifications.verifyMessageSentSuccessfully();
    }
}
