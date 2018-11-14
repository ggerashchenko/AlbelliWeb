import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public abstract class WebPageBase {

    private final WebDriver driver = WebDriverRunner.getWebDriver();
    private final String parentWindow = driver.getWindowHandle();

    protected WebDriver getDriver() {
        return driver;
    }

    public void waitForPageToLoad() {
        final long timeToWait = 30;
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeToWait);
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(final WebDriver webDriver) {
                return String
                        .valueOf(((JavascriptExecutor) webDriver).
                                executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

    public void switchToPopupWindow() {
        if (driver == null) {
            throw new RuntimeException("driver cannot be null");
        }

        String popupWindowHandle = "";
        for (String winHandle : getDriver().getWindowHandles()) {
            popupWindowHandle = winHandle;
        }

        if (popupWindowHandle.isEmpty()) {
            throw new RuntimeException("popup is empty");
        }

        getDriver().switchTo().window(popupWindowHandle);
    }

    public void switchToMainWindow() {
        getDriver().switchTo().window(parentWindow);
    }

    public void switchToLoginiFrame() {
        final WebElement iframe = driver.findElement(By.cssSelector(".text-container > iframe"));
        driver.switchTo().frame(iframe);
    }

    public Wait<WebDriver> waitWithWebDriver() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        return wait;
    }

}
