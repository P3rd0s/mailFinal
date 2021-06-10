package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;
import polis.mail.ru.page.LoginPage;

public class LoginSteps extends AbstractSteps{

    private LoginPage page;


    public LoginSteps(Atlas atlas, WebDriver driver) {
        this.driver = driver;
        this.atlas = atlas;
        this.page = atlas.create(driver, LoginPage.class);
    }

    @Step("Fill mail field")
    public LoginSteps fillEmail(String username) {
        page.searchInput("field_email").sendKeys(username);
        return this;
    }

    @Step("Fill password field")
    public LoginSteps fillPassword(String password) {
        page.searchInput("field_password").sendKeys(password);
        return this;
    }

    @Step("Click Log In")
    public LoginSteps clickLogin() {
        page.goLogin().click();
        return this;
    }
}
