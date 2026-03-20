package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {

		super(driver);

	}

	@FindBy(xpath = "//*[@class='title text-center']")
	WebElement txt_AllProducts;
	@FindBy(id = "search_product")
	WebElement input_searchProduct;
	@FindBy(id = "submit_search")
	WebElement btn_Search;
	@FindBy(xpath = "//div[@class=\"col-sm-4\"]//*[@class=\"overlay-content\"]/p")
	List<WebElement> product_Name;

	public boolean checkPageLoad() {
		return txt_AllProducts.isDisplayed();
	}

	public void searchProduct(String product_name) {
		input_searchProduct.sendKeys(product_name);

	}

	public void clickSearch() {
		btn_Search.click();

	}

	public List<String> productList() {
		List<String> names = new ArrayList<>();
		for (WebElement product : product_Name) {
			names.add(product.getText());
		}
		return names;

	}

}
