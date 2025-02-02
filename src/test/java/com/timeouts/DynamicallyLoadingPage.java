package com.timeouts;

import net.serenitybdd.core.pages.PageObject;

public class DynamicallyLoadingPage extends PageObject {

    public void start(){
        $("#start button").click();
    }
    public String result(){
        return $("#finish").getText();
    }
}
