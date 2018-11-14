package Utils;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void setBrowser() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
        Configuration.browser = "chrome";
    }
}
