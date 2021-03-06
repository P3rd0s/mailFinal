package polis.mail.ru.page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import io.qameta.atlas.webdriver.extension.Selector;

public interface GroupPage extends WebPage {



    @FindBy(".//div[@data-id='{{ vis_option }}']")
    AtlasWebElement visibilitySettingsMenu(@Param("vis_option") String vis_option);

    @FindBy(value = "div[data-id='{{ category }}']", selector = Selector.CSS)
    AtlasWebElement visibilityOptionsList(@Param("category") String category);

    @FindBy(value = "input[name='button_save_settings']", selector = Selector.CSS)
    AtlasWebElement submitButton();

    @FindBy(".//li[@class='u-menu_li expand-action-item']")
    AtlasWebElement groupExpandActionButton();

    @FindBy(".//a[contains(@hrefattrs, 'ButtonsRemoveAltGroup')]")
    AtlasWebElement deleteGroupButton();

    @FindBy(".//input[@data-l='t,confirm']")
    AtlasWebElement confirmButton();
}
