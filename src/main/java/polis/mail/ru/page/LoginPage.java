package polis.mail.ru.page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface LoginPage extends WebPage {

    @FindBy(".//input[@id='{{ text }}']")
    AtlasWebElement searchInput(@Param("text") String text);

    @FindBy("//input[@value='Log in to OK']")
    AtlasWebElement goLogin();

}
