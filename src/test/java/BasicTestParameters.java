import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BasicTestParameters {

    String login = "test user";
    String password = "test user";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://amt2.estafeta.org";
        Configuration.screenshots = false;
    }

    @BeforeMethod
    public void openGmail(){

        new LoginPage()
                .openLoginPage();
    }
}
