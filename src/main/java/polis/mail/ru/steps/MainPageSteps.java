package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;
import polis.mail.ru.page.MainPage;

public class MainPageSteps extends AbstractSteps{

    private MainPage page;



    public MainPageSteps(Atlas atlas, WebDriver driver) {
        this.driver = driver;
        this.atlas = atlas;
        this.page = atlas.create(driver, MainPage.class);
    }

    @Step("Navigate to")
    public MainPageSteps navigateTo(String text) {
        page.navigateButton(text);
        return this;
    }
}
