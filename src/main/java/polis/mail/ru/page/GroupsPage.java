package polis.mail.ru.page;


import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import io.qameta.atlas.webdriver.extension.Selector;
import polis.mail.ru.element.ModerateGroupCard;

public interface GroupsPage extends WebPage {

    final static String TYPE_INTEREST = "t,INTEREST";
    final static String GROUP_NAME = "Test1";
    final static String VIS_OPEN = "Открытый";
    final static String VIS_SECRET = "Секретный";
    final static String VIS_CLOSED = "Закрытый";
    final static String THEME_AUTO = "CAR_WASH";





    @FindBy(".//div[@class='create-group']/a")
    AtlasWebElement createGroup();

    @FindBy(".//a[@data-l='{{ type }}']")
    AtlasWebElement chooseType(@Param("type") String type);

    @FindBy(".//input[@id='field_name']")
    AtlasWebElement enterGroupName();

    @FindBy(".//label[@for='field_visibility_BY_MEMBER_INVITATION_AND_REQUEST']")
    AtlasWebElement chooseVisibility();

    @FindBy(".//div[@data-module='GroupCategorySelect']/div[contains(@class,'multi-select_trigger')]")
    AtlasWebElement chooseTheme();

    //@FindBy(".//div[@data-value='Автомобили']")
    @FindBy(value = "div[data-id='Category_{{ category }}']", selector = Selector.CSS)
    AtlasWebElement selectConcreteTheme(@Param("category") String category);

    @FindBy(".//input[@data-l='t,confirm']")
    AtlasWebElement confirmCreation();


    @FindBy(".//a[contains(@hrefattrs,'MODERATED_BY_USER')]")
    AtlasWebElement selectModerateGroups();

    @FindBy(".//h1[@class='group-name_h']")
    AtlasWebElement pageLoaded();


    @FindBy(".//div[@class='ugrid_i']")
    ElementsCollection<ModerateGroupCard> moderatedGroupsCards();


}
