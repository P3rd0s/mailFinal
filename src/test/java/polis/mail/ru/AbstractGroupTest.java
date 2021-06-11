package polis.mail.ru;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import polis.mail.ru.steps.NavigationSteps;

public abstract class AbstractGroupTest {

    NavigationSteps navigationSteps;
    protected WebDriver driver;

    final static String USERNAME = "";
    final static String PASSWORD = "";

    final static String TYPE_INTEREST = "t,INTEREST";
    final static String GROUP_NAME = "Test1";
    final static String VIS_OPEN = "OPEN";
    final static String VIS_SECRET = "BY_MEMBER_INVITATION";
    final static String VIS_CLOSED = "BY_MEMBER_INVITATION_AND_REQUEST";
    final static String THEME_AUTO = "CAR_WASH";

    @Before
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Atlas atlas = new Atlas(new WebDriverConfiguration(driver));
        navigationSteps = new NavigationSteps(atlas, driver);

        navigationSteps
                .openLoginPage()
                .fillEmail(USERNAME)
                .fillPassword(PASSWORD)
                .clickLogin();
    }

    @After
    public void stopDriver() {
        this.driver.quit();
    }

    public void createDefaultClosedGroup() {
        navigationSteps
                .openGroupsPage()
                .clickCreateGroup()
                .chooseGroupType(TYPE_INTEREST)
                .enterGroupName(GROUP_NAME)
                .selectTheme(THEME_AUTO)
                .selectVisibility(VIS_CLOSED)
                .confirmCreation();
    }

    public void deleteGroup(String url) {
        driver.manage().window().maximize();
        navigationSteps
                .openGroupPage(url)
                .clickMoreButton()
                .deleteGroup();
    }

    public boolean isClosedGroup(String URL){
        WebDriver secondDriver = new ChromeDriver();
        secondDriver.get(URL);

        try {
            secondDriver.findElement(By.xpath(".//span[@class='group-name_badge iblock-cloud_show']"));
        }
        catch (NoSuchElementException e){
            return false;
        } finally {
            secondDriver.close();
            secondDriver.quit();
        }
        return true;
    }
}
