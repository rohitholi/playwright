import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AsimplePlaywrightTest
{
    @Test
    void shouldShowPageTitle()
    {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practicesoftwaretesting.com");
        String title = page.title();
        System.out.println("Page title is: " + title);
        playwright.close();
        Assertions.assertEquals("Practice Software Testing - Toolshop - v5.0", title, "Page title match expected value.");
    }
}
