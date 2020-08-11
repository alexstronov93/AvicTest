package pageobject.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    private static final String SEARCH_RESULT="query=iPhone";
    private static final String SEARCH_KEYWORD="iPhone 11";
    private static final int EXPECTED_PRODUCT_AMOUNT=12;


    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD);
        assertTrue(getDriver().getCurrentUrl().contains(SEARCH_RESULT));//проверяем что урла содержит кверю
    }

    @Test(priority = 2)
    public void checkElementsAmountOnSearchPage() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD);
        getBasePage().implicityWait(30);

        int actualElementsSize = getSearchResultPage().getProductElement().size();
        assertEquals(actualElementsSize, EXPECTED_PRODUCT_AMOUNT);
    }

    @Test(priority = 3)
    public void checkThatSearchResultsContainsSearchWord() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD);
        for (WebElement webElement : getSearchResultPage().getProductElement()) {
            assertTrue(webElement.getText().contains(SEARCH_KEYWORD));
        }
    }
}
