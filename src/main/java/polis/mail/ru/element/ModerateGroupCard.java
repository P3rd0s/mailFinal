package polis.mail.ru.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ModerateGroupCard extends AtlasWebElement<ModerateGroupCard> {

    @FindBy(".//div[@class='section']/a[@data-l='t,visit']")
    public AtlasWebElement groupName();
}
