package com.team3.stockPhoto.automation.tests;

import com.team3.stockPhoto.automation.actions.UiActions;
import com.team3.stockPhoto.automation.base.BaseTest;
import com.team3.stockPhoto.automation.utils.GeneralUtils;
import com.team3.stockPhoto.automation.verifications.UiVerifications;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

/**
 * Created by rafsan on 8/9/2017.
 */
public class BuyerTest extends BaseTest {
  private static final Logger log = Logger.getLogger(BuyerTest.class);

    @Test(enabled = true, description = "Verify buyer can contact media seller")
    public void  testBuyerContactMediaOwnerSuccess() throws Exception{

      // ==== CONFIGURATION ====
      // The item will be searched
      String mediaTitle = "Banana Gun";
      // The message will be sent
      String messageToSeller = "Test Msg from Buyer on " + GeneralUtils.currentTimeStamp();


      // ==== ACTION ====
      // Navigate to user LOGIN page
      UiActions.openUrl(USER_LOGIN_URL);
      // Login as the BUYER
      UiActions.loggingInAs(BUYER_USER_NAME,BUYER_USER_PASSWORD );

      // Navigate to the App HOME page
      UiActions.openingHomePage();
      // Searched for the item that was specified at the top: "Banana Gun"
      UiActions.searchWithoutCategory(mediaTitle);

      // Send message to the seller with specified message body at the top
      UiActions.sendMessageToSellerForSearchedItem(messageToSeller);

      // ==== VERIFICATION ====
      // Verify the message is sent successfully
      UiVerifications.verifyMessageSentSuccessfully();
    }
}
