package com.mvasylchuk.yashatest.v0;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.BeforeClass;
import org.junit.Test;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

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

public class GoogleSearch {


    @Test
    public void testGoogleSearchAndSeleniumPage(){
        open("http://google.com/ncr");
        $("#lst-ib").val("selenium").pressEnter();
        ElementsCollection searchResultsList = $$("#rso>.srg>.g");
        searchResultsList.shouldHaveSize(10);
        searchResultsList.get(0).shouldHave(text("Selenium automates browsers."));
        searchResultsList.get(0).find("a").click();
        $("[title='Overview of Selenium']").shouldBe(visible);

    }


}
