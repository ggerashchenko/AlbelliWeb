import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;

public class ExtraOptionsPopUpPage extends WebPageBase {

    public NewAlbumPage cancelExtraOptions() {
        waitWithWebDriver().until(ExpectedConditions.elementToBeClickable($(By.className("cancel"))));
        $(By.className("cancel")).shouldBe(Condition.visible).click();
        return new NewAlbumPage();
    }
}
