package pageobject.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.assertEquals;

public class AddToCartTest extends BaseTest {

    private final static String EXPECTED_AMOUNT_OF_PRODUCTS= "1";




    @Test(priority = 4)
    public void checkAddToCart() {

        getHomePage().clickCatalogueButton();
        getHomePage().clickAppleStoreButton();
        getAppleStorePage().clickIphoneButton();
        getBasePage().waitForPageReadyState(30);
        getIphonePage().clickAddToCart();
        getBasePage().waitForElementVisibility(30,getIphonePage().getAddCartPopup());
        getIphonePage().clickContinueShoppingButton();
        assertEquals(getHomePage().getAmountOfProductCart(),EXPECTED_AMOUNT_OF_PRODUCTS);

    }

    @Test(priority = 5)
    public void checkRightSite() {
        String title = getDriver().getTitle();
        Assert.assertTrue(title.equals("AVIC™ - удобный интернет-магазин бытовой техники и электроники в Украине. | Avic"));
    }

    @Test(priority = 6)
    public void checkAddToCartAnotherElement() {
        WebElement searchInput = getDriver().findElement(xpath("//input[@id='input_search']"));
        searchInput.sendKeys("iPhone 11", ENTER);
        new WebDriverWait(getDriver(), 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        getDriver().findElement(xpath("//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'White (MWLF2)')]")).click();

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_cart")));
        getDriver().findElement(xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")).click();
    }


}