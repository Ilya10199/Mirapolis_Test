package com.mirapolis.autotest.pages;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    private static final String ALERT_TEXT = "Неверные данные для авторизации";

    public void signIn(String log, String pass){
        $("[name='user']").sendKeys(log);
        $("[name='password']").sendKeys(pass);
        $("#button_submit_login_form").click();
    }

    public void checkAlertIsVisible(){
        String actualMessage = WebDriverRunner.driver().switchTo().alert().getText().trim();
        Assertions.assertEquals(actualMessage, ALERT_TEXT);
    }
}
