package com.test.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebElement;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(id = "etEmail")
    @iOSFindBy(accessibility = "??")
    private RemoteWebElement campoEmail;

    @AndroidFindBy(id = "etPassword")
    @iOSFindBy(accessibility = "???")
    private RemoteWebElement campoPassword;

    @AndroidFindBy(id = "btnSubmit")
    @iOSFindBy(accessibility = "???")
    private RemoteWebElement botaoEntrar;

    @AndroidFindBy(id = "content")
    private RemoteWebElement paginaLogin;

    public void logar(String email, String senha) {
        campoEmail.isDisplayed();
        campoEmail.sendKeys(email);
        campoPassword.sendKeys(senha);
        botaoEntrar.click();
    }

    public void validarLogin() {
        Assert.assertTrue(paginaLogin.getText().contains("Show! Suas credenciais são válidas."));
    }

}
