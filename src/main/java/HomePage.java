import com.codeborne.selenide.Selenide;

public class HomePage extends WebPageBase {

    public void goToNewAlbumPage() {
        Selenide.open("https://editor.bonusprint.co.uk/html5/?articleType=PhotoBook&papId=PAP_354#/editor");
    }
}
