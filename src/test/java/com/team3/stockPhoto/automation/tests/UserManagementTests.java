package com.team3.stockPhoto.automation.tests;

import com.team3.stockPhoto.automation.actions.UiActions;
import com.team3.stockPhoto.automation.base.BaseTest;
import com.team3.stockPhoto.automation.utils.GeneralUtils;
import com.team3.stockPhoto.automation.verifications.UiVerifications;
import org.testng.annotations.Test;

/**
 * Created by rafsan on 8/22/2017.
 */
public class UserManagementTests extends BaseTest {
  @Test(enabled = true, description = "Verify new customer can register into the stock photo marketplace")
  public void  testUserRegistrationSuccess() throws Exception{

    // ==== CONFIGURATION ====
    String newCustomerEmail = "customer_" + GeneralUtils.currentTimeStamp() + "@email.com";
    String newCustomerPassword = "12345";

    // ==== ACTION ====
    UiActions.openUrl(USER_REGISTRATION_URL);
    UiActions.fillUpUserRegistrationForm(newCustomerEmail, newCustomerPassword);
    UiActions.submitRegistrationForm();

    // ==== VERIFICATION ====
    UiVerifications.verifyUserRegistrationSuccessful();
  }

  @Test(enabled = true, description = "Verify registered user can login successfully")
  public void  testUserLoginSuccess() throws Exception{

    // ==== CONFIGURATION ====
    String regUserEmail = BUYER_USER_NAME;
    String regUserPassword = BUYER_USER_PASSWORD;

    // ==== ACTION ====
    UiActions.openUrl(USER_LOGIN_URL);
    UiActions.loggingInAs(regUserEmail, regUserPassword);

    // ==== VERIFICATION ====
    UiVerifications.verifyUserLoginSuccessful();
  }

  @Test(enabled = true, description = "Verify user cannot login with NO password")
  public void  testUserLoginWithoutPasswordFail() throws Exception{

    // ==== CONFIGURATION ====
    String correctEmail = BUYER_USER_NAME;
    String noPassword = "";

    // ==== ACTION ====
    UiActions.openUrl(USER_LOGIN_URL);
    UiActions.loggingInAs(correctEmail, noPassword);

    // ==== VERIFICATION ====
    UiVerifications.verifyUserLoginFail();
  }

}
