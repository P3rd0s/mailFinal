package polis.mail.ru.page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface MainPage extends WebPage {

    public final static String GROUPS = "t,userAltGroup";

    @FindBy(".//a[@data-l='{{ text }}']")
    AtlasWebElement navigateButton(@Param("text") String text);
}
