package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import polis.mail.ru.page.GroupPage;

public class GroupSteps extends AbstractSteps{

    private GroupPage page;


    public GroupSteps(Atlas atlas, WebDriver driver) {
        this.atlas = atlas;
        this.driver = driver;
        page = atlas.create(driver, GroupPage.class);
    }

    @Step("Select Visibility")
    public GroupSteps selectVisibility(String cur_option){
        page.visibilitySettingsMenu(cur_option).click();
        return this;
    }

    @Step("Change Visibility")
    public GroupSteps changeVisibilityToOpen(String new_option){
        page.visibilityOptionsList(new_option).click();
        return this;
    }

    @Step("Submit changes")
    public GroupSteps submitChanges() {
        page.submitButton().click();
        return this;
    }

    @Step("Click expand actions")
    public GroupSteps clickMoreButton() {
        page.groupExpandActionButton().click();
        return this;
    }

    @Step("Delete group")
    public GroupSteps deleteGroup() {
        Actions actions = new Actions(driver);
        actions.moveToElement(page.deleteGroupButton().getWrappedElement()).perform();
        page.deleteGroupButton().click();
        page.confirmButton().click();
        return this;
    }

}
