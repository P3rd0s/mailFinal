package polis.mail.ru;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CreateClosedGroupTest extends AbstractGroupTest {


    String groupURL;

    @Test
    public void checkCreatedClosedGroup() {

        createDefaultClosedGroup();

        groupURL = driver.getCurrentUrl();

        navigationSteps
                .goHome()
                .openGroupsPage()
                .selectModerated()
                .checkGroupCreated(groupURL);

        assertThat(isClosedGroup(groupURL), is(true));

    }


    @After
    public void cleaning() {
        deleteGroup(groupURL);
    }

}




