import static com.codeborne.selenide.Selenide.$;

public class NewAlbumPage extends WebPageBase {

    public void saveNewAlbum() {
        $("#saveProduct").click();
    }
}