package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;
import polis.mail.ru.page.GroupPage;

public class GroupSteps extends AbstractSteps{

    private GroupPage page;


    public GroupSteps(Atlas atlas, WebDriver driver) {
        this.atlas = atlas;
        this.driver = driver;
        page = atlas.create(driver, GroupPage.class);
    }

    @Step("Select Visibility")
    public GroupSteps selectVisibility(){
        page.visibilitySettings().click();
        return this;
    }

    @Step("Change Visibility")
    public GroupSteps changeVisibilityToOpen(){
        page.changeVisibility(page.VIS_OPEN).click();
        return this;
    }

    @Step("Submit changes")
    public GroupSteps submitChanges() {
        page.submitButton().click();
        return this;
    }
}
