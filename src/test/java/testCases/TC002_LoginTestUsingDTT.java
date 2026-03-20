package testCases;

import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC002_LoginTestUsingDTT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verify_login(String email, String pwd, String exp) {

        logger.info("*** Starting TC002_LoginTest - Email: " + email + " | Expected: " + exp + " ***");

        try {
            // Skip row if any field is empty/null
            if (email == null || pwd == null || exp == null ||
                email.trim().isEmpty() || pwd.trim().isEmpty() || exp.trim().isEmpty()) {
                logger.warn("Skipping row - missing data: email=" + email + " pwd=" + pwd + " exp=" + exp);
                return; // soft skip - won't fail or block next rows
            }

            // HomePage
            HomePage hp = new HomePage(driver);
            hp.clickSignupLogin();

            // SignUpPage
            SignUpPage sp = new SignUpPage(driver);
            sp.enterloginEmail(email);
            sp.enterloginPass(pwd);
            sp.clickBttnLogin();

            // MyAccountPage
            MyAccountPage hpl = new MyAccountPage(driver);
            boolean targetPage = hpl.isMyAccountExists();

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage==true) {
                    logger.info("Valid login successful for: " + email);
                    hpl.clickLogout();
                    Assert.assertTrue(true, "Valid login passed.");
                } else {
                    logger.error("Valid login FAILED for: " + email);
                    Assert.fail("Expected valid login but MyAccount page not found for: " + email);
                }
            } 
            if (exp.equalsIgnoreCase("Invalid"))  
            {
                if (targetPage==true) {
                    logger.error("Invalid login INCORRECTLY passed for: " + email);
                   hpl.clickLogout();
                    Assert.fail("Expected login to fail but MyAccount page was reached for: " + email);
                } else {
                    logger.info("Invalid login correctly rejected for: " + email);
                    Assert.assertTrue(true, "Invalid login correctly failed.");
                }
            }

        } catch (Exception e) {
            logger.error("Exception during test for email: " + email + " | " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
            // Does NOT rethrow - next data row will still execute
        }

        logger.info("*** Finished TC002_LoginTest - Email: " + email + " ***");
    }
}