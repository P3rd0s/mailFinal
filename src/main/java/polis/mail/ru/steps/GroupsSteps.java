package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.openqa.selenium.WebDriver;
import polis.mail.ru.page.GroupsPage;
import polis.mail.ru.element.ModerateGroupCard;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class GroupsSteps extends AbstractSteps {

    private GroupsPage page;

    public GroupsSteps(Atlas atlas, WebDriver driver) {
        this.atlas = atlas;
        this.driver = driver;
        page = atlas.create(driver, GroupsPage.class);
    }


    @Step("Click crete group")
    public GroupsSteps clickCreateGroup() {
        page.createGroupButton().click();
        return this;
    }


    @Step("Choose group type")
    public GroupsSteps chooseGroupType(String type) {
        page.groupMaintypesList(type).click();
        return this;
    }

    @Step("Enter group name")
    public GroupsSteps enterGroupName(String groupName) {
        page.groupNameField().sendKeys(groupName);
        return this;
    }

    @Step("Select group theme")
    public GroupsSteps selectTheme(String theme) {
        page.themeField().click();
        page.themesList(theme).click();
        return this;
    }

    @Step("Select group visibility")
    public GroupsSteps selectVisibility(String option) {
        page.closedVisibilityOption(option).click();
        return this;
    }

    @Step("Confirm group creation")
    public GroupsSteps confirmCreation(){
        page.confirmCreationButton().click();
        page.groupName().waitUntil(displayed());
        return this;
    }

//    @Step("Fill data")
//    public GroupsSteps fillData() {
//
//        page.groupMaintypesList(page.TYPE_INTEREST).click();
//        page.groupNameField().sendKeys(page.GROUP_NAME);
//
//        page.themeField().click();
//        page.themesList(page.THEME_AUTO).click();
//
//        page.closedVisibilityOption().click();
//
//        page.confirmCreationButton().click();
//
//        page.groupName().waitUntil(displayed());
//        return this;
//    }

    @Step("Select moderaetd")
    public GroupsSteps selectModerated() {
        page.moderateGroupsButton().click();
        page.moderateGroupsButton().waitUntil(displayed());
        return this;
    }


    @Step("Check group created")
    public GroupsSteps checkGroupCreated(String groupURL) {

        ElementsCollection<ModerateGroupCard> cards = page.moderatedGroupsCards();
        ArrayList<String> hrefs = new ArrayList<String>(cards.size());
        for(int i = 0; i < cards.size(); i++)
            hrefs.add(cards.get(i).groupName().getAttribute("href"));


        assertThat(hrefs, hasItem(groupURL));

//        page.moderatedGroupsCards()
//                .extract(card->card.groupName().getAttribute("href"))
//                .should(contains(groupURL));


        //assertThat(page.moderatedGroupsCards(), hasSize(greaterThanOrEqualTo(1)));
        return this;
    }

    @Step("Select first group")
    public GroupsSteps selectGroup(int num) {

        if (num < 0)
            return this;

        page.moderatedGroupsCards().get(num).groupName().click();
        page.groupName().waitUntil(displayed());

        return this;
    }
}
