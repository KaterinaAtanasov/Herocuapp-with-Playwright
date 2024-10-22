package tests.herokuapp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.herokuapp.HomePage;
import static org.testng.Assert.assertEquals;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        homePage = new HomePage(page);
    }

    @Test
    public void testHomePageTitle() {
        homePage.navigate();
        assertEquals(homePage.getTitle(), "The Internet", "The title does not match the expected text");
    }

    @Test
    public void testHomePageTexts() {
        homePage.navigate();
        assertEquals(homePage.getInnerText("h1"), "Welcome to the-internet", "Heading does not" +
                " match the expected text");
        assertEquals(homePage.getInnerText("h2"), "Available Examples", "Heading does not match" +
                " the expected text");
    }

    @AfterMethod
    public void tearDown(){
        super.tearDown();
    }
}
