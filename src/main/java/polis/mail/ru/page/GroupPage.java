package polis.mail.ru.page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import io.qameta.atlas.webdriver.extension.Selector;

public interface GroupPage extends WebPage {

    final static String VIS_OPEN = "OPEN";


    @FindBy(".//div[@data-id='BY_MEMBER_INVITATION_AND_REQUEST']")
    AtlasWebElement visibilitySettings();

    @FindBy(value = "div[data-id='{{ category }}']", selector = Selector.CSS)
    AtlasWebElement changeVisibility(@Param("category") String category);

//    @FindBy(".//input[@value='Сохранить']")
    @FindBy(value = "input[name='button_save_settings']", selector = Selector.CSS)
    AtlasWebElement submitButton();
}
