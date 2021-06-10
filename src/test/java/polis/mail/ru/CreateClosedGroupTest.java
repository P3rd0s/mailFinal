package polis.mail.ru;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateClosedGroupTest extends AbstractTest{

    final static String TYPE_INTEREST = "t,INTEREST";
    final static String GROUP_NAME = "Test1";
    final static String VIS_OPEN = "OPEN";
    final static String VIS_SECRET = "BY_MEMBER_INVITATION";
    final static String VIS_CLOSED = "BY_MEMBER_INVITATION_AND_REQUEST";
    final static String THEME_AUTO = "CAR_WASH";


    @Test
    public void createClosedGroup() {

        navigationSteps
                .openGroupsPage()
                .clickCreateGroup()
                .chooseGroupType(TYPE_INTEREST)
                .enterGroupName(GROUP_NAME)
                .selectTheme(THEME_AUTO)
                .selectVisibility(VIS_CLOSED)
                .confirmCreation();


        String groupURL = driver.getCurrentUrl();

        navigationSteps
                .goHome()
                .openGroupsPage()
                .selectModerated()
                .checkGroupCreated(groupURL);

        assertThat(isClosedGroup(groupURL), is(true));

    }



}




