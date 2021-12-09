package com.mirapolis.autotest.pages;

import org.junit.jupiter.api.Assertions;
import static com.codeborne.selenide.Selenide.$;

public class PassRecoveryPage {

    private static final String ALERT_TEXT = "Пользователь с таким именем не найден.";
    private static final String SUCCESS_TEXT = "На ваш электронный адрес отправлена инструкция по восстановлению пароля.";

    public void passwordRecovery(String unsuccessfulLog){
        $(".mira-default-login-page-link").click();
        $("[name='loginOrEmail']").sendKeys(unsuccessfulLog);
        $(".mira-page-forgot-password-button").click();
    }

    public void checkAlertIsVisible(){
        String actualMessage = $(".alert").getText().trim();
        Assertions.assertEquals(actualMessage, ALERT_TEXT);
    }

    public void checkThatMessageIsPosted(){
        String actualMessage = $(".success").getText().trim();
        Assertions.assertEquals(actualMessage, SUCCESS_TEXT);
    }
}
