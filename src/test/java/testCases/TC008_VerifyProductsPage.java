package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import TestBase.BaseClass;

public class TC008_VerifyProductsPage extends BaseClass {

	@Test
	public void verifyProductsPage() {
		HomePage hp = new HomePage(driver);
		hp.clickProducts();
		ProductsPage productsPage = new ProductsPage(driver);
		Assert.assertTrue(productsPage.checkPageLoad());
		productsPage.searchProduct("T-shirt");
		productsPage.clickSearch();

		for (String name : productsPage.productList()) {
			System.out.println("Name"+name);
		}

	}

}
