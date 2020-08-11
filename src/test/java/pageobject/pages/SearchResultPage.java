package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class SearchResultPage extends BasePage {
    private By productList= By.xpath("//div[@class='prod-cart__descr']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProductElement(){
        return driver.findElements(productList);
    }



}
