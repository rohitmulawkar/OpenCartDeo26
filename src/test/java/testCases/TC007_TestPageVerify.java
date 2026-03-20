package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.TestCasesPage;
import pageObjects.HomePage;
public class TC007_TestPageVerify extends BaseClass {
	@Test(groups= {"Sanity"})
	public void verifyTestPage () {
		HomePage hp = new HomePage(driver);
		hp.clicktestCasePage();
		TestCasesPage tcp = new TestCasesPage(driver);
		Assert.assertTrue(tcp.isTestPageOpen());
			
	}

}
