package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IphonePage  extends BasePage{
    private By addToCartButton= By.xpath("//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'Black (MWLT2)')]");
    private By continueButton =By.xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]");
    private By addCartPopup= By.id("js_cart");

    public IphonePage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart(){
        driver.findElement(addToCartButton).click();
    }
    public void clickContinueShoppingButton(){
        driver.findElement(continueButton).click();
    }
    public By getAddCartPopup(){
        return  addCartPopup;
    }

}
