package pageobject.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageobject.pages.*;


public class BaseTest {
    private WebDriver driver;
    private static String AVIC_URL="https://avic.ua/";

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }


    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AVIC_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }
    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public IphonePage getIphonePage(){
        return new IphonePage(driver);
    }

    public SearchResultPage getSearchResultPage(){
        return new SearchResultPage(driver);
    }

    public AppleStorePage getAppleStorePage(){
        return new AppleStorePage(driver);
    }
    public BasePage getBasePage(){
        return new BasePage(driver);
    }
}
