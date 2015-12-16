package com.mvasylchuk.yashatest.v3;

import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static junit.framework.Assert.assertEquals;

/**
 * Created by Max on 08.11.2015.
 */
//Automate:
//        1 visit http://google.com/ncr
//        2 search: “selenium”
//        3 check that 10 results are found
//        4 check the text “Selenium automates browsers” in 1st result
//        5 follow the link in 1st result
//        6 check that selenium official page is loaded
//        Search the world's information, including webpages, images, videos and more. Google has many special features to help you find exactly what you're looking for.

public class GoogleSearchTest {


    @Test
    public void testGoogleSearch(){
        open("http://google.com/ncr");

        search("selenium");
        results.shouldHaveSize(10);
        assertNthLink(1,"Selenium - Web Browser Automation");
        clickNthResult(1);

        assertTextOnPage("Browser Automation");
        assertPageTitle("Selenium - Web Browser Automation");

    }

    public void search(String text){
        $(By.name("q")).val(text);
    }
    public void clickNthResult(int number){
        results.get(number - 1).find("a").click();
    }

    public void assertNthLink(int number, String text){
        results.get(number - 1).shouldHave(text(text));
    }
    public void assertTextOnPage(String text){
        $(".homepage").shouldHave(text(text));
    }
    public void assertPageTitle(String title){
        assertEquals(title, title());
    }

    ElementsCollection results = $$(".srg>.g .r");

}
