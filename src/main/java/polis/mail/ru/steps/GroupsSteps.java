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
        page.createGroup().click();
        return this;
    }

    @Step("Fill data")
    public GroupsSteps fillData() {

        page.chooseType(page.TYPE_INTEREST).click();
        page.enterGroupName().sendKeys(page.GROUP_NAME);

        page.chooseTheme().click();
        page.selectConcreteTheme(page.THEME_AUTO).click();

        page.chooseVisibility().click();

        page.confirmCreation().click();

        page.pageLoaded().waitUntil(displayed());
        return this;
    }

    @Step("Select moderaetd")
    public GroupsSteps selectModerated() {
        page.selectModerateGroups().click();
        page.selectModerateGroups().waitUntil(displayed());
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
    public GroupsSteps selectFirstGroup() {

        page.moderatedGroupsCards().get(0).groupName().click();
        page.pageLoaded().waitUntil(displayed());

        return this;
    }
}
