import org.openqa.selenium.By;

public interface OnlineMISLocator {
    By LOGIN_EMAIL_INPUT = By.xpath("//input[@id='username']");
    By LOGIN_PASSWORD_INPUT = By.xpath("//input[@id='password']");
    By LOGIN_SUBMIT_BUTTON = By.xpath("//input[@class='btn-submit']");

    By HOMEPAGE_PERSONAL_TAB = By.xpath("//a[text()='Personal']");
    By HOMEPAGE_LOGBOOK_ENTRY_DROPDOWN = By.xpath("//a[text()='Entry Logbook KP']");
    By HOMEPAGE_LOGOUT_BUTTON = By.xpath("//a[@title='logout']");

    By LOGBOOK_STARTING_HOUR_INPUT = By.xpath("//input[@id='jam_mulai']");
    By LOGBOOK_ENDING_HOUR_INPUT = By.xpath("//input[@id='jam_selesai']");
    By LOGBOOK_ACTIVITY_TEXTAREA = By.xpath("//textarea[@id='kegiatan']");
    By LOGBOOK_HAS_RELATED_COURSE = By.xpath("//td[contains(text(), 'mata kuliah')]//input");
    By LOGBOOK_AGREEMENT_CHECKBOX = By.xpath("//input[@id='Setuju']");
    By LOGBOOK_SAVE_BUTTON = By.xpath("//input[@name='Button']");
    By LOGBOOK_UPLOAD_PHOTO = By.xpath("//input[@id='fileupload2']");
    By LOGBOOK_UPLOAD_PHOTO_BUTTON = By.xpath("//input[@name='Submit22']");
}
