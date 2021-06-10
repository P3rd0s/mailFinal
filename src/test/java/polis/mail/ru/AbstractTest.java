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

public abstract class AbstractTest {

    NavigationSteps navigationSteps;
    protected WebDriver driver;

    final static String USERNAME = "";
    final static String PASSWORD = "";

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
