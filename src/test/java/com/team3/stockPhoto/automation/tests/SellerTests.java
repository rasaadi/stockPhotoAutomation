package com.team3.stockPhoto.automation.tests;

import com.team3.stockPhoto.automation.actions.UiActions;
import com.team3.stockPhoto.automation.base.BaseTest;
import com.team3.stockPhoto.automation.utils.GeneralUtils;
import com.team3.stockPhoto.automation.verifications.UiVerifications;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by rafsan on 8/22/2017.
 */
public class SellerTests extends BaseTest {
  private static final Logger log = Logger.getLogger(SellerTests.class);

  @Test(enabled = true, description = "Verify seller can view messages from potential buyers in his message list")
  public void  testSellerViewMessageInMessageListSuccess() throws Exception{

    // ==== CONFIGURATION ====
    String mediaTitle = "Banana Gun";
    String messageContent = "Test Msg from Buyer on " + GeneralUtils.currentTimeStamp();

    UiActions.openUrl(USER_LOGIN_URL);
    UiActions.loggingInAs(BUYER_USER_NAME,BUYER_USER_PASSWORD );

    UiActions.openingHomePage();
    UiActions.searchWithoutCategory(mediaTitle);

    UiActions.sendMessageToSellerForSearchedItem(messageContent);

    UiActions.loggingOut();


    // ==== ACTION ====
    UiActions.openUrl(USER_LOGIN_URL);
    UiActions.loggingInAs(SELLER_USER_NAME,SELLER_USER_PASSWORD );

    UiActions.openUrl(COMMUNICATION_MANAGER_URL);


    // ==== VERIFICATION ====
    UiVerifications.verifyViewMessageInMessageListSuccessfully(BUYER_USER_NAME, SELLER_USER_NAME, mediaTitle );

  }
}
