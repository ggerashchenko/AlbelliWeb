import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SavePopUpPage extends WebPageBase {
    public void enterNameAndConfirm(final String myPhotoBookName) {

        $(By.id("input-saveName")).shouldBe(Condition.visible).sendKeys(myPhotoBookName);
        $(By.id("saveProductConfirmationButton")).click();
    }
}
