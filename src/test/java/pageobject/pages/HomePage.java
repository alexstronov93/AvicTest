package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    private By catalogueProductButton = By.xpath("//span[@class='sidebar-item']");
    private By appleStoreButton=By.xpath("//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]");
    private By amountOfProductCart=By.xpath("//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyWord(String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickCatalogueButton() {
        driver.findElement(catalogueProductButton).click();
    }
    public void clickAppleStoreButton() {
        driver.findElement(appleStoreButton).click();

    }

    public String getAmountOfProductCart(){
        return driver.findElement(amountOfProductCart).getText();
    }


}

