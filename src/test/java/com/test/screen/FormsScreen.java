package com.test.screen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class FormsScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    @iOSFindBy(accessibility = "???")
    private RemoteWebElement botaoLogin;

    public void clicarBotaoLogin() {
        botaoLogin.isDisplayed();
        botaoLogin.click();
    }
}
