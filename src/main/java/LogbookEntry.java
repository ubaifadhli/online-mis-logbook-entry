import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URISyntaxException;

public class LogbookEntry {

    public static void main(String[] args) {
        ApplicationProperties properties = new ApplicationProperties();

        String onlineMISLoginUrl = "onlinemis.website.login";
        String loginEmail = "onlinemis.login.email";
        String loginPassword = "onlinemis.login.password";
        String startingHour = "onlinemis.logbook.startinghour";
        String endingHour = "onlinemis.logbook.endinghour";
        String activityDetail = "onlinemis.logbook.activitydetail";
        String photoPath = "onlinemis.logbook.photoname";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        OnlineMISPage page = new OnlineMISPage(driver);

        page.openPageAt(properties.getProperty(onlineMISLoginUrl));

        page.fillLoginCredential(
                properties.getProperty(loginEmail),
                properties.getProperty(loginPassword));

        page.goToLogbookPage();

        page.fillLogbookDetail(
                properties.getProperty(startingHour),
                properties.getProperty(endingHour),
                properties.getProperty(activityDetail)
        );

        page.waitForSeconds(2);

        try {
            page.uploadLogbookPhoto(properties.getFilePath(photoPath));
        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }

        page.waitForSeconds(2);
        page.acceptAlert();

        page.logoutAccount();
        page.waitForSeconds(2);

        driver.quit();
    }

}
