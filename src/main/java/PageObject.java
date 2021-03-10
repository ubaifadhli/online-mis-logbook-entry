import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageObject {
    WebDriver driver;
    WebDriverWait wait;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void openPageAt(String url) {
        driver.get(url);
    }

    public WebElement getElementAfterClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> getElementsAfterVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void clickButton(By locator) {
        getElementAfterClickable(locator).click();
    }

    public void clickElementAt(By locator, int index) {
        getElementsAfterVisible(locator).get(index).click();
    }

    public void typeInput(By locator, String input) {
        getElementAfterClickable(locator).sendKeys(input);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
