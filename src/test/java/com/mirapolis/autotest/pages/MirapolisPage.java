package com.mirapolis.autotest.pages;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import static com.codeborne.selenide.Selenide.$;

public class MirapolisPage {

    private static final String PROFILE_NAME_TEXT = "Фомина Елена Сергеевна";

    public void checkPageIsOpen(){
        $(".avatar-full-name").shouldBe(Condition.visible);
        String actualProfileNameText = $(".avatar-full-name").getText().trim();
        Assertions.assertEquals(actualProfileNameText, PROFILE_NAME_TEXT );
    }
}
