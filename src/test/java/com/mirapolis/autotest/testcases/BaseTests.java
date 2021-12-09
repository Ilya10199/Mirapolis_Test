package com.mirapolis.autotest.testcases;

import org.junit.jupiter.api.AfterEach;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTests {

    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }


}
