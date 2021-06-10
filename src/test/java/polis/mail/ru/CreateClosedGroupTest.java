package polis.mail.ru;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateClosedGroupTest extends AbstractTest{


    @Test
    public void createClosedGroup() {

        navigationSteps
                .openGroupsPage()
                .clickCreateGroup()
                .fillData();


        String groupURL = driver.getCurrentUrl();

        navigationSteps
                .goHome()
                .openGroupsPage()
                .selectModerated()
                .checkGroupCreated(groupURL);

        assertThat(isClosedGroup(groupURL), is(true));

        return;
    }



}




