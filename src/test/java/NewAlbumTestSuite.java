import Utils.RandomGenerator;
import Utils.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class NewAlbumTestSuite extends TestBase {

    @Test
    public void createNewAlbumTest() throws InterruptedException {
        String randomEmail = RandomGenerator.generateRandom(5);

        HomePage homePage = new HomePage();
        homePage.goToNewAlbumPage();
        homePage.waitForPageToLoad();

        ExtraOptionsPopUpPage extraOptionsPopUpPage = new ExtraOptionsPopUpPage();
        extraOptionsPopUpPage.switchToPopupWindow();

        NewAlbumPage newAlbumPage = extraOptionsPopUpPage.cancelExtraOptions();
        newAlbumPage.switchToMainWindow();
        newAlbumPage.saveNewAlbum();

        LoginPopUpPage loginPopUpPage = new LoginPopUpPage();
        loginPopUpPage.switchToLoginiFrame();
        RegisterNewUserPage registerNewUserPage = loginPopUpPage.tapRegisterNewCustomer();

        SavePopUpPage savePopUpPage = registerNewUserPage.enterAndConfirmCustomerDetails(randomEmail + "@test.com", "test12345");
        savePopUpPage.switchToMainWindow();
        savePopUpPage.enterNameAndConfirm("myPhotoBook");

        $(".notification-body").shouldHave(text("Project saved!"));
    }
}
