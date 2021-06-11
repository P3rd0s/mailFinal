package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;
import polis.mail.ru.page.MainPage;

import static java.lang.String.format;

public class NavigationSteps {

    private final static String BASE_URL = "https://ok.ru/";

    private Atlas atlas;
    private WebDriver driver;


    public NavigationSteps(Atlas atlas, WebDriver driver) {
        this.atlas = atlas;
        this.driver = driver;
    }

    @Step("Open login page")
    public LoginSteps openLoginPage() {
        driver.get(BASE_URL);
        return new LoginSteps(atlas, driver);
    }

    @Step("Open groups page")
    public GroupsSteps openGroupsPage() {

        MainPage page;

        page = atlas.create(driver, MainPage.class);
        page.navigateButton(page.GROUPS).click();
        return new GroupsSteps(atlas, driver);
    }

    @Step("Go home")
    public NavigationSteps goHome() {
        driver.get("https://ok.ru/");
        return this;
    }

    @Step("Open group page settings")
    public GroupSteps openGroupPageSettings(String url) {
        driver.get(url + "/settings");
        return new GroupSteps(atlas, driver);
    }

    @Step("Open group page")
    public GroupSteps openGroupPage(String url) {
        driver.get(url);
        return new GroupSteps(atlas, driver);
    }

}
