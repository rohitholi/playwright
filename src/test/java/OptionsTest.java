import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;

public class OptionsTest implements OptionsFactory
{
    @Override
    public Options getOptions() {
        return new Options()
                .setHeadless(false);

    }
}
