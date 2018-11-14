import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPopUpPage extends WebPageBase {

    public RegisterNewUserPage tapRegisterNewCustomer() throws InterruptedException {
        //TODO: investigation of waits for page to load needs to be done.
        Thread.sleep(3000);

        $(By.id("registerAsNew")).shouldBe(Condition.visible).scrollTo().click();
        return new RegisterNewUserPage();

    }
}
