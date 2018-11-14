import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegisterNewUserPage extends WebPageBase {

    public SavePopUpPage enterAndConfirmCustomerDetails(final String email, final String password) {
        $(By.id("Email")).sendKeys(email);
        $(By.id("Password")).sendKeys(password);
        $(By.id("ConfirmPassword")).sendKeys(password);
        $(By.id("registerButton")).click();

        return new SavePopUpPage();
    }
}
