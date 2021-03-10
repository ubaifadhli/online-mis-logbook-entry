import org.openqa.selenium.WebDriver;

public class OnlineMISPage extends PageObject {

    public OnlineMISPage(WebDriver driver) {
        super(driver);
    }

    public void fillLoginCredential(String email, String password) {
        typeInput(OnlineMISLocator.LOGIN_EMAIL_INPUT, email);
        typeInput(OnlineMISLocator.LOGIN_PASSWORD_INPUT, password);

        clickButton(OnlineMISLocator.LOGIN_SUBMIT_BUTTON);
    }

    public void goToLogbookPage() {
        clickButton(OnlineMISLocator.HOMEPAGE_PERSONAL_TAB);
        clickButton(OnlineMISLocator.HOMEPAGE_LOGBOOK_ENTRY_DROPDOWN);
    }

    public void fillLogbookDetail(String startingHour, String endingHour, String activityDetail) {
        typeInput(OnlineMISLocator.LOGBOOK_STARTING_HOUR_INPUT, startingHour);
        typeInput(OnlineMISLocator.LOGBOOK_ENDING_HOUR_INPUT, endingHour);
        typeInput(OnlineMISLocator.LOGBOOK_ACTIVITY_TEXTAREA, activityDetail);

        fillHasRelatedCourseInput(false);

        clickButton(OnlineMISLocator.LOGBOOK_AGREEMENT_CHECKBOX);
        clickButton(OnlineMISLocator.LOGBOOK_SAVE_BUTTON);

        acceptAlert();
    }

    public void fillHasRelatedCourseInput(boolean hasRelatedCourse) {
        int index = hasRelatedCourse ? 0 : 1;
        clickElementAt(OnlineMISLocator.LOGBOOK_HAS_RELATED_COURSE, index);
    }

    public void uploadLogbookPhoto(String photoPath) {
        typeInput(OnlineMISLocator.LOGBOOK_UPLOAD_PHOTO, photoPath);
        clickButton(OnlineMISLocator.LOGBOOK_UPLOAD_PHOTO_BUTTON);

        acceptAlert();
    }

    public void logoutAccount() {
        clickButton(OnlineMISLocator.HOMEPAGE_LOGOUT_BUTTON);
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
