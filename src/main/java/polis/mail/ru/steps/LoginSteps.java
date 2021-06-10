package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;
import polis.mail.ru.page.LoginPage;

public class LoginSteps extends AbstractSteps{

    private LoginPage page;

    final static String USERNAME = "79267612747";
    final static String PASSWORD = "ksdjfnjsdfnksdlf23r423n";

    public LoginSteps(Atlas atlas, WebDriver driver) {
        this.driver = driver;
        this.atlas = atlas;
        this.page = atlas.create(driver, LoginPage.class);
    }

    @Step("Wait login page is loaded")
    public LoginSteps waitPageIsLoaded() {
        return this;
    }

    @Step("Fill mail field")
    public LoginSteps fillEmail() {
        page.searchInput("field_email").sendKeys(USERNAME);
        return this;
    }

    @Step("Fill password field")
    public LoginSteps fillPassword() {
        page.searchInput("field_password").sendKeys(PASSWORD);
        return this;
    }

    @Step("Click Log In")
    public LoginSteps clickLogin() {
        page.goLogin().click();
        return this;
    }
}
