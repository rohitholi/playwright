import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class AsimplePlaywrightTest {
    private static Playwright playwright;
    private static Page page;
    private static Browser browser;
    private static BrowserContext context;

    @BeforeEach
    void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = browser.newPage();
        page.navigate("https://practicesoftwaretesting.com");
        playwright.selectors().setTestIdAttribute("data-test");


    }

    @Test
    void shouldShowPageTitle() {
        String title = page.title();
        System.out.println("Page title is: " + title);
        Assertions.assertEquals("Practice Software Testing - Toolshop - v5.0", title, "Page title match expected value.");
    }

    @Test
    void search() {
        page.locator("[placeholder='Search']").fill("Pliers");
        page.getByTestId("search-submit").click();
        int numberOfCards = page.locator(".card").count();
        System.out.println("Number of cards found: " + numberOfCards);
    }

    @AfterEach
    void tearDown()
    {
     playwright.close();
    }

}
