import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.Test;

@UsePlaywright(OptionsTest.class)
public class PlaywrightTest3
{
    @Test
    void selectItem(Page page)
    {
        page.navigate("https://practicesoftwaretesting.com");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        page.locator(".card").first().click();
        page.locator("#btn-add-to-cart").click();
        page.getByRole(AriaRole.ALERT, new Page.GetByRoleOptions().setName(" Product added to shopping cart. ")).isVisible();
        page.locator("[aria-label='cart']").click();
        page.waitForLoadState(LoadState.NETWORKIDLE);
        page.locator("button:has-text('Proceed to checkout')").first().click();
        page.waitForLoadState(LoadState.NETWORKIDLE);
      assert page.locator("//h3[text()='Login']").isVisible();

    }
}
