package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppleStorePage extends BasePage {
    private By iphoneButton= By.xpath("//div[@class='brand-box__title']/a[contains(@href,'iphone')]");

    public AppleStorePage(WebDriver driver) {
        super(driver);
    }

    public void clickIphoneButton(){
        driver.findElement(iphoneButton).click();
    }
}
