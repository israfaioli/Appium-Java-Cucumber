package com.test.screen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class SplashScreen extends BaseScreen {

    @AndroidFindBy(id = "mi_button_cta")
    @iOSFindBy(accessibility = "???")
    private RemoteWebElement botaoComecar;

    public void clicarBotaoComecar() {
        botaoComecar.isDisplayed();
        botaoComecar.click();
    }
}
