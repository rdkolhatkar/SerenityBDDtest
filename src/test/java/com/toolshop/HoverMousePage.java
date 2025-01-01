package com.toolshop;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("http://the-internet.herokuapp.com/hovers")
public class HoverMousePage extends PageObject {
    public static final String VISIBLE_FIGURE = "(//*[@class='figure'])[{0}]";
    public static final String FIGURE_CAPTION = "(//*[@class='figcaption'])[{0}]";
    public void hoverOverFigure(int number) {
        //{0} is used when we are making any value as parameterized & By default {0} will pick the first parameter i.e. parameter at zeroth index.
        WebElementFacade figure = $(VISIBLE_FIGURE,number);

        //Another way to get the location of figure element is as below
        /* $$("(//*[@class='figure'])").get(number -1);*/

        // This code is used with selenium for performing mouse actions but with serenity there is a difference
        /*
        new Actions(getDriver())
                .moveToElement(figure)
                .pause(1000)
                .moveByOffset(100, 100)
                .pause(1000)
                .perform();
         */

        // Serenity code for performing mouse actions
        withAction().moveToElement(figure).perform();
    }

    public WebElementState captionForFigure(int number) {
        return $(FIGURE_CAPTION, number);
    }
}
