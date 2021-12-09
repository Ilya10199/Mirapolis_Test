package com.mirapolis.autotest.testcases;

import com.mirapolis.autotest.pages.AuthPage;
import com.mirapolis.autotest.pages.MirapolisPage;
import com.mirapolis.autotest.pages.PassRecoveryPage;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.mirapolis.autotest.constants.Constants.LogAndPass.LOGIN;
import static com.mirapolis.autotest.constants.Constants.LogAndPass.PASSWORD;
import static com.mirapolis.autotest.constants.Constants.NegativeLogAndPass.UNSUCCESSFUL_LOGIN;
import static com.mirapolis.autotest.constants.Constants.NegativeLogAndPass.UNSUCCESSFUL_PASSWORD;
import static com.mirapolis.autotest.constants.Constants.Url.MIRAPOLIS_URL;

public class AuthTests extends BaseTests {

    @Test
    public void signIn(){
        AuthPage authPage = new AuthPage();
        MirapolisPage mirapolisPage = new MirapolisPage();
        open(MIRAPOLIS_URL);
        authPage.signIn(LOGIN,PASSWORD);
        mirapolisPage.checkPageIsOpen();
    }

    @Test
    public void passwordRecovery(){
        PassRecoveryPage passRecoveryPage = new PassRecoveryPage();
        open(MIRAPOLIS_URL);
        passRecoveryPage.passwordRecovery(LOGIN);
        passRecoveryPage.checkThatMessageIsPosted();
    }

    @Test
    public void unsuccessfulSignIn(){
        AuthPage authPage = new AuthPage();
        open(MIRAPOLIS_URL);
        authPage.signIn(UNSUCCESSFUL_LOGIN, UNSUCCESSFUL_PASSWORD);
        authPage.checkAlertIsVisible();
    }

    @Test
    public void unsuccessfulPasswordRecovery(){
        PassRecoveryPage passRecoveryPage = new PassRecoveryPage();
        open(MIRAPOLIS_URL);
        passRecoveryPage.passwordRecovery(UNSUCCESSFUL_LOGIN);
        passRecoveryPage.checkAlertIsVisible();
    }
}
