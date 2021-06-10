package polis.mail.ru.page;


import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import io.qameta.atlas.webdriver.extension.Selector;
import polis.mail.ru.element.ModerateGroupCard;

public interface GroupsPage extends WebPage {







    @FindBy(".//div[@class='create-group']/a")
    AtlasWebElement createGroupButton();

    @FindBy(".//a[@data-l='{{ type }}']")
    AtlasWebElement groupMaintypesList(@Param("type") String type);

    @FindBy(".//input[@id='field_name']")
    AtlasWebElement groupNameField();

    @FindBy(".//label[@for='field_visibility_{{ vis_option }}']")
    AtlasWebElement closedVisibilityOption(@Param("vis_option") String vis_option);

    @FindBy(".//div[@data-module='GroupCategorySelect']/div[contains(@class,'multi-select_trigger')]")
    AtlasWebElement themeField();

    @FindBy(value = "div[data-id='Category_{{ category }}']", selector = Selector.CSS)
    AtlasWebElement themesList(@Param("category") String category);

    @FindBy(".//input[@data-l='t,confirm']")
    AtlasWebElement confirmCreationButton();


    @FindBy(".//a[contains(@hrefattrs,'MODERATED_BY_USER')]")
    AtlasWebElement moderateGroupsButton();

    @FindBy(".//h1[@class='group-name_h']")
    AtlasWebElement groupName();


    @FindBy(".//div[@class='ugrid_i']")
    ElementsCollection<ModerateGroupCard> moderatedGroupsCards();


}
